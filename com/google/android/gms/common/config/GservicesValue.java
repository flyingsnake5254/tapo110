package com.google.android.gms.common.config;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashSet;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
public abstract class GservicesValue<T>
{
  private static final Object sLock = new Object();
  private static zza zzbm;
  private static int zzbn;
  private static Context zzbo;
  @GuardedBy("sLock")
  private static HashSet<String> zzbp;
  protected final String mKey;
  protected final T zzbq;
  private T zzbr = null;
  
  protected GservicesValue(String paramString, T paramT)
  {
    this.mKey = paramString;
    this.zzbq = paramT;
  }
  
  @KeepForSdk
  public static boolean isInitialized()
  {
    synchronized (sLock)
    {
      return false;
    }
  }
  
  @KeepForSdk
  public static GservicesValue<Float> value(String paramString, Float paramFloat)
  {
    return new zzd(paramString, paramFloat);
  }
  
  @KeepForSdk
  public static GservicesValue<Integer> value(String paramString, Integer paramInteger)
  {
    return new zzc(paramString, paramInteger);
  }
  
  @KeepForSdk
  public static GservicesValue<Long> value(String paramString, Long paramLong)
  {
    return new zzb(paramString, paramLong);
  }
  
  @KeepForSdk
  public static GservicesValue<String> value(String paramString1, String paramString2)
  {
    return new zze(paramString1, paramString2);
  }
  
  @KeepForSdk
  public static GservicesValue<Boolean> value(String paramString, boolean paramBoolean)
  {
    return new zza(paramString, Boolean.valueOf(paramBoolean));
  }
  
  private static boolean zzi()
  {
    synchronized (sLock)
    {
      return false;
    }
  }
  
  /* Error */
  @KeepForSdk
  public final T get()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 38	com/google/android/gms/common/config/GservicesValue:zzbr	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnull +5 -> 11
    //   9: aload_1
    //   10: areturn
    //   11: invokestatic 99	android/os/StrictMode:allowThreadDiskReads	()Landroid/os/StrictMode$ThreadPolicy;
    //   14: astore_1
    //   15: getstatic 34	com/google/android/gms/common/config/GservicesValue:sLock	Ljava/lang/Object;
    //   18: astore_2
    //   19: aload_2
    //   20: monitorenter
    //   21: aload_2
    //   22: monitorexit
    //   23: aload_2
    //   24: monitorenter
    //   25: aconst_null
    //   26: putstatic 101	com/google/android/gms/common/config/GservicesValue:zzbp	Ljava/util/HashSet;
    //   29: aconst_null
    //   30: putstatic 103	com/google/android/gms/common/config/GservicesValue:zzbo	Landroid/content/Context;
    //   33: aload_2
    //   34: monitorexit
    //   35: aload_0
    //   36: aload_0
    //   37: getfield 40	com/google/android/gms/common/config/GservicesValue:mKey	Ljava/lang/String;
    //   40: invokevirtual 107	com/google/android/gms/common/config/GservicesValue:zzd	(Ljava/lang/String;)Ljava/lang/Object;
    //   43: astore_2
    //   44: aload_1
    //   45: invokestatic 111	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   48: aload_2
    //   49: areturn
    //   50: astore_2
    //   51: goto +34 -> 85
    //   54: astore_2
    //   55: invokestatic 117	android/os/Binder:clearCallingIdentity	()J
    //   58: lstore_3
    //   59: aload_0
    //   60: aload_0
    //   61: getfield 40	com/google/android/gms/common/config/GservicesValue:mKey	Ljava/lang/String;
    //   64: invokevirtual 107	com/google/android/gms/common/config/GservicesValue:zzd	(Ljava/lang/String;)Ljava/lang/Object;
    //   67: astore_2
    //   68: lload_3
    //   69: invokestatic 121	android/os/Binder:restoreCallingIdentity	(J)V
    //   72: aload_1
    //   73: invokestatic 111	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   76: aload_2
    //   77: areturn
    //   78: astore_2
    //   79: lload_3
    //   80: invokestatic 121	android/os/Binder:restoreCallingIdentity	(J)V
    //   83: aload_2
    //   84: athrow
    //   85: aload_1
    //   86: invokestatic 111	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   89: aload_2
    //   90: athrow
    //   91: astore_1
    //   92: aload_2
    //   93: monitorexit
    //   94: aload_1
    //   95: athrow
    //   96: astore_1
    //   97: aload_2
    //   98: monitorexit
    //   99: aload_1
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	GservicesValue
    //   4	82	1	localObject1	Object
    //   91	4	1	localObject2	Object
    //   96	4	1	localObject3	Object
    //   18	31	2	localObject4	Object
    //   50	1	2	localObject5	Object
    //   54	1	2	localSecurityException	SecurityException
    //   67	10	2	localObject6	Object
    //   78	20	2	localObject7	Object
    //   58	22	3	l	long
    // Exception table:
    //   from	to	target	type
    //   35	44	50	finally
    //   55	59	50	finally
    //   68	72	50	finally
    //   79	85	50	finally
    //   35	44	54	java/lang/SecurityException
    //   59	68	78	finally
    //   25	35	91	finally
    //   92	94	91	finally
    //   21	23	96	finally
    //   97	99	96	finally
  }
  
  @Deprecated
  @KeepForSdk
  public final T getBinderSafe()
  {
    return (T)get();
  }
  
  @KeepForSdk
  @VisibleForTesting
  public void override(T arg1)
  {
    Log.w("GservicesValue", "GservicesValue.override(): test should probably call initForTests() first");
    this.zzbr = ???;
    synchronized (sLock)
    {
      zzi();
      return;
    }
  }
  
  @KeepForSdk
  @VisibleForTesting
  public void resetOverride()
  {
    this.zzbr = null;
  }
  
  protected abstract T zzd(String paramString);
  
  private static abstract interface zza
  {
    public abstract Long getLong(String paramString, Long paramLong);
    
    public abstract String getString(String paramString1, String paramString2);
    
    public abstract Boolean zza(String paramString, Boolean paramBoolean);
    
    public abstract Float zza(String paramString, Float paramFloat);
    
    public abstract Integer zza(String paramString, Integer paramInteger);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\config\GservicesValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */