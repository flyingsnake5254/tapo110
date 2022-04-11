package io.netty.channel;

import io.netty.util.concurrent.AbstractFuture;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ObjectUtil;
import java.util.concurrent.TimeUnit;

public final class VoidChannelPromise
  extends AbstractFuture<Void>
  implements ChannelPromise
{
  private final Channel channel;
  private final ChannelFutureListener fireExceptionListener;
  
  public VoidChannelPromise(Channel paramChannel, boolean paramBoolean)
  {
    ObjectUtil.checkNotNull(paramChannel, "channel");
    this.channel = paramChannel;
    if (paramBoolean) {
      this.fireExceptionListener = new ChannelFutureListener()
      {
        public void operationComplete(ChannelFuture paramAnonymousChannelFuture)
          throws Exception
        {
          paramAnonymousChannelFuture = paramAnonymousChannelFuture.cause();
          if (paramAnonymousChannelFuture != null) {
            VoidChannelPromise.this.fireException0(paramAnonymousChannelFuture);
          }
        }
      };
    } else {
      this.fireExceptionListener = null;
    }
  }
  
  private static void fail()
  {
    throw new IllegalStateException("void future");
  }
  
  private void fireException0(Throwable paramThrowable)
  {
    if ((this.fireExceptionListener != null) && (this.channel.isRegistered())) {
      this.channel.pipeline().fireExceptionCaught(paramThrowable);
    }
  }
  
  public VoidChannelPromise addListener(GenericFutureListener<? extends Future<? super Void>> paramGenericFutureListener)
  {
    fail();
    return this;
  }
  
  public VoidChannelPromise addListeners(GenericFutureListener<? extends Future<? super Void>>... paramVarArgs)
  {
    fail();
    return this;
  }
  
  public VoidChannelPromise await()
    throws InterruptedException
  {
    if (!Thread.interrupted()) {
      return this;
    }
    throw new InterruptedException();
  }
  
  public boolean await(long paramLong)
  {
    fail();
    return false;
  }
  
  public boolean await(long paramLong, TimeUnit paramTimeUnit)
  {
    fail();
    return false;
  }
  
  public VoidChannelPromise awaitUninterruptibly()
  {
    fail();
    return this;
  }
  
  public boolean awaitUninterruptibly(long paramLong)
  {
    fail();
    return false;
  }
  
  public boolean awaitUninterruptibly(long paramLong, TimeUnit paramTimeUnit)
  {
    fail();
    return false;
  }
  
  public boolean cancel(boolean paramBoolean)
  {
    return false;
  }
  
  public Throwable cause()
  {
    return null;
  }
  
  public Channel channel()
  {
    return this.channel;
  }
  
  public Void getNow()
  {
    return null;
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
  
  public boolean isSuccess()
  {
    return false;
  }
  
  public boolean isVoid()
  {
    return true;
  }
  
  public VoidChannelPromise removeListener(GenericFutureListener<? extends Future<? super Void>> paramGenericFutureListener)
  {
    return this;
  }
  
  public VoidChannelPromise removeListeners(GenericFutureListener<? extends Future<? super Void>>... paramVarArgs)
  {
    return this;
  }
  
  public VoidChannelPromise setFailure(Throwable paramThrowable)
  {
    fireException0(paramThrowable);
    return this;
  }
  
  public VoidChannelPromise setSuccess()
  {
    return this;
  }
  
  public VoidChannelPromise setSuccess(Void paramVoid)
  {
    return this;
  }
  
  public boolean setUncancellable()
  {
    return true;
  }
  
  public VoidChannelPromise sync()
  {
    fail();
    return this;
  }
  
  public VoidChannelPromise syncUninterruptibly()
  {
    fail();
    return this;
  }
  
  public boolean tryFailure(Throwable paramThrowable)
  {
    fireException0(paramThrowable);
    return false;
  }
  
  public boolean trySuccess()
  {
    return false;
  }
  
  public boolean trySuccess(Void paramVoid)
  {
    return false;
  }
  
  public ChannelPromise unvoid()
  {
    DefaultChannelPromise localDefaultChannelPromise = new DefaultChannelPromise(this.channel);
    ChannelFutureListener localChannelFutureListener = this.fireExceptionListener;
    if (localChannelFutureListener != null) {
      localDefaultChannelPromise.addListener(localChannelFutureListener);
    }
    return localDefaultChannelPromise;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\VoidChannelPromise.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */