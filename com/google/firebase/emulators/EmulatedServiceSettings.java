package com.google.firebase.emulators;

import androidx.annotation.NonNull;

public final class EmulatedServiceSettings
{
  private final String host;
  private final int port;
  
  public EmulatedServiceSettings(@NonNull String paramString, int paramInt)
  {
    this.host = paramString;
    this.port = paramInt;
  }
  
  public String getHost()
  {
    return this.host;
  }
  
  public int getPort()
  {
    return this.port;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\emulators\EmulatedServiceSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */