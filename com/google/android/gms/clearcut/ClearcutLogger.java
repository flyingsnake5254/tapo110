package com.google.android.gms.clearcut;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.clearcut.zzaa;
import com.google.android.gms.internal.clearcut.zzge.zzv.zzb;
import com.google.android.gms.internal.clearcut.zzha;
import com.google.android.gms.internal.clearcut.zzj;
import com.google.android.gms.internal.clearcut.zzp;
import com.google.android.gms.internal.clearcut.zzr;
import com.google.android.gms.phenotype.ExperimentTokens;
import java.util.ArrayList;
import java.util.TimeZone;
import javax.annotation.Nullable;

@KeepForSdk
public final class ClearcutLogger
{
  @Deprecated
  public static final Api<Api.ApiOptions.NoOptions> API;
  private static final Api.AbstractClientBuilder<zzj, Api.ApiOptions.NoOptions> CLIENT_BUILDER;
  private static final Api.ClientKey<zzj> CLIENT_KEY;
  private static final ExperimentTokens[] zze = new ExperimentTokens[0];
  private static final String[] zzf = new String[0];
  private static final byte[][] zzg = new byte[0][];
  private final String packageName;
  private final Context zzh;
  private final int zzi;
  private String zzj;
  private int zzk = -1;
  private String zzl;
  private String zzm;
  private final boolean zzn;
  private zzge.zzv.zzb zzo;
  private final zzb zzp;
  private final Clock zzq;
  private zzc zzr;
  private final zza zzs;
  
  static
  {
    Api.ClientKey localClientKey = new Api.ClientKey();
    CLIENT_KEY = localClientKey;
    zza localzza = new zza();
    CLIENT_BUILDER = localzza;
    API = new Api("ClearcutLogger.API", localzza, localClientKey);
  }
  
  @VisibleForTesting
  private ClearcutLogger(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean, zzb paramzzb, Clock paramClock, zzc paramzzc, zza paramzza)
  {
    paramString3 = zzge.zzv.zzb.zzbhk;
    this.zzo = paramString3;
    this.zzh = paramContext;
    this.packageName = paramContext.getPackageName();
    this.zzi = zza(paramContext);
    this.zzk = -1;
    this.zzj = paramString1;
    this.zzl = paramString2;
    this.zzm = null;
    this.zzn = paramBoolean;
    this.zzp = paramzzb;
    this.zzq = paramClock;
    this.zzr = new zzc();
    this.zzo = paramString3;
    this.zzs = paramzza;
    if (paramBoolean)
    {
      if (paramString2 == null) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      Preconditions.checkArgument(paramBoolean, "can't be anonymous with an upload account");
    }
  }
  
  @KeepForSdk
  public ClearcutLogger(Context paramContext, String paramString1, @Nullable String paramString2)
  {
    this(paramContext, -1, paramString1, paramString2, null, false, com.google.android.gms.internal.clearcut.zze.zzb(paramContext), DefaultClock.getInstance(), null, new zzp(paramContext));
  }
  
  @KeepForSdk
  public static ClearcutLogger anonymousLogger(Context paramContext, String paramString)
  {
    return new ClearcutLogger(paramContext, -1, paramString, null, null, true, com.google.android.gms.internal.clearcut.zze.zzb(paramContext), DefaultClock.getInstance(), null, new zzp(paramContext));
  }
  
  private static int zza(Context paramContext)
  {
    int i = 0;
    int j;
    try
    {
      j = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionCode;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      Log.wtf("ClearcutLogger", "This can't happen.", paramContext);
      j = i;
    }
    return j;
  }
  
  private static int[] zza(ArrayList<Integer> paramArrayList)
  {
    if (paramArrayList == null) {
      return null;
    }
    int[] arrayOfInt = new int[paramArrayList.size()];
    int i = paramArrayList.size();
    int j = 0;
    for (int k = 0; j < i; k++)
    {
      Object localObject = paramArrayList.get(j);
      j++;
      arrayOfInt[k] = ((Integer)localObject).intValue();
    }
    return arrayOfInt;
  }
  
  @KeepForSdk
  public final LogEventBuilder newEvent(@Nullable byte[] paramArrayOfByte)
  {
    return new LogEventBuilder(paramArrayOfByte, null);
  }
  
  public class LogEventBuilder
  {
    private final zzha zzaa;
    private boolean zzab;
    private String zzj = ClearcutLogger.zzb(ClearcutLogger.this);
    private int zzk = ClearcutLogger.zza(ClearcutLogger.this);
    private String zzl = ClearcutLogger.zzc(ClearcutLogger.this);
    private String zzm = null;
    private zzge.zzv.zzb zzo = ClearcutLogger.zzd(ClearcutLogger.this);
    private final ClearcutLogger.zzb zzt;
    private ArrayList<Integer> zzu = null;
    private ArrayList<String> zzv = null;
    private ArrayList<Integer> zzw = null;
    private ArrayList<ExperimentTokens> zzx = null;
    private ArrayList<byte[]> zzy = null;
    private boolean zzz = true;
    
    private LogEventBuilder(byte[] paramArrayOfByte)
    {
      this(paramArrayOfByte, null);
    }
    
    private LogEventBuilder(byte[] paramArrayOfByte, ClearcutLogger.zzb paramzzb)
    {
      paramzzb = new zzha();
      this.zzaa = paramzzb;
      this.zzab = false;
      this.zzl = ClearcutLogger.zzc(ClearcutLogger.this);
      this.zzm = null;
      paramzzb.zzbkc = zzaa.zze(ClearcutLogger.zze(ClearcutLogger.this));
      paramzzb.zzbjf = ClearcutLogger.zzf(ClearcutLogger.this).currentTimeMillis();
      paramzzb.zzbjg = ClearcutLogger.zzf(ClearcutLogger.this).elapsedRealtime();
      ClearcutLogger.zzg(ClearcutLogger.this);
      long l = paramzzb.zzbjf;
      paramzzb.zzbju = (TimeZone.getDefault().getOffset(l) / 1000);
      if (paramArrayOfByte != null) {
        paramzzb.zzbjp = paramArrayOfByte;
      }
      this.zzt = null;
    }
    
    @KeepForSdk
    public void log()
    {
      if (!this.zzab)
      {
        this.zzab = true;
        zze localzze = new zze(new zzr(ClearcutLogger.zzi(ClearcutLogger.this), ClearcutLogger.zzj(ClearcutLogger.this), this.zzk, this.zzj, this.zzl, this.zzm, ClearcutLogger.zzh(ClearcutLogger.this), this.zzo), this.zzaa, null, null, ClearcutLogger.zzb(null), null, ClearcutLogger.zzb(null), null, null, this.zzz);
        if (ClearcutLogger.zzk(ClearcutLogger.this).zza(localzze))
        {
          ClearcutLogger.zzl(ClearcutLogger.this).zzb(localzze);
          return;
        }
        PendingResults.immediatePendingResult(Status.RESULT_SUCCESS, null);
        return;
      }
      throw new IllegalStateException("do not reuse LogEventBuilder");
    }
    
    @KeepForSdk
    public LogEventBuilder setEventCode(int paramInt)
    {
      this.zzaa.zzbji = paramInt;
      return this;
    }
  }
  
  public static abstract interface zza
  {
    public abstract boolean zza(zze paramzze);
  }
  
  public static abstract interface zzb
  {
    public abstract byte[] zza();
  }
  
  public static final class zzc {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\clearcut\ClearcutLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */