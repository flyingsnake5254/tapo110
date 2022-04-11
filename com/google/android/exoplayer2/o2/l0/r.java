package com.google.android.exoplayer2.o2.l0;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format.b;
import com.google.android.exoplayer2.o2.b0;
import com.google.android.exoplayer2.o2.l;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.i;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.z;
import com.google.android.exoplayer2.util.z.a;
import com.google.android.exoplayer2.util.z.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class r
  implements o
{
  private final e0 a;
  private final boolean b;
  private final boolean c;
  private final w d;
  private final w e;
  private final w f;
  private long g;
  private final boolean[] h;
  private String i;
  private b0 j;
  private b k;
  private boolean l;
  private long m;
  private boolean n;
  private final d0 o;
  
  public r(e0 parame0, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a = parame0;
    this.b = paramBoolean1;
    this.c = paramBoolean2;
    this.h = new boolean[3];
    this.d = new w(7, 128);
    this.e = new w(8, 128);
    this.f = new w(6, 128);
    this.o = new d0();
  }
  
  @EnsuresNonNull({"output", "sampleReader"})
  private void a()
  {
    g.i(this.j);
    o0.i(this.k);
  }
  
  @RequiresNonNull({"output", "sampleReader"})
  private void g(long paramLong1, int paramInt1, int paramInt2, long paramLong2)
  {
    Object localObject1;
    if ((!this.l) || (this.k.c()))
    {
      this.d.b(paramInt2);
      this.e.b(paramInt2);
      if (!this.l)
      {
        if ((this.d.c()) && (this.e.c()))
        {
          localObject1 = new ArrayList();
          Object localObject2 = this.d;
          ((List)localObject1).add(Arrays.copyOf(((w)localObject2).d, ((w)localObject2).e));
          localObject2 = this.e;
          ((List)localObject1).add(Arrays.copyOf(((w)localObject2).d, ((w)localObject2).e));
          localObject2 = this.d;
          localObject2 = z.i(((w)localObject2).d, 3, ((w)localObject2).e);
          Object localObject3 = this.e;
          localObject3 = z.h(((w)localObject3).d, 3, ((w)localObject3).e);
          String str = i.a(((z.b)localObject2).a, ((z.b)localObject2).b, ((z.b)localObject2).c);
          this.j.d(new Format.b().S(this.i).e0("video/avc").I(str).j0(((z.b)localObject2).e).Q(((z.b)localObject2).f).a0(((z.b)localObject2).g).T((List)localObject1).E());
          this.l = true;
          this.k.f((z.b)localObject2);
          this.k.e((z.a)localObject3);
          this.d.d();
          this.e.d();
        }
      }
      else if (this.d.c())
      {
        localObject1 = this.d;
        localObject1 = z.i(((w)localObject1).d, 3, ((w)localObject1).e);
        this.k.f((z.b)localObject1);
        this.d.d();
      }
      else if (this.e.c())
      {
        localObject1 = this.e;
        localObject1 = z.h(((w)localObject1).d, 3, ((w)localObject1).e);
        this.k.e((z.a)localObject1);
        this.e.d();
      }
    }
    if (this.f.b(paramInt2))
    {
      localObject1 = this.f;
      paramInt2 = z.k(((w)localObject1).d, ((w)localObject1).e);
      this.o.N(this.f.d, paramInt2);
      this.o.P(4);
      this.a.a(paramLong2, this.o);
    }
    if (this.k.b(paramLong1, paramInt1, this.l, this.n)) {
      this.n = false;
    }
  }
  
  @RequiresNonNull({"sampleReader"})
  private void h(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((!this.l) || (this.k.c()))
    {
      this.d.a(paramArrayOfByte, paramInt1, paramInt2);
      this.e.a(paramArrayOfByte, paramInt1, paramInt2);
    }
    this.f.a(paramArrayOfByte, paramInt1, paramInt2);
    this.k.a(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  @RequiresNonNull({"sampleReader"})
  private void i(long paramLong1, int paramInt, long paramLong2)
  {
    if ((!this.l) || (this.k.c()))
    {
      this.d.e(paramInt);
      this.e.e(paramInt);
    }
    this.f.e(paramInt);
    this.k.h(paramLong1, paramInt, paramLong2);
  }
  
  public void b(d0 paramd0)
  {
    a();
    int i1 = paramd0.e();
    int i2 = paramd0.f();
    byte[] arrayOfByte = paramd0.d();
    this.g += paramd0.a();
    this.j.c(paramd0, paramd0.a());
    for (;;)
    {
      int i3 = z.c(arrayOfByte, i1, i2, this.h);
      if (i3 == i2)
      {
        h(arrayOfByte, i1, i2);
        return;
      }
      int i4 = z.f(arrayOfByte, i3);
      int i5 = i3 - i1;
      if (i5 > 0) {
        h(arrayOfByte, i1, i3);
      }
      int i6 = i2 - i3;
      long l1 = this.g - i6;
      if (i5 < 0) {
        i1 = -i5;
      } else {
        i1 = 0;
      }
      g(l1, i6, i1, this.m);
      i(l1, i4, this.m);
      i1 = i3 + 3;
    }
  }
  
  public void c()
  {
    this.g = 0L;
    this.n = false;
    z.a(this.h);
    this.d.d();
    this.e.d();
    this.f.d();
    b localb = this.k;
    if (localb != null) {
      localb.g();
    }
  }
  
  public void d(l paraml, i0.d paramd)
  {
    paramd.a();
    this.i = paramd.b();
    b0 localb0 = paraml.t(paramd.c(), 2);
    this.j = localb0;
    this.k = new b(localb0, this.b, this.c);
    this.a.b(paraml, paramd);
  }
  
  public void e() {}
  
  public void f(long paramLong, int paramInt)
  {
    this.m = paramLong;
    int i1 = this.n;
    if ((paramInt & 0x2) != 0) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    this.n = (i1 | paramInt);
  }
  
  private static final class b
  {
    private final b0 a;
    private final boolean b;
    private final boolean c;
    private final SparseArray<z.b> d;
    private final SparseArray<z.a> e;
    private final com.google.android.exoplayer2.util.e0 f;
    private byte[] g;
    private int h;
    private int i;
    private long j;
    private boolean k;
    private long l;
    private a m;
    private a n;
    private boolean o;
    private long p;
    private long q;
    private boolean r;
    
    public b(b0 paramb0, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.a = paramb0;
      this.b = paramBoolean1;
      this.c = paramBoolean2;
      this.d = new SparseArray();
      this.e = new SparseArray();
      this.m = new a(null);
      this.n = new a(null);
      paramb0 = new byte[''];
      this.g = paramb0;
      this.f = new com.google.android.exoplayer2.util.e0(paramb0, 0, 0);
      g();
    }
    
    private void d(int paramInt)
    {
      int i1 = this.r;
      int i2 = (int)(this.j - this.p);
      this.a.e(this.q, i1, i2, paramInt, null);
    }
    
    public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      if (!this.k) {
        return;
      }
      int i1 = paramInt2 - paramInt1;
      Object localObject = this.g;
      paramInt2 = localObject.length;
      int i2 = this.h;
      if (paramInt2 < i2 + i1) {
        this.g = Arrays.copyOf((byte[])localObject, (i2 + i1) * 2);
      }
      System.arraycopy(paramArrayOfByte, paramInt1, this.g, this.h, i1);
      paramInt1 = this.h + i1;
      this.h = paramInt1;
      this.f.i(this.g, 0, paramInt1);
      if (!this.f.b(8)) {
        return;
      }
      this.f.k();
      int i3 = this.f.e(2);
      this.f.l(5);
      if (!this.f.c()) {
        return;
      }
      this.f.h();
      if (!this.f.c()) {
        return;
      }
      int i4 = this.f.h();
      if (!this.c)
      {
        this.k = false;
        this.n.f(i4);
        return;
      }
      if (!this.f.c()) {
        return;
      }
      int i5 = this.f.h();
      if (this.e.indexOfKey(i5) < 0)
      {
        this.k = false;
        return;
      }
      localObject = (z.a)this.e.get(i5);
      paramArrayOfByte = (z.b)this.d.get(((z.a)localObject).b);
      if (paramArrayOfByte.h)
      {
        if (!this.f.b(2)) {
          return;
        }
        this.f.l(2);
      }
      if (!this.f.b(paramArrayOfByte.j)) {
        return;
      }
      int i6 = this.f.e(paramArrayOfByte.j);
      boolean bool1;
      if (!paramArrayOfByte.i)
      {
        if (!this.f.b(1)) {
          return;
        }
        bool1 = this.f.d();
        if (bool1)
        {
          if (!this.f.b(1)) {
            return;
          }
          bool2 = this.f.d();
          bool3 = true;
          break label389;
        }
      }
      else
      {
        bool1 = false;
      }
      boolean bool3 = false;
      boolean bool2 = false;
      label389:
      boolean bool4;
      if (this.i == 5) {
        bool4 = true;
      } else {
        bool4 = false;
      }
      if (bool4)
      {
        if (!this.f.c()) {
          return;
        }
        i1 = this.f.h();
      }
      else
      {
        i1 = 0;
      }
      paramInt1 = paramArrayOfByte.k;
      if (paramInt1 == 0)
      {
        if (!this.f.b(paramArrayOfByte.l)) {
          return;
        }
        paramInt1 = this.f.e(paramArrayOfByte.l);
        if ((((z.a)localObject).c) && (!bool1))
        {
          if (!this.f.c()) {
            return;
          }
          paramInt2 = this.f.g();
          break label594;
        }
      }
      else
      {
        if ((paramInt1 == 1) && (!paramArrayOfByte.m))
        {
          if (!this.f.c()) {
            return;
          }
          i2 = this.f.g();
          if ((((z.a)localObject).c) && (!bool1))
          {
            if (!this.f.c()) {
              return;
            }
            i7 = this.f.g();
            paramInt1 = 0;
            paramInt2 = 0;
            break label600;
          }
          paramInt1 = 0;
          paramInt2 = 0;
          break label597;
        }
        paramInt1 = 0;
      }
      paramInt2 = 0;
      label594:
      i2 = 0;
      label597:
      int i7 = 0;
      label600:
      this.n.e(paramArrayOfByte, i3, i4, i6, i5, bool1, bool3, bool2, bool4, i1, paramInt1, paramInt2, i2, i7);
      this.k = false;
    }
    
    public boolean b(long paramLong, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    {
      int i1 = this.i;
      int i2 = 0;
      if ((i1 == 9) || ((this.c) && (a.a(this.n, this.m))))
      {
        if ((paramBoolean1) && (this.o)) {
          d(paramInt + (int)(paramLong - this.j));
        }
        this.p = this.j;
        this.q = this.l;
        this.r = false;
        this.o = true;
      }
      if (this.b) {
        paramBoolean2 = this.n.d();
      }
      paramBoolean1 = this.r;
      i1 = this.i;
      if (i1 != 5)
      {
        paramInt = i2;
        if (paramBoolean2)
        {
          paramInt = i2;
          if (i1 != 1) {}
        }
      }
      else
      {
        paramInt = 1;
      }
      paramBoolean1 |= paramInt;
      this.r = paramBoolean1;
      return paramBoolean1;
    }
    
    public boolean c()
    {
      return this.c;
    }
    
    public void e(z.a parama)
    {
      this.e.append(parama.a, parama);
    }
    
    public void f(z.b paramb)
    {
      this.d.append(paramb.d, paramb);
    }
    
    public void g()
    {
      this.k = false;
      this.o = false;
      this.n.b();
    }
    
    public void h(long paramLong1, int paramInt, long paramLong2)
    {
      this.i = paramInt;
      this.l = paramLong2;
      this.j = paramLong1;
      if (((this.b) && (paramInt == 1)) || ((this.c) && ((paramInt == 5) || (paramInt == 1) || (paramInt == 2))))
      {
        a locala = this.m;
        this.m = this.n;
        this.n = locala;
        locala.b();
        this.h = 0;
        this.k = true;
      }
    }
    
    private static final class a
    {
      private boolean a;
      private boolean b;
      @Nullable
      private z.b c;
      private int d;
      private int e;
      private int f;
      private int g;
      private boolean h;
      private boolean i;
      private boolean j;
      private boolean k;
      private int l;
      private int m;
      private int n;
      private int o;
      private int p;
      
      private boolean c(a parama)
      {
        boolean bool1 = this.a;
        boolean bool2 = false;
        if (!bool1) {
          return false;
        }
        if (!parama.a) {
          return true;
        }
        z.b localb1 = (z.b)g.i(this.c);
        z.b localb2 = (z.b)g.i(parama.c);
        if ((this.f == parama.f) && (this.g == parama.g) && (this.h == parama.h) && ((!this.i) || (!parama.i) || (this.j == parama.j)))
        {
          int i1 = this.d;
          int i2 = parama.d;
          if ((i1 == i2) || ((i1 != 0) && (i2 != 0)))
          {
            i1 = localb1.k;
            if (((i1 != 0) || (localb2.k != 0) || ((this.m == parama.m) && (this.n == parama.n))) && ((i1 != 1) || (localb2.k != 1) || ((this.o == parama.o) && (this.p == parama.p))))
            {
              boolean bool3 = this.k;
              if (bool3 == parama.k)
              {
                bool1 = bool2;
                if (!bool3) {
                  return bool1;
                }
                bool1 = bool2;
                if (this.l == parama.l) {
                  return bool1;
                }
              }
            }
          }
        }
        bool1 = true;
        return bool1;
      }
      
      public void b()
      {
        this.b = false;
        this.a = false;
      }
      
      public boolean d()
      {
        if (this.b)
        {
          int i1 = this.e;
          if ((i1 == 7) || (i1 == 2)) {
            return true;
          }
        }
        boolean bool = false;
        return bool;
      }
      
      public void e(z.b paramb, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
      {
        this.c = paramb;
        this.d = paramInt1;
        this.e = paramInt2;
        this.f = paramInt3;
        this.g = paramInt4;
        this.h = paramBoolean1;
        this.i = paramBoolean2;
        this.j = paramBoolean3;
        this.k = paramBoolean4;
        this.l = paramInt5;
        this.m = paramInt6;
        this.n = paramInt7;
        this.o = paramInt8;
        this.p = paramInt9;
        this.a = true;
        this.b = true;
      }
      
      public void f(int paramInt)
      {
        this.e = paramInt;
        this.b = true;
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\l0\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */