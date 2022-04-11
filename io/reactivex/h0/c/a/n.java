package io.reactivex.h0.c.a;

import io.reactivex.e;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.g0.j;
import io.reactivex.h0.a.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class n
  extends io.reactivex.a
{
  final e c;
  final j<? super Throwable, ? extends e> d;
  
  public n(e parame, j<? super Throwable, ? extends e> paramj)
  {
    this.c = parame;
    this.d = paramj;
  }
  
  protected void B(io.reactivex.c paramc)
  {
    a locala = new a(paramc, this.d);
    paramc.onSubscribe(locala);
    this.c.a(locala);
  }
  
  static final class a
    extends AtomicReference<io.reactivex.e0.c>
    implements io.reactivex.c, io.reactivex.e0.c
  {
    final io.reactivex.c c;
    final j<? super Throwable, ? extends e> d;
    boolean f;
    
    a(io.reactivex.c paramc, j<? super Throwable, ? extends e> paramj)
    {
      this.c = paramc;
      this.d = paramj;
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
      this.c.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.f)
      {
        this.c.onError(paramThrowable);
        return;
      }
      this.f = true;
      try
      {
        e locale = (e)b.e(this.d.apply(paramThrowable), "The errorMapper returned a null CompletableSource");
        locale.a(this);
        return;
      }
      finally
      {
        io.reactivex.exceptions.a.b(localThrowable);
        this.c.onError(new CompositeException(new Throwable[] { paramThrowable, localThrowable }));
      }
    }
    
    public void onSubscribe(io.reactivex.e0.c paramc)
    {
      DisposableHelper.replace(this, paramc);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\h0\c\a\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */