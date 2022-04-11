package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.util.Clock;
import java.util.Iterator;
import java.util.Set;

public final class zzr
{
  private final zzfu zza;
  
  public zzr(zzfu paramzzfu)
  {
    this.zza = paramzzfu;
  }
  
  @WorkerThread
  final void zza()
  {
    this.zza.zzav().zzg();
    if (!zze()) {
      return;
    }
    Object localObject;
    if (zzd())
    {
      this.zza.zzd().zzp.zzb(null);
      localObject = new Bundle();
      ((Bundle)localObject).putString("source", "(not set)");
      ((Bundle)localObject).putString("medium", "(not set)");
      ((Bundle)localObject).putString("_cis", "intent");
      ((Bundle)localObject).putLong("_cc", 1L);
      this.zza.zzk().zzs("auto", "_cmpx", (Bundle)localObject);
    }
    else
    {
      localObject = this.zza.zzd().zzp.zza();
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        this.zza.zzau().zzc().zza("Cache still valid but referrer not found");
      }
      else
      {
        long l = this.zza.zzd().zzq.zza() / 3600000L;
        Uri localUri = Uri.parse((String)localObject);
        localObject = new Bundle();
        Pair localPair = new Pair(localUri.getPath(), localObject);
        Iterator localIterator = localUri.getQueryParameterNames().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          ((Bundle)localObject).putString(str, localUri.getQueryParameter(str));
        }
        ((Bundle)localPair.second).putLong("_cc", (l - 1L) * 3600000L);
        this.zza.zzk().zzs((String)localPair.first, "_cmp", (Bundle)localPair.second);
      }
      this.zza.zzd().zzp.zzb(null);
    }
    this.zza.zzd().zzq.zzb(0L);
  }
  
  @WorkerThread
  final void zzb(String paramString, Bundle paramBundle)
  {
    this.zza.zzav().zzg();
    if (!this.zza.zzF())
    {
      if (paramBundle.isEmpty())
      {
        paramString = null;
      }
      else
      {
        Object localObject = paramString;
        if (true == paramString.isEmpty()) {
          localObject = "auto";
        }
        paramString = new Uri.Builder();
        paramString.path((String)localObject);
        localObject = paramBundle.keySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          paramString.appendQueryParameter(str, paramBundle.getString(str));
        }
        paramString = paramString.build().toString();
      }
      if (!TextUtils.isEmpty(paramString))
      {
        this.zza.zzd().zzp.zzb(paramString);
        this.zza.zzd().zzq.zzb(this.zza.zzay().currentTimeMillis());
      }
    }
  }
  
  final void zzc()
  {
    if ((zze()) && (zzd())) {
      this.zza.zzd().zzp.zzb(null);
    }
  }
  
  final boolean zzd()
  {
    if (!zze()) {
      return false;
    }
    return this.zza.zzay().currentTimeMillis() - this.zza.zzd().zzq.zza() > this.zza.zzc().zzj(null, zzea.zzQ);
  }
  
  final boolean zze()
  {
    return this.zza.zzd().zzq.zza() > 0L;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */