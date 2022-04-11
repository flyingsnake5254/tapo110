package io.reactivex.h0.c.c;

import io.reactivex.b0;
import io.reactivex.e0.c;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;
import io.reactivex.h0.a.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.x;
import io.reactivex.z;
import java.util.concurrent.atomic.AtomicReference;

public final class e<T>
  extends x<T>
{
  final b0<? extends T> c;
  final io.reactivex.g0.j<? super Throwable, ? extends b0<? extends T>> d;
  
  public e(b0<? extends T> paramb0, io.reactivex.g0.j<? super Throwable, ? extends b0<? extends T>> paramj)
  {
    this.c = paramb0;
    this.d = paramj;
  }
  
  protected void l(z<? super T> paramz)
  {
    this.c.a(new a(paramz, this.d));
  }
  
  static final class a<T>
    extends AtomicReference<c>
    implements z<T>, c
  {
    final z<? super T> c;
    final io.reactivex.g0.j<? super Throwable, ? extends b0<? extends T>> d;
    
    a(z<? super T> paramz, io.reactivex.g0.j<? super Throwable, ? extends b0<? extends T>> paramj)
    {
      this.c = paramz;
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
    
    public void onError(Throwable paramThrowable)
    {
      try
      {
        b0 localb0 = (b0)b.e(this.d.apply(paramThrowable), "The nextFunction returned a null SingleSource.");
        localb0.a(new io.reactivex.internal.observers.j(this, this.c));
        return;
      }
      finally
      {
        a.b(localThrowable);
        this.c.onError(new CompositeException(new Throwable[] { paramThrowable, localThrowable }));
      }
    }
    
    public void onSubscribe(c paramc)
    {
      if (DisposableHelper.setOnce(this, paramc)) {
        this.c.onSubscribe(this);
      }
    }
    
    public void onSuccess(T paramT)
    {
      this.c.onSuccess(paramT);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\h0\c\c\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */