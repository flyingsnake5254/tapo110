package com.google.firebase.crashlytics.ndk;

public class CrashpadMain
{
  public static native void crashpadMain(String[] paramArrayOfString);
  
  public static void main(String[] paramArrayOfString)
  {
    try
    {
      System.loadLibrary("crashlytics-handler");
      crashpadMain(paramArrayOfString);
      return;
    }
    catch (UnsatisfiedLinkError paramArrayOfString)
    {
      throw new RuntimeException(paramArrayOfString);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\ndk\CrashpadMain.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */