package com.bumptech.glide.util;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.j.l;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

public final class j
{
  private static final char[] a = "0123456789abcdef".toCharArray();
  private static final char[] b = new char[64];
  @Nullable
  private static volatile Handler c;
  
  public static void a()
  {
    if (r()) {
      return;
    }
    throw new IllegalArgumentException("You must call this method on a background thread");
  }
  
  public static void b()
  {
    if (s()) {
      return;
    }
    throw new IllegalArgumentException("You must call this method on the main thread");
  }
  
  public static boolean c(@Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    if (paramObject1 == null)
    {
      boolean bool;
      if (paramObject2 == null) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    if ((paramObject1 instanceof l)) {
      return ((l)paramObject1).a(paramObject2);
    }
    return paramObject1.equals(paramObject2);
  }
  
  public static boolean d(@Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    boolean bool;
    if (paramObject1 == null)
    {
      if (paramObject2 == null) {
        bool = true;
      } else {
        bool = false;
      }
    }
    else {
      bool = paramObject1.equals(paramObject2);
    }
    return bool;
  }
  
  @NonNull
  private static String e(@NonNull byte[] paramArrayOfByte, @NonNull char[] paramArrayOfChar)
  {
    for (int i = 0; i < paramArrayOfByte.length; i++)
    {
      int j = paramArrayOfByte[i] & 0xFF;
      int k = i * 2;
      char[] arrayOfChar = a;
      paramArrayOfChar[k] = ((char)arrayOfChar[(j >>> 4)]);
      paramArrayOfChar[(k + 1)] = ((char)arrayOfChar[(j & 0xF)]);
    }
    return new String(paramArrayOfChar);
  }
  
  @NonNull
  public static <T> Queue<T> f(int paramInt)
  {
    return new ArrayDeque(paramInt);
  }
  
  public static int g(int paramInt1, int paramInt2, @Nullable Bitmap.Config paramConfig)
  {
    return paramInt1 * paramInt2 * i(paramConfig);
  }
  
  @TargetApi(19)
  public static int h(@NonNull Bitmap paramBitmap)
  {
    if ((paramBitmap.isRecycled()) || (Build.VERSION.SDK_INT >= 19)) {}
    try
    {
      int i = paramBitmap.getAllocationByteCount();
      return i;
    }
    catch (NullPointerException localNullPointerException)
    {
      StringBuilder localStringBuilder;
      for (;;) {}
    }
    return paramBitmap.getHeight() * paramBitmap.getRowBytes();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Cannot obtain size for recycled Bitmap: ");
    localStringBuilder.append(paramBitmap);
    localStringBuilder.append("[");
    localStringBuilder.append(paramBitmap.getWidth());
    localStringBuilder.append("x");
    localStringBuilder.append(paramBitmap.getHeight());
    localStringBuilder.append("] ");
    localStringBuilder.append(paramBitmap.getConfig());
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  private static int i(@Nullable Bitmap.Config paramConfig)
  {
    Bitmap.Config localConfig = paramConfig;
    if (paramConfig == null) {
      localConfig = Bitmap.Config.ARGB_8888;
    }
    int i = a.a[localConfig.ordinal()];
    int j = 4;
    if (i != 1)
    {
      if ((i != 2) && (i != 3))
      {
        if (i == 4) {
          j = 8;
        }
      }
      else {
        j = 2;
      }
    }
    else {
      j = 1;
    }
    return j;
  }
  
  @NonNull
  public static <T> List<T> j(@NonNull Collection<T> paramCollection)
  {
    ArrayList localArrayList = new ArrayList(paramCollection.size());
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      Object localObject = paramCollection.next();
      if (localObject != null) {
        localArrayList.add(localObject);
      }
    }
    return localArrayList;
  }
  
  private static Handler k()
  {
    if (c == null) {
      try
      {
        if (c == null)
        {
          Handler localHandler = new android/os/Handler;
          localHandler.<init>(Looper.getMainLooper());
          c = localHandler;
        }
      }
      finally {}
    }
    return c;
  }
  
  public static int l(float paramFloat)
  {
    return m(paramFloat, 17);
  }
  
  public static int m(float paramFloat, int paramInt)
  {
    return o(Float.floatToIntBits(paramFloat), paramInt);
  }
  
  public static int n(int paramInt)
  {
    return o(paramInt, 17);
  }
  
  public static int o(int paramInt1, int paramInt2)
  {
    return paramInt2 * 31 + paramInt1;
  }
  
  public static int p(@Nullable Object paramObject, int paramInt)
  {
    int i;
    if (paramObject == null) {
      i = 0;
    } else {
      i = paramObject.hashCode();
    }
    return o(i, paramInt);
  }
  
  public static int q(boolean paramBoolean, int paramInt)
  {
    return o(paramBoolean, paramInt);
  }
  
  public static boolean r()
  {
    return s() ^ true;
  }
  
  public static boolean s()
  {
    boolean bool;
    if (Looper.myLooper() == Looper.getMainLooper()) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static boolean t(int paramInt)
  {
    boolean bool;
    if ((paramInt <= 0) && (paramInt != Integer.MIN_VALUE)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static boolean u(int paramInt1, int paramInt2)
  {
    boolean bool;
    if ((t(paramInt1)) && (t(paramInt2))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static void v(Runnable paramRunnable)
  {
    k().post(paramRunnable);
  }
  
  public static void w(Runnable paramRunnable)
  {
    k().removeCallbacks(paramRunnable);
  }
  
  @NonNull
  public static String x(@NonNull byte[] paramArrayOfByte)
  {
    synchronized (b)
    {
      paramArrayOfByte = e(paramArrayOfByte, ???);
      return paramArrayOfByte;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\util\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */