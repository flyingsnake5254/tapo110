package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class zzfo
{
  private static volatile boolean zza = false;
  private static boolean zzb = true;
  private static volatile zzfo zzc;
  private static final zzfo zzd = new zzfo(true);
  private final Map<Object, Object> zze;
  
  zzfo()
  {
    this.zze = new HashMap();
  }
  
  private zzfo(boolean paramBoolean)
  {
    this.zze = Collections.emptyMap();
  }
  
  public static zzfo zza()
  {
    zzfo localzzfo1 = zzc;
    zzfo localzzfo2 = localzzfo1;
    if (localzzfo1 == null) {
      try
      {
        localzzfo1 = zzc;
        localzzfo2 = localzzfo1;
        if (localzzfo1 == null)
        {
          localzzfo2 = zzd;
          zzc = localzzfo2;
        }
      }
      finally {}
    }
    return localzzfo3;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_vision_barcode\zzfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */