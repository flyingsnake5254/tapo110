package io.reactivex.internal.util;

import io.reactivex.e0.c;
import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.h0.a.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.j0.a;
import java.util.concurrent.atomic.AtomicReference;

public final class d
{
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("It is not allowed to subscribe with a(n) ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" multiple times. Please create a fresh instance of ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" and subscribe that to the target source instead.");
    return localStringBuilder.toString();
  }
  
  public static void b(Class<?> paramClass)
  {
    a.r(new ProtocolViolationException(a(paramClass.getName())));
  }
  
  public static boolean c(AtomicReference<c> paramAtomicReference, c paramc, Class<?> paramClass)
  {
    b.e(paramc, "next is null");
    if (!paramAtomicReference.compareAndSet(null, paramc))
    {
      paramc.dispose();
      if (paramAtomicReference.get() != DisposableHelper.DISPOSED) {
        b(paramClass);
      }
      return false;
    }
    return true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\util\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */