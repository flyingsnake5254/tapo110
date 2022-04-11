package com.google.android.exoplayer2.text.s;

import android.text.Layout.Alignment;
import androidx.annotation.Nullable;

final class g
{
  @Nullable
  private String a;
  private int b;
  private boolean c;
  private int d;
  private boolean e;
  private int f = -1;
  private int g = -1;
  private int h = -1;
  private int i = -1;
  private int j = -1;
  private float k;
  @Nullable
  private String l;
  private int m = -1;
  private int n = -1;
  @Nullable
  private Layout.Alignment o;
  @Nullable
  private Layout.Alignment p;
  private int q = -1;
  @Nullable
  private b r;
  private float s = Float.MAX_VALUE;
  
  private g r(@Nullable g paramg, boolean paramBoolean)
  {
    if (paramg != null)
    {
      if ((!this.c) && (paramg.c)) {
        w(paramg.b);
      }
      if (this.h == -1) {
        this.h = paramg.h;
      }
      if (this.i == -1) {
        this.i = paramg.i;
      }
      Object localObject;
      if (this.a == null)
      {
        localObject = paramg.a;
        if (localObject != null) {
          this.a = ((String)localObject);
        }
      }
      if (this.f == -1) {
        this.f = paramg.f;
      }
      if (this.g == -1) {
        this.g = paramg.g;
      }
      if (this.n == -1) {
        this.n = paramg.n;
      }
      if (this.o == null)
      {
        localObject = paramg.o;
        if (localObject != null) {
          this.o = ((Layout.Alignment)localObject);
        }
      }
      if (this.p == null)
      {
        localObject = paramg.p;
        if (localObject != null) {
          this.p = ((Layout.Alignment)localObject);
        }
      }
      if (this.q == -1) {
        this.q = paramg.q;
      }
      if (this.j == -1)
      {
        this.j = paramg.j;
        this.k = paramg.k;
      }
      if (this.r == null) {
        this.r = paramg.r;
      }
      if (this.s == Float.MAX_VALUE) {
        this.s = paramg.s;
      }
      if ((paramBoolean) && (!this.e) && (paramg.e)) {
        u(paramg.d);
      }
      if ((paramBoolean) && (this.m == -1))
      {
        int i1 = paramg.m;
        if (i1 != -1) {
          this.m = i1;
        }
      }
    }
    return this;
  }
  
  public g A(@Nullable String paramString)
  {
    this.l = paramString;
    return this;
  }
  
  public g B(boolean paramBoolean)
  {
    this.i = paramBoolean;
    return this;
  }
  
  public g C(boolean paramBoolean)
  {
    this.f = paramBoolean;
    return this;
  }
  
  public g D(@Nullable Layout.Alignment paramAlignment)
  {
    this.p = paramAlignment;
    return this;
  }
  
  public g E(int paramInt)
  {
    this.n = paramInt;
    return this;
  }
  
  public g F(int paramInt)
  {
    this.m = paramInt;
    return this;
  }
  
  public g G(float paramFloat)
  {
    this.s = paramFloat;
    return this;
  }
  
  public g H(@Nullable Layout.Alignment paramAlignment)
  {
    this.o = paramAlignment;
    return this;
  }
  
  public g I(boolean paramBoolean)
  {
    this.q = paramBoolean;
    return this;
  }
  
  public g J(@Nullable b paramb)
  {
    this.r = paramb;
    return this;
  }
  
  public g K(boolean paramBoolean)
  {
    this.g = paramBoolean;
    return this;
  }
  
  public g a(@Nullable g paramg)
  {
    return r(paramg, true);
  }
  
  public int b()
  {
    if (this.e) {
      return this.d;
    }
    throw new IllegalStateException("Background color has not been defined.");
  }
  
  public int c()
  {
    if (this.c) {
      return this.b;
    }
    throw new IllegalStateException("Font color has not been defined.");
  }
  
  @Nullable
  public String d()
  {
    return this.a;
  }
  
  public float e()
  {
    return this.k;
  }
  
  public int f()
  {
    return this.j;
  }
  
  @Nullable
  public String g()
  {
    return this.l;
  }
  
  @Nullable
  public Layout.Alignment h()
  {
    return this.p;
  }
  
  public int i()
  {
    return this.n;
  }
  
  public int j()
  {
    return this.m;
  }
  
  public float k()
  {
    return this.s;
  }
  
  public int l()
  {
    int i1 = this.h;
    if ((i1 == -1) && (this.i == -1)) {
      return -1;
    }
    int i2 = 0;
    if (i1 == 1) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (this.i == 1) {
      i2 = 2;
    }
    return i1 | i2;
  }
  
  @Nullable
  public Layout.Alignment m()
  {
    return this.o;
  }
  
  public boolean n()
  {
    int i1 = this.q;
    boolean bool = true;
    if (i1 != 1) {
      bool = false;
    }
    return bool;
  }
  
  @Nullable
  public b o()
  {
    return this.r;
  }
  
  public boolean p()
  {
    return this.e;
  }
  
  public boolean q()
  {
    return this.c;
  }
  
  public boolean s()
  {
    int i1 = this.f;
    boolean bool = true;
    if (i1 != 1) {
      bool = false;
    }
    return bool;
  }
  
  public boolean t()
  {
    int i1 = this.g;
    boolean bool = true;
    if (i1 != 1) {
      bool = false;
    }
    return bool;
  }
  
  public g u(int paramInt)
  {
    this.d = paramInt;
    this.e = true;
    return this;
  }
  
  public g v(boolean paramBoolean)
  {
    this.h = paramBoolean;
    return this;
  }
  
  public g w(int paramInt)
  {
    this.b = paramInt;
    this.c = true;
    return this;
  }
  
  public g x(@Nullable String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public g y(float paramFloat)
  {
    this.k = paramFloat;
    return this;
  }
  
  public g z(int paramInt)
  {
    this.j = paramInt;
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\text\s\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */