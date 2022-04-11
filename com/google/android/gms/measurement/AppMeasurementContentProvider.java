package com.google.android.gms.measurement;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzfu;

@Deprecated
public class AppMeasurementContentProvider
  extends ContentProvider
{
  public void attachInfo(@NonNull Context paramContext, @NonNull ProviderInfo paramProviderInfo)
  {
    super.attachInfo(paramContext, paramProviderInfo);
    if (!"com.google.android.gms.measurement.google_measurement_service".equals(paramProviderInfo.authority)) {
      return;
    }
    throw new IllegalStateException("Incorrect provider authority in manifest. Most likely due to a missing applicationId variable in application's build.gradle.");
  }
  
  public int delete(@NonNull Uri paramUri, @NonNull String paramString, @NonNull String[] paramArrayOfString)
  {
    return 0;
  }
  
  @NonNull
  public String getType(@NonNull Uri paramUri)
  {
    return null;
  }
  
  @NonNull
  public Uri insert(@NonNull Uri paramUri, @NonNull ContentValues paramContentValues)
  {
    return null;
  }
  
  public boolean onCreate()
  {
    Context localContext = getContext();
    Preconditions.checkNotNull(localContext);
    zzfu.zzC(localContext, null, null);
    return false;
  }
  
  @NonNull
  public Cursor query(@NonNull Uri paramUri, @NonNull String[] paramArrayOfString1, @NonNull String paramString1, @NonNull String[] paramArrayOfString2, @NonNull String paramString2)
  {
    return null;
  }
  
  public int update(@NonNull Uri paramUri, @NonNull ContentValues paramContentValues, @NonNull String paramString, @NonNull String[] paramArrayOfString)
  {
    return 0;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\AppMeasurementContentProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */