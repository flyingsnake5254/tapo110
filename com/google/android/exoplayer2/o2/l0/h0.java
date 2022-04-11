package com.google.android.exoplayer2.o2.l0;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.o2.b;
import com.google.android.exoplayer2.o2.j;
import com.google.android.exoplayer2.o2.k;
import com.google.android.exoplayer2.o2.o;
import com.google.android.exoplayer2.o2.x;
import com.google.android.exoplayer2.o2.y.b;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.l0;
import com.google.android.exoplayer2.util.o0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class h0
  implements j
{
  public static final o a = e.b;
  private final int b;
  private final int c;
  private final List<l0> d;
  private final com.google.android.exoplayer2.util.d0 e;
  private final SparseIntArray f;
  private final i0.c g;
  private final SparseArray<i0> h;
  private final SparseBooleanArray i;
  private final SparseBooleanArray j;
  private final g0 k;
  private f0 l;
  private com.google.android.exoplayer2.o2.l m;
  private int n;
  private boolean o;
  private boolean p;
  private boolean q;
  private i0 r;
  private int s;
  private int t;
  
  public h0()
  {
    this(0);
  }
  
  public h0(int paramInt)
  {
    this(1, paramInt, 112800);
  }
  
  public h0(int paramInt1, int paramInt2, int paramInt3)
  {
    this(paramInt1, new l0(0L), new l(paramInt2), paramInt3);
  }
  
  public h0(int paramInt, l0 paraml0, i0.c paramc)
  {
    this(paramInt, paraml0, paramc, 112800);
  }
  
  public h0(int paramInt1, l0 paraml0, i0.c paramc, int paramInt2)
  {
    this.g = ((i0.c)g.e(paramc));
    this.c = paramInt2;
    this.b = paramInt1;
    if ((paramInt1 != 1) && (paramInt1 != 2))
    {
      paramc = new ArrayList();
      this.d = paramc;
      paramc.add(paraml0);
    }
    else
    {
      this.d = Collections.singletonList(paraml0);
    }
    this.e = new com.google.android.exoplayer2.util.d0(new byte['Ⓒ'], 0);
    this.i = new SparseBooleanArray();
    this.j = new SparseBooleanArray();
    this.h = new SparseArray();
    this.f = new SparseIntArray();
    this.k = new g0(paramInt2);
    this.t = -1;
    x();
  }
  
  private boolean t(k paramk)
    throws IOException
  {
    byte[] arrayOfByte = this.e.d();
    int i1;
    if (9400 - this.e.e() < 188)
    {
      i1 = this.e.a();
      if (i1 > 0) {
        System.arraycopy(arrayOfByte, this.e.e(), arrayOfByte, 0, i1);
      }
      this.e.N(arrayOfByte, i1);
    }
    while (this.e.a() < 188)
    {
      i1 = this.e.f();
      int i2 = paramk.read(arrayOfByte, i1, 9400 - i1);
      if (i2 == -1) {
        return false;
      }
      this.e.O(i1 + i2);
    }
    return true;
  }
  
  private int u()
    throws ParserException
  {
    int i1 = this.e.e();
    int i2 = this.e.f();
    int i3 = j0.a(this.e.d(), i1, i2);
    this.e.P(i3);
    int i4 = i3 + 188;
    if (i4 > i2)
    {
      i3 = this.s + (i3 - i1);
      this.s = i3;
      if ((this.b == 2) && (i3 > 376)) {
        throw ParserException.createForMalformedContainer("Cannot find sync byte. Most likely not a Transport Stream.", null);
      }
    }
    else
    {
      this.s = 0;
    }
    return i4;
  }
  
  private void w(long paramLong)
  {
    if (!this.p)
    {
      this.p = true;
      if (this.k.b() != -9223372036854775807L)
      {
        f0 localf0 = new f0(this.k.c(), this.k.b(), paramLong, this.t, this.c);
        this.l = localf0;
        this.m.o(localf0.b());
      }
      else
      {
        this.m.o(new y.b(this.k.b()));
      }
    }
  }
  
  private void x()
  {
    this.i.clear();
    this.h.clear();
    SparseArray localSparseArray = this.g.a();
    int i1 = localSparseArray.size();
    for (int i2 = 0; i2 < i1; i2++) {
      this.h.put(localSparseArray.keyAt(i2), (i0)localSparseArray.valueAt(i2));
    }
    this.h.put(0, new d0(new a()));
    this.r = null;
  }
  
  private boolean y(int paramInt)
  {
    int i1 = this.b;
    boolean bool = false;
    if ((i1 == 2) || (this.o) || (!this.j.get(paramInt, false))) {
      bool = true;
    }
    return bool;
  }
  
  public void b(com.google.android.exoplayer2.o2.l paraml)
  {
    this.m = paraml;
  }
  
  public void c(long paramLong1, long paramLong2)
  {
    boolean bool;
    if (this.b != 2) {
      bool = true;
    } else {
      bool = false;
    }
    g.g(bool);
    int i1 = this.d.size();
    Object localObject;
    for (int i2 = 0; i2 < i1; i2++)
    {
      localObject = (l0)this.d.get(i2);
      if (((l0)localObject).e() == -9223372036854775807L) {
        i3 = 1;
      } else {
        i3 = 0;
      }
      int i4 = i3;
      if (i3 == 0)
      {
        paramLong1 = ((l0)localObject).c();
        if ((paramLong1 != -9223372036854775807L) && (paramLong1 != 0L) && (paramLong1 != paramLong2)) {
          i4 = 1;
        } else {
          i4 = 0;
        }
      }
      if (i4 != 0) {
        ((l0)localObject).g(paramLong2);
      }
    }
    if (paramLong2 != 0L)
    {
      localObject = this.l;
      if (localObject != null) {
        ((b)localObject).h(paramLong2);
      }
    }
    this.e.L(0);
    this.f.clear();
    for (int i3 = 0; i3 < this.h.size(); i3++) {
      ((i0)this.h.valueAt(i3)).c();
    }
    this.s = 0;
  }
  
  public boolean d(k paramk)
    throws IOException
  {
    byte[] arrayOfByte = this.e.d();
    paramk.n(arrayOfByte, 0, 940);
    for (int i1 = 0; i1 < 188; i1++)
    {
      for (int i2 = 0; i2 < 5; i2++) {
        if (arrayOfByte[(i2 * 188 + i1)] != 71)
        {
          i2 = 0;
          break label67;
        }
      }
      i2 = 1;
      label67:
      if (i2 != 0)
      {
        paramk.l(i1);
        return true;
      }
    }
    return false;
  }
  
  public int e(k paramk, x paramx)
    throws IOException
  {
    long l1 = paramk.a();
    int i1;
    if (this.o)
    {
      if ((l1 != -1L) && (this.b != 2)) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if ((i1 != 0) && (!this.k.d())) {
        return this.k.e(paramk, paramx, this.t);
      }
      w(l1);
      if (this.q)
      {
        this.q = false;
        c(0L, 0L);
        if (paramk.getPosition() != 0L)
        {
          paramx.a = 0L;
          return 1;
        }
      }
      f0 localf0 = this.l;
      if ((localf0 != null) && (localf0.d())) {
        return this.l.c(paramk, paramx);
      }
    }
    if (!t(paramk)) {
      return -1;
    }
    int i2 = u();
    int i3 = this.e.f();
    if (i2 > i3) {
      return 0;
    }
    int i4 = this.e.n();
    if ((0x800000 & i4) != 0)
    {
      this.e.P(i2);
      return 0;
    }
    if ((0x400000 & i4) != 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i5 = i1 | 0x0;
    int i6 = (0x1FFF00 & i4) >> 8;
    if ((i4 & 0x20) != 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if ((i4 & 0x10) != 0) {
      i7 = 1;
    } else {
      i7 = 0;
    }
    if (i7 != 0) {
      paramk = (i0)this.h.get(i6);
    } else {
      paramk = null;
    }
    if (paramk == null)
    {
      this.e.P(i2);
      return 0;
    }
    if (this.b != 2)
    {
      i7 = i4 & 0xF;
      i4 = this.f.get(i6, i7 - 1);
      this.f.put(i6, i7);
      if (i4 == i7)
      {
        this.e.P(i2);
        return 0;
      }
      if (i7 != (i4 + 1 & 0xF)) {
        paramk.c();
      }
    }
    int i7 = i5;
    if (i1 != 0)
    {
      i4 = this.e.D();
      if ((this.e.D() & 0x40) != 0) {
        i1 = 2;
      } else {
        i1 = 0;
      }
      i7 = i5 | i1;
      this.e.Q(i4 - 1);
    }
    boolean bool = this.o;
    if (y(i6))
    {
      this.e.O(i2);
      paramk.b(this.e, i7);
      this.e.O(i3);
    }
    if ((this.b != 2) && (!bool) && (this.o) && (l1 != -1L)) {
      this.q = true;
    }
    this.e.P(i2);
    return 0;
  }
  
  public void release() {}
  
  private class a
    implements c0
  {
    private final com.google.android.exoplayer2.util.c0 a = new com.google.android.exoplayer2.util.c0(new byte[4]);
    
    public a() {}
    
    public void a(l0 paraml0, com.google.android.exoplayer2.o2.l paraml, i0.d paramd) {}
    
    public void b(com.google.android.exoplayer2.util.d0 paramd0)
    {
      if (paramd0.D() != 0) {
        return;
      }
      if ((paramd0.D() & 0x80) == 0) {
        return;
      }
      paramd0.Q(6);
      int i = paramd0.a() / 4;
      for (int j = 0; j < i; j++)
      {
        paramd0.i(this.a, 4);
        int k = this.a.h(16);
        this.a.r(3);
        if (k == 0)
        {
          this.a.r(13);
        }
        else
        {
          k = this.a.h(13);
          if (h0.a(h0.this).get(k) == null)
          {
            h0.a(h0.this).put(k, new d0(new h0.b(h0.this, k)));
            h0.j(h0.this);
          }
        }
      }
      if (h0.k(h0.this) != 2) {
        h0.a(h0.this).remove(0);
      }
    }
  }
  
  private class b
    implements c0
  {
    private final com.google.android.exoplayer2.util.c0 a = new com.google.android.exoplayer2.util.c0(new byte[5]);
    private final SparseArray<i0> b = new SparseArray();
    private final SparseIntArray c = new SparseIntArray();
    private final int d;
    
    public b(int paramInt)
    {
      this.d = paramInt;
    }
    
    private i0.b c(com.google.android.exoplayer2.util.d0 paramd0, int paramInt)
    {
      int i = paramd0.e();
      int j = paramInt + i;
      Object localObject1 = null;
      Object localObject2 = null;
      paramInt = -1;
      while (paramd0.e() < j)
      {
        int k = paramd0.D();
        int m = paramd0.D();
        m = paramd0.e() + m;
        if (m > j) {
          break;
        }
        long l;
        if (k == 5)
        {
          l = paramd0.F();
          if (l == 1094921523L) {
            break label156;
          }
          if (l == 1161904947L) {
            break label178;
          }
          if (l != 1094921524L) {}
        }
        Object localObject3;
        Object localObject4;
        for (;;)
        {
          paramInt = 172;
          localObject3 = localObject1;
          localObject4 = localObject2;
          break label379;
          localObject3 = localObject1;
          localObject4 = localObject2;
          if (l != 1212503619L) {
            break label379;
          }
          paramInt = 36;
          localObject3 = localObject1;
          localObject4 = localObject2;
          break label379;
          if (k == 106)
          {
            label156:
            paramInt = 129;
            localObject3 = localObject1;
            localObject4 = localObject2;
            break label379;
          }
          if (k == 122)
          {
            label178:
            paramInt = 135;
            localObject3 = localObject1;
            localObject4 = localObject2;
            break label379;
          }
          if (k != 127) {
            break;
          }
          localObject3 = localObject1;
          localObject4 = localObject2;
          if (paramd0.D() != 21) {
            break label379;
          }
        }
        if (k == 123)
        {
          paramInt = 138;
          localObject3 = localObject1;
          localObject4 = localObject2;
        }
        else if (k == 10)
        {
          localObject3 = paramd0.A(3).trim();
          localObject4 = localObject2;
        }
        else if (k == 89)
        {
          localObject4 = new ArrayList();
          while (paramd0.e() < m)
          {
            localObject2 = paramd0.A(3).trim();
            paramInt = paramd0.D();
            localObject3 = new byte[4];
            paramd0.j((byte[])localObject3, 0, 4);
            ((List)localObject4).add(new i0.a((String)localObject2, paramInt, (byte[])localObject3));
          }
          paramInt = 89;
          localObject3 = localObject1;
        }
        else
        {
          localObject3 = localObject1;
          localObject4 = localObject2;
          if (k == 111)
          {
            paramInt = 257;
            localObject4 = localObject2;
            localObject3 = localObject1;
          }
        }
        label379:
        paramd0.Q(m - paramd0.e());
        localObject1 = localObject3;
        localObject2 = localObject4;
      }
      paramd0.P(j);
      return new i0.b(paramInt, (String)localObject1, (List)localObject2, Arrays.copyOfRange(paramd0.d(), i, j));
    }
    
    public void a(l0 paraml0, com.google.android.exoplayer2.o2.l paraml, i0.d paramd) {}
    
    public void b(com.google.android.exoplayer2.util.d0 paramd0)
    {
      if (paramd0.D() != 2) {
        return;
      }
      l0 locall0;
      if ((h0.k(h0.this) != 1) && (h0.k(h0.this) != 2) && (h0.f(h0.this) != 1))
      {
        locall0 = new l0(((l0)h0.l(h0.this).get(0)).c());
        h0.l(h0.this).add(locall0);
      }
      else
      {
        locall0 = (l0)h0.l(h0.this).get(0);
      }
      if ((paramd0.D() & 0x80) == 0) {
        return;
      }
      paramd0.Q(1);
      int i = paramd0.J();
      paramd0.Q(3);
      paramd0.i(this.a, 2);
      this.a.r(3);
      h0.m(h0.this, this.a.h(13));
      paramd0.i(this.a, 2);
      this.a.r(4);
      paramd0.Q(this.a.h(12));
      Object localObject;
      if ((h0.k(h0.this) == 2) && (h0.n(h0.this) == null))
      {
        i0.b localb = new i0.b(21, null, null, o0.f);
        localObject = h0.this;
        h0.o((h0)localObject, h0.p((h0)localObject).b(21, localb));
        h0.n(h0.this).a(locall0, h0.q(h0.this), new i0.d(i, 21, 8192));
      }
      this.b.clear();
      this.c.clear();
      int k;
      int m;
      for (int j = paramd0.a(); j > 0; j = k)
      {
        paramd0.i(this.a, 5);
        k = this.a.h(8);
        this.a.r(3);
        m = this.a.h(13);
        this.a.r(4);
        int n = this.a.h(12);
        localObject = c(paramd0, n);
        if (k != 6)
        {
          i1 = k;
          if (k != 5) {}
        }
        else
        {
          i1 = ((i0.b)localObject).a;
        }
        k = j - (n + 5);
        if (h0.k(h0.this) == 2) {
          j = i1;
        } else {
          j = m;
        }
        if (!h0.r(h0.this).get(j))
        {
          if ((h0.k(h0.this) == 2) && (i1 == 21)) {
            localObject = h0.n(h0.this);
          } else {
            localObject = h0.p(h0.this).b(i1, (i0.b)localObject);
          }
          if ((h0.k(h0.this) != 2) || (m < this.c.get(j, 8192)))
          {
            this.c.put(j, m);
            this.b.put(j, localObject);
          }
        }
      }
      j = this.c.size();
      for (int i1 = 0; i1 < j; i1++)
      {
        m = this.c.keyAt(i1);
        k = this.c.valueAt(i1);
        h0.r(h0.this).put(m, true);
        h0.s(h0.this).put(k, true);
        paramd0 = (i0)this.b.valueAt(i1);
        if (paramd0 != null)
        {
          if (paramd0 != h0.n(h0.this)) {
            paramd0.a(locall0, h0.q(h0.this), new i0.d(i, m, 8192));
          }
          h0.a(h0.this).put(k, paramd0);
        }
      }
      if (h0.k(h0.this) == 2)
      {
        if (!h0.g(h0.this))
        {
          h0.q(h0.this).r();
          h0.i(h0.this, 0);
          h0.h(h0.this, true);
        }
      }
      else
      {
        h0.a(h0.this).remove(this.d);
        paramd0 = h0.this;
        if (h0.k(paramd0) == 1) {
          i1 = 0;
        } else {
          i1 = h0.f(h0.this) - 1;
        }
        h0.i(paramd0, i1);
        if (h0.f(h0.this) == 0)
        {
          h0.q(h0.this).r();
          h0.h(h0.this, true);
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\l0\h0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */