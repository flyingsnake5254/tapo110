package com.google.android.gms.internal.vision;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.net.Uri;
import androidx.annotation.GuardedBy;
import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class zzav
  implements zzaz
{
  @GuardedBy("ConfigurationContentLoader.class")
  private static final Map<Uri, zzav> zzfr = new ArrayMap();
  private static final String[] zzfx = { "key", "value" };
  private final Uri uri;
  private final ContentResolver zzfs;
  private final ContentObserver zzft;
  private final Object zzfu;
  private volatile Map<String, String> zzfv;
  @GuardedBy("this")
  private final List<zzaw> zzfw;
  
  private zzav(ContentResolver paramContentResolver, Uri paramUri)
  {
    zzax localzzax = new zzax(this, null);
    this.zzft = localzzax;
    this.zzfu = new Object();
    this.zzfw = new ArrayList();
    this.zzfs = paramContentResolver;
    this.uri = paramUri;
    paramContentResolver.registerContentObserver(paramUri, false, localzzax);
  }
  
  /* Error */
  public static zzav zza(ContentResolver paramContentResolver, Uri paramUri)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 37	com/google/android/gms/internal/vision/zzav:zzfr	Ljava/util/Map;
    //   6: astore_2
    //   7: aload_2
    //   8: aload_1
    //   9: invokeinterface 81 2 0
    //   14: checkcast 2	com/google/android/gms/internal/vision/zzav
    //   17: astore_3
    //   18: aload_3
    //   19: astore 4
    //   21: aload_3
    //   22: ifnonnull +25 -> 47
    //   25: new 2	com/google/android/gms/internal/vision/zzav
    //   28: astore 4
    //   30: aload 4
    //   32: aload_0
    //   33: aload_1
    //   34: invokespecial 83	com/google/android/gms/internal/vision/zzav:<init>	(Landroid/content/ContentResolver;Landroid/net/Uri;)V
    //   37: aload_2
    //   38: aload_1
    //   39: aload 4
    //   41: invokeinterface 87 3 0
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
    //   17	44	3	localzzav1	zzav
    //   19	43	4	localzzav2	zzav
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
  
  private final Map<String, String> zzv()
  {
    Map localMap1 = this.zzfv;
    Map localMap2 = localMap1;
    if (localMap1 == null) {
      synchronized (this.zzfu)
      {
        localMap1 = this.zzfv;
        localMap2 = localMap1;
        if (localMap1 == null)
        {
          localMap2 = zzx();
          this.zzfv = localMap2;
        }
      }
    }
    if (localMap != null) {
      return localMap;
    }
    return Collections.emptyMap();
  }
  
  /* Error */
  private final Map<String, String> zzx()
  {
    // Byte code:
    //   0: invokestatic 111	android/os/StrictMode:allowThreadDiskReads	()Landroid/os/StrictMode$ThreadPolicy;
    //   3: astore_1
    //   4: new 113	com/google/android/gms/internal/vision/zzau
    //   7: astore_2
    //   8: aload_2
    //   9: aload_0
    //   10: invokespecial 116	com/google/android/gms/internal/vision/zzau:<init>	(Lcom/google/android/gms/internal/vision/zzav;)V
    //   13: aload_2
    //   14: invokestatic 121	com/google/android/gms/internal/vision/zzay:zza	(Lcom/google/android/gms/internal/vision/zzbb;)Ljava/lang/Object;
    //   17: checkcast 77	java/util/Map
    //   20: astore_2
    //   21: aload_1
    //   22: invokestatic 125	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   25: aload_2
    //   26: areturn
    //   27: astore_2
    //   28: goto +18 -> 46
    //   31: astore_2
    //   32: ldc 127
    //   34: ldc -127
    //   36: invokestatic 135	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   39: pop
    //   40: aload_1
    //   41: invokestatic 125	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   44: aconst_null
    //   45: areturn
    //   46: aload_1
    //   47: invokestatic 125	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   50: aload_2
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	zzav
    //   3	44	1	localThreadPolicy	android.os.StrictMode.ThreadPolicy
    //   7	19	2	localObject1	Object
    //   27	1	2	localObject2	Object
    //   31	20	2	localSecurityException	SecurityException
    // Exception table:
    //   from	to	target	type
    //   4	21	27	finally
    //   32	40	27	finally
    //   4	21	31	java/lang/SecurityException
    //   4	21	31	android/database/sqlite/SQLiteException
    //   4	21	31	java/lang/IllegalStateException
  }
  
  static void zzy()
  {
    try
    {
      Iterator localIterator = zzfr.values().iterator();
      while (localIterator.hasNext())
      {
        zzav localzzav = (zzav)localIterator.next();
        localzzav.zzfs.unregisterContentObserver(localzzav.zzft);
      }
      zzfr.clear();
      return;
    }
    finally {}
  }
  
  public final void zzw()
  {
    synchronized (this.zzfu)
    {
      this.zzfv = null;
      zzbj.zzac();
      try
      {
        Iterator localIterator = this.zzfw.iterator();
        while (localIterator.hasNext()) {
          ((zzaw)localIterator.next()).zzaa();
        }
        return;
      }
      finally {}
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzav.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */