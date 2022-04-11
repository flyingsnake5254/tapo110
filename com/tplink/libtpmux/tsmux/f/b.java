package com.tplink.libtpmux.tsmux.f;

public class b
{
  private int a;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  
  public int a()
  {
    return this.g & 0x3;
  }
  
  public int b()
  {
    return this.h & 0xF;
  }
  
  public int c()
  {
    return this.e & 0x1FFF;
  }
  
  public int d()
  {
    return this.c & 0x1;
  }
  
  public int e()
  {
    return this.a & 0xFF;
  }
  
  public int f()
  {
    return this.b & 0x1;
  }
  
  public int g()
  {
    return this.d & 0x1;
  }
  
  public int h()
  {
    return this.f & 0x3;
  }
  
  public void i(int paramInt)
  {
    this.g = (paramInt & 0x3);
  }
  
  public void j(int paramInt)
  {
    this.h = (paramInt & 0xF);
  }
  
  public void k(int paramInt)
  {
    this.e = (paramInt & 0x1FFF);
  }
  
  public void l(int paramInt)
  {
    this.c = (paramInt & 0x1);
  }
  
  public void m(int paramInt)
  {
    this.a = (paramInt & 0xFF);
  }
  
  public void n(int paramInt)
  {
    this.b = (paramInt & 0x1);
  }
  
  public void o(int paramInt)
  {
    this.d = (paramInt & 0x1);
  }
  
  public void p(int paramInt)
  {
    this.f = (paramInt & 0x3);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpmux\tsmux\f\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */