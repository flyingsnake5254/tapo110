package com.tplink.libtpmux.tsmux.f;

public class e
{
  private int a;
  private int b;
  private int c;
  
  public int a()
  {
    return this.c & 0x1FFF;
  }
  
  public int b()
  {
    return this.a & 0xFFFF;
  }
  
  public int c()
  {
    return this.b & 0x7;
  }
  
  public void d(int paramInt)
  {
    this.c = (paramInt & 0x1FFF);
  }
  
  public void e(int paramInt)
  {
    this.a = (paramInt & 0xFFFF);
  }
  
  public void f(int paramInt)
  {
    this.b = (paramInt & 0x7);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpmux\tsmux\f\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */