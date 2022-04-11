package com.google.android.exoplayer2.trackselection;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.d2;
import com.google.android.exoplayer2.j2;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.e0.a;

public abstract class m
{
  @Nullable
  private a a;
  @Nullable
  private com.google.android.exoplayer2.upstream.g b;
  
  protected final com.google.android.exoplayer2.upstream.g a()
  {
    return (com.google.android.exoplayer2.upstream.g)com.google.android.exoplayer2.util.g.e(this.b);
  }
  
  public final void b(a parama, com.google.android.exoplayer2.upstream.g paramg)
  {
    this.a = parama;
    this.b = paramg;
  }
  
  protected final void c()
  {
    a locala = this.a;
    if (locala != null) {
      locala.a();
    }
  }
  
  public abstract void d(@Nullable Object paramObject);
  
  public abstract n e(d2[] paramArrayOfd2, TrackGroupArray paramTrackGroupArray, e0.a parama, j2 paramj2)
    throws ExoPlaybackException;
  
  public static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\trackselection\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */