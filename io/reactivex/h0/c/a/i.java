package io.reactivex.h0.c.a;

import io.reactivex.e;
import io.reactivex.e0.b;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;

public final class i
  extends io.reactivex.a
{
  final e[] c;
  
  public i(e[] paramArrayOfe)
  {
    this.c = paramArrayOfe;
  }
  
  public void B(io.reactivex.c paramc)
  {
    Object localObject = new b();
    AtomicInteger localAtomicInteger = new AtomicInteger(this.c.length + 1);
    AtomicThrowable localAtomicThrowable = new AtomicThrowable();
    paramc.onSubscribe((io.reactivex.e0.c)localObject);
    for (e locale : this.c)
    {
      if (((b)localObject).isDisposed()) {
        return;
      }
      if (locale == null)
      {
        localAtomicThrowable.addThrowable(new NullPointerException("A completable source is null"));
        localAtomicInteger.decrementAndGet();
      }
      else
      {
        locale.a(new a(paramc, (b)localObject, localAtomicThrowable, localAtomicInteger));
      }
    }
    if (localAtomicInteger.decrementAndGet() == 0)
    {
      localObject = localAtomicThrowable.terminate();
      if (localObject == null) {
        paramc.onComplete();
      } else {
        paramc.onError((Throwable)localObject);
      }
    }
  }
  
  static final class a
    implements io.reactivex.c
  {
    final io.reactivex.c c;
    final b d;
    final AtomicThrowable f;
    final AtomicInteger q;
    
    a(io.reactivex.c paramc, b paramb, AtomicThrowable paramAtomicThrowable, AtomicInteger paramAtomicInteger)
    {
      this.c = paramc;
      this.d = paramb;
      this.f = paramAtomicThrowable;
      this.q = paramAtomicInteger;
    }
    
    void a()
    {
      if (this.q.decrementAndGet() == 0)
      {
        Throwable localThrowable = this.f.terminate();
        if (localThrowable == null) {
          this.c.onComplete();
        } else {
          this.c.onError(localThrowable);
        }
      }
    }
    
    public void onComplete()
    {
      a();
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.f.addThrowable(paramThrowable)) {
        a();
      } else {
        io.reactivex.j0.a.r(paramThrowable);
      }
    }
    
    public void onSubscribe(io.reactivex.e0.c paramc)
    {
      this.d.b(paramc);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\h0\c\a\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */