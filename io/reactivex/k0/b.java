package io.reactivex.k0;

import e.b.c;
import io.reactivex.h;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.k;

final class b<T>
  extends a<T>
{
  final a<T> d;
  boolean f;
  io.reactivex.internal.util.a<Object> q;
  volatile boolean x;
  
  b(a<T> parama)
  {
    this.d = parama;
  }
  
  protected void H(e.b.b<? super T> paramb)
  {
    this.d.a(paramb);
  }
  
  void N()
  {
    for (;;)
    {
      try
      {
        io.reactivex.internal.util.a locala = this.q;
        if (locala == null)
        {
          this.f = false;
          return;
        }
        this.q = null;
        locala.b(this.d);
      }
      finally {}
    }
  }
  
  public void onComplete()
  {
    if (this.x) {
      return;
    }
    try
    {
      if (this.x) {
        return;
      }
      this.x = true;
      if (this.f)
      {
        io.reactivex.internal.util.a locala1 = this.q;
        io.reactivex.internal.util.a locala2 = locala1;
        if (locala1 == null)
        {
          locala2 = new io/reactivex/internal/util/a;
          locala2.<init>(4);
          this.q = locala2;
        }
        locala2.c(NotificationLite.complete());
        return;
      }
      this.f = true;
      this.d.onComplete();
      return;
    }
    finally {}
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (this.x)
    {
      io.reactivex.j0.a.r(paramThrowable);
      return;
    }
    try
    {
      boolean bool = this.x;
      int i = 1;
      if (!bool)
      {
        this.x = true;
        if (this.f)
        {
          io.reactivex.internal.util.a locala1 = this.q;
          io.reactivex.internal.util.a locala2 = locala1;
          if (locala1 == null)
          {
            locala2 = new io/reactivex/internal/util/a;
            locala2.<init>(4);
            this.q = locala2;
          }
          locala2.e(NotificationLite.error(paramThrowable));
          return;
        }
        this.f = true;
        i = 0;
      }
      if (i != 0)
      {
        io.reactivex.j0.a.r(paramThrowable);
        return;
      }
      this.d.onError(paramThrowable);
      return;
    }
    finally {}
  }
  
  public void onNext(T paramT)
  {
    if (this.x) {
      return;
    }
    try
    {
      if (this.x) {
        return;
      }
      if (this.f)
      {
        io.reactivex.internal.util.a locala1 = this.q;
        io.reactivex.internal.util.a locala2 = locala1;
        if (locala1 == null)
        {
          locala2 = new io/reactivex/internal/util/a;
          locala2.<init>(4);
          this.q = locala2;
        }
        locala2.c(NotificationLite.next(paramT));
        return;
      }
      this.f = true;
      this.d.onNext(paramT);
      N();
      return;
    }
    finally {}
  }
  
  public void onSubscribe(c paramc)
  {
    boolean bool = this.x;
    int i = 1;
    int j = 1;
    if (!bool) {
      try
      {
        if (this.x)
        {
          i = j;
        }
        else
        {
          if (this.f)
          {
            io.reactivex.internal.util.a locala1 = this.q;
            io.reactivex.internal.util.a locala2 = locala1;
            if (locala1 == null)
            {
              locala2 = new io/reactivex/internal/util/a;
              locala2.<init>(4);
              this.q = locala2;
            }
            locala2.c(NotificationLite.subscription(paramc));
            return;
          }
          this.f = true;
          i = 0;
        }
      }
      finally {}
    }
    if (i != 0)
    {
      paramc.cancel();
    }
    else
    {
      this.d.onSubscribe(paramc);
      N();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\k0\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */