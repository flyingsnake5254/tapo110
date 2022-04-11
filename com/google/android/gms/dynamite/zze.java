package com.google.android.gms.dynamite;

import android.content.Context;

final class zze
  implements DynamiteModule.VersionPolicy
{
  public final DynamiteModule.VersionPolicy.zzb zza(Context paramContext, String paramString, DynamiteModule.VersionPolicy.zza paramzza)
    throws DynamiteModule.LoadingException
  {
    DynamiteModule.VersionPolicy.zzb localzzb = new DynamiteModule.VersionPolicy.zzb();
    int i = paramzza.getLocalVersion(paramContext, paramString);
    localzzb.zzir = i;
    if (i != 0) {
      localzzb.zzis = paramzza.zza(paramContext, paramString, false);
    } else {
      localzzb.zzis = paramzza.zza(paramContext, paramString, true);
    }
    i = localzzb.zzir;
    if ((i == 0) && (localzzb.zzis == 0)) {
      localzzb.zzit = 0;
    } else if (i >= localzzb.zzis) {
      localzzb.zzit = -1;
    } else {
      localzzb.zzit = 1;
    }
    return localzzb;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\dynamite\zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */