package com.google.android.exoplayer2;

import android.os.Handler;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m2.h1;
import com.google.android.exoplayer2.source.b0;
import com.google.android.exoplayer2.source.c0;
import com.google.android.exoplayer2.source.e0.a;
import com.google.android.exoplayer2.trackselection.m;
import com.google.android.exoplayer2.trackselection.n;
import com.google.android.exoplayer2.upstream.e;
import com.google.android.exoplayer2.util.g;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.a;

final class p1
{
  private final j2.b a;
  private final j2.c b;
  @Nullable
  private final h1 c;
  private final Handler d;
  private long e;
  private int f;
  private boolean g;
  @Nullable
  private n1 h;
  @Nullable
  private n1 i;
  @Nullable
  private n1 j;
  private int k;
  @Nullable
  private Object l;
  private long m;
  
  public p1(@Nullable h1 paramh1, Handler paramHandler)
  {
    this.c = paramh1;
    this.d = paramHandler;
    this.a = new j2.b();
    this.b = new j2.c();
  }
  
  private static e0.a B(j2 paramj2, Object paramObject, long paramLong1, long paramLong2, j2.b paramb)
  {
    paramj2.h(paramObject, paramb);
    int n = paramb.e(paramLong1);
    if (n == -1) {
      return new e0.a(paramObject, paramLong2, paramb.d(paramLong1));
    }
    return new e0.a(paramObject, n, paramb.j(n), paramLong2);
  }
  
  private long C(j2 paramj2, Object paramObject)
  {
    int n = paramj2.h(paramObject, this.a).d;
    Object localObject = this.l;
    int i1;
    if (localObject != null)
    {
      i1 = paramj2.b(localObject);
      if ((i1 != -1) && (paramj2.f(i1, this.a).d == n)) {
        return this.m;
      }
    }
    for (localObject = this.h; localObject != null; localObject = ((n1)localObject).j()) {
      if (((n1)localObject).b.equals(paramObject)) {
        return ((n1)localObject).f.a.d;
      }
    }
    for (localObject = this.h; localObject != null; localObject = ((n1)localObject).j())
    {
      i1 = paramj2.b(((n1)localObject).b);
      if ((i1 != -1) && (paramj2.f(i1, this.a).d == n)) {
        return ((n1)localObject).f.a.d;
      }
    }
    long l1 = this.e;
    this.e = (1L + l1);
    if (this.h == null)
    {
      this.l = paramObject;
      this.m = l1;
    }
    return l1;
  }
  
  private boolean E(j2 paramj2)
  {
    Object localObject = this.h;
    if (localObject == null) {
      return true;
    }
    int n = paramj2.b(((n1)localObject).b);
    for (;;)
    {
      n = paramj2.d(n, this.a, this.b, this.f, this.g);
      while ((((n1)localObject).j() != null) && (!((n1)localObject).f.g)) {
        localObject = ((n1)localObject).j();
      }
      n1 localn1 = ((n1)localObject).j();
      if ((n == -1) || (localn1 == null) || (paramj2.b(localn1.b) != n)) {
        break;
      }
      localObject = localn1;
    }
    boolean bool = z((n1)localObject);
    ((n1)localObject).f = q(paramj2, ((n1)localObject).f);
    return bool ^ true;
  }
  
  private boolean c(long paramLong1, long paramLong2)
  {
    boolean bool;
    if ((paramLong1 != -9223372036854775807L) && (paramLong1 != paramLong2)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private boolean d(o1 paramo11, o1 paramo12)
  {
    boolean bool;
    if ((paramo11.b == paramo12.b) && (paramo11.a.equals(paramo12.a))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @Nullable
  private o1 g(s1 params1)
  {
    return j(params1.b, params1.c, params1.d, params1.t);
  }
  
  @Nullable
  private o1 h(j2 paramj2, n1 paramn1, long paramLong)
  {
    Object localObject1 = paramn1.f;
    long l1 = paramn1.l() + ((o1)localObject1).e - paramLong;
    Object localObject2;
    Object localObject3;
    int i1;
    long l3;
    if (((o1)localObject1).g)
    {
      n = paramj2.b(((o1)localObject1).a.a);
      localObject2 = this.a;
      localObject3 = this.b;
      i1 = this.f;
      boolean bool = this.g;
      long l2 = 0L;
      n = paramj2.d(n, (j2.b)localObject2, (j2.c)localObject3, i1, bool);
      if (n == -1) {
        return null;
      }
      i1 = paramj2.g(n, this.a, true).d;
      localObject2 = this.a.c;
      paramLong = ((o1)localObject1).a.d;
      if (paramj2.n(i1, this.b).s == n)
      {
        localObject1 = paramj2.k(this.b, this.a, i1, -9223372036854775807L, Math.max(0L, l1));
        if (localObject1 == null) {
          return null;
        }
        localObject2 = ((Pair)localObject1).first;
        l3 = ((Long)((Pair)localObject1).second).longValue();
        paramn1 = paramn1.j();
        if ((paramn1 != null) && (paramn1.b.equals(localObject2)))
        {
          paramLong = paramn1.f.a.d;
        }
        else
        {
          paramLong = this.e;
          this.e = (1L + paramLong);
        }
        l2 = -9223372036854775807L;
        paramn1 = (n1)localObject2;
      }
      else
      {
        l3 = 0L;
        paramn1 = (n1)localObject2;
      }
      return j(paramj2, B(paramj2, paramn1, l3, paramLong, this.a), l2, l3);
    }
    paramn1 = ((o1)localObject1).a;
    paramj2.h(paramn1.a, this.a);
    if (paramn1.b())
    {
      n = paramn1.b;
      i1 = this.a.a(n);
      if (i1 == -1) {
        return null;
      }
      int i2 = this.a.k(n, paramn1.c);
      if (i2 < i1) {
        return k(paramj2, paramn1.a, n, i2, ((o1)localObject1).c, paramn1.d);
      }
      l3 = ((o1)localObject1).c;
      paramLong = l3;
      if (l3 == -9223372036854775807L)
      {
        localObject2 = this.b;
        localObject3 = this.a;
        localObject2 = paramj2.k((j2.c)localObject2, (j2.b)localObject3, ((j2.b)localObject3).d, -9223372036854775807L, Math.max(0L, l1));
        if (localObject2 == null) {
          return null;
        }
        paramLong = ((Long)((Pair)localObject2).second).longValue();
      }
      l3 = m(paramj2, paramn1.a, paramn1.b);
      return l(paramj2, paramn1.a, Math.max(l3, paramLong), ((o1)localObject1).c, paramn1.d);
    }
    int n = this.a.j(paramn1.e);
    if (n == this.a.a(paramn1.e))
    {
      paramLong = m(paramj2, paramn1.a, paramn1.e);
      return l(paramj2, paramn1.a, paramLong, ((o1)localObject1).e, paramn1.d);
    }
    return k(paramj2, paramn1.a, paramn1.e, n, ((o1)localObject1).e, paramn1.d);
  }
  
  @Nullable
  private o1 j(j2 paramj2, e0.a parama, long paramLong1, long paramLong2)
  {
    paramj2.h(parama.a, this.a);
    if (parama.b()) {
      return k(paramj2, parama.a, parama.b, parama.c, paramLong1, parama.d);
    }
    return l(paramj2, parama.a, paramLong2, paramLong1, parama.d);
  }
  
  private o1 k(j2 paramj2, Object paramObject, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    paramObject = new e0.a(paramObject, paramInt1, paramInt2, paramLong2);
    long l1 = paramj2.h(((c0)paramObject).a, this.a).b(((c0)paramObject).b, ((c0)paramObject).c);
    if (paramInt2 == this.a.j(paramInt1)) {
      paramLong2 = this.a.g();
    } else {
      paramLong2 = 0L;
    }
    boolean bool = this.a.p(((c0)paramObject).b);
    if ((l1 != -9223372036854775807L) && (paramLong2 >= l1)) {
      paramLong2 = Math.max(0L, l1 - 1L);
    }
    return new o1((e0.a)paramObject, paramLong2, paramLong1, -9223372036854775807L, l1, bool, false, false, false);
  }
  
  private o1 l(j2 paramj2, Object paramObject, long paramLong1, long paramLong2, long paramLong3)
  {
    long l1 = paramLong1;
    paramj2.h(paramObject, this.a);
    int n = this.a.d(l1);
    paramObject = new e0.a(paramObject, paramLong3, n);
    boolean bool1 = r((e0.a)paramObject);
    boolean bool2 = t(paramj2, (e0.a)paramObject);
    boolean bool3 = s(paramj2, (e0.a)paramObject, bool1);
    boolean bool4;
    if ((n != -1) && (this.a.p(n))) {
      bool4 = true;
    } else {
      bool4 = false;
    }
    if (n != -1) {
      paramLong1 = this.a.f(n);
    } else {
      paramLong1 = -9223372036854775807L;
    }
    if ((paramLong1 != -9223372036854775807L) && (paramLong1 != Long.MIN_VALUE)) {
      paramLong3 = paramLong1;
    } else {
      paramLong3 = this.a.e;
    }
    long l2 = l1;
    if (paramLong3 != -9223372036854775807L)
    {
      l2 = l1;
      if (l1 >= paramLong3) {
        l2 = Math.max(0L, paramLong3 - 1L);
      }
    }
    return new o1((e0.a)paramObject, l2, paramLong2, paramLong1, paramLong3, bool4, bool1, bool2, bool3);
  }
  
  private long m(j2 paramj2, Object paramObject, int paramInt)
  {
    paramj2.h(paramObject, this.a);
    long l1 = this.a.f(paramInt);
    if (l1 == Long.MIN_VALUE) {
      return this.a.e;
    }
    return l1 + this.a.h(paramInt);
  }
  
  private boolean r(e0.a parama)
  {
    boolean bool;
    if ((!parama.b()) && (parama.e == -1)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private boolean s(j2 paramj2, e0.a parama, boolean paramBoolean)
  {
    int n = paramj2.b(parama.a);
    if ((!paramj2.n(paramj2.f(n, this.a).d, this.b).m) && (paramj2.r(n, this.a, this.b, this.f, this.g)) && (paramBoolean)) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    return paramBoolean;
  }
  
  private boolean t(j2 paramj2, e0.a parama)
  {
    boolean bool1 = r(parama);
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    int n = paramj2.h(parama.a, this.a).d;
    int i1 = paramj2.b(parama.a);
    if (paramj2.n(n, this.b).t == i1) {
      bool2 = true;
    }
    return bool2;
  }
  
  private void x()
  {
    if (this.c != null)
    {
      ImmutableList.a locala = ImmutableList.builder();
      for (Object localObject = this.h; localObject != null; localObject = ((n1)localObject).j()) {
        locala.h(((n1)localObject).f.a);
      }
      localObject = this.i;
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((n1)localObject).f.a;
      }
      this.d.post(new g0(this, locala, (e0.a)localObject));
    }
  }
  
  public e0.a A(j2 paramj2, Object paramObject, long paramLong)
  {
    return B(paramj2, paramObject, paramLong, C(paramj2, paramObject), this.a);
  }
  
  public boolean D()
  {
    n1 localn1 = this.j;
    boolean bool;
    if ((localn1 != null) && ((localn1.f.i) || (!localn1.q()) || (this.j.f.e == -9223372036854775807L) || (this.k >= 100))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean F(j2 paramj2, long paramLong1, long paramLong2)
  {
    Object localObject1 = this.h;
    Object localObject2 = null;
    for (;;)
    {
      boolean bool = true;
      if (localObject1 == null) {
        break;
      }
      o1 localo1 = ((n1)localObject1).f;
      if (localObject2 == null)
      {
        localObject2 = q(paramj2, localo1);
      }
      else
      {
        localObject3 = h(paramj2, (n1)localObject2, paramLong1);
        if (localObject3 == null) {
          return z((n1)localObject2) ^ true;
        }
        if (!d(localo1, (o1)localObject3)) {
          return z((n1)localObject2) ^ true;
        }
        localObject2 = localObject3;
      }
      ((n1)localObject1).f = ((o1)localObject2).a(localo1.c);
      if (!c(localo1.e, ((o1)localObject2).e))
      {
        ((n1)localObject1).A();
        paramLong1 = ((o1)localObject2).e;
        if (paramLong1 == -9223372036854775807L) {
          paramLong1 = Long.MAX_VALUE;
        } else {
          paramLong1 = ((n1)localObject1).z(paramLong1);
        }
        int n;
        if ((localObject1 == this.i) && (!((n1)localObject1).f.f) && ((paramLong2 == Long.MIN_VALUE) || (paramLong2 >= paramLong1))) {
          n = 1;
        } else {
          n = 0;
        }
        if ((z((n1)localObject1)) || (n != 0)) {
          bool = false;
        }
        return bool;
      }
      Object localObject3 = ((n1)localObject1).j();
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
    return true;
  }
  
  public boolean G(j2 paramj2, int paramInt)
  {
    this.f = paramInt;
    return E(paramj2);
  }
  
  public boolean H(j2 paramj2, boolean paramBoolean)
  {
    this.g = paramBoolean;
    return E(paramj2);
  }
  
  @Nullable
  public n1 a()
  {
    n1 localn1 = this.h;
    if (localn1 == null) {
      return null;
    }
    if (localn1 == this.i) {
      this.i = localn1.j();
    }
    this.h.t();
    int n = this.k - 1;
    this.k = n;
    if (n == 0)
    {
      this.j = null;
      localn1 = this.h;
      this.l = localn1.b;
      this.m = localn1.f.a.d;
    }
    this.h = this.h.j();
    x();
    return this.h;
  }
  
  public n1 b()
  {
    n1 localn1 = this.i;
    boolean bool;
    if ((localn1 != null) && (localn1.j() != null)) {
      bool = true;
    } else {
      bool = false;
    }
    g.g(bool);
    this.i = this.i.j();
    x();
    return this.i;
  }
  
  public void e()
  {
    if (this.k == 0) {
      return;
    }
    n1 localn1 = (n1)g.i(this.h);
    this.l = localn1.b;
    this.m = localn1.f.a.d;
    while (localn1 != null)
    {
      localn1.t();
      localn1 = localn1.j();
    }
    this.h = null;
    this.j = null;
    this.i = null;
    this.k = 0;
    x();
  }
  
  public n1 f(d2[] paramArrayOfd2, m paramm, e parame, r1 paramr1, o1 paramo1, n paramn)
  {
    n1 localn1 = this.j;
    long l1;
    if (localn1 == null)
    {
      if (paramo1.a.b())
      {
        l1 = paramo1.c;
        if (l1 != -9223372036854775807L) {}
      }
      else
      {
        l1 = 0L;
      }
    }
    else {
      l1 = localn1.l() + this.j.f.e - paramo1.b;
    }
    paramm = new n1(paramArrayOfd2, l1, paramm, parame, paramr1, paramo1, paramn);
    paramArrayOfd2 = this.j;
    if (paramArrayOfd2 != null)
    {
      paramArrayOfd2.w(paramm);
    }
    else
    {
      this.h = paramm;
      this.i = paramm;
    }
    this.l = null;
    this.j = paramm;
    this.k += 1;
    x();
    return paramm;
  }
  
  @Nullable
  public n1 i()
  {
    return this.j;
  }
  
  @Nullable
  public o1 n(long paramLong, s1 params1)
  {
    n1 localn1 = this.j;
    if (localn1 == null) {
      params1 = g(params1);
    } else {
      params1 = h(params1.b, localn1, paramLong);
    }
    return params1;
  }
  
  @Nullable
  public n1 o()
  {
    return this.h;
  }
  
  @Nullable
  public n1 p()
  {
    return this.i;
  }
  
  public o1 q(j2 paramj2, o1 paramo1)
  {
    e0.a locala = paramo1.a;
    boolean bool1 = r(locala);
    boolean bool2 = t(paramj2, locala);
    boolean bool3 = s(paramj2, locala, bool1);
    paramj2.h(paramo1.a.a, this.a);
    int n;
    if (!locala.b())
    {
      n = locala.e;
      if (n != -1)
      {
        l1 = this.a.f(n);
        break label87;
      }
    }
    long l1 = -9223372036854775807L;
    label87:
    if (locala.b()) {}
    for (long l2 = this.a.b(locala.b, locala.c);; l2 = this.a.i())
    {
      break;
      if ((l1 != -9223372036854775807L) && (l1 != Long.MIN_VALUE))
      {
        l2 = l1;
        break;
      }
    }
    boolean bool4;
    if (locala.b())
    {
      bool4 = this.a.p(locala.b);
    }
    else
    {
      n = locala.e;
      if ((n != -1) && (this.a.p(n))) {
        bool4 = true;
      } else {
        bool4 = false;
      }
    }
    return new o1(locala, paramo1.b, paramo1.c, l1, l2, bool4, bool1, bool2, bool3);
  }
  
  public boolean u(b0 paramb0)
  {
    n1 localn1 = this.j;
    boolean bool;
    if ((localn1 != null) && (localn1.a == paramb0)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void y(long paramLong)
  {
    n1 localn1 = this.j;
    if (localn1 != null) {
      localn1.s(paramLong);
    }
  }
  
  public boolean z(n1 paramn1)
  {
    boolean bool1 = false;
    if (paramn1 != null) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    g.g(bool2);
    if (paramn1.equals(this.j)) {
      return false;
    }
    this.j = paramn1;
    boolean bool2 = bool1;
    while (paramn1.j() != null)
    {
      paramn1 = paramn1.j();
      if (paramn1 == this.i)
      {
        this.i = this.h;
        bool2 = true;
      }
      paramn1.t();
      this.k -= 1;
    }
    this.j.w(null);
    x();
    return bool2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\p1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */