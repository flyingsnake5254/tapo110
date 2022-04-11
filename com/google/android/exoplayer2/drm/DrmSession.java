package com.google.android.exoplayer2.drm;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

public abstract interface DrmSession
{
  public abstract void a(@Nullable v.a parama);
  
  public abstract void b(@Nullable v.a parama);
  
  public abstract UUID c();
  
  public abstract boolean d();
  
  @Nullable
  public abstract d0 e();
  
  @Nullable
  public abstract DrmSessionException f();
  
  @Nullable
  public abstract Map<String, String> g();
  
  public abstract int getState();
  
  public static class DrmSessionException
    extends IOException
  {
    public final int errorCode;
    
    public DrmSessionException(Throwable paramThrowable, int paramInt)
    {
      super();
      this.errorCode = paramInt;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\drm\DrmSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */