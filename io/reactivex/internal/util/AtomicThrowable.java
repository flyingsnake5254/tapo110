package io.reactivex.internal.util;

import java.util.concurrent.atomic.AtomicReference;

public final class AtomicThrowable
  extends AtomicReference<Throwable>
{
  private static final long serialVersionUID = 3949248817947090603L;
  
  public boolean addThrowable(Throwable paramThrowable)
  {
    return e.a(this, paramThrowable);
  }
  
  public boolean isTerminated()
  {
    boolean bool;
    if (get() == e.a) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public Throwable terminate()
  {
    return e.b(this);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\util\AtomicThrowable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */