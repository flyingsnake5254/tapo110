package com.tplink.libtpimagedownloadmedia.loader;

import androidx.annotation.NonNull;

public class g
{
  @NonNull
  private String a;
  private String b;
  private int c;
  private int d;
  private int e;
  
  public g(String paramString1, int paramInt, String paramString2)
  {
    this.a = paramString1;
    this.c = paramInt;
    this.b = paramString2;
    this.e = 0;
    this.d = 2;
  }
  
  public int a()
  {
    return this.c;
  }
  
  public String b()
  {
    return this.a;
  }
  
  public String c()
  {
    return this.b;
  }
  
  public int d()
  {
    return this.d;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof g)) {
      return false;
    }
    paramObject = (g)paramObject;
    if (!b().equals(((g)paramObject).b())) {
      return false;
    }
    if (!c().equals(((g)paramObject).c())) {
      return false;
    }
    if (d() != ((g)paramObject).d()) {
      bool = false;
    }
    return bool;
  }
  
  public int hashCode()
  {
    return c().hashCode() * 31 + b().hashCode();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpimagedownloadmedia\loader\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */