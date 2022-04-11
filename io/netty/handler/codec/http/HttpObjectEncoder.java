package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufHolder;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.FileRegion;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.StringUtil;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public abstract class HttpObjectEncoder<H extends HttpMessage>
  extends MessageToMessageEncoder<Object>
{
  private static final ByteBuf CRLF_BUF;
  static final int CRLF_SHORT = 3338;
  private static final float HEADERS_WEIGHT_HISTORICAL = 0.8F;
  private static final float HEADERS_WEIGHT_NEW = 0.2F;
  private static final int ST_CONTENT_ALWAYS_EMPTY = 3;
  private static final int ST_CONTENT_CHUNK = 2;
  private static final int ST_CONTENT_NON_CHUNK = 1;
  private static final int ST_INIT = 0;
  private static final float TRAILERS_WEIGHT_HISTORICAL = 0.8F;
  private static final float TRAILERS_WEIGHT_NEW = 0.2F;
  private static final byte[] ZERO_CRLF_CRLF;
  private static final ByteBuf ZERO_CRLF_CRLF_BUF;
  private static final int ZERO_CRLF_MEDIUM = 3149066;
  private float headersEncodedSizeAccumulator = 256.0F;
  private int state = 0;
  private float trailersEncodedSizeAccumulator = 256.0F;
  
  static
  {
    byte[] arrayOfByte = new byte[5];
    arrayOfByte[0] = 48;
    arrayOfByte[1] = 13;
    arrayOfByte[2] = 10;
    arrayOfByte[3] = 13;
    arrayOfByte[4] = 10;
    arrayOfByte;
    ZERO_CRLF_CRLF = arrayOfByte;
    CRLF_BUF = Unpooled.unreleasableBuffer(Unpooled.directBuffer(2).writeByte(13).writeByte(10));
    ZERO_CRLF_CRLF_BUF = Unpooled.unreleasableBuffer(Unpooled.directBuffer(arrayOfByte.length).writeBytes(arrayOfByte));
  }
  
  private static long contentLength(Object paramObject)
  {
    if ((paramObject instanceof HttpContent)) {
      return ((HttpContent)paramObject).content().readableBytes();
    }
    if ((paramObject instanceof ByteBuf)) {
      return ((ByteBuf)paramObject).readableBytes();
    }
    if ((paramObject instanceof FileRegion)) {
      return ((FileRegion)paramObject).count();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unexpected message type: ");
    localStringBuilder.append(StringUtil.simpleClassName(paramObject));
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  private static Object encodeAndRetain(Object paramObject)
  {
    if ((paramObject instanceof ByteBuf)) {
      return ((ByteBuf)paramObject).retain();
    }
    if ((paramObject instanceof HttpContent)) {
      return ((HttpContent)paramObject).content().retain();
    }
    if ((paramObject instanceof FileRegion)) {
      return ((FileRegion)paramObject).retain();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unexpected message type: ");
    localStringBuilder.append(StringUtil.simpleClassName(paramObject));
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  @Deprecated
  protected static void encodeAscii(String paramString, ByteBuf paramByteBuf)
  {
    paramByteBuf.writeCharSequence(paramString, CharsetUtil.US_ASCII);
  }
  
  private void encodeChunkedContent(ChannelHandlerContext paramChannelHandlerContext, Object paramObject, long paramLong, List<Object> paramList)
  {
    boolean bool = paramLong < 0L;
    if (bool)
    {
      String str = Long.toHexString(paramLong);
      ByteBuf localByteBuf = paramChannelHandlerContext.alloc().buffer(str.length() + 2);
      localByteBuf.writeCharSequence(str, CharsetUtil.US_ASCII);
      ByteBufUtil.writeShortBE(localByteBuf, 3338);
      paramList.add(localByteBuf);
      paramList.add(encodeAndRetain(paramObject));
      paramList.add(CRLF_BUF.duplicate());
    }
    if ((paramObject instanceof LastHttpContent))
    {
      paramObject = ((LastHttpContent)paramObject).trailingHeaders();
      if (((HttpHeaders)paramObject).isEmpty())
      {
        paramList.add(ZERO_CRLF_CRLF_BUF.duplicate());
      }
      else
      {
        paramChannelHandlerContext = paramChannelHandlerContext.alloc().buffer((int)this.trailersEncodedSizeAccumulator);
        ByteBufUtil.writeMediumBE(paramChannelHandlerContext, 3149066);
        encodeHeaders((HttpHeaders)paramObject, paramChannelHandlerContext);
        ByteBufUtil.writeShortBE(paramChannelHandlerContext, 3338);
        this.trailersEncodedSizeAccumulator = (padSizeForAccumulation(paramChannelHandlerContext.readableBytes()) * 0.2F + this.trailersEncodedSizeAccumulator * 0.8F);
        paramList.add(paramChannelHandlerContext);
      }
    }
    else if (!bool)
    {
      paramList.add(encodeAndRetain(paramObject));
    }
  }
  
  private static int padSizeForAccumulation(int paramInt)
  {
    return (paramInt << 2) / 3;
  }
  
  public boolean acceptOutboundMessage(Object paramObject)
    throws Exception
  {
    boolean bool;
    if ((!(paramObject instanceof HttpObject)) && (!(paramObject instanceof ByteBuf)) && (!(paramObject instanceof FileRegion))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  protected void encode(ChannelHandlerContext paramChannelHandlerContext, Object paramObject, List<Object> paramList)
    throws Exception
  {
    Object localObject;
    ByteBuf localByteBuf;
    int i;
    if ((paramObject instanceof HttpMessage))
    {
      if (this.state == 0)
      {
        localObject = (HttpMessage)paramObject;
        localByteBuf = paramChannelHandlerContext.alloc().buffer((int)this.headersEncodedSizeAccumulator);
        encodeInitialLine(localByteBuf, (HttpMessage)localObject);
        if (isContentAlwaysEmpty((HttpMessage)localObject)) {
          i = 3;
        } else if (HttpUtil.isTransferEncodingChunked((HttpMessage)localObject)) {
          i = 2;
        } else {
          i = 1;
        }
        this.state = i;
        if (i == 3) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        sanitizeHeadersBeforeEncode((HttpMessage)localObject, bool1);
        encodeHeaders(((HttpMessage)localObject).headers(), localByteBuf);
        ByteBufUtil.writeShortBE(localByteBuf, 3338);
        this.headersEncodedSizeAccumulator = (padSizeForAccumulation(localByteBuf.readableBytes()) * 0.2F + this.headersEncodedSizeAccumulator * 0.8F);
      }
      else
      {
        paramChannelHandlerContext = new StringBuilder();
        paramChannelHandlerContext.append("unexpected message type: ");
        paramChannelHandlerContext.append(StringUtil.simpleClassName(paramObject));
        paramChannelHandlerContext.append(", state: ");
        paramChannelHandlerContext.append(this.state);
        throw new IllegalStateException(paramChannelHandlerContext.toString());
      }
    }
    else {
      localByteBuf = null;
    }
    boolean bool2 = paramObject instanceof ByteBuf;
    if (bool2)
    {
      localObject = (ByteBuf)paramObject;
      if (!((ByteBuf)localObject).isReadable())
      {
        paramList.add(((ByteBuf)localObject).retain());
        return;
      }
    }
    boolean bool1 = paramObject instanceof HttpContent;
    if ((!bool1) && (!bool2) && (!(paramObject instanceof FileRegion)))
    {
      if (localByteBuf != null) {
        paramList.add(localByteBuf);
      }
    }
    else
    {
      i = this.state;
      if (i == 0) {
        break label502;
      }
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            throw new Error();
          }
        }
        else
        {
          if (localByteBuf != null) {
            paramList.add(localByteBuf);
          }
          encodeChunkedContent(paramChannelHandlerContext, paramObject, contentLength(paramObject), paramList);
          break label489;
        }
      }
      else
      {
        long l = contentLength(paramObject);
        if (l > 0L)
        {
          if ((localByteBuf != null) && (localByteBuf.writableBytes() >= l) && (bool1))
          {
            localByteBuf.writeBytes(((HttpContent)paramObject).content());
            paramList.add(localByteBuf);
          }
          else
          {
            if (localByteBuf != null) {
              paramList.add(localByteBuf);
            }
            paramList.add(encodeAndRetain(paramObject));
          }
          if (!(paramObject instanceof LastHttpContent)) {
            break label489;
          }
          this.state = 0;
          break label489;
        }
      }
      if (localByteBuf != null) {
        paramList.add(localByteBuf);
      } else {
        paramList.add(Unpooled.EMPTY_BUFFER);
      }
      label489:
      if ((paramObject instanceof LastHttpContent)) {
        this.state = 0;
      }
    }
    return;
    label502:
    paramChannelHandlerContext = new StringBuilder();
    paramChannelHandlerContext.append("unexpected message type: ");
    paramChannelHandlerContext.append(StringUtil.simpleClassName(paramObject));
    throw new IllegalStateException(paramChannelHandlerContext.toString());
  }
  
  protected void encodeHeaders(HttpHeaders paramHttpHeaders, ByteBuf paramByteBuf)
  {
    Iterator localIterator = paramHttpHeaders.iteratorCharSequence();
    while (localIterator.hasNext())
    {
      paramHttpHeaders = (Map.Entry)localIterator.next();
      HttpHeadersEncoder.encoderHeader((CharSequence)paramHttpHeaders.getKey(), (CharSequence)paramHttpHeaders.getValue(), paramByteBuf);
    }
  }
  
  protected abstract void encodeInitialLine(ByteBuf paramByteBuf, H paramH)
    throws Exception;
  
  protected boolean isContentAlwaysEmpty(H paramH)
  {
    return false;
  }
  
  protected void sanitizeHeadersBeforeEncode(H paramH, boolean paramBoolean) {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\HttpObjectEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */