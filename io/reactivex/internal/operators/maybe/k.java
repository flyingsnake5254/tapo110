package io.reactivex.internal.operators.maybe;

import io.reactivex.e0.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.n;
import io.reactivex.o;
import io.reactivex.x;
import io.reactivex.z;
import java.util.NoSuchElementException;

public final class k<T>
  extends x<T>
{
  final o<T> c;
  final T d;
  
  public k(o<T> paramo, T paramT)
  {
    this.c = paramo;
    this.d = paramT;
  }
  
  protected void l(z<? super T> paramz)
  {
    this.c.a(new a(paramz, this.d));
  }
  
  static final class a<T>
    implements n<T>, c
  {
    final z<? super T> c;
    final T d;
    c f;
    
    a(z<? super T> paramz, T paramT)
    {
      this.c = paramz;
      this.d = paramT;
    }
    
    public void dispose()
    {
      this.f.dispose();
      this.f = DisposableHelper.DISPOSED;
    }
    
    public boolean isDisposed()
    {
      return this.f.isDisposed();
    }
    
    public void onComplete()
    {
      this.f = DisposableHelper.DISPOSED;
      Object localObject = this.d;
      if (localObject != null) {
        this.c.onSuccess(localObject);
      } else {
        this.c.onError(new NoSuchElementException("The MaybeSource is empty"));
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.f = DisposableHelper.DISPOSED;
      this.c.onError(paramThrowable);
    }
    
    public void onSubscribe(c paramc)
    {
      if (DisposableHelper.validate(this.f, paramc))
      {
        this.f = paramc;
        this.c.onSubscribe(this);
      }
    }
    
    public void onSuccess(T paramT)
    {
      this.f = DisposableHelper.DISPOSED;
      this.c.onSuccess(paramT);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\maybe\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */