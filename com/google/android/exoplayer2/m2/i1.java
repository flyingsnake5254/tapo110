package com.google.android.exoplayer2.m2;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.decoder.d;
import com.google.android.exoplayer2.decoder.e;
import com.google.android.exoplayer2.j2;
import com.google.android.exoplayer2.l1;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.a0;
import com.google.android.exoplayer2.source.e0.a;
import com.google.android.exoplayer2.source.x;
import com.google.android.exoplayer2.t1;
import com.google.android.exoplayer2.u1;
import com.google.android.exoplayer2.u1.b;
import com.google.android.exoplayer2.u1.f;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p;
import com.google.android.exoplayer2.video.z;
import java.io.IOException;
import java.util.List;

public abstract interface i1
{
  public abstract void A(a parama, Exception paramException);
  
  public abstract void B(a parama, int paramInt);
  
  @Deprecated
  public abstract void C(a parama);
  
  public abstract void D(a parama, @Nullable l1 paraml1, int paramInt);
  
  @Deprecated
  public abstract void E(a parama);
  
  public abstract void F(a parama, d paramd);
  
  public abstract void G(a parama);
  
  public abstract void H(a parama, int paramInt, long paramLong1, long paramLong2);
  
  @Deprecated
  public abstract void I(a parama, int paramInt1, int paramInt2, int paramInt3, float paramFloat);
  
  @Deprecated
  public abstract void J(a parama, int paramInt, Format paramFormat);
  
  @Deprecated
  public abstract void K(a parama);
  
  public abstract void L(a parama, x paramx, a0 parama0);
  
  @Deprecated
  public abstract void M(a parama, int paramInt, String paramString, long paramLong);
  
  public abstract void N(a parama, PlaybackException paramPlaybackException);
  
  @Deprecated
  public abstract void O(a parama, int paramInt);
  
  public abstract void P(a parama);
  
  public abstract void Q(a parama, t1 paramt1);
  
  public abstract void R(a parama, int paramInt, long paramLong1, long paramLong2);
  
  public abstract void S(a parama, d paramd);
  
  public abstract void T(a parama, d paramd);
  
  public abstract void U(a parama, String paramString, long paramLong1, long paramLong2);
  
  public abstract void V(a parama, int paramInt);
  
  public abstract void W(a parama);
  
  public abstract void X(a parama, z paramz);
  
  @Deprecated
  public abstract void Y(a parama, Format paramFormat);
  
  public abstract void Z(a parama);
  
  public abstract void a(a parama, String paramString);
  
  public abstract void a0(a parama, float paramFloat);
  
  public abstract void b(a parama, long paramLong, int paramInt);
  
  public abstract void b0(a parama, x paramx, a0 parama0);
  
  public abstract void c(a parama, int paramInt);
  
  public abstract void c0(a parama, TrackGroupArray paramTrackGroupArray, com.google.android.exoplayer2.trackselection.k paramk);
  
  public abstract void d(a parama, Exception paramException);
  
  public abstract void d0(a parama, boolean paramBoolean);
  
  public abstract void e(a parama);
  
  public abstract void e0(a parama, Exception paramException);
  
  public abstract void f(a parama, int paramInt);
  
  public abstract void f0(a parama, a0 parama0);
  
  @Deprecated
  public abstract void g(a parama, boolean paramBoolean);
  
  public abstract void g0(a parama, x paramx, a0 parama0);
  
  public abstract void h(a parama, m1 paramm1);
  
  public abstract void h0(a parama, a0 parama0);
  
  public abstract void i(a parama, d paramd);
  
  public abstract void i0(a parama, u1.f paramf1, u1.f paramf2, int paramInt);
  
  public abstract void j(a parama, x paramx, a0 parama0, IOException paramIOException, boolean paramBoolean);
  
  public abstract void j0(a parama, String paramString);
  
  @Deprecated
  public abstract void k(a parama, int paramInt, d paramd);
  
  @Deprecated
  public abstract void k0(a parama, String paramString, long paramLong);
  
  @Deprecated
  public abstract void l(a parama, String paramString, long paramLong);
  
  public abstract void l0(a parama, Format paramFormat, @Nullable e parame);
  
  public abstract void m(a parama, Metadata paramMetadata);
  
  public abstract void m0(a parama, u1.b paramb);
  
  public abstract void n(u1 paramu1, b paramb);
  
  public abstract void n0(a parama, Object paramObject, long paramLong);
  
  @Deprecated
  public abstract void o(a parama, boolean paramBoolean, int paramInt);
  
  @Deprecated
  public abstract void o0(a parama, int paramInt, d paramd);
  
  public abstract void p(a parama, int paramInt);
  
  @Deprecated
  public abstract void p0(a parama, List<Metadata> paramList);
  
  @Deprecated
  public abstract void q(a parama, Format paramFormat);
  
  public abstract void q0(a parama, boolean paramBoolean);
  
  public abstract void r(a parama, long paramLong);
  
  public abstract void s(a parama, int paramInt1, int paramInt2);
  
  public abstract void t(a parama, boolean paramBoolean);
  
  public abstract void u(a parama, int paramInt, long paramLong);
  
  public abstract void v(a parama, Exception paramException);
  
  public abstract void w(a parama, boolean paramBoolean);
  
  public abstract void x(a parama, boolean paramBoolean, int paramInt);
  
  public abstract void y(a parama, String paramString, long paramLong1, long paramLong2);
  
  public abstract void z(a parama, Format paramFormat, @Nullable e parame);
  
  public static final class a
  {
    public final long a;
    public final j2 b;
    public final int c;
    @Nullable
    public final e0.a d;
    public final long e;
    public final j2 f;
    public final int g;
    @Nullable
    public final e0.a h;
    public final long i;
    public final long j;
    
    public a(long paramLong1, j2 paramj21, int paramInt1, @Nullable e0.a parama1, long paramLong2, j2 paramj22, int paramInt2, @Nullable e0.a parama2, long paramLong3, long paramLong4)
    {
      this.a = paramLong1;
      this.b = paramj21;
      this.c = paramInt1;
      this.d = parama1;
      this.e = paramLong2;
      this.f = paramj22;
      this.g = paramInt2;
      this.h = parama2;
      this.i = paramLong3;
      this.j = paramLong4;
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      boolean bool = true;
      if (this == paramObject) {
        return true;
      }
      if ((paramObject != null) && (a.class == paramObject.getClass()))
      {
        paramObject = (a)paramObject;
        if ((this.a != ((a)paramObject).a) || (this.c != ((a)paramObject).c) || (this.e != ((a)paramObject).e) || (this.g != ((a)paramObject).g) || (this.i != ((a)paramObject).i) || (this.j != ((a)paramObject).j) || (!com.google.common.base.k.a(this.b, ((a)paramObject).b)) || (!com.google.common.base.k.a(this.d, ((a)paramObject).d)) || (!com.google.common.base.k.a(this.f, ((a)paramObject).f)) || (!com.google.common.base.k.a(this.h, ((a)paramObject).h))) {
          bool = false;
        }
        return bool;
      }
      return false;
    }
    
    public int hashCode()
    {
      return com.google.common.base.k.b(new Object[] { Long.valueOf(this.a), this.b, Integer.valueOf(this.c), this.d, Long.valueOf(this.e), this.f, Integer.valueOf(this.g), this.h, Long.valueOf(this.i), Long.valueOf(this.j) });
    }
  }
  
  public static final class b
  {
    private final p a;
    private final SparseArray<i1.a> b;
    
    public b(p paramp, SparseArray<i1.a> paramSparseArray)
    {
      this.a = paramp;
      SparseArray localSparseArray = new SparseArray(paramp.d());
      for (int i = 0; i < paramp.d(); i++)
      {
        int j = paramp.c(i);
        localSparseArray.append(j, (i1.a)g.e((i1.a)paramSparseArray.get(j)));
      }
      this.b = localSparseArray;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\m2\i1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */