package com.google.android.gms.internal.play_billing;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.a;
import com.android.billingclient.api.f;
import com.android.billingclient.api.f0;
import com.android.billingclient.api.g;
import com.android.billingclient.api.g.a;
import com.android.billingclient.api.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;

public final class zza
{
  public static final int zza = Runtime.getRuntime().availableProcessors();
  
  public static void zza(String paramString1, String paramString2)
  {
    if (Log.isLoggable(paramString1, 2)) {
      Log.v(paramString1, paramString2);
    }
  }
  
  public static void zzb(String paramString1, String paramString2)
  {
    if (Log.isLoggable(paramString1, 5)) {
      Log.w(paramString1, paramString2);
    }
  }
  
  public static g zzc(Intent paramIntent, String paramString)
  {
    if (paramIntent == null)
    {
      zzb("BillingHelper", "Got null intent!");
      paramIntent = g.b();
      paramIntent.c(6);
      paramIntent.b("An internal error occurred.");
      return paramIntent.a();
    }
    g.a locala = g.b();
    locala.c(zzd(paramIntent.getExtras(), paramString));
    locala.b(zze(paramIntent.getExtras(), paramString));
    return locala.a();
  }
  
  public static int zzd(Bundle paramBundle, String paramString)
  {
    if (paramBundle == null)
    {
      zzb(paramString, "Unexpected null bundle received!");
      return 6;
    }
    paramBundle = paramBundle.get("RESPONSE_CODE");
    if (paramBundle == null)
    {
      zza(paramString, "getResponseCodeFromBundle() got null response code, assuming OK");
      return 0;
    }
    if ((paramBundle instanceof Integer)) {
      return ((Integer)paramBundle).intValue();
    }
    paramBundle = paramBundle.getClass().getName();
    if (paramBundle.length() != 0) {
      paramBundle = "Unexpected type for bundle response code: ".concat(paramBundle);
    } else {
      paramBundle = new String("Unexpected type for bundle response code: ");
    }
    zzb(paramString, paramBundle);
    return 6;
  }
  
  public static String zze(Bundle paramBundle, String paramString)
  {
    if (paramBundle == null)
    {
      zzb(paramString, "Unexpected null bundle received!");
      return "";
    }
    paramBundle = paramBundle.get("DEBUG_MESSAGE");
    if (paramBundle == null)
    {
      zza(paramString, "getDebugMessageFromBundle() got null response code, assuming OK");
      return "";
    }
    if ((paramBundle instanceof String)) {
      return (String)paramBundle;
    }
    paramBundle = paramBundle.getClass().getName();
    if (paramBundle.length() != 0) {
      paramBundle = "Unexpected type for debug message: ".concat(paramBundle);
    } else {
      paramBundle = new String("Unexpected type for debug message: ");
    }
    zzb(paramString, paramBundle);
    return "";
  }
  
  public static List<Purchase> zzf(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    ArrayList localArrayList1 = paramBundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
    ArrayList localArrayList2 = paramBundle.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
    ArrayList localArrayList3 = new ArrayList();
    int i;
    if ((localArrayList1 != null) && (localArrayList2 != null)) {
      i = 0;
    }
    while ((i < localArrayList1.size()) && (i < localArrayList2.size()))
    {
      paramBundle = zzl((String)localArrayList1.get(i), (String)localArrayList2.get(i));
      if (paramBundle != null) {
        localArrayList3.add(paramBundle);
      }
      i++;
      continue;
      zzb("BillingHelper", "Couldn't find purchase lists, trying to find single data.");
      paramBundle = zzl(paramBundle.getString("INAPP_PURCHASE_DATA"), paramBundle.getString("INAPP_DATA_SIGNATURE"));
      if (paramBundle == null)
      {
        zzb("BillingHelper", "Couldn't find single purchase data as well.");
        return null;
      }
      localArrayList3.add(paramBundle);
    }
    return localArrayList3;
  }
  
  public static Bundle zzg(f paramf, boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("playBillingLibraryVersion", paramString);
    if (paramf.c() != 0) {
      localBundle.putInt("prorationMode", paramf.c());
    }
    if (!TextUtils.isEmpty(paramf.g())) {
      localBundle.putString("accountId", paramf.g());
    }
    if (!TextUtils.isEmpty(paramf.i())) {
      localBundle.putString("obfuscatedProfileId", paramf.i());
    }
    if (paramf.d()) {
      localBundle.putBoolean("vr", true);
    }
    if (!TextUtils.isEmpty(paramf.a())) {
      localBundle.putStringArrayList("skusToReplace", new ArrayList(Arrays.asList(new String[] { paramf.a() })));
    }
    if (!TextUtils.isEmpty(paramf.b())) {
      localBundle.putString("oldSkuPurchaseToken", paramf.b());
    }
    if (!TextUtils.isEmpty(null)) {
      localBundle.putString("oldSkuPurchaseId", null);
    }
    if (!TextUtils.isEmpty(null)) {
      localBundle.putString("paymentsPurchaseParams", null);
    }
    if ((paramBoolean1) && (paramBoolean2)) {
      localBundle.putBoolean("enablePendingPurchases", true);
    }
    return localBundle;
  }
  
  public static Bundle zzh(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("playBillingLibraryVersion", paramString);
    if ((paramBoolean1) && (paramBoolean2)) {
      localBundle.putBoolean("enablePendingPurchases", true);
    }
    return localBundle;
  }
  
  public static Bundle zzi(int paramInt, boolean paramBoolean, String paramString1, @Nullable String paramString2, ArrayList<f0> paramArrayList)
  {
    paramString2 = new Bundle();
    if (paramInt >= 9) {
      paramString2.putString("playBillingLibraryVersion", paramString1);
    }
    if ((paramInt >= 9) && (paramBoolean)) {
      paramString2.putBoolean("enablePendingPurchases", true);
    }
    if (paramInt >= 14)
    {
      paramString1 = new ArrayList();
      int i = paramArrayList.size();
      paramInt = 0;
      boolean bool = false;
      while (paramInt < i)
      {
        f0 localf0 = (f0)paramArrayList.get(paramInt);
        paramString1.add(null);
        bool |= TextUtils.isEmpty(null) ^ true;
        paramInt++;
      }
      if (bool) {
        paramString2.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", paramString1);
      }
    }
    return paramString2;
  }
  
  public static Bundle zzj(h paramh, boolean paramBoolean, String paramString)
  {
    paramh = new Bundle();
    if (paramBoolean) {
      paramh.putString("playBillingLibraryVersion", paramString);
    }
    return paramh;
  }
  
  public static Bundle zzk(a parama, String paramString)
  {
    parama = new Bundle();
    parama.putString("playBillingLibraryVersion", paramString);
    return parama;
  }
  
  private static Purchase zzl(String paramString1, String paramString2)
  {
    Object localObject = null;
    if ((paramString1 != null) && (paramString2 != null))
    {
      try
      {
        Purchase localPurchase = new com/android/billingclient/api/Purchase;
        localPurchase.<init>(paramString1, paramString2);
        paramString1 = localPurchase;
      }
      catch (JSONException paramString1)
      {
        paramString1 = String.valueOf(paramString1);
        paramString2 = new StringBuilder(paramString1.length() + 47);
        paramString2.append("Got JSONException while parsing purchase data: ");
        paramString2.append(paramString1);
        zzb("BillingHelper", paramString2.toString());
        paramString1 = (String)localObject;
      }
      return paramString1;
    }
    zzb("BillingHelper", "Received a bad purchase data.");
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\play_billing\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */