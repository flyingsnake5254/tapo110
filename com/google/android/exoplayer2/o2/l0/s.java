package com.google.android.exoplayer2.o2.l0;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format.b;
import com.google.android.exoplayer2.o2.b0;
import com.google.android.exoplayer2.o2.l;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.i;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;
import com.google.android.exoplayer2.util.z;
import java.util.Collections;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class s
  implements o
{
  private final e0 a;
  private String b;
  private b0 c;
  private a d;
  private boolean e;
  private final boolean[] f;
  private final w g;
  private final w h;
  private final w i;
  private final w j;
  private final w k;
  private long l;
  private long m;
  private final d0 n;
  
  public s(e0 parame0)
  {
    this.a = parame0;
    this.f = new boolean[3];
    this.g = new w(32, 128);
    this.h = new w(33, 128);
    this.i = new w(34, 128);
    this.j = new w(39, 128);
    this.k = new w(40, 128);
    this.n = new d0();
  }
  
  @EnsuresNonNull({"output", "sampleReader"})
  private void a()
  {
    g.i(this.c);
    o0.i(this.d);
  }
  
  @RequiresNonNull({"output", "sampleReader"})
  private void g(long paramLong1, int paramInt1, int paramInt2, long paramLong2)
  {
    this.d.a(paramLong1, paramInt1, this.e);
    if (!this.e)
    {
      this.g.b(paramInt2);
      this.h.b(paramInt2);
      this.i.b(paramInt2);
      if ((this.g.c()) && (this.h.c()) && (this.i.c()))
      {
        this.c.d(i(this.b, this.g, this.h, this.i));
        this.e = true;
      }
    }
    w localw;
    if (this.j.b(paramInt2))
    {
      localw = this.j;
      paramInt1 = z.k(localw.d, localw.e);
      this.n.N(this.j.d, paramInt1);
      this.n.Q(5);
      this.a.a(paramLong2, this.n);
    }
    if (this.k.b(paramInt2))
    {
      localw = this.k;
      paramInt1 = z.k(localw.d, localw.e);
      this.n.N(this.k.d, paramInt1);
      this.n.Q(5);
      this.a.a(paramLong2, this.n);
    }
  }
  
  @RequiresNonNull({"sampleReader"})
  private void h(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.d.e(paramArrayOfByte, paramInt1, paramInt2);
    if (!this.e)
    {
      this.g.a(paramArrayOfByte, paramInt1, paramInt2);
      this.h.a(paramArrayOfByte, paramInt1, paramInt2);
      this.i.a(paramArrayOfByte, paramInt1, paramInt2);
    }
    this.j.a(paramArrayOfByte, paramInt1, paramInt2);
    this.k.a(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  private static Format i(@Nullable String paramString, w paramw1, w paramw2, w paramw3)
  {
    int i1 = paramw1.e;
    byte[] arrayOfByte = new byte[paramw2.e + i1 + paramw3.e];
    System.arraycopy(paramw1.d, 0, arrayOfByte, 0, i1);
    System.arraycopy(paramw2.d, 0, arrayOfByte, paramw1.e, paramw2.e);
    System.arraycopy(paramw3.d, 0, arrayOfByte, paramw1.e + paramw2.e, paramw3.e);
    paramw1 = new com.google.android.exoplayer2.util.e0(paramw2.d, 0, paramw2.e);
    paramw1.l(44);
    int i2 = paramw1.e(3);
    paramw1.k();
    paramw1.l(88);
    paramw1.l(8);
    int i3 = 0;
    i1 = 0;
    while (i3 < i2)
    {
      i4 = i1;
      if (paramw1.d()) {
        i4 = i1 + 89;
      }
      i1 = i4;
      if (paramw1.d()) {
        i1 = i4 + 8;
      }
      i3++;
    }
    paramw1.l(i1);
    if (i2 > 0) {
      paramw1.l((8 - i2) * 2);
    }
    paramw1.h();
    int i4 = paramw1.h();
    if (i4 == 3) {
      paramw1.k();
    }
    int i5 = paramw1.h();
    int i6 = paramw1.h();
    i3 = i5;
    i1 = i6;
    if (paramw1.d())
    {
      i3 = paramw1.h();
      int i7 = paramw1.h();
      int i8 = paramw1.h();
      int i9 = paramw1.h();
      if ((i4 != 1) && (i4 != 2)) {
        i1 = 1;
      } else {
        i1 = 2;
      }
      if (i4 == 1) {
        i4 = 2;
      } else {
        i4 = 1;
      }
      i3 = i5 - i1 * (i3 + i7);
      i1 = i6 - i4 * (i8 + i9);
    }
    paramw1.h();
    paramw1.h();
    i6 = paramw1.h();
    if (paramw1.d()) {
      i4 = 0;
    }
    for (i4 = i2; i4 <= i2; i4++)
    {
      paramw1.h();
      paramw1.h();
      paramw1.h();
    }
    paramw1.h();
    paramw1.h();
    paramw1.h();
    paramw1.h();
    paramw1.h();
    paramw1.h();
    if ((paramw1.d()) && (paramw1.d())) {
      j(paramw1);
    }
    paramw1.l(2);
    if (paramw1.d())
    {
      paramw1.l(8);
      paramw1.h();
      paramw1.h();
      paramw1.k();
    }
    k(paramw1);
    if (paramw1.d()) {
      for (i4 = 0; i4 < paramw1.h(); i4++) {
        paramw1.l(i6 + 4 + 1);
      }
    }
    paramw1.l(2);
    float f1 = 1.0F;
    float f2 = f1;
    i4 = i1;
    if (paramw1.d())
    {
      float f3 = f1;
      if (paramw1.d())
      {
        i4 = paramw1.e(8);
        if (i4 == 255)
        {
          i2 = paramw1.e(16);
          i4 = paramw1.e(16);
          f3 = f1;
          if (i2 != 0)
          {
            f3 = f1;
            if (i4 != 0) {
              f3 = i2 / i4;
            }
          }
        }
        else
        {
          paramw3 = z.b;
          if (i4 < paramw3.length)
          {
            f3 = paramw3[i4];
          }
          else
          {
            paramw3 = new StringBuilder(46);
            paramw3.append("Unexpected aspect_ratio_idc value: ");
            paramw3.append(i4);
            u.h("H265Reader", paramw3.toString());
            f3 = f1;
          }
        }
      }
      if (paramw1.d()) {
        paramw1.k();
      }
      if (paramw1.d())
      {
        paramw1.l(4);
        if (paramw1.d()) {
          paramw1.l(24);
        }
      }
      if (paramw1.d())
      {
        paramw1.h();
        paramw1.h();
      }
      paramw1.k();
      f2 = f3;
      i4 = i1;
      if (paramw1.d())
      {
        i4 = i1 * 2;
        f2 = f3;
      }
    }
    paramw1.i(paramw2.d, 0, paramw2.e);
    paramw1.l(24);
    paramw1 = i.c(paramw1);
    return new Format.b().S(paramString).e0("video/hevc").I(paramw1).j0(i3).Q(i4).a0(f2).T(Collections.singletonList(arrayOfByte)).E();
  }
  
  private static void j(com.google.android.exoplayer2.util.e0 parame0)
  {
    for (int i1 = 0; i1 < 4; i1++)
    {
      int i2 = 0;
      while (i2 < 6)
      {
        boolean bool = parame0.d();
        int i3 = 1;
        if (!bool)
        {
          parame0.h();
        }
        else
        {
          int i4 = Math.min(64, 1 << (i1 << 1) + 4);
          if (i1 > 1) {
            parame0.g();
          }
          for (i5 = 0; i5 < i4; i5++) {
            parame0.g();
          }
        }
        int i5 = i3;
        if (i1 == 3) {
          i5 = 3;
        }
        i2 += i5;
      }
    }
  }
  
  private static void k(com.google.android.exoplayer2.util.e0 parame0)
  {
    int i1 = parame0.h();
    int i2 = 0;
    boolean bool = false;
    int i5;
    for (int i3 = 0; i2 < i1; i3 = i5)
    {
      if (i2 != 0) {
        bool = parame0.d();
      }
      if (bool)
      {
        parame0.k();
        parame0.h();
        for (i4 = 0;; i4++)
        {
          i5 = i3;
          if (i4 > i3) {
            break;
          }
          if (parame0.d()) {
            parame0.k();
          }
        }
      }
      int i4 = parame0.h();
      i5 = parame0.h();
      for (i3 = 0; i3 < i4; i3++)
      {
        parame0.h();
        parame0.k();
      }
      for (i3 = 0; i3 < i5; i3++)
      {
        parame0.h();
        parame0.k();
      }
      i5 = i4 + i5;
      i2++;
    }
  }
  
  @RequiresNonNull({"sampleReader"})
  private void l(long paramLong1, int paramInt1, int paramInt2, long paramLong2)
  {
    this.d.g(paramLong1, paramInt1, paramInt2, paramLong2, this.e);
    if (!this.e)
    {
      this.g.e(paramInt2);
      this.h.e(paramInt2);
      this.i.e(paramInt2);
    }
    this.j.e(paramInt2);
    this.k.e(paramInt2);
  }
  
  public void b(d0 paramd0)
  {
    a();
    while (paramd0.a() > 0)
    {
      int i1 = paramd0.e();
      int i2 = paramd0.f();
      byte[] arrayOfByte = paramd0.d();
      this.l += paramd0.a();
      this.c.c(paramd0, paramd0.a());
      while (i1 < i2)
      {
        int i3 = z.c(arrayOfByte, i1, i2, this.f);
        if (i3 == i2)
        {
          h(arrayOfByte, i1, i2);
          return;
        }
        int i4 = z.e(arrayOfByte, i3);
        int i5 = i3 - i1;
        if (i5 > 0) {
          h(arrayOfByte, i1, i3);
        }
        int i6 = i2 - i3;
        long l1 = this.l - i6;
        if (i5 < 0) {
          i1 = -i5;
        } else {
          i1 = 0;
        }
        g(l1, i6, i1, this.m);
        l(l1, i6, i4, this.m);
        i1 = i3 + 3;
      }
    }
  }
  
  public void c()
  {
    this.l = 0L;
    z.a(this.f);
    this.g.d();
    this.h.d();
    this.i.d();
    this.j.d();
    this.k.d();
    a locala = this.d;
    if (locala != null) {
      locala.f();
    }
  }
  
  public void d(l paraml, i0.d paramd)
  {
    paramd.a();
    this.b = paramd.b();
    b0 localb0 = paraml.t(paramd.c(), 2);
    this.c = localb0;
    this.d = new a(localb0);
    this.a.b(paraml, paramd);
  }
  
  public void e() {}
  
  public void f(long paramLong, int paramInt)
  {
    this.m = paramLong;
  }
  
  private static final class a
  {
    private final b0 a;
    private long b;
    private boolean c;
    private int d;
    private long e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private long k;
    private long l;
    private boolean m;
    
    public a(b0 paramb0)
    {
      this.a = paramb0;
    }
    
    private static boolean b(int paramInt)
    {
      boolean bool;
      if (((32 <= paramInt) && (paramInt <= 35)) || (paramInt == 39)) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    private static boolean c(int paramInt)
    {
      boolean bool;
      if ((paramInt >= 32) && (paramInt != 40)) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    
    private void d(int paramInt)
    {
      int n = this.m;
      int i1 = (int)(this.b - this.k);
      this.a.e(this.l, n, i1, paramInt, null);
    }
    
    public void a(long paramLong, int paramInt, boolean paramBoolean)
    {
      if ((this.j) && (this.g))
      {
        this.m = this.c;
        this.j = false;
      }
      else if ((this.h) || (this.g))
      {
        if ((paramBoolean) && (this.i)) {
          d(paramInt + (int)(paramLong - this.b));
        }
        this.k = this.b;
        this.l = this.e;
        this.m = this.c;
        this.i = true;
      }
    }
    
    public void e(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      if (this.f)
      {
        int n = this.d;
        int i1 = paramInt1 + 2 - n;
        if (i1 < paramInt2)
        {
          boolean bool;
          if ((paramArrayOfByte[i1] & 0x80) != 0) {
            bool = true;
          } else {
            bool = false;
          }
          this.g = bool;
          this.f = false;
        }
        else
        {
          this.d = (n + (paramInt2 - paramInt1));
        }
      }
    }
    
    public void f()
    {
      this.f = false;
      this.g = false;
      this.h = false;
      this.i = false;
      this.j = false;
    }
    
    public void g(long paramLong1, int paramInt1, int paramInt2, long paramLong2, boolean paramBoolean)
    {
      boolean bool = false;
      this.g = false;
      this.h = false;
      this.e = paramLong2;
      this.d = 0;
      this.b = paramLong1;
      if (!c(paramInt2))
      {
        if ((this.i) && (!this.j))
        {
          if (paramBoolean) {
            d(paramInt1);
          }
          this.i = false;
        }
        if (b(paramInt2))
        {
          this.h = (this.j ^ true);
          this.j = true;
        }
      }
      if ((paramInt2 >= 16) && (paramInt2 <= 21)) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      this.c = paramBoolean;
      if (!paramBoolean)
      {
        paramBoolean = bool;
        if (paramInt2 > 9) {}
      }
      else
      {
        paramBoolean = true;
      }
      this.f = paramBoolean;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\l0\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */