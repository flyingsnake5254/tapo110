package com.android.billingclient.api;

import android.os.Bundle;
import com.google.android.gms.internal.play_billing.zza;

final class a0
{
  static g a(Bundle paramBundle, String paramString1, String paramString2)
  {
    paramString1 = y.l;
    if (paramBundle == null)
    {
      zza.zzb("BillingClient", String.format("%s got null owned items list", new Object[] { paramString2 }));
      return paramString1;
    }
    int i = zza.zzd(paramBundle, "BillingClient");
    Object localObject1 = zza.zze(paramBundle, "BillingClient");
    Object localObject2 = g.b();
    ((g.a)localObject2).c(i);
    ((g.a)localObject2).b((String)localObject1);
    localObject1 = ((g.a)localObject2).a();
    if (i != 0)
    {
      zza.zzb("BillingClient", String.format("%s failed. Response code: %s", new Object[] { paramString2, Integer.valueOf(i) }));
      return (g)localObject1;
    }
    if ((paramBundle.containsKey("INAPP_PURCHASE_ITEM_LIST")) && (paramBundle.containsKey("INAPP_PURCHASE_DATA_LIST")) && (paramBundle.containsKey("INAPP_DATA_SIGNATURE_LIST")))
    {
      localObject1 = paramBundle.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
      localObject2 = paramBundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
      paramBundle = paramBundle.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
      if (localObject1 == null)
      {
        zza.zzb("BillingClient", String.format("Bundle returned from %s contains null SKUs list.", new Object[] { paramString2 }));
        return paramString1;
      }
      if (localObject2 == null)
      {
        zza.zzb("BillingClient", String.format("Bundle returned from %s contains null purchases list.", new Object[] { paramString2 }));
        return paramString1;
      }
      if (paramBundle == null)
      {
        zza.zzb("BillingClient", String.format("Bundle returned from %s contains null signatures list.", new Object[] { paramString2 }));
        return paramString1;
      }
      return y.p;
    }
    zza.zzb("BillingClient", String.format("Bundle returned from %s doesn't contain required fields.", new Object[] { paramString2 }));
    return paramString1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\android\billingclient\api\a0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */