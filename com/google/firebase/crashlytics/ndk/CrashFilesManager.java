package com.google.firebase.crashlytics.ndk;

import java.io.File;

abstract interface CrashFilesManager
{
  public abstract void cleanOldSessionFileDirectories();
  
  public abstract void deleteSessionFileDirectory(String paramString);
  
  public abstract File getSessionFileDirectory(String paramString);
  
  public abstract boolean hasSessionFileDirectory(String paramString);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\ndk\CrashFilesManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */