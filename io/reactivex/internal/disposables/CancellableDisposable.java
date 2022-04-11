package io.reactivex.internal.disposables;

import io.reactivex.e0.c;
import io.reactivex.g0.f;
import java.util.concurrent.atomic.AtomicReference;

public final class CancellableDisposable
  extends AtomicReference<f>
  implements c
{
  private static final long serialVersionUID = 5718521705281392066L;
  
  public CancellableDisposable(f paramf)
  {
    super(paramf);
  }
  
  public void dispose()
  {
    if (get() != null)
    {
      f localf = (f)getAndSet(null);
      if (localf != null) {
        try
        {
          localf.cancel();
        }
        catch (Exception localException)
        {
          io.reactivex.exceptions.a.b(localException);
          io.reactivex.j0.a.r(localException);
        }
      }
    }
  }
  
  public boolean isDisposed()
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\disposables\CancellableDisposable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */