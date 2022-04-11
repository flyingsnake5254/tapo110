package com.google.android.exoplayer2;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.n0;
import com.google.android.exoplayer2.util.w;
import java.io.IOException;

public abstract interface b2
  extends x1.b
{
  public abstract void b();
  
  public abstract boolean d();
  
  public abstract int f();
  
  public abstract boolean g();
  
  public abstract String getName();
  
  public abstract int getState();
  
  @Nullable
  public abstract n0 getStream();
  
  public abstract void h(int paramInt);
  
  public abstract boolean i();
  
  public abstract void j();
  
  public abstract void l()
    throws IOException;
  
  public abstract boolean m();
  
  public abstract void n(Format[] paramArrayOfFormat, n0 paramn0, long paramLong1, long paramLong2)
    throws ExoPlaybackException;
  
  public abstract d2 o();
  
  public abstract void q(float paramFloat1, float paramFloat2)
    throws ExoPlaybackException;
  
  public abstract void r(e2 parame2, Format[] paramArrayOfFormat, n0 paramn0, long paramLong1, boolean paramBoolean1, boolean paramBoolean2, long paramLong2, long paramLong3)
    throws ExoPlaybackException;
  
  public abstract void reset();
  
  public abstract void start()
    throws ExoPlaybackException;
  
  public abstract void stop();
  
  public abstract void t(long paramLong1, long paramLong2)
    throws ExoPlaybackException;
  
  public abstract long u();
  
  public abstract void v(long paramLong)
    throws ExoPlaybackException;
  
  @Nullable
  public abstract w w();
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void b(long paramLong);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\b2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */