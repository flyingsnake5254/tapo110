package io.reactivex.h0.c.c;

import io.reactivex.b0;
import io.reactivex.e0.c;
import io.reactivex.g0.g;
import io.reactivex.x;
import io.reactivex.z;

public final class b<T>
  extends x<T>
{
  final b0<T> c;
  final g<? super Throwable> d;
  
  public b(b0<T> paramb0, g<? super Throwable> paramg)
  {
    this.c = paramb0;
    this.d = paramg;
  }
  
  protected void l(z<? super T> paramz)
  {
    this.c.a(new a(paramz));
  }
  
  final class a
    implements z<T>
  {
    private final z<? super T> c;
    
    a()
    {
      z localz;
      this.c = localz;
    }
    
    /* Error */
    public void onError(Throwable paramThrowable)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 19	io/reactivex/h0/c/c/b$a:d	Lio/reactivex/h0/c/c/b;
      //   4: getfield 32	io/reactivex/h0/c/c/b:d	Lio/reactivex/g0/g;
      //   7: aload_1
      //   8: invokeinterface 38 2 0
      //   13: goto +28 -> 41
      //   16: astore_2
      //   17: aload_2
      //   18: invokestatic 43	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
      //   21: new 45	io/reactivex/exceptions/CompositeException
      //   24: dup
      //   25: iconst_2
      //   26: anewarray 47	java/lang/Throwable
      //   29: dup
      //   30: iconst_0
      //   31: aload_1
      //   32: aastore
      //   33: dup
      //   34: iconst_1
      //   35: aload_2
      //   36: aastore
      //   37: invokespecial 50	io/reactivex/exceptions/CompositeException:<init>	([Ljava/lang/Throwable;)V
      //   40: astore_1
      //   41: aload_0
      //   42: getfield 24	io/reactivex/h0/c/c/b$a:c	Lio/reactivex/z;
      //   45: aload_1
      //   46: invokeinterface 52 2 0
      //   51: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	52	0	this	a
      //   0	52	1	paramThrowable	Throwable
      //   16	20	2	localThrowable	Throwable
      // Exception table:
      //   from	to	target	type
      //   0	13	16	finally
    }
    
    public void onSubscribe(c paramc)
    {
      this.c.onSubscribe(paramc);
    }
    
    public void onSuccess(T paramT)
    {
      this.c.onSuccess(paramT);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\h0\c\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */