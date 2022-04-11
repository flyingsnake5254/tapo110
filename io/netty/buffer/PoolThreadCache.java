package io.netty.buffer;

import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectPool;
import io.netty.util.internal.ObjectPool.Handle;
import io.netty.util.internal.ObjectPool.ObjectCreator;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.ByteBuffer;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

final class PoolThreadCache
{
  private static final int INTEGER_SIZE_MINUS_ONE = 31;
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(PoolThreadCache.class);
  private int allocations;
  final PoolArena<ByteBuffer> directArena;
  private final int freeSweepAllocationThreshold;
  private final AtomicBoolean freed = new AtomicBoolean();
  final PoolArena<byte[]> heapArena;
  private final MemoryRegionCache<ByteBuffer>[] normalDirectCaches;
  private final MemoryRegionCache<byte[]>[] normalHeapCaches;
  private final int numShiftsNormalDirect;
  private final int numShiftsNormalHeap;
  private final MemoryRegionCache<ByteBuffer>[] smallSubPageDirectCaches;
  private final MemoryRegionCache<byte[]>[] smallSubPageHeapCaches;
  private final MemoryRegionCache<ByteBuffer>[] tinySubPageDirectCaches;
  private final MemoryRegionCache<byte[]>[] tinySubPageHeapCaches;
  
  PoolThreadCache(PoolArena<byte[]> paramPoolArena, PoolArena<ByteBuffer> paramPoolArena1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    ObjectUtil.checkPositiveOrZero(paramInt4, "maxCachedBufferCapacity");
    this.freeSweepAllocationThreshold = paramInt5;
    this.heapArena = paramPoolArena;
    this.directArena = paramPoolArena1;
    if (paramPoolArena1 != null)
    {
      this.tinySubPageDirectCaches = createSubPageCaches(paramInt1, 32, PoolArena.SizeClass.Tiny);
      this.smallSubPageDirectCaches = createSubPageCaches(paramInt2, paramPoolArena1.numSmallSubpagePools, PoolArena.SizeClass.Small);
      this.numShiftsNormalDirect = log2(paramPoolArena1.pageSize);
      this.normalDirectCaches = createNormalCaches(paramInt3, paramInt4, paramPoolArena1);
      paramPoolArena1.numThreadCaches.getAndIncrement();
    }
    else
    {
      this.tinySubPageDirectCaches = null;
      this.smallSubPageDirectCaches = null;
      this.normalDirectCaches = null;
      this.numShiftsNormalDirect = -1;
    }
    if (paramPoolArena != null)
    {
      this.tinySubPageHeapCaches = createSubPageCaches(paramInt1, 32, PoolArena.SizeClass.Tiny);
      this.smallSubPageHeapCaches = createSubPageCaches(paramInt2, paramPoolArena.numSmallSubpagePools, PoolArena.SizeClass.Small);
      this.numShiftsNormalHeap = log2(paramPoolArena.pageSize);
      this.normalHeapCaches = createNormalCaches(paramInt3, paramInt4, paramPoolArena);
      paramPoolArena.numThreadCaches.getAndIncrement();
    }
    else
    {
      this.tinySubPageHeapCaches = null;
      this.smallSubPageHeapCaches = null;
      this.normalHeapCaches = null;
      this.numShiftsNormalHeap = -1;
    }
    if (((this.tinySubPageDirectCaches == null) && (this.smallSubPageDirectCaches == null) && (this.normalDirectCaches == null) && (this.tinySubPageHeapCaches == null) && (this.smallSubPageHeapCaches == null) && (this.normalHeapCaches == null)) || (paramInt5 >= 1)) {
      return;
    }
    paramPoolArena = new StringBuilder();
    paramPoolArena.append("freeSweepAllocationThreshold: ");
    paramPoolArena.append(paramInt5);
    paramPoolArena.append(" (expected: > 0)");
    throw new IllegalArgumentException(paramPoolArena.toString());
  }
  
  private boolean allocate(MemoryRegionCache<?> paramMemoryRegionCache, PooledByteBuf paramPooledByteBuf, int paramInt)
  {
    if (paramMemoryRegionCache == null) {
      return false;
    }
    boolean bool = paramMemoryRegionCache.allocate(paramPooledByteBuf, paramInt, this);
    paramInt = this.allocations + 1;
    this.allocations = paramInt;
    if (paramInt >= this.freeSweepAllocationThreshold)
    {
      this.allocations = 0;
      trim();
    }
    return bool;
  }
  
  private MemoryRegionCache<?> cache(PoolArena<?> paramPoolArena, int paramInt, PoolArena.SizeClass paramSizeClass)
  {
    int i = 1.$SwitchMap$io$netty$buffer$PoolArena$SizeClass[paramSizeClass.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3) {
          return cacheForTiny(paramPoolArena, paramInt);
        }
        throw new Error();
      }
      return cacheForSmall(paramPoolArena, paramInt);
    }
    return cacheForNormal(paramPoolArena, paramInt);
  }
  
  private static <T> MemoryRegionCache<T> cache(MemoryRegionCache<T>[] paramArrayOfMemoryRegionCache, int paramInt)
  {
    if ((paramArrayOfMemoryRegionCache != null) && (paramInt <= paramArrayOfMemoryRegionCache.length - 1)) {
      return paramArrayOfMemoryRegionCache[paramInt];
    }
    return null;
  }
  
  private MemoryRegionCache<?> cacheForNormal(PoolArena<?> paramPoolArena, int paramInt)
  {
    if (paramPoolArena.isDirect())
    {
      paramInt = log2(paramInt >> this.numShiftsNormalDirect);
      return cache(this.normalDirectCaches, paramInt);
    }
    paramInt = log2(paramInt >> this.numShiftsNormalHeap);
    return cache(this.normalHeapCaches, paramInt);
  }
  
  private MemoryRegionCache<?> cacheForSmall(PoolArena<?> paramPoolArena, int paramInt)
  {
    paramInt = PoolArena.smallIdx(paramInt);
    if (paramPoolArena.isDirect()) {
      return cache(this.smallSubPageDirectCaches, paramInt);
    }
    return cache(this.smallSubPageHeapCaches, paramInt);
  }
  
  private MemoryRegionCache<?> cacheForTiny(PoolArena<?> paramPoolArena, int paramInt)
  {
    paramInt = PoolArena.tinyIdx(paramInt);
    if (paramPoolArena.isDirect()) {
      return cache(this.tinySubPageDirectCaches, paramInt);
    }
    return cache(this.tinySubPageHeapCaches, paramInt);
  }
  
  private static <T> MemoryRegionCache<T>[] createNormalCaches(int paramInt1, int paramInt2, PoolArena<T> paramPoolArena)
  {
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      int i = Math.max(1, log2(Math.min(paramPoolArena.chunkSize, paramInt2) / paramPoolArena.pageSize) + 1);
      paramPoolArena = new MemoryRegionCache[i];
      for (paramInt2 = 0; paramInt2 < i; paramInt2++) {
        paramPoolArena[paramInt2] = new NormalMemoryRegionCache(paramInt1);
      }
      return paramPoolArena;
    }
    return null;
  }
  
  private static <T> MemoryRegionCache<T>[] createSubPageCaches(int paramInt1, int paramInt2, PoolArena.SizeClass paramSizeClass)
  {
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      MemoryRegionCache[] arrayOfMemoryRegionCache = new MemoryRegionCache[paramInt2];
      for (int i = 0; i < paramInt2; i++) {
        arrayOfMemoryRegionCache[i] = new SubPageMemoryRegionCache(paramInt1, paramSizeClass);
      }
      return arrayOfMemoryRegionCache;
    }
    return null;
  }
  
  private static int free(MemoryRegionCache<?> paramMemoryRegionCache, boolean paramBoolean)
  {
    if (paramMemoryRegionCache == null) {
      return 0;
    }
    return paramMemoryRegionCache.free(paramBoolean);
  }
  
  private static int free(MemoryRegionCache<?>[] paramArrayOfMemoryRegionCache, boolean paramBoolean)
  {
    int i = 0;
    if (paramArrayOfMemoryRegionCache == null) {
      return 0;
    }
    int j = paramArrayOfMemoryRegionCache.length;
    int k = 0;
    while (i < j)
    {
      k += free(paramArrayOfMemoryRegionCache[i], paramBoolean);
      i++;
    }
    return k;
  }
  
  private static int log2(int paramInt)
  {
    return 31 - Integer.numberOfLeadingZeros(paramInt);
  }
  
  private static void trim(MemoryRegionCache<?> paramMemoryRegionCache)
  {
    if (paramMemoryRegionCache == null) {
      return;
    }
    paramMemoryRegionCache.trim();
  }
  
  private static void trim(MemoryRegionCache<?>[] paramArrayOfMemoryRegionCache)
  {
    if (paramArrayOfMemoryRegionCache == null) {
      return;
    }
    int i = paramArrayOfMemoryRegionCache.length;
    for (int j = 0; j < i; j++) {
      trim(paramArrayOfMemoryRegionCache[j]);
    }
  }
  
  boolean add(PoolArena<?> paramPoolArena, PoolChunk paramPoolChunk, ByteBuffer paramByteBuffer, long paramLong, int paramInt, PoolArena.SizeClass paramSizeClass)
  {
    paramPoolArena = cache(paramPoolArena, paramInt, paramSizeClass);
    if (paramPoolArena == null) {
      return false;
    }
    return paramPoolArena.add(paramPoolChunk, paramByteBuffer, paramLong);
  }
  
  boolean allocateNormal(PoolArena<?> paramPoolArena, PooledByteBuf<?> paramPooledByteBuf, int paramInt1, int paramInt2)
  {
    return allocate(cacheForNormal(paramPoolArena, paramInt2), paramPooledByteBuf, paramInt1);
  }
  
  boolean allocateSmall(PoolArena<?> paramPoolArena, PooledByteBuf<?> paramPooledByteBuf, int paramInt1, int paramInt2)
  {
    return allocate(cacheForSmall(paramPoolArena, paramInt2), paramPooledByteBuf, paramInt1);
  }
  
  boolean allocateTiny(PoolArena<?> paramPoolArena, PooledByteBuf<?> paramPooledByteBuf, int paramInt1, int paramInt2)
  {
    return allocate(cacheForTiny(paramPoolArena, paramInt2), paramPooledByteBuf, paramInt1);
  }
  
  protected void finalize()
    throws Throwable
  {
    try
    {
      super.finalize();
      return;
    }
    finally
    {
      free(true);
    }
  }
  
  void free(boolean paramBoolean)
  {
    if (this.freed.compareAndSet(false, true))
    {
      int i = free(this.tinySubPageDirectCaches, paramBoolean) + free(this.smallSubPageDirectCaches, paramBoolean) + free(this.normalDirectCaches, paramBoolean) + free(this.tinySubPageHeapCaches, paramBoolean) + free(this.smallSubPageHeapCaches, paramBoolean) + free(this.normalHeapCaches, paramBoolean);
      if (i > 0)
      {
        localObject = logger;
        if (((InternalLogger)localObject).isDebugEnabled()) {
          ((InternalLogger)localObject).debug("Freed {} thread-local buffer(s) from thread: {}", Integer.valueOf(i), Thread.currentThread().getName());
        }
      }
      Object localObject = this.directArena;
      if (localObject != null) {
        ((PoolArena)localObject).numThreadCaches.getAndDecrement();
      }
      localObject = this.heapArena;
      if (localObject != null) {
        ((PoolArena)localObject).numThreadCaches.getAndDecrement();
      }
    }
  }
  
  void trim()
  {
    trim(this.tinySubPageDirectCaches);
    trim(this.smallSubPageDirectCaches);
    trim(this.normalDirectCaches);
    trim(this.tinySubPageHeapCaches);
    trim(this.smallSubPageHeapCaches);
    trim(this.normalHeapCaches);
  }
  
  private static abstract class MemoryRegionCache<T>
  {
    private static final ObjectPool<Entry> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator()
    {
      public PoolThreadCache.MemoryRegionCache.Entry newObject(ObjectPool.Handle<PoolThreadCache.MemoryRegionCache.Entry> paramAnonymousHandle)
      {
        return new PoolThreadCache.MemoryRegionCache.Entry(paramAnonymousHandle);
      }
    });
    private int allocations;
    private final Queue<Entry<T>> queue;
    private final int size;
    private final PoolArena.SizeClass sizeClass;
    
    MemoryRegionCache(int paramInt, PoolArena.SizeClass paramSizeClass)
    {
      paramInt = MathUtil.safeFindNextPositivePowerOfTwo(paramInt);
      this.size = paramInt;
      this.queue = PlatformDependent.newFixedMpscQueue(paramInt);
      this.sizeClass = paramSizeClass;
    }
    
    private int free(int paramInt, boolean paramBoolean)
    {
      for (int i = 0; i < paramInt; i++)
      {
        Entry localEntry = (Entry)this.queue.poll();
        if (localEntry == null) {
          break;
        }
        freeEntry(localEntry, paramBoolean);
      }
      return i;
    }
    
    private void freeEntry(Entry paramEntry, boolean paramBoolean)
    {
      PoolChunk localPoolChunk = paramEntry.chunk;
      long l = paramEntry.handle;
      ByteBuffer localByteBuffer = paramEntry.nioBuffer;
      if (!paramBoolean) {
        paramEntry.recycle();
      }
      localPoolChunk.arena.freeChunk(localPoolChunk, l, this.sizeClass, localByteBuffer, paramBoolean);
    }
    
    private static Entry newEntry(PoolChunk<?> paramPoolChunk, ByteBuffer paramByteBuffer, long paramLong)
    {
      Entry localEntry = (Entry)RECYCLER.get();
      localEntry.chunk = paramPoolChunk;
      localEntry.nioBuffer = paramByteBuffer;
      localEntry.handle = paramLong;
      return localEntry;
    }
    
    public final boolean add(PoolChunk<T> paramPoolChunk, ByteBuffer paramByteBuffer, long paramLong)
    {
      paramPoolChunk = newEntry(paramPoolChunk, paramByteBuffer, paramLong);
      boolean bool = this.queue.offer(paramPoolChunk);
      if (!bool) {
        paramPoolChunk.recycle();
      }
      return bool;
    }
    
    public final boolean allocate(PooledByteBuf<T> paramPooledByteBuf, int paramInt, PoolThreadCache paramPoolThreadCache)
    {
      Entry localEntry = (Entry)this.queue.poll();
      if (localEntry == null) {
        return false;
      }
      initBuf(localEntry.chunk, localEntry.nioBuffer, localEntry.handle, paramPooledByteBuf, paramInt, paramPoolThreadCache);
      localEntry.recycle();
      this.allocations += 1;
      return true;
    }
    
    public final int free(boolean paramBoolean)
    {
      return free(Integer.MAX_VALUE, paramBoolean);
    }
    
    protected abstract void initBuf(PoolChunk<T> paramPoolChunk, ByteBuffer paramByteBuffer, long paramLong, PooledByteBuf<T> paramPooledByteBuf, int paramInt, PoolThreadCache paramPoolThreadCache);
    
    public final void trim()
    {
      int i = this.size - this.allocations;
      this.allocations = 0;
      if (i > 0) {
        free(i, false);
      }
    }
    
    static final class Entry<T>
    {
      PoolChunk<T> chunk;
      long handle = -1L;
      ByteBuffer nioBuffer;
      final ObjectPool.Handle<Entry<?>> recyclerHandle;
      
      Entry(ObjectPool.Handle<Entry<?>> paramHandle)
      {
        this.recyclerHandle = paramHandle;
      }
      
      void recycle()
      {
        this.chunk = null;
        this.nioBuffer = null;
        this.handle = -1L;
        this.recyclerHandle.recycle(this);
      }
    }
  }
  
  private static final class NormalMemoryRegionCache<T>
    extends PoolThreadCache.MemoryRegionCache<T>
  {
    NormalMemoryRegionCache(int paramInt)
    {
      super(PoolArena.SizeClass.Normal);
    }
    
    protected void initBuf(PoolChunk<T> paramPoolChunk, ByteBuffer paramByteBuffer, long paramLong, PooledByteBuf<T> paramPooledByteBuf, int paramInt, PoolThreadCache paramPoolThreadCache)
    {
      paramPoolChunk.initBuf(paramPooledByteBuf, paramByteBuffer, paramLong, paramInt, paramPoolThreadCache);
    }
  }
  
  private static final class SubPageMemoryRegionCache<T>
    extends PoolThreadCache.MemoryRegionCache<T>
  {
    SubPageMemoryRegionCache(int paramInt, PoolArena.SizeClass paramSizeClass)
    {
      super(paramSizeClass);
    }
    
    protected void initBuf(PoolChunk<T> paramPoolChunk, ByteBuffer paramByteBuffer, long paramLong, PooledByteBuf<T> paramPooledByteBuf, int paramInt, PoolThreadCache paramPoolThreadCache)
    {
      paramPoolChunk.initBufWithSubpage(paramPooledByteBuf, paramByteBuffer, paramLong, paramInt, paramPoolThreadCache);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\buffer\PoolThreadCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */