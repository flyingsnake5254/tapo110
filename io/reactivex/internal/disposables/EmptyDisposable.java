package io.reactivex.internal.disposables;

import io.reactivex.c;
import io.reactivex.h0.b.d;
import io.reactivex.n;
import io.reactivex.v;
import io.reactivex.z;

public enum EmptyDisposable
  implements d<Object>
{
  static
  {
    EmptyDisposable localEmptyDisposable1 = new EmptyDisposable("INSTANCE", 0);
    INSTANCE = localEmptyDisposable1;
    EmptyDisposable localEmptyDisposable2 = new EmptyDisposable("NEVER", 1);
    NEVER = localEmptyDisposable2;
    $VALUES = new EmptyDisposable[] { localEmptyDisposable1, localEmptyDisposable2 };
  }
  
  public static void complete(c paramc)
  {
    paramc.onSubscribe(INSTANCE);
    paramc.onComplete();
  }
  
  public static void complete(n<?> paramn)
  {
    paramn.onSubscribe(INSTANCE);
    paramn.onComplete();
  }
  
  public static void complete(v<?> paramv)
  {
    paramv.onSubscribe(INSTANCE);
    paramv.onComplete();
  }
  
  public static void error(Throwable paramThrowable, c paramc)
  {
    paramc.onSubscribe(INSTANCE);
    paramc.onError(paramThrowable);
  }
  
  public static void error(Throwable paramThrowable, n<?> paramn)
  {
    paramn.onSubscribe(INSTANCE);
    paramn.onError(paramThrowable);
  }
  
  public static void error(Throwable paramThrowable, v<?> paramv)
  {
    paramv.onSubscribe(INSTANCE);
    paramv.onError(paramThrowable);
  }
  
  public static void error(Throwable paramThrowable, z<?> paramz)
  {
    paramz.onSubscribe(INSTANCE);
    paramz.onError(paramThrowable);
  }
  
  public void clear() {}
  
  public void dispose() {}
  
  public boolean isDisposed()
  {
    boolean bool;
    if (this == INSTANCE) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isEmpty()
  {
    return true;
  }
  
  public boolean offer(Object paramObject)
  {
    throw new UnsupportedOperationException("Should not be called!");
  }
  
  public boolean offer(Object paramObject1, Object paramObject2)
  {
    throw new UnsupportedOperationException("Should not be called!");
  }
  
  public Object poll()
    throws Exception
  {
    return null;
  }
  
  public int requestFusion(int paramInt)
  {
    return paramInt & 0x2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\disposables\EmptyDisposable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */