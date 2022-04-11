package io.reactivex.h0.c.a;

import io.reactivex.a;
import io.reactivex.e;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.w;
import java.util.concurrent.atomic.AtomicReference;

public final class o
  extends a
{
  final e c;
  final w d;
  
  public o(e parame, w paramw)
  {
    this.c = parame;
    this.d = paramw;
  }
  
  protected void B(io.reactivex.c paramc)
  {
    a locala = new a(paramc, this.c);
    paramc.onSubscribe(locala);
    paramc = this.d.c(locala);
    locala.d.replace(paramc);
  }
  
  static final class a
    extends AtomicReference<io.reactivex.e0.c>
    implements io.reactivex.c, io.reactivex.e0.c, Runnable
  {
    final io.reactivex.c c;
    final SequentialDisposable d;
    final e f;
    
    a(io.reactivex.c paramc, e parame)
    {
      this.c = paramc;
      this.f = parame;
      this.d = new SequentialDisposable();
    }
    
    public void dispose()
    {
      DisposableHelper.dispose(this);
      this.d.dispose();
    }
    
    public boolean isDisposed()
    {
      return DisposableHelper.isDisposed((io.reactivex.e0.c)get());
    }
    
    public void onComplete()
    {
      this.c.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.c.onError(paramThrowable);
    }
    
    public void onSubscribe(io.reactivex.e0.c paramc)
    {
      DisposableHelper.setOnce(this, paramc);
    }
    
    public void run()
    {
      this.f.a(this);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\h0\c\a\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */