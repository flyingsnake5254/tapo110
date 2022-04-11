package com.google.android.exoplayer2.source;

import android.os.Looper;
import androidx.annotation.CallSuper;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format.b;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.a;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.DrmSession.DrmSessionException;
import com.google.android.exoplayer2.drm.v.a;
import com.google.android.exoplayer2.drm.x;
import com.google.android.exoplayer2.drm.x.b;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.o2.b0;
import com.google.android.exoplayer2.o2.b0.a;
import com.google.android.exoplayer2.upstream.e;
import com.google.android.exoplayer2.upstream.i;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;
import com.google.android.exoplayer2.util.y;
import java.io.IOException;

public class m0
  implements b0
{
  private boolean A;
  @Nullable
  private Format B;
  @Nullable
  private Format C;
  private int D;
  private boolean E;
  private boolean F;
  private long G;
  private boolean H;
  private final l0 a;
  private final b b;
  private final t0<c> c;
  @Nullable
  private final x d;
  @Nullable
  private final v.a e;
  @Nullable
  private final Looper f;
  @Nullable
  private d g;
  @Nullable
  private Format h;
  @Nullable
  private DrmSession i;
  private int j;
  private int[] k;
  private long[] l;
  private int[] m;
  private int[] n;
  private long[] o;
  private b0.a[] p;
  private int q;
  private int r;
  private int s;
  private int t;
  private long u;
  private long v;
  private long w;
  private boolean x;
  private boolean y;
  private boolean z;
  
  protected m0(e parame, @Nullable Looper paramLooper, @Nullable x paramx, @Nullable v.a parama)
  {
    this.f = paramLooper;
    this.d = paramx;
    this.e = parama;
    this.a = new l0(parame);
    this.b = new b();
    this.j = 1000;
    this.k = new int['Ϩ'];
    this.l = new long['Ϩ'];
    this.o = new long['Ϩ'];
    this.n = new int['Ϩ'];
    this.m = new int['Ϩ'];
    this.p = new b0.a['Ϩ'];
    this.c = new t0(l.a);
    this.u = Long.MIN_VALUE;
    this.v = Long.MIN_VALUE;
    this.w = Long.MIN_VALUE;
    this.z = true;
    this.y = true;
  }
  
  private boolean B()
  {
    boolean bool;
    if (this.t != this.q) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private boolean G(int paramInt)
  {
    DrmSession localDrmSession = this.i;
    boolean bool;
    if ((localDrmSession != null) && (localDrmSession.getState() != 4) && (((this.n[paramInt] & 0x40000000) != 0) || (!this.i.d()))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private void I(Format paramFormat, i1 parami1)
  {
    Object localObject1 = this.h;
    int i1;
    if (localObject1 == null) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0) {
      localObject1 = null;
    } else {
      localObject1 = ((Format)localObject1).K3;
    }
    this.h = paramFormat;
    DrmInitData localDrmInitData = paramFormat.K3;
    Object localObject2 = this.d;
    if (localObject2 != null) {
      localObject2 = paramFormat.b(((x)localObject2).c(paramFormat));
    } else {
      localObject2 = paramFormat;
    }
    parami1.b = ((Format)localObject2);
    parami1.a = this.i;
    if (this.d == null) {
      return;
    }
    if ((i1 == 0) && (o0.b(localObject1, localDrmInitData))) {
      return;
    }
    localObject1 = this.i;
    paramFormat = this.d.a((Looper)g.e(this.f), this.e, paramFormat);
    this.i = paramFormat;
    parami1.a = paramFormat;
    if (localObject1 != null) {
      ((DrmSession)localObject1).b(this.e);
    }
  }
  
  private int J(i1 parami1, DecoderInputBuffer paramDecoderInputBuffer, boolean paramBoolean1, boolean paramBoolean2, b paramb)
  {
    try
    {
      paramDecoderInputBuffer.q = false;
      if (!B())
      {
        if ((!paramBoolean2) && (!this.x))
        {
          paramDecoderInputBuffer = this.C;
          if ((paramDecoderInputBuffer != null) && ((paramBoolean1) || (paramDecoderInputBuffer != this.h)))
          {
            I((Format)g.e(paramDecoderInputBuffer), parami1);
            return -5;
          }
          return -3;
        }
        paramDecoderInputBuffer.m(4);
        return -4;
      }
      Format localFormat = ((c)this.c.e(w())).a;
      if ((!paramBoolean1) && (localFormat == this.h))
      {
        int i1 = x(this.t);
        if (!G(i1))
        {
          paramDecoderInputBuffer.q = true;
          return -3;
        }
        paramDecoderInputBuffer.m(this.n[i1]);
        long l1 = this.o[i1];
        paramDecoderInputBuffer.x = l1;
        if (l1 < this.u) {
          paramDecoderInputBuffer.e(Integer.MIN_VALUE);
        }
        paramb.a = this.m[i1];
        paramb.b = this.l[i1];
        paramb.c = this.p[i1];
        return -4;
      }
      I(localFormat, parami1);
      return -5;
    }
    finally {}
  }
  
  private void O()
  {
    DrmSession localDrmSession = this.i;
    if (localDrmSession != null)
    {
      localDrmSession.b(this.e);
      this.i = null;
      this.h = null;
    }
  }
  
  private void R()
  {
    try
    {
      this.t = 0;
      this.a.o();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private boolean V(Format paramFormat)
  {
    try
    {
      this.z = false;
      boolean bool = o0.b(paramFormat, this.C);
      if (bool) {
        return false;
      }
      if ((!this.c.g()) && (((c)this.c.f()).a.equals(paramFormat))) {
        this.C = ((c)this.c.f()).a;
      } else {
        this.C = paramFormat;
      }
      paramFormat = this.C;
      this.E = y.a(paramFormat.H3, paramFormat.p1);
      this.F = false;
      return true;
    }
    finally {}
  }
  
  private boolean g(long paramLong)
  {
    try
    {
      int i1 = this.q;
      boolean bool = true;
      if (i1 == 0)
      {
        l1 = this.v;
        if (paramLong <= l1) {
          bool = false;
        }
        return bool;
      }
      long l1 = u();
      if (l1 >= paramLong) {
        return false;
      }
      i1 = i(paramLong);
      p(this.r + i1);
      return true;
    }
    finally {}
  }
  
  private void h(long paramLong1, int paramInt1, long paramLong2, int paramInt2, @Nullable b0.a parama)
  {
    try
    {
      int i1 = this.q;
      boolean bool;
      if (i1 > 0)
      {
        i1 = x(i1 - 1);
        if (this.l[i1] + this.m[i1] <= paramLong2) {
          bool = true;
        } else {
          bool = false;
        }
        g.a(bool);
      }
      if ((0x20000000 & paramInt1) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.x = bool;
      this.w = Math.max(this.w, paramLong1);
      i1 = x(this.q);
      this.o[i1] = paramLong1;
      this.l[i1] = paramLong2;
      this.m[i1] = paramInt2;
      this.n[i1] = paramInt1;
      this.p[i1] = parama;
      this.k[i1] = this.D;
      Object localObject1;
      Object localObject2;
      if ((this.c.g()) || (!((c)this.c.f()).a.equals(this.C)))
      {
        parama = this.d;
        if (parama != null) {
          parama = parama.b((Looper)g.e(this.f), this.e, this.C);
        } else {
          parama = x.b.a;
        }
        localObject1 = this.c;
        paramInt1 = A();
        localObject2 = new com/google/android/exoplayer2/source/m0$c;
        ((c)localObject2).<init>((Format)g.e(this.C), parama, null);
        ((t0)localObject1).a(paramInt1, localObject2);
      }
      paramInt1 = this.q + 1;
      this.q = paramInt1;
      paramInt2 = this.j;
      if (paramInt1 == paramInt2)
      {
        paramInt1 = paramInt2 + 1000;
        int[] arrayOfInt1 = new int[paramInt1];
        long[] arrayOfLong = new long[paramInt1];
        parama = new long[paramInt1];
        localObject2 = new int[paramInt1];
        int[] arrayOfInt2 = new int[paramInt1];
        localObject1 = new b0.a[paramInt1];
        i1 = this.s;
        paramInt2 -= i1;
        System.arraycopy(this.l, i1, arrayOfLong, 0, paramInt2);
        System.arraycopy(this.o, this.s, parama, 0, paramInt2);
        System.arraycopy(this.n, this.s, localObject2, 0, paramInt2);
        System.arraycopy(this.m, this.s, arrayOfInt2, 0, paramInt2);
        System.arraycopy(this.p, this.s, localObject1, 0, paramInt2);
        System.arraycopy(this.k, this.s, arrayOfInt1, 0, paramInt2);
        i1 = this.s;
        System.arraycopy(this.l, 0, arrayOfLong, paramInt2, i1);
        System.arraycopy(this.o, 0, parama, paramInt2, i1);
        System.arraycopy(this.n, 0, localObject2, paramInt2, i1);
        System.arraycopy(this.m, 0, arrayOfInt2, paramInt2, i1);
        System.arraycopy(this.p, 0, localObject1, paramInt2, i1);
        System.arraycopy(this.k, 0, arrayOfInt1, paramInt2, i1);
        this.l = arrayOfLong;
        this.o = parama;
        this.n = ((int[])localObject2);
        this.m = arrayOfInt2;
        this.p = ((b0.a[])localObject1);
        this.k = arrayOfInt1;
        this.s = 0;
        this.j = paramInt1;
      }
      return;
    }
    finally {}
  }
  
  private int i(long paramLong)
  {
    int i1 = this.q;
    int i2 = x(i1 - 1);
    while ((i1 > this.t) && (this.o[i2] >= paramLong))
    {
      int i3 = i1 - 1;
      int i4 = i2 - 1;
      i1 = i3;
      i2 = i4;
      if (i4 == -1)
      {
        i2 = this.j - 1;
        i1 = i3;
      }
    }
    return i1;
  }
  
  public static m0 j(e parame, Looper paramLooper, x paramx, v.a parama)
  {
    return new m0(parame, (Looper)g.e(paramLooper), (x)g.e(paramx), (v.a)g.e(parama));
  }
  
  private long k(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      int i1 = this.q;
      if (i1 != 0)
      {
        long[] arrayOfLong = this.o;
        int i2 = this.s;
        if (paramLong >= arrayOfLong[i2])
        {
          int i3 = i1;
          if (paramBoolean2)
          {
            int i4 = this.t;
            i3 = i1;
            if (i4 != i1) {
              i3 = i4 + 1;
            }
          }
          i3 = r(i2, i3, paramLong, paramBoolean1);
          if (i3 == -1) {
            return -1L;
          }
          paramLong = m(i3);
          return paramLong;
        }
      }
      return -1L;
    }
    finally {}
  }
  
  private long l()
  {
    try
    {
      int i1 = this.q;
      if (i1 == 0) {
        return -1L;
      }
      long l1 = m(i1);
      return l1;
    }
    finally {}
  }
  
  @GuardedBy("this")
  private long m(int paramInt)
  {
    this.v = Math.max(this.v, v(paramInt));
    this.q -= paramInt;
    int i1 = this.r + paramInt;
    this.r = i1;
    int i2 = this.s + paramInt;
    this.s = i2;
    int i3 = this.j;
    if (i2 >= i3) {
      this.s = (i2 - i3);
    }
    paramInt = this.t - paramInt;
    this.t = paramInt;
    if (paramInt < 0) {
      this.t = 0;
    }
    this.c.d(i1);
    if (this.q == 0)
    {
      i1 = this.s;
      paramInt = i1;
      if (i1 == 0) {
        paramInt = this.j;
      }
      paramInt--;
      return this.l[paramInt] + this.m[paramInt];
    }
    return this.l[this.s];
  }
  
  private long p(int paramInt)
  {
    int i1 = A() - paramInt;
    boolean bool1 = false;
    if ((i1 >= 0) && (i1 <= this.q - this.t)) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    g.a(bool2);
    int i2 = this.q - i1;
    this.q = i2;
    this.w = Math.max(this.v, v(i2));
    boolean bool2 = bool1;
    if (i1 == 0)
    {
      bool2 = bool1;
      if (this.x) {
        bool2 = true;
      }
    }
    this.x = bool2;
    this.c.c(paramInt);
    paramInt = this.q;
    if (paramInt != 0)
    {
      paramInt = x(paramInt - 1);
      return this.l[paramInt] + this.m[paramInt];
    }
    return 0L;
  }
  
  private int r(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    int i1 = -1;
    int i2 = 0;
    int i3 = paramInt1;
    for (paramInt1 = i2;; paramInt1++)
    {
      i2 = i1;
      if (paramInt1 >= paramInt2) {
        break;
      }
      long[] arrayOfLong = this.o;
      i2 = i1;
      if (arrayOfLong[i3] > paramLong) {
        break;
      }
      if ((!paramBoolean) || ((this.n[i3] & 0x1) != 0))
      {
        if (arrayOfLong[i3] == paramLong)
        {
          i2 = paramInt1;
          break;
        }
        i1 = paramInt1;
      }
      i2 = i3 + 1;
      i3 = i2;
      if (i2 == this.j) {
        i3 = 0;
      }
    }
    return i2;
  }
  
  private long v(int paramInt)
  {
    long l1 = Long.MIN_VALUE;
    if (paramInt == 0) {
      return Long.MIN_VALUE;
    }
    int i1 = x(paramInt - 1);
    long l2;
    for (int i2 = 0;; i2++)
    {
      l2 = l1;
      if (i2 >= paramInt) {
        break;
      }
      l1 = Math.max(l1, this.o[i1]);
      if ((this.n[i1] & 0x1) != 0)
      {
        l2 = l1;
        break;
      }
      int i3 = i1 - 1;
      i1 = i3;
      if (i3 == -1) {
        i1 = this.j - 1;
      }
    }
    return l2;
  }
  
  private int x(int paramInt)
  {
    paramInt = this.s + paramInt;
    int i1 = this.j;
    if (paramInt >= i1) {
      paramInt -= i1;
    }
    return paramInt;
  }
  
  public final int A()
  {
    return this.r + this.q;
  }
  
  protected final void C()
  {
    this.A = true;
  }
  
  public final boolean D()
  {
    try
    {
      boolean bool = this.x;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  @CallSuper
  public boolean E(boolean paramBoolean)
  {
    try
    {
      boolean bool1 = B();
      boolean bool2 = true;
      if (!bool1)
      {
        bool1 = bool2;
        if (!paramBoolean)
        {
          bool1 = bool2;
          if (!this.x)
          {
            localFormat1 = this.C;
            if (localFormat1 != null)
            {
              localFormat2 = this.h;
              if (localFormat1 != localFormat2)
              {
                bool1 = bool2;
                break label59;
              }
            }
            bool1 = false;
          }
        }
        label59:
        return bool1;
      }
      Format localFormat1 = ((c)this.c.e(w())).a;
      Format localFormat2 = this.h;
      if (localFormat1 != localFormat2) {
        return true;
      }
      paramBoolean = G(x(this.t));
      return paramBoolean;
    }
    finally {}
  }
  
  @CallSuper
  public void H()
    throws IOException
  {
    DrmSession localDrmSession = this.i;
    if ((localDrmSession != null) && (localDrmSession.getState() == 1)) {
      throw ((DrmSession.DrmSessionException)g.e(this.i.f()));
    }
  }
  
  public final int K()
  {
    try
    {
      int i1 = x(this.t);
      if (B()) {
        i1 = this.k[i1];
      } else {
        i1 = this.D;
      }
      return i1;
    }
    finally {}
  }
  
  @CallSuper
  public void L()
  {
    o();
    O();
  }
  
  @CallSuper
  public int M(i1 parami1, DecoderInputBuffer paramDecoderInputBuffer, int paramInt, boolean paramBoolean)
  {
    int i1 = 0;
    boolean bool;
    if ((paramInt & 0x2) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    int i2 = J(parami1, paramDecoderInputBuffer, bool, paramBoolean, this.b);
    if ((i2 == -4) && (!paramDecoderInputBuffer.k()))
    {
      if ((paramInt & 0x1) != 0) {
        i1 = 1;
      }
      if ((paramInt & 0x4) == 0) {
        if (i1 != 0) {
          this.a.f(paramDecoderInputBuffer, this.b);
        } else {
          this.a.m(paramDecoderInputBuffer, this.b);
        }
      }
      if (i1 == 0) {
        this.t += 1;
      }
    }
    return i2;
  }
  
  @CallSuper
  public void N()
  {
    Q(true);
    O();
  }
  
  public final void P()
  {
    Q(false);
  }
  
  @CallSuper
  public void Q(boolean paramBoolean)
  {
    this.a.n();
    this.q = 0;
    this.r = 0;
    this.s = 0;
    this.t = 0;
    this.y = true;
    this.u = Long.MIN_VALUE;
    this.v = Long.MIN_VALUE;
    this.w = Long.MIN_VALUE;
    this.x = false;
    this.c.b();
    if (paramBoolean)
    {
      this.B = null;
      this.C = null;
      this.z = true;
    }
  }
  
  public final boolean S(long paramLong, boolean paramBoolean)
  {
    try
    {
      R();
      int i1 = x(this.t);
      if ((B()) && (paramLong >= this.o[i1]) && ((paramLong <= this.w) || (paramBoolean)))
      {
        i1 = r(i1, this.q - this.t, paramLong, true);
        if (i1 == -1) {
          return false;
        }
        this.u = paramLong;
        this.t += i1;
        return true;
      }
      return false;
    }
    finally {}
  }
  
  public final void T(long paramLong)
  {
    if (this.G != paramLong)
    {
      this.G = paramLong;
      C();
    }
  }
  
  public final void U(long paramLong)
  {
    this.u = paramLong;
  }
  
  public final void W(@Nullable d paramd)
  {
    this.g = paramd;
  }
  
  public final void X(int paramInt)
  {
    if (paramInt >= 0) {
      try
      {
        if (this.t + paramInt <= this.q) {
          bool = true;
        }
      }
      finally
      {
        break label47;
      }
    }
    boolean bool = false;
    g.a(bool);
    this.t += paramInt;
    return;
    label47:
    throw ((Throwable)localObject);
  }
  
  public final void Y(int paramInt)
  {
    this.D = paramInt;
  }
  
  public final void Z()
  {
    this.H = true;
  }
  
  public final int a(i parami, int paramInt1, boolean paramBoolean, int paramInt2)
    throws IOException
  {
    return this.a.p(parami, paramInt1, paramBoolean);
  }
  
  public final void d(Format paramFormat)
  {
    Format localFormat = s(paramFormat);
    this.A = false;
    this.B = paramFormat;
    boolean bool = V(localFormat);
    paramFormat = this.g;
    if ((paramFormat != null) && (bool)) {
      paramFormat.g(localFormat);
    }
  }
  
  public void e(long paramLong, int paramInt1, int paramInt2, int paramInt3, @Nullable b0.a parama)
  {
    if (this.A) {
      d((Format)g.i(this.B));
    }
    int i1 = paramInt1 & 0x1;
    int i2;
    if (i1 != 0) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    if (this.y)
    {
      if (i2 == 0) {
        return;
      }
      this.y = false;
    }
    paramLong = this.G + paramLong;
    if (this.E)
    {
      if (paramLong < this.u) {
        return;
      }
      if (i1 == 0)
      {
        if (!this.F)
        {
          String str = String.valueOf(this.C);
          StringBuilder localStringBuilder = new StringBuilder(str.length() + 50);
          localStringBuilder.append("Overriding unexpected non-sync sample for format: ");
          localStringBuilder.append(str);
          u.h("SampleQueue", localStringBuilder.toString());
          this.F = true;
        }
        paramInt1 |= 0x1;
      }
    }
    if (this.H) {
      if ((i2 != 0) && (g(paramLong))) {
        this.H = false;
      } else {
        return;
      }
    }
    h(paramLong, paramInt1, this.a.e() - paramInt2 - paramInt3, paramInt2, parama);
  }
  
  public final void f(d0 paramd0, int paramInt1, int paramInt2)
  {
    this.a.q(paramd0, paramInt1);
  }
  
  public final void n(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a.b(k(paramLong, paramBoolean1, paramBoolean2));
  }
  
  public final void o()
  {
    this.a.b(l());
  }
  
  public final void q(int paramInt)
  {
    this.a.c(p(paramInt));
  }
  
  @CallSuper
  protected Format s(Format paramFormat)
  {
    Format localFormat = paramFormat;
    if (this.G != 0L)
    {
      localFormat = paramFormat;
      if (paramFormat.L3 != Long.MAX_VALUE) {
        localFormat = paramFormat.a().i0(paramFormat.L3 + this.G).E();
      }
    }
    return localFormat;
  }
  
  public final long t()
  {
    try
    {
      long l1 = this.w;
      return l1;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final long u()
  {
    try
    {
      long l1 = Math.max(this.v, v(this.t));
      return l1;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final int w()
  {
    return this.r + this.t;
  }
  
  public final int y(long paramLong, boolean paramBoolean)
  {
    try
    {
      int i1 = x(this.t);
      if ((B()) && (paramLong >= this.o[i1]))
      {
        if ((paramLong > this.w) && (paramBoolean))
        {
          i1 = this.q;
          int i2 = this.t;
          return i1 - i2;
        }
        i1 = r(i1, this.q - this.t, paramLong, true);
        if (i1 == -1) {
          return 0;
        }
        return i1;
      }
      return 0;
    }
    finally {}
  }
  
  @Nullable
  public final Format z()
  {
    try
    {
      Format localFormat;
      if (this.z) {
        localFormat = null;
      } else {
        localFormat = this.C;
      }
      return localFormat;
    }
    finally {}
  }
  
  static final class b
  {
    public int a;
    public long b;
    @Nullable
    public b0.a c;
  }
  
  private static final class c
  {
    public final Format a;
    public final x.b b;
    
    private c(Format paramFormat, x.b paramb)
    {
      this.a = paramFormat;
      this.b = paramb;
    }
  }
  
  public static abstract interface d
  {
    public abstract void g(Format paramFormat);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\source\m0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */