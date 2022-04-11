package com.google.android.gms.internal.mlkit_vision_common;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class zzeb
{
  private static volatile boolean zza = false;
  private static boolean zzb = true;
  private static volatile zzeb zzc;
  private static final zzeb zzd = new zzeb(true);
  private final Map<Object, Object> zze;
  
  zzeb()
  {
    this.zze = new HashMap();
  }
  
  private zzeb(boolean paramBoolean)
  {
    this.zze = Collections.emptyMap();
  }
  
  public static zzeb zza()
  {
    zzeb localzzeb1 = zzc;
    zzeb localzzeb2 = localzzeb1;
    if (localzzeb1 == null) {
      try
      {
        localzzeb1 = zzc;
        localzzeb2 = localzzeb1;
        if (localzzeb1 == null)
        {
          localzzeb2 = zzd;
          zzc = localzzeb2;
        }
      }
      finally {}
    }
    return localzzeb3;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_common\zzeb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */