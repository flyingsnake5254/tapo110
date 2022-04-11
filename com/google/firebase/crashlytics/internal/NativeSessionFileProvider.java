package com.google.firebase.crashlytics.internal;

import androidx.annotation.Nullable;
import java.io.File;

public abstract interface NativeSessionFileProvider
{
  @Nullable
  public abstract File getAppFile();
  
  @Nullable
  public abstract File getBinaryImagesFile();
  
  @Nullable
  public abstract File getDeviceFile();
  
  @Nullable
  public abstract File getMetadataFile();
  
  @Nullable
  public abstract File getMinidumpFile();
  
  @Nullable
  public abstract File getOsFile();
  
  @Nullable
  public abstract File getSessionFile();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\NativeSessionFileProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */