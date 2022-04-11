package io.reactivex.internal.operators.observable;

import io.reactivex.e0.c;
import io.reactivex.h0.b.d;
import io.reactivex.h0.b.e;
import io.reactivex.h0.b.i;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.t;
import io.reactivex.v;

public final class j<T>
  extends a<T, T>
{
  final io.reactivex.g0.a d;
  
  public j(t<T> paramt, io.reactivex.g0.a parama)
  {
    super(paramt);
    this.d = parama;
  }
  
  protected void K0(v<? super T> paramv)
  {
    this.c.a(new a(paramv, this.d));
  }
  
  static final class a<T>
    extends BasicIntQueueDisposable<T>
    implements v<T>
  {
    final v<? super T> c;
    final io.reactivex.g0.a d;
    c f;
    d<T> q;
    boolean x;
    
    a(v<? super T> paramv, io.reactivex.g0.a parama)
    {
      this.c = paramv;
      this.d = parama;
    }
    
    /* Error */
    void a()
    {
      // Byte code:
      //   0: aload_0
      //   1: iconst_0
      //   2: iconst_1
      //   3: invokevirtual 40	java/util/concurrent/atomic/AtomicInteger:compareAndSet	(II)Z
      //   6: ifeq +24 -> 30
      //   9: aload_0
      //   10: getfield 31	io/reactivex/internal/operators/observable/j$a:d	Lio/reactivex/g0/a;
      //   13: invokeinterface 45 1 0
      //   18: goto +12 -> 30
      //   21: astore_1
      //   22: aload_1
      //   23: invokestatic 51	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
      //   26: aload_1
      //   27: invokestatic 56	io/reactivex/j0/a:r	(Ljava/lang/Throwable;)V
      //   30: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	31	0	this	a
      //   21	6	1	localThrowable	Throwable
      // Exception table:
      //   from	to	target	type
      //   9	18	21	finally
    }
    
    public void clear()
    {
      this.q.clear();
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
    
    public boolean isEmpty()
    {
      return this.q.isEmpty();
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
    
    public void onNext(T paramT)
    {
      this.c.onNext(paramT);
    }
    
    public void onSubscribe(c paramc)
    {
      if (DisposableHelper.validate(this.f, paramc))
      {
        this.f = paramc;
        if ((paramc instanceof d)) {
          this.q = ((d)paramc);
        }
        this.c.onSubscribe(this);
      }
    }
    
    public T poll()
      throws Exception
    {
      Object localObject = this.q.poll();
      if ((localObject == null) && (this.x)) {
        a();
      }
      return (T)localObject;
    }
    
    public int requestFusion(int paramInt)
    {
      d locald = this.q;
      boolean bool = false;
      if ((locald != null) && ((paramInt & 0x4) == 0))
      {
        paramInt = locald.requestFusion(paramInt);
        if (paramInt != 0)
        {
          if (paramInt == 1) {
            bool = true;
          }
          this.x = bool;
        }
        return paramInt;
      }
      return 0;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\observable\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */