package io.reactivex.m0;

import io.reactivex.e0.c;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.internal.util.a.a;
import io.reactivex.internal.util.e;
import io.reactivex.v;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class b<T>
  extends g<T>
{
  private static final Object[] c = new Object[0];
  static final a[] d = new a[0];
  static final a[] f = new a[0];
  final Lock p0;
  final AtomicReference<Throwable> p1;
  long p2;
  final AtomicReference<Object> q;
  final AtomicReference<a<T>[]> x;
  final ReadWriteLock y;
  final Lock z;
  
  b()
  {
    ReentrantReadWriteLock localReentrantReadWriteLock = new ReentrantReadWriteLock();
    this.y = localReentrantReadWriteLock;
    this.z = localReentrantReadWriteLock.readLock();
    this.p0 = localReentrantReadWriteLock.writeLock();
    this.x = new AtomicReference(d);
    this.q = new AtomicReference();
    this.p1 = new AtomicReference();
  }
  
  public static <T> b<T> n1()
  {
    return new b();
  }
  
  protected void K0(v<? super T> paramv)
  {
    Object localObject = new a(paramv, this);
    paramv.onSubscribe((c)localObject);
    if (m1((a)localObject))
    {
      if (((a)localObject).z) {
        o1((a)localObject);
      } else {
        ((a)localObject).a();
      }
    }
    else
    {
      localObject = (Throwable)this.p1.get();
      if (localObject == e.a) {
        paramv.onComplete();
      } else {
        paramv.onError((Throwable)localObject);
      }
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
  
  boolean m1(a<T> parama)
  {
    a[] arrayOfa1;
    a[] arrayOfa2;
    do
    {
      arrayOfa1 = (a[])this.x.get();
      if (arrayOfa1 == f) {
        return false;
      }
      int i = arrayOfa1.length;
      arrayOfa2 = new a[i + 1];
      System.arraycopy(arrayOfa1, 0, arrayOfa2, 0, i);
      arrayOfa2[i] = parama;
    } while (!this.x.compareAndSet(arrayOfa1, arrayOfa2));
    return true;
  }
  
  void o1(a<T> parama)
  {
    a[] arrayOfa1;
    a[] arrayOfa2;
    do
    {
      arrayOfa1 = (a[])this.x.get();
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
        arrayOfa2 = d;
      }
      else
      {
        arrayOfa2 = new a[i - 1];
        System.arraycopy(arrayOfa1, 0, arrayOfa2, 0, m);
        System.arraycopy(arrayOfa1, m + 1, arrayOfa2, m, i - m - 1);
      }
    } while (!this.x.compareAndSet(arrayOfa1, arrayOfa2));
  }
  
  public void onComplete()
  {
    if (!this.p1.compareAndSet(null, e.a)) {
      return;
    }
    Object localObject = NotificationLite.complete();
    a[] arrayOfa = q1(localObject);
    int i = arrayOfa.length;
    for (int j = 0; j < i; j++) {
      arrayOfa[j].c(localObject, this.p2);
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    io.reactivex.h0.a.b.e(paramThrowable, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
    if (!this.p1.compareAndSet(null, paramThrowable))
    {
      io.reactivex.j0.a.r(paramThrowable);
      return;
    }
    paramThrowable = NotificationLite.error(paramThrowable);
    a[] arrayOfa = q1(paramThrowable);
    int i = arrayOfa.length;
    for (int j = 0; j < i; j++) {
      arrayOfa[j].c(paramThrowable, this.p2);
    }
  }
  
  public void onNext(T paramT)
  {
    io.reactivex.h0.a.b.e(paramT, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
    if (this.p1.get() != null) {
      return;
    }
    Object localObject = NotificationLite.next(paramT);
    p1(localObject);
    paramT = (a[])this.x.get();
    int i = paramT.length;
    for (int j = 0; j < i; j++) {
      paramT[j].c(localObject, this.p2);
    }
  }
  
  public void onSubscribe(c paramc)
  {
    if (this.p1.get() != null) {
      paramc.dispose();
    }
  }
  
  void p1(Object paramObject)
  {
    this.p0.lock();
    this.p2 += 1L;
    this.q.lazySet(paramObject);
    this.p0.unlock();
  }
  
  a<T>[] q1(Object paramObject)
  {
    Object localObject = this.x;
    a[] arrayOfa = f;
    localObject = (a[])((AtomicReference)localObject).getAndSet(arrayOfa);
    if (localObject != arrayOfa) {
      p1(paramObject);
    }
    return (a<T>[])localObject;
  }
  
  static final class a<T>
    implements c, a.a<Object>
  {
    final v<? super T> c;
    final b<T> d;
    boolean f;
    long p0;
    boolean q;
    io.reactivex.internal.util.a<Object> x;
    boolean y;
    volatile boolean z;
    
    a(v<? super T> paramv, b<T> paramb)
    {
      this.c = paramv;
      this.d = paramb;
    }
    
    void a()
    {
      if (this.z) {
        return;
      }
      try
      {
        if (this.z) {
          return;
        }
        if (this.f) {
          return;
        }
        Object localObject1 = this.d;
        Lock localLock = ((b)localObject1).z;
        localLock.lock();
        this.p0 = ((b)localObject1).p2;
        localObject1 = ((b)localObject1).q.get();
        localLock.unlock();
        boolean bool;
        if (localObject1 != null) {
          bool = true;
        } else {
          bool = false;
        }
        this.q = bool;
        this.f = true;
        if (localObject1 != null)
        {
          if (test(localObject1)) {
            return;
          }
          b();
        }
        return;
      }
      finally {}
    }
    
    void b()
    {
      for (;;)
      {
        if (this.z) {
          return;
        }
        try
        {
          io.reactivex.internal.util.a locala = this.x;
          if (locala == null)
          {
            this.q = false;
            return;
          }
          this.x = null;
          locala.d(this);
        }
        finally {}
      }
    }
    
    void c(Object paramObject, long paramLong)
    {
      if (this.z) {
        return;
      }
      if (!this.y) {
        try
        {
          if (this.z) {
            return;
          }
          if (this.p0 == paramLong) {
            return;
          }
          if (this.q)
          {
            io.reactivex.internal.util.a locala1 = this.x;
            io.reactivex.internal.util.a locala2 = locala1;
            if (locala1 == null)
            {
              locala2 = new io/reactivex/internal/util/a;
              locala2.<init>(4);
              this.x = locala2;
            }
            locala2.c(paramObject);
            return;
          }
          this.f = true;
          this.y = true;
        }
        finally {}
      }
      test(paramObject);
    }
    
    public void dispose()
    {
      if (!this.z)
      {
        this.z = true;
        this.d.o1(this);
      }
    }
    
    public boolean isDisposed()
    {
      return this.z;
    }
    
    public boolean test(Object paramObject)
    {
      boolean bool;
      if ((!this.z) && (!NotificationLite.accept(paramObject, this.c))) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\m0\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */