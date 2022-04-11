package com.bumptech.glide.request;

import android.graphics.drawable.Drawable;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.k.i;
import com.bumptech.glide.request.l.b;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class e<R>
  implements c<R>, f<R>
{
  private static final a c = new a();
  private final int d;
  private final int f;
  @GuardedBy("this")
  private boolean p0;
  @GuardedBy("this")
  private boolean p1;
  @GuardedBy("this")
  private boolean p2;
  @GuardedBy("this")
  @Nullable
  private GlideException p3;
  private final boolean q;
  private final a x;
  @GuardedBy("this")
  @Nullable
  private R y;
  @GuardedBy("this")
  @Nullable
  private d z;
  
  public e(int paramInt1, int paramInt2)
  {
    this(paramInt1, paramInt2, true, c);
  }
  
  e(int paramInt1, int paramInt2, boolean paramBoolean, a parama)
  {
    this.d = paramInt1;
    this.f = paramInt2;
    this.q = paramBoolean;
    this.x = parama;
  }
  
  private R k(Long paramLong)
    throws ExecutionException, InterruptedException, TimeoutException
  {
    try
    {
      if ((this.q) && (!isDone())) {
        com.bumptech.glide.util.j.a();
      }
      if (!this.p0)
      {
        if (!this.p2)
        {
          if (this.p1)
          {
            paramLong = this.y;
            return paramLong;
          }
          if (paramLong == null)
          {
            this.x.b(this, 0L);
          }
          else if (paramLong.longValue() > 0L)
          {
            long l1 = System.currentTimeMillis();
            long l2 = paramLong.longValue() + l1;
            while ((!isDone()) && (l1 < l2))
            {
              this.x.b(this, l2 - l1);
              l1 = System.currentTimeMillis();
            }
          }
          if (!Thread.interrupted())
          {
            if (!this.p2)
            {
              if (!this.p0)
              {
                if (this.p1)
                {
                  paramLong = this.y;
                  return paramLong;
                }
                paramLong = new java/util/concurrent/TimeoutException;
                paramLong.<init>();
                throw paramLong;
              }
              paramLong = new java/util/concurrent/CancellationException;
              paramLong.<init>();
              throw paramLong;
            }
            paramLong = new java/util/concurrent/ExecutionException;
            paramLong.<init>(this.p3);
            throw paramLong;
          }
          paramLong = new java/lang/InterruptedException;
          paramLong.<init>();
          throw paramLong;
        }
        paramLong = new java/util/concurrent/ExecutionException;
        paramLong.<init>(this.p3);
        throw paramLong;
      }
      paramLong = new java/util/concurrent/CancellationException;
      paramLong.<init>();
      throw paramLong;
    }
    finally {}
  }
  
  public void a(@NonNull i parami) {}
  
  public void b(@Nullable Drawable paramDrawable) {}
  
  @Nullable
  public d c()
  {
    try
    {
      d locald = this.z;
      return locald;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean cancel(boolean paramBoolean)
  {
    try
    {
      if (isDone()) {
        return false;
      }
      this.p0 = true;
      this.x.a(this);
      d locald = null;
      if (paramBoolean)
      {
        locald = this.z;
        this.z = null;
      }
      if (locald != null) {
        locald.clear();
      }
      return true;
    }
    finally {}
  }
  
  public void d(@Nullable Drawable paramDrawable) {}
  
  public void e(@NonNull R paramR, @Nullable b<? super R> paramb) {}
  
  public void f(@Nullable d paramd)
  {
    try
    {
      this.z = paramd;
      return;
    }
    finally
    {
      paramd = finally;
      throw paramd;
    }
  }
  
  public boolean g(@Nullable GlideException paramGlideException, Object paramObject, com.bumptech.glide.request.k.j<R> paramj, boolean paramBoolean)
  {
    try
    {
      this.p2 = true;
      this.p3 = paramGlideException;
      this.x.a(this);
      return false;
    }
    finally
    {
      paramGlideException = finally;
      throw paramGlideException;
    }
  }
  
  public R get()
    throws InterruptedException, ExecutionException
  {
    try
    {
      Object localObject = k(null);
      return (R)localObject;
    }
    catch (TimeoutException localTimeoutException)
    {
      throw new AssertionError(localTimeoutException);
    }
  }
  
  public R get(long paramLong, @NonNull TimeUnit paramTimeUnit)
    throws InterruptedException, ExecutionException, TimeoutException
  {
    return (R)k(Long.valueOf(paramTimeUnit.toMillis(paramLong)));
  }
  
  public void h(@Nullable Drawable paramDrawable) {}
  
  public boolean i(R paramR, Object paramObject, com.bumptech.glide.request.k.j<R> paramj, DataSource paramDataSource, boolean paramBoolean)
  {
    try
    {
      this.p1 = true;
      this.y = paramR;
      this.x.a(this);
      return false;
    }
    finally
    {
      paramR = finally;
      throw paramR;
    }
  }
  
  public boolean isCancelled()
  {
    try
    {
      boolean bool = this.p0;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean isDone()
  {
    try
    {
      if ((!this.p0) && (!this.p1))
      {
        bool = this.p2;
        if (!bool)
        {
          bool = false;
          break label35;
        }
      }
      boolean bool = true;
      label35:
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void j(@NonNull i parami)
  {
    parami.d(this.d, this.f);
  }
  
  public void onDestroy() {}
  
  public void onStart() {}
  
  public void onStop() {}
  
  @VisibleForTesting
  static class a
  {
    void a(Object paramObject)
    {
      paramObject.notifyAll();
    }
    
    void b(Object paramObject, long paramLong)
      throws InterruptedException
    {
      paramObject.wait(paramLong);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\request\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */