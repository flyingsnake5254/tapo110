package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzcl;
import com.google.android.gms.internal.measurement.zzht;
import com.google.android.gms.internal.measurement.zzoa;
import com.google.android.gms.internal.measurement.zzod;
import java.net.URL;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.checkerframework.dataflow.qual.Pure;
import org.checkerframework.dataflow.qual.SideEffectFree;

public final class zzfu
  implements zzgp
{
  private static volatile zzfu zzd;
  private zzee zzA;
  private zzfe zzB;
  private boolean zzC;
  private Boolean zzD;
  private long zzE;
  private volatile Boolean zzF;
  private volatile boolean zzG;
  private int zzH;
  private final AtomicInteger zzI;
  @VisibleForTesting
  protected Boolean zza;
  @VisibleForTesting
  protected Boolean zzb;
  @VisibleForTesting
  final long zzc;
  private final Context zze;
  private final String zzf;
  private final String zzg;
  private final String zzh;
  private final boolean zzi;
  private final zzz zzj;
  private final zzae zzk;
  private final zzfb zzl;
  private final zzem zzm;
  private final zzfr zzn;
  private final zzjz zzo;
  private final zzku zzp;
  private final zzeh zzq;
  private final Clock zzr;
  private final zzik zzs;
  private final zzhw zzt;
  private final zzd zzu;
  private final zzia zzv;
  private final String zzw;
  private zzeg zzx;
  private zzjk zzy;
  private zzam zzz;
  
  zzfu(zzgw paramzzgw)
  {
    int i = 0;
    this.zzC = false;
    this.zzI = new AtomicInteger(0);
    Preconditions.checkNotNull(paramzzgw);
    Object localObject1 = new zzz(paramzzgw.zza);
    this.zzj = ((zzz)localObject1);
    zzdy.zza = (zzz)localObject1;
    localObject1 = paramzzgw.zza;
    this.zze = ((Context)localObject1);
    this.zzf = paramzzgw.zzb;
    this.zzg = paramzzgw.zzc;
    this.zzh = paramzzgw.zzd;
    this.zzi = paramzzgw.zzh;
    this.zzF = paramzzgw.zze;
    this.zzw = paramzzgw.zzj;
    this.zzG = true;
    Object localObject2 = paramzzgw.zzg;
    if (localObject2 != null)
    {
      localObject3 = ((zzcl)localObject2).zzg;
      if (localObject3 != null)
      {
        localObject3 = ((Bundle)localObject3).get("measurementEnabled");
        if ((localObject3 instanceof Boolean)) {
          this.zza = ((Boolean)localObject3);
        }
        localObject2 = ((zzcl)localObject2).zzg.get("measurementDeactivated");
        if ((localObject2 instanceof Boolean)) {
          this.zzb = ((Boolean)localObject2);
        }
      }
    }
    zzht.zzb((Context)localObject1);
    Object localObject3 = DefaultClock.getInstance();
    this.zzr = ((Clock)localObject3);
    localObject2 = paramzzgw.zzi;
    long l;
    if (localObject2 != null) {
      l = ((Long)localObject2).longValue();
    } else {
      l = ((Clock)localObject3).currentTimeMillis();
    }
    this.zzc = l;
    this.zzk = new zzae(this);
    localObject2 = new zzfb(this);
    ((zzgo)localObject2).zzx();
    this.zzl = ((zzfb)localObject2);
    localObject2 = new zzem(this);
    ((zzgo)localObject2).zzx();
    this.zzm = ((zzem)localObject2);
    localObject2 = new zzku(this);
    ((zzgo)localObject2).zzx();
    this.zzp = ((zzku)localObject2);
    localObject2 = new zzeh(this);
    ((zzgo)localObject2).zzx();
    this.zzq = ((zzeh)localObject2);
    this.zzu = new zzd(this);
    localObject2 = new zzik(this);
    ((zzf)localObject2).zzc();
    this.zzs = ((zzik)localObject2);
    localObject2 = new zzhw(this);
    ((zzf)localObject2).zzc();
    this.zzt = ((zzhw)localObject2);
    localObject2 = new zzjz(this);
    ((zzf)localObject2).zzc();
    this.zzo = ((zzjz)localObject2);
    localObject2 = new zzia(this);
    ((zzgo)localObject2).zzx();
    this.zzv = ((zzia)localObject2);
    localObject2 = new zzfr(this);
    ((zzgo)localObject2).zzx();
    this.zzn = ((zzfr)localObject2);
    localObject3 = paramzzgw.zzg;
    if ((localObject3 == null) || (((zzcl)localObject3).zzb == 0L)) {
      i = 1;
    }
    if ((((Context)localObject1).getApplicationContext() instanceof Application))
    {
      localObject3 = zzk();
      if ((((zzgn)localObject3).zzs.zze.getApplicationContext() instanceof Application))
      {
        localObject1 = (Application)((zzgn)localObject3).zzs.zze.getApplicationContext();
        if (((zzhw)localObject3).zza == null) {
          ((zzhw)localObject3).zza = new zzhv((zzhw)localObject3, null);
        }
        if (i != 0)
        {
          ((Application)localObject1).unregisterActivityLifecycleCallbacks(((zzhw)localObject3).zza);
          ((Application)localObject1).registerActivityLifecycleCallbacks(((zzhw)localObject3).zza);
          ((zzgn)localObject3).zzs.zzau().zzk().zza("Registered activity lifecycle callback");
        }
      }
    }
    else
    {
      zzau().zze().zza("Application context is not an Application");
    }
    ((zzfr)localObject2).zzh(new zzft(this, paramzzgw));
  }
  
  public static zzfu zzC(Context paramContext, zzcl paramzzcl, Long paramLong)
  {
    zzcl localzzcl = paramzzcl;
    if (paramzzcl != null) {
      if (paramzzcl.zze != null)
      {
        localzzcl = paramzzcl;
        if (paramzzcl.zzf != null) {}
      }
      else
      {
        localzzcl = new zzcl(paramzzcl.zza, paramzzcl.zzb, paramzzcl.zzc, paramzzcl.zzd, null, null, paramzzcl.zzg, null);
      }
    }
    Preconditions.checkNotNull(paramContext);
    Preconditions.checkNotNull(paramContext.getApplicationContext());
    if (zzd == null)
    {
      try
      {
        if (zzd == null)
        {
          paramzzcl = new com/google/android/gms/measurement/internal/zzgw;
          paramzzcl.<init>(paramContext, localzzcl, paramLong);
          paramContext = new com/google/android/gms/measurement/internal/zzfu;
          paramContext.<init>(paramzzcl);
          zzd = paramContext;
        }
      }
      finally {}
    }
    else if (localzzcl != null)
    {
      paramContext = localzzcl.zzg;
      if ((paramContext != null) && (paramContext.containsKey("dataCollectionDefaultEnabled")))
      {
        Preconditions.checkNotNull(zzd);
        zzd.zzF = Boolean.valueOf(localzzcl.zzg.getBoolean("dataCollectionDefaultEnabled"));
      }
    }
    Preconditions.checkNotNull(zzd);
    return zzd;
  }
  
  static final void zzP()
  {
    throw new IllegalStateException("Unexpected call on client side");
  }
  
  private static final void zzQ(zzgn paramzzgn)
  {
    if (paramzzgn != null) {
      return;
    }
    throw new IllegalStateException("Component not created");
  }
  
  private static final void zzR(zzf paramzzf)
  {
    if (paramzzf != null)
    {
      if (paramzzf.zza()) {
        return;
      }
      String str = String.valueOf(paramzzf.getClass());
      paramzzf = new StringBuilder(str.length() + 27);
      paramzzf.append("Component not initialized: ");
      paramzzf.append(str);
      throw new IllegalStateException(paramzzf.toString());
    }
    throw new IllegalStateException("Component not created");
  }
  
  private static final void zzS(zzgo paramzzgo)
  {
    if (paramzzgo != null)
    {
      if (paramzzgo.zzu()) {
        return;
      }
      String str = String.valueOf(paramzzgo.getClass());
      paramzzgo = new StringBuilder(str.length() + 27);
      paramzzgo.append("Component not initialized: ");
      paramzzgo.append(str);
      throw new IllegalStateException(paramzzgo.toString());
    }
    throw new IllegalStateException("Component not created");
  }
  
  @Pure
  public final zzee zzA()
  {
    zzR(this.zzA);
    return this.zzA;
  }
  
  @Pure
  public final zzd zzB()
  {
    zzd localzzd = this.zzu;
    if (localzzd != null) {
      return localzzd;
    }
    throw new IllegalStateException("Component not created");
  }
  
  @WorkerThread
  final void zzD(boolean paramBoolean)
  {
    this.zzF = Boolean.valueOf(paramBoolean);
  }
  
  @WorkerThread
  public final boolean zzE()
  {
    return (this.zzF != null) && (this.zzF.booleanValue());
  }
  
  @WorkerThread
  public final boolean zzF()
  {
    return zzG() == 0;
  }
  
  @WorkerThread
  public final int zzG()
  {
    zzav().zzg();
    if (this.zzk.zzr()) {
      return 1;
    }
    Object localObject = this.zzb;
    if ((localObject != null) && (((Boolean)localObject).booleanValue())) {
      return 2;
    }
    zzav().zzg();
    if (!this.zzG) {
      return 8;
    }
    localObject = zzd().zzf();
    if (localObject != null)
    {
      if (((Boolean)localObject).booleanValue()) {
        return 0;
      }
      return 3;
    }
    zzae localzzae = this.zzk;
    localObject = localzzae.zzs.zzj;
    localObject = localzzae.zzp("firebase_analytics_collection_enabled");
    if (localObject != null)
    {
      if (((Boolean)localObject).booleanValue()) {
        return 0;
      }
      return 4;
    }
    localObject = this.zza;
    if (localObject != null)
    {
      if (((Boolean)localObject).booleanValue()) {
        return 0;
      }
      return 5;
    }
    if ((this.zzk.zzn(null, zzea.zzS)) && (this.zzF != null))
    {
      if (this.zzF.booleanValue()) {
        return 0;
      }
      return 7;
    }
    return 0;
  }
  
  @WorkerThread
  public final void zzH(boolean paramBoolean)
  {
    zzav().zzg();
    this.zzG = paramBoolean;
  }
  
  @WorkerThread
  public final boolean zzI()
  {
    zzav().zzg();
    return this.zzG;
  }
  
  final void zzJ()
  {
    this.zzH += 1;
  }
  
  final void zzK()
  {
    this.zzI.incrementAndGet();
  }
  
  @WorkerThread
  protected final boolean zzL()
  {
    if (this.zzC)
    {
      zzav().zzg();
      Boolean localBoolean = this.zzD;
      if ((localBoolean == null) || (this.zzE == 0L) || ((!localBoolean.booleanValue()) && (Math.abs(this.zzr.elapsedRealtime() - this.zzE) > 1000L)))
      {
        this.zzE = this.zzr.elapsedRealtime();
        boolean bool1 = zzl().zzQ("android.permission.INTERNET");
        boolean bool2 = true;
        if ((bool1) && (zzl().zzQ("android.permission.ACCESS_NETWORK_STATE")) && ((Wrappers.packageManager(this.zze).isCallerInstantApp()) || (this.zzk.zzy()) || ((zzku.zzam(this.zze)) && (zzku.zzP(this.zze, false))))) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        localBoolean = Boolean.valueOf(bool1);
        this.zzD = localBoolean;
        if (localBoolean.booleanValue())
        {
          bool1 = bool2;
          if (!zzl().zzA(zzA().zzj(), zzA().zzk(), zzA().zzl())) {
            if (!TextUtils.isEmpty(zzA().zzk())) {
              bool1 = bool2;
            } else {
              bool1 = false;
            }
          }
          this.zzD = Boolean.valueOf(bool1);
        }
      }
      return this.zzD.booleanValue();
    }
    throw new IllegalStateException("AppMeasurement is not initialized");
  }
  
  @WorkerThread
  public final void zzM()
  {
    zzav().zzg();
    zzS(zzo());
    String str = zzA().zzi();
    Object localObject1 = zzd().zzb(str);
    if ((this.zzk.zzs()) && (!((Boolean)((Pair)localObject1).second).booleanValue()) && (!TextUtils.isEmpty((CharSequence)((Pair)localObject1).first)))
    {
      Object localObject2 = zzo();
      ((zzgo)localObject2).zzv();
      ConnectivityManager localConnectivityManager = (ConnectivityManager)((zzgn)localObject2).zzs.zze.getSystemService("connectivity");
      zzfs localzzfs = null;
      localObject2 = localzzfs;
      Object localObject3;
      if (localConnectivityManager != null) {
        try
        {
          localObject2 = localConnectivityManager.getActiveNetworkInfo();
        }
        catch (SecurityException localSecurityException)
        {
          localObject3 = localzzfs;
        }
      }
      if ((localObject3 != null) && (((NetworkInfo)localObject3).isConnected()))
      {
        localObject3 = zzl();
        zzA().zzs.zzk.zzf();
        localObject1 = ((zzku)localObject3).zzal(42004L, str, (String)((Pair)localObject1).first, zzd().zzn.zza() - 1L);
        if (localObject1 != null)
        {
          localObject3 = zzo();
          localzzfs = new zzfs(this);
          ((zzgn)localObject3).zzg();
          ((zzgo)localObject3).zzv();
          Preconditions.checkNotNull(localObject1);
          Preconditions.checkNotNull(localzzfs);
          ((zzgn)localObject3).zzs.zzav().zzk(new zzhz((zzia)localObject3, str, (URL)localObject1, null, null, localzzfs, null));
        }
        return;
      }
      zzau().zze().zza("Network is not available for Deferred Deep Link request. Skipping");
      return;
    }
    zzau().zzj().zza("ADID unavailable to retrieve Deferred Deep Link. Skipping");
  }
  
  @WorkerThread
  protected final void zza(zzcl paramzzcl)
  {
    zzav().zzg();
    Object localObject1 = zzd().zzi();
    Object localObject2 = zzd();
    Object localObject3 = ((zzgn)localObject2).zzs;
    ((zzgn)localObject2).zzg();
    localObject3 = ((zzfb)localObject2).zzd();
    int i = 100;
    int j = ((SharedPreferences)localObject3).getInt("consent_source", 100);
    localObject3 = this.zzk;
    localObject2 = ((zzgn)localObject3).zzs;
    localObject3 = ((zzae)localObject3).zzp("google_analytics_default_allow_ad_storage");
    localObject2 = this.zzk;
    Object localObject4 = ((zzgn)localObject2).zzs;
    localObject2 = ((zzae)localObject2).zzp("google_analytics_default_allow_analytics_storage");
    if (((localObject3 != null) || (localObject2 != null)) && (zzd().zzh(-10)))
    {
      paramzzcl = new zzaf((Boolean)localObject3, (Boolean)localObject2);
      i = -10;
    }
    else
    {
      if ((!TextUtils.isEmpty(zzA().zzj())) && ((j == 0) || (j == 30) || (j == 10) || (j == 30) || (j == 30) || (j == 40))) {
        zzk().zzq(zzaf.zza, -10, this.zzc);
      }
      do
      {
        do
        {
          paramzzcl = null;
          break;
          zzod.zzb();
        } while (((this.zzk.zzn(null, zzea.zzaC)) && (!TextUtils.isEmpty(zzA().zzj()))) || (paramzzcl == null) || (paramzzcl.zzg == null) || (!zzd().zzh(30)));
        paramzzcl = zzaf.zzb(paramzzcl.zzg);
      } while (paramzzcl.equals(zzaf.zza));
      i = 30;
    }
    if (paramzzcl != null)
    {
      zzk().zzq(paramzzcl, i, this.zzc);
      localObject1 = paramzzcl;
    }
    zzk().zzr((zzaf)localObject1);
    if (zzd().zzc.zza() == 0L)
    {
      zzau().zzk().zzb("Persisting first open", Long.valueOf(this.zzc));
      zzd().zzc.zzb(this.zzc);
    }
    zzk().zzb.zzc();
    if (!zzL())
    {
      if (zzF())
      {
        if (!zzl().zzQ("android.permission.INTERNET")) {
          zzau().zzb().zza("App is missing INTERNET permission");
        }
        if (!zzl().zzQ("android.permission.ACCESS_NETWORK_STATE")) {
          zzau().zzb().zza("App is missing ACCESS_NETWORK_STATE permission");
        }
        if ((!Wrappers.packageManager(this.zze).isCallerInstantApp()) && (!this.zzk.zzy()))
        {
          if (!zzku.zzam(this.zze)) {
            zzau().zzb().zza("AppMeasurementReceiver not registered/enabled");
          }
          if (!zzku.zzP(this.zze, false)) {
            zzau().zzb().zza("AppMeasurementService not registered/enabled");
          }
        }
        zzau().zzb().zza("Uploading is not possible. App measurement disabled");
      }
    }
    else
    {
      if ((!TextUtils.isEmpty(zzA().zzj())) || (!TextUtils.isEmpty(zzA().zzk())))
      {
        paramzzcl = zzl();
        localObject1 = zzA().zzj();
        localObject3 = zzd();
        ((zzgn)localObject3).zzg();
        localObject2 = ((zzfb)localObject3).zzd().getString("gmp_app_id", null);
        localObject3 = zzA().zzk();
        localObject4 = zzd();
        ((zzgn)localObject4).zzg();
        if (paramzzcl.zzB((String)localObject1, (String)localObject2, (String)localObject3, ((zzfb)localObject4).zzd().getString("admob_app_id", null)))
        {
          zzau().zzi().zza("Rechecking which service to use due to a GMP App Id change");
          paramzzcl = zzd();
          paramzzcl.zzg();
          localObject1 = paramzzcl.zzf();
          localObject3 = paramzzcl.zzd().edit();
          ((SharedPreferences.Editor)localObject3).clear();
          ((SharedPreferences.Editor)localObject3).apply();
          if (localObject1 != null) {
            paramzzcl.zze((Boolean)localObject1);
          }
          zzn().zzh();
          this.zzy.zzF();
          this.zzy.zzB();
          zzd().zzc.zzb(this.zzc);
          zzd().zze.zzb(null);
        }
        localObject1 = zzd();
        paramzzcl = zzA().zzj();
        ((zzgn)localObject1).zzg();
        localObject1 = ((zzfb)localObject1).zzd().edit();
        ((SharedPreferences.Editor)localObject1).putString("gmp_app_id", paramzzcl);
        ((SharedPreferences.Editor)localObject1).apply();
        localObject1 = zzd();
        paramzzcl = zzA().zzk();
        ((zzgn)localObject1).zzg();
        localObject1 = ((zzfb)localObject1).zzd().edit();
        ((SharedPreferences.Editor)localObject1).putString("admob_app_id", paramzzcl);
        ((SharedPreferences.Editor)localObject1).apply();
      }
      if (!zzd().zzi().zzh()) {
        zzd().zze.zzb(null);
      }
      zzk().zzE(zzd().zze.zza());
      zzoa.zzb();
      if (this.zzk.zzn(null, zzea.zzam))
      {
        paramzzcl = zzl();
        try
        {
          paramzzcl.zzs.zze.getClassLoader().loadClass("com.google.firebase.remoteconfig.FirebaseRemoteConfig");
        }
        catch (ClassNotFoundException paramzzcl)
        {
          if (!TextUtils.isEmpty(zzd().zzo.zza()))
          {
            zzau().zze().zza("Remote config removed with active feature rollouts");
            zzd().zzo.zzb(null);
          }
        }
      }
      if ((!TextUtils.isEmpty(zzA().zzj())) || (!TextUtils.isEmpty(zzA().zzk())))
      {
        boolean bool = zzF();
        if ((!zzd().zzk()) && (!this.zzk.zzr())) {
          zzd().zzj(bool ^ true);
        }
        if (bool) {
          zzk().zzH();
        }
        zzh().zza.zza();
        zzy().zzv(new AtomicReference());
        zzy().zzA(zzd().zzr.zza());
      }
    }
    zzd().zzi.zzb(true);
  }
  
  @Pure
  public final zzz zzat()
  {
    return this.zzj;
  }
  
  @Pure
  public final zzem zzau()
  {
    zzS(this.zzm);
    return this.zzm;
  }
  
  @Pure
  public final zzfr zzav()
  {
    zzS(this.zzn);
    return this.zzn;
  }
  
  @Pure
  public final Context zzax()
  {
    return this.zze;
  }
  
  @Pure
  public final Clock zzay()
  {
    return this.zzr;
  }
  
  @Pure
  public final zzae zzc()
  {
    return this.zzk;
  }
  
  @Pure
  public final zzfb zzd()
  {
    zzQ(this.zzl);
    return this.zzl;
  }
  
  public final zzem zzf()
  {
    zzem localzzem = this.zzm;
    if ((localzzem != null) && (localzzem.zzu())) {
      return this.zzm;
    }
    return null;
  }
  
  @Pure
  public final zzjz zzh()
  {
    zzR(this.zzo);
    return this.zzo;
  }
  
  @SideEffectFree
  public final zzfe zzi()
  {
    return this.zzB;
  }
  
  @SideEffectFree
  final zzfr zzj()
  {
    return this.zzn;
  }
  
  @Pure
  public final zzhw zzk()
  {
    zzR(this.zzt);
    return this.zzt;
  }
  
  @Pure
  public final zzku zzl()
  {
    zzQ(this.zzp);
    return this.zzp;
  }
  
  @Pure
  public final zzeh zzm()
  {
    zzQ(this.zzq);
    return this.zzq;
  }
  
  @Pure
  public final zzeg zzn()
  {
    zzR(this.zzx);
    return this.zzx;
  }
  
  @Pure
  public final zzia zzo()
  {
    zzS(this.zzv);
    return this.zzv;
  }
  
  @Pure
  public final boolean zzq()
  {
    return TextUtils.isEmpty(this.zzf);
  }
  
  @Pure
  public final String zzr()
  {
    return this.zzf;
  }
  
  @Pure
  public final String zzs()
  {
    return this.zzg;
  }
  
  @Pure
  public final String zzt()
  {
    return this.zzh;
  }
  
  @Pure
  public final boolean zzu()
  {
    return this.zzi;
  }
  
  @Pure
  public final String zzv()
  {
    return this.zzw;
  }
  
  @Pure
  public final zzik zzx()
  {
    zzR(this.zzs);
    return this.zzs;
  }
  
  @Pure
  public final zzjk zzy()
  {
    zzR(this.zzy);
    return this.zzy;
  }
  
  @Pure
  public final zzam zzz()
  {
    zzS(this.zzz);
    return this.zzz;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzfu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */