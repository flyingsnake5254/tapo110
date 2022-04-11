package io.reactivex.internal.util;

import io.reactivex.h0.b.h;
import io.reactivex.h0.b.i;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.b;
import io.reactivex.v;

public final class j
{
  public static <T, U> boolean a(boolean paramBoolean1, boolean paramBoolean2, v<?> paramv, boolean paramBoolean3, i<?> parami, io.reactivex.e0.c paramc, g<T, U> paramg)
  {
    if (paramg.d())
    {
      parami.clear();
      paramc.dispose();
      return true;
    }
    if (paramBoolean1) {
      if (paramBoolean3)
      {
        if (paramBoolean2)
        {
          if (paramc != null) {
            paramc.dispose();
          }
          parami = paramg.e();
          if (parami != null) {
            paramv.onError(parami);
          } else {
            paramv.onComplete();
          }
          return true;
        }
      }
      else
      {
        paramg = paramg.e();
        if (paramg != null)
        {
          parami.clear();
          if (paramc != null) {
            paramc.dispose();
          }
          paramv.onError(paramg);
          return true;
        }
        if (paramBoolean2)
        {
          if (paramc != null) {
            paramc.dispose();
          }
          paramv.onComplete();
          return true;
        }
      }
    }
    return false;
  }
  
  public static <T> i<T> b(int paramInt)
  {
    if (paramInt < 0) {
      return new b(-paramInt);
    }
    return new SpscArrayQueue(paramInt);
  }
  
  public static <T, U> void c(h<T> paramh, v<? super U> paramv, boolean paramBoolean, io.reactivex.e0.c paramc, g<T, U> paramg)
  {
    int i = 1;
    if (a(paramg.c(), paramh.isEmpty(), paramv, paramBoolean, paramh, paramc, paramg)) {
      return;
    }
    for (;;)
    {
      boolean bool1 = paramg.c();
      Object localObject = paramh.poll();
      boolean bool2;
      if (localObject == null) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      if (a(bool1, bool2, paramv, paramBoolean, paramh, paramc, paramg)) {
        return;
      }
      if (bool2)
      {
        int j = paramg.b(-i);
        i = j;
        if (j != 0) {
          break;
        }
        return;
      }
      paramg.a(paramv, localObject);
    }
  }
  
  public static void d(e.b.c paramc, int paramInt)
  {
    long l;
    if (paramInt < 0) {
      l = Long.MAX_VALUE;
    } else {
      l = paramInt;
    }
    paramc.request(l);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\util\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */