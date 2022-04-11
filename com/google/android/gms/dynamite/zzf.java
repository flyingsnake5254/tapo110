package com.google.android.gms.dynamite;

import android.content.Context;

final class zzf
  implements DynamiteModule.VersionPolicy
{
  public final DynamiteModule.VersionPolicy.zzb zza(Context paramContext, String paramString, DynamiteModule.VersionPolicy.zza paramzza)
    throws DynamiteModule.LoadingException
  {
    DynamiteModule.VersionPolicy.zzb localzzb = new DynamiteModule.VersionPolicy.zzb();
    localzzb.zzir = paramzza.getLocalVersion(paramContext, paramString);
    int i = paramzza.zza(paramContext, paramString, true);
    localzzb.zzis = i;
    int j = localzzb.zzir;
    if ((j == 0) && (i == 0)) {
      localzzb.zzit = 0;
    } else if (i >= j) {
      localzzb.zzit = 1;
    } else {
      localzzb.zzit = -1;
    }
    return localzzb;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\dynamite\zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */