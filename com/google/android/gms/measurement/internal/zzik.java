package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.GuardedBy;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Size;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class zzik
  extends zzf
{
  @VisibleForTesting
  protected zzid zza;
  private volatile zzid zzb;
  private zzid zzc;
  private final Map<Activity, zzid> zzd = new ConcurrentHashMap();
  @GuardedBy("activityLock")
  private Activity zze;
  @GuardedBy("activityLock")
  private volatile boolean zzf;
  private volatile zzid zzg;
  private zzid zzh;
  @GuardedBy("activityLock")
  private boolean zzi;
  private final Object zzj = new Object();
  @GuardedBy("this")
  private zzid zzk;
  @GuardedBy("this")
  private String zzl;
  
  public zzik(zzfu paramzzfu)
  {
    super(paramzzfu);
  }
  
  @MainThread
  private final void zzA(Activity paramActivity, zzid paramzzid, boolean paramBoolean)
  {
    zzid localzzid;
    if (this.zzb == null) {
      localzzid = this.zzc;
    } else {
      localzzid = this.zzb;
    }
    if (paramzzid.zzb == null)
    {
      if (paramActivity != null) {
        paramActivity = zzi(paramActivity.getClass(), "Activity");
      } else {
        paramActivity = null;
      }
      paramzzid = new zzid(paramzzid.zza, paramActivity, paramzzid.zzc, paramzzid.zze, paramzzid.zzf);
    }
    this.zzc = this.zzb;
    this.zzb = paramzzid;
    long l = this.zzs.zzay().elapsedRealtime();
    this.zzs.zzav().zzh(new zzif(this, paramzzid, localzzid, l, paramBoolean));
  }
  
  @WorkerThread
  private final void zzB(zzid paramzzid1, zzid paramzzid2, long paramLong, boolean paramBoolean, Bundle paramBundle)
  {
    zzg();
    int i = 0;
    int j = i;
    if (paramBoolean)
    {
      j = i;
      if (this.zza != null) {
        j = 1;
      }
    }
    if (j != 0) {
      zzC(this.zza, true, paramLong);
    }
    if ((paramzzid2 == null) || (paramzzid2.zzc != paramzzid1.zzc) || (!zzku.zzS(paramzzid2.zzb, paramzzid1.zzb)) || (!zzku.zzS(paramzzid2.zza, paramzzid1.zza)))
    {
      Bundle localBundle = new Bundle();
      zzae localzzae = this.zzs.zzc();
      Object localObject = zzea.zzar;
      if (localzzae.zzn(null, (zzdz)localObject)) {
        if (paramBundle != null) {
          localBundle = new Bundle(paramBundle);
        } else {
          localBundle = new Bundle();
        }
      }
      zzm(paramzzid1, localBundle, true);
      if (paramzzid2 != null)
      {
        paramBundle = paramzzid2.zza;
        if (paramBundle != null) {
          localBundle.putString("_pn", paramBundle);
        }
        paramBundle = paramzzid2.zzb;
        if (paramBundle != null) {
          localBundle.putString("_pc", paramBundle);
        }
        localBundle.putLong("_pi", paramzzid2.zzc);
      }
      long l;
      if (j != 0)
      {
        paramzzid2 = this.zzs.zzh().zzb;
        l = paramLong - paramzzid2.zzb;
        paramzzid2.zzb = paramLong;
        if (l > 0L) {
          this.zzs.zzl().zzac(localBundle, l);
        }
      }
      paramBoolean = this.zzs.zzc().zzn(null, (zzdz)localObject);
      paramBundle = "auto";
      paramzzid2 = paramBundle;
      if (paramBoolean)
      {
        if (!this.zzs.zzc().zzt()) {
          localBundle.putLong("_mst", 1L);
        }
        if (true != paramzzid1.zze) {
          paramzzid2 = paramBundle;
        } else {
          paramzzid2 = "app";
        }
      }
      if (this.zzs.zzc().zzn(null, (zzdz)localObject))
      {
        l = this.zzs.zzay().currentTimeMillis();
        if (paramzzid1.zze)
        {
          paramLong = paramzzid1.zzf;
          if (paramLong != 0L) {}
        }
        else
        {
          paramLong = l;
        }
        this.zzs.zzk().zzt(paramzzid2, "_vs", paramLong, localBundle);
      }
      else
      {
        paramBundle = this.zzs.zzk();
        localObject = paramBundle.zzs;
        paramBundle.zzg();
        paramBundle.zzt(paramzzid2, "_vs", paramBundle.zzs.zzay().currentTimeMillis(), localBundle);
      }
    }
    this.zza = paramzzid1;
    if ((this.zzs.zzc().zzn(null, zzea.zzar)) && (paramzzid1.zze)) {
      this.zzh = paramzzid1;
    }
    this.zzs.zzy().zzz(paramzzid1);
  }
  
  @WorkerThread
  private final void zzC(zzid paramzzid, boolean paramBoolean, long paramLong)
  {
    this.zzs.zzB().zzc(this.zzs.zzay().elapsedRealtime());
    boolean bool;
    if ((paramzzid != null) && (paramzzid.zzd)) {
      bool = true;
    } else {
      bool = false;
    }
    if ((this.zzs.zzh().zzb.zzd(bool, paramBoolean, paramLong)) && (paramzzid != null)) {
      paramzzid.zzd = false;
    }
  }
  
  @MainThread
  private final zzid zzD(@NonNull Activity paramActivity)
  {
    Preconditions.checkNotNull(paramActivity);
    zzid localzzid1 = (zzid)this.zzd.get(paramActivity);
    zzid localzzid2 = localzzid1;
    if (localzzid1 == null)
    {
      localzzid2 = new zzid(null, zzi(paramActivity.getClass(), "Activity"), this.zzs.zzl().zzd());
      this.zzd.put(paramActivity, localzzid2);
    }
    if (!this.zzs.zzc().zzn(null, zzea.zzar)) {
      return localzzid2;
    }
    if (this.zzg != null) {
      return this.zzg;
    }
    return localzzid2;
  }
  
  public static void zzm(zzid paramzzid, Bundle paramBundle, boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (paramzzid != null) {
      if ((paramBundle.containsKey("_sc")) && (!paramBoolean))
      {
        bool = false;
      }
      else
      {
        String str = paramzzid.zza;
        if (str != null) {
          paramBundle.putString("_sn", str);
        } else {
          paramBundle.remove("_sn");
        }
        str = paramzzid.zzb;
        if (str != null) {
          paramBundle.putString("_sc", str);
        } else {
          paramBundle.remove("_sc");
        }
        paramBundle.putLong("_si", paramzzid.zzc);
        return;
      }
    }
    if ((paramzzid == null) && (bool))
    {
      paramBundle.remove("_sn");
      paramBundle.remove("_sc");
      paramBundle.remove("_si");
    }
  }
  
  protected final boolean zze()
  {
    return false;
  }
  
  @WorkerThread
  public final zzid zzh(boolean paramBoolean)
  {
    zzb();
    zzg();
    if ((this.zzs.zzc().zzn(null, zzea.zzar)) && (paramBoolean))
    {
      zzid localzzid = this.zza;
      if (localzzid != null) {
        return localzzid;
      }
      return this.zzh;
    }
    return this.zza;
  }
  
  @VisibleForTesting
  final String zzi(Class<?> paramClass, String paramString)
  {
    paramClass = paramClass.getCanonicalName();
    if (paramClass == null) {
      return "Activity";
    }
    paramClass = paramClass.split("\\.");
    int i = paramClass.length;
    if (i > 0) {
      paramClass = paramClass[(i - 1)];
    } else {
      paramClass = "";
    }
    i = paramClass.length();
    this.zzs.zzc();
    paramString = paramClass;
    if (i > 100)
    {
      this.zzs.zzc();
      paramString = paramClass.substring(0, 100);
    }
    return paramString;
  }
  
  public final void zzj(Bundle paramBundle, long paramLong)
  {
    if (!this.zzs.zzc().zzn(null, zzea.zzar))
    {
      this.zzs.zzau().zzh().zza("Manual screen reporting is disabled.");
      return;
    }
    synchronized (this.zzj)
    {
      if (!this.zzi)
      {
        this.zzs.zzau().zzh().zza("Cannot log screen view event when the app is in the background.");
        return;
      }
      String str = paramBundle.getString("screen_name");
      int i;
      if (str != null) {
        if (str.length() > 0)
        {
          i = str.length();
          this.zzs.zzc();
          if (i <= 100) {}
        }
        else
        {
          this.zzs.zzau().zzh().zzb("Invalid screen name length for screen view. Length", Integer.valueOf(str.length()));
          return;
        }
      }
      Object localObject2 = paramBundle.getString("screen_class");
      if (localObject2 != null) {
        if (((String)localObject2).length() > 0)
        {
          i = ((String)localObject2).length();
          this.zzs.zzc();
          if (i <= 100) {}
        }
        else
        {
          this.zzs.zzau().zzh().zzb("Invalid screen class length for screen view. Length", Integer.valueOf(((String)localObject2).length()));
          return;
        }
      }
      if (localObject2 == null)
      {
        localObject2 = this.zze;
        if (localObject2 != null) {
          localObject2 = zzi(localObject2.getClass(), "Activity");
        } else {
          localObject2 = "Activity";
        }
      }
      Object localObject3 = this.zzb;
      if ((this.zzf) && (localObject3 != null))
      {
        this.zzf = false;
        boolean bool1 = zzku.zzS(((zzid)localObject3).zzb, (String)localObject2);
        boolean bool2 = zzku.zzS(((zzid)localObject3).zza, str);
        if ((bool1) && (bool2))
        {
          this.zzs.zzau().zzh().zza("Ignoring call to log screen view event with duplicate parameters.");
          return;
        }
      }
      zzek localzzek = this.zzs.zzau().zzk();
      if (str == null) {
        ??? = "null";
      } else {
        ??? = str;
      }
      if (localObject2 == null) {
        localObject3 = "null";
      } else {
        localObject3 = localObject2;
      }
      localzzek.zzc("Logging screen view with name, class", ???, localObject3);
      if (this.zzb == null) {
        ??? = this.zzc;
      } else {
        ??? = this.zzb;
      }
      localObject2 = new zzid(str, (String)localObject2, this.zzs.zzl().zzd(), true, paramLong);
      this.zzb = ((zzid)localObject2);
      this.zzc = ((zzid)???);
      this.zzg = ((zzid)localObject2);
      paramLong = this.zzs.zzay().elapsedRealtime();
      this.zzs.zzav().zzh(new zzie(this, paramBundle, (zzid)localObject2, (zzid)???, paramLong));
      return;
    }
  }
  
  @Deprecated
  @MainThread
  public final void zzk(@NonNull Activity paramActivity, @Size(max=36L, min=1L) String paramString1, @Size(max=36L, min=1L) String paramString2)
  {
    if (!this.zzs.zzc().zzt())
    {
      this.zzs.zzau().zzh().zza("setCurrentScreen cannot be called while screen reporting is disabled.");
      return;
    }
    Object localObject = this.zzb;
    if (localObject == null)
    {
      this.zzs.zzau().zzh().zza("setCurrentScreen cannot be called while no activity active");
      return;
    }
    if (this.zzd.get(paramActivity) == null)
    {
      this.zzs.zzau().zzh().zza("setCurrentScreen must be called with an activity in the activity lifecycle");
      return;
    }
    String str = paramString2;
    if (paramString2 == null) {
      str = zzi(paramActivity.getClass(), "Activity");
    }
    boolean bool1 = zzku.zzS(((zzid)localObject).zzb, str);
    boolean bool2 = zzku.zzS(((zzid)localObject).zza, paramString1);
    if ((bool1) && (bool2))
    {
      this.zzs.zzau().zzh().zza("setCurrentScreen cannot be called with the same class and name");
      return;
    }
    int i;
    if (paramString1 != null) {
      if (paramString1.length() > 0)
      {
        i = paramString1.length();
        this.zzs.zzc();
        if (i <= 100) {}
      }
      else
      {
        this.zzs.zzau().zzh().zzb("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(paramString1.length()));
        return;
      }
    }
    if (str != null) {
      if (str.length() > 0)
      {
        i = str.length();
        this.zzs.zzc();
        if (i <= 100) {}
      }
      else
      {
        this.zzs.zzau().zzh().zzb("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
        return;
      }
    }
    localObject = this.zzs.zzau().zzk();
    if (paramString1 == null) {
      paramString2 = "null";
    } else {
      paramString2 = paramString1;
    }
    ((zzek)localObject).zzc("Setting current screen to name, class", paramString2, str);
    paramString1 = new zzid(paramString1, str, this.zzs.zzl().zzd());
    this.zzd.put(paramActivity, paramString1);
    zzA(paramActivity, paramString1, true);
  }
  
  public final zzid zzl()
  {
    return this.zzb;
  }
  
  @WorkerThread
  public final void zzn(String paramString, zzid paramzzid)
  {
    zzg();
    try
    {
      String str = this.zzl;
      if ((str == null) || (str.equals(paramString)) || (paramzzid != null))
      {
        this.zzl = paramString;
        this.zzk = paramzzid;
      }
      return;
    }
    finally {}
  }
  
  @MainThread
  public final void zzo(Activity paramActivity, Bundle paramBundle)
  {
    if (!this.zzs.zzc().zzt()) {
      return;
    }
    if (paramBundle == null) {
      return;
    }
    paramBundle = paramBundle.getBundle("com.google.app_measurement.screen_service");
    if (paramBundle == null) {
      return;
    }
    paramBundle = new zzid(paramBundle.getString("name"), paramBundle.getString("referrer_name"), paramBundle.getLong("id"));
    this.zzd.put(paramActivity, paramBundle);
  }
  
  @MainThread
  public final void zzq(Activity paramActivity)
  {
    if (this.zzs.zzc().zzn(null, zzea.zzar)) {
      synchronized (this.zzj)
      {
        this.zzi = true;
        if (paramActivity != this.zze) {
          synchronized (this.zzj)
          {
            this.zze = paramActivity;
            this.zzf = false;
            if ((this.zzs.zzc().zzn(null, zzea.zzaq)) && (this.zzs.zzc().zzt()))
            {
              this.zzg = null;
              zzfr localzzfr = this.zzs.zzav();
              ??? = new com/google/android/gms/measurement/internal/zzij;
              ((zzij)???).<init>(this);
              localzzfr.zzh((Runnable)???);
            }
          }
        }
      }
    }
    if ((this.zzs.zzc().zzn(null, zzea.zzaq)) && (!this.zzs.zzc().zzt()))
    {
      this.zzb = this.zzg;
      this.zzs.zzav().zzh(new zzig(this));
      return;
    }
    zzA(paramActivity, zzD(paramActivity), false);
    paramActivity = this.zzs.zzB();
    long l = paramActivity.zzs.zzay().elapsedRealtime();
    paramActivity.zzs.zzav().zzh(new zzc(paramActivity, l));
  }
  
  @MainThread
  public final void zzr(Activity paramActivity)
  {
    if (this.zzs.zzc().zzn(null, zzea.zzar)) {
      synchronized (this.zzj)
      {
        this.zzi = false;
        this.zzf = true;
      }
    }
    long l = this.zzs.zzay().elapsedRealtime();
    if ((this.zzs.zzc().zzn(null, zzea.zzaq)) && (!this.zzs.zzc().zzt()))
    {
      this.zzb = null;
      this.zzs.zzav().zzh(new zzih(this, l));
      return;
    }
    paramActivity = zzD(paramActivity);
    this.zzc = this.zzb;
    this.zzb = null;
    this.zzs.zzav().zzh(new zzii(this, paramActivity, l));
  }
  
  @MainThread
  public final void zzs(Activity paramActivity, Bundle paramBundle)
  {
    if (!this.zzs.zzc().zzt()) {
      return;
    }
    if (paramBundle == null) {
      return;
    }
    paramActivity = (zzid)this.zzd.get(paramActivity);
    if (paramActivity == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putLong("id", paramActivity.zzc);
    localBundle.putString("name", paramActivity.zza);
    localBundle.putString("referrer_name", paramActivity.zzb);
    paramBundle.putBundle("com.google.app_measurement.screen_service", localBundle);
  }
  
  @MainThread
  public final void zzt(Activity paramActivity)
  {
    synchronized (this.zzj)
    {
      if (paramActivity == this.zze) {
        this.zze = null;
      }
      if (!this.zzs.zzc().zzt()) {
        return;
      }
      this.zzd.remove(paramActivity);
      return;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzik.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */