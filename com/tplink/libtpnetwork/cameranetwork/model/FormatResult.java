package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

public enum FormatResult
{
  public static final Companion Companion = new Companion(null);
  private final String raw;
  
  static
  {
    FormatResult localFormatResult1 = new FormatResult("WAITING", 0, "waiting");
    WAITING = localFormatResult1;
    FormatResult localFormatResult2 = new FormatResult("SUCCESS", 1, "success");
    SUCCESS = localFormatResult2;
    $VALUES = new FormatResult[] { localFormatResult1, localFormatResult2 };
  }
  
  private FormatResult(String paramString)
  {
    this.raw = paramString;
  }
  
  public static final FormatResult fromString(String paramString)
  {
    return Companion.fromString(paramString);
  }
  
  public static final class Companion
  {
    public final FormatResult fromString(String paramString)
    {
      j.e(paramString, "raw");
      for (FormatResult localFormatResult : FormatResult.values()) {
        if (j.a(FormatResult.access$getRaw$p(localFormatResult), paramString)) {
          return localFormatResult;
        }
      }
      paramString = null;
      return paramString;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\FormatResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */