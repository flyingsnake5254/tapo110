package io.reactivex.internal.operators.observable;

import io.reactivex.e0.c;
import io.reactivex.h0.b.d;
import io.reactivex.h0.b.e;
import io.reactivex.h0.b.i;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.internal.queue.b;
import io.reactivex.internal.schedulers.l;
import io.reactivex.t;
import io.reactivex.v;
import io.reactivex.w;
import io.reactivex.w.c;
import java.util.concurrent.atomic.AtomicInteger;

public final class j0<T>
  extends a<T, T>
{
  final w d;
  final boolean f;
  final int q;
  
  public j0(t<T> paramt, w paramw, boolean paramBoolean, int paramInt)
  {
    super(paramt);
    this.d = paramw;
    this.f = paramBoolean;
    this.q = paramInt;
  }
  
  protected void K0(v<? super T> paramv)
  {
    Object localObject = this.d;
    if ((localObject instanceof l))
    {
      this.c.a(paramv);
    }
    else
    {
      localObject = ((w)localObject).b();
      this.c.a(new a(paramv, (w.c)localObject, this.f, this.q));
    }
  }
  
  static final class a<T>
    extends BasicIntQueueDisposable<T>
    implements v<T>, Runnable
  {
    final v<? super T> c;
    final w.c d;
    final boolean f;
    volatile boolean p0;
    volatile boolean p1;
    int p2;
    boolean p3;
    final int q;
    i<T> x;
    c y;
    Throwable z;
    
    a(v<? super T> paramv, w.c paramc, boolean paramBoolean, int paramInt)
    {
      this.c = paramv;
      this.d = paramc;
      this.f = paramBoolean;
      this.q = paramInt;
    }
    
    boolean a(boolean paramBoolean1, boolean paramBoolean2, v<? super T> paramv)
    {
      if (this.p1)
      {
        this.x.clear();
        return true;
      }
      if (paramBoolean1)
      {
        Throwable localThrowable = this.z;
        if (this.f)
        {
          if (paramBoolean2)
          {
            this.p1 = true;
            if (localThrowable != null) {
              paramv.onError(localThrowable);
            } else {
              paramv.onComplete();
            }
            this.d.dispose();
            return true;
          }
        }
        else
        {
          if (localThrowable != null)
          {
            this.p1 = true;
            this.x.clear();
            paramv.onError(localThrowable);
            this.d.dispose();
            return true;
          }
          if (paramBoolean2)
          {
            this.p1 = true;
            paramv.onComplete();
            this.d.dispose();
            return true;
          }
        }
      }
      return false;
    }
    
    void b()
    {
      int i = 1;
      int j;
      do
      {
        if (this.p1) {
          return;
        }
        boolean bool = this.p0;
        Throwable localThrowable = this.z;
        if ((!this.f) && (bool) && (localThrowable != null))
        {
          this.p1 = true;
          this.c.onError(this.z);
          this.d.dispose();
          return;
        }
        this.c.onNext(null);
        if (bool)
        {
          this.p1 = true;
          localThrowable = this.z;
          if (localThrowable != null) {
            this.c.onError(localThrowable);
          } else {
            this.c.onComplete();
          }
          this.d.dispose();
          return;
        }
        j = addAndGet(-i);
        i = j;
      } while (j != 0);
    }
    
    public void clear()
    {
      this.x.clear();
    }
    
    /* Error */
    void d()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 53	io/reactivex/internal/operators/observable/j0$a:x	Lio/reactivex/h0/b/i;
      //   4: astore_1
      //   5: aload_0
      //   6: getfield 39	io/reactivex/internal/operators/observable/j0$a:c	Lio/reactivex/v;
      //   9: astore_2
      //   10: iconst_1
      //   11: istore_3
      //   12: aload_0
      //   13: aload_0
      //   14: getfield 76	io/reactivex/internal/operators/observable/j0$a:p0	Z
      //   17: aload_1
      //   18: invokeinterface 90 1 0
      //   23: aload_2
      //   24: invokevirtual 92	io/reactivex/internal/operators/observable/j0$a:a	(ZZLio/reactivex/v;)Z
      //   27: ifeq +4 -> 31
      //   30: return
      //   31: aload_0
      //   32: getfield 76	io/reactivex/internal/operators/observable/j0$a:p0	Z
      //   35: istore 4
      //   37: aload_1
      //   38: invokeinterface 96 1 0
      //   43: astore 5
      //   45: aload 5
      //   47: ifnonnull +9 -> 56
      //   50: iconst_1
      //   51: istore 6
      //   53: goto +6 -> 59
      //   56: iconst_0
      //   57: istore 6
      //   59: aload_0
      //   60: iload 4
      //   62: iload 6
      //   64: aload_2
      //   65: invokevirtual 92	io/reactivex/internal/operators/observable/j0$a:a	(ZZLio/reactivex/v;)Z
      //   68: ifeq +4 -> 72
      //   71: return
      //   72: iload 6
      //   74: ifeq +20 -> 94
      //   77: aload_0
      //   78: iload_3
      //   79: ineg
      //   80: invokevirtual 86	java/util/concurrent/atomic/AtomicInteger:addAndGet	(I)I
      //   83: istore 7
      //   85: iload 7
      //   87: istore_3
      //   88: iload 7
      //   90: ifne -78 -> 12
      //   93: return
      //   94: aload_2
      //   95: aload 5
      //   97: invokeinterface 80 2 0
      //   102: goto -71 -> 31
      //   105: astore 5
      //   107: aload 5
      //   109: invokestatic 100	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
      //   112: aload_0
      //   113: iconst_1
      //   114: putfield 51	io/reactivex/internal/operators/observable/j0$a:p1	Z
      //   117: aload_0
      //   118: getfield 102	io/reactivex/internal/operators/observable/j0$a:y	Lio/reactivex/e0/c;
      //   121: invokeinterface 72 1 0
      //   126: aload_1
      //   127: invokeinterface 58 1 0
      //   132: aload_2
      //   133: aload 5
      //   135: invokeinterface 64 2 0
      //   140: aload_0
      //   141: getfield 41	io/reactivex/internal/operators/observable/j0$a:d	Lio/reactivex/w$c;
      //   144: invokeinterface 72 1 0
      //   149: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	150	0	this	a
      //   4	123	1	locali	i
      //   9	124	2	localv	v
      //   11	77	3	i	int
      //   35	26	4	bool1	boolean
      //   43	53	5	localObject	Object
      //   105	29	5	localThrowable	Throwable
      //   51	22	6	bool2	boolean
      //   83	6	7	j	int
      // Exception table:
      //   from	to	target	type
      //   37	45	105	finally
    }
    
    public void dispose()
    {
      if (!this.p1)
      {
        this.p1 = true;
        this.y.dispose();
        this.d.dispose();
        if ((!this.p3) && (getAndIncrement() == 0)) {
          this.x.clear();
        }
      }
    }
    
    void f()
    {
      if (getAndIncrement() == 0) {
        this.d.b(this);
      }
    }
    
    public boolean isDisposed()
    {
      return this.p1;
    }
    
    public boolean isEmpty()
    {
      return this.x.isEmpty();
    }
    
    public void onComplete()
    {
      if (this.p0) {
        return;
      }
      this.p0 = true;
      f();
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.p0)
      {
        io.reactivex.j0.a.r(paramThrowable);
        return;
      }
      this.z = paramThrowable;
      this.p0 = true;
      f();
    }
    
    public void onNext(T paramT)
    {
      if (this.p0) {
        return;
      }
      if (this.p2 != 2) {
        this.x.offer(paramT);
      }
      f();
    }
    
    public void onSubscribe(c paramc)
    {
      if (DisposableHelper.validate(this.y, paramc))
      {
        this.y = paramc;
        if ((paramc instanceof d))
        {
          paramc = (d)paramc;
          int i = paramc.requestFusion(7);
          if (i == 1)
          {
            this.p2 = i;
            this.x = paramc;
            this.p0 = true;
            this.c.onSubscribe(this);
            f();
            return;
          }
          if (i == 2)
          {
            this.p2 = i;
            this.x = paramc;
            this.c.onSubscribe(this);
            return;
          }
        }
        this.x = new b(this.q);
        this.c.onSubscribe(this);
      }
    }
    
    public T poll()
      throws Exception
    {
      return (T)this.x.poll();
    }
    
    public int requestFusion(int paramInt)
    {
      if ((paramInt & 0x2) != 0)
      {
        this.p3 = true;
        return 2;
      }
      return 0;
    }
    
    public void run()
    {
      if (this.p3) {
        b();
      } else {
        d();
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\observable\j0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */