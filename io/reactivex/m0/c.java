package io.reactivex.m0;

import io.reactivex.h0.a.b;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class c
  extends io.reactivex.a
  implements io.reactivex.c
{
  static final a[] c = new a[0];
  static final a[] d = new a[0];
  final AtomicReference<a[]> f = new AtomicReference(c);
  final AtomicBoolean q = new AtomicBoolean();
  Throwable x;
  
  public static c M()
  {
    return new c();
  }
  
  protected void B(io.reactivex.c paramc)
  {
    Object localObject = new a(paramc, this);
    paramc.onSubscribe((io.reactivex.e0.c)localObject);
    if (L((a)localObject))
    {
      if (((a)localObject).isDisposed()) {
        N((a)localObject);
      }
    }
    else
    {
      localObject = this.x;
      if (localObject != null) {
        paramc.onError((Throwable)localObject);
      } else {
        paramc.onComplete();
      }
    }
  }
  
  boolean L(a parama)
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
  
  void N(a parama)
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
    Object localObject = this.q;
    int i = 0;
    if (((AtomicBoolean)localObject).compareAndSet(false, true))
    {
      localObject = (a[])this.f.getAndSet(d);
      int j = localObject.length;
      while (i < j)
      {
        localObject[i].c.onComplete();
        i++;
      }
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    b.e(paramThrowable, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
    Object localObject = this.q;
    int i = 0;
    if (((AtomicBoolean)localObject).compareAndSet(false, true))
    {
      this.x = paramThrowable;
      localObject = (a[])this.f.getAndSet(d);
      int j = localObject.length;
      while (i < j)
      {
        localObject[i].c.onError(paramThrowable);
        i++;
      }
    }
    io.reactivex.j0.a.r(paramThrowable);
  }
  
  public void onSubscribe(io.reactivex.e0.c paramc)
  {
    if (this.f.get() == d) {
      paramc.dispose();
    }
  }
  
  static final class a
    extends AtomicReference<c>
    implements io.reactivex.e0.c
  {
    final io.reactivex.c c;
    
    a(io.reactivex.c paramc, c paramc1)
    {
      this.c = paramc;
      lazySet(paramc1);
    }
    
    public void dispose()
    {
      c localc = (c)getAndSet(null);
      if (localc != null) {
        localc.N(this);
      }
    }
    
    public boolean isDisposed()
    {
      boolean bool;
      if (get() == null) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\m0\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */