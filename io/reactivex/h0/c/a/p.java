package io.reactivex.h0.c.a;

import io.reactivex.e0.b;
import io.reactivex.w;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

public final class p
  extends io.reactivex.a
{
  final io.reactivex.e c;
  final long d;
  final TimeUnit f;
  final w q;
  final io.reactivex.e x;
  
  public p(io.reactivex.e parame1, long paramLong, TimeUnit paramTimeUnit, w paramw, io.reactivex.e parame2)
  {
    this.c = parame1;
    this.d = paramLong;
    this.f = paramTimeUnit;
    this.q = paramw;
    this.x = parame2;
  }
  
  public void B(io.reactivex.c paramc)
  {
    b localb = new b();
    paramc.onSubscribe(localb);
    AtomicBoolean localAtomicBoolean = new AtomicBoolean();
    localb.b(this.q.d(new a(localAtomicBoolean, localb, paramc), this.d, this.f));
    this.c.a(new b(localb, localAtomicBoolean, paramc));
  }
  
  final class a
    implements Runnable
  {
    private final AtomicBoolean c;
    final b d;
    final io.reactivex.c f;
    
    a(AtomicBoolean paramAtomicBoolean, b paramb, io.reactivex.c paramc)
    {
      this.c = paramAtomicBoolean;
      this.d = paramb;
      this.f = paramc;
    }
    
    public void run()
    {
      if (this.c.compareAndSet(false, true))
      {
        this.d.d();
        Object localObject = p.this.x;
        if (localObject == null)
        {
          io.reactivex.c localc = this.f;
          localObject = p.this;
          localc.onError(new TimeoutException(io.reactivex.internal.util.e.d(((p)localObject).d, ((p)localObject).f)));
        }
        else
        {
          ((io.reactivex.e)localObject).a(new a());
        }
      }
    }
    
    final class a
      implements io.reactivex.c
    {
      a() {}
      
      public void onComplete()
      {
        p.a.this.d.dispose();
        p.a.this.f.onComplete();
      }
      
      public void onError(Throwable paramThrowable)
      {
        p.a.this.d.dispose();
        p.a.this.f.onError(paramThrowable);
      }
      
      public void onSubscribe(io.reactivex.e0.c paramc)
      {
        p.a.this.d.b(paramc);
      }
    }
  }
  
  static final class b
    implements io.reactivex.c
  {
    private final b c;
    private final AtomicBoolean d;
    private final io.reactivex.c f;
    
    b(b paramb, AtomicBoolean paramAtomicBoolean, io.reactivex.c paramc)
    {
      this.c = paramb;
      this.d = paramAtomicBoolean;
      this.f = paramc;
    }
    
    public void onComplete()
    {
      if (this.d.compareAndSet(false, true))
      {
        this.c.dispose();
        this.f.onComplete();
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.d.compareAndSet(false, true))
      {
        this.c.dispose();
        this.f.onError(paramThrowable);
      }
      else
      {
        io.reactivex.j0.a.r(paramThrowable);
      }
    }
    
    public void onSubscribe(io.reactivex.e0.c paramc)
    {
      this.c.b(paramc);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\h0\c\a\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */