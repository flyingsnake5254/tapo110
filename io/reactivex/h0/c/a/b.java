package io.reactivex.h0.c.a;

import io.reactivex.d;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class b
  extends io.reactivex.a
{
  final d c;
  
  public b(d paramd)
  {
    this.c = paramd;
  }
  
  /* Error */
  protected void B(io.reactivex.c paramc)
  {
    // Byte code:
    //   0: new 6	io/reactivex/h0/c/a/b$a
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 21	io/reactivex/h0/c/a/b$a:<init>	(Lio/reactivex/c;)V
    //   8: astore_2
    //   9: aload_1
    //   10: aload_2
    //   11: invokeinterface 27 2 0
    //   16: aload_0
    //   17: getfield 16	io/reactivex/h0/c/a/b:c	Lio/reactivex/d;
    //   20: aload_2
    //   21: invokeinterface 32 2 0
    //   26: goto +13 -> 39
    //   29: astore_1
    //   30: aload_1
    //   31: invokestatic 38	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
    //   34: aload_2
    //   35: aload_1
    //   36: invokevirtual 41	io/reactivex/h0/c/a/b$a:onError	(Ljava/lang/Throwable;)V
    //   39: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	b
    //   0	40	1	paramc	io.reactivex.c
    //   8	27	2	locala	a
    // Exception table:
    //   from	to	target	type
    //   16	26	29	finally
  }
  
  static final class a
    extends AtomicReference<io.reactivex.e0.c>
    implements io.reactivex.b, io.reactivex.e0.c
  {
    final io.reactivex.c c;
    
    a(io.reactivex.c paramc)
    {
      this.c = paramc;
    }
    
    public boolean a(Throwable paramThrowable)
    {
      Object localObject1 = paramThrowable;
      if (paramThrowable == null) {
        localObject1 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
      }
      paramThrowable = get();
      DisposableHelper localDisposableHelper = DisposableHelper.DISPOSED;
      if (paramThrowable != localDisposableHelper)
      {
        paramThrowable = (io.reactivex.e0.c)getAndSet(localDisposableHelper);
        if (paramThrowable != localDisposableHelper) {
          try
          {
            this.c.onError((Throwable)localObject1);
            return true;
          }
          finally
          {
            if (paramThrowable != null) {
              paramThrowable.dispose();
            }
          }
        }
      }
      return false;
    }
    
    public void dispose()
    {
      DisposableHelper.dispose(this);
    }
    
    public boolean isDisposed()
    {
      return DisposableHelper.isDisposed((io.reactivex.e0.c)get());
    }
    
    /* Error */
    public void onComplete()
    {
      // Byte code:
      //   0: aload_0
      //   1: invokevirtual 34	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
      //   4: astore_1
      //   5: getstatic 40	io/reactivex/internal/disposables/DisposableHelper:DISPOSED	Lio/reactivex/internal/disposables/DisposableHelper;
      //   8: astore_2
      //   9: aload_1
      //   10: aload_2
      //   11: if_acmpeq +52 -> 63
      //   14: aload_0
      //   15: aload_2
      //   16: invokevirtual 44	java/util/concurrent/atomic/AtomicReference:getAndSet	(Ljava/lang/Object;)Ljava/lang/Object;
      //   19: checkcast 9	io/reactivex/e0/c
      //   22: astore_1
      //   23: aload_1
      //   24: aload_2
      //   25: if_acmpeq +38 -> 63
      //   28: aload_0
      //   29: getfield 21	io/reactivex/h0/c/a/b$a:c	Lio/reactivex/c;
      //   32: invokeinterface 64 1 0
      //   37: aload_1
      //   38: ifnull +25 -> 63
      //   41: aload_1
      //   42: invokeinterface 53 1 0
      //   47: goto +16 -> 63
      //   50: astore_2
      //   51: aload_1
      //   52: ifnull +9 -> 61
      //   55: aload_1
      //   56: invokeinterface 53 1 0
      //   61: aload_2
      //   62: athrow
      //   63: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	64	0	this	a
      //   4	52	1	localObject1	Object
      //   8	17	2	localDisposableHelper	DisposableHelper
      //   50	12	2	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   28	37	50	finally
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (!a(paramThrowable)) {
        io.reactivex.j0.a.r(paramThrowable);
      }
    }
    
    public String toString()
    {
      return String.format("%s{%s}", new Object[] { a.class.getSimpleName(), super.toString() });
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\h0\c\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */