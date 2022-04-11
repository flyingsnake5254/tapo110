package io.reactivex.internal.operators.observable;

import io.reactivex.g0.d;
import io.reactivex.g0.j;
import io.reactivex.t;
import io.reactivex.v;

public final class i<T, K>
  extends a<T, T>
{
  final j<? super T, K> d;
  final d<? super K, ? super K> f;
  
  public i(t<T> paramt, j<? super T, K> paramj, d<? super K, ? super K> paramd)
  {
    super(paramt);
    this.d = paramj;
    this.f = paramd;
  }
  
  protected void K0(v<? super T> paramv)
  {
    this.c.a(new a(paramv, this.d, this.f));
  }
  
  static final class a<T, K>
    extends io.reactivex.internal.observers.a<T, T>
  {
    K p0;
    boolean p1;
    final j<? super T, K> y;
    final d<? super K, ? super K> z;
    
    a(v<? super T> paramv, j<? super T, K> paramj, d<? super K, ? super K> paramd)
    {
      super();
      this.y = paramj;
      this.z = paramd;
    }
    
    public void onNext(T paramT)
    {
      if (this.q) {
        return;
      }
      if (this.x != 0)
      {
        this.c.onNext(paramT);
        return;
      }
      try
      {
        Object localObject = this.y.apply(paramT);
        if (this.p1)
        {
          boolean bool = this.z.a(this.p0, localObject);
          this.p0 = localObject;
          if (!bool) {}
        }
        else
        {
          this.p1 = true;
          this.p0 = localObject;
        }
        this.c.onNext(paramT);
        return;
      }
      finally
      {
        c(paramT);
      }
    }
    
    public T poll()
      throws Exception
    {
      for (;;)
      {
        Object localObject1 = this.f.poll();
        if (localObject1 == null) {
          return null;
        }
        Object localObject2 = this.y.apply(localObject1);
        if (!this.p1)
        {
          this.p1 = true;
          this.p0 = localObject2;
          return (T)localObject1;
        }
        if (!this.z.a(this.p0, localObject2))
        {
          this.p0 = localObject2;
          return (T)localObject1;
        }
        this.p0 = localObject2;
      }
    }
    
    public int requestFusion(int paramInt)
    {
      return d(paramInt);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\observable\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */