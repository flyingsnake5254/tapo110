package com.google.android.gms.internal.vision;

import android.content.Context;
import android.util.Log;

public final class zzq
{
  public static boolean zza(Context paramContext, String paramString1, String paramString2)
  {
    paramString2 = zzda.zzk(paramString2);
    if ((!"face".equals(paramString1)) && (!"ica".equals(paramString1)) && (!"ocr".equals(paramString1)) && (!"barcode".equals(paramString1)))
    {
      Log.e("NativeLibraryLoader", String.format("Unrecognized engine: %s", new Object[] { paramString1 }));
      return false;
    }
    int i = paramString2.lastIndexOf(".so");
    paramContext = paramString2;
    if (i == paramString2.length() - 3) {
      paramContext = paramString2.substring(0, i);
    }
    paramString2 = paramContext;
    if (paramContext.indexOf("lib") == 0) {
      paramString2 = paramContext.substring(3);
    }
    boolean bool = zzr.zza(paramString1, paramString2);
    if (!bool) {
      Log.d("NativeLibraryLoader", String.format("%s engine not loaded with %s.", new Object[] { paramString1, paramString2 }));
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */