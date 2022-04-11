package io.reactivex.h0.c.b;

import io.reactivex.e;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.q;
import io.reactivex.t;
import io.reactivex.v;
import java.util.concurrent.atomic.AtomicReference;

public final class a<R>
  extends q<R>
{
  final e c;
  final t<? extends R> d;
  
  public a(e parame, t<? extends R> paramt)
  {
    this.c = parame;
    this.d = paramt;
  }
  
  protected void K0(v<? super R> paramv)
  {
    a locala = new a(paramv, this.d);
    paramv.onSubscribe(locala);
    this.c.a(locala);
  }
  
  static final class a<R>
    extends AtomicReference<io.reactivex.e0.c>
    implements v<R>, io.reactivex.c, io.reactivex.e0.c
  {
    final v<? super R> c;
    t<? extends R> d;
    
    a(v<? super R> paramv, t<? extends R> paramt)
    {
      this.d = paramt;
      this.c = paramv;
    }
    
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
      t localt = this.d;
      if (localt == null)
      {
        this.c.onComplete();
      }
      else
      {
        this.d = null;
        localt.a(this);
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.c.onError(paramThrowable);
    }
    
    public void onNext(R paramR)
    {
      this.c.onNext(paramR);
    }
    
    public void onSubscribe(io.reactivex.e0.c paramc)
    {
      DisposableHelper.replace(this, paramc);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\h0\c\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */