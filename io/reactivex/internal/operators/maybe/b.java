package io.reactivex.internal.operators.maybe;

import io.reactivex.e0.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.n;
import io.reactivex.o;
import java.util.concurrent.atomic.AtomicInteger;

public final class b<T>
  extends a<T, T>
{
  final io.reactivex.g0.a d;
  
  public b(o<T> paramo, io.reactivex.g0.a parama)
  {
    super(paramo);
    this.d = parama;
  }
  
  protected void n(n<? super T> paramn)
  {
    this.c.a(new a(paramn, this.d));
  }
  
  static final class a<T>
    extends AtomicInteger
    implements n<T>, c
  {
    final n<? super T> c;
    final io.reactivex.g0.a d;
    c f;
    
    a(n<? super T> paramn, io.reactivex.g0.a parama)
    {
      this.c = paramn;
      this.d = parama;
    }
    
    /* Error */
    void a()
    {
      // Byte code:
      //   0: aload_0
      //   1: iconst_0
      //   2: iconst_1
      //   3: invokevirtual 35	java/util/concurrent/atomic/AtomicInteger:compareAndSet	(II)Z
      //   6: ifeq +24 -> 30
      //   9: aload_0
      //   10: getfield 28	io/reactivex/internal/operators/maybe/b$a:d	Lio/reactivex/g0/a;
      //   13: invokeinterface 40 1 0
      //   18: goto +12 -> 30
      //   21: astore_1
      //   22: aload_1
      //   23: invokestatic 46	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
      //   26: aload_1
      //   27: invokestatic 51	io/reactivex/j0/a:r	(Ljava/lang/Throwable;)V
      //   30: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	31	0	this	a
      //   21	6	1	localThrowable	Throwable
      // Exception table:
      //   from	to	target	type
      //   9	18	21	finally
    }
    
    public void dispose()
    {
      this.f.dispose();
      a();
    }
    
    public boolean isDisposed()
    {
      return this.f.isDisposed();
    }
    
    public void onComplete()
    {
      this.c.onComplete();
      a();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.c.onError(paramThrowable);
      a();
    }
    
    public void onSubscribe(c paramc)
    {
      if (DisposableHelper.validate(this.f, paramc))
      {
        this.f = paramc;
        this.c.onSubscribe(this);
      }
    }
    
    public void onSuccess(T paramT)
    {
      this.c.onSuccess(paramT);
      a();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\maybe\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */