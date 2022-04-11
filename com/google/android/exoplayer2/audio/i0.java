package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.g;
import java.nio.ShortBuffer;
import java.util.Arrays;

final class i0
{
  private final int a;
  private final int b;
  private final float c;
  private final float d;
  private final float e;
  private final int f;
  private final int g;
  private final int h;
  private final short[] i;
  private short[] j;
  private int k;
  private short[] l;
  private int m;
  private short[] n;
  private int o;
  private int p;
  private int q;
  private int r;
  private int s;
  private int t;
  private int u;
  private int v;
  
  public i0(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, int paramInt3)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramFloat1;
    this.d = paramFloat2;
    this.e = (paramInt1 / paramInt3);
    this.f = (paramInt1 / 400);
    paramInt1 /= 65;
    this.g = paramInt1;
    paramInt1 *= 2;
    this.h = paramInt1;
    this.i = new short[paramInt1];
    this.j = new short[paramInt1 * paramInt2];
    this.l = new short[paramInt1 * paramInt2];
    this.n = new short[paramInt1 * paramInt2];
  }
  
  private void a(float paramFloat, int paramInt)
  {
    if (this.m == paramInt) {
      return;
    }
    int i1 = this.a;
    int i2 = (int)(i1 / paramFloat);
    for (;;)
    {
      if ((i2 <= 16384) && (i1 <= 16384))
      {
        o(paramInt);
        int i3;
        for (paramInt = 0;; paramInt++)
        {
          i3 = this.o;
          boolean bool = true;
          if (paramInt >= i3 - 1) {
            break;
          }
          int i4;
          for (;;)
          {
            i4 = this.p;
            i3 = this.q;
            if ((i4 + 1) * i2 <= i3 * i1) {
              break;
            }
            this.l = f(this.l, this.m, 1);
            for (i3 = 0;; i3++)
            {
              i4 = this.b;
              if (i3 >= i4) {
                break;
              }
              this.l[(this.m * i4 + i3)] = n(this.n, i4 * paramInt + i3, i1, i2);
            }
            this.q += 1;
            this.m += 1;
          }
          i4++;
          this.p = i4;
          if (i4 == i1)
          {
            this.p = 0;
            if (i3 != i2) {
              bool = false;
            }
            g.g(bool);
            this.q = 0;
          }
        }
        u(i3 - 1);
        return;
      }
      i2 /= 2;
      i1 /= 2;
    }
  }
  
  private void b(float paramFloat)
  {
    int i1 = this.k;
    if (i1 < this.h) {
      return;
    }
    int i2 = 0;
    int i3;
    do
    {
      if (this.r > 0) {
        i3 = c(i2);
      }
      for (;;)
      {
        i3 = i2 + i3;
        break;
        i3 = g(this.j, i2);
        if (paramFloat > 1.0D) {
          i3 += w(this.j, i2, paramFloat, i3);
        } else {
          i3 = m(this.j, i2, paramFloat, i3);
        }
      }
      i2 = i3;
    } while (this.h + i3 <= i1);
    v(i3);
  }
  
  private int c(int paramInt)
  {
    int i1 = Math.min(this.h, this.r);
    d(this.j, paramInt, i1);
    this.r -= i1;
    return i1;
  }
  
  private void d(short[] paramArrayOfShort, int paramInt1, int paramInt2)
  {
    short[] arrayOfShort = f(this.l, this.m, paramInt2);
    this.l = arrayOfShort;
    int i1 = this.b;
    System.arraycopy(paramArrayOfShort, paramInt1 * i1, arrayOfShort, this.m * i1, i1 * paramInt2);
    this.m += paramInt2;
  }
  
  private void e(short[] paramArrayOfShort, int paramInt1, int paramInt2)
  {
    int i1 = this.h / paramInt2;
    int i2 = this.b;
    int i3 = paramInt2 * i2;
    for (paramInt2 = 0; paramInt2 < i1; paramInt2++)
    {
      int i4 = 0;
      int i5 = 0;
      while (i4 < i3)
      {
        i5 += paramArrayOfShort[(paramInt2 * i3 + paramInt1 * i2 + i4)];
        i4++;
      }
      i5 /= i3;
      this.i[paramInt2] = ((short)(short)i5);
    }
  }
  
  private short[] f(short[] paramArrayOfShort, int paramInt1, int paramInt2)
  {
    int i1 = paramArrayOfShort.length;
    int i2 = this.b;
    i1 /= i2;
    if (paramInt1 + paramInt2 <= i1) {
      return paramArrayOfShort;
    }
    return Arrays.copyOf(paramArrayOfShort, (i1 * 3 / 2 + paramInt2) * i2);
  }
  
  private int g(short[] paramArrayOfShort, int paramInt)
  {
    int i1 = this.a;
    if (i1 > 4000) {
      i1 /= 4000;
    } else {
      i1 = 1;
    }
    if ((this.b == 1) && (i1 == 1))
    {
      paramInt = h(paramArrayOfShort, paramInt, this.f, this.g);
    }
    else
    {
      e(paramArrayOfShort, paramInt, i1);
      int i2 = h(this.i, 0, this.f / i1, this.g / i1);
      if (i1 != 1)
      {
        int i3 = i2 * i1;
        i1 *= 4;
        i2 = i3 - i1;
        i3 += i1;
        int i4 = this.f;
        i1 = i2;
        if (i2 < i4) {
          i1 = i4;
        }
        i4 = this.g;
        i2 = i3;
        if (i3 > i4) {
          i2 = i4;
        }
        if (this.b == 1)
        {
          paramInt = h(paramArrayOfShort, paramInt, i1, i2);
        }
        else
        {
          e(paramArrayOfShort, paramInt, 1);
          paramInt = h(this.i, 0, i1, i2);
        }
      }
      else
      {
        paramInt = i2;
      }
    }
    if (q(this.u, this.v)) {
      i1 = this.s;
    } else {
      i1 = paramInt;
    }
    this.t = this.u;
    this.s = paramInt;
    return i1;
  }
  
  private int h(short[] paramArrayOfShort, int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = paramInt1 * this.b;
    int i2 = 1;
    int i3 = 255;
    int i4 = 0;
    int i8;
    for (int i5 = 0; paramInt2 <= paramInt3; i5 = i8)
    {
      int i6 = 0;
      paramInt1 = 0;
      while (i6 < paramInt2)
      {
        paramInt1 += Math.abs(paramArrayOfShort[(i1 + i6)] - paramArrayOfShort[(i1 + paramInt2 + i6)]);
        i6++;
      }
      int i7 = i2;
      i6 = i4;
      if (paramInt1 * i4 < i2 * paramInt2)
      {
        i6 = paramInt2;
        i7 = paramInt1;
      }
      i4 = i3;
      i8 = i5;
      if (paramInt1 * i3 > i5 * paramInt2)
      {
        i4 = paramInt2;
        i8 = paramInt1;
      }
      paramInt2++;
      i2 = i7;
      i3 = i4;
      i4 = i6;
    }
    this.u = (i2 / i4);
    this.v = (i5 / i3);
    return i4;
  }
  
  private int m(short[] paramArrayOfShort, int paramInt1, float paramFloat, int paramInt2)
  {
    int i1;
    if (paramFloat < 0.5F)
    {
      i1 = (int)(paramInt2 * paramFloat / (1.0F - paramFloat));
    }
    else
    {
      this.r = ((int)(paramInt2 * (2.0F * paramFloat - 1.0F) / (1.0F - paramFloat)));
      i1 = paramInt2;
    }
    short[] arrayOfShort = this.l;
    int i2 = this.m;
    int i3 = paramInt2 + i1;
    arrayOfShort = f(arrayOfShort, i2, i3);
    this.l = arrayOfShort;
    i2 = this.b;
    System.arraycopy(paramArrayOfShort, paramInt1 * i2, arrayOfShort, this.m * i2, i2 * paramInt2);
    p(i1, this.b, this.l, this.m + paramInt2, paramArrayOfShort, paramInt1 + paramInt2, paramArrayOfShort, paramInt1);
    this.m += i3;
    return i1;
  }
  
  private short n(short[] paramArrayOfShort, int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = paramArrayOfShort[paramInt1];
    paramInt1 = paramArrayOfShort[(paramInt1 + this.b)];
    int i2 = this.q;
    int i3 = this.p;
    int i4 = (i3 + 1) * paramInt3;
    paramInt2 = i4 - i2 * paramInt2;
    paramInt3 = i4 - i3 * paramInt3;
    return (short)((i1 * paramInt2 + (paramInt3 - paramInt2) * paramInt1) / paramInt3);
  }
  
  private void o(int paramInt)
  {
    int i1 = this.m - paramInt;
    short[] arrayOfShort1 = f(this.n, this.o, i1);
    this.n = arrayOfShort1;
    short[] arrayOfShort2 = this.l;
    int i2 = this.b;
    System.arraycopy(arrayOfShort2, paramInt * i2, arrayOfShort1, this.o * i2, i2 * i1);
    this.m = paramInt;
    this.o += i1;
  }
  
  private static void p(int paramInt1, int paramInt2, short[] paramArrayOfShort1, int paramInt3, short[] paramArrayOfShort2, int paramInt4, short[] paramArrayOfShort3, int paramInt5)
  {
    for (int i1 = 0; i1 < paramInt2; i1++)
    {
      int i2 = paramInt3 * paramInt2 + i1;
      int i3 = paramInt5 * paramInt2 + i1;
      int i4 = paramInt4 * paramInt2 + i1;
      for (int i5 = 0; i5 < paramInt1; i5++)
      {
        paramArrayOfShort1[i2] = ((short)(short)((paramArrayOfShort2[i4] * (paramInt1 - i5) + paramArrayOfShort3[i3] * i5) / paramInt1));
        i2 += paramInt2;
        i4 += paramInt2;
        i3 += paramInt2;
      }
    }
  }
  
  private boolean q(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != 0) && (this.s != 0))
    {
      if (paramInt2 > paramInt1 * 3) {
        return false;
      }
      return paramInt1 * 2 > this.t * 3;
    }
    return false;
  }
  
  private void r()
  {
    int i1 = this.m;
    float f1 = this.c;
    float f2 = this.d;
    f1 /= f2;
    f2 = this.e * f2;
    double d1 = f1;
    if ((d1 <= 1.00001D) && (d1 >= 0.99999D))
    {
      d(this.j, 0, this.k);
      this.k = 0;
    }
    else
    {
      b(f1);
    }
    if (f2 != 1.0F) {
      a(f2, i1);
    }
  }
  
  private void u(int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    short[] arrayOfShort = this.n;
    int i1 = this.b;
    System.arraycopy(arrayOfShort, paramInt * i1, arrayOfShort, 0, (this.o - paramInt) * i1);
    this.o -= paramInt;
  }
  
  private void v(int paramInt)
  {
    int i1 = this.k - paramInt;
    short[] arrayOfShort = this.j;
    int i2 = this.b;
    System.arraycopy(arrayOfShort, paramInt * i2, arrayOfShort, 0, i2 * i1);
    this.k = i1;
  }
  
  private int w(short[] paramArrayOfShort, int paramInt1, float paramFloat, int paramInt2)
  {
    int i1;
    if (paramFloat >= 2.0F)
    {
      i1 = (int)(paramInt2 / (paramFloat - 1.0F));
    }
    else
    {
      this.r = ((int)(paramInt2 * (2.0F - paramFloat) / (paramFloat - 1.0F)));
      i1 = paramInt2;
    }
    short[] arrayOfShort = f(this.l, this.m, i1);
    this.l = arrayOfShort;
    p(i1, this.b, arrayOfShort, this.m, paramArrayOfShort, paramInt1, paramArrayOfShort, paramInt1 + paramInt2);
    this.m += i1;
    return i1;
  }
  
  public void i()
  {
    this.k = 0;
    this.m = 0;
    this.o = 0;
    this.p = 0;
    this.q = 0;
    this.r = 0;
    this.s = 0;
    this.t = 0;
    this.u = 0;
    this.v = 0;
  }
  
  public void j(ShortBuffer paramShortBuffer)
  {
    int i1 = Math.min(paramShortBuffer.remaining() / this.b, this.m);
    paramShortBuffer.put(this.l, 0, this.b * i1);
    int i2 = this.m - i1;
    this.m = i2;
    paramShortBuffer = this.l;
    int i3 = this.b;
    System.arraycopy(paramShortBuffer, i1 * i3, paramShortBuffer, 0, i2 * i3);
  }
  
  public int k()
  {
    return this.m * this.b * 2;
  }
  
  public int l()
  {
    return this.k * this.b * 2;
  }
  
  public void s()
  {
    int i1 = this.k;
    float f1 = this.c;
    float f2 = this.d;
    f1 /= f2;
    float f3 = this.e;
    int i2 = this.m + (int)((i1 / f1 + this.o) / (f3 * f2) + 0.5F);
    this.j = f(this.j, i1, this.h * 2 + i1);
    int i4;
    for (int i3 = 0;; i3++)
    {
      i4 = this.h;
      int i5 = this.b;
      if (i3 >= i4 * 2 * i5) {
        break;
      }
      this.j[(i5 * i1 + i3)] = ((short)0);
    }
    this.k += i4 * 2;
    r();
    if (this.m > i2) {
      this.m = i2;
    }
    this.k = 0;
    this.r = 0;
    this.o = 0;
  }
  
  public void t(ShortBuffer paramShortBuffer)
  {
    int i1 = paramShortBuffer.remaining();
    int i2 = this.b;
    i1 /= i2;
    short[] arrayOfShort = f(this.j, this.k, i1);
    this.j = arrayOfShort;
    paramShortBuffer.get(arrayOfShort, this.k * this.b, i2 * i1 * 2 / 2);
    this.k += i1;
    r();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\audio\i0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */