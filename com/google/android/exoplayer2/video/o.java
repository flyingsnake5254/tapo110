package com.google.android.exoplayer2.video;

import java.util.Arrays;

final class o
{
  private a a = new a();
  private a b = new a();
  private boolean c;
  private boolean d;
  private long e = -9223372036854775807L;
  private int f;
  
  public long a()
  {
    long l;
    if (e()) {
      l = this.a.a();
    } else {
      l = -9223372036854775807L;
    }
    return l;
  }
  
  public float b()
  {
    float f1;
    if (e()) {
      f1 = (float)(1.0E9D / this.a.a());
    } else {
      f1 = -1.0F;
    }
    return f1;
  }
  
  public int c()
  {
    return this.f;
  }
  
  public long d()
  {
    long l;
    if (e()) {
      l = this.a.b();
    } else {
      l = -9223372036854775807L;
    }
    return l;
  }
  
  public boolean e()
  {
    return this.a.e();
  }
  
  public void f(long paramLong)
  {
    this.a.f(paramLong);
    boolean bool = this.a.e();
    int i = 0;
    if ((bool) && (!this.d))
    {
      this.c = false;
    }
    else if (this.e != -9223372036854775807L)
    {
      if ((!this.c) || (this.b.d()))
      {
        this.b.g();
        this.b.f(this.e);
      }
      this.c = true;
      this.b.f(paramLong);
    }
    if ((this.c) && (this.b.e()))
    {
      a locala = this.a;
      this.a = this.b;
      this.b = locala;
      this.c = false;
      this.d = false;
    }
    this.e = paramLong;
    if (!this.a.e()) {
      i = this.f + 1;
    }
    this.f = i;
  }
  
  public void g()
  {
    this.a.g();
    this.b.g();
    this.c = false;
    this.e = -9223372036854775807L;
    this.f = 0;
  }
  
  private static final class a
  {
    private long a;
    private long b;
    private long c;
    private long d;
    private long e;
    private long f;
    private final boolean[] g = new boolean[15];
    private int h;
    
    private static int c(long paramLong)
    {
      return (int)(paramLong % 15L);
    }
    
    public long a()
    {
      long l1 = this.e;
      long l2 = 0L;
      if (l1 != 0L) {
        l2 = this.f / l1;
      }
      return l2;
    }
    
    public long b()
    {
      return this.f;
    }
    
    public boolean d()
    {
      long l = this.d;
      if (l == 0L) {
        return false;
      }
      return this.g[c(l - 1L)];
    }
    
    public boolean e()
    {
      boolean bool;
      if ((this.d > 15L) && (this.h == 0)) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public void f(long paramLong)
    {
      long l1 = this.d;
      if (l1 == 0L)
      {
        this.a = paramLong;
      }
      else
      {
        long l2;
        if (l1 == 1L)
        {
          l2 = paramLong - this.a;
          this.b = l2;
          this.f = l2;
          this.e = 1L;
        }
        else
        {
          l2 = paramLong - this.c;
          int i = c(l1);
          boolean[] arrayOfBoolean;
          if (Math.abs(l2 - this.b) <= 1000000L)
          {
            this.e += 1L;
            this.f += l2;
            arrayOfBoolean = this.g;
            if (arrayOfBoolean[i] != 0)
            {
              arrayOfBoolean[i] = false;
              this.h -= 1;
            }
          }
          else
          {
            arrayOfBoolean = this.g;
            if (arrayOfBoolean[i] == 0)
            {
              arrayOfBoolean[i] = true;
              this.h += 1;
            }
          }
        }
      }
      this.d += 1L;
      this.c = paramLong;
    }
    
    public void g()
    {
      this.d = 0L;
      this.e = 0L;
      this.f = 0L;
      this.h = 0;
      Arrays.fill(this.g, false);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\video\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */