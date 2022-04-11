package io.netty.channel;

import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.ProgressiveFuture;

public abstract interface ChannelProgressiveFuture
  extends ChannelFuture, ProgressiveFuture<Void>
{
  public abstract ChannelProgressiveFuture addListener(GenericFutureListener<? extends Future<? super Void>> paramGenericFutureListener);
  
  public abstract ChannelProgressiveFuture addListeners(GenericFutureListener<? extends Future<? super Void>>... paramVarArgs);
  
  public abstract ChannelProgressiveFuture await()
    throws InterruptedException;
  
  public abstract ChannelProgressiveFuture awaitUninterruptibly();
  
  public abstract ChannelProgressiveFuture removeListener(GenericFutureListener<? extends Future<? super Void>> paramGenericFutureListener);
  
  public abstract ChannelProgressiveFuture removeListeners(GenericFutureListener<? extends Future<? super Void>>... paramVarArgs);
  
  public abstract ChannelProgressiveFuture sync()
    throws InterruptedException;
  
  public abstract ChannelProgressiveFuture syncUninterruptibly();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\ChannelProgressiveFuture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */