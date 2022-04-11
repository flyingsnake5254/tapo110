package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.measurement.internal.zzgq;
import com.google.android.gms.measurement.internal.zzgr;
import com.google.android.gms.measurement.internal.zzgt;
import com.google.android.gms.measurement.internal.zzic;
import com.google.firebase.analytics.connector.AnalyticsConnector.ConditionalUserProperty;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class zzc
{
  private static final Set<String> zza = new HashSet(Arrays.asList(new String[] { "_in", "_xa", "_xu", "_aq", "_aa", "_ai", "_ac", "campaign_details", "_ug", "_iapx", "_exp_set", "_exp_clear", "_exp_activate", "_exp_timeout", "_exp_expire" }));
  private static final List<String> zzb = Arrays.asList(new String[] { "_e", "_f", "_iap", "_s", "_au", "_ui", "_cd" });
  private static final List<String> zzc = Arrays.asList(new String[] { "auto", "app", "am" });
  private static final List<String> zzd = Arrays.asList(new String[] { "_r", "_dbg" });
  private static final List<String> zze = Arrays.asList((String[])ArrayUtils.concat(new String[][] { zzgt.zza, zzgt.zzb }));
  private static final List<String> zzf = Arrays.asList(new String[] { "^_ltv_[A-Z]{3}$", "^_cc[1-5]{1}$" });
  
  public static boolean zza(String paramString)
  {
    return !zzc.contains(paramString);
  }
  
  public static boolean zzb(String paramString, Bundle paramBundle)
  {
    if (zzb.contains(paramString)) {
      return false;
    }
    if (paramBundle != null)
    {
      paramString = zzd.iterator();
      while (paramString.hasNext()) {
        if (paramBundle.containsKey((String)paramString.next())) {
          return false;
        }
      }
    }
    return true;
  }
  
  public static boolean zzc(String paramString)
  {
    return !zza.contains(paramString);
  }
  
  public static boolean zzd(String paramString1, String paramString2)
  {
    if ((!"_ce1".equals(paramString2)) && (!"_ce2".equals(paramString2)))
    {
      if ("_ln".equals(paramString2)) {
        return (paramString1.equals("fcm")) || (paramString1.equals("fiam"));
      }
      if (zze.contains(paramString2)) {
        return false;
      }
      paramString1 = zzf.iterator();
      while (paramString1.hasNext()) {
        if (paramString2.matches((String)paramString1.next())) {
          return false;
        }
      }
      return true;
    }
    return (paramString1.equals("fcm")) || (paramString1.equals("frc"));
  }
  
  public static boolean zze(AnalyticsConnector.ConditionalUserProperty paramConditionalUserProperty)
  {
    if (paramConditionalUserProperty == null) {
      return false;
    }
    String str = paramConditionalUserProperty.origin;
    if ((str != null) && (!str.isEmpty()))
    {
      Object localObject = paramConditionalUserProperty.value;
      if ((localObject != null) && (zzic.zzb(localObject) == null)) {
        return false;
      }
      if (!zza(str)) {
        return false;
      }
      if (!zzd(str, paramConditionalUserProperty.name)) {
        return false;
      }
      localObject = paramConditionalUserProperty.expiredEventName;
      if (localObject != null)
      {
        if (!zzb((String)localObject, paramConditionalUserProperty.expiredEventParams)) {
          return false;
        }
        if (!zzf(str, paramConditionalUserProperty.expiredEventName, paramConditionalUserProperty.expiredEventParams)) {
          return false;
        }
      }
      localObject = paramConditionalUserProperty.triggeredEventName;
      if (localObject != null)
      {
        if (!zzb((String)localObject, paramConditionalUserProperty.triggeredEventParams)) {
          return false;
        }
        if (!zzf(str, paramConditionalUserProperty.triggeredEventName, paramConditionalUserProperty.triggeredEventParams)) {
          return false;
        }
      }
      localObject = paramConditionalUserProperty.timedOutEventName;
      if (localObject != null)
      {
        if (!zzb((String)localObject, paramConditionalUserProperty.timedOutEventParams)) {
          return false;
        }
        if (!zzf(str, paramConditionalUserProperty.timedOutEventName, paramConditionalUserProperty.timedOutEventParams)) {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  public static boolean zzf(String paramString1, String paramString2, Bundle paramBundle)
  {
    if (!"_cmp".equals(paramString2)) {
      return true;
    }
    if (!zza(paramString1)) {
      return false;
    }
    if (paramBundle == null) {
      return false;
    }
    paramString2 = zzd.iterator();
    while (paramString2.hasNext()) {
      if (paramBundle.containsKey((String)paramString2.next())) {
        return false;
      }
    }
    int i = paramString1.hashCode();
    if (i != 101200)
    {
      if (i != 101230)
      {
        if ((i == 3142703) && (paramString1.equals("fiam")))
        {
          i = 2;
          break label132;
        }
      }
      else if (paramString1.equals("fdl"))
      {
        i = 1;
        break label132;
      }
    }
    else if (paramString1.equals("fcm"))
    {
      i = 0;
      break label132;
    }
    i = -1;
    label132:
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return false;
        }
        paramBundle.putString("_cis", "fiam_integration");
        return true;
      }
      paramBundle.putString("_cis", "fdl_integration");
      return true;
    }
    paramBundle.putString("_cis", "fcm_integration");
    return true;
  }
  
  public static Bundle zzg(AnalyticsConnector.ConditionalUserProperty paramConditionalUserProperty)
  {
    Bundle localBundle = new Bundle();
    Object localObject = paramConditionalUserProperty.origin;
    if (localObject != null) {
      localBundle.putString("origin", (String)localObject);
    }
    localObject = paramConditionalUserProperty.name;
    if (localObject != null) {
      localBundle.putString("name", (String)localObject);
    }
    localObject = paramConditionalUserProperty.value;
    if (localObject != null) {
      zzgq.zza(localBundle, localObject);
    }
    localObject = paramConditionalUserProperty.triggerEventName;
    if (localObject != null) {
      localBundle.putString("trigger_event_name", (String)localObject);
    }
    localBundle.putLong("trigger_timeout", paramConditionalUserProperty.triggerTimeout);
    localObject = paramConditionalUserProperty.timedOutEventName;
    if (localObject != null) {
      localBundle.putString("timed_out_event_name", (String)localObject);
    }
    localObject = paramConditionalUserProperty.timedOutEventParams;
    if (localObject != null) {
      localBundle.putBundle("timed_out_event_params", (Bundle)localObject);
    }
    localObject = paramConditionalUserProperty.triggeredEventName;
    if (localObject != null) {
      localBundle.putString("triggered_event_name", (String)localObject);
    }
    localObject = paramConditionalUserProperty.triggeredEventParams;
    if (localObject != null) {
      localBundle.putBundle("triggered_event_params", (Bundle)localObject);
    }
    localBundle.putLong("time_to_live", paramConditionalUserProperty.timeToLive);
    localObject = paramConditionalUserProperty.expiredEventName;
    if (localObject != null) {
      localBundle.putString("expired_event_name", (String)localObject);
    }
    localObject = paramConditionalUserProperty.expiredEventParams;
    if (localObject != null) {
      localBundle.putBundle("expired_event_params", (Bundle)localObject);
    }
    localBundle.putLong("creation_timestamp", paramConditionalUserProperty.creationTimestamp);
    localBundle.putBoolean("active", paramConditionalUserProperty.active);
    localBundle.putLong("triggered_timestamp", paramConditionalUserProperty.triggeredTimestamp);
    return localBundle;
  }
  
  public static AnalyticsConnector.ConditionalUserProperty zzh(Bundle paramBundle)
  {
    Preconditions.checkNotNull(paramBundle);
    AnalyticsConnector.ConditionalUserProperty localConditionalUserProperty = new AnalyticsConnector.ConditionalUserProperty();
    localConditionalUserProperty.origin = ((String)Preconditions.checkNotNull((String)zzgq.zzb(paramBundle, "origin", String.class, null)));
    localConditionalUserProperty.name = ((String)Preconditions.checkNotNull((String)zzgq.zzb(paramBundle, "name", String.class, null)));
    localConditionalUserProperty.value = zzgq.zzb(paramBundle, "value", Object.class, null);
    localConditionalUserProperty.triggerEventName = ((String)zzgq.zzb(paramBundle, "trigger_event_name", String.class, null));
    Long localLong = Long.valueOf(0L);
    localConditionalUserProperty.triggerTimeout = ((Long)zzgq.zzb(paramBundle, "trigger_timeout", Long.class, localLong)).longValue();
    localConditionalUserProperty.timedOutEventName = ((String)zzgq.zzb(paramBundle, "timed_out_event_name", String.class, null));
    localConditionalUserProperty.timedOutEventParams = ((Bundle)zzgq.zzb(paramBundle, "timed_out_event_params", Bundle.class, null));
    localConditionalUserProperty.triggeredEventName = ((String)zzgq.zzb(paramBundle, "triggered_event_name", String.class, null));
    localConditionalUserProperty.triggeredEventParams = ((Bundle)zzgq.zzb(paramBundle, "triggered_event_params", Bundle.class, null));
    localConditionalUserProperty.timeToLive = ((Long)zzgq.zzb(paramBundle, "time_to_live", Long.class, localLong)).longValue();
    localConditionalUserProperty.expiredEventName = ((String)zzgq.zzb(paramBundle, "expired_event_name", String.class, null));
    localConditionalUserProperty.expiredEventParams = ((Bundle)zzgq.zzb(paramBundle, "expired_event_params", Bundle.class, null));
    localConditionalUserProperty.active = ((Boolean)zzgq.zzb(paramBundle, "active", Boolean.class, Boolean.FALSE)).booleanValue();
    localConditionalUserProperty.creationTimestamp = ((Long)zzgq.zzb(paramBundle, "creation_timestamp", Long.class, localLong)).longValue();
    localConditionalUserProperty.triggeredTimestamp = ((Long)zzgq.zzb(paramBundle, "triggered_timestamp", Long.class, localLong)).longValue();
    return localConditionalUserProperty;
  }
  
  public static boolean zzi(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    if (paramString.length() == 0) {
      return false;
    }
    int i = paramString.codePointAt(0);
    if (!Character.isLetter(i)) {
      return false;
    }
    int j = paramString.length();
    i = Character.charCount(i);
    while (i < j)
    {
      int k = paramString.codePointAt(i);
      if ((k != 95) && (!Character.isLetterOrDigit(k))) {
        return false;
      }
      i += Character.charCount(k);
    }
    return true;
  }
  
  public static boolean zzj(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    if (paramString.length() == 0) {
      return false;
    }
    int i = paramString.codePointAt(0);
    if ((!Character.isLetter(i)) && (i != 95)) {
      return false;
    }
    int j = paramString.length();
    i = Character.charCount(i);
    while (i < j)
    {
      int k = paramString.codePointAt(i);
      if ((k != 95) && (!Character.isLetterOrDigit(k))) {
        return false;
      }
      i += Character.charCount(k);
    }
    return true;
  }
  
  public static String zzk(String paramString)
  {
    String str = zzgr.zza(paramString);
    if (str != null) {
      return str;
    }
    return paramString;
  }
  
  public static String zzl(String paramString)
  {
    String str = zzgr.zzb(paramString);
    if (str != null) {
      return str;
    }
    return paramString;
  }
  
  public static void zzm(String paramString1, String paramString2, Bundle paramBundle)
  {
    if (("clx".equals(paramString1)) && ("_ae".equals(paramString2))) {
      paramBundle.putLong("_r", 1L);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\analytics\connector\internal\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */