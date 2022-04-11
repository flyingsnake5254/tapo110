package com.tplink.libmediakit.jniinterface;

import android.os.Build.VERSION;
import android.util.Log;

public class FdSanitizer
{
  private static final String a = "FdSanitizer";
  private static boolean b = true;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 29) {
      System.loadLibrary("fdsan-lib");
    }
  }
  
  private static void a(String paramString1, String paramString2)
  {
    if (b) {
      Log.d(paramString1, paramString2);
    }
  }
  
  public static void b(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 29)
    {
      int i = getFdSanErrorLevelNative();
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fdSan error l1 ");
      localStringBuilder.append(i);
      a(str, localStringBuilder.toString());
      paramInt = setFdSanErrorLevelNative(paramInt);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("fdSan error l2 ");
      localStringBuilder.append(paramInt);
      a(str, localStringBuilder.toString());
      paramInt = getFdSanErrorLevelNative();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("fdSan error l3 ");
      localStringBuilder.append(paramInt);
      a(str, localStringBuilder.toString());
    }
  }
  
  private static native int getFdSanErrorLevelNative();
  
  private static native int setFdSanErrorLevelNative(int paramInt);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libmediakit\jniinterface\FdSanitizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */