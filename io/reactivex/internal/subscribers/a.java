package io.reactivex.internal.subscribers;

import e.b.b;
import e.b.c;
import io.reactivex.h0.b.e;
import io.reactivex.h0.b.f;
import io.reactivex.h0.b.i;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.k;

public abstract class a<T, R>
  implements io.reactivex.h0.b.a<T>, f<R>
{
  protected final io.reactivex.h0.b.a<? super R> c;
  protected c d;
  protected f<T> f;
  protected boolean q;
  protected int x;
  
  public a(io.reactivex.h0.b.a<? super R> parama)
  {
    this.c = parama;
  }
  
  protected void a() {}
  
  protected boolean c()
  {
    return true;
  }
  
  public void cancel()
  {
    this.d.cancel();
  }
  
  public void clear()
  {
    this.f.clear();
  }
  
  protected final void d(Throwable paramThrowable)
  {
    io.reactivex.exceptions.a.b(paramThrowable);
    this.d.cancel();
    onError(paramThrowable);
  }
  
  protected final int e(int paramInt)
  {
    f localf = this.f;
    if ((localf != null) && ((paramInt & 0x4) == 0))
    {
      paramInt = localf.requestFusion(paramInt);
      if (paramInt != 0) {
        this.x = paramInt;
      }
      return paramInt;
    }
    return 0;
  }
  
  public boolean isEmpty()
  {
    return this.f.isEmpty();
  }
  
  public final boolean offer(R paramR)
  {
    throw new UnsupportedOperationException("Should not be called!");
  }
  
  public void onComplete()
  {
    if (this.q) {
      return;
    }
    this.q = true;
    this.c.onComplete();
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (this.q)
    {
      io.reactivex.j0.a.r(paramThrowable);
      return;
    }
    this.q = true;
    this.c.onError(paramThrowable);
  }
  
  public final void onSubscribe(c paramc)
  {
    if (SubscriptionHelper.validate(this.d, paramc))
    {
      this.d = paramc;
      if ((paramc instanceof f)) {
        this.f = ((f)paramc);
      }
      if (c())
      {
        this.c.onSubscribe(this);
        a();
      }
    }
  }
  
  public void request(long paramLong)
  {
    this.d.request(paramLong);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\subscribers\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */