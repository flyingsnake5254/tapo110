package io.reactivex;

import io.reactivex.internal.observers.LambdaObserver;
import io.reactivex.internal.operators.observable.ObservableScalarXMap;
import io.reactivex.internal.operators.observable.a0;
import io.reactivex.internal.operators.observable.a1;
import io.reactivex.internal.operators.observable.b1;
import io.reactivex.internal.operators.observable.c1;
import io.reactivex.internal.operators.observable.d;
import io.reactivex.internal.operators.observable.d0;
import io.reactivex.internal.operators.observable.d1;
import io.reactivex.internal.operators.observable.e0;
import io.reactivex.internal.operators.observable.f;
import io.reactivex.internal.operators.observable.f0;
import io.reactivex.internal.operators.observable.f1;
import io.reactivex.internal.operators.observable.g0;
import io.reactivex.internal.operators.observable.g1;
import io.reactivex.internal.operators.observable.h0;
import io.reactivex.internal.operators.observable.h1;
import io.reactivex.internal.operators.observable.i0;
import io.reactivex.internal.operators.observable.j0;
import io.reactivex.internal.operators.observable.k;
import io.reactivex.internal.operators.observable.k0;
import io.reactivex.internal.operators.observable.l0;
import io.reactivex.internal.operators.observable.m0;
import io.reactivex.internal.operators.observable.n;
import io.reactivex.internal.operators.observable.n0;
import io.reactivex.internal.operators.observable.o0;
import io.reactivex.internal.operators.observable.p;
import io.reactivex.internal.operators.observable.p0;
import io.reactivex.internal.operators.observable.q0;
import io.reactivex.internal.operators.observable.r;
import io.reactivex.internal.operators.observable.r0;
import io.reactivex.internal.operators.observable.s0;
import io.reactivex.internal.operators.observable.t0;
import io.reactivex.internal.operators.observable.u0;
import io.reactivex.internal.operators.observable.v0;
import io.reactivex.internal.operators.observable.w0;
import io.reactivex.internal.operators.observable.x0;
import io.reactivex.internal.operators.observable.y;
import io.reactivex.internal.operators.observable.y0;
import io.reactivex.internal.operators.observable.z0;
import io.reactivex.internal.util.ArrayListSupplier;
import io.reactivex.internal.util.ErrorMode;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public abstract class q<T>
  implements t<T>
{
  private q<T> B(io.reactivex.g0.g<? super T> paramg, io.reactivex.g0.g<? super Throwable> paramg1, io.reactivex.g0.a parama1, io.reactivex.g0.a parama2)
  {
    io.reactivex.h0.a.b.e(paramg, "onNext is null");
    io.reactivex.h0.a.b.e(paramg1, "onError is null");
    io.reactivex.h0.a.b.e(parama1, "onComplete is null");
    io.reactivex.h0.a.b.e(parama2, "onAfterTerminate is null");
    return io.reactivex.j0.a.n(new k(this, paramg, paramg1, parama1, parama2));
  }
  
  public static <T> q<T> I()
  {
    return io.reactivex.j0.a.n(io.reactivex.internal.operators.observable.o.c);
  }
  
  public static <T> q<T> J(Throwable paramThrowable)
  {
    io.reactivex.h0.a.b.e(paramThrowable, "exception is null");
    return K(io.reactivex.h0.a.a.h(paramThrowable));
  }
  
  public static <T> q<T> K(Callable<? extends Throwable> paramCallable)
  {
    io.reactivex.h0.a.b.e(paramCallable, "errorSupplier is null");
    return io.reactivex.j0.a.n(new p(paramCallable));
  }
  
  private q<T> V0(long paramLong, TimeUnit paramTimeUnit, t<? extends T> paramt, w paramw)
  {
    io.reactivex.h0.a.b.e(paramTimeUnit, "timeUnit is null");
    io.reactivex.h0.a.b.e(paramw, "scheduler is null");
    return io.reactivex.j0.a.n(new c1(this, paramLong, paramTimeUnit, paramw, paramt));
  }
  
  public static <T> q<T> W(T... paramVarArgs)
  {
    io.reactivex.h0.a.b.e(paramVarArgs, "items is null");
    if (paramVarArgs.length == 0) {
      return I();
    }
    if (paramVarArgs.length == 1) {
      return f0(paramVarArgs[0]);
    }
    return io.reactivex.j0.a.n(new io.reactivex.internal.operators.observable.w(paramVarArgs));
  }
  
  public static q<Long> W0(long paramLong, TimeUnit paramTimeUnit)
  {
    return X0(paramLong, paramTimeUnit, io.reactivex.l0.a.a());
  }
  
  public static <T> q<T> X(Callable<? extends T> paramCallable)
  {
    io.reactivex.h0.a.b.e(paramCallable, "supplier is null");
    return io.reactivex.j0.a.n(new io.reactivex.internal.operators.observable.x(paramCallable));
  }
  
  public static q<Long> X0(long paramLong, TimeUnit paramTimeUnit, w paramw)
  {
    io.reactivex.h0.a.b.e(paramTimeUnit, "unit is null");
    io.reactivex.h0.a.b.e(paramw, "scheduler is null");
    return io.reactivex.j0.a.n(new d1(Math.max(paramLong, 0L), paramTimeUnit, paramw));
  }
  
  public static <T> q<T> Y(Iterable<? extends T> paramIterable)
  {
    io.reactivex.h0.a.b.e(paramIterable, "source is null");
    return io.reactivex.j0.a.n(new y(paramIterable));
  }
  
  public static q<Long> a0(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    return b0(paramLong1, paramLong2, paramTimeUnit, io.reactivex.l0.a.a());
  }
  
  public static q<Long> b0(long paramLong1, long paramLong2, TimeUnit paramTimeUnit, w paramw)
  {
    io.reactivex.h0.a.b.e(paramTimeUnit, "unit is null");
    io.reactivex.h0.a.b.e(paramw, "scheduler is null");
    return io.reactivex.j0.a.n(new f0(Math.max(0L, paramLong1), Math.max(0L, paramLong2), paramTimeUnit, paramw));
  }
  
  public static q<Long> c0(long paramLong, TimeUnit paramTimeUnit)
  {
    return b0(paramLong, paramLong, paramTimeUnit, io.reactivex.l0.a.a());
  }
  
  public static <T> q<T> c1(t<T> paramt)
  {
    io.reactivex.h0.a.b.e(paramt, "source is null");
    if ((paramt instanceof q)) {
      return io.reactivex.j0.a.n((q)paramt);
    }
    return io.reactivex.j0.a.n(new a0(paramt));
  }
  
  public static int d()
  {
    return h.c();
  }
  
  public static q<Long> d0(long paramLong1, long paramLong2, long paramLong3, long paramLong4, TimeUnit paramTimeUnit)
  {
    return e0(paramLong1, paramLong2, paramLong3, paramLong4, paramTimeUnit, io.reactivex.l0.a.a());
  }
  
  public static <T1, T2, T3, T4, R> q<R> d1(t<? extends T1> paramt, t<? extends T2> paramt1, t<? extends T3> paramt2, t<? extends T4> paramt3, io.reactivex.g0.i<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> parami)
  {
    io.reactivex.h0.a.b.e(paramt, "source1 is null");
    io.reactivex.h0.a.b.e(paramt1, "source2 is null");
    io.reactivex.h0.a.b.e(paramt2, "source3 is null");
    io.reactivex.h0.a.b.e(paramt3, "source4 is null");
    return h1(io.reactivex.h0.a.a.l(parami), false, d(), new t[] { paramt, paramt1, paramt2, paramt3 });
  }
  
  public static q<Long> e0(long paramLong1, long paramLong2, long paramLong3, long paramLong4, TimeUnit paramTimeUnit, w paramw)
  {
    boolean bool = paramLong2 < 0L;
    if (!bool)
    {
      if (!bool) {
        return I().p(paramLong3, paramTimeUnit, paramw);
      }
      paramLong2 = paramLong1 + (paramLong2 - 1L);
      if ((paramLong1 > 0L) && (paramLong2 < 0L)) {
        throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
      }
      io.reactivex.h0.a.b.e(paramTimeUnit, "unit is null");
      io.reactivex.h0.a.b.e(paramw, "scheduler is null");
      return io.reactivex.j0.a.n(new g0(paramLong1, paramLong2, Math.max(0L, paramLong3), Math.max(0L, paramLong4), paramTimeUnit, paramw));
    }
    paramTimeUnit = new StringBuilder();
    paramTimeUnit.append("count >= 0 required but it was ");
    paramTimeUnit.append(paramLong2);
    throw new IllegalArgumentException(paramTimeUnit.toString());
  }
  
  public static <T1, T2, T3, R> q<R> e1(t<? extends T1> paramt, t<? extends T2> paramt1, t<? extends T3> paramt2, io.reactivex.g0.h<? super T1, ? super T2, ? super T3, ? extends R> paramh)
  {
    io.reactivex.h0.a.b.e(paramt, "source1 is null");
    io.reactivex.h0.a.b.e(paramt1, "source2 is null");
    io.reactivex.h0.a.b.e(paramt2, "source3 is null");
    return h1(io.reactivex.h0.a.a.k(paramh), false, d(), new t[] { paramt, paramt1, paramt2 });
  }
  
  public static <T1, T2, R> q<R> f(t<? extends T1> paramt, t<? extends T2> paramt1, io.reactivex.g0.c<? super T1, ? super T2, ? extends R> paramc)
  {
    io.reactivex.h0.a.b.e(paramt, "source1 is null");
    io.reactivex.h0.a.b.e(paramt1, "source2 is null");
    return g(io.reactivex.h0.a.a.j(paramc), d(), new t[] { paramt, paramt1 });
  }
  
  public static <T> q<T> f0(T paramT)
  {
    io.reactivex.h0.a.b.e(paramT, "item is null");
    return io.reactivex.j0.a.n(new h0(paramT));
  }
  
  public static <T1, T2, R> q<R> f1(t<? extends T1> paramt, t<? extends T2> paramt1, io.reactivex.g0.c<? super T1, ? super T2, ? extends R> paramc)
  {
    io.reactivex.h0.a.b.e(paramt, "source1 is null");
    io.reactivex.h0.a.b.e(paramt1, "source2 is null");
    return h1(io.reactivex.h0.a.a.j(paramc), false, d(), new t[] { paramt, paramt1 });
  }
  
  public static <T, R> q<R> g(io.reactivex.g0.j<? super Object[], ? extends R> paramj, int paramInt, t<? extends T>... paramVarArgs)
  {
    return h(paramVarArgs, paramj, paramInt);
  }
  
  public static <T, R> q<R> g1(Iterable<? extends t<? extends T>> paramIterable, io.reactivex.g0.j<? super Object[], ? extends R> paramj)
  {
    io.reactivex.h0.a.b.e(paramj, "zipper is null");
    io.reactivex.h0.a.b.e(paramIterable, "sources is null");
    return io.reactivex.j0.a.n(new h1(null, paramIterable, paramj, d(), false));
  }
  
  public static <T, R> q<R> h(t<? extends T>[] paramArrayOft, io.reactivex.g0.j<? super Object[], ? extends R> paramj, int paramInt)
  {
    io.reactivex.h0.a.b.e(paramArrayOft, "sources is null");
    if (paramArrayOft.length == 0) {
      return I();
    }
    io.reactivex.h0.a.b.e(paramj, "combiner is null");
    io.reactivex.h0.a.b.f(paramInt, "bufferSize");
    return io.reactivex.j0.a.n(new io.reactivex.internal.operators.observable.c(paramArrayOft, null, paramj, paramInt << 1, false));
  }
  
  public static <T> q<T> h0(t<? extends T> paramt1, t<? extends T> paramt2, t<? extends T> paramt3, t<? extends T> paramt4)
  {
    io.reactivex.h0.a.b.e(paramt1, "source1 is null");
    io.reactivex.h0.a.b.e(paramt2, "source2 is null");
    io.reactivex.h0.a.b.e(paramt3, "source3 is null");
    io.reactivex.h0.a.b.e(paramt4, "source4 is null");
    return W(new t[] { paramt1, paramt2, paramt3, paramt4 }).P(io.reactivex.h0.a.a.g(), false, 4);
  }
  
  public static <T, R> q<R> h1(io.reactivex.g0.j<? super Object[], ? extends R> paramj, boolean paramBoolean, int paramInt, t<? extends T>... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      return I();
    }
    io.reactivex.h0.a.b.e(paramj, "zipper is null");
    io.reactivex.h0.a.b.f(paramInt, "bufferSize");
    return io.reactivex.j0.a.n(new h1(paramVarArgs, null, paramj, paramInt, paramBoolean));
  }
  
  public static <T> q<T> i0(t<? extends T>... paramVarArgs)
  {
    return W(paramVarArgs).P(io.reactivex.h0.a.a.g(), true, paramVarArgs.length);
  }
  
  public static <T> q<T> j(t<? extends T> paramt1, t<? extends T> paramt2)
  {
    io.reactivex.h0.a.b.e(paramt1, "source1 is null");
    io.reactivex.h0.a.b.e(paramt2, "source2 is null");
    return k(new t[] { paramt1, paramt2 });
  }
  
  public static <T> q<T> j0(Iterable<? extends t<? extends T>> paramIterable)
  {
    return Y(paramIterable).O(io.reactivex.h0.a.a.g(), true);
  }
  
  public static <T> q<T> k(t<? extends T>... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      return I();
    }
    if (paramVarArgs.length == 1) {
      return c1(paramVarArgs[0]);
    }
    return io.reactivex.j0.a.n(new d(W(paramVarArgs), io.reactivex.h0.a.a.g(), d(), ErrorMode.BOUNDARY));
  }
  
  public static <T> q<T> k0(Iterable<? extends t<? extends T>> paramIterable, int paramInt)
  {
    return Y(paramIterable).P(io.reactivex.h0.a.a.g(), true, paramInt);
  }
  
  public static <T> q<T> m(s<T> params)
  {
    io.reactivex.h0.a.b.e(params, "source is null");
    return io.reactivex.j0.a.n(new io.reactivex.internal.operators.observable.e(params));
  }
  
  public final q<T> A(io.reactivex.g0.a parama)
  {
    return D(io.reactivex.h0.a.a.f(), parama);
  }
  
  public final <R> q<R> A0(Callable<R> paramCallable, io.reactivex.g0.c<R, ? super T, R> paramc)
  {
    io.reactivex.h0.a.b.e(paramCallable, "seedSupplier is null");
    io.reactivex.h0.a.b.e(paramc, "accumulator is null");
    return io.reactivex.j0.a.n(new r0(this, paramCallable, paramc));
  }
  
  public final m<T> B0()
  {
    return io.reactivex.j0.a.m(new s0(this));
  }
  
  public final q<T> C(io.reactivex.g0.g<? super Throwable> paramg)
  {
    io.reactivex.g0.g localg = io.reactivex.h0.a.a.f();
    io.reactivex.g0.a locala = io.reactivex.h0.a.a.c;
    return B(localg, paramg, locala, locala);
  }
  
  public final x<T> C0()
  {
    return io.reactivex.j0.a.o(new t0(this, null));
  }
  
  public final q<T> D(io.reactivex.g0.g<? super io.reactivex.e0.c> paramg, io.reactivex.g0.a parama)
  {
    io.reactivex.h0.a.b.e(paramg, "onSubscribe is null");
    io.reactivex.h0.a.b.e(parama, "onDispose is null");
    return io.reactivex.j0.a.n(new io.reactivex.internal.operators.observable.l(this, paramg, parama));
  }
  
  public final q<T> D0(long paramLong)
  {
    if (paramLong <= 0L) {
      return io.reactivex.j0.a.n(this);
    }
    return io.reactivex.j0.a.n(new u0(this, paramLong));
  }
  
  public final q<T> E(io.reactivex.g0.g<? super T> paramg)
  {
    io.reactivex.g0.g localg = io.reactivex.h0.a.a.f();
    io.reactivex.g0.a locala = io.reactivex.h0.a.a.c;
    return B(paramg, localg, locala, locala);
  }
  
  public final q<T> E0(T paramT)
  {
    io.reactivex.h0.a.b.e(paramT, "item is null");
    return k(new t[] { f0(paramT), this });
  }
  
  public final q<T> F(io.reactivex.g0.g<? super io.reactivex.e0.c> paramg)
  {
    return D(paramg, io.reactivex.h0.a.a.c);
  }
  
  public final io.reactivex.e0.c F0()
  {
    return J0(io.reactivex.h0.a.a.f(), io.reactivex.h0.a.a.f, io.reactivex.h0.a.a.c, io.reactivex.h0.a.a.f());
  }
  
  public final q<T> G(io.reactivex.g0.a parama)
  {
    io.reactivex.h0.a.b.e(parama, "onTerminate is null");
    return B(io.reactivex.h0.a.a.f(), io.reactivex.h0.a.a.a(parama), parama, io.reactivex.h0.a.a.c);
  }
  
  public final io.reactivex.e0.c G0(io.reactivex.g0.g<? super T> paramg)
  {
    return J0(paramg, io.reactivex.h0.a.a.f, io.reactivex.h0.a.a.c, io.reactivex.h0.a.a.f());
  }
  
  public final m<T> H(long paramLong)
  {
    if (paramLong >= 0L) {
      return io.reactivex.j0.a.m(new n(this, paramLong));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("index >= 0 required but it was ");
    localStringBuilder.append(paramLong);
    throw new IndexOutOfBoundsException(localStringBuilder.toString());
  }
  
  public final io.reactivex.e0.c H0(io.reactivex.g0.g<? super T> paramg, io.reactivex.g0.g<? super Throwable> paramg1)
  {
    return J0(paramg, paramg1, io.reactivex.h0.a.a.c, io.reactivex.h0.a.a.f());
  }
  
  public final io.reactivex.e0.c I0(io.reactivex.g0.g<? super T> paramg, io.reactivex.g0.g<? super Throwable> paramg1, io.reactivex.g0.a parama)
  {
    return J0(paramg, paramg1, parama, io.reactivex.h0.a.a.f());
  }
  
  public final io.reactivex.e0.c J0(io.reactivex.g0.g<? super T> paramg, io.reactivex.g0.g<? super Throwable> paramg1, io.reactivex.g0.a parama, io.reactivex.g0.g<? super io.reactivex.e0.c> paramg2)
  {
    io.reactivex.h0.a.b.e(paramg, "onNext is null");
    io.reactivex.h0.a.b.e(paramg1, "onError is null");
    io.reactivex.h0.a.b.e(parama, "onComplete is null");
    io.reactivex.h0.a.b.e(paramg2, "onSubscribe is null");
    paramg = new LambdaObserver(paramg, paramg1, parama, paramg2);
    a(paramg);
    return paramg;
  }
  
  protected abstract void K0(v<? super T> paramv);
  
  public final q<T> L(io.reactivex.g0.l<? super T> paraml)
  {
    io.reactivex.h0.a.b.e(paraml, "predicate is null");
    return io.reactivex.j0.a.n(new io.reactivex.internal.operators.observable.q(this, paraml));
  }
  
  public final q<T> L0(w paramw)
  {
    io.reactivex.h0.a.b.e(paramw, "scheduler is null");
    return io.reactivex.j0.a.n(new v0(this, paramw));
  }
  
  public final m<T> M()
  {
    return H(0L);
  }
  
  public final <E extends v<? super T>> E M0(E paramE)
  {
    a(paramE);
    return paramE;
  }
  
  public final <R> q<R> N(io.reactivex.g0.j<? super T, ? extends t<? extends R>> paramj)
  {
    return O(paramj, false);
  }
  
  public final q<T> N0(t<? extends T> paramt)
  {
    io.reactivex.h0.a.b.e(paramt, "other is null");
    return io.reactivex.j0.a.n(new w0(this, paramt));
  }
  
  public final <R> q<R> O(io.reactivex.g0.j<? super T, ? extends t<? extends R>> paramj, boolean paramBoolean)
  {
    return P(paramj, paramBoolean, Integer.MAX_VALUE);
  }
  
  public final <R> q<R> O0(io.reactivex.g0.j<? super T, ? extends t<? extends R>> paramj)
  {
    return P0(paramj, d());
  }
  
  public final <R> q<R> P(io.reactivex.g0.j<? super T, ? extends t<? extends R>> paramj, boolean paramBoolean, int paramInt)
  {
    return Q(paramj, paramBoolean, paramInt, d());
  }
  
  public final <R> q<R> P0(io.reactivex.g0.j<? super T, ? extends t<? extends R>> paramj, int paramInt)
  {
    io.reactivex.h0.a.b.e(paramj, "mapper is null");
    io.reactivex.h0.a.b.f(paramInt, "bufferSize");
    if ((this instanceof io.reactivex.h0.b.g))
    {
      Object localObject = ((io.reactivex.h0.b.g)this).call();
      if (localObject == null) {
        return I();
      }
      return ObservableScalarXMap.a(localObject, paramj);
    }
    return io.reactivex.j0.a.n(new x0(this, paramj, paramInt, false));
  }
  
  public final <R> q<R> Q(io.reactivex.g0.j<? super T, ? extends t<? extends R>> paramj, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    io.reactivex.h0.a.b.e(paramj, "mapper is null");
    io.reactivex.h0.a.b.f(paramInt1, "maxConcurrency");
    io.reactivex.h0.a.b.f(paramInt2, "bufferSize");
    if ((this instanceof io.reactivex.h0.b.g))
    {
      Object localObject = ((io.reactivex.h0.b.g)this).call();
      if (localObject == null) {
        return I();
      }
      return ObservableScalarXMap.a(localObject, paramj);
    }
    return io.reactivex.j0.a.n(new r(this, paramj, paramBoolean, paramInt1, paramInt2));
  }
  
  public final q<T> Q0(long paramLong)
  {
    if (paramLong >= 0L) {
      return io.reactivex.j0.a.n(new y0(this, paramLong));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("count >= 0 required but it was ");
    localStringBuilder.append(paramLong);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public final a R(io.reactivex.g0.j<? super T, ? extends e> paramj)
  {
    return S(paramj, false);
  }
  
  public final q<T> R0(int paramInt)
  {
    if (paramInt >= 0)
    {
      if (paramInt == 0) {
        return io.reactivex.j0.a.n(new d0(this));
      }
      if (paramInt == 1) {
        return io.reactivex.j0.a.n(new a1(this));
      }
      return io.reactivex.j0.a.n(new z0(this, paramInt));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("count >= 0 required but it was ");
    localStringBuilder.append(paramInt);
    throw new IndexOutOfBoundsException(localStringBuilder.toString());
  }
  
  public final a S(io.reactivex.g0.j<? super T, ? extends e> paramj, boolean paramBoolean)
  {
    io.reactivex.h0.a.b.e(paramj, "mapper is null");
    return io.reactivex.j0.a.k(new io.reactivex.internal.operators.observable.t(this, paramj, paramBoolean));
  }
  
  public final q<T> S0(io.reactivex.g0.l<? super T> paraml)
  {
    io.reactivex.h0.a.b.e(paraml, "stopPredicate is null");
    return io.reactivex.j0.a.n(new b1(this, paraml));
  }
  
  public final <U> q<U> T(io.reactivex.g0.j<? super T, ? extends Iterable<? extends U>> paramj)
  {
    io.reactivex.h0.a.b.e(paramj, "mapper is null");
    return io.reactivex.j0.a.n(new io.reactivex.internal.operators.observable.v(this, paramj));
  }
  
  public final q<T> T0(long paramLong, TimeUnit paramTimeUnit)
  {
    return V0(paramLong, paramTimeUnit, null, io.reactivex.l0.a.a());
  }
  
  public final <R> q<R> U(io.reactivex.g0.j<? super T, ? extends o<? extends R>> paramj)
  {
    return V(paramj, false);
  }
  
  public final q<T> U0(long paramLong, TimeUnit paramTimeUnit, t<? extends T> paramt)
  {
    io.reactivex.h0.a.b.e(paramt, "other is null");
    return V0(paramLong, paramTimeUnit, paramt, io.reactivex.l0.a.a());
  }
  
  public final <R> q<R> V(io.reactivex.g0.j<? super T, ? extends o<? extends R>> paramj, boolean paramBoolean)
  {
    io.reactivex.h0.a.b.e(paramj, "mapper is null");
    return io.reactivex.j0.a.n(new io.reactivex.internal.operators.observable.u(this, paramj, paramBoolean));
  }
  
  public final h<T> Y0(BackpressureStrategy paramBackpressureStrategy)
  {
    io.reactivex.internal.operators.flowable.l locall = new io.reactivex.internal.operators.flowable.l(this);
    int i = a.a[paramBackpressureStrategy.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return locall.y();
          }
          return io.reactivex.j0.a.l(new io.reactivex.internal.operators.flowable.t(locall));
        }
        return locall;
      }
      return locall.B();
    }
    return locall.A();
  }
  
  public final a Z()
  {
    return io.reactivex.j0.a.k(new e0(this));
  }
  
  public final x<List<T>> Z0()
  {
    return a1(16);
  }
  
  /* Error */
  public final void a(v<? super T> paramv)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc_w 649
    //   4: invokestatic 24	io/reactivex/h0/a/b:e	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   7: pop
    //   8: aload_0
    //   9: aload_1
    //   10: invokestatic 653	io/reactivex/j0/a:x	(Lio/reactivex/q;Lio/reactivex/v;)Lio/reactivex/v;
    //   13: astore_1
    //   14: aload_1
    //   15: ldc_w 655
    //   18: invokestatic 24	io/reactivex/h0/a/b:e	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   21: pop
    //   22: aload_0
    //   23: aload_1
    //   24: invokevirtual 657	io/reactivex/q:K0	(Lio/reactivex/v;)V
    //   27: return
    //   28: astore_1
    //   29: aload_1
    //   30: invokestatic 663	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
    //   33: aload_1
    //   34: invokestatic 666	io/reactivex/j0/a:r	(Ljava/lang/Throwable;)V
    //   37: new 647	java/lang/NullPointerException
    //   40: dup
    //   41: ldc_w 668
    //   44: invokespecial 669	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   47: astore_2
    //   48: aload_2
    //   49: aload_1
    //   50: invokevirtual 673	java/lang/NullPointerException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   53: pop
    //   54: aload_2
    //   55: athrow
    //   56: astore_1
    //   57: aload_1
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	q
    //   0	59	1	paramv	v<? super T>
    //   47	8	2	localNullPointerException	NullPointerException
    // Exception table:
    //   from	to	target	type
    //   8	27	28	finally
    //   8	27	56	java/lang/NullPointerException
  }
  
  public final x<List<T>> a1(int paramInt)
  {
    io.reactivex.h0.a.b.f(paramInt, "capacityHint");
    return io.reactivex.j0.a.o(new f1(this, paramInt));
  }
  
  public final <B> q<List<T>> b(t<B> paramt)
  {
    return c(paramt, ArrayListSupplier.asCallable());
  }
  
  public final q<T> b1(w paramw)
  {
    io.reactivex.h0.a.b.e(paramw, "scheduler is null");
    return io.reactivex.j0.a.n(new g1(this, paramw));
  }
  
  public final <B, U extends Collection<? super T>> q<U> c(t<B> paramt, Callable<U> paramCallable)
  {
    io.reactivex.h0.a.b.e(paramt, "boundary is null");
    io.reactivex.h0.a.b.e(paramCallable, "bufferSupplier is null");
    return io.reactivex.j0.a.n(new io.reactivex.internal.operators.observable.b(this, paramt, paramCallable));
  }
  
  public final <U> q<U> e(Class<U> paramClass)
  {
    io.reactivex.h0.a.b.e(paramClass, "clazz is null");
    return g0(io.reactivex.h0.a.a.c(paramClass));
  }
  
  public final <R> q<R> g0(io.reactivex.g0.j<? super T, ? extends R> paramj)
  {
    io.reactivex.h0.a.b.e(paramj, "mapper is null");
    return io.reactivex.j0.a.n(new i0(this, paramj));
  }
  
  public final <R> q<R> i(u<? super T, ? extends R> paramu)
  {
    return c1(((u)io.reactivex.h0.a.b.e(paramu, "composer is null")).a(this));
  }
  
  public final <U, R> q<R> i1(t<? extends U> paramt, io.reactivex.g0.c<? super T, ? super U, ? extends R> paramc)
  {
    io.reactivex.h0.a.b.e(paramt, "other is null");
    return f1(this, paramt, paramc);
  }
  
  public final q<T> l(t<? extends T> paramt)
  {
    io.reactivex.h0.a.b.e(paramt, "other is null");
    return j(this, paramt);
  }
  
  public final q<T> l0(w paramw)
  {
    return m0(paramw, false, d());
  }
  
  public final q<T> m0(w paramw, boolean paramBoolean, int paramInt)
  {
    io.reactivex.h0.a.b.e(paramw, "scheduler is null");
    io.reactivex.h0.a.b.f(paramInt, "bufferSize");
    return io.reactivex.j0.a.n(new j0(this, paramw, paramBoolean, paramInt));
  }
  
  public final q<T> n(T paramT)
  {
    io.reactivex.h0.a.b.e(paramT, "defaultItem is null");
    return N0(f0(paramT));
  }
  
  public final q<T> n0(t<? extends T> paramt)
  {
    io.reactivex.h0.a.b.e(paramt, "next is null");
    return o0(io.reactivex.h0.a.a.i(paramt));
  }
  
  public final q<T> o(long paramLong, TimeUnit paramTimeUnit)
  {
    return q(paramLong, paramTimeUnit, io.reactivex.l0.a.a(), false);
  }
  
  public final q<T> o0(io.reactivex.g0.j<? super Throwable, ? extends t<? extends T>> paramj)
  {
    io.reactivex.h0.a.b.e(paramj, "resumeFunction is null");
    return io.reactivex.j0.a.n(new k0(this, paramj, false));
  }
  
  public final q<T> p(long paramLong, TimeUnit paramTimeUnit, w paramw)
  {
    return q(paramLong, paramTimeUnit, paramw, false);
  }
  
  public final q<T> p0(io.reactivex.g0.j<? super Throwable, ? extends T> paramj)
  {
    io.reactivex.h0.a.b.e(paramj, "valueSupplier is null");
    return io.reactivex.j0.a.n(new l0(this, paramj));
  }
  
  public final q<T> q(long paramLong, TimeUnit paramTimeUnit, w paramw, boolean paramBoolean)
  {
    io.reactivex.h0.a.b.e(paramTimeUnit, "unit is null");
    io.reactivex.h0.a.b.e(paramw, "scheduler is null");
    return io.reactivex.j0.a.n(new f(this, paramLong, paramTimeUnit, paramw, paramBoolean));
  }
  
  public final q<T> q0(T paramT)
  {
    io.reactivex.h0.a.b.e(paramT, "item is null");
    return p0(io.reactivex.h0.a.a.i(paramT));
  }
  
  public final q<T> r(long paramLong, TimeUnit paramTimeUnit)
  {
    return s(paramLong, paramTimeUnit, io.reactivex.l0.a.a());
  }
  
  public final m<T> r0(io.reactivex.g0.c<T, T, T> paramc)
  {
    io.reactivex.h0.a.b.e(paramc, "reducer is null");
    return io.reactivex.j0.a.m(new m0(this, paramc));
  }
  
  public final q<T> s(long paramLong, TimeUnit paramTimeUnit, w paramw)
  {
    return t(X0(paramLong, paramTimeUnit, paramw));
  }
  
  public final q<T> s0(io.reactivex.g0.e parame)
  {
    io.reactivex.h0.a.b.e(parame, "stop is null");
    return io.reactivex.j0.a.n(new n0(this, parame));
  }
  
  public final <U> q<T> t(t<U> paramt)
  {
    io.reactivex.h0.a.b.e(paramt, "other is null");
    return io.reactivex.j0.a.n(new io.reactivex.internal.operators.observable.g(this, paramt));
  }
  
  public final q<T> t0(io.reactivex.g0.j<? super q<Object>, ? extends t<?>> paramj)
  {
    io.reactivex.h0.a.b.e(paramj, "handler is null");
    return io.reactivex.j0.a.n(new o0(this, paramj));
  }
  
  public final <K> q<T> u(io.reactivex.g0.j<? super T, K> paramj)
  {
    return v(paramj, io.reactivex.h0.a.a.e());
  }
  
  public final q<T> u0(long paramLong)
  {
    return v0(paramLong, io.reactivex.h0.a.a.b());
  }
  
  public final <K> q<T> v(io.reactivex.g0.j<? super T, K> paramj, Callable<? extends Collection<? super K>> paramCallable)
  {
    io.reactivex.h0.a.b.e(paramj, "keySelector is null");
    io.reactivex.h0.a.b.e(paramCallable, "collectionSupplier is null");
    return io.reactivex.j0.a.n(new io.reactivex.internal.operators.observable.h(this, paramj, paramCallable));
  }
  
  public final q<T> v0(long paramLong, io.reactivex.g0.l<? super Throwable> paraml)
  {
    if (paramLong >= 0L)
    {
      io.reactivex.h0.a.b.e(paraml, "predicate is null");
      return io.reactivex.j0.a.n(new p0(this, paramLong, paraml));
    }
    paraml = new StringBuilder();
    paraml.append("times >= 0 required but it was ");
    paraml.append(paramLong);
    throw new IllegalArgumentException(paraml.toString());
  }
  
  public final q<T> w()
  {
    return x(io.reactivex.h0.a.a.g());
  }
  
  public final q<T> w0(io.reactivex.g0.l<? super Throwable> paraml)
  {
    return v0(Long.MAX_VALUE, paraml);
  }
  
  public final <K> q<T> x(io.reactivex.g0.j<? super T, K> paramj)
  {
    io.reactivex.h0.a.b.e(paramj, "keySelector is null");
    return io.reactivex.j0.a.n(new io.reactivex.internal.operators.observable.i(this, paramj, io.reactivex.h0.a.b.d()));
  }
  
  public final q<T> x0(io.reactivex.g0.j<? super q<Throwable>, ? extends t<?>> paramj)
  {
    io.reactivex.h0.a.b.e(paramj, "handler is null");
    return io.reactivex.j0.a.n(new q0(this, paramj));
  }
  
  public final q<T> y(io.reactivex.g0.a parama)
  {
    io.reactivex.h0.a.b.e(parama, "onFinally is null");
    return io.reactivex.j0.a.n(new io.reactivex.internal.operators.observable.j(this, parama));
  }
  
  public final void y0(v<? super T> paramv)
  {
    io.reactivex.h0.a.b.e(paramv, "observer is null");
    if ((paramv instanceof io.reactivex.observers.c)) {
      a(paramv);
    } else {
      a(new io.reactivex.observers.c(paramv));
    }
  }
  
  public final q<T> z(io.reactivex.g0.a parama)
  {
    return B(io.reactivex.h0.a.a.f(), io.reactivex.h0.a.a.f(), parama, io.reactivex.h0.a.a.c);
  }
  
  public final <R> q<R> z0(R paramR, io.reactivex.g0.c<R, ? super T, R> paramc)
  {
    io.reactivex.h0.a.b.e(paramR, "initialValue is null");
    return A0(io.reactivex.h0.a.a.h(paramR), paramc);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */