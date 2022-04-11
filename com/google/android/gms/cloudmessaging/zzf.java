package com.google.android.gms.cloudmessaging;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

final class zzf
  implements ServiceConnection
{
  @GuardedBy("this")
  int zza = 0;
  final Messenger zzb = new Messenger(new com.google.android.gms.internal.cloudmessaging.zze(Looper.getMainLooper(), new zzi(this)));
  zzo zzc;
  @GuardedBy("this")
  final Queue<zzq<?>> zzd = new ArrayDeque();
  @GuardedBy("this")
  final SparseArray<zzq<?>> zze = new SparseArray();
  
  private zzf(zze paramzze) {}
  
  @MainThread
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    if (Log.isLoggable("MessengerIpcClient", 2)) {
      Log.v("MessengerIpcClient", "Service connected");
    }
    zze.zzb(this.zzf).execute(new zzk(this, paramIBinder));
  }
  
  @MainThread
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    if (Log.isLoggable("MessengerIpcClient", 2)) {
      Log.v("MessengerIpcClient", "Service disconnected");
    }
    zze.zzb(this.zzf).execute(new zzm(this));
  }
  
  final void zza()
  {
    zze.zzb(this.zzf).execute(new zzj(this));
  }
  
  final void zza(int paramInt)
  {
    try
    {
      zzq localzzq = (zzq)this.zze.get(paramInt);
      if (localzzq != null)
      {
        Object localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>(31);
        ((StringBuilder)localObject2).append("Timing out request: ");
        ((StringBuilder)localObject2).append(paramInt);
        Log.w("MessengerIpcClient", ((StringBuilder)localObject2).toString());
        this.zze.remove(paramInt);
        localObject2 = new com/google/android/gms/cloudmessaging/zzp;
        ((zzp)localObject2).<init>(3, "Timed out waiting for response");
        localzzq.zza((zzp)localObject2);
        zzb();
      }
      return;
    }
    finally {}
  }
  
  final void zza(int paramInt, @Nullable String paramString)
  {
    try
    {
      Object localObject;
      if (Log.isLoggable("MessengerIpcClient", 3))
      {
        localObject = String.valueOf(paramString);
        if (((String)localObject).length() != 0) {
          localObject = "Disconnected: ".concat((String)localObject);
        } else {
          localObject = new String("Disconnected: ");
        }
        Log.d("MessengerIpcClient", (String)localObject);
      }
      int i = this.zza;
      if (i != 0)
      {
        if ((i != 1) && (i != 2))
        {
          if (i != 3)
          {
            if (i == 4) {
              return;
            }
            localObject = new java/lang/IllegalStateException;
            paramInt = this.zza;
            paramString = new java/lang/StringBuilder;
            paramString.<init>(26);
            paramString.append("Unknown state: ");
            paramString.append(paramInt);
            ((IllegalStateException)localObject).<init>(paramString.toString());
            throw ((Throwable)localObject);
          }
          this.zza = 4;
          return;
        }
        if (Log.isLoggable("MessengerIpcClient", 2)) {
          Log.v("MessengerIpcClient", "Unbinding service");
        }
        this.zza = 4;
        ConnectionTracker.getInstance().unbindService(zze.zza(this.zzf), this);
        localObject = new com/google/android/gms/cloudmessaging/zzp;
        ((zzp)localObject).<init>(paramInt, paramString);
        paramString = this.zzd.iterator();
        while (paramString.hasNext()) {
          ((zzq)paramString.next()).zza((zzp)localObject);
        }
        this.zzd.clear();
        for (paramInt = 0; paramInt < this.zze.size(); paramInt++) {
          ((zzq)this.zze.valueAt(paramInt)).zza((zzp)localObject);
        }
        this.zze.clear();
        return;
      }
      paramString = new java/lang/IllegalStateException;
      paramString.<init>();
      throw paramString;
    }
    finally {}
  }
  
  final boolean zza(Message paramMessage)
  {
    int i = paramMessage.arg1;
    Object localObject;
    if (Log.isLoggable("MessengerIpcClient", 3))
    {
      localObject = new StringBuilder(41);
      ((StringBuilder)localObject).append("Received response to request: ");
      ((StringBuilder)localObject).append(i);
      Log.d("MessengerIpcClient", ((StringBuilder)localObject).toString());
    }
    try
    {
      localObject = (zzq)this.zze.get(i);
      if (localObject == null)
      {
        paramMessage = new java/lang/StringBuilder;
        paramMessage.<init>(50);
        paramMessage.append("Received response for unknown request: ");
        paramMessage.append(i);
        Log.w("MessengerIpcClient", paramMessage.toString());
        return true;
      }
      this.zze.remove(i);
      zzb();
      paramMessage = paramMessage.getData();
      if (paramMessage.getBoolean("unsupported", false)) {
        ((zzq)localObject).zza(new zzp(4, "Not supported by GmsCore"));
      } else {
        ((zzq)localObject).zza(paramMessage);
      }
      return true;
    }
    finally {}
  }
  
  final boolean zza(zzq<?> paramzzq)
  {
    try
    {
      int i = this.zza;
      Object localObject;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if ((i != 3) && (i != 4))
            {
              localObject = new java/lang/IllegalStateException;
              i = this.zza;
              paramzzq = new java/lang/StringBuilder;
              paramzzq.<init>(26);
              paramzzq.append("Unknown state: ");
              paramzzq.append(i);
              ((IllegalStateException)localObject).<init>(paramzzq.toString());
              throw ((Throwable)localObject);
            }
            return false;
          }
          this.zzd.add(paramzzq);
          zza();
          return true;
        }
        this.zzd.add(paramzzq);
        return true;
      }
      this.zzd.add(paramzzq);
      boolean bool;
      if (this.zza == 0) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkState(bool);
      if (Log.isLoggable("MessengerIpcClient", 2)) {
        Log.v("MessengerIpcClient", "Starting bind to GmsCore");
      }
      this.zza = 1;
      paramzzq = new android/content/Intent;
      paramzzq.<init>("com.google.android.c2dm.intent.REGISTER");
      paramzzq.setPackage("com.google.android.gms");
      if (!ConnectionTracker.getInstance().bindService(zze.zza(this.zzf), paramzzq, this, 1))
      {
        zza(0, "Unable to bind to service");
      }
      else
      {
        paramzzq = zze.zzb(this.zzf);
        localObject = new com/google/android/gms/cloudmessaging/zzh;
        ((zzh)localObject).<init>(this);
        paramzzq.schedule((Runnable)localObject, 30L, TimeUnit.SECONDS);
      }
      return true;
    }
    finally {}
  }
  
  final void zzb()
  {
    try
    {
      if ((this.zza == 2) && (this.zzd.isEmpty()) && (this.zze.size() == 0))
      {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
          Log.v("MessengerIpcClient", "Finished handling requests, unbinding");
        }
        this.zza = 3;
        ConnectionTracker.getInstance().unbindService(zze.zza(this.zzf), this);
      }
      return;
    }
    finally {}
  }
  
  final void zzc()
  {
    try
    {
      if (this.zza == 1) {
        zza(1, "Timed out while binding");
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\cloudmessaging\zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */