package io.reactivex.m0;

import io.reactivex.e0.c;
import io.reactivex.h0.a.b;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.j0.a;
import io.reactivex.v;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class e<T>
  extends g<T>
{
  static final b[] c = new b[0];
  static final b[] d = new b[0];
  private static final Object[] f = new Object[0];
  final a<T> q;
  final AtomicReference<b<T>[]> x;
  boolean y;
  
  e(a<T> parama)
  {
    this.q = parama;
    this.x = new AtomicReference(c);
  }
  
  public static <T> e<T> n1()
  {
    return new e(new c(16));
  }
  
  protected void K0(v<? super T> paramv)
  {
    b localb = new b(paramv, this);
    paramv.onSubscribe(localb);
    if (!localb.q)
    {
      if ((m1(localb)) && (localb.q))
      {
        o1(localb);
        return;
      }
      this.q.b(localb);
    }
  }
  
  public boolean j1()
  {
    return NotificationLite.isComplete(this.q.get());
  }
  
  public boolean k1()
  {
    return NotificationLite.isError(this.q.get());
  }
  
  boolean m1(b<T> paramb)
  {
    b[] arrayOfb1;
    b[] arrayOfb2;
    do
    {
      arrayOfb1 = (b[])this.x.get();
      if (arrayOfb1 == d) {
        return false;
      }
      int i = arrayOfb1.length;
      arrayOfb2 = new b[i + 1];
      System.arraycopy(arrayOfb1, 0, arrayOfb2, 0, i);
      arrayOfb2[i] = paramb;
    } while (!this.x.compareAndSet(arrayOfb1, arrayOfb2));
    return true;
  }
  
  void o1(b<T> paramb)
  {
    b[] arrayOfb1;
    b[] arrayOfb2;
    do
    {
      arrayOfb1 = (b[])this.x.get();
      if ((arrayOfb1 == d) || (arrayOfb1 == c)) {
        break;
      }
      int i = arrayOfb1.length;
      int j = -1;
      int m;
      for (int k = 0;; k++)
      {
        m = j;
        if (k >= i) {
          break;
        }
        if (arrayOfb1[k] == paramb)
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
        arrayOfb2 = c;
      }
      else
      {
        arrayOfb2 = new b[i - 1];
        System.arraycopy(arrayOfb1, 0, arrayOfb2, 0, m);
        System.arraycopy(arrayOfb1, m + 1, arrayOfb2, m, i - m - 1);
      }
    } while (!this.x.compareAndSet(arrayOfb1, arrayOfb2));
  }
  
  public void onComplete()
  {
    if (this.y) {
      return;
    }
    this.y = true;
    Object localObject = NotificationLite.complete();
    a locala = this.q;
    locala.a(localObject);
    localObject = p1(localObject);
    int i = localObject.length;
    for (int j = 0; j < i; j++) {
      locala.b(localObject[j]);
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    b.e(paramThrowable, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
    if (this.y)
    {
      a.r(paramThrowable);
      return;
    }
    this.y = true;
    Object localObject = NotificationLite.error(paramThrowable);
    paramThrowable = this.q;
    paramThrowable.a(localObject);
    localObject = p1(localObject);
    int i = localObject.length;
    for (int j = 0; j < i; j++) {
      paramThrowable.b(localObject[j]);
    }
  }
  
  public void onNext(T paramT)
  {
    b.e(paramT, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
    if (this.y) {
      return;
    }
    a locala = this.q;
    locala.add(paramT);
    paramT = (b[])this.x.get();
    int i = paramT.length;
    for (int j = 0; j < i; j++) {
      locala.b(paramT[j]);
    }
  }
  
  public void onSubscribe(c paramc)
  {
    if (this.y) {
      paramc.dispose();
    }
  }
  
  b<T>[] p1(Object paramObject)
  {
    if (this.q.compareAndSet(null, paramObject)) {
      return (b[])this.x.getAndSet(d);
    }
    return d;
  }
  
  static abstract interface a<T>
  {
    public abstract void a(Object paramObject);
    
    public abstract void add(T paramT);
    
    public abstract void b(e.b<T> paramb);
    
    public abstract boolean compareAndSet(Object paramObject1, Object paramObject2);
    
    public abstract Object get();
  }
  
  static final class b<T>
    extends AtomicInteger
    implements c
  {
    final v<? super T> c;
    final e<T> d;
    Object f;
    volatile boolean q;
    
    b(v<? super T> paramv, e<T> parame)
    {
      this.c = paramv;
      this.d = parame;
    }
    
    public void dispose()
    {
      if (!this.q)
      {
        this.q = true;
        this.d.o1(this);
      }
    }
    
    public boolean isDisposed()
    {
      return this.q;
    }
  }
  
  static final class c<T>
    extends AtomicReference<Object>
    implements e.a<T>
  {
    final List<Object> c;
    volatile boolean d;
    volatile int f;
    
    c(int paramInt)
    {
      this.c = new ArrayList(b.f(paramInt, "capacityHint"));
    }
    
    public void a(Object paramObject)
    {
      this.c.add(paramObject);
      d();
      this.f += 1;
      this.d = true;
    }
    
    public void add(T paramT)
    {
      this.c.add(paramT);
      this.f += 1;
    }
    
    public void b(e.b<T> paramb)
    {
      if (paramb.getAndIncrement() != 0) {
        return;
      }
      List localList = this.c;
      v localv = paramb.c;
      Object localObject = (Integer)paramb.f;
      int i = 0;
      if (localObject != null) {
        i = ((Integer)localObject).intValue();
      } else {
        paramb.f = Integer.valueOf(0);
      }
      int j = 1;
      int k = i;
      i = j;
      do
      {
        do
        {
          if (paramb.q)
          {
            paramb.f = null;
            return;
          }
          for (int m = this.f; m != k; m = j)
          {
            if (paramb.q)
            {
              paramb.f = null;
              return;
            }
            localObject = localList.get(k);
            j = m;
            if (this.d)
            {
              int n = k + 1;
              j = m;
              if (n == m)
              {
                m = this.f;
                j = m;
                if (n == m)
                {
                  if (NotificationLite.isComplete(localObject)) {
                    localv.onComplete();
                  } else {
                    localv.onError(NotificationLite.getError(localObject));
                  }
                  paramb.f = null;
                  paramb.q = true;
                  return;
                }
              }
            }
            localv.onNext(localObject);
            k++;
          }
        } while (k != this.f);
        paramb.f = Integer.valueOf(k);
        j = paramb.addAndGet(-i);
        i = j;
      } while (j != 0);
    }
    
    public void d() {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\m0\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */