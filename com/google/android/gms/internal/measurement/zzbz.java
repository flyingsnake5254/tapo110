package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.util.Log;
import java.util.concurrent.atomic.AtomicReference;

public final class zzbz
  extends zzce
{
  private final AtomicReference<Bundle> zza = new AtomicReference();
  private boolean zzb;
  
  public static final <T> T zze(Bundle paramBundle, Class<T> paramClass)
  {
    Object localObject1 = null;
    Object localObject2 = localObject1;
    if (paramBundle != null)
    {
      paramBundle = paramBundle.get("r");
      localObject2 = localObject1;
      if (paramBundle != null) {
        try
        {
          localObject2 = paramClass.cast(paramBundle);
        }
        catch (ClassCastException localClassCastException)
        {
          Log.w("AM", String.format("Unexpected object type. Expected, Received: %s, %s", new Object[] { paramClass.getCanonicalName(), paramBundle.getClass().getCanonicalName() }), localClassCastException);
          throw localClassCastException;
        }
      }
    }
    return localClassCastException;
  }
  
  /* Error */
  public final void zzb(Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 18	com/google/android/gms/internal/measurement/zzbz:zza	Ljava/util/concurrent/atomic/AtomicReference;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 18	com/google/android/gms/internal/measurement/zzbz:zza	Ljava/util/concurrent/atomic/AtomicReference;
    //   11: aload_1
    //   12: invokevirtual 70	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
    //   15: aload_0
    //   16: iconst_1
    //   17: putfield 72	com/google/android/gms/internal/measurement/zzbz:zzb	Z
    //   20: aload_0
    //   21: getfield 18	com/google/android/gms/internal/measurement/zzbz:zza	Ljava/util/concurrent/atomic/AtomicReference;
    //   24: invokevirtual 75	java/lang/Object:notify	()V
    //   27: aload_2
    //   28: monitorexit
    //   29: return
    //   30: astore_1
    //   31: aload_0
    //   32: getfield 18	com/google/android/gms/internal/measurement/zzbz:zza	Ljava/util/concurrent/atomic/AtomicReference;
    //   35: invokevirtual 75	java/lang/Object:notify	()V
    //   38: aload_1
    //   39: athrow
    //   40: astore_1
    //   41: aload_2
    //   42: monitorexit
    //   43: aload_1
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	zzbz
    //   0	45	1	paramBundle	Bundle
    //   4	38	2	localAtomicReference	AtomicReference
    // Exception table:
    //   from	to	target	type
    //   7	20	30	finally
    //   20	29	40	finally
    //   31	40	40	finally
    //   41	43	40	finally
  }
  
  public final String zzc(long paramLong)
  {
    return (String)zze(zzd(paramLong), String.class);
  }
  
  public final Bundle zzd(long paramLong)
  {
    synchronized (this.zza)
    {
      boolean bool = this.zzb;
      if (!bool) {
        try
        {
          this.zza.wait(paramLong);
        }
        catch (InterruptedException localInterruptedException)
        {
          return null;
        }
      }
      Bundle localBundle = (Bundle)this.zza.get();
      return localBundle;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzbz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */