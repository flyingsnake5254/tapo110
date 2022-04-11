package io.reactivex.internal.operators.observable;

import io.reactivex.e0.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.schedulers.l;
import io.reactivex.q;
import io.reactivex.v;
import io.reactivex.w;
import io.reactivex.w.c;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class f0
  extends q<Long>
{
  final w c;
  final long d;
  final long f;
  final TimeUnit q;
  
  public f0(long paramLong1, long paramLong2, TimeUnit paramTimeUnit, w paramw)
  {
    this.d = paramLong1;
    this.f = paramLong2;
    this.q = paramTimeUnit;
    this.c = paramw;
  }
  
  public void K0(v<? super Long> paramv)
  {
    a locala = new a(paramv);
    paramv.onSubscribe(locala);
    paramv = this.c;
    if ((paramv instanceof l))
    {
      paramv = paramv.b();
      locala.a(paramv);
      paramv.d(locala, this.d, this.f, this.q);
    }
    else
    {
      locala.a(paramv.e(locala, this.d, this.f, this.q));
    }
  }
  
  static final class a
    extends AtomicReference<c>
    implements c, Runnable
  {
    final v<? super Long> c;
    long d;
    
    a(v<? super Long> paramv)
    {
      this.c = paramv;
    }
    
    public void a(c paramc)
    {
      DisposableHelper.setOnce(this, paramc);
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
      if (get() != DisposableHelper.DISPOSED)
      {
        v localv = this.c;
        long l = this.d;
        this.d = (1L + l);
        localv.onNext(Long.valueOf(l));
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\observable\f0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */