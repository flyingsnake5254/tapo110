package io.reactivex.internal.disposables;

import io.reactivex.e0.c;
import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.h0.a.b;
import io.reactivex.j0.a;
import java.util.concurrent.atomic.AtomicReference;

public enum DisposableHelper
  implements c
{
  static
  {
    DisposableHelper localDisposableHelper = new DisposableHelper("DISPOSED", 0);
    DISPOSED = localDisposableHelper;
    $VALUES = new DisposableHelper[] { localDisposableHelper };
  }
  
  public static boolean dispose(AtomicReference<c> paramAtomicReference)
  {
    c localc = (c)paramAtomicReference.get();
    DisposableHelper localDisposableHelper = DISPOSED;
    if (localc != localDisposableHelper)
    {
      paramAtomicReference = (c)paramAtomicReference.getAndSet(localDisposableHelper);
      if (paramAtomicReference != localDisposableHelper)
      {
        if (paramAtomicReference != null) {
          paramAtomicReference.dispose();
        }
        return true;
      }
    }
    return false;
  }
  
  public static boolean isDisposed(c paramc)
  {
    boolean bool;
    if (paramc == DISPOSED) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static boolean replace(AtomicReference<c> paramAtomicReference, c paramc)
  {
    c localc;
    do
    {
      localc = (c)paramAtomicReference.get();
      if (localc == DISPOSED)
      {
        if (paramc != null) {
          paramc.dispose();
        }
        return false;
      }
    } while (!paramAtomicReference.compareAndSet(localc, paramc));
    return true;
  }
  
  public static void reportDisposableSet()
  {
    a.r(new ProtocolViolationException("Disposable already set!"));
  }
  
  public static boolean set(AtomicReference<c> paramAtomicReference, c paramc)
  {
    c localc;
    do
    {
      localc = (c)paramAtomicReference.get();
      if (localc == DISPOSED)
      {
        if (paramc != null) {
          paramc.dispose();
        }
        return false;
      }
    } while (!paramAtomicReference.compareAndSet(localc, paramc));
    if (localc != null) {
      localc.dispose();
    }
    return true;
  }
  
  public static boolean setOnce(AtomicReference<c> paramAtomicReference, c paramc)
  {
    b.e(paramc, "d is null");
    if (!paramAtomicReference.compareAndSet(null, paramc))
    {
      paramc.dispose();
      if (paramAtomicReference.get() != DISPOSED) {
        reportDisposableSet();
      }
      return false;
    }
    return true;
  }
  
  public static boolean trySet(AtomicReference<c> paramAtomicReference, c paramc)
  {
    if (!paramAtomicReference.compareAndSet(null, paramc))
    {
      if (paramAtomicReference.get() == DISPOSED) {
        paramc.dispose();
      }
      return false;
    }
    return true;
  }
  
  public static boolean validate(c paramc1, c paramc2)
  {
    if (paramc2 == null)
    {
      a.r(new NullPointerException("next is null"));
      return false;
    }
    if (paramc1 != null)
    {
      paramc2.dispose();
      reportDisposableSet();
      return false;
    }
    return true;
  }
  
  public void dispose() {}
  
  public boolean isDisposed()
  {
    return true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\disposables\DisposableHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */