package com.google.firebase.crashlytics.internal;

import androidx.annotation.NonNull;

public abstract interface CrashlyticsNativeComponent
{
  public abstract boolean finalizeSession(@NonNull String paramString);
  
  @NonNull
  public abstract NativeSessionFileProvider getSessionFileProvider(@NonNull String paramString);
  
  public abstract boolean hasCrashDataForSession(@NonNull String paramString);
  
  public abstract boolean openSession(@NonNull String paramString);
  
  public abstract void writeBeginSession(@NonNull String paramString1, @NonNull String paramString2, long paramLong);
  
  public abstract void writeSessionApp(@NonNull String paramString1, @NonNull String paramString2, @NonNull String paramString3, @NonNull String paramString4, @NonNull String paramString5, int paramInt, @NonNull String paramString6);
  
  public abstract void writeSessionDevice(@NonNull String paramString1, int paramInt1, @NonNull String paramString2, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean, int paramInt3, @NonNull String paramString3, @NonNull String paramString4);
  
  public abstract void writeSessionOs(@NonNull String paramString1, @NonNull String paramString2, @NonNull String paramString3, boolean paramBoolean);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\CrashlyticsNativeComponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */