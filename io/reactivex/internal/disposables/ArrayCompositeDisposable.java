package io.reactivex.internal.disposables;

import io.reactivex.e0.c;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class ArrayCompositeDisposable
  extends AtomicReferenceArray<c>
  implements c
{
  private static final long serialVersionUID = 2746389416410565408L;
  
  public ArrayCompositeDisposable(int paramInt)
  {
    super(paramInt);
  }
  
  public void dispose()
  {
    int i = 0;
    if (get(0) != DisposableHelper.DISPOSED)
    {
      int j = length();
      while (i < j)
      {
        c localc = (c)get(i);
        DisposableHelper localDisposableHelper = DisposableHelper.DISPOSED;
        if (localc != localDisposableHelper)
        {
          localc = (c)getAndSet(i, localDisposableHelper);
          if ((localc != localDisposableHelper) && (localc != null)) {
            localc.dispose();
          }
        }
        i++;
      }
    }
  }
  
  public boolean isDisposed()
  {
    boolean bool = false;
    if (get(0) == DisposableHelper.DISPOSED) {
      bool = true;
    }
    return bool;
  }
  
  public c replaceResource(int paramInt, c paramc)
  {
    c localc;
    do
    {
      localc = (c)get(paramInt);
      if (localc == DisposableHelper.DISPOSED)
      {
        paramc.dispose();
        return null;
      }
    } while (!compareAndSet(paramInt, localc, paramc));
    return localc;
  }
  
  public boolean setResource(int paramInt, c paramc)
  {
    c localc;
    do
    {
      localc = (c)get(paramInt);
      if (localc == DisposableHelper.DISPOSED)
      {
        paramc.dispose();
        return false;
      }
    } while (!compareAndSet(paramInt, localc, paramc));
    if (localc != null) {
      localc.dispose();
    }
    return true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\disposables\ArrayCompositeDisposable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */