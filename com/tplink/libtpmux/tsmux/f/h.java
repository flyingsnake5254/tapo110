package com.tplink.libtpmux.tsmux.f;

public class h
{
  private int a;
  private int b;
  private int c;
  private int d;
  private int e;
  
  public int a()
  {
    return this.e & 0xFFF;
  }
  
  public int b()
  {
    return this.c & 0x1FFF;
  }
  
  public int c()
  {
    return this.b & 0x7;
  }
  
  public int d()
  {
    return this.d & 0xF;
  }
  
  public int e()
  {
    return this.a & 0xFF;
  }
  
  public void f(int paramInt)
  {
    this.e = (paramInt & 0xFFF);
  }
  
  public void g(int paramInt)
  {
    this.c = (paramInt & 0x1FFF);
  }
  
  public void h(int paramInt)
  {
    this.b = (paramInt & 0x7);
  }
  
  public void i(int paramInt)
  {
    this.d = (paramInt & 0xF);
  }
  
  public void j(int paramInt)
  {
    this.a = (paramInt & 0xFF);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpmux\tsmux\f\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */