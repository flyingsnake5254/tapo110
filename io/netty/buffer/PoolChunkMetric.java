package io.netty.buffer;

public abstract interface PoolChunkMetric
{
  public abstract int chunkSize();
  
  public abstract int freeBytes();
  
  public abstract int usage();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\buffer\PoolChunkMetric.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */