package io.reactivex.internal.operators.observable;

import io.reactivex.g0.l;
import io.reactivex.h0.b.i;
import io.reactivex.t;
import io.reactivex.v;

public final class q<T>
  extends a<T, T>
{
  final l<? super T> d;
  
  public q(t<T> paramt, l<? super T> paraml)
  {
    super(paramt);
    this.d = paraml;
  }
  
  public void K0(v<? super T> paramv)
  {
    this.c.a(new a(paramv, this.d));
  }
  
  static final class a<T>
    extends io.reactivex.internal.observers.a<T, T>
  {
    final l<? super T> y;
    
    a(v<? super T> paramv, l<? super T> paraml)
    {
      super();
      this.y = paraml;
    }
    
    /* Error */
    public void onNext(T paramT)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 27	io/reactivex/internal/observers/a:x	I
      //   4: ifne +38 -> 42
      //   7: aload_0
      //   8: getfield 18	io/reactivex/internal/operators/observable/q$a:y	Lio/reactivex/g0/l;
      //   11: aload_1
      //   12: invokeinterface 33 2 0
      //   17: istore_2
      //   18: iload_2
      //   19: ifeq +33 -> 52
      //   22: aload_0
      //   23: getfield 37	io/reactivex/internal/observers/a:c	Lio/reactivex/v;
      //   26: aload_1
      //   27: invokeinterface 41 2 0
      //   32: goto +20 -> 52
      //   35: astore_1
      //   36: aload_0
      //   37: aload_1
      //   38: invokevirtual 44	io/reactivex/internal/observers/a:c	(Ljava/lang/Throwable;)V
      //   41: return
      //   42: aload_0
      //   43: getfield 37	io/reactivex/internal/observers/a:c	Lio/reactivex/v;
      //   46: aconst_null
      //   47: invokeinterface 41 2 0
      //   52: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	53	0	this	a
      //   0	53	1	paramT	T
      //   17	2	2	bool	boolean
      // Exception table:
      //   from	to	target	type
      //   7	18	35	finally
    }
    
    public T poll()
      throws Exception
    {
      Object localObject;
      do
      {
        localObject = this.f.poll();
      } while ((localObject != null) && (!this.y.test(localObject)));
      return (T)localObject;
    }
    
    public int requestFusion(int paramInt)
    {
      return d(paramInt);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\observable\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */