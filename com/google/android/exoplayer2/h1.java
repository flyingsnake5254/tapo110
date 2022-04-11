package com.google.android.exoplayer2;

import android.os.Build.VERSION;
import java.util.HashSet;

public final class h1
{
  @Deprecated
  public static final String a;
  private static final HashSet<String> b = new HashSet();
  private static String c = "goog.exo.core";
  
  static
  {
    String str = Build.VERSION.RELEASE;
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str).length() + 57);
    localStringBuilder.append("ExoPlayerLib/2.15.0 (Linux; Android ");
    localStringBuilder.append(str);
    localStringBuilder.append(") ");
    localStringBuilder.append("ExoPlayerLib/2.15.0");
    a = localStringBuilder.toString();
  }
  
  public static void a(String paramString)
  {
    try
    {
      if (b.add(paramString))
      {
        String str = c;
        int i = String.valueOf(str).length();
        int j = String.valueOf(paramString).length();
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>(i + 2 + j);
        localStringBuilder.append(str);
        localStringBuilder.append(", ");
        localStringBuilder.append(paramString);
        c = localStringBuilder.toString();
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static String b()
  {
    try
    {
      String str = c;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\h1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */