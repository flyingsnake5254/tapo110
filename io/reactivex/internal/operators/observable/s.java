package io.reactivex.internal.operators.observable;

import io.reactivex.e;
import io.reactivex.g0.j;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.t;
import io.reactivex.v;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class s<T>
  extends a<T, T>
{
  final j<? super T, ? extends e> d;
  final boolean f;
  
  public s(t<T> paramt, j<? super T, ? extends e> paramj, boolean paramBoolean)
  {
    super(paramt);
    this.d = paramj;
    this.f = paramBoolean;
  }
  
  protected void K0(v<? super T> paramv)
  {
    this.c.a(new a(paramv, this.d, this.f));
  }
  
  static final class a<T>
    extends BasicIntQueueDisposable<T>
    implements v<T>
  {
    final v<? super T> c;
    final AtomicThrowable d;
    final j<? super T, ? extends e> f;
    final boolean q;
    final io.reactivex.e0.b x;
    io.reactivex.e0.c y;
    volatile boolean z;
    
    a(v<? super T> paramv, j<? super T, ? extends e> paramj, boolean paramBoolean)
    {
      this.c = paramv;
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
    
    public void clear() {}
    
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
    
    public boolean isEmpty()
    {
      return true;
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
        paramT = (e)io.reactivex.h0.a.b.e(this.f.apply(paramT), "The mapper returned a null CompletableSource");
        getAndIncrement();
        a locala = new a();
        if ((!this.z) && (this.x.b(locala))) {
          paramT.a(locala);
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
    
    public T poll()
      throws Exception
    {
      return null;
    }
    
    public int requestFusion(int paramInt)
    {
      return paramInt & 0x2;
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
        s.a.this.a(this);
      }
      
      public void onError(Throwable paramThrowable)
      {
        s.a.this.b(this, paramThrowable);
      }
      
      public void onSubscribe(io.reactivex.e0.c paramc)
      {
        DisposableHelper.setOnce(this, paramc);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\observable\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */