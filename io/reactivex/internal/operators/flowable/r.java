package io.reactivex.internal.operators.flowable;

import e.b.c;
import io.reactivex.h0.b.i;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.k;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class r<T>
  extends a<T, T>
{
  final int f;
  final boolean q;
  final boolean x;
  final io.reactivex.g0.a y;
  
  public r(io.reactivex.h<T> paramh, int paramInt, boolean paramBoolean1, boolean paramBoolean2, io.reactivex.g0.a parama)
  {
    super(paramh);
    this.f = paramInt;
    this.q = paramBoolean1;
    this.x = paramBoolean2;
    this.y = parama;
  }
  
  protected void H(e.b.b<? super T> paramb)
  {
    this.d.G(new a(paramb, this.f, this.q, this.x, this.y));
  }
  
  static final class a<T>
    extends BasicIntQueueSubscription<T>
    implements k<T>
  {
    final e.b.b<? super T> c;
    final io.reactivex.h0.b.h<T> d;
    final boolean f;
    Throwable p0;
    final AtomicLong p1 = new AtomicLong();
    boolean p2;
    final io.reactivex.g0.a q;
    c x;
    volatile boolean y;
    volatile boolean z;
    
    a(e.b.b<? super T> paramb, int paramInt, boolean paramBoolean1, boolean paramBoolean2, io.reactivex.g0.a parama)
    {
      this.c = paramb;
      this.q = parama;
      this.f = paramBoolean2;
      if (paramBoolean1) {
        paramb = new io.reactivex.internal.queue.b(paramInt);
      } else {
        paramb = new SpscArrayQueue(paramInt);
      }
      this.d = paramb;
    }
    
    public void cancel()
    {
      if (!this.y)
      {
        this.y = true;
        this.x.cancel();
        if ((!this.p2) && (getAndIncrement() == 0)) {
          this.d.clear();
        }
      }
    }
    
    public void clear()
    {
      this.d.clear();
    }
    
    boolean d(boolean paramBoolean1, boolean paramBoolean2, e.b.b<? super T> paramb)
    {
      if (this.y)
      {
        this.d.clear();
        return true;
      }
      if (paramBoolean1)
      {
        Throwable localThrowable;
        if (this.f)
        {
          if (paramBoolean2)
          {
            localThrowable = this.p0;
            if (localThrowable != null) {
              paramb.onError(localThrowable);
            } else {
              paramb.onComplete();
            }
            return true;
          }
        }
        else
        {
          localThrowable = this.p0;
          if (localThrowable != null)
          {
            this.d.clear();
            paramb.onError(localThrowable);
            return true;
          }
          if (paramBoolean2)
          {
            paramb.onComplete();
            return true;
          }
        }
      }
      return false;
    }
    
    void drain()
    {
      if (getAndIncrement() == 0)
      {
        io.reactivex.h0.b.h localh = this.d;
        e.b.b localb = this.c;
        int i = 1;
        int j;
        do
        {
          if (d(this.z, localh.isEmpty(), localb)) {
            return;
          }
          long l1 = this.p1.get();
          boolean bool1;
          for (long l2 = 0L;; l2 += 1L)
          {
            bool1 = l2 < l1;
            if (!bool1) {
              break;
            }
            boolean bool2 = this.z;
            Object localObject = localh.poll();
            boolean bool3;
            if (localObject == null) {
              bool3 = true;
            } else {
              bool3 = false;
            }
            if (d(bool2, bool3, localb)) {
              return;
            }
            if (bool3) {
              break;
            }
            localb.onNext(localObject);
          }
          if ((!bool1) && (d(this.z, localh.isEmpty(), localb))) {
            return;
          }
          if ((l2 != 0L) && (l1 != Long.MAX_VALUE)) {
            this.p1.addAndGet(-l2);
          }
          j = addAndGet(-i);
          i = j;
        } while (j != 0);
      }
    }
    
    public boolean isEmpty()
    {
      return this.d.isEmpty();
    }
    
    public void onComplete()
    {
      this.z = true;
      if (this.p2) {
        this.c.onComplete();
      } else {
        drain();
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.p0 = paramThrowable;
      this.z = true;
      if (this.p2) {
        this.c.onError(paramThrowable);
      } else {
        drain();
      }
    }
    
    /* Error */
    public void onNext(T paramT)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 55	io/reactivex/internal/operators/flowable/r$a:d	Lio/reactivex/h0/b/h;
      //   4: aload_1
      //   5: invokeinterface 131 2 0
      //   10: ifne +51 -> 61
      //   13: aload_0
      //   14: getfield 63	io/reactivex/internal/operators/flowable/r$a:x	Le/b/c;
      //   17: invokeinterface 67 1 0
      //   22: new 133	io/reactivex/exceptions/MissingBackpressureException
      //   25: dup
      //   26: ldc -121
      //   28: invokespecial 138	io/reactivex/exceptions/MissingBackpressureException:<init>	(Ljava/lang/String;)V
      //   31: astore_2
      //   32: aload_0
      //   33: getfield 43	io/reactivex/internal/operators/flowable/r$a:q	Lio/reactivex/g0/a;
      //   36: invokeinterface 143 1 0
      //   41: goto +14 -> 55
      //   44: astore_1
      //   45: aload_1
      //   46: invokestatic 148	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
      //   49: aload_2
      //   50: aload_1
      //   51: invokevirtual 154	java/lang/RuntimeException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
      //   54: pop
      //   55: aload_0
      //   56: aload_2
      //   57: invokevirtual 155	io/reactivex/internal/operators/flowable/r$a:onError	(Ljava/lang/Throwable;)V
      //   60: return
      //   61: aload_0
      //   62: getfield 69	io/reactivex/internal/operators/flowable/r$a:p2	Z
      //   65: ifeq +16 -> 81
      //   68: aload_0
      //   69: getfield 41	io/reactivex/internal/operators/flowable/r$a:c	Le/b/b;
      //   72: aconst_null
      //   73: invokeinterface 116 2 0
      //   78: goto +7 -> 85
      //   81: aload_0
      //   82: invokevirtual 127	io/reactivex/internal/operators/flowable/r$a:drain	()V
      //   85: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	86	0	this	a
      //   0	86	1	paramT	T
      //   31	26	2	localMissingBackpressureException	io.reactivex.exceptions.MissingBackpressureException
      // Exception table:
      //   from	to	target	type
      //   32	41	44	finally
    }
    
    public void onSubscribe(c paramc)
    {
      if (SubscriptionHelper.validate(this.x, paramc))
      {
        this.x = paramc;
        this.c.onSubscribe(this);
        paramc.request(Long.MAX_VALUE);
      }
    }
    
    public T poll()
      throws Exception
    {
      return (T)this.d.poll();
    }
    
    public void request(long paramLong)
    {
      if ((!this.p2) && (SubscriptionHelper.validate(paramLong)))
      {
        io.reactivex.internal.util.b.a(this.p1, paramLong);
        drain();
      }
    }
    
    public int requestFusion(int paramInt)
    {
      if ((paramInt & 0x2) != 0)
      {
        this.p2 = true;
        return 2;
      }
      return 0;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\flowable\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */