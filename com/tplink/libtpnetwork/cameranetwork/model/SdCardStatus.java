package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

public enum SdCardStatus
{
  public static final Companion Companion = new Companion(null);
  private final String raw;
  
  static
  {
    SdCardStatus localSdCardStatus1 = new SdCardStatus("NORMAL", 0, "normal");
    NORMAL = localSdCardStatus1;
    SdCardStatus localSdCardStatus2 = new SdCardStatus("UNFORMATTED", 1, "unformatted");
    UNFORMATTED = localSdCardStatus2;
    SdCardStatus localSdCardStatus3 = new SdCardStatus("ABNORMAL", 2, "abnormal");
    ABNORMAL = localSdCardStatus3;
    SdCardStatus localSdCardStatus4 = new SdCardStatus("FORMATTING", 3, "formatting");
    FORMATTING = localSdCardStatus4;
    SdCardStatus localSdCardStatus5 = new SdCardStatus("OFFLINE", 4, "offline");
    OFFLINE = localSdCardStatus5;
    SdCardStatus localSdCardStatus6 = new SdCardStatus("INSUFFICIENT", 5, "insufficient");
    INSUFFICIENT = localSdCardStatus6;
    SdCardStatus localSdCardStatus7 = new SdCardStatus("FULL", 6, "full");
    FULL = localSdCardStatus7;
    $VALUES = new SdCardStatus[] { localSdCardStatus1, localSdCardStatus2, localSdCardStatus3, localSdCardStatus4, localSdCardStatus5, localSdCardStatus6, localSdCardStatus7 };
  }
  
  private SdCardStatus(String paramString)
  {
    this.raw = paramString;
  }
  
  public static final SdCardStatus fromString(String paramString)
  {
    return Companion.fromString(paramString);
  }
  
  public final String getRaw()
  {
    return this.raw;
  }
  
  public static final class Companion
  {
    public final SdCardStatus fromString(String paramString)
    {
      j.e(paramString, "raw");
      for (SdCardStatus localSdCardStatus : SdCardStatus.values()) {
        if (j.a(localSdCardStatus.getRaw(), paramString)) {
          return localSdCardStatus;
        }
      }
      paramString = null;
      return paramString;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\SdCardStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */