package io.reactivex.internal.operators.flowable;

import io.reactivex.g0.g;
import io.reactivex.h;

public final class e<T>
  extends a<T, T>
{
  final g<? super T> f;
  final g<? super Throwable> q;
  final io.reactivex.g0.a x;
  final io.reactivex.g0.a y;
  
  public e(h<T> paramh, g<? super T> paramg, g<? super Throwable> paramg1, io.reactivex.g0.a parama1, io.reactivex.g0.a parama2)
  {
    super(paramh);
    this.f = paramg;
    this.q = paramg1;
    this.x = parama1;
    this.y = parama2;
  }
  
  protected void H(e.b.b<? super T> paramb)
  {
    if ((paramb instanceof io.reactivex.h0.b.a)) {
      this.d.G(new a((io.reactivex.h0.b.a)paramb, this.f, this.q, this.x, this.y));
    } else {
      this.d.G(new b(paramb, this.f, this.q, this.x, this.y));
    }
  }
  
  static final class a<T>
    extends io.reactivex.internal.subscribers.a<T, T>
  {
    final io.reactivex.g0.a p0;
    final io.reactivex.g0.a p1;
    final g<? super T> y;
    final g<? super Throwable> z;
    
    a(io.reactivex.h0.b.a<? super T> parama, g<? super T> paramg, g<? super Throwable> paramg1, io.reactivex.g0.a parama1, io.reactivex.g0.a parama2)
    {
      super();
      this.y = paramg;
      this.z = paramg1;
      this.p0 = parama1;
      this.p1 = parama2;
    }
    
    public boolean b(T paramT)
    {
      if (this.q) {
        return false;
      }
      try
      {
        this.y.accept(paramT);
        return this.c.b(paramT);
      }
      finally
      {
        d(paramT);
      }
      return false;
    }
    
    /* Error */
    public void onComplete()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 38	io/reactivex/internal/subscribers/a:q	Z
      //   4: ifeq +4 -> 8
      //   7: return
      //   8: aload_0
      //   9: getfield 27	io/reactivex/internal/operators/flowable/e$a:p0	Lio/reactivex/g0/a;
      //   12: invokeinterface 64 1 0
      //   17: aload_0
      //   18: iconst_1
      //   19: putfield 38	io/reactivex/internal/subscribers/a:q	Z
      //   22: aload_0
      //   23: getfield 48	io/reactivex/internal/subscribers/a:c	Lio/reactivex/h0/b/a;
      //   26: invokeinterface 68 1 0
      //   31: aload_0
      //   32: getfield 29	io/reactivex/internal/operators/flowable/e$a:p1	Lio/reactivex/g0/a;
      //   35: invokeinterface 64 1 0
      //   40: goto +12 -> 52
      //   43: astore_1
      //   44: aload_1
      //   45: invokestatic 72	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
      //   48: aload_1
      //   49: invokestatic 77	io/reactivex/j0/a:r	(Ljava/lang/Throwable;)V
      //   52: return
      //   53: astore_1
      //   54: aload_0
      //   55: aload_1
      //   56: invokevirtual 56	io/reactivex/internal/subscribers/a:d	(Ljava/lang/Throwable;)V
      //   59: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	60	0	this	a
      //   43	6	1	localThrowable1	Throwable
      //   53	3	1	localThrowable2	Throwable
      // Exception table:
      //   from	to	target	type
      //   31	40	43	finally
      //   8	17	53	finally
    }
    
    /* Error */
    public void onError(Throwable paramThrowable)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 38	io/reactivex/internal/subscribers/a:q	Z
      //   4: ifeq +8 -> 12
      //   7: aload_1
      //   8: invokestatic 77	io/reactivex/j0/a:r	(Ljava/lang/Throwable;)V
      //   11: return
      //   12: iconst_1
      //   13: istore_2
      //   14: aload_0
      //   15: iconst_1
      //   16: putfield 38	io/reactivex/internal/subscribers/a:q	Z
      //   19: aload_0
      //   20: getfield 25	io/reactivex/internal/operators/flowable/e$a:z	Lio/reactivex/g0/g;
      //   23: aload_1
      //   24: invokeinterface 44 2 0
      //   29: goto +38 -> 67
      //   32: astore_3
      //   33: aload_3
      //   34: invokestatic 72	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
      //   37: aload_0
      //   38: getfield 48	io/reactivex/internal/subscribers/a:c	Lio/reactivex/h0/b/a;
      //   41: new 80	io/reactivex/exceptions/CompositeException
      //   44: dup
      //   45: iconst_2
      //   46: anewarray 82	java/lang/Throwable
      //   49: dup
      //   50: iconst_0
      //   51: aload_1
      //   52: aastore
      //   53: dup
      //   54: iconst_1
      //   55: aload_3
      //   56: aastore
      //   57: invokespecial 85	io/reactivex/exceptions/CompositeException:<init>	([Ljava/lang/Throwable;)V
      //   60: invokeinterface 87 2 0
      //   65: iconst_0
      //   66: istore_2
      //   67: iload_2
      //   68: ifeq +13 -> 81
      //   71: aload_0
      //   72: getfield 48	io/reactivex/internal/subscribers/a:c	Lio/reactivex/h0/b/a;
      //   75: aload_1
      //   76: invokeinterface 87 2 0
      //   81: aload_0
      //   82: getfield 29	io/reactivex/internal/operators/flowable/e$a:p1	Lio/reactivex/g0/a;
      //   85: invokeinterface 64 1 0
      //   90: goto +12 -> 102
      //   93: astore_1
      //   94: aload_1
      //   95: invokestatic 72	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
      //   98: aload_1
      //   99: invokestatic 77	io/reactivex/j0/a:r	(Ljava/lang/Throwable;)V
      //   102: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	103	0	this	a
      //   0	103	1	paramThrowable	Throwable
      //   13	55	2	i	int
      //   32	24	3	localThrowable	Throwable
      // Exception table:
      //   from	to	target	type
      //   19	29	32	finally
      //   81	90	93	finally
    }
    
    public void onNext(T paramT)
    {
      if (this.q) {
        return;
      }
      if (this.x != 0)
      {
        this.c.onNext(null);
        return;
      }
      try
      {
        this.y.accept(paramT);
        this.c.onNext(paramT);
        return;
      }
      finally
      {
        d(paramT);
      }
    }
    
    /* Error */
    public T poll()
      throws java.lang.Exception
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 103	io/reactivex/internal/subscribers/a:f	Lio/reactivex/h0/b/f;
      //   4: invokeinterface 107 1 0
      //   9: astore_1
      //   10: aload_1
      //   11: ifnull +80 -> 91
      //   14: aload_0
      //   15: getfield 23	io/reactivex/internal/operators/flowable/e$a:y	Lio/reactivex/g0/g;
      //   18: aload_1
      //   19: invokeinterface 44 2 0
      //   24: aload_0
      //   25: getfield 29	io/reactivex/internal/operators/flowable/e$a:p1	Lio/reactivex/g0/a;
      //   28: invokeinterface 64 1 0
      //   33: goto +84 -> 117
      //   36: astore_2
      //   37: aload_2
      //   38: invokestatic 72	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
      //   41: aload_0
      //   42: getfield 25	io/reactivex/internal/operators/flowable/e$a:z	Lio/reactivex/g0/g;
      //   45: aload_2
      //   46: invokeinterface 44 2 0
      //   51: aload_2
      //   52: invokestatic 112	io/reactivex/internal/util/e:c	(Ljava/lang/Throwable;)Ljava/lang/Exception;
      //   55: athrow
      //   56: astore_1
      //   57: new 80	io/reactivex/exceptions/CompositeException
      //   60: astore_3
      //   61: aload_3
      //   62: iconst_2
      //   63: anewarray 82	java/lang/Throwable
      //   66: dup
      //   67: iconst_0
      //   68: aload_2
      //   69: aastore
      //   70: dup
      //   71: iconst_1
      //   72: aload_1
      //   73: aastore
      //   74: invokespecial 85	io/reactivex/exceptions/CompositeException:<init>	([Ljava/lang/Throwable;)V
      //   77: aload_3
      //   78: athrow
      //   79: astore_1
      //   80: aload_0
      //   81: getfield 29	io/reactivex/internal/operators/flowable/e$a:p1	Lio/reactivex/g0/a;
      //   84: invokeinterface 64 1 0
      //   89: aload_1
      //   90: athrow
      //   91: aload_0
      //   92: getfield 92	io/reactivex/internal/subscribers/a:x	I
      //   95: iconst_1
      //   96: if_icmpne +21 -> 117
      //   99: aload_0
      //   100: getfield 27	io/reactivex/internal/operators/flowable/e$a:p0	Lio/reactivex/g0/a;
      //   103: invokeinterface 64 1 0
      //   108: aload_0
      //   109: getfield 29	io/reactivex/internal/operators/flowable/e$a:p1	Lio/reactivex/g0/a;
      //   112: invokeinterface 64 1 0
      //   117: aload_1
      //   118: areturn
      //   119: astore_1
      //   120: aload_1
      //   121: invokestatic 72	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
      //   124: aload_0
      //   125: getfield 25	io/reactivex/internal/operators/flowable/e$a:z	Lio/reactivex/g0/g;
      //   128: aload_1
      //   129: invokeinterface 44 2 0
      //   134: aload_1
      //   135: invokestatic 112	io/reactivex/internal/util/e:c	(Ljava/lang/Throwable;)Ljava/lang/Exception;
      //   138: athrow
      //   139: astore_3
      //   140: new 80	io/reactivex/exceptions/CompositeException
      //   143: dup
      //   144: iconst_2
      //   145: anewarray 82	java/lang/Throwable
      //   148: dup
      //   149: iconst_0
      //   150: aload_1
      //   151: aastore
      //   152: dup
      //   153: iconst_1
      //   154: aload_3
      //   155: aastore
      //   156: invokespecial 85	io/reactivex/exceptions/CompositeException:<init>	([Ljava/lang/Throwable;)V
      //   159: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	160	0	this	a
      //   9	10	1	localObject1	Object
      //   56	17	1	localObject2	Object
      //   79	39	1	?	T
      //   119	32	1	localThrowable1	Throwable
      //   36	33	2	localThrowable2	Throwable
      //   60	18	3	localCompositeException	io.reactivex.exceptions.CompositeException
      //   139	16	3	localObject3	Object
      // Exception table:
      //   from	to	target	type
      //   14	24	36	finally
      //   41	51	56	finally
      //   37	41	79	finally
      //   51	56	79	finally
      //   57	79	79	finally
      //   0	10	119	finally
      //   124	134	139	finally
    }
    
    public int requestFusion(int paramInt)
    {
      return e(paramInt);
    }
  }
  
  static final class b<T>
    extends io.reactivex.internal.subscribers.b<T, T>
  {
    final io.reactivex.g0.a p0;
    final io.reactivex.g0.a p1;
    final g<? super T> y;
    final g<? super Throwable> z;
    
    b(e.b.b<? super T> paramb, g<? super T> paramg, g<? super Throwable> paramg1, io.reactivex.g0.a parama1, io.reactivex.g0.a parama2)
    {
      super();
      this.y = paramg;
      this.z = paramg1;
      this.p0 = parama1;
      this.p1 = parama2;
    }
    
    /* Error */
    public void onComplete()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 38	io/reactivex/internal/subscribers/b:q	Z
      //   4: ifeq +4 -> 8
      //   7: return
      //   8: aload_0
      //   9: getfield 27	io/reactivex/internal/operators/flowable/e$b:p0	Lio/reactivex/g0/a;
      //   12: invokeinterface 43 1 0
      //   17: aload_0
      //   18: iconst_1
      //   19: putfield 38	io/reactivex/internal/subscribers/b:q	Z
      //   22: aload_0
      //   23: getfield 47	io/reactivex/internal/subscribers/b:c	Le/b/b;
      //   26: invokeinterface 51 1 0
      //   31: aload_0
      //   32: getfield 29	io/reactivex/internal/operators/flowable/e$b:p1	Lio/reactivex/g0/a;
      //   35: invokeinterface 43 1 0
      //   40: goto +12 -> 52
      //   43: astore_1
      //   44: aload_1
      //   45: invokestatic 56	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
      //   48: aload_1
      //   49: invokestatic 61	io/reactivex/j0/a:r	(Ljava/lang/Throwable;)V
      //   52: return
      //   53: astore_1
      //   54: aload_0
      //   55: aload_1
      //   56: invokevirtual 64	io/reactivex/internal/subscribers/b:d	(Ljava/lang/Throwable;)V
      //   59: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	60	0	this	b
      //   43	6	1	localThrowable1	Throwable
      //   53	3	1	localThrowable2	Throwable
      // Exception table:
      //   from	to	target	type
      //   31	40	43	finally
      //   8	17	53	finally
    }
    
    /* Error */
    public void onError(Throwable paramThrowable)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 38	io/reactivex/internal/subscribers/b:q	Z
      //   4: ifeq +8 -> 12
      //   7: aload_1
      //   8: invokestatic 61	io/reactivex/j0/a:r	(Ljava/lang/Throwable;)V
      //   11: return
      //   12: iconst_1
      //   13: istore_2
      //   14: aload_0
      //   15: iconst_1
      //   16: putfield 38	io/reactivex/internal/subscribers/b:q	Z
      //   19: aload_0
      //   20: getfield 25	io/reactivex/internal/operators/flowable/e$b:z	Lio/reactivex/g0/g;
      //   23: aload_1
      //   24: invokeinterface 71 2 0
      //   29: goto +38 -> 67
      //   32: astore_3
      //   33: aload_3
      //   34: invokestatic 56	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
      //   37: aload_0
      //   38: getfield 47	io/reactivex/internal/subscribers/b:c	Le/b/b;
      //   41: new 73	io/reactivex/exceptions/CompositeException
      //   44: dup
      //   45: iconst_2
      //   46: anewarray 75	java/lang/Throwable
      //   49: dup
      //   50: iconst_0
      //   51: aload_1
      //   52: aastore
      //   53: dup
      //   54: iconst_1
      //   55: aload_3
      //   56: aastore
      //   57: invokespecial 78	io/reactivex/exceptions/CompositeException:<init>	([Ljava/lang/Throwable;)V
      //   60: invokeinterface 80 2 0
      //   65: iconst_0
      //   66: istore_2
      //   67: iload_2
      //   68: ifeq +13 -> 81
      //   71: aload_0
      //   72: getfield 47	io/reactivex/internal/subscribers/b:c	Le/b/b;
      //   75: aload_1
      //   76: invokeinterface 80 2 0
      //   81: aload_0
      //   82: getfield 29	io/reactivex/internal/operators/flowable/e$b:p1	Lio/reactivex/g0/a;
      //   85: invokeinterface 43 1 0
      //   90: goto +12 -> 102
      //   93: astore_1
      //   94: aload_1
      //   95: invokestatic 56	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
      //   98: aload_1
      //   99: invokestatic 61	io/reactivex/j0/a:r	(Ljava/lang/Throwable;)V
      //   102: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	103	0	this	b
      //   0	103	1	paramThrowable	Throwable
      //   13	55	2	i	int
      //   32	24	3	localThrowable	Throwable
      // Exception table:
      //   from	to	target	type
      //   19	29	32	finally
      //   81	90	93	finally
    }
    
    public void onNext(T paramT)
    {
      if (this.q) {
        return;
      }
      if (this.x != 0)
      {
        this.c.onNext(null);
        return;
      }
      try
      {
        this.y.accept(paramT);
        this.c.onNext(paramT);
        return;
      }
      finally
      {
        d(paramT);
      }
    }
    
    /* Error */
    public T poll()
      throws java.lang.Exception
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 96	io/reactivex/internal/subscribers/b:f	Lio/reactivex/h0/b/f;
      //   4: invokeinterface 100 1 0
      //   9: astore_1
      //   10: aload_1
      //   11: ifnull +80 -> 91
      //   14: aload_0
      //   15: getfield 23	io/reactivex/internal/operators/flowable/e$b:y	Lio/reactivex/g0/g;
      //   18: aload_1
      //   19: invokeinterface 71 2 0
      //   24: aload_0
      //   25: getfield 29	io/reactivex/internal/operators/flowable/e$b:p1	Lio/reactivex/g0/a;
      //   28: invokeinterface 43 1 0
      //   33: goto +84 -> 117
      //   36: astore_2
      //   37: aload_2
      //   38: invokestatic 56	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
      //   41: aload_0
      //   42: getfield 25	io/reactivex/internal/operators/flowable/e$b:z	Lio/reactivex/g0/g;
      //   45: aload_2
      //   46: invokeinterface 71 2 0
      //   51: aload_2
      //   52: invokestatic 105	io/reactivex/internal/util/e:c	(Ljava/lang/Throwable;)Ljava/lang/Exception;
      //   55: athrow
      //   56: astore_1
      //   57: new 73	io/reactivex/exceptions/CompositeException
      //   60: astore_3
      //   61: aload_3
      //   62: iconst_2
      //   63: anewarray 75	java/lang/Throwable
      //   66: dup
      //   67: iconst_0
      //   68: aload_2
      //   69: aastore
      //   70: dup
      //   71: iconst_1
      //   72: aload_1
      //   73: aastore
      //   74: invokespecial 78	io/reactivex/exceptions/CompositeException:<init>	([Ljava/lang/Throwable;)V
      //   77: aload_3
      //   78: athrow
      //   79: astore_1
      //   80: aload_0
      //   81: getfield 29	io/reactivex/internal/operators/flowable/e$b:p1	Lio/reactivex/g0/a;
      //   84: invokeinterface 43 1 0
      //   89: aload_1
      //   90: athrow
      //   91: aload_0
      //   92: getfield 85	io/reactivex/internal/subscribers/b:x	I
      //   95: iconst_1
      //   96: if_icmpne +21 -> 117
      //   99: aload_0
      //   100: getfield 27	io/reactivex/internal/operators/flowable/e$b:p0	Lio/reactivex/g0/a;
      //   103: invokeinterface 43 1 0
      //   108: aload_0
      //   109: getfield 29	io/reactivex/internal/operators/flowable/e$b:p1	Lio/reactivex/g0/a;
      //   112: invokeinterface 43 1 0
      //   117: aload_1
      //   118: areturn
      //   119: astore_1
      //   120: aload_1
      //   121: invokestatic 56	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
      //   124: aload_0
      //   125: getfield 25	io/reactivex/internal/operators/flowable/e$b:z	Lio/reactivex/g0/g;
      //   128: aload_1
      //   129: invokeinterface 71 2 0
      //   134: aload_1
      //   135: invokestatic 105	io/reactivex/internal/util/e:c	(Ljava/lang/Throwable;)Ljava/lang/Exception;
      //   138: athrow
      //   139: astore_3
      //   140: new 73	io/reactivex/exceptions/CompositeException
      //   143: dup
      //   144: iconst_2
      //   145: anewarray 75	java/lang/Throwable
      //   148: dup
      //   149: iconst_0
      //   150: aload_1
      //   151: aastore
      //   152: dup
      //   153: iconst_1
      //   154: aload_3
      //   155: aastore
      //   156: invokespecial 78	io/reactivex/exceptions/CompositeException:<init>	([Ljava/lang/Throwable;)V
      //   159: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	160	0	this	b
      //   9	10	1	localObject1	Object
      //   56	17	1	localObject2	Object
      //   79	39	1	?	T
      //   119	32	1	localThrowable1	Throwable
      //   36	33	2	localThrowable2	Throwable
      //   60	18	3	localCompositeException	io.reactivex.exceptions.CompositeException
      //   139	16	3	localObject3	Object
      // Exception table:
      //   from	to	target	type
      //   14	24	36	finally
      //   41	51	56	finally
      //   37	41	79	finally
      //   51	56	79	finally
      //   57	79	79	finally
      //   0	10	119	finally
      //   124	134	139	finally
    }
    
    public int requestFusion(int paramInt)
    {
      return e(paramInt);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\flowable\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */