package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.util.Clock;

final class zzhl
  implements zzkt
{
  zzhl(zzhw paramzzhw) {}
  
  public final void zza(String paramString1, String paramString2, Bundle paramBundle)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      paramString2 = this.zza;
      zzfu.zzP();
      paramString2.zzx("auto", "_err", paramString2.zzs.zzay().currentTimeMillis(), paramBundle, false, true, false, paramString1);
      return;
    }
    this.zza.zzs("auto", "_err", paramBundle);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzhl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */