package io.reactivex.m0;

import io.reactivex.e0.c;
import io.reactivex.h0.a.b;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import io.reactivex.v;
import java.util.concurrent.atomic.AtomicReference;

public final class a<T>
  extends g<T>
{
  static final a[] c = new a[0];
  static final a[] d = new a[0];
  final AtomicReference<a<T>[]> f = new AtomicReference(c);
  Throwable q;
  T x;
  
  public static <T> a<T> n1()
  {
    return new a();
  }
  
  protected void K0(v<? super T> paramv)
  {
    a locala = new a(paramv, this);
    paramv.onSubscribe(locala);
    if (m1(locala))
    {
      if (locala.isDisposed()) {
        o1(locala);
      }
    }
    else
    {
      Throwable localThrowable = this.q;
      if (localThrowable != null)
      {
        paramv.onError(localThrowable);
      }
      else
      {
        paramv = this.x;
        if (paramv != null) {
          locala.complete(paramv);
        } else {
          locala.onComplete();
        }
      }
    }
  }
  
  public boolean j1()
  {
    boolean bool;
    if ((this.f.get() == d) && (this.q == null)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean k1()
  {
    boolean bool;
    if ((this.f.get() == d) && (this.q != null)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  boolean m1(a<T> parama)
  {
    a[] arrayOfa1;
    a[] arrayOfa2;
    do
    {
      arrayOfa1 = (a[])this.f.get();
      if (arrayOfa1 == d) {
        return false;
      }
      int i = arrayOfa1.length;
      arrayOfa2 = new a[i + 1];
      System.arraycopy(arrayOfa1, 0, arrayOfa2, 0, i);
      arrayOfa2[i] = parama;
    } while (!this.f.compareAndSet(arrayOfa1, arrayOfa2));
    return true;
  }
  
  void o1(a<T> parama)
  {
    a[] arrayOfa1;
    a[] arrayOfa2;
    do
    {
      arrayOfa1 = (a[])this.f.get();
      int i = arrayOfa1.length;
      if (i == 0) {
        return;
      }
      int j = -1;
      int m;
      for (int k = 0;; k++)
      {
        m = j;
        if (k >= i) {
          break;
        }
        if (arrayOfa1[k] == parama)
        {
          m = k;
          break;
        }
      }
      if (m < 0) {
        return;
      }
      if (i == 1)
      {
        arrayOfa2 = c;
      }
      else
      {
        arrayOfa2 = new a[i - 1];
        System.arraycopy(arrayOfa1, 0, arrayOfa2, 0, m);
        System.arraycopy(arrayOfa1, m + 1, arrayOfa2, m, i - m - 1);
      }
    } while (!this.f.compareAndSet(arrayOfa1, arrayOfa2));
  }
  
  public void onComplete()
  {
    Object localObject = this.f.get();
    a[] arrayOfa = d;
    if (localObject == arrayOfa) {
      return;
    }
    localObject = this.x;
    arrayOfa = (a[])this.f.getAndSet(arrayOfa);
    int i = 0;
    int j = 0;
    if (localObject == null)
    {
      i = arrayOfa.length;
      while (j < i)
      {
        arrayOfa[j].onComplete();
        j++;
      }
    }
    int k = arrayOfa.length;
    for (j = i; j < k; j++) {
      arrayOfa[j].complete(localObject);
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    b.e(paramThrowable, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
    Object localObject = this.f.get();
    a[] arrayOfa = d;
    if (localObject == arrayOfa)
    {
      io.reactivex.j0.a.r(paramThrowable);
      return;
    }
    this.x = null;
    this.q = paramThrowable;
    localObject = (a[])this.f.getAndSet(arrayOfa);
    int i = localObject.length;
    for (int j = 0; j < i; j++) {
      localObject[j].onError(paramThrowable);
    }
  }
  
  public void onNext(T paramT)
  {
    b.e(paramT, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
    if (this.f.get() == d) {
      return;
    }
    this.x = paramT;
  }
  
  public void onSubscribe(c paramc)
  {
    if (this.f.get() == d) {
      paramc.dispose();
    }
  }
  
  static final class a<T>
    extends DeferredScalarDisposable<T>
  {
    final a<T> c;
    
    a(v<? super T> paramv, a<T> parama)
    {
      super();
      this.c = parama;
    }
    
    public void dispose()
    {
      if (super.tryDispose()) {
        this.c.o1(this);
      }
    }
    
    void onComplete()
    {
      if (!isDisposed()) {
        this.downstream.onComplete();
      }
    }
    
    void onError(Throwable paramThrowable)
    {
      if (isDisposed()) {
        io.reactivex.j0.a.r(paramThrowable);
      } else {
        this.downstream.onError(paramThrowable);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\m0\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */