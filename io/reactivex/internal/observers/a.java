package io.reactivex.internal.observers;

import io.reactivex.e0.c;
import io.reactivex.h0.b.d;
import io.reactivex.h0.b.e;
import io.reactivex.h0.b.i;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.v;

public abstract class a<T, R>
  implements v<T>, d<R>
{
  protected final v<? super R> c;
  protected c d;
  protected d<T> f;
  protected boolean q;
  protected int x;
  
  public a(v<? super R> paramv)
  {
    this.c = paramv;
  }
  
  protected void a() {}
  
  protected boolean b()
  {
    return true;
  }
  
  protected final void c(Throwable paramThrowable)
  {
    io.reactivex.exceptions.a.b(paramThrowable);
    this.d.dispose();
    onError(paramThrowable);
  }
  
  public void clear()
  {
    this.f.clear();
  }
  
  protected final int d(int paramInt)
  {
    d locald = this.f;
    if ((locald != null) && ((paramInt & 0x4) == 0))
    {
      paramInt = locald.requestFusion(paramInt);
      if (paramInt != 0) {
        this.x = paramInt;
      }
      return paramInt;
    }
    return 0;
  }
  
  public void dispose()
  {
    this.d.dispose();
  }
  
  public boolean isDisposed()
  {
    return this.d.isDisposed();
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
    if (DisposableHelper.validate(this.d, paramc))
    {
      this.d = paramc;
      if ((paramc instanceof d)) {
        this.f = ((d)paramc);
      }
      if (b())
      {
        this.c.onSubscribe(this);
        a();
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\observers\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */