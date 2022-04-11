package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.DefaultByteBufHolder;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.handler.codec.CorruptedFrameException;

public class Utf8FrameValidator
  extends ChannelInboundHandlerAdapter
{
  private int fragmentedFramesCount;
  private Utf8Validator utf8Validator;
  
  private void checkUTF8String(ByteBuf paramByteBuf)
  {
    if (this.utf8Validator == null) {
      this.utf8Validator = new Utf8Validator();
    }
    this.utf8Validator.check(paramByteBuf);
  }
  
  public void channelRead(ChannelHandlerContext paramChannelHandlerContext, Object paramObject)
    throws Exception
  {
    if ((paramObject instanceof WebSocketFrame))
    {
      WebSocketFrame localWebSocketFrame = (WebSocketFrame)paramObject;
      try
      {
        Utf8Validator localUtf8Validator;
        if (((WebSocketFrame)paramObject).isFinalFragment())
        {
          if (!(localWebSocketFrame instanceof PingWebSocketFrame))
          {
            this.fragmentedFramesCount = 0;
            if (!(localWebSocketFrame instanceof TextWebSocketFrame))
            {
              localUtf8Validator = this.utf8Validator;
              if ((localUtf8Validator == null) || (!localUtf8Validator.isChecking())) {}
            }
            else
            {
              checkUTF8String(localWebSocketFrame.content());
              this.utf8Validator.finish();
            }
          }
        }
        else
        {
          if (this.fragmentedFramesCount == 0)
          {
            if ((localWebSocketFrame instanceof TextWebSocketFrame)) {
              checkUTF8String(localWebSocketFrame.content());
            }
          }
          else
          {
            localUtf8Validator = this.utf8Validator;
            if ((localUtf8Validator != null) && (localUtf8Validator.isChecking())) {
              checkUTF8String(localWebSocketFrame.content());
            }
          }
          this.fragmentedFramesCount += 1;
        }
      }
      catch (CorruptedWebSocketFrameException paramChannelHandlerContext)
      {
        localWebSocketFrame.release();
        throw paramChannelHandlerContext;
      }
    }
    super.channelRead(paramChannelHandlerContext, paramObject);
  }
  
  public void exceptionCaught(ChannelHandlerContext paramChannelHandlerContext, Throwable paramThrowable)
    throws Exception
  {
    if (((paramThrowable instanceof CorruptedFrameException)) && (paramChannelHandlerContext.channel().isOpen())) {
      paramChannelHandlerContext.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
    }
    super.exceptionCaught(paramChannelHandlerContext, paramThrowable);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\websocketx\Utf8FrameValidator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */