package io.reactivex;

import io.reactivex.internal.operators.maybe.MaybeCallbackObserver;
import io.reactivex.internal.operators.maybe.d;
import io.reactivex.internal.operators.maybe.f;
import io.reactivex.internal.operators.maybe.h;
import io.reactivex.internal.operators.maybe.k;
import java.util.concurrent.Callable;

public abstract class m<T>
  implements o<T>
{
  public static <T> m<T> h(Throwable paramThrowable)
  {
    io.reactivex.h0.a.b.e(paramThrowable, "exception is null");
    return io.reactivex.j0.a.m(new io.reactivex.internal.operators.maybe.c(paramThrowable));
  }
  
  public static <T> m<T> j(Callable<? extends T> paramCallable)
  {
    io.reactivex.h0.a.b.e(paramCallable, "callable is null");
    return io.reactivex.j0.a.m(new f(paramCallable));
  }
  
  public static <T> m<T> r(o<T> paramo)
  {
    if ((paramo instanceof m)) {
      return io.reactivex.j0.a.m((m)paramo);
    }
    io.reactivex.h0.a.b.e(paramo, "onSubscribe is null");
    return io.reactivex.j0.a.m(new io.reactivex.internal.operators.maybe.l(paramo));
  }
  
  /* Error */
  public final void a(n<? super T> paramn)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 61
    //   3: invokestatic 22	io/reactivex/h0/a/b:e	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   6: pop
    //   7: aload_0
    //   8: aload_1
    //   9: invokestatic 65	io/reactivex/j0/a:w	(Lio/reactivex/m;Lio/reactivex/n;)Lio/reactivex/n;
    //   12: astore_1
    //   13: aload_1
    //   14: ldc 67
    //   16: invokestatic 22	io/reactivex/h0/a/b:e	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   19: pop
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 70	io/reactivex/m:n	(Lio/reactivex/n;)V
    //   25: return
    //   26: astore_1
    //   27: aload_1
    //   28: invokestatic 75	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
    //   31: new 59	java/lang/NullPointerException
    //   34: dup
    //   35: ldc 77
    //   37: invokespecial 80	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   40: astore_2
    //   41: aload_2
    //   42: aload_1
    //   43: invokevirtual 84	java/lang/NullPointerException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   46: pop
    //   47: aload_2
    //   48: athrow
    //   49: astore_1
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	m
    //   0	52	1	paramn	n<? super T>
    //   40	8	2	localNullPointerException	NullPointerException
    // Exception table:
    //   from	to	target	type
    //   20	25	26	finally
    //   20	25	49	java/lang/NullPointerException
  }
  
  public final <R> m<R> c(p<? super T, ? extends R> paramp)
  {
    return r(((p)io.reactivex.h0.a.b.e(paramp, "transformer is null")).a(this));
  }
  
  public final m<T> d(io.reactivex.g0.a parama)
  {
    io.reactivex.h0.a.b.e(parama, "onFinally is null");
    return io.reactivex.j0.a.m(new io.reactivex.internal.operators.maybe.b(this, parama));
  }
  
  public final m<T> e(io.reactivex.g0.g<? super Throwable> paramg)
  {
    io.reactivex.g0.g localg1 = io.reactivex.h0.a.a.f();
    io.reactivex.g0.g localg2 = io.reactivex.h0.a.a.f();
    io.reactivex.g0.g localg3 = (io.reactivex.g0.g)io.reactivex.h0.a.b.e(paramg, "onError is null");
    paramg = io.reactivex.h0.a.a.c;
    return io.reactivex.j0.a.m(new h(this, localg1, localg2, localg3, paramg, paramg, paramg));
  }
  
  public final m<T> f(io.reactivex.g0.g<? super io.reactivex.e0.c> paramg)
  {
    io.reactivex.g0.g localg1 = (io.reactivex.g0.g)io.reactivex.h0.a.b.e(paramg, "onSubscribe is null");
    io.reactivex.g0.g localg2 = io.reactivex.h0.a.a.f();
    paramg = io.reactivex.h0.a.a.f();
    io.reactivex.g0.a locala = io.reactivex.h0.a.a.c;
    return io.reactivex.j0.a.m(new h(this, localg1, localg2, paramg, locala, locala, locala));
  }
  
  public final m<T> g(io.reactivex.g0.g<? super T> paramg)
  {
    io.reactivex.g0.g localg1 = io.reactivex.h0.a.a.f();
    io.reactivex.g0.g localg2 = (io.reactivex.g0.g)io.reactivex.h0.a.b.e(paramg, "onSuccess is null");
    io.reactivex.g0.g localg3 = io.reactivex.h0.a.a.f();
    paramg = io.reactivex.h0.a.a.c;
    return io.reactivex.j0.a.m(new h(this, localg1, localg2, localg3, paramg, paramg, paramg));
  }
  
  public final m<T> i(io.reactivex.g0.l<? super T> paraml)
  {
    io.reactivex.h0.a.b.e(paraml, "predicate is null");
    return io.reactivex.j0.a.m(new d(this, paraml));
  }
  
  public final m<T> k(io.reactivex.g0.j<? super Throwable, ? extends o<? extends T>> paramj)
  {
    io.reactivex.h0.a.b.e(paramj, "resumeFunction is null");
    return io.reactivex.j0.a.m(new io.reactivex.internal.operators.maybe.g(this, paramj, true));
  }
  
  public final io.reactivex.e0.c l()
  {
    return m(io.reactivex.h0.a.a.f(), io.reactivex.h0.a.a.f, io.reactivex.h0.a.a.c);
  }
  
  public final io.reactivex.e0.c m(io.reactivex.g0.g<? super T> paramg, io.reactivex.g0.g<? super Throwable> paramg1, io.reactivex.g0.a parama)
  {
    io.reactivex.h0.a.b.e(paramg, "onSuccess is null");
    io.reactivex.h0.a.b.e(paramg1, "onError is null");
    io.reactivex.h0.a.b.e(parama, "onComplete is null");
    return (io.reactivex.e0.c)o(new MaybeCallbackObserver(paramg, paramg1, parama));
  }
  
  protected abstract void n(n<? super T> paramn);
  
  public final <E extends n<? super T>> E o(E paramE)
  {
    a(paramE);
    return paramE;
  }
  
  public final q<T> p()
  {
    if ((this instanceof io.reactivex.h0.b.c)) {
      return ((io.reactivex.h0.b.c)this).b();
    }
    return io.reactivex.j0.a.n(new io.reactivex.internal.operators.maybe.j(this));
  }
  
  public final x<T> q()
  {
    return io.reactivex.j0.a.o(new k(this, null));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */