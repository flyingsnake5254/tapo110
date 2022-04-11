package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageInstaller.SessionInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.UserManager;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.HideFirstParty;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.util.zzb;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@KeepForSdk
@ShowFirstParty
public class GooglePlayServicesUtilLight
{
  @KeepForSdk
  static final int GMS_AVAILABILITY_NOTIFICATION_ID = 10436;
  @KeepForSdk
  static final int GMS_GENERAL_ERROR_NOTIFICATION_ID = 39789;
  @KeepForSdk
  public static final String GOOGLE_PLAY_GAMES_PACKAGE = "com.google.android.play.games";
  @Deprecated
  @KeepForSdk
  public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
  @Deprecated
  @KeepForSdk
  public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = 12451000;
  @KeepForSdk
  public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
  @KeepForSdk
  @VisibleForTesting
  static final AtomicBoolean sCanceledAvailabilityNotification = new AtomicBoolean();
  @VisibleForTesting
  private static boolean zzah = false;
  @VisibleForTesting
  private static boolean zzai = false;
  private static boolean zzaj = false;
  @VisibleForTesting
  private static boolean zzak = false;
  private static final AtomicBoolean zzal = new AtomicBoolean();
  
  @Deprecated
  @KeepForSdk
  public static void cancelAvailabilityErrorNotifications(Context paramContext)
  {
    if (sCanceledAvailabilityNotification.getAndSet(true)) {
      return;
    }
    try
    {
      paramContext = (NotificationManager)paramContext.getSystemService("notification");
      if (paramContext != null) {
        paramContext.cancel(10436);
      }
      return;
    }
    catch (SecurityException paramContext)
    {
      for (;;) {}
    }
  }
  
  @KeepForSdk
  @ShowFirstParty
  public static void enableUsingApkIndependentContext()
  {
    zzal.set(true);
  }
  
  @Deprecated
  @KeepForSdk
  public static void ensurePlayServicesAvailable(Context paramContext, int paramInt)
    throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException
  {
    paramInt = GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(paramContext, paramInt);
    if (paramInt != 0)
    {
      Intent localIntent = GoogleApiAvailabilityLight.getInstance().getErrorResolutionIntent(paramContext, paramInt, "e");
      paramContext = new StringBuilder(57);
      paramContext.append("GooglePlayServices not available due to error ");
      paramContext.append(paramInt);
      Log.e("GooglePlayServicesUtil", paramContext.toString());
      if (localIntent == null) {
        throw new GooglePlayServicesNotAvailableException(paramInt);
      }
      throw new GooglePlayServicesRepairableException(paramInt, "Google Play Services not available", localIntent);
    }
  }
  
  @Deprecated
  @KeepForSdk
  @ShowFirstParty
  public static int getApkVersion(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo("com.google.android.gms", 0);
      return paramContext.versionCode;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
    }
    return 0;
  }
  
  @Deprecated
  @KeepForSdk
  @ShowFirstParty
  public static int getClientVersion(Context paramContext)
  {
    Preconditions.checkState(true);
    return ClientLibraryUtils.getClientVersion(paramContext, paramContext.getPackageName());
  }
  
  @Deprecated
  @KeepForSdk
  public static PendingIntent getErrorPendingIntent(int paramInt1, Context paramContext, int paramInt2)
  {
    return GoogleApiAvailabilityLight.getInstance().getErrorResolutionPendingIntent(paramContext, paramInt1, paramInt2);
  }
  
  @Deprecated
  @KeepForSdk
  @VisibleForTesting
  public static String getErrorString(int paramInt)
  {
    return ConnectionResult.zza(paramInt);
  }
  
  @Deprecated
  @KeepForSdk
  @ShowFirstParty
  public static Intent getGooglePlayServicesAvailabilityRecoveryIntent(int paramInt)
  {
    return GoogleApiAvailabilityLight.getInstance().getErrorResolutionIntent(null, paramInt, null);
  }
  
  @KeepForSdk
  public static Context getRemoteContext(Context paramContext)
  {
    try
    {
      paramContext = paramContext.createPackageContext("com.google.android.gms", 3);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return null;
  }
  
  @KeepForSdk
  public static Resources getRemoteResource(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getResourcesForApplication("com.google.android.gms");
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return null;
  }
  
  /* Error */
  @KeepForSdk
  @ShowFirstParty
  public static boolean honorsDebugCertificates(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 198	com/google/android/gms/common/GooglePlayServicesUtilLight:zzak	Z
    //   3: ifne +85 -> 88
    //   6: aload_0
    //   7: invokestatic 204	com/google/android/gms/common/wrappers/Wrappers:packageManager	(Landroid/content/Context;)Lcom/google/android/gms/common/wrappers/PackageManagerWrapper;
    //   10: ldc 18
    //   12: bipush 64
    //   14: invokevirtual 207	com/google/android/gms/common/wrappers/PackageManagerWrapper:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   17: astore_1
    //   18: aload_0
    //   19: invokestatic 212	com/google/android/gms/common/GoogleSignatureVerifier:getInstance	(Landroid/content/Context;)Lcom/google/android/gms/common/GoogleSignatureVerifier;
    //   22: pop
    //   23: aload_1
    //   24: ifnull +26 -> 50
    //   27: aload_1
    //   28: iconst_0
    //   29: invokestatic 215	com/google/android/gms/common/GoogleSignatureVerifier:zza	(Landroid/content/pm/PackageInfo;Z)Z
    //   32: ifne +18 -> 50
    //   35: aload_1
    //   36: iconst_1
    //   37: invokestatic 215	com/google/android/gms/common/GoogleSignatureVerifier:zza	(Landroid/content/pm/PackageInfo;Z)Z
    //   40: ifeq +10 -> 50
    //   43: iconst_1
    //   44: putstatic 217	com/google/android/gms/common/GooglePlayServicesUtilLight:zzaj	Z
    //   47: goto +7 -> 54
    //   50: iconst_0
    //   51: putstatic 217	com/google/android/gms/common/GooglePlayServicesUtilLight:zzaj	Z
    //   54: iconst_1
    //   55: putstatic 198	com/google/android/gms/common/GooglePlayServicesUtilLight:zzak	Z
    //   58: goto +30 -> 88
    //   61: astore_0
    //   62: goto +20 -> 82
    //   65: astore_0
    //   66: ldc 113
    //   68: ldc -37
    //   70: aload_0
    //   71: invokestatic 222	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   74: pop
    //   75: iconst_1
    //   76: putstatic 198	com/google/android/gms/common/GooglePlayServicesUtilLight:zzak	Z
    //   79: goto +9 -> 88
    //   82: iconst_1
    //   83: putstatic 198	com/google/android/gms/common/GooglePlayServicesUtilLight:zzak	Z
    //   86: aload_0
    //   87: athrow
    //   88: getstatic 217	com/google/android/gms/common/GooglePlayServicesUtilLight:zzaj	Z
    //   91: ifne +14 -> 105
    //   94: invokestatic 228	com/google/android/gms/common/util/DeviceProperties:isUserBuild	()Z
    //   97: ifne +6 -> 103
    //   100: goto +5 -> 105
    //   103: iconst_0
    //   104: ireturn
    //   105: iconst_1
    //   106: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	paramContext	Context
    //   17	19	1	localPackageInfo	PackageInfo
    // Exception table:
    //   from	to	target	type
    //   6	23	61	finally
    //   27	47	61	finally
    //   50	54	61	finally
    //   66	75	61	finally
    //   6	23	65	android/content/pm/PackageManager$NameNotFoundException
    //   27	47	65	android/content/pm/PackageManager$NameNotFoundException
    //   50	54	65	android/content/pm/PackageManager$NameNotFoundException
  }
  
  @Deprecated
  @KeepForSdk
  @HideFirstParty
  public static int isGooglePlayServicesAvailable(Context paramContext)
  {
    return isGooglePlayServicesAvailable(paramContext, GOOGLE_PLAY_SERVICES_VERSION_CODE);
  }
  
  /* Error */
  @Deprecated
  @KeepForSdk
  public static int isGooglePlayServicesAvailable(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 236	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   4: getstatic 241	com/google/android/gms/common/R$string:common_google_play_services_unknown_issue	I
    //   7: invokevirtual 246	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   10: pop
    //   11: goto +12 -> 23
    //   14: astore_2
    //   15: ldc 113
    //   17: ldc -8
    //   19: invokestatic 122	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   22: pop
    //   23: ldc 18
    //   25: aload_0
    //   26: invokevirtual 162	android/content/Context:getPackageName	()Ljava/lang/String;
    //   29: invokevirtual 254	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   32: ifne +106 -> 138
    //   35: getstatic 45	com/google/android/gms/common/GooglePlayServicesUtilLight:zzal	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   38: invokevirtual 257	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   41: ifne +97 -> 138
    //   44: aload_0
    //   45: invokestatic 262	com/google/android/gms/common/internal/zzp:zzd	(Landroid/content/Context;)I
    //   48: istore_3
    //   49: iload_3
    //   50: ifeq +77 -> 127
    //   53: getstatic 231	com/google/android/gms/common/GooglePlayServicesUtilLight:GOOGLE_PLAY_SERVICES_VERSION_CODE	I
    //   56: istore 4
    //   58: iload_3
    //   59: iload 4
    //   61: if_icmpne +6 -> 67
    //   64: goto +74 -> 138
    //   67: new 100	java/lang/StringBuilder
    //   70: dup
    //   71: sipush 320
    //   74: invokespecial 102	java/lang/StringBuilder:<init>	(I)V
    //   77: astore_0
    //   78: aload_0
    //   79: ldc_w 264
    //   82: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: aload_0
    //   87: iload 4
    //   89: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload_0
    //   94: ldc_w 266
    //   97: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: aload_0
    //   102: iload_3
    //   103: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: aload_0
    //   108: ldc_w 268
    //   111: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: new 270	java/lang/IllegalStateException
    //   118: dup
    //   119: aload_0
    //   120: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokespecial 273	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   126: athrow
    //   127: new 270	java/lang/IllegalStateException
    //   130: dup
    //   131: ldc_w 275
    //   134: invokespecial 273	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   137: athrow
    //   138: aload_0
    //   139: invokestatic 278	com/google/android/gms/common/util/DeviceProperties:isWearableWithoutPlayStore	(Landroid/content/Context;)Z
    //   142: ifne +16 -> 158
    //   145: aload_0
    //   146: invokestatic 281	com/google/android/gms/common/util/DeviceProperties:zzf	(Landroid/content/Context;)Z
    //   149: ifne +9 -> 158
    //   152: iconst_1
    //   153: istore 5
    //   155: goto +6 -> 161
    //   158: iconst_0
    //   159: istore 5
    //   161: aload_0
    //   162: iload 5
    //   164: iload_1
    //   165: invokestatic 284	com/google/android/gms/common/GooglePlayServicesUtilLight:zza	(Landroid/content/Context;ZI)I
    //   168: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	169	0	paramContext	Context
    //   0	169	1	paramInt	int
    //   14	1	2	localObject	Object
    //   48	55	3	i	int
    //   56	32	4	j	int
    //   153	10	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   0	11	14	finally
  }
  
  @Deprecated
  @KeepForSdk
  public static boolean isGooglePlayServicesUid(Context paramContext, int paramInt)
  {
    return UidVerifier.isGooglePlayServicesUid(paramContext, paramInt);
  }
  
  @Deprecated
  @KeepForSdk
  @ShowFirstParty
  public static boolean isPlayServicesPossiblyUpdating(Context paramContext, int paramInt)
  {
    if (paramInt == 18) {
      return true;
    }
    if (paramInt == 1) {
      return isUninstalledAppPossiblyUpdating(paramContext, "com.google.android.gms");
    }
    return false;
  }
  
  @Deprecated
  @KeepForSdk
  @ShowFirstParty
  public static boolean isPlayStorePossiblyUpdating(Context paramContext, int paramInt)
  {
    if (paramInt == 9) {
      return isUninstalledAppPossiblyUpdating(paramContext, "com.android.vending");
    }
    return false;
  }
  
  @TargetApi(18)
  @KeepForSdk
  public static boolean isRestrictedUserProfile(Context paramContext)
  {
    if (PlatformVersion.isAtLeastJellyBeanMR2())
    {
      paramContext = ((UserManager)paramContext.getSystemService("user")).getApplicationRestrictions(paramContext.getPackageName());
      if ((paramContext != null) && ("true".equals(paramContext.getString("restricted_profile")))) {
        return true;
      }
    }
    return false;
  }
  
  @Deprecated
  @KeepForSdk
  @ShowFirstParty
  @VisibleForTesting
  public static boolean isSidewinderDevice(Context paramContext)
  {
    return DeviceProperties.isSidewinder(paramContext);
  }
  
  @TargetApi(21)
  static boolean isUninstalledAppPossiblyUpdating(Context paramContext, String paramString)
  {
    boolean bool = paramString.equals("com.google.android.gms");
    if (PlatformVersion.isAtLeastLollipop()) {
      try
      {
        localObject = paramContext.getPackageManager().getPackageInstaller().getAllSessions();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          if (paramString.equals(((PackageInstaller.SessionInfo)((Iterator)localObject).next()).getAppPackageName())) {
            return true;
          }
        }
      }
      catch (Exception paramContext)
      {
        return false;
      }
    }
    Object localObject = paramContext.getPackageManager();
    try
    {
      paramString = ((PackageManager)localObject).getApplicationInfo(paramString, 8192);
      if (bool) {
        return paramString.enabled;
      }
      if (paramString.enabled)
      {
        bool = isRestrictedUserProfile(paramContext);
        if (!bool) {
          return true;
        }
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;) {}
    }
    return false;
  }
  
  @Deprecated
  @KeepForSdk
  public static boolean isUserRecoverableError(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 2) || (paramInt == 3) || (paramInt == 9);
  }
  
  @Deprecated
  @TargetApi(19)
  @KeepForSdk
  public static boolean uidHasPackageName(Context paramContext, int paramInt, String paramString)
  {
    return UidVerifier.uidHasPackageName(paramContext, paramInt, paramString);
  }
  
  @VisibleForTesting
  private static int zza(Context paramContext, boolean paramBoolean, int paramInt)
  {
    boolean bool;
    if (paramInt >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool);
    PackageManager localPackageManager = paramContext.getPackageManager();
    Object localObject = null;
    if (paramBoolean) {
      try
      {
        localObject = localPackageManager.getPackageInfo("com.android.vending", 8256);
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        Log.w("GooglePlayServicesUtil", "Google Play Store is missing.");
        return 9;
      }
    }
    try
    {
      PackageInfo localPackageInfo = localPackageManager.getPackageInfo("com.google.android.gms", 64);
      GoogleSignatureVerifier.getInstance(paramContext);
      if (!GoogleSignatureVerifier.zza(localPackageInfo, true))
      {
        Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
        return 9;
      }
      if ((paramBoolean) && ((!GoogleSignatureVerifier.zza((PackageInfo)localObject, true)) || (!localObject.signatures[0].equals(localPackageInfo.signatures[0]))))
      {
        Log.w("GooglePlayServicesUtil", "Google Play Store signature invalid.");
        return 9;
      }
      if (zzb.zzc(localPackageInfo.versionCode) < zzb.zzc(paramInt))
      {
        int i = localPackageInfo.versionCode;
        paramContext = new StringBuilder(77);
        paramContext.append("Google Play services out of date.  Requires ");
        paramContext.append(paramInt);
        paramContext.append(" but found ");
        paramContext.append(i);
        Log.w("GooglePlayServicesUtil", paramContext.toString());
        return 2;
      }
      localObject = localPackageInfo.applicationInfo;
      paramContext = (Context)localObject;
      if (localObject == null) {
        try
        {
          paramContext = localPackageManager.getApplicationInfo("com.google.android.gms", 0);
        }
        catch (PackageManager.NameNotFoundException paramContext)
        {
          Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.", paramContext);
          return 1;
        }
      }
      if (!paramContext.enabled) {
        return 3;
      }
      return 0;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
    }
    return 1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\GooglePlayServicesUtilLight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */