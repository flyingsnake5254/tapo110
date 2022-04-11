package io.reactivex.observers;

import io.reactivex.e0.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.d;
import io.reactivex.v;
import java.util.concurrent.atomic.AtomicReference;

public abstract class b<T>
  implements v<T>, c
{
  final AtomicReference<c> c = new AtomicReference();
  
  protected void a() {}
  
  public final void dispose()
  {
    DisposableHelper.dispose(this.c);
  }
  
  public final boolean isDisposed()
  {
    boolean bool;
    if (this.c.get() == DisposableHelper.DISPOSED) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final void onSubscribe(c paramc)
  {
    if (d.c(this.c, paramc, getClass())) {
      a();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\observers\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */