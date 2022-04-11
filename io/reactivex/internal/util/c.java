package io.reactivex.internal.util;

import io.reactivex.internal.schedulers.i;
import io.reactivex.j0.a;

public final class c
{
  public static void a()
  {
    if ((a.j()) && (((Thread.currentThread() instanceof i)) || (a.p())))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Attempt to block on a Scheduler ");
      localStringBuilder.append(Thread.currentThread().getName());
      localStringBuilder.append(" that doesn't support blocking operators as they may lead to deadlock");
      throw new IllegalStateException(localStringBuilder.toString());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\util\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */