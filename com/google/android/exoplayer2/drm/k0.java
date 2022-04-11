package com.google.android.exoplayer2.drm;

import android.util.Pair;
import androidx.annotation.Nullable;
import java.util.Map;

public final class k0
{
  private static long a(Map<String, String> paramMap, String paramString)
  {
    if (paramMap != null) {}
    try
    {
      paramMap = (String)paramMap.get(paramString);
      if (paramMap != null)
      {
        long l = Long.parseLong(paramMap);
        return l;
      }
    }
    catch (NumberFormatException paramMap)
    {
      for (;;) {}
    }
    return -9223372036854775807L;
  }
  
  @Nullable
  public static Pair<Long, Long> b(DrmSession paramDrmSession)
  {
    paramDrmSession = paramDrmSession.g();
    if (paramDrmSession == null) {
      return null;
    }
    return new Pair(Long.valueOf(a(paramDrmSession, "LicenseDurationRemaining")), Long.valueOf(a(paramDrmSession, "PlaybackDurationRemaining")));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\drm\k0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */