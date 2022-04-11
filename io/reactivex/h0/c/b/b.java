package io.reactivex.h0.c.b;

import io.reactivex.b0;
import io.reactivex.e0.c;
import io.reactivex.exceptions.a;
import io.reactivex.g0.j;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.q;
import io.reactivex.t;
import io.reactivex.v;
import io.reactivex.z;
import java.util.concurrent.atomic.AtomicReference;

public final class b<T, R>
  extends q<R>
{
  final b0<T> c;
  final j<? super T, ? extends t<? extends R>> d;
  
  public b(b0<T> paramb0, j<? super T, ? extends t<? extends R>> paramj)
  {
    this.c = paramb0;
    this.d = paramj;
  }
  
  protected void K0(v<? super R> paramv)
  {
    a locala = new a(paramv, this.d);
    paramv.onSubscribe(locala);
    this.c.a(locala);
  }
  
  static final class a<T, R>
    extends AtomicReference<c>
    implements v<R>, z<T>, c
  {
    final v<? super R> c;
    final j<? super T, ? extends t<? extends R>> d;
    
    a(v<? super R> paramv, j<? super T, ? extends t<? extends R>> paramj)
    {
      this.c = paramv;
      this.d = paramj;
    }
    
    public void dispose()
    {
      DisposableHelper.dispose(this);
    }
    
    public boolean isDisposed()
    {
      return DisposableHelper.isDisposed((c)get());
    }
    
    public void onComplete()
    {
      this.c.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.c.onError(paramThrowable);
    }
    
    public void onNext(R paramR)
    {
      this.c.onNext(paramR);
    }
    
    public void onSubscribe(c paramc)
    {
      DisposableHelper.replace(this, paramc);
    }
    
    public void onSuccess(T paramT)
    {
      try
      {
        paramT = (t)io.reactivex.h0.a.b.e(this.d.apply(paramT), "The mapper returned a null Publisher");
        paramT.a(this);
        return;
      }
      finally
      {
        a.b(paramT);
        this.c.onError(paramT);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\h0\c\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */