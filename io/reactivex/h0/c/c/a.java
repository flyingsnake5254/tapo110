package io.reactivex.h0.c.c;

import io.reactivex.a0;
import io.reactivex.e0.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.x;
import io.reactivex.y;
import io.reactivex.z;
import java.util.concurrent.atomic.AtomicReference;

public final class a<T>
  extends x<T>
{
  final a0<T> c;
  
  public a(a0<T> parama0)
  {
    this.c = parama0;
  }
  
  /* Error */
  protected void l(z<? super T> paramz)
  {
    // Byte code:
    //   0: new 7	io/reactivex/h0/c/c/a$a
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 25	io/reactivex/h0/c/c/a$a:<init>	(Lio/reactivex/z;)V
    //   8: astore_2
    //   9: aload_1
    //   10: aload_2
    //   11: invokeinterface 31 2 0
    //   16: aload_0
    //   17: getfield 18	io/reactivex/h0/c/c/a:c	Lio/reactivex/a0;
    //   20: aload_2
    //   21: invokeinterface 37 2 0
    //   26: goto +13 -> 39
    //   29: astore_1
    //   30: aload_1
    //   31: invokestatic 43	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
    //   34: aload_2
    //   35: aload_1
    //   36: invokevirtual 44	io/reactivex/h0/c/c/a$a:b	(Ljava/lang/Throwable;)V
    //   39: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	a
    //   0	40	1	paramz	z<? super T>
    //   8	27	2	locala	a
    // Exception table:
    //   from	to	target	type
    //   16	26	29	finally
  }
  
  static final class a<T>
    extends AtomicReference<c>
    implements y<T>, c
  {
    final z<? super T> c;
    
    a(z<? super T> paramz)
    {
      this.c = paramz;
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
        paramThrowable = (c)getAndSet(localDisposableHelper);
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
    
    public void b(Throwable paramThrowable)
    {
      if (!a(paramThrowable)) {
        io.reactivex.j0.a.r(paramThrowable);
      }
    }
    
    public void dispose()
    {
      DisposableHelper.dispose(this);
    }
    
    public boolean isDisposed()
    {
      return DisposableHelper.isDisposed((c)get());
    }
    
    public void onSuccess(T paramT)
    {
      Object localObject1 = get();
      Object localObject2 = DisposableHelper.DISPOSED;
      if (localObject1 != localObject2)
      {
        localObject1 = (c)getAndSet(localObject2);
        if (localObject1 != localObject2)
        {
          if (paramT == null) {}
          try
          {
            localObject2 = this.c;
            paramT = new java/lang/NullPointerException;
            paramT.<init>("onSuccess called with null. Null values are generally not allowed in 2.x operators and sources.");
            ((z)localObject2).onError(paramT);
            break label67;
            this.c.onSuccess(paramT);
          }
          finally
          {
            label67:
            if (localObject1 != null) {
              ((c)localObject1).dispose();
            }
          }
        }
      }
    }
    
    public String toString()
    {
      return String.format("%s{%s}", new Object[] { a.class.getSimpleName(), super.toString() });
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\h0\c\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */