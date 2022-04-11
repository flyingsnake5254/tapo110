package com.google.android.exoplayer2.o2.l0;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format.b;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.m;
import com.google.android.exoplayer2.audio.m.b;
import com.google.android.exoplayer2.o2.b0;
import com.google.android.exoplayer2.o2.i;
import com.google.android.exoplayer2.o2.l;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;
import java.util.Arrays;
import java.util.Collections;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class k
  implements o
{
  private static final byte[] a = { 73, 68, 51 };
  private final boolean b;
  private final c0 c = new c0(new byte[7]);
  private final d0 d = new d0(Arrays.copyOf(a, 10));
  @Nullable
  private final String e;
  private String f;
  private b0 g;
  private b0 h;
  private int i;
  private int j;
  private int k;
  private boolean l;
  private boolean m;
  private int n;
  private int o;
  private int p;
  private boolean q;
  private long r;
  private int s;
  private long t;
  private b0 u;
  private long v;
  
  public k(boolean paramBoolean)
  {
    this(paramBoolean, null);
  }
  
  public k(boolean paramBoolean, @Nullable String paramString)
  {
    s();
    this.n = -1;
    this.o = -1;
    this.r = -9223372036854775807L;
    this.b = paramBoolean;
    this.e = paramString;
  }
  
  @EnsuresNonNull({"output", "currentOutput", "id3Output"})
  private void a()
  {
    g.e(this.g);
    o0.i(this.u);
    o0.i(this.h);
  }
  
  private void g(d0 paramd0)
  {
    if (paramd0.a() == 0) {
      return;
    }
    this.c.a[0] = ((byte)paramd0.d()[paramd0.e()]);
    this.c.p(2);
    int i1 = this.c.h(4);
    int i2 = this.o;
    if ((i2 != -1) && (i1 != i2))
    {
      q();
      return;
    }
    if (!this.m)
    {
      this.m = true;
      this.n = this.p;
      this.o = i1;
    }
    t();
  }
  
  private boolean h(d0 paramd0, int paramInt)
  {
    paramd0.P(paramInt + 1);
    byte[] arrayOfByte = this.c.a;
    boolean bool1 = true;
    boolean bool2 = true;
    if (!w(paramd0, arrayOfByte, 1)) {
      return false;
    }
    this.c.p(4);
    int i1 = this.c.h(1);
    int i2 = this.n;
    if ((i2 != -1) && (i1 != i2)) {
      return false;
    }
    if (this.o != -1)
    {
      if (!w(paramd0, this.c.a, 1)) {
        return true;
      }
      this.c.p(2);
      if (this.c.h(4) != this.o) {
        return false;
      }
      paramd0.P(paramInt + 2);
    }
    if (!w(paramd0, this.c.a, 4)) {
      return true;
    }
    this.c.p(14);
    int i3 = this.c.h(13);
    if (i3 < 7) {
      return false;
    }
    arrayOfByte = paramd0.d();
    i2 = paramd0.f();
    paramInt += i3;
    if (paramInt >= i2) {
      return true;
    }
    if (arrayOfByte[paramInt] == -1)
    {
      paramInt++;
      if (paramInt == i2) {
        return true;
      }
      if ((!l((byte)-1, arrayOfByte[paramInt])) || ((arrayOfByte[paramInt] & 0x8) >> 3 != i1)) {
        bool2 = false;
      }
      return bool2;
    }
    if (arrayOfByte[paramInt] != 73) {
      return false;
    }
    i1 = paramInt + 1;
    if (i1 == i2) {
      return true;
    }
    if (arrayOfByte[i1] != 68) {
      return false;
    }
    paramInt += 2;
    if (paramInt == i2) {
      return true;
    }
    if (arrayOfByte[paramInt] == 51) {
      bool2 = bool1;
    } else {
      bool2 = false;
    }
    return bool2;
  }
  
  private boolean i(d0 paramd0, byte[] paramArrayOfByte, int paramInt)
  {
    int i1 = Math.min(paramd0.a(), paramInt - this.j);
    paramd0.j(paramArrayOfByte, this.j, i1);
    i1 = this.j + i1;
    this.j = i1;
    boolean bool;
    if (i1 == paramInt) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private void j(d0 paramd0)
  {
    byte[] arrayOfByte = paramd0.d();
    int i1 = paramd0.e();
    int i2 = paramd0.f();
    while (i1 < i2)
    {
      int i3 = i1 + 1;
      i1 = arrayOfByte[i1] & 0xFF;
      if ((this.k == 512) && (l((byte)-1, (byte)i1)) && ((this.m) || (h(paramd0, i3 - 2))))
      {
        this.p = ((i1 & 0x8) >> 3);
        boolean bool = true;
        if ((i1 & 0x1) != 0) {
          bool = false;
        }
        this.l = bool;
        if (!this.m) {
          r();
        } else {
          t();
        }
        paramd0.P(i3);
        return;
      }
      int i4 = this.k;
      i1 |= i4;
      if (i1 != 329)
      {
        if (i1 != 511)
        {
          if (i1 != 836)
          {
            if (i1 != 1075)
            {
              i1 = i3;
              if (i4 != 256)
              {
                this.k = 256;
                i1 = i3 - 1;
              }
            }
            else
            {
              u();
              paramd0.P(i3);
            }
          }
          else
          {
            this.k = 1024;
            i1 = i3;
          }
        }
        else
        {
          this.k = 512;
          i1 = i3;
        }
      }
      else
      {
        this.k = 768;
        i1 = i3;
      }
    }
    paramd0.P(i1);
  }
  
  private boolean l(byte paramByte1, byte paramByte2)
  {
    return m((paramByte1 & 0xFF) << 8 | paramByte2 & 0xFF);
  }
  
  public static boolean m(int paramInt)
  {
    boolean bool;
    if ((paramInt & 0xFFF6) == 65520) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @RequiresNonNull({"output"})
  private void n()
    throws ParserException
  {
    this.c.p(0);
    if (!this.q)
    {
      i1 = this.c.h(2) + 1;
      i2 = i1;
      if (i1 != 2)
      {
        localObject = new StringBuilder(61);
        ((StringBuilder)localObject).append("Detected audio object type: ");
        ((StringBuilder)localObject).append(i1);
        ((StringBuilder)localObject).append(", but assuming AAC LC.");
        u.h("AdtsReader", ((StringBuilder)localObject).toString());
        i2 = 2;
      }
      this.c.r(5);
      i1 = this.c.h(3);
      Object localObject = m.a(i2, this.o, i1);
      m.b localb = m.f((byte[])localObject);
      localObject = new Format.b().S(this.f).e0("audio/mp4a-latm").I(localb.c).H(localb.b).f0(localb.a).T(Collections.singletonList(localObject)).V(this.e).E();
      this.r = (1024000000L / ((Format)localObject).V3);
      this.g.d((Format)localObject);
      this.q = true;
    }
    else
    {
      this.c.r(10);
    }
    this.c.r(4);
    int i1 = this.c.h(13) - 2 - 5;
    int i2 = i1;
    if (this.l) {
      i2 = i1 - 2;
    }
    v(this.g, this.r, 0, i2);
  }
  
  @RequiresNonNull({"id3Output"})
  private void o()
  {
    this.h.c(this.d, 10);
    this.d.P(6);
    v(this.h, 0L, 10, this.d.C() + 10);
  }
  
  @RequiresNonNull({"currentOutput"})
  private void p(d0 paramd0)
  {
    int i1 = Math.min(paramd0.a(), this.s - this.j);
    this.u.c(paramd0, i1);
    i1 = this.j + i1;
    this.j = i1;
    int i2 = this.s;
    if (i1 == i2)
    {
      this.u.e(this.t, 1, i2, 0, null);
      this.t += this.v;
      s();
    }
  }
  
  private void q()
  {
    this.m = false;
    s();
  }
  
  private void r()
  {
    this.i = 1;
    this.j = 0;
  }
  
  private void s()
  {
    this.i = 0;
    this.j = 0;
    this.k = 256;
  }
  
  private void t()
  {
    this.i = 3;
    this.j = 0;
  }
  
  private void u()
  {
    this.i = 2;
    this.j = a.length;
    this.s = 0;
    this.d.P(0);
  }
  
  private void v(b0 paramb0, long paramLong, int paramInt1, int paramInt2)
  {
    this.i = 4;
    this.j = paramInt1;
    this.u = paramb0;
    this.v = paramLong;
    this.s = paramInt2;
  }
  
  private boolean w(d0 paramd0, byte[] paramArrayOfByte, int paramInt)
  {
    if (paramd0.a() < paramInt) {
      return false;
    }
    paramd0.j(paramArrayOfByte, 0, paramInt);
    return true;
  }
  
  public void b(d0 paramd0)
    throws ParserException
  {
    a();
    while (paramd0.a() > 0)
    {
      int i1 = this.i;
      if (i1 != 0)
      {
        if (i1 != 1)
        {
          if (i1 != 2)
          {
            if (i1 != 3)
            {
              if (i1 == 4) {
                p(paramd0);
              } else {
                throw new IllegalStateException();
              }
            }
            else
            {
              if (this.l) {
                i1 = 7;
              } else {
                i1 = 5;
              }
              if (i(paramd0, this.c.a, i1)) {
                n();
              }
            }
          }
          else if (i(paramd0, this.d.d(), 10)) {
            o();
          }
        }
        else {
          g(paramd0);
        }
      }
      else {
        j(paramd0);
      }
    }
  }
  
  public void c()
  {
    q();
  }
  
  public void d(l paraml, i0.d paramd)
  {
    paramd.a();
    this.f = paramd.b();
    b0 localb0 = paraml.t(paramd.c(), 1);
    this.g = localb0;
    this.u = localb0;
    if (this.b)
    {
      paramd.a();
      paraml = paraml.t(paramd.c(), 5);
      this.h = paraml;
      paraml.d(new Format.b().S(paramd.b()).e0("application/id3").E());
    }
    else
    {
      this.h = new i();
    }
  }
  
  public void e() {}
  
  public void f(long paramLong, int paramInt)
  {
    this.t = paramLong;
  }
  
  public long k()
  {
    return this.r;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\l0\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */