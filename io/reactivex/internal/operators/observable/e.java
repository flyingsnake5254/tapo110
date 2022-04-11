package io.reactivex.internal.operators.observable;

import io.reactivex.e0.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.j0.a;
import io.reactivex.q;
import io.reactivex.r;
import io.reactivex.s;
import io.reactivex.v;
import java.util.concurrent.atomic.AtomicReference;

public final class e<T>
  extends q<T>
{
  final s<T> c;
  
  public e(s<T> params)
  {
    this.c = params;
  }
  
  /* Error */
  protected void K0(v<? super T> paramv)
  {
    // Byte code:
    //   0: new 7	io/reactivex/internal/operators/observable/e$a
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 25	io/reactivex/internal/operators/observable/e$a:<init>	(Lio/reactivex/v;)V
    //   8: astore_2
    //   9: aload_1
    //   10: aload_2
    //   11: invokeinterface 31 2 0
    //   16: aload_0
    //   17: getfield 18	io/reactivex/internal/operators/observable/e:c	Lio/reactivex/s;
    //   20: aload_2
    //   21: invokeinterface 37 2 0
    //   26: goto +13 -> 39
    //   29: astore_1
    //   30: aload_1
    //   31: invokestatic 43	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
    //   34: aload_2
    //   35: aload_1
    //   36: invokevirtual 46	io/reactivex/internal/operators/observable/e$a:onError	(Ljava/lang/Throwable;)V
    //   39: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	e
    //   0	40	1	paramv	v<? super T>
    //   8	27	2	locala	a
    // Exception table:
    //   from	to	target	type
    //   16	26	29	finally
  }
  
  static final class a<T>
    extends AtomicReference<c>
    implements r<T>, c
  {
    final v<? super T> c;
    
    a(v<? super T> paramv)
    {
      this.c = paramv;
    }
    
    public void a(c paramc)
    {
      DisposableHelper.set(this, paramc);
    }
    
    public boolean b(Throwable paramThrowable)
    {
      Object localObject = paramThrowable;
      if (paramThrowable == null) {
        localObject = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
      }
      if (!isDisposed()) {
        try
        {
          this.c.onError((Throwable)localObject);
          return true;
        }
        finally
        {
          dispose();
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
      return DisposableHelper.isDisposed((c)get());
    }
    
    /* Error */
    public void onComplete()
    {
      // Byte code:
      //   0: aload_0
      //   1: invokevirtual 45	io/reactivex/internal/operators/observable/e$a:isDisposed	()Z
      //   4: ifne +26 -> 30
      //   7: aload_0
      //   8: getfield 22	io/reactivex/internal/operators/observable/e$a:c	Lio/reactivex/v;
      //   11: invokeinterface 67 1 0
      //   16: aload_0
      //   17: invokevirtual 54	io/reactivex/internal/operators/observable/e$a:dispose	()V
      //   20: goto +10 -> 30
      //   23: astore_1
      //   24: aload_0
      //   25: invokevirtual 54	io/reactivex/internal/operators/observable/e$a:dispose	()V
      //   28: aload_1
      //   29: athrow
      //   30: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	31	0	this	a
      //   23	6	1	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   7	16	23	finally
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (!b(paramThrowable)) {
        a.r(paramThrowable);
      }
    }
    
    public void onNext(T paramT)
    {
      if (paramT == null)
      {
        onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
        return;
      }
      if (!isDisposed()) {
        this.c.onNext(paramT);
      }
    }
    
    public String toString()
    {
      return String.format("%s{%s}", new Object[] { a.class.getSimpleName(), super.toString() });
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\observable\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */