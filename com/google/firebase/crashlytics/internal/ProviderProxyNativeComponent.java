package com.google.firebase.crashlytics.internal;

import androidx.annotation.NonNull;
import com.google.firebase.inject.Provider;
import java.io.File;

public final class ProviderProxyNativeComponent
  implements CrashlyticsNativeComponent
{
  private static final NativeSessionFileProvider MISSING_NATIVE_SESSION_FILE_PROVIDER = new MissingNativeSessionFileProvider(null);
  private final Provider<CrashlyticsNativeComponent> provider;
  
  public ProviderProxyNativeComponent(Provider<CrashlyticsNativeComponent> paramProvider)
  {
    this.provider = paramProvider;
  }
  
  public boolean finalizeSession(@NonNull String paramString)
  {
    CrashlyticsNativeComponent localCrashlyticsNativeComponent = (CrashlyticsNativeComponent)this.provider.get();
    if (localCrashlyticsNativeComponent != null) {
      return localCrashlyticsNativeComponent.finalizeSession(paramString);
    }
    return true;
  }
  
  @NonNull
  public NativeSessionFileProvider getSessionFileProvider(@NonNull String paramString)
  {
    CrashlyticsNativeComponent localCrashlyticsNativeComponent = (CrashlyticsNativeComponent)this.provider.get();
    if (localCrashlyticsNativeComponent != null) {
      return localCrashlyticsNativeComponent.getSessionFileProvider(paramString);
    }
    return MISSING_NATIVE_SESSION_FILE_PROVIDER;
  }
  
  public boolean hasCrashDataForSession(@NonNull String paramString)
  {
    CrashlyticsNativeComponent localCrashlyticsNativeComponent = (CrashlyticsNativeComponent)this.provider.get();
    if (localCrashlyticsNativeComponent != null) {
      return localCrashlyticsNativeComponent.hasCrashDataForSession(paramString);
    }
    return false;
  }
  
  public boolean openSession(@NonNull String paramString)
  {
    CrashlyticsNativeComponent localCrashlyticsNativeComponent = (CrashlyticsNativeComponent)this.provider.get();
    if (localCrashlyticsNativeComponent != null) {
      return localCrashlyticsNativeComponent.openSession(paramString);
    }
    return true;
  }
  
  public void writeBeginSession(@NonNull String paramString1, @NonNull String paramString2, long paramLong)
  {
    CrashlyticsNativeComponent localCrashlyticsNativeComponent = (CrashlyticsNativeComponent)this.provider.get();
    if (localCrashlyticsNativeComponent != null) {
      localCrashlyticsNativeComponent.writeBeginSession(paramString1, paramString2, paramLong);
    }
  }
  
  public void writeSessionApp(@NonNull String paramString1, @NonNull String paramString2, @NonNull String paramString3, @NonNull String paramString4, @NonNull String paramString5, int paramInt, @NonNull String paramString6)
  {
    CrashlyticsNativeComponent localCrashlyticsNativeComponent = (CrashlyticsNativeComponent)this.provider.get();
    if (localCrashlyticsNativeComponent != null) {
      localCrashlyticsNativeComponent.writeSessionApp(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt, paramString6);
    }
  }
  
  public void writeSessionDevice(@NonNull String paramString1, int paramInt1, @NonNull String paramString2, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean, int paramInt3, @NonNull String paramString3, @NonNull String paramString4)
  {
    CrashlyticsNativeComponent localCrashlyticsNativeComponent = (CrashlyticsNativeComponent)this.provider.get();
    if (localCrashlyticsNativeComponent != null) {
      localCrashlyticsNativeComponent.writeSessionDevice(paramString1, paramInt1, paramString2, paramInt2, paramLong1, paramLong2, paramBoolean, paramInt3, paramString3, paramString4);
    }
  }
  
  public void writeSessionOs(@NonNull String paramString1, @NonNull String paramString2, @NonNull String paramString3, boolean paramBoolean)
  {
    CrashlyticsNativeComponent localCrashlyticsNativeComponent = (CrashlyticsNativeComponent)this.provider.get();
    if (localCrashlyticsNativeComponent != null) {
      localCrashlyticsNativeComponent.writeSessionOs(paramString1, paramString2, paramString3, paramBoolean);
    }
  }
  
  private static final class MissingNativeSessionFileProvider
    implements NativeSessionFileProvider
  {
    public File getAppFile()
    {
      return null;
    }
    
    public File getBinaryImagesFile()
    {
      return null;
    }
    
    public File getDeviceFile()
    {
      return null;
    }
    
    public File getMetadataFile()
    {
      return null;
    }
    
    public File getMinidumpFile()
    {
      return null;
    }
    
    public File getOsFile()
    {
      return null;
    }
    
    public File getSessionFile()
    {
      return null;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\ProviderProxyNativeComponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */