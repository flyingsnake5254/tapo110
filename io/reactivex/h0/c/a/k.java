package io.reactivex.h0.c.a;

import io.reactivex.a;
import io.reactivex.e;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.w;
import java.util.concurrent.atomic.AtomicReference;

public final class k
  extends a
{
  final e c;
  final w d;
  
  public k(e parame, w paramw)
  {
    this.c = parame;
    this.d = paramw;
  }
  
  protected void B(io.reactivex.c paramc)
  {
    this.c.a(new a(paramc, this.d));
  }
  
  static final class a
    extends AtomicReference<io.reactivex.e0.c>
    implements io.reactivex.c, io.reactivex.e0.c, Runnable
  {
    final io.reactivex.c c;
    final w d;
    Throwable f;
    
    a(io.reactivex.c paramc, w paramw)
    {
      this.c = paramc;
      this.d = paramw;
    }
    
    public void dispose()
    {
      DisposableHelper.dispose(this);
    }
    
    public boolean isDisposed()
    {
      return DisposableHelper.isDisposed((io.reactivex.e0.c)get());
    }
    
    public void onComplete()
    {
      DisposableHelper.replace(this, this.d.c(this));
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.f = paramThrowable;
      DisposableHelper.replace(this, this.d.c(this));
    }
    
    public void onSubscribe(io.reactivex.e0.c paramc)
    {
      if (DisposableHelper.setOnce(this, paramc)) {
        this.c.onSubscribe(this);
      }
    }
    
    public void run()
    {
      Throwable localThrowable = this.f;
      if (localThrowable != null)
      {
        this.f = null;
        this.c.onError(localThrowable);
      }
      else
      {
        this.c.onComplete();
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\h0\c\a\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */