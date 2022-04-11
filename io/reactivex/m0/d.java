package io.reactivex.m0;

import io.reactivex.e0.c;
import io.reactivex.h0.a.b;
import io.reactivex.j0.a;
import io.reactivex.v;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class d<T>
  extends g<T>
{
  static final a[] c = new a[0];
  static final a[] d = new a[0];
  final AtomicReference<a<T>[]> f = new AtomicReference(d);
  Throwable q;
  
  public static <T> d<T> n1()
  {
    return new d();
  }
  
  protected void K0(v<? super T> paramv)
  {
    Object localObject = new a(paramv, this);
    paramv.onSubscribe((c)localObject);
    if (m1((a)localObject))
    {
      if (((a)localObject).isDisposed()) {
        o1((a)localObject);
      }
    }
    else
    {
      localObject = this.q;
      if (localObject != null) {
        paramv.onError((Throwable)localObject);
      } else {
        paramv.onComplete();
      }
    }
  }
  
  public boolean j1()
  {
    boolean bool;
    if ((this.f.get() == c) && (this.q == null)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean k1()
  {
    boolean bool;
    if ((this.f.get() == c) && (this.q != null)) {
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
      if (arrayOfa1 == c) {
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
      if ((arrayOfa1 == c) || (arrayOfa1 == d)) {
        break;
      }
      int i = arrayOfa1.length;
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
        arrayOfa2 = d;
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
    a[] arrayOfa = c;
    if (localObject == arrayOfa) {
      return;
    }
    arrayOfa = (a[])this.f.getAndSet(arrayOfa);
    int i = arrayOfa.length;
    for (int j = 0; j < i; j++) {
      arrayOfa[j].a();
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    b.e(paramThrowable, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
    Object localObject = this.f.get();
    a[] arrayOfa = c;
    if (localObject == arrayOfa)
    {
      a.r(paramThrowable);
      return;
    }
    this.q = paramThrowable;
    localObject = (a[])this.f.getAndSet(arrayOfa);
    int i = localObject.length;
    for (int j = 0; j < i; j++) {
      localObject[j].b(paramThrowable);
    }
  }
  
  public void onNext(T paramT)
  {
    b.e(paramT, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
    a[] arrayOfa = (a[])this.f.get();
    int i = arrayOfa.length;
    for (int j = 0; j < i; j++) {
      arrayOfa[j].d(paramT);
    }
  }
  
  public void onSubscribe(c paramc)
  {
    if (this.f.get() == c) {
      paramc.dispose();
    }
  }
  
  static final class a<T>
    extends AtomicBoolean
    implements c
  {
    final v<? super T> c;
    final d<T> d;
    
    a(v<? super T> paramv, d<T> paramd)
    {
      this.c = paramv;
      this.d = paramd;
    }
    
    public void a()
    {
      if (!get()) {
        this.c.onComplete();
      }
    }
    
    public void b(Throwable paramThrowable)
    {
      if (get()) {
        a.r(paramThrowable);
      } else {
        this.c.onError(paramThrowable);
      }
    }
    
    public void d(T paramT)
    {
      if (!get()) {
        this.c.onNext(paramT);
      }
    }
    
    public void dispose()
    {
      if (compareAndSet(false, true)) {
        this.d.o1(this);
      }
    }
    
    public boolean isDisposed()
    {
      return get();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\m0\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */