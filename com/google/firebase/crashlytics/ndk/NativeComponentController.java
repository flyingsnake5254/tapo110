package com.google.firebase.crashlytics.ndk;

import androidx.annotation.NonNull;

abstract interface NativeComponentController
{
  public abstract boolean finalizeSession(String paramString);
  
  @NonNull
  public abstract SessionFiles getFilesForSession(String paramString);
  
  public abstract boolean hasCrashDataForSession(String paramString);
  
  public abstract boolean initialize(String paramString);
  
  public abstract void writeBeginSession(String paramString1, String paramString2, long paramLong);
  
  public abstract void writeSessionApp(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6);
  
  public abstract void writeSessionDevice(String paramString1, int paramInt1, String paramString2, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean, int paramInt3, String paramString3, String paramString4);
  
  public abstract void writeSessionOs(String paramString1, String paramString2, String paramString3, boolean paramBoolean);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\ndk\NativeComponentController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */