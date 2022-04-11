package io.netty.util;

@Deprecated
public abstract interface ResourceLeak
{
  public abstract boolean close();
  
  public abstract void record();
  
  public abstract void record(Object paramObject);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\ResourceLeak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */