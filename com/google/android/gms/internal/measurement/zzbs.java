package com.google.android.gms.internal.measurement;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;

public final class zzbs
{
  public static final int zza;
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    int j = 0;
    int k = j;
    if (i >= 30)
    {
      String str = Build.VERSION.CODENAME;
      k = j;
      if (str.length() == 1)
      {
        k = j;
        if (str.charAt(0) >= 'S')
        {
          k = j;
          if (str.charAt(0) <= 'Z') {
            k = 33554432;
          }
        }
      }
    }
    zza = k;
  }
  
  public static PendingIntent zza(Context paramContext, int paramInt1, Intent paramIntent, int paramInt2)
  {
    return PendingIntent.getBroadcast(paramContext, 0, paramIntent, paramInt2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzbs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */