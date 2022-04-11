package com.google.firebase.crashlytics.internal.log;

import androidx.annotation.Nullable;

abstract interface FileLogStore
{
  public abstract void closeLogFile();
  
  public abstract void deleteLogFile();
  
  @Nullable
  public abstract byte[] getLogAsBytes();
  
  @Nullable
  public abstract String getLogAsString();
  
  public abstract void writeToLog(long paramLong, String paramString);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\log\FileLogStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */