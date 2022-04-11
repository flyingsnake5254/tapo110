package com.google.firebase.crashlytics.ndk;

import java.io.File;

final class SessionFiles
{
  public final File app;
  public final File binaryImages;
  public final File device;
  public final File metadata;
  public final File minidump;
  public final File os;
  public final File session;
  
  private SessionFiles(Builder paramBuilder)
  {
    this.minidump = paramBuilder.minidump;
    this.binaryImages = paramBuilder.binaryImages;
    this.metadata = paramBuilder.metadata;
    this.session = paramBuilder.session;
    this.app = paramBuilder.app;
    this.device = paramBuilder.device;
    this.os = paramBuilder.os;
  }
  
  static final class Builder
  {
    private File app;
    private File binaryImages;
    private File device;
    private File metadata;
    private File minidump;
    private File os;
    private File session;
    
    Builder appFile(File paramFile)
    {
      this.app = paramFile;
      return this;
    }
    
    Builder binaryImagesFile(File paramFile)
    {
      this.binaryImages = paramFile;
      return this;
    }
    
    SessionFiles build()
    {
      return new SessionFiles(this, null);
    }
    
    Builder deviceFile(File paramFile)
    {
      this.device = paramFile;
      return this;
    }
    
    Builder metadataFile(File paramFile)
    {
      this.metadata = paramFile;
      return this;
    }
    
    Builder minidumpFile(File paramFile)
    {
      this.minidump = paramFile;
      return this;
    }
    
    Builder osFile(File paramFile)
    {
      this.os = paramFile;
      return this;
    }
    
    Builder sessionFile(File paramFile)
    {
      this.session = paramFile;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\ndk\SessionFiles.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */