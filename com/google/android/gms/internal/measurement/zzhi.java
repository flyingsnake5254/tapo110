package com.google.android.gms.internal.measurement;

import android.net.Uri;
import java.util.Map;
import javax.annotation.Nullable;

public final class zzhi
{
  private final Map<String, Map<String, String>> zza;
  
  zzhi(Map<String, Map<String, String>> paramMap)
  {
    this.zza = paramMap;
  }
  
  @Nullable
  public final String zza(@Nullable Uri paramUri, @Nullable String paramString1, @Nullable String paramString2, String paramString3)
  {
    if (paramUri != null)
    {
      paramUri = paramUri.toString();
      paramString1 = (Map)this.zza.get(paramUri);
      if (paramString1 == null) {
        return null;
      }
      paramUri = String.valueOf(paramString3);
      if (paramUri.length() != 0) {
        paramUri = "".concat(paramUri);
      } else {
        paramUri = new String("");
      }
      return (String)paramString1.get(paramUri);
    }
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzhi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */