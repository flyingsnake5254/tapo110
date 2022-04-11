package com.google.android.exoplayer2.o2.j0;

import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format.b;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmInitData.SchemeData;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.metadata.emsg.b;
import com.google.android.exoplayer2.o2.b0;
import com.google.android.exoplayer2.o2.j;
import com.google.android.exoplayer2.o2.k;
import com.google.android.exoplayer2.o2.x;
import com.google.android.exoplayer2.o2.y;
import com.google.android.exoplayer2.o2.y.b;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.l0;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.z;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class i
  implements j
{
  public static final com.google.android.exoplayer2.o2.o a = a.b;
  private static final byte[] b = { -94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12 };
  private static final Format c = new Format.b().e0("application/x-emsg").E();
  private long A;
  private long B;
  @Nullable
  private b C;
  private int D;
  private int E;
  private int F;
  private boolean G;
  private com.google.android.exoplayer2.o2.l H;
  private b0[] I;
  private b0[] J;
  private boolean K;
  private final int d;
  @Nullable
  private final o e;
  private final List<Format> f;
  private final SparseArray<b> g;
  private final d0 h;
  private final d0 i;
  private final d0 j;
  private final byte[] k;
  private final d0 l;
  @Nullable
  private final l0 m;
  private final b n;
  private final d0 o;
  private final ArrayDeque<e.a> p;
  private final ArrayDeque<a> q;
  @Nullable
  private final b0 r;
  private int s;
  private int t;
  private long u;
  private int v;
  @Nullable
  private d0 w;
  private long x;
  private int y;
  private long z;
  
  public i()
  {
    this(0);
  }
  
  public i(int paramInt)
  {
    this(paramInt, null);
  }
  
  public i(int paramInt, @Nullable l0 paraml0)
  {
    this(paramInt, paraml0, null, Collections.emptyList());
  }
  
  public i(int paramInt, @Nullable l0 paraml0, @Nullable o paramo, List<Format> paramList)
  {
    this(paramInt, paraml0, paramo, paramList, null);
  }
  
  public i(int paramInt, @Nullable l0 paraml0, @Nullable o paramo, List<Format> paramList, @Nullable b0 paramb0)
  {
    this.d = paramInt;
    this.m = paraml0;
    this.e = paramo;
    this.f = Collections.unmodifiableList(paramList);
    this.r = paramb0;
    this.n = new b();
    this.o = new d0(16);
    this.h = new d0(z.a);
    this.i = new d0(5);
    this.j = new d0();
    paraml0 = new byte[16];
    this.k = paraml0;
    this.l = new d0(paraml0);
    this.p = new ArrayDeque();
    this.q = new ArrayDeque();
    this.g = new SparseArray();
    this.A = -9223372036854775807L;
    this.z = -9223372036854775807L;
    this.B = -9223372036854775807L;
    this.H = com.google.android.exoplayer2.o2.l.a;
    this.I = new b0[0];
    this.J = new b0[0];
  }
  
  private static long A(d0 paramd0)
  {
    paramd0.P(8);
    long l1;
    if (e.c(paramd0.n()) == 1) {
      l1 = paramd0.I();
    } else {
      l1 = paramd0.F();
    }
    return l1;
  }
  
  @Nullable
  private static b B(d0 paramd0, SparseArray<b> paramSparseArray, boolean paramBoolean)
  {
    paramd0.P(8);
    int i1 = e.b(paramd0.n());
    int i2 = paramd0.n();
    if (paramBoolean) {
      paramSparseArray = paramSparseArray.valueAt(0);
    } else {
      paramSparseArray = paramSparseArray.get(i2);
    }
    paramSparseArray = (b)paramSparseArray;
    if (paramSparseArray == null) {
      return null;
    }
    if ((i1 & 0x1) != 0)
    {
      long l1 = paramd0.I();
      localObject = paramSparseArray.b;
      ((q)localObject).c = l1;
      ((q)localObject).d = l1;
    }
    Object localObject = paramSparseArray.e;
    if ((i1 & 0x2) != 0) {
      i2 = paramd0.n() - 1;
    } else {
      i2 = ((g)localObject).a;
    }
    int i3;
    if ((i1 & 0x8) != 0) {
      i3 = paramd0.n();
    } else {
      i3 = ((g)localObject).b;
    }
    int i4;
    if ((i1 & 0x10) != 0) {
      i4 = paramd0.n();
    } else {
      i4 = ((g)localObject).c;
    }
    if ((i1 & 0x20) != 0) {
      i1 = paramd0.n();
    } else {
      i1 = ((g)localObject).d;
    }
    paramSparseArray.b.a = new g(i2, i3, i4, i1);
    return paramSparseArray;
  }
  
  private static void C(e.a parama, SparseArray<b> paramSparseArray, boolean paramBoolean, int paramInt, byte[] paramArrayOfByte)
    throws ParserException
  {
    Object localObject = B(((e.b)com.google.android.exoplayer2.util.g.e(parama.g(1952868452))).b, paramSparseArray, paramBoolean);
    if (localObject == null) {
      return;
    }
    q localq = ((b)localObject).b;
    long l1 = localq.r;
    paramBoolean = localq.s;
    ((b)localObject).k();
    b.b((b)localObject, true);
    paramSparseArray = parama.g(1952867444);
    if ((paramSparseArray != null) && ((paramInt & 0x2) == 0))
    {
      localq.r = A(paramSparseArray.b);
      localq.s = true;
    }
    else
    {
      localq.r = l1;
      localq.s = paramBoolean;
    }
    F(parama, (b)localObject, paramInt);
    paramSparseArray = ((b)localObject).d.a.a(((g)com.google.android.exoplayer2.util.g.e(localq.a)).a);
    localObject = parama.g(1935763834);
    if (localObject != null) {
      v((p)com.google.android.exoplayer2.util.g.e(paramSparseArray), ((e.b)localObject).b, localq);
    }
    localObject = parama.g(1935763823);
    if (localObject != null) {
      u(((e.b)localObject).b, localq);
    }
    localObject = parama.g(1936027235);
    if (localObject != null) {
      y(((e.b)localObject).b, localq);
    }
    if (paramSparseArray != null) {
      paramSparseArray = paramSparseArray.b;
    } else {
      paramSparseArray = null;
    }
    w(parama, paramSparseArray, localq);
    int i1 = parama.c.size();
    for (paramInt = 0; paramInt < i1; paramInt++)
    {
      paramSparseArray = (e.b)parama.c.get(paramInt);
      if (paramSparseArray.a == 1970628964) {
        G(paramSparseArray.b, localq, paramArrayOfByte);
      }
    }
  }
  
  private static Pair<Integer, g> D(d0 paramd0)
  {
    paramd0.P(12);
    return Pair.create(Integer.valueOf(paramd0.n()), new g(paramd0.n() - 1, paramd0.n(), paramd0.n(), paramd0.n()));
  }
  
  private static int E(b paramb, int paramInt1, int paramInt2, d0 paramd0, int paramInt3)
    throws ParserException
  {
    Object localObject1 = paramb;
    paramd0.P(8);
    int i1 = e.b(paramd0.n());
    o localo = ((b)localObject1).d.a;
    localObject1 = ((b)localObject1).b;
    g localg = (g)o0.i(((q)localObject1).a);
    ((q)localObject1).h[paramInt1] = paramd0.H();
    Object localObject2 = ((q)localObject1).g;
    localObject2[paramInt1] = ((q)localObject1).c;
    if ((i1 & 0x1) != 0) {
      localObject2[paramInt1] += paramd0.n();
    }
    int i2;
    if ((i1 & 0x4) != 0) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    int i3 = localg.d;
    if (i2 != 0) {
      i3 = paramd0.n();
    }
    int i4;
    if ((i1 & 0x100) != 0) {
      i4 = 1;
    } else {
      i4 = 0;
    }
    int i5;
    if ((i1 & 0x200) != 0) {
      i5 = 1;
    } else {
      i5 = 0;
    }
    int i6;
    if ((i1 & 0x400) != 0) {
      i6 = 1;
    } else {
      i6 = 0;
    }
    if ((i1 & 0x800) != 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    localObject2 = localo.h;
    long l1;
    if ((localObject2 != null) && (localObject2.length == 1) && (localObject2[0] == 0L)) {
      l1 = o0.C0(((long[])o0.i(localo.i))[0], 1000000L, localo.c);
    } else {
      l1 = 0L;
    }
    localObject2 = ((q)localObject1).i;
    int[] arrayOfInt = ((q)localObject1).j;
    long[] arrayOfLong = ((q)localObject1).k;
    boolean[] arrayOfBoolean = ((q)localObject1).l;
    if ((localo.b == 2) && ((paramInt2 & 0x1) != 0)) {
      paramInt2 = 1;
    } else {
      paramInt2 = 0;
    }
    int i7 = paramInt3 + localObject1.h[paramInt1];
    long l2 = localo.c;
    long l3 = ((q)localObject1).r;
    while (paramInt3 < i7)
    {
      if (i4 != 0) {
        paramInt1 = paramd0.n();
      } else {
        paramInt1 = localg.b;
      }
      int i8 = a(paramInt1);
      if (i5 != 0) {
        paramInt1 = paramd0.n();
      } else {
        paramInt1 = localg.c;
      }
      int i9 = a(paramInt1);
      if (i6 != 0) {
        paramInt1 = paramd0.n();
      } else if ((paramInt3 == 0) && (i2 != 0)) {
        paramInt1 = i3;
      } else {
        paramInt1 = localg.d;
      }
      if (i1 != 0) {
        arrayOfInt[paramInt3] = ((int)(paramd0.n() * 1000000L / l2));
      } else {
        arrayOfInt[paramInt3] = 0;
      }
      arrayOfLong[paramInt3] = (o0.C0(l3, 1000000L, l2) - l1);
      if (!((q)localObject1).s) {
        arrayOfLong[paramInt3] += paramb.d.h;
      }
      localObject2[paramInt3] = i9;
      int i10;
      if (((paramInt1 >> 16 & 0x1) == 0) && ((paramInt2 == 0) || (paramInt3 == 0))) {
        i10 = 1;
      } else {
        i10 = 0;
      }
      arrayOfBoolean[paramInt3] = i10;
      l3 += i8;
      paramInt3++;
    }
    ((q)localObject1).r = l3;
    return i7;
  }
  
  private static void F(e.a parama, b paramb, int paramInt)
    throws ParserException
  {
    parama = parama.c;
    int i1 = parama.size();
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    Object localObject;
    int i6;
    for (int i5 = 0; i3 < i1; i5 = i7)
    {
      localObject = (e.b)parama.get(i3);
      i6 = i4;
      i7 = i5;
      if (((e)localObject).a == 1953658222)
      {
        localObject = ((e.b)localObject).b;
        ((d0)localObject).P(12);
        int i8 = ((d0)localObject).H();
        i6 = i4;
        i7 = i5;
        if (i8 > 0)
        {
          i7 = i5 + i8;
          i6 = i4 + 1;
        }
      }
      i3++;
      i4 = i6;
    }
    paramb.h = 0;
    paramb.g = 0;
    paramb.f = 0;
    paramb.b.e(i4, i5);
    int i7 = 0;
    i5 = 0;
    i3 = i2;
    while (i3 < i1)
    {
      localObject = (e.b)parama.get(i3);
      i6 = i7;
      i4 = i5;
      if (((e)localObject).a == 1953658222)
      {
        i4 = E(paramb, i7, paramInt, ((e.b)localObject).b, i5);
        i6 = i7 + 1;
      }
      i3++;
      i7 = i6;
      i5 = i4;
    }
  }
  
  private static void G(d0 paramd0, q paramq, byte[] paramArrayOfByte)
    throws ParserException
  {
    paramd0.P(8);
    paramd0.j(paramArrayOfByte, 0, 16);
    if (!Arrays.equals(paramArrayOfByte, b)) {
      return;
    }
    x(paramd0, 16, paramq);
  }
  
  private void H(long paramLong)
    throws ParserException
  {
    while ((!this.p.isEmpty()) && (((e.a)this.p.peek()).b == paramLong)) {
      m((e.a)this.p.pop());
    }
    f();
  }
  
  private boolean I(k paramk)
    throws IOException
  {
    if (this.v == 0)
    {
      if (!paramk.f(this.o.d(), 0, 8, true)) {
        return false;
      }
      this.v = 8;
      this.o.P(0);
      this.u = this.o.F();
      this.t = this.o.n();
    }
    long l1 = this.u;
    if (l1 == 1L)
    {
      paramk.readFully(this.o.d(), 8, 8);
      this.v += 8;
      this.u = this.o.I();
    }
    else if (l1 == 0L)
    {
      long l2 = paramk.a();
      l1 = l2;
      if (l2 == -1L)
      {
        l1 = l2;
        if (!this.p.isEmpty()) {
          l1 = ((e.a)this.p.peek()).b;
        }
      }
      if (l1 != -1L) {
        this.u = (l1 - paramk.getPosition() + this.v);
      }
    }
    if (this.u >= this.v)
    {
      l1 = paramk.getPosition() - this.v;
      int i1 = this.t;
      if (((i1 == 1836019558) || (i1 == 1835295092)) && (!this.K))
      {
        this.H.o(new y.b(this.A, l1));
        this.K = true;
      }
      if (this.t == 1836019558)
      {
        int i2 = this.g.size();
        for (i1 = 0; i1 < i2; i1++)
        {
          q localq = ((b)this.g.valueAt(i1)).b;
          localq.b = l1;
          localq.d = l1;
          localq.c = l1;
        }
      }
      i1 = this.t;
      if (i1 == 1835295092)
      {
        this.C = null;
        this.x = (l1 + this.u);
        this.s = 2;
        return true;
      }
      if (M(i1))
      {
        l1 = paramk.getPosition() + this.u - 8L;
        this.p.push(new e.a(this.t, l1));
        if (this.u == this.v) {
          H(l1);
        } else {
          f();
        }
      }
      else if (N(this.t))
      {
        if (this.v == 8)
        {
          l1 = this.u;
          if (l1 <= 2147483647L)
          {
            paramk = new d0((int)l1);
            System.arraycopy(this.o.d(), 0, paramk.d(), 0, 8);
            this.w = paramk;
            this.s = 1;
          }
          else
          {
            throw ParserException.createForUnsupportedContainerFeature("Leaf atom with length > 2147483647 (unsupported).");
          }
        }
        else
        {
          throw ParserException.createForUnsupportedContainerFeature("Leaf atom defines extended atom size (unsupported).");
        }
      }
      else
      {
        if (this.u > 2147483647L) {
          break label565;
        }
        this.w = null;
        this.s = 1;
      }
      return true;
      label565:
      throw ParserException.createForUnsupportedContainerFeature("Skipping atom with length > 2147483647 (unsupported).");
    }
    throw ParserException.createForUnsupportedContainerFeature("Atom size less than header length (unsupported).");
  }
  
  private void J(k paramk)
    throws IOException
  {
    int i1 = (int)this.u - this.v;
    d0 locald0 = this.w;
    if (locald0 != null)
    {
      paramk.readFully(locald0.d(), 8, i1);
      o(new e.b(this.t, locald0), paramk.getPosition());
    }
    else
    {
      paramk.l(i1);
    }
    H(paramk.getPosition());
  }
  
  private void K(k paramk)
    throws IOException
  {
    int i1 = this.g.size();
    long l1 = Long.MAX_VALUE;
    int i2 = 0;
    Object localObject2;
    for (Object localObject1 = null; i2 < i1; localObject1 = localObject2)
    {
      q localq = ((b)this.g.valueAt(i2)).b;
      long l2 = l1;
      localObject2 = localObject1;
      if (localq.q)
      {
        long l3 = localq.d;
        l2 = l1;
        localObject2 = localObject1;
        if (l3 < l1)
        {
          localObject2 = (b)this.g.valueAt(i2);
          l2 = l3;
        }
      }
      i2++;
      l1 = l2;
    }
    if (localObject1 == null)
    {
      this.s = 3;
      return;
    }
    i2 = (int)(l1 - paramk.getPosition());
    if (i2 >= 0)
    {
      paramk.l(i2);
      ((b)localObject1).b.a(paramk);
      return;
    }
    throw ParserException.createForMalformedContainer("Offset to encryption data was negative.", null);
  }
  
  private boolean L(k paramk)
    throws IOException
  {
    Object localObject1 = this.C;
    Object localObject2 = localObject1;
    int i2;
    if (localObject1 == null)
    {
      localObject2 = i(this.g);
      if (localObject2 == null)
      {
        i1 = (int)(this.x - paramk.getPosition());
        if (i1 >= 0)
        {
          paramk.l(i1);
          f();
          return false;
        }
        throw ParserException.createForMalformedContainer("Offset to end of mdat was negative.", null);
      }
      i2 = (int)(((b)localObject2).d() - paramk.getPosition());
      i1 = i2;
      if (i2 < 0)
      {
        com.google.android.exoplayer2.util.u.h("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
        i1 = 0;
      }
      paramk.l(i1);
      this.C = ((b)localObject2);
    }
    if (this.s == 3)
    {
      i1 = ((b)localObject2).f();
      this.D = i1;
      if (((b)localObject2).f < ((b)localObject2).i)
      {
        paramk.l(i1);
        ((b)localObject2).m();
        if (!((b)localObject2).h()) {
          this.C = null;
        }
        this.s = 3;
        return true;
      }
      if (((b)localObject2).d.a.g == 1)
      {
        this.D = (i1 - 8);
        paramk.l(8);
      }
      if ("audio/ac4".equals(((b)localObject2).d.a.f.H3))
      {
        this.E = ((b)localObject2).i(this.D, 7);
        com.google.android.exoplayer2.audio.o.a(this.D, this.l);
        ((b)localObject2).a.c(this.l, 7);
        this.E += 7;
      }
      else
      {
        this.E = ((b)localObject2).i(this.D, 0);
      }
      this.D += this.E;
      this.s = 4;
      this.F = 0;
    }
    o localo = ((b)localObject2).d.a;
    localObject1 = ((b)localObject2).a;
    long l1 = ((b)localObject2).e();
    Object localObject3 = this.m;
    long l2 = l1;
    if (localObject3 != null) {
      l2 = ((l0)localObject3).a(l1);
    }
    if (localo.j != 0)
    {
      localObject3 = this.i.d();
      localObject3[0] = ((byte)0);
      localObject3[1] = ((byte)0);
      localObject3[2] = ((byte)0);
      int i3 = localo.j;
      i2 = 4 - i3;
      while (this.E < this.D)
      {
        i1 = this.F;
        if (i1 == 0)
        {
          paramk.readFully((byte[])localObject3, i2, i3 + 1);
          this.i.P(0);
          i1 = this.i.n();
          if (i1 >= 1)
          {
            this.F = (i1 - 1);
            this.h.P(0);
            ((b0)localObject1).c(this.h, 4);
            ((b0)localObject1).c(this.i, 1);
            boolean bool;
            if ((this.J.length > 0) && (z.g(localo.f.H3, localObject3[4]))) {
              bool = true;
            } else {
              bool = false;
            }
            this.G = bool;
            this.E += 5;
            this.D += i2;
          }
          else
          {
            throw ParserException.createForMalformedContainer("Invalid NAL length", null);
          }
        }
        else
        {
          if (this.G)
          {
            this.j.L(i1);
            paramk.readFully(this.j.d(), 0, this.F);
            ((b0)localObject1).c(this.j, this.F);
            i1 = this.F;
            int i4 = z.k(this.j.d(), this.j.f());
            this.j.P("video/hevc".equals(localo.f.H3));
            this.j.O(i4);
            com.google.android.exoplayer2.o2.d.a(l2, this.j, this.J);
          }
          else
          {
            i1 = ((b0)localObject1).b(paramk, i1, false);
          }
          this.E += i1;
          this.F -= i1;
        }
      }
    }
    for (;;)
    {
      i2 = this.E;
      i1 = this.D;
      if (i2 >= i1) {
        break;
      }
      i1 = ((b0)localObject1).b(paramk, i1 - i2, false);
      this.E += i1;
    }
    int i1 = ((b)localObject2).c();
    paramk = ((b)localObject2).g();
    if (paramk != null) {
      paramk = paramk.c;
    } else {
      paramk = null;
    }
    ((b0)localObject1).e(l2, i1, this.D, 0, paramk);
    r(l2);
    if (!((b)localObject2).h()) {
      this.C = null;
    }
    this.s = 3;
    return true;
  }
  
  private static boolean M(int paramInt)
  {
    boolean bool;
    if ((paramInt != 1836019574) && (paramInt != 1953653099) && (paramInt != 1835297121) && (paramInt != 1835626086) && (paramInt != 1937007212) && (paramInt != 1836019558) && (paramInt != 1953653094) && (paramInt != 1836475768) && (paramInt != 1701082227)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private static boolean N(int paramInt)
  {
    boolean bool;
    if ((paramInt != 1751411826) && (paramInt != 1835296868) && (paramInt != 1836476516) && (paramInt != 1936286840) && (paramInt != 1937011556) && (paramInt != 1937011827) && (paramInt != 1668576371) && (paramInt != 1937011555) && (paramInt != 1937011578) && (paramInt != 1937013298) && (paramInt != 1937007471) && (paramInt != 1668232756) && (paramInt != 1937011571) && (paramInt != 1952867444) && (paramInt != 1952868452) && (paramInt != 1953196132) && (paramInt != 1953654136) && (paramInt != 1953658222) && (paramInt != 1886614376) && (paramInt != 1935763834) && (paramInt != 1935763823) && (paramInt != 1936027235) && (paramInt != 1970628964) && (paramInt != 1935828848) && (paramInt != 1936158820) && (paramInt != 1701606260) && (paramInt != 1835362404) && (paramInt != 1701671783)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private static int a(int paramInt)
    throws ParserException
  {
    if (paramInt >= 0) {
      return paramInt;
    }
    StringBuilder localStringBuilder = new StringBuilder(38);
    localStringBuilder.append("Unexpected negative value: ");
    localStringBuilder.append(paramInt);
    throw ParserException.createForMalformedContainer(localStringBuilder.toString(), null);
  }
  
  private void f()
  {
    this.s = 0;
    this.v = 0;
  }
  
  private g g(SparseArray<g> paramSparseArray, int paramInt)
  {
    if (paramSparseArray.size() == 1) {
      return (g)paramSparseArray.valueAt(0);
    }
    return (g)com.google.android.exoplayer2.util.g.e((g)paramSparseArray.get(paramInt));
  }
  
  @Nullable
  private static DrmInitData h(List<e.b> paramList)
  {
    int i1 = paramList.size();
    Object localObject1 = null;
    int i2 = 0;
    Object localObject4;
    for (Object localObject2 = null; i2 < i1; localObject2 = localObject4)
    {
      Object localObject3 = (e.b)paramList.get(i2);
      localObject4 = localObject2;
      if (((e)localObject3).a == 1886614376)
      {
        localObject4 = localObject2;
        if (localObject2 == null) {
          localObject4 = new ArrayList();
        }
        localObject3 = ((e.b)localObject3).b.d();
        localObject2 = l.f((byte[])localObject3);
        if (localObject2 == null) {
          com.google.android.exoplayer2.util.u.h("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
        } else {
          ((ArrayList)localObject4).add(new DrmInitData.SchemeData((UUID)localObject2, "video/mp4", (byte[])localObject3));
        }
      }
      i2++;
    }
    if (localObject2 == null) {
      paramList = (List<e.b>)localObject1;
    } else {
      paramList = new DrmInitData((List)localObject2);
    }
    return paramList;
  }
  
  @Nullable
  private static b i(SparseArray<b> paramSparseArray)
  {
    int i1 = paramSparseArray.size();
    Object localObject1 = null;
    long l1 = Long.MAX_VALUE;
    int i2 = 0;
    while (i2 < i1)
    {
      b localb = (b)paramSparseArray.valueAt(i2);
      Object localObject2;
      long l2;
      if (!b.a(localb))
      {
        localObject2 = localObject1;
        l2 = l1;
        if (localb.f == localb.d.b) {}
      }
      else if ((b.a(localb)) && (localb.h == localb.b.e))
      {
        localObject2 = localObject1;
        l2 = l1;
      }
      else
      {
        long l3 = localb.d();
        localObject2 = localObject1;
        l2 = l1;
        if (l3 < l1)
        {
          localObject2 = localb;
          l2 = l3;
        }
      }
      i2++;
      localObject1 = localObject2;
      l1 = l2;
    }
    return (b)localObject1;
  }
  
  private void j()
  {
    b0[] arrayOfb0 = new b0[2];
    this.I = arrayOfb0;
    Object localObject = this.r;
    int i1 = 0;
    if (localObject != null)
    {
      arrayOfb0[0] = localObject;
      i2 = 1;
    }
    else
    {
      i2 = 0;
    }
    int i3 = this.d;
    int i4 = 100;
    int i5 = i2;
    if ((i3 & 0x4) != 0)
    {
      arrayOfb0[i2] = this.H.t(100, 5);
      i5 = i2 + 1;
      i4 = 101;
    }
    localObject = (b0[])o0.w0(this.I, i5);
    this.I = ((b0[])localObject);
    i5 = localObject.length;
    for (int i2 = 0; i2 < i5; i2++) {
      localObject[i2].d(c);
    }
    this.J = new b0[this.f.size()];
    i2 = i1;
    while (i2 < this.J.length)
    {
      localObject = this.H.t(i4, 3);
      ((b0)localObject).d((Format)this.f.get(i2));
      this.J[i2] = localObject;
      i2++;
      i4++;
    }
  }
  
  private void m(e.a parama)
    throws ParserException
  {
    int i1 = parama.a;
    if (i1 == 1836019574) {
      q(parama);
    } else if (i1 == 1836019558) {
      p(parama);
    } else if (!this.p.isEmpty()) {
      ((e.a)this.p.peek()).d(parama);
    }
  }
  
  private void n(d0 paramd0)
  {
    if (this.I.length == 0) {
      return;
    }
    paramd0.P(8);
    int i1 = e.c(paramd0.n());
    long l1;
    long l2;
    long l3;
    long l4;
    Object localObject2;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        paramd0 = new StringBuilder(46);
        paramd0.append("Skipping unsupported emsg version: ");
        paramd0.append(i1);
        com.google.android.exoplayer2.util.u.h("FragmentedMp4Extractor", paramd0.toString());
        return;
      }
      l1 = paramd0.F();
      l2 = o0.C0(paramd0.I(), 1000000L, l1);
      l3 = o0.C0(paramd0.F(), 1000L, l1);
      l4 = paramd0.F();
      localObject1 = (String)com.google.android.exoplayer2.util.g.e(paramd0.x());
      localObject2 = (String)com.google.android.exoplayer2.util.g.e(paramd0.x());
      l1 = -9223372036854775807L;
    }
    else
    {
      localObject1 = (String)com.google.android.exoplayer2.util.g.e(paramd0.x());
      localObject2 = (String)com.google.android.exoplayer2.util.g.e(paramd0.x());
      l1 = paramd0.F();
      long l5 = o0.C0(paramd0.F(), 1000000L, l1);
      l2 = this.B;
      if (l2 != -9223372036854775807L) {
        l2 += l5;
      } else {
        l2 = -9223372036854775807L;
      }
      l1 = o0.C0(paramd0.F(), 1000L, l1);
      l4 = paramd0.F();
      l3 = l1;
      l1 = l5;
    }
    byte[] arrayOfByte = new byte[paramd0.a()];
    i1 = paramd0.a();
    int i2 = 0;
    paramd0.j(arrayOfByte, 0, i1);
    paramd0 = new EventMessage((String)localObject1, (String)localObject2, l3, l4, arrayOfByte);
    Object localObject1 = new d0(this.n.a(paramd0));
    int i3 = ((d0)localObject1).a();
    for (paramd0 : this.I)
    {
      ((d0)localObject1).P(0);
      paramd0.c((d0)localObject1, i3);
    }
    if (l2 == -9223372036854775807L)
    {
      this.q.addLast(new a(l1, i3));
      this.y += i3;
    }
    else
    {
      paramd0 = this.m;
      l1 = l2;
      if (paramd0 != null) {
        l1 = paramd0.a(l2);
      }
      paramd0 = this.I;
      ??? = paramd0.length;
      for (i1 = i2; i1 < ???; i1++) {
        paramd0[i1].e(l1, 1, i3, 0, null);
      }
    }
  }
  
  private void o(e.b paramb, long paramLong)
    throws ParserException
  {
    if (!this.p.isEmpty())
    {
      ((e.a)this.p.peek()).e(paramb);
    }
    else
    {
      int i1 = paramb.a;
      if (i1 == 1936286840)
      {
        paramb = z(paramb.b, paramLong);
        this.B = ((Long)paramb.first).longValue();
        this.H.o((y)paramb.second);
        this.K = true;
      }
      else if (i1 == 1701671783)
      {
        n(paramb.b);
      }
    }
  }
  
  private void p(e.a parama)
    throws ParserException
  {
    SparseArray localSparseArray = this.g;
    o localo = this.e;
    int i1 = 0;
    boolean bool;
    if (localo != null) {
      bool = true;
    } else {
      bool = false;
    }
    t(parama, localSparseArray, bool, this.d, this.k);
    parama = h(parama.c);
    int i2;
    int i3;
    if (parama != null)
    {
      i2 = this.g.size();
      for (i3 = 0; i3 < i2; i3++) {
        ((b)this.g.valueAt(i3)).n(parama);
      }
    }
    if (this.z != -9223372036854775807L)
    {
      i2 = this.g.size();
      for (i3 = i1; i3 < i2; i3++) {
        ((b)this.g.valueAt(i3)).l(this.z);
      }
      this.z = -9223372036854775807L;
    }
  }
  
  private void q(e.a parama)
    throws ParserException
  {
    Object localObject1 = this.e;
    boolean bool1 = true;
    int i1 = 0;
    int i2 = 0;
    boolean bool2;
    if (localObject1 == null) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    com.google.android.exoplayer2.util.g.h(bool2, "Unexpected moov box.");
    Object localObject2 = h(parama.c);
    Object localObject3 = (e.a)com.google.android.exoplayer2.util.g.e(parama.f(1836475768));
    localObject1 = new SparseArray();
    int i3 = ((e.a)localObject3).c.size();
    long l1 = -9223372036854775807L;
    for (int i4 = 0; i4 < i3; i4++)
    {
      Object localObject4 = (e.b)((e.a)localObject3).c.get(i4);
      int i5 = ((e)localObject4).a;
      if (i5 == 1953654136)
      {
        localObject4 = D(((e.b)localObject4).b);
        ((SparseArray)localObject1).put(((Integer)((Pair)localObject4).first).intValue(), (g)((Pair)localObject4).second);
      }
      else if (i5 == 1835362404)
      {
        l1 = s(((e.b)localObject4).b);
      }
    }
    localObject3 = new com.google.android.exoplayer2.o2.u();
    if ((this.d & 0x10) != 0) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    parama = f.z(parama, (com.google.android.exoplayer2.o2.u)localObject3, l1, (DrmInitData)localObject2, bool2, false, new d(this));
    i3 = parama.size();
    if (this.g.size() == 0)
    {
      for (i4 = i2; i4 < i3; i4++)
      {
        localObject3 = (r)parama.get(i4);
        localObject2 = ((r)localObject3).a;
        localObject3 = new b(this.H.t(i4, ((o)localObject2).b), (r)localObject3, g((SparseArray)localObject1, ((o)localObject2).a));
        this.g.put(((o)localObject2).a, localObject3);
        this.A = Math.max(this.A, ((o)localObject2).e);
      }
      this.H.r();
    }
    else
    {
      if (this.g.size() == i3) {
        bool2 = bool1;
      } else {
        bool2 = false;
      }
      com.google.android.exoplayer2.util.g.g(bool2);
      for (i4 = i1; i4 < i3; i4++)
      {
        localObject3 = (r)parama.get(i4);
        localObject2 = ((r)localObject3).a;
        ((b)this.g.get(((o)localObject2).a)).j((r)localObject3, g((SparseArray)localObject1, ((o)localObject2).a));
      }
    }
  }
  
  private void r(long paramLong)
  {
    if (!this.q.isEmpty())
    {
      a locala = (a)this.q.removeFirst();
      this.y -= locala.b;
      long l1 = locala.a + paramLong;
      Object localObject = this.m;
      long l2 = l1;
      if (localObject != null) {
        l2 = ((l0)localObject).a(l1);
      }
      localObject = this.I;
      int i1 = localObject.length;
      for (int i2 = 0; i2 < i1; i2++) {
        localObject[i2].e(l2, 1, locala.b, this.y, null);
      }
    }
  }
  
  private static long s(d0 paramd0)
  {
    paramd0.P(8);
    long l1;
    if (e.c(paramd0.n()) == 0) {
      l1 = paramd0.F();
    } else {
      l1 = paramd0.I();
    }
    return l1;
  }
  
  private static void t(e.a parama, SparseArray<b> paramSparseArray, boolean paramBoolean, int paramInt, byte[] paramArrayOfByte)
    throws ParserException
  {
    int i1 = parama.d.size();
    for (int i2 = 0; i2 < i1; i2++)
    {
      e.a locala = (e.a)parama.d.get(i2);
      if (locala.a == 1953653094) {
        C(locala, paramSparseArray, paramBoolean, paramInt, paramArrayOfByte);
      }
    }
  }
  
  private static void u(d0 paramd0, q paramq)
    throws ParserException
  {
    paramd0.P(8);
    int i1 = paramd0.n();
    if ((e.b(i1) & 0x1) == 1) {
      paramd0.Q(8);
    }
    int i2 = paramd0.H();
    if (i2 == 1)
    {
      i2 = e.c(i1);
      long l1 = paramq.d;
      long l2;
      if (i2 == 0) {
        l2 = paramd0.F();
      } else {
        l2 = paramd0.I();
      }
      paramq.d = (l1 + l2);
      return;
    }
    paramd0 = new StringBuilder(40);
    paramd0.append("Unexpected saio entry count: ");
    paramd0.append(i2);
    throw ParserException.createForMalformedContainer(paramd0.toString(), null);
  }
  
  private static void v(p paramp, d0 paramd0, q paramq)
    throws ParserException
  {
    int i1 = paramp.d;
    paramd0.P(8);
    int i2 = e.b(paramd0.n());
    boolean bool = true;
    if ((i2 & 0x1) == 1) {
      paramd0.Q(8);
    }
    i2 = paramd0.D();
    int i3 = paramd0.H();
    int i4 = paramq.f;
    if (i3 <= i4)
    {
      if (i2 == 0)
      {
        paramp = paramq.n;
        i4 = 0;
        i2 = 0;
        for (;;)
        {
          i5 = i2;
          if (i4 >= i3) {
            break;
          }
          i5 = paramd0.D();
          i2 += i5;
          if (i5 > i1) {
            bool = true;
          } else {
            bool = false;
          }
          paramp[i4] = bool;
          i4++;
        }
      }
      if (i2 <= i1) {
        bool = false;
      }
      int i5 = i2 * i3 + 0;
      Arrays.fill(paramq.n, 0, i3, bool);
      Arrays.fill(paramq.n, i3, paramq.f, false);
      if (i5 > 0) {
        paramq.d(i5);
      }
      return;
    }
    paramp = new StringBuilder(78);
    paramp.append("Saiz sample count ");
    paramp.append(i3);
    paramp.append(" is greater than fragment sample count");
    paramp.append(i4);
    throw ParserException.createForMalformedContainer(paramp.toString(), null);
  }
  
  private static void w(e.a parama, @Nullable String paramString, q paramq)
    throws ParserException
  {
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject3 = localObject2;
    int i1 = 0;
    int i2;
    while (i1 < parama.c.size())
    {
      Object localObject4 = (e.b)parama.c.get(i1);
      d0 locald0 = ((e.b)localObject4).b;
      i2 = ((e)localObject4).a;
      Object localObject5;
      if (i2 == 1935828848)
      {
        locald0.P(12);
        localObject5 = localObject2;
        localObject4 = localObject3;
        if (locald0.n() == 1936025959)
        {
          localObject5 = locald0;
          localObject4 = localObject3;
        }
      }
      else
      {
        localObject5 = localObject2;
        localObject4 = localObject3;
        if (i2 == 1936158820)
        {
          locald0.P(12);
          localObject5 = localObject2;
          localObject4 = localObject3;
          if (locald0.n() == 1936025959)
          {
            localObject4 = locald0;
            localObject5 = localObject2;
          }
        }
      }
      i1++;
      localObject2 = localObject5;
      localObject3 = localObject4;
    }
    if ((localObject2 != null) && (localObject3 != null))
    {
      ((d0)localObject2).P(8);
      i1 = e.c(((d0)localObject2).n());
      ((d0)localObject2).Q(4);
      if (i1 == 1) {
        ((d0)localObject2).Q(4);
      }
      if (((d0)localObject2).n() == 1)
      {
        ((d0)localObject3).P(8);
        i1 = e.c(((d0)localObject3).n());
        ((d0)localObject3).Q(4);
        if (i1 == 1)
        {
          if (((d0)localObject3).F() == 0L) {
            throw ParserException.createForUnsupportedContainerFeature("Variable length description in sgpd found (unsupported)");
          }
        }
        else if (i1 >= 2) {
          ((d0)localObject3).Q(4);
        }
        if (((d0)localObject3).F() == 1L)
        {
          ((d0)localObject3).Q(1);
          int i3 = ((d0)localObject3).D();
          boolean bool;
          if (((d0)localObject3).D() == 1) {
            bool = true;
          } else {
            bool = false;
          }
          if (!bool) {
            return;
          }
          i1 = ((d0)localObject3).D();
          localObject2 = new byte[16];
          ((d0)localObject3).j((byte[])localObject2, 0, 16);
          parama = (e.a)localObject1;
          if (i1 == 0)
          {
            i2 = ((d0)localObject3).D();
            parama = new byte[i2];
            ((d0)localObject3).j(parama, 0, i2);
          }
          paramq.m = true;
          paramq.o = new p(bool, paramString, i1, (byte[])localObject2, (i3 & 0xF0) >> 4, i3 & 0xF, parama);
          return;
        }
        throw ParserException.createForUnsupportedContainerFeature("Entry count in sgpd != 1 (unsupported).");
      }
      throw ParserException.createForUnsupportedContainerFeature("Entry count in sbgp != 1 (unsupported).");
    }
  }
  
  private static void x(d0 paramd0, int paramInt, q paramq)
    throws ParserException
  {
    paramd0.P(paramInt + 8);
    paramInt = e.b(paramd0.n());
    if ((paramInt & 0x1) == 0)
    {
      boolean bool;
      if ((paramInt & 0x2) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      paramInt = paramd0.H();
      if (paramInt == 0)
      {
        Arrays.fill(paramq.n, 0, paramq.f, false);
        return;
      }
      int i1 = paramq.f;
      if (paramInt == i1)
      {
        Arrays.fill(paramq.n, 0, paramInt, bool);
        paramq.d(paramd0.a());
        paramq.b(paramd0);
        return;
      }
      paramd0 = new StringBuilder(80);
      paramd0.append("Senc sample count ");
      paramd0.append(paramInt);
      paramd0.append(" is different from fragment sample count");
      paramd0.append(i1);
      throw ParserException.createForMalformedContainer(paramd0.toString(), null);
    }
    throw ParserException.createForUnsupportedContainerFeature("Overriding TrackEncryptionBox parameters is unsupported.");
  }
  
  private static void y(d0 paramd0, q paramq)
    throws ParserException
  {
    x(paramd0, 0, paramq);
  }
  
  private static Pair<Long, com.google.android.exoplayer2.o2.e> z(d0 paramd0, long paramLong)
    throws ParserException
  {
    paramd0.P(8);
    int i1 = e.c(paramd0.n());
    paramd0.Q(4);
    long l1 = paramd0.F();
    if (i1 == 0)
    {
      l2 = paramd0.F();
      l3 = paramd0.F();
    }
    else
    {
      l2 = paramd0.I();
      l3 = paramd0.I();
    }
    paramLong += l3;
    long l4 = o0.C0(l2, 1000000L, l1);
    paramd0.Q(2);
    i1 = paramd0.J();
    int[] arrayOfInt = new int[i1];
    long[] arrayOfLong1 = new long[i1];
    long[] arrayOfLong2 = new long[i1];
    long[] arrayOfLong3 = new long[i1];
    long l3 = l2;
    long l2 = l4;
    int i2 = 0;
    while (i2 < i1)
    {
      int i3 = paramd0.n();
      if ((i3 & 0x80000000) == 0)
      {
        long l5 = paramd0.F();
        arrayOfInt[i2] = (i3 & 0x7FFFFFFF);
        arrayOfLong1[i2] = paramLong;
        arrayOfLong3[i2] = l2;
        l3 += l5;
        l2 = o0.C0(l3, 1000000L, l1);
        arrayOfLong2[i2] = (l2 - arrayOfLong3[i2]);
        paramd0.Q(4);
        paramLong += arrayOfInt[i2];
        i2++;
      }
      else
      {
        throw ParserException.createForMalformedContainer("Unhandled indirect reference", null);
      }
    }
    return Pair.create(Long.valueOf(l4), new com.google.android.exoplayer2.o2.e(arrayOfInt, arrayOfLong1, arrayOfLong2, arrayOfLong3));
  }
  
  public void b(com.google.android.exoplayer2.o2.l paraml)
  {
    this.H = paraml;
    f();
    j();
    o localo = this.e;
    if (localo != null)
    {
      paraml = new b(paraml.t(0, localo.b), new r(this.e, new long[0], new int[0], 0, new long[0], new int[0], 0L), new g(0, 0, 0, 0));
      this.g.put(0, paraml);
      this.H.r();
    }
  }
  
  public void c(long paramLong1, long paramLong2)
  {
    int i1 = this.g.size();
    for (int i2 = 0; i2 < i1; i2++) {
      ((b)this.g.valueAt(i2)).k();
    }
    this.q.clear();
    this.y = 0;
    this.z = paramLong2;
    this.p.clear();
    f();
  }
  
  public boolean d(k paramk)
    throws IOException
  {
    return n.b(paramk);
  }
  
  public int e(k paramk, x paramx)
    throws IOException
  {
    do
    {
      for (;;)
      {
        int i1 = this.s;
        if (i1 == 0) {
          break;
        }
        if (i1 != 1)
        {
          if (i1 != 2)
          {
            if (L(paramk)) {
              return 0;
            }
          }
          else {
            K(paramk);
          }
        }
        else {
          J(paramk);
        }
      }
    } while (I(paramk));
    return -1;
  }
  
  @Nullable
  protected o l(@Nullable o paramo)
  {
    return paramo;
  }
  
  public void release() {}
  
  private static final class a
  {
    public final long a;
    public final int b;
    
    public a(long paramLong, int paramInt)
    {
      this.a = paramLong;
      this.b = paramInt;
    }
  }
  
  private static final class b
  {
    public final b0 a;
    public final q b;
    public final d0 c;
    public r d;
    public g e;
    public int f;
    public int g;
    public int h;
    public int i;
    private final d0 j;
    private final d0 k;
    private boolean l;
    
    public b(b0 paramb0, r paramr, g paramg)
    {
      this.a = paramb0;
      this.d = paramr;
      this.e = paramg;
      this.b = new q();
      this.c = new d0();
      this.j = new d0(1);
      this.k = new d0();
      j(paramr, paramg);
    }
    
    public int c()
    {
      int m;
      if (!this.l) {
        m = this.d.g[this.f];
      } else if (this.b.l[this.f] != 0) {
        m = 1;
      } else {
        m = 0;
      }
      int n = m;
      if (g() != null) {
        n = m | 0x40000000;
      }
      return n;
    }
    
    public long d()
    {
      long l1;
      if (!this.l) {
        l1 = this.d.c[this.f];
      } else {
        l1 = this.b.g[this.h];
      }
      return l1;
    }
    
    public long e()
    {
      long l1;
      if (!this.l) {
        l1 = this.d.f[this.f];
      } else {
        l1 = this.b.c(this.f);
      }
      return l1;
    }
    
    public int f()
    {
      int m;
      if (!this.l) {
        m = this.d.d[this.f];
      } else {
        m = this.b.i[this.f];
      }
      return m;
    }
    
    @Nullable
    public p g()
    {
      boolean bool = this.l;
      Object localObject1 = null;
      if (!bool) {
        return null;
      }
      int m = ((g)o0.i(this.b.a)).a;
      p localp = this.b.o;
      if (localp == null) {
        localp = this.d.a.a(m);
      }
      Object localObject2 = localObject1;
      if (localp != null)
      {
        localObject2 = localObject1;
        if (localp.a) {
          localObject2 = localp;
        }
      }
      return (p)localObject2;
    }
    
    public boolean h()
    {
      this.f += 1;
      if (!this.l) {
        return false;
      }
      int m = this.g + 1;
      this.g = m;
      int[] arrayOfInt = this.b.h;
      int n = this.h;
      if (m == arrayOfInt[n])
      {
        this.h = (n + 1);
        this.g = 0;
        return false;
      }
      return true;
    }
    
    public int i(int paramInt1, int paramInt2)
    {
      Object localObject1 = g();
      if (localObject1 == null) {
        return 0;
      }
      int m = ((p)localObject1).d;
      if (m != 0)
      {
        localObject1 = this.b.p;
      }
      else
      {
        localObject2 = (byte[])o0.i(((p)localObject1).e);
        this.k.N((byte[])localObject2, localObject2.length);
        localObject1 = this.k;
        m = localObject2.length;
      }
      boolean bool = this.b.g(this.f);
      int n;
      if ((!bool) && (paramInt2 == 0)) {
        n = 0;
      } else {
        n = 1;
      }
      Object localObject2 = this.j.d();
      int i1;
      if (n != 0) {
        i1 = 128;
      } else {
        i1 = 0;
      }
      localObject2[0] = ((byte)(byte)(i1 | m));
      this.j.P(0);
      this.a.f(this.j, 1, 1);
      this.a.f((d0)localObject1, m, 1);
      if (n == 0) {
        return m + 1;
      }
      if (!bool)
      {
        this.c.L(8);
        localObject1 = this.c.d();
        localObject1[0] = ((byte)0);
        localObject1[1] = ((byte)1);
        localObject1[2] = ((byte)(byte)(paramInt2 >> 8 & 0xFF));
        localObject1[3] = ((byte)(byte)(paramInt2 & 0xFF));
        localObject1[4] = ((byte)(byte)(paramInt1 >> 24 & 0xFF));
        localObject1[5] = ((byte)(byte)(paramInt1 >> 16 & 0xFF));
        localObject1[6] = ((byte)(byte)(paramInt1 >> 8 & 0xFF));
        localObject1[7] = ((byte)(byte)(paramInt1 & 0xFF));
        this.a.f(this.c, 8, 1);
        return m + 1 + 8;
      }
      localObject2 = this.b.p;
      paramInt1 = ((d0)localObject2).J();
      ((d0)localObject2).Q(-2);
      paramInt1 = paramInt1 * 6 + 2;
      localObject1 = localObject2;
      if (paramInt2 != 0)
      {
        this.c.L(paramInt1);
        localObject1 = this.c.d();
        ((d0)localObject2).j((byte[])localObject1, 0, paramInt1);
        paramInt2 = ((localObject1[2] & 0xFF) << 8 | localObject1[3] & 0xFF) + paramInt2;
        localObject1[2] = ((byte)(byte)(paramInt2 >> 8 & 0xFF));
        localObject1[3] = ((byte)(byte)(paramInt2 & 0xFF));
        localObject1 = this.c;
      }
      this.a.f((d0)localObject1, paramInt1, 1);
      return m + 1 + paramInt1;
    }
    
    public void j(r paramr, g paramg)
    {
      this.d = paramr;
      this.e = paramg;
      this.a.d(paramr.a.f);
      k();
    }
    
    public void k()
    {
      this.b.f();
      this.f = 0;
      this.h = 0;
      this.g = 0;
      this.i = 0;
      this.l = false;
    }
    
    public void l(long paramLong)
    {
      for (int m = this.f;; m++)
      {
        q localq = this.b;
        if ((m >= localq.f) || (localq.c(m) >= paramLong)) {
          break;
        }
        if (this.b.l[m] != 0) {
          this.i = m;
        }
      }
    }
    
    public void m()
    {
      p localp = g();
      if (localp == null) {
        return;
      }
      d0 locald0 = this.b.p;
      int m = localp.d;
      if (m != 0) {
        locald0.Q(m);
      }
      if (this.b.g(this.f)) {
        locald0.Q(locald0.J() * 6);
      }
    }
    
    public void n(DrmInitData paramDrmInitData)
    {
      Object localObject = this.d.a.a(((g)o0.i(this.b.a)).a);
      if (localObject != null) {
        localObject = ((p)localObject).b;
      } else {
        localObject = null;
      }
      paramDrmInitData = paramDrmInitData.c((String)localObject);
      paramDrmInitData = this.d.a.f.a().L(paramDrmInitData).E();
      this.a.d(paramDrmInitData);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\j0\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */