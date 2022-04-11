package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.InstantApps;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzov;
import com.google.android.gms.internal.measurement.zzqi;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

public final class zzee
  extends zzf
{
  private String zza;
  private String zzb;
  private int zzc;
  private String zzd;
  private String zze;
  private long zzf;
  private final long zzg;
  private List<String> zzh;
  private int zzi;
  private String zzj;
  private String zzk;
  private String zzl;
  
  zzee(zzfu paramzzfu, long paramLong)
  {
    super(paramzzfu);
    this.zzg = paramLong;
  }
  
  protected final boolean zze()
  {
    return true;
  }
  
  @EnsuresNonNull({"appId", "appStore", "appName", "gmpAppId", "gaAppId"})
  protected final void zzf()
  {
    String str1 = this.zzs.zzax().getPackageName();
    PackageManager localPackageManager = this.zzs.zzax().getPackageManager();
    Object localObject1 = "Unknown";
    int i = Integer.MIN_VALUE;
    String str2 = "";
    Object localObject2 = "unknown";
    if (localPackageManager == null) {
      this.zzs.zzau().zzb().zzb("PackageManager is null, app identity information might be inaccurate. appId", zzem.zzl(str1));
    }
    Object localObject6;
    Object localObject7;
    for (;;)
    {
      String str3 = "Unknown";
      j = i;
      Object localObject5 = localObject2;
      localObject2 = str3;
      break label283;
      try
      {
        localObject5 = localPackageManager.getInstallerPackageName(str1);
        localObject2 = localObject5;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        this.zzs.zzau().zzb().zzb("Error retrieving app installer package name. appId", zzem.zzl(str1));
      }
      if (localObject2 == null)
      {
        localObject6 = "manual_install";
      }
      else
      {
        localObject6 = localObject2;
        if ("com.android.vending".equals(localObject2)) {
          localObject6 = "";
        }
      }
      try
      {
        localObject7 = localPackageManager.getPackageInfo(this.zzs.zzax().getPackageName(), 0);
        localObject2 = localObject6;
        if (localObject7 != null)
        {
          localObject2 = localPackageManager.getApplicationLabel(((PackageInfo)localObject7).applicationInfo);
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject2 = ((CharSequence)localObject2).toString();
          } else {
            localObject2 = "Unknown";
          }
          try
          {
            str3 = ((PackageInfo)localObject7).versionName;
            localObject1 = str3;
            j = ((PackageInfo)localObject7).versionCode;
            localObject1 = str3;
          }
          catch (PackageManager.NameNotFoundException localNameNotFoundException2)
          {
            localObject4 = localObject1;
            localObject1 = localObject2;
            localObject2 = localObject4;
          }
          this.zzs.zzau().zzb().zzc("Error retrieving package info. appId, appName", zzem.zzl(str1), localObject1);
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException1)
      {
        localObject3 = "Unknown";
      }
    }
    Object localObject4 = localObject1;
    localObject1 = localObject3;
    Object localObject3 = localObject4;
    int j = i;
    label283:
    this.zza = str1;
    this.zzd = ((String)localObject6);
    this.zzb = ((String)localObject1);
    this.zzc = j;
    this.zze = ((String)localObject3);
    this.zzf = 0L;
    if ((!TextUtils.isEmpty(this.zzs.zzr())) && ("am".equals(this.zzs.zzs()))) {
      j = 1;
    } else {
      j = 0;
    }
    i = this.zzs.zzG();
    switch (i)
    {
    default: 
      this.zzs.zzau().zzi().zza("App measurement disabled due to denied storage consent");
      break;
    case 7: 
      this.zzs.zzau().zzi().zza("App measurement disabled via the global data collection setting");
      break;
    case 6: 
      this.zzs.zzau().zzh().zza("App measurement deactivated via resources. This method is being deprecated. Please refer to https://firebase.google.com/support/guides/disable-analytics");
      break;
    case 5: 
      this.zzs.zzau().zzk().zza("App measurement disabled via the init parameters");
      break;
    case 4: 
      this.zzs.zzau().zzi().zza("App measurement disabled via the manifest");
      break;
    case 3: 
      this.zzs.zzau().zzi().zza("App measurement disabled by setAnalyticsCollectionEnabled(false)");
      break;
    case 2: 
      this.zzs.zzau().zzk().zza("App measurement deactivated via the init parameters");
      break;
    case 1: 
      this.zzs.zzau().zzi().zza("App measurement deactivated via the manifest");
      break;
    case 0: 
      this.zzs.zzau().zzk().zza("App measurement collection enabled");
    }
    this.zzj = "";
    this.zzk = "";
    this.zzl = "";
    this.zzs.zzat();
    if (j != 0) {
      this.zzk = this.zzs.zzr();
    }
    try
    {
      localObject1 = zzic.zza(this.zzs.zzax(), "google_app_id", this.zzs.zzv());
      if (true != TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject6 = localObject1;
      } else {
        localObject6 = "";
      }
      this.zzj = ((String)localObject6);
      zzov.zzb();
      boolean bool = this.zzs.zzc().zzn(null, zzea.zzag);
      if (bool)
      {
        localObject3 = this.zzs.zzax();
        localObject6 = this.zzs.zzv();
        Preconditions.checkNotNull(localObject3);
        localObject7 = ((Context)localObject3).getResources();
        if (TextUtils.isEmpty((CharSequence)localObject6)) {
          localObject6 = zzfm.zza((Context)localObject3);
        }
        localObject4 = zzfm.zzb("ga_app_id", (Resources)localObject7, (String)localObject6);
        localObject3 = str2;
        if (true != TextUtils.isEmpty((CharSequence)localObject4)) {
          localObject3 = localObject4;
        }
        this.zzl = ((String)localObject3);
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) || (!TextUtils.isEmpty((CharSequence)localObject4))) {
          this.zzk = zzfm.zzb("admob_app_id", (Resources)localObject7, (String)localObject6);
        }
      }
      else if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = this.zzs.zzax();
        localObject6 = this.zzs.zzv();
        Preconditions.checkNotNull(localObject1);
        localObject3 = ((Context)localObject1).getResources();
        if (TextUtils.isEmpty((CharSequence)localObject6)) {
          localObject6 = zzfm.zza((Context)localObject1);
        }
        this.zzk = zzfm.zzb("admob_app_id", (Resources)localObject3, (String)localObject6);
      }
      if (i == 0)
      {
        localObject1 = this.zzs.zzau().zzk();
        localObject3 = this.zza;
        if (TextUtils.isEmpty(this.zzj)) {
          localObject6 = this.zzk;
        } else {
          localObject6 = this.zzj;
        }
        ((zzek)localObject1).zzc("App measurement enabled for app package, google app id", localObject3, localObject6);
      }
    }
    catch (IllegalStateException localIllegalStateException)
    {
      this.zzs.zzau().zzb().zzc("Fetching Google App Id failed with exception. appId", zzem.zzl(str1), localIllegalStateException);
    }
    this.zzh = null;
    this.zzs.zzat();
    localObject1 = this.zzs.zzc().zzq("analytics.safelisted_events");
    if (localObject1 != null)
    {
      if (((List)localObject1).size() == 0)
      {
        this.zzs.zzau().zzh().zza("Safelisted event list is empty. Ignoring");
      }
      else
      {
        localObject3 = ((List)localObject1).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          String str4 = (String)((Iterator)localObject3).next();
          if (!this.zzs.zzl().zzk("safelisted event", str4)) {
            break label1066;
          }
        }
      }
    }
    else {
      this.zzh = ((List)localObject1);
    }
    label1066:
    if (localPackageManager != null)
    {
      this.zzi = InstantApps.isInstantApp(this.zzs.zzax());
      return;
    }
    this.zzi = 0;
  }
  
  @WorkerThread
  final zzp zzh(String paramString)
  {
    zzg();
    String str1 = zzi();
    String str2 = zzj();
    zzb();
    String str3 = this.zzb;
    zzb();
    long l1 = this.zzc;
    zzb();
    Preconditions.checkNotNull(this.zzd);
    String str4 = this.zzd;
    this.zzs.zzc().zzf();
    zzb();
    zzg();
    long l2 = this.zzf;
    long l3 = l2;
    Object localObject1;
    Object localObject4;
    if (l2 == 0L)
    {
      localObject1 = this.zzs.zzl();
      localObject2 = this.zzs.zzax();
      localObject3 = this.zzs.zzax().getPackageName();
      ((zzgn)localObject1).zzg();
      Preconditions.checkNotNull(localObject2);
      Preconditions.checkNotEmpty((String)localObject3);
      localObject4 = ((Context)localObject2).getPackageManager();
      MessageDigest localMessageDigest = zzku.zzN();
      l3 = -1L;
      if (localMessageDigest == null) {
        ((zzgn)localObject1).zzs.zzau().zzb().zza("Could not get MD5 instance");
      }
      for (;;)
      {
        break label302;
        if (localObject4 != null) {
          try
          {
            if (!((zzku)localObject1).zzW((Context)localObject2, (String)localObject3))
            {
              localObject4 = Wrappers.packageManager((Context)localObject2).getPackageInfo(((zzgn)localObject1).zzs.zzax().getPackageName(), 64).signatures;
              if ((localObject4 != null) && (localObject4.length > 0)) {
                l3 = zzku.zzO(localMessageDigest.digest(localObject4[0].toByteArray()));
              } else {
                ((zzgn)localObject1).zzs.zzau().zze().zza("Could not get signatures");
              }
            }
            else
            {
              l3 = 0L;
            }
          }
          catch (PackageManager.NameNotFoundException localNameNotFoundException)
          {
            ((zzgn)localObject1).zzs.zzau().zzb().zzb("Package name not found", localNameNotFoundException);
          }
        }
      }
      l3 = 0L;
      label302:
      this.zzf = l3;
    }
    boolean bool1 = this.zzs.zzF();
    boolean bool2 = this.zzs.zzd().zzk;
    zzg();
    if (!this.zzs.zzF()) {}
    for (;;)
    {
      localObject1 = null;
      break label531;
      zzqi.zzb();
      if (this.zzs.zzc().zzn(null, zzea.zzai)) {
        this.zzs.zzau().zzk().zza("Disabled IID for tests.");
      }
      try
      {
        localObject5 = this.zzs.zzax().getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
        if (localObject5 != null) {
          try
          {
            localObject1 = ((Class)localObject5).getDeclaredMethod("getInstance", new Class[] { Context.class }).invoke(null, new Object[] { this.zzs.zzax() });
            if (localObject1 != null) {
              try
              {
                localObject1 = (String)((Class)localObject5).getDeclaredMethod("getFirebaseInstanceId", new Class[0]).invoke(localObject1, new Object[0]);
              }
              catch (Exception localException1)
              {
                this.zzs.zzau().zzh().zza("Failed to retrieve Firebase Instance Id");
              }
            }
            str5 = null;
          }
          catch (Exception localException2)
          {
            this.zzs.zzau().zzf().zza("Failed to obtain Firebase Analytics instance");
          }
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        Object localObject5;
        String str5;
        label531:
        int i;
        boolean bool3;
        boolean bool4;
        long l4;
        for (;;) {}
      }
    }
    localObject5 = this.zzs;
    l2 = ((zzfu)localObject5).zzd().zzc.zza();
    if (l2 == 0L) {
      l2 = ((zzfu)localObject5).zzc;
    } else {
      l2 = Math.min(((zzfu)localObject5).zzc, l2);
    }
    zzb();
    i = this.zzi;
    bool3 = this.zzs.zzc().zzs();
    localObject5 = this.zzs.zzd();
    ((zzgn)localObject5).zzg();
    bool4 = ((zzfb)localObject5).zzd().getBoolean("deferred_analytics_collection", false);
    zzb();
    Object localObject2 = this.zzk;
    localObject5 = this.zzs.zzc().zzp("google_analytics_default_allow_ad_personalization_signals");
    if (localObject5 == null) {
      localObject5 = null;
    } else {
      localObject5 = Boolean.valueOf(((Boolean)localObject5).booleanValue() ^ true);
    }
    l4 = this.zzg;
    Object localObject3 = this.zzh;
    zzov.zzb();
    if (this.zzs.zzc().zzn(null, zzea.zzag)) {
      localObject4 = zzl();
    } else {
      localObject4 = null;
    }
    return new zzp(str1, str2, str3, l1, str4, 42004L, l3, paramString, bool1, bool2 ^ true, str5, 0L, l2, i, bool3, bool4, (String)localObject2, (Boolean)localObject5, l4, (List)localObject3, (String)localObject4, this.zzs.zzd().zzi().zzd());
  }
  
  final String zzi()
  {
    zzb();
    Preconditions.checkNotNull(this.zza);
    return this.zza;
  }
  
  final String zzj()
  {
    zzb();
    Preconditions.checkNotNull(this.zzj);
    return this.zzj;
  }
  
  final String zzk()
  {
    zzb();
    return this.zzk;
  }
  
  final String zzl()
  {
    zzb();
    Preconditions.checkNotNull(this.zzl);
    return this.zzl;
  }
  
  final int zzm()
  {
    zzb();
    return this.zzc;
  }
  
  final int zzn()
  {
    zzb();
    return this.zzi;
  }
  
  final List<String> zzo()
  {
    return this.zzh;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzee.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */