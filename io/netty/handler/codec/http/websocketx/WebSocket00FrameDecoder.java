package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.ReplayingDecoder;
import io.netty.handler.codec.TooLongFrameException;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

public class WebSocket00FrameDecoder
  extends ReplayingDecoder<Void>
  implements a
{
  static final int DEFAULT_MAX_FRAME_SIZE = 16384;
  private final long maxFrameSize;
  private boolean receivedClosingHandshake;
  
  public WebSocket00FrameDecoder()
  {
    this(16384);
  }
  
  public WebSocket00FrameDecoder(int paramInt)
  {
    this.maxFrameSize = paramInt;
  }
  
  public WebSocket00FrameDecoder(WebSocketDecoderConfig paramWebSocketDecoderConfig)
  {
    this.maxFrameSize = ((WebSocketDecoderConfig)ObjectUtil.checkNotNull(paramWebSocketDecoderConfig, "decoderConfig")).maxFramePayloadLength();
  }
  
  private WebSocketFrame decodeBinaryFrame(ChannelHandlerContext paramChannelHandlerContext, byte paramByte, ByteBuf paramByteBuf)
  {
    long l1 = 0L;
    int i = 0;
    int j;
    long l2;
    do
    {
      j = paramByteBuf.readByte();
      l2 = l1 << 7 | j & 0x7F;
      if (l2 > this.maxFrameSize) {
        break label130;
      }
      i++;
      if (i > 8) {
        break;
      }
      l1 = l2;
    } while ((j & 0x80) == 128);
    if ((paramByte == -1) && (l2 == 0L))
    {
      this.receivedClosingHandshake = true;
      return new CloseWebSocketFrame(true, 0, paramChannelHandlerContext.alloc().buffer(0));
    }
    return new BinaryWebSocketFrame(ByteBufUtil.readBytes(paramChannelHandlerContext.alloc(), paramByteBuf, (int)l2));
    throw new TooLongFrameException();
    label130:
    throw new TooLongFrameException();
  }
  
  private WebSocketFrame decodeTextFrame(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf)
  {
    int i = paramByteBuf.readerIndex();
    int j = actualReadableBytes();
    int k = paramByteBuf.indexOf(i, i + j, (byte)-1);
    if (k == -1)
    {
      if (j <= this.maxFrameSize) {
        return null;
      }
      throw new TooLongFrameException();
    }
    k -= i;
    if (k <= this.maxFrameSize)
    {
      paramChannelHandlerContext = ByteBufUtil.readBytes(paramChannelHandlerContext.alloc(), paramByteBuf, k);
      paramByteBuf.skipBytes(1);
      if (paramChannelHandlerContext.indexOf(paramChannelHandlerContext.readerIndex(), paramChannelHandlerContext.writerIndex(), (byte)-1) < 0) {
        return new TextWebSocketFrame(paramChannelHandlerContext);
      }
      paramChannelHandlerContext.release();
      throw new IllegalArgumentException("a text frame should not contain 0xFF.");
    }
    throw new TooLongFrameException();
  }
  
  protected void decode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, List<Object> paramList)
    throws Exception
  {
    if (this.receivedClosingHandshake)
    {
      paramByteBuf.skipBytes(actualReadableBytes());
      return;
    }
    int i = paramByteBuf.readByte();
    if ((i & 0x80) == 128) {
      paramChannelHandlerContext = decodeBinaryFrame(paramChannelHandlerContext, i, paramByteBuf);
    } else {
      paramChannelHandlerContext = decodeTextFrame(paramChannelHandlerContext, paramByteBuf);
    }
    if (paramChannelHandlerContext != null) {
      paramList.add(paramChannelHandlerContext);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\websocketx\WebSocket00FrameDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */