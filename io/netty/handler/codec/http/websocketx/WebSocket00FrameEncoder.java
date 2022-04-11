package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.DefaultByteBufHolder;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler.a;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.util.ReferenceCounted;
import java.util.List;

@ChannelHandler.a
public class WebSocket00FrameEncoder
  extends MessageToMessageEncoder<WebSocketFrame>
  implements b
{
  private static final ByteBuf _0X00 = Unpooled.unreleasableBuffer(Unpooled.directBuffer(1, 1).writeByte(0));
  private static final ByteBuf _0XFF = Unpooled.unreleasableBuffer(Unpooled.directBuffer(1, 1).writeByte(-1));
  private static final ByteBuf _0XFF_0X00 = Unpooled.unreleasableBuffer(Unpooled.directBuffer(2, 2).writeByte(-1).writeByte(0));
  
  protected void encode(ChannelHandlerContext paramChannelHandlerContext, WebSocketFrame paramWebSocketFrame, List<Object> paramList)
    throws Exception
  {
    int i;
    if ((paramWebSocketFrame instanceof TextWebSocketFrame))
    {
      paramChannelHandlerContext = paramWebSocketFrame.content();
      paramList.add(_0X00.duplicate());
      paramList.add(paramChannelHandlerContext.retain());
      paramList.add(_0XFF.duplicate());
    }
    else if ((paramWebSocketFrame instanceof CloseWebSocketFrame))
    {
      paramList.add(_0XFF_0X00.duplicate());
    }
    else
    {
      paramWebSocketFrame = paramWebSocketFrame.content();
      i = paramWebSocketFrame.readableBytes();
      paramChannelHandlerContext = paramChannelHandlerContext.alloc().buffer(5);
    }
    try
    {
      paramChannelHandlerContext.writeByte(-128);
      int j = i >>> 28 & 0x7F;
      int k = i >>> 14 & 0x7F;
      int m = i >>> 7 & 0x7F;
      i &= 0x7F;
      if (j == 0)
      {
        if (k == 0)
        {
          if (m == 0)
          {
            paramChannelHandlerContext.writeByte(i);
          }
          else
          {
            paramChannelHandlerContext.writeByte(m | 0x80);
            paramChannelHandlerContext.writeByte(i);
          }
        }
        else
        {
          paramChannelHandlerContext.writeByte(k | 0x80);
          paramChannelHandlerContext.writeByte(m | 0x80);
          paramChannelHandlerContext.writeByte(i);
        }
      }
      else
      {
        paramChannelHandlerContext.writeByte(j | 0x80);
        paramChannelHandlerContext.writeByte(k | 0x80);
        paramChannelHandlerContext.writeByte(m | 0x80);
        paramChannelHandlerContext.writeByte(i);
      }
      paramList.add(paramChannelHandlerContext);
      return;
    }
    finally
    {
      paramChannelHandlerContext.release();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\websocketx\WebSocket00FrameEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */