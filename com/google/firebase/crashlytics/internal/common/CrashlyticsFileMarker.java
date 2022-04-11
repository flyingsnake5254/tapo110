package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import java.io.File;
import java.io.IOException;

class CrashlyticsFileMarker
{
  private final FileStore fileStore;
  private final String markerName;
  
  public CrashlyticsFileMarker(String paramString, FileStore paramFileStore)
  {
    this.markerName = paramString;
    this.fileStore = paramFileStore;
  }
  
  private File getMarkerFile()
  {
    return new File(this.fileStore.getFilesDir(), this.markerName);
  }
  
  public boolean create()
  {
    boolean bool;
    try
    {
      bool = getMarkerFile().createNewFile();
    }
    catch (IOException localIOException)
    {
      Logger localLogger = Logger.getLogger();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Error creating marker: ");
      localStringBuilder.append(this.markerName);
      localLogger.e(localStringBuilder.toString(), localIOException);
      bool = false;
    }
    return bool;
  }
  
  public boolean isPresent()
  {
    return getMarkerFile().exists();
  }
  
  public boolean remove()
  {
    return getMarkerFile().delete();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\common\CrashlyticsFileMarker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */