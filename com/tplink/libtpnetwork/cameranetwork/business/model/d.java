package com.tplink.libtpnetwork.cameranetwork.business.model;

import androidx.annotation.Nullable;

public class d
{
  private int a;
  private int b;
  private int c;
  private int d;
  
  public d() {}
  
  public d(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
  }
  
  public int a()
  {
    return this.d;
  }
  
  public int b()
  {
    return this.c;
  }
  
  public int c()
  {
    return this.a;
  }
  
  public int d()
  {
    return this.b;
  }
  
  public void e(int paramInt)
  {
    this.d = paramInt;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool1 = paramObject instanceof d;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    if (paramObject == this) {
      return true;
    }
    paramObject = (d)paramObject;
    bool1 = bool2;
    if (((d)paramObject).a == this.a)
    {
      bool1 = bool2;
      if (((d)paramObject).b == this.b)
      {
        bool1 = bool2;
        if (((d)paramObject).c == this.c)
        {
          bool1 = bool2;
          if (((d)paramObject).d == this.d) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public void f(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void g(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void h(int paramInt)
  {
    this.b = paramInt;
  }
  
  public int hashCode()
  {
    return ((this.a * 31 + this.b) * 31 + this.c) * 31 + this.d;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\business\model\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */