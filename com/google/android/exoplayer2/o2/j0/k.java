package com.google.android.exoplayer2.o2.j0;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format.b;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.metadata.mp4.MotionPhotoMetadata;
import com.google.android.exoplayer2.o2.b0;
import com.google.android.exoplayer2.o2.l;
import com.google.android.exoplayer2.o2.u;
import com.google.android.exoplayer2.o2.x;
import com.google.android.exoplayer2.o2.y;
import com.google.android.exoplayer2.o2.y.a;
import com.google.android.exoplayer2.o2.y.b;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class k
  implements com.google.android.exoplayer2.o2.j, y
{
  public static final com.google.android.exoplayer2.o2.o a = c.b;
  private final int b;
  private final d0 c;
  private final d0 d;
  private final d0 e;
  private final d0 f;
  private final ArrayDeque<e.a> g;
  private final m h;
  private final List<Metadata.Entry> i;
  private int j;
  private int k;
  private long l;
  private int m;
  @Nullable
  private d0 n;
  private int o;
  private int p;
  private int q;
  private int r;
  private l s;
  private a[] t;
  private long[][] u;
  private int v;
  private long w;
  private int x;
  @Nullable
  private MotionPhotoMetadata y;
  
  public k()
  {
    this(0);
  }
  
  public k(int paramInt)
  {
    this.b = paramInt;
    if ((paramInt & 0x4) != 0) {
      paramInt = 3;
    } else {
      paramInt = 0;
    }
    this.j = paramInt;
    this.h = new m();
    this.i = new ArrayList();
    this.f = new d0(16);
    this.g = new ArrayDeque();
    this.c = new d0(com.google.android.exoplayer2.util.z.a);
    this.d = new d0(4);
    this.e = new d0();
    this.o = -1;
  }
  
  private int A(com.google.android.exoplayer2.o2.k paramk, x paramx)
    throws IOException
  {
    int i1 = this.h.c(paramk, paramx, this.i);
    if ((i1 == 1) && (paramx.a == 0L)) {
      l();
    }
    return i1;
  }
  
  private static boolean B(int paramInt)
  {
    boolean bool;
    if ((paramInt != 1836019574) && (paramInt != 1953653099) && (paramInt != 1835297121) && (paramInt != 1835626086) && (paramInt != 1937007212) && (paramInt != 1701082227) && (paramInt != 1835365473)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private static boolean C(int paramInt)
  {
    boolean bool;
    if ((paramInt != 1835296868) && (paramInt != 1836476516) && (paramInt != 1751411826) && (paramInt != 1937011556) && (paramInt != 1937011827) && (paramInt != 1937011571) && (paramInt != 1668576371) && (paramInt != 1701606260) && (paramInt != 1937011555) && (paramInt != 1937011578) && (paramInt != 1937013298) && (paramInt != 1937007471) && (paramInt != 1668232756) && (paramInt != 1953196132) && (paramInt != 1718909296) && (paramInt != 1969517665) && (paramInt != 1801812339) && (paramInt != 1768715124)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  @RequiresNonNull({"tracks"})
  private void D(long paramLong)
  {
    for (a locala : this.t)
    {
      r localr = locala.b;
      int i3 = localr.a(paramLong);
      int i4 = i3;
      if (i3 == -1) {
        i4 = localr.b(paramLong);
      }
      locala.d = i4;
    }
  }
  
  private static int j(int paramInt)
  {
    if (paramInt != 1751476579)
    {
      if (paramInt != 1903435808) {
        return 0;
      }
      return 1;
    }
    return 2;
  }
  
  private static long[][] k(a[] paramArrayOfa)
  {
    long[][] arrayOfLong = new long[paramArrayOfa.length][];
    int[] arrayOfInt = new int[paramArrayOfa.length];
    long[] arrayOfLong1 = new long[paramArrayOfa.length];
    boolean[] arrayOfBoolean = new boolean[paramArrayOfa.length];
    for (int i1 = 0; i1 < paramArrayOfa.length; i1++)
    {
      arrayOfLong[i1] = new long[paramArrayOfa[i1].b.b];
      arrayOfLong1[i1] = paramArrayOfa[i1].b.f[0];
    }
    long l1 = 0L;
    int i2 = 0;
    while (i2 < paramArrayOfa.length)
    {
      long l2 = Long.MAX_VALUE;
      int i3 = -1;
      i1 = 0;
      while (i1 < paramArrayOfa.length)
      {
        long l3 = l2;
        int i4 = i3;
        if (arrayOfBoolean[i1] == 0)
        {
          l3 = l2;
          i4 = i3;
          if (arrayOfLong1[i1] <= l2)
          {
            l3 = arrayOfLong1[i1];
            i4 = i1;
          }
        }
        i1++;
        l2 = l3;
        i3 = i4;
      }
      i1 = arrayOfInt[i3];
      arrayOfLong[i3][i1] = l1;
      l1 += paramArrayOfa[i3].b.d[i1];
      i1++;
      arrayOfInt[i3] = i1;
      if (i1 < arrayOfLong[i3].length)
      {
        arrayOfLong1[i3] = paramArrayOfa[i3].b.f[i1];
      }
      else
      {
        arrayOfBoolean[i3] = true;
        i2++;
      }
    }
    return arrayOfLong;
  }
  
  private void l()
  {
    this.j = 0;
    this.m = 0;
  }
  
  private static int m(r paramr, long paramLong)
  {
    int i1 = paramr.a(paramLong);
    int i2 = i1;
    if (i1 == -1) {
      i2 = paramr.b(paramLong);
    }
    return i2;
  }
  
  private int n(long paramLong)
  {
    int i1 = -1;
    int i2 = -1;
    int i3 = 0;
    long l1 = Long.MAX_VALUE;
    int i4 = 1;
    long l2 = Long.MAX_VALUE;
    int i5 = 1;
    long l3 = Long.MAX_VALUE;
    while (i3 < ((a[])o0.i(this.t)).length)
    {
      Object localObject = this.t[i3];
      int i6 = ((a)localObject).d;
      localObject = ((a)localObject).b;
      long l4;
      if (i6 == ((r)localObject).b)
      {
        l4 = l1;
      }
      else
      {
        long l5 = localObject.c[i6];
        long l6 = ((long[][])o0.i(this.u))[i3][i6];
        l4 = l5 - paramLong;
        if ((l4 >= 0L) && (l4 < 262144L)) {
          i6 = 0;
        } else {
          i6 = 1;
        }
        int i7;
        long l7;
        int i8;
        if ((i6 != 0) || (i5 == 0))
        {
          i7 = i2;
          l7 = l2;
          i8 = i5;
          l5 = l3;
          if (i6 == i5)
          {
            i7 = i2;
            l7 = l2;
            i8 = i5;
            l5 = l3;
            if (l4 >= l3) {}
          }
        }
        else
        {
          i8 = i6;
          l5 = l4;
          i7 = i3;
          l7 = l6;
        }
        i2 = i7;
        l4 = l1;
        l2 = l7;
        i5 = i8;
        l3 = l5;
        if (l6 < l1)
        {
          i1 = i3;
          l3 = l5;
          i5 = i8;
          l2 = l7;
          i4 = i6;
          l4 = l6;
          i2 = i7;
        }
      }
      i3++;
      l1 = l4;
    }
    if ((l1 == Long.MAX_VALUE) || (i4 == 0) || (l2 < l1 + 10485760L)) {
      i1 = i2;
    }
    return i1;
  }
  
  private static long q(r paramr, long paramLong1, long paramLong2)
  {
    int i1 = m(paramr, paramLong1);
    if (i1 == -1) {
      return paramLong2;
    }
    return Math.min(paramr.c[i1], paramLong2);
  }
  
  private void r(com.google.android.exoplayer2.o2.k paramk)
    throws IOException
  {
    this.e.L(8);
    paramk.n(this.e.d(), 0, 8);
    f.d(this.e);
    paramk.l(this.e.e());
    paramk.e();
  }
  
  private void s(long paramLong)
    throws ParserException
  {
    while ((!this.g.isEmpty()) && (((e.a)this.g.peek()).b == paramLong))
    {
      e.a locala = (e.a)this.g.pop();
      if (locala.a == 1836019574)
      {
        v(locala);
        this.g.clear();
        this.j = 2;
      }
      else if (!this.g.isEmpty())
      {
        ((e.a)this.g.peek()).d(locala);
      }
    }
    if (this.j != 2) {
      l();
    }
  }
  
  private void t()
  {
    if ((this.x == 2) && ((this.b & 0x2) != 0))
    {
      l locall = (l)g.e(this.s);
      b0 localb0 = locall.t(0, 4);
      Metadata localMetadata;
      if (this.y == null) {
        localMetadata = null;
      } else {
        localMetadata = new Metadata(new Metadata.Entry[] { this.y });
      }
      localb0.d(new Format.b().X(localMetadata).E());
      locall.r();
      locall.o(new y.b(-9223372036854775807L));
    }
  }
  
  private static int u(d0 paramd0)
  {
    paramd0.P(8);
    int i1 = j(paramd0.n());
    if (i1 != 0) {
      return i1;
    }
    paramd0.Q(4);
    while (paramd0.a() > 0)
    {
      i1 = j(paramd0.n());
      if (i1 != 0) {
        return i1;
      }
    }
    return 0;
  }
  
  private void v(e.a parama)
    throws ParserException
  {
    Object localObject1 = new ArrayList();
    boolean bool1;
    if (this.x == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    u localu = new u();
    Object localObject2 = parama.g(1969517665);
    Metadata localMetadata;
    if (localObject2 != null)
    {
      localObject2 = f.A((e.b)localObject2);
      localMetadata = (Metadata)((Pair)localObject2).first;
      localObject2 = (Metadata)((Pair)localObject2).second;
      if (localMetadata != null) {
        localu.c(localMetadata);
      }
    }
    else
    {
      localObject2 = null;
      localMetadata = null;
    }
    Object localObject3 = parama.f(1835365473);
    if (localObject3 != null) {
      localObject3 = f.m((e.a)localObject3);
    } else {
      localObject3 = null;
    }
    boolean bool2;
    if ((this.b & 0x1) != 0) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    Object localObject4 = f.z(parama, localu, -9223372036854775807L, null, bool2, bool1, b.c);
    l locall = (l)g.e(this.s);
    int i1 = ((List)localObject4).size();
    int i2 = 0;
    int i3 = -1;
    long l1 = -9223372036854775807L;
    parama = (e.a)localObject1;
    localObject1 = localObject4;
    while (i2 < i1)
    {
      localObject4 = (r)((List)localObject1).get(i2);
      if (((r)localObject4).b != 0)
      {
        o localo = ((r)localObject4).a;
        e.a locala = parama;
        long l2 = localo.e;
        if (l2 == -9223372036854775807L) {
          l2 = ((r)localObject4).h;
        }
        l1 = Math.max(l1, l2);
        a locala1 = new a(localo, (r)localObject4, locall.t(i2, localo.b));
        int i4 = ((r)localObject4).e;
        Format.b localb = localo.f.a();
        localb.W(i4 + 30);
        if ((localo.b == 2) && (l2 > 0L))
        {
          i4 = ((r)localObject4).b;
          if (i4 > 1) {
            localb.P(i4 / ((float)l2 / 1000000.0F));
          }
        }
        j.k(localo.b, localu, localb);
        i4 = localo.b;
        if (this.i.isEmpty()) {
          localObject4 = null;
        } else {
          localObject4 = new Metadata(this.i);
        }
        j.l(i4, localMetadata, (Metadata)localObject3, localb, new Metadata[] { localObject2, localObject4 });
        locala1.c.d(localb.E());
        if ((localo.b == 2) && (i3 == -1)) {
          i3 = locala.size();
        }
        locala.add(locala1);
      }
      i2++;
    }
    this.v = i3;
    this.w = l1;
    parama = (a[])parama.toArray(new a[0]);
    this.t = parama;
    this.u = k(parama);
    locall.r();
    locall.o(this);
  }
  
  private void w(long paramLong)
  {
    if (this.k == 1836086884)
    {
      int i1 = this.m;
      this.y = new MotionPhotoMetadata(0L, paramLong, -9223372036854775807L, paramLong + i1, this.l - i1);
    }
  }
  
  private boolean x(com.google.android.exoplayer2.o2.k paramk)
    throws IOException
  {
    if (this.m == 0)
    {
      if (!paramk.f(this.f.d(), 0, 8, true))
      {
        t();
        return false;
      }
      this.m = 8;
      this.f.P(0);
      this.l = this.f.F();
      this.k = this.f.n();
    }
    long l1 = this.l;
    long l2;
    if (l1 == 1L)
    {
      paramk.readFully(this.f.d(), 8, 8);
      this.m += 8;
      this.l = this.f.I();
    }
    else if (l1 == 0L)
    {
      l2 = paramk.a();
      l1 = l2;
      if (l2 == -1L)
      {
        e.a locala = (e.a)this.g.peek();
        l1 = l2;
        if (locala != null) {
          l1 = locala.b;
        }
      }
      if (l1 != -1L) {
        this.l = (l1 - paramk.getPosition() + this.m);
      }
    }
    if (this.l >= this.m)
    {
      if (B(this.k))
      {
        l2 = paramk.getPosition();
        l1 = this.l;
        int i1 = this.m;
        l2 = l2 + l1 - i1;
        if ((l1 != i1) && (this.k == 1835365473)) {
          r(paramk);
        }
        this.g.push(new e.a(this.k, l2));
        if (this.l == this.m) {
          s(l2);
        } else {
          l();
        }
      }
      else if (C(this.k))
      {
        boolean bool;
        if (this.m == 8) {
          bool = true;
        } else {
          bool = false;
        }
        g.g(bool);
        if (this.l <= 2147483647L) {
          bool = true;
        } else {
          bool = false;
        }
        g.g(bool);
        paramk = new d0((int)this.l);
        System.arraycopy(this.f.d(), 0, paramk.d(), 0, 8);
        this.n = paramk;
        this.j = 1;
      }
      else
      {
        w(paramk.getPosition() - this.m);
        this.n = null;
        this.j = 1;
      }
      return true;
    }
    throw ParserException.createForUnsupportedContainerFeature("Atom size less than header length (unsupported).");
  }
  
  private boolean y(com.google.android.exoplayer2.o2.k paramk, x paramx)
    throws IOException
  {
    long l1 = this.l - this.m;
    long l2 = paramk.getPosition();
    d0 locald0 = this.n;
    boolean bool = true;
    if (locald0 != null)
    {
      paramk.readFully(locald0.d(), this.m, (int)l1);
      if (this.k == 1718909296) {
        this.x = u(locald0);
      } else if (!this.g.isEmpty()) {
        ((e.a)this.g.peek()).e(new e.b(this.k, locald0));
      }
    }
    else
    {
      if (l1 >= 262144L) {
        break label132;
      }
      paramk.l((int)l1);
    }
    int i1 = 0;
    break label147;
    label132:
    paramx.a = (paramk.getPosition() + l1);
    i1 = 1;
    label147:
    s(l2 + l1);
    if ((i1 == 0) || (this.j == 2)) {
      bool = false;
    }
    return bool;
  }
  
  private int z(com.google.android.exoplayer2.o2.k paramk, x paramx)
    throws IOException
  {
    long l1 = paramk.getPosition();
    int i1;
    if (this.o == -1)
    {
      i1 = n(l1);
      this.o = i1;
      if (i1 == -1) {
        return -1;
      }
    }
    a locala = ((a[])o0.i(this.t))[this.o];
    b0 localb0 = locala.c;
    int i2 = locala.d;
    r localr = locala.b;
    long l2 = localr.c[i2];
    int i3 = localr.d[i2];
    l1 = l2 - l1 + this.p;
    if ((l1 >= 0L) && (l1 < 262144L))
    {
      l2 = l1;
      i1 = i3;
      if (locala.a.g == 1)
      {
        l2 = l1 + 8L;
        i1 = i3 - 8;
      }
      paramk.l((int)l2);
      paramx = locala.a;
      int i5;
      if (paramx.j != 0)
      {
        paramx = this.d.d();
        paramx[0] = ((byte)0);
        paramx[1] = ((byte)0);
        paramx[2] = ((byte)0);
        int i4 = locala.a.j;
        i3 = 4 - i4;
        for (;;)
        {
          i5 = i1;
          if (this.q >= i1) {
            break;
          }
          i5 = this.r;
          if (i5 == 0)
          {
            paramk.readFully(paramx, i3, i4);
            this.p += i4;
            this.d.P(0);
            i5 = this.d.n();
            if (i5 >= 0)
            {
              this.r = i5;
              this.c.P(0);
              localb0.c(this.c, 4);
              this.q += 4;
              i1 += i3;
            }
            else
            {
              throw ParserException.createForMalformedContainer("Invalid NAL length", null);
            }
          }
          else
          {
            i5 = localb0.b(paramk, i5, false);
            this.p += i5;
            this.q += i5;
            this.r -= i5;
          }
        }
      }
      i3 = i1;
      if ("audio/ac4".equals(paramx.f.H3))
      {
        if (this.q == 0)
        {
          com.google.android.exoplayer2.audio.o.a(i1, this.e);
          localb0.c(this.e, 7);
          this.q += 7;
        }
        i3 = i1 + 7;
      }
      for (;;)
      {
        i1 = this.q;
        i5 = i3;
        if (i1 >= i3) {
          break;
        }
        i1 = localb0.b(paramk, i3 - i1, false);
        this.p += i1;
        this.q += i1;
        this.r -= i1;
      }
      paramk = locala.b;
      localb0.e(paramk.f[i2], paramk.g[i2], i5, 0, null);
      locala.d += 1;
      this.o = -1;
      this.p = 0;
      this.q = 0;
      this.r = 0;
      return 0;
    }
    paramx.a = l2;
    return 1;
  }
  
  public y.a a(long paramLong)
  {
    if (((a[])g.e(this.t)).length == 0) {
      return new y.a(com.google.android.exoplayer2.o2.z.a);
    }
    int i1 = this.v;
    long l1;
    long l2;
    long l3;
    label157:
    long l4;
    if (i1 != -1)
    {
      localObject = this.t[i1].b;
      int i2 = m((r)localObject, paramLong);
      if (i2 == -1) {
        return new y.a(com.google.android.exoplayer2.o2.z.a);
      }
      l1 = localObject.f[i2];
      l2 = localObject.c[i2];
      if ((l1 < paramLong) && (i2 < ((r)localObject).b - 1))
      {
        i1 = ((r)localObject).b(paramLong);
        if ((i1 != -1) && (i1 != i2))
        {
          paramLong = localObject.f[i1];
          l3 = localObject.c[i1];
          break label157;
        }
      }
      l3 = -1L;
      paramLong = -9223372036854775807L;
      l4 = paramLong;
      paramLong = l3;
      l3 = l2;
    }
    else
    {
      l3 = Long.MAX_VALUE;
      l2 = -1L;
      l4 = -9223372036854775807L;
      l1 = paramLong;
      paramLong = l2;
    }
    i1 = 0;
    for (;;)
    {
      localObject = this.t;
      if (i1 >= localObject.length) {
        break;
      }
      long l5 = paramLong;
      l2 = l3;
      if (i1 != this.v)
      {
        localObject = localObject[i1].b;
        l2 = q((r)localObject, l1, l3);
        l3 = paramLong;
        if (l4 != -9223372036854775807L) {
          l3 = q((r)localObject, l4, paramLong);
        }
        l5 = l3;
      }
      i1++;
      paramLong = l5;
      l3 = l2;
    }
    Object localObject = new com.google.android.exoplayer2.o2.z(l1, l3);
    if (l4 == -9223372036854775807L) {
      return new y.a((com.google.android.exoplayer2.o2.z)localObject);
    }
    return new y.a((com.google.android.exoplayer2.o2.z)localObject, new com.google.android.exoplayer2.o2.z(l4, paramLong));
  }
  
  public void b(l paraml)
  {
    this.s = paraml;
  }
  
  public void c(long paramLong1, long paramLong2)
  {
    this.g.clear();
    this.m = 0;
    this.o = -1;
    this.p = 0;
    this.q = 0;
    this.r = 0;
    if (paramLong1 == 0L)
    {
      if (this.j != 3)
      {
        l();
      }
      else
      {
        this.h.g();
        this.i.clear();
      }
    }
    else if (this.t != null) {
      D(paramLong2);
    }
  }
  
  public boolean d(com.google.android.exoplayer2.o2.k paramk)
    throws IOException
  {
    boolean bool;
    if ((this.b & 0x2) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return n.d(paramk, bool);
  }
  
  public int e(com.google.android.exoplayer2.o2.k paramk, x paramx)
    throws IOException
  {
    do
    {
      do
      {
        int i1 = this.j;
        if (i1 == 0) {
          break;
        }
        if (i1 != 1)
        {
          if (i1 != 2)
          {
            if (i1 == 3) {
              return A(paramk, paramx);
            }
            throw new IllegalStateException();
          }
          return z(paramk, paramx);
        }
      } while (!y(paramk, paramx));
      return 1;
    } while (x(paramk));
    return -1;
  }
  
  public boolean g()
  {
    return true;
  }
  
  public long i()
  {
    return this.w;
  }
  
  public void release() {}
  
  private static final class a
  {
    public final o a;
    public final r b;
    public final b0 c;
    public int d;
    
    public a(o paramo, r paramr, b0 paramb0)
    {
      this.a = paramo;
      this.b = paramr;
      this.c = paramb0;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\j0\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */