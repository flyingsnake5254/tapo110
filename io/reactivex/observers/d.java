package io.reactivex.observers;

import io.reactivex.e0.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.v;

public final class d<T>
  implements v<T>, c
{
  final v<? super T> c;
  final boolean d;
  c f;
  boolean q;
  io.reactivex.internal.util.a<Object> x;
  volatile boolean y;
  
  public d(v<? super T> paramv)
  {
    this(paramv, false);
  }
  
  public d(v<? super T> paramv, boolean paramBoolean)
  {
    this.c = paramv;
    this.d = paramBoolean;
  }
  
  void a()
  {
    for (;;)
    {
      try
      {
        io.reactivex.internal.util.a locala = this.x;
        if (locala == null)
        {
          this.q = false;
          return;
        }
        this.x = null;
        if (!locala.a(this.c)) {
          continue;
        }
        return;
      }
      finally {}
    }
  }
  
  public void dispose()
  {
    this.f.dispose();
  }
  
  public boolean isDisposed()
  {
    return this.f.isDisposed();
  }
  
  public void onComplete()
  {
    if (this.y) {
      return;
    }
    try
    {
      if (this.y) {
        return;
      }
      if (this.q)
      {
        io.reactivex.internal.util.a locala1 = this.x;
        io.reactivex.internal.util.a locala2 = locala1;
        if (locala1 == null)
        {
          locala2 = new io/reactivex/internal/util/a;
          locala2.<init>(4);
          this.x = locala2;
        }
        locala2.c(NotificationLite.complete());
        return;
      }
      this.y = true;
      this.q = true;
      this.c.onComplete();
      return;
    }
    finally {}
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (this.y)
    {
      io.reactivex.j0.a.r(paramThrowable);
      return;
    }
    try
    {
      boolean bool = this.y;
      int i = 1;
      if (!bool)
      {
        if (this.q)
        {
          this.y = true;
          io.reactivex.internal.util.a locala1 = this.x;
          io.reactivex.internal.util.a locala2 = locala1;
          if (locala1 == null)
          {
            locala2 = new io/reactivex/internal/util/a;
            locala2.<init>(4);
            this.x = locala2;
          }
          paramThrowable = NotificationLite.error(paramThrowable);
          if (this.d) {
            locala2.c(paramThrowable);
          } else {
            locala2.e(paramThrowable);
          }
          return;
        }
        this.y = true;
        this.q = true;
        i = 0;
      }
      if (i != 0)
      {
        io.reactivex.j0.a.r(paramThrowable);
        return;
      }
      this.c.onError(paramThrowable);
      return;
    }
    finally {}
  }
  
  public void onNext(T paramT)
  {
    if (this.y) {
      return;
    }
    if (paramT == null)
    {
      this.f.dispose();
      onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
      return;
    }
    try
    {
      if (this.y) {
        return;
      }
      if (this.q)
      {
        io.reactivex.internal.util.a locala1 = this.x;
        io.reactivex.internal.util.a locala2 = locala1;
        if (locala1 == null)
        {
          locala2 = new io/reactivex/internal/util/a;
          locala2.<init>(4);
          this.x = locala2;
        }
        locala2.c(NotificationLite.next(paramT));
        return;
      }
      this.q = true;
      this.c.onNext(paramT);
      a();
      return;
    }
    finally {}
  }
  
  public void onSubscribe(c paramc)
  {
    if (DisposableHelper.validate(this.f, paramc))
    {
      this.f = paramc;
      this.c.onSubscribe(this);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\observers\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */