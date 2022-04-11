package com.google.android.gms.common.util;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.io.File;

@KeepForSdk
public class SharedPreferencesUtils
{
  @Deprecated
  @KeepForSdk
  public static void publishWorldReadableSharedPreferences(Context paramContext, SharedPreferences.Editor paramEditor, String paramString)
  {
    paramContext = new File(paramContext.getApplicationInfo().dataDir, "shared_prefs");
    File localFile = paramContext.getParentFile();
    if (localFile != null) {
      localFile.setExecutable(true, false);
    }
    paramContext.setExecutable(true, false);
    paramEditor.commit();
    new File(paramContext, String.valueOf(paramString).concat(".xml")).setReadable(true, false);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\util\SharedPreferencesUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */