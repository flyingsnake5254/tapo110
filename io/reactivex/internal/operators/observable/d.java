package io.reactivex.internal.operators.observable;

import io.reactivex.e0.c;
import io.reactivex.g0.j;
import io.reactivex.h0.b.e;
import io.reactivex.h0.b.i;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.b;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.t;
import io.reactivex.v;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class d<T, U>
  extends a<T, U>
{
  final j<? super T, ? extends t<? extends U>> d;
  final int f;
  final ErrorMode q;
  
  public d(t<T> paramt, j<? super T, ? extends t<? extends U>> paramj, int paramInt, ErrorMode paramErrorMode)
  {
    super(paramt);
    this.d = paramj;
    this.q = paramErrorMode;
    this.f = Math.max(8, paramInt);
  }
  
  public void K0(v<? super U> paramv)
  {
    if (ObservableScalarXMap.b(this.c, paramv, this.d)) {
      return;
    }
    if (this.q == ErrorMode.IMMEDIATE)
    {
      paramv = new io.reactivex.observers.d(paramv);
      this.c.a(new b(paramv, this.d, this.f));
    }
    else
    {
      t localt = this.c;
      j localj = this.d;
      int i = this.f;
      boolean bool;
      if (this.q == ErrorMode.END) {
        bool = true;
      } else {
        bool = false;
      }
      localt.a(new a(paramv, localj, i, bool));
    }
  }
  
  static final class a<T, R>
    extends AtomicInteger
    implements v<T>, c
  {
    int H3;
    final v<? super R> c;
    final j<? super T, ? extends t<? extends R>> d;
    final int f;
    c p0;
    volatile boolean p1;
    volatile boolean p2;
    volatile boolean p3;
    final AtomicThrowable q;
    final a<R> x;
    final boolean y;
    i<T> z;
    
    a(v<? super R> paramv, j<? super T, ? extends t<? extends R>> paramj, int paramInt, boolean paramBoolean)
    {
      this.c = paramv;
      this.d = paramj;
      this.f = paramInt;
      this.y = paramBoolean;
      this.q = new AtomicThrowable();
      this.x = new a(paramv, this);
    }
    
    /* Error */
    void a()
    {
      // Byte code:
      //   0: aload_0
      //   1: invokevirtual 68	java/util/concurrent/atomic/AtomicInteger:getAndIncrement	()I
      //   4: ifeq +4 -> 8
      //   7: return
      //   8: aload_0
      //   9: getfield 45	io/reactivex/internal/operators/observable/d$a:c	Lio/reactivex/v;
      //   12: astore_1
      //   13: aload_0
      //   14: getfield 70	io/reactivex/internal/operators/observable/d$a:z	Lio/reactivex/h0/b/i;
      //   17: astore_2
      //   18: aload_0
      //   19: getfield 56	io/reactivex/internal/operators/observable/d$a:q	Lio/reactivex/internal/util/AtomicThrowable;
      //   22: astore_3
      //   23: aload_0
      //   24: getfield 72	io/reactivex/internal/operators/observable/d$a:p1	Z
      //   27: ifne +311 -> 338
      //   30: aload_0
      //   31: getfield 74	io/reactivex/internal/operators/observable/d$a:p3	Z
      //   34: ifeq +10 -> 44
      //   37: aload_2
      //   38: invokeinterface 79 1 0
      //   43: return
      //   44: aload_0
      //   45: getfield 51	io/reactivex/internal/operators/observable/d$a:y	Z
      //   48: ifne +35 -> 83
      //   51: aload_3
      //   52: invokevirtual 85	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
      //   55: checkcast 87	java/lang/Throwable
      //   58: ifnull +25 -> 83
      //   61: aload_2
      //   62: invokeinterface 79 1 0
      //   67: aload_0
      //   68: iconst_1
      //   69: putfield 74	io/reactivex/internal/operators/observable/d$a:p3	Z
      //   72: aload_1
      //   73: aload_3
      //   74: invokevirtual 91	io/reactivex/internal/util/AtomicThrowable:terminate	()Ljava/lang/Throwable;
      //   77: invokeinterface 95 2 0
      //   82: return
      //   83: aload_0
      //   84: getfield 97	io/reactivex/internal/operators/observable/d$a:p2	Z
      //   87: istore 4
      //   89: aload_2
      //   90: invokeinterface 100 1 0
      //   95: astore 5
      //   97: aload 5
      //   99: ifnonnull +9 -> 108
      //   102: iconst_1
      //   103: istore 6
      //   105: goto +6 -> 111
      //   108: iconst_0
      //   109: istore 6
      //   111: iload 4
      //   113: ifeq +39 -> 152
      //   116: iload 6
      //   118: ifeq +34 -> 152
      //   121: aload_0
      //   122: iconst_1
      //   123: putfield 74	io/reactivex/internal/operators/observable/d$a:p3	Z
      //   126: aload_3
      //   127: invokevirtual 91	io/reactivex/internal/util/AtomicThrowable:terminate	()Ljava/lang/Throwable;
      //   130: astore_3
      //   131: aload_3
      //   132: ifnull +13 -> 145
      //   135: aload_1
      //   136: aload_3
      //   137: invokeinterface 95 2 0
      //   142: goto +9 -> 151
      //   145: aload_1
      //   146: invokeinterface 103 1 0
      //   151: return
      //   152: iload 6
      //   154: ifne +184 -> 338
      //   157: aload_0
      //   158: getfield 47	io/reactivex/internal/operators/observable/d$a:d	Lio/reactivex/g0/j;
      //   161: aload 5
      //   163: invokeinterface 109 2 0
      //   168: ldc 111
      //   170: invokestatic 117	io/reactivex/h0/a/b:e	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
      //   173: checkcast 119	io/reactivex/t
      //   176: astore 5
      //   178: aload 5
      //   180: instanceof 121
      //   183: ifeq +55 -> 238
      //   186: aload 5
      //   188: checkcast 121	java/util/concurrent/Callable
      //   191: invokeinterface 124 1 0
      //   196: astore 5
      //   198: aload 5
      //   200: ifnull -177 -> 23
      //   203: aload_0
      //   204: getfield 74	io/reactivex/internal/operators/observable/d$a:p3	Z
      //   207: ifne -184 -> 23
      //   210: aload_1
      //   211: aload 5
      //   213: invokeinterface 128 2 0
      //   218: goto -195 -> 23
      //   221: astore 5
      //   223: aload 5
      //   225: invokestatic 133	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
      //   228: aload_3
      //   229: aload 5
      //   231: invokevirtual 137	io/reactivex/internal/util/AtomicThrowable:addThrowable	(Ljava/lang/Throwable;)Z
      //   234: pop
      //   235: goto -212 -> 23
      //   238: aload_0
      //   239: iconst_1
      //   240: putfield 72	io/reactivex/internal/operators/observable/d$a:p1	Z
      //   243: aload 5
      //   245: aload_0
      //   246: getfield 61	io/reactivex/internal/operators/observable/d$a:x	Lio/reactivex/internal/operators/observable/d$a$a;
      //   249: invokeinterface 140 2 0
      //   254: goto +84 -> 338
      //   257: astore 5
      //   259: aload 5
      //   261: invokestatic 133	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
      //   264: aload_0
      //   265: iconst_1
      //   266: putfield 74	io/reactivex/internal/operators/observable/d$a:p3	Z
      //   269: aload_0
      //   270: getfield 142	io/reactivex/internal/operators/observable/d$a:p0	Lio/reactivex/e0/c;
      //   273: invokeinterface 145 1 0
      //   278: aload_2
      //   279: invokeinterface 79 1 0
      //   284: aload_3
      //   285: aload 5
      //   287: invokevirtual 137	io/reactivex/internal/util/AtomicThrowable:addThrowable	(Ljava/lang/Throwable;)Z
      //   290: pop
      //   291: aload_1
      //   292: aload_3
      //   293: invokevirtual 91	io/reactivex/internal/util/AtomicThrowable:terminate	()Ljava/lang/Throwable;
      //   296: invokeinterface 95 2 0
      //   301: return
      //   302: astore_2
      //   303: aload_2
      //   304: invokestatic 133	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
      //   307: aload_0
      //   308: iconst_1
      //   309: putfield 74	io/reactivex/internal/operators/observable/d$a:p3	Z
      //   312: aload_0
      //   313: getfield 142	io/reactivex/internal/operators/observable/d$a:p0	Lio/reactivex/e0/c;
      //   316: invokeinterface 145 1 0
      //   321: aload_3
      //   322: aload_2
      //   323: invokevirtual 137	io/reactivex/internal/util/AtomicThrowable:addThrowable	(Ljava/lang/Throwable;)Z
      //   326: pop
      //   327: aload_1
      //   328: aload_3
      //   329: invokevirtual 91	io/reactivex/internal/util/AtomicThrowable:terminate	()Ljava/lang/Throwable;
      //   332: invokeinterface 95 2 0
      //   337: return
      //   338: aload_0
      //   339: invokevirtual 148	java/util/concurrent/atomic/AtomicInteger:decrementAndGet	()I
      //   342: ifne -319 -> 23
      //   345: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	346	0	this	a
      //   12	316	1	localv	v
      //   17	262	2	locali	i
      //   302	21	2	localThrowable1	Throwable
      //   22	307	3	localObject1	Object
      //   87	25	4	bool	boolean
      //   95	117	5	localObject2	Object
      //   221	23	5	localThrowable2	Throwable
      //   257	29	5	localThrowable3	Throwable
      //   103	50	6	i	int
      // Exception table:
      //   from	to	target	type
      //   186	198	221	finally
      //   157	178	257	finally
      //   89	97	302	finally
    }
    
    public void dispose()
    {
      this.p3 = true;
      this.p0.dispose();
      this.x.a();
    }
    
    public boolean isDisposed()
    {
      return this.p3;
    }
    
    public void onComplete()
    {
      this.p2 = true;
      a();
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.q.addThrowable(paramThrowable))
      {
        this.p2 = true;
        a();
      }
      else
      {
        io.reactivex.j0.a.r(paramThrowable);
      }
    }
    
    public void onNext(T paramT)
    {
      if (this.H3 == 0) {
        this.z.offer(paramT);
      }
      a();
    }
    
    public void onSubscribe(c paramc)
    {
      if (DisposableHelper.validate(this.p0, paramc))
      {
        this.p0 = paramc;
        if ((paramc instanceof io.reactivex.h0.b.d))
        {
          paramc = (io.reactivex.h0.b.d)paramc;
          int i = paramc.requestFusion(3);
          if (i == 1)
          {
            this.H3 = i;
            this.z = paramc;
            this.p2 = true;
            this.c.onSubscribe(this);
            a();
            return;
          }
          if (i == 2)
          {
            this.H3 = i;
            this.z = paramc;
            this.c.onSubscribe(this);
            return;
          }
        }
        this.z = new b(this.f);
        this.c.onSubscribe(this);
      }
    }
    
    static final class a<R>
      extends AtomicReference<c>
      implements v<R>
    {
      final v<? super R> c;
      final d.a<?, R> d;
      
      a(v<? super R> paramv, d.a<?, R> parama)
      {
        this.c = paramv;
        this.d = parama;
      }
      
      void a()
      {
        DisposableHelper.dispose(this);
      }
      
      public void onComplete()
      {
        d.a locala = this.d;
        locala.p1 = false;
        locala.a();
      }
      
      public void onError(Throwable paramThrowable)
      {
        d.a locala = this.d;
        if (locala.q.addThrowable(paramThrowable))
        {
          if (!locala.y) {
            locala.p0.dispose();
          }
          locala.p1 = false;
          locala.a();
        }
        else
        {
          io.reactivex.j0.a.r(paramThrowable);
        }
      }
      
      public void onNext(R paramR)
      {
        this.c.onNext(paramR);
      }
      
      public void onSubscribe(c paramc)
      {
        DisposableHelper.replace(this, paramc);
      }
    }
  }
  
  static final class b<T, U>
    extends AtomicInteger
    implements v<T>, c
  {
    final v<? super U> c;
    final j<? super T, ? extends t<? extends U>> d;
    final a<U> f;
    volatile boolean p0;
    volatile boolean p1;
    int p2;
    final int q;
    i<T> x;
    c y;
    volatile boolean z;
    
    b(v<? super U> paramv, j<? super T, ? extends t<? extends U>> paramj, int paramInt)
    {
      this.c = paramv;
      this.d = paramj;
      this.q = paramInt;
      this.f = new a(paramv, this);
    }
    
    /* Error */
    void a()
    {
      // Byte code:
      //   0: aload_0
      //   1: invokevirtual 59	java/util/concurrent/atomic/AtomicInteger:getAndIncrement	()I
      //   4: ifeq +4 -> 8
      //   7: return
      //   8: aload_0
      //   9: getfield 61	io/reactivex/internal/operators/observable/d$b:p0	Z
      //   12: ifeq +13 -> 25
      //   15: aload_0
      //   16: getfield 63	io/reactivex/internal/operators/observable/d$b:x	Lio/reactivex/h0/b/i;
      //   19: invokeinterface 68 1 0
      //   24: return
      //   25: aload_0
      //   26: getfield 70	io/reactivex/internal/operators/observable/d$b:z	Z
      //   29: ifne +151 -> 180
      //   32: aload_0
      //   33: getfield 72	io/reactivex/internal/operators/observable/d$b:p1	Z
      //   36: istore_1
      //   37: aload_0
      //   38: getfield 63	io/reactivex/internal/operators/observable/d$b:x	Lio/reactivex/h0/b/i;
      //   41: invokeinterface 76 1 0
      //   46: astore_2
      //   47: aload_2
      //   48: ifnonnull +8 -> 56
      //   51: iconst_1
      //   52: istore_3
      //   53: goto +5 -> 58
      //   56: iconst_0
      //   57: istore_3
      //   58: iload_1
      //   59: ifeq +22 -> 81
      //   62: iload_3
      //   63: ifeq +18 -> 81
      //   66: aload_0
      //   67: iconst_1
      //   68: putfield 61	io/reactivex/internal/operators/observable/d$b:p0	Z
      //   71: aload_0
      //   72: getfield 43	io/reactivex/internal/operators/observable/d$b:c	Lio/reactivex/v;
      //   75: invokeinterface 79 1 0
      //   80: return
      //   81: iload_3
      //   82: ifne +98 -> 180
      //   85: aload_0
      //   86: getfield 45	io/reactivex/internal/operators/observable/d$b:d	Lio/reactivex/g0/j;
      //   89: aload_2
      //   90: invokeinterface 85 2 0
      //   95: ldc 87
      //   97: invokestatic 93	io/reactivex/h0/a/b:e	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
      //   100: checkcast 95	io/reactivex/t
      //   103: astore_2
      //   104: aload_0
      //   105: iconst_1
      //   106: putfield 70	io/reactivex/internal/operators/observable/d$b:z	Z
      //   109: aload_2
      //   110: aload_0
      //   111: getfield 52	io/reactivex/internal/operators/observable/d$b:f	Lio/reactivex/internal/operators/observable/d$b$a;
      //   114: invokeinterface 98 2 0
      //   119: goto +61 -> 180
      //   122: astore_2
      //   123: aload_2
      //   124: invokestatic 103	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
      //   127: aload_0
      //   128: invokevirtual 106	io/reactivex/internal/operators/observable/d$b:dispose	()V
      //   131: aload_0
      //   132: getfield 63	io/reactivex/internal/operators/observable/d$b:x	Lio/reactivex/h0/b/i;
      //   135: invokeinterface 68 1 0
      //   140: aload_0
      //   141: getfield 43	io/reactivex/internal/operators/observable/d$b:c	Lio/reactivex/v;
      //   144: aload_2
      //   145: invokeinterface 109 2 0
      //   150: return
      //   151: astore_2
      //   152: aload_2
      //   153: invokestatic 103	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
      //   156: aload_0
      //   157: invokevirtual 106	io/reactivex/internal/operators/observable/d$b:dispose	()V
      //   160: aload_0
      //   161: getfield 63	io/reactivex/internal/operators/observable/d$b:x	Lio/reactivex/h0/b/i;
      //   164: invokeinterface 68 1 0
      //   169: aload_0
      //   170: getfield 43	io/reactivex/internal/operators/observable/d$b:c	Lio/reactivex/v;
      //   173: aload_2
      //   174: invokeinterface 109 2 0
      //   179: return
      //   180: aload_0
      //   181: invokevirtual 112	java/util/concurrent/atomic/AtomicInteger:decrementAndGet	()I
      //   184: ifne -176 -> 8
      //   187: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	188	0	this	b
      //   36	23	1	bool	boolean
      //   46	64	2	localObject	Object
      //   122	23	2	localThrowable1	Throwable
      //   151	23	2	localThrowable2	Throwable
      //   52	30	3	i	int
      // Exception table:
      //   from	to	target	type
      //   85	104	122	finally
      //   37	47	151	finally
    }
    
    void b()
    {
      this.z = false;
      a();
    }
    
    public void dispose()
    {
      this.p0 = true;
      this.f.a();
      this.y.dispose();
      if (getAndIncrement() == 0) {
        this.x.clear();
      }
    }
    
    public boolean isDisposed()
    {
      return this.p0;
    }
    
    public void onComplete()
    {
      if (this.p1) {
        return;
      }
      this.p1 = true;
      a();
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.p1)
      {
        io.reactivex.j0.a.r(paramThrowable);
        return;
      }
      this.p1 = true;
      dispose();
      this.c.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      if (this.p1) {
        return;
      }
      if (this.p2 == 0) {
        this.x.offer(paramT);
      }
      a();
    }
    
    public void onSubscribe(c paramc)
    {
      if (DisposableHelper.validate(this.y, paramc))
      {
        this.y = paramc;
        if ((paramc instanceof io.reactivex.h0.b.d))
        {
          paramc = (io.reactivex.h0.b.d)paramc;
          int i = paramc.requestFusion(3);
          if (i == 1)
          {
            this.p2 = i;
            this.x = paramc;
            this.p1 = true;
            this.c.onSubscribe(this);
            a();
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
    
    static final class a<U>
      extends AtomicReference<c>
      implements v<U>
    {
      final v<? super U> c;
      final d.b<?, ?> d;
      
      a(v<? super U> paramv, d.b<?, ?> paramb)
      {
        this.c = paramv;
        this.d = paramb;
      }
      
      void a()
      {
        DisposableHelper.dispose(this);
      }
      
      public void onComplete()
      {
        this.d.b();
      }
      
      public void onError(Throwable paramThrowable)
      {
        this.d.dispose();
        this.c.onError(paramThrowable);
      }
      
      public void onNext(U paramU)
      {
        this.c.onNext(paramU);
      }
      
      public void onSubscribe(c paramc)
      {
        DisposableHelper.replace(this, paramc);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\observable\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */