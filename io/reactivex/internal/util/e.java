package io.reactivex.internal.util;

import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class e
{
  public static final Throwable a = new a();
  
  public static <T> boolean a(AtomicReference<Throwable> paramAtomicReference, Throwable paramThrowable)
  {
    Throwable localThrowable;
    Object localObject;
    do
    {
      localThrowable = (Throwable)paramAtomicReference.get();
      if (localThrowable == a) {
        return false;
      }
      if (localThrowable == null) {
        localObject = paramThrowable;
      } else {
        localObject = new CompositeException(new Throwable[] { localThrowable, paramThrowable });
      }
    } while (!paramAtomicReference.compareAndSet(localThrowable, localObject));
    return true;
  }
  
  public static <T> Throwable b(AtomicReference<Throwable> paramAtomicReference)
  {
    Throwable localThrowable1 = (Throwable)paramAtomicReference.get();
    Throwable localThrowable2 = a;
    Throwable localThrowable3 = localThrowable1;
    if (localThrowable1 != localThrowable2) {
      localThrowable3 = (Throwable)paramAtomicReference.getAndSet(localThrowable2);
    }
    return localThrowable3;
  }
  
  public static <E extends Throwable> Exception c(Throwable paramThrowable)
    throws Throwable
  {
    if ((paramThrowable instanceof Exception)) {
      return (Exception)paramThrowable;
    }
    throw paramThrowable;
  }
  
  public static String d(long paramLong, TimeUnit paramTimeUnit)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("The source did not signal an event for ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramTimeUnit.toString().toLowerCase());
    localStringBuilder.append(" and has been terminated.");
    return localStringBuilder.toString();
  }
  
  public static RuntimeException e(Throwable paramThrowable)
  {
    if (!(paramThrowable instanceof Error))
    {
      if ((paramThrowable instanceof RuntimeException)) {
        return (RuntimeException)paramThrowable;
      }
      return new RuntimeException(paramThrowable);
    }
    throw ((Error)paramThrowable);
  }
  
  static final class a
    extends Throwable
  {
    a()
    {
      super();
    }
    
    public Throwable fillInStackTrace()
    {
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\util\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */