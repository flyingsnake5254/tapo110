package io.reactivex.internal.util;

import e.b.b;
import io.reactivex.j0.a;
import io.reactivex.v;
import java.util.concurrent.atomic.AtomicInteger;

public final class f
{
  public static void a(v<?> paramv, AtomicInteger paramAtomicInteger, AtomicThrowable paramAtomicThrowable)
  {
    if (paramAtomicInteger.getAndIncrement() == 0)
    {
      paramAtomicInteger = paramAtomicThrowable.terminate();
      if (paramAtomicInteger != null) {
        paramv.onError(paramAtomicInteger);
      } else {
        paramv.onComplete();
      }
    }
  }
  
  public static void b(b<?> paramb, AtomicInteger paramAtomicInteger, AtomicThrowable paramAtomicThrowable)
  {
    if (paramAtomicInteger.getAndIncrement() == 0)
    {
      paramAtomicInteger = paramAtomicThrowable.terminate();
      if (paramAtomicInteger != null) {
        paramb.onError(paramAtomicInteger);
      } else {
        paramb.onComplete();
      }
    }
  }
  
  public static void c(v<?> paramv, Throwable paramThrowable, AtomicInteger paramAtomicInteger, AtomicThrowable paramAtomicThrowable)
  {
    if (paramAtomicThrowable.addThrowable(paramThrowable))
    {
      if (paramAtomicInteger.getAndIncrement() == 0) {
        paramv.onError(paramAtomicThrowable.terminate());
      }
    }
    else {
      a.r(paramThrowable);
    }
  }
  
  public static void d(b<?> paramb, Throwable paramThrowable, AtomicInteger paramAtomicInteger, AtomicThrowable paramAtomicThrowable)
  {
    if (paramAtomicThrowable.addThrowable(paramThrowable))
    {
      if (paramAtomicInteger.getAndIncrement() == 0) {
        paramb.onError(paramAtomicThrowable.terminate());
      }
    }
    else {
      a.r(paramThrowable);
    }
  }
  
  public static <T> void e(v<? super T> paramv, T paramT, AtomicInteger paramAtomicInteger, AtomicThrowable paramAtomicThrowable)
  {
    if ((paramAtomicInteger.get() == 0) && (paramAtomicInteger.compareAndSet(0, 1)))
    {
      paramv.onNext(paramT);
      if (paramAtomicInteger.decrementAndGet() != 0)
      {
        paramT = paramAtomicThrowable.terminate();
        if (paramT != null) {
          paramv.onError(paramT);
        } else {
          paramv.onComplete();
        }
      }
    }
  }
  
  public static <T> void f(b<? super T> paramb, T paramT, AtomicInteger paramAtomicInteger, AtomicThrowable paramAtomicThrowable)
  {
    if ((paramAtomicInteger.get() == 0) && (paramAtomicInteger.compareAndSet(0, 1)))
    {
      paramb.onNext(paramT);
      if (paramAtomicInteger.decrementAndGet() != 0)
      {
        paramT = paramAtomicThrowable.terminate();
        if (paramT != null) {
          paramb.onError(paramT);
        } else {
          paramb.onComplete();
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\util\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */