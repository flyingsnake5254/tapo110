package com.google.firebase.crashlytics.internal.persistence;

import java.io.File;

public abstract interface FileStore
{
  public abstract File getFilesDir();
  
  public abstract String getFilesDirPath();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\persistence\FileStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */