package io.netty.channel;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.buffer.Unpooled;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.concurrent.ProgressivePromise;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.InternalThreadLocalMap;
import io.netty.util.internal.ObjectPool;
import io.netty.util.internal.ObjectPool.Handle;
import io.netty.util.internal.ObjectPool.ObjectCreator;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PromiseNotificationUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.util.Arrays;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

public final class ChannelOutboundBuffer
{
  static final int CHANNEL_OUTBOUND_BUFFER_ENTRY_OVERHEAD = SystemPropertyUtil.getInt("io.netty.transport.outboundBufferEntrySizeOverhead", 96);
  private static final FastThreadLocal<ByteBuffer[]> NIO_BUFFERS = new FastThreadLocal()
  {
    protected ByteBuffer[] initialValue()
      throws Exception
    {
      return new ByteBuffer['Ѐ'];
    }
  };
  private static final AtomicLongFieldUpdater<ChannelOutboundBuffer> TOTAL_PENDING_SIZE_UPDATER = AtomicLongFieldUpdater.newUpdater(ChannelOutboundBuffer.class, "totalPendingSize");
  private static final AtomicIntegerFieldUpdater<ChannelOutboundBuffer> UNWRITABLE_UPDATER = AtomicIntegerFieldUpdater.newUpdater(ChannelOutboundBuffer.class, "unwritable");
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(ChannelOutboundBuffer.class);
  private final Channel channel;
  private volatile Runnable fireChannelWritabilityChangedTask;
  private int flushed;
  private Entry flushedEntry;
  private boolean inFail;
  private int nioBufferCount;
  private long nioBufferSize;
  private Entry tailEntry;
  private volatile long totalPendingSize;
  private Entry unflushedEntry;
  private volatile int unwritable;
  
  ChannelOutboundBuffer(AbstractChannel paramAbstractChannel)
  {
    this.channel = paramAbstractChannel;
  }
  
  private void clearNioBuffers()
  {
    int i = this.nioBufferCount;
    if (i > 0)
    {
      this.nioBufferCount = 0;
      Arrays.fill((Object[])NIO_BUFFERS.get(), 0, i, null);
    }
  }
  
  private void clearUserDefinedWritability(int paramInt)
  {
    paramInt = writabilityMask(paramInt);
    int i;
    int j;
    do
    {
      i = this.unwritable;
      j = i | paramInt;
    } while (!UNWRITABLE_UPDATER.compareAndSet(this, i, j));
    if ((i == 0) && (j != 0)) {
      fireChannelWritabilityChanged(true);
    }
  }
  
  private void decrementPendingOutboundBytes(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramLong == 0L) {
      return;
    }
    paramLong = TOTAL_PENDING_SIZE_UPDATER.addAndGet(this, -paramLong);
    if ((paramBoolean2) && (paramLong < this.channel.config().getWriteBufferLowWaterMark())) {
      setWritable(paramBoolean1);
    }
  }
  
  private static ByteBuffer[] expandNioBufferArray(ByteBuffer[] paramArrayOfByteBuffer, int paramInt1, int paramInt2)
  {
    int i = paramArrayOfByteBuffer.length;
    int j;
    do
    {
      j = i << 1;
      if (j < 0) {
        break;
      }
      i = j;
    } while (paramInt1 > j);
    ByteBuffer[] arrayOfByteBuffer = new ByteBuffer[j];
    System.arraycopy(paramArrayOfByteBuffer, 0, arrayOfByteBuffer, 0, paramInt2);
    return arrayOfByteBuffer;
    throw new IllegalStateException();
  }
  
  private void fireChannelWritabilityChanged(boolean paramBoolean)
  {
    final ChannelPipeline localChannelPipeline = this.channel.pipeline();
    if (paramBoolean)
    {
      Runnable localRunnable = this.fireChannelWritabilityChangedTask;
      Object localObject = localRunnable;
      if (localRunnable == null)
      {
        localObject = new Runnable()
        {
          public void run()
          {
            localChannelPipeline.fireChannelWritabilityChanged();
          }
        };
        this.fireChannelWritabilityChangedTask = ((Runnable)localObject);
      }
      this.channel.eventLoop().execute((Runnable)localObject);
    }
    else
    {
      localChannelPipeline.fireChannelWritabilityChanged();
    }
  }
  
  private void incrementPendingOutboundBytes(long paramLong, boolean paramBoolean)
  {
    if (paramLong == 0L) {
      return;
    }
    if (TOTAL_PENDING_SIZE_UPDATER.addAndGet(this, paramLong) > this.channel.config().getWriteBufferHighWaterMark()) {
      setUnwritable(paramBoolean);
    }
  }
  
  private boolean isFlushedEntry(Entry paramEntry)
  {
    boolean bool;
    if ((paramEntry != null) && (paramEntry != this.unflushedEntry)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static int nioBuffers(Entry paramEntry, ByteBuf paramByteBuf, ByteBuffer[] paramArrayOfByteBuffer, int paramInt1, int paramInt2)
  {
    ByteBuffer[] arrayOfByteBuffer1 = paramEntry.bufs;
    ByteBuffer[] arrayOfByteBuffer2 = arrayOfByteBuffer1;
    if (arrayOfByteBuffer1 == null)
    {
      arrayOfByteBuffer2 = paramByteBuf.nioBuffers();
      paramEntry.bufs = arrayOfByteBuffer2;
    }
    int i = 0;
    int j = paramInt1;
    for (paramInt1 = i; (paramInt1 < arrayOfByteBuffer2.length) && (j < paramInt2); paramInt1++)
    {
      paramEntry = arrayOfByteBuffer2[paramInt1];
      if (paramEntry == null) {
        break;
      }
      if (paramEntry.hasRemaining())
      {
        paramArrayOfByteBuffer[j] = paramEntry;
        j++;
      }
    }
    return j;
  }
  
  private boolean remove0(Throwable paramThrowable, boolean paramBoolean)
  {
    Entry localEntry = this.flushedEntry;
    if (localEntry == null)
    {
      clearNioBuffers();
      return false;
    }
    Object localObject = localEntry.msg;
    ChannelPromise localChannelPromise = localEntry.promise;
    int i = localEntry.pendingSize;
    removeEntry(localEntry);
    if (!localEntry.cancelled)
    {
      ReferenceCountUtil.safeRelease(localObject);
      safeFail(localChannelPromise, paramThrowable);
      decrementPendingOutboundBytes(i, false, paramBoolean);
    }
    localEntry.recycle();
    return true;
  }
  
  private void removeEntry(Entry paramEntry)
  {
    int i = this.flushed - 1;
    this.flushed = i;
    if (i == 0)
    {
      this.flushedEntry = null;
      if (paramEntry == this.tailEntry)
      {
        this.tailEntry = null;
        this.unflushedEntry = null;
      }
    }
    else
    {
      this.flushedEntry = paramEntry.next;
    }
  }
  
  private static void safeFail(ChannelPromise paramChannelPromise, Throwable paramThrowable)
  {
    InternalLogger localInternalLogger;
    if ((paramChannelPromise instanceof VoidChannelPromise)) {
      localInternalLogger = null;
    } else {
      localInternalLogger = logger;
    }
    PromiseNotificationUtil.tryFailure(paramChannelPromise, paramThrowable, localInternalLogger);
  }
  
  private static void safeSuccess(ChannelPromise paramChannelPromise)
  {
    InternalLogger localInternalLogger;
    if ((paramChannelPromise instanceof VoidChannelPromise)) {
      localInternalLogger = null;
    } else {
      localInternalLogger = logger;
    }
    PromiseNotificationUtil.trySuccess(paramChannelPromise, null, localInternalLogger);
  }
  
  private void setUnwritable(boolean paramBoolean)
  {
    int i;
    int j;
    do
    {
      i = this.unwritable;
      j = i | 0x1;
    } while (!UNWRITABLE_UPDATER.compareAndSet(this, i, j));
    if ((i == 0) && (j != 0)) {
      fireChannelWritabilityChanged(paramBoolean);
    }
  }
  
  private void setUserDefinedWritability(int paramInt)
  {
    int i = writabilityMask(paramInt);
    int j;
    do
    {
      j = this.unwritable;
      paramInt = j & (i ^ 0xFFFFFFFF);
    } while (!UNWRITABLE_UPDATER.compareAndSet(this, j, paramInt));
    if ((j != 0) && (paramInt == 0)) {
      fireChannelWritabilityChanged(true);
    }
  }
  
  private void setWritable(boolean paramBoolean)
  {
    int i;
    int j;
    do
    {
      i = this.unwritable;
      j = i & 0xFFFFFFFE;
    } while (!UNWRITABLE_UPDATER.compareAndSet(this, i, j));
    if ((i != 0) && (j == 0)) {
      fireChannelWritabilityChanged(paramBoolean);
    }
  }
  
  private static long total(Object paramObject)
  {
    if ((paramObject instanceof ByteBuf)) {
      return ((ByteBuf)paramObject).readableBytes();
    }
    if ((paramObject instanceof FileRegion)) {
      return ((FileRegion)paramObject).count();
    }
    if ((paramObject instanceof ByteBufHolder)) {
      return ((ByteBufHolder)paramObject).content().readableBytes();
    }
    return -1L;
  }
  
  private static int writabilityMask(int paramInt)
  {
    if ((paramInt >= 1) && (paramInt <= 31)) {
      return 1 << paramInt;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("index: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" (expected: 1~31)");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public void addFlush()
  {
    Entry localEntry1 = this.unflushedEntry;
    if (localEntry1 != null)
    {
      Entry localEntry2 = localEntry1;
      if (this.flushedEntry == null)
      {
        this.flushedEntry = localEntry1;
        localEntry2 = localEntry1;
      }
      do
      {
        this.flushed += 1;
        if (!localEntry2.promise.setUncancellable()) {
          decrementPendingOutboundBytes(localEntry2.cancel(), false, true);
        }
        localEntry1 = localEntry2.next;
        localEntry2 = localEntry1;
      } while (localEntry1 != null);
      this.unflushedEntry = null;
    }
  }
  
  public void addMessage(Object paramObject, int paramInt, ChannelPromise paramChannelPromise)
  {
    paramObject = Entry.newInstance(paramObject, paramInt, total(paramObject), paramChannelPromise);
    paramChannelPromise = this.tailEntry;
    if (paramChannelPromise == null) {
      this.flushedEntry = null;
    } else {
      paramChannelPromise.next = ((Entry)paramObject);
    }
    this.tailEntry = ((Entry)paramObject);
    if (this.unflushedEntry == null) {
      this.unflushedEntry = ((Entry)paramObject);
    }
    incrementPendingOutboundBytes(((Entry)paramObject).pendingSize, false);
  }
  
  public long bytesBeforeUnwritable()
  {
    long l = this.channel.config().getWriteBufferHighWaterMark() - this.totalPendingSize;
    if (l > 0L)
    {
      if (!isWritable()) {
        l = 0L;
      }
      return l;
    }
    return 0L;
  }
  
  public long bytesBeforeWritable()
  {
    long l = this.totalPendingSize - this.channel.config().getWriteBufferLowWaterMark();
    if (l > 0L)
    {
      if (isWritable()) {
        l = 0L;
      }
      return l;
    }
    return 0L;
  }
  
  void close(final Throwable paramThrowable, final boolean paramBoolean)
  {
    if (this.inFail)
    {
      this.channel.eventLoop().execute(new Runnable()
      {
        public void run()
        {
          ChannelOutboundBuffer.this.close(paramThrowable, paramBoolean);
        }
      });
      return;
    }
    this.inFail = true;
    if ((!paramBoolean) && (this.channel.isOpen())) {
      throw new IllegalStateException("close() must be invoked after the channel is closed.");
    }
    if (isEmpty()) {
      try
      {
        for (Entry localEntry = this.unflushedEntry; localEntry != null; localEntry = localEntry.recycleAndGetNext())
        {
          int i = localEntry.pendingSize;
          TOTAL_PENDING_SIZE_UPDATER.addAndGet(this, -i);
          if (!localEntry.cancelled)
          {
            ReferenceCountUtil.safeRelease(localEntry.msg);
            safeFail(localEntry.promise, paramThrowable);
          }
        }
        this.inFail = false;
        clearNioBuffers();
        return;
      }
      finally
      {
        this.inFail = false;
      }
    }
    throw new IllegalStateException("close() must be invoked after all flushed writes are handled.");
  }
  
  void close(ClosedChannelException paramClosedChannelException)
  {
    close(paramClosedChannelException, false);
  }
  
  public Object current()
  {
    Entry localEntry = this.flushedEntry;
    if (localEntry == null) {
      return null;
    }
    return localEntry.msg;
  }
  
  public long currentProgress()
  {
    Entry localEntry = this.flushedEntry;
    if (localEntry == null) {
      return 0L;
    }
    return localEntry.progress;
  }
  
  void decrementPendingOutboundBytes(long paramLong)
  {
    decrementPendingOutboundBytes(paramLong, true, true);
  }
  
  void failFlushed(Throwable paramThrowable, boolean paramBoolean)
  {
    if (this.inFail) {
      return;
    }
    try
    {
      this.inFail = true;
      boolean bool;
      do
      {
        bool = remove0(paramThrowable, paramBoolean);
      } while (bool);
      return;
    }
    finally
    {
      this.inFail = false;
    }
  }
  
  public void forEachFlushedMessage(MessageProcessor paramMessageProcessor)
    throws Exception
  {
    ObjectUtil.checkNotNull(paramMessageProcessor, "processor");
    Entry localEntry1 = this.flushedEntry;
    Entry localEntry2 = localEntry1;
    if (localEntry1 == null) {
      return;
    }
    do
    {
      if ((!localEntry2.cancelled) && (!paramMessageProcessor.processMessage(localEntry2.msg))) {
        return;
      }
      localEntry1 = localEntry2.next;
      localEntry2 = localEntry1;
    } while (isFlushedEntry(localEntry1));
  }
  
  public boolean getUserDefinedWritability(int paramInt)
  {
    int i = this.unwritable;
    boolean bool;
    if ((writabilityMask(paramInt) & i) == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  void incrementPendingOutboundBytes(long paramLong)
  {
    incrementPendingOutboundBytes(paramLong, true);
  }
  
  public boolean isEmpty()
  {
    boolean bool;
    if (this.flushed == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isWritable()
  {
    boolean bool;
    if (this.unwritable == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public int nioBufferCount()
  {
    return this.nioBufferCount;
  }
  
  public long nioBufferSize()
  {
    return this.nioBufferSize;
  }
  
  public ByteBuffer[] nioBuffers()
  {
    return nioBuffers(Integer.MAX_VALUE, 2147483647L);
  }
  
  public ByteBuffer[] nioBuffers(int paramInt, long paramLong)
  {
    long l1 = 0L;
    int i = 0;
    InternalThreadLocalMap localInternalThreadLocalMap = InternalThreadLocalMap.get();
    Object localObject1 = (ByteBuffer[])NIO_BUFFERS.get(localInternalThreadLocalMap);
    Entry localEntry = this.flushedEntry;
    long l2;
    int j;
    Object localObject2;
    for (;;)
    {
      l2 = l1;
      j = i;
      localObject2 = localObject1;
      if (!isFlushedEntry(localEntry)) {
        break;
      }
      Object localObject3 = localEntry.msg;
      l2 = l1;
      j = i;
      localObject2 = localObject1;
      if (!(localObject3 instanceof ByteBuf)) {
        break;
      }
      l2 = l1;
      j = i;
      Object localObject4 = localObject1;
      if (!localEntry.cancelled)
      {
        localObject3 = (ByteBuf)localObject3;
        int k = ((ByteBuf)localObject3).readerIndex();
        int m = ((ByteBuf)localObject3).writerIndex() - k;
        l2 = l1;
        j = i;
        localObject4 = localObject1;
        if (m > 0)
        {
          l2 = m;
          if ((paramLong - l2 < l1) && (i != 0))
          {
            l2 = l1;
            j = i;
            localObject2 = localObject1;
            break;
          }
          l1 += l2;
          int n = localEntry.count;
          j = n;
          if (n == -1)
          {
            j = ((ByteBuf)localObject3).nioBufferCount();
            localEntry.count = j;
          }
          n = Math.min(paramInt, i + j);
          localObject2 = localObject1;
          if (n > localObject1.length)
          {
            localObject2 = expandNioBufferArray((ByteBuffer[])localObject1, n, i);
            NIO_BUFFERS.set(localInternalThreadLocalMap, localObject2);
          }
          if (j == 1)
          {
            localObject4 = localEntry.buf;
            localObject1 = localObject4;
            if (localObject4 == null)
            {
              localObject1 = ((ByteBuf)localObject3).internalNioBuffer(k, m);
              localEntry.buf = ((ByteBuffer)localObject1);
            }
            localObject2[i] = localObject1;
            i++;
          }
          else
          {
            i = nioBuffers(localEntry, (ByteBuf)localObject3, (ByteBuffer[])localObject2, i, paramInt);
          }
          l2 = l1;
          j = i;
          localObject4 = localObject2;
          if (i >= paramInt)
          {
            l2 = l1;
            j = i;
            break;
          }
        }
      }
      localEntry = localEntry.next;
      l1 = l2;
      i = j;
      localObject1 = localObject4;
    }
    this.nioBufferCount = j;
    this.nioBufferSize = l2;
    return (ByteBuffer[])localObject2;
  }
  
  public void progress(long paramLong)
  {
    Entry localEntry = this.flushedEntry;
    ChannelPromise localChannelPromise = localEntry.promise;
    paramLong = localEntry.progress + paramLong;
    localEntry.progress = paramLong;
    if ((localChannelPromise instanceof ChannelProgressivePromise)) {
      ((ChannelProgressivePromise)localChannelPromise).tryProgress(paramLong, localEntry.total);
    }
  }
  
  @Deprecated
  public void recycle() {}
  
  public boolean remove()
  {
    Entry localEntry = this.flushedEntry;
    if (localEntry == null)
    {
      clearNioBuffers();
      return false;
    }
    Object localObject = localEntry.msg;
    ChannelPromise localChannelPromise = localEntry.promise;
    int i = localEntry.pendingSize;
    removeEntry(localEntry);
    if (!localEntry.cancelled)
    {
      ReferenceCountUtil.safeRelease(localObject);
      safeSuccess(localChannelPromise);
      decrementPendingOutboundBytes(i, false, true);
    }
    localEntry.recycle();
    return true;
  }
  
  public boolean remove(Throwable paramThrowable)
  {
    return remove0(paramThrowable, true);
  }
  
  public void removeBytes(long paramLong)
  {
    Object localObject;
    int i;
    for (long l1 = paramLong;; l1 = paramLong)
    {
      localObject = current();
      if (!(localObject instanceof ByteBuf)) {
        break label102;
      }
      localObject = (ByteBuf)localObject;
      i = ((ByteBuf)localObject).readerIndex();
      long l2 = ((ByteBuf)localObject).writerIndex() - i;
      if (l2 > l1) {
        break;
      }
      paramLong = l1;
      if (l1 != 0L)
      {
        progress(l2);
        paramLong = l1 - l2;
      }
      remove();
    }
    if (l1 != 0L)
    {
      ((ByteBuf)localObject).readerIndex(i + (int)l1);
      progress(l1);
    }
    label102:
    clearNioBuffers();
  }
  
  public void setUserDefinedWritability(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      setUserDefinedWritability(paramInt);
    } else {
      clearUserDefinedWritability(paramInt);
    }
  }
  
  public int size()
  {
    return this.flushed;
  }
  
  public long totalPendingWriteBytes()
  {
    return this.totalPendingSize;
  }
  
  static final class Entry
  {
    private static final ObjectPool<Entry> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator()
    {
      public ChannelOutboundBuffer.Entry newObject(ObjectPool.Handle<ChannelOutboundBuffer.Entry> paramAnonymousHandle)
      {
        return new ChannelOutboundBuffer.Entry(paramAnonymousHandle, null);
      }
    });
    ByteBuffer buf;
    ByteBuffer[] bufs;
    boolean cancelled;
    int count = -1;
    private final ObjectPool.Handle<Entry> handle;
    Object msg;
    Entry next;
    int pendingSize;
    long progress;
    ChannelPromise promise;
    long total;
    
    private Entry(ObjectPool.Handle<Entry> paramHandle)
    {
      this.handle = paramHandle;
    }
    
    static Entry newInstance(Object paramObject, int paramInt, long paramLong, ChannelPromise paramChannelPromise)
    {
      Entry localEntry = (Entry)RECYCLER.get();
      localEntry.msg = paramObject;
      localEntry.pendingSize = (paramInt + ChannelOutboundBuffer.CHANNEL_OUTBOUND_BUFFER_ENTRY_OVERHEAD);
      localEntry.total = paramLong;
      localEntry.promise = paramChannelPromise;
      return localEntry;
    }
    
    int cancel()
    {
      if (!this.cancelled)
      {
        this.cancelled = true;
        int i = this.pendingSize;
        ReferenceCountUtil.safeRelease(this.msg);
        this.msg = Unpooled.EMPTY_BUFFER;
        this.pendingSize = 0;
        this.total = 0L;
        this.progress = 0L;
        this.bufs = null;
        this.buf = null;
        return i;
      }
      return 0;
    }
    
    void recycle()
    {
      this.next = null;
      this.bufs = null;
      this.buf = null;
      this.msg = null;
      this.promise = null;
      this.progress = 0L;
      this.total = 0L;
      this.pendingSize = 0;
      this.count = -1;
      this.cancelled = false;
      this.handle.recycle(this);
    }
    
    Entry recycleAndGetNext()
    {
      Entry localEntry = this.next;
      recycle();
      return localEntry;
    }
  }
  
  public static abstract interface MessageProcessor
  {
    public abstract boolean processMessage(Object paramObject)
      throws Exception;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\ChannelOutboundBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */