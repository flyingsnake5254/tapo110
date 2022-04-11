package io.netty.util;

public abstract interface ResourceLeakTracker<T>
{
  public abstract boolean close(T paramT);
  
  public abstract void record();
  
  public abstract void record(Object paramObject);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\ResourceLeakTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */