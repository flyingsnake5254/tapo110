package com.google.android.gms.internal.firebase_messaging;

import java.io.PrintStream;
import java.lang.reflect.Field;

public final class zzt
{
  static final zzn zza;
  
  static
  {
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject3 = localObject1;
    try
    {
      try
      {
        Integer localInteger = (Integer)Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
        localObject2 = localInteger;
      }
      catch (Exception localException)
      {
        localObject3 = localObject1;
        System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
        localObject3 = localObject1;
        localException.printStackTrace(System.err);
      }
      if (localObject2 != null)
      {
        localObject3 = localObject2;
        if (((Integer)localObject2).intValue() >= 19)
        {
          localObject3 = localObject2;
          localObject1 = new com/google/android/gms/internal/firebase_messaging/zzs;
          localObject3 = localObject2;
          ((zzs)localObject1).<init>();
          localObject3 = localObject2;
          localObject2 = localObject1;
          break label199;
        }
      }
      localObject3 = localObject2;
      if (!Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic"))
      {
        localObject3 = localObject2;
        localObject1 = new zzq();
        localObject3 = localObject2;
        localObject2 = localObject1;
      }
      else
      {
        localObject3 = localObject2;
        localObject1 = new zzr();
        localObject3 = localObject2;
        localObject2 = localObject1;
      }
    }
    finally
    {
      PrintStream localPrintStream = System.err;
      localObject2 = zzr.class.getName();
      localObject1 = new StringBuilder(((String)localObject2).length() + 133);
      ((StringBuilder)localObject1).append("An error has occurred when initializing the try-with-resources desuguring strategy. The default strategy ");
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("will be used. The error is: ");
      localPrintStream.println(((StringBuilder)localObject1).toString());
      ((Throwable)localObject4).printStackTrace(System.err);
      localObject2 = new zzr();
    }
    label199:
    zza = (zzn)localObject2;
    if (localObject3 == null) {
      return;
    }
    ((Integer)localObject3).intValue();
  }
  
  public static void zza(Throwable paramThrowable1, Throwable paramThrowable2)
  {
    zza.zza(paramThrowable1, paramThrowable2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\firebase_messaging\zzt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */