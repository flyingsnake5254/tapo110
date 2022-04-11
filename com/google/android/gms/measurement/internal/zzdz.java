package com.google.android.gms.measurement.internal;

import androidx.annotation.GuardedBy;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Iterator;
import java.util.List;

@VisibleForTesting
public final class zzdz<V>
{
  private static final Object zzf = new Object();
  private final String zza;
  private final zzdx<V> zzb;
  private final V zzc;
  private final V zzd;
  private final Object zze;
  @GuardedBy("overrideLock")
  private volatile V zzg;
  @GuardedBy("cachingLock")
  private volatile V zzh;
  
  public final String zza()
  {
    return this.zza;
  }
  
  public final V zzb(V paramV)
  {
    synchronized (this.zze)
    {
      if (paramV == null) {}
    }
    synchronized (zzf)
    {
      if (zzz.zza())
      {
        if (this.zzh == null) {
          paramV = this.zzc;
        } else {
          paramV = this.zzh;
        }
        return paramV;
      }
      for (;;)
      {
        try
        {
          Iterator localIterator = zzea.zzc().iterator();
          if (localIterator.hasNext())
          {
            localzzdz = (zzdz)localIterator.next();
            boolean bool = zzz.zza();
            if (!bool) {
              ??? = null;
            }
          }
        }
        catch (SecurityException paramV)
        {
          zzdz localzzdz;
          zzdx localzzdx;
          paramV = this.zzb;
          if (paramV == null) {
            return (V)this.zzc;
          }
          try
          {
            paramV = paramV.zza();
            return paramV;
          }
          catch (IllegalStateException paramV)
          {
            return (V)this.zzc;
          }
          catch (SecurityException paramV)
          {
            return (V)this.zzc;
          }
        }
        try
        {
          localzzdx = localzzdz.zzb;
          paramV = (V)???;
          if (localzzdx != null) {
            paramV = localzzdx.zza();
          }
        }
        catch (IllegalStateException paramV)
        {
          paramV = (V)???;
          continue;
        }
        synchronized (zzf)
        {
          localzzdz.zzh = paramV;
        }
      }
      paramV = new java/lang/IllegalStateException;
      paramV.<init>("Refreshing flag cache must be done on a worker thread.");
      throw paramV;
    }
    return (V)this.zzc;
    paramV = finally;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzdz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */