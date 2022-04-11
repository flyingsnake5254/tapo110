package io.reactivex.internal.operators.flowable;

import io.reactivex.g0.j;
import io.reactivex.h;

public final class a0
{
  public static <T, U> h<U> a(T paramT, j<? super T, ? extends e.b.a<? extends U>> paramj)
  {
    return io.reactivex.j0.a.l(new a(paramT, paramj));
  }
  
  /* Error */
  public static <T, R> boolean b(e.b.a<T> parama, e.b.b<? super R> paramb, j<? super T, ? extends e.b.a<? extends R>> paramj)
  {
    // Byte code:
    //   0: aload_0
    //   1: instanceof 25
    //   4: ifeq +129 -> 133
    //   7: aload_0
    //   8: checkcast 25	java/util/concurrent/Callable
    //   11: invokeinterface 29 1 0
    //   16: astore_0
    //   17: aload_0
    //   18: ifnonnull +9 -> 27
    //   21: aload_1
    //   22: invokestatic 35	io/reactivex/internal/subscriptions/EmptySubscription:complete	(Le/b/b;)V
    //   25: iconst_1
    //   26: ireturn
    //   27: aload_2
    //   28: aload_0
    //   29: invokeinterface 41 2 0
    //   34: ldc 43
    //   36: invokestatic 49	io/reactivex/h0/a/b:e	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   39: checkcast 51	e/b/a
    //   42: astore_0
    //   43: aload_0
    //   44: instanceof 25
    //   47: ifeq +53 -> 100
    //   50: aload_0
    //   51: checkcast 25	java/util/concurrent/Callable
    //   54: invokeinterface 29 1 0
    //   59: astore_0
    //   60: aload_0
    //   61: ifnonnull +9 -> 70
    //   64: aload_1
    //   65: invokestatic 35	io/reactivex/internal/subscriptions/EmptySubscription:complete	(Le/b/b;)V
    //   68: iconst_1
    //   69: ireturn
    //   70: aload_1
    //   71: new 53	io/reactivex/internal/subscriptions/ScalarSubscription
    //   74: dup
    //   75: aload_1
    //   76: aload_0
    //   77: invokespecial 56	io/reactivex/internal/subscriptions/ScalarSubscription:<init>	(Le/b/b;Ljava/lang/Object;)V
    //   80: invokeinterface 62 2 0
    //   85: goto +22 -> 107
    //   88: astore_0
    //   89: aload_0
    //   90: invokestatic 67	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
    //   93: aload_0
    //   94: aload_1
    //   95: invokestatic 71	io/reactivex/internal/subscriptions/EmptySubscription:error	(Ljava/lang/Throwable;Le/b/b;)V
    //   98: iconst_1
    //   99: ireturn
    //   100: aload_0
    //   101: aload_1
    //   102: invokeinterface 73 2 0
    //   107: iconst_1
    //   108: ireturn
    //   109: astore_0
    //   110: aload_0
    //   111: invokestatic 67	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
    //   114: aload_0
    //   115: aload_1
    //   116: invokestatic 71	io/reactivex/internal/subscriptions/EmptySubscription:error	(Ljava/lang/Throwable;Le/b/b;)V
    //   119: iconst_1
    //   120: ireturn
    //   121: astore_0
    //   122: aload_0
    //   123: invokestatic 67	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
    //   126: aload_0
    //   127: aload_1
    //   128: invokestatic 71	io/reactivex/internal/subscriptions/EmptySubscription:error	(Ljava/lang/Throwable;Le/b/b;)V
    //   131: iconst_1
    //   132: ireturn
    //   133: iconst_0
    //   134: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	parama	e.b.a<T>
    //   0	135	1	paramb	e.b.b<? super R>
    //   0	135	2	paramj	j<? super T, ? extends e.b.a<? extends R>>
    // Exception table:
    //   from	to	target	type
    //   50	60	88	finally
    //   27	43	109	finally
    //   7	17	121	finally
  }
  
  static final class a<T, R>
    extends h<R>
  {
    final T d;
    final j<? super T, ? extends e.b.a<? extends R>> f;
    
    a(T paramT, j<? super T, ? extends e.b.a<? extends R>> paramj)
    {
      this.d = paramT;
      this.f = paramj;
    }
    
    /* Error */
    public void H(e.b.b<? super R> paramb)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 23	io/reactivex/internal/operators/flowable/a0$a:f	Lio/reactivex/g0/j;
      //   4: aload_0
      //   5: getfield 21	io/reactivex/internal/operators/flowable/a0$a:d	Ljava/lang/Object;
      //   8: invokeinterface 34 2 0
      //   13: ldc 36
      //   15: invokestatic 42	io/reactivex/h0/a/b:e	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
      //   18: checkcast 44	e/b/a
      //   21: astore_2
      //   22: aload_2
      //   23: instanceof 46
      //   26: ifeq +51 -> 77
      //   29: aload_2
      //   30: checkcast 46	java/util/concurrent/Callable
      //   33: invokeinterface 50 1 0
      //   38: astore_2
      //   39: aload_2
      //   40: ifnonnull +8 -> 48
      //   43: aload_1
      //   44: invokestatic 55	io/reactivex/internal/subscriptions/EmptySubscription:complete	(Le/b/b;)V
      //   47: return
      //   48: aload_1
      //   49: new 57	io/reactivex/internal/subscriptions/ScalarSubscription
      //   52: dup
      //   53: aload_1
      //   54: aload_2
      //   55: invokespecial 60	io/reactivex/internal/subscriptions/ScalarSubscription:<init>	(Le/b/b;Ljava/lang/Object;)V
      //   58: invokeinterface 66 2 0
      //   63: goto +21 -> 84
      //   66: astore_2
      //   67: aload_2
      //   68: invokestatic 72	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
      //   71: aload_2
      //   72: aload_1
      //   73: invokestatic 76	io/reactivex/internal/subscriptions/EmptySubscription:error	(Ljava/lang/Throwable;Le/b/b;)V
      //   76: return
      //   77: aload_2
      //   78: aload_1
      //   79: invokeinterface 78 2 0
      //   84: return
      //   85: astore_2
      //   86: aload_2
      //   87: aload_1
      //   88: invokestatic 76	io/reactivex/internal/subscriptions/EmptySubscription:error	(Ljava/lang/Throwable;Le/b/b;)V
      //   91: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	92	0	this	a
      //   0	92	1	paramb	e.b.b<? super R>
      //   21	34	2	localObject	Object
      //   66	12	2	localThrowable1	Throwable
      //   85	2	2	localThrowable2	Throwable
      // Exception table:
      //   from	to	target	type
      //   29	39	66	finally
      //   0	22	85	finally
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\flowable\a0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */