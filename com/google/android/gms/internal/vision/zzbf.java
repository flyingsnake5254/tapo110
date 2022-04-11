package com.google.android.gms.internal.vision;

import android.net.Uri;
import java.util.Map;
import javax.annotation.Nullable;

public final class zzbf
{
  private final Map<String, Map<String, String>> map;
  
  zzbf(Map<String, Map<String, String>> paramMap)
  {
    this.map = paramMap;
  }
  
  @Nullable
  public final String zza(@Nullable Uri paramUri, @Nullable String paramString1, @Nullable String paramString2, String paramString3)
  {
    if (paramUri != null) {
      paramString1 = paramUri.toString();
    } else {
      if (paramString1 == null) {
        break label85;
      }
    }
    paramString1 = (Map)this.map.get(paramString1);
    if (paramString1 == null) {
      return null;
    }
    paramUri = paramString3;
    if (paramString2 != null)
    {
      paramUri = String.valueOf(paramString3);
      if (paramUri.length() != 0) {
        paramUri = paramString2.concat(paramUri);
      } else {
        paramUri = new String(paramString2);
      }
    }
    return (String)paramString1.get(paramUri);
    label85:
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzbf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */