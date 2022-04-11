package com.google.android.gms.internal.clearcut;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.clearcut.ClearcutLogger.zza;
import com.google.android.gms.clearcut.zze;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.phenotype.Phenotype;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public final class zzp
  implements ClearcutLogger.zza
{
  private static final Charset UTF_8 = Charset.forName("UTF-8");
  private static final zzao zzaq;
  private static final zzao zzar;
  private static final ConcurrentHashMap<String, zzae<zzgw.zza>> zzas;
  private static final HashMap<String, zzae<String>> zzat;
  @VisibleForTesting
  private static Boolean zzau;
  @VisibleForTesting
  private static Long zzav;
  @VisibleForTesting
  private static final zzae<Boolean> zzaw;
  private final Context zzh;
  
  static
  {
    zzao localzzao = new zzao(Phenotype.getContentProviderUri("com.google.android.gms.clearcut.public")).zzc("gms:playlog:service:samplingrules_").zzd("LogSamplingRules__");
    zzaq = localzzao;
    zzar = new zzao(Phenotype.getContentProviderUri("com.google.android.gms.clearcut.public")).zzc("gms:playlog:service:sampling_").zzd("LogSampling__");
    zzas = new ConcurrentHashMap();
    zzat = new HashMap();
    zzau = null;
    zzav = null;
    zzaw = localzzao.zzc("enable_log_sampling_rules", false);
  }
  
  public zzp(Context paramContext)
  {
    this.zzh = paramContext;
    if (paramContext != null) {
      zzae.maybeInit(paramContext);
    }
  }
  
  @VisibleForTesting
  private static long zza(String paramString, long paramLong)
  {
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      byte[] arrayOfByte = paramString.getBytes(UTF_8);
      paramString = ByteBuffer.allocate(arrayOfByte.length + 8);
      paramString.put(arrayOfByte);
      paramString.putLong(paramLong);
      return zzk.zza(paramString.array());
    }
    return zzk.zza(ByteBuffer.allocate(8).putLong(paramLong).array());
  }
  
  @VisibleForTesting
  private static zzgw.zza.zzb zza(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    int i = paramString.indexOf(',');
    int j = 0;
    String str;
    if (i >= 0)
    {
      str = paramString.substring(0, i);
      j = i + 1;
    }
    else
    {
      str = "";
    }
    i = paramString.indexOf('/', j);
    if (i <= 0)
    {
      if (paramString.length() != 0) {
        paramString = "Failed to parse the rule: ".concat(paramString);
      } else {
        paramString = new String("Failed to parse the rule: ");
      }
      Log.e("LogSamplerImpl", paramString);
      return null;
    }
    try
    {
      long l1 = Long.parseLong(paramString.substring(j, i));
      long l2 = Long.parseLong(paramString.substring(i + 1));
      if ((l1 >= 0L) && (l2 >= 0L)) {
        return (zzgw.zza.zzb)zzgw.zza.zzb.zzfz().zzn(str).zzr(l1).zzs(l2).zzbh();
      }
      paramString = new StringBuilder(72);
      paramString.append("negative values not supported: ");
      paramString.append(l1);
      paramString.append("/");
      paramString.append(l2);
      Log.e("LogSamplerImpl", paramString.toString());
      return null;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      if (paramString.length() != 0) {
        paramString = "parseLong() failed while parsing: ".concat(paramString);
      } else {
        paramString = new String("parseLong() failed while parsing: ");
      }
      Log.e("LogSamplerImpl", paramString, localNumberFormatException);
    }
    return null;
  }
  
  @VisibleForTesting
  private static boolean zzb(long paramLong1, long paramLong2, long paramLong3)
  {
    if ((paramLong2 >= 0L) && (paramLong3 > 0L))
    {
      if (paramLong1 >= 0L) {
        paramLong1 %= paramLong3;
      } else {
        paramLong1 = (Long.MAX_VALUE % paramLong3 + 1L + (paramLong1 & 0x7FFFFFFFFFFFFFFF) % paramLong3) % paramLong3;
      }
      if (paramLong1 >= paramLong2) {
        return false;
      }
    }
    return true;
  }
  
  private static boolean zzc(Context paramContext)
  {
    if (zzau == null)
    {
      boolean bool;
      if (Wrappers.packageManager(paramContext).checkCallingOrSelfPermission("com.google.android.providers.gsf.permission.READ_GSERVICES") == 0) {
        bool = true;
      } else {
        bool = false;
      }
      zzau = Boolean.valueOf(bool);
    }
    return zzau.booleanValue();
  }
  
  @VisibleForTesting
  private static long zzd(Context paramContext)
  {
    if (zzav == null)
    {
      long l = 0L;
      if (paramContext != null)
      {
        if (zzc(paramContext)) {
          l = zzy.getLong(paramContext.getContentResolver(), "android_id", 0L);
        }
        zzav = Long.valueOf(l);
      }
      else
      {
        return 0L;
      }
    }
    return zzav.longValue();
  }
  
  public final boolean zza(zze paramzze)
  {
    Object localObject1 = paramzze.zzag;
    Object localObject2 = ((zzr)localObject1).zzj;
    int i = ((zzr)localObject1).zzk;
    paramzze = paramzze.zzaa;
    int j;
    if (paramzze != null) {
      j = paramzze.zzbji;
    } else {
      j = 0;
    }
    boolean bool = ((Boolean)zzaw.get()).booleanValue();
    localObject1 = null;
    Object localObject3;
    if (!bool)
    {
      if ((localObject2 != null) && (!((String)localObject2).isEmpty())) {
        paramzze = (zze)localObject2;
      } else if (i >= 0) {
        paramzze = String.valueOf(i);
      } else {
        paramzze = null;
      }
      if (paramzze != null)
      {
        localObject3 = this.zzh;
        localObject2 = localObject1;
        if (localObject3 != null) {
          if (!zzc((Context)localObject3))
          {
            localObject2 = localObject1;
          }
          else
          {
            localObject3 = zzat;
            localObject1 = (zzae)((HashMap)localObject3).get(paramzze);
            localObject2 = localObject1;
            if (localObject1 == null)
            {
              localObject2 = zzar.zza(paramzze, null);
              ((HashMap)localObject3).put(paramzze, localObject2);
            }
            localObject2 = (String)((zzae)localObject2).get();
          }
        }
        paramzze = zza((String)localObject2);
        if (paramzze != null) {
          return zzb(zza(paramzze.zzfw(), zzd(this.zzh)), paramzze.zzfx(), paramzze.zzfy());
        }
      }
    }
    else
    {
      if ((localObject2 == null) || (((String)localObject2).isEmpty())) {
        if (i >= 0) {
          localObject2 = String.valueOf(i);
        } else {
          localObject2 = null;
        }
      }
      if (localObject2 != null)
      {
        if (this.zzh == null)
        {
          paramzze = Collections.emptyList();
        }
        else
        {
          localObject3 = zzas;
          localObject1 = (zzae)((ConcurrentHashMap)localObject3).get(localObject2);
          paramzze = (zze)localObject1;
          if (localObject1 == null)
          {
            paramzze = zzaq.zza((String)localObject2, zzgw.zza.zzft(), zzq.zzax);
            localObject2 = (zzae)((ConcurrentHashMap)localObject3).putIfAbsent(localObject2, paramzze);
            if (localObject2 != null) {
              paramzze = (zze)localObject2;
            }
          }
          paramzze = ((zzgw.zza)paramzze.get()).zzfs();
        }
        paramzze = paramzze.iterator();
        while (paramzze.hasNext())
        {
          localObject2 = (zzgw.zza.zzb)paramzze.next();
          if (((!((zzgw.zza.zzb)localObject2).zzfv()) || (((zzgw.zza.zzb)localObject2).getEventCode() == 0) || (((zzgw.zza.zzb)localObject2).getEventCode() == j)) && (!zzb(zza(((zzgw.zza.zzb)localObject2).zzfw(), zzd(this.zzh)), ((zzgw.zza.zzb)localObject2).zzfx(), ((zzgw.zza.zzb)localObject2).zzfy()))) {
            return false;
          }
        }
      }
    }
    return true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */