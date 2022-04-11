package com.google.firebase.crashlytics.ndk;

import com.google.firebase.crashlytics.internal.NativeSessionFileProvider;
import java.io.File;

class SessionFilesProvider
  implements NativeSessionFileProvider
{
  private final SessionFiles sessionFiles;
  
  SessionFilesProvider(SessionFiles paramSessionFiles)
  {
    this.sessionFiles = paramSessionFiles;
  }
  
  public File getAppFile()
  {
    return this.sessionFiles.app;
  }
  
  public File getBinaryImagesFile()
  {
    return this.sessionFiles.binaryImages;
  }
  
  public File getDeviceFile()
  {
    return this.sessionFiles.device;
  }
  
  public File getMetadataFile()
  {
    return this.sessionFiles.metadata;
  }
  
  public File getMinidumpFile()
  {
    return this.sessionFiles.minidump;
  }
  
  public File getOsFile()
  {
    return this.sessionFiles.os;
  }
  
  public File getSessionFile()
  {
    return this.sessionFiles.session;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\ndk\SessionFilesProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */