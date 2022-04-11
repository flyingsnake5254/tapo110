package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.common.zzg;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@KeepForSdk
public class AndroidUtilsLight
{
  private static volatile int zzgf = -1;
  
  @Deprecated
  @TargetApi(24)
  @KeepForSdk
  public static Context getDeviceProtectedStorageContext(Context paramContext)
  {
    Context localContext = paramContext;
    if (zzg.zzam()) {
      localContext = zzg.getDeviceProtectedStorageContext(paramContext);
    }
    return localContext;
  }
  
  @KeepForSdk
  public static byte[] getPackageCertificateHashBytes(Context paramContext, String paramString)
    throws PackageManager.NameNotFoundException
  {
    paramContext = Wrappers.packageManager(paramContext).getPackageInfo(paramString, 64);
    paramString = paramContext.signatures;
    if ((paramString != null) && (paramString.length == 1))
    {
      paramString = zzj("SHA1");
      if (paramString != null) {
        return paramString.digest(paramContext.signatures[0].toByteArray());
      }
    }
    return null;
  }
  
  public static MessageDigest zzj(String paramString)
  {
    for (int i = 0; i < 2; i++) {
      try
      {
        MessageDigest localMessageDigest = MessageDigest.getInstance(paramString);
        if (localMessageDigest != null) {
          return localMessageDigest;
        }
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        for (;;) {}
      }
    }
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\util\AndroidUtilsLight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */