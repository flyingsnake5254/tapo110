package com.tplink.libmediakit.media.audioprocess;

import android.text.TextUtils;
import b.d.p.d;
import java.util.HashMap;
import java.util.Map;

public class e
{
  private static boolean a = true;
  private static Map<String, String> b = new HashMap();
  
  public static void a(String paramString1, String paramString2)
  {
    if (a)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AudioProcess-");
      localStringBuilder.append(paramString1);
      d.a(localStringBuilder.toString(), paramString2);
    }
  }
  
  public static void b(String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    paramString2 = localStringBuilder.toString();
    if (TextUtils.equals((CharSequence)b.get(paramString2), paramString3)) {
      return;
    }
    b.put(paramString2, paramString3);
    if (a)
    {
      paramString2 = new StringBuilder();
      paramString2.append("AudioProcess-");
      paramString2.append(paramString1);
      d.a(paramString2.toString(), paramString3);
    }
  }
  
  public static void c(String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    paramString2 = localStringBuilder.toString();
    if (TextUtils.equals((CharSequence)b.get(paramString2), paramString3)) {
      return;
    }
    b.put(paramString2, paramString3);
    if (a)
    {
      paramString2 = new StringBuilder();
      paramString2.append("AudioProcess-");
      paramString2.append(paramString1);
      d.c(paramString2.toString(), paramString3);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libmediakit\media\audioprocess\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */