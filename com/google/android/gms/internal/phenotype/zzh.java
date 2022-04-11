package com.google.android.gms.internal.phenotype;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;

public final class zzh<T>
{
  private static final Object zzak = new Object();
  @SuppressLint({"StaticFieldLeak"})
  private static Context zzal;
  private static boolean zzam = false;
  private static volatile Boolean zzan;
  private static volatile Boolean zzbq;
  
  public static void init(Context paramContext)
  {
    synchronized (zzak)
    {
      if ((Build.VERSION.SDK_INT < 24) || (!paramContext.isDeviceProtectedStorage()))
      {
        Context localContext = paramContext.getApplicationContext();
        if (localContext != null) {
          paramContext = localContext;
        }
      }
      if (zzal != paramContext) {
        zzan = null;
      }
      zzal = paramContext;
      zzam = false;
      return;
    }
  }
  
  public static void maybeInit(Context paramContext)
  {
    if (zzal == null) {
      init(paramContext);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\phenotype\zzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */