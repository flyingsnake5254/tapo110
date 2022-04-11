package com.tplink.libtpmux.tsmux.f;

public class c
{
  private long a;
  private int b;
  private int c;
  
  public long a()
  {
    return this.a & 0x1FFFFFFFF;
  }
  
  public int b()
  {
    return this.c & 0x1FF;
  }
  
  public int c()
  {
    return this.b & 0x3F;
  }
  
  public void d(long paramLong)
  {
    this.a = (paramLong & 0x1FFFFFFFF);
  }
  
  public void e(int paramInt)
  {
    this.c = (paramInt & 0x1FF);
  }
  
  public void f(int paramInt)
  {
    this.b = (paramInt & 0x3F);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpmux\tsmux\f\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */