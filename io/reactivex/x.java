package io.reactivex;

import io.reactivex.g0.j;
import io.reactivex.g0.l;
import io.reactivex.h0.c.c.d;
import io.reactivex.h0.c.c.f;
import java.util.concurrent.Callable;

public abstract class x<T>
  implements b0<T>
{
  public static <T> x<T> e(a0<T> parama0)
  {
    io.reactivex.h0.a.b.e(parama0, "source is null");
    return io.reactivex.j0.a.o(new io.reactivex.h0.c.c.a(parama0));
  }
  
  public static <T> x<T> g(Throwable paramThrowable)
  {
    io.reactivex.h0.a.b.e(paramThrowable, "exception is null");
    return h(io.reactivex.h0.a.a.h(paramThrowable));
  }
  
  public static <T> x<T> h(Callable<? extends Throwable> paramCallable)
  {
    io.reactivex.h0.a.b.e(paramCallable, "errorSupplier is null");
    return io.reactivex.j0.a.o(new io.reactivex.h0.c.c.c(paramCallable));
  }
  
  public static <T> x<T> o(b0<T> paramb0)
  {
    io.reactivex.h0.a.b.e(paramb0, "source is null");
    if ((paramb0 instanceof x)) {
      return io.reactivex.j0.a.o((x)paramb0);
    }
    return io.reactivex.j0.a.o(new d(paramb0));
  }
  
  /* Error */
  public final void a(z<? super T> paramz)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 69
    //   3: invokestatic 21	io/reactivex/h0/a/b:e	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   6: pop
    //   7: aload_0
    //   8: aload_1
    //   9: invokestatic 73	io/reactivex/j0/a:y	(Lio/reactivex/x;Lio/reactivex/z;)Lio/reactivex/z;
    //   12: astore_1
    //   13: aload_1
    //   14: ldc 75
    //   16: invokestatic 21	io/reactivex/h0/a/b:e	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   19: pop
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 78	io/reactivex/x:l	(Lio/reactivex/z;)V
    //   25: return
    //   26: astore_1
    //   27: aload_1
    //   28: invokestatic 84	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
    //   31: new 67	java/lang/NullPointerException
    //   34: dup
    //   35: ldc 86
    //   37: invokespecial 89	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   40: astore_2
    //   41: aload_2
    //   42: aload_1
    //   43: invokevirtual 93	java/lang/NullPointerException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   46: pop
    //   47: aload_2
    //   48: athrow
    //   49: astore_1
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	x
    //   0	52	1	paramz	z<? super T>
    //   40	8	2	localNullPointerException	NullPointerException
    // Exception table:
    //   from	to	target	type
    //   20	25	26	finally
    //   20	25	49	java/lang/NullPointerException
  }
  
  public final T c()
  {
    io.reactivex.internal.observers.c localc = new io.reactivex.internal.observers.c();
    a(localc);
    return (T)localc.a();
  }
  
  public final <R> x<R> d(c0<? super T, ? extends R> paramc0)
  {
    return o(((c0)io.reactivex.h0.a.b.e(paramc0, "transformer is null")).a(this));
  }
  
  public final x<T> f(io.reactivex.g0.g<? super Throwable> paramg)
  {
    io.reactivex.h0.a.b.e(paramg, "onError is null");
    return io.reactivex.j0.a.o(new io.reactivex.h0.c.c.b(this, paramg));
  }
  
  public final m<T> i(l<? super T> paraml)
  {
    io.reactivex.h0.a.b.e(paraml, "predicate is null");
    return io.reactivex.j0.a.m(new io.reactivex.internal.operators.maybe.e(this, paraml));
  }
  
  public final <R> q<R> j(j<? super T, ? extends t<? extends R>> paramj)
  {
    io.reactivex.h0.a.b.e(paramj, "mapper is null");
    return io.reactivex.j0.a.n(new io.reactivex.h0.c.b.b(this, paramj));
  }
  
  public final x<T> k(j<? super Throwable, ? extends b0<? extends T>> paramj)
  {
    io.reactivex.h0.a.b.e(paramj, "resumeFunctionInCaseOfError is null");
    return io.reactivex.j0.a.o(new io.reactivex.h0.c.c.e(this, paramj));
  }
  
  protected abstract void l(z<? super T> paramz);
  
  public final x<T> m(w paramw)
  {
    io.reactivex.h0.a.b.e(paramw, "scheduler is null");
    return io.reactivex.j0.a.o(new f(this, paramw));
  }
  
  public final q<T> n()
  {
    if ((this instanceof io.reactivex.h0.b.c)) {
      return ((io.reactivex.h0.b.c)this).b();
    }
    return io.reactivex.j0.a.n(new io.reactivex.h0.c.c.g(this));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */