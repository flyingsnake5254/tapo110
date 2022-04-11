package com.google.android.exoplayer2.drm;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.w0;
import java.util.Map;
import java.util.UUID;

public final class c0
  implements DrmSession
{
  private final DrmSession.DrmSessionException a;
  
  public c0(DrmSession.DrmSessionException paramDrmSessionException)
  {
    this.a = ((DrmSession.DrmSessionException)g.e(paramDrmSessionException));
  }
  
  public void a(@Nullable v.a parama) {}
  
  public void b(@Nullable v.a parama) {}
  
  public final UUID c()
  {
    return w0.a;
  }
  
  public boolean d()
  {
    return false;
  }
  
  @Nullable
  public d0 e()
  {
    return null;
  }
  
  @Nullable
  public DrmSession.DrmSessionException f()
  {
    return this.a;
  }
  
  @Nullable
  public Map<String, String> g()
  {
    return null;
  }
  
  public int getState()
  {
    return 1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\drm\c0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */