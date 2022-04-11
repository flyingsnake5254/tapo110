package io.netty.handler.codec.http.multipart;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufHolder;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.DecoderResultProvider;
import io.netty.handler.codec.http.DefaultFullHttpRequest;
import io.netty.handler.codec.http.DefaultHttpContent;
import io.netty.handler.codec.http.DefaultHttpMessage;
import io.netty.handler.codec.http.EmptyHttpHeaders;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMessage;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpUtil;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.codec.http.LastHttpContent;
import io.netty.handler.stream.ChunkedInput;
import io.netty.util.AsciiString;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map.Entry;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HttpPostRequestEncoder
  implements ChunkedInput<HttpContent>
{
  private static final Map.Entry[] percentEncodings = { new AbstractMap.SimpleImmutableEntry(Pattern.compile("\\*"), "%2A"), new AbstractMap.SimpleImmutableEntry(Pattern.compile("\\+"), "%20"), new AbstractMap.SimpleImmutableEntry(Pattern.compile("~"), "%7E") };
  private final List<InterfaceHttpData> bodyListDatas;
  private final Charset charset;
  private ByteBuf currentBuffer;
  private InterfaceHttpData currentData;
  private FileUpload currentFileUpload;
  private boolean duringMixedMode;
  private final EncoderMode encoderMode;
  private final HttpDataFactory factory;
  private long globalBodySize;
  private long globalProgress;
  private boolean headerFinalized;
  private boolean isChunked;
  private boolean isKey = true;
  private boolean isLastChunk;
  private boolean isLastChunkSent;
  private final boolean isMultipart;
  private ListIterator<InterfaceHttpData> iterator;
  String multipartDataBoundary;
  final List<InterfaceHttpData> multipartHttpDatas;
  String multipartMixedBoundary;
  private final HttpRequest request;
  
  public HttpPostRequestEncoder(HttpRequest paramHttpRequest, boolean paramBoolean)
    throws HttpPostRequestEncoder.ErrorDataEncoderException
  {
    this(new DefaultHttpDataFactory(16384L), paramHttpRequest, paramBoolean, HttpConstants.DEFAULT_CHARSET, EncoderMode.RFC1738);
  }
  
  public HttpPostRequestEncoder(HttpDataFactory paramHttpDataFactory, HttpRequest paramHttpRequest, boolean paramBoolean)
    throws HttpPostRequestEncoder.ErrorDataEncoderException
  {
    this(paramHttpDataFactory, paramHttpRequest, paramBoolean, HttpConstants.DEFAULT_CHARSET, EncoderMode.RFC1738);
  }
  
  public HttpPostRequestEncoder(HttpDataFactory paramHttpDataFactory, HttpRequest paramHttpRequest, boolean paramBoolean, Charset paramCharset, EncoderMode paramEncoderMode)
    throws HttpPostRequestEncoder.ErrorDataEncoderException
  {
    this.request = ((HttpRequest)ObjectUtil.checkNotNull(paramHttpRequest, "request"));
    this.charset = ((Charset)ObjectUtil.checkNotNull(paramCharset, "charset"));
    this.factory = ((HttpDataFactory)ObjectUtil.checkNotNull(paramHttpDataFactory, "factory"));
    if (!HttpMethod.TRACE.equals(paramHttpRequest.method()))
    {
      this.bodyListDatas = new ArrayList();
      this.isLastChunk = false;
      this.isLastChunkSent = false;
      this.isMultipart = paramBoolean;
      this.multipartHttpDatas = new ArrayList();
      this.encoderMode = paramEncoderMode;
      if (paramBoolean) {
        initDataMultipart();
      }
      return;
    }
    throw new ErrorDataEncoderException("Cannot create a Encoder if request is a TRACE");
  }
  
  private int calculateRemainingSize()
  {
    ByteBuf localByteBuf = this.currentBuffer;
    int i = 8096;
    if (localByteBuf != null) {
      i = 8096 - localByteBuf.readableBytes();
    }
    return i;
  }
  
  private String encodeAttribute(String paramString, Charset paramCharset)
    throws HttpPostRequestEncoder.ErrorDataEncoderException
  {
    if (paramString == null) {
      return "";
    }
    try
    {
      paramString = URLEncoder.encode(paramString, paramCharset.name());
      String str1 = paramString;
      if (this.encoderMode == EncoderMode.RFC3986)
      {
        Map.Entry[] arrayOfEntry = percentEncodings;
        int i = arrayOfEntry.length;
        for (int j = 0;; j++)
        {
          str1 = paramString;
          if (j >= i) {
            break;
          }
          str1 = arrayOfEntry[j];
          String str2 = (String)str1.getValue();
          paramString = ((Pattern)str1.getKey()).matcher(paramString).replaceAll(str2);
        }
      }
      return str1;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new ErrorDataEncoderException(paramCharset.name(), paramString);
    }
  }
  
  private HttpContent encodeNextChunkMultipart(int paramInt)
    throws HttpPostRequestEncoder.ErrorDataEncoderException
  {
    Object localObject = this.currentData;
    if (localObject == null) {
      return null;
    }
    if ((localObject instanceof InternalAttribute))
    {
      localObject = ((InternalAttribute)localObject).toByteBuf();
      this.currentData = null;
    }
    try
    {
      ByteBuf localByteBuf = ((HttpData)localObject).getChunk(paramInt);
      localObject = localByteBuf;
      if (localByteBuf.capacity() == 0)
      {
        this.currentData = null;
        return null;
      }
      localByteBuf = this.currentBuffer;
      if (localByteBuf == null) {
        this.currentBuffer = ((ByteBuf)localObject);
      } else {
        this.currentBuffer = Unpooled.wrappedBuffer(new ByteBuf[] { localByteBuf, localObject });
      }
      if (this.currentBuffer.readableBytes() < 8096)
      {
        this.currentData = null;
        return null;
      }
      return new DefaultHttpContent(fillByteBuf());
    }
    catch (IOException localIOException)
    {
      throw new ErrorDataEncoderException(localIOException);
    }
  }
  
  private HttpContent encodeNextChunkUrlEncoded(int paramInt)
    throws HttpPostRequestEncoder.ErrorDataEncoderException
  {
    Object localObject = this.currentData;
    if (localObject == null) {
      return null;
    }
    int i = paramInt;
    ByteBuf localByteBuf1;
    if (this.isKey)
    {
      localObject = Unpooled.wrappedBuffer(((InterfaceHttpData)localObject).getName().getBytes());
      this.isKey = false;
      localByteBuf1 = this.currentBuffer;
      if (localByteBuf1 == null) {
        this.currentBuffer = Unpooled.wrappedBuffer(new ByteBuf[] { localObject, Unpooled.wrappedBuffer("=".getBytes()) });
      } else {
        this.currentBuffer = Unpooled.wrappedBuffer(new ByteBuf[] { localByteBuf1, localObject, Unpooled.wrappedBuffer("=".getBytes()) });
      }
      i = paramInt - (((ByteBuf)localObject).readableBytes() + 1);
      if (this.currentBuffer.readableBytes() >= 8096) {
        return new DefaultHttpContent(fillByteBuf());
      }
    }
    try
    {
      localByteBuf1 = ((HttpData)this.currentData).getChunk(i);
      if (localByteBuf1.readableBytes() < i)
      {
        this.isKey = true;
        if (this.iterator.hasNext())
        {
          localObject = Unpooled.wrappedBuffer("&".getBytes());
          break label201;
        }
      }
      localObject = null;
      label201:
      if (localByteBuf1.capacity() == 0)
      {
        this.currentData = null;
        localByteBuf1 = this.currentBuffer;
        if (localByteBuf1 == null)
        {
          if (localObject == null) {
            return null;
          }
          this.currentBuffer = ((ByteBuf)localObject);
        }
        else if (localObject != null)
        {
          this.currentBuffer = Unpooled.wrappedBuffer(new ByteBuf[] { localByteBuf1, localObject });
        }
        if (this.currentBuffer.readableBytes() >= 8096) {
          return new DefaultHttpContent(fillByteBuf());
        }
        return null;
      }
      ByteBuf localByteBuf2 = this.currentBuffer;
      if (localByteBuf2 == null)
      {
        if (localObject != null) {
          this.currentBuffer = Unpooled.wrappedBuffer(new ByteBuf[] { localByteBuf1, localObject });
        } else {
          this.currentBuffer = localByteBuf1;
        }
      }
      else if (localObject != null) {
        this.currentBuffer = Unpooled.wrappedBuffer(new ByteBuf[] { localByteBuf2, localByteBuf1, localObject });
      } else {
        this.currentBuffer = Unpooled.wrappedBuffer(new ByteBuf[] { localByteBuf2, localByteBuf1 });
      }
      if (this.currentBuffer.readableBytes() < 8096)
      {
        this.currentData = null;
        this.isKey = true;
        return null;
      }
      return new DefaultHttpContent(fillByteBuf());
    }
    catch (IOException localIOException)
    {
      throw new ErrorDataEncoderException(localIOException);
    }
  }
  
  private ByteBuf fillByteBuf()
  {
    if (this.currentBuffer.readableBytes() > 8096) {
      return this.currentBuffer.readRetainedSlice(8096);
    }
    ByteBuf localByteBuf = this.currentBuffer;
    this.currentBuffer = null;
    return localByteBuf;
  }
  
  private static String getNewMultipartDelimiter()
  {
    return Long.toHexString(PlatformDependent.threadLocalRandom().nextLong());
  }
  
  private void initDataMultipart()
  {
    this.multipartDataBoundary = getNewMultipartDelimiter();
  }
  
  private void initMixedMultipart()
  {
    this.multipartMixedBoundary = getNewMultipartDelimiter();
  }
  
  private HttpContent lastChunk()
  {
    this.isLastChunk = true;
    ByteBuf localByteBuf = this.currentBuffer;
    if (localByteBuf == null)
    {
      this.isLastChunkSent = true;
      return LastHttpContent.EMPTY_LAST_CONTENT;
    }
    this.currentBuffer = null;
    return new DefaultHttpContent(localByteBuf);
  }
  
  private HttpContent nextChunk()
    throws HttpPostRequestEncoder.ErrorDataEncoderException
  {
    if (this.isLastChunk)
    {
      this.isLastChunkSent = true;
      return LastHttpContent.EMPTY_LAST_CONTENT;
    }
    int i = calculateRemainingSize();
    if (i <= 0) {
      return new DefaultHttpContent(fillByteBuf());
    }
    int j = i;
    HttpContent localHttpContent;
    if (this.currentData != null)
    {
      if (this.isMultipart) {
        localHttpContent = encodeNextChunkMultipart(i);
      } else {
        localHttpContent = encodeNextChunkUrlEncoded(i);
      }
      if (localHttpContent != null) {
        return localHttpContent;
      }
      j = calculateRemainingSize();
    }
    if (!this.iterator.hasNext()) {
      return lastChunk();
    }
    while ((j > 0) && (this.iterator.hasNext()))
    {
      this.currentData = ((InterfaceHttpData)this.iterator.next());
      if (this.isMultipart) {
        localHttpContent = encodeNextChunkMultipart(j);
      } else {
        localHttpContent = encodeNextChunkUrlEncoded(j);
      }
      if (localHttpContent == null) {
        j = calculateRemainingSize();
      } else {
        return localHttpContent;
      }
    }
    return lastChunk();
  }
  
  public void addBodyAttribute(String paramString1, String paramString2)
    throws HttpPostRequestEncoder.ErrorDataEncoderException
  {
    if (paramString2 == null) {
      paramString2 = "";
    }
    addBodyHttpData(this.factory.createAttribute(this.request, (String)ObjectUtil.checkNotNull(paramString1, "name"), paramString2));
  }
  
  public void addBodyFileUpload(String paramString1, File paramFile, String paramString2, boolean paramBoolean)
    throws HttpPostRequestEncoder.ErrorDataEncoderException
  {
    addBodyFileUpload(paramString1, paramFile.getName(), paramFile, paramString2, paramBoolean);
  }
  
  public void addBodyFileUpload(String paramString1, String paramString2, File paramFile, String paramString3, boolean paramBoolean)
    throws HttpPostRequestEncoder.ErrorDataEncoderException
  {
    ObjectUtil.checkNotNull(paramString1, "name");
    ObjectUtil.checkNotNull(paramFile, "file");
    String str = paramString2;
    if (paramString2 == null) {
      str = "";
    }
    Object localObject = null;
    paramString2 = paramString3;
    if (paramString3 == null) {
      if (paramBoolean) {
        paramString2 = "text/plain";
      } else {
        paramString2 = "application/octet-stream";
      }
    }
    paramString3 = (String)localObject;
    if (!paramBoolean) {
      paramString3 = HttpPostBodyUtil.TransferEncodingMechanism.BINARY.value();
    }
    paramString1 = this.factory.createFileUpload(this.request, paramString1, str, paramString2, paramString3, null, paramFile.length());
    try
    {
      paramString1.setContent(paramFile);
      addBodyHttpData(paramString1);
      return;
    }
    catch (IOException paramString1)
    {
      throw new ErrorDataEncoderException(paramString1);
    }
  }
  
  public void addBodyFileUploads(String paramString, File[] paramArrayOfFile, String[] paramArrayOfString, boolean[] paramArrayOfBoolean)
    throws HttpPostRequestEncoder.ErrorDataEncoderException
  {
    if ((paramArrayOfFile.length != paramArrayOfString.length) && (paramArrayOfFile.length != paramArrayOfBoolean.length)) {
      throw new IllegalArgumentException("Different array length");
    }
    for (int i = 0; i < paramArrayOfFile.length; i++) {
      addBodyFileUpload(paramString, paramArrayOfFile[i], paramArrayOfString[i], paramArrayOfBoolean[i]);
    }
  }
  
  public void addBodyHttpData(InterfaceHttpData paramInterfaceHttpData)
    throws HttpPostRequestEncoder.ErrorDataEncoderException
  {
    if (!this.headerFinalized)
    {
      this.bodyListDatas.add(ObjectUtil.checkNotNull(paramInterfaceHttpData, "data"));
      Object localObject1;
      if (!this.isMultipart)
      {
        if ((paramInterfaceHttpData instanceof Attribute))
        {
          localObject1 = (Attribute)paramInterfaceHttpData;
          try
          {
            paramInterfaceHttpData = encodeAttribute(((InterfaceHttpData)localObject1).getName(), this.charset);
            localObject1 = encodeAttribute(((Attribute)localObject1).getValue(), this.charset);
            paramInterfaceHttpData = this.factory.createAttribute(this.request, paramInterfaceHttpData, (String)localObject1);
            this.multipartHttpDatas.add(paramInterfaceHttpData);
            this.globalBodySize += paramInterfaceHttpData.getName().length() + 1 + paramInterfaceHttpData.length() + 1L;
          }
          catch (IOException paramInterfaceHttpData)
          {
            throw new ErrorDataEncoderException(paramInterfaceHttpData);
          }
        }
        else if ((paramInterfaceHttpData instanceof FileUpload))
        {
          localObject1 = (FileUpload)paramInterfaceHttpData;
          paramInterfaceHttpData = encodeAttribute(((InterfaceHttpData)localObject1).getName(), this.charset);
          localObject1 = encodeAttribute(((FileUpload)localObject1).getFilename(), this.charset);
          paramInterfaceHttpData = this.factory.createAttribute(this.request, paramInterfaceHttpData, (String)localObject1);
          this.multipartHttpDatas.add(paramInterfaceHttpData);
          this.globalBodySize += paramInterfaceHttpData.getName().length() + 1 + paramInterfaceHttpData.length() + 1L;
        }
        return;
      }
      Object localObject2;
      Object localObject3;
      Object localObject4;
      if ((paramInterfaceHttpData instanceof Attribute))
      {
        if (this.duringMixedMode)
        {
          localObject1 = new InternalAttribute(this.charset);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("\r\n--");
          ((StringBuilder)localObject2).append(this.multipartMixedBoundary);
          ((StringBuilder)localObject2).append("--");
          ((InternalAttribute)localObject1).addValue(((StringBuilder)localObject2).toString());
          this.multipartHttpDatas.add(localObject1);
          this.multipartMixedBoundary = null;
          this.currentFileUpload = null;
          this.duringMixedMode = false;
        }
        localObject1 = new InternalAttribute(this.charset);
        if (!this.multipartHttpDatas.isEmpty()) {
          ((InternalAttribute)localObject1).addValue("\r\n");
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("--");
        ((StringBuilder)localObject2).append(this.multipartDataBoundary);
        ((StringBuilder)localObject2).append("\r\n");
        ((InternalAttribute)localObject1).addValue(((StringBuilder)localObject2).toString());
        localObject2 = (Attribute)paramInterfaceHttpData;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(HttpHeaderNames.CONTENT_DISPOSITION);
        ((StringBuilder)localObject3).append(": ");
        ((StringBuilder)localObject3).append(HttpHeaderValues.FORM_DATA);
        ((StringBuilder)localObject3).append("; ");
        ((StringBuilder)localObject3).append(HttpHeaderValues.NAME);
        ((StringBuilder)localObject3).append("=\"");
        ((StringBuilder)localObject3).append(((InterfaceHttpData)localObject2).getName());
        ((StringBuilder)localObject3).append("\"\r\n");
        ((InternalAttribute)localObject1).addValue(((StringBuilder)localObject3).toString());
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(HttpHeaderNames.CONTENT_LENGTH);
        ((StringBuilder)localObject3).append(": ");
        ((StringBuilder)localObject3).append(((HttpData)localObject2).length());
        ((StringBuilder)localObject3).append("\r\n");
        ((InternalAttribute)localObject1).addValue(((StringBuilder)localObject3).toString());
        localObject3 = ((HttpData)localObject2).getCharset();
        if (localObject3 != null)
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(HttpHeaderNames.CONTENT_TYPE);
          ((StringBuilder)localObject4).append(": ");
          ((StringBuilder)localObject4).append("text/plain");
          ((StringBuilder)localObject4).append("; ");
          ((StringBuilder)localObject4).append(HttpHeaderValues.CHARSET);
          ((StringBuilder)localObject4).append('=');
          ((StringBuilder)localObject4).append(((Charset)localObject3).name());
          ((StringBuilder)localObject4).append("\r\n");
          ((InternalAttribute)localObject1).addValue(((StringBuilder)localObject4).toString());
        }
        ((InternalAttribute)localObject1).addValue("\r\n");
        this.multipartHttpDatas.add(localObject1);
        this.multipartHttpDatas.add(paramInterfaceHttpData);
        this.globalBodySize += ((HttpData)localObject2).length() + ((InternalAttribute)localObject1).size();
      }
      else if ((paramInterfaceHttpData instanceof FileUpload))
      {
        localObject2 = (FileUpload)paramInterfaceHttpData;
        localObject1 = new InternalAttribute(this.charset);
        if (!this.multipartHttpDatas.isEmpty()) {
          ((InternalAttribute)localObject1).addValue("\r\n");
        }
        if (this.duringMixedMode)
        {
          localObject3 = this.currentFileUpload;
          if ((localObject3 != null) && (((InterfaceHttpData)localObject3).getName().equals(((InterfaceHttpData)localObject2).getName())))
          {
            i = 1;
            break label1401;
          }
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("--");
          ((StringBuilder)localObject3).append(this.multipartMixedBoundary);
          ((StringBuilder)localObject3).append("--");
          ((InternalAttribute)localObject1).addValue(((StringBuilder)localObject3).toString());
          this.multipartHttpDatas.add(localObject1);
          this.multipartMixedBoundary = null;
          localObject1 = new InternalAttribute(this.charset);
          ((InternalAttribute)localObject1).addValue("\r\n");
          this.currentFileUpload = ((FileUpload)localObject2);
          this.duringMixedMode = false;
        }
        else
        {
          if (this.encoderMode != EncoderMode.HTML5)
          {
            localObject3 = this.currentFileUpload;
            if ((localObject3 != null) && (((InterfaceHttpData)localObject3).getName().equals(((InterfaceHttpData)localObject2).getName())))
            {
              initMixedMultipart();
              localObject3 = this.multipartHttpDatas;
              InternalAttribute localInternalAttribute = (InternalAttribute)((List)localObject3).get(((List)localObject3).size() - 2);
              this.globalBodySize -= localInternalAttribute.size();
              localObject4 = new StringBuilder(this.multipartDataBoundary.length() + 139 + this.multipartMixedBoundary.length() * 2 + ((FileUpload)localObject2).getFilename().length() + ((InterfaceHttpData)localObject2).getName().length());
              ((StringBuilder)localObject4).append("--");
              ((StringBuilder)localObject4).append(this.multipartDataBoundary);
              ((StringBuilder)localObject4).append("\r\n");
              localObject3 = HttpHeaderNames.CONTENT_DISPOSITION;
              ((StringBuilder)localObject4).append((CharSequence)localObject3);
              ((StringBuilder)localObject4).append(": ");
              ((StringBuilder)localObject4).append(HttpHeaderValues.FORM_DATA);
              ((StringBuilder)localObject4).append("; ");
              ((StringBuilder)localObject4).append(HttpHeaderValues.NAME);
              String str = "=\"";
              ((StringBuilder)localObject4).append(str);
              ((StringBuilder)localObject4).append(((InterfaceHttpData)localObject2).getName());
              ((StringBuilder)localObject4).append("\"\r\n");
              ((StringBuilder)localObject4).append(HttpHeaderNames.CONTENT_TYPE);
              ((StringBuilder)localObject4).append(": ");
              ((StringBuilder)localObject4).append(HttpHeaderValues.MULTIPART_MIXED);
              ((StringBuilder)localObject4).append("; ");
              ((StringBuilder)localObject4).append(HttpHeaderValues.BOUNDARY);
              ((StringBuilder)localObject4).append('=');
              ((StringBuilder)localObject4).append(this.multipartMixedBoundary);
              ((StringBuilder)localObject4).append("\r\n\r\n");
              ((StringBuilder)localObject4).append("--");
              ((StringBuilder)localObject4).append(this.multipartMixedBoundary);
              ((StringBuilder)localObject4).append("\r\n");
              ((StringBuilder)localObject4).append((CharSequence)localObject3);
              ((StringBuilder)localObject4).append(": ");
              ((StringBuilder)localObject4).append(HttpHeaderValues.ATTACHMENT);
              if (!((FileUpload)localObject2).getFilename().isEmpty())
              {
                ((StringBuilder)localObject4).append("; ");
                ((StringBuilder)localObject4).append(HttpHeaderValues.FILENAME);
                ((StringBuilder)localObject4).append(str);
                ((StringBuilder)localObject4).append(this.currentFileUpload.getFilename());
                ((StringBuilder)localObject4).append('"');
              }
              ((StringBuilder)localObject4).append("\r\n");
              localInternalAttribute.setValue(((StringBuilder)localObject4).toString(), 1);
              localInternalAttribute.setValue("", 2);
              this.globalBodySize += localInternalAttribute.size();
              i = 1;
              this.duringMixedMode = true;
              break label1401;
            }
          }
          this.currentFileUpload = ((FileUpload)localObject2);
          this.duringMixedMode = false;
        }
        int i = 0;
        label1401:
        if (i != 0)
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("--");
          ((StringBuilder)localObject3).append(this.multipartMixedBoundary);
          ((StringBuilder)localObject3).append("\r\n");
          ((InternalAttribute)localObject1).addValue(((StringBuilder)localObject3).toString());
          if (((FileUpload)localObject2).getFilename().isEmpty())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(HttpHeaderNames.CONTENT_DISPOSITION);
            ((StringBuilder)localObject3).append(": ");
            ((StringBuilder)localObject3).append(HttpHeaderValues.ATTACHMENT);
            ((StringBuilder)localObject3).append("\r\n");
            ((InternalAttribute)localObject1).addValue(((StringBuilder)localObject3).toString());
          }
          else
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(HttpHeaderNames.CONTENT_DISPOSITION);
            ((StringBuilder)localObject3).append(": ");
            ((StringBuilder)localObject3).append(HttpHeaderValues.ATTACHMENT);
            ((StringBuilder)localObject3).append("; ");
            ((StringBuilder)localObject3).append(HttpHeaderValues.FILENAME);
            ((StringBuilder)localObject3).append("=\"");
            ((StringBuilder)localObject3).append(((FileUpload)localObject2).getFilename());
            ((StringBuilder)localObject3).append("\"\r\n");
            ((InternalAttribute)localObject1).addValue(((StringBuilder)localObject3).toString());
          }
        }
        else
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("--");
          ((StringBuilder)localObject3).append(this.multipartDataBoundary);
          ((StringBuilder)localObject3).append("\r\n");
          ((InternalAttribute)localObject1).addValue(((StringBuilder)localObject3).toString());
          if (((FileUpload)localObject2).getFilename().isEmpty())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(HttpHeaderNames.CONTENT_DISPOSITION);
            ((StringBuilder)localObject3).append(": ");
            ((StringBuilder)localObject3).append(HttpHeaderValues.FORM_DATA);
            ((StringBuilder)localObject3).append("; ");
            ((StringBuilder)localObject3).append(HttpHeaderValues.NAME);
            ((StringBuilder)localObject3).append("=\"");
            ((StringBuilder)localObject3).append(((InterfaceHttpData)localObject2).getName());
            ((StringBuilder)localObject3).append("\"\r\n");
            ((InternalAttribute)localObject1).addValue(((StringBuilder)localObject3).toString());
          }
          else
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(HttpHeaderNames.CONTENT_DISPOSITION);
            ((StringBuilder)localObject3).append(": ");
            ((StringBuilder)localObject3).append(HttpHeaderValues.FORM_DATA);
            ((StringBuilder)localObject3).append("; ");
            ((StringBuilder)localObject3).append(HttpHeaderValues.NAME);
            ((StringBuilder)localObject3).append("=\"");
            ((StringBuilder)localObject3).append(((InterfaceHttpData)localObject2).getName());
            ((StringBuilder)localObject3).append("\"; ");
            ((StringBuilder)localObject3).append(HttpHeaderValues.FILENAME);
            ((StringBuilder)localObject3).append("=\"");
            ((StringBuilder)localObject3).append(((FileUpload)localObject2).getFilename());
            ((StringBuilder)localObject3).append("\"\r\n");
            ((InternalAttribute)localObject1).addValue(((StringBuilder)localObject3).toString());
          }
        }
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(HttpHeaderNames.CONTENT_LENGTH);
        ((StringBuilder)localObject3).append(": ");
        ((StringBuilder)localObject3).append(((HttpData)localObject2).length());
        ((StringBuilder)localObject3).append("\r\n");
        ((InternalAttribute)localObject1).addValue(((StringBuilder)localObject3).toString());
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(HttpHeaderNames.CONTENT_TYPE);
        ((StringBuilder)localObject3).append(": ");
        ((StringBuilder)localObject3).append(((FileUpload)localObject2).getContentType());
        ((InternalAttribute)localObject1).addValue(((StringBuilder)localObject3).toString());
        localObject4 = ((FileUpload)localObject2).getContentTransferEncoding();
        if (localObject4 != null)
        {
          localObject3 = HttpPostBodyUtil.TransferEncodingMechanism.BINARY;
          if (((String)localObject4).equals(((HttpPostBodyUtil.TransferEncodingMechanism)localObject3).value()))
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("\r\n");
            ((StringBuilder)localObject4).append(HttpHeaderNames.CONTENT_TRANSFER_ENCODING);
            ((StringBuilder)localObject4).append(": ");
            ((StringBuilder)localObject4).append(((HttpPostBodyUtil.TransferEncodingMechanism)localObject3).value());
            ((StringBuilder)localObject4).append("\r\n\r\n");
            ((InternalAttribute)localObject1).addValue(((StringBuilder)localObject4).toString());
            break label2194;
          }
        }
        if (((HttpData)localObject2).getCharset() != null)
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("; ");
          ((StringBuilder)localObject3).append(HttpHeaderValues.CHARSET);
          ((StringBuilder)localObject3).append('=');
          ((StringBuilder)localObject3).append(((HttpData)localObject2).getCharset().name());
          ((StringBuilder)localObject3).append("\r\n\r\n");
          ((InternalAttribute)localObject1).addValue(((StringBuilder)localObject3).toString());
        }
        else
        {
          ((InternalAttribute)localObject1).addValue("\r\n\r\n");
        }
        label2194:
        this.multipartHttpDatas.add(localObject1);
        this.multipartHttpDatas.add(paramInterfaceHttpData);
        this.globalBodySize += ((HttpData)localObject2).length() + ((InternalAttribute)localObject1).size();
      }
      return;
    }
    throw new ErrorDataEncoderException("Cannot add value once finalized");
  }
  
  public void cleanFiles()
  {
    this.factory.cleanRequestHttpData(this.request);
  }
  
  public void close()
    throws Exception
  {}
  
  public HttpRequest finalizeRequest()
    throws HttpPostRequestEncoder.ErrorDataEncoderException
  {
    if (!this.headerFinalized)
    {
      if (this.isMultipart)
      {
        localObject1 = new InternalAttribute(this.charset);
        if (this.duringMixedMode)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("\r\n--");
          ((StringBuilder)localObject2).append(this.multipartMixedBoundary);
          ((StringBuilder)localObject2).append("--");
          ((InternalAttribute)localObject1).addValue(((StringBuilder)localObject2).toString());
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("\r\n--");
        ((StringBuilder)localObject2).append(this.multipartDataBoundary);
        ((StringBuilder)localObject2).append("--\r\n");
        ((InternalAttribute)localObject1).addValue(((StringBuilder)localObject2).toString());
        this.multipartHttpDatas.add(localObject1);
        this.multipartMixedBoundary = null;
        this.currentFileUpload = null;
        this.duringMixedMode = false;
        this.globalBodySize += ((InternalAttribute)localObject1).size();
      }
      this.headerFinalized = true;
      Object localObject1 = this.request.headers();
      Object localObject3 = HttpHeaderNames.CONTENT_TYPE;
      Object localObject4 = ((HttpHeaders)localObject1).getAll((CharSequence)localObject3);
      Object localObject2 = ((HttpHeaders)localObject1).getAll(HttpHeaderNames.TRANSFER_ENCODING);
      if (localObject4 != null)
      {
        ((HttpHeaders)localObject1).remove((CharSequence)localObject3);
        Iterator localIterator = ((List)localObject4).iterator();
        while (localIterator.hasNext())
        {
          localObject4 = (String)localIterator.next();
          localObject3 = ((String)localObject4).toLowerCase();
          if ((!((String)localObject3).startsWith(HttpHeaderValues.MULTIPART_FORM_DATA.toString())) && (!((String)localObject3).startsWith(HttpHeaderValues.APPLICATION_X_WWW_FORM_URLENCODED.toString()))) {
            ((HttpHeaders)localObject1).add(HttpHeaderNames.CONTENT_TYPE, localObject4);
          }
        }
      }
      if (this.isMultipart)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(HttpHeaderValues.MULTIPART_FORM_DATA);
        ((StringBuilder)localObject3).append("; ");
        ((StringBuilder)localObject3).append(HttpHeaderValues.BOUNDARY);
        ((StringBuilder)localObject3).append('=');
        ((StringBuilder)localObject3).append(this.multipartDataBoundary);
        localObject3 = ((StringBuilder)localObject3).toString();
        ((HttpHeaders)localObject1).add(HttpHeaderNames.CONTENT_TYPE, localObject3);
      }
      else
      {
        ((HttpHeaders)localObject1).add(HttpHeaderNames.CONTENT_TYPE, HttpHeaderValues.APPLICATION_X_WWW_FORM_URLENCODED);
      }
      long l1 = this.globalBodySize;
      long l2 = l1;
      if (!this.isMultipart) {
        l2 = l1 - 1L;
      }
      this.iterator = this.multipartHttpDatas.listIterator();
      ((HttpHeaders)localObject1).set(HttpHeaderNames.CONTENT_LENGTH, String.valueOf(l2));
      if ((l2 <= 8096L) && (!this.isMultipart))
      {
        localObject1 = nextChunk();
        localObject2 = this.request;
        if ((localObject2 instanceof FullHttpRequest))
        {
          localObject2 = (FullHttpRequest)localObject2;
          localObject1 = ((ByteBufHolder)localObject1).content();
          if (((ByteBufHolder)localObject2).content() != localObject1)
          {
            ((ByteBufHolder)localObject2).content().clear().writeBytes((ByteBuf)localObject1);
            ((ReferenceCounted)localObject1).release();
          }
          return (HttpRequest)localObject2;
        }
        return new WrappedFullHttpRequest(this.request, (HttpContent)localObject1, null);
      }
      this.isChunked = true;
      if (localObject2 != null)
      {
        ((HttpHeaders)localObject1).remove(HttpHeaderNames.TRANSFER_ENCODING);
        localObject3 = ((List)localObject2).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject2 = (CharSequence)((Iterator)localObject3).next();
          if (!HttpHeaderValues.CHUNKED.contentEqualsIgnoreCase((CharSequence)localObject2)) {
            ((HttpHeaders)localObject1).add(HttpHeaderNames.TRANSFER_ENCODING, localObject2);
          }
        }
      }
      HttpUtil.setTransferEncodingChunked(this.request, true);
      return new WrappedHttpRequest(this.request);
    }
    throw new ErrorDataEncoderException("Header already encoded");
  }
  
  public List<InterfaceHttpData> getBodyListAttributes()
  {
    return this.bodyListDatas;
  }
  
  public boolean isChunked()
  {
    return this.isChunked;
  }
  
  public boolean isEndOfInput()
    throws Exception
  {
    return this.isLastChunkSent;
  }
  
  public boolean isMultipart()
  {
    return this.isMultipart;
  }
  
  public long length()
  {
    long l;
    if (this.isMultipart) {
      l = this.globalBodySize;
    } else {
      l = this.globalBodySize - 1L;
    }
    return l;
  }
  
  public long progress()
  {
    return this.globalProgress;
  }
  
  public HttpContent readChunk(ByteBufAllocator paramByteBufAllocator)
    throws Exception
  {
    if (this.isLastChunkSent) {
      return null;
    }
    paramByteBufAllocator = nextChunk();
    this.globalProgress += paramByteBufAllocator.content().readableBytes();
    return paramByteBufAllocator;
  }
  
  @Deprecated
  public HttpContent readChunk(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    return readChunk(paramChannelHandlerContext.alloc());
  }
  
  public void setBodyHttpDatas(List<InterfaceHttpData> paramList)
    throws HttpPostRequestEncoder.ErrorDataEncoderException
  {
    ObjectUtil.checkNotNull(paramList, "datas");
    this.globalBodySize = 0L;
    this.bodyListDatas.clear();
    this.currentFileUpload = null;
    this.duringMixedMode = false;
    this.multipartHttpDatas.clear();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      addBodyHttpData((InterfaceHttpData)paramList.next());
    }
  }
  
  public static enum EncoderMode
  {
    static
    {
      EncoderMode localEncoderMode1 = new EncoderMode("RFC1738", 0);
      RFC1738 = localEncoderMode1;
      EncoderMode localEncoderMode2 = new EncoderMode("RFC3986", 1);
      RFC3986 = localEncoderMode2;
      EncoderMode localEncoderMode3 = new EncoderMode("HTML5", 2);
      HTML5 = localEncoderMode3;
      $VALUES = new EncoderMode[] { localEncoderMode1, localEncoderMode2, localEncoderMode3 };
    }
  }
  
  public static class ErrorDataEncoderException
    extends Exception
  {
    private static final long serialVersionUID = 5020247425493164465L;
    
    public ErrorDataEncoderException() {}
    
    public ErrorDataEncoderException(String paramString)
    {
      super();
    }
    
    public ErrorDataEncoderException(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }
    
    public ErrorDataEncoderException(Throwable paramThrowable)
    {
      super();
    }
  }
  
  private static final class WrappedFullHttpRequest
    extends HttpPostRequestEncoder.WrappedHttpRequest
    implements FullHttpRequest
  {
    private final HttpContent content;
    
    private WrappedFullHttpRequest(HttpRequest paramHttpRequest, HttpContent paramHttpContent)
    {
      super();
      this.content = paramHttpContent;
    }
    
    public ByteBuf content()
    {
      return this.content.content();
    }
    
    public FullHttpRequest copy()
    {
      return replace(content().copy());
    }
    
    public FullHttpRequest duplicate()
    {
      return replace(content().duplicate());
    }
    
    public int refCnt()
    {
      return this.content.refCnt();
    }
    
    public boolean release()
    {
      return this.content.release();
    }
    
    public boolean release(int paramInt)
    {
      return this.content.release(paramInt);
    }
    
    public FullHttpRequest replace(ByteBuf paramByteBuf)
    {
      paramByteBuf = new DefaultFullHttpRequest(protocolVersion(), method(), uri(), paramByteBuf);
      paramByteBuf.headers().set(headers());
      paramByteBuf.trailingHeaders().set(trailingHeaders());
      return paramByteBuf;
    }
    
    public FullHttpRequest retain()
    {
      this.content.retain();
      return this;
    }
    
    public FullHttpRequest retain(int paramInt)
    {
      this.content.retain(paramInt);
      return this;
    }
    
    public FullHttpRequest retainedDuplicate()
    {
      return replace(content().retainedDuplicate());
    }
    
    public FullHttpRequest setMethod(HttpMethod paramHttpMethod)
    {
      super.setMethod(paramHttpMethod);
      return this;
    }
    
    public FullHttpRequest setProtocolVersion(HttpVersion paramHttpVersion)
    {
      super.setProtocolVersion(paramHttpVersion);
      return this;
    }
    
    public FullHttpRequest setUri(String paramString)
    {
      super.setUri(paramString);
      return this;
    }
    
    public FullHttpRequest touch()
    {
      this.content.touch();
      return this;
    }
    
    public FullHttpRequest touch(Object paramObject)
    {
      this.content.touch(paramObject);
      return this;
    }
    
    public HttpHeaders trailingHeaders()
    {
      HttpContent localHttpContent = this.content;
      if ((localHttpContent instanceof LastHttpContent)) {
        return ((LastHttpContent)localHttpContent).trailingHeaders();
      }
      return EmptyHttpHeaders.INSTANCE;
    }
  }
  
  private static class WrappedHttpRequest
    implements HttpRequest
  {
    private final HttpRequest request;
    
    WrappedHttpRequest(HttpRequest paramHttpRequest)
    {
      this.request = paramHttpRequest;
    }
    
    public DecoderResult decoderResult()
    {
      return this.request.decoderResult();
    }
    
    @Deprecated
    public DecoderResult getDecoderResult()
    {
      return this.request.getDecoderResult();
    }
    
    public HttpMethod getMethod()
    {
      return this.request.method();
    }
    
    public HttpVersion getProtocolVersion()
    {
      return this.request.protocolVersion();
    }
    
    public String getUri()
    {
      return this.request.uri();
    }
    
    public HttpHeaders headers()
    {
      return this.request.headers();
    }
    
    public HttpMethod method()
    {
      return this.request.method();
    }
    
    public HttpVersion protocolVersion()
    {
      return this.request.protocolVersion();
    }
    
    public void setDecoderResult(DecoderResult paramDecoderResult)
    {
      this.request.setDecoderResult(paramDecoderResult);
    }
    
    public HttpRequest setMethod(HttpMethod paramHttpMethod)
    {
      this.request.setMethod(paramHttpMethod);
      return this;
    }
    
    public HttpRequest setProtocolVersion(HttpVersion paramHttpVersion)
    {
      this.request.setProtocolVersion(paramHttpVersion);
      return this;
    }
    
    public HttpRequest setUri(String paramString)
    {
      this.request.setUri(paramString);
      return this;
    }
    
    public String uri()
    {
      return this.request.uri();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\multipart\HttpPostRequestEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */