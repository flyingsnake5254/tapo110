package io.netty.buffer;

import io.netty.util.internal.StringUtil;
import java.util.List;

public final class PooledByteBufAllocatorMetric
  implements ByteBufAllocatorMetric
{
  private final PooledByteBufAllocator allocator;
  
  PooledByteBufAllocatorMetric(PooledByteBufAllocator paramPooledByteBufAllocator)
  {
    this.allocator = paramPooledByteBufAllocator;
  }
  
  public int chunkSize()
  {
    return this.allocator.chunkSize();
  }
  
  public List<PoolArenaMetric> directArenas()
  {
    return this.allocator.directArenas();
  }
  
  public List<PoolArenaMetric> heapArenas()
  {
    return this.allocator.heapArenas();
  }
  
  public int normalCacheSize()
  {
    return this.allocator.normalCacheSize();
  }
  
  public int numDirectArenas()
  {
    return this.allocator.numDirectArenas();
  }
  
  public int numHeapArenas()
  {
    return this.allocator.numHeapArenas();
  }
  
  public int numThreadLocalCaches()
  {
    return this.allocator.numThreadLocalCaches();
  }
  
  public int smallCacheSize()
  {
    return this.allocator.smallCacheSize();
  }
  
  public int tinyCacheSize()
  {
    return this.allocator.tinyCacheSize();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(256);
    localStringBuilder.append(StringUtil.simpleClassName(this));
    localStringBuilder.append("(usedHeapMemory: ");
    localStringBuilder.append(usedHeapMemory());
    localStringBuilder.append("; usedDirectMemory: ");
    localStringBuilder.append(usedDirectMemory());
    localStringBuilder.append("; numHeapArenas: ");
    localStringBuilder.append(numHeapArenas());
    localStringBuilder.append("; numDirectArenas: ");
    localStringBuilder.append(numDirectArenas());
    localStringBuilder.append("; tinyCacheSize: ");
    localStringBuilder.append(tinyCacheSize());
    localStringBuilder.append("; smallCacheSize: ");
    localStringBuilder.append(smallCacheSize());
    localStringBuilder.append("; normalCacheSize: ");
    localStringBuilder.append(normalCacheSize());
    localStringBuilder.append("; numThreadLocalCaches: ");
    localStringBuilder.append(numThreadLocalCaches());
    localStringBuilder.append("; chunkSize: ");
    localStringBuilder.append(chunkSize());
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  public long usedDirectMemory()
  {
    return this.allocator.usedDirectMemory();
  }
  
  public long usedHeapMemory()
  {
    return this.allocator.usedHeapMemory();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\buffer\PooledByteBufAllocatorMetric.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */