package com.google.android.exoplayer2;

import android.net.Uri;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.ads.g.a;

public abstract class j2
{
  public static final j2 a = new a();
  public static final v0<j2> b = m0.a;
  
  public int a(boolean paramBoolean)
  {
    int i;
    if (q()) {
      i = -1;
    } else {
      i = 0;
    }
    return i;
  }
  
  public abstract int b(Object paramObject);
  
  public int c(boolean paramBoolean)
  {
    int i;
    if (q()) {
      i = -1;
    } else {
      i = p() - 1;
    }
    return i;
  }
  
  public final int d(int paramInt1, b paramb, c paramc, int paramInt2, boolean paramBoolean)
  {
    int i = f(paramInt1, paramb).d;
    if (n(i, paramc).t == paramInt1)
    {
      paramInt1 = e(i, paramInt2, paramBoolean);
      if (paramInt1 == -1) {
        return -1;
      }
      return n(paramInt1, paramc).s;
    }
    return paramInt1 + 1;
  }
  
  public int e(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramInt2 != 0)
    {
      if (paramInt2 != 1)
      {
        if (paramInt2 == 2)
        {
          if (paramInt1 == c(paramBoolean)) {
            paramInt1 = a(paramBoolean);
          } else {
            paramInt1++;
          }
          return paramInt1;
        }
        throw new IllegalStateException();
      }
      return paramInt1;
    }
    if (paramInt1 == c(paramBoolean)) {
      paramInt1 = -1;
    } else {
      paramInt1++;
    }
    return paramInt1;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof j2)) {
      return false;
    }
    j2 localj2 = (j2)paramObject;
    if ((localj2.p() == p()) && (localj2.i() == i()))
    {
      paramObject = new c();
      b localb1 = new b();
      c localc = new c();
      b localb2 = new b();
      for (int i = 0; i < p(); i++) {
        if (!n(i, (c)paramObject).equals(localj2.n(i, localc))) {
          return false;
        }
      }
      for (i = 0; i < i(); i++) {
        if (!g(i, localb1, true).equals(localj2.g(i, localb2, true))) {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  public final b f(int paramInt, b paramb)
  {
    return g(paramInt, paramb, false);
  }
  
  public abstract b g(int paramInt, b paramb, boolean paramBoolean);
  
  public b h(Object paramObject, b paramb)
  {
    return g(b(paramObject), paramb, true);
  }
  
  public int hashCode()
  {
    c localc = new c();
    b localb = new b();
    int i = 217 + p();
    int j = 0;
    for (int k = 0; k < p(); k++) {
      i = i * 31 + n(k, localc).hashCode();
    }
    k = i * 31 + i();
    for (i = j; i < i(); i++) {
      k = k * 31 + g(i, localb, true).hashCode();
    }
    return k;
  }
  
  public abstract int i();
  
  public final Pair<Object, Long> j(c paramc, b paramb, int paramInt, long paramLong)
  {
    return (Pair)com.google.android.exoplayer2.util.g.e(k(paramc, paramb, paramInt, paramLong, 0L));
  }
  
  @Nullable
  public final Pair<Object, Long> k(c paramc, b paramb, int paramInt, long paramLong1, long paramLong2)
  {
    com.google.android.exoplayer2.util.g.c(paramInt, 0, p());
    o(paramInt, paramc, paramLong2);
    paramLong2 = paramLong1;
    if (paramLong1 == -9223372036854775807L)
    {
      paramLong1 = paramc.c();
      paramLong2 = paramLong1;
      if (paramLong1 == -9223372036854775807L) {
        return null;
      }
    }
    paramInt = paramc.s;
    f(paramInt, paramb);
    while ((paramInt < paramc.t) && (paramb.f != paramLong2))
    {
      int i = paramInt + 1;
      if (f(i, paramb).f > paramLong2) {
        break;
      }
      paramInt = i;
    }
    g(paramInt, paramb, true);
    paramLong1 = paramb.f;
    return Pair.create(com.google.android.exoplayer2.util.g.e(paramb.c), Long.valueOf(paramLong2 - paramLong1));
  }
  
  public int l(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramInt2 != 0)
    {
      if (paramInt2 != 1)
      {
        if (paramInt2 == 2)
        {
          if (paramInt1 == a(paramBoolean)) {
            paramInt1 = c(paramBoolean);
          } else {
            paramInt1--;
          }
          return paramInt1;
        }
        throw new IllegalStateException();
      }
      return paramInt1;
    }
    if (paramInt1 == a(paramBoolean)) {
      paramInt1 = -1;
    } else {
      paramInt1--;
    }
    return paramInt1;
  }
  
  public abstract Object m(int paramInt);
  
  public final c n(int paramInt, c paramc)
  {
    return o(paramInt, paramc, 0L);
  }
  
  public abstract c o(int paramInt, c paramc, long paramLong);
  
  public abstract int p();
  
  public final boolean q()
  {
    boolean bool;
    if (p() == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final boolean r(int paramInt1, b paramb, c paramc, int paramInt2, boolean paramBoolean)
  {
    if (d(paramInt1, paramb, paramc, paramInt2, paramBoolean) == -1) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    return paramBoolean;
  }
  
  class a
    extends j2
  {
    public int b(Object paramObject)
    {
      return -1;
    }
    
    public j2.b g(int paramInt, j2.b paramb, boolean paramBoolean)
    {
      throw new IndexOutOfBoundsException();
    }
    
    public int i()
    {
      return 0;
    }
    
    public Object m(int paramInt)
    {
      throw new IndexOutOfBoundsException();
    }
    
    public j2.c o(int paramInt, j2.c paramc, long paramLong)
    {
      throw new IndexOutOfBoundsException();
    }
    
    public int p()
    {
      return 0;
    }
  }
  
  public static final class b
  {
    public static final v0<b> a = n0.a;
    @Nullable
    public Object b;
    @Nullable
    public Object c;
    public int d;
    public long e;
    public long f;
    public boolean g;
    private com.google.android.exoplayer2.source.ads.g h = com.google.android.exoplayer2.source.ads.g.a;
    
    public int a(int paramInt)
    {
      return this.h.a(paramInt).c;
    }
    
    public long b(int paramInt1, int paramInt2)
    {
      g.a locala = this.h.a(paramInt1);
      long l;
      if (locala.c != -1) {
        l = locala.f[paramInt2];
      } else {
        l = -9223372036854775807L;
      }
      return l;
    }
    
    public int c()
    {
      return this.h.e;
    }
    
    public int d(long paramLong)
    {
      return this.h.b(paramLong, this.e);
    }
    
    public int e(long paramLong)
    {
      return this.h.c(paramLong, this.e);
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      boolean bool = true;
      if (this == paramObject) {
        return true;
      }
      if ((paramObject != null) && (b.class.equals(paramObject.getClass())))
      {
        paramObject = (b)paramObject;
        if ((!com.google.android.exoplayer2.util.o0.b(this.b, ((b)paramObject).b)) || (!com.google.android.exoplayer2.util.o0.b(this.c, ((b)paramObject).c)) || (this.d != ((b)paramObject).d) || (this.e != ((b)paramObject).e) || (this.f != ((b)paramObject).f) || (this.g != ((b)paramObject).g) || (!com.google.android.exoplayer2.util.o0.b(this.h, ((b)paramObject).h))) {
          bool = false;
        }
        return bool;
      }
      return false;
    }
    
    public long f(int paramInt)
    {
      return this.h.a(paramInt).b;
    }
    
    public long g()
    {
      return this.h.f;
    }
    
    public long h(int paramInt)
    {
      return this.h.a(paramInt).g;
    }
    
    public int hashCode()
    {
      Object localObject = this.b;
      int i = 0;
      int j;
      if (localObject == null) {
        j = 0;
      } else {
        j = localObject.hashCode();
      }
      localObject = this.c;
      if (localObject != null) {
        i = localObject.hashCode();
      }
      int k = this.d;
      long l = this.e;
      int m = (int)(l ^ l >>> 32);
      l = this.f;
      return ((((((217 + j) * 31 + i) * 31 + k) * 31 + m) * 31 + (int)(l ^ l >>> 32)) * 31 + this.g) * 31 + this.h.hashCode();
    }
    
    public long i()
    {
      return this.e;
    }
    
    public int j(int paramInt)
    {
      return this.h.a(paramInt).c();
    }
    
    public int k(int paramInt1, int paramInt2)
    {
      return this.h.a(paramInt1).d(paramInt2);
    }
    
    public long l()
    {
      return w0.e(this.f);
    }
    
    public long m()
    {
      return this.f;
    }
    
    public int n()
    {
      return this.h.h;
    }
    
    public boolean o(int paramInt)
    {
      return this.h.a(paramInt).e() ^ true;
    }
    
    public boolean p(int paramInt)
    {
      return this.h.a(paramInt).h;
    }
    
    public b q(@Nullable Object paramObject1, @Nullable Object paramObject2, int paramInt, long paramLong1, long paramLong2)
    {
      return r(paramObject1, paramObject2, paramInt, paramLong1, paramLong2, com.google.android.exoplayer2.source.ads.g.a, false);
    }
    
    public b r(@Nullable Object paramObject1, @Nullable Object paramObject2, int paramInt, long paramLong1, long paramLong2, com.google.android.exoplayer2.source.ads.g paramg, boolean paramBoolean)
    {
      this.b = paramObject1;
      this.c = paramObject2;
      this.d = paramInt;
      this.e = paramLong1;
      this.f = paramLong2;
      this.h = paramg;
      this.g = paramBoolean;
      return this;
    }
  }
  
  public static final class c
  {
    public static final Object a = new Object();
    private static final Object b = new Object();
    private static final l1 c = new l1.c().p("com.google.android.exoplayer2.Timeline").u(Uri.EMPTY).a();
    public static final v0<c> d = o0.a;
    public Object e = a;
    @Deprecated
    @Nullable
    public Object f;
    public l1 g = c;
    @Nullable
    public Object h;
    public long i;
    public long j;
    public long k;
    public boolean l;
    public boolean m;
    @Deprecated
    public boolean n;
    @Nullable
    public l1.f o;
    public boolean p;
    public long q;
    public long r;
    public int s;
    public int t;
    public long u;
    
    public long a()
    {
      return com.google.android.exoplayer2.util.o0.T(this.k);
    }
    
    public long b()
    {
      return w0.e(this.q);
    }
    
    public long c()
    {
      return this.q;
    }
    
    public long d()
    {
      return w0.e(this.r);
    }
    
    public long e()
    {
      return this.u;
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      boolean bool = true;
      if (this == paramObject) {
        return true;
      }
      if ((paramObject != null) && (c.class.equals(paramObject.getClass())))
      {
        paramObject = (c)paramObject;
        if ((!com.google.android.exoplayer2.util.o0.b(this.e, ((c)paramObject).e)) || (!com.google.android.exoplayer2.util.o0.b(this.g, ((c)paramObject).g)) || (!com.google.android.exoplayer2.util.o0.b(this.h, ((c)paramObject).h)) || (!com.google.android.exoplayer2.util.o0.b(this.o, ((c)paramObject).o)) || (this.i != ((c)paramObject).i) || (this.j != ((c)paramObject).j) || (this.k != ((c)paramObject).k) || (this.l != ((c)paramObject).l) || (this.m != ((c)paramObject).m) || (this.p != ((c)paramObject).p) || (this.q != ((c)paramObject).q) || (this.r != ((c)paramObject).r) || (this.s != ((c)paramObject).s) || (this.t != ((c)paramObject).t) || (this.u != ((c)paramObject).u)) {
          bool = false;
        }
        return bool;
      }
      return false;
    }
    
    public boolean f()
    {
      boolean bool1 = this.n;
      l1.f localf = this.o;
      boolean bool2 = true;
      boolean bool3;
      if (localf != null) {
        bool3 = true;
      } else {
        bool3 = false;
      }
      if (bool1 == bool3) {
        bool3 = true;
      } else {
        bool3 = false;
      }
      com.google.android.exoplayer2.util.g.g(bool3);
      if (this.o != null) {
        bool3 = bool2;
      } else {
        bool3 = false;
      }
      return bool3;
    }
    
    public c g(Object paramObject1, @Nullable l1 paraml1, @Nullable Object paramObject2, long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean1, boolean paramBoolean2, @Nullable l1.f paramf, long paramLong4, long paramLong5, int paramInt1, int paramInt2, long paramLong6)
    {
      this.e = paramObject1;
      if (paraml1 != null) {
        paramObject1 = paraml1;
      } else {
        paramObject1 = c;
      }
      this.g = ((l1)paramObject1);
      if (paraml1 != null)
      {
        paramObject1 = paraml1.d;
        if (paramObject1 != null)
        {
          paramObject1 = ((l1.g)paramObject1).h;
          break label46;
        }
      }
      paramObject1 = null;
      label46:
      this.f = paramObject1;
      this.h = paramObject2;
      this.i = paramLong1;
      this.j = paramLong2;
      this.k = paramLong3;
      this.l = paramBoolean1;
      this.m = paramBoolean2;
      if (paramf != null) {
        paramBoolean1 = true;
      } else {
        paramBoolean1 = false;
      }
      this.n = paramBoolean1;
      this.o = paramf;
      this.q = paramLong4;
      this.r = paramLong5;
      this.s = paramInt1;
      this.t = paramInt2;
      this.u = paramLong6;
      this.p = false;
      return this;
    }
    
    public int hashCode()
    {
      int i1 = this.e.hashCode();
      int i2 = this.g.hashCode();
      Object localObject = this.h;
      int i3 = 0;
      int i4;
      if (localObject == null) {
        i4 = 0;
      } else {
        i4 = localObject.hashCode();
      }
      localObject = this.o;
      if (localObject != null) {
        i3 = ((l1.f)localObject).hashCode();
      }
      long l1 = this.i;
      int i5 = (int)(l1 ^ l1 >>> 32);
      l1 = this.j;
      int i6 = (int)(l1 ^ l1 >>> 32);
      l1 = this.k;
      int i7 = (int)(l1 ^ l1 >>> 32);
      int i8 = this.l;
      int i9 = this.m;
      int i10 = this.p;
      l1 = this.q;
      int i11 = (int)(l1 ^ l1 >>> 32);
      l1 = this.r;
      int i12 = (int)(l1 ^ l1 >>> 32);
      int i13 = this.s;
      int i14 = this.t;
      l1 = this.u;
      return ((((((((((((((217 + i1) * 31 + i2) * 31 + i4) * 31 + i3) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + i8) * 31 + i9) * 31 + i10) * 31 + i11) * 31 + i12) * 31 + i13) * 31 + i14) * 31 + (int)(l1 ^ l1 >>> 32);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\j2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */