package io.reactivex.h0.c.a;

import io.reactivex.a;
import io.reactivex.c;
import io.reactivex.internal.disposables.EmptyDisposable;

public final class e
  extends a
{
  final Throwable c;
  
  public e(Throwable paramThrowable)
  {
    this.c = paramThrowable;
  }
  
  protected void B(c paramc)
  {
    EmptyDisposable.error(this.c, paramc);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\h0\c\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */