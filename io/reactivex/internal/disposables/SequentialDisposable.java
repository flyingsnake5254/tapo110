package io.reactivex.internal.disposables;

import io.reactivex.e0.c;
import java.util.concurrent.atomic.AtomicReference;

public final class SequentialDisposable
  extends AtomicReference<c>
  implements c
{
  private static final long serialVersionUID = -754898800686245608L;
  
  public SequentialDisposable() {}
  
  public SequentialDisposable(c paramc)
  {
    lazySet(paramc);
  }
  
  public void dispose()
  {
    DisposableHelper.dispose(this);
  }
  
  public boolean isDisposed()
  {
    return DisposableHelper.isDisposed((c)get());
  }
  
  public boolean replace(c paramc)
  {
    return DisposableHelper.replace(this, paramc);
  }
  
  public boolean update(c paramc)
  {
    return DisposableHelper.set(this, paramc);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\disposables\SequentialDisposable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */