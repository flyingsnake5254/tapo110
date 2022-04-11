package io.netty.channel;

import io.netty.util.concurrent.Promise;
import io.netty.util.internal.ObjectUtil;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

public final class ChannelFlushPromiseNotifier
{
  private final Queue<FlushCheckpoint> flushCheckpoints = new ArrayDeque();
  private final boolean tryNotify;
  private long writeCounter;
  
  public ChannelFlushPromiseNotifier()
  {
    this(false);
  }
  
  public ChannelFlushPromiseNotifier(boolean paramBoolean)
  {
    this.tryNotify = paramBoolean;
  }
  
  private void notifyPromises0(Throwable paramThrowable)
  {
    if (this.flushCheckpoints.isEmpty())
    {
      this.writeCounter = 0L;
      return;
    }
    long l = this.writeCounter;
    for (;;)
    {
      Object localObject = (FlushCheckpoint)this.flushCheckpoints.peek();
      if (localObject == null)
      {
        this.writeCounter = 0L;
      }
      else
      {
        if (((FlushCheckpoint)localObject).flushCheckpoint() <= l) {
          break label170;
        }
        if ((l > 0L) && (this.flushCheckpoints.size() == 1))
        {
          this.writeCounter = 0L;
          ((FlushCheckpoint)localObject).flushCheckpoint(((FlushCheckpoint)localObject).flushCheckpoint() - l);
        }
      }
      l = this.writeCounter;
      if (l >= 549755813888L)
      {
        this.writeCounter = 0L;
        paramThrowable = this.flushCheckpoints.iterator();
        while (paramThrowable.hasNext())
        {
          localObject = (FlushCheckpoint)paramThrowable.next();
          ((FlushCheckpoint)localObject).flushCheckpoint(((FlushCheckpoint)localObject).flushCheckpoint() - l);
        }
      }
      return;
      label170:
      this.flushCheckpoints.remove();
      localObject = ((FlushCheckpoint)localObject).promise();
      if (paramThrowable == null)
      {
        if (this.tryNotify) {
          ((ChannelPromise)localObject).trySuccess();
        } else {
          ((ChannelPromise)localObject).setSuccess();
        }
      }
      else if (this.tryNotify) {
        ((Promise)localObject).tryFailure(paramThrowable);
      } else {
        ((ChannelPromise)localObject).setFailure(paramThrowable);
      }
    }
  }
  
  @Deprecated
  public ChannelFlushPromiseNotifier add(ChannelPromise paramChannelPromise, int paramInt)
  {
    return add(paramChannelPromise, paramInt);
  }
  
  public ChannelFlushPromiseNotifier add(ChannelPromise paramChannelPromise, long paramLong)
  {
    ObjectUtil.checkNotNull(paramChannelPromise, "promise");
    ObjectUtil.checkPositiveOrZero(paramLong, "pendingDataSize");
    paramLong = this.writeCounter + paramLong;
    if ((paramChannelPromise instanceof FlushCheckpoint))
    {
      paramChannelPromise = (FlushCheckpoint)paramChannelPromise;
      paramChannelPromise.flushCheckpoint(paramLong);
      this.flushCheckpoints.add(paramChannelPromise);
    }
    else
    {
      this.flushCheckpoints.add(new DefaultFlushCheckpoint(paramLong, paramChannelPromise));
    }
    return this;
  }
  
  public ChannelFlushPromiseNotifier increaseWriteCounter(long paramLong)
  {
    ObjectUtil.checkPositiveOrZero(paramLong, "delta");
    this.writeCounter += paramLong;
    return this;
  }
  
  @Deprecated
  public ChannelFlushPromiseNotifier notifyFlushFutures()
  {
    return notifyPromises();
  }
  
  @Deprecated
  public ChannelFlushPromiseNotifier notifyFlushFutures(Throwable paramThrowable)
  {
    return notifyPromises(paramThrowable);
  }
  
  @Deprecated
  public ChannelFlushPromiseNotifier notifyFlushFutures(Throwable paramThrowable1, Throwable paramThrowable2)
  {
    return notifyPromises(paramThrowable1, paramThrowable2);
  }
  
  public ChannelFlushPromiseNotifier notifyPromises()
  {
    notifyPromises0(null);
    return this;
  }
  
  public ChannelFlushPromiseNotifier notifyPromises(Throwable paramThrowable)
  {
    notifyPromises();
    for (;;)
    {
      FlushCheckpoint localFlushCheckpoint = (FlushCheckpoint)this.flushCheckpoints.poll();
      if (localFlushCheckpoint == null) {
        return this;
      }
      if (this.tryNotify) {
        localFlushCheckpoint.promise().tryFailure(paramThrowable);
      } else {
        localFlushCheckpoint.promise().setFailure(paramThrowable);
      }
    }
  }
  
  public ChannelFlushPromiseNotifier notifyPromises(Throwable paramThrowable1, Throwable paramThrowable2)
  {
    notifyPromises0(paramThrowable1);
    for (;;)
    {
      paramThrowable1 = (FlushCheckpoint)this.flushCheckpoints.poll();
      if (paramThrowable1 == null) {
        return this;
      }
      if (this.tryNotify) {
        paramThrowable1.promise().tryFailure(paramThrowable2);
      } else {
        paramThrowable1.promise().setFailure(paramThrowable2);
      }
    }
  }
  
  public long writeCounter()
  {
    return this.writeCounter;
  }
  
  private static class DefaultFlushCheckpoint
    implements ChannelFlushPromiseNotifier.FlushCheckpoint
  {
    private long checkpoint;
    private final ChannelPromise future;
    
    DefaultFlushCheckpoint(long paramLong, ChannelPromise paramChannelPromise)
    {
      this.checkpoint = paramLong;
      this.future = paramChannelPromise;
    }
    
    public long flushCheckpoint()
    {
      return this.checkpoint;
    }
    
    public void flushCheckpoint(long paramLong)
    {
      this.checkpoint = paramLong;
    }
    
    public ChannelPromise promise()
    {
      return this.future;
    }
  }
  
  static abstract interface FlushCheckpoint
  {
    public abstract long flushCheckpoint();
    
    public abstract void flushCheckpoint(long paramLong);
    
    public abstract ChannelPromise promise();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\ChannelFlushPromiseNotifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */