package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.common.R.string;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.concurrent.GuardedBy;

@Deprecated
@KeepForSdk
public final class GoogleServices
{
  private static final Object sLock = new Object();
  @GuardedBy("sLock")
  private static GoogleServices zzay;
  private final String zzaz;
  private final Status zzba;
  private final boolean zzbb;
  private final boolean zzbc;
  
  @KeepForSdk
  @VisibleForTesting
  GoogleServices(Context paramContext)
  {
    Object localObject = paramContext.getResources();
    int i = ((Resources)localObject).getIdentifier("google_app_measurement_enable", "integer", ((Resources)localObject).getResourcePackageName(R.string.common_google_play_services_unknown_issue));
    boolean bool1 = false;
    boolean bool2 = true;
    if (i != 0)
    {
      bool2 = bool1;
      if (((Resources)localObject).getInteger(i) != 0) {
        bool2 = true;
      }
      this.zzbc = (bool2 ^ true);
    }
    else
    {
      this.zzbc = false;
    }
    this.zzbb = bool2;
    String str = zzp.zzc(paramContext);
    localObject = str;
    if (str == null) {
      localObject = new StringResourceValueReader(paramContext).getString("google_app_id");
    }
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      this.zzba = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
      this.zzaz = null;
      return;
    }
    this.zzaz = ((String)localObject);
    this.zzba = Status.RESULT_SUCCESS;
  }
  
  @KeepForSdk
  @VisibleForTesting
  GoogleServices(String paramString, boolean paramBoolean)
  {
    this.zzaz = paramString;
    this.zzba = Status.RESULT_SUCCESS;
    this.zzbb = paramBoolean;
    this.zzbc = (paramBoolean ^ true);
  }
  
  @KeepForSdk
  private static GoogleServices checkInitialized(String paramString)
  {
    synchronized (sLock)
    {
      Object localObject2 = zzay;
      if (localObject2 != null) {
        return (GoogleServices)localObject2;
      }
      IllegalStateException localIllegalStateException = new java/lang/IllegalStateException;
      int i = String.valueOf(paramString).length();
      localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>(i + 34);
      ((StringBuilder)localObject2).append("Initialize must be called before ");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(".");
      localIllegalStateException.<init>(((StringBuilder)localObject2).toString());
      throw localIllegalStateException;
    }
  }
  
  @KeepForSdk
  @VisibleForTesting
  static void clearInstanceForTest()
  {
    synchronized (sLock)
    {
      zzay = null;
      return;
    }
  }
  
  @KeepForSdk
  public static String getGoogleAppId()
  {
    return checkInitialized("getGoogleAppId").zzaz;
  }
  
  @KeepForSdk
  public static Status initialize(Context paramContext)
  {
    Preconditions.checkNotNull(paramContext, "Context must not be null.");
    synchronized (sLock)
    {
      if (zzay == null)
      {
        GoogleServices localGoogleServices = new com/google/android/gms/common/api/internal/GoogleServices;
        localGoogleServices.<init>(paramContext);
        zzay = localGoogleServices;
      }
      paramContext = zzay.zzba;
      return paramContext;
    }
  }
  
  @KeepForSdk
  public static Status initialize(Context arg0, String paramString, boolean paramBoolean)
  {
    Preconditions.checkNotNull(???, "Context must not be null.");
    Preconditions.checkNotEmpty(paramString, "App ID must be nonempty.");
    synchronized (sLock)
    {
      GoogleServices localGoogleServices = zzay;
      if (localGoogleServices != null)
      {
        paramString = localGoogleServices.checkGoogleAppId(paramString);
        return paramString;
      }
      localGoogleServices = new com/google/android/gms/common/api/internal/GoogleServices;
      localGoogleServices.<init>(paramString, paramBoolean);
      zzay = localGoogleServices;
      paramString = localGoogleServices.zzba;
      return paramString;
    }
  }
  
  @KeepForSdk
  public static boolean isMeasurementEnabled()
  {
    GoogleServices localGoogleServices = checkInitialized("isMeasurementEnabled");
    return (localGoogleServices.zzba.isSuccess()) && (localGoogleServices.zzbb);
  }
  
  @KeepForSdk
  public static boolean isMeasurementExplicitlyDisabled()
  {
    return checkInitialized("isMeasurementExplicitlyDisabled").zzbc;
  }
  
  @KeepForSdk
  @VisibleForTesting
  final Status checkGoogleAppId(String paramString)
  {
    String str = this.zzaz;
    if ((str != null) && (!str.equals(paramString)))
    {
      str = this.zzaz;
      paramString = new StringBuilder(String.valueOf(str).length() + 97);
      paramString.append("Initialize was called with two different Google App IDs.  Only the first app ID will be used: '");
      paramString.append(str);
      paramString.append("'.");
      return new Status(10, paramString.toString());
    }
    return Status.RESULT_SUCCESS;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\api\internal\GoogleServices.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */