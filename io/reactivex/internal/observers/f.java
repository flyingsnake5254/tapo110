package io.reactivex.internal.observers;

import io.reactivex.e0.c;
import io.reactivex.internal.util.g;
import io.reactivex.internal.util.j;
import io.reactivex.v;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class f<T, U, V>
  extends h
  implements v<T>, g<U, V>
{
  protected final v<? super V> d;
  protected final io.reactivex.h0.b.h<U> f;
  protected volatile boolean q;
  protected volatile boolean x;
  protected Throwable y;
  
  public f(v<? super V> paramv, io.reactivex.h0.b.h<U> paramh)
  {
    this.d = paramv;
    this.f = paramh;
  }
  
  public abstract void a(v<? super V> paramv, U paramU);
  
  public final int b(int paramInt)
  {
    return this.c.addAndGet(paramInt);
  }
  
  public final boolean c()
  {
    return this.x;
  }
  
  public final boolean d()
  {
    return this.q;
  }
  
  public final Throwable e()
  {
    return this.y;
  }
  
  public final boolean f()
  {
    boolean bool;
    if (this.c.getAndIncrement() == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected final void g(U paramU, boolean paramBoolean, c paramc)
  {
    v localv = this.d;
    io.reactivex.h0.b.h localh = this.f;
    if ((this.c.get() == 0) && (this.c.compareAndSet(0, 1)))
    {
      a(localv, paramU);
      if (b(-1) != 0) {}
    }
    else
    {
      localh.offer(paramU);
      if (!f()) {
        return;
      }
    }
    j.c(localh, localv, paramBoolean, paramc, this);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\observers\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */