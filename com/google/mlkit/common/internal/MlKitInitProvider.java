package com.google.mlkit.common.internal;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.mlkit.common.sdkinternal.j;

public class MlKitInitProvider
  extends ContentProvider
{
  public void attachInfo(@NonNull Context paramContext, @NonNull ProviderInfo paramProviderInfo)
  {
    Preconditions.checkState(paramProviderInfo.authority.equals("com.google.mlkit.common.mlkitinitprovider") ^ true, "Incorrect provider authority in manifest. Most likely due to a missing applicationId variable in application's build.gradle.");
    super.attachInfo(paramContext, paramProviderInfo);
  }
  
  public int delete(@NonNull Uri paramUri, @Nullable String paramString, @Nullable String[] paramArrayOfString)
  {
    return 0;
  }
  
  @Nullable
  public String getType(@NonNull Uri paramUri)
  {
    return null;
  }
  
  @Nullable
  public Uri insert(@NonNull Uri paramUri, @Nullable ContentValues paramContentValues)
  {
    return null;
  }
  
  public boolean onCreate()
  {
    Context localContext = getContext();
    if (localContext == null)
    {
      Log.i("MlKitInitProvider", "No context available. Manually call MlKit.initialize(), otherwise ML Kit will not be functional.");
      return false;
    }
    j.d(localContext);
    return false;
  }
  
  @Nullable
  public Cursor query(@NonNull Uri paramUri, @Nullable String[] paramArrayOfString1, @Nullable String paramString1, @Nullable String[] paramArrayOfString2, @Nullable String paramString2)
  {
    return null;
  }
  
  public int update(@NonNull Uri paramUri, @Nullable ContentValues paramContentValues, @Nullable String paramString, @Nullable String[] paramArrayOfString)
  {
    return 0;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\mlkit\common\internal\MlKitInitProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */