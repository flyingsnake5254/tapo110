package io.reactivex.j0;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.exceptions.UndeliverableException;
import io.reactivex.g0.e;
import io.reactivex.g0.g;
import io.reactivex.g0.j;
import io.reactivex.h;
import io.reactivex.m;
import io.reactivex.n;
import io.reactivex.q;
import io.reactivex.v;
import io.reactivex.w;
import io.reactivex.x;
import io.reactivex.z;
import java.util.concurrent.Callable;

public final class a
{
  static volatile g<? super Throwable> a;
  static volatile j<? super Runnable, ? extends Runnable> b;
  static volatile j<? super Callable<w>, ? extends w> c;
  static volatile j<? super Callable<w>, ? extends w> d;
  static volatile j<? super Callable<w>, ? extends w> e;
  static volatile j<? super Callable<w>, ? extends w> f;
  static volatile j<? super w, ? extends w> g;
  static volatile j<? super w, ? extends w> h;
  static volatile j<? super w, ? extends w> i;
  static volatile j<? super h, ? extends h> j;
  static volatile j<? super q, ? extends q> k;
  static volatile j<? super m, ? extends m> l;
  static volatile j<? super x, ? extends x> m;
  static volatile j<? super io.reactivex.a, ? extends io.reactivex.a> n;
  static volatile io.reactivex.g0.c<? super h, ? super e.b.b, ? extends e.b.b> o;
  static volatile io.reactivex.g0.c<? super m, ? super n, ? extends n> p;
  static volatile io.reactivex.g0.c<? super q, ? super v, ? extends v> q;
  static volatile io.reactivex.g0.c<? super x, ? super z, ? extends z> r;
  static volatile io.reactivex.g0.c<? super io.reactivex.a, ? super io.reactivex.c, ? extends io.reactivex.c> s;
  static volatile e t;
  static volatile boolean u;
  static volatile boolean v;
  
  public static void A(g<? super Throwable> paramg)
  {
    if (!u)
    {
      a = paramg;
      return;
    }
    throw new IllegalStateException("Plugins can't be changed anymore");
  }
  
  static void B(Throwable paramThrowable)
  {
    Thread localThread = Thread.currentThread();
    localThread.getUncaughtExceptionHandler().uncaughtException(localThread, paramThrowable);
  }
  
  static <T, U, R> R a(io.reactivex.g0.c<T, U, R> paramc, T paramT, U paramU)
  {
    try
    {
      paramc = paramc.apply(paramT, paramU);
      return paramc;
    }
    finally {}
  }
  
  static <T, R> R b(j<T, R> paramj, T paramT)
  {
    try
    {
      paramj = paramj.apply(paramT);
      return paramj;
    }
    finally {}
  }
  
  static w c(j<? super Callable<w>, ? extends w> paramj, Callable<w> paramCallable)
  {
    return (w)io.reactivex.h0.a.b.e(b(paramj, paramCallable), "Scheduler Callable result can't be null");
  }
  
  static w d(Callable<w> paramCallable)
  {
    try
    {
      paramCallable = (w)io.reactivex.h0.a.b.e(paramCallable.call(), "Scheduler Callable result can't be null");
      return paramCallable;
    }
    finally {}
  }
  
  public static w e(Callable<w> paramCallable)
  {
    io.reactivex.h0.a.b.e(paramCallable, "Scheduler Callable can't be null");
    j localj = c;
    if (localj == null) {
      return d(paramCallable);
    }
    return c(localj, paramCallable);
  }
  
  public static w f(Callable<w> paramCallable)
  {
    io.reactivex.h0.a.b.e(paramCallable, "Scheduler Callable can't be null");
    j localj = e;
    if (localj == null) {
      return d(paramCallable);
    }
    return c(localj, paramCallable);
  }
  
  public static w g(Callable<w> paramCallable)
  {
    io.reactivex.h0.a.b.e(paramCallable, "Scheduler Callable can't be null");
    j localj = f;
    if (localj == null) {
      return d(paramCallable);
    }
    return c(localj, paramCallable);
  }
  
  public static w h(Callable<w> paramCallable)
  {
    io.reactivex.h0.a.b.e(paramCallable, "Scheduler Callable can't be null");
    j localj = d;
    if (localj == null) {
      return d(paramCallable);
    }
    return c(localj, paramCallable);
  }
  
  static boolean i(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof OnErrorNotImplementedException)) {
      return true;
    }
    if ((paramThrowable instanceof MissingBackpressureException)) {
      return true;
    }
    if ((paramThrowable instanceof IllegalStateException)) {
      return true;
    }
    if ((paramThrowable instanceof NullPointerException)) {
      return true;
    }
    if ((paramThrowable instanceof IllegalArgumentException)) {
      return true;
    }
    return (paramThrowable instanceof CompositeException);
  }
  
  public static boolean j()
  {
    return v;
  }
  
  public static io.reactivex.a k(io.reactivex.a parama)
  {
    j localj = n;
    io.reactivex.a locala = parama;
    if (localj != null) {
      locala = (io.reactivex.a)b(localj, parama);
    }
    return locala;
  }
  
  public static <T> h<T> l(h<T> paramh)
  {
    j localj = j;
    Object localObject = paramh;
    if (localj != null) {
      localObject = (h)b(localj, paramh);
    }
    return (h<T>)localObject;
  }
  
  public static <T> m<T> m(m<T> paramm)
  {
    j localj = l;
    Object localObject = paramm;
    if (localj != null) {
      localObject = (m)b(localj, paramm);
    }
    return (m<T>)localObject;
  }
  
  public static <T> q<T> n(q<T> paramq)
  {
    j localj = k;
    Object localObject = paramq;
    if (localj != null) {
      localObject = (q)b(localj, paramq);
    }
    return (q<T>)localObject;
  }
  
  public static <T> x<T> o(x<T> paramx)
  {
    j localj = m;
    Object localObject = paramx;
    if (localj != null) {
      localObject = (x)b(localj, paramx);
    }
    return (x<T>)localObject;
  }
  
  public static boolean p()
  {
    e locale = t;
    if (locale != null) {
      try
      {
        boolean bool = locale.a();
        return bool;
      }
      finally {}
    }
    return false;
  }
  
  public static w q(w paramw)
  {
    j localj = g;
    if (localj == null) {
      return paramw;
    }
    return (w)b(localj, paramw);
  }
  
  public static void r(Throwable paramThrowable)
  {
    g localg = a;
    Object localObject;
    if (paramThrowable == null)
    {
      localObject = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
    }
    else
    {
      localObject = paramThrowable;
      if (!i(paramThrowable)) {
        localObject = new UndeliverableException(paramThrowable);
      }
    }
    if (localg != null) {
      try
      {
        localg.accept(localObject);
        return;
      }
      finally
      {
        paramThrowable.printStackTrace();
        B(paramThrowable);
      }
    }
    ((Throwable)localObject).printStackTrace();
    B((Throwable)localObject);
  }
  
  public static w s(w paramw)
  {
    j localj = i;
    if (localj == null) {
      return paramw;
    }
    return (w)b(localj, paramw);
  }
  
  public static Runnable t(Runnable paramRunnable)
  {
    io.reactivex.h0.a.b.e(paramRunnable, "run is null");
    j localj = b;
    if (localj == null) {
      return paramRunnable;
    }
    return (Runnable)b(localj, paramRunnable);
  }
  
  public static w u(w paramw)
  {
    j localj = h;
    if (localj == null) {
      return paramw;
    }
    return (w)b(localj, paramw);
  }
  
  public static io.reactivex.c v(io.reactivex.a parama, io.reactivex.c paramc)
  {
    io.reactivex.g0.c localc = s;
    if (localc != null) {
      return (io.reactivex.c)a(localc, parama, paramc);
    }
    return paramc;
  }
  
  public static <T> n<? super T> w(m<T> paramm, n<? super T> paramn)
  {
    io.reactivex.g0.c localc = p;
    if (localc != null) {
      return (n)a(localc, paramm, paramn);
    }
    return paramn;
  }
  
  public static <T> v<? super T> x(q<T> paramq, v<? super T> paramv)
  {
    io.reactivex.g0.c localc = q;
    if (localc != null) {
      return (v)a(localc, paramq, paramv);
    }
    return paramv;
  }
  
  public static <T> z<? super T> y(x<T> paramx, z<? super T> paramz)
  {
    io.reactivex.g0.c localc = r;
    if (localc != null) {
      return (z)a(localc, paramx, paramz);
    }
    return paramz;
  }
  
  public static <T> e.b.b<? super T> z(h<T> paramh, e.b.b<? super T> paramb)
  {
    io.reactivex.g0.c localc = o;
    if (localc != null) {
      return (e.b.b)a(localc, paramh, paramb);
    }
    return paramb;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\j0\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */