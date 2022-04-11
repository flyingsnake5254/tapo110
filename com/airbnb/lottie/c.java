package com.airbnb.lottie;

import androidx.annotation.RestrictTo;
import androidx.core.os.TraceCompat;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
public class c
{
  public static boolean a = false;
  private static boolean b = false;
  private static String[] c;
  private static long[] d;
  private static int e;
  private static int f;
  
  public static void a(String paramString)
  {
    if (!b) {
      return;
    }
    int i = e;
    if (i == 20)
    {
      f += 1;
      return;
    }
    c[i] = paramString;
    d[i] = System.nanoTime();
    TraceCompat.beginSection(paramString);
    e += 1;
  }
  
  public static float b(String paramString)
  {
    int i = f;
    if (i > 0)
    {
      f = i - 1;
      return 0.0F;
    }
    if (!b) {
      return 0.0F;
    }
    i = e - 1;
    e = i;
    if (i != -1)
    {
      if (paramString.equals(c[i]))
      {
        TraceCompat.endSection();
        return (float)(System.nanoTime() - d[e]) / 1000000.0F;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unbalanced trace call ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(". Expected ");
      localStringBuilder.append(c[e]);
      localStringBuilder.append(".");
      throw new IllegalStateException(localStringBuilder.toString());
    }
    throw new IllegalStateException("Can't end trace section. There are none.");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */