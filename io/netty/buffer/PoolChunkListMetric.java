package io.netty.buffer;

public abstract interface PoolChunkListMetric
  extends Iterable<PoolChunkMetric>
{
  public abstract int maxUsage();
  
  public abstract int minUsage();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\buffer\PoolChunkListMetric.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */