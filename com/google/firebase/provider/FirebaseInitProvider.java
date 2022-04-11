package com.google.firebase.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.FirebaseApp;

public class FirebaseInitProvider
  extends ContentProvider
{
  @VisibleForTesting
  static final String EMPTY_APPLICATION_ID_PROVIDER_AUTHORITY = "com.google.firebase.firebaseinitprovider";
  private static final String TAG = "FirebaseInitProvider";
  
  private static void checkContentProviderAuthority(@NonNull ProviderInfo paramProviderInfo)
  {
    Preconditions.checkNotNull(paramProviderInfo, "FirebaseInitProvider ProviderInfo cannot be null.");
    if (!"com.google.firebase.firebaseinitprovider".equals(paramProviderInfo.authority)) {
      return;
    }
    throw new IllegalStateException("Incorrect provider authority in manifest. Most likely due to a missing applicationId variable in application's build.gradle.");
  }
  
  public void attachInfo(@NonNull Context paramContext, @NonNull ProviderInfo paramProviderInfo)
  {
    checkContentProviderAuthority(paramProviderInfo);
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
    if (FirebaseApp.initializeApp(getContext()) == null) {
      Log.i("FirebaseInitProvider", "FirebaseApp initialization unsuccessful");
    } else {
      Log.i("FirebaseInitProvider", "FirebaseApp initialization successful");
    }
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\provider\FirebaseInitProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */