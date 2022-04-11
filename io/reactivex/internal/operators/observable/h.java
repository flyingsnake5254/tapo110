package io.reactivex.internal.operators.observable;

import io.reactivex.g0.j;
import io.reactivex.h0.a.b;
import io.reactivex.h0.b.i;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.t;
import io.reactivex.v;
import java.util.Collection;
import java.util.concurrent.Callable;

public final class h<T, K>
  extends a<T, T>
{
  final j<? super T, K> d;
  final Callable<? extends Collection<? super K>> f;
  
  public h(t<T> paramt, j<? super T, K> paramj, Callable<? extends Collection<? super K>> paramCallable)
  {
    super(paramt);
    this.d = paramj;
    this.f = paramCallable;
  }
  
  protected void K0(v<? super T> paramv)
  {
    try
    {
      Collection localCollection = (Collection)b.e(this.f.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");
      this.c.a(new a(paramv, this.d, localCollection));
      return;
    }
    finally
    {
      io.reactivex.exceptions.a.b(localThrowable);
      EmptyDisposable.error(localThrowable, paramv);
    }
  }
  
  static final class a<T, K>
    extends io.reactivex.internal.observers.a<T, T>
  {
    final Collection<? super K> y;
    final j<? super T, K> z;
    
    a(v<? super T> paramv, j<? super T, K> paramj, Collection<? super K> paramCollection)
    {
      super();
      this.z = paramj;
      this.y = paramCollection;
    }
    
    public void clear()
    {
      this.y.clear();
      super.clear();
    }
    
    public void onComplete()
    {
      if (!this.q)
      {
        this.q = true;
        this.y.clear();
        this.c.onComplete();
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.q)
      {
        io.reactivex.j0.a.r(paramThrowable);
      }
      else
      {
        this.q = true;
        this.y.clear();
        this.c.onError(paramThrowable);
      }
    }
    
    /* Error */
    public void onNext(T paramT)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 38	io/reactivex/internal/observers/a:q	Z
      //   4: ifeq +4 -> 8
      //   7: return
      //   8: aload_0
      //   9: getfield 61	io/reactivex/internal/observers/a:x	I
      //   12: ifne +54 -> 66
      //   15: aload_0
      //   16: getfield 21	io/reactivex/internal/operators/observable/h$a:z	Lio/reactivex/g0/j;
      //   19: aload_1
      //   20: invokeinterface 67 2 0
      //   25: ldc 69
      //   27: invokestatic 75	io/reactivex/h0/a/b:e	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
      //   30: astore_2
      //   31: aload_0
      //   32: getfield 23	io/reactivex/internal/operators/observable/h$a:y	Ljava/util/Collection;
      //   35: aload_2
      //   36: invokeinterface 79 2 0
      //   41: istore_3
      //   42: iload_3
      //   43: ifeq +33 -> 76
      //   46: aload_0
      //   47: getfield 42	io/reactivex/internal/observers/a:c	Lio/reactivex/v;
      //   50: aload_1
      //   51: invokeinterface 81 2 0
      //   56: goto +20 -> 76
      //   59: astore_1
      //   60: aload_0
      //   61: aload_1
      //   62: invokevirtual 83	io/reactivex/internal/observers/a:c	(Ljava/lang/Throwable;)V
      //   65: return
      //   66: aload_0
      //   67: getfield 42	io/reactivex/internal/observers/a:c	Lio/reactivex/v;
      //   70: aconst_null
      //   71: invokeinterface 81 2 0
      //   76: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	77	0	this	a
      //   0	77	1	paramT	T
      //   30	6	2	localObject	Object
      //   41	2	3	bool	boolean
      // Exception table:
      //   from	to	target	type
      //   15	42	59	finally
    }
    
    public T poll()
      throws Exception
    {
      Object localObject;
      do
      {
        localObject = this.f.poll();
      } while ((localObject != null) && (!this.y.add(b.e(this.z.apply(localObject), "The keySelector returned a null key"))));
      return (T)localObject;
    }
    
    public int requestFusion(int paramInt)
    {
      return d(paramInt);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\observable\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */