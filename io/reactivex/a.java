package io.reactivex;

import io.reactivex.h0.c.a.i;
import io.reactivex.h0.c.a.k;
import io.reactivex.h0.c.a.m;
import io.reactivex.h0.c.a.n;
import io.reactivex.h0.c.a.o;
import io.reactivex.h0.c.a.p;
import io.reactivex.h0.c.a.r;
import io.reactivex.h0.c.a.s;
import io.reactivex.internal.observers.CallbackCompletableObserver;
import io.reactivex.internal.observers.EmptyCompletableObserver;
import java.util.concurrent.TimeUnit;

public abstract class a
  implements e
{
  private a E(long paramLong, TimeUnit paramTimeUnit, w paramw, e parame)
  {
    io.reactivex.h0.a.b.e(paramTimeUnit, "unit is null");
    io.reactivex.h0.a.b.e(paramw, "scheduler is null");
    return io.reactivex.j0.a.k(new p(this, paramLong, paramTimeUnit, paramw, parame));
  }
  
  public static a F(long paramLong, TimeUnit paramTimeUnit)
  {
    return G(paramLong, paramTimeUnit, io.reactivex.l0.a.a());
  }
  
  public static a G(long paramLong, TimeUnit paramTimeUnit, w paramw)
  {
    io.reactivex.h0.a.b.e(paramTimeUnit, "unit is null");
    io.reactivex.h0.a.b.e(paramw, "scheduler is null");
    return io.reactivex.j0.a.k(new io.reactivex.h0.c.a.q(paramLong, paramTimeUnit, paramw));
  }
  
  private static NullPointerException I(Throwable paramThrowable)
  {
    NullPointerException localNullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
    localNullPointerException.initCause(paramThrowable);
    return localNullPointerException;
  }
  
  public static a K(e parame)
  {
    io.reactivex.h0.a.b.e(parame, "source is null");
    if ((parame instanceof a)) {
      return io.reactivex.j0.a.k((a)parame);
    }
    return io.reactivex.j0.a.k(new io.reactivex.h0.c.a.h(parame));
  }
  
  public static a e()
  {
    return io.reactivex.j0.a.k(io.reactivex.h0.c.a.d.c);
  }
  
  public static a g(d paramd)
  {
    io.reactivex.h0.a.b.e(paramd, "source is null");
    return io.reactivex.j0.a.k(new io.reactivex.h0.c.a.b(paramd));
  }
  
  private a k(io.reactivex.g0.g<? super io.reactivex.e0.c> paramg, io.reactivex.g0.g<? super Throwable> paramg1, io.reactivex.g0.a parama1, io.reactivex.g0.a parama2, io.reactivex.g0.a parama3, io.reactivex.g0.a parama4)
  {
    io.reactivex.h0.a.b.e(paramg, "onSubscribe is null");
    io.reactivex.h0.a.b.e(paramg1, "onError is null");
    io.reactivex.h0.a.b.e(parama1, "onComplete is null");
    io.reactivex.h0.a.b.e(parama2, "onTerminate is null");
    io.reactivex.h0.a.b.e(parama3, "onAfterTerminate is null");
    io.reactivex.h0.a.b.e(parama4, "onDispose is null");
    return io.reactivex.j0.a.k(new m(this, paramg, paramg1, parama1, parama2, parama3, parama4));
  }
  
  public static a m(Throwable paramThrowable)
  {
    io.reactivex.h0.a.b.e(paramThrowable, "error is null");
    return io.reactivex.j0.a.k(new io.reactivex.h0.c.a.e(paramThrowable));
  }
  
  public static a n(io.reactivex.g0.a parama)
  {
    io.reactivex.h0.a.b.e(parama, "run is null");
    return io.reactivex.j0.a.k(new io.reactivex.h0.c.a.f(parama));
  }
  
  public static <T> a o(e.b.a<T> parama)
  {
    io.reactivex.h0.a.b.e(parama, "publisher is null");
    return io.reactivex.j0.a.k(new io.reactivex.h0.c.a.g(parama));
  }
  
  public static a p(Iterable<? extends e> paramIterable)
  {
    io.reactivex.h0.a.b.e(paramIterable, "sources is null");
    return io.reactivex.j0.a.k(new io.reactivex.h0.c.a.j(paramIterable));
  }
  
  public static a q(e... paramVarArgs)
  {
    io.reactivex.h0.a.b.e(paramVarArgs, "sources is null");
    return io.reactivex.j0.a.k(new i(paramVarArgs));
  }
  
  public final io.reactivex.e0.c A(io.reactivex.g0.a parama, io.reactivex.g0.g<? super Throwable> paramg)
  {
    io.reactivex.h0.a.b.e(paramg, "onError is null");
    io.reactivex.h0.a.b.e(parama, "onComplete is null");
    parama = new CallbackCompletableObserver(paramg, parama);
    a(parama);
    return parama;
  }
  
  protected abstract void B(c paramc);
  
  public final a C(w paramw)
  {
    io.reactivex.h0.a.b.e(paramw, "scheduler is null");
    return io.reactivex.j0.a.k(new o(this, paramw));
  }
  
  public final a D(long paramLong, TimeUnit paramTimeUnit)
  {
    return E(paramLong, paramTimeUnit, io.reactivex.l0.a.a(), null);
  }
  
  public final <T> h<T> H()
  {
    if ((this instanceof io.reactivex.h0.b.b)) {
      return ((io.reactivex.h0.b.b)this).a();
    }
    return io.reactivex.j0.a.l(new r(this));
  }
  
  public final <T> q<T> J()
  {
    if ((this instanceof io.reactivex.h0.b.c)) {
      return ((io.reactivex.h0.b.c)this).b();
    }
    return io.reactivex.j0.a.n(new s(this));
  }
  
  /* Error */
  public final void a(c paramc)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc -52
    //   3: invokestatic 21	io/reactivex/h0/a/b:e	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   6: pop
    //   7: aload_0
    //   8: aload_1
    //   9: invokestatic 208	io/reactivex/j0/a:v	(Lio/reactivex/a;Lio/reactivex/c;)Lio/reactivex/c;
    //   12: astore_1
    //   13: aload_1
    //   14: ldc -46
    //   16: invokestatic 21	io/reactivex/h0/a/b:e	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   19: pop
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 212	io/reactivex/a:B	(Lio/reactivex/c;)V
    //   25: return
    //   26: astore_1
    //   27: aload_1
    //   28: invokestatic 216	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
    //   31: aload_1
    //   32: invokestatic 219	io/reactivex/j0/a:r	(Ljava/lang/Throwable;)V
    //   35: aload_1
    //   36: invokestatic 221	io/reactivex/a:I	(Ljava/lang/Throwable;)Ljava/lang/NullPointerException;
    //   39: athrow
    //   40: astore_1
    //   41: aload_1
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	a
    //   0	43	1	paramc	c
    // Exception table:
    //   from	to	target	type
    //   7	25	26	finally
    //   7	25	40	java/lang/NullPointerException
  }
  
  public final a c(e parame)
  {
    io.reactivex.h0.a.b.e(parame, "next is null");
    return io.reactivex.j0.a.k(new io.reactivex.h0.c.a.a(this, parame));
  }
  
  public final <T> q<T> d(t<T> paramt)
  {
    io.reactivex.h0.a.b.e(paramt, "next is null");
    return io.reactivex.j0.a.n(new io.reactivex.h0.c.b.a(this, paramt));
  }
  
  public final a f(f paramf)
  {
    return K(((f)io.reactivex.h0.a.b.e(paramf, "transformer is null")).a(this));
  }
  
  public final a h(io.reactivex.g0.a parama)
  {
    io.reactivex.h0.a.b.e(parama, "onFinally is null");
    return io.reactivex.j0.a.k(new io.reactivex.h0.c.a.c(this, parama));
  }
  
  public final a i(io.reactivex.g0.a parama)
  {
    io.reactivex.g0.g localg1 = io.reactivex.h0.a.a.f();
    io.reactivex.g0.g localg2 = io.reactivex.h0.a.a.f();
    io.reactivex.g0.a locala = io.reactivex.h0.a.a.c;
    return k(localg1, localg2, parama, locala, locala, locala);
  }
  
  public final a j(io.reactivex.g0.g<? super Throwable> paramg)
  {
    io.reactivex.g0.g localg = io.reactivex.h0.a.a.f();
    io.reactivex.g0.a locala = io.reactivex.h0.a.a.c;
    return k(localg, paramg, locala, locala, locala, locala);
  }
  
  public final a l(io.reactivex.g0.g<? super io.reactivex.e0.c> paramg)
  {
    io.reactivex.g0.g localg = io.reactivex.h0.a.a.f();
    io.reactivex.g0.a locala = io.reactivex.h0.a.a.c;
    return k(paramg, localg, locala, locala, locala, locala);
  }
  
  public final a r(w paramw)
  {
    io.reactivex.h0.a.b.e(paramw, "scheduler is null");
    return io.reactivex.j0.a.k(new k(this, paramw));
  }
  
  public final a s()
  {
    return t(io.reactivex.h0.a.a.b());
  }
  
  public final a t(io.reactivex.g0.l<? super Throwable> paraml)
  {
    io.reactivex.h0.a.b.e(paraml, "predicate is null");
    return io.reactivex.j0.a.k(new io.reactivex.h0.c.a.l(this, paraml));
  }
  
  public final a u(io.reactivex.g0.j<? super Throwable, ? extends e> paramj)
  {
    io.reactivex.h0.a.b.e(paramj, "errorMapper is null");
    return io.reactivex.j0.a.k(new n(this, paramj));
  }
  
  public final a v(long paramLong, io.reactivex.g0.l<? super Throwable> paraml)
  {
    return o(H().D(paramLong, paraml));
  }
  
  public final a w(io.reactivex.g0.j<? super h<Throwable>, ? extends e.b.a<?>> paramj)
  {
    return o(H().E(paramj));
  }
  
  public final <T> q<T> x(q<T> paramq)
  {
    io.reactivex.h0.a.b.e(paramq, "other is null");
    return paramq.l(J());
  }
  
  public final io.reactivex.e0.c y()
  {
    EmptyCompletableObserver localEmptyCompletableObserver = new EmptyCompletableObserver();
    a(localEmptyCompletableObserver);
    return localEmptyCompletableObserver;
  }
  
  public final io.reactivex.e0.c z(io.reactivex.g0.a parama)
  {
    io.reactivex.h0.a.b.e(parama, "onComplete is null");
    parama = new CallbackCompletableObserver(parama);
    a(parama);
    return parama;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */