package io.reactivex.internal.operators.observable;

import io.reactivex.e0.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.j0.a;
import io.reactivex.t;
import io.reactivex.v;
import io.reactivex.x;
import io.reactivex.z;
import java.util.NoSuchElementException;

public final class t0<T>
  extends x<T>
{
  final t<? extends T> c;
  final T d;
  
  public t0(t<? extends T> paramt, T paramT)
  {
    this.c = paramt;
    this.d = paramT;
  }
  
  public void l(z<? super T> paramz)
  {
    this.c.a(new a(paramz, this.d));
  }
  
  static final class a<T>
    implements v<T>, c
  {
    final z<? super T> c;
    final T d;
    c f;
    T q;
    boolean x;
    
    a(z<? super T> paramz, T paramT)
    {
      this.c = paramz;
      this.d = paramT;
    }
    
    public void dispose()
    {
      this.f.dispose();
    }
    
    public boolean isDisposed()
    {
      return this.f.isDisposed();
    }
    
    public void onComplete()
    {
      if (this.x) {
        return;
      }
      this.x = true;
      Object localObject1 = this.q;
      this.q = null;
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = this.d;
      }
      if (localObject2 != null) {
        this.c.onSuccess(localObject2);
      } else {
        this.c.onError(new NoSuchElementException());
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.x)
      {
        a.r(paramThrowable);
        return;
      }
      this.x = true;
      this.c.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      if (this.x) {
        return;
      }
      if (this.q != null)
      {
        this.x = true;
        this.f.dispose();
        this.c.onError(new IllegalArgumentException("Sequence contains more than one element!"));
        return;
      }
      this.q = paramT;
    }
    
    public void onSubscribe(c paramc)
    {
      if (DisposableHelper.validate(this.f, paramc))
      {
        this.f = paramc;
        this.c.onSubscribe(this);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\observable\t0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */