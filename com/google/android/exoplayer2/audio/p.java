package com.google.android.exoplayer2.audio;

import android.media.AudioAttributes;
import android.media.AudioAttributes.Builder;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.v0;

public final class p
{
  public static final p a = new b().a();
  public static final v0<p> b = a.a;
  public final int c;
  public final int d;
  public final int e;
  public final int f;
  @Nullable
  private AudioAttributes g;
  
  private p(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramInt3;
    this.f = paramInt4;
  }
  
  @RequiresApi(21)
  public AudioAttributes a()
  {
    if (this.g == null)
    {
      AudioAttributes.Builder localBuilder = new AudioAttributes.Builder().setContentType(this.c).setFlags(this.d).setUsage(this.e);
      if (o0.a >= 29) {
        localBuilder.setAllowedCapturePolicy(this.f);
      }
      this.g = localBuilder.build();
    }
    return this.g;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (p.class == paramObject.getClass()))
    {
      paramObject = (p)paramObject;
      if ((this.c != ((p)paramObject).c) || (this.d != ((p)paramObject).d) || (this.e != ((p)paramObject).e) || (this.f != ((p)paramObject).f)) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public int hashCode()
  {
    return (((527 + this.c) * 31 + this.d) * 31 + this.e) * 31 + this.f;
  }
  
  public static final class b
  {
    private int a = 0;
    private int b = 0;
    private int c = 1;
    private int d = 1;
    
    public p a()
    {
      return new p(this.a, this.b, this.c, this.d, null);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\audio\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */