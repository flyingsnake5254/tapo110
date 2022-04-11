package io.reactivex.internal.operators.observable;

import io.reactivex.e;
import io.reactivex.g0.j;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.q;
import io.reactivex.v;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class t<T>
  extends io.reactivex.a
  implements io.reactivex.h0.b.c<T>
{
  final io.reactivex.t<T> c;
  final j<? super T, ? extends e> d;
  final boolean f;
  
  public t(io.reactivex.t<T> paramt, j<? super T, ? extends e> paramj, boolean paramBoolean)
  {
    this.c = paramt;
    this.d = paramj;
    this.f = paramBoolean;
  }
  
  protected void B(io.reactivex.c paramc)
  {
    this.c.a(new a(paramc, this.d, this.f));
  }
  
  public q<T> b()
  {
    return io.reactivex.j0.a.n(new s(this.c, this.d, this.f));
  }
  
  static final class a<T>
    extends AtomicInteger
    implements io.reactivex.e0.c, v<T>
  {
    final io.reactivex.c c;
    final AtomicThrowable d;
    final j<? super T, ? extends e> f;
    final boolean q;
    final io.reactivex.e0.b x;
    io.reactivex.e0.c y;
    volatile boolean z;
    
    a(io.reactivex.c paramc, j<? super T, ? extends e> paramj, boolean paramBoolean)
    {
      this.c = paramc;
      this.f = paramj;
      this.q = paramBoolean;
      this.d = new AtomicThrowable();
      this.x = new io.reactivex.e0.b();
      lazySet(1);
    }
    
    void a(a<T>.a parama)
    {
      this.x.c(parama);
      onComplete();
    }
    
    void b(a<T>.a parama, Throwable paramThrowable)
    {
      this.x.c(parama);
      onError(paramThrowable);
    }
    
    public void dispose()
    {
      this.z = true;
      this.y.dispose();
      this.x.dispose();
    }
    
    public boolean isDisposed()
    {
      return this.y.isDisposed();
    }
    
    public void onComplete()
    {
      if (decrementAndGet() == 0)
      {
        Throwable localThrowable = this.d.terminate();
        if (localThrowable != null) {
          this.c.onError(localThrowable);
        } else {
          this.c.onComplete();
        }
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.d.addThrowable(paramThrowable))
      {
        if (this.q)
        {
          if (decrementAndGet() == 0)
          {
            paramThrowable = this.d.terminate();
            this.c.onError(paramThrowable);
          }
        }
        else
        {
          dispose();
          if (getAndSet(0) > 0)
          {
            paramThrowable = this.d.terminate();
            this.c.onError(paramThrowable);
          }
        }
      }
      else {
        io.reactivex.j0.a.r(paramThrowable);
      }
    }
    
    public void onNext(T paramT)
    {
      try
      {
        e locale = (e)io.reactivex.h0.a.b.e(this.f.apply(paramT), "The mapper returned a null CompletableSource");
        getAndIncrement();
        paramT = new a();
        if ((!this.z) && (this.x.b(paramT))) {
          locale.a(paramT);
        }
        return;
      }
      finally
      {
        io.reactivex.exceptions.a.b(paramT);
        this.y.dispose();
        onError(paramT);
      }
    }
    
    public void onSubscribe(io.reactivex.e0.c paramc)
    {
      if (DisposableHelper.validate(this.y, paramc))
      {
        this.y = paramc;
        this.c.onSubscribe(this);
      }
    }
    
    final class a
      extends AtomicReference<io.reactivex.e0.c>
      implements io.reactivex.c, io.reactivex.e0.c
    {
      a() {}
      
      public void dispose()
      {
        DisposableHelper.dispose(this);
      }
      
      public boolean isDisposed()
      {
        return DisposableHelper.isDisposed((io.reactivex.e0.c)get());
      }
      
      public void onComplete()
      {
        t.a.this.a(this);
      }
      
      public void onError(Throwable paramThrowable)
      {
        t.a.this.b(this, paramThrowable);
      }
      
      public void onSubscribe(io.reactivex.e0.c paramc)
      {
        DisposableHelper.setOnce(this, paramc);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\observable\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */