package io.netty.buffer;

final class PoolSubpage<T>
  implements PoolSubpageMetric
{
  private final long[] bitmap;
  private int bitmapLength;
  final PoolChunk<T> chunk;
  boolean doNotDestroy;
  int elemSize;
  private int maxNumElems;
  private final int memoryMapIdx;
  PoolSubpage<T> next;
  private int nextAvail;
  private int numAvail;
  private final int pageSize;
  PoolSubpage<T> prev;
  private final int runOffset;
  
  PoolSubpage(int paramInt)
  {
    this.chunk = null;
    this.memoryMapIdx = -1;
    this.runOffset = -1;
    this.elemSize = -1;
    this.pageSize = paramInt;
    this.bitmap = null;
  }
  
  PoolSubpage(PoolSubpage<T> paramPoolSubpage, PoolChunk<T> paramPoolChunk, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.chunk = paramPoolChunk;
    this.memoryMapIdx = paramInt1;
    this.runOffset = paramInt2;
    this.pageSize = paramInt3;
    this.bitmap = new long[paramInt3 >>> 10];
    init(paramPoolSubpage, paramInt4);
  }
  
  private void addToPool(PoolSubpage<T> paramPoolSubpage)
  {
    this.prev = paramPoolSubpage;
    PoolSubpage localPoolSubpage = paramPoolSubpage.next;
    this.next = localPoolSubpage;
    localPoolSubpage.prev = this;
    paramPoolSubpage.next = this;
  }
  
  private int findNextAvail()
  {
    long[] arrayOfLong = this.bitmap;
    int i = this.bitmapLength;
    for (int j = 0; j < i; j++)
    {
      long l = arrayOfLong[j];
      if ((l ^ 0xFFFFFFFFFFFFFFFF) != 0L) {
        return findNextAvail0(j, l);
      }
    }
    return -1;
  }
  
  private int findNextAvail0(int paramInt, long paramLong)
  {
    int i = this.maxNumElems;
    for (int j = 0; j < 64; j++)
    {
      if ((1L & paramLong) == 0L)
      {
        paramInt = paramInt << 6 | j;
        if (paramInt >= i) {
          break;
        }
        return paramInt;
      }
      paramLong >>>= 1;
    }
    return -1;
  }
  
  private int getNextAvail()
  {
    int i = this.nextAvail;
    if (i >= 0)
    {
      this.nextAvail = -1;
      return i;
    }
    return findNextAvail();
  }
  
  private void removeFromPool()
  {
    PoolSubpage localPoolSubpage = this.prev;
    localPoolSubpage.next = this.next;
    this.next.prev = localPoolSubpage;
    this.next = null;
    this.prev = null;
  }
  
  private void setNextAvail(int paramInt)
  {
    this.nextAvail = paramInt;
  }
  
  private long toHandle(int paramInt)
  {
    return paramInt << 32 | 0x4000000000000000 | this.memoryMapIdx;
  }
  
  long allocate()
  {
    if (this.elemSize == 0) {
      return toHandle(0);
    }
    if ((this.numAvail != 0) && (this.doNotDestroy))
    {
      int i = getNextAvail();
      int j = i >>> 6;
      long[] arrayOfLong = this.bitmap;
      arrayOfLong[j] |= 1L << (i & 0x3F);
      j = this.numAvail - 1;
      this.numAvail = j;
      if (j == 0) {
        removeFromPool();
      }
      return toHandle(i);
    }
    return -1L;
  }
  
  void destroy()
  {
    PoolChunk localPoolChunk = this.chunk;
    if (localPoolChunk != null) {
      localPoolChunk.destroy();
    }
  }
  
  public int elementSize()
  {
    PoolChunk localPoolChunk = this.chunk;
    if (localPoolChunk == null) {
      return -1;
    }
    synchronized (localPoolChunk.arena)
    {
      int i = this.elemSize;
      return i;
    }
  }
  
  boolean free(PoolSubpage<T> paramPoolSubpage, int paramInt)
  {
    if (this.elemSize == 0) {
      return true;
    }
    int i = paramInt >>> 6;
    long[] arrayOfLong = this.bitmap;
    arrayOfLong[i] ^= 1L << (paramInt & 0x3F);
    setNextAvail(paramInt);
    i = this.numAvail;
    paramInt = i + 1;
    this.numAvail = paramInt;
    if (i == 0)
    {
      addToPool(paramPoolSubpage);
      return true;
    }
    if (paramInt != this.maxNumElems) {
      return true;
    }
    if (this.prev == this.next) {
      return true;
    }
    this.doNotDestroy = false;
    removeFromPool();
    return false;
  }
  
  void init(PoolSubpage<T> paramPoolSubpage, int paramInt)
  {
    this.doNotDestroy = true;
    this.elemSize = paramInt;
    if (paramInt != 0)
    {
      int i = this.pageSize / paramInt;
      this.numAvail = i;
      this.maxNumElems = i;
      int j = 0;
      this.nextAvail = 0;
      int k = i >>> 6;
      this.bitmapLength = k;
      paramInt = j;
      if ((i & 0x3F) != 0) {
        this.bitmapLength = (k + 1);
      }
      for (paramInt = j; paramInt < this.bitmapLength; paramInt++) {
        this.bitmap[paramInt] = 0L;
      }
    }
    addToPool(paramPoolSubpage);
  }
  
  public int maxNumElements()
  {
    ??? = this.chunk;
    if (??? == null) {
      return 0;
    }
    synchronized (((PoolChunk)???).arena)
    {
      int i = this.maxNumElems;
      return i;
    }
  }
  
  public int numAvailable()
  {
    ??? = this.chunk;
    if (??? == null) {
      return 0;
    }
    synchronized (((PoolChunk)???).arena)
    {
      int i = this.numAvail;
      return i;
    }
  }
  
  public int pageSize()
  {
    return this.pageSize;
  }
  
  public String toString()
  {
    Object localObject1 = this.chunk;
    int i = -1;
    int j = 1;
    int k = 1;
    int m = 0;
    int n;
    if (localObject1 == null)
    {
      n = 0;
      k = j;
    }
    synchronized (((PoolChunk)localObject1).arena)
    {
      if (!this.doNotDestroy)
      {
        k = 0;
        n = -1;
        m = -1;
      }
      else
      {
        i = this.maxNumElems;
        n = this.numAvail;
        m = this.elemSize;
      }
      j = i;
      i = m;
      m = j;
      if (k == 0)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("(");
        ((StringBuilder)localObject1).append(this.memoryMapIdx);
        ((StringBuilder)localObject1).append(": not in use)");
        return ((StringBuilder)localObject1).toString();
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("(");
      ((StringBuilder)localObject1).append(this.memoryMapIdx);
      ((StringBuilder)localObject1).append(": ");
      ((StringBuilder)localObject1).append(m - n);
      ((StringBuilder)localObject1).append('/');
      ((StringBuilder)localObject1).append(m);
      ((StringBuilder)localObject1).append(", offset: ");
      ((StringBuilder)localObject1).append(this.runOffset);
      ((StringBuilder)localObject1).append(", length: ");
      ((StringBuilder)localObject1).append(this.pageSize);
      ((StringBuilder)localObject1).append(", elemSize: ");
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).append(')');
      return ((StringBuilder)localObject1).toString();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\buffer\PoolSubpage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */