package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.DefaultByteBufHolder;
import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandler;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.ChannelPromise;
import io.netty.channel.ChannelPromiseNotifier;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.EventExecutorGroup;
import io.netty.util.concurrent.Promise;
import io.netty.util.concurrent.c;
import java.net.SocketAddress;
import java.nio.channels.ClosedChannelException;
import java.util.List;
import java.util.concurrent.TimeUnit;

abstract class WebSocketProtocolHandler
  extends MessageToMessageDecoder<WebSocketFrame>
  implements ChannelOutboundHandler
{
  private ChannelPromise closeSent;
  private final WebSocketCloseStatus closeStatus;
  private final boolean dropPongFrames;
  private final long forceCloseTimeoutMillis;
  
  WebSocketProtocolHandler()
  {
    this(true);
  }
  
  WebSocketProtocolHandler(boolean paramBoolean)
  {
    this(paramBoolean, null, 0L);
  }
  
  WebSocketProtocolHandler(boolean paramBoolean, WebSocketCloseStatus paramWebSocketCloseStatus, long paramLong)
  {
    this.dropPongFrames = paramBoolean;
    this.closeStatus = paramWebSocketCloseStatus;
    this.forceCloseTimeoutMillis = paramLong;
  }
  
  private void applyCloseSentTimeout(final ChannelHandlerContext paramChannelHandlerContext)
  {
    if ((!this.closeSent.isDone()) && (this.forceCloseTimeoutMillis >= 0L))
    {
      paramChannelHandlerContext = paramChannelHandlerContext.executor().schedule(new Runnable()
      {
        public void run()
        {
          if (!WebSocketProtocolHandler.this.closeSent.isDone()) {
            WebSocketProtocolHandler.this.closeSent.tryFailure(new WebSocketHandshakeException("send close frame timed out"));
          }
        }
      }, this.forceCloseTimeoutMillis, TimeUnit.MILLISECONDS);
      this.closeSent.addListener(new ChannelFutureListener()
      {
        public void operationComplete(ChannelFuture paramAnonymousChannelFuture)
        {
          paramChannelHandlerContext.cancel(false);
        }
      });
    }
  }
  
  private static void readIfNeeded(ChannelHandlerContext paramChannelHandlerContext)
  {
    if (!paramChannelHandlerContext.channel().config().isAutoRead()) {
      paramChannelHandlerContext.read();
    }
  }
  
  public void bind(ChannelHandlerContext paramChannelHandlerContext, SocketAddress paramSocketAddress, ChannelPromise paramChannelPromise)
    throws Exception
  {
    paramChannelHandlerContext.bind(paramSocketAddress, paramChannelPromise);
  }
  
  public void close(final ChannelHandlerContext paramChannelHandlerContext, final ChannelPromise paramChannelPromise)
    throws Exception
  {
    if ((this.closeStatus != null) && (paramChannelHandlerContext.channel().isActive()))
    {
      if (this.closeSent == null) {
        write(paramChannelHandlerContext, new CloseWebSocketFrame(this.closeStatus), paramChannelHandlerContext.newPromise());
      }
      flush(paramChannelHandlerContext);
      applyCloseSentTimeout(paramChannelHandlerContext);
      this.closeSent.addListener(new ChannelFutureListener()
      {
        public void operationComplete(ChannelFuture paramAnonymousChannelFuture)
        {
          paramChannelHandlerContext.close(paramChannelPromise);
        }
      });
    }
    else
    {
      paramChannelHandlerContext.close(paramChannelPromise);
    }
  }
  
  public void connect(ChannelHandlerContext paramChannelHandlerContext, SocketAddress paramSocketAddress1, SocketAddress paramSocketAddress2, ChannelPromise paramChannelPromise)
    throws Exception
  {
    paramChannelHandlerContext.connect(paramSocketAddress1, paramSocketAddress2, paramChannelPromise);
  }
  
  protected void decode(ChannelHandlerContext paramChannelHandlerContext, WebSocketFrame paramWebSocketFrame, List<Object> paramList)
    throws Exception
  {
    if ((paramWebSocketFrame instanceof PingWebSocketFrame))
    {
      paramWebSocketFrame.content().retain();
      paramChannelHandlerContext.channel().writeAndFlush(new PongWebSocketFrame(paramWebSocketFrame.content()));
      readIfNeeded(paramChannelHandlerContext);
      return;
    }
    if (((paramWebSocketFrame instanceof PongWebSocketFrame)) && (this.dropPongFrames))
    {
      readIfNeeded(paramChannelHandlerContext);
      return;
    }
    paramList.add(paramWebSocketFrame.retain());
  }
  
  public void deregister(ChannelHandlerContext paramChannelHandlerContext, ChannelPromise paramChannelPromise)
    throws Exception
  {
    paramChannelHandlerContext.deregister(paramChannelPromise);
  }
  
  public void disconnect(ChannelHandlerContext paramChannelHandlerContext, ChannelPromise paramChannelPromise)
    throws Exception
  {
    paramChannelHandlerContext.disconnect(paramChannelPromise);
  }
  
  public void exceptionCaught(ChannelHandlerContext paramChannelHandlerContext, Throwable paramThrowable)
    throws Exception
  {
    paramChannelHandlerContext.fireExceptionCaught(paramThrowable);
    paramChannelHandlerContext.close();
  }
  
  public void flush(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    paramChannelHandlerContext.flush();
  }
  
  public void read(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    paramChannelHandlerContext.read();
  }
  
  public void write(ChannelHandlerContext paramChannelHandlerContext, Object paramObject, ChannelPromise paramChannelPromise)
    throws Exception
  {
    if (this.closeSent != null)
    {
      ReferenceCountUtil.release(paramObject);
      paramChannelPromise.setFailure(new ClosedChannelException());
    }
    else if ((paramObject instanceof CloseWebSocketFrame))
    {
      this.closeSent = paramChannelPromise.unvoid();
      paramChannelHandlerContext.write(paramObject).addListener(new ChannelPromiseNotifier(false, new ChannelPromise[] { this.closeSent }));
    }
    else
    {
      paramChannelHandlerContext.write(paramObject, paramChannelPromise);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\websocketx\WebSocketProtocolHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */