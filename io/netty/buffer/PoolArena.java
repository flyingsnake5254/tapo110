package io.netty.buffer;

import io.netty.util.internal.LongCounter;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

abstract class PoolArena<T>
  implements PoolArenaMetric
{
  static final boolean HAS_UNSAFE = ;
  static final int numTinySubpagePools = 32;
  private final LongCounter activeBytesHuge = PlatformDependent.newLongCounter();
  private final LongCounter allocationsHuge = PlatformDependent.newLongCounter();
  private long allocationsNormal;
  private final LongCounter allocationsSmall = PlatformDependent.newLongCounter();
  private final LongCounter allocationsTiny = PlatformDependent.newLongCounter();
  private final List<PoolChunkListMetric> chunkListMetrics;
  final int chunkSize;
  private final LongCounter deallocationsHuge = PlatformDependent.newLongCounter();
  private long deallocationsNormal;
  private long deallocationsSmall;
  private long deallocationsTiny;
  final int directMemoryCacheAlignment;
  final int directMemoryCacheAlignmentMask;
  private final int maxOrder;
  final int numSmallSubpagePools;
  final AtomicInteger numThreadCaches = new AtomicInteger();
  final int pageShifts;
  final int pageSize;
  final PooledByteBufAllocator parent;
  private final PoolChunkList<T> q000;
  private final PoolChunkList<T> q025;
  private final PoolChunkList<T> q050;
  private final PoolChunkList<T> q075;
  private final PoolChunkList<T> q100;
  private final PoolChunkList<T> qInit;
  private final PoolSubpage<T>[] smallSubpagePools;
  final int subpageOverflowMask;
  private final PoolSubpage<T>[] tinySubpagePools;
  
  protected PoolArena(PooledByteBufAllocator paramPooledByteBufAllocator, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.parent = paramPooledByteBufAllocator;
    this.pageSize = paramInt1;
    this.maxOrder = paramInt2;
    this.pageShifts = paramInt3;
    this.chunkSize = paramInt4;
    this.directMemoryCacheAlignment = paramInt5;
    this.directMemoryCacheAlignmentMask = (paramInt5 - 1);
    this.subpageOverflowMask = (paramInt1 - 1 ^ 0xFFFFFFFF);
    this.tinySubpagePools = newSubpagePoolArray(32);
    paramInt5 = 0;
    for (paramInt2 = 0;; paramInt2++)
    {
      paramPooledByteBufAllocator = this.tinySubpagePools;
      if (paramInt2 >= paramPooledByteBufAllocator.length) {
        break;
      }
      paramPooledByteBufAllocator[paramInt2] = newSubpagePoolHead(paramInt1);
    }
    paramInt2 = paramInt3 - 9;
    this.numSmallSubpagePools = paramInt2;
    this.smallSubpagePools = newSubpagePoolArray(paramInt2);
    for (paramInt2 = paramInt5;; paramInt2++)
    {
      paramPooledByteBufAllocator = this.smallSubpagePools;
      if (paramInt2 >= paramPooledByteBufAllocator.length) {
        break;
      }
      paramPooledByteBufAllocator[paramInt2] = newSubpagePoolHead(paramInt1);
    }
    PoolChunkList localPoolChunkList1 = new PoolChunkList(this, null, 100, Integer.MAX_VALUE, paramInt4);
    this.q100 = localPoolChunkList1;
    paramPooledByteBufAllocator = new PoolChunkList(this, localPoolChunkList1, 75, 100, paramInt4);
    this.q075 = paramPooledByteBufAllocator;
    PoolChunkList localPoolChunkList2 = new PoolChunkList(this, paramPooledByteBufAllocator, 50, 100, paramInt4);
    this.q050 = localPoolChunkList2;
    PoolChunkList localPoolChunkList3 = new PoolChunkList(this, localPoolChunkList2, 25, 75, paramInt4);
    this.q025 = localPoolChunkList3;
    PoolChunkList localPoolChunkList4 = new PoolChunkList(this, localPoolChunkList3, 1, 50, paramInt4);
    this.q000 = localPoolChunkList4;
    PoolChunkList localPoolChunkList5 = new PoolChunkList(this, localPoolChunkList4, Integer.MIN_VALUE, 25, paramInt4);
    this.qInit = localPoolChunkList5;
    localPoolChunkList1.prevList(paramPooledByteBufAllocator);
    paramPooledByteBufAllocator.prevList(localPoolChunkList2);
    localPoolChunkList2.prevList(localPoolChunkList3);
    localPoolChunkList3.prevList(localPoolChunkList4);
    localPoolChunkList4.prevList(null);
    localPoolChunkList5.prevList(localPoolChunkList5);
    ArrayList localArrayList = new ArrayList(6);
    localArrayList.add(localPoolChunkList5);
    localArrayList.add(localPoolChunkList4);
    localArrayList.add(localPoolChunkList3);
    localArrayList.add(localPoolChunkList2);
    localArrayList.add(paramPooledByteBufAllocator);
    localArrayList.add(localPoolChunkList1);
    this.chunkListMetrics = Collections.unmodifiableList(localArrayList);
  }
  
  private void allocate(PoolThreadCache paramPoolThreadCache, PooledByteBuf<T> paramPooledByteBuf, int paramInt)
  {
    int i = normalizeCapacity(paramInt);
    if (isTinyOrSmall(i))
    {
      boolean bool = isTiny(i);
      int j;
      if (bool)
      {
        if (paramPoolThreadCache.allocateTiny(this, paramPooledByteBuf, paramInt, i)) {
          return;
        }
        j = tinyIdx(i);
        ??? = this.tinySubpagePools;
      }
      else
      {
        if (paramPoolThreadCache.allocateSmall(this, paramPooledByteBuf, paramInt, i)) {
          return;
        }
        j = smallIdx(i);
        ??? = this.smallSubpagePools;
      }
      synchronized (???[j])
      {
        PoolSubpage localPoolSubpage = ((PoolSubpage)???).next;
        if (localPoolSubpage != ???)
        {
          long l = localPoolSubpage.allocate();
          localPoolSubpage.chunk.initBufWithSubpage(paramPooledByteBuf, null, l, paramInt, paramPoolThreadCache);
          incTinySmallAllocation(bool);
          return;
        }
        try
        {
          allocateNormal(paramPooledByteBuf, paramInt, i, paramPoolThreadCache);
          incTinySmallAllocation(bool);
          return;
        }
        finally {}
      }
    }
    if (i <= this.chunkSize)
    {
      if (paramPoolThreadCache.allocateNormal(this, paramPooledByteBuf, paramInt, i)) {
        return;
      }
      try
      {
        allocateNormal(paramPooledByteBuf, paramInt, i, paramPoolThreadCache);
        this.allocationsNormal += 1L;
      }
      finally {}
    }
    else
    {
      allocateHuge(paramPooledByteBuf, paramInt);
    }
  }
  
  private void allocateHuge(PooledByteBuf<T> paramPooledByteBuf, int paramInt)
  {
    PoolChunk localPoolChunk = newUnpooledChunk(paramInt);
    this.activeBytesHuge.add(localPoolChunk.chunkSize());
    paramPooledByteBuf.initUnpooled(localPoolChunk, paramInt);
    this.allocationsHuge.increment();
  }
  
  private void allocateNormal(PooledByteBuf<T> paramPooledByteBuf, int paramInt1, int paramInt2, PoolThreadCache paramPoolThreadCache)
  {
    if ((!this.q050.allocate(paramPooledByteBuf, paramInt1, paramInt2, paramPoolThreadCache)) && (!this.q025.allocate(paramPooledByteBuf, paramInt1, paramInt2, paramPoolThreadCache)) && (!this.q000.allocate(paramPooledByteBuf, paramInt1, paramInt2, paramPoolThreadCache)) && (!this.qInit.allocate(paramPooledByteBuf, paramInt1, paramInt2, paramPoolThreadCache)) && (!this.q075.allocate(paramPooledByteBuf, paramInt1, paramInt2, paramPoolThreadCache)))
    {
      PoolChunk localPoolChunk = newChunk(this.pageSize, this.maxOrder, this.pageShifts, this.chunkSize);
      localPoolChunk.allocate(paramPooledByteBuf, paramInt1, paramInt2, paramPoolThreadCache);
      this.qInit.add(localPoolChunk);
    }
  }
  
  private static void appendPoolSubPages(StringBuilder paramStringBuilder, PoolSubpage<?>[] paramArrayOfPoolSubpage)
  {
    for (int i = 0; i < paramArrayOfPoolSubpage.length; i++)
    {
      PoolSubpage<?> localPoolSubpage = paramArrayOfPoolSubpage[i];
      if (localPoolSubpage.next != localPoolSubpage)
      {
        paramStringBuilder.append(StringUtil.NEWLINE);
        paramStringBuilder.append(i);
        paramStringBuilder.append(": ");
        Object localObject = localPoolSubpage.next;
        PoolSubpage localPoolSubpage1;
        do
        {
          paramStringBuilder.append(localObject);
          localPoolSubpage1 = ((PoolSubpage)localObject).next;
          localObject = localPoolSubpage1;
        } while (localPoolSubpage1 != localPoolSubpage);
      }
    }
  }
  
  private void destroyPoolChunkLists(PoolChunkList<T>... paramVarArgs)
  {
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++) {
      paramVarArgs[j].destroy(this);
    }
  }
  
  private static void destroyPoolSubPages(PoolSubpage<?>[] paramArrayOfPoolSubpage)
  {
    int i = paramArrayOfPoolSubpage.length;
    for (int j = 0; j < i; j++) {
      paramArrayOfPoolSubpage[j].destroy();
    }
  }
  
  private void incTinySmallAllocation(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.allocationsTiny.increment();
    } else {
      this.allocationsSmall.increment();
    }
  }
  
  static boolean isTiny(int paramInt)
  {
    boolean bool;
    if ((paramInt & 0xFE00) == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private PoolSubpage<T>[] newSubpagePoolArray(int paramInt)
  {
    return new PoolSubpage[paramInt];
  }
  
  private PoolSubpage<T> newSubpagePoolHead(int paramInt)
  {
    PoolSubpage localPoolSubpage = new PoolSubpage(paramInt);
    localPoolSubpage.prev = localPoolSubpage;
    localPoolSubpage.next = localPoolSubpage;
    return localPoolSubpage;
  }
  
  private SizeClass sizeClass(int paramInt)
  {
    if (!isTinyOrSmall(paramInt)) {
      return SizeClass.Normal;
    }
    SizeClass localSizeClass;
    if (isTiny(paramInt)) {
      localSizeClass = SizeClass.Tiny;
    } else {
      localSizeClass = SizeClass.Small;
    }
    return localSizeClass;
  }
  
  static int smallIdx(int paramInt)
  {
    paramInt >>>= 10;
    for (int i = 0; paramInt != 0; i++) {
      paramInt >>>= 1;
    }
    return i;
  }
  
  private static List<PoolSubpageMetric> subPageMetricList(PoolSubpage<?>[] paramArrayOfPoolSubpage)
  {
    ArrayList localArrayList = new ArrayList();
    int i = paramArrayOfPoolSubpage.length;
    for (int j = 0; j < i; j++)
    {
      PoolSubpage<?> localPoolSubpage = paramArrayOfPoolSubpage[j];
      PoolSubpage localPoolSubpage1 = localPoolSubpage.next;
      PoolSubpage localPoolSubpage2 = localPoolSubpage1;
      if (localPoolSubpage1 != localPoolSubpage) {
        do
        {
          localArrayList.add(localPoolSubpage2);
          localPoolSubpage1 = localPoolSubpage2.next;
          localPoolSubpage2 = localPoolSubpage1;
        } while (localPoolSubpage1 != localPoolSubpage);
      }
    }
    return localArrayList;
  }
  
  static int tinyIdx(int paramInt)
  {
    return paramInt >>> 4;
  }
  
  int alignCapacity(int paramInt)
  {
    int i = this.directMemoryCacheAlignmentMask & paramInt;
    if (i != 0) {
      paramInt = paramInt + this.directMemoryCacheAlignment - i;
    }
    return paramInt;
  }
  
  PooledByteBuf<T> allocate(PoolThreadCache paramPoolThreadCache, int paramInt1, int paramInt2)
  {
    PooledByteBuf localPooledByteBuf = newByteBuf(paramInt2);
    allocate(paramPoolThreadCache, localPooledByteBuf, paramInt1);
    return localPooledByteBuf;
  }
  
  public List<PoolChunkListMetric> chunkLists()
  {
    return this.chunkListMetrics;
  }
  
  protected abstract void destroyChunk(PoolChunk<T> paramPoolChunk);
  
  /* Error */
  protected final void finalize()
    throws Throwable
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 343	java/lang/Object:finalize	()V
    //   4: aload_0
    //   5: getfield 127	io/netty/buffer/PoolArena:smallSubpagePools	[Lio/netty/buffer/PoolSubpage;
    //   8: invokestatic 345	io/netty/buffer/PoolArena:destroyPoolSubPages	([Lio/netty/buffer/PoolSubpage;)V
    //   11: aload_0
    //   12: getfield 119	io/netty/buffer/PoolArena:tinySubpagePools	[Lio/netty/buffer/PoolSubpage;
    //   15: invokestatic 345	io/netty/buffer/PoolArena:destroyPoolSubPages	([Lio/netty/buffer/PoolSubpage;)V
    //   18: aload_0
    //   19: bipush 6
    //   21: anewarray 129	io/netty/buffer/PoolChunkList
    //   24: dup
    //   25: iconst_0
    //   26: aload_0
    //   27: getfield 146	io/netty/buffer/PoolArena:qInit	Lio/netty/buffer/PoolChunkList;
    //   30: aastore
    //   31: dup
    //   32: iconst_1
    //   33: aload_0
    //   34: getfield 143	io/netty/buffer/PoolArena:q000	Lio/netty/buffer/PoolChunkList;
    //   37: aastore
    //   38: dup
    //   39: iconst_2
    //   40: aload_0
    //   41: getfield 141	io/netty/buffer/PoolArena:q025	Lio/netty/buffer/PoolChunkList;
    //   44: aastore
    //   45: dup
    //   46: iconst_3
    //   47: aload_0
    //   48: getfield 139	io/netty/buffer/PoolArena:q050	Lio/netty/buffer/PoolChunkList;
    //   51: aastore
    //   52: dup
    //   53: iconst_4
    //   54: aload_0
    //   55: getfield 137	io/netty/buffer/PoolArena:q075	Lio/netty/buffer/PoolChunkList;
    //   58: aastore
    //   59: dup
    //   60: iconst_5
    //   61: aload_0
    //   62: getfield 135	io/netty/buffer/PoolArena:q100	Lio/netty/buffer/PoolChunkList;
    //   65: aastore
    //   66: invokespecial 347	io/netty/buffer/PoolArena:destroyPoolChunkLists	([Lio/netty/buffer/PoolChunkList;)V
    //   69: return
    //   70: astore_1
    //   71: aload_0
    //   72: getfield 127	io/netty/buffer/PoolArena:smallSubpagePools	[Lio/netty/buffer/PoolSubpage;
    //   75: invokestatic 345	io/netty/buffer/PoolArena:destroyPoolSubPages	([Lio/netty/buffer/PoolSubpage;)V
    //   78: aload_0
    //   79: getfield 119	io/netty/buffer/PoolArena:tinySubpagePools	[Lio/netty/buffer/PoolSubpage;
    //   82: invokestatic 345	io/netty/buffer/PoolArena:destroyPoolSubPages	([Lio/netty/buffer/PoolSubpage;)V
    //   85: aload_0
    //   86: bipush 6
    //   88: anewarray 129	io/netty/buffer/PoolChunkList
    //   91: dup
    //   92: iconst_0
    //   93: aload_0
    //   94: getfield 146	io/netty/buffer/PoolArena:qInit	Lio/netty/buffer/PoolChunkList;
    //   97: aastore
    //   98: dup
    //   99: iconst_1
    //   100: aload_0
    //   101: getfield 143	io/netty/buffer/PoolArena:q000	Lio/netty/buffer/PoolChunkList;
    //   104: aastore
    //   105: dup
    //   106: iconst_2
    //   107: aload_0
    //   108: getfield 141	io/netty/buffer/PoolArena:q025	Lio/netty/buffer/PoolChunkList;
    //   111: aastore
    //   112: dup
    //   113: iconst_3
    //   114: aload_0
    //   115: getfield 139	io/netty/buffer/PoolArena:q050	Lio/netty/buffer/PoolChunkList;
    //   118: aastore
    //   119: dup
    //   120: iconst_4
    //   121: aload_0
    //   122: getfield 137	io/netty/buffer/PoolArena:q075	Lio/netty/buffer/PoolChunkList;
    //   125: aastore
    //   126: dup
    //   127: iconst_5
    //   128: aload_0
    //   129: getfield 135	io/netty/buffer/PoolArena:q100	Lio/netty/buffer/PoolChunkList;
    //   132: aastore
    //   133: invokespecial 347	io/netty/buffer/PoolArena:destroyPoolChunkLists	([Lio/netty/buffer/PoolChunkList;)V
    //   136: aload_1
    //   137: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	this	PoolArena
    //   70	67	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	4	70	finally
  }
  
  PoolSubpage<T> findSubpagePoolHead(int paramInt)
  {
    PoolSubpage[] arrayOfPoolSubpage;
    if (isTiny(paramInt))
    {
      paramInt = tinyIdx(paramInt);
      arrayOfPoolSubpage = this.tinySubpagePools;
    }
    else
    {
      paramInt = smallIdx(paramInt);
      arrayOfPoolSubpage = this.smallSubpagePools;
    }
    return arrayOfPoolSubpage[paramInt];
  }
  
  void free(PoolChunk<T> paramPoolChunk, ByteBuffer paramByteBuffer, long paramLong, int paramInt, PoolThreadCache paramPoolThreadCache)
  {
    if (paramPoolChunk.unpooled)
    {
      paramInt = paramPoolChunk.chunkSize();
      destroyChunk(paramPoolChunk);
      this.activeBytesHuge.add(-paramInt);
      this.deallocationsHuge.increment();
    }
    else
    {
      SizeClass localSizeClass = sizeClass(paramInt);
      if ((paramPoolThreadCache != null) && (paramPoolThreadCache.add(this, paramPoolChunk, paramByteBuffer, paramLong, paramInt, localSizeClass))) {
        return;
      }
      freeChunk(paramPoolChunk, paramLong, localSizeClass, paramByteBuffer, false);
    }
  }
  
  void freeChunk(PoolChunk<T> paramPoolChunk, long paramLong, SizeClass paramSizeClass, ByteBuffer paramByteBuffer, boolean paramBoolean)
  {
    int i = 1;
    if (!paramBoolean) {}
    try
    {
      int j = 1.$SwitchMap$io$netty$buffer$PoolArena$SizeClass[paramSizeClass.ordinal()];
      if (j != 1)
      {
        if (j != 2)
        {
          if (j == 3)
          {
            this.deallocationsTiny += 1L;
          }
          else
          {
            paramPoolChunk = new java/lang/Error;
            paramPoolChunk.<init>();
            throw paramPoolChunk;
          }
        }
        else {
          this.deallocationsSmall += 1L;
        }
      }
      else {
        this.deallocationsNormal += 1L;
      }
      if (paramPoolChunk.parent.free(paramPoolChunk, paramLong, paramByteBuffer)) {
        i = 0;
      }
      if (i != 0) {
        destroyChunk(paramPoolChunk);
      }
      return;
    }
    finally {}
  }
  
  abstract boolean isDirect();
  
  boolean isTinyOrSmall(int paramInt)
  {
    boolean bool;
    if ((paramInt & this.subpageOverflowMask) == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected abstract void memoryCopy(T paramT, int paramInt1, PooledByteBuf<T> paramPooledByteBuf, int paramInt2);
  
  protected abstract PooledByteBuf<T> newByteBuf(int paramInt);
  
  protected abstract PoolChunk<T> newChunk(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  protected abstract PoolChunk<T> newUnpooledChunk(int paramInt);
  
  int normalizeCapacity(int paramInt)
  {
    ObjectUtil.checkPositiveOrZero(paramInt, "reqCapacity");
    if (paramInt >= this.chunkSize)
    {
      if (this.directMemoryCacheAlignment != 0) {
        paramInt = alignCapacity(paramInt);
      }
      return paramInt;
    }
    if (!isTiny(paramInt))
    {
      paramInt--;
      paramInt |= paramInt >>> 1;
      paramInt |= paramInt >>> 2;
      paramInt |= paramInt >>> 4;
      paramInt |= paramInt >>> 8;
      int i = (paramInt | paramInt >>> 16) + 1;
      paramInt = i;
      if (i < 0) {
        paramInt = i >>> 1;
      }
      return paramInt;
    }
    if (this.directMemoryCacheAlignment > 0) {
      return alignCapacity(paramInt);
    }
    if ((paramInt & 0xF) == 0) {
      return paramInt;
    }
    return (paramInt & 0xFFFFFFF0) + 16;
  }
  
  public long numActiveAllocations()
  {
    long l1 = this.allocationsTiny.value();
    long l2 = this.allocationsSmall.value();
    long l3 = this.allocationsHuge.value();
    long l4 = this.deallocationsHuge.value();
    try
    {
      long l5 = this.allocationsNormal;
      long l6 = this.deallocationsTiny;
      long l7 = this.deallocationsSmall;
      long l8 = this.deallocationsNormal;
      return Math.max(l1 + l2 + l3 - l4 + (l5 - (l6 + l7 + l8)), 0L);
    }
    finally {}
  }
  
  public long numActiveBytes()
  {
    long l = this.activeBytesHuge.value();
    int i = 0;
    try
    {
      while (i < this.chunkListMetrics.size())
      {
        Iterator localIterator = ((PoolChunkListMetric)this.chunkListMetrics.get(i)).iterator();
        while (localIterator.hasNext()) {
          l += ((PoolChunkMetric)localIterator.next()).chunkSize();
        }
        i++;
      }
      return Math.max(0L, l);
    }
    finally {}
  }
  
  public long numActiveHugeAllocations()
  {
    return Math.max(numHugeAllocations() - numHugeDeallocations(), 0L);
  }
  
  public long numActiveNormalAllocations()
  {
    try
    {
      long l1 = this.allocationsNormal;
      long l2 = this.deallocationsNormal;
      return Math.max(l1 - l2, 0L);
    }
    finally {}
  }
  
  public long numActiveSmallAllocations()
  {
    return Math.max(numSmallAllocations() - numSmallDeallocations(), 0L);
  }
  
  public long numActiveTinyAllocations()
  {
    return Math.max(numTinyAllocations() - numTinyDeallocations(), 0L);
  }
  
  public long numAllocations()
  {
    try
    {
      long l = this.allocationsNormal;
      return this.allocationsTiny.value() + this.allocationsSmall.value() + l + this.allocationsHuge.value();
    }
    finally {}
  }
  
  public int numChunkLists()
  {
    return this.chunkListMetrics.size();
  }
  
  public long numDeallocations()
  {
    try
    {
      long l1 = this.deallocationsTiny;
      long l2 = this.deallocationsSmall;
      long l3 = this.deallocationsNormal;
      return l1 + l2 + l3 + this.deallocationsHuge.value();
    }
    finally {}
  }
  
  public long numHugeAllocations()
  {
    return this.allocationsHuge.value();
  }
  
  public long numHugeDeallocations()
  {
    return this.deallocationsHuge.value();
  }
  
  public long numNormalAllocations()
  {
    try
    {
      long l = this.allocationsNormal;
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public long numNormalDeallocations()
  {
    try
    {
      long l = this.deallocationsNormal;
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public long numSmallAllocations()
  {
    return this.allocationsSmall.value();
  }
  
  public long numSmallDeallocations()
  {
    try
    {
      long l = this.deallocationsSmall;
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int numSmallSubpages()
  {
    return this.smallSubpagePools.length;
  }
  
  public int numThreadCaches()
  {
    return this.numThreadCaches.get();
  }
  
  public long numTinyAllocations()
  {
    return this.allocationsTiny.value();
  }
  
  public long numTinyDeallocations()
  {
    try
    {
      long l = this.deallocationsTiny;
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int numTinySubpages()
  {
    return this.tinySubpagePools.length;
  }
  
  void reallocate(PooledByteBuf<T> paramPooledByteBuf, int paramInt, boolean paramBoolean)
  {
    int i = paramPooledByteBuf.length;
    if (i == paramInt) {
      return;
    }
    PoolChunk localPoolChunk = paramPooledByteBuf.chunk;
    ByteBuffer localByteBuffer = paramPooledByteBuf.tmpNioBuf;
    long l = paramPooledByteBuf.handle;
    Object localObject = paramPooledByteBuf.memory;
    int j = paramPooledByteBuf.offset;
    int k = paramPooledByteBuf.maxLength;
    allocate(this.parent.threadCache(), paramPooledByteBuf, paramInt);
    if (paramInt > i) {
      paramInt = i;
    } else {
      paramPooledByteBuf.trimIndicesToCapacity(paramInt);
    }
    memoryCopy(localObject, j, paramPooledByteBuf, paramInt);
    if (paramBoolean) {
      free(localPoolChunk, localByteBuffer, l, k, paramPooledByteBuf.cache);
    }
  }
  
  public List<PoolSubpageMetric> smallSubpages()
  {
    return subPageMetricList(this.smallSubpagePools);
  }
  
  public List<PoolSubpageMetric> tinySubpages()
  {
    return subPageMetricList(this.tinySubpagePools);
  }
  
  public String toString()
  {
    try
    {
      Object localObject1 = new java/lang/StringBuilder;
      ((StringBuilder)localObject1).<init>();
      ((StringBuilder)localObject1).append("Chunk(s) at 0~25%:");
      String str = StringUtil.NEWLINE;
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append(this.qInit);
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append("Chunk(s) at 0~50%:");
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append(this.q000);
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append("Chunk(s) at 25~75%:");
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append(this.q025);
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append("Chunk(s) at 50~100%:");
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append(this.q050);
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append("Chunk(s) at 75~100%:");
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append(this.q075);
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append("Chunk(s) at 100%:");
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append(this.q100);
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append("tiny subpages:");
      appendPoolSubPages((StringBuilder)localObject1, this.tinySubpagePools);
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append("small subpages:");
      appendPoolSubPages((StringBuilder)localObject1, this.smallSubpagePools);
      ((StringBuilder)localObject1).append(str);
      localObject1 = ((StringBuilder)localObject1).toString();
      return (String)localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
  }
  
  static final class DirectArena
    extends PoolArena<ByteBuffer>
  {
    DirectArena(PooledByteBufAllocator paramPooledByteBufAllocator, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    }
    
    private static ByteBuffer allocateDirect(int paramInt)
    {
      ByteBuffer localByteBuffer;
      if (PlatformDependent.useDirectBufferNoCleaner()) {
        localByteBuffer = PlatformDependent.allocateDirectNoCleaner(paramInt);
      } else {
        localByteBuffer = ByteBuffer.allocateDirect(paramInt);
      }
      return localByteBuffer;
    }
    
    protected void destroyChunk(PoolChunk<ByteBuffer> paramPoolChunk)
    {
      if (PlatformDependent.useDirectBufferNoCleaner()) {
        PlatformDependent.freeDirectNoCleaner((ByteBuffer)paramPoolChunk.memory);
      } else {
        PlatformDependent.freeDirectBuffer((ByteBuffer)paramPoolChunk.memory);
      }
    }
    
    boolean isDirect()
    {
      return true;
    }
    
    protected void memoryCopy(ByteBuffer paramByteBuffer, int paramInt1, PooledByteBuf<ByteBuffer> paramPooledByteBuf, int paramInt2)
    {
      if (paramInt2 == 0) {
        return;
      }
      if (PoolArena.HAS_UNSAFE)
      {
        PlatformDependent.copyMemory(PlatformDependent.directBufferAddress(paramByteBuffer) + paramInt1, PlatformDependent.directBufferAddress((ByteBuffer)paramPooledByteBuf.memory) + paramPooledByteBuf.offset, paramInt2);
      }
      else
      {
        ByteBuffer localByteBuffer = paramByteBuffer.duplicate();
        paramByteBuffer = paramPooledByteBuf.internalNioBuffer();
        localByteBuffer.position(paramInt1).limit(paramInt1 + paramInt2);
        paramByteBuffer.position(paramPooledByteBuf.offset);
        paramByteBuffer.put(localByteBuffer);
      }
    }
    
    protected PooledByteBuf<ByteBuffer> newByteBuf(int paramInt)
    {
      if (PoolArena.HAS_UNSAFE) {
        return PooledUnsafeDirectByteBuf.newInstance(paramInt);
      }
      return PooledDirectByteBuf.newInstance(paramInt);
    }
    
    protected PoolChunk<ByteBuffer> newChunk(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      int i = this.directMemoryCacheAlignment;
      if (i == 0) {
        return new PoolChunk(this, allocateDirect(paramInt4), paramInt1, paramInt2, paramInt3, paramInt4, 0);
      }
      ByteBuffer localByteBuffer = allocateDirect(i + paramInt4);
      return new PoolChunk(this, localByteBuffer, paramInt1, paramInt2, paramInt3, paramInt4, offsetCacheLine(localByteBuffer));
    }
    
    protected PoolChunk<ByteBuffer> newUnpooledChunk(int paramInt)
    {
      int i = this.directMemoryCacheAlignment;
      if (i == 0) {
        return new PoolChunk(this, allocateDirect(paramInt), paramInt, 0);
      }
      ByteBuffer localByteBuffer = allocateDirect(i + paramInt);
      return new PoolChunk(this, localByteBuffer, paramInt, offsetCacheLine(localByteBuffer));
    }
    
    int offsetCacheLine(ByteBuffer paramByteBuffer)
    {
      int i;
      if (PoolArena.HAS_UNSAFE) {
        i = (int)(PlatformDependent.directBufferAddress(paramByteBuffer) & this.directMemoryCacheAlignmentMask);
      } else {
        i = 0;
      }
      return this.directMemoryCacheAlignment - i;
    }
  }
  
  static final class HeapArena
    extends PoolArena<byte[]>
  {
    HeapArena(PooledByteBufAllocator paramPooledByteBufAllocator, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    }
    
    private static byte[] newByteArray(int paramInt)
    {
      return PlatformDependent.allocateUninitializedArray(paramInt);
    }
    
    protected void destroyChunk(PoolChunk<byte[]> paramPoolChunk) {}
    
    boolean isDirect()
    {
      return false;
    }
    
    protected void memoryCopy(byte[] paramArrayOfByte, int paramInt1, PooledByteBuf<byte[]> paramPooledByteBuf, int paramInt2)
    {
      if (paramInt2 == 0) {
        return;
      }
      System.arraycopy(paramArrayOfByte, paramInt1, paramPooledByteBuf.memory, paramPooledByteBuf.offset, paramInt2);
    }
    
    protected PooledByteBuf<byte[]> newByteBuf(int paramInt)
    {
      Object localObject;
      if (PoolArena.HAS_UNSAFE) {
        localObject = PooledUnsafeHeapByteBuf.newUnsafeInstance(paramInt);
      } else {
        localObject = PooledHeapByteBuf.newInstance(paramInt);
      }
      return (PooledByteBuf<byte[]>)localObject;
    }
    
    protected PoolChunk<byte[]> newChunk(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      return new PoolChunk(this, newByteArray(paramInt4), paramInt1, paramInt2, paramInt3, paramInt4, 0);
    }
    
    protected PoolChunk<byte[]> newUnpooledChunk(int paramInt)
    {
      return new PoolChunk(this, newByteArray(paramInt), paramInt, 0);
    }
  }
  
  static enum SizeClass
  {
    static
    {
      SizeClass localSizeClass1 = new SizeClass("Tiny", 0);
      Tiny = localSizeClass1;
      SizeClass localSizeClass2 = new SizeClass("Small", 1);
      Small = localSizeClass2;
      SizeClass localSizeClass3 = new SizeClass("Normal", 2);
      Normal = localSizeClass3;
      $VALUES = new SizeClass[] { localSizeClass1, localSizeClass2, localSizeClass3 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\buffer\PoolArena.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */