package com.google.android.gms.internal.mlkit_common;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class zzen
{
  private static volatile boolean zza = false;
  private static boolean zzb = true;
  private static volatile zzen zzc;
  private static final zzen zzd = new zzen(true);
  private final Map<Object, Object> zze;
  
  zzen()
  {
    this.zze = new HashMap();
  }
  
  private zzen(boolean paramBoolean)
  {
    this.zze = Collections.emptyMap();
  }
  
  public static zzen zza()
  {
    zzen localzzen1 = zzc;
    zzen localzzen2 = localzzen1;
    if (localzzen1 == null) {
      try
      {
        localzzen1 = zzc;
        localzzen2 = localzzen1;
        if (localzzen1 == null)
        {
          localzzen2 = zzd;
          zzc = localzzen2;
        }
      }
      finally {}
    }
    return localzzen3;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_common\zzen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */