package io.netty.channel;

import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

public abstract interface ChannelFuture
  extends Future<Void>
{
  public abstract ChannelFuture addListener(GenericFutureListener<? extends Future<? super Void>> paramGenericFutureListener);
  
  public abstract ChannelFuture addListeners(GenericFutureListener<? extends Future<? super Void>>... paramVarArgs);
  
  public abstract ChannelFuture await()
    throws InterruptedException;
  
  public abstract ChannelFuture awaitUninterruptibly();
  
  public abstract Channel channel();
  
  public abstract boolean isVoid();
  
  public abstract ChannelFuture removeListener(GenericFutureListener<? extends Future<? super Void>> paramGenericFutureListener);
  
  public abstract ChannelFuture removeListeners(GenericFutureListener<? extends Future<? super Void>>... paramVarArgs);
  
  public abstract ChannelFuture sync()
    throws InterruptedException;
  
  public abstract ChannelFuture syncUninterruptibly();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\ChannelFuture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */