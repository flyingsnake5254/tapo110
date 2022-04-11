package io.netty.buffer;

import io.netty.util.internal.StringUtil;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

final class PoolChunkList<T>
  implements PoolChunkListMetric
{
  private static final Iterator<PoolChunkMetric> EMPTY_METRICS = Collections.emptyList().iterator();
  private final PoolArena<T> arena;
  private final int freeMaxThreshold;
  private final int freeMinThreshold;
  private PoolChunk<T> head;
  private final int maxCapacity;
  private final int maxUsage;
  private final int minUsage;
  private final PoolChunkList<T> nextList;
  private PoolChunkList<T> prevList;
  
  PoolChunkList(PoolArena<T> paramPoolArena, PoolChunkList<T> paramPoolChunkList, int paramInt1, int paramInt2, int paramInt3)
  {
    this.arena = paramPoolArena;
    this.nextList = paramPoolChunkList;
    this.minUsage = paramInt1;
    this.maxUsage = paramInt2;
    this.maxCapacity = calculateMaxCapacity(paramInt1, paramInt3);
    int i = 0;
    if (paramInt2 == 100) {
      paramInt2 = 0;
    } else {
      paramInt2 = (int)(paramInt3 * (100.0D - paramInt2 + 0.99999999D) / 100.0D);
    }
    this.freeMinThreshold = paramInt2;
    if (paramInt1 == 100) {
      paramInt1 = i;
    } else {
      paramInt1 = (int)(paramInt3 * (100.0D - paramInt1 + 0.99999999D) / 100.0D);
    }
    this.freeMaxThreshold = paramInt1;
  }
  
  private static int calculateMaxCapacity(int paramInt1, int paramInt2)
  {
    paramInt1 = minUsage0(paramInt1);
    if (paramInt1 == 100) {
      return 0;
    }
    return (int)(paramInt2 * (100L - paramInt1) / 100L);
  }
  
  private static int minUsage0(int paramInt)
  {
    return Math.max(1, paramInt);
  }
  
  private boolean move(PoolChunk<T> paramPoolChunk)
  {
    if (paramPoolChunk.freeBytes > this.freeMaxThreshold) {
      return move0(paramPoolChunk);
    }
    add0(paramPoolChunk);
    return true;
  }
  
  private boolean move0(PoolChunk<T> paramPoolChunk)
  {
    PoolChunkList localPoolChunkList = this.prevList;
    if (localPoolChunkList == null) {
      return false;
    }
    return localPoolChunkList.move(paramPoolChunk);
  }
  
  private void remove(PoolChunk<T> paramPoolChunk)
  {
    if (paramPoolChunk == this.head)
    {
      paramPoolChunk = paramPoolChunk.next;
      this.head = paramPoolChunk;
      if (paramPoolChunk != null) {
        paramPoolChunk.prev = null;
      }
    }
    else
    {
      PoolChunk localPoolChunk = paramPoolChunk.next;
      paramPoolChunk = paramPoolChunk.prev;
      paramPoolChunk.next = localPoolChunk;
      if (localPoolChunk != null) {
        localPoolChunk.prev = paramPoolChunk;
      }
    }
  }
  
  void add(PoolChunk<T> paramPoolChunk)
  {
    if (paramPoolChunk.freeBytes <= this.freeMinThreshold)
    {
      this.nextList.add(paramPoolChunk);
      return;
    }
    add0(paramPoolChunk);
  }
  
  void add0(PoolChunk<T> paramPoolChunk)
  {
    paramPoolChunk.parent = this;
    PoolChunk localPoolChunk = this.head;
    if (localPoolChunk == null)
    {
      this.head = paramPoolChunk;
      paramPoolChunk.prev = null;
      paramPoolChunk.next = null;
    }
    else
    {
      paramPoolChunk.prev = null;
      paramPoolChunk.next = localPoolChunk;
      localPoolChunk.prev = paramPoolChunk;
      this.head = paramPoolChunk;
    }
  }
  
  boolean allocate(PooledByteBuf<T> paramPooledByteBuf, int paramInt1, int paramInt2, PoolThreadCache paramPoolThreadCache)
  {
    if (paramInt2 > this.maxCapacity) {
      return false;
    }
    for (PoolChunk localPoolChunk = this.head; localPoolChunk != null; localPoolChunk = localPoolChunk.next) {
      if (localPoolChunk.allocate(paramPooledByteBuf, paramInt1, paramInt2, paramPoolThreadCache))
      {
        if (localPoolChunk.freeBytes <= this.freeMinThreshold)
        {
          remove(localPoolChunk);
          this.nextList.add(localPoolChunk);
        }
        return true;
      }
    }
    return false;
  }
  
  void destroy(PoolArena<T> paramPoolArena)
  {
    for (PoolChunk localPoolChunk = this.head; localPoolChunk != null; localPoolChunk = localPoolChunk.next) {
      paramPoolArena.destroyChunk(localPoolChunk);
    }
    this.head = null;
  }
  
  boolean free(PoolChunk<T> paramPoolChunk, long paramLong, ByteBuffer paramByteBuffer)
  {
    paramPoolChunk.free(paramLong, paramByteBuffer);
    if (paramPoolChunk.freeBytes > this.freeMaxThreshold)
    {
      remove(paramPoolChunk);
      return move0(paramPoolChunk);
    }
    return true;
  }
  
  public Iterator<PoolChunkMetric> iterator()
  {
    synchronized (this.arena)
    {
      if (this.head == null)
      {
        localObject1 = EMPTY_METRICS;
        return (Iterator<PoolChunkMetric>)localObject1;
      }
      ArrayList localArrayList = new java/util/ArrayList;
      localArrayList.<init>();
      Object localObject1 = this.head;
      PoolChunk localPoolChunk;
      do
      {
        localArrayList.add(localObject1);
        localPoolChunk = ((PoolChunk)localObject1).next;
        localObject1 = localPoolChunk;
      } while (localPoolChunk != null);
      localObject1 = localArrayList.iterator();
      return (Iterator<PoolChunkMetric>)localObject1;
    }
  }
  
  public int maxUsage()
  {
    return Math.min(this.maxUsage, 100);
  }
  
  public int minUsage()
  {
    return minUsage0(this.minUsage);
  }
  
  void prevList(PoolChunkList<T> paramPoolChunkList)
  {
    this.prevList = paramPoolChunkList;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    synchronized (this.arena)
    {
      PoolChunk localPoolChunk1 = this.head;
      PoolChunk localPoolChunk2 = localPoolChunk1;
      if (localPoolChunk1 == null) {
        return "none";
      }
      localStringBuilder.append(localPoolChunk2);
      localPoolChunk2 = localPoolChunk2.next;
      if (localPoolChunk2 == null) {
        return localStringBuilder.toString();
      }
      localStringBuilder.append(StringUtil.NEWLINE);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\buffer\PoolChunkList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */