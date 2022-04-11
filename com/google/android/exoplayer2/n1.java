package com.google.android.exoplayer2;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.b0;
import com.google.android.exoplayer2.source.c0;
import com.google.android.exoplayer2.source.e0.a;
import com.google.android.exoplayer2.source.n0;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.trackselection.m;
import com.google.android.exoplayer2.trackselection.n;
import com.google.android.exoplayer2.upstream.e;

final class n1
{
  public final b0 a;
  public final Object b;
  public final n0[] c;
  public boolean d;
  public boolean e;
  public o1 f;
  public boolean g;
  private final boolean[] h;
  private final d2[] i;
  private final m j;
  private final r1 k;
  @Nullable
  private n1 l;
  private TrackGroupArray m;
  private n n;
  private long o;
  
  public n1(d2[] paramArrayOfd2, long paramLong, m paramm, e parame, r1 paramr1, o1 paramo1, n paramn)
  {
    this.i = paramArrayOfd2;
    this.o = paramLong;
    this.j = paramm;
    this.k = paramr1;
    paramm = paramo1.a;
    this.b = paramm.a;
    this.f = paramo1;
    this.m = TrackGroupArray.c;
    this.n = paramn;
    this.c = new n0[paramArrayOfd2.length];
    this.h = new boolean[paramArrayOfd2.length];
    this.a = e(paramm, paramr1, parame, paramo1.b, paramo1.d);
  }
  
  private void c(n0[] paramArrayOfn0)
  {
    for (int i1 = 0;; i1++)
    {
      d2[] arrayOfd2 = this.i;
      if (i1 >= arrayOfd2.length) {
        break;
      }
      if ((arrayOfd2[i1].f() == 7) && (this.n.c(i1))) {
        paramArrayOfn0[i1] = new com.google.android.exoplayer2.source.u();
      }
    }
  }
  
  private static b0 e(e0.a parama, r1 paramr1, e parame, long paramLong1, long paramLong2)
  {
    paramr1 = paramr1.g(parama, parame, paramLong1);
    parama = paramr1;
    if (paramLong2 != -9223372036854775807L) {
      parama = new o(paramr1, true, 0L, paramLong2);
    }
    return parama;
  }
  
  private void f()
  {
    if (!r()) {
      return;
    }
    for (int i1 = 0;; i1++)
    {
      Object localObject = this.n;
      if (i1 >= ((n)localObject).a) {
        break;
      }
      boolean bool = ((n)localObject).c(i1);
      localObject = this.n.c[i1];
      if ((bool) && (localObject != null)) {
        ((com.google.android.exoplayer2.trackselection.g)localObject).b();
      }
    }
  }
  
  private void g(n0[] paramArrayOfn0)
  {
    for (int i1 = 0;; i1++)
    {
      d2[] arrayOfd2 = this.i;
      if (i1 >= arrayOfd2.length) {
        break;
      }
      if (arrayOfd2[i1].f() == 7) {
        paramArrayOfn0[i1] = null;
      }
    }
  }
  
  private void h()
  {
    if (!r()) {
      return;
    }
    for (int i1 = 0;; i1++)
    {
      Object localObject = this.n;
      if (i1 >= ((n)localObject).a) {
        break;
      }
      boolean bool = ((n)localObject).c(i1);
      localObject = this.n.c[i1];
      if ((bool) && (localObject != null)) {
        ((com.google.android.exoplayer2.trackselection.g)localObject).c();
      }
    }
  }
  
  private boolean r()
  {
    boolean bool;
    if (this.l == null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static void u(r1 paramr1, b0 paramb0)
  {
    try
    {
      if ((paramb0 instanceof o)) {
        paramr1.z(((o)paramb0).c);
      } else {
        paramr1.z(paramb0);
      }
    }
    catch (RuntimeException paramr1)
    {
      com.google.android.exoplayer2.util.u.d("MediaPeriodHolder", "Period release failed.", paramr1);
    }
  }
  
  public void A()
  {
    b0 localb0 = this.a;
    if ((localb0 instanceof o))
    {
      long l1 = this.f.d;
      long l2 = l1;
      if (l1 == -9223372036854775807L) {
        l2 = Long.MIN_VALUE;
      }
      ((o)localb0).v(0L, l2);
    }
  }
  
  public long a(n paramn, long paramLong, boolean paramBoolean)
  {
    return b(paramn, paramLong, paramBoolean, new boolean[this.i.length]);
  }
  
  public long b(n paramn, long paramLong, boolean paramBoolean, boolean[] paramArrayOfBoolean)
  {
    for (int i1 = 0;; i1++)
    {
      int i2 = paramn.a;
      int i3 = 1;
      if (i1 >= i2) {
        break;
      }
      boolean[] arrayOfBoolean = this.h;
      if ((paramBoolean) || (!paramn.b(this.n, i1))) {
        i3 = 0;
      }
      arrayOfBoolean[i1] = i3;
    }
    g(this.c);
    f();
    this.n = paramn;
    h();
    paramLong = this.a.m(paramn.c, this.h, this.c, paramArrayOfBoolean, paramLong);
    c(this.c);
    this.e = false;
    for (i1 = 0;; i1++)
    {
      paramArrayOfBoolean = this.c;
      if (i1 >= paramArrayOfBoolean.length) {
        break;
      }
      if (paramArrayOfBoolean[i1] != null)
      {
        com.google.android.exoplayer2.util.g.g(paramn.c(i1));
        if (this.i[i1].f() != 7) {
          this.e = true;
        }
      }
      else
      {
        if (paramn.c[i1] == null) {
          paramBoolean = true;
        } else {
          paramBoolean = false;
        }
        com.google.android.exoplayer2.util.g.g(paramBoolean);
      }
    }
    return paramLong;
  }
  
  public void d(long paramLong)
  {
    com.google.android.exoplayer2.util.g.g(r());
    paramLong = y(paramLong);
    this.a.d(paramLong);
  }
  
  public long i()
  {
    if (!this.d) {
      return this.f.b;
    }
    long l1;
    if (this.e) {
      l1 = this.a.e();
    } else {
      l1 = Long.MIN_VALUE;
    }
    long l2 = l1;
    if (l1 == Long.MIN_VALUE) {
      l2 = this.f.e;
    }
    return l2;
  }
  
  @Nullable
  public n1 j()
  {
    return this.l;
  }
  
  public long k()
  {
    long l1;
    if (!this.d) {
      l1 = 0L;
    } else {
      l1 = this.a.a();
    }
    return l1;
  }
  
  public long l()
  {
    return this.o;
  }
  
  public long m()
  {
    return this.f.b + this.o;
  }
  
  public TrackGroupArray n()
  {
    return this.m;
  }
  
  public n o()
  {
    return this.n;
  }
  
  public void p(float paramFloat, j2 paramj2)
    throws ExoPlaybackException
  {
    this.d = true;
    this.m = this.a.s();
    paramj2 = v(paramFloat, paramj2);
    o1 localo1 = this.f;
    long l1 = localo1.b;
    long l2 = localo1.e;
    long l3 = l1;
    if (l2 != -9223372036854775807L)
    {
      l3 = l1;
      if (l1 >= l2) {
        l3 = Math.max(0L, l2 - 1L);
      }
    }
    l1 = a(paramj2, l3, false);
    l3 = this.o;
    paramj2 = this.f;
    this.o = (l3 + (paramj2.b - l1));
    this.f = paramj2.b(l1);
  }
  
  public boolean q()
  {
    boolean bool;
    if ((this.d) && ((!this.e) || (this.a.e() == Long.MIN_VALUE))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void s(long paramLong)
  {
    com.google.android.exoplayer2.util.g.g(r());
    if (this.d) {
      this.a.f(y(paramLong));
    }
  }
  
  public void t()
  {
    f();
    u(this.k, this.a);
  }
  
  public n v(float paramFloat, j2 paramj2)
    throws ExoPlaybackException
  {
    n localn = this.j.e(this.i, n(), this.f.a, paramj2);
    for (paramj2 : localn.c) {
      if (paramj2 != null) {
        paramj2.i(paramFloat);
      }
    }
    return localn;
  }
  
  public void w(@Nullable n1 paramn1)
  {
    if (paramn1 == this.l) {
      return;
    }
    f();
    this.l = paramn1;
    h();
  }
  
  public void x(long paramLong)
  {
    this.o = paramLong;
  }
  
  public long y(long paramLong)
  {
    return paramLong - l();
  }
  
  public long z(long paramLong)
  {
    return paramLong + l();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\n1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */