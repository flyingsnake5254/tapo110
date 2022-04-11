package com.tplink.libtpmux.tsmux.f;

public class i
{
  private int a;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  
  public int a()
  {
    return this.a & 0xF;
  }
  
  public int b()
  {
    return this.b & 0x7;
  }
  
  public int c()
  {
    return this.d & 0x7FFF;
  }
  
  public int d()
  {
    return this.f & 0x7FFF;
  }
  
  public int e()
  {
    return this.c & 0x1;
  }
  
  public int f()
  {
    return this.e & 0x1;
  }
  
  public int g()
  {
    return this.g & 0x1;
  }
  
  public void h(int paramInt)
  {
    this.a = (paramInt & 0xF);
  }
  
  public void i(int paramInt)
  {
    this.b = (paramInt & 0x7);
  }
  
  public void j(int paramInt)
  {
    this.d = (paramInt & 0x7FFF);
  }
  
  public void k(int paramInt)
  {
    this.f = (paramInt & 0x7FFF);
  }
  
  public void l(int paramInt)
  {
    this.c = (paramInt & 0x1);
  }
  
  public void m(int paramInt)
  {
    this.e = (paramInt & 0x1);
  }
  
  public void n(int paramInt)
  {
    this.g = (paramInt & 0x1);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpmux\tsmux\f\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */