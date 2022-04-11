package io.netty.handler.codec.http.multipart;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufHolder;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.LastHttpContent;
import io.netty.handler.codec.http.QueryStringDecoder;
import io.netty.util.ByteProcessor;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class HttpPostStandardRequestDecoder
  implements InterfaceHttpPostRequestDecoder
{
  private final List<InterfaceHttpData> bodyListHttpData = new ArrayList();
  private int bodyListHttpDataRank;
  private final Map<String, List<InterfaceHttpData>> bodyMapHttpData = new TreeMap(CaseIgnoringComparator.INSTANCE);
  private final Charset charset;
  private Attribute currentAttribute;
  private HttpPostRequestDecoder.MultiPartStatus currentStatus = HttpPostRequestDecoder.MultiPartStatus.NOTSTARTED;
  private boolean destroyed;
  private int discardThreshold = 10485760;
  private final HttpDataFactory factory;
  private boolean isLastChunk;
  private final HttpRequest request;
  private ByteBuf undecodedChunk;
  
  public HttpPostStandardRequestDecoder(HttpRequest paramHttpRequest)
  {
    this(new DefaultHttpDataFactory(16384L), paramHttpRequest, HttpConstants.DEFAULT_CHARSET);
  }
  
  public HttpPostStandardRequestDecoder(HttpDataFactory paramHttpDataFactory, HttpRequest paramHttpRequest)
  {
    this(paramHttpDataFactory, paramHttpRequest, HttpConstants.DEFAULT_CHARSET);
  }
  
  public HttpPostStandardRequestDecoder(HttpDataFactory paramHttpDataFactory, HttpRequest paramHttpRequest, Charset paramCharset)
  {
    this.request = ((HttpRequest)ObjectUtil.checkNotNull(paramHttpRequest, "request"));
    this.charset = ((Charset)ObjectUtil.checkNotNull(paramCharset, "charset"));
    this.factory = ((HttpDataFactory)ObjectUtil.checkNotNull(paramHttpDataFactory, "factory"));
    try
    {
      if ((paramHttpRequest instanceof HttpContent)) {
        offer((HttpContent)paramHttpRequest);
      } else {
        parseBody();
      }
    }
    finally
    {
      destroy();
      PlatformDependent.throwException(paramHttpDataFactory);
    }
  }
  
  private void checkDestroyed()
  {
    if (!this.destroyed) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HttpPostStandardRequestDecoder.class.getSimpleName());
    localStringBuilder.append(" was destroyed already");
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  private static ByteBuf decodeAttribute(ByteBuf paramByteBuf, Charset paramCharset)
  {
    if (paramByteBuf.forEachByte(new UrlEncodedDetector(null)) == -1) {
      return null;
    }
    ByteBuf localByteBuf = paramByteBuf.alloc().buffer(paramByteBuf.readableBytes());
    UrlDecoder localUrlDecoder = new UrlDecoder(localByteBuf);
    int i = paramByteBuf.forEachByte(localUrlDecoder);
    if (localUrlDecoder.nextEscapedIdx != 0)
    {
      int j = i;
      if (i == -1) {
        j = paramByteBuf.readableBytes() - 1;
      }
      i = localUrlDecoder.nextEscapedIdx;
      localByteBuf.release();
      throw new HttpPostRequestDecoder.ErrorDataDecoderException(String.format("Invalid hex byte at index '%d' in string: '%s'", new Object[] { Integer.valueOf(j - (i - 1)), paramByteBuf.toString(paramCharset) }));
    }
    return localByteBuf;
  }
  
  private static String decodeAttribute(String paramString, Charset paramCharset)
  {
    try
    {
      paramCharset = QueryStringDecoder.decodeComponent(paramString, paramCharset);
      return paramCharset;
    }
    catch (IllegalArgumentException paramCharset)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Bad string: '");
      localStringBuilder.append(paramString);
      localStringBuilder.append('\'');
      throw new HttpPostRequestDecoder.ErrorDataDecoderException(localStringBuilder.toString(), paramCharset);
    }
  }
  
  private void parseBody()
  {
    HttpPostRequestDecoder.MultiPartStatus localMultiPartStatus = this.currentStatus;
    if ((localMultiPartStatus != HttpPostRequestDecoder.MultiPartStatus.PREEPILOGUE) && (localMultiPartStatus != HttpPostRequestDecoder.MultiPartStatus.EPILOGUE))
    {
      parseBodyAttributes();
      return;
    }
    if (this.isLastChunk) {
      this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.EPILOGUE;
    }
  }
  
  private void parseBodyAttributes()
  {
    Object localObject1 = this.undecodedChunk;
    if (localObject1 == null) {
      return;
    }
    if (!((ByteBuf)localObject1).hasArray())
    {
      parseBodyAttributesStandard();
      return;
    }
    localObject1 = new HttpPostBodyUtil.SeekAheadOptimize(this.undecodedChunk);
    int i = this.undecodedChunk.readerIndex();
    int j = i;
    if (this.currentStatus == HttpPostRequestDecoder.MultiPartStatus.NOTSTARTED)
    {
      this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.DISPOSITION;
      j = i;
    }
    for (;;)
    {
      i = j;
      int k = j;
      label68:
      int m = i;
      int n = i;
      int i1 = i;
      try
      {
        int i2 = ((HttpPostBodyUtil.SeekAheadOptimize)localObject1).pos;
        m = i;
        n = i;
        i1 = i;
        int i3 = ((HttpPostBodyUtil.SeekAheadOptimize)localObject1).limit;
        int i4 = 1;
        j = k;
        int i5 = i;
        if (i2 < i3)
        {
          m = i;
          n = i;
          i1 = i;
          Object localObject2 = ((HttpPostBodyUtil.SeekAheadOptimize)localObject1).bytes;
          m = i;
          n = i;
          i1 = i;
          ((HttpPostBodyUtil.SeekAheadOptimize)localObject1).pos = (i2 + 1);
          i5 = (char)(localObject2[i2] & 0xFF);
          j = k + 1;
          m = i;
          n = i;
          i1 = i;
          k = 1.$SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus[this.currentStatus.ordinal()];
          if (k != 1)
          {
            if (k != 2)
            {
              m = i;
              n = i;
              i1 = i;
              ((HttpPostBodyUtil.SeekAheadOptimize)localObject1).setReadPosition(0);
            }
            for (;;)
            {
              i4 = 0;
              i5 = i;
              break label814;
              if (i5 == 38)
              {
                m = i;
                n = i;
                i1 = i;
                this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.DISPOSITION;
                m = i;
                n = i;
                i1 = i;
                setFinalBuffer(this.undecodedChunk.retainedSlice(i, j - 1 - i));
                break;
              }
              if (i5 == 13)
              {
                m = i;
                n = i;
                i1 = i;
                k = ((HttpPostBodyUtil.SeekAheadOptimize)localObject1).pos;
                m = i;
                n = i;
                i1 = i;
                i5 = ((HttpPostBodyUtil.SeekAheadOptimize)localObject1).limit;
                if (k < i5)
                {
                  m = i;
                  n = i;
                  i1 = i;
                  localObject2 = ((HttpPostBodyUtil.SeekAheadOptimize)localObject1).bytes;
                  m = i;
                  n = i;
                  i1 = i;
                  ((HttpPostBodyUtil.SeekAheadOptimize)localObject1).pos = (k + 1);
                  i5 = (char)(localObject2[k] & 0xFF);
                  j++;
                  if (i5 == 10)
                  {
                    m = i;
                    n = i;
                    i1 = i;
                    this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.PREEPILOGUE;
                    m = i;
                    n = i;
                    i1 = i;
                    ((HttpPostBodyUtil.SeekAheadOptimize)localObject1).setReadPosition(0);
                    m = i;
                    n = i;
                    i1 = i;
                    setFinalBuffer(this.undecodedChunk.retainedSlice(i, j - 2 - i));
                    break label565;
                  }
                  m = i;
                  n = i;
                  i1 = i;
                  ((HttpPostBodyUtil.SeekAheadOptimize)localObject1).setReadPosition(0);
                  m = i;
                  n = i;
                  i1 = i;
                  localObject1 = new io/netty/handler/codec/http/multipart/HttpPostRequestDecoder$ErrorDataDecoderException;
                  m = i;
                  n = i;
                  i1 = i;
                  ((HttpPostRequestDecoder.ErrorDataDecoderException)localObject1).<init>("Bad end of line");
                  m = i;
                  n = i;
                  i1 = i;
                  throw ((Throwable)localObject1);
                }
                k = j;
                if (i5 <= 0) {
                  break label68;
                }
                k = j - 1;
                break label68;
              }
              k = j;
              if (i5 != 10) {
                break label68;
              }
              m = i;
              n = i;
              i1 = i;
              this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.PREEPILOGUE;
              m = i;
              n = i;
              i1 = i;
              ((HttpPostBodyUtil.SeekAheadOptimize)localObject1).setReadPosition(0);
              m = i;
              n = i;
              i1 = i;
              setFinalBuffer(this.undecodedChunk.retainedSlice(i, j - 1 - i));
              label565:
              i = j;
            }
          }
          if (i5 == 61)
          {
            m = i;
            n = i;
            i1 = i;
            this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.FIELD;
            m = i;
            n = i;
            i1 = i;
            localObject2 = decodeAttribute(this.undecodedChunk.toString(i, j - 1 - i, this.charset), this.charset);
            m = i;
            n = i;
            i1 = i;
            this.currentAttribute = this.factory.createAttribute(this.request, (String)localObject2);
            continue;
          }
          k = j;
          if (i5 != 38) {
            break label68;
          }
          m = i;
          n = i;
          i1 = i;
          this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.DISPOSITION;
          m = i;
          n = i;
          i1 = i;
          localObject2 = decodeAttribute(this.undecodedChunk.toString(i, j - 1 - i, this.charset), this.charset);
          m = i;
          n = i;
          i1 = i;
          localObject2 = this.factory.createAttribute(this.request, (String)localObject2);
          m = i;
          n = i;
          i1 = i;
          this.currentAttribute = ((Attribute)localObject2);
          m = i;
          n = i;
          i1 = i;
          ((Attribute)localObject2).setValue("");
          m = i;
          n = i;
          i1 = i;
          addHttpData(this.currentAttribute);
          m = i;
          n = i;
          i1 = i;
          this.currentAttribute = null;
          continue;
        }
        label814:
        m = i5;
        n = i5;
        i1 = i5;
        if (this.isLastChunk)
        {
          m = i5;
          n = i5;
          i1 = i5;
          localObject1 = this.currentAttribute;
          if (localObject1 != null)
          {
            if (j > i5)
            {
              m = i5;
              n = i5;
              i1 = i5;
              setFinalBuffer(this.undecodedChunk.retainedSlice(i5, j - i5));
            }
            else
            {
              m = i5;
              n = i5;
              i1 = i5;
              if (!((HttpData)localObject1).isCompleted())
              {
                m = i5;
                n = i5;
                i1 = i5;
                setFinalBuffer(Unpooled.EMPTY_BUFFER);
              }
            }
            try
            {
              this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.EPILOGUE;
            }
            catch (IllegalArgumentException localIllegalArgumentException1)
            {
              break label1074;
            }
            catch (IOException localIOException1)
            {
              n = j;
              break label1093;
            }
            catch (HttpPostRequestDecoder.ErrorDataDecoderException localErrorDataDecoderException1)
            {
              i1 = j;
              break label1113;
            }
          }
        }
        i = i5;
        if (i4 != 0)
        {
          m = i5;
          n = i5;
          i1 = i5;
          Attribute localAttribute = this.currentAttribute;
          i = i5;
          if (localAttribute != null)
          {
            i = i5;
            m = i5;
            n = i5;
            i1 = i5;
            if (this.currentStatus == HttpPostRequestDecoder.MultiPartStatus.FIELD)
            {
              m = i5;
              n = i5;
              i1 = i5;
              localAttribute.addContent(this.undecodedChunk.retainedSlice(i5, j - i5), false);
              i = j;
            }
          }
        }
        m = i;
        n = i;
        i1 = i;
        this.undecodedChunk.readerIndex(i);
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException2)
      {
        j = m;
        this.undecodedChunk.readerIndex(j);
        throw new HttpPostRequestDecoder.ErrorDataDecoderException(localIllegalArgumentException2);
      }
      catch (IOException localIOException2)
      {
        this.undecodedChunk.readerIndex(n);
        throw new HttpPostRequestDecoder.ErrorDataDecoderException(localIOException2);
      }
      catch (HttpPostRequestDecoder.ErrorDataDecoderException localErrorDataDecoderException2)
      {
        label1074:
        label1093:
        label1113:
        this.undecodedChunk.readerIndex(i1);
        throw localErrorDataDecoderException2;
      }
    }
  }
  
  private void parseBodyAttributesStandard()
  {
    int i = this.undecodedChunk.readerIndex();
    if (this.currentStatus == HttpPostRequestDecoder.MultiPartStatus.NOTSTARTED) {
      this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.DISPOSITION;
    }
    int j;
    for (;;)
    {
      j = i;
      int k = 1;
      try
      {
        label29:
        int n;
        Object localObject;
        for (;;)
        {
          if ((this.undecodedChunk.isReadable()) && (k != 0))
          {
            int m = (char)this.undecodedChunk.readUnsignedByte();
            n = i + 1;
            i = 1.$SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus[this.currentStatus.ordinal()];
            if (i != 1)
            {
              if (i != 2) {}
              for (i = n;; i = n)
              {
                k = 0;
                break label29;
                if (m == 38)
                {
                  this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.DISPOSITION;
                  setFinalBuffer(this.undecodedChunk.retainedSlice(j, n - 1 - j));
                  i = n;
                  break;
                }
                if (m == 13)
                {
                  if (this.undecodedChunk.isReadable())
                  {
                    i = (char)this.undecodedChunk.readUnsignedByte();
                    n++;
                    if (i == 10)
                    {
                      this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.PREEPILOGUE;
                      setFinalBuffer(this.undecodedChunk.retainedSlice(j, n - 2 - j));
                      break label248;
                    }
                    localObject = new io/netty/handler/codec/http/multipart/HttpPostRequestDecoder$ErrorDataDecoderException;
                    ((HttpPostRequestDecoder.ErrorDataDecoderException)localObject).<init>("Bad end of line");
                    throw ((Throwable)localObject);
                  }
                  i = n - 1;
                  break label29;
                }
                i = n;
                if (m != 10) {
                  break label29;
                }
                this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.PREEPILOGUE;
                setFinalBuffer(this.undecodedChunk.retainedSlice(j, n - 1 - j));
                label248:
                j = n;
              }
            }
            if (m == 61)
            {
              this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.FIELD;
              localObject = decodeAttribute(this.undecodedChunk.toString(j, n - 1 - j, this.charset), this.charset);
              this.currentAttribute = this.factory.createAttribute(this.request, (String)localObject);
              j = n;
              i = n;
            }
            else
            {
              i = n;
              if (m == 38)
              {
                this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.DISPOSITION;
                localObject = decodeAttribute(this.undecodedChunk.toString(j, n - 1 - j, this.charset), this.charset);
                localObject = this.factory.createAttribute(this.request, (String)localObject);
                this.currentAttribute = ((Attribute)localObject);
                ((Attribute)localObject).setValue("");
                addHttpData(this.currentAttribute);
                this.currentAttribute = null;
                i = n;
                break;
              }
            }
          }
        }
        if (this.isLastChunk)
        {
          localObject = this.currentAttribute;
          if (localObject != null)
          {
            if (i > j) {
              setFinalBuffer(this.undecodedChunk.retainedSlice(j, i - j));
            } else if (!((HttpData)localObject).isCompleted()) {
              setFinalBuffer(Unpooled.EMPTY_BUFFER);
            }
            n = i;
            j = i;
            k = i;
          }
        }
        try
        {
          this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.EPILOGUE;
          break label546;
          if (k != 0)
          {
            localObject = this.currentAttribute;
            if ((localObject != null) && (this.currentStatus == HttpPostRequestDecoder.MultiPartStatus.FIELD))
            {
              ((HttpData)localObject).addContent(this.undecodedChunk.retainedSlice(j, i - j), false);
              break label546;
            }
          }
          i = j;
          label546:
          n = i;
          j = i;
          k = i;
          this.undecodedChunk.readerIndex(i);
          return;
        }
        catch (IllegalArgumentException localIllegalArgumentException1)
        {
          j = n;
        }
        catch (IOException localIOException1) {}catch (HttpPostRequestDecoder.ErrorDataDecoderException localErrorDataDecoderException1)
        {
          j = k;
        }
        this.undecodedChunk.readerIndex(j);
      }
      catch (IllegalArgumentException localIllegalArgumentException2)
      {
        this.undecodedChunk.readerIndex(j);
        throw new HttpPostRequestDecoder.ErrorDataDecoderException(localIllegalArgumentException2);
      }
      catch (IOException localIOException2)
      {
        this.undecodedChunk.readerIndex(j);
        throw new HttpPostRequestDecoder.ErrorDataDecoderException(localIOException2);
      }
      catch (HttpPostRequestDecoder.ErrorDataDecoderException localErrorDataDecoderException2) {}
    }
    throw localErrorDataDecoderException2;
  }
  
  private void setFinalBuffer(ByteBuf paramByteBuf)
    throws IOException
  {
    this.currentAttribute.addContent(paramByteBuf, true);
    paramByteBuf = decodeAttribute(this.currentAttribute.getByteBuf(), this.charset);
    if (paramByteBuf != null) {
      this.currentAttribute.setContent(paramByteBuf);
    }
    addHttpData(this.currentAttribute);
    this.currentAttribute = null;
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
    return false;
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
  
  public HttpPostStandardRequestDecoder offer(HttpContent paramHttpContent)
  {
    checkDestroyed();
    if ((paramHttpContent instanceof LastHttpContent)) {
      this.isLastChunk = true;
    }
    paramHttpContent = paramHttpContent.content();
    ByteBuf localByteBuf = this.undecodedChunk;
    if (localByteBuf == null)
    {
      if (this.isLastChunk) {
        paramHttpContent = paramHttpContent.retainedSlice();
      } else {
        paramHttpContent = paramHttpContent.alloc().buffer(paramHttpContent.readableBytes()).writeBytes(paramHttpContent);
      }
      this.undecodedChunk = paramHttpContent;
    }
    else
    {
      localByteBuf.writeBytes(paramHttpContent);
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
  
  private static final class UrlDecoder
    implements ByteProcessor
  {
    private byte hiByte;
    private int nextEscapedIdx;
    private final ByteBuf output;
    
    UrlDecoder(ByteBuf paramByteBuf)
    {
      this.output = paramByteBuf;
    }
    
    public boolean process(byte paramByte)
    {
      int i = this.nextEscapedIdx;
      if (i != 0)
      {
        if (i == 1)
        {
          this.hiByte = ((byte)paramByte);
          this.nextEscapedIdx = (i + 1);
        }
        else
        {
          i = StringUtil.decodeHexNibble((char)this.hiByte);
          paramByte = StringUtil.decodeHexNibble((char)paramByte);
          if ((i != -1) && (paramByte != -1))
          {
            this.output.writeByte((i << 4) + paramByte);
            this.nextEscapedIdx = 0;
          }
          else
          {
            this.nextEscapedIdx += 1;
            return false;
          }
        }
      }
      else if (paramByte == 37) {
        this.nextEscapedIdx = 1;
      } else if (paramByte == 43) {
        this.output.writeByte(32);
      } else {
        this.output.writeByte(paramByte);
      }
      return true;
    }
  }
  
  private static final class UrlEncodedDetector
    implements ByteProcessor
  {
    public boolean process(byte paramByte)
      throws Exception
    {
      boolean bool;
      if ((paramByte != 37) && (paramByte != 43)) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\multipart\HttpPostStandardRequestDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */