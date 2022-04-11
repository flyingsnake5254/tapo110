package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class zzd
  extends zze
{
  private final Map<String, Long> zza = new ArrayMap();
  private final Map<String, Integer> zzb = new ArrayMap();
  private long zzc;
  
  public zzd(zzfu paramzzfu)
  {
    super(paramzzfu);
  }
  
  @WorkerThread
  private final void zzh(long paramLong, zzid paramzzid)
  {
    if (paramzzid == null)
    {
      this.zzs.zzau().zzk().zza("Not logging ad exposure. No active activity");
      return;
    }
    if (paramLong < 1000L)
    {
      this.zzs.zzau().zzk().zzb("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(paramLong));
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putLong("_xt", paramLong);
    zzik.zzm(paramzzid, localBundle, true);
    this.zzs.zzk().zzs("am", "_xa", localBundle);
  }
  
  @WorkerThread
  private final void zzi(String paramString, long paramLong, zzid paramzzid)
  {
    if (paramzzid == null)
    {
      this.zzs.zzau().zzk().zza("Not logging ad unit exposure. No active activity");
      return;
    }
    if (paramLong < 1000L)
    {
      this.zzs.zzau().zzk().zzb("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(paramLong));
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("_ai", paramString);
    localBundle.putLong("_xt", paramLong);
    zzik.zzm(paramzzid, localBundle, true);
    this.zzs.zzk().zzs("am", "_xu", localBundle);
  }
  
  @WorkerThread
  private final void zzj(long paramLong)
  {
    Iterator localIterator = this.zza.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.zza.put(str, Long.valueOf(paramLong));
    }
    if (!this.zza.isEmpty()) {
      this.zzc = paramLong;
    }
  }
  
  public final void zza(String paramString, long paramLong)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      this.zzs.zzav().zzh(new zza(this, paramString, paramLong));
      return;
    }
    this.zzs.zzau().zzb().zza("Ad unit id must be a non-empty string");
  }
  
  public final void zzb(String paramString, long paramLong)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      this.zzs.zzav().zzh(new zzb(this, paramString, paramLong));
      return;
    }
    this.zzs.zzau().zzb().zza("Ad unit id must be a non-empty string");
  }
  
  @WorkerThread
  public final void zzc(long paramLong)
  {
    zzid localzzid = this.zzs.zzx().zzh(false);
    Iterator localIterator = this.zza.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      zzi(str, paramLong - ((Long)this.zza.get(str)).longValue(), localzzid);
    }
    if (!this.zza.isEmpty()) {
      zzh(paramLong - this.zzc, localzzid);
    }
    zzj(paramLong);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */