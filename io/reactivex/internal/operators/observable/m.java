package io.reactivex.internal.operators.observable;

import io.reactivex.e0.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.t;
import io.reactivex.v;
import java.util.NoSuchElementException;

public final class m<T>
  extends a<T, T>
{
  final long d;
  final T f;
  final boolean q;
  
  public m(t<T> paramt, long paramLong, T paramT, boolean paramBoolean)
  {
    super(paramt);
    this.d = paramLong;
    this.f = paramT;
    this.q = paramBoolean;
  }
  
  public void K0(v<? super T> paramv)
  {
    this.c.a(new a(paramv, this.d, this.f, this.q));
  }
  
  static final class a<T>
    implements v<T>, c
  {
    final v<? super T> c;
    final long d;
    final T f;
    final boolean q;
    c x;
    long y;
    boolean z;
    
    a(v<? super T> paramv, long paramLong, T paramT, boolean paramBoolean)
    {
      this.c = paramv;
      this.d = paramLong;
      this.f = paramT;
      this.q = paramBoolean;
    }
    
    public void dispose()
    {
      this.x.dispose();
    }
    
    public boolean isDisposed()
    {
      return this.x.isDisposed();
    }
    
    public void onComplete()
    {
      if (!this.z)
      {
        this.z = true;
        Object localObject = this.f;
        if ((localObject == null) && (this.q))
        {
          this.c.onError(new NoSuchElementException());
        }
        else
        {
          if (localObject != null) {
            this.c.onNext(localObject);
          }
          this.c.onComplete();
        }
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.z)
      {
        io.reactivex.j0.a.r(paramThrowable);
        return;
      }
      this.z = true;
      this.c.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      if (this.z) {
        return;
      }
      long l = this.y;
      if (l == this.d)
      {
        this.z = true;
        this.x.dispose();
        this.c.onNext(paramT);
        this.c.onComplete();
        return;
      }
      this.y = (l + 1L);
    }
    
    public void onSubscribe(c paramc)
    {
      if (DisposableHelper.validate(this.x, paramc))
      {
        this.x = paramc;
        this.c.onSubscribe(this);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\observable\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */