package com.bumptech.glide.load.engine.a0;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;

public final class i
{
  private final int a;
  private final int b;
  private final Context c;
  private final int d;
  
  i(a parama)
  {
    this.c = parama.b;
    int i;
    if (e(parama.c)) {
      i = parama.i / 2;
    } else {
      i = parama.i;
    }
    this.d = i;
    int j = c(parama.c, parama.g, parama.h);
    float f1 = parama.d.b() * parama.d.a() * 4;
    int k = Math.round(parama.f * f1);
    int m = Math.round(f1 * parama.e);
    int n = j - i;
    int i1 = m + k;
    if (i1 <= n)
    {
      this.b = m;
      this.a = k;
    }
    else
    {
      float f2 = n;
      float f3 = parama.f;
      f1 = parama.e;
      f2 /= (f3 + f1);
      this.b = Math.round(f1 * f2);
      this.a = Math.round(f2 * parama.f);
    }
    if (Log.isLoggable("MemorySizeCalculator", 3))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Calculation complete, Calculated memory cache size: ");
      localStringBuilder.append(f(this.b));
      localStringBuilder.append(", pool size: ");
      localStringBuilder.append(f(this.a));
      localStringBuilder.append(", byte array size: ");
      localStringBuilder.append(f(i));
      localStringBuilder.append(", memory class limited? ");
      boolean bool;
      if (i1 > j) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      localStringBuilder.append(", max size: ");
      localStringBuilder.append(f(j));
      localStringBuilder.append(", memoryClass: ");
      localStringBuilder.append(parama.c.getMemoryClass());
      localStringBuilder.append(", isLowMemoryDevice: ");
      localStringBuilder.append(e(parama.c));
      Log.d("MemorySizeCalculator", localStringBuilder.toString());
    }
  }
  
  private static int c(ActivityManager paramActivityManager, float paramFloat1, float paramFloat2)
  {
    int i = paramActivityManager.getMemoryClass();
    boolean bool = e(paramActivityManager);
    float f = i * 1024 * 1024;
    if (bool) {
      paramFloat1 = paramFloat2;
    }
    return Math.round(f * paramFloat1);
  }
  
  @TargetApi(19)
  static boolean e(ActivityManager paramActivityManager)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramActivityManager.isLowRamDevice();
    }
    return true;
  }
  
  private String f(int paramInt)
  {
    return Formatter.formatFileSize(this.c, paramInt);
  }
  
  public int a()
  {
    return this.d;
  }
  
  public int b()
  {
    return this.a;
  }
  
  public int d()
  {
    return this.b;
  }
  
  public static final class a
  {
    static final int a;
    final Context b;
    ActivityManager c;
    i.c d;
    float e = 2.0F;
    float f = a;
    float g = 0.4F;
    float h = 0.33F;
    int i = 4194304;
    
    static
    {
      int j;
      if (Build.VERSION.SDK_INT < 26) {
        j = 4;
      } else {
        j = 1;
      }
      a = j;
    }
    
    public a(Context paramContext)
    {
      this.b = paramContext;
      this.c = ((ActivityManager)paramContext.getSystemService("activity"));
      this.d = new i.b(paramContext.getResources().getDisplayMetrics());
      if ((Build.VERSION.SDK_INT >= 26) && (i.e(this.c))) {
        this.f = 0.0F;
      }
    }
    
    public i a()
    {
      return new i(this);
    }
  }
  
  private static final class b
    implements i.c
  {
    private final DisplayMetrics a;
    
    b(DisplayMetrics paramDisplayMetrics)
    {
      this.a = paramDisplayMetrics;
    }
    
    public int a()
    {
      return this.a.heightPixels;
    }
    
    public int b()
    {
      return this.a.widthPixels;
    }
  }
  
  static abstract interface c
  {
    public abstract int a();
    
    public abstract int b();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\engine\a0\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */