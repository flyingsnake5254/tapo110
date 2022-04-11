package com.bumptech.glide.util;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.SystemClock;

public final class e
{
  private static final double a;
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    double d = 1.0D;
    if (i >= 17) {
      d = 1.0D / Math.pow(10.0D, 6.0D);
    }
    a = d;
  }
  
  public static double a(long paramLong)
  {
    return (b() - paramLong) * a;
  }
  
  @TargetApi(17)
  public static long b()
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return SystemClock.elapsedRealtimeNanos();
    }
    return SystemClock.uptimeMillis();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\util\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */