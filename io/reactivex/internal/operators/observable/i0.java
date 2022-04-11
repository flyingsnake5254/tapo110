package io.reactivex.internal.operators.observable;

import io.reactivex.g0.j;
import io.reactivex.h0.a.b;
import io.reactivex.h0.b.i;
import io.reactivex.t;
import io.reactivex.v;

public final class i0<T, U>
  extends a<T, U>
{
  final j<? super T, ? extends U> d;
  
  public i0(t<T> paramt, j<? super T, ? extends U> paramj)
  {
    super(paramt);
    this.d = paramj;
  }
  
  public void K0(v<? super U> paramv)
  {
    this.c.a(new a(paramv, this.d));
  }
  
  static final class a<T, U>
    extends io.reactivex.internal.observers.a<T, U>
  {
    final j<? super T, ? extends U> y;
    
    a(v<? super U> paramv, j<? super T, ? extends U> paramj)
    {
      super();
      this.y = paramj;
    }
    
    public void onNext(T paramT)
    {
      if (this.q) {
        return;
      }
      if (this.x != 0)
      {
        this.c.onNext(null);
        return;
      }
      try
      {
        paramT = b.e(this.y.apply(paramT), "The mapper function returned a null value.");
        this.c.onNext(paramT);
        return;
      }
      finally
      {
        c(paramT);
      }
    }
    
    public U poll()
      throws Exception
    {
      Object localObject = this.f.poll();
      if (localObject != null) {
        localObject = b.e(this.y.apply(localObject), "The mapper function returned a null value.");
      } else {
        localObject = null;
      }
      return (U)localObject;
    }
    
    public int requestFusion(int paramInt)
    {
      return d(paramInt);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\observable\i0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */