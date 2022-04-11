package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import androidx.collection.LruCache;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzc;
import com.google.android.gms.internal.measurement.zzd;
import com.google.android.gms.internal.measurement.zzez;
import com.google.android.gms.internal.measurement.zzfb;
import com.google.android.gms.internal.measurement.zzfc;
import com.google.android.gms.internal.measurement.zzfe;
import com.google.android.gms.internal.measurement.zzgk;
import com.google.android.gms.internal.measurement.zzgm;
import com.google.android.gms.internal.measurement.zzgo;
import com.google.android.gms.internal.measurement.zzio;
import com.google.android.gms.internal.measurement.zzjz;
import com.google.android.gms.internal.measurement.zzpn;
import com.google.android.gms.internal.measurement.zzpt;
import com.google.android.gms.internal.measurement.zzr;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public final class zzfl
  extends zzke
  implements zzad
{
  @VisibleForTesting
  final LruCache<String, zzc> zza = new zzfi(this, 20);
  final zzr zzb = new zzfj(this);
  private final Map<String, Map<String, String>> zzc = new ArrayMap();
  private final Map<String, Map<String, Boolean>> zzd = new ArrayMap();
  private final Map<String, Map<String, Boolean>> zze = new ArrayMap();
  private final Map<String, zzfc> zzg = new ArrayMap();
  private final Map<String, Map<String, Integer>> zzh = new ArrayMap();
  private final Map<String, String> zzi = new ArrayMap();
  
  zzfl(zzkn paramzzkn)
  {
    super(paramzzkn);
  }
  
  /* Error */
  @WorkerThread
  private final void zzq(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 65	com/google/android/gms/measurement/internal/zzke:zzZ	()V
    //   4: aload_0
    //   5: invokevirtual 136	com/google/android/gms/measurement/internal/zzgn:zzg	()V
    //   8: aload_1
    //   9: invokestatic 71	com/google/android/gms/common/internal/Preconditions:checkNotEmpty	(Ljava/lang/String;)Ljava/lang/String;
    //   12: pop
    //   13: aload_0
    //   14: getfield 41	com/google/android/gms/measurement/internal/zzfl:zzg	Ljava/util/Map;
    //   17: aload_1
    //   18: invokeinterface 112 2 0
    //   23: ifnonnull +482 -> 505
    //   26: aload_0
    //   27: getfield 142	com/google/android/gms/measurement/internal/zzkd:zzf	Lcom/google/android/gms/measurement/internal/zzkn;
    //   30: invokevirtual 147	com/google/android/gms/measurement/internal/zzkn:zzi	()Lcom/google/android/gms/measurement/internal/zzai;
    //   33: astore_2
    //   34: aload_1
    //   35: invokestatic 71	com/google/android/gms/common/internal/Preconditions:checkNotEmpty	(Ljava/lang/String;)Ljava/lang/String;
    //   38: pop
    //   39: aload_2
    //   40: invokevirtual 136	com/google/android/gms/measurement/internal/zzgn:zzg	()V
    //   43: aload_2
    //   44: invokevirtual 65	com/google/android/gms/measurement/internal/zzke:zzZ	()V
    //   47: aconst_null
    //   48: astore_3
    //   49: aload_2
    //   50: invokevirtual 152	com/google/android/gms/measurement/internal/zzai:zze	()Landroid/database/sqlite/SQLiteDatabase;
    //   53: ldc -102
    //   55: iconst_2
    //   56: anewarray 156	java/lang/String
    //   59: dup
    //   60: iconst_0
    //   61: ldc -98
    //   63: aastore
    //   64: dup
    //   65: iconst_1
    //   66: ldc -96
    //   68: aastore
    //   69: ldc -94
    //   71: iconst_1
    //   72: anewarray 156	java/lang/String
    //   75: dup
    //   76: iconst_0
    //   77: aload_1
    //   78: aastore
    //   79: aconst_null
    //   80: aconst_null
    //   81: aconst_null
    //   82: invokevirtual 168	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   85: astore 4
    //   87: aload 4
    //   89: astore_3
    //   90: aload 4
    //   92: invokeinterface 173 1 0
    //   97: ifne +6 -> 103
    //   100: goto +148 -> 248
    //   103: aload 4
    //   105: astore_3
    //   106: aload 4
    //   108: iconst_0
    //   109: invokeinterface 177 2 0
    //   114: astore 5
    //   116: aload 4
    //   118: astore_3
    //   119: aload 4
    //   121: iconst_1
    //   122: invokeinterface 181 2 0
    //   127: astore 6
    //   129: aload 4
    //   131: astore_3
    //   132: aload 4
    //   134: invokeinterface 184 1 0
    //   139: ifeq +25 -> 164
    //   142: aload 4
    //   144: astore_3
    //   145: aload_2
    //   146: getfield 82	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   149: invokevirtual 188	com/google/android/gms/measurement/internal/zzfu:zzau	()Lcom/google/android/gms/measurement/internal/zzem;
    //   152: invokevirtual 193	com/google/android/gms/measurement/internal/zzem:zzb	()Lcom/google/android/gms/measurement/internal/zzek;
    //   155: ldc -61
    //   157: aload_1
    //   158: invokestatic 199	com/google/android/gms/measurement/internal/zzem:zzl	(Ljava/lang/String;)Ljava/lang/Object;
    //   161: invokevirtual 204	com/google/android/gms/measurement/internal/zzek:zzb	(Ljava/lang/String;Ljava/lang/Object;)V
    //   164: aload 5
    //   166: ifnonnull +6 -> 172
    //   169: goto +79 -> 248
    //   172: aload 4
    //   174: astore_3
    //   175: new 206	android/util/Pair
    //   178: dup
    //   179: aload 5
    //   181: aload 6
    //   183: invokespecial 209	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   186: astore 6
    //   188: aload 4
    //   190: invokeinterface 212 1 0
    //   195: aload 6
    //   197: astore 4
    //   199: goto +59 -> 258
    //   202: astore 6
    //   204: goto +15 -> 219
    //   207: astore 4
    //   209: aload_3
    //   210: astore_1
    //   211: goto +281 -> 492
    //   214: astore 6
    //   216: aconst_null
    //   217: astore 4
    //   219: aload 4
    //   221: astore_3
    //   222: aload_2
    //   223: getfield 82	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   226: invokevirtual 188	com/google/android/gms/measurement/internal/zzfu:zzau	()Lcom/google/android/gms/measurement/internal/zzem;
    //   229: invokevirtual 193	com/google/android/gms/measurement/internal/zzem:zzb	()Lcom/google/android/gms/measurement/internal/zzek;
    //   232: ldc -42
    //   234: aload_1
    //   235: invokestatic 199	com/google/android/gms/measurement/internal/zzem:zzl	(Ljava/lang/String;)Ljava/lang/Object;
    //   238: aload 6
    //   240: invokevirtual 217	com/google/android/gms/measurement/internal/zzek:zzc	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   243: aload 4
    //   245: ifnull +10 -> 255
    //   248: aload 4
    //   250: invokeinterface 212 1 0
    //   255: aconst_null
    //   256: astore 4
    //   258: aload 4
    //   260: ifnonnull +76 -> 336
    //   263: aload_0
    //   264: getfield 35	com/google/android/gms/measurement/internal/zzfl:zzc	Ljava/util/Map;
    //   267: aload_1
    //   268: aconst_null
    //   269: invokeinterface 221 3 0
    //   274: pop
    //   275: aload_0
    //   276: getfield 37	com/google/android/gms/measurement/internal/zzfl:zzd	Ljava/util/Map;
    //   279: aload_1
    //   280: aconst_null
    //   281: invokeinterface 221 3 0
    //   286: pop
    //   287: aload_0
    //   288: getfield 39	com/google/android/gms/measurement/internal/zzfl:zze	Ljava/util/Map;
    //   291: aload_1
    //   292: aconst_null
    //   293: invokeinterface 221 3 0
    //   298: pop
    //   299: aload_0
    //   300: getfield 41	com/google/android/gms/measurement/internal/zzfl:zzg	Ljava/util/Map;
    //   303: aload_1
    //   304: aconst_null
    //   305: invokeinterface 221 3 0
    //   310: pop
    //   311: aload_0
    //   312: getfield 43	com/google/android/gms/measurement/internal/zzfl:zzi	Ljava/util/Map;
    //   315: aload_1
    //   316: aconst_null
    //   317: invokeinterface 221 3 0
    //   322: pop
    //   323: aload_0
    //   324: getfield 45	com/google/android/gms/measurement/internal/zzfl:zzh	Ljava/util/Map;
    //   327: aload_1
    //   328: aconst_null
    //   329: invokeinterface 221 3 0
    //   334: pop
    //   335: return
    //   336: aload_0
    //   337: aload_1
    //   338: aload 4
    //   340: getfield 225	android/util/Pair:first	Ljava/lang/Object;
    //   343: checkcast 227	[B
    //   346: invokespecial 231	com/google/android/gms/measurement/internal/zzfl:zzt	(Ljava/lang/String;[B)Lcom/google/android/gms/internal/measurement/zzfc;
    //   349: invokevirtual 237	com/google/android/gms/internal/measurement/zzkd:zzbu	()Lcom/google/android/gms/internal/measurement/zzjz;
    //   352: checkcast 239	com/google/android/gms/internal/measurement/zzfb
    //   355: astore_3
    //   356: aload_0
    //   357: aload_1
    //   358: aload_3
    //   359: invokespecial 243	com/google/android/gms/measurement/internal/zzfl:zzr	(Ljava/lang/String;Lcom/google/android/gms/internal/measurement/zzfb;)V
    //   362: aload_0
    //   363: getfield 35	com/google/android/gms/measurement/internal/zzfl:zzc	Ljava/util/Map;
    //   366: aload_1
    //   367: aload_3
    //   368: invokevirtual 249	com/google/android/gms/internal/measurement/zzjz:zzaA	()Lcom/google/android/gms/internal/measurement/zzkd;
    //   371: checkcast 114	com/google/android/gms/internal/measurement/zzfc
    //   374: invokestatic 253	com/google/android/gms/measurement/internal/zzfl:zzu	(Lcom/google/android/gms/internal/measurement/zzfc;)Ljava/util/Map;
    //   377: invokeinterface 221 3 0
    //   382: pop
    //   383: aload_0
    //   384: getfield 41	com/google/android/gms/measurement/internal/zzfl:zzg	Ljava/util/Map;
    //   387: aload_1
    //   388: aload_3
    //   389: invokevirtual 249	com/google/android/gms/internal/measurement/zzjz:zzaA	()Lcom/google/android/gms/internal/measurement/zzkd;
    //   392: checkcast 114	com/google/android/gms/internal/measurement/zzfc
    //   395: invokeinterface 221 3 0
    //   400: pop
    //   401: invokestatic 76	com/google/android/gms/internal/measurement/zzpt:zzb	()Z
    //   404: pop
    //   405: aload_0
    //   406: getfield 82	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   409: invokevirtual 87	com/google/android/gms/measurement/internal/zzfu:zzc	()Lcom/google/android/gms/measurement/internal/zzae;
    //   412: aconst_null
    //   413: getstatic 93	com/google/android/gms/measurement/internal/zzea:zzaD	Lcom/google/android/gms/measurement/internal/zzdz;
    //   416: invokevirtual 99	com/google/android/gms/measurement/internal/zzae:zzn	(Ljava/lang/String;Lcom/google/android/gms/measurement/internal/zzdz;)Z
    //   419: ifeq +15 -> 434
    //   422: aload_0
    //   423: aload_1
    //   424: aload_3
    //   425: invokevirtual 249	com/google/android/gms/internal/measurement/zzjz:zzaA	()Lcom/google/android/gms/internal/measurement/zzkd;
    //   428: checkcast 114	com/google/android/gms/internal/measurement/zzfc
    //   431: invokespecial 117	com/google/android/gms/measurement/internal/zzfl:zzs	(Ljava/lang/String;Lcom/google/android/gms/internal/measurement/zzfc;)V
    //   434: invokestatic 256	com/google/android/gms/internal/measurement/zzpn:zzb	()Z
    //   437: pop
    //   438: aload_0
    //   439: getfield 82	com/google/android/gms/measurement/internal/zzgn:zzs	Lcom/google/android/gms/measurement/internal/zzfu;
    //   442: invokevirtual 87	com/google/android/gms/measurement/internal/zzfu:zzc	()Lcom/google/android/gms/measurement/internal/zzae;
    //   445: aconst_null
    //   446: getstatic 259	com/google/android/gms/measurement/internal/zzea:zzaB	Lcom/google/android/gms/measurement/internal/zzdz;
    //   449: invokevirtual 99	com/google/android/gms/measurement/internal/zzae:zzn	(Ljava/lang/String;Lcom/google/android/gms/measurement/internal/zzdz;)Z
    //   452: ifeq +23 -> 475
    //   455: aload_0
    //   456: getfield 43	com/google/android/gms/measurement/internal/zzfl:zzi	Ljava/util/Map;
    //   459: aload_1
    //   460: aload 4
    //   462: getfield 262	android/util/Pair:second	Ljava/lang/Object;
    //   465: checkcast 156	java/lang/String
    //   468: invokeinterface 221 3 0
    //   473: pop
    //   474: return
    //   475: aload_0
    //   476: getfield 43	com/google/android/gms/measurement/internal/zzfl:zzi	Ljava/util/Map;
    //   479: aload_1
    //   480: aconst_null
    //   481: invokeinterface 221 3 0
    //   486: pop
    //   487: return
    //   488: astore 4
    //   490: aload_3
    //   491: astore_1
    //   492: aload_1
    //   493: ifnull +9 -> 502
    //   496: aload_1
    //   497: invokeinterface 212 1 0
    //   502: aload 4
    //   504: athrow
    //   505: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	506	0	this	zzfl
    //   0	506	1	paramString	String
    //   33	190	2	localzzai	zzai
    //   48	443	3	localObject1	Object
    //   85	113	4	localObject2	Object
    //   207	1	4	localObject3	Object
    //   217	244	4	localObject4	Object
    //   488	15	4	localObject5	Object
    //   114	66	5	arrayOfByte	byte[]
    //   127	69	6	localObject6	Object
    //   202	1	6	localSQLiteException1	android.database.sqlite.SQLiteException
    //   214	25	6	localSQLiteException2	android.database.sqlite.SQLiteException
    // Exception table:
    //   from	to	target	type
    //   90	100	202	android/database/sqlite/SQLiteException
    //   106	116	202	android/database/sqlite/SQLiteException
    //   119	129	202	android/database/sqlite/SQLiteException
    //   132	142	202	android/database/sqlite/SQLiteException
    //   145	164	202	android/database/sqlite/SQLiteException
    //   175	188	202	android/database/sqlite/SQLiteException
    //   49	87	207	finally
    //   49	87	214	android/database/sqlite/SQLiteException
    //   90	100	488	finally
    //   106	116	488	finally
    //   119	129	488	finally
    //   132	142	488	finally
    //   145	164	488	finally
    //   175	188	488	finally
    //   222	243	488	finally
  }
  
  private final void zzr(String paramString, zzfb paramzzfb)
  {
    ArrayMap localArrayMap1 = new ArrayMap();
    ArrayMap localArrayMap2 = new ArrayMap();
    ArrayMap localArrayMap3 = new ArrayMap();
    if (paramzzfb != null) {
      for (int i = 0; i < paramzzfb.zza(); i++)
      {
        zzez localzzez = (zzez)paramzzfb.zzb(i).zzbu();
        if (TextUtils.isEmpty(localzzez.zza()))
        {
          this.zzs.zzau().zze().zza("EventConfig contained null event name");
        }
        else
        {
          String str1 = localzzez.zza();
          String str2 = zzgr.zzb(localzzez.zza());
          if (!TextUtils.isEmpty(str2))
          {
            localzzez.zzb(str2);
            paramzzfb.zzc(i, localzzez);
          }
          localArrayMap1.put(str1, Boolean.valueOf(localzzez.zzc()));
          localArrayMap2.put(localzzez.zza(), Boolean.valueOf(localzzez.zzd()));
          if (localzzez.zze()) {
            if ((localzzez.zzf() >= 2) && (localzzez.zzf() <= 65535)) {
              localArrayMap3.put(localzzez.zza(), Integer.valueOf(localzzez.zzf()));
            } else {
              this.zzs.zzau().zze().zzc("Invalid sampling rate. Event name, sample rate", localzzez.zza(), Integer.valueOf(localzzez.zzf()));
            }
          }
        }
      }
    }
    this.zzd.put(paramString, localArrayMap1);
    this.zze.put(paramString, localArrayMap2);
    this.zzh.put(paramString, localArrayMap3);
  }
  
  @WorkerThread
  private final void zzs(String paramString, zzfc paramzzfc)
  {
    if (paramzzfc.zzk() != 0)
    {
      this.zzs.zzau().zzk().zzb("EES programs found", Integer.valueOf(paramzzfc.zzk()));
      paramzzfc = (zzgo)paramzzfc.zzj().get(0);
      try
      {
        Object localObject1 = new com/google/android/gms/internal/measurement/zzc;
        ((zzc)localObject1).<init>();
        Object localObject2 = new com/google/android/gms/measurement/internal/zzfg;
        ((zzfg)localObject2).<init>(this, paramString);
        ((zzc)localObject1).zza("internal.remoteConfig", (Callable)localObject2);
        localObject2 = new com/google/android/gms/measurement/internal/zzfh;
        ((zzfh)localObject2).<init>(this);
        ((zzc)localObject1).zza("internal.logger", (Callable)localObject2);
        ((zzc)localObject1).zzf(paramzzfc);
        this.zza.put(paramString, localObject1);
        this.zzs.zzau().zzk().zzc("EES program loaded for appId, activities", paramString, Integer.valueOf(paramzzfc.zzb().zzb()));
        paramzzfc = paramzzfc.zzb().zza().iterator();
        while (paramzzfc.hasNext())
        {
          localObject1 = (zzgm)paramzzfc.next();
          this.zzs.zzau().zzk().zzb("EES program activity", ((zzgm)localObject1).zza());
        }
        return;
      }
      catch (zzd paramzzfc)
      {
        this.zzs.zzau().zzb().zzb("Failed to load EES program. appId", paramString);
        return;
      }
    }
    this.zza.remove(paramString);
  }
  
  @WorkerThread
  private final zzfc zzt(String paramString, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return zzfc.zzn();
    }
    try
    {
      zzfc localzzfc = (zzfc)((zzfb)zzkp.zzt(zzfc.zzm(), paramArrayOfByte)).zzaA();
      zzek localzzek = this.zzs.zzau().zzk();
      boolean bool = localzzfc.zza();
      String str = null;
      if (bool) {
        paramArrayOfByte = Long.valueOf(localzzfc.zzb());
      } else {
        paramArrayOfByte = null;
      }
      if (localzzfc.zzc()) {
        str = localzzfc.zzd();
      }
      localzzek.zzc("Parsed config. version, gmp_app_id", paramArrayOfByte, str);
      return localzzfc;
    }
    catch (RuntimeException paramArrayOfByte)
    {
      this.zzs.zzau().zze().zzc("Unable to merge remote config. appId", zzem.zzl(paramString), paramArrayOfByte);
      return zzfc.zzn();
    }
    catch (com.google.android.gms.internal.measurement.zzkn paramArrayOfByte)
    {
      this.zzs.zzau().zze().zzc("Unable to merge remote config. appId", zzem.zzl(paramString), paramArrayOfByte);
    }
    return zzfc.zzn();
  }
  
  private static final Map<String, String> zzu(zzfc paramzzfc)
  {
    ArrayMap localArrayMap = new ArrayMap();
    if (paramzzfc != null)
    {
      Iterator localIterator = paramzzfc.zze().iterator();
      while (localIterator.hasNext())
      {
        paramzzfc = (zzfe)localIterator.next();
        localArrayMap.put(paramzzfc.zza(), paramzzfc.zzb());
      }
    }
    return localArrayMap;
  }
  
  @WorkerThread
  public final String zza(String paramString1, String paramString2)
  {
    zzg();
    zzq(paramString1);
    paramString1 = (Map)this.zzc.get(paramString1);
    if (paramString1 != null) {
      return (String)paramString1.get(paramString2);
    }
    return null;
  }
  
  protected final boolean zzaA()
  {
    return false;
  }
  
  @WorkerThread
  protected final zzfc zzb(String paramString)
  {
    zzZ();
    zzg();
    Preconditions.checkNotEmpty(paramString);
    zzq(paramString);
    return (zzfc)this.zzg.get(paramString);
  }
  
  @WorkerThread
  protected final String zzc(String paramString)
  {
    zzg();
    return (String)this.zzi.get(paramString);
  }
  
  @WorkerThread
  protected final void zzd(String paramString)
  {
    zzg();
    this.zzi.put(paramString, null);
  }
  
  @WorkerThread
  final void zze(String paramString)
  {
    zzg();
    this.zzg.remove(paramString);
  }
  
  @WorkerThread
  final boolean zzf(String paramString)
  {
    zzg();
    paramString = zzb(paramString);
    if (paramString == null) {
      return false;
    }
    return paramString.zzi();
  }
  
  public final boolean zzh(String paramString)
  {
    zzpt.zzb();
    if (this.zzs.zzc().zzn(null, zzea.zzaD))
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      paramString = (zzfc)this.zzg.get(paramString);
      if (paramString == null) {
        return false;
      }
      if (paramString.zzk() != 0) {
        return true;
      }
    }
    return false;
  }
  
  @WorkerThread
  protected final boolean zzi(String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    zzZ();
    zzg();
    Preconditions.checkNotEmpty(paramString1);
    zzfb localzzfb = (zzfb)zzt(paramString1, paramArrayOfByte).zzbu();
    if (localzzfb == null) {
      return false;
    }
    zzr(paramString1, localzzfb);
    zzpt.zzb();
    if (this.zzs.zzc().zzn(null, zzea.zzaD)) {
      zzs(paramString1, (zzfc)localzzfb.zzaA());
    }
    this.zzg.put(paramString1, (zzfc)localzzfb.zzaA());
    this.zzi.put(paramString1, paramString2);
    this.zzc.put(paramString1, zzu((zzfc)localzzfb.zzaA()));
    this.zzf.zzi().zzL(paramString1, new ArrayList(localzzfb.zzd()));
    try
    {
      localzzfb.zze();
      byte[] arrayOfByte = ((zzfc)localzzfb.zzaA()).zzbp();
      paramArrayOfByte = arrayOfByte;
    }
    catch (RuntimeException localRuntimeException)
    {
      this.zzs.zzau().zze().zzc("Unable to serialize reduced-size config. Storing full config instead. appId", zzem.zzl(paramString1), localRuntimeException);
    }
    zzpn.zzb();
    if (this.zzs.zzc().zzn(null, zzea.zzaB)) {
      this.zzf.zzi().zzw(paramString1, paramArrayOfByte, paramString2);
    } else {
      this.zzf.zzi().zzw(paramString1, paramArrayOfByte, null);
    }
    this.zzg.put(paramString1, (zzfc)localzzfb.zzaA());
    return true;
  }
  
  @WorkerThread
  final boolean zzj(String paramString1, String paramString2)
  {
    zzg();
    zzq(paramString1);
    if ((zzm(paramString1)) && (zzku.zzR(paramString2))) {
      return true;
    }
    if ((zzn(paramString1)) && (zzku.zzh(paramString2))) {
      return true;
    }
    paramString1 = (Map)this.zzd.get(paramString1);
    if (paramString1 != null)
    {
      paramString1 = (Boolean)paramString1.get(paramString2);
      if (paramString1 == null) {
        return false;
      }
      return paramString1.booleanValue();
    }
    return false;
  }
  
  @WorkerThread
  final boolean zzk(String paramString1, String paramString2)
  {
    zzg();
    zzq(paramString1);
    if ("ecommerce_purchase".equals(paramString2)) {
      return true;
    }
    if ((!"purchase".equals(paramString2)) && (!"refund".equals(paramString2)))
    {
      paramString1 = (Map)this.zze.get(paramString1);
      if (paramString1 != null)
      {
        paramString1 = (Boolean)paramString1.get(paramString2);
        if (paramString1 == null) {
          return false;
        }
        return paramString1.booleanValue();
      }
      return false;
    }
    return true;
  }
  
  @WorkerThread
  final int zzl(String paramString1, String paramString2)
  {
    zzg();
    zzq(paramString1);
    paramString1 = (Map)this.zzh.get(paramString1);
    if (paramString1 != null)
    {
      paramString1 = (Integer)paramString1.get(paramString2);
      if (paramString1 == null) {
        return 1;
      }
      return paramString1.intValue();
    }
    return 1;
  }
  
  final boolean zzm(String paramString)
  {
    return "1".equals(zza(paramString, "measurement.upload.blacklist_internal"));
  }
  
  final boolean zzn(String paramString)
  {
    return "1".equals(zza(paramString, "measurement.upload.blacklist_public"));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzfl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */