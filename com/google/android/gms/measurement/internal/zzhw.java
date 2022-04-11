package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzoa;
import com.google.android.gms.internal.measurement.zzom;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class zzhw
  extends zzf
{
  @VisibleForTesting
  protected zzhv zza;
  final zzr zzb;
  @VisibleForTesting
  protected boolean zzc = true;
  private zzgu zzd;
  private final Set<zzgv> zze = new CopyOnWriteArraySet();
  private boolean zzf;
  private final AtomicReference<String> zzg = new AtomicReference();
  private final Object zzh = new Object();
  @GuardedBy("consentLock")
  private zzaf zzi = new zzaf(null, null);
  @GuardedBy("consentLock")
  private int zzj = 100;
  private final AtomicLong zzk = new AtomicLong(0L);
  private long zzl = -1L;
  private int zzm = 100;
  private final zzkt zzn = new zzhl(this);
  
  protected zzhw(zzfu paramzzfu)
  {
    super(paramzzfu);
    this.zzb = new zzr(paramzzfu);
  }
  
  @WorkerThread
  private final void zzY(Boolean paramBoolean, boolean paramBoolean1)
  {
    zzg();
    zzb();
    this.zzs.zzau().zzj().zzb("Setting app measurement enabled (FE)", paramBoolean);
    this.zzs.zzd().zze(paramBoolean);
    if (paramBoolean1)
    {
      Object localObject = this.zzs.zzd();
      zzfu localzzfu = ((zzgn)localObject).zzs;
      ((zzgn)localObject).zzg();
      localObject = ((zzfb)localObject).zzd().edit();
      if (paramBoolean != null) {
        ((SharedPreferences.Editor)localObject).putBoolean("measurement_enabled_from_api", paramBoolean.booleanValue());
      } else {
        ((SharedPreferences.Editor)localObject).remove("measurement_enabled_from_api");
      }
      ((SharedPreferences.Editor)localObject).apply();
    }
    if ((!this.zzs.zzI()) && ((paramBoolean == null) || (paramBoolean.booleanValue()))) {
      return;
    }
    zzZ();
  }
  
  @WorkerThread
  private final void zzZ()
  {
    zzg();
    String str = this.zzs.zzd().zzh.zza();
    if (str != null) {
      if ("unset".equals(str))
      {
        zzB("app", "_npa", null, this.zzs.zzay().currentTimeMillis());
      }
      else
      {
        long l;
        if (true != "true".equals(str)) {
          l = 0L;
        } else {
          l = 1L;
        }
        zzB("app", "_npa", Long.valueOf(l), this.zzs.zzay().currentTimeMillis());
      }
    }
    if ((this.zzs.zzF()) && (this.zzc))
    {
      this.zzs.zzau().zzj().zza("Recording app launch after enabling measurement for the first time (FE)");
      zzH();
      zzom.zzb();
      if (this.zzs.zzc().zzn(null, zzea.zzan)) {
        this.zzs.zzh().zza.zza();
      }
      this.zzs.zzav().zzh(new zzha(this));
      return;
    }
    this.zzs.zzau().zzj().zza("Updating Scion state (FE)");
    this.zzs.zzy().zzi();
  }
  
  final void zzA(String paramString1, String paramString2, long paramLong, Object paramObject)
  {
    this.zzs.zzav().zzh(new zzhd(this, paramString1, paramString2, paramObject, paramLong));
  }
  
  @WorkerThread
  final void zzB(String paramString1, String paramString2, Object paramObject, long paramLong)
  {
    Preconditions.checkNotEmpty(paramString1);
    Preconditions.checkNotEmpty(paramString2);
    zzg();
    zzb();
    if ("allow_personalized_ads".equals(paramString2))
    {
      if ((paramObject instanceof String))
      {
        Object localObject = (String)paramObject;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          paramObject = ((String)localObject).toLowerCase(Locale.ENGLISH);
          paramString2 = "false";
          long l;
          if (true != "false".equals(paramObject)) {
            l = 0L;
          } else {
            l = 1L;
          }
          paramObject = Long.valueOf(l);
          localObject = this.zzs.zzd().zzh;
          if (((Long)paramObject).longValue() == 1L) {
            paramString2 = "true";
          }
          ((zzfa)localObject).zzb(paramString2);
          break label141;
        }
      }
      if (paramObject == null)
      {
        this.zzs.zzd().zzh.zzb("unset");
        label141:
        paramString2 = "_npa";
      }
    }
    if (!this.zzs.zzF())
    {
      this.zzs.zzau().zzk().zza("User property not set since app measurement is disabled");
      return;
    }
    if (!this.zzs.zzL()) {
      return;
    }
    paramString1 = new zzkq(paramString2, paramLong, paramObject, paramString1);
    this.zzs.zzy().zzs(paramString1);
  }
  
  public final List<zzkq> zzC(boolean paramBoolean)
  {
    zzb();
    this.zzs.zzau().zzk().zza("Getting user properties (FE)");
    if (!this.zzs.zzav().zzd())
    {
      this.zzs.zzat();
      if (zzz.zza())
      {
        this.zzs.zzau().zzb().zza("Cannot get all user properties from main thread");
        return Collections.emptyList();
      }
      Object localObject = new AtomicReference();
      this.zzs.zzav().zzi((AtomicReference)localObject, 5000L, "get user properties", new zzhe(this, (AtomicReference)localObject, paramBoolean));
      localObject = (List)((AtomicReference)localObject).get();
      if (localObject == null)
      {
        this.zzs.zzau().zzb().zzb("Timed out waiting for get user properties, includeInternal", Boolean.valueOf(paramBoolean));
        return Collections.emptyList();
      }
      return (List<zzkq>)localObject;
    }
    this.zzs.zzau().zzb().zza("Cannot get all user properties from analytics worker thread");
    return Collections.emptyList();
  }
  
  public final String zzD()
  {
    return (String)this.zzg.get();
  }
  
  final void zzE(String paramString)
  {
    this.zzg.set(paramString);
  }
  
  public final void zzF(long paramLong)
  {
    this.zzg.set(null);
    this.zzs.zzav().zzh(new zzhf(this, paramLong));
  }
  
  final void zzG(long paramLong, boolean paramBoolean)
  {
    zzg();
    zzb();
    this.zzs.zzau().zzj().zza("Resetting analytics data (FE)");
    Object localObject = this.zzs.zzh();
    ((zzgn)localObject).zzg();
    ((zzjz)localObject).zzb.zzc();
    boolean bool = this.zzs.zzF();
    zzfb localzzfb = this.zzs.zzd();
    localzzfb.zzc.zzb(paramLong);
    if (!TextUtils.isEmpty(localzzfb.zzs.zzd().zzo.zza())) {
      localzzfb.zzo.zzb(null);
    }
    zzom.zzb();
    zzae localzzae = localzzfb.zzs.zzc();
    localObject = zzea.zzan;
    if (localzzae.zzn(null, (zzdz)localObject)) {
      localzzfb.zzj.zzb(0L);
    }
    if (!localzzfb.zzs.zzc().zzr()) {
      localzzfb.zzj(bool ^ true);
    }
    localzzfb.zzp.zzb(null);
    localzzfb.zzq.zzb(0L);
    localzzfb.zzr.zzb(null);
    if (paramBoolean) {
      this.zzs.zzy().zzu();
    }
    zzom.zzb();
    if (this.zzs.zzc().zzn(null, (zzdz)localObject)) {
      this.zzs.zzh().zza.zza();
    }
    this.zzc = (bool ^ true);
  }
  
  @WorkerThread
  public final void zzH()
  {
    zzg();
    zzb();
    if (this.zzs.zzL())
    {
      if (this.zzs.zzc().zzn(null, zzea.zzaa))
      {
        localObject1 = this.zzs.zzc();
        ((zzgn)localObject1).zzs.zzat();
        localObject1 = ((zzae)localObject1).zzp("google_analytics_deferred_deep_link_enabled");
        if ((localObject1 != null) && (((Boolean)localObject1).booleanValue()))
        {
          this.zzs.zzau().zzj().zza("Deferred Deep Link feature enabled.");
          this.zzs.zzav().zzh(new zzgy(this));
        }
      }
      this.zzs.zzy().zzy();
      this.zzc = false;
      Object localObject2 = this.zzs.zzd();
      ((zzgn)localObject2).zzg();
      Object localObject1 = ((zzfb)localObject2).zzd().getString("previous_os_version", null);
      ((zzgn)localObject2).zzs.zzz().zzv();
      Object localObject3 = Build.VERSION.RELEASE;
      if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!((String)localObject3).equals(localObject1)))
      {
        localObject2 = ((zzfb)localObject2).zzd().edit();
        ((SharedPreferences.Editor)localObject2).putString("previous_os_version", (String)localObject3);
        ((SharedPreferences.Editor)localObject2).apply();
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        this.zzs.zzz().zzv();
        if (!((String)localObject1).equals(localObject3))
        {
          localObject3 = new Bundle();
          ((Bundle)localObject3).putString("_po", (String)localObject1);
          zzs("auto", "_ou", (Bundle)localObject3);
        }
      }
    }
  }
  
  @WorkerThread
  public final void zzI(zzgu paramzzgu)
  {
    zzg();
    zzb();
    if (paramzzgu != null)
    {
      zzgu localzzgu = this.zzd;
      if (paramzzgu != localzzgu)
      {
        boolean bool;
        if (localzzgu == null) {
          bool = true;
        } else {
          bool = false;
        }
        Preconditions.checkState(bool, "EventInterceptor already set.");
      }
    }
    this.zzd = paramzzgu;
  }
  
  public final void zzJ(zzgv paramzzgv)
  {
    zzb();
    Preconditions.checkNotNull(paramzzgv);
    if (!this.zze.add(paramzzgv)) {
      this.zzs.zzau().zze().zza("OnEventListener already registered");
    }
  }
  
  public final void zzK(zzgv paramzzgv)
  {
    zzb();
    Preconditions.checkNotNull(paramzzgv);
    if (!this.zze.remove(paramzzgv)) {
      this.zzs.zzau().zze().zza("OnEventListener had not been registered");
    }
  }
  
  public final int zzL(String paramString)
  {
    Preconditions.checkNotEmpty(paramString);
    this.zzs.zzc();
    return 25;
  }
  
  public final void zzM(Bundle paramBundle)
  {
    zzN(paramBundle, this.zzs.zzay().currentTimeMillis());
  }
  
  public final void zzN(Bundle paramBundle, long paramLong)
  {
    Preconditions.checkNotNull(paramBundle);
    paramBundle = new Bundle(paramBundle);
    if (!TextUtils.isEmpty(paramBundle.getString("app_id"))) {
      this.zzs.zzau().zze().zza("Package name should be null when calling setConditionalUserProperty");
    }
    paramBundle.remove("app_id");
    Preconditions.checkNotNull(paramBundle);
    zzgq.zzb(paramBundle, "app_id", String.class, null);
    zzgq.zzb(paramBundle, "origin", String.class, null);
    zzgq.zzb(paramBundle, "name", String.class, null);
    zzgq.zzb(paramBundle, "value", Object.class, null);
    zzgq.zzb(paramBundle, "trigger_event_name", String.class, null);
    Object localObject1 = Long.valueOf(0L);
    zzgq.zzb(paramBundle, "trigger_timeout", Long.class, localObject1);
    zzgq.zzb(paramBundle, "timed_out_event_name", String.class, null);
    zzgq.zzb(paramBundle, "timed_out_event_params", Bundle.class, null);
    zzgq.zzb(paramBundle, "triggered_event_name", String.class, null);
    zzgq.zzb(paramBundle, "triggered_event_params", Bundle.class, null);
    zzgq.zzb(paramBundle, "time_to_live", Long.class, localObject1);
    zzgq.zzb(paramBundle, "expired_event_name", String.class, null);
    zzgq.zzb(paramBundle, "expired_event_params", Bundle.class, null);
    Preconditions.checkNotEmpty(paramBundle.getString("name"));
    Preconditions.checkNotEmpty(paramBundle.getString("origin"));
    Preconditions.checkNotNull(paramBundle.get("value"));
    paramBundle.putLong("creation_timestamp", paramLong);
    localObject1 = paramBundle.getString("name");
    Object localObject2 = paramBundle.get("value");
    if (this.zzs.zzl().zzo((String)localObject1) == 0)
    {
      if (this.zzs.zzl().zzJ((String)localObject1, localObject2) == 0)
      {
        Object localObject3 = this.zzs.zzl().zzK((String)localObject1, localObject2);
        if (localObject3 == null)
        {
          this.zzs.zzau().zzb().zzc("Unable to normalize conditional user property value", this.zzs.zzm().zze((String)localObject1), localObject2);
          return;
        }
        zzgq.zza(paramBundle, localObject3);
        paramLong = paramBundle.getLong("trigger_timeout");
        if (!TextUtils.isEmpty(paramBundle.getString("trigger_event_name")))
        {
          this.zzs.zzc();
          if ((paramLong > 15552000000L) || (paramLong < 1L))
          {
            this.zzs.zzau().zzb().zzc("Invalid conditional user property timeout", this.zzs.zzm().zze((String)localObject1), Long.valueOf(paramLong));
            return;
          }
        }
        paramLong = paramBundle.getLong("time_to_live");
        this.zzs.zzc();
        if ((paramLong <= 15552000000L) && (paramLong >= 1L))
        {
          this.zzs.zzav().zzh(new zzhg(this, paramBundle));
          return;
        }
        this.zzs.zzau().zzb().zzc("Invalid conditional user property time to live", this.zzs.zzm().zze((String)localObject1), Long.valueOf(paramLong));
        return;
      }
      this.zzs.zzau().zzb().zzc("Invalid conditional user property value", this.zzs.zzm().zze((String)localObject1), localObject2);
      return;
    }
    this.zzs.zzau().zzb().zzb("Invalid conditional user property name", this.zzs.zzm().zze((String)localObject1));
  }
  
  public final void zzO(String paramString1, String paramString2, Bundle paramBundle)
  {
    long l = this.zzs.zzay().currentTimeMillis();
    Preconditions.checkNotEmpty(paramString1);
    Bundle localBundle = new Bundle();
    localBundle.putString("name", paramString1);
    localBundle.putLong("creation_timestamp", l);
    if (paramString2 != null)
    {
      localBundle.putString("expired_event_name", paramString2);
      localBundle.putBundle("expired_event_params", paramBundle);
    }
    this.zzs.zzav().zzh(new zzhh(this, localBundle));
  }
  
  public final ArrayList<Bundle> zzP(String paramString1, String paramString2)
  {
    if (this.zzs.zzav().zzd())
    {
      this.zzs.zzau().zzb().zza("Cannot get conditional user properties from analytics worker thread");
      paramString1 = new ArrayList(0);
    }
    else
    {
      this.zzs.zzat();
      if (zzz.zza())
      {
        this.zzs.zzau().zzb().zza("Cannot get conditional user properties from main thread");
        paramString1 = new ArrayList(0);
      }
      else
      {
        AtomicReference localAtomicReference = new AtomicReference();
        this.zzs.zzav().zzi(localAtomicReference, 5000L, "get conditional user properties", new zzhj(this, localAtomicReference, null, paramString1, paramString2));
        paramString1 = (List)localAtomicReference.get();
        if (paramString1 == null)
        {
          this.zzs.zzau().zzb().zzb("Timed out waiting for get conditional user properties", null);
          paramString1 = new ArrayList();
        }
        else
        {
          paramString1 = zzku.zzak(paramString1);
        }
      }
    }
    return paramString1;
  }
  
  public final Map<String, Object> zzQ(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (this.zzs.zzav().zzd())
    {
      this.zzs.zzau().zzb().zza("Cannot get user properties from analytics worker thread");
      paramString1 = Collections.emptyMap();
    }
    else
    {
      this.zzs.zzat();
      if (zzz.zza())
      {
        this.zzs.zzau().zzb().zza("Cannot get user properties from main thread");
        paramString1 = Collections.emptyMap();
      }
      else
      {
        Object localObject = new AtomicReference();
        this.zzs.zzav().zzi((AtomicReference)localObject, 5000L, "get user properties", new zzhk(this, (AtomicReference)localObject, null, paramString1, paramString2, paramBoolean));
        paramString2 = (List)((AtomicReference)localObject).get();
        if (paramString2 == null)
        {
          this.zzs.zzau().zzb().zzb("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(paramBoolean));
          paramString1 = Collections.emptyMap();
        }
        else
        {
          paramString1 = new ArrayMap(paramString2.size());
          Iterator localIterator = paramString2.iterator();
          while (localIterator.hasNext())
          {
            paramString2 = (zzkq)localIterator.next();
            localObject = paramString2.zza();
            if (localObject != null) {
              paramString1.put(paramString2.zzb, localObject);
            }
          }
        }
      }
    }
    return paramString1;
  }
  
  public final String zzR()
  {
    zzid localzzid = this.zzs.zzx().zzl();
    if (localzzid != null) {
      return localzzid.zza;
    }
    return null;
  }
  
  public final String zzS()
  {
    zzid localzzid = this.zzs.zzx().zzl();
    if (localzzid != null) {
      return localzzid.zzb;
    }
    return null;
  }
  
  public final String zzT()
  {
    if (this.zzs.zzr() == null) {
      try
      {
        String str = zzic.zza(this.zzs.zzax(), "google_app_id", this.zzs.zzv());
        return str;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        this.zzs.zzau().zzb().zzb("getGoogleAppId failed with exception", localIllegalStateException);
        return null;
      }
    }
    return this.zzs.zzr();
  }
  
  protected final boolean zze()
  {
    return false;
  }
  
  public final void zzh()
  {
    if (((this.zzs.zzax().getApplicationContext() instanceof Application)) && (this.zza != null)) {
      ((Application)this.zzs.zzax().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.zza);
    }
  }
  
  public final Boolean zzi()
  {
    AtomicReference localAtomicReference = new AtomicReference();
    return (Boolean)this.zzs.zzav().zzi(localAtomicReference, 15000L, "boolean test flag value", new zzhi(this, localAtomicReference));
  }
  
  public final String zzj()
  {
    AtomicReference localAtomicReference = new AtomicReference();
    return (String)this.zzs.zzav().zzi(localAtomicReference, 15000L, "String test flag value", new zzhm(this, localAtomicReference));
  }
  
  public final Long zzk()
  {
    AtomicReference localAtomicReference = new AtomicReference();
    return (Long)this.zzs.zzav().zzi(localAtomicReference, 15000L, "long test flag value", new zzhn(this, localAtomicReference));
  }
  
  public final Integer zzl()
  {
    AtomicReference localAtomicReference = new AtomicReference();
    return (Integer)this.zzs.zzav().zzi(localAtomicReference, 15000L, "int test flag value", new zzho(this, localAtomicReference));
  }
  
  public final Double zzm()
  {
    AtomicReference localAtomicReference = new AtomicReference();
    return (Double)this.zzs.zzav().zzi(localAtomicReference, 15000L, "double test flag value", new zzhp(this, localAtomicReference));
  }
  
  public final void zzn(Boolean paramBoolean)
  {
    zzb();
    this.zzs.zzav().zzh(new zzhq(this, paramBoolean));
  }
  
  public final void zzo(Bundle paramBundle, int paramInt, long paramLong)
  {
    zzb();
    String str = zzaf.zza(paramBundle);
    if (str != null)
    {
      this.zzs.zzau().zzh().zzb("Ignoring invalid consent setting", str);
      this.zzs.zzau().zzh().zza("Valid consent values are 'granted', 'denied'");
    }
    zzq(zzaf.zzb(paramBundle), paramInt, paramLong);
  }
  
  public final void zzq(zzaf paramzzaf, int paramInt, long paramLong)
  {
    zzb();
    if ((paramInt != -10) && (paramzzaf.zze() == null) && (paramzzaf.zzg() == null))
    {
      this.zzs.zzau().zzh().zza("Discarding empty consent settings");
      return;
    }
    synchronized (this.zzh)
    {
      boolean bool1 = zzaf.zzm(paramInt, this.zzj);
      int i = 1;
      boolean bool2 = false;
      boolean bool3 = false;
      if (bool1)
      {
        bool2 = paramzzaf.zzi(this.zzi);
        bool1 = bool3;
        if (paramzzaf.zzh())
        {
          bool1 = bool3;
          if (!this.zzi.zzh()) {
            bool1 = true;
          }
        }
        paramzzaf = paramzzaf.zzl(this.zzi);
        this.zzi = paramzzaf;
        this.zzj = paramInt;
      }
      else
      {
        bool1 = false;
        i = 0;
      }
      if (i == 0)
      {
        this.zzs.zzau().zzi().zzb("Ignoring lower-priority consent settings, proposed settings", paramzzaf);
        return;
      }
      long l = this.zzk.getAndIncrement();
      if (bool2)
      {
        this.zzg.set(null);
        this.zzs.zzav().zzj(new zzhr(this, paramzzaf, paramLong, paramInt, l, bool1));
        return;
      }
      if ((paramInt != 30) && (paramInt != -10))
      {
        this.zzs.zzav().zzh(new zzht(this, paramzzaf, paramInt, l, bool1));
        return;
      }
      this.zzs.zzav().zzj(new zzhs(this, paramzzaf, paramInt, l, bool1));
      return;
    }
  }
  
  @WorkerThread
  final void zzr(zzaf paramzzaf)
  {
    zzg();
    boolean bool;
    if (((paramzzaf.zzh()) && (paramzzaf.zzf())) || (this.zzs.zzy().zzH())) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool != this.zzs.zzI())
    {
      this.zzs.zzH(bool);
      paramzzaf = this.zzs.zzd();
      zzfu localzzfu = paramzzaf.zzs;
      paramzzaf.zzg();
      if (paramzzaf.zzd().contains("measurement_enabled_from_api")) {
        paramzzaf = Boolean.valueOf(paramzzaf.zzd().getBoolean("measurement_enabled_from_api", true));
      } else {
        paramzzaf = null;
      }
      if ((!bool) || (paramzzaf == null) || (paramzzaf.booleanValue())) {
        zzY(Boolean.valueOf(bool), false);
      }
    }
  }
  
  public final void zzs(String paramString1, String paramString2, Bundle paramBundle)
  {
    zzv(paramString1, paramString2, paramBundle, true, true, this.zzs.zzay().currentTimeMillis());
  }
  
  @WorkerThread
  final void zzt(String paramString1, String paramString2, long paramLong, Bundle paramBundle)
  {
    zzg();
    boolean bool;
    if ((this.zzd != null) && (!zzku.zzR(paramString2))) {
      bool = false;
    } else {
      bool = true;
    }
    zzu(paramString1, paramString2, paramLong, paramBundle, true, bool, false, null);
  }
  
  @WorkerThread
  protected final void zzu(String paramString1, String paramString2, long paramLong, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString3)
  {
    Preconditions.checkNotEmpty(paramString1);
    Preconditions.checkNotNull(paramBundle);
    zzg();
    zzb();
    if (this.zzs.zzF())
    {
      Object localObject1 = this.zzs.zzA().zzo();
      if ((localObject1 != null) && (!((List)localObject1).contains(paramString2)))
      {
        this.zzs.zzau().zzj().zzc("Dropping non-safelisted event. event name, origin", paramString2, paramString1);
        return;
      }
      boolean bool1 = this.zzf;
      int i = 0;
      int j = 0;
      if (!bool1)
      {
        this.zzf = true;
        try
        {
          if (!this.zzs.zzu()) {
            localObject1 = Class.forName("com.google.android.gms.tagmanager.TagManagerService", true, this.zzs.zzax().getClassLoader());
          } else {
            localObject1 = Class.forName("com.google.android.gms.tagmanager.TagManagerService");
          }
          try
          {
            ((Class)localObject1).getDeclaredMethod("initialize", new Class[] { Context.class }).invoke(null, new Object[] { this.zzs.zzax() });
          }
          catch (Exception localException)
          {
            this.zzs.zzau().zze().zzb("Failed to invoke Tag Manager's initialize() method", localException);
          }
          if (!this.zzs.zzc().zzn(null, zzea.zzab)) {
            break label298;
          }
        }
        catch (ClassNotFoundException localClassNotFoundException)
        {
          this.zzs.zzau().zzi().zza("Tag Manager is not found and thus will not be used");
        }
      }
      if (("_cmp".equals(paramString2)) && (paramBundle.containsKey("gclid")))
      {
        this.zzs.zzat();
        zzB("auto", "_lgclid", paramBundle.getString("gclid"), this.zzs.zzay().currentTimeMillis());
      }
      label298:
      this.zzs.zzat();
      if ((paramBoolean1) && (zzku.zzY(paramString2))) {
        this.zzs.zzl().zzH(paramBundle, this.zzs.zzd().zzr.zza());
      }
      int k;
      if (paramBoolean3)
      {
        this.zzs.zzat();
        if (!"_iap".equals(paramString2))
        {
          localObject2 = this.zzs.zzl();
          bool1 = ((zzku)localObject2).zzj("event", paramString2);
          k = 2;
          if (bool1) {
            if (!((zzku)localObject2).zzl("event", zzgr.zza, zzgr.zzb, paramString2))
            {
              k = 13;
            }
            else
            {
              ((zzgn)localObject2).zzs.zzc();
              if (((zzku)localObject2).zzm("event", 40, paramString2)) {
                k = 0;
              }
            }
          }
          if (k != 0)
          {
            this.zzs.zzau().zzd().zzb("Invalid public event name. Event will not be logged (FE)", this.zzs.zzm().zzc(paramString2));
            paramString1 = this.zzs.zzl();
            this.zzs.zzc();
            paramString1 = paramString1.zzC(paramString2, 40, true);
            i = j;
            if (paramString2 != null) {
              i = paramString2.length();
            }
            this.zzs.zzl().zzM(this.zzn, null, k, "_ev", paramString1, i, this.zzs.zzc().zzn(null, zzea.zzaw));
            return;
          }
        }
      }
      this.zzs.zzat();
      Object localObject2 = this.zzs.zzx().zzh(false);
      if ((localObject2 != null) && (!paramBundle.containsKey("_sc"))) {
        ((zzid)localObject2).zzd = true;
      }
      if ((paramBoolean1) && (paramBoolean3)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      zzik.zzm((zzid)localObject2, paramBundle, bool1);
      bool1 = "am".equals(paramString1);
      boolean bool2 = zzku.zzR(paramString2);
      if ((paramBoolean1) && (this.zzd != null) && (!bool2))
      {
        if (bool1)
        {
          paramBoolean1 = true;
        }
        else
        {
          this.zzs.zzau().zzj().zzc("Passing event to registered event handler (FE)", this.zzs.zzm().zzc(paramString2), this.zzs.zzm().zzf(paramBundle));
          Preconditions.checkNotNull(this.zzd);
          this.zzd.interceptEvent(paramString1, paramString2, paramBundle, paramLong);
        }
      }
      else {
        paramBoolean1 = bool1;
      }
      if (this.zzs.zzL())
      {
        j = this.zzs.zzl().zzn(paramString2);
        if (j != 0)
        {
          this.zzs.zzau().zzd().zzb("Invalid event name. Event will not be logged (FE)", this.zzs.zzm().zzc(paramString2));
          paramString1 = this.zzs.zzl();
          this.zzs.zzc();
          paramString1 = paramString1.zzC(paramString2, 40, true);
          k = i;
          if (paramString2 != null) {
            k = paramString2.length();
          }
          this.zzs.zzl().zzM(this.zzn, paramString3, j, "_ev", paramString1, k, this.zzs.zzc().zzn(null, zzea.zzaw));
          return;
        }
        Object localObject3 = "_o";
        localObject2 = CollectionUtils.listOf(new String[] { "_o", "_sn", "_sc", "_si" });
        Object localObject4 = this.zzs.zzl().zzF(paramString3, paramString2, paramBundle, (List)localObject2, paramBoolean3);
        Preconditions.checkNotNull(localObject4);
        if ((((Bundle)localObject4).containsKey("_sc")) && (((Bundle)localObject4).containsKey("_si"))) {
          new zzid(((Bundle)localObject4).getString("_sn"), ((Bundle)localObject4).getString("_sc"), ((Bundle)localObject4).getLong("_si"));
        }
        this.zzs.zzat();
        if ((this.zzs.zzx().zzh(false) != null) && ("_ae".equals(paramString2)))
        {
          paramBundle = this.zzs.zzh().zzb;
          long l1 = paramBundle.zzc.zzs.zzay().elapsedRealtime();
          long l2 = l1 - paramBundle.zzb;
          paramBundle.zzb = l1;
          if (l2 > 0L) {
            this.zzs.zzl().zzac((Bundle)localObject4, l2);
          }
        }
        zzoa.zzb();
        Object localObject5;
        if (this.zzs.zzc().zzn(null, zzea.zzam)) {
          if ((!"auto".equals(paramString1)) && ("_ssr".equals(paramString2)))
          {
            localObject5 = this.zzs.zzl();
            localObject2 = ((Bundle)localObject4).getString("_ffr");
            if (Strings.isEmptyOrWhitespace((String)localObject2))
            {
              paramBundle = null;
            }
            else
            {
              paramBundle = (Bundle)localObject2;
              if (localObject2 != null) {
                paramBundle = ((String)localObject2).trim();
              }
            }
            if (!zzku.zzS(paramBundle, ((zzgn)localObject5).zzs.zzd().zzo.zza())) {
              ((zzgn)localObject5).zzs.zzd().zzo.zzb(paramBundle);
            } else {
              ((zzgn)localObject5).zzs.zzau().zzj().zza("Not logging duplicate session_start_with_rollout event");
            }
          }
          else if ("_ae".equals(paramString2))
          {
            paramBundle = this.zzs.zzl().zzs.zzd().zzo.zza();
            if (!TextUtils.isEmpty(paramBundle)) {
              ((Bundle)localObject4).putString("_ffr", paramBundle);
            }
          }
        }
        localObject2 = new ArrayList();
        ((List)localObject2).add(localObject4);
        if ((this.zzs.zzd().zzj.zza() > 0L) && (this.zzs.zzd().zzl(paramLong)) && (this.zzs.zzd().zzl.zza()))
        {
          this.zzs.zzau().zzk().zza("Current session is expired, remove the session number, ID, and engagement time");
          zzB("auto", "_sid", null, this.zzs.zzay().currentTimeMillis());
          zzB("auto", "_sno", null, this.zzs.zzay().currentTimeMillis());
          zzB("auto", "_se", null, this.zzs.zzay().currentTimeMillis());
        }
        if (((Bundle)localObject4).getLong("extend_session", 0L) == 1L)
        {
          this.zzs.zzau().zzk().zza("EXTEND_SESSION param attached: initiate a new session or extend the current active session");
          this.zzs.zzh().zza.zzb(paramLong, true);
        }
        ArrayList localArrayList = new ArrayList(((Bundle)localObject4).keySet());
        Collections.sort(localArrayList);
        i = localArrayList.size();
        for (k = 0; k < i; k++)
        {
          localObject5 = (String)localArrayList.get(k);
          if (localObject5 != null)
          {
            this.zzs.zzl();
            Object localObject6 = ((Bundle)localObject4).get((String)localObject5);
            if ((localObject6 instanceof Bundle))
            {
              paramBundle = new Bundle[1];
              paramBundle[0] = ((Bundle)localObject6);
            }
            else if ((localObject6 instanceof Parcelable[]))
            {
              paramBundle = (Parcelable[])localObject6;
              paramBundle = (Bundle[])Arrays.copyOf(paramBundle, paramBundle.length, Bundle[].class);
            }
            else if ((localObject6 instanceof ArrayList))
            {
              paramBundle = (ArrayList)localObject6;
              paramBundle = (Bundle[])paramBundle.toArray(new Bundle[paramBundle.size()]);
            }
            else
            {
              paramBundle = null;
            }
            if (paramBundle != null) {
              ((Bundle)localObject4).putParcelableArray((String)localObject5, paramBundle);
            }
          }
        }
        k = 0;
        paramBundle = (Bundle)localObject3;
        while (k < ((List)localObject2).size())
        {
          localObject5 = (Bundle)((List)localObject2).get(k);
          if (k != 0) {
            localObject4 = "_ep";
          } else {
            localObject4 = paramString2;
          }
          ((Bundle)localObject5).putString(paramBundle, paramString1);
          localObject3 = localObject5;
          if (paramBoolean2) {
            localObject3 = this.zzs.zzl().zzU((Bundle)localObject5);
          }
          localObject4 = new zzas((String)localObject4, new zzaq((Bundle)localObject3), paramString1, paramLong);
          this.zzs.zzy().zzl((zzas)localObject4, paramString3);
          if (!paramBoolean1)
          {
            localObject4 = this.zze.iterator();
            while (((Iterator)localObject4).hasNext()) {
              ((zzgv)((Iterator)localObject4).next()).onEvent(paramString1, paramString2, new Bundle((Bundle)localObject3), paramLong);
            }
          }
          k++;
        }
        this.zzs.zzat();
        if ((this.zzs.zzx().zzh(false) != null) && ("_ae".equals(paramString2)))
        {
          paramString1 = this.zzs.zzh();
          paramLong = this.zzs.zzay().elapsedRealtime();
          paramString1.zzb.zzd(true, true, paramLong);
        }
      }
      return;
    }
    this.zzs.zzau().zzj().zza("Event not sent since app measurement is disabled");
  }
  
  public final void zzv(String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    if (paramString1 == null) {
      paramString1 = "app";
    }
    if (paramBundle == null) {
      paramBundle = new Bundle();
    }
    if ((this.zzs.zzc().zzn(null, zzea.zzar)) && (zzku.zzS(paramString2, "screen_view")))
    {
      this.zzs.zzx().zzj(paramBundle, paramLong);
      return;
    }
    boolean bool;
    if ((paramBoolean2) && (this.zzd != null) && (!zzku.zzR(paramString2))) {
      bool = false;
    } else {
      bool = true;
    }
    zzx(paramString1, paramString2, paramLong, paramBundle, paramBoolean2, bool, paramBoolean1 ^ true, null);
  }
  
  protected final void zzx(String paramString1, String paramString2, long paramLong, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString3)
  {
    Bundle localBundle = new Bundle(paramBundle);
    paramBundle = localBundle.keySet().iterator();
    while (paramBundle.hasNext())
    {
      Object localObject1 = (String)paramBundle.next();
      Object localObject2 = localBundle.get((String)localObject1);
      if ((localObject2 instanceof Bundle))
      {
        localBundle.putBundle((String)localObject1, new Bundle((Bundle)localObject2));
      }
      else
      {
        boolean bool = localObject2 instanceof Parcelable[];
        int i = 0;
        int j = 0;
        if (bool)
        {
          localObject2 = (Parcelable[])localObject2;
          while (j < localObject2.length)
          {
            localObject1 = localObject2[j];
            if ((localObject1 instanceof Bundle)) {
              localObject2[j] = new Bundle((Bundle)localObject1);
            }
            j++;
          }
        }
        else if ((localObject2 instanceof List))
        {
          localObject1 = (List)localObject2;
          for (j = i; j < ((List)localObject1).size(); j++)
          {
            localObject2 = ((List)localObject1).get(j);
            if ((localObject2 instanceof Bundle)) {
              ((List)localObject1).set(j, new Bundle((Bundle)localObject2));
            }
          }
        }
      }
    }
    this.zzs.zzav().zzh(new zzhc(this, paramString1, paramString2, paramLong, localBundle, paramBoolean1, paramBoolean2, paramBoolean3, paramString3));
  }
  
  public final void zzy(String paramString1, String paramString2, Object paramObject, boolean paramBoolean)
  {
    zzz("auto", paramString2, paramObject, true, this.zzs.zzay().currentTimeMillis());
  }
  
  public final void zzz(String paramString1, String paramString2, Object paramObject, boolean paramBoolean, long paramLong)
  {
    if (paramString1 == null) {
      paramString1 = "app";
    }
    int i;
    if (paramBoolean)
    {
      i = this.zzs.zzl().zzo(paramString2);
    }
    else
    {
      zzku localzzku = this.zzs.zzl();
      if (!localzzku.zzj("user property", paramString2)) {}
      do
      {
        i = 6;
        break;
        if (!localzzku.zzl("user property", zzgt.zza, null, paramString2))
        {
          i = 15;
          break;
        }
        localzzku.zzs.zzc();
      } while (!localzzku.zzm("user property", 24, paramString2));
      i = 0;
    }
    int j;
    if (i != 0)
    {
      paramString1 = this.zzs.zzl();
      this.zzs.zzc();
      paramString1 = paramString1.zzC(paramString2, 24, true);
      if (paramString2 != null) {
        j = paramString2.length();
      } else {
        j = 0;
      }
      this.zzs.zzl().zzM(this.zzn, null, i, "_ev", paramString1, j, this.zzs.zzc().zzn(null, zzea.zzaw));
      return;
    }
    if (paramObject != null)
    {
      j = this.zzs.zzl().zzJ(paramString2, paramObject);
      if (j != 0)
      {
        paramString1 = this.zzs.zzl();
        this.zzs.zzc();
        paramString1 = paramString1.zzC(paramString2, 24, true);
        if ((!(paramObject instanceof String)) && (!(paramObject instanceof CharSequence))) {
          i = 0;
        } else {
          i = String.valueOf(paramObject).length();
        }
        this.zzs.zzl().zzM(this.zzn, null, j, "_ev", paramString1, i, this.zzs.zzc().zzn(null, zzea.zzaw));
        return;
      }
      paramObject = this.zzs.zzl().zzK(paramString2, paramObject);
      if (paramObject != null) {
        zzA(paramString1, paramString2, paramLong, paramObject);
      }
      return;
    }
    zzA(paramString1, paramString2, paramLong, null);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzhw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */