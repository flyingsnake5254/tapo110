package com.bumptech.glide.load.engine.z;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class k
  implements e
{
  private static final Bitmap.Config a = Bitmap.Config.ARGB_8888;
  private final l b;
  private final Set<Bitmap.Config> c;
  private final long d;
  private final a e;
  private long f;
  private long g;
  private int h;
  private int i;
  private int j;
  private int k;
  
  public k(long paramLong)
  {
    this(paramLong, l(), k());
  }
  
  k(long paramLong, l paraml, Set<Bitmap.Config> paramSet)
  {
    this.d = paramLong;
    this.f = paramLong;
    this.b = paraml;
    this.c = paramSet;
    this.e = new b();
  }
  
  @TargetApi(26)
  private static void f(Bitmap.Config paramConfig)
  {
    if (Build.VERSION.SDK_INT < 26) {
      return;
    }
    if (paramConfig != Bitmap.Config.HARDWARE) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Cannot create a mutable Bitmap with config: ");
    localStringBuilder.append(paramConfig);
    localStringBuilder.append(". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  @NonNull
  private static Bitmap g(int paramInt1, int paramInt2, @Nullable Bitmap.Config paramConfig)
  {
    if (paramConfig == null) {
      paramConfig = a;
    }
    return Bitmap.createBitmap(paramInt1, paramInt2, paramConfig);
  }
  
  private void h()
  {
    if (Log.isLoggable("LruBitmapPool", 2)) {
      i();
    }
  }
  
  private void i()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Hits=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", misses=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", puts=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", evictions=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", currentSize=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", maxSize=");
    localStringBuilder.append(this.f);
    localStringBuilder.append("\nStrategy=");
    localStringBuilder.append(this.b);
    Log.v("LruBitmapPool", localStringBuilder.toString());
  }
  
  private void j()
  {
    q(this.f);
  }
  
  @TargetApi(26)
  private static Set<Bitmap.Config> k()
  {
    HashSet localHashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
    int m = Build.VERSION.SDK_INT;
    if (m >= 19) {
      localHashSet.add(null);
    }
    if (m >= 26) {
      localHashSet.remove(Bitmap.Config.HARDWARE);
    }
    return Collections.unmodifiableSet(localHashSet);
  }
  
  private static l l()
  {
    Object localObject;
    if (Build.VERSION.SDK_INT >= 19) {
      localObject = new n();
    } else {
      localObject = new c();
    }
    return (l)localObject;
  }
  
  @Nullable
  private Bitmap m(int paramInt1, int paramInt2, @Nullable Bitmap.Config paramConfig)
  {
    try
    {
      f(paramConfig);
      Object localObject1 = this.b;
      if (paramConfig != null) {
        localObject2 = paramConfig;
      } else {
        localObject2 = a;
      }
      Object localObject2 = ((l)localObject1).d(paramInt1, paramInt2, (Bitmap.Config)localObject2);
      if (localObject2 == null)
      {
        if (Log.isLoggable("LruBitmapPool", 3))
        {
          localObject1 = new java/lang/StringBuilder;
          ((StringBuilder)localObject1).<init>();
          ((StringBuilder)localObject1).append("Missing bitmap=");
          ((StringBuilder)localObject1).append(this.b.b(paramInt1, paramInt2, paramConfig));
          Log.d("LruBitmapPool", ((StringBuilder)localObject1).toString());
        }
        this.i += 1;
      }
      else
      {
        this.h += 1;
        this.g -= this.b.e((Bitmap)localObject2);
        this.e.a((Bitmap)localObject2);
        p((Bitmap)localObject2);
      }
      if (Log.isLoggable("LruBitmapPool", 2))
      {
        localObject1 = new java/lang/StringBuilder;
        ((StringBuilder)localObject1).<init>();
        ((StringBuilder)localObject1).append("Get bitmap=");
        ((StringBuilder)localObject1).append(this.b.b(paramInt1, paramInt2, paramConfig));
        Log.v("LruBitmapPool", ((StringBuilder)localObject1).toString());
      }
      h();
      return (Bitmap)localObject2;
    }
    finally {}
  }
  
  @TargetApi(19)
  private static void o(Bitmap paramBitmap)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      paramBitmap.setPremultiplied(true);
    }
  }
  
  private static void p(Bitmap paramBitmap)
  {
    paramBitmap.setHasAlpha(true);
    o(paramBitmap);
  }
  
  private void q(long paramLong)
  {
    try
    {
      while (this.g > paramLong)
      {
        Bitmap localBitmap = this.b.removeLast();
        if (localBitmap == null)
        {
          if (Log.isLoggable("LruBitmapPool", 5))
          {
            Log.w("LruBitmapPool", "Size mismatch, resetting");
            i();
          }
          this.g = 0L;
          return;
        }
        this.e.a(localBitmap);
        this.g -= this.b.e(localBitmap);
        this.k += 1;
        if (Log.isLoggable("LruBitmapPool", 3))
        {
          StringBuilder localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>();
          localStringBuilder.append("Evicting bitmap=");
          localStringBuilder.append(this.b.a(localBitmap));
          Log.d("LruBitmapPool", localStringBuilder.toString());
        }
        h();
        localBitmap.recycle();
      }
      return;
    }
    finally {}
  }
  
  @SuppressLint({"InlinedApi"})
  public void a(int paramInt)
  {
    if (Log.isLoggable("LruBitmapPool", 3))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("trimMemory, level=");
      localStringBuilder.append(paramInt);
      Log.d("LruBitmapPool", localStringBuilder.toString());
    }
    if ((paramInt < 40) && ((Build.VERSION.SDK_INT < 23) || (paramInt < 20)))
    {
      if ((paramInt >= 20) || (paramInt == 15)) {
        q(n() / 2L);
      }
    }
    else {
      b();
    }
  }
  
  public void b()
  {
    if (Log.isLoggable("LruBitmapPool", 3)) {
      Log.d("LruBitmapPool", "clearMemory");
    }
    q(0L);
  }
  
  public void c(Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      try
      {
        if (!paramBitmap.isRecycled())
        {
          StringBuilder localStringBuilder;
          if ((paramBitmap.isMutable()) && (this.b.e(paramBitmap) <= this.f) && (this.c.contains(paramBitmap.getConfig())))
          {
            int m = this.b.e(paramBitmap);
            this.b.c(paramBitmap);
            this.e.b(paramBitmap);
            this.j += 1;
            this.g += m;
            if (Log.isLoggable("LruBitmapPool", 2))
            {
              localStringBuilder = new java/lang/StringBuilder;
              localStringBuilder.<init>();
              localStringBuilder.append("Put bitmap in pool=");
              localStringBuilder.append(this.b.a(paramBitmap));
              Log.v("LruBitmapPool", localStringBuilder.toString());
            }
            h();
            j();
            return;
          }
          if (Log.isLoggable("LruBitmapPool", 2))
          {
            localStringBuilder = new java/lang/StringBuilder;
            localStringBuilder.<init>();
            localStringBuilder.append("Reject bitmap from pool, bitmap: ");
            localStringBuilder.append(this.b.a(paramBitmap));
            localStringBuilder.append(", is mutable: ");
            localStringBuilder.append(paramBitmap.isMutable());
            localStringBuilder.append(", is allowed config: ");
            localStringBuilder.append(this.c.contains(paramBitmap.getConfig()));
            Log.v("LruBitmapPool", localStringBuilder.toString());
          }
          paramBitmap.recycle();
          return;
        }
        paramBitmap = new java/lang/IllegalStateException;
        paramBitmap.<init>("Cannot pool recycled bitmap");
        throw paramBitmap;
      }
      finally
      {
        break label301;
      }
    }
    paramBitmap = new java/lang/NullPointerException;
    paramBitmap.<init>("Bitmap must not be null");
    throw paramBitmap;
    label301:
    throw paramBitmap;
  }
  
  @NonNull
  public Bitmap d(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    Bitmap localBitmap = m(paramInt1, paramInt2, paramConfig);
    if (localBitmap != null)
    {
      localBitmap.eraseColor(0);
      paramConfig = localBitmap;
    }
    else
    {
      paramConfig = g(paramInt1, paramInt2, paramConfig);
    }
    return paramConfig;
  }
  
  @NonNull
  public Bitmap e(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    Bitmap localBitmap1 = m(paramInt1, paramInt2, paramConfig);
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null) {
      localBitmap2 = g(paramInt1, paramInt2, paramConfig);
    }
    return localBitmap2;
  }
  
  public long n()
  {
    return this.f;
  }
  
  private static abstract interface a
  {
    public abstract void a(Bitmap paramBitmap);
    
    public abstract void b(Bitmap paramBitmap);
  }
  
  private static final class b
    implements k.a
  {
    public void a(Bitmap paramBitmap) {}
    
    public void b(Bitmap paramBitmap) {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\engine\z\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */