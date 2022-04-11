package io.reactivex.internal.operators.observable;

import io.reactivex.e0.c;
import io.reactivex.g0.j;
import io.reactivex.h0.b.d;
import io.reactivex.h0.b.e;
import io.reactivex.h0.b.i;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.t;
import io.reactivex.v;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class x0<T, R>
  extends a<T, R>
{
  final j<? super T, ? extends t<? extends R>> d;
  final int f;
  final boolean q;
  
  public x0(t<T> paramt, j<? super T, ? extends t<? extends R>> paramj, int paramInt, boolean paramBoolean)
  {
    super(paramt);
    this.d = paramj;
    this.f = paramInt;
    this.q = paramBoolean;
  }
  
  public void K0(v<? super R> paramv)
  {
    if (ObservableScalarXMap.b(this.c, paramv, this.d)) {
      return;
    }
    this.c.a(new b(paramv, this.d, this.f, this.q));
  }
  
  static final class a<T, R>
    extends AtomicReference<c>
    implements v<R>
  {
    final x0.b<T, R> c;
    final long d;
    final int f;
    volatile i<R> q;
    volatile boolean x;
    
    a(x0.b<T, R> paramb, long paramLong, int paramInt)
    {
      this.c = paramb;
      this.d = paramLong;
      this.f = paramInt;
    }
    
    public void a()
    {
      DisposableHelper.dispose(this);
    }
    
    public void onComplete()
    {
      if (this.d == this.c.p3)
      {
        this.x = true;
        this.c.b();
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.c.d(this, paramThrowable);
    }
    
    public void onNext(R paramR)
    {
      if (this.d == this.c.p3)
      {
        if (paramR != null) {
          this.q.offer(paramR);
        }
        this.c.b();
      }
    }
    
    public void onSubscribe(c paramc)
    {
      if (DisposableHelper.setOnce(this, paramc))
      {
        if ((paramc instanceof d))
        {
          paramc = (d)paramc;
          int i = paramc.requestFusion(7);
          if (i == 1)
          {
            this.q = paramc;
            this.x = true;
            this.c.b();
            return;
          }
          if (i == 2)
          {
            this.q = paramc;
            return;
          }
        }
        this.q = new io.reactivex.internal.queue.b(this.f);
      }
    }
  }
  
  static final class b<T, R>
    extends AtomicInteger
    implements v<T>, c
  {
    static final x0.a<Object, Object> c;
    final v<? super R> d;
    final j<? super T, ? extends t<? extends R>> f;
    volatile boolean p0;
    c p1;
    final AtomicReference<x0.a<T, R>> p2 = new AtomicReference();
    volatile long p3;
    final int q;
    final boolean x;
    final AtomicThrowable y;
    volatile boolean z;
    
    static
    {
      x0.a locala = new x0.a(null, -1L, 1);
      c = locala;
      locala.a();
    }
    
    b(v<? super R> paramv, j<? super T, ? extends t<? extends R>> paramj, int paramInt, boolean paramBoolean)
    {
      this.d = paramv;
      this.f = paramj;
      this.q = paramInt;
      this.x = paramBoolean;
      this.y = new AtomicThrowable();
    }
    
    void a()
    {
      x0.a locala1 = (x0.a)this.p2.get();
      x0.a locala2 = c;
      if (locala1 != locala2)
      {
        locala1 = (x0.a)this.p2.getAndSet(locala2);
        if ((locala1 != locala2) && (locala1 != null)) {
          locala1.a();
        }
      }
    }
    
    /* Error */
    void b()
    {
      // Byte code:
      //   0: aload_0
      //   1: invokevirtual 87	java/util/concurrent/atomic/AtomicInteger:getAndIncrement	()I
      //   4: ifeq +4 -> 8
      //   7: return
      //   8: aload_0
      //   9: getfield 62	io/reactivex/internal/operators/observable/x0$b:d	Lio/reactivex/v;
      //   12: astore_1
      //   13: aload_0
      //   14: getfield 60	io/reactivex/internal/operators/observable/x0$b:p2	Ljava/util/concurrent/atomic/AtomicReference;
      //   17: astore_2
      //   18: aload_0
      //   19: getfield 68	io/reactivex/internal/operators/observable/x0$b:x	Z
      //   22: istore_3
      //   23: iconst_1
      //   24: istore 4
      //   26: aload_0
      //   27: getfield 89	io/reactivex/internal/operators/observable/x0$b:p0	Z
      //   30: ifeq +4 -> 34
      //   33: return
      //   34: aload_0
      //   35: getfield 91	io/reactivex/internal/operators/observable/x0$b:z	Z
      //   38: ifeq +102 -> 140
      //   41: aload_2
      //   42: invokevirtual 79	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
      //   45: ifnonnull +9 -> 54
      //   48: iconst_1
      //   49: istore 5
      //   51: goto +6 -> 57
      //   54: iconst_0
      //   55: istore 5
      //   57: iload_3
      //   58: ifeq +43 -> 101
      //   61: iload 5
      //   63: ifeq +77 -> 140
      //   66: aload_0
      //   67: getfield 73	io/reactivex/internal/operators/observable/x0$b:y	Lio/reactivex/internal/util/AtomicThrowable;
      //   70: invokevirtual 79	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
      //   73: checkcast 93	java/lang/Throwable
      //   76: astore 6
      //   78: aload 6
      //   80: ifnull +14 -> 94
      //   83: aload_1
      //   84: aload 6
      //   86: invokeinterface 97 2 0
      //   91: goto +9 -> 100
      //   94: aload_1
      //   95: invokeinterface 100 1 0
      //   100: return
      //   101: aload_0
      //   102: getfield 73	io/reactivex/internal/operators/observable/x0$b:y	Lio/reactivex/internal/util/AtomicThrowable;
      //   105: invokevirtual 79	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
      //   108: checkcast 93	java/lang/Throwable
      //   111: ifnull +17 -> 128
      //   114: aload_1
      //   115: aload_0
      //   116: getfield 73	io/reactivex/internal/operators/observable/x0$b:y	Lio/reactivex/internal/util/AtomicThrowable;
      //   119: invokevirtual 104	io/reactivex/internal/util/AtomicThrowable:terminate	()Ljava/lang/Throwable;
      //   122: invokeinterface 97 2 0
      //   127: return
      //   128: iload 5
      //   130: ifeq +10 -> 140
      //   133: aload_1
      //   134: invokeinterface 100 1 0
      //   139: return
      //   140: aload_2
      //   141: invokevirtual 79	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
      //   144: checkcast 40	io/reactivex/internal/operators/observable/x0$a
      //   147: astore 7
      //   149: aload 7
      //   151: ifnull +291 -> 442
      //   154: aload 7
      //   156: getfield 107	io/reactivex/internal/operators/observable/x0$a:q	Lio/reactivex/h0/b/i;
      //   159: astore 8
      //   161: aload 8
      //   163: ifnull +279 -> 442
      //   166: aload 7
      //   168: getfield 108	io/reactivex/internal/operators/observable/x0$a:x	Z
      //   171: ifeq +75 -> 246
      //   174: aload 8
      //   176: invokeinterface 114 1 0
      //   181: istore 9
      //   183: iload_3
      //   184: ifeq +19 -> 203
      //   187: iload 9
      //   189: ifeq +57 -> 246
      //   192: aload_2
      //   193: aload 7
      //   195: aconst_null
      //   196: invokevirtual 118	java/util/concurrent/atomic/AtomicReference:compareAndSet	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   199: pop
      //   200: goto -174 -> 26
      //   203: aload_0
      //   204: getfield 73	io/reactivex/internal/operators/observable/x0$b:y	Lio/reactivex/internal/util/AtomicThrowable;
      //   207: invokevirtual 79	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
      //   210: checkcast 93	java/lang/Throwable
      //   213: ifnull +17 -> 230
      //   216: aload_1
      //   217: aload_0
      //   218: getfield 73	io/reactivex/internal/operators/observable/x0$b:y	Lio/reactivex/internal/util/AtomicThrowable;
      //   221: invokevirtual 104	io/reactivex/internal/util/AtomicThrowable:terminate	()Ljava/lang/Throwable;
      //   224: invokeinterface 97 2 0
      //   229: return
      //   230: iload 9
      //   232: ifeq +14 -> 246
      //   235: aload_2
      //   236: aload 7
      //   238: aconst_null
      //   239: invokevirtual 118	java/util/concurrent/atomic/AtomicReference:compareAndSet	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   242: pop
      //   243: goto -217 -> 26
      //   246: iconst_0
      //   247: istore 5
      //   249: aload_0
      //   250: getfield 89	io/reactivex/internal/operators/observable/x0$b:p0	Z
      //   253: ifeq +4 -> 257
      //   256: return
      //   257: aload 7
      //   259: aload_2
      //   260: invokevirtual 79	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
      //   263: if_acmpeq +9 -> 272
      //   266: iconst_1
      //   267: istore 5
      //   269: goto +154 -> 423
      //   272: iload_3
      //   273: ifne +30 -> 303
      //   276: aload_0
      //   277: getfield 73	io/reactivex/internal/operators/observable/x0$b:y	Lio/reactivex/internal/util/AtomicThrowable;
      //   280: invokevirtual 79	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
      //   283: checkcast 93	java/lang/Throwable
      //   286: ifnull +17 -> 303
      //   289: aload_1
      //   290: aload_0
      //   291: getfield 73	io/reactivex/internal/operators/observable/x0$b:y	Lio/reactivex/internal/util/AtomicThrowable;
      //   294: invokevirtual 104	io/reactivex/internal/util/AtomicThrowable:terminate	()Ljava/lang/Throwable;
      //   297: invokeinterface 97 2 0
      //   302: return
      //   303: aload 7
      //   305: getfield 108	io/reactivex/internal/operators/observable/x0$a:x	Z
      //   308: istore 9
      //   310: aload 8
      //   312: invokeinterface 121 1 0
      //   317: astore 6
      //   319: goto +64 -> 383
      //   322: astore 6
      //   324: aload 6
      //   326: invokestatic 125	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
      //   329: aload_0
      //   330: getfield 73	io/reactivex/internal/operators/observable/x0$b:y	Lio/reactivex/internal/util/AtomicThrowable;
      //   333: aload 6
      //   335: invokevirtual 129	io/reactivex/internal/util/AtomicThrowable:addThrowable	(Ljava/lang/Throwable;)Z
      //   338: pop
      //   339: aload_2
      //   340: aload 7
      //   342: aconst_null
      //   343: invokevirtual 118	java/util/concurrent/atomic/AtomicReference:compareAndSet	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   346: pop
      //   347: iload_3
      //   348: ifne +24 -> 372
      //   351: aload_0
      //   352: invokevirtual 130	io/reactivex/internal/operators/observable/x0$b:a	()V
      //   355: aload_0
      //   356: getfield 132	io/reactivex/internal/operators/observable/x0$b:p1	Lio/reactivex/e0/c;
      //   359: invokeinterface 135 1 0
      //   364: aload_0
      //   365: iconst_1
      //   366: putfield 91	io/reactivex/internal/operators/observable/x0$b:z	Z
      //   369: goto +8 -> 377
      //   372: aload 7
      //   374: invokevirtual 51	io/reactivex/internal/operators/observable/x0$a:a	()V
      //   377: aconst_null
      //   378: astore 6
      //   380: iconst_1
      //   381: istore 5
      //   383: aload 6
      //   385: ifnonnull +9 -> 394
      //   388: iconst_1
      //   389: istore 10
      //   391: goto +6 -> 397
      //   394: iconst_0
      //   395: istore 10
      //   397: iload 9
      //   399: ifeq +19 -> 418
      //   402: iload 10
      //   404: ifeq +14 -> 418
      //   407: aload_2
      //   408: aload 7
      //   410: aconst_null
      //   411: invokevirtual 118	java/util/concurrent/atomic/AtomicReference:compareAndSet	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   414: pop
      //   415: goto -149 -> 266
      //   418: iload 10
      //   420: ifeq +11 -> 431
      //   423: iload 5
      //   425: ifeq +17 -> 442
      //   428: goto -402 -> 26
      //   431: aload_1
      //   432: aload 6
      //   434: invokeinterface 139 2 0
      //   439: goto -190 -> 249
      //   442: aload_0
      //   443: iload 4
      //   445: ineg
      //   446: invokevirtual 143	java/util/concurrent/atomic/AtomicInteger:addAndGet	(I)I
      //   449: istore 5
      //   451: iload 5
      //   453: istore 4
      //   455: iload 5
      //   457: ifne -431 -> 26
      //   460: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	461	0	this	b
      //   12	420	1	localv	v
      //   17	391	2	localAtomicReference	AtomicReference
      //   22	326	3	bool1	boolean
      //   24	430	4	i	int
      //   49	407	5	j	int
      //   76	242	6	localObject1	Object
      //   322	12	6	localThrowable	Throwable
      //   378	55	6	localObject2	Object
      //   147	262	7	locala	x0.a
      //   159	152	8	locali	i
      //   181	217	9	bool2	boolean
      //   389	30	10	k	int
      // Exception table:
      //   from	to	target	type
      //   310	319	322	finally
    }
    
    void d(x0.a<T, R> parama, Throwable paramThrowable)
    {
      if ((parama.d == this.p3) && (this.y.addThrowable(paramThrowable)))
      {
        if (!this.x)
        {
          this.p1.dispose();
          this.z = true;
        }
        parama.x = true;
        b();
      }
      else
      {
        io.reactivex.j0.a.r(paramThrowable);
      }
    }
    
    public void dispose()
    {
      if (!this.p0)
      {
        this.p0 = true;
        this.p1.dispose();
        a();
      }
    }
    
    public boolean isDisposed()
    {
      return this.p0;
    }
    
    public void onComplete()
    {
      if (!this.z)
      {
        this.z = true;
        b();
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      if ((!this.z) && (this.y.addThrowable(paramThrowable)))
      {
        if (!this.x) {
          a();
        }
        this.z = true;
        b();
      }
      else
      {
        io.reactivex.j0.a.r(paramThrowable);
      }
    }
    
    public void onNext(T paramT)
    {
      long l = this.p3 + 1L;
      this.p3 = l;
      x0.a locala1 = (x0.a)this.p2.get();
      if (locala1 != null) {
        locala1.a();
      }
      try
      {
        paramT = (t)io.reactivex.h0.a.b.e(this.f.apply(paramT), "The ObservableSource returned is null");
        x0.a locala2 = new x0.a(this, l, this.q);
        do
        {
          locala1 = (x0.a)this.p2.get();
          if (locala1 == c) {
            break;
          }
        } while (!this.p2.compareAndSet(locala1, locala2));
        paramT.a(locala2);
        return;
      }
      finally
      {
        io.reactivex.exceptions.a.b(paramT);
        this.p1.dispose();
        onError(paramT);
      }
    }
    
    public void onSubscribe(c paramc)
    {
      if (DisposableHelper.validate(this.p1, paramc))
      {
        this.p1 = paramc;
        this.d.onSubscribe(this);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\observable\x0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */