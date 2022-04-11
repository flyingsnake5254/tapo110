package com.google.android.gms.common.stats;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager.WakeLock;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.List;

@KeepForSdk
public class StatsUtils
{
  @KeepForSdk
  public static String getEventKey(Context paramContext, Intent paramIntent)
  {
    long l = System.identityHashCode(paramContext);
    return String.valueOf(System.identityHashCode(paramIntent) | l << 32);
  }
  
  @KeepForSdk
  public static String getEventKey(PowerManager.WakeLock paramWakeLock, String paramString)
  {
    String str = String.valueOf(String.valueOf(Process.myPid() << 32 | System.identityHashCode(paramWakeLock)));
    paramWakeLock = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramWakeLock = "";
    }
    paramWakeLock = String.valueOf(paramWakeLock);
    if (paramWakeLock.length() != 0) {
      return str.concat(paramWakeLock);
    }
    return new String(str);
  }
  
  @Nullable
  static List<String> zza(@Nullable List<String> paramList)
  {
    List<String> localList = paramList;
    if (paramList != null)
    {
      localList = paramList;
      if (paramList.size() == 1)
      {
        localList = paramList;
        if ("com.google.android.gms".equals(paramList.get(0))) {
          localList = null;
        }
      }
    }
    return localList;
  }
  
  @Nullable
  static String zzi(String paramString)
  {
    String str = paramString;
    if ("com.google.android.gms".equals(paramString)) {
      str = null;
    }
    return str;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\stats\StatsUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */