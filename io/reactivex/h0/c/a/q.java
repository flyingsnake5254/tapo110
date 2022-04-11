package io.reactivex.h0.c.a;

import io.reactivex.a;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.w;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class q
  extends a
{
  final long c;
  final TimeUnit d;
  final w f;
  
  public q(long paramLong, TimeUnit paramTimeUnit, w paramw)
  {
    this.c = paramLong;
    this.d = paramTimeUnit;
    this.f = paramw;
  }
  
  protected void B(io.reactivex.c paramc)
  {
    a locala = new a(paramc);
    paramc.onSubscribe(locala);
    locala.a(this.f.d(locala, this.c, this.d));
  }
  
  static final class a
    extends AtomicReference<io.reactivex.e0.c>
    implements io.reactivex.e0.c, Runnable
  {
    final io.reactivex.c c;
    
    a(io.reactivex.c paramc)
    {
      this.c = paramc;
    }
    
    void a(io.reactivex.e0.c paramc)
    {
      DisposableHelper.replace(this, paramc);
    }
    
    public void dispose()
    {
      DisposableHelper.dispose(this);
    }
    
    public boolean isDisposed()
    {
      return DisposableHelper.isDisposed((io.reactivex.e0.c)get());
    }
    
    public void run()
    {
      this.c.onComplete();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\h0\c\a\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */