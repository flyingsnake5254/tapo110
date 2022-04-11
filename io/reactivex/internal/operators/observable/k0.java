package io.reactivex.internal.operators.observable;

import io.reactivex.e0.c;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.g0.j;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.t;
import io.reactivex.v;

public final class k0<T>
  extends a<T, T>
{
  final j<? super Throwable, ? extends t<? extends T>> d;
  final boolean f;
  
  public k0(t<T> paramt, j<? super Throwable, ? extends t<? extends T>> paramj, boolean paramBoolean)
  {
    super(paramt);
    this.d = paramj;
    this.f = paramBoolean;
  }
  
  public void K0(v<? super T> paramv)
  {
    a locala = new a(paramv, this.d, this.f);
    paramv.onSubscribe(locala.q);
    this.c.a(locala);
  }
  
  static final class a<T>
    implements v<T>
  {
    final v<? super T> c;
    final j<? super Throwable, ? extends t<? extends T>> d;
    final boolean f;
    final SequentialDisposable q;
    boolean x;
    boolean y;
    
    a(v<? super T> paramv, j<? super Throwable, ? extends t<? extends T>> paramj, boolean paramBoolean)
    {
      this.c = paramv;
      this.d = paramj;
      this.f = paramBoolean;
      this.q = new SequentialDisposable();
    }
    
    public void onComplete()
    {
      if (this.y) {
        return;
      }
      this.y = true;
      this.x = true;
      this.c.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.x)
      {
        if (this.y)
        {
          io.reactivex.j0.a.r(paramThrowable);
          return;
        }
        this.c.onError(paramThrowable);
        return;
      }
      this.x = true;
      if ((this.f) && (!(paramThrowable instanceof Exception)))
      {
        this.c.onError(paramThrowable);
        return;
      }
      try
      {
        Object localObject = (t)this.d.apply(paramThrowable);
        if (localObject == null)
        {
          localObject = new NullPointerException("Observable is null");
          ((NullPointerException)localObject).initCause(paramThrowable);
          this.c.onError((Throwable)localObject);
          return;
        }
        ((t)localObject).a(this);
        return;
      }
      finally
      {
        io.reactivex.exceptions.a.b(localThrowable);
        this.c.onError(new CompositeException(new Throwable[] { paramThrowable, localThrowable }));
      }
    }
    
    public void onNext(T paramT)
    {
      if (this.y) {
        return;
      }
      this.c.onNext(paramT);
    }
    
    public void onSubscribe(c paramc)
    {
      this.q.replace(paramc);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\observable\k0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */