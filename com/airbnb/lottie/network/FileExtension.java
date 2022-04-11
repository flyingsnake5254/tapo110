package com.airbnb.lottie.network;

import com.airbnb.lottie.v.d;

public enum FileExtension
{
  public final String extension;
  
  static
  {
    FileExtension localFileExtension1 = new FileExtension("JSON", 0, ".json");
    JSON = localFileExtension1;
    FileExtension localFileExtension2 = new FileExtension("ZIP", 1, ".zip");
    ZIP = localFileExtension2;
    $VALUES = new FileExtension[] { localFileExtension1, localFileExtension2 };
  }
  
  private FileExtension(String paramString)
  {
    this.extension = paramString;
  }
  
  public static FileExtension forFile(String paramString)
  {
    for (FileExtension localFileExtension : ) {
      if (paramString.endsWith(localFileExtension.extension)) {
        return localFileExtension;
      }
    }
    ??? = new StringBuilder();
    ((StringBuilder)???).append("Unable to find correct extension for ");
    ((StringBuilder)???).append(paramString);
    d.c(((StringBuilder)???).toString());
    return JSON;
  }
  
  public String tempExtension()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(".temp");
    localStringBuilder.append(this.extension);
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    return this.extension;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\network\FileExtension.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */