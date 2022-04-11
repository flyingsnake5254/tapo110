package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
public final class zzjj
  implements ServiceConnection, BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener
{
  private volatile boolean zzb;
  private volatile zzei zzc;
  
  protected zzjj(zzjk paramzzjk) {}
  
  /* Error */
  @MainThread
  public final void onConnected(android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: ldc 38
    //   2: invokestatic 44	com/google/android/gms/common/internal/Preconditions:checkMainThread	(Ljava/lang/String;)V
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 46	com/google/android/gms/measurement/internal/zzjj:zzc	Lcom/google/android/gms/measurement/internal/zzei;
    //   11: invokestatic 50	com/google/android/gms/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   14: pop
    //   15: aload_0
    //   16: getfield 46	com/google/android/gms/measurement/internal/zzjj:zzc	Lcom/google/android/gms/measurement/internal/zzei;
    //   19: invokevirtual 56	com/google/android/gms/common/internal/BaseGmsClient:getService	()Landroid/os/IInterface;
    //   22: checkcast 58	com/google/android/gms/measurement/internal/zzed
    //   25: astore_2
    //   26: aload_0
    //   27: getfield 21	com/google/android/gms/measurement/internal/zzjj:zza	Lcom/google/android/gms/measurement/internal/zzjk;
    //   30: getfield 64	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   33: invokevirtual 70	com/google/android/gms/measurement/internal/zzfu:zzav	()Lcom/google/android/gms/measurement/internal/zzfr;
    //   36: astore_1
    //   37: new 72	com/google/android/gms/measurement/internal/zzjg
    //   40: astore_3
    //   41: aload_3
    //   42: aload_0
    //   43: aload_2
    //   44: invokespecial 75	com/google/android/gms/measurement/internal/zzjg:<init>	(Lcom/google/android/gms/measurement/internal/zzjj;Lcom/google/android/gms/measurement/internal/zzed;)V
    //   47: aload_1
    //   48: aload_3
    //   49: invokevirtual 81	com/google/android/gms/measurement/internal/zzfr:zzh	(Ljava/lang/Runnable;)V
    //   52: goto +18 -> 70
    //   55: astore_1
    //   56: goto +17 -> 73
    //   59: astore_1
    //   60: aload_0
    //   61: aconst_null
    //   62: putfield 46	com/google/android/gms/measurement/internal/zzjj:zzc	Lcom/google/android/gms/measurement/internal/zzei;
    //   65: aload_0
    //   66: iconst_0
    //   67: putfield 29	com/google/android/gms/measurement/internal/zzjj:zzb	Z
    //   70: aload_0
    //   71: monitorexit
    //   72: return
    //   73: aload_0
    //   74: monitorexit
    //   75: aload_1
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	zzjj
    //   0	77	1	paramBundle	android.os.Bundle
    //   25	19	2	localzzed	zzed
    //   40	9	3	localzzjg	zzjg
    // Exception table:
    //   from	to	target	type
    //   7	52	55	finally
    //   60	70	55	finally
    //   70	72	55	finally
    //   73	75	55	finally
    //   7	52	59	android/os/DeadObjectException
    //   7	52	59	java/lang/IllegalStateException
  }
  
  @MainThread
  public final void onConnectionFailed(@NonNull ConnectionResult paramConnectionResult)
  {
    Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionFailed");
    zzem localzzem = this.zza.zzs.zzf();
    if (localzzem != null) {
      localzzem.zze().zzb("Service connection failed", paramConnectionResult);
    }
    try
    {
      this.zzb = false;
      this.zzc = null;
      this.zza.zzs.zzav().zzh(new zzji(this));
      return;
    }
    finally {}
  }
  
  @MainThread
  public final void onConnectionSuspended(int paramInt)
  {
    Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionSuspended");
    this.zza.zzs.zzau().zzj().zza("Service connection suspended");
    this.zza.zzs.zzav().zzh(new zzjh(this));
  }
  
  @MainThread
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    Preconditions.checkMainThread("MeasurementServiceConnection.onServiceConnected");
    if (paramIBinder == null) {}
    try
    {
      this.zzb = false;
      this.zza.zzs.zzau().zzb().zza("Service connected with null binder");
      return;
    }
    finally
    {
      try
      {
        IInterface localIInterface;
        String str = paramIBinder.getInterfaceDescriptor();
        paramComponentName = localzzfr;
        if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(str))
        {
          paramComponentName = localzzfr;
          localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
          paramComponentName = localzzfr;
          if ((localIInterface instanceof zzed)) {
            paramComponentName = localzzfr;
          }
          for (paramIBinder = (zzed)localIInterface;; paramIBinder = new zzeb(paramIBinder))
          {
            break;
            paramComponentName = localzzfr;
          }
          paramComponentName = paramIBinder;
          this.zza.zzs.zzau().zzk().zza("Bound to IMeasurementService interface");
          paramComponentName = paramIBinder;
        }
        else
        {
          paramComponentName = localzzfr;
          this.zza.zzs.zzau().zzb().zzb("Got binder with a wrong descriptor", str);
          paramComponentName = localIInterface;
        }
      }
      catch (RemoteException paramIBinder)
      {
        this.zza.zzs.zzau().zzb().zza("Service connect failed to get IMeasurementService");
        if (paramComponentName != null) {
          break label225;
        }
        this.zzb = false;
        try
        {
          ConnectionTracker.getInstance().unbindService(this.zza.zzs.zzax(), zzjk.zzI(this.zza));
        }
        catch (IllegalArgumentException paramComponentName)
        {
          for (;;) {}
        }
        zzfr localzzfr = this.zza.zzs.zzav();
        paramIBinder = new com/google/android/gms/measurement/internal/zzje;
        paramIBinder.<init>(this, paramComponentName);
        localzzfr.zzh(paramIBinder);
      }
      paramComponentName = finally;
      break label256;
    }
    localIInterface = null;
    localzzfr = null;
    paramComponentName = localzzfr;
    label225:
    return;
    label256:
    throw paramComponentName;
  }
  
  @MainThread
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    Preconditions.checkMainThread("MeasurementServiceConnection.onServiceDisconnected");
    this.zza.zzs.zzau().zzj().zza("Service disconnected");
    this.zza.zzs.zzav().zzh(new zzjf(this, paramComponentName));
  }
  
  @WorkerThread
  public final void zza(Intent paramIntent)
  {
    this.zza.zzg();
    Context localContext = this.zza.zzs.zzax();
    ConnectionTracker localConnectionTracker = ConnectionTracker.getInstance();
    try
    {
      if (this.zzb)
      {
        this.zza.zzs.zzau().zzk().zza("Connection attempt already in progress");
        return;
      }
      this.zza.zzs.zzau().zzk().zza("Using local app measurement service");
      this.zzb = true;
      localConnectionTracker.bindService(localContext, paramIntent, zzjk.zzI(this.zza), 129);
      return;
    }
    finally {}
  }
  
  @WorkerThread
  public final void zzb()
  {
    if ((this.zzc != null) && ((this.zzc.isConnected()) || (this.zzc.isConnecting()))) {
      this.zzc.disconnect();
    }
    this.zzc = null;
  }
  
  @WorkerThread
  public final void zzc()
  {
    this.zza.zzg();
    Context localContext = this.zza.zzs.zzax();
    try
    {
      if (this.zzb)
      {
        this.zza.zzs.zzau().zzk().zza("Connection attempt already in progress");
        return;
      }
      if ((this.zzc != null) && ((this.zzc.isConnecting()) || (this.zzc.isConnected())))
      {
        this.zza.zzs.zzau().zzk().zza("Already awaiting connection attempt");
        return;
      }
      zzei localzzei = new com/google/android/gms/measurement/internal/zzei;
      localzzei.<init>(localContext, Looper.getMainLooper(), this, this);
      this.zzc = localzzei;
      this.zza.zzs.zzau().zzk().zza("Connecting to remote service");
      this.zzb = true;
      Preconditions.checkNotNull(this.zzc);
      this.zzc.checkAvailabilityAndConnect();
      return;
    }
    finally {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzjj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */