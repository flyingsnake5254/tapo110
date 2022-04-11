package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

final class zzkl
  implements zzkt
{
  zzkl(zzkn paramzzkn) {}
  
  public final void zza(String paramString1, String paramString2, Bundle paramBundle)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      if (zzkn.zzX(this.zza) != null) {
        zzkn.zzX(this.zza).zzau().zzb().zzb("AppId not known when logging event", "_err");
      }
      return;
    }
    this.zza.zzav().zzh(new zzkk(this, paramString1, "_err", paramBundle));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzkl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */