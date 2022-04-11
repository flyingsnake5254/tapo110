package com.tplink.libtpmediaother.memory;

public class q<T>
{
  private T a;
  private int b;
  
  public q(int paramInt, T paramT)
  {
    this.b = paramInt;
    this.a = paramT;
  }
  
  public T a()
  {
    return (T)this.a;
  }
  
  public int b()
  {
    return this.b;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpmediaother\memory\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */