package io.reactivex.m0;

import io.reactivex.e0.c;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.internal.util.a.a;
import io.reactivex.q;
import io.reactivex.v;

final class f<T>
  extends g<T>
  implements a.a<Object>
{
  final g<T> c;
  boolean d;
  io.reactivex.internal.util.a<Object> f;
  volatile boolean q;
  
  f(g<T> paramg)
  {
    this.c = paramg;
  }
  
  protected void K0(v<? super T> paramv)
  {
    this.c.a(paramv);
  }
  
  public boolean j1()
  {
    return this.c.j1();
  }
  
  public boolean k1()
  {
    return this.c.k1();
  }
  
  void m1()
  {
    for (;;)
    {
      try
      {
        io.reactivex.internal.util.a locala = this.f;
        if (locala == null)
        {
          this.d = false;
          return;
        }
        this.f = null;
        locala.d(this);
      }
      finally {}
    }
  }
  
  public void onComplete()
  {
    if (this.q) {
      return;
    }
    try
    {
      if (this.q) {
        return;
      }
      this.q = true;
      if (this.d)
      {
        io.reactivex.internal.util.a locala1 = this.f;
        io.reactivex.internal.util.a locala2 = locala1;
        if (locala1 == null)
        {
          locala2 = new io/reactivex/internal/util/a;
          locala2.<init>(4);
          this.f = locala2;
        }
        locala2.c(NotificationLite.complete());
        return;
      }
      this.d = true;
      this.c.onComplete();
      return;
    }
    finally {}
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (this.q)
    {
      io.reactivex.j0.a.r(paramThrowable);
      return;
    }
    try
    {
      boolean bool = this.q;
      int i = 1;
      if (!bool)
      {
        this.q = true;
        if (this.d)
        {
          io.reactivex.internal.util.a locala1 = this.f;
          io.reactivex.internal.util.a locala2 = locala1;
          if (locala1 == null)
          {
            locala2 = new io/reactivex/internal/util/a;
            locala2.<init>(4);
            this.f = locala2;
          }
          locala2.e(NotificationLite.error(paramThrowable));
          return;
        }
        this.d = true;
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
    if (this.q) {
      return;
    }
    try
    {
      if (this.q) {
        return;
      }
      if (this.d)
      {
        io.reactivex.internal.util.a locala1 = this.f;
        io.reactivex.internal.util.a locala2 = locala1;
        if (locala1 == null)
        {
          locala2 = new io/reactivex/internal/util/a;
          locala2.<init>(4);
          this.f = locala2;
        }
        locala2.c(NotificationLite.next(paramT));
        return;
      }
      this.d = true;
      this.c.onNext(paramT);
      m1();
      return;
    }
    finally {}
  }
  
  public void onSubscribe(c paramc)
  {
    boolean bool = this.q;
    int i = 1;
    int j = 1;
    if (!bool) {
      try
      {
        if (this.q)
        {
          i = j;
        }
        else
        {
          if (this.d)
          {
            io.reactivex.internal.util.a locala1 = this.f;
            io.reactivex.internal.util.a locala2 = locala1;
            if (locala1 == null)
            {
              locala2 = new io/reactivex/internal/util/a;
              locala2.<init>(4);
              this.f = locala2;
            }
            locala2.c(NotificationLite.disposable(paramc));
            return;
          }
          this.d = true;
          i = 0;
        }
      }
      finally {}
    }
    if (i != 0)
    {
      paramc.dispose();
    }
    else
    {
      this.c.onSubscribe(paramc);
      m1();
    }
  }
  
  public boolean test(Object paramObject)
  {
    return NotificationLite.acceptFull(paramObject, this.c);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\m0\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */