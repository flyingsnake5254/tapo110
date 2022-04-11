package com.google.android.gms.measurement.internal;

import android.util.Pair;
import androidx.annotation.WorkerThread;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.util.Clock;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;

public final class zzjl
  extends zzke
{
  public final zzey zza;
  public final zzey zzb;
  public final zzey zzc;
  public final zzey zzd;
  public final zzey zze;
  private String zzg;
  private boolean zzh;
  private long zzi;
  
  zzjl(zzkn paramzzkn)
  {
    super(paramzzkn);
    paramzzkn = this.zzs.zzd();
    paramzzkn.getClass();
    this.zza = new zzey(paramzzkn, "last_delete_stale", 0L);
    paramzzkn = this.zzs.zzd();
    paramzzkn.getClass();
    this.zzb = new zzey(paramzzkn, "backoff", 0L);
    paramzzkn = this.zzs.zzd();
    paramzzkn.getClass();
    this.zzc = new zzey(paramzzkn, "last_upload", 0L);
    paramzzkn = this.zzs.zzd();
    paramzzkn.getClass();
    this.zzd = new zzey(paramzzkn, "last_upload_attempt", 0L);
    paramzzkn = this.zzs.zzd();
    paramzzkn.getClass();
    this.zze = new zzey(paramzzkn, "midnight_offset", 0L);
  }
  
  protected final boolean zzaA()
  {
    return false;
  }
  
  @WorkerThread
  final Pair<String, Boolean> zzc(String paramString, zzaf paramzzaf)
  {
    if (paramzzaf.zzf()) {
      return zzd(paramString);
    }
    return new Pair("", Boolean.FALSE);
  }
  
  @Deprecated
  @WorkerThread
  final Pair<String, Boolean> zzd(String paramString)
  {
    zzg();
    long l = this.zzs.zzay().elapsedRealtime();
    Object localObject = this.zzg;
    if ((localObject != null) && (l < this.zzi)) {
      return new Pair(localObject, Boolean.valueOf(this.zzh));
    }
    this.zzi = (l + this.zzs.zzc().zzj(paramString, zzea.zza));
    AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
    try
    {
      localObject = AdvertisingIdClient.getAdvertisingIdInfo(this.zzs.zzax());
      this.zzg = "";
      paramString = ((AdvertisingIdClient.Info)localObject).getId();
      if (paramString != null) {
        this.zzg = paramString;
      }
      this.zzh = ((AdvertisingIdClient.Info)localObject).isLimitAdTrackingEnabled();
    }
    catch (Exception paramString)
    {
      this.zzs.zzau().zzj().zzb("Unable to get advertising id", paramString);
      this.zzg = "";
    }
    AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
    return new Pair(this.zzg, Boolean.valueOf(this.zzh));
  }
  
  @Deprecated
  @WorkerThread
  final String zzf(String paramString)
  {
    zzg();
    String str = (String)zzd(paramString).first;
    paramString = zzku.zzN();
    if (paramString == null) {
      return null;
    }
    return String.format(Locale.US, "%032X", new Object[] { new BigInteger(1, paramString.digest(str.getBytes())) });
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzjl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */