package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzo;
import java.util.Map;

final class zzfk
  implements zzo
{
  zzfk(zzfl paramzzfl, String paramString) {}
  
  public final String zza(String paramString)
  {
    Map localMap = (Map)zzfl.zzp(this.zzb).get(this.zza);
    if ((localMap != null) && (localMap.containsKey(paramString))) {
      return (String)localMap.get(paramString);
    }
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzfk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */