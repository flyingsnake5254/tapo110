package com.google.android.exoplayer2;

import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.h;
import java.util.concurrent.TimeoutException;

public final class x1
{
  private final b a;
  private final a b;
  private final h c;
  private final j2 d;
  private int e;
  @Nullable
  private Object f;
  private Looper g;
  private int h;
  private long i;
  private boolean j;
  private boolean k;
  private boolean l;
  private boolean m;
  private boolean n;
  
  public x1(a parama, b paramb, j2 paramj2, int paramInt, h paramh, Looper paramLooper)
  {
    this.b = parama;
    this.a = paramb;
    this.d = paramj2;
    this.g = paramLooper;
    this.c = paramh;
    this.h = paramInt;
    this.i = -9223372036854775807L;
    this.j = true;
  }
  
  public boolean a(long paramLong)
    throws InterruptedException, TimeoutException
  {
    try
    {
      g.g(this.k);
      boolean bool;
      if (this.g.getThread() != Thread.currentThread()) {
        bool = true;
      } else {
        bool = false;
      }
      g.g(bool);
      long l1 = this.c.elapsedRealtime();
      for (long l2 = paramLong;; l2 = l1 + paramLong - this.c.elapsedRealtime())
      {
        bool = this.m;
        if ((bool) || (l2 <= 0L)) {
          break;
        }
        this.c.c();
        wait(l2);
      }
      if (bool)
      {
        bool = this.l;
        return bool;
      }
      TimeoutException localTimeoutException = new java/util/concurrent/TimeoutException;
      localTimeoutException.<init>("Message delivery timed out.");
      throw localTimeoutException;
    }
    finally {}
  }
  
  public boolean b()
  {
    return this.j;
  }
  
  public Looper c()
  {
    return this.g;
  }
  
  @Nullable
  public Object d()
  {
    return this.f;
  }
  
  public long e()
  {
    return this.i;
  }
  
  public b f()
  {
    return this.a;
  }
  
  public j2 g()
  {
    return this.d;
  }
  
  public int h()
  {
    return this.e;
  }
  
  public int i()
  {
    return this.h;
  }
  
  public boolean j()
  {
    try
    {
      boolean bool = this.n;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void k(boolean paramBoolean)
  {
    try
    {
      this.l = (paramBoolean | this.l);
      this.m = true;
      notifyAll();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public x1 l()
  {
    g.g(this.k ^ true);
    if (this.i == -9223372036854775807L) {
      g.a(this.j);
    }
    this.k = true;
    this.b.e(this);
    return this;
  }
  
  public x1 m(@Nullable Object paramObject)
  {
    g.g(this.k ^ true);
    this.f = paramObject;
    return this;
  }
  
  public x1 n(int paramInt)
  {
    g.g(this.k ^ true);
    this.e = paramInt;
    return this;
  }
  
  public static abstract interface a
  {
    public abstract void e(x1 paramx1);
  }
  
  public static abstract interface b
  {
    public abstract void k(int paramInt, @Nullable Object paramObject)
      throws ExoPlaybackException;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\x1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */