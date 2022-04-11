package io.reactivex;

import io.reactivex.internal.operators.flowable.a0;
import io.reactivex.internal.operators.flowable.b0;
import io.reactivex.internal.operators.flowable.c0;
import io.reactivex.internal.operators.flowable.d;
import io.reactivex.internal.operators.flowable.e;
import io.reactivex.internal.operators.flowable.f;
import io.reactivex.internal.operators.flowable.i;
import io.reactivex.internal.operators.flowable.m;
import io.reactivex.internal.operators.flowable.p;
import io.reactivex.internal.operators.flowable.r;
import io.reactivex.internal.operators.flowable.s;
import io.reactivex.internal.operators.flowable.u;
import io.reactivex.internal.operators.flowable.v;
import io.reactivex.internal.operators.flowable.y;
import io.reactivex.internal.subscribers.StrictSubscriber;
import java.util.concurrent.Callable;

public abstract class h<T>
  implements e.b.a<T>
{
  static final int c = Math.max(1, Integer.getInteger("rx2.buffer-size", 128).intValue());
  
  public static int c()
  {
    return c;
  }
  
  public static <T> h<T> e(e.b.a<? extends T>... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      return m();
    }
    if (paramVarArgs.length == 1) {
      return u(paramVarArgs[0]);
    }
    return io.reactivex.j0.a.l(new io.reactivex.internal.operators.flowable.b(paramVarArgs, false));
  }
  
  public static <T> h<T> f(j<T> paramj, BackpressureStrategy paramBackpressureStrategy)
  {
    io.reactivex.h0.a.b.e(paramj, "source is null");
    io.reactivex.h0.a.b.e(paramBackpressureStrategy, "mode is null");
    return io.reactivex.j0.a.l(new io.reactivex.internal.operators.flowable.c(paramj, paramBackpressureStrategy));
  }
  
  private h<T> j(io.reactivex.g0.g<? super T> paramg, io.reactivex.g0.g<? super Throwable> paramg1, io.reactivex.g0.a parama1, io.reactivex.g0.a parama2)
  {
    io.reactivex.h0.a.b.e(paramg, "onNext is null");
    io.reactivex.h0.a.b.e(paramg1, "onError is null");
    io.reactivex.h0.a.b.e(parama1, "onComplete is null");
    io.reactivex.h0.a.b.e(parama2, "onAfterTerminate is null");
    return io.reactivex.j0.a.l(new e(this, paramg, paramg1, parama1, parama2));
  }
  
  public static <T> h<T> m()
  {
    return io.reactivex.j0.a.l(io.reactivex.internal.operators.flowable.g.d);
  }
  
  public static <T> h<T> n(Throwable paramThrowable)
  {
    io.reactivex.h0.a.b.e(paramThrowable, "throwable is null");
    return o(io.reactivex.h0.a.a.h(paramThrowable));
  }
  
  public static <T> h<T> o(Callable<? extends Throwable> paramCallable)
  {
    io.reactivex.h0.a.b.e(paramCallable, "supplier is null");
    return io.reactivex.j0.a.l(new io.reactivex.internal.operators.flowable.h(paramCallable));
  }
  
  public static <T> h<T> u(e.b.a<? extends T> parama)
  {
    if ((parama instanceof h)) {
      return io.reactivex.j0.a.l((h)parama);
    }
    io.reactivex.h0.a.b.e(parama, "source is null");
    return io.reactivex.j0.a.l(new m(parama));
  }
  
  public static <T> h<T> v(T paramT)
  {
    io.reactivex.h0.a.b.e(paramT, "item is null");
    return io.reactivex.j0.a.l(new p(paramT));
  }
  
  public final h<T> A()
  {
    return io.reactivex.j0.a.l(new s(this));
  }
  
  public final h<T> B()
  {
    return io.reactivex.j0.a.l(new u(this));
  }
  
  public final h<T> C(io.reactivex.g0.j<? super Throwable, ? extends e.b.a<? extends T>> paramj)
  {
    io.reactivex.h0.a.b.e(paramj, "resumeFunction is null");
    return io.reactivex.j0.a.l(new v(this, paramj, false));
  }
  
  public final h<T> D(long paramLong, io.reactivex.g0.l<? super Throwable> paraml)
  {
    if (paramLong >= 0L)
    {
      io.reactivex.h0.a.b.e(paraml, "predicate is null");
      return io.reactivex.j0.a.l(new y(this, paramLong, paraml));
    }
    paraml = new StringBuilder();
    paraml.append("times >= 0 required but it was ");
    paraml.append(paramLong);
    throw new IllegalArgumentException(paraml.toString());
  }
  
  public final h<T> E(io.reactivex.g0.j<? super h<Throwable>, ? extends e.b.a<?>> paramj)
  {
    io.reactivex.h0.a.b.e(paramj, "handler is null");
    return io.reactivex.j0.a.l(new io.reactivex.internal.operators.flowable.z(this, paramj));
  }
  
  public final h<T> F(T paramT)
  {
    io.reactivex.h0.a.b.e(paramT, "value is null");
    return e(new e.b.a[] { v(paramT), this });
  }
  
  /* Error */
  public final void G(k<? super T> paramk)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc -44
    //   3: invokestatic 67	io/reactivex/h0/a/b:e	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   6: pop
    //   7: aload_0
    //   8: aload_1
    //   9: invokestatic 216	io/reactivex/j0/a:z	(Lio/reactivex/h;Le/b/b;)Le/b/b;
    //   12: astore_1
    //   13: aload_1
    //   14: ldc -38
    //   16: invokestatic 67	io/reactivex/h0/a/b:e	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   19: pop
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 222	io/reactivex/h:H	(Le/b/b;)V
    //   25: return
    //   26: astore_2
    //   27: aload_2
    //   28: invokestatic 228	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
    //   31: aload_2
    //   32: invokestatic 231	io/reactivex/j0/a:r	(Ljava/lang/Throwable;)V
    //   35: new 210	java/lang/NullPointerException
    //   38: dup
    //   39: ldc -23
    //   41: invokespecial 234	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   44: astore_1
    //   45: aload_1
    //   46: aload_2
    //   47: invokevirtual 238	java/lang/NullPointerException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   50: pop
    //   51: aload_1
    //   52: athrow
    //   53: astore_1
    //   54: aload_1
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	h
    //   0	56	1	paramk	k<? super T>
    //   26	21	2	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   7	25	26	finally
    //   7	25	53	java/lang/NullPointerException
  }
  
  protected abstract void H(e.b.b<? super T> paramb);
  
  public final h<T> I(w paramw)
  {
    io.reactivex.h0.a.b.e(paramw, "scheduler is null");
    return J(paramw, this instanceof io.reactivex.internal.operators.flowable.c ^ true);
  }
  
  public final h<T> J(w paramw, boolean paramBoolean)
  {
    io.reactivex.h0.a.b.e(paramw, "scheduler is null");
    return io.reactivex.j0.a.l(new b0(this, paramw, paramBoolean));
  }
  
  public final q<T> K()
  {
    return io.reactivex.j0.a.n(new io.reactivex.internal.operators.observable.z(this));
  }
  
  public final h<T> L(w paramw)
  {
    io.reactivex.h0.a.b.e(paramw, "scheduler is null");
    return io.reactivex.j0.a.l(new c0(this, paramw));
  }
  
  public final void a(e.b.b<? super T> paramb)
  {
    if ((paramb instanceof k))
    {
      G((k)paramb);
    }
    else
    {
      io.reactivex.h0.a.b.e(paramb, "s is null");
      G(new StrictSubscriber(paramb));
    }
  }
  
  public final <R> h<R> d(l<? super T, ? extends R> paraml)
  {
    return u(((l)io.reactivex.h0.a.b.e(paraml, "composer is null")).a(this));
  }
  
  public final h<T> g()
  {
    return h(io.reactivex.h0.a.a.g());
  }
  
  public final <K> h<T> h(io.reactivex.g0.j<? super T, K> paramj)
  {
    io.reactivex.h0.a.b.e(paramj, "keySelector is null");
    return io.reactivex.j0.a.l(new d(this, paramj, io.reactivex.h0.a.b.d()));
  }
  
  public final h<T> i(io.reactivex.g0.a parama)
  {
    return l(io.reactivex.h0.a.a.f(), io.reactivex.h0.a.a.g, parama);
  }
  
  public final h<T> k(io.reactivex.g0.g<? super Throwable> paramg)
  {
    io.reactivex.g0.g localg = io.reactivex.h0.a.a.f();
    io.reactivex.g0.a locala = io.reactivex.h0.a.a.c;
    return j(localg, paramg, locala, locala);
  }
  
  public final h<T> l(io.reactivex.g0.g<? super e.b.c> paramg, io.reactivex.g0.k paramk, io.reactivex.g0.a parama)
  {
    io.reactivex.h0.a.b.e(paramg, "onSubscribe is null");
    io.reactivex.h0.a.b.e(paramk, "onRequest is null");
    io.reactivex.h0.a.b.e(parama, "onCancel is null");
    return io.reactivex.j0.a.l(new f(this, paramg, paramk, parama));
  }
  
  public final h<T> p(io.reactivex.g0.l<? super T> paraml)
  {
    io.reactivex.h0.a.b.e(paraml, "predicate is null");
    return io.reactivex.j0.a.l(new i(this, paraml));
  }
  
  public final <R> h<R> q(io.reactivex.g0.j<? super T, ? extends e.b.a<? extends R>> paramj)
  {
    return r(paramj, false, c(), c());
  }
  
  public final <R> h<R> r(io.reactivex.g0.j<? super T, ? extends e.b.a<? extends R>> paramj, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    io.reactivex.h0.a.b.e(paramj, "mapper is null");
    io.reactivex.h0.a.b.f(paramInt1, "maxConcurrency");
    io.reactivex.h0.a.b.f(paramInt2, "bufferSize");
    if ((this instanceof io.reactivex.h0.b.g))
    {
      Object localObject = ((io.reactivex.h0.b.g)this).call();
      if (localObject == null) {
        return m();
      }
      return a0.a(localObject, paramj);
    }
    return io.reactivex.j0.a.l(new io.reactivex.internal.operators.flowable.j(this, paramj, paramBoolean, paramInt1, paramInt2));
  }
  
  public final <R> h<R> s(io.reactivex.g0.j<? super T, ? extends o<? extends R>> paramj)
  {
    return t(paramj, false, Integer.MAX_VALUE);
  }
  
  public final <R> h<R> t(io.reactivex.g0.j<? super T, ? extends o<? extends R>> paramj, boolean paramBoolean, int paramInt)
  {
    io.reactivex.h0.a.b.e(paramj, "mapper is null");
    io.reactivex.h0.a.b.f(paramInt, "maxConcurrency");
    return io.reactivex.j0.a.l(new io.reactivex.internal.operators.flowable.k(this, paramj, paramBoolean, paramInt));
  }
  
  public final h<T> w(w paramw)
  {
    return x(paramw, false, c());
  }
  
  public final h<T> x(w paramw, boolean paramBoolean, int paramInt)
  {
    io.reactivex.h0.a.b.e(paramw, "scheduler is null");
    io.reactivex.h0.a.b.f(paramInt, "bufferSize");
    return io.reactivex.j0.a.l(new io.reactivex.internal.operators.flowable.q(this, paramw, paramBoolean, paramInt));
  }
  
  public final h<T> y()
  {
    return z(c(), false, true);
  }
  
  public final h<T> z(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    io.reactivex.h0.a.b.f(paramInt, "capacity");
    return io.reactivex.j0.a.l(new r(this, paramInt, paramBoolean2, paramBoolean1, io.reactivex.h0.a.a.c));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */