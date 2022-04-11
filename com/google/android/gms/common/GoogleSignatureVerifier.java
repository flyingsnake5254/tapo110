package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import javax.annotation.CheckReturnValue;

@CheckReturnValue
@KeepForSdk
@ShowFirstParty
public class GoogleSignatureVerifier
{
  private static GoogleSignatureVerifier zzam;
  private final Context mContext;
  private volatile String zzan;
  
  private GoogleSignatureVerifier(Context paramContext)
  {
    this.mContext = paramContext.getApplicationContext();
  }
  
  @KeepForSdk
  public static GoogleSignatureVerifier getInstance(Context paramContext)
  {
    Preconditions.checkNotNull(paramContext);
    try
    {
      if (zzam == null)
      {
        zzc.zza(paramContext);
        GoogleSignatureVerifier localGoogleSignatureVerifier = new com/google/android/gms/common/GoogleSignatureVerifier;
        localGoogleSignatureVerifier.<init>(paramContext);
        zzam = localGoogleSignatureVerifier;
      }
      return zzam;
    }
    finally {}
  }
  
  private static zze zza(PackageInfo paramPackageInfo, zze... paramVarArgs)
  {
    Signature[] arrayOfSignature = paramPackageInfo.signatures;
    if (arrayOfSignature == null) {
      return null;
    }
    if (arrayOfSignature.length != 1)
    {
      Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
      return null;
    }
    paramPackageInfo = paramPackageInfo.signatures;
    int i = 0;
    paramPackageInfo = new zzf(paramPackageInfo[0].toByteArray());
    while (i < paramVarArgs.length)
    {
      if (paramVarArgs[i].equals(paramPackageInfo)) {
        return paramVarArgs[i];
      }
      i++;
    }
    return null;
  }
  
  private final zzm zza(String paramString, int paramInt)
  {
    try
    {
      Object localObject = Wrappers.packageManager(this.mContext).zza(paramString, 64, paramInt);
      boolean bool = GooglePlayServicesUtilLight.honorsDebugCertificates(this.mContext);
      if (localObject == null) {
        return zzm.zzb("null pkg");
      }
      if (((PackageInfo)localObject).signatures.length != 1) {
        return zzm.zzb("single cert required");
      }
      zzf localzzf = new com/google/android/gms/common/zzf;
      localzzf.<init>(localObject.signatures[0].toByteArray());
      String str = ((PackageInfo)localObject).packageName;
      zzm localzzm = zzc.zza(str, localzzf, bool, false);
      if (localzzm.zzad)
      {
        localObject = ((PackageInfo)localObject).applicationInfo;
        if ((localObject != null) && ((((ApplicationInfo)localObject).flags & 0x2) != 0) && (zzc.zza(str, localzzf, false, true).zzad))
        {
          localzzm = zzm.zzb("debuggable release cert app rejected");
          return localzzm;
        }
      }
      return localzzm;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {
        paramString = "no pkg ".concat(paramString);
      } else {
        paramString = new String("no pkg ");
      }
    }
    return zzm.zzb(paramString);
  }
  
  public static boolean zza(PackageInfo paramPackageInfo, boolean paramBoolean)
  {
    if ((paramPackageInfo != null) && (paramPackageInfo.signatures != null))
    {
      if (paramBoolean) {
        paramPackageInfo = zza(paramPackageInfo, zzh.zzx);
      } else {
        paramPackageInfo = zza(paramPackageInfo, new zze[] { zzh.zzx[0] });
      }
      if (paramPackageInfo != null) {
        return true;
      }
    }
    return false;
  }
  
  private final zzm zzc(String paramString)
  {
    if (paramString == null) {
      return zzm.zzb("null pkg");
    }
    if (paramString.equals(this.zzan)) {
      return zzm.zze();
    }
    try
    {
      Object localObject = Wrappers.packageManager(this.mContext).getPackageInfo(paramString, 64);
      boolean bool = GooglePlayServicesUtilLight.honorsDebugCertificates(this.mContext);
      zzm localzzm;
      if (localObject == null)
      {
        localzzm = zzm.zzb("null pkg");
      }
      else if (((PackageInfo)localObject).signatures.length != 1)
      {
        localzzm = zzm.zzb("single cert required");
      }
      else
      {
        zzf localzzf = new zzf(localObject.signatures[0].toByteArray());
        String str = ((PackageInfo)localObject).packageName;
        localzzm = zzc.zza(str, localzzf, bool, false);
        if (localzzm.zzad)
        {
          localObject = ((PackageInfo)localObject).applicationInfo;
          if ((localObject != null) && ((((ApplicationInfo)localObject).flags & 0x2) != 0) && (zzc.zza(str, localzzf, false, true).zzad)) {
            localzzm = zzm.zzb("debuggable release cert app rejected");
          }
        }
      }
      if (localzzm.zzad) {
        this.zzan = paramString;
      }
      return localzzm;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      if (paramString.length() != 0) {
        paramString = "no pkg ".concat(paramString);
      } else {
        paramString = new String("no pkg ");
      }
    }
    return zzm.zzb(paramString);
  }
  
  @KeepForSdk
  public boolean isGooglePublicSignedPackage(PackageInfo paramPackageInfo)
  {
    if (paramPackageInfo == null) {
      return false;
    }
    if (zza(paramPackageInfo, false)) {
      return true;
    }
    if (zza(paramPackageInfo, true))
    {
      if (GooglePlayServicesUtilLight.honorsDebugCertificates(this.mContext)) {
        return true;
      }
      Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
    }
    return false;
  }
  
  @KeepForSdk
  @ShowFirstParty
  public boolean isPackageGoogleSigned(String paramString)
  {
    paramString = zzc(paramString);
    paramString.zzf();
    return paramString.zzad;
  }
  
  @KeepForSdk
  @ShowFirstParty
  public boolean isUidGoogleSigned(int paramInt)
  {
    String[] arrayOfString = Wrappers.packageManager(this.mContext).getPackagesForUid(paramInt);
    Object localObject;
    int i;
    int j;
    if ((arrayOfString != null) && (arrayOfString.length != 0))
    {
      localObject = null;
      i = arrayOfString.length;
      j = 0;
    }
    while (j < i)
    {
      zzm localzzm = zza(arrayOfString[j], paramInt);
      localObject = localzzm;
      if (!localzzm.zzad)
      {
        j++;
        localObject = localzzm;
        continue;
        localObject = zzm.zzb("no pkgs");
      }
    }
    ((zzm)localObject).zzf();
    return ((zzm)localObject).zzad;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\GoogleSignatureVerifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */