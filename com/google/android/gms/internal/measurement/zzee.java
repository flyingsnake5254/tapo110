package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.NetworkOnMainThreadException;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.DynamiteModule.LoadingException;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzfm;
import com.google.android.gms.measurement.internal.zzgu;
import com.google.android.gms.measurement.internal.zzgv;
import com.google.android.gms.measurement.internal.zzic;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ExecutorService;

public final class zzee
{
  private static volatile zzee zzc;
  protected final Clock zza;
  protected final ExecutorService zzb;
  private final String zzd;
  private final AppMeasurementSdk zze;
  @GuardedBy("listenerList")
  private final List<Pair<zzgv, zzdv>> zzf;
  private int zzg;
  private boolean zzh;
  private final String zzi;
  private volatile zzcc zzj;
  
  protected zzee(Context paramContext, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    if ((paramString1 != null) && (zzV(paramString2, paramString3))) {
      this.zzd = paramString1;
    } else {
      this.zzd = "FA";
    }
    this.zza = DefaultClock.getInstance();
    zzbu localzzbu = zzbx.zza();
    paramString1 = new zzdi(this);
    int i = 1;
    this.zzb = localzzbu.zzb(paramString1, 1);
    this.zze = new AppMeasurementSdk(this);
    this.zzf = new ArrayList();
    try
    {
      paramString1 = zzic.zza(paramContext, "google_app_id", zzfm.zza(paramContext));
      if ((paramString1 != null) && (!zzR()))
      {
        this.zzi = null;
        this.zzh = true;
        Log.w(this.zzd, "Disabling data collection. Found google_app_id in strings.xml but Google Analytics for Firebase is missing. Remove this value or add Google Analytics for Firebase to resume data collection.");
        return;
      }
    }
    catch (IllegalStateException paramString1)
    {
      if (!zzV(paramString2, paramString3))
      {
        this.zzi = "fa";
        if ((paramString2 != null) && (paramString3 != null))
        {
          Log.v(this.zzd, "Deferring to Google Analytics for Firebase for event data collection. https://goo.gl/J1sWQy");
        }
        else
        {
          int j;
          if (paramString2 == null) {
            j = 1;
          } else {
            j = 0;
          }
          if (paramString3 != null) {
            i = 0;
          }
          if ((j ^ i) != 0) {
            Log.w(this.zzd, "Specified origin or custom app id is null. Both parameters will be ignored.");
          }
        }
      }
      else
      {
        this.zzi = paramString2;
      }
      zzS(new zzcx(this, paramString2, paramString3, paramContext, paramBundle));
      paramContext = (Application)paramContext.getApplicationContext();
      if (paramContext == null)
      {
        Log.w(this.zzd, "Unable to register lifecycle notifications. Application null.");
        return;
      }
      paramContext.registerActivityLifecycleCallbacks(new zzed(this));
    }
  }
  
  protected static final boolean zzR()
  {
    try
    {
      Class.forName("com.google.firebase.analytics.FirebaseAnalytics");
      return true;
    }
    catch (ClassNotFoundException localClassNotFoundException) {}
    return false;
  }
  
  private final void zzS(zzdt paramzzdt)
  {
    this.zzb.execute(paramzzdt);
  }
  
  private final void zzT(Exception paramException, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.zzh |= paramBoolean1;
    if (paramBoolean1)
    {
      Log.w(this.zzd, "Data collection startup failed. No data will be collected.", paramException);
      return;
    }
    if (paramBoolean2) {
      zzC(5, "Error with data collection. Data lost.", paramException, null, null);
    }
    Log.w(this.zzd, "Error with data collection. Data lost.", paramException);
  }
  
  private final void zzU(String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2, Long paramLong)
  {
    zzS(new zzdr(this, paramLong, paramString1, paramString2, paramBundle, paramBoolean1, paramBoolean2));
  }
  
  private static final boolean zzV(String paramString1, String paramString2)
  {
    return (paramString2 != null) && (paramString1 != null) && (!zzR());
  }
  
  public static zzee zza(Context paramContext, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    Preconditions.checkNotNull(paramContext);
    if (zzc == null) {
      try
      {
        if (zzc == null)
        {
          zzee localzzee = new com/google/android/gms/internal/measurement/zzee;
          localzzee.<init>(paramContext, paramString1, paramString2, paramString3, paramBundle);
          zzc = localzzee;
        }
      }
      finally {}
    }
    return zzc;
  }
  
  public final String zzA()
  {
    zzbz localzzbz = new zzbz();
    zzS(new zzde(this, localzzbz));
    return localzzbz.zzc(500L);
  }
  
  public final Map<String, Object> zzB(String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject = new zzbz();
    zzS(new zzdf(this, paramString1, paramString2, paramBoolean, (zzbz)localObject));
    localObject = ((zzbz)localObject).zzd(5000L);
    if ((localObject != null) && (((Bundle)localObject).size() != 0))
    {
      HashMap localHashMap = new HashMap(((Bundle)localObject).size());
      Iterator localIterator = ((Bundle)localObject).keySet().iterator();
      while (localIterator.hasNext())
      {
        paramString1 = (String)localIterator.next();
        paramString2 = ((Bundle)localObject).get(paramString1);
        if (((paramString2 instanceof Double)) || ((paramString2 instanceof Long)) || ((paramString2 instanceof String))) {
          localHashMap.put(paramString1, paramString2);
        }
      }
      return localHashMap;
    }
    return Collections.emptyMap();
  }
  
  public final void zzC(int paramInt, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    zzS(new zzdg(this, false, 5, paramString, paramObject1, null, null));
  }
  
  public final Bundle zzD(Bundle paramBundle, boolean paramBoolean)
  {
    zzbz localzzbz = new zzbz();
    zzS(new zzdh(this, paramBundle, localzzbz));
    if (paramBoolean) {
      return localzzbz.zzd(5000L);
    }
    return null;
  }
  
  public final int zzE(String paramString)
  {
    zzbz localzzbz = new zzbz();
    zzS(new zzdj(this, paramString, localzzbz));
    paramString = (Integer)zzbz.zze(localzzbz.zzd(10000L), Integer.class);
    if (paramString == null) {
      return 25;
    }
    return paramString.intValue();
  }
  
  @WorkerThread
  public final String zzF()
  {
    zzbz localzzbz = new zzbz();
    zzS(new zzdk(this, localzzbz));
    return localzzbz.zzc(120000L);
  }
  
  public final String zzG()
  {
    return this.zzi;
  }
  
  public final Object zzH(int paramInt)
  {
    zzbz localzzbz = new zzbz();
    zzS(new zzdl(this, localzzbz, paramInt));
    return zzbz.zze(localzzbz.zzd(15000L), Object.class);
  }
  
  public final void zzI(boolean paramBoolean)
  {
    zzS(new zzdm(this, paramBoolean));
  }
  
  public final void zzJ(Bundle paramBundle)
  {
    zzS(new zzdn(this, paramBundle));
  }
  
  public final AppMeasurementSdk zzb()
  {
    return this.zze;
  }
  
  protected final zzcc zzc(Context paramContext, boolean paramBoolean)
  {
    try
    {
      paramContext = zzcb.asInterface(DynamiteModule.load(paramContext, DynamiteModule.PREFER_HIGHEST_OR_REMOTE_VERSION, "com.google.android.gms.measurement.dynamite").instantiate("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
      return paramContext;
    }
    catch (DynamiteModule.LoadingException paramContext)
    {
      zzT(paramContext, true, false);
    }
    return null;
  }
  
  public final void zzd(zzgu paramzzgu)
  {
    zzdu localzzdu = new zzdu(paramzzgu);
    if (this.zzj != null) {
      try
      {
        this.zzj.setEventInterceptor(localzzdu);
        return;
      }
      catch (RemoteException|BadParcelableException|IllegalArgumentException|IllegalStateException|NetworkOnMainThreadException|NullPointerException|SecurityException|UnsupportedOperationException paramzzgu)
      {
        Log.w(this.zzd, "Failed to set event interceptor on calling thread. Trying again on the dynamite thread.");
      }
    }
    zzS(new zzdo(this, localzzdu));
  }
  
  public final void zze(zzgv paramzzgv)
  {
    Preconditions.checkNotNull(paramzzgv);
    List localList1 = this.zzf;
    int i = 0;
    try
    {
      while (i < this.zzf.size())
      {
        if (paramzzgv.equals(((Pair)this.zzf.get(i)).first))
        {
          Log.w(this.zzd, "OnEventListener already registered.");
          return;
        }
        i++;
      }
      zzdv localzzdv = new com/google/android/gms/internal/measurement/zzdv;
      localzzdv.<init>(paramzzgv);
      List localList2 = this.zzf;
      Pair localPair = new android/util/Pair;
      localPair.<init>(paramzzgv, localzzdv);
      localList2.add(localPair);
      if (this.zzj != null) {
        try
        {
          this.zzj.registerOnMeasurementEventListener(localzzdv);
          return;
        }
        catch (RemoteException|BadParcelableException|IllegalArgumentException|IllegalStateException|NetworkOnMainThreadException|NullPointerException|SecurityException|UnsupportedOperationException paramzzgv)
        {
          Log.w(this.zzd, "Failed to register event listener on calling thread. Trying again on the dynamite thread.");
        }
      }
      zzS(new zzdp(this, localzzdv));
      return;
    }
    finally {}
  }
  
  public final void zzf(zzgv paramzzgv)
  {
    Preconditions.checkNotNull(paramzzgv);
    List localList = this.zzf;
    int i = 0;
    try
    {
      while (i < this.zzf.size())
      {
        if (paramzzgv.equals(((Pair)this.zzf.get(i)).first))
        {
          paramzzgv = (Pair)this.zzf.get(i);
          break label75;
        }
        i++;
      }
      paramzzgv = null;
      label75:
      if (paramzzgv == null)
      {
        Log.w(this.zzd, "OnEventListener had not been registered.");
        return;
      }
      this.zzf.remove(paramzzgv);
      paramzzgv = (zzdv)paramzzgv.second;
      if (this.zzj != null) {
        try
        {
          this.zzj.unregisterOnMeasurementEventListener(paramzzgv);
          return;
        }
        catch (RemoteException|BadParcelableException|IllegalArgumentException|IllegalStateException|NetworkOnMainThreadException|NullPointerException|SecurityException|UnsupportedOperationException localRemoteException)
        {
          Log.w(this.zzd, "Failed to unregister event listener on calling thread. Trying again on the dynamite thread.");
        }
      }
      zzS(new zzdq(this, paramzzgv));
      return;
    }
    finally {}
  }
  
  public final void zzg(@NonNull String paramString, Bundle paramBundle)
  {
    zzU(null, paramString, paramBundle, false, true, null);
  }
  
  public final void zzh(String paramString1, String paramString2, Bundle paramBundle)
  {
    zzU(paramString1, paramString2, paramBundle, true, true, null);
  }
  
  public final void zzi(String paramString1, String paramString2, Bundle paramBundle, long paramLong)
  {
    zzU(paramString1, paramString2, paramBundle, true, false, Long.valueOf(paramLong));
  }
  
  public final void zzj(String paramString1, String paramString2, Object paramObject, boolean paramBoolean)
  {
    zzS(new zzds(this, paramString1, paramString2, paramObject, paramBoolean));
  }
  
  public final void zzk(Bundle paramBundle)
  {
    zzS(new zzcn(this, paramBundle));
  }
  
  public final void zzl(String paramString1, String paramString2, Bundle paramBundle)
  {
    zzS(new zzco(this, paramString1, paramString2, paramBundle));
  }
  
  public final List<Bundle> zzm(String paramString1, String paramString2)
  {
    zzbz localzzbz = new zzbz();
    zzS(new zzcp(this, paramString1, paramString2, localzzbz));
    paramString2 = (List)zzbz.zze(localzzbz.zzd(5000L), List.class);
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = Collections.emptyList();
    }
    return paramString1;
  }
  
  public final void zzn(String paramString)
  {
    zzS(new zzcq(this, paramString));
  }
  
  public final void zzo(Activity paramActivity, String paramString1, String paramString2)
  {
    zzS(new zzcr(this, paramActivity, paramString1, paramString2));
  }
  
  public final void zzp(Boolean paramBoolean)
  {
    zzS(new zzcs(this, paramBoolean));
  }
  
  public final void zzq(Bundle paramBundle)
  {
    zzS(new zzct(this, paramBundle));
  }
  
  public final void zzr(Bundle paramBundle)
  {
    zzS(new zzcu(this, paramBundle));
  }
  
  public final void zzs()
  {
    zzS(new zzcv(this));
  }
  
  public final void zzt(long paramLong)
  {
    zzS(new zzcw(this, paramLong));
  }
  
  public final void zzu(String paramString)
  {
    zzS(new zzcy(this, paramString));
  }
  
  public final void zzv(String paramString)
  {
    zzS(new zzcz(this, paramString));
  }
  
  public final String zzw()
  {
    zzbz localzzbz = new zzbz();
    zzS(new zzda(this, localzzbz));
    return localzzbz.zzc(500L);
  }
  
  public final String zzx()
  {
    zzbz localzzbz = new zzbz();
    zzS(new zzdb(this, localzzbz));
    return localzzbz.zzc(50L);
  }
  
  public final long zzy()
  {
    Object localObject = new zzbz();
    zzS(new zzdc(this, (zzbz)localObject));
    localObject = (Long)zzbz.zze(((zzbz)localObject).zzd(500L), Long.class);
    long l;
    if (localObject == null)
    {
      l = new Random(System.nanoTime() ^ this.zza.currentTimeMillis()).nextLong();
      int i = this.zzg + 1;
      this.zzg = i;
      l += i;
    }
    else
    {
      l = ((Long)localObject).longValue();
    }
    return l;
  }
  
  public final String zzz()
  {
    zzbz localzzbz = new zzbz();
    zzS(new zzdd(this, localzzbz));
    return localzzbz.zzc(500L);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzee.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */