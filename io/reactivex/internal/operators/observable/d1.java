package io.reactivex.internal.operators.observable;

import io.reactivex.e0.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.q;
import io.reactivex.v;
import io.reactivex.w;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class d1
  extends q<Long>
{
  final w c;
  final long d;
  final TimeUnit f;
  
  public d1(long paramLong, TimeUnit paramTimeUnit, w paramw)
  {
    this.d = paramLong;
    this.f = paramTimeUnit;
    this.c = paramw;
  }
  
  public void K0(v<? super Long> paramv)
  {
    a locala = new a(paramv);
    paramv.onSubscribe(locala);
    locala.a(this.c.d(locala, this.d, this.f));
  }
  
  static final class a
    extends AtomicReference<c>
    implements c, Runnable
  {
    final v<? super Long> c;
    
    a(v<? super Long> paramv)
    {
      this.c = paramv;
    }
    
    public void a(c paramc)
    {
      DisposableHelper.trySet(this, paramc);
    }
    
    public void dispose()
    {
      DisposableHelper.dispose(this);
    }
    
    public boolean isDisposed()
    {
      boolean bool;
      if (get() == DisposableHelper.DISPOSED) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public void run()
    {
      if (!isDisposed())
      {
        this.c.onNext(Long.valueOf(0L));
        lazySet(EmptyDisposable.INSTANCE);
        this.c.onComplete();
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\observable\d1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */