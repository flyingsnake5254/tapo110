package com.google.android.gms.internal.clearcut;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.UserManager;

public class zzaa
{
  private static volatile UserManager zzdc;
  private static volatile boolean zzdd = zzf() ^ true;
  
  public static boolean zze(Context paramContext)
  {
    return (zzf()) && (!zzf(paramContext));
  }
  
  private static boolean zzf()
  {
    return Build.VERSION.SDK_INT >= 24;
  }
  
  @TargetApi(24)
  private static boolean zzf(Context paramContext)
  {
    boolean bool1 = zzdd;
    boolean bool2 = bool1;
    if (!bool1)
    {
      UserManager localUserManager1 = zzdc;
      UserManager localUserManager2 = localUserManager1;
      if (localUserManager1 == null) {
        try
        {
          localUserManager1 = zzdc;
          localUserManager2 = localUserManager1;
          if (localUserManager1 == null)
          {
            localUserManager2 = (UserManager)paramContext.getSystemService(UserManager.class);
            zzdc = localUserManager2;
            if (localUserManager2 == null)
            {
              zzdd = true;
              return true;
            }
          }
        }
        finally {}
      }
      bool1 = localUserManager2.isUserUnlocked();
      zzdd = bool1;
      bool2 = bool1;
      if (bool1)
      {
        zzdc = null;
        bool2 = bool1;
      }
    }
    return bool2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzaa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */