package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;

final class zzhu
  implements Runnable
{
  zzhu(zzhv paramzzhv, boolean paramBoolean, Uri paramUri, String paramString1, String paramString2) {}
  
  public final void run()
  {
    zzhv localzzhv = this.zze;
    boolean bool1 = this.zza;
    Object localObject1 = this.zzb;
    String str1 = this.zzc;
    String str2 = this.zzd;
    localzzhv.zza.zzg();
    try
    {
      Object localObject2 = localzzhv.zza.zzs.zzc();
      zzdz localzzdz = zzea.zzab;
      boolean bool2 = ((zzae)localObject2).zzn(null, localzzdz);
      if ((bool2) || (localzzhv.zza.zzs.zzc().zzn(null, zzea.zzad)) || (localzzhv.zza.zzs.zzc().zzn(null, zzea.zzac)))
      {
        localObject3 = localzzhv.zza.zzs.zzl();
        if (!TextUtils.isEmpty(str2)) {
          break label132;
        }
      }
      for (;;)
      {
        localObject2 = null;
        break label256;
        label132:
        if ((str2.contains("gclid")) || (str2.contains("utm_campaign")) || (str2.contains("utm_source")) || (str2.contains("utm_medium"))) {
          break;
        }
        ((zzgn)localObject3).zzs.zzau().zzj().zza("Activity created with data 'referrer' without required params");
      }
      if (str2.length() != 0) {
        localObject2 = "https://google.com/search?".concat(str2);
      } else {
        localObject2 = new String("https://google.com/search?");
      }
      Object localObject3 = ((zzku)localObject3).zzi(Uri.parse((String)localObject2));
      localObject2 = localObject3;
      if (localObject3 != null)
      {
        ((Bundle)localObject3).putString("_cis", "referrer");
        localObject2 = localObject3;
      }
      label256:
      if (bool1)
      {
        localObject1 = localzzhv.zza.zzs.zzl().zzi((Uri)localObject1);
        localObject3 = localObject1;
        if (localObject1 != null)
        {
          ((Bundle)localObject1).putString("_cis", "intent");
          if ((localzzhv.zza.zzs.zzc().zzn(null, localzzdz)) && (!((Bundle)localObject1).containsKey("gclid")) && (localObject2 != null) && (((Bundle)localObject2).containsKey("gclid"))) {
            ((Bundle)localObject1).putString("_cer", String.format("gclid=%s", new Object[] { ((Bundle)localObject2).getString("gclid") }));
          }
          localzzhv.zza.zzs(str1, "_cmp", (Bundle)localObject1);
          localzzhv.zza.zzb.zzb(str1, (Bundle)localObject1);
          localObject3 = localObject1;
        }
      }
      else
      {
        localObject3 = null;
      }
      bool1 = localzzhv.zza.zzs.zzc().zzn(null, zzea.zzad);
      if ((bool1) && (!localzzhv.zza.zzs.zzc().zzn(null, zzea.zzac)) && (localObject2 != null) && (((Bundle)localObject2).containsKey("gclid")) && ((localObject3 == null) || (!((Bundle)localObject3).containsKey("gclid")))) {
        localzzhv.zza.zzy("auto", "_lgclid", ((Bundle)localObject2).getString("gclid"), true);
      }
      if (!TextUtils.isEmpty(str2))
      {
        localzzhv.zza.zzs.zzau().zzj().zzb("Activity created with referrer", str2);
        bool1 = localzzhv.zza.zzs.zzc().zzn(null, zzea.zzac);
        if (bool1)
        {
          if (localObject2 != null)
          {
            localzzhv.zza.zzs(str1, "_cmp", (Bundle)localObject2);
            localzzhv.zza.zzb.zzb(str1, (Bundle)localObject2);
          }
          else
          {
            localzzhv.zza.zzs.zzau().zzj().zzb("Referrer does not contain valid parameters", str2);
          }
          localzzhv.zza.zzy("auto", "_ldl", null, true);
          return;
        }
        if ((!str2.contains("gclid")) || ((!str2.contains("utm_campaign")) && (!str2.contains("utm_source")) && (!str2.contains("utm_medium")) && (!str2.contains("utm_term")) && (!str2.contains("utm_content")))) {
          break label688;
        }
        if (!TextUtils.isEmpty(str2)) {
          localzzhv.zza.zzy("auto", "_ldl", str2, true);
        }
      }
      return;
      label688:
      localzzhv.zza.zzs.zzau().zzj().zza("Activity created with data 'referrer' without required params");
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      localzzhv.zza.zzs.zzau().zzb().zzb("Throwable caught in handleReferrerForOnActivityCreated", localRuntimeException);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzhu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */