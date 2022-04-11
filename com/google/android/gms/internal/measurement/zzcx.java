package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.measurement.internal.zzfm;

final class zzcx
  extends zzdt
{
  zzcx(zzee paramzzee, String paramString1, String paramString2, Context paramContext, Bundle paramBundle)
  {
    super(paramzzee, true);
  }
  
  public final void zza()
  {
    try
    {
      Object localObject1;
      Object localObject2;
      Object localObject3;
      if (zzee.zzM(this.zze, this.zza, this.zzb))
      {
        localObject1 = this.zzb;
        localObject2 = this.zza;
        localObject3 = zzee.zzN(this.zze);
      }
      else
      {
        localObject4 = null;
        localObject3 = localObject4;
        localObject1 = localObject3;
        localObject2 = localObject3;
        localObject3 = localObject4;
      }
      Preconditions.checkNotNull(this.zzc);
      Object localObject4 = this.zze;
      zzee.zzO((zzee)localObject4, ((zzee)localObject4).zzc(this.zzc, true));
      if (zzee.zzP(this.zze) == null)
      {
        Log.w(zzee.zzN(this.zze), "Failed to connect to measurement client.");
        return;
      }
      int i = DynamiteModule.getLocalVersion(this.zzc, "com.google.android.gms.measurement.dynamite");
      int j = DynamiteModule.getRemoteVersion(this.zzc, "com.google.android.gms.measurement.dynamite");
      int k = Math.max(i, j);
      boolean bool;
      if (j < i) {
        bool = true;
      } else {
        bool = false;
      }
      localObject4 = new com/google/android/gms/internal/measurement/zzcl;
      ((zzcl)localObject4).<init>(42004L, k, bool, (String)localObject3, (String)localObject2, (String)localObject1, this.zzd, zzfm.zza(this.zzc));
      ((zzcc)Preconditions.checkNotNull(zzee.zzP(this.zze))).initialize(ObjectWrapper.wrap(this.zzc), (zzcl)localObject4, this.zzh);
      return;
    }
    catch (Exception localException)
    {
      zzee.zzL(this.zze, localException, true, false);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzcx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */