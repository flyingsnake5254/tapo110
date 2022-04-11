package com.google.android.gms.internal.measurement;

import java.io.PrintStream;
import java.lang.reflect.Field;

public final class zzim
{
  static final zzig zza;
  
  static
  {
    Object localObject1 = null;
    Object localObject3 = null;
    Object localObject4 = localObject1;
    try
    {
      try
      {
        Integer localInteger = (Integer)Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
        localObject3 = localInteger;
      }
      catch (Exception localException)
      {
        localObject4 = localObject1;
        System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
        localObject4 = localObject1;
        localException.printStackTrace(System.err);
      }
      if (localObject3 != null)
      {
        localObject4 = localObject3;
        if (((Integer)localObject3).intValue() >= 19)
        {
          localObject4 = localObject3;
          localObject1 = new com/google/android/gms/internal/measurement/zzil;
          localObject4 = localObject3;
          ((zzil)localObject1).<init>();
          localObject4 = localObject3;
          localObject3 = localObject1;
          break label202;
        }
      }
      localObject4 = localObject3;
      if (!Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic"))
      {
        localObject4 = localObject3;
        localObject1 = new zzij();
        localObject4 = localObject3;
        localObject3 = localObject1;
      }
      else
      {
        localObject4 = localObject3;
        localObject1 = new zzik();
        localObject4 = localObject3;
        localObject3 = localObject1;
      }
    }
    finally
    {
      PrintStream localPrintStream = System.err;
      localObject3 = zzik.class.getName();
      StringBuilder localStringBuilder = new StringBuilder(((String)localObject3).length() + 133);
      localStringBuilder.append("An error has occurred when initializing the try-with-resources desuguring strategy. The default strategy ");
      localStringBuilder.append((String)localObject3);
      localStringBuilder.append("will be used. The error is: ");
      localPrintStream.println(localStringBuilder.toString());
      ((Throwable)localObject2).printStackTrace(System.err);
      localObject3 = new zzik();
    }
    label202:
    zza = (zzig)localObject3;
    if (localObject4 == null) {
      return;
    }
    ((Integer)localObject4).intValue();
  }
  
  public static void zza(Throwable paramThrowable1, Throwable paramThrowable2)
  {
    zza.zza(paramThrowable1, paramThrowable2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzim.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */