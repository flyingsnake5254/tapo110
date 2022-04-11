package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public final class p
{
  public static final boolean a;
  public static final boolean b;
  private static final File c = new File("/proc/self/fd");
  private static volatile p d;
  private static volatile int e = -1;
  private final boolean f = f();
  private final int g;
  private final int h;
  @GuardedBy("this")
  private int i;
  @GuardedBy("this")
  private boolean j = true;
  private final AtomicBoolean k = new AtomicBoolean(false);
  
  static
  {
    int m = Build.VERSION.SDK_INT;
    boolean bool1 = true;
    boolean bool2;
    if (m < 29) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    a = bool2;
    if (m >= 26) {
      bool2 = bool1;
    } else {
      bool2 = false;
    }
    b = bool2;
  }
  
  @VisibleForTesting
  p()
  {
    if (Build.VERSION.SDK_INT >= 28)
    {
      this.g = 20000;
      this.h = 0;
    }
    else
    {
      this.g = 700;
      this.h = 128;
    }
  }
  
  private boolean a()
  {
    boolean bool;
    if ((a) && (!this.k.get())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static p b()
  {
    if (d == null) {
      try
      {
        if (d == null)
        {
          p localp = new com/bumptech/glide/load/resource/bitmap/p;
          localp.<init>();
          d = localp;
        }
      }
      finally {}
    }
    return d;
  }
  
  private int c()
  {
    int m;
    if (e != -1) {
      m = e;
    } else {
      m = this.g;
    }
    return m;
  }
  
  private boolean d()
  {
    try
    {
      int m = this.i;
      boolean bool = true;
      m++;
      this.i = m;
      if (m >= 50)
      {
        this.i = 0;
        m = c.list().length;
        long l = c();
        if (m >= l) {
          bool = false;
        }
        this.j = bool;
        if ((!bool) && (Log.isLoggable("Downsampler", 5)))
        {
          StringBuilder localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>();
          localStringBuilder.append("Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors ");
          localStringBuilder.append(m);
          localStringBuilder.append(", limit ");
          localStringBuilder.append(l);
          Log.w("Downsampler", localStringBuilder.toString());
        }
      }
      bool = this.j;
      return bool;
    }
    finally {}
  }
  
  private static boolean f()
  {
    boolean bool;
    if ((!g()) && (!h())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static boolean g()
  {
    if (Build.VERSION.SDK_INT != 26) {
      return false;
    }
    Iterator localIterator = Arrays.asList(new String[] { "SC-04J", "SM-N935", "SM-J720", "SM-G570F", "SM-G570M", "SM-G960", "SM-G965", "SM-G935", "SM-G930", "SM-A520", "SM-A720F", "moto e5", "moto e5 play", "moto e5 plus", "moto e5 cruise", "moto g(6) forge", "moto g(6) play" }).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (Build.MODEL.startsWith(str)) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean h()
  {
    if (Build.VERSION.SDK_INT != 27) {
      return false;
    }
    return Arrays.asList(new String[] { "LG-M250", "LG-M320", "LG-Q710AL", "LG-Q710PL", "LGM-K121K", "LGM-K121L", "LGM-K121S", "LGM-X320K", "LGM-X320L", "LGM-X320S", "LGM-X401L", "LGM-X401S", "LM-Q610.FG", "LM-Q610.FGN", "LM-Q617.FG", "LM-Q617.FGN", "LM-Q710.FG", "LM-Q710.FGN", "LM-X220PM", "LM-X220QMA", "LM-X410PM" }).contains(Build.MODEL);
  }
  
  public boolean e(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1)
    {
      if (Log.isLoggable("HardwareConfig", 2)) {
        Log.v("HardwareConfig", "Hardware config disallowed by caller");
      }
      return false;
    }
    if (!this.f)
    {
      if (Log.isLoggable("HardwareConfig", 2)) {
        Log.v("HardwareConfig", "Hardware config disallowed by device model");
      }
      return false;
    }
    if (!b)
    {
      if (Log.isLoggable("HardwareConfig", 2)) {
        Log.v("HardwareConfig", "Hardware config disallowed by sdk");
      }
      return false;
    }
    if (a())
    {
      if (Log.isLoggable("HardwareConfig", 2)) {
        Log.v("HardwareConfig", "Hardware config disallowed by app state");
      }
      return false;
    }
    if (paramBoolean2)
    {
      if (Log.isLoggable("HardwareConfig", 2)) {
        Log.v("HardwareConfig", "Hardware config disallowed because exif orientation is required");
      }
      return false;
    }
    int m = this.h;
    if (paramInt1 < m)
    {
      if (Log.isLoggable("HardwareConfig", 2)) {
        Log.v("HardwareConfig", "Hardware config disallowed because width is too small");
      }
      return false;
    }
    if (paramInt2 < m)
    {
      if (Log.isLoggable("HardwareConfig", 2)) {
        Log.v("HardwareConfig", "Hardware config disallowed because height is too small");
      }
      return false;
    }
    if (!d())
    {
      if (Log.isLoggable("HardwareConfig", 2)) {
        Log.v("HardwareConfig", "Hardware config disallowed because there are insufficient FDs");
      }
      return false;
    }
    return true;
  }
  
  @TargetApi(26)
  boolean i(int paramInt1, int paramInt2, BitmapFactory.Options paramOptions, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramBoolean1 = e(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    if (paramBoolean1)
    {
      paramOptions.inPreferredConfig = Bitmap.Config.HARDWARE;
      paramOptions.inMutable = false;
    }
    return paramBoolean1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\resource\bitmap\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */