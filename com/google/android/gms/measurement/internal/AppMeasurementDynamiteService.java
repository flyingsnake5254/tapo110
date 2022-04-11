package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzcb;
import com.google.android.gms.internal.measurement.zzcf;
import com.google.android.gms.internal.measurement.zzci;
import com.google.android.gms.internal.measurement.zzck;
import com.google.android.gms.internal.measurement.zzcl;
import com.google.android.gms.internal.measurement.zzod;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

@DynamiteApi
public class AppMeasurementDynamiteService
  extends zzcb
{
  @VisibleForTesting
  zzfu zza = null;
  @GuardedBy("listenerMap")
  private final Map<Integer, zzgv> zzb = new ArrayMap();
  
  @EnsuresNonNull({"scion"})
  private final void zzb()
  {
    if (this.zza != null) {
      return;
    }
    throw new IllegalStateException("Attempting to perform action before initialize.");
  }
  
  private final void zzc(zzcf paramzzcf, String paramString)
  {
    zzb();
    this.zza.zzl().zzad(paramzzcf, paramString);
  }
  
  public void beginAdUnitExposure(@NonNull String paramString, long paramLong)
    throws RemoteException
  {
    zzb();
    this.zza.zzB().zza(paramString, paramLong);
  }
  
  public void clearConditionalUserProperty(@NonNull String paramString1, @NonNull String paramString2, @NonNull Bundle paramBundle)
    throws RemoteException
  {
    zzb();
    this.zza.zzk().zzO(paramString1, paramString2, paramBundle);
  }
  
  public void clearMeasurementEnabled(long paramLong)
    throws RemoteException
  {
    zzb();
    this.zza.zzk().zzn(null);
  }
  
  public void endAdUnitExposure(@NonNull String paramString, long paramLong)
    throws RemoteException
  {
    zzb();
    this.zza.zzB().zzb(paramString, paramLong);
  }
  
  public void generateEventId(zzcf paramzzcf)
    throws RemoteException
  {
    zzb();
    long l = this.zza.zzl().zzd();
    zzb();
    this.zza.zzl().zzae(paramzzcf, l);
  }
  
  public void getAppInstanceId(zzcf paramzzcf)
    throws RemoteException
  {
    zzb();
    this.zza.zzav().zzh(new zzh(this, paramzzcf));
  }
  
  public void getCachedAppInstanceId(zzcf paramzzcf)
    throws RemoteException
  {
    zzb();
    zzc(paramzzcf, this.zza.zzk().zzD());
  }
  
  public void getConditionalUserProperties(String paramString1, String paramString2, zzcf paramzzcf)
    throws RemoteException
  {
    zzb();
    this.zza.zzav().zzh(new zzl(this, paramzzcf, paramString1, paramString2));
  }
  
  public void getCurrentScreenClass(zzcf paramzzcf)
    throws RemoteException
  {
    zzb();
    zzc(paramzzcf, this.zza.zzk().zzS());
  }
  
  public void getCurrentScreenName(zzcf paramzzcf)
    throws RemoteException
  {
    zzb();
    zzc(paramzzcf, this.zza.zzk().zzR());
  }
  
  public void getGmpAppId(zzcf paramzzcf)
    throws RemoteException
  {
    zzb();
    zzc(paramzzcf, this.zza.zzk().zzT());
  }
  
  public void getMaxUserProperties(String paramString, zzcf paramzzcf)
    throws RemoteException
  {
    zzb();
    this.zza.zzk().zzL(paramString);
    zzb();
    this.zza.zzl().zzaf(paramzzcf, 25);
  }
  
  public void getTestFlag(zzcf paramzzcf, int paramInt)
    throws RemoteException
  {
    zzb();
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4) {
              return;
            }
            this.zza.zzl().zzah(paramzzcf, this.zza.zzk().zzi().booleanValue());
            return;
          }
          this.zza.zzl().zzaf(paramzzcf, this.zza.zzk().zzl().intValue());
          return;
        }
        zzku localzzku = this.zza.zzl();
        double d = this.zza.zzk().zzm().doubleValue();
        Bundle localBundle = new Bundle();
        localBundle.putDouble("r", d);
        try
        {
          paramzzcf.zzb(localBundle);
          return;
        }
        catch (RemoteException paramzzcf)
        {
          localzzku.zzs.zzau().zze().zzb("Error returning double value to wrapper", paramzzcf);
          return;
        }
      }
      this.zza.zzl().zzae(paramzzcf, this.zza.zzk().zzk().longValue());
      return;
    }
    this.zza.zzl().zzad(paramzzcf, this.zza.zzk().zzj());
  }
  
  public void getUserProperties(String paramString1, String paramString2, boolean paramBoolean, zzcf paramzzcf)
    throws RemoteException
  {
    zzb();
    this.zza.zzav().zzh(new zzj(this, paramzzcf, paramString1, paramString2, paramBoolean));
  }
  
  public void initForTests(@NonNull Map paramMap)
    throws RemoteException
  {
    zzb();
  }
  
  public void initialize(IObjectWrapper paramIObjectWrapper, zzcl paramzzcl, long paramLong)
    throws RemoteException
  {
    zzfu localzzfu = this.zza;
    if (localzzfu == null)
    {
      this.zza = zzfu.zzC((Context)Preconditions.checkNotNull((Context)ObjectWrapper.unwrap(paramIObjectWrapper)), paramzzcl, Long.valueOf(paramLong));
      return;
    }
    localzzfu.zzau().zze().zza("Attempting to initialize multiple times");
  }
  
  public void isDataCollectionEnabled(zzcf paramzzcf)
    throws RemoteException
  {
    zzb();
    this.zza.zzav().zzh(new zzm(this, paramzzcf));
  }
  
  public void logEvent(@NonNull String paramString1, @NonNull String paramString2, @NonNull Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
    throws RemoteException
  {
    zzb();
    this.zza.zzk().zzv(paramString1, paramString2, paramBundle, paramBoolean1, paramBoolean2, paramLong);
  }
  
  public void logEventAndBundle(String paramString1, String paramString2, Bundle paramBundle, zzcf paramzzcf, long paramLong)
    throws RemoteException
  {
    zzb();
    Preconditions.checkNotEmpty(paramString2);
    Bundle localBundle;
    if (paramBundle != null) {
      localBundle = new Bundle(paramBundle);
    } else {
      localBundle = new Bundle();
    }
    localBundle.putString("_o", "app");
    paramString2 = new zzas(paramString2, new zzaq(paramBundle), "app", paramLong);
    this.zza.zzav().zzh(new zzi(this, paramzzcf, paramString2, paramString1));
  }
  
  public void logHealthData(int paramInt, @NonNull String paramString, @NonNull IObjectWrapper paramIObjectWrapper1, @NonNull IObjectWrapper paramIObjectWrapper2, @NonNull IObjectWrapper paramIObjectWrapper3)
    throws RemoteException
  {
    zzb();
    Object localObject = null;
    if (paramIObjectWrapper1 == null) {
      paramIObjectWrapper1 = null;
    } else {
      paramIObjectWrapper1 = ObjectWrapper.unwrap(paramIObjectWrapper1);
    }
    if (paramIObjectWrapper2 == null) {
      paramIObjectWrapper2 = null;
    } else {
      paramIObjectWrapper2 = ObjectWrapper.unwrap(paramIObjectWrapper2);
    }
    if (paramIObjectWrapper3 == null) {
      paramIObjectWrapper3 = (IObjectWrapper)localObject;
    } else {
      paramIObjectWrapper3 = ObjectWrapper.unwrap(paramIObjectWrapper3);
    }
    this.zza.zzau().zzm(paramInt, true, false, paramString, paramIObjectWrapper1, paramIObjectWrapper2, paramIObjectWrapper3);
  }
  
  public void onActivityCreated(@NonNull IObjectWrapper paramIObjectWrapper, @NonNull Bundle paramBundle, long paramLong)
    throws RemoteException
  {
    zzb();
    zzhv localzzhv = this.zza.zzk().zza;
    if (localzzhv != null)
    {
      this.zza.zzk().zzh();
      localzzhv.onActivityCreated((Activity)ObjectWrapper.unwrap(paramIObjectWrapper), paramBundle);
    }
  }
  
  public void onActivityDestroyed(@NonNull IObjectWrapper paramIObjectWrapper, long paramLong)
    throws RemoteException
  {
    zzb();
    zzhv localzzhv = this.zza.zzk().zza;
    if (localzzhv != null)
    {
      this.zza.zzk().zzh();
      localzzhv.onActivityDestroyed((Activity)ObjectWrapper.unwrap(paramIObjectWrapper));
    }
  }
  
  public void onActivityPaused(@NonNull IObjectWrapper paramIObjectWrapper, long paramLong)
    throws RemoteException
  {
    zzb();
    zzhv localzzhv = this.zza.zzk().zza;
    if (localzzhv != null)
    {
      this.zza.zzk().zzh();
      localzzhv.onActivityPaused((Activity)ObjectWrapper.unwrap(paramIObjectWrapper));
    }
  }
  
  public void onActivityResumed(@NonNull IObjectWrapper paramIObjectWrapper, long paramLong)
    throws RemoteException
  {
    zzb();
    zzhv localzzhv = this.zza.zzk().zza;
    if (localzzhv != null)
    {
      this.zza.zzk().zzh();
      localzzhv.onActivityResumed((Activity)ObjectWrapper.unwrap(paramIObjectWrapper));
    }
  }
  
  public void onActivitySaveInstanceState(IObjectWrapper paramIObjectWrapper, zzcf paramzzcf, long paramLong)
    throws RemoteException
  {
    zzb();
    zzhv localzzhv = this.zza.zzk().zza;
    Bundle localBundle = new Bundle();
    if (localzzhv != null)
    {
      this.zza.zzk().zzh();
      localzzhv.onActivitySaveInstanceState((Activity)ObjectWrapper.unwrap(paramIObjectWrapper), localBundle);
    }
    try
    {
      paramzzcf.zzb(localBundle);
      return;
    }
    catch (RemoteException paramIObjectWrapper)
    {
      this.zza.zzau().zze().zzb("Error returning bundle value to wrapper", paramIObjectWrapper);
    }
  }
  
  public void onActivityStarted(@NonNull IObjectWrapper paramIObjectWrapper, long paramLong)
    throws RemoteException
  {
    zzb();
    if (this.zza.zzk().zza != null)
    {
      this.zza.zzk().zzh();
      paramIObjectWrapper = (Activity)ObjectWrapper.unwrap(paramIObjectWrapper);
    }
  }
  
  public void onActivityStopped(@NonNull IObjectWrapper paramIObjectWrapper, long paramLong)
    throws RemoteException
  {
    zzb();
    if (this.zza.zzk().zza != null)
    {
      this.zza.zzk().zzh();
      paramIObjectWrapper = (Activity)ObjectWrapper.unwrap(paramIObjectWrapper);
    }
  }
  
  public void performAction(Bundle paramBundle, zzcf paramzzcf, long paramLong)
    throws RemoteException
  {
    zzb();
    paramzzcf.zzb(null);
  }
  
  public void registerOnMeasurementEventListener(zzci paramzzci)
    throws RemoteException
  {
    zzb();
    synchronized (this.zzb)
    {
      zzgv localzzgv = (zzgv)this.zzb.get(Integer.valueOf(paramzzci.zze()));
      Object localObject = localzzgv;
      if (localzzgv == null)
      {
        localObject = new com/google/android/gms/measurement/internal/zzo;
        ((zzo)localObject).<init>(this, paramzzci);
        this.zzb.put(Integer.valueOf(paramzzci.zze()), localObject);
      }
      this.zza.zzk().zzJ((zzgv)localObject);
      return;
    }
  }
  
  public void resetAnalyticsData(long paramLong)
    throws RemoteException
  {
    zzb();
    this.zza.zzk().zzF(paramLong);
  }
  
  public void setConditionalUserProperty(@NonNull Bundle paramBundle, long paramLong)
    throws RemoteException
  {
    zzb();
    if (paramBundle == null)
    {
      this.zza.zzau().zzb().zza("Conditional user property must not be null");
      return;
    }
    this.zza.zzk().zzN(paramBundle, paramLong);
  }
  
  public void setConsent(@NonNull Bundle paramBundle, long paramLong)
    throws RemoteException
  {
    zzb();
    zzhw localzzhw = this.zza.zzk();
    zzod.zzb();
    if ((localzzhw.zzs.zzc().zzn(null, zzea.zzaC)) && (!TextUtils.isEmpty(localzzhw.zzs.zzA().zzj())))
    {
      localzzhw.zzs.zzau().zzh().zza("Using developer consent only; google app id found");
      return;
    }
    localzzhw.zzo(paramBundle, 0, paramLong);
  }
  
  public void setConsentThirdParty(@NonNull Bundle paramBundle, long paramLong)
    throws RemoteException
  {
    zzb();
    this.zza.zzk().zzo(paramBundle, -20, paramLong);
  }
  
  public void setCurrentScreen(@NonNull IObjectWrapper paramIObjectWrapper, @NonNull String paramString1, @NonNull String paramString2, long paramLong)
    throws RemoteException
  {
    zzb();
    this.zza.zzx().zzk((Activity)ObjectWrapper.unwrap(paramIObjectWrapper), paramString1, paramString2);
  }
  
  public void setDataCollectionEnabled(boolean paramBoolean)
    throws RemoteException
  {
    zzb();
    zzhw localzzhw = this.zza.zzk();
    localzzhw.zzb();
    localzzhw.zzs.zzav().zzh(new zzgz(localzzhw, paramBoolean));
  }
  
  public void setDefaultEventParameters(@NonNull Bundle paramBundle)
  {
    zzb();
    zzhw localzzhw = this.zza.zzk();
    if (paramBundle == null) {
      paramBundle = null;
    } else {
      paramBundle = new Bundle(paramBundle);
    }
    localzzhw.zzs.zzav().zzh(new zzgx(localzzhw, paramBundle));
  }
  
  public void setEventInterceptor(zzci paramzzci)
    throws RemoteException
  {
    zzb();
    paramzzci = new zzn(this, paramzzci);
    if (this.zza.zzav().zzd())
    {
      this.zza.zzk().zzI(paramzzci);
      return;
    }
    this.zza.zzav().zzh(new zzk(this, paramzzci));
  }
  
  public void setInstanceIdProvider(zzck paramzzck)
    throws RemoteException
  {
    zzb();
  }
  
  public void setMeasurementEnabled(boolean paramBoolean, long paramLong)
    throws RemoteException
  {
    zzb();
    this.zza.zzk().zzn(Boolean.valueOf(paramBoolean));
  }
  
  public void setMinimumSessionDuration(long paramLong)
    throws RemoteException
  {
    zzb();
  }
  
  public void setSessionTimeoutDuration(long paramLong)
    throws RemoteException
  {
    zzb();
    zzhw localzzhw = this.zza.zzk();
    localzzhw.zzs.zzav().zzh(new zzhb(localzzhw, paramLong));
  }
  
  public void setUserId(@NonNull String paramString, long paramLong)
    throws RemoteException
  {
    zzb();
    if ((this.zza.zzc().zzn(null, zzea.zzaA)) && (paramString != null) && (paramString.length() == 0))
    {
      this.zza.zzau().zze().zza("User ID must be non-empty");
      return;
    }
    this.zza.zzk().zzz(null, "_id", paramString, true, paramLong);
  }
  
  public void setUserProperty(@NonNull String paramString1, @NonNull String paramString2, @NonNull IObjectWrapper paramIObjectWrapper, boolean paramBoolean, long paramLong)
    throws RemoteException
  {
    zzb();
    paramIObjectWrapper = ObjectWrapper.unwrap(paramIObjectWrapper);
    this.zza.zzk().zzz(paramString1, paramString2, paramIObjectWrapper, paramBoolean, paramLong);
  }
  
  public void unregisterOnMeasurementEventListener(zzci paramzzci)
    throws RemoteException
  {
    zzb();
    synchronized (this.zzb)
    {
      zzgv localzzgv = (zzgv)this.zzb.remove(Integer.valueOf(paramzzci.zze()));
      ??? = localzzgv;
      if (localzzgv == null) {
        ??? = new zzo(this, paramzzci);
      }
      this.zza.zzk().zzK((zzgv)???);
      return;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\AppMeasurementDynamiteService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */