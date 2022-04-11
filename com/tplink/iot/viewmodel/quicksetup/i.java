package com.tplink.iot.viewmodel.quicksetup;

public class i<T>
{
  private int a;
  private T b;
  
  public i(int paramInt, T paramT)
  {
    this.a = paramInt;
    this.b = paramT;
  }
  
  public T a()
  {
    return (T)this.b;
  }
  
  public int b()
  {
    return this.a;
  }
  
  public void c(T paramT)
  {
    this.b = paramT;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\quicksetup\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */