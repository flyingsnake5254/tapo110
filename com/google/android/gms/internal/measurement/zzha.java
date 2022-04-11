package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.net.Uri;
import androidx.annotation.GuardedBy;
import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class zzha
  implements zzhe
{
  public static final String[] zza = { "key", "value" };
  @GuardedBy("ConfigurationContentLoader.class")
  private static final Map<Uri, zzha> zzb = new ArrayMap();
  private final ContentResolver zzc;
  private final Uri zzd;
  private final ContentObserver zze;
  private final Object zzf;
  private volatile Map<String, String> zzg;
  @GuardedBy("this")
  private final List<zzhb> zzh;
  
  private zzha(ContentResolver paramContentResolver, Uri paramUri)
  {
    zzgz localzzgz = new zzgz(this, null);
    this.zze = localzzgz;
    this.zzf = new Object();
    this.zzh = new ArrayList();
    Objects.requireNonNull(paramContentResolver);
    Objects.requireNonNull(paramUri);
    this.zzc = paramContentResolver;
    this.zzd = paramUri;
    paramContentResolver.registerContentObserver(paramUri, false, localzzgz);
  }
  
  /* Error */
  public static zzha zza(ContentResolver paramContentResolver, Uri paramUri)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 37	com/google/android/gms/internal/measurement/zzha:zzb	Ljava/util/Map;
    //   6: astore_2
    //   7: aload_2
    //   8: aload_1
    //   9: invokeinterface 85 2 0
    //   14: checkcast 2	com/google/android/gms/internal/measurement/zzha
    //   17: astore_3
    //   18: aload_3
    //   19: astore 4
    //   21: aload_3
    //   22: ifnonnull +25 -> 47
    //   25: new 2	com/google/android/gms/internal/measurement/zzha
    //   28: astore 4
    //   30: aload 4
    //   32: aload_0
    //   33: aload_1
    //   34: invokespecial 87	com/google/android/gms/internal/measurement/zzha:<init>	(Landroid/content/ContentResolver;Landroid/net/Uri;)V
    //   37: aload_2
    //   38: aload_1
    //   39: aload 4
    //   41: invokeinterface 91 3 0
    //   46: pop
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload 4
    //   52: areturn
    //   53: astore_0
    //   54: ldc 2
    //   56: monitorexit
    //   57: aload_0
    //   58: athrow
    //   59: astore_0
    //   60: aload_3
    //   61: astore 4
    //   63: goto -16 -> 47
    //   66: astore_0
    //   67: goto -20 -> 47
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	paramContentResolver	ContentResolver
    //   0	70	1	paramUri	Uri
    //   6	32	2	localMap	Map
    //   17	44	3	localzzha1	zzha
    //   19	43	4	localzzha2	zzha
    // Exception table:
    //   from	to	target	type
    //   3	18	53	finally
    //   25	37	53	finally
    //   37	47	53	finally
    //   47	50	53	finally
    //   54	57	53	finally
    //   25	37	59	java/lang/SecurityException
    //   37	47	66	java/lang/SecurityException
  }
  
  static void zzd()
  {
    try
    {
      Iterator localIterator = zzb.values().iterator();
      while (localIterator.hasNext())
      {
        zzha localzzha = (zzha)localIterator.next();
        localzzha.zzc.unregisterContentObserver(localzzha.zze);
      }
      zzb.clear();
      return;
    }
    finally {}
  }
  
  /* Error */
  public final Map<String, String> zzb()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 125	com/google/android/gms/internal/measurement/zzha:zzg	Ljava/util/Map;
    //   4: astore_1
    //   5: aload_1
    //   6: astore_2
    //   7: aload_1
    //   8: ifnonnull +92 -> 100
    //   11: aload_0
    //   12: getfield 56	com/google/android/gms/internal/measurement/zzha:zzf	Ljava/lang/Object;
    //   15: astore_3
    //   16: aload_3
    //   17: monitorenter
    //   18: aload_0
    //   19: getfield 125	com/google/android/gms/internal/measurement/zzha:zzg	Ljava/util/Map;
    //   22: astore_1
    //   23: aload_1
    //   24: astore_2
    //   25: aload_1
    //   26: ifnonnull +64 -> 90
    //   29: invokestatic 131	android/os/StrictMode:allowThreadDiskReads	()Landroid/os/StrictMode$ThreadPolicy;
    //   32: astore_1
    //   33: new 133	com/google/android/gms/internal/measurement/zzgy
    //   36: astore_2
    //   37: aload_2
    //   38: aload_0
    //   39: invokespecial 136	com/google/android/gms/internal/measurement/zzgy:<init>	(Lcom/google/android/gms/internal/measurement/zzha;)V
    //   42: aload_2
    //   43: invokestatic 141	com/google/android/gms/internal/measurement/zzhc:zza	(Lcom/google/android/gms/internal/measurement/zzhd;)Ljava/lang/Object;
    //   46: checkcast 82	java/util/Map
    //   49: astore_2
    //   50: aload_1
    //   51: invokestatic 145	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   54: goto +22 -> 76
    //   57: astore_2
    //   58: goto +26 -> 84
    //   61: astore_2
    //   62: ldc -109
    //   64: ldc -107
    //   66: invokestatic 155	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   69: pop
    //   70: aload_1
    //   71: invokestatic 145	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   74: aconst_null
    //   75: astore_2
    //   76: aload_0
    //   77: aload_2
    //   78: putfield 125	com/google/android/gms/internal/measurement/zzha:zzg	Ljava/util/Map;
    //   81: goto +9 -> 90
    //   84: aload_1
    //   85: invokestatic 145	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   88: aload_2
    //   89: athrow
    //   90: aload_3
    //   91: monitorexit
    //   92: goto +8 -> 100
    //   95: astore_2
    //   96: aload_3
    //   97: monitorexit
    //   98: aload_2
    //   99: athrow
    //   100: aload_2
    //   101: ifnull +5 -> 106
    //   104: aload_2
    //   105: areturn
    //   106: invokestatic 160	java/util/Collections:emptyMap	()Ljava/util/Map;
    //   109: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	this	zzha
    //   4	81	1	localObject1	Object
    //   6	44	2	localObject2	Object
    //   57	1	2	localObject3	Object
    //   61	1	2	localSecurityException	SecurityException
    //   75	14	2	localMap	Map
    //   95	10	2	localMap1	Map<String, String>
    //   15	82	3	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   33	50	57	finally
    //   62	70	57	finally
    //   33	50	61	java/lang/SecurityException
    //   33	50	61	android/database/sqlite/SQLiteException
    //   33	50	61	java/lang/IllegalStateException
    //   18	23	95	finally
    //   29	33	95	finally
    //   50	54	95	finally
    //   70	74	95	finally
    //   76	81	95	finally
    //   84	90	95	finally
    //   90	92	95	finally
    //   96	98	95	finally
  }
  
  public final void zzc()
  {
    synchronized (this.zzf)
    {
      this.zzg = null;
      zzht.zzc();
      try
      {
        ??? = this.zzh.iterator();
        while (((Iterator)???).hasNext()) {
          ((zzhb)((Iterator)???).next()).zza();
        }
        return;
      }
      finally {}
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzha.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */