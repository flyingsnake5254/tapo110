package io.reactivex.internal.operators.observable;

import io.reactivex.q;
import io.reactivex.v;

public final class w<T>
  extends q<T>
{
  final T[] c;
  
  public w(T[] paramArrayOfT)
  {
    this.c = paramArrayOfT;
  }
  
  public void K0(v<? super T> paramv)
  {
    a locala = new a(paramv, this.c);
    paramv.onSubscribe(locala);
    if (locala.q) {
      return;
    }
    locala.a();
  }
  
  static final class a<T>
    extends io.reactivex.internal.observers.b<T>
  {
    final v<? super T> c;
    final T[] d;
    int f;
    boolean q;
    volatile boolean x;
    
    a(v<? super T> paramv, T[] paramArrayOfT)
    {
      this.c = paramv;
      this.d = paramArrayOfT;
    }
    
    void a()
    {
      Object localObject = this.d;
      int i = localObject.length;
      for (int j = 0; (j < i) && (!isDisposed()); j++)
      {
        v localv = localObject[j];
        if (localv == null)
        {
          localv = this.c;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("The element at index ");
          ((StringBuilder)localObject).append(j);
          ((StringBuilder)localObject).append(" is null");
          localv.onError(new NullPointerException(((StringBuilder)localObject).toString()));
          return;
        }
        this.c.onNext(localv);
      }
      if (!isDisposed()) {
        this.c.onComplete();
      }
    }
    
    public void clear()
    {
      this.f = this.d.length;
    }
    
    public void dispose()
    {
      this.x = true;
    }
    
    public boolean isDisposed()
    {
      return this.x;
    }
    
    public boolean isEmpty()
    {
      boolean bool;
      if (this.f == this.d.length) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public T poll()
    {
      int i = this.f;
      Object[] arrayOfObject = this.d;
      if (i != arrayOfObject.length)
      {
        this.f = (i + 1);
        return (T)io.reactivex.h0.a.b.e(arrayOfObject[i], "The array element is null");
      }
      return null;
    }
    
    public int requestFusion(int paramInt)
    {
      if ((paramInt & 0x1) != 0)
      {
        this.q = true;
        return 1;
      }
      return 0;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\observable\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */