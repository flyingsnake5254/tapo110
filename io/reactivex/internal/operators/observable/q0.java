package io.reactivex.internal.operators.observable;

import io.reactivex.e0.c;
import io.reactivex.g0.j;
import io.reactivex.h0.a.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.f;
import io.reactivex.m0.d;
import io.reactivex.m0.g;
import io.reactivex.q;
import io.reactivex.t;
import io.reactivex.v;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class q0<T>
  extends a<T, T>
{
  final j<? super q<Throwable>, ? extends t<?>> d;
  
  public q0(t<T> paramt, j<? super q<Throwable>, ? extends t<?>> paramj)
  {
    super(paramt);
    this.d = paramj;
  }
  
  protected void K0(v<? super T> paramv)
  {
    Object localObject = d.n1().l1();
    try
    {
      t localt = (t)b.e(this.d.apply(localObject), "The handler returned a null ObservableSource");
      localObject = new a(paramv, (g)localObject, this.c);
      paramv.onSubscribe((c)localObject);
      localt.a(((a)localObject).x);
      ((a)localObject).f();
      return;
    }
    finally
    {
      io.reactivex.exceptions.a.b(localThrowable);
      EmptyDisposable.error(localThrowable, paramv);
    }
  }
  
  static final class a<T>
    extends AtomicInteger
    implements v<T>, c
  {
    final v<? super T> c;
    final AtomicInteger d;
    final AtomicThrowable f;
    volatile boolean p0;
    final g<Throwable> q;
    final a<T>.a x;
    final AtomicReference<c> y;
    final t<T> z;
    
    a(v<? super T> paramv, g<Throwable> paramg, t<T> paramt)
    {
      this.c = paramv;
      this.q = paramg;
      this.z = paramt;
      this.d = new AtomicInteger();
      this.f = new AtomicThrowable();
      this.x = new a();
      this.y = new AtomicReference();
    }
    
    void a()
    {
      DisposableHelper.dispose(this.y);
      f.a(this.c, this, this.f);
    }
    
    void b(Throwable paramThrowable)
    {
      DisposableHelper.dispose(this.y);
      f.c(this.c, paramThrowable, this, this.f);
    }
    
    void d()
    {
      f();
    }
    
    public void dispose()
    {
      DisposableHelper.dispose(this.y);
      DisposableHelper.dispose(this.x);
    }
    
    void f()
    {
      if (this.d.getAndIncrement() == 0) {
        do
        {
          if (isDisposed()) {
            return;
          }
          if (!this.p0)
          {
            this.p0 = true;
            this.z.a(this);
          }
        } while (this.d.decrementAndGet() != 0);
      }
    }
    
    public boolean isDisposed()
    {
      return DisposableHelper.isDisposed((c)this.y.get());
    }
    
    public void onComplete()
    {
      DisposableHelper.dispose(this.x);
      f.a(this.c, this, this.f);
    }
    
    public void onError(Throwable paramThrowable)
    {
      DisposableHelper.replace(this.y, null);
      this.p0 = false;
      this.q.onNext(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      f.e(this.c, paramT, this, this.f);
    }
    
    public void onSubscribe(c paramc)
    {
      DisposableHelper.replace(this.y, paramc);
    }
    
    final class a
      extends AtomicReference<c>
      implements v<Object>
    {
      a() {}
      
      public void onComplete()
      {
        q0.a.this.a();
      }
      
      public void onError(Throwable paramThrowable)
      {
        q0.a.this.b(paramThrowable);
      }
      
      public void onNext(Object paramObject)
      {
        q0.a.this.d();
      }
      
      public void onSubscribe(c paramc)
      {
        DisposableHelper.setOnce(this, paramc);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\observable\q0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */