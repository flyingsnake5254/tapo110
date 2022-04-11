package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Size;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzpe;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

public final class zzae
  extends zzgn
{
  private Boolean zza;
  private zzad zzb = zzac.zza;
  private Boolean zzc;
  
  zzae(zzfu paramzzfu)
  {
    super(paramzzfu);
  }
  
  public static final long zzA()
  {
    return ((Long)zzea.zzC.zzb(null)).longValue();
  }
  
  private final String zzB(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = (String)Class.forName("android.os.SystemProperties").getMethod("get", new Class[] { String.class, String.class }).invoke(null, new Object[] { paramString1, "" });
      Preconditions.checkNotNull(paramString1);
      return paramString1;
    }
    catch (InvocationTargetException paramString1)
    {
      this.zzs.zzau().zzb().zzb("SystemProperties.get() threw an exception", paramString1);
    }
    catch (IllegalAccessException paramString1)
    {
      this.zzs.zzau().zzb().zzb("Could not access SystemProperties.get()", paramString1);
    }
    catch (NoSuchMethodException paramString1)
    {
      this.zzs.zzau().zzb().zzb("Could not find SystemProperties.get() method", paramString1);
    }
    catch (ClassNotFoundException paramString1)
    {
      this.zzs.zzau().zzb().zzb("Could not find SystemProperties class", paramString1);
    }
    return "";
  }
  
  public static final long zzz()
  {
    return ((Long)zzea.zzc.zzb(null)).longValue();
  }
  
  final void zza(zzad paramzzad)
  {
    this.zzb = paramzzad;
  }
  
  final String zzb()
  {
    this.zzs.zzat();
    return "FA";
  }
  
  public final int zzc()
  {
    zzku localzzku = this.zzs.zzl();
    Boolean localBoolean = localzzku.zzs.zzy().zzC();
    if ((localzzku.zzZ() < 201500) && ((localBoolean == null) || (localBoolean.booleanValue()))) {
      return 25;
    }
    return 100;
  }
  
  public final int zzd(@Size(min=1L) String paramString)
  {
    return zzl(paramString, zzea.zzH, 25, 100);
  }
  
  final int zze(@Size(min=1L) String paramString)
  {
    return zzl(paramString, zzea.zzG, 500, 2000);
  }
  
  public final long zzf()
  {
    this.zzs.zzat();
    return 42004L;
  }
  
  @EnsuresNonNull({"this.isMainProcess"})
  public final boolean zzh()
  {
    if (this.zzc == null) {
      try
      {
        if (this.zzc == null)
        {
          Object localObject1 = this.zzs.zzax().getApplicationInfo();
          String str = ProcessUtils.getMyProcessName();
          if (localObject1 != null)
          {
            localObject1 = ((ApplicationInfo)localObject1).processName;
            boolean bool1 = false;
            boolean bool2 = bool1;
            if (localObject1 != null)
            {
              bool2 = bool1;
              if (((String)localObject1).equals(str)) {
                bool2 = true;
              }
            }
            this.zzc = Boolean.valueOf(bool2);
          }
          if (this.zzc == null)
          {
            this.zzc = Boolean.TRUE;
            this.zzs.zzau().zzb().zza("My process not in the list of running processes");
          }
        }
      }
      finally {}
    }
    return this.zzc.booleanValue();
  }
  
  @WorkerThread
  public final String zzi(String paramString, zzdz<String> paramzzdz)
  {
    if (paramString == null) {
      return (String)paramzzdz.zzb(null);
    }
    return (String)paramzzdz.zzb(this.zzb.zza(paramString, paramzzdz.zza()));
  }
  
  @WorkerThread
  public final long zzj(String paramString, zzdz<Long> paramzzdz)
  {
    if (paramString == null) {
      return ((Long)paramzzdz.zzb(null)).longValue();
    }
    paramString = this.zzb.zza(paramString, paramzzdz.zza());
    if (TextUtils.isEmpty(paramString)) {
      return ((Long)paramzzdz.zzb(null)).longValue();
    }
    try
    {
      long l = ((Long)paramzzdz.zzb(Long.valueOf(Long.parseLong(paramString)))).longValue();
      return l;
    }
    catch (NumberFormatException paramString) {}
    return ((Long)paramzzdz.zzb(null)).longValue();
  }
  
  @WorkerThread
  public final int zzk(String paramString, zzdz<Integer> paramzzdz)
  {
    if (paramString == null) {
      return ((Integer)paramzzdz.zzb(null)).intValue();
    }
    paramString = this.zzb.zza(paramString, paramzzdz.zza());
    if (TextUtils.isEmpty(paramString)) {
      return ((Integer)paramzzdz.zzb(null)).intValue();
    }
    try
    {
      int i = ((Integer)paramzzdz.zzb(Integer.valueOf(Integer.parseInt(paramString)))).intValue();
      return i;
    }
    catch (NumberFormatException paramString) {}
    return ((Integer)paramzzdz.zzb(null)).intValue();
  }
  
  @WorkerThread
  public final int zzl(String paramString, zzdz<Integer> paramzzdz, int paramInt1, int paramInt2)
  {
    return Math.max(Math.min(zzk(paramString, paramzzdz), paramInt2), paramInt1);
  }
  
  @WorkerThread
  public final double zzm(String paramString, zzdz<Double> paramzzdz)
  {
    if (paramString == null) {
      return ((Double)paramzzdz.zzb(null)).doubleValue();
    }
    paramString = this.zzb.zza(paramString, paramzzdz.zza());
    if (TextUtils.isEmpty(paramString)) {
      return ((Double)paramzzdz.zzb(null)).doubleValue();
    }
    try
    {
      double d = ((Double)paramzzdz.zzb(Double.valueOf(Double.parseDouble(paramString)))).doubleValue();
      return d;
    }
    catch (NumberFormatException paramString) {}
    return ((Double)paramzzdz.zzb(null)).doubleValue();
  }
  
  @WorkerThread
  public final boolean zzn(String paramString, zzdz<Boolean> paramzzdz)
  {
    if (paramString == null) {
      return ((Boolean)paramzzdz.zzb(null)).booleanValue();
    }
    paramString = this.zzb.zza(paramString, paramzzdz.zza());
    if (TextUtils.isEmpty(paramString)) {
      return ((Boolean)paramzzdz.zzb(null)).booleanValue();
    }
    return ((Boolean)paramzzdz.zzb(Boolean.valueOf(Boolean.parseBoolean(paramString)))).booleanValue();
  }
  
  @VisibleForTesting
  final Bundle zzo()
  {
    try
    {
      if (this.zzs.zzax().getPackageManager() == null)
      {
        this.zzs.zzau().zzb().zza("Failed to load metadata: PackageManager is null");
        return null;
      }
      Object localObject = Wrappers.packageManager(this.zzs.zzax()).getApplicationInfo(this.zzs.zzax().getPackageName(), 128);
      if (localObject == null)
      {
        this.zzs.zzau().zzb().zza("Failed to load metadata: ApplicationInfo is null");
        return null;
      }
      localObject = ((ApplicationInfo)localObject).metaData;
      return (Bundle)localObject;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      this.zzs.zzau().zzb().zzb("Failed to load metadata: Package name not found", localNameNotFoundException);
    }
    return null;
  }
  
  @VisibleForTesting
  final Boolean zzp(@Size(min=1L) String paramString)
  {
    Preconditions.checkNotEmpty(paramString);
    Bundle localBundle = zzo();
    if (localBundle == null)
    {
      this.zzs.zzau().zzb().zza("Failed to load metadata: Metadata bundle is null");
      return null;
    }
    if (!localBundle.containsKey(paramString)) {
      return null;
    }
    return Boolean.valueOf(localBundle.getBoolean(paramString));
  }
  
  @VisibleForTesting
  final List<String> zzq(@Size(min=1L) String paramString)
  {
    Preconditions.checkNotEmpty("analytics.safelisted_events");
    paramString = zzo();
    if (paramString == null) {
      this.zzs.zzau().zzb().zza("Failed to load metadata: Metadata bundle is null");
    }
    while (!paramString.containsKey("analytics.safelisted_events"))
    {
      paramString = null;
      break;
    }
    paramString = Integer.valueOf(paramString.getInt("analytics.safelisted_events"));
    if (paramString != null) {
      try
      {
        paramString = this.zzs.zzax().getResources().getStringArray(paramString.intValue());
        if (paramString == null) {
          return null;
        }
        paramString = Arrays.asList(paramString);
        return paramString;
      }
      catch (Resources.NotFoundException paramString)
      {
        this.zzs.zzau().zzb().zzb("Failed to load string array from metadata: resource not found", paramString);
      }
    }
    return null;
  }
  
  public final boolean zzr()
  {
    this.zzs.zzat();
    Boolean localBoolean = zzp("firebase_analytics_collection_deactivated");
    return (localBoolean != null) && (localBoolean.booleanValue());
  }
  
  public final boolean zzs()
  {
    Boolean localBoolean = zzp("google_analytics_adid_collection_enabled");
    return (localBoolean == null) || (localBoolean.booleanValue());
  }
  
  public final boolean zzt()
  {
    zzpe.zzb();
    if (!zzn(null, zzea.zzaq)) {
      return true;
    }
    Boolean localBoolean = zzp("google_analytics_automatic_screen_reporting_enabled");
    return (localBoolean == null) || (localBoolean.booleanValue());
  }
  
  public final String zzu()
  {
    return zzB("debug.firebase.analytics.app", "");
  }
  
  public final String zzv()
  {
    return zzB("debug.deferred.deeplink", "");
  }
  
  public final boolean zzw(String paramString)
  {
    return "1".equals(this.zzb.zza(paramString, "gaia_collection_enabled"));
  }
  
  public final boolean zzx(String paramString)
  {
    return "1".equals(this.zzb.zza(paramString, "measurement.event_sampling_enabled"));
  }
  
  @WorkerThread
  final boolean zzy()
  {
    if (this.zza == null)
    {
      Boolean localBoolean = zzp("app_measurement_lite");
      this.zza = localBoolean;
      if (localBoolean == null) {
        this.zza = Boolean.FALSE;
      }
    }
    return (this.zza.booleanValue()) || (!this.zzs.zzu());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */