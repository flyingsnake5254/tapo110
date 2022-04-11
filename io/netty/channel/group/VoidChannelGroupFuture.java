package io.netty.channel.group;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

final class VoidChannelGroupFuture
  implements ChannelGroupFuture
{
  private static final Iterator<ChannelFuture> EMPTY = Collections.emptyList().iterator();
  private final ChannelGroup group;
  
  VoidChannelGroupFuture(ChannelGroup paramChannelGroup)
  {
    this.group = paramChannelGroup;
  }
  
  private static RuntimeException reject()
  {
    return new IllegalStateException("void future");
  }
  
  public ChannelGroupFuture addListener(GenericFutureListener<? extends Future<? super Void>> paramGenericFutureListener)
  {
    throw reject();
  }
  
  public ChannelGroupFuture addListeners(GenericFutureListener<? extends Future<? super Void>>... paramVarArgs)
  {
    throw reject();
  }
  
  public ChannelGroupFuture await()
  {
    throw reject();
  }
  
  public boolean await(long paramLong)
  {
    throw reject();
  }
  
  public boolean await(long paramLong, TimeUnit paramTimeUnit)
  {
    throw reject();
  }
  
  public ChannelGroupFuture awaitUninterruptibly()
  {
    throw reject();
  }
  
  public boolean awaitUninterruptibly(long paramLong)
  {
    throw reject();
  }
  
  public boolean awaitUninterruptibly(long paramLong, TimeUnit paramTimeUnit)
  {
    throw reject();
  }
  
  public boolean cancel(boolean paramBoolean)
  {
    return false;
  }
  
  public ChannelGroupException cause()
  {
    return null;
  }
  
  public ChannelFuture find(Channel paramChannel)
  {
    return null;
  }
  
  public Void get()
  {
    throw reject();
  }
  
  public Void get(long paramLong, TimeUnit paramTimeUnit)
  {
    throw reject();
  }
  
  public Void getNow()
  {
    return null;
  }
  
  public ChannelGroup group()
  {
    return this.group;
  }
  
  public boolean isCancellable()
  {
    return false;
  }
  
  public boolean isCancelled()
  {
    return false;
  }
  
  public boolean isDone()
  {
    return false;
  }
  
  public boolean isPartialFailure()
  {
    return false;
  }
  
  public boolean isPartialSuccess()
  {
    return false;
  }
  
  public boolean isSuccess()
  {
    return false;
  }
  
  public Iterator<ChannelFuture> iterator()
  {
    return EMPTY;
  }
  
  public ChannelGroupFuture removeListener(GenericFutureListener<? extends Future<? super Void>> paramGenericFutureListener)
  {
    throw reject();
  }
  
  public ChannelGroupFuture removeListeners(GenericFutureListener<? extends Future<? super Void>>... paramVarArgs)
  {
    throw reject();
  }
  
  public ChannelGroupFuture sync()
  {
    throw reject();
  }
  
  public ChannelGroupFuture syncUninterruptibly()
  {
    throw reject();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\group\VoidChannelGroupFuture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */