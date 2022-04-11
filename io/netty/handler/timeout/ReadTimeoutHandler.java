package io.netty.handler.timeout;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundInvoker;
import java.util.concurrent.TimeUnit;

public class ReadTimeoutHandler
  extends IdleStateHandler
{
  private boolean closed;
  
  public ReadTimeoutHandler(int paramInt)
  {
    this(paramInt, TimeUnit.SECONDS);
  }
  
  public ReadTimeoutHandler(long paramLong, TimeUnit paramTimeUnit)
  {
    super(paramLong, 0L, 0L, paramTimeUnit);
  }
  
  protected final void channelIdle(ChannelHandlerContext paramChannelHandlerContext, IdleStateEvent paramIdleStateEvent)
    throws Exception
  {
    readTimedOut(paramChannelHandlerContext);
  }
  
  protected void readTimedOut(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    if (!this.closed)
    {
      paramChannelHandlerContext.fireExceptionCaught(ReadTimeoutException.INSTANCE);
      paramChannelHandlerContext.close();
      this.closed = true;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\timeout\ReadTimeoutHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */