package com.google.firebase.crashlytics.internal.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File;
import java.io.InputStream;

abstract interface NativeSessionFile
{
  @Nullable
  public abstract CrashlyticsReport.FilesPayload.File asFilePayload();
  
  @NonNull
  public abstract String getReportsEndpointFilename();
  
  @Nullable
  public abstract InputStream getStream();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\common\NativeSessionFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */