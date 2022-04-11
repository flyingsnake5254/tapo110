package com.tplink.libmediakit.jniinterface;

public class GenKey
{
  static
  {
    System.loadLibrary("tpgenkey");
  }
  
  public static String a()
  {
    return generateDefaultPsw();
  }
  
  public static String b()
  {
    return generateDefaultUsername();
  }
  
  private static native String generateDefaultPsw();
  
  private static native String generateDefaultUsername();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libmediakit\jniinterface\GenKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */