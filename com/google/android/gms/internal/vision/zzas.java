package com.google.android.gms.internal.vision;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Process;
import android.os.UserManager;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.RequiresApi;

public class zzas
{
  @GuardedBy("DirectBootUtils.class")
  private static UserManager zzfn;
  private static volatile boolean zzfo = zzt() ^ true;
  @GuardedBy("DirectBootUtils.class")
  private static boolean zzfp = false;
  
  public static boolean isUserUnlocked(Context paramContext)
  {
    return (!zzt()) || (zzd(paramContext));
  }
  
  @TargetApi(24)
  @GuardedBy("DirectBootUtils.class")
  @RequiresApi(24)
  private static boolean zzc(Context paramContext)
  {
    boolean bool1 = true;
    int i = 1;
    boolean bool2;
    for (;;)
    {
      bool2 = false;
      if (i > 2) {
        break;
      }
      if (zzfn == null) {
        zzfn = (UserManager)paramContext.getSystemService(UserManager.class);
      }
      UserManager localUserManager = zzfn;
      if (localUserManager == null) {
        return true;
      }
      bool2 = bool1;
      try
      {
        if (!localUserManager.isUserUnlocked())
        {
          bool2 = localUserManager.isUserRunning(Process.myUserHandle());
          if (!bool2) {
            bool2 = bool1;
          } else {
            bool2 = false;
          }
        }
      }
      catch (NullPointerException localNullPointerException)
      {
        Log.w("DirectBootUtils", "Failed to check if user is unlocked.", localNullPointerException);
        zzfn = null;
        i++;
      }
    }
    if (bool2) {
      zzfn = null;
    }
    return bool2;
  }
  
  @TargetApi(24)
  @RequiresApi(24)
  private static boolean zzd(Context paramContext)
  {
    if (zzfo) {
      return true;
    }
    try
    {
      if (zzfo) {
        return true;
      }
      boolean bool = zzc(paramContext);
      if (bool) {
        zzfo = bool;
      }
      return bool;
    }
    finally {}
  }
  
  public static boolean zzt()
  {
    return Build.VERSION.SDK_INT >= 24;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzas.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */