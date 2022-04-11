package com.google.android.exoplayer2.o2.k0;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.o2.k;
import com.google.android.exoplayer2.o2.m;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import java.io.IOException;

final class f
{
  public int a;
  public int b;
  public long c;
  public long d;
  public long e;
  public long f;
  public int g;
  public int h;
  public int i;
  public final int[] j = new int['ÿ'];
  private final d0 k = new d0(255);
  
  public boolean a(k paramk, boolean paramBoolean)
    throws IOException
  {
    b();
    this.k.L(27);
    byte[] arrayOfByte = this.k.d();
    int m = 0;
    if ((m.b(paramk, arrayOfByte, 0, 27, paramBoolean)) && (this.k.F() == 1332176723L))
    {
      int n = this.k.D();
      this.a = n;
      if (n != 0)
      {
        if (paramBoolean) {
          return false;
        }
        throw ParserException.createForUnsupportedContainerFeature("unsupported bit stream revision");
      }
      this.b = this.k.D();
      this.c = this.k.r();
      this.d = this.k.t();
      this.e = this.k.t();
      this.f = this.k.t();
      n = this.k.D();
      this.g = n;
      this.h = (n + 27);
      this.k.L(n);
      if (!m.b(paramk, this.k.d(), 0, this.g, paramBoolean)) {
        return false;
      }
      while (m < this.g)
      {
        this.j[m] = this.k.D();
        this.i += this.j[m];
        m++;
      }
      return true;
    }
    return false;
  }
  
  public void b()
  {
    this.a = 0;
    this.b = 0;
    this.c = 0L;
    this.d = 0L;
    this.e = 0L;
    this.f = 0L;
    this.g = 0;
    this.h = 0;
    this.i = 0;
  }
  
  public boolean c(k paramk)
    throws IOException
  {
    return d(paramk, -1L);
  }
  
  public boolean d(k paramk, long paramLong)
    throws IOException
  {
    boolean bool1;
    if (paramk.getPosition() == paramk.g()) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    g.a(bool1);
    this.k.L(4);
    boolean bool2;
    for (;;)
    {
      bool2 = paramLong < -1L;
      if (((bool2) && (paramk.getPosition() + 4L >= paramLong)) || (!m.b(paramk, this.k.d(), 0, 4, true))) {
        break;
      }
      this.k.P(0);
      if (this.k.F() == 1332176723L)
      {
        paramk.e();
        return true;
      }
      paramk.l(1);
    }
    while (((!bool2) || (paramk.getPosition() < paramLong)) && (paramk.i(1) != -1)) {}
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\k0\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */