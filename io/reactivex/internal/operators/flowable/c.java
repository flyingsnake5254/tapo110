package io.reactivex.internal.operators.flowable;

import io.reactivex.BackpressureStrategy;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.h;
import io.reactivex.i;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import io.reactivex.j0.a;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class c<T>
  extends h<T>
{
  final j<T> d;
  final BackpressureStrategy f;
  
  public c(j<T> paramj, BackpressureStrategy paramBackpressureStrategy)
  {
    this.d = paramj;
    this.f = paramBackpressureStrategy;
  }
  
  /* Error */
  public void H(e.b.b<? super T> paramb)
  {
    // Byte code:
    //   0: getstatic 49	io/reactivex/internal/operators/flowable/c$a:a	[I
    //   3: aload_0
    //   4: getfield 40	io/reactivex/internal/operators/flowable/c:f	Lio/reactivex/BackpressureStrategy;
    //   7: invokevirtual 55	java/lang/Enum:ordinal	()I
    //   10: iaload
    //   11: istore_2
    //   12: iload_2
    //   13: iconst_1
    //   14: if_icmpeq +69 -> 83
    //   17: iload_2
    //   18: iconst_2
    //   19: if_icmpeq +52 -> 71
    //   22: iload_2
    //   23: iconst_3
    //   24: if_icmpeq +35 -> 59
    //   27: iload_2
    //   28: iconst_4
    //   29: if_icmpeq +18 -> 47
    //   32: new 12	io/reactivex/internal/operators/flowable/c$c
    //   35: dup
    //   36: aload_1
    //   37: invokestatic 57	io/reactivex/h:c	()I
    //   40: invokespecial 60	io/reactivex/internal/operators/flowable/c$c:<init>	(Le/b/b;I)V
    //   43: astore_3
    //   44: goto +48 -> 92
    //   47: new 21	io/reactivex/internal/operators/flowable/c$f
    //   50: dup
    //   51: aload_1
    //   52: invokespecial 62	io/reactivex/internal/operators/flowable/c$f:<init>	(Le/b/b;)V
    //   55: astore_3
    //   56: goto +36 -> 92
    //   59: new 15	io/reactivex/internal/operators/flowable/c$d
    //   62: dup
    //   63: aload_1
    //   64: invokespecial 63	io/reactivex/internal/operators/flowable/c$d:<init>	(Le/b/b;)V
    //   67: astore_3
    //   68: goto +24 -> 92
    //   71: new 18	io/reactivex/internal/operators/flowable/c$e
    //   74: dup
    //   75: aload_1
    //   76: invokespecial 64	io/reactivex/internal/operators/flowable/c$e:<init>	(Le/b/b;)V
    //   79: astore_3
    //   80: goto +12 -> 92
    //   83: new 24	io/reactivex/internal/operators/flowable/c$g
    //   86: dup
    //   87: aload_1
    //   88: invokespecial 65	io/reactivex/internal/operators/flowable/c$g:<init>	(Le/b/b;)V
    //   91: astore_3
    //   92: aload_1
    //   93: aload_3
    //   94: invokeinterface 71 2 0
    //   99: aload_0
    //   100: getfield 38	io/reactivex/internal/operators/flowable/c:d	Lio/reactivex/j;
    //   103: aload_3
    //   104: invokeinterface 77 2 0
    //   109: goto +13 -> 122
    //   112: astore_1
    //   113: aload_1
    //   114: invokestatic 82	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
    //   117: aload_3
    //   118: aload_1
    //   119: invokevirtual 85	io/reactivex/internal/operators/flowable/c$b:onError	(Ljava/lang/Throwable;)V
    //   122: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	this	c
    //   0	123	1	paramb	e.b.b<? super T>
    //   11	19	2	i	int
    //   43	75	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   99	109	112	finally
  }
  
  static abstract class b<T>
    extends AtomicLong
    implements i<T>, e.b.c
  {
    final e.b.b<? super T> c;
    final SequentialDisposable d;
    
    b(e.b.b<? super T> paramb)
    {
      this.c = paramb;
      this.d = new SequentialDisposable();
    }
    
    public final void a(io.reactivex.e0.c paramc)
    {
      this.d.update(paramc);
    }
    
    protected void b()
    {
      if (isCancelled()) {
        return;
      }
      try
      {
        this.c.onComplete();
        return;
      }
      finally
      {
        this.d.dispose();
      }
    }
    
    public final void cancel()
    {
      this.d.dispose();
      g();
    }
    
    protected boolean d(Throwable paramThrowable)
    {
      Object localObject = paramThrowable;
      if (paramThrowable == null) {
        localObject = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
      }
      if (isCancelled()) {
        return false;
      }
      try
      {
        this.c.onError((Throwable)localObject);
        return true;
      }
      finally
      {
        this.d.dispose();
      }
    }
    
    void f() {}
    
    void g() {}
    
    public boolean h(Throwable paramThrowable)
    {
      return d(paramThrowable);
    }
    
    public final boolean isCancelled()
    {
      return this.d.isDisposed();
    }
    
    public void onComplete()
    {
      b();
    }
    
    public final void onError(Throwable paramThrowable)
    {
      if (!h(paramThrowable)) {
        a.r(paramThrowable);
      }
    }
    
    public final void request(long paramLong)
    {
      if (SubscriptionHelper.validate(paramLong))
      {
        io.reactivex.internal.util.b.a(this, paramLong);
        f();
      }
    }
    
    public String toString()
    {
      return String.format("%s{%s}", new Object[] { getClass().getSimpleName(), super.toString() });
    }
  }
  
  static final class c<T>
    extends c.b<T>
  {
    final io.reactivex.internal.queue.b<T> f;
    Throwable q;
    volatile boolean x;
    final AtomicInteger y;
    
    c(e.b.b<? super T> paramb, int paramInt)
    {
      super();
      this.f = new io.reactivex.internal.queue.b(paramInt);
      this.y = new AtomicInteger();
    }
    
    void f()
    {
      i();
    }
    
    void g()
    {
      if (this.y.getAndIncrement() == 0) {
        this.f.clear();
      }
    }
    
    public boolean h(Throwable paramThrowable)
    {
      if ((!this.x) && (!isCancelled()))
      {
        Object localObject = paramThrowable;
        if (paramThrowable == null) {
          localObject = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        this.q = ((Throwable)localObject);
        this.x = true;
        i();
        return true;
      }
      return false;
    }
    
    void i()
    {
      if (this.y.getAndIncrement() != 0) {
        return;
      }
      e.b.b localb = this.c;
      Object localObject1 = this.f;
      int i = 1;
      int j;
      do
      {
        long l1 = get();
        boolean bool1;
        boolean bool2;
        for (long l2 = 0L;; l2 += 1L)
        {
          bool1 = l2 < l1;
          if (!bool1) {
            break;
          }
          if (isCancelled())
          {
            ((io.reactivex.internal.queue.b)localObject1).clear();
            return;
          }
          bool2 = this.x;
          Object localObject2 = ((io.reactivex.internal.queue.b)localObject1).poll();
          if (localObject2 == null) {
            j = 1;
          } else {
            j = 0;
          }
          if ((bool2) && (j != 0))
          {
            localObject1 = this.q;
            if (localObject1 != null) {
              d((Throwable)localObject1);
            } else {
              b();
            }
            return;
          }
          if (j != 0) {
            break;
          }
          localb.onNext(localObject2);
        }
        if (!bool1)
        {
          if (isCancelled())
          {
            ((io.reactivex.internal.queue.b)localObject1).clear();
            return;
          }
          bool2 = this.x;
          boolean bool3 = ((io.reactivex.internal.queue.b)localObject1).isEmpty();
          if ((bool2) && (bool3))
          {
            localObject1 = this.q;
            if (localObject1 != null) {
              d((Throwable)localObject1);
            } else {
              b();
            }
            return;
          }
        }
        if (l2 != 0L) {
          io.reactivex.internal.util.b.c(this, l2);
        }
        j = this.y.addAndGet(-i);
        i = j;
      } while (j != 0);
    }
    
    public void onComplete()
    {
      this.x = true;
      i();
    }
    
    public void onNext(T paramT)
    {
      if ((!this.x) && (!isCancelled()))
      {
        if (paramT == null)
        {
          onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
          return;
        }
        this.f.offer(paramT);
        i();
      }
    }
  }
  
  static final class d<T>
    extends c.h<T>
  {
    d(e.b.b<? super T> paramb)
    {
      super();
    }
    
    void i() {}
  }
  
  static final class e<T>
    extends c.h<T>
  {
    e(e.b.b<? super T> paramb)
    {
      super();
    }
    
    void i()
    {
      onError(new MissingBackpressureException("create: could not emit value due to lack of requests"));
    }
  }
  
  static final class f<T>
    extends c.b<T>
  {
    final AtomicReference<T> f = new AtomicReference();
    Throwable q;
    volatile boolean x;
    final AtomicInteger y = new AtomicInteger();
    
    f(e.b.b<? super T> paramb)
    {
      super();
    }
    
    void f()
    {
      i();
    }
    
    void g()
    {
      if (this.y.getAndIncrement() == 0) {
        this.f.lazySet(null);
      }
    }
    
    public boolean h(Throwable paramThrowable)
    {
      if ((!this.x) && (!isCancelled()))
      {
        if (paramThrowable == null) {
          onError(new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources."));
        }
        this.q = paramThrowable;
        this.x = true;
        i();
        return true;
      }
      return false;
    }
    
    void i()
    {
      if (this.y.getAndIncrement() != 0) {
        return;
      }
      e.b.b localb = this.c;
      AtomicReference localAtomicReference = this.f;
      int i = 1;
      int k;
      do
      {
        long l1 = get();
        int j;
        boolean bool1;
        boolean bool2;
        Object localObject;
        for (long l2 = 0L;; l2 += 1L)
        {
          j = 0;
          bool1 = l2 < l1;
          if (!bool1) {
            break;
          }
          if (isCancelled())
          {
            localAtomicReference.lazySet(null);
            return;
          }
          bool2 = this.x;
          localObject = localAtomicReference.getAndSet(null);
          if (localObject == null) {
            k = 1;
          } else {
            k = 0;
          }
          if ((bool2) && (k != 0))
          {
            localObject = this.q;
            if (localObject != null) {
              d((Throwable)localObject);
            } else {
              b();
            }
            return;
          }
          if (k != 0) {
            break;
          }
          localb.onNext(localObject);
        }
        if (!bool1)
        {
          if (isCancelled())
          {
            localAtomicReference.lazySet(null);
            return;
          }
          bool2 = this.x;
          k = j;
          if (localAtomicReference.get() == null) {
            k = 1;
          }
          if ((bool2) && (k != 0))
          {
            localObject = this.q;
            if (localObject != null) {
              d((Throwable)localObject);
            } else {
              b();
            }
            return;
          }
        }
        if (l2 != 0L) {
          io.reactivex.internal.util.b.c(this, l2);
        }
        k = this.y.addAndGet(-i);
        i = k;
      } while (k != 0);
    }
    
    public void onComplete()
    {
      this.x = true;
      i();
    }
    
    public void onNext(T paramT)
    {
      if ((!this.x) && (!isCancelled()))
      {
        if (paramT == null)
        {
          onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
          return;
        }
        this.f.set(paramT);
        i();
      }
    }
  }
  
  static final class g<T>
    extends c.b<T>
  {
    g(e.b.b<? super T> paramb)
    {
      super();
    }
    
    public void onNext(T paramT)
    {
      if (isCancelled()) {
        return;
      }
      if (paramT != null)
      {
        this.c.onNext(paramT);
        long l;
        do
        {
          l = get();
        } while ((l != 0L) && (!compareAndSet(l, l - 1L)));
        return;
      }
      onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
    }
  }
  
  static abstract class h<T>
    extends c.b<T>
  {
    h(e.b.b<? super T> paramb)
    {
      super();
    }
    
    abstract void i();
    
    public final void onNext(T paramT)
    {
      if (isCancelled()) {
        return;
      }
      if (paramT == null)
      {
        onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
        return;
      }
      if (get() != 0L)
      {
        this.c.onNext(paramT);
        io.reactivex.internal.util.b.c(this, 1L);
      }
      else
      {
        i();
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\flowable\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */