package io.netty.handler.codec.http.multipart;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufHolder;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMessage;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.LastHttpContent;
import io.netty.handler.codec.http.QueryStringDecoder;
import io.netty.util.AsciiString;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.InternalThreadLocalMap;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class HttpPostMultipartRequestDecoder
  implements InterfaceHttpPostRequestDecoder
{
  private static final String FILENAME_ENCODED;
  private final List<InterfaceHttpData> bodyListHttpData = new ArrayList();
  private int bodyListHttpDataRank;
  private final Map<String, List<InterfaceHttpData>> bodyMapHttpData = new TreeMap(CaseIgnoringComparator.INSTANCE);
  private Charset charset;
  private Attribute currentAttribute;
  private Map<CharSequence, Attribute> currentFieldAttributes;
  private FileUpload currentFileUpload;
  private HttpPostRequestDecoder.MultiPartStatus currentStatus = HttpPostRequestDecoder.MultiPartStatus.NOTSTARTED;
  private boolean destroyed;
  private int discardThreshold = 10485760;
  private final HttpDataFactory factory;
  private boolean isLastChunk;
  private String multipartDataBoundary;
  private String multipartMixedBoundary;
  private final HttpRequest request;
  private ByteBuf undecodedChunk;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HttpHeaderValues.FILENAME.toString());
    localStringBuilder.append('*');
    FILENAME_ENCODED = localStringBuilder.toString();
  }
  
  public HttpPostMultipartRequestDecoder(HttpRequest paramHttpRequest)
  {
    this(new DefaultHttpDataFactory(16384L), paramHttpRequest, HttpConstants.DEFAULT_CHARSET);
  }
  
  public HttpPostMultipartRequestDecoder(HttpDataFactory paramHttpDataFactory, HttpRequest paramHttpRequest)
  {
    this(paramHttpDataFactory, paramHttpRequest, HttpConstants.DEFAULT_CHARSET);
  }
  
  public HttpPostMultipartRequestDecoder(HttpDataFactory paramHttpDataFactory, HttpRequest paramHttpRequest, Charset paramCharset)
  {
    HttpRequest localHttpRequest = (HttpRequest)ObjectUtil.checkNotNull(paramHttpRequest, "request");
    this.request = localHttpRequest;
    this.charset = ((Charset)ObjectUtil.checkNotNull(paramCharset, "charset"));
    this.factory = ((HttpDataFactory)ObjectUtil.checkNotNull(paramHttpDataFactory, "factory"));
    setMultipart(localHttpRequest.headers().get(HttpHeaderNames.CONTENT_TYPE));
    if ((paramHttpRequest instanceof HttpContent)) {
      offer((HttpContent)paramHttpRequest);
    } else {
      parseBody();
    }
  }
  
  private void checkDestroyed()
  {
    if (!this.destroyed) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HttpPostMultipartRequestDecoder.class.getSimpleName());
    localStringBuilder.append(" was destroyed already");
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  private void cleanMixedAttributes()
  {
    this.currentFieldAttributes.remove(HttpHeaderValues.CHARSET);
    this.currentFieldAttributes.remove(HttpHeaderNames.CONTENT_LENGTH);
    this.currentFieldAttributes.remove(HttpHeaderNames.CONTENT_TRANSFER_ENCODING);
    this.currentFieldAttributes.remove(HttpHeaderNames.CONTENT_TYPE);
    this.currentFieldAttributes.remove(HttpHeaderValues.FILENAME);
  }
  
  private static String cleanString(String paramString)
  {
    int i = paramString.length();
    StringBuilder localStringBuilder = new StringBuilder(i);
    for (int j = 0; j < i; j++)
    {
      char c = paramString.charAt(j);
      if (c != '\t')
      {
        if (c == '"') {
          continue;
        }
        if ((c != ',') && (c != '=') && (c != ':') && (c != ';'))
        {
          localStringBuilder.append(c);
          continue;
        }
      }
      localStringBuilder.append(' ');
    }
    return localStringBuilder.toString().trim();
  }
  
  /* Error */
  private InterfaceHttpData decodeMultipart(HttpPostRequestDecoder.MultiPartStatus paramMultiPartStatus)
  {
    // Byte code:
    //   0: getstatic 233	io/netty/handler/codec/http/multipart/HttpPostMultipartRequestDecoder$1:$SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus	[I
    //   3: aload_1
    //   4: invokevirtual 238	java/lang/Enum:ordinal	()I
    //   7: iaload
    //   8: tableswitch	default:+60->68, 1:+424->432, 2:+413->421, 3:+398->406, 4:+393->401, 5:+110->118, 6:+101->109, 7:+86->94, 8:+81->89, 9:+72->80, 10:+70->78, 11:+70->78
    //   68: new 240	io/netty/handler/codec/http/multipart/HttpPostRequestDecoder$ErrorDataDecoderException
    //   71: dup
    //   72: ldc -14
    //   74: invokespecial 243	io/netty/handler/codec/http/multipart/HttpPostRequestDecoder$ErrorDataDecoderException:<init>	(Ljava/lang/String;)V
    //   77: athrow
    //   78: aconst_null
    //   79: areturn
    //   80: aload_0
    //   81: aload_0
    //   82: getfield 245	io/netty/handler/codec/http/multipart/HttpPostMultipartRequestDecoder:multipartMixedBoundary	Ljava/lang/String;
    //   85: invokevirtual 249	io/netty/handler/codec/http/multipart/HttpPostMultipartRequestDecoder:getFileUpload	(Ljava/lang/String;)Lio/netty/handler/codec/http/multipart/InterfaceHttpData;
    //   88: areturn
    //   89: aload_0
    //   90: invokespecial 253	io/netty/handler/codec/http/multipart/HttpPostMultipartRequestDecoder:findMultipartDisposition	()Lio/netty/handler/codec/http/multipart/InterfaceHttpData;
    //   93: areturn
    //   94: aload_0
    //   95: aload_0
    //   96: getfield 245	io/netty/handler/codec/http/multipart/HttpPostMultipartRequestDecoder:multipartMixedBoundary	Ljava/lang/String;
    //   99: getstatic 256	io/netty/handler/codec/http/multipart/HttpPostRequestDecoder$MultiPartStatus:MIXEDDISPOSITION	Lio/netty/handler/codec/http/multipart/HttpPostRequestDecoder$MultiPartStatus;
    //   102: getstatic 259	io/netty/handler/codec/http/multipart/HttpPostRequestDecoder$MultiPartStatus:HEADERDELIMITER	Lio/netty/handler/codec/http/multipart/HttpPostRequestDecoder$MultiPartStatus;
    //   105: invokespecial 263	io/netty/handler/codec/http/multipart/HttpPostMultipartRequestDecoder:findMultipartDelimiter	(Ljava/lang/String;Lio/netty/handler/codec/http/multipart/HttpPostRequestDecoder$MultiPartStatus;Lio/netty/handler/codec/http/multipart/HttpPostRequestDecoder$MultiPartStatus;)Lio/netty/handler/codec/http/multipart/InterfaceHttpData;
    //   108: areturn
    //   109: aload_0
    //   110: aload_0
    //   111: getfield 265	io/netty/handler/codec/http/multipart/HttpPostMultipartRequestDecoder:multipartDataBoundary	Ljava/lang/String;
    //   114: invokevirtual 249	io/netty/handler/codec/http/multipart/HttpPostMultipartRequestDecoder:getFileUpload	(Ljava/lang/String;)Lio/netty/handler/codec/http/multipart/InterfaceHttpData;
    //   117: areturn
    //   118: aload_0
    //   119: getfield 184	io/netty/handler/codec/http/multipart/HttpPostMultipartRequestDecoder:currentFieldAttributes	Ljava/util/Map;
    //   122: getstatic 187	io/netty/handler/codec/http/HttpHeaderValues:CHARSET	Lio/netty/util/AsciiString;
    //   125: invokeinterface 267 2 0
    //   130: checkcast 269	io/netty/handler/codec/http/multipart/Attribute
    //   133: astore_1
    //   134: aload_1
    //   135: ifnull +36 -> 171
    //   138: aload_1
    //   139: invokeinterface 272 1 0
    //   144: invokestatic 276	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
    //   147: astore_1
    //   148: goto +25 -> 173
    //   151: astore_1
    //   152: new 240	io/netty/handler/codec/http/multipart/HttpPostRequestDecoder$ErrorDataDecoderException
    //   155: dup
    //   156: aload_1
    //   157: invokespecial 279	io/netty/handler/codec/http/multipart/HttpPostRequestDecoder$ErrorDataDecoderException:<init>	(Ljava/lang/Throwable;)V
    //   160: athrow
    //   161: astore_1
    //   162: new 240	io/netty/handler/codec/http/multipart/HttpPostRequestDecoder$ErrorDataDecoderException
    //   165: dup
    //   166: aload_1
    //   167: invokespecial 279	io/netty/handler/codec/http/multipart/HttpPostRequestDecoder$ErrorDataDecoderException:<init>	(Ljava/lang/Throwable;)V
    //   170: athrow
    //   171: aconst_null
    //   172: astore_1
    //   173: aload_0
    //   174: getfield 184	io/netty/handler/codec/http/multipart/HttpPostMultipartRequestDecoder:currentFieldAttributes	Ljava/util/Map;
    //   177: getstatic 282	io/netty/handler/codec/http/HttpHeaderValues:NAME	Lio/netty/util/AsciiString;
    //   180: invokeinterface 267 2 0
    //   185: checkcast 269	io/netty/handler/codec/http/multipart/Attribute
    //   188: astore_2
    //   189: aload_0
    //   190: getfield 284	io/netty/handler/codec/http/multipart/HttpPostMultipartRequestDecoder:currentAttribute	Lio/netty/handler/codec/http/multipart/Attribute;
    //   193: ifnonnull +164 -> 357
    //   196: aload_0
    //   197: getfield 184	io/netty/handler/codec/http/multipart/HttpPostMultipartRequestDecoder:currentFieldAttributes	Ljava/util/Map;
    //   200: getstatic 196	io/netty/handler/codec/http/HttpHeaderNames:CONTENT_LENGTH	Lio/netty/util/AsciiString;
    //   203: invokeinterface 267 2 0
    //   208: checkcast 269	io/netty/handler/codec/http/multipart/Attribute
    //   211: astore_3
    //   212: aload_3
    //   213: ifnull +17 -> 230
    //   216: aload_3
    //   217: invokeinterface 272 1 0
    //   222: invokestatic 290	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   225: lstore 4
    //   227: goto +19 -> 246
    //   230: lconst_0
    //   231: lstore 4
    //   233: goto +13 -> 246
    //   236: astore_1
    //   237: new 240	io/netty/handler/codec/http/multipart/HttpPostRequestDecoder$ErrorDataDecoderException
    //   240: dup
    //   241: aload_1
    //   242: invokespecial 279	io/netty/handler/codec/http/multipart/HttpPostRequestDecoder$ErrorDataDecoderException:<init>	(Ljava/lang/Throwable;)V
    //   245: athrow
    //   246: lload 4
    //   248: lconst_0
    //   249: lcmp
    //   250: ifle +34 -> 284
    //   253: aload_0
    //   254: aload_0
    //   255: getfield 137	io/netty/handler/codec/http/multipart/HttpPostMultipartRequestDecoder:factory	Lio/netty/handler/codec/http/multipart/HttpDataFactory;
    //   258: aload_0
    //   259: getfield 127	io/netty/handler/codec/http/multipart/HttpPostMultipartRequestDecoder:request	Lio/netty/handler/codec/http/HttpRequest;
    //   262: aload_2
    //   263: invokeinterface 272 1 0
    //   268: invokestatic 292	io/netty/handler/codec/http/multipart/HttpPostMultipartRequestDecoder:cleanString	(Ljava/lang/String;)Ljava/lang/String;
    //   271: lload 4
    //   273: invokeinterface 296 5 0
    //   278: putfield 284	io/netty/handler/codec/http/multipart/HttpPostMultipartRequestDecoder:currentAttribute	Lio/netty/handler/codec/http/multipart/Attribute;
    //   281: goto +29 -> 310
    //   284: aload_0
    //   285: aload_0
    //   286: getfield 137	io/netty/handler/codec/http/multipart/HttpPostMultipartRequestDecoder:factory	Lio/netty/handler/codec/http/multipart/HttpDataFactory;
    //   289: aload_0
    //   290: getfield 127	io/netty/handler/codec/http/multipart/HttpPostMultipartRequestDecoder:request	Lio/netty/handler/codec/http/HttpRequest;
    //   293: aload_2
    //   294: invokeinterface 272 1 0
    //   299: invokestatic 292	io/netty/handler/codec/http/multipart/HttpPostMultipartRequestDecoder:cleanString	(Ljava/lang/String;)Ljava/lang/String;
    //   302: invokeinterface 299 3 0
    //   307: putfield 284	io/netty/handler/codec/http/multipart/HttpPostMultipartRequestDecoder:currentAttribute	Lio/netty/handler/codec/http/multipart/Attribute;
    //   310: aload_1
    //   311: ifnull +46 -> 357
    //   314: aload_0
    //   315: getfield 284	io/netty/handler/codec/http/multipart/HttpPostMultipartRequestDecoder:currentAttribute	Lio/netty/handler/codec/http/multipart/Attribute;
    //   318: aload_1
    //   319: invokeinterface 305 2 0
    //   324: goto +33 -> 357
    //   327: astore_1
    //   328: new 240	io/netty/handler/codec/http/multipart/HttpPostRequestDecoder$ErrorDataDecoderException
    //   331: dup
    //   332: aload_1
    //   333: invokespecial 279	io/netty/handler/codec/http/multipart/HttpPostRequestDecoder$ErrorDataDecoderException:<init>	(Ljava/lang/Throwable;)V
    //   336: athrow
    //   337: astore_1
    //   338: new 240	io/netty/handler/codec/http/multipart/HttpPostRequestDecoder$ErrorDataDecoderException
    //   341: dup
    //   342: aload_1
    //   343: invokespecial 279	io/netty/handler/codec/http/multipart/HttpPostRequestDecoder$ErrorDataDecoderException:<init>	(Ljava/lang/Throwable;)V
    //   346: athrow
    //   347: astore_1
    //   348: new 240	io/netty/handler/codec/http/multipart/HttpPostRequestDecoder$ErrorDataDecoderException
    //   351: dup
    //   352: aload_1
    //   353: invokespecial 279	io/netty/handler/codec/http/multipart/HttpPostRequestDecoder$ErrorDataDecoderException:<init>	(Ljava/lang/Throwable;)V
    //   356: athrow
    //   357: aload_0
    //   358: getfield 307	io/netty/handler/codec/http/multipart/HttpPostMultipartRequestDecoder:undecodedChunk	Lio/netty/buffer/ByteBuf;
    //   361: aload_0
    //   362: getfield 265	io/netty/handler/codec/http/multipart/HttpPostMultipartRequestDecoder:multipartDataBoundary	Ljava/lang/String;
    //   365: aload_0
    //   366: getfield 284	io/netty/handler/codec/http/multipart/HttpPostMultipartRequestDecoder:currentAttribute	Lio/netty/handler/codec/http/multipart/Attribute;
    //   369: invokestatic 311	io/netty/handler/codec/http/multipart/HttpPostMultipartRequestDecoder:loadDataMultipart	(Lio/netty/buffer/ByteBuf;Ljava/lang/String;Lio/netty/handler/codec/http/multipart/HttpData;)Z
    //   372: ifne +5 -> 377
    //   375: aconst_null
    //   376: areturn
    //   377: aload_0
    //   378: getfield 284	io/netty/handler/codec/http/multipart/HttpPostMultipartRequestDecoder:currentAttribute	Lio/netty/handler/codec/http/multipart/Attribute;
    //   381: astore_1
    //   382: aload_0
    //   383: aconst_null
    //   384: putfield 284	io/netty/handler/codec/http/multipart/HttpPostMultipartRequestDecoder:currentAttribute	Lio/netty/handler/codec/http/multipart/Attribute;
    //   387: aload_0
    //   388: aconst_null
    //   389: putfield 184	io/netty/handler/codec/http/multipart/HttpPostMultipartRequestDecoder:currentFieldAttributes	Ljava/util/Map;
    //   392: aload_0
    //   393: getstatic 259	io/netty/handler/codec/http/multipart/HttpPostRequestDecoder$MultiPartStatus:HEADERDELIMITER	Lio/netty/handler/codec/http/multipart/HttpPostRequestDecoder$MultiPartStatus;
    //   396: putfield 113	io/netty/handler/codec/http/multipart/HttpPostMultipartRequestDecoder:currentStatus	Lio/netty/handler/codec/http/multipart/HttpPostRequestDecoder$MultiPartStatus;
    //   399: aload_1
    //   400: areturn
    //   401: aload_0
    //   402: invokespecial 253	io/netty/handler/codec/http/multipart/HttpPostMultipartRequestDecoder:findMultipartDisposition	()Lio/netty/handler/codec/http/multipart/InterfaceHttpData;
    //   405: areturn
    //   406: aload_0
    //   407: aload_0
    //   408: getfield 265	io/netty/handler/codec/http/multipart/HttpPostMultipartRequestDecoder:multipartDataBoundary	Ljava/lang/String;
    //   411: getstatic 314	io/netty/handler/codec/http/multipart/HttpPostRequestDecoder$MultiPartStatus:DISPOSITION	Lio/netty/handler/codec/http/multipart/HttpPostRequestDecoder$MultiPartStatus;
    //   414: getstatic 317	io/netty/handler/codec/http/multipart/HttpPostRequestDecoder$MultiPartStatus:PREEPILOGUE	Lio/netty/handler/codec/http/multipart/HttpPostRequestDecoder$MultiPartStatus;
    //   417: invokespecial 263	io/netty/handler/codec/http/multipart/HttpPostMultipartRequestDecoder:findMultipartDelimiter	(Ljava/lang/String;Lio/netty/handler/codec/http/multipart/HttpPostRequestDecoder$MultiPartStatus;Lio/netty/handler/codec/http/multipart/HttpPostRequestDecoder$MultiPartStatus;)Lio/netty/handler/codec/http/multipart/InterfaceHttpData;
    //   420: areturn
    //   421: new 240	io/netty/handler/codec/http/multipart/HttpPostRequestDecoder$ErrorDataDecoderException
    //   424: dup
    //   425: ldc_w 319
    //   428: invokespecial 243	io/netty/handler/codec/http/multipart/HttpPostRequestDecoder$ErrorDataDecoderException:<init>	(Ljava/lang/String;)V
    //   431: athrow
    //   432: new 240	io/netty/handler/codec/http/multipart/HttpPostRequestDecoder$ErrorDataDecoderException
    //   435: dup
    //   436: ldc_w 319
    //   439: invokespecial 243	io/netty/handler/codec/http/multipart/HttpPostRequestDecoder$ErrorDataDecoderException:<init>	(Ljava/lang/String;)V
    //   442: athrow
    //   443: astore_3
    //   444: goto -214 -> 230
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	447	0	this	HttpPostMultipartRequestDecoder
    //   0	447	1	paramMultiPartStatus	HttpPostRequestDecoder.MultiPartStatus
    //   188	106	2	localAttribute1	Attribute
    //   211	6	3	localAttribute2	Attribute
    //   443	1	3	localNumberFormatException	NumberFormatException
    //   225	47	4	l	long
    // Exception table:
    //   from	to	target	type
    //   138	148	151	java/nio/charset/UnsupportedCharsetException
    //   138	148	161	java/io/IOException
    //   216	227	236	java/io/IOException
    //   253	281	327	java/io/IOException
    //   284	310	327	java/io/IOException
    //   253	281	337	java/lang/IllegalArgumentException
    //   284	310	337	java/lang/IllegalArgumentException
    //   253	281	347	java/lang/NullPointerException
    //   284	310	347	java/lang/NullPointerException
    //   216	227	443	java/lang/NumberFormatException
  }
  
  private InterfaceHttpData findMultipartDelimiter(String paramString, HttpPostRequestDecoder.MultiPartStatus paramMultiPartStatus1, HttpPostRequestDecoder.MultiPartStatus paramMultiPartStatus2)
  {
    int i = this.undecodedChunk.readerIndex();
    try
    {
      skipControlCharacters(this.undecodedChunk);
      skipOneLine();
      try
      {
        String str = readDelimiter(this.undecodedChunk, paramString);
        if (str.equals(paramString))
        {
          this.currentStatus = paramMultiPartStatus1;
          return decodeMultipart(paramMultiPartStatus1);
        }
        paramMultiPartStatus1 = new StringBuilder();
        paramMultiPartStatus1.append(paramString);
        paramMultiPartStatus1.append("--");
        if (str.equals(paramMultiPartStatus1.toString()))
        {
          this.currentStatus = paramMultiPartStatus2;
          paramString = HttpPostRequestDecoder.MultiPartStatus.HEADERDELIMITER;
          if (paramMultiPartStatus2 == paramString)
          {
            this.currentFieldAttributes = null;
            return decodeMultipart(paramString);
          }
          return null;
        }
        this.undecodedChunk.readerIndex(i);
        throw new HttpPostRequestDecoder.ErrorDataDecoderException("No Multipart delimiter found");
      }
      catch (HttpPostRequestDecoder.NotEnoughDataDecoderException paramString)
      {
        this.undecodedChunk.readerIndex(i);
        return null;
      }
      return null;
    }
    catch (HttpPostRequestDecoder.NotEnoughDataDecoderException paramString)
    {
      this.undecodedChunk.readerIndex(i);
    }
  }
  
  private InterfaceHttpData findMultipartDisposition()
  {
    int i = this.undecodedChunk.readerIndex();
    if (this.currentStatus == HttpPostRequestDecoder.MultiPartStatus.DISPOSITION) {
      this.currentFieldAttributes = new TreeMap(CaseIgnoringComparator.INSTANCE);
    }
    while (!skipOneLine()) {
      try
      {
        skipControlCharacters(this.undecodedChunk);
        Object localObject1 = readLine(this.undecodedChunk, this.charset);
        localObject1 = splitMultipartHeader((String)localObject1);
        Object localObject4 = HttpHeaderNames.CONTENT_DISPOSITION;
        boolean bool1 = false;
        boolean bool2 = ((AsciiString)localObject4).contentEqualsIgnoreCase(localObject1[0]);
        int j = 1;
        if (bool2)
        {
          if (this.currentStatus == HttpPostRequestDecoder.MultiPartStatus.DISPOSITION) {
            bool1 = HttpHeaderValues.FORM_DATA.contentEqualsIgnoreCase(localObject1[1]);
          } else if ((HttpHeaderValues.ATTACHMENT.contentEqualsIgnoreCase(localObject1[1])) || (HttpHeaderValues.FILE.contentEqualsIgnoreCase(localObject1[1]))) {
            bool1 = true;
          }
          if (!bool1) {
            continue;
          }
          j = 2;
          while (j < localObject1.length)
          {
            localObject4 = localObject1[j].split("=", 2);
            try
            {
              localObject4 = getContentDispositionAttribute((String[])localObject4);
              this.currentFieldAttributes.put(((InterfaceHttpData)localObject4).getName(), localObject4);
              j++;
            }
            catch (IllegalArgumentException localIllegalArgumentException1)
            {
              throw new HttpPostRequestDecoder.ErrorDataDecoderException(localIllegalArgumentException1);
            }
            catch (NullPointerException localNullPointerException1)
            {
              throw new HttpPostRequestDecoder.ErrorDataDecoderException(localNullPointerException1);
            }
          }
        }
        localObject4 = HttpHeaderNames.CONTENT_TRANSFER_ENCODING;
        if (((AsciiString)localObject4).contentEqualsIgnoreCase(localNullPointerException1[0]))
        {
          try
          {
            Attribute localAttribute1 = this.factory.createAttribute(this.request, ((AsciiString)localObject4).toString(), cleanString(localNullPointerException1[1]));
            this.currentFieldAttributes.put(localObject4, localAttribute1);
          }
          catch (IllegalArgumentException localIllegalArgumentException2)
          {
            throw new HttpPostRequestDecoder.ErrorDataDecoderException(localIllegalArgumentException2);
          }
          catch (NullPointerException localNullPointerException2)
          {
            throw new HttpPostRequestDecoder.ErrorDataDecoderException(localNullPointerException2);
          }
        }
        else
        {
          localObject4 = HttpHeaderNames.CONTENT_LENGTH;
          if (((AsciiString)localObject4).contentEqualsIgnoreCase(localNullPointerException2[0]))
          {
            try
            {
              Attribute localAttribute2 = this.factory.createAttribute(this.request, ((AsciiString)localObject4).toString(), cleanString(localNullPointerException2[1]));
              this.currentFieldAttributes.put(localObject4, localAttribute2);
            }
            catch (IllegalArgumentException localIllegalArgumentException3)
            {
              throw new HttpPostRequestDecoder.ErrorDataDecoderException(localIllegalArgumentException3);
            }
            catch (NullPointerException localNullPointerException3)
            {
              throw new HttpPostRequestDecoder.ErrorDataDecoderException(localNullPointerException3);
            }
          }
          else if (HttpHeaderNames.CONTENT_TYPE.contentEqualsIgnoreCase(localNullPointerException3[0]))
          {
            Object localObject2;
            if (HttpHeaderValues.MULTIPART_MIXED.contentEqualsIgnoreCase(localNullPointerException3[1]))
            {
              if (this.currentStatus == HttpPostRequestDecoder.MultiPartStatus.DISPOSITION)
              {
                localObject2 = StringUtil.substringAfter(localNullPointerException3[2], '=');
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append("--");
                ((StringBuilder)localObject4).append((String)localObject2);
                this.multipartMixedBoundary = ((StringBuilder)localObject4).toString();
                localObject2 = HttpPostRequestDecoder.MultiPartStatus.MIXEDDELIMITER;
                this.currentStatus = ((HttpPostRequestDecoder.MultiPartStatus)localObject2);
                return decodeMultipart((HttpPostRequestDecoder.MultiPartStatus)localObject2);
              }
              throw new HttpPostRequestDecoder.ErrorDataDecoderException("Mixed Multipart found in a previous Mixed Multipart");
            }
            while (j < localObject2.length)
            {
              localObject4 = HttpHeaderValues.CHARSET;
              String str = ((AsciiString)localObject4).toString();
              if (localObject2[j].regionMatches(true, 0, str, 0, str.length()))
              {
                Object localObject5 = StringUtil.substringAfter(localObject2[j], '=');
                try
                {
                  localObject5 = this.factory.createAttribute(this.request, str, cleanString((String)localObject5));
                  this.currentFieldAttributes.put(localObject4, localObject5);
                }
                catch (IllegalArgumentException localIllegalArgumentException4)
                {
                  throw new HttpPostRequestDecoder.ErrorDataDecoderException(localIllegalArgumentException4);
                }
                catch (NullPointerException localNullPointerException4)
                {
                  throw new HttpPostRequestDecoder.ErrorDataDecoderException(localNullPointerException4);
                }
              }
              try
              {
                localObject4 = this.factory.createAttribute(this.request, cleanString(localNullPointerException4[0]), localNullPointerException4[j]);
                this.currentFieldAttributes.put(((InterfaceHttpData)localObject4).getName(), localObject4);
                j++;
              }
              catch (IllegalArgumentException localIllegalArgumentException5)
              {
                throw new HttpPostRequestDecoder.ErrorDataDecoderException(localIllegalArgumentException5);
              }
              catch (NullPointerException localNullPointerException5)
              {
                throw new HttpPostRequestDecoder.ErrorDataDecoderException(localNullPointerException5);
              }
            }
            localObject3 = (Attribute)this.currentFieldAttributes.get(HttpHeaderValues.FILENAME);
          }
        }
      }
      catch (HttpPostRequestDecoder.NotEnoughDataDecoderException localNotEnoughDataDecoderException)
      {
        this.undecodedChunk.readerIndex(i);
        return null;
      }
    }
    Object localObject3;
    if (this.currentStatus == HttpPostRequestDecoder.MultiPartStatus.DISPOSITION)
    {
      if (localObject3 != null)
      {
        localObject3 = HttpPostRequestDecoder.MultiPartStatus.FILEUPLOAD;
        this.currentStatus = ((HttpPostRequestDecoder.MultiPartStatus)localObject3);
        return decodeMultipart((HttpPostRequestDecoder.MultiPartStatus)localObject3);
      }
      localObject3 = HttpPostRequestDecoder.MultiPartStatus.FIELD;
      this.currentStatus = ((HttpPostRequestDecoder.MultiPartStatus)localObject3);
      return decodeMultipart((HttpPostRequestDecoder.MultiPartStatus)localObject3);
    }
    if (localObject3 != null)
    {
      localObject3 = HttpPostRequestDecoder.MultiPartStatus.MIXEDFILEUPLOAD;
      this.currentStatus = ((HttpPostRequestDecoder.MultiPartStatus)localObject3);
      return decodeMultipart((HttpPostRequestDecoder.MultiPartStatus)localObject3);
    }
    throw new HttpPostRequestDecoder.ErrorDataDecoderException("Filename not found");
  }
  
  private Attribute getContentDispositionAttribute(String... paramVarArgs)
  {
    String str1 = cleanString(paramVarArgs[0]);
    String str2 = paramVarArgs[1];
    paramVarArgs = HttpHeaderValues.FILENAME;
    String str3;
    if (paramVarArgs.contentEquals(str1))
    {
      int i = str2.length() - 1;
      str3 = str1;
      paramVarArgs = str2;
      if (i > 0)
      {
        str3 = str1;
        paramVarArgs = str2;
        if (str2.charAt(0) == '"')
        {
          str3 = str1;
          paramVarArgs = str2;
          if (str2.charAt(i) == '"')
          {
            paramVarArgs = str2.substring(1, i);
            str3 = str1;
          }
        }
      }
    }
    else if (FILENAME_ENCODED.equals(str1))
    {
      try
      {
        str3 = paramVarArgs.toString();
        paramVarArgs = cleanString(str2).split("'", 3);
        paramVarArgs = QueryStringDecoder.decodeComponent(paramVarArgs[2], Charset.forName(paramVarArgs[0]));
      }
      catch (UnsupportedCharsetException paramVarArgs)
      {
        throw new HttpPostRequestDecoder.ErrorDataDecoderException(paramVarArgs);
      }
      catch (ArrayIndexOutOfBoundsException paramVarArgs)
      {
        throw new HttpPostRequestDecoder.ErrorDataDecoderException(paramVarArgs);
      }
    }
    else
    {
      paramVarArgs = cleanString(str2);
      str3 = str1;
    }
    return this.factory.createAttribute(this.request, str3, paramVarArgs);
  }
  
  private static boolean loadDataMultipart(ByteBuf paramByteBuf, String paramString, HttpData paramHttpData)
  {
    if (!paramByteBuf.hasArray()) {
      return loadDataMultipartStandard(paramByteBuf, paramString, paramHttpData);
    }
    HttpPostBodyUtil.SeekAheadOptimize localSeekAheadOptimize = new HttpPostBodyUtil.SeekAheadOptimize(paramByteBuf);
    int i = paramByteBuf.readerIndex();
    int j = paramString.length();
    int k = localSeekAheadOptimize.pos;
    boolean bool1 = false;
    int m = 10;
    int n = 0;
    boolean bool2;
    for (;;)
    {
      int i1 = localSeekAheadOptimize.pos;
      int i2 = localSeekAheadOptimize.limit;
      int i3 = 1;
      bool2 = bool1;
      if (i1 >= i2) {
        break;
      }
      byte[] arrayOfByte = localSeekAheadOptimize.bytes;
      localSeekAheadOptimize.pos = (i1 + 1);
      i2 = arrayOfByte[i1];
      if ((m == 10) && (i2 == paramString.codePointAt(n)))
      {
        i2 = n + 1;
        n = i2;
        if (j == i2)
        {
          bool2 = true;
          break;
        }
      }
      else
      {
        i1 = localSeekAheadOptimize.pos;
        k = i1;
        if (i2 == 10)
        {
          n = i3;
          if (m == 13) {
            n = 2;
          }
          k = i1 - n;
          n = 0;
        }
        m = i2;
      }
    }
    n = k;
    if (m == 13) {
      n = k - 1;
    }
    n = localSeekAheadOptimize.getReadPosition(n);
    paramString = paramByteBuf.retainedSlice(i, n - i);
    try
    {
      paramHttpData.addContent(paramString, bool2);
      paramByteBuf.readerIndex(n);
      return bool2;
    }
    catch (IOException paramByteBuf)
    {
      throw new HttpPostRequestDecoder.ErrorDataDecoderException(paramByteBuf);
    }
  }
  
  private static boolean loadDataMultipartStandard(ByteBuf paramByteBuf, String paramString, HttpData paramHttpData)
  {
    int i = paramByteBuf.readerIndex();
    int j = paramString.length();
    boolean bool1 = false;
    int k = i;
    int m = 10;
    int n = 0;
    boolean bool3;
    for (;;)
    {
      boolean bool2 = paramByteBuf.isReadable();
      int i1 = 1;
      bool3 = bool1;
      if (!bool2) {
        break;
      }
      int i2 = paramByteBuf.readByte();
      if ((m == 10) && (i2 == paramString.codePointAt(n)))
      {
        i2 = n + 1;
        n = i2;
        if (j == i2)
        {
          bool3 = true;
          break;
        }
      }
      else
      {
        int i3 = paramByteBuf.readerIndex();
        k = i3;
        if (i2 == 10)
        {
          n = i1;
          if (m == 13) {
            n = 2;
          }
          k = i3 - n;
          n = 0;
        }
        m = i2;
      }
    }
    n = k;
    if (m == 13) {
      n = k - 1;
    }
    paramString = paramByteBuf.retainedSlice(i, n - i);
    try
    {
      paramHttpData.addContent(paramString, bool3);
      paramByteBuf.readerIndex(n);
      return bool3;
    }
    catch (IOException paramByteBuf)
    {
      throw new HttpPostRequestDecoder.ErrorDataDecoderException(paramByteBuf);
    }
  }
  
  private void parseBody()
  {
    HttpPostRequestDecoder.MultiPartStatus localMultiPartStatus = this.currentStatus;
    if ((localMultiPartStatus != HttpPostRequestDecoder.MultiPartStatus.PREEPILOGUE) && (localMultiPartStatus != HttpPostRequestDecoder.MultiPartStatus.EPILOGUE))
    {
      parseBodyMultipart();
      return;
    }
    if (this.isLastChunk) {
      this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.EPILOGUE;
    }
  }
  
  private void parseBodyMultipart()
  {
    Object localObject = this.undecodedChunk;
    if ((localObject != null) && (((ByteBuf)localObject).readableBytes() != 0)) {
      for (localObject = decodeMultipart(this.currentStatus); localObject != null; localObject = decodeMultipart((HttpPostRequestDecoder.MultiPartStatus)localObject))
      {
        addHttpData((InterfaceHttpData)localObject);
        localObject = this.currentStatus;
        if ((localObject == HttpPostRequestDecoder.MultiPartStatus.PREEPILOGUE) || (localObject == HttpPostRequestDecoder.MultiPartStatus.EPILOGUE)) {
          break;
        }
      }
    }
  }
  
  private static String readDelimiter(ByteBuf paramByteBuf, String paramString)
  {
    if (!paramByteBuf.hasArray()) {
      return readDelimiterStandard(paramByteBuf, paramString);
    }
    HttpPostBodyUtil.SeekAheadOptimize localSeekAheadOptimize = new HttpPostBodyUtil.SeekAheadOptimize(paramByteBuf);
    int i = paramByteBuf.readerIndex();
    int j = paramString.length();
    try
    {
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>(64);
      int k = 0;
      int m;
      int n;
      for (;;)
      {
        m = localSeekAheadOptimize.pos;
        n = localSeekAheadOptimize.limit;
        if ((m >= n) || (k >= j)) {
          break label137;
        }
        byte[] arrayOfByte = localSeekAheadOptimize.bytes;
        localSeekAheadOptimize.pos = (m + 1);
        n = arrayOfByte[m];
        if (n != paramString.charAt(k)) {
          break;
        }
        k++;
        localStringBuilder.append((char)n);
      }
      paramByteBuf.readerIndex(i);
      paramString = new io/netty/handler/codec/http/multipart/HttpPostRequestDecoder$NotEnoughDataDecoderException;
      paramString.<init>();
      throw paramString;
      label137:
      if (m < n)
      {
        paramString = localSeekAheadOptimize.bytes;
        k = m + 1;
        localSeekAheadOptimize.pos = k;
        j = paramString[m];
        if (j == 13)
        {
          if (k < n)
          {
            localSeekAheadOptimize.pos = (k + 1);
            if (paramString[k] == 10)
            {
              localSeekAheadOptimize.setReadPosition(0);
              return localStringBuilder.toString();
            }
            paramByteBuf.readerIndex(i);
            paramString = new io/netty/handler/codec/http/multipart/HttpPostRequestDecoder$NotEnoughDataDecoderException;
            paramString.<init>();
            throw paramString;
          }
          paramByteBuf.readerIndex(i);
          paramString = new io/netty/handler/codec/http/multipart/HttpPostRequestDecoder$NotEnoughDataDecoderException;
          paramString.<init>();
          throw paramString;
        }
        if (j == 10)
        {
          localSeekAheadOptimize.setReadPosition(0);
          return localStringBuilder.toString();
        }
        if (j == 45)
        {
          localStringBuilder.append('-');
          k = localSeekAheadOptimize.pos;
          if (k < localSeekAheadOptimize.limit)
          {
            paramString = localSeekAheadOptimize.bytes;
            localSeekAheadOptimize.pos = (k + 1);
            if (paramString[k] == 45)
            {
              localStringBuilder.append('-');
              n = localSeekAheadOptimize.pos;
              k = localSeekAheadOptimize.limit;
              if (n < k)
              {
                paramString = localSeekAheadOptimize.bytes;
                j = n + 1;
                localSeekAheadOptimize.pos = j;
                n = paramString[n];
                if (n == 13)
                {
                  if (j < k)
                  {
                    localSeekAheadOptimize.pos = (j + 1);
                    if (paramString[j] == 10)
                    {
                      localSeekAheadOptimize.setReadPosition(0);
                      return localStringBuilder.toString();
                    }
                    paramByteBuf.readerIndex(i);
                    paramString = new io/netty/handler/codec/http/multipart/HttpPostRequestDecoder$NotEnoughDataDecoderException;
                    paramString.<init>();
                    throw paramString;
                  }
                  paramByteBuf.readerIndex(i);
                  paramString = new io/netty/handler/codec/http/multipart/HttpPostRequestDecoder$NotEnoughDataDecoderException;
                  paramString.<init>();
                  throw paramString;
                }
                if (n == 10)
                {
                  localSeekAheadOptimize.setReadPosition(0);
                  return localStringBuilder.toString();
                }
                localSeekAheadOptimize.setReadPosition(1);
                return localStringBuilder.toString();
              }
              localSeekAheadOptimize.setReadPosition(0);
              paramString = localStringBuilder.toString();
              return paramString;
            }
          }
        }
      }
      paramByteBuf.readerIndex(i);
      throw new HttpPostRequestDecoder.NotEnoughDataDecoderException();
    }
    catch (IndexOutOfBoundsException paramString)
    {
      paramByteBuf.readerIndex(i);
      throw new HttpPostRequestDecoder.NotEnoughDataDecoderException(paramString);
    }
  }
  
  private static String readDelimiterStandard(ByteBuf paramByteBuf, String paramString)
  {
    int i = paramByteBuf.readerIndex();
    try
    {
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>(64);
      int j = 0;
      int k = paramString.length();
      while ((paramByteBuf.isReadable()) && (j < k))
      {
        int m = paramByteBuf.readByte();
        if (m == paramString.charAt(j))
        {
          j++;
          localStringBuilder.append((char)m);
        }
        else
        {
          paramByteBuf.readerIndex(i);
          paramString = new io/netty/handler/codec/http/multipart/HttpPostRequestDecoder$NotEnoughDataDecoderException;
          paramString.<init>();
          throw paramString;
        }
      }
      if (paramByteBuf.isReadable())
      {
        j = paramByteBuf.readByte();
        if (j == 13)
        {
          if (paramByteBuf.readByte() == 10) {
            return localStringBuilder.toString();
          }
          paramByteBuf.readerIndex(i);
          paramString = new io/netty/handler/codec/http/multipart/HttpPostRequestDecoder$NotEnoughDataDecoderException;
          paramString.<init>();
          throw paramString;
        }
        if (j == 10) {
          return localStringBuilder.toString();
        }
        if (j == 45)
        {
          localStringBuilder.append('-');
          if (paramByteBuf.readByte() == 45)
          {
            localStringBuilder.append('-');
            if (paramByteBuf.isReadable())
            {
              j = paramByteBuf.readByte();
              if (j == 13)
              {
                if (paramByteBuf.readByte() == 10) {
                  return localStringBuilder.toString();
                }
                paramByteBuf.readerIndex(i);
                paramString = new io/netty/handler/codec/http/multipart/HttpPostRequestDecoder$NotEnoughDataDecoderException;
                paramString.<init>();
                throw paramString;
              }
              if (j == 10) {
                return localStringBuilder.toString();
              }
              paramByteBuf.readerIndex(paramByteBuf.readerIndex() - 1);
              return localStringBuilder.toString();
            }
            paramString = localStringBuilder.toString();
            return paramString;
          }
        }
      }
      paramByteBuf.readerIndex(i);
      throw new HttpPostRequestDecoder.NotEnoughDataDecoderException();
    }
    catch (IndexOutOfBoundsException paramString)
    {
      paramByteBuf.readerIndex(i);
      throw new HttpPostRequestDecoder.NotEnoughDataDecoderException(paramString);
    }
  }
  
  /* Error */
  private static String readLine(ByteBuf paramByteBuf, Charset paramCharset)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 446	io/netty/buffer/ByteBuf:hasArray	()Z
    //   4: ifne +9 -> 13
    //   7: aload_0
    //   8: aload_1
    //   9: invokestatic 513	io/netty/handler/codec/http/multipart/HttpPostMultipartRequestDecoder:readLineStandard	(Lio/netty/buffer/ByteBuf;Ljava/nio/charset/Charset;)Ljava/lang/String;
    //   12: areturn
    //   13: new 451	io/netty/handler/codec/http/multipart/HttpPostBodyUtil$SeekAheadOptimize
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 453	io/netty/handler/codec/http/multipart/HttpPostBodyUtil$SeekAheadOptimize:<init>	(Lio/netty/buffer/ByteBuf;)V
    //   21: astore_2
    //   22: aload_0
    //   23: invokevirtual 326	io/netty/buffer/ByteBuf:readerIndex	()I
    //   26: istore_3
    //   27: aload_0
    //   28: invokevirtual 517	io/netty/buffer/ByteBuf:alloc	()Lio/netty/buffer/ByteBufAllocator;
    //   31: bipush 64
    //   33: invokeinterface 522 2 0
    //   38: astore 4
    //   40: aload_2
    //   41: getfield 456	io/netty/handler/codec/http/multipart/HttpPostBodyUtil$SeekAheadOptimize:pos	I
    //   44: istore 5
    //   46: aload_2
    //   47: getfield 459	io/netty/handler/codec/http/multipart/HttpPostBodyUtil$SeekAheadOptimize:limit	I
    //   50: istore 6
    //   52: iload 5
    //   54: iload 6
    //   56: if_icmpge +156 -> 212
    //   59: aload_2
    //   60: getfield 463	io/netty/handler/codec/http/multipart/HttpPostBodyUtil$SeekAheadOptimize:bytes	[B
    //   63: astore 7
    //   65: iload 5
    //   67: iconst_1
    //   68: iadd
    //   69: istore 8
    //   71: aload_2
    //   72: iload 8
    //   74: putfield 456	io/netty/handler/codec/http/multipart/HttpPostBodyUtil$SeekAheadOptimize:pos	I
    //   77: aload 7
    //   79: iload 5
    //   81: baload
    //   82: istore 5
    //   84: iload 5
    //   86: bipush 13
    //   88: if_icmpne +84 -> 172
    //   91: iload 8
    //   93: iload 6
    //   95: if_icmpge +66 -> 161
    //   98: iload 8
    //   100: iconst_1
    //   101: iadd
    //   102: istore 6
    //   104: aload_2
    //   105: iload 6
    //   107: putfield 456	io/netty/handler/codec/http/multipart/HttpPostBodyUtil$SeekAheadOptimize:pos	I
    //   110: aload 7
    //   112: iload 8
    //   114: baload
    //   115: bipush 10
    //   117: if_icmpne +25 -> 142
    //   120: aload_2
    //   121: iconst_0
    //   122: invokevirtual 509	io/netty/handler/codec/http/multipart/HttpPostBodyUtil$SeekAheadOptimize:setReadPosition	(I)V
    //   125: aload 4
    //   127: aload_1
    //   128: invokevirtual 525	io/netty/buffer/ByteBuf:toString	(Ljava/nio/charset/Charset;)Ljava/lang/String;
    //   131: astore_1
    //   132: aload 4
    //   134: invokeinterface 530 1 0
    //   139: pop
    //   140: aload_1
    //   141: areturn
    //   142: aload_2
    //   143: iload 6
    //   145: iconst_1
    //   146: isub
    //   147: putfield 456	io/netty/handler/codec/http/multipart/HttpPostBodyUtil$SeekAheadOptimize:pos	I
    //   150: aload 4
    //   152: bipush 13
    //   154: invokevirtual 533	io/netty/buffer/ByteBuf:writeByte	(I)Lio/netty/buffer/ByteBuf;
    //   157: pop
    //   158: goto -118 -> 40
    //   161: aload 4
    //   163: iload 5
    //   165: invokevirtual 533	io/netty/buffer/ByteBuf:writeByte	(I)Lio/netty/buffer/ByteBuf;
    //   168: pop
    //   169: goto -129 -> 40
    //   172: iload 5
    //   174: bipush 10
    //   176: if_icmpne +25 -> 201
    //   179: aload_2
    //   180: iconst_0
    //   181: invokevirtual 509	io/netty/handler/codec/http/multipart/HttpPostBodyUtil$SeekAheadOptimize:setReadPosition	(I)V
    //   184: aload 4
    //   186: aload_1
    //   187: invokevirtual 525	io/netty/buffer/ByteBuf:toString	(Ljava/nio/charset/Charset;)Ljava/lang/String;
    //   190: astore_1
    //   191: aload 4
    //   193: invokeinterface 530 1 0
    //   198: pop
    //   199: aload_1
    //   200: areturn
    //   201: aload 4
    //   203: iload 5
    //   205: invokevirtual 533	io/netty/buffer/ByteBuf:writeByte	(I)Lio/netty/buffer/ByteBuf;
    //   208: pop
    //   209: goto -169 -> 40
    //   212: aload 4
    //   214: invokeinterface 530 1 0
    //   219: pop
    //   220: aload_0
    //   221: iload_3
    //   222: invokevirtual 349	io/netty/buffer/ByteBuf:readerIndex	(I)Lio/netty/buffer/ByteBuf;
    //   225: pop
    //   226: new 321	io/netty/handler/codec/http/multipart/HttpPostRequestDecoder$NotEnoughDataDecoderException
    //   229: dup
    //   230: invokespecial 506	io/netty/handler/codec/http/multipart/HttpPostRequestDecoder$NotEnoughDataDecoderException:<init>	()V
    //   233: athrow
    //   234: astore_0
    //   235: goto +21 -> 256
    //   238: astore_1
    //   239: aload_0
    //   240: iload_3
    //   241: invokevirtual 349	io/netty/buffer/ByteBuf:readerIndex	(I)Lio/netty/buffer/ByteBuf;
    //   244: pop
    //   245: new 321	io/netty/handler/codec/http/multipart/HttpPostRequestDecoder$NotEnoughDataDecoderException
    //   248: astore_0
    //   249: aload_0
    //   250: aload_1
    //   251: invokespecial 510	io/netty/handler/codec/http/multipart/HttpPostRequestDecoder$NotEnoughDataDecoderException:<init>	(Ljava/lang/Throwable;)V
    //   254: aload_0
    //   255: athrow
    //   256: aload 4
    //   258: invokeinterface 530 1 0
    //   263: pop
    //   264: aload_0
    //   265: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	266	0	paramByteBuf	ByteBuf
    //   0	266	1	paramCharset	Charset
    //   21	159	2	localSeekAheadOptimize	HttpPostBodyUtil.SeekAheadOptimize
    //   26	215	3	i	int
    //   38	219	4	localByteBuf	ByteBuf
    //   44	160	5	j	int
    //   50	97	6	k	int
    //   63	48	7	arrayOfByte	byte[]
    //   69	44	8	m	int
    // Exception table:
    //   from	to	target	type
    //   40	52	234	finally
    //   59	65	234	finally
    //   71	77	234	finally
    //   104	110	234	finally
    //   120	132	234	finally
    //   142	158	234	finally
    //   161	169	234	finally
    //   179	191	234	finally
    //   201	209	234	finally
    //   239	256	234	finally
    //   40	52	238	java/lang/IndexOutOfBoundsException
    //   59	65	238	java/lang/IndexOutOfBoundsException
    //   71	77	238	java/lang/IndexOutOfBoundsException
    //   104	110	238	java/lang/IndexOutOfBoundsException
    //   120	132	238	java/lang/IndexOutOfBoundsException
    //   142	158	238	java/lang/IndexOutOfBoundsException
    //   161	169	238	java/lang/IndexOutOfBoundsException
    //   179	191	238	java/lang/IndexOutOfBoundsException
    //   201	209	238	java/lang/IndexOutOfBoundsException
  }
  
  /* Error */
  private static String readLineStandard(ByteBuf paramByteBuf, Charset paramCharset)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 326	io/netty/buffer/ByteBuf:readerIndex	()I
    //   4: istore_2
    //   5: aload_0
    //   6: invokevirtual 517	io/netty/buffer/ByteBuf:alloc	()Lio/netty/buffer/ByteBufAllocator;
    //   9: bipush 64
    //   11: invokeinterface 522 2 0
    //   16: astore_3
    //   17: aload_0
    //   18: invokevirtual 481	io/netty/buffer/ByteBuf:isReadable	()Z
    //   21: ifeq +91 -> 112
    //   24: aload_0
    //   25: invokevirtual 485	io/netty/buffer/ByteBuf:readByte	()B
    //   28: istore 4
    //   30: iload 4
    //   32: bipush 13
    //   34: if_icmpne +46 -> 80
    //   37: aload_0
    //   38: aload_0
    //   39: invokevirtual 326	io/netty/buffer/ByteBuf:readerIndex	()I
    //   42: invokevirtual 537	io/netty/buffer/ByteBuf:getByte	(I)B
    //   45: bipush 10
    //   47: if_icmpne +23 -> 70
    //   50: aload_0
    //   51: invokevirtual 485	io/netty/buffer/ByteBuf:readByte	()B
    //   54: pop
    //   55: aload_3
    //   56: aload_1
    //   57: invokevirtual 525	io/netty/buffer/ByteBuf:toString	(Ljava/nio/charset/Charset;)Ljava/lang/String;
    //   60: astore_1
    //   61: aload_3
    //   62: invokeinterface 530 1 0
    //   67: pop
    //   68: aload_1
    //   69: areturn
    //   70: aload_3
    //   71: bipush 13
    //   73: invokevirtual 533	io/netty/buffer/ByteBuf:writeByte	(I)Lio/netty/buffer/ByteBuf;
    //   76: pop
    //   77: goto -60 -> 17
    //   80: iload 4
    //   82: bipush 10
    //   84: if_icmpne +18 -> 102
    //   87: aload_3
    //   88: aload_1
    //   89: invokevirtual 525	io/netty/buffer/ByteBuf:toString	(Ljava/nio/charset/Charset;)Ljava/lang/String;
    //   92: astore_1
    //   93: aload_3
    //   94: invokeinterface 530 1 0
    //   99: pop
    //   100: aload_1
    //   101: areturn
    //   102: aload_3
    //   103: iload 4
    //   105: invokevirtual 533	io/netty/buffer/ByteBuf:writeByte	(I)Lio/netty/buffer/ByteBuf;
    //   108: pop
    //   109: goto -92 -> 17
    //   112: aload_3
    //   113: invokeinterface 530 1 0
    //   118: pop
    //   119: aload_0
    //   120: iload_2
    //   121: invokevirtual 349	io/netty/buffer/ByteBuf:readerIndex	(I)Lio/netty/buffer/ByteBuf;
    //   124: pop
    //   125: new 321	io/netty/handler/codec/http/multipart/HttpPostRequestDecoder$NotEnoughDataDecoderException
    //   128: dup
    //   129: invokespecial 506	io/netty/handler/codec/http/multipart/HttpPostRequestDecoder$NotEnoughDataDecoderException:<init>	()V
    //   132: athrow
    //   133: astore_0
    //   134: goto +21 -> 155
    //   137: astore_1
    //   138: aload_0
    //   139: iload_2
    //   140: invokevirtual 349	io/netty/buffer/ByteBuf:readerIndex	(I)Lio/netty/buffer/ByteBuf;
    //   143: pop
    //   144: new 321	io/netty/handler/codec/http/multipart/HttpPostRequestDecoder$NotEnoughDataDecoderException
    //   147: astore_0
    //   148: aload_0
    //   149: aload_1
    //   150: invokespecial 510	io/netty/handler/codec/http/multipart/HttpPostRequestDecoder$NotEnoughDataDecoderException:<init>	(Ljava/lang/Throwable;)V
    //   153: aload_0
    //   154: athrow
    //   155: aload_3
    //   156: invokeinterface 530 1 0
    //   161: pop
    //   162: aload_0
    //   163: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	paramByteBuf	ByteBuf
    //   0	164	1	paramCharset	Charset
    //   4	136	2	i	int
    //   16	140	3	localByteBuf	ByteBuf
    //   28	76	4	j	int
    // Exception table:
    //   from	to	target	type
    //   17	30	133	finally
    //   37	61	133	finally
    //   70	77	133	finally
    //   87	93	133	finally
    //   102	109	133	finally
    //   138	155	133	finally
    //   17	30	137	java/lang/IndexOutOfBoundsException
    //   37	61	137	java/lang/IndexOutOfBoundsException
    //   70	77	137	java/lang/IndexOutOfBoundsException
    //   87	93	137	java/lang/IndexOutOfBoundsException
    //   102	109	137	java/lang/IndexOutOfBoundsException
  }
  
  private void setMultipart(String paramString)
  {
    paramString = HttpPostRequestDecoder.getMultipartDataBoundary(paramString);
    if (paramString != null)
    {
      this.multipartDataBoundary = paramString[0];
      if ((paramString.length > 1) && (paramString[1] != null)) {
        this.charset = Charset.forName(paramString[1]);
      }
    }
    else
    {
      this.multipartDataBoundary = null;
    }
    this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.HEADERDELIMITER;
  }
  
  private static void skipControlCharacters(ByteBuf paramByteBuf)
  {
    if (!paramByteBuf.hasArray()) {
      try
      {
        skipControlCharactersStandard(paramByteBuf);
        return;
      }
      catch (IndexOutOfBoundsException paramByteBuf)
      {
        throw new HttpPostRequestDecoder.NotEnoughDataDecoderException(paramByteBuf);
      }
    }
    HttpPostBodyUtil.SeekAheadOptimize localSeekAheadOptimize = new HttpPostBodyUtil.SeekAheadOptimize(paramByteBuf);
    char c;
    do
    {
      int i = localSeekAheadOptimize.pos;
      if (i >= localSeekAheadOptimize.limit) {
        break;
      }
      paramByteBuf = localSeekAheadOptimize.bytes;
      localSeekAheadOptimize.pos = (i + 1);
      c = (char)(paramByteBuf[i] & 0xFF);
    } while ((Character.isISOControl(c)) || (Character.isWhitespace(c)));
    localSeekAheadOptimize.setReadPosition(1);
    return;
    throw new HttpPostRequestDecoder.NotEnoughDataDecoderException("Access out of bounds");
  }
  
  private static void skipControlCharactersStandard(ByteBuf paramByteBuf)
  {
    char c;
    do
    {
      c = (char)paramByteBuf.readUnsignedByte();
    } while ((Character.isISOControl(c)) || (Character.isWhitespace(c)));
    paramByteBuf.readerIndex(paramByteBuf.readerIndex() - 1);
  }
  
  private boolean skipOneLine()
  {
    if (!this.undecodedChunk.isReadable()) {
      return false;
    }
    int i = this.undecodedChunk.readByte();
    if (i == 13)
    {
      if (!this.undecodedChunk.isReadable())
      {
        localByteBuf = this.undecodedChunk;
        localByteBuf.readerIndex(localByteBuf.readerIndex() - 1);
        return false;
      }
      if (this.undecodedChunk.readByte() == 10) {
        return true;
      }
      localByteBuf = this.undecodedChunk;
      localByteBuf.readerIndex(localByteBuf.readerIndex() - 2);
      return false;
    }
    if (i == 10) {
      return true;
    }
    ByteBuf localByteBuf = this.undecodedChunk;
    localByteBuf.readerIndex(localByteBuf.readerIndex() - 1);
    return false;
  }
  
  private static String[] splitMultipartHeader(String paramString)
  {
    ArrayList localArrayList = new ArrayList(1);
    int i = 0;
    int j = HttpPostBodyUtil.findNonWhitespace(paramString, 0);
    for (int k = j; k < paramString.length(); k++)
    {
      char c = paramString.charAt(k);
      if ((c == ':') || (Character.isWhitespace(c))) {
        break;
      }
    }
    for (int m = k;; m++)
    {
      n = m;
      if (m >= paramString.length()) {
        break;
      }
      if (paramString.charAt(m) == ':')
      {
        n = m + 1;
        break;
      }
    }
    m = HttpPostBodyUtil.findNonWhitespace(paramString, n);
    int n = HttpPostBodyUtil.findEndOfString(paramString);
    localArrayList.add(paramString.substring(j, k));
    if (m >= n) {
      paramString = "";
    } else {
      paramString = paramString.substring(m, n);
    }
    if (paramString.indexOf(';') >= 0) {
      paramString = splitMultipartHeaderValues(paramString);
    } else {
      paramString = paramString.split(",");
    }
    m = paramString.length;
    for (k = 0; k < m; k++) {
      localArrayList.add(paramString[k].trim());
    }
    paramString = new String[localArrayList.size()];
    for (k = i; k < localArrayList.size(); k++) {
      paramString[k] = ((String)localArrayList.get(k));
    }
    return paramString;
  }
  
  private static String[] splitMultipartHeaderValues(String paramString)
  {
    ArrayList localArrayList = InternalThreadLocalMap.get().arrayList(1);
    int i = 0;
    int j = 0;
    int k = 0;
    int i1;
    for (int m = 0; i < paramString.length(); m = i1)
    {
      int n = paramString.charAt(i);
      int i2;
      int i3;
      if (k != 0)
      {
        if (m != 0)
        {
          i1 = 0;
          i2 = j;
          i3 = k;
        }
        else if (n == 92)
        {
          i1 = 1;
          i2 = j;
          i3 = k;
        }
        else
        {
          i2 = j;
          i3 = k;
          i1 = m;
          if (n == 34)
          {
            i3 = 0;
            i2 = j;
            i1 = m;
          }
        }
      }
      else if (n == 34)
      {
        i3 = 1;
        i2 = j;
        i1 = m;
      }
      else
      {
        i2 = j;
        i3 = k;
        i1 = m;
        if (n == 59)
        {
          localArrayList.add(paramString.substring(j, i));
          i2 = i + 1;
          i1 = m;
          i3 = k;
        }
      }
      i++;
      j = i2;
      k = i3;
    }
    localArrayList.add(paramString.substring(j));
    return (String[])localArrayList.toArray(new String[0]);
  }
  
  protected void addHttpData(InterfaceHttpData paramInterfaceHttpData)
  {
    if (paramInterfaceHttpData == null) {
      return;
    }
    List localList = (List)this.bodyMapHttpData.get(paramInterfaceHttpData.getName());
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList(1);
      this.bodyMapHttpData.put(paramInterfaceHttpData.getName(), localObject);
    }
    ((List)localObject).add(paramInterfaceHttpData);
    this.bodyListHttpData.add(paramInterfaceHttpData);
  }
  
  public void cleanFiles()
  {
    checkDestroyed();
    this.factory.cleanRequestHttpData(this.request);
  }
  
  public InterfaceHttpData currentPartialHttpData()
  {
    FileUpload localFileUpload = this.currentFileUpload;
    if (localFileUpload != null) {
      return localFileUpload;
    }
    return this.currentAttribute;
  }
  
  public void destroy()
  {
    cleanFiles();
    this.destroyed = true;
    ByteBuf localByteBuf = this.undecodedChunk;
    if ((localByteBuf != null) && (localByteBuf.refCnt() > 0))
    {
      this.undecodedChunk.release();
      this.undecodedChunk = null;
    }
  }
  
  public InterfaceHttpData getBodyHttpData(String paramString)
  {
    checkDestroyed();
    if (this.isLastChunk)
    {
      paramString = (List)this.bodyMapHttpData.get(paramString);
      if (paramString != null) {
        return (InterfaceHttpData)paramString.get(0);
      }
      return null;
    }
    throw new HttpPostRequestDecoder.NotEnoughDataDecoderException();
  }
  
  public List<InterfaceHttpData> getBodyHttpDatas()
  {
    checkDestroyed();
    if (this.isLastChunk) {
      return this.bodyListHttpData;
    }
    throw new HttpPostRequestDecoder.NotEnoughDataDecoderException();
  }
  
  public List<InterfaceHttpData> getBodyHttpDatas(String paramString)
  {
    checkDestroyed();
    if (this.isLastChunk) {
      return (List)this.bodyMapHttpData.get(paramString);
    }
    throw new HttpPostRequestDecoder.NotEnoughDataDecoderException();
  }
  
  public int getDiscardThreshold()
  {
    return this.discardThreshold;
  }
  
  protected InterfaceHttpData getFileUpload(String paramString)
  {
    Attribute localAttribute1 = (Attribute)this.currentFieldAttributes.get(HttpHeaderNames.CONTENT_TRANSFER_ENCODING);
    Object localObject1 = this.charset;
    Object localObject2 = HttpPostBodyUtil.TransferEncodingMechanism.BIT7;
    Object localObject3 = localObject1;
    Object localObject4 = localObject2;
    if (localAttribute1 != null) {
      try
      {
        localObject3 = localAttribute1.getValue().toLowerCase();
        if (((String)localObject3).equals(((HttpPostBodyUtil.TransferEncodingMechanism)localObject2).value()))
        {
          localObject3 = CharsetUtil.US_ASCII;
          localObject4 = localObject2;
        }
        else
        {
          localObject4 = HttpPostBodyUtil.TransferEncodingMechanism.BIT8;
          if (((String)localObject3).equals(((HttpPostBodyUtil.TransferEncodingMechanism)localObject4).value()))
          {
            localObject3 = CharsetUtil.ISO_8859_1;
          }
          else
          {
            localObject4 = HttpPostBodyUtil.TransferEncodingMechanism.BINARY;
            if (((String)localObject3).equals(((HttpPostBodyUtil.TransferEncodingMechanism)localObject4).value()))
            {
              localObject3 = localObject1;
            }
            else
            {
              paramString = new StringBuilder();
              paramString.append("TransferEncoding Unknown: ");
              paramString.append((String)localObject3);
              throw new HttpPostRequestDecoder.ErrorDataDecoderException(paramString.toString());
            }
          }
        }
      }
      catch (IOException paramString)
      {
        throw new HttpPostRequestDecoder.ErrorDataDecoderException(paramString);
      }
    }
    localObject1 = (Attribute)this.currentFieldAttributes.get(HttpHeaderValues.CHARSET);
    if (localObject1 != null) {
      try
      {
        localObject3 = Charset.forName(((Attribute)localObject1).getValue());
      }
      catch (UnsupportedCharsetException paramString)
      {
        throw new HttpPostRequestDecoder.ErrorDataDecoderException(paramString);
      }
      catch (IOException paramString)
      {
        throw new HttpPostRequestDecoder.ErrorDataDecoderException(paramString);
      }
    }
    Attribute localAttribute2;
    if (this.currentFileUpload == null)
    {
      localObject2 = (Attribute)this.currentFieldAttributes.get(HttpHeaderValues.FILENAME);
      localAttribute1 = (Attribute)this.currentFieldAttributes.get(HttpHeaderValues.NAME);
      localObject1 = (Attribute)this.currentFieldAttributes.get(HttpHeaderNames.CONTENT_TYPE);
      localAttribute2 = (Attribute)this.currentFieldAttributes.get(HttpHeaderNames.CONTENT_LENGTH);
      l1 = 0L;
      l2 = l1;
      if (localAttribute2 == null) {}
    }
    try
    {
      try
      {
        l2 = Long.parseLong(localAttribute2.getValue());
      }
      catch (IOException paramString)
      {
        throw new HttpPostRequestDecoder.ErrorDataDecoderException(paramString);
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        l2 = l1;
      }
    }
    if (localObject1 != null) {}
    try
    {
      localObject1 = ((Attribute)localObject1).getValue();
      break label350;
      localObject1 = "application/octet-stream";
      label350:
      this.currentFileUpload = this.factory.createFileUpload(this.request, cleanString(localAttribute1.getValue()), cleanString(((Attribute)localObject2).getValue()), (String)localObject1, ((HttpPostBodyUtil.TransferEncodingMechanism)localObject4).value(), (Charset)localObject3, l2);
    }
    catch (IOException paramString)
    {
      throw new HttpPostRequestDecoder.ErrorDataDecoderException(paramString);
    }
    catch (IllegalArgumentException paramString)
    {
      throw new HttpPostRequestDecoder.ErrorDataDecoderException(paramString);
    }
    catch (NullPointerException paramString)
    {
      throw new HttpPostRequestDecoder.ErrorDataDecoderException(paramString);
    }
    if (!loadDataMultipart(this.undecodedChunk, paramString, this.currentFileUpload)) {
      return null;
    }
    if (this.currentFileUpload.isCompleted())
    {
      if (this.currentStatus == HttpPostRequestDecoder.MultiPartStatus.FILEUPLOAD)
      {
        this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.HEADERDELIMITER;
        this.currentFieldAttributes = null;
      }
      else
      {
        this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.MIXEDDELIMITER;
        cleanMixedAttributes();
      }
      paramString = this.currentFileUpload;
      this.currentFileUpload = null;
      return paramString;
    }
    return null;
  }
  
  public boolean hasNext()
  {
    checkDestroyed();
    if ((this.currentStatus == HttpPostRequestDecoder.MultiPartStatus.EPILOGUE) && (this.bodyListHttpDataRank >= this.bodyListHttpData.size())) {
      throw new HttpPostRequestDecoder.EndOfDataDecoderException();
    }
    boolean bool;
    if ((!this.bodyListHttpData.isEmpty()) && (this.bodyListHttpDataRank < this.bodyListHttpData.size())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isMultipart()
  {
    checkDestroyed();
    return true;
  }
  
  public InterfaceHttpData next()
  {
    checkDestroyed();
    if (hasNext())
    {
      List localList = this.bodyListHttpData;
      int i = this.bodyListHttpDataRank;
      this.bodyListHttpDataRank = (i + 1);
      return (InterfaceHttpData)localList.get(i);
    }
    return null;
  }
  
  public HttpPostMultipartRequestDecoder offer(HttpContent paramHttpContent)
  {
    checkDestroyed();
    if ((paramHttpContent instanceof LastHttpContent)) {
      this.isLastChunk = true;
    }
    ByteBuf localByteBuf = paramHttpContent.content();
    paramHttpContent = this.undecodedChunk;
    if (paramHttpContent == null)
    {
      if (this.isLastChunk) {
        paramHttpContent = localByteBuf.retainedSlice();
      } else {
        paramHttpContent = localByteBuf.alloc().buffer(localByteBuf.readableBytes()).writeBytes(localByteBuf);
      }
      this.undecodedChunk = paramHttpContent;
    }
    else
    {
      paramHttpContent.writeBytes(localByteBuf);
    }
    parseBody();
    paramHttpContent = this.undecodedChunk;
    if ((paramHttpContent != null) && (paramHttpContent.writerIndex() > this.discardThreshold)) {
      this.undecodedChunk.discardReadBytes();
    }
    return this;
  }
  
  public void removeHttpDataFromClean(InterfaceHttpData paramInterfaceHttpData)
  {
    checkDestroyed();
    this.factory.removeHttpDataFromClean(this.request, paramInterfaceHttpData);
  }
  
  public void setDiscardThreshold(int paramInt)
  {
    this.discardThreshold = ObjectUtil.checkPositiveOrZero(paramInt, "discardThreshold");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\multipart\HttpPostMultipartRequestDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */