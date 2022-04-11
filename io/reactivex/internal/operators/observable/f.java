package io.reactivex.internal.operators.observable;

import io.reactivex.e0.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.d;
import io.reactivex.t;
import io.reactivex.v;
import io.reactivex.w;
import io.reactivex.w.c;
import java.util.concurrent.TimeUnit;

public final class f<T>
  extends a<T, T>
{
  final long d;
  final TimeUnit f;
  final w q;
  final boolean x;
  
  public f(t<T> paramt, long paramLong, TimeUnit paramTimeUnit, w paramw, boolean paramBoolean)
  {
    super(paramt);
    this.d = paramLong;
    this.f = paramTimeUnit;
    this.q = paramw;
    this.x = paramBoolean;
  }
  
  public void K0(v<? super T> paramv)
  {
    if (!this.x) {
      paramv = new d(paramv);
    }
    w.c localc = this.q.b();
    this.c.a(new a(paramv, this.d, this.f, localc, this.x));
  }
  
  static final class a<T>
    implements v<T>, c
  {
    final v<? super T> c;
    final long d;
    final TimeUnit f;
    final w.c q;
    final boolean x;
    c y;
    
    a(v<? super T> paramv, long paramLong, TimeUnit paramTimeUnit, w.c paramc, boolean paramBoolean)
    {
      this.c = paramv;
      this.d = paramLong;
      this.f = paramTimeUnit;
      this.q = paramc;
      this.x = paramBoolean;
    }
    
    public void dispose()
    {
      this.y.dispose();
      this.q.dispose();
    }
    
    public boolean isDisposed()
    {
      return this.q.isDisposed();
    }
    
    public void onComplete()
    {
      this.q.c(new a(), this.d, this.f);
    }
    
    public void onError(Throwable paramThrowable)
    {
      w.c localc = this.q;
      paramThrowable = new b(paramThrowable);
      long l;
      if (this.x) {
        l = this.d;
      } else {
        l = 0L;
      }
      localc.c(paramThrowable, l, this.f);
    }
    
    public void onNext(T paramT)
    {
      this.q.c(new c(paramT), this.d, this.f);
    }
    
    public void onSubscribe(c paramc)
    {
      if (DisposableHelper.validate(this.y, paramc))
      {
        this.y = paramc;
        this.c.onSubscribe(this);
      }
    }
    
    final class a
      implements Runnable
    {
      a() {}
      
      public void run()
      {
        try
        {
          f.a.this.c.onComplete();
          return;
        }
        finally
        {
          f.a.this.q.dispose();
        }
      }
    }
    
    final class b
      implements Runnable
    {
      private final Throwable c;
      
      b(Throwable paramThrowable)
      {
        this.c = paramThrowable;
      }
      
      public void run()
      {
        try
        {
          f.a.this.c.onError(this.c);
          return;
        }
        finally
        {
          f.a.this.q.dispose();
        }
      }
    }
    
    final class c
      implements Runnable
    {
      private final T c;
      
      c()
      {
        Object localObject;
        this.c = localObject;
      }
      
      public void run()
      {
        f.a.this.c.onNext(this.c);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\observable\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */