package io.reactivex.internal.operators.observable;

import io.reactivex.g0.j;
import io.reactivex.h0.b.d;
import io.reactivex.j0.a;
import io.reactivex.q;
import io.reactivex.t;
import io.reactivex.v;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableScalarXMap
{
  public static <T, U> q<U> a(T paramT, j<? super T, ? extends t<? extends U>> paramj)
  {
    return a.n(new a(paramT, paramj));
  }
  
  /* Error */
  public static <T, R> boolean b(t<T> paramt, v<? super R> paramv, j<? super T, ? extends t<? extends R>> paramj)
  {
    // Byte code:
    //   0: aload_0
    //   1: instanceof 28
    //   4: ifeq +135 -> 139
    //   7: aload_0
    //   8: checkcast 28	java/util/concurrent/Callable
    //   11: invokeinterface 32 1 0
    //   16: astore_0
    //   17: aload_0
    //   18: ifnonnull +9 -> 27
    //   21: aload_1
    //   22: invokestatic 38	io/reactivex/internal/disposables/EmptyDisposable:complete	(Lio/reactivex/v;)V
    //   25: iconst_1
    //   26: ireturn
    //   27: aload_2
    //   28: aload_0
    //   29: invokeinterface 44 2 0
    //   34: ldc 46
    //   36: invokestatic 52	io/reactivex/h0/a/b:e	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   39: checkcast 54	io/reactivex/t
    //   42: astore_0
    //   43: aload_0
    //   44: instanceof 28
    //   47: ifeq +59 -> 106
    //   50: aload_0
    //   51: checkcast 28	java/util/concurrent/Callable
    //   54: invokeinterface 32 1 0
    //   59: astore_0
    //   60: aload_0
    //   61: ifnonnull +9 -> 70
    //   64: aload_1
    //   65: invokestatic 38	io/reactivex/internal/disposables/EmptyDisposable:complete	(Lio/reactivex/v;)V
    //   68: iconst_1
    //   69: ireturn
    //   70: new 6	io/reactivex/internal/operators/observable/ObservableScalarXMap$ScalarDisposable
    //   73: dup
    //   74: aload_1
    //   75: aload_0
    //   76: invokespecial 57	io/reactivex/internal/operators/observable/ObservableScalarXMap$ScalarDisposable:<init>	(Lio/reactivex/v;Ljava/lang/Object;)V
    //   79: astore_0
    //   80: aload_1
    //   81: aload_0
    //   82: invokeinterface 63 2 0
    //   87: aload_0
    //   88: invokevirtual 67	io/reactivex/internal/operators/observable/ObservableScalarXMap$ScalarDisposable:run	()V
    //   91: goto +22 -> 113
    //   94: astore_0
    //   95: aload_0
    //   96: invokestatic 72	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
    //   99: aload_0
    //   100: aload_1
    //   101: invokestatic 76	io/reactivex/internal/disposables/EmptyDisposable:error	(Ljava/lang/Throwable;Lio/reactivex/v;)V
    //   104: iconst_1
    //   105: ireturn
    //   106: aload_0
    //   107: aload_1
    //   108: invokeinterface 78 2 0
    //   113: iconst_1
    //   114: ireturn
    //   115: astore_0
    //   116: aload_0
    //   117: invokestatic 72	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
    //   120: aload_0
    //   121: aload_1
    //   122: invokestatic 76	io/reactivex/internal/disposables/EmptyDisposable:error	(Ljava/lang/Throwable;Lio/reactivex/v;)V
    //   125: iconst_1
    //   126: ireturn
    //   127: astore_0
    //   128: aload_0
    //   129: invokestatic 72	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
    //   132: aload_0
    //   133: aload_1
    //   134: invokestatic 76	io/reactivex/internal/disposables/EmptyDisposable:error	(Ljava/lang/Throwable;Lio/reactivex/v;)V
    //   137: iconst_1
    //   138: ireturn
    //   139: iconst_0
    //   140: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	paramt	t<T>
    //   0	141	1	paramv	v<? super R>
    //   0	141	2	paramj	j<? super T, ? extends t<? extends R>>
    // Exception table:
    //   from	to	target	type
    //   50	60	94	finally
    //   27	43	115	finally
    //   7	17	127	finally
  }
  
  public static final class ScalarDisposable<T>
    extends AtomicInteger
    implements d<T>, Runnable
  {
    static final int FUSED = 1;
    static final int ON_COMPLETE = 3;
    static final int ON_NEXT = 2;
    static final int START = 0;
    private static final long serialVersionUID = 3880992722410194083L;
    final v<? super T> observer;
    final T value;
    
    public ScalarDisposable(v<? super T> paramv, T paramT)
    {
      this.observer = paramv;
      this.value = paramT;
    }
    
    public void clear()
    {
      lazySet(3);
    }
    
    public void dispose()
    {
      set(3);
    }
    
    public boolean isDisposed()
    {
      boolean bool;
      if (get() == 3) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public boolean isEmpty()
    {
      int i = get();
      boolean bool = true;
      if (i == 1) {
        bool = false;
      }
      return bool;
    }
    
    public boolean offer(T paramT)
    {
      throw new UnsupportedOperationException("Should not be called!");
    }
    
    public boolean offer(T paramT1, T paramT2)
    {
      throw new UnsupportedOperationException("Should not be called!");
    }
    
    public T poll()
      throws Exception
    {
      if (get() == 1)
      {
        lazySet(3);
        return (T)this.value;
      }
      return null;
    }
    
    public int requestFusion(int paramInt)
    {
      if ((paramInt & 0x1) != 0)
      {
        lazySet(1);
        return 1;
      }
      return 0;
    }
    
    public void run()
    {
      if ((get() == 0) && (compareAndSet(0, 2)))
      {
        this.observer.onNext(this.value);
        if (get() == 2)
        {
          lazySet(3);
          this.observer.onComplete();
        }
      }
    }
  }
  
  static final class a<T, R>
    extends q<R>
  {
    final T c;
    final j<? super T, ? extends t<? extends R>> d;
    
    a(T paramT, j<? super T, ? extends t<? extends R>> paramj)
    {
      this.c = paramT;
      this.d = paramj;
    }
    
    /* Error */
    public void K0(v<? super R> paramv)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 23	io/reactivex/internal/operators/observable/ObservableScalarXMap$a:d	Lio/reactivex/g0/j;
      //   4: aload_0
      //   5: getfield 21	io/reactivex/internal/operators/observable/ObservableScalarXMap$a:c	Ljava/lang/Object;
      //   8: invokeinterface 34 2 0
      //   13: ldc 36
      //   15: invokestatic 42	io/reactivex/h0/a/b:e	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
      //   18: checkcast 44	io/reactivex/t
      //   21: astore_2
      //   22: aload_2
      //   23: instanceof 46
      //   26: ifeq +57 -> 83
      //   29: aload_2
      //   30: checkcast 46	java/util/concurrent/Callable
      //   33: invokeinterface 50 1 0
      //   38: astore_2
      //   39: aload_2
      //   40: ifnonnull +8 -> 48
      //   43: aload_1
      //   44: invokestatic 55	io/reactivex/internal/disposables/EmptyDisposable:complete	(Lio/reactivex/v;)V
      //   47: return
      //   48: new 57	io/reactivex/internal/operators/observable/ObservableScalarXMap$ScalarDisposable
      //   51: dup
      //   52: aload_1
      //   53: aload_2
      //   54: invokespecial 60	io/reactivex/internal/operators/observable/ObservableScalarXMap$ScalarDisposable:<init>	(Lio/reactivex/v;Ljava/lang/Object;)V
      //   57: astore_2
      //   58: aload_1
      //   59: aload_2
      //   60: invokeinterface 66 2 0
      //   65: aload_2
      //   66: invokevirtual 69	io/reactivex/internal/operators/observable/ObservableScalarXMap$ScalarDisposable:run	()V
      //   69: goto +21 -> 90
      //   72: astore_2
      //   73: aload_2
      //   74: invokestatic 75	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
      //   77: aload_2
      //   78: aload_1
      //   79: invokestatic 79	io/reactivex/internal/disposables/EmptyDisposable:error	(Ljava/lang/Throwable;Lio/reactivex/v;)V
      //   82: return
      //   83: aload_2
      //   84: aload_1
      //   85: invokeinterface 81 2 0
      //   90: return
      //   91: astore_2
      //   92: aload_2
      //   93: aload_1
      //   94: invokestatic 79	io/reactivex/internal/disposables/EmptyDisposable:error	(Ljava/lang/Throwable;Lio/reactivex/v;)V
      //   97: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	98	0	this	a
      //   0	98	1	paramv	v<? super R>
      //   21	45	2	localObject	Object
      //   72	12	2	localThrowable1	Throwable
      //   91	2	2	localThrowable2	Throwable
      // Exception table:
      //   from	to	target	type
      //   29	39	72	finally
      //   0	22	91	finally
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\observable\ObservableScalarXMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */