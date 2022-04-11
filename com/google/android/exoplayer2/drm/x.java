package com.google.android.exoplayer2.drm;

import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;

public abstract interface x
{
  public static final x a;
  @Deprecated
  public static final x b;
  
  static
  {
    a locala = new a();
    a = locala;
    b = locala;
  }
  
  @Nullable
  public abstract DrmSession a(Looper paramLooper, @Nullable v.a parama, Format paramFormat);
  
  public abstract b b(Looper paramLooper, @Nullable v.a parama, Format paramFormat);
  
  @Nullable
  public abstract Class<? extends d0> c(Format paramFormat);
  
  public abstract void prepare();
  
  public abstract void release();
  
  class a
    implements x
  {
    @Nullable
    public DrmSession a(Looper paramLooper, @Nullable v.a parama, Format paramFormat)
    {
      if (paramFormat.K3 == null) {
        return null;
      }
      return new c0(new DrmSession.DrmSessionException(new UnsupportedDrmException(1), 6001));
    }
    
    @Nullable
    public Class<j0> c(Format paramFormat)
    {
      if (paramFormat.K3 != null) {
        paramFormat = j0.class;
      } else {
        paramFormat = null;
      }
      return paramFormat;
    }
  }
  
  public static abstract interface b
  {
    public static final b a = m.b;
    
    public abstract void release();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\drm\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */