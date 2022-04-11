package io.netty.util.internal;

public abstract interface LongCounter
{
  public abstract void add(long paramLong);
  
  public abstract void decrement();
  
  public abstract void increment();
  
  public abstract long value();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\LongCounter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */