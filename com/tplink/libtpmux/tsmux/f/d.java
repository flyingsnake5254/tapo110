package com.tplink.libtpmux.tsmux.f;

import java.util.ArrayList;
import java.util.List;

public class d
{
  private int a;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private List<e> l = new ArrayList();
  private int m;
  
  public int a()
  {
    return this.i & 0x1;
  }
  
  public int b()
  {
    return this.k & 0xFF;
  }
  
  public int c()
  {
    return this.d & 0x3;
  }
  
  public int d()
  {
    return this.g & 0x3;
  }
  
  public int e()
  {
    return this.e & 0xFFF;
  }
  
  public int f()
  {
    return this.j & 0xFF;
  }
  
  public int g()
  {
    return this.b & 0x1;
  }
  
  public int h()
  {
    return this.a & 0xFF;
  }
  
  public int i()
  {
    return this.f & 0xFFFF;
  }
  
  public int j()
  {
    return this.h & 0x1F;
  }
  
  public int k()
  {
    return this.c & 0x1;
  }
  
  public void l(int paramInt)
  {
    this.m = (paramInt & 0xFFFFFFFF);
  }
  
  public void m(int paramInt)
  {
    this.i = (paramInt & 0x1);
  }
  
  public void n(int paramInt)
  {
    this.k = (paramInt & 0xFF);
  }
  
  public void o(List<e> paramList)
  {
    this.l = paramList;
  }
  
  public void p(int paramInt)
  {
    this.d = (paramInt & 0x3);
  }
  
  public void q(int paramInt)
  {
    this.g = (paramInt & 0x3);
  }
  
  public void r(int paramInt)
  {
    this.e = (paramInt & 0xFFF);
  }
  
  public void s(int paramInt)
  {
    this.j = (paramInt & 0xFF);
  }
  
  public void t(int paramInt)
  {
    this.b = (paramInt & 0x1);
  }
  
  public void u(int paramInt)
  {
    this.a = (paramInt & 0xFF);
  }
  
  public void v(int paramInt)
  {
    this.f = (paramInt & 0xFFFF);
  }
  
  public void w(int paramInt)
  {
    this.h = (paramInt & 0x1F);
  }
  
  public void x(int paramInt)
  {
    this.c = (paramInt & 0x1);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpmux\tsmux\f\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */