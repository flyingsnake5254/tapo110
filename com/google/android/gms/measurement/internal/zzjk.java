package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Pair;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzcf;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@VisibleForTesting
public final class zzjk
  extends zzf
{
  private final zzjj zza;
  private zzed zzb;
  private volatile Boolean zzc;
  private final zzal zzd;
  private final zzka zze;
  private final List<Runnable> zzf = new ArrayList();
  private final zzal zzg;
  
  protected zzjk(zzfu paramzzfu)
  {
    super(paramzzfu);
    this.zze = new zzka(paramzzfu.zzay());
    this.zza = new zzjj(this);
    this.zzd = new zziu(this, paramzzfu);
    this.zzg = new zziw(this, paramzzfu);
  }
  
  private final boolean zzO()
  {
    this.zzs.zzat();
    return true;
  }
  
  @WorkerThread
  private final void zzP()
  {
    zzg();
    this.zze.zza();
    zzal localzzal = this.zzd;
    this.zzs.zzc();
    localzzal.zzb(((Long)zzea.zzI.zzb(null)).longValue());
  }
  
  @WorkerThread
  private final void zzQ(Runnable paramRunnable)
    throws IllegalStateException
  {
    zzg();
    if (zzh())
    {
      paramRunnable.run();
      return;
    }
    int i = this.zzf.size();
    this.zzs.zzc();
    if (i >= 1000L)
    {
      this.zzs.zzau().zzb().zza("Discarding data. Max runnable queue size reached");
      return;
    }
    this.zzf.add(paramRunnable);
    this.zzg.zzb(60000L);
    zzB();
  }
  
  @WorkerThread
  private final void zzR()
  {
    zzg();
    this.zzs.zzau().zzk().zzb("Processing queued up service tasks", Integer.valueOf(this.zzf.size()));
    Iterator localIterator = this.zzf.iterator();
    while (localIterator.hasNext())
    {
      Runnable localRunnable = (Runnable)localIterator.next();
      try
      {
        localRunnable.run();
      }
      catch (RuntimeException localRuntimeException)
      {
        this.zzs.zzau().zzb().zzb("Task exception while flushing queue", localRuntimeException);
      }
    }
    this.zzf.clear();
    this.zzg.zzd();
  }
  
  @WorkerThread
  private final zzp zzS(boolean paramBoolean)
  {
    this.zzs.zzat();
    zzee localzzee = this.zzs.zzA();
    String str = null;
    Object localObject1 = str;
    if (paramBoolean)
    {
      localObject1 = this.zzs.zzau();
      if (((zzgn)localObject1).zzs.zzd().zzb == null)
      {
        localObject1 = str;
      }
      else
      {
        Object localObject2 = ((zzgn)localObject1).zzs.zzd().zzb.zzb();
        localObject1 = str;
        if (localObject2 != null) {
          if (localObject2 == zzfb.zza)
          {
            localObject1 = str;
          }
          else
          {
            localObject1 = String.valueOf(((Pair)localObject2).second);
            str = (String)((Pair)localObject2).first;
            localObject2 = new StringBuilder(((String)localObject1).length() + 1 + String.valueOf(str).length());
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append(":");
            ((StringBuilder)localObject2).append(str);
            localObject1 = ((StringBuilder)localObject2).toString();
          }
        }
      }
    }
    return localzzee.zzh((String)localObject1);
  }
  
  @WorkerThread
  public final void zzA(Bundle paramBundle)
  {
    zzg();
    zzb();
    zzQ(new zzit(this, zzS(false), paramBundle));
  }
  
  @WorkerThread
  final void zzB()
  {
    zzg();
    zzb();
    if (zzh()) {
      return;
    }
    if (!zzD())
    {
      if (!this.zzs.zzc().zzy())
      {
        this.zzs.zzat();
        Object localObject = this.zzs.zzax().getPackageManager().queryIntentServices(new Intent().setClassName(this.zzs.zzax(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          localObject = new Intent("com.google.android.gms.measurement.START");
          Context localContext = this.zzs.zzax();
          this.zzs.zzat();
          ((Intent)localObject).setComponent(new ComponentName(localContext, "com.google.android.gms.measurement.AppMeasurementService"));
          this.zza.zza((Intent)localObject);
          return;
        }
        this.zzs.zzau().zzb().zza("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
      }
      return;
    }
    this.zza.zzc();
  }
  
  final Boolean zzC()
  {
    return this.zzc;
  }
  
  @WorkerThread
  final boolean zzD()
  {
    zzg();
    zzb();
    if (this.zzc == null)
    {
      zzg();
      zzb();
      Object localObject = this.zzs.zzd();
      ((zzgn)localObject).zzg();
      boolean bool1 = ((zzfb)localObject).zzd().contains("use_service");
      boolean bool2 = false;
      boolean bool3 = false;
      if (!bool1) {
        localObject = null;
      } else {
        localObject = Boolean.valueOf(((zzfb)localObject).zzd().getBoolean("use_service", false));
      }
      int i = 1;
      boolean bool4 = true;
      bool1 = true;
      if ((localObject != null) && (((Boolean)localObject).booleanValue()))
      {
        bool3 = bool4;
      }
      else
      {
        this.zzs.zzat();
        if (this.zzs.zzA().zzn() == 1) {}
        for (;;)
        {
          bool3 = true;
          break;
          this.zzs.zzau().zzk().zza("Checking service availability");
          int j = this.zzs.zzl().zzaa(12451000);
          if (j != 0)
          {
            if (j != 1)
            {
              if (j != 2) {
                if (j != 3)
                {
                  if (j != 9)
                  {
                    if (j != 18) {
                      this.zzs.zzau().zze().zzb("Unexpected service status", Integer.valueOf(j));
                    } else {
                      this.zzs.zzau().zze().zza("Service updating");
                    }
                  }
                  else {
                    this.zzs.zzau().zze().zza("Service invalid");
                  }
                }
                else {
                  this.zzs.zzau().zze().zza("Service disabled");
                }
              }
              for (;;)
              {
                i = 0;
                break;
                this.zzs.zzau().zzj().zza("Service container out of date");
                if (this.zzs.zzl().zzZ() < 17443)
                {
                  bool3 = bool2;
                  break;
                }
                if (localObject == null) {
                  bool3 = bool1;
                } else {
                  bool3 = false;
                }
              }
            }
            else
            {
              this.zzs.zzau().zzk().zza("Service missing");
              bool3 = bool2;
              break;
            }
          }
          else {
            this.zzs.zzau().zzk().zza("Service available");
          }
        }
        if ((!bool3) && (this.zzs.zzc().zzy()))
        {
          this.zzs.zzau().zzb().zza("No way to upload. Consider using the full version of Analytics");
        }
        else if (i != 0)
        {
          localObject = this.zzs.zzd();
          ((zzgn)localObject).zzg();
          localObject = ((zzfb)localObject).zzd().edit();
          ((SharedPreferences.Editor)localObject).putBoolean("use_service", bool3);
          ((SharedPreferences.Editor)localObject).apply();
        }
      }
      this.zzc = Boolean.valueOf(bool3);
    }
    return this.zzc.booleanValue();
  }
  
  @WorkerThread
  @VisibleForTesting
  protected final void zzE(zzed paramzzed)
  {
    zzg();
    Preconditions.checkNotNull(paramzzed);
    this.zzb = paramzzed;
    zzP();
    zzR();
  }
  
  @WorkerThread
  public final void zzF()
  {
    zzg();
    zzb();
    this.zza.zzb();
    try
    {
      ConnectionTracker.getInstance().unbindService(this.zzs.zzax(), this.zza);
      this.zzb = null;
      return;
    }
    catch (IllegalStateException|IllegalArgumentException localIllegalStateException)
    {
      for (;;) {}
    }
  }
  
  @WorkerThread
  public final void zzG(zzcf paramzzcf, zzas paramzzas, String paramString)
  {
    zzg();
    zzb();
    if (this.zzs.zzl().zzaa(12451000) != 0)
    {
      this.zzs.zzau().zze().zza("Not bundling data. Service unavailable or out of date");
      this.zzs.zzl().zzag(paramzzcf, new byte[0]);
      return;
    }
    zzQ(new zziv(this, paramzzas, paramString, paramzzcf));
  }
  
  @WorkerThread
  final boolean zzH()
  {
    zzg();
    zzb();
    if (zzD()) {
      return this.zzs.zzl().zzZ() >= ((Integer)zzea.zzau.zzb(null)).intValue();
    }
    return true;
  }
  
  protected final boolean zze()
  {
    return false;
  }
  
  @WorkerThread
  public final boolean zzh()
  {
    zzg();
    zzb();
    return this.zzb != null;
  }
  
  @WorkerThread
  protected final void zzi()
  {
    zzg();
    zzb();
    zzQ(new zzix(this, zzS(true)));
  }
  
  @WorkerThread
  protected final void zzj(boolean paramBoolean)
  {
    zzg();
    zzb();
    if (paramBoolean)
    {
      zzO();
      this.zzs.zzn().zzh();
    }
    if (zzH()) {
      zzQ(new zziy(this, zzS(false)));
    }
  }
  
  @WorkerThread
  @VisibleForTesting
  final void zzk(zzed paramzzed, AbstractSafeParcelable paramAbstractSafeParcelable, zzp paramzzp)
  {
    zzg();
    zzb();
    zzO();
    this.zzs.zzc();
    int i = 0;
    int j = 100;
    while ((i < 1001) && (j == 100))
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject = this.zzs.zzn().zzl(100);
      if (localObject != null)
      {
        localArrayList.addAll((Collection)localObject);
        j = ((List)localObject).size();
      }
      else
      {
        j = 0;
      }
      if ((paramAbstractSafeParcelable != null) && (j < 100)) {
        localArrayList.add(paramAbstractSafeParcelable);
      }
      int k = localArrayList.size();
      for (int m = 0; m < k; m++)
      {
        localObject = (AbstractSafeParcelable)localArrayList.get(m);
        if ((localObject instanceof zzas)) {
          try
          {
            paramzzed.zzd((zzas)localObject, paramzzp);
          }
          catch (RemoteException localRemoteException1)
          {
            this.zzs.zzau().zzb().zzb("Failed to send event to the service", localRemoteException1);
          }
        } else if ((localRemoteException1 instanceof zzkq)) {
          try
          {
            paramzzed.zze((zzkq)localRemoteException1, paramzzp);
          }
          catch (RemoteException localRemoteException2)
          {
            this.zzs.zzau().zzb().zzb("Failed to send user property to the service", localRemoteException2);
          }
        } else if ((localRemoteException2 instanceof zzaa)) {
          try
          {
            paramzzed.zzm((zzaa)localRemoteException2, paramzzp);
          }
          catch (RemoteException localRemoteException3)
          {
            this.zzs.zzau().zzb().zzb("Failed to send conditional user property to the service", localRemoteException3);
          }
        } else {
          this.zzs.zzau().zzb().zza("Discarding data. Unrecognized parcel type.");
        }
      }
      i++;
    }
  }
  
  @WorkerThread
  protected final void zzl(zzas paramzzas, String paramString)
  {
    Preconditions.checkNotNull(paramzzas);
    zzg();
    zzb();
    zzO();
    boolean bool = this.zzs.zzn().zzi(paramzzas);
    zzQ(new zziz(this, true, zzS(true), bool, paramzzas, paramString));
  }
  
  @WorkerThread
  protected final void zzm(zzaa paramzzaa)
  {
    Preconditions.checkNotNull(paramzzaa);
    zzg();
    zzb();
    this.zzs.zzat();
    boolean bool = this.zzs.zzn().zzk(paramzzaa);
    zzaa localzzaa = new zzaa(paramzzaa);
    zzQ(new zzja(this, true, zzS(true), bool, localzzaa, paramzzaa));
  }
  
  @WorkerThread
  protected final void zzn(AtomicReference<List<zzaa>> paramAtomicReference, String paramString1, String paramString2, String paramString3)
  {
    zzg();
    zzb();
    zzQ(new zzjb(this, paramAtomicReference, null, paramString2, paramString3, zzS(false)));
  }
  
  @WorkerThread
  protected final void zzo(zzcf paramzzcf, String paramString1, String paramString2)
  {
    zzg();
    zzb();
    zzQ(new zzjc(this, paramString1, paramString2, zzS(false), paramzzcf));
  }
  
  @WorkerThread
  protected final void zzq(AtomicReference<List<zzkq>> paramAtomicReference, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    zzg();
    zzb();
    zzQ(new zzjd(this, paramAtomicReference, null, paramString2, paramString3, zzS(false), paramBoolean));
  }
  
  @WorkerThread
  protected final void zzr(zzcf paramzzcf, String paramString1, String paramString2, boolean paramBoolean)
  {
    zzg();
    zzb();
    zzQ(new zzil(this, paramString1, paramString2, zzS(false), paramBoolean, paramzzcf));
  }
  
  @WorkerThread
  protected final void zzs(zzkq paramzzkq)
  {
    zzg();
    zzb();
    zzO();
    boolean bool = this.zzs.zzn().zzj(paramzzkq);
    zzQ(new zzim(this, zzS(true), bool, paramzzkq));
  }
  
  @WorkerThread
  protected final void zzt(AtomicReference<List<zzkq>> paramAtomicReference, boolean paramBoolean)
  {
    zzg();
    zzb();
    zzQ(new zzin(this, paramAtomicReference, zzS(false), paramBoolean));
  }
  
  @WorkerThread
  protected final void zzu()
  {
    zzg();
    zzb();
    zzp localzzp = zzS(false);
    zzO();
    this.zzs.zzn().zzh();
    zzQ(new zzio(this, localzzp));
  }
  
  @WorkerThread
  public final void zzv(AtomicReference<String> paramAtomicReference)
  {
    zzg();
    zzb();
    zzQ(new zzip(this, paramAtomicReference, zzS(false)));
  }
  
  @WorkerThread
  public final void zzx(zzcf paramzzcf)
  {
    zzg();
    zzb();
    zzQ(new zziq(this, zzS(false), paramzzcf));
  }
  
  @WorkerThread
  protected final void zzy()
  {
    zzg();
    zzb();
    zzp localzzp = zzS(true);
    this.zzs.zzn().zzm();
    zzQ(new zzir(this, localzzp));
  }
  
  @WorkerThread
  protected final void zzz(zzid paramzzid)
  {
    zzg();
    zzb();
    zzQ(new zzis(this, paramzzid));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzjk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */