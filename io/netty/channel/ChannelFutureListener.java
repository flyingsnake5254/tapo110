package io.netty.channel;

import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

public abstract interface ChannelFutureListener
  extends GenericFutureListener<ChannelFuture>
{
  public static final ChannelFutureListener CLOSE = new ChannelFutureListener()
  {
    public void operationComplete(ChannelFuture paramAnonymousChannelFuture)
    {
      paramAnonymousChannelFuture.channel().close();
    }
  };
  public static final ChannelFutureListener CLOSE_ON_FAILURE = new ChannelFutureListener()
  {
    public void operationComplete(ChannelFuture paramAnonymousChannelFuture)
    {
      if (!paramAnonymousChannelFuture.isSuccess()) {
        paramAnonymousChannelFuture.channel().close();
      }
    }
  };
  public static final ChannelFutureListener FIRE_EXCEPTION_ON_FAILURE = new ChannelFutureListener()
  {
    public void operationComplete(ChannelFuture paramAnonymousChannelFuture)
    {
      if (!paramAnonymousChannelFuture.isSuccess()) {
        paramAnonymousChannelFuture.channel().pipeline().fireExceptionCaught(paramAnonymousChannelFuture.cause());
      }
    }
  };
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\ChannelFutureListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */