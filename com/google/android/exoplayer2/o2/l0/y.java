package com.google.android.exoplayer2.o2.l0;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.o2.l;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.l0;
import com.google.android.exoplayer2.util.u;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class y
  implements i0
{
  private final o a;
  private final c0 b;
  private int c;
  private int d;
  private l0 e;
  private boolean f;
  private boolean g;
  private boolean h;
  private int i;
  private int j;
  private boolean k;
  private long l;
  
  public y(o paramo)
  {
    this.a = paramo;
    this.b = new c0(new byte[10]);
    this.c = 0;
  }
  
  private boolean d(d0 paramd0, @Nullable byte[] paramArrayOfByte, int paramInt)
  {
    int m = Math.min(paramd0.a(), paramInt - this.d);
    boolean bool = true;
    if (m <= 0) {
      return true;
    }
    if (paramArrayOfByte == null) {
      paramd0.Q(m);
    } else {
      paramd0.j(paramArrayOfByte, this.d, m);
    }
    m = this.d + m;
    this.d = m;
    if (m != paramInt) {
      bool = false;
    }
    return bool;
  }
  
  private boolean e()
  {
    this.b.p(0);
    int m = this.b.h(24);
    StringBuilder localStringBuilder;
    if (m != 1)
    {
      localStringBuilder = new StringBuilder(41);
      localStringBuilder.append("Unexpected start code prefix: ");
      localStringBuilder.append(m);
      u.h("PesReader", localStringBuilder.toString());
      this.j = -1;
      return false;
    }
    this.b.r(8);
    int n = this.b.h(16);
    this.b.r(5);
    this.k = this.b.g();
    this.b.r(2);
    this.f = this.b.g();
    this.g = this.b.g();
    this.b.r(6);
    m = this.b.h(8);
    this.i = m;
    if (n == 0)
    {
      this.j = -1;
    }
    else
    {
      m = n + 6 - 9 - m;
      this.j = m;
      if (m < 0)
      {
        localStringBuilder = new StringBuilder(47);
        localStringBuilder.append("Found negative packet payload size: ");
        localStringBuilder.append(m);
        u.h("PesReader", localStringBuilder.toString());
        this.j = -1;
      }
    }
    return true;
  }
  
  @RequiresNonNull({"timestampAdjuster"})
  private void f()
  {
    this.b.p(0);
    this.l = -9223372036854775807L;
    if (this.f)
    {
      this.b.r(4);
      long l1 = this.b.h(3);
      this.b.r(1);
      long l2 = this.b.h(15) << 15;
      this.b.r(1);
      long l3 = this.b.h(15);
      this.b.r(1);
      if ((!this.h) && (this.g))
      {
        this.b.r(4);
        long l4 = this.b.h(3);
        this.b.r(1);
        long l5 = this.b.h(15) << 15;
        this.b.r(1);
        long l6 = this.b.h(15);
        this.b.r(1);
        this.e.b(l4 << 30 | l5 | l6);
        this.h = true;
      }
      this.l = this.e.b(l1 << 30 | l2 | l3);
    }
  }
  
  private void g(int paramInt)
  {
    this.c = paramInt;
    this.d = 0;
  }
  
  public void a(l0 paraml0, l paraml, i0.d paramd)
  {
    this.e = paraml0;
    this.a.d(paraml, paramd);
  }
  
  public final void b(d0 paramd0, int paramInt)
    throws ParserException
  {
    g.i(this.e);
    int m = paramInt;
    if ((paramInt & 0x1) != 0)
    {
      m = this.c;
      if ((m != 0) && (m != 1)) {
        if (m != 2)
        {
          if (m == 3)
          {
            m = this.j;
            if (m != -1)
            {
              StringBuilder localStringBuilder = new StringBuilder(59);
              localStringBuilder.append("Unexpected start indicator: expected ");
              localStringBuilder.append(m);
              localStringBuilder.append(" more bytes");
              u.h("PesReader", localStringBuilder.toString());
            }
            this.a.e();
          }
          else
          {
            throw new IllegalStateException();
          }
        }
        else {
          u.h("PesReader", "Unexpected start indicator reading extended header");
        }
      }
      g(1);
      m = paramInt;
    }
    while (paramd0.a() > 0)
    {
      int n = this.c;
      if (n != 0)
      {
        paramInt = 0;
        int i1 = 0;
        int i2 = 0;
        if (n != 1)
        {
          if (n != 2)
          {
            if (n == 3)
            {
              i1 = paramd0.a();
              paramInt = this.j;
              if (paramInt != -1) {
                i2 = i1 - paramInt;
              }
              paramInt = i1;
              if (i2 > 0)
              {
                paramInt = i1 - i2;
                paramd0.O(paramd0.e() + paramInt);
              }
              this.a.b(paramd0);
              i2 = this.j;
              if (i2 != -1)
              {
                paramInt = i2 - paramInt;
                this.j = paramInt;
                if (paramInt == 0)
                {
                  this.a.e();
                  g(1);
                }
              }
            }
            else
            {
              throw new IllegalStateException();
            }
          }
          else
          {
            i2 = Math.min(10, this.i);
            if ((d(paramd0, this.b.a, i2)) && (d(paramd0, null, this.i)))
            {
              f();
              if (this.k) {
                paramInt = 4;
              }
              m |= paramInt;
              this.a.f(this.l, m);
              g(3);
            }
          }
        }
        else if (d(paramd0, this.b.a, 9))
        {
          paramInt = i1;
          if (e()) {
            paramInt = 2;
          }
          g(paramInt);
        }
      }
      else
      {
        paramd0.Q(paramd0.a());
      }
    }
  }
  
  public final void c()
  {
    this.c = 0;
    this.d = 0;
    this.h = false;
    this.a.c();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\l0\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */