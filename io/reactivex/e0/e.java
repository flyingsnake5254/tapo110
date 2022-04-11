package io.reactivex.e0;

import io.reactivex.h0.a.b;
import java.util.concurrent.atomic.AtomicReference;

abstract class e<T>
  extends AtomicReference<T>
  implements c
{
  e(T paramT)
  {
    super(b.e(paramT, "value is null"));
  }
  
  protected abstract void a(T paramT);
  
  public final void dispose()
  {
    if (get() != null)
    {
      Object localObject = getAndSet(null);
      if (localObject != null) {
        a(localObject);
      }
    }
  }
  
  public final boolean isDisposed()
  {
    boolean bool;
    if (get() == null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\e0\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */