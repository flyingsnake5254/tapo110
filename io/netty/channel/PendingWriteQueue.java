package io.netty.channel;

import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.Promise;
import io.netty.util.concurrent.PromiseCombiner;
import io.netty.util.internal.ObjectPool;
import io.netty.util.internal.ObjectPool.Handle;
import io.netty.util.internal.ObjectPool.ObjectCreator;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

public final class PendingWriteQueue
{
  private static final int PENDING_WRITE_OVERHEAD = SystemPropertyUtil.getInt("io.netty.transport.pendingWriteSizeOverhead", 64);
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(PendingWriteQueue.class);
  private long bytes;
  private final ChannelHandlerContext ctx;
  private PendingWrite head;
  private int size;
  private PendingWrite tail;
  private final PendingBytesTracker tracker;
  
  public PendingWriteQueue(ChannelHandlerContext paramChannelHandlerContext)
  {
    this.tracker = PendingBytesTracker.newTracker(paramChannelHandlerContext.channel());
    this.ctx = paramChannelHandlerContext;
  }
  
  private void assertEmpty() {}
  
  private void recycle(PendingWrite paramPendingWrite, boolean paramBoolean)
  {
    PendingWrite localPendingWrite = paramPendingWrite.next;
    long l = paramPendingWrite.size;
    if (paramBoolean) {
      if (localPendingWrite == null)
      {
        this.tail = null;
        this.head = null;
        this.size = 0;
        this.bytes = 0L;
      }
      else
      {
        this.head = localPendingWrite;
        this.size -= 1;
        this.bytes -= l;
      }
    }
    paramPendingWrite.recycle();
    this.tracker.decrementPendingOutboundBytes(l);
  }
  
  private static void safeFail(ChannelPromise paramChannelPromise, Throwable paramThrowable)
  {
    if ((!(paramChannelPromise instanceof VoidChannelPromise)) && (!paramChannelPromise.tryFailure(paramThrowable))) {
      logger.warn("Failed to mark a promise as failure because it's done already: {}", paramChannelPromise, paramThrowable);
    }
  }
  
  private int size(Object paramObject)
  {
    int i = this.tracker.size(paramObject);
    int j = i;
    if (i < 0) {
      j = 0;
    }
    return j + PENDING_WRITE_OVERHEAD;
  }
  
  public void add(Object paramObject, ChannelPromise paramChannelPromise)
  {
    ObjectUtil.checkNotNull(paramObject, "msg");
    ObjectUtil.checkNotNull(paramChannelPromise, "promise");
    int i = size(paramObject);
    paramChannelPromise = PendingWrite.newInstance(paramObject, i, paramChannelPromise);
    paramObject = this.tail;
    if (paramObject == null)
    {
      this.head = paramChannelPromise;
      this.tail = paramChannelPromise;
    }
    else
    {
      PendingWrite.access$002((PendingWrite)paramObject, paramChannelPromise);
      this.tail = paramChannelPromise;
    }
    this.size += 1;
    this.bytes += i;
    this.tracker.incrementPendingOutboundBytes(paramChannelPromise.size);
  }
  
  public long bytes()
  {
    return this.bytes;
  }
  
  public Object current()
  {
    PendingWrite localPendingWrite = this.head;
    if (localPendingWrite == null) {
      return null;
    }
    return localPendingWrite.msg;
  }
  
  public boolean isEmpty()
  {
    boolean bool;
    if (this.head == null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public ChannelPromise remove()
  {
    PendingWrite localPendingWrite = this.head;
    if (localPendingWrite == null) {
      return null;
    }
    ChannelPromise localChannelPromise = localPendingWrite.promise;
    ReferenceCountUtil.safeRelease(localPendingWrite.msg);
    recycle(localPendingWrite, true);
    return localChannelPromise;
  }
  
  public void removeAndFail(Throwable paramThrowable)
  {
    ObjectUtil.checkNotNull(paramThrowable, "cause");
    PendingWrite localPendingWrite = this.head;
    if (localPendingWrite == null) {
      return;
    }
    ReferenceCountUtil.safeRelease(localPendingWrite.msg);
    safeFail(localPendingWrite.promise, paramThrowable);
    recycle(localPendingWrite, true);
  }
  
  public void removeAndFailAll(Throwable paramThrowable)
  {
    ObjectUtil.checkNotNull(paramThrowable, "cause");
    for (;;)
    {
      Object localObject = this.head;
      if (localObject == null) {
        break;
      }
      this.tail = null;
      this.head = null;
      this.size = 0;
      this.bytes = 0L;
      while (localObject != null)
      {
        PendingWrite localPendingWrite = ((PendingWrite)localObject).next;
        ReferenceCountUtil.safeRelease(((PendingWrite)localObject).msg);
        ChannelPromise localChannelPromise = ((PendingWrite)localObject).promise;
        recycle((PendingWrite)localObject, false);
        safeFail(localChannelPromise, paramThrowable);
        localObject = localPendingWrite;
      }
    }
    assertEmpty();
  }
  
  public ChannelFuture removeAndWrite()
  {
    PendingWrite localPendingWrite = this.head;
    if (localPendingWrite == null) {
      return null;
    }
    Object localObject = localPendingWrite.msg;
    ChannelPromise localChannelPromise = localPendingWrite.promise;
    recycle(localPendingWrite, true);
    return this.ctx.write(localObject, localChannelPromise);
  }
  
  public ChannelFuture removeAndWriteAll()
  {
    if (isEmpty()) {
      return null;
    }
    ChannelPromise localChannelPromise1 = this.ctx.newPromise();
    PromiseCombiner localPromiseCombiner = new PromiseCombiner(this.ctx.executor());
    try
    {
      Object localObject1 = this.head;
      if (localObject1 != null)
      {
        this.tail = null;
        this.head = null;
        this.size = 0;
        this.bytes = 0L;
        while (localObject1 != null)
        {
          PendingWrite localPendingWrite = ((PendingWrite)localObject1).next;
          Object localObject2 = ((PendingWrite)localObject1).msg;
          ChannelPromise localChannelPromise2 = ((PendingWrite)localObject1).promise;
          recycle((PendingWrite)localObject1, false);
          if (!(localChannelPromise2 instanceof VoidChannelPromise)) {
            localPromiseCombiner.add(localChannelPromise2);
          }
          this.ctx.write(localObject2, localChannelPromise2);
          localObject1 = localPendingWrite;
        }
      }
      localPromiseCombiner.finish(localChannelPromise1);
    }
    finally
    {
      localChannelPromise1.setFailure(localThrowable);
    }
    assertEmpty();
    return localChannelPromise1;
  }
  
  public int size()
  {
    return this.size;
  }
  
  static final class PendingWrite
  {
    private static final ObjectPool<PendingWrite> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator()
    {
      public PendingWriteQueue.PendingWrite newObject(ObjectPool.Handle<PendingWriteQueue.PendingWrite> paramAnonymousHandle)
      {
        return new PendingWriteQueue.PendingWrite(paramAnonymousHandle, null);
      }
    });
    private final ObjectPool.Handle<PendingWrite> handle;
    private Object msg;
    private PendingWrite next;
    private ChannelPromise promise;
    private long size;
    
    private PendingWrite(ObjectPool.Handle<PendingWrite> paramHandle)
    {
      this.handle = paramHandle;
    }
    
    static PendingWrite newInstance(Object paramObject, int paramInt, ChannelPromise paramChannelPromise)
    {
      PendingWrite localPendingWrite = (PendingWrite)RECYCLER.get();
      localPendingWrite.size = paramInt;
      localPendingWrite.msg = paramObject;
      localPendingWrite.promise = paramChannelPromise;
      return localPendingWrite;
    }
    
    private void recycle()
    {
      this.size = 0L;
      this.next = null;
      this.msg = null;
      this.promise = null;
      this.handle.recycle(this);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\PendingWriteQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */