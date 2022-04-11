package io.reactivex.h0.c.c;

import io.reactivex.b0;
import io.reactivex.e0.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.w;
import io.reactivex.x;
import io.reactivex.z;
import java.util.concurrent.atomic.AtomicReference;

public final class f<T>
  extends x<T>
{
  final b0<? extends T> c;
  final w d;
  
  public f(b0<? extends T> paramb0, w paramw)
  {
    this.c = paramb0;
    this.d = paramw;
  }
  
  protected void l(z<? super T> paramz)
  {
    a locala = new a(paramz, this.c);
    paramz.onSubscribe(locala);
    paramz = this.d.c(locala);
    locala.d.replace(paramz);
  }
  
  static final class a<T>
    extends AtomicReference<c>
    implements z<T>, c, Runnable
  {
    final z<? super T> c;
    final SequentialDisposable d;
    final b0<? extends T> f;
    
    a(z<? super T> paramz, b0<? extends T> paramb0)
    {
      this.c = paramz;
      this.f = paramb0;
      this.d = new SequentialDisposable();
    }
    
    public void dispose()
    {
      DisposableHelper.dispose(this);
      this.d.dispose();
    }
    
    public boolean isDisposed()
    {
      return DisposableHelper.isDisposed((c)get());
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.c.onError(paramThrowable);
    }
    
    public void onSubscribe(c paramc)
    {
      DisposableHelper.setOnce(this, paramc);
    }
    
    public void onSuccess(T paramT)
    {
      this.c.onSuccess(paramT);
    }
    
    public void run()
    {
      this.f.a(this);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\h0\c\c\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */