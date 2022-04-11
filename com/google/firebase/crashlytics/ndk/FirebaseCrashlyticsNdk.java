package com.google.firebase.crashlytics.ndk;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.NativeSessionFileProvider;
import java.io.File;

class FirebaseCrashlyticsNdk
  implements CrashlyticsNativeComponent
{
  private static final String FILES_PATH = ".com.google.firebase.crashlytics-ndk";
  private final NativeComponentController controller;
  
  FirebaseCrashlyticsNdk(@NonNull NativeComponentController paramNativeComponentController)
  {
    this.controller = paramNativeComponentController;
  }
  
  static FirebaseCrashlyticsNdk create(@NonNull Context paramContext)
  {
    File localFile = new File(paramContext.getFilesDir(), ".com.google.firebase.crashlytics-ndk");
    return new FirebaseCrashlyticsNdk(new CrashpadController(paramContext, new JniNativeApi(paramContext), new NdkCrashFilesManager(localFile)));
  }
  
  public boolean finalizeSession(@NonNull String paramString)
  {
    return this.controller.finalizeSession(paramString);
  }
  
  @NonNull
  public NativeSessionFileProvider getSessionFileProvider(@NonNull String paramString)
  {
    return new SessionFilesProvider(this.controller.getFilesForSession(paramString));
  }
  
  public boolean hasCrashDataForSession(@NonNull String paramString)
  {
    return this.controller.hasCrashDataForSession(paramString);
  }
  
  public boolean openSession(String paramString)
  {
    boolean bool = this.controller.initialize(paramString);
    if (!bool)
    {
      Logger localLogger = Logger.getLogger();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to initialize Crashlytics NDK for session ");
      localStringBuilder.append(paramString);
      localLogger.w(localStringBuilder.toString());
    }
    return bool;
  }
  
  public void writeBeginSession(@NonNull String paramString1, @NonNull String paramString2, long paramLong)
  {
    this.controller.writeBeginSession(paramString1, paramString2, paramLong);
  }
  
  public void writeSessionApp(@NonNull String paramString1, @NonNull String paramString2, @NonNull String paramString3, @NonNull String paramString4, @NonNull String paramString5, int paramInt, @NonNull String paramString6)
  {
    this.controller.writeSessionApp(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt, paramString6);
  }
  
  public void writeSessionDevice(@NonNull String paramString1, int paramInt1, @NonNull String paramString2, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean, int paramInt3, @NonNull String paramString3, @NonNull String paramString4)
  {
    this.controller.writeSessionDevice(paramString1, paramInt1, paramString2, paramInt2, paramLong1, paramLong2, paramBoolean, paramInt3, paramString3, paramString4);
  }
  
  public void writeSessionOs(@NonNull String paramString1, @NonNull String paramString2, @NonNull String paramString3, boolean paramBoolean)
  {
    this.controller.writeSessionOs(paramString1, paramString2, paramString3, paramBoolean);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\ndk\FirebaseCrashlyticsNdk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */