package io.netty.buffer;

public abstract interface ByteBufAllocatorMetric
{
  public abstract long usedDirectMemory();
  
  public abstract long usedHeapMemory();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\buffer\ByteBufAllocatorMetric.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */