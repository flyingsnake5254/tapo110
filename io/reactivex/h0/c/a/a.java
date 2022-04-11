package io.reactivex.h0.c.a;

import io.reactivex.e;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class a
  extends io.reactivex.a
{
  final e c;
  final e d;
  
  public a(e parame1, e parame2)
  {
    this.c = parame1;
    this.d = parame2;
  }
  
  protected void B(io.reactivex.c paramc)
  {
    this.c.a(new b(paramc, this.d));
  }
  
  static final class a
    implements io.reactivex.c
  {
    final AtomicReference<io.reactivex.e0.c> c;
    final io.reactivex.c d;
    
    a(AtomicReference<io.reactivex.e0.c> paramAtomicReference, io.reactivex.c paramc)
    {
      this.c = paramAtomicReference;
      this.d = paramc;
    }
    
    public void onComplete()
    {
      this.d.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.d.onError(paramThrowable);
    }
    
    public void onSubscribe(io.reactivex.e0.c paramc)
    {
      DisposableHelper.replace(this.c, paramc);
    }
  }
  
  static final class b
    extends AtomicReference<io.reactivex.e0.c>
    implements io.reactivex.c, io.reactivex.e0.c
  {
    final io.reactivex.c c;
    final e d;
    
    b(io.reactivex.c paramc, e parame)
    {
      this.c = paramc;
      this.d = parame;
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
      this.d.a(new a.a(this, this.c));
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.c.onError(paramThrowable);
    }
    
    public void onSubscribe(io.reactivex.e0.c paramc)
    {
      if (DisposableHelper.setOnce(this, paramc)) {
        this.c.onSubscribe(this);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\h0\c\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */