package io.netty.buffer;

import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.Deque;

final class PoolChunk<T>
  implements PoolChunkMetric
{
  private static final int INTEGER_SIZE_MINUS_ONE = 31;
  final PoolArena<T> arena;
  private final Deque<ByteBuffer> cachedNioBuffers;
  private final int chunkSize;
  private final byte[] depthMap;
  int freeBytes;
  private final int log2ChunkSize;
  private final int maxOrder;
  private final int maxSubpageAllocs;
  final T memory;
  private final byte[] memoryMap;
  PoolChunk<T> next;
  final int offset;
  private final int pageShifts;
  private final int pageSize;
  PoolChunkList<T> parent;
  PoolChunk<T> prev;
  private final int subpageOverflowMask;
  private final PoolSubpage<T>[] subpages;
  final boolean unpooled;
  private final byte unusable;
  
  PoolChunk(PoolArena<T> paramPoolArena, T paramT, int paramInt1, int paramInt2)
  {
    this.unpooled = true;
    this.arena = paramPoolArena;
    this.memory = paramT;
    this.offset = paramInt2;
    this.memoryMap = null;
    this.depthMap = null;
    this.subpages = null;
    this.subpageOverflowMask = 0;
    this.pageSize = 0;
    this.pageShifts = 0;
    this.maxOrder = 0;
    this.unusable = ((byte)(byte)(1 + 0));
    this.chunkSize = paramInt1;
    this.log2ChunkSize = log2(paramInt1);
    this.maxSubpageAllocs = 0;
    this.cachedNioBuffers = null;
  }
  
  PoolChunk(PoolArena<T> paramPoolArena, T paramT, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.unpooled = false;
    this.arena = paramPoolArena;
    this.memory = paramT;
    this.pageSize = paramInt1;
    this.pageShifts = paramInt3;
    this.maxOrder = paramInt2;
    this.chunkSize = paramInt4;
    this.offset = paramInt5;
    this.unusable = ((byte)(byte)(paramInt2 + 1));
    this.log2ChunkSize = log2(paramInt4);
    this.subpageOverflowMask = (paramInt1 - 1 ^ 0xFFFFFFFF);
    this.freeBytes = paramInt4;
    paramInt1 = 1 << paramInt2;
    this.maxSubpageAllocs = paramInt1;
    paramPoolArena = new byte[paramInt1 << 1];
    this.memoryMap = paramPoolArena;
    this.depthMap = new byte[paramPoolArena.length];
    paramInt1 = 0;
    paramInt4 = 1;
    while (paramInt1 <= paramInt2)
    {
      for (paramInt3 = 0; paramInt3 < 1 << paramInt1; paramInt3++)
      {
        paramPoolArena = this.memoryMap;
        paramInt5 = (byte)paramInt1;
        paramPoolArena[paramInt4] = ((byte)paramInt5);
        this.depthMap[paramInt4] = ((byte)paramInt5);
        paramInt4++;
      }
      paramInt1++;
    }
    this.subpages = newSubpageArray(this.maxSubpageAllocs);
    this.cachedNioBuffers = new ArrayDeque(8);
  }
  
  private int allocateNode(int paramInt)
  {
    int i = 1;
    int j = -(1 << paramInt);
    int k = value(1);
    int m = k;
    if (k > paramInt) {
      return -1;
    }
    for (;;)
    {
      if ((m >= paramInt) && ((i & j) != 0))
      {
        value(i);
        setValue(i, this.unusable);
        updateParentsAlloc(i);
        return i;
      }
      int n = i << 1;
      k = value(n);
      i = n;
      m = k;
      if (k > paramInt)
      {
        i = n ^ 0x1;
        m = value(i);
      }
    }
  }
  
  private long allocateRun(int paramInt)
  {
    paramInt = allocateNode(this.maxOrder - (log2(paramInt) - this.pageShifts));
    if (paramInt < 0) {
      return paramInt;
    }
    this.freeBytes -= runLength(paramInt);
    return paramInt;
  }
  
  private long allocateSubpage(int paramInt)
  {
    PoolSubpage localPoolSubpage1 = this.arena.findSubpagePoolHead(paramInt);
    int i = this.maxOrder;
    try
    {
      int j = allocateNode(i);
      if (j < 0)
      {
        l = j;
        return l;
      }
      PoolSubpage[] arrayOfPoolSubpage = this.subpages;
      i = this.pageSize;
      this.freeBytes -= i;
      int k = subpageIdx(j);
      PoolSubpage localPoolSubpage2 = arrayOfPoolSubpage[k];
      if (localPoolSubpage2 == null)
      {
        localPoolSubpage2 = new io/netty/buffer/PoolSubpage;
        localPoolSubpage2.<init>(localPoolSubpage1, this, j, runOffset(j), i, paramInt);
        arrayOfPoolSubpage[k] = localPoolSubpage2;
      }
      else
      {
        localPoolSubpage2.init(localPoolSubpage1, paramInt);
      }
      long l = localPoolSubpage2.allocate();
      return l;
    }
    finally {}
  }
  
  private static int bitmapIdx(long paramLong)
  {
    return (int)(paramLong >>> 32);
  }
  
  private byte depth(int paramInt)
  {
    return this.depthMap[paramInt];
  }
  
  private void initBufWithSubpage(PooledByteBuf<T> paramPooledByteBuf, ByteBuffer paramByteBuffer, long paramLong, int paramInt1, int paramInt2, PoolThreadCache paramPoolThreadCache)
  {
    int i = memoryMapIdx(paramLong);
    PoolSubpage localPoolSubpage = this.subpages[subpageIdx(i)];
    int j = runOffset(i);
    i = localPoolSubpage.elemSize;
    paramPooledByteBuf.init(this, paramByteBuffer, paramLong, j + (0x3FFFFFFF & paramInt1) * i + this.offset, paramInt2, i, paramPoolThreadCache);
  }
  
  private static int log2(int paramInt)
  {
    return 31 - Integer.numberOfLeadingZeros(paramInt);
  }
  
  private static int memoryMapIdx(long paramLong)
  {
    return (int)paramLong;
  }
  
  private PoolSubpage<T>[] newSubpageArray(int paramInt)
  {
    return new PoolSubpage[paramInt];
  }
  
  private int runLength(int paramInt)
  {
    return 1 << this.log2ChunkSize - depth(paramInt);
  }
  
  private int runOffset(int paramInt)
  {
    return (1 << depth(paramInt) ^ paramInt) * runLength(paramInt);
  }
  
  private void setValue(int paramInt, byte paramByte)
  {
    this.memoryMap[paramInt] = ((byte)paramByte);
  }
  
  private int subpageIdx(int paramInt)
  {
    return paramInt ^ this.maxSubpageAllocs;
  }
  
  private void updateParentsAlloc(int paramInt)
  {
    while (paramInt > 1)
    {
      int i = paramInt >>> 1;
      int j = value(paramInt);
      paramInt = value(paramInt ^ 0x1);
      int k;
      if (j < paramInt) {
        k = j;
      } else {
        k = paramInt;
      }
      setValue(i, k);
      paramInt = i;
    }
  }
  
  private void updateParentsFree(int paramInt)
  {
    int i = depth(paramInt) + 1;
    int j = paramInt;
    paramInt = i;
    while (j > 1)
    {
      i = j >>> 1;
      int k = value(j);
      j = value(j ^ 0x1);
      paramInt--;
      if ((k == paramInt) && (j == paramInt))
      {
        setValue(i, (byte)(paramInt - 1));
      }
      else
      {
        int m;
        if (k < j) {
          m = k;
        } else {
          m = j;
        }
        setValue(i, m);
      }
      j = i;
    }
  }
  
  private int usage(int paramInt)
  {
    if (paramInt == 0) {
      return 100;
    }
    paramInt = (int)(paramInt * 100L / this.chunkSize);
    if (paramInt == 0) {
      return 99;
    }
    return 100 - paramInt;
  }
  
  private byte value(int paramInt)
  {
    return this.memoryMap[paramInt];
  }
  
  boolean allocate(PooledByteBuf<T> paramPooledByteBuf, int paramInt1, int paramInt2, PoolThreadCache paramPoolThreadCache)
  {
    long l;
    if ((this.subpageOverflowMask & paramInt2) != 0) {
      l = allocateRun(paramInt2);
    } else {
      l = allocateSubpage(paramInt2);
    }
    if (l < 0L) {
      return false;
    }
    Object localObject = this.cachedNioBuffers;
    if (localObject != null) {
      localObject = (ByteBuffer)((Deque)localObject).pollLast();
    } else {
      localObject = null;
    }
    initBuf(paramPooledByteBuf, (ByteBuffer)localObject, l, paramInt1, paramPoolThreadCache);
    return true;
  }
  
  public int chunkSize()
  {
    return this.chunkSize;
  }
  
  void destroy()
  {
    this.arena.destroyChunk(this);
  }
  
  void free(long paramLong, ByteBuffer paramByteBuffer)
  {
    int i = memoryMapIdx(paramLong);
    int j = bitmapIdx(paramLong);
    if (j != 0)
    {
      PoolSubpage localPoolSubpage = this.subpages[subpageIdx(i)];
      synchronized (this.arena.findSubpagePoolHead(localPoolSubpage.elemSize))
      {
        if (localPoolSubpage.free((PoolSubpage)???, j & 0x3FFFFFFF)) {
          return;
        }
      }
    }
    this.freeBytes += runLength(i);
    setValue(i, depth(i));
    updateParentsFree(i);
    if (paramByteBuffer != null)
    {
      ??? = this.cachedNioBuffers;
      if ((??? != null) && (((Deque)???).size() < PooledByteBufAllocator.DEFAULT_MAX_CACHED_BYTEBUFFERS_PER_CHUNK)) {
        this.cachedNioBuffers.offer(paramByteBuffer);
      }
    }
  }
  
  public int freeBytes()
  {
    synchronized (this.arena)
    {
      int i = this.freeBytes;
      return i;
    }
  }
  
  void initBuf(PooledByteBuf<T> paramPooledByteBuf, ByteBuffer paramByteBuffer, long paramLong, int paramInt, PoolThreadCache paramPoolThreadCache)
  {
    int i = memoryMapIdx(paramLong);
    int j = bitmapIdx(paramLong);
    if (j == 0)
    {
      value(i);
      paramPooledByteBuf.init(this, paramByteBuffer, paramLong, runOffset(i) + this.offset, paramInt, runLength(i), paramPoolThreadCache);
    }
    else
    {
      initBufWithSubpage(paramPooledByteBuf, paramByteBuffer, paramLong, j, paramInt, paramPoolThreadCache);
    }
  }
  
  void initBufWithSubpage(PooledByteBuf<T> paramPooledByteBuf, ByteBuffer paramByteBuffer, long paramLong, int paramInt, PoolThreadCache paramPoolThreadCache)
  {
    initBufWithSubpage(paramPooledByteBuf, paramByteBuffer, paramLong, bitmapIdx(paramLong), paramInt, paramPoolThreadCache);
  }
  
  public String toString()
  {
    synchronized (this.arena)
    {
      int i = this.freeBytes;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Chunk(");
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      localStringBuilder.append(": ");
      localStringBuilder.append(usage(i));
      localStringBuilder.append("%, ");
      localStringBuilder.append(this.chunkSize - i);
      localStringBuilder.append('/');
      localStringBuilder.append(this.chunkSize);
      localStringBuilder.append(')');
      return localStringBuilder.toString();
    }
  }
  
  public int usage()
  {
    synchronized (this.arena)
    {
      int i = this.freeBytes;
      return usage(i);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\buffer\PoolChunk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */