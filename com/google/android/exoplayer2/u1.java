package com.google.android.exoplayer2;

import android.os.Looper;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.audio.r;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.e;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.util.p;
import com.google.android.exoplayer2.util.p.b;
import com.google.android.exoplayer2.video.w;
import com.google.android.exoplayer2.video.z;
import java.util.List;

public abstract interface u1
{
  public abstract com.google.android.exoplayer2.trackselection.k A();
  
  public abstract void B(int paramInt, long paramLong);
  
  public abstract b C();
  
  public abstract void D(l1 paraml1);
  
  public abstract boolean E();
  
  public abstract void F(boolean paramBoolean);
  
  public abstract int G();
  
  public abstract int H();
  
  public abstract void I(@Nullable TextureView paramTextureView);
  
  public abstract z J();
  
  public abstract int K();
  
  public abstract long L();
  
  public abstract long M();
  
  public abstract void N(e parame);
  
  public abstract boolean O();
  
  public abstract void P(@Nullable SurfaceView paramSurfaceView);
  
  public abstract boolean Q();
  
  public abstract long R();
  
  public abstract void S();
  
  public abstract void T();
  
  public abstract m1 U();
  
  public abstract long V();
  
  public abstract long W();
  
  public abstract t1 c();
  
  public abstract void e(t1 paramt1);
  
  public abstract boolean f();
  
  public abstract long g();
  
  public abstract int getPlaybackState();
  
  public abstract int getRepeatMode();
  
  public abstract boolean h();
  
  public abstract void i(e parame);
  
  public abstract void j(List<l1> paramList, boolean paramBoolean);
  
  public abstract void k(@Nullable SurfaceView paramSurfaceView);
  
  public abstract void l(int paramInt1, int paramInt2);
  
  public abstract int m();
  
  public abstract void n();
  
  @Nullable
  public abstract PlaybackException o();
  
  public abstract void p(boolean paramBoolean);
  
  public abstract void play();
  
  public abstract void prepare();
  
  public abstract List<com.google.android.exoplayer2.text.c> q();
  
  public abstract int r();
  
  public abstract void release();
  
  public abstract boolean s(int paramInt);
  
  public abstract void seekTo(long paramLong);
  
  public abstract void setRepeatMode(int paramInt);
  
  public abstract int t();
  
  public abstract TrackGroupArray u();
  
  public abstract long v();
  
  public abstract j2 w();
  
  public abstract Looper x();
  
  public abstract void y();
  
  public abstract void z(@Nullable TextureView paramTextureView);
  
  public static final class b
  {
    public static final b a = new a().e();
    public static final v0<b> b = j0.a;
    private final p c;
    
    private b(p paramp)
    {
      this.c = paramp;
    }
    
    public boolean b(int paramInt)
    {
      return this.c.a(paramInt);
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if (!(paramObject instanceof b)) {
        return false;
      }
      paramObject = (b)paramObject;
      return this.c.equals(((b)paramObject).c);
    }
    
    public int hashCode()
    {
      return this.c.hashCode();
    }
    
    public static final class a
    {
      private static final int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27 };
      private final p.b b = new p.b();
      
      public a a(int paramInt)
      {
        this.b.a(paramInt);
        return this;
      }
      
      public a b(u1.b paramb)
      {
        this.b.b(u1.b.a(paramb));
        return this;
      }
      
      public a c(int... paramVarArgs)
      {
        this.b.c(paramVarArgs);
        return this;
      }
      
      public a d(int paramInt, boolean paramBoolean)
      {
        this.b.d(paramInt, paramBoolean);
        return this;
      }
      
      public u1.b e()
      {
        return new u1.b(this.b.e(), null);
      }
    }
  }
  
  @Deprecated
  public static abstract interface c
  {
    public abstract void G(TrackGroupArray paramTrackGroupArray, com.google.android.exoplayer2.trackselection.k paramk);
    
    public abstract void J(@Nullable PlaybackException paramPlaybackException);
    
    @Deprecated
    public abstract void K(int paramInt);
    
    public abstract void M(boolean paramBoolean);
    
    @Deprecated
    public abstract void O();
    
    public abstract void P(PlaybackException paramPlaybackException);
    
    public abstract void S(u1 paramu1, u1.d paramd);
    
    @Deprecated
    public abstract void U(boolean paramBoolean, int paramInt);
    
    public abstract void Y(@Nullable l1 paraml1, int paramInt);
    
    public abstract void d(t1 paramt1);
    
    public abstract void d0(boolean paramBoolean, int paramInt);
    
    public abstract void e(u1.f paramf1, u1.f paramf2, int paramInt);
    
    public abstract void f(int paramInt);
    
    @Deprecated
    public abstract void g(boolean paramBoolean);
    
    @Deprecated
    public abstract void j(List<Metadata> paramList);
    
    public abstract void m0(boolean paramBoolean);
    
    public abstract void n(u1.b paramb);
    
    public abstract void o(j2 paramj2, int paramInt);
    
    public abstract void onRepeatModeChanged(int paramInt);
    
    public abstract void q(int paramInt);
    
    public abstract void s(m1 paramm1);
    
    public abstract void v(boolean paramBoolean);
  }
  
  public static final class d
  {
    private final p a;
    
    public d(p paramp)
    {
      this.a = paramp;
    }
    
    public boolean a(int paramInt)
    {
      return this.a.a(paramInt);
    }
    
    public boolean b(int... paramVarArgs)
    {
      return this.a.b(paramVarArgs);
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if (!(paramObject instanceof d)) {
        return false;
      }
      paramObject = (d)paramObject;
      return this.a.equals(((d)paramObject).a);
    }
    
    public int hashCode()
    {
      return this.a.hashCode();
    }
  }
  
  public static abstract interface e
    extends w, r, com.google.android.exoplayer2.text.k, e, com.google.android.exoplayer2.n2.c, u1.c
  {}
  
  public static final class f
  {
    public static final v0<f> a = k0.a;
    @Nullable
    public final Object b;
    public final int c;
    @Nullable
    public final Object d;
    public final int e;
    public final long f;
    public final long g;
    public final int h;
    public final int i;
    
    public f(@Nullable Object paramObject1, int paramInt1, @Nullable Object paramObject2, int paramInt2, long paramLong1, long paramLong2, int paramInt3, int paramInt4)
    {
      this.b = paramObject1;
      this.c = paramInt1;
      this.d = paramObject2;
      this.e = paramInt2;
      this.f = paramLong1;
      this.g = paramLong2;
      this.h = paramInt3;
      this.i = paramInt4;
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      boolean bool = true;
      if (this == paramObject) {
        return true;
      }
      if ((paramObject != null) && (f.class == paramObject.getClass()))
      {
        paramObject = (f)paramObject;
        if ((this.c != ((f)paramObject).c) || (this.e != ((f)paramObject).e) || (this.f != ((f)paramObject).f) || (this.g != ((f)paramObject).g) || (this.h != ((f)paramObject).h) || (this.i != ((f)paramObject).i) || (!com.google.common.base.k.a(this.b, ((f)paramObject).b)) || (!com.google.common.base.k.a(this.d, ((f)paramObject).d))) {
          bool = false;
        }
        return bool;
      }
      return false;
    }
    
    public int hashCode()
    {
      return com.google.common.base.k.b(new Object[] { this.b, Integer.valueOf(this.c), this.d, Integer.valueOf(this.e), Integer.valueOf(this.c), Long.valueOf(this.f), Long.valueOf(this.g), Integer.valueOf(this.h), Integer.valueOf(this.i) });
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\u1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */