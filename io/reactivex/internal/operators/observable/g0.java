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

public final class g0
  extends q<Long>
{
  final w c;
  final long d;
  final long f;
  final long q;
  final long x;
  final TimeUnit y;
  
  public g0(long paramLong1, long paramLong2, long paramLong3, long paramLong4, TimeUnit paramTimeUnit, w paramw)
  {
    this.q = paramLong3;
    this.x = paramLong4;
    this.y = paramTimeUnit;
    this.c = paramw;
    this.d = paramLong1;
    this.f = paramLong2;
  }
  
  public void K0(v<? super Long> paramv)
  {
    a locala = new a(paramv, this.d, this.f);
    paramv.onSubscribe(locala);
    paramv = this.c;
    if ((paramv instanceof l))
    {
      paramv = paramv.b();
      locala.a(paramv);
      paramv.d(locala, this.q, this.x, this.y);
    }
    else
    {
      locala.a(paramv.e(locala, this.q, this.x, this.y));
    }
  }
  
  static final class a
    extends AtomicReference<c>
    implements c, Runnable
  {
    final v<? super Long> c;
    final long d;
    long f;
    
    a(v<? super Long> paramv, long paramLong1, long paramLong2)
    {
      this.c = paramv;
      this.f = paramLong1;
      this.d = paramLong2;
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
      if (!isDisposed())
      {
        long l = this.f;
        this.c.onNext(Long.valueOf(l));
        if (l == this.d)
        {
          DisposableHelper.dispose(this);
          this.c.onComplete();
          return;
        }
        this.f = (l + 1L);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\observable\g0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */