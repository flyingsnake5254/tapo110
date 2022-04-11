package io.reactivex.internal.operators.observable;

import io.reactivex.e0.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.t;
import io.reactivex.v;

public final class a1<T>
  extends a<T, T>
{
  public a1(t<T> paramt)
  {
    super(paramt);
  }
  
  public void K0(v<? super T> paramv)
  {
    this.c.a(new a(paramv));
  }
  
  static final class a<T>
    implements v<T>, c
  {
    final v<? super T> c;
    c d;
    T f;
    
    a(v<? super T> paramv)
    {
      this.c = paramv;
    }
    
    void a()
    {
      Object localObject = this.f;
      if (localObject != null)
      {
        this.f = null;
        this.c.onNext(localObject);
      }
      this.c.onComplete();
    }
    
    public void dispose()
    {
      this.f = null;
      this.d.dispose();
    }
    
    public boolean isDisposed()
    {
      return this.d.isDisposed();
    }
    
    public void onComplete()
    {
      a();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.f = null;
      this.c.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      this.f = paramT;
    }
    
    public void onSubscribe(c paramc)
    {
      if (DisposableHelper.validate(this.d, paramc))
      {
        this.d = paramc;
        this.c.onSubscribe(this);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\observable\a1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */