package io.reactivex.internal.operators.observable;

import io.reactivex.g0.j;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.queue.b;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.j0.a;
import io.reactivex.q;
import io.reactivex.t;
import io.reactivex.v;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class c<T, R>
  extends q<R>
{
  final t<? extends T>[] c;
  final Iterable<? extends t<? extends T>> d;
  final j<? super Object[], ? extends R> f;
  final int q;
  final boolean x;
  
  public c(t<? extends T>[] paramArrayOft, Iterable<? extends t<? extends T>> paramIterable, j<? super Object[], ? extends R> paramj, int paramInt, boolean paramBoolean)
  {
    this.c = paramArrayOft;
    this.d = paramIterable;
    this.f = paramj;
    this.q = paramInt;
    this.x = paramBoolean;
  }
  
  public void K0(v<? super R> paramv)
  {
    Object localObject1 = this.c;
    if (localObject1 == null)
    {
      Object localObject2 = new t[8];
      Iterator localIterator = this.d.iterator();
      int i = 0;
      for (;;)
      {
        localObject1 = localObject2;
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        t localt = (t)localIterator.next();
        localObject1 = localObject2;
        if (i == localObject2.length)
        {
          localObject1 = new t[(i >> 2) + i];
          System.arraycopy(localObject2, 0, localObject1, 0, i);
        }
        localObject1[i] = localt;
        i++;
        localObject2 = localObject1;
      }
    }
    int j = localObject1.length;
    if (j == 0)
    {
      EmptyDisposable.complete(paramv);
      return;
    }
    new b(paramv, this.f, j, this.q, this.x).i((t[])localObject1);
  }
  
  static final class a<T, R>
    extends AtomicReference<io.reactivex.e0.c>
    implements v<T>
  {
    final c.b<T, R> c;
    final int d;
    
    a(c.b<T, R> paramb, int paramInt)
    {
      this.c = paramb;
      this.d = paramInt;
    }
    
    public void a()
    {
      DisposableHelper.dispose(this);
    }
    
    public void onComplete()
    {
      this.c.f(this.d);
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.c.g(this.d, paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      this.c.h(this.d, paramT);
    }
    
    public void onSubscribe(io.reactivex.e0.c paramc)
    {
      DisposableHelper.setOnce(this, paramc);
    }
  }
  
  static final class b<T, R>
    extends AtomicInteger
    implements io.reactivex.e0.c
  {
    final v<? super R> c;
    final j<? super Object[], ? extends R> d;
    final c.a<T, R>[] f;
    volatile boolean p0;
    final AtomicThrowable p1 = new AtomicThrowable();
    int p2;
    int p3;
    Object[] q;
    final b<Object[]> x;
    final boolean y;
    volatile boolean z;
    
    b(v<? super R> paramv, j<? super Object[], ? extends R> paramj, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      this.c = paramv;
      this.d = paramj;
      this.y = paramBoolean;
      this.q = new Object[paramInt1];
      paramv = new c.a[paramInt1];
      for (int i = 0; i < paramInt1; i++) {
        paramv[i] = new c.a(this, i);
      }
      this.f = paramv;
      this.x = new b(paramInt2);
    }
    
    void a()
    {
      c.a[] arrayOfa = this.f;
      int i = arrayOfa.length;
      for (int j = 0; j < i; j++) {
        arrayOfa[j].a();
      }
    }
    
    void b(b<?> paramb)
    {
      try
      {
        this.q = null;
        paramb.clear();
        return;
      }
      finally {}
    }
    
    /* Error */
    void d()
    {
      // Byte code:
      //   0: aload_0
      //   1: invokevirtual 82	java/util/concurrent/atomic/AtomicInteger:getAndIncrement	()I
      //   4: ifeq +4 -> 8
      //   7: return
      //   8: aload_0
      //   9: getfield 67	io/reactivex/internal/operators/observable/c$b:x	Lio/reactivex/internal/queue/b;
      //   12: astore_1
      //   13: aload_0
      //   14: getfield 45	io/reactivex/internal/operators/observable/c$b:c	Lio/reactivex/v;
      //   17: astore_2
      //   18: aload_0
      //   19: getfield 49	io/reactivex/internal/operators/observable/c$b:y	Z
      //   22: istore_3
      //   23: iconst_1
      //   24: istore 4
      //   26: aload_0
      //   27: getfield 84	io/reactivex/internal/operators/observable/c$b:z	Z
      //   30: ifeq +9 -> 39
      //   33: aload_0
      //   34: aload_1
      //   35: invokevirtual 86	io/reactivex/internal/operators/observable/c$b:b	(Lio/reactivex/internal/queue/b;)V
      //   38: return
      //   39: iload_3
      //   40: ifne +36 -> 76
      //   43: aload_0
      //   44: getfield 43	io/reactivex/internal/operators/observable/c$b:p1	Lio/reactivex/internal/util/AtomicThrowable;
      //   47: invokevirtual 92	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
      //   50: ifnull +26 -> 76
      //   53: aload_0
      //   54: invokevirtual 93	io/reactivex/internal/operators/observable/c$b:a	()V
      //   57: aload_0
      //   58: aload_1
      //   59: invokevirtual 86	io/reactivex/internal/operators/observable/c$b:b	(Lio/reactivex/internal/queue/b;)V
      //   62: aload_2
      //   63: aload_0
      //   64: getfield 43	io/reactivex/internal/operators/observable/c$b:p1	Lio/reactivex/internal/util/AtomicThrowable;
      //   67: invokevirtual 97	io/reactivex/internal/util/AtomicThrowable:terminate	()Ljava/lang/Throwable;
      //   70: invokeinterface 103 2 0
      //   75: return
      //   76: aload_0
      //   77: getfield 105	io/reactivex/internal/operators/observable/c$b:p0	Z
      //   80: istore 5
      //   82: aload_1
      //   83: invokevirtual 108	io/reactivex/internal/queue/b:poll	()Ljava/lang/Object;
      //   86: checkcast 109	[Ljava/lang/Object;
      //   89: astore 6
      //   91: aload 6
      //   93: ifnonnull +9 -> 102
      //   96: iconst_1
      //   97: istore 7
      //   99: goto +6 -> 105
      //   102: iconst_0
      //   103: istore 7
      //   105: iload 5
      //   107: ifeq +42 -> 149
      //   110: iload 7
      //   112: ifeq +37 -> 149
      //   115: aload_0
      //   116: aload_1
      //   117: invokevirtual 86	io/reactivex/internal/operators/observable/c$b:b	(Lio/reactivex/internal/queue/b;)V
      //   120: aload_0
      //   121: getfield 43	io/reactivex/internal/operators/observable/c$b:p1	Lio/reactivex/internal/util/AtomicThrowable;
      //   124: invokevirtual 97	io/reactivex/internal/util/AtomicThrowable:terminate	()Ljava/lang/Throwable;
      //   127: astore_1
      //   128: aload_1
      //   129: ifnonnull +12 -> 141
      //   132: aload_2
      //   133: invokeinterface 112 1 0
      //   138: goto +10 -> 148
      //   141: aload_2
      //   142: aload_1
      //   143: invokeinterface 103 2 0
      //   148: return
      //   149: iload 7
      //   151: ifeq +22 -> 173
      //   154: aload_0
      //   155: iload 4
      //   157: ineg
      //   158: invokevirtual 116	java/util/concurrent/atomic/AtomicInteger:addAndGet	(I)I
      //   161: istore 7
      //   163: iload 7
      //   165: istore 4
      //   167: iload 7
      //   169: ifne -143 -> 26
      //   172: return
      //   173: aload_0
      //   174: getfield 47	io/reactivex/internal/operators/observable/c$b:d	Lio/reactivex/g0/j;
      //   177: aload 6
      //   179: invokeinterface 122 2 0
      //   184: ldc 124
      //   186: invokestatic 130	io/reactivex/h0/a/b:e	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
      //   189: astore 6
      //   191: aload_2
      //   192: aload 6
      //   194: invokeinterface 134 2 0
      //   199: goto -173 -> 26
      //   202: astore 6
      //   204: aload 6
      //   206: invokestatic 138	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
      //   209: aload_0
      //   210: getfield 43	io/reactivex/internal/operators/observable/c$b:p1	Lio/reactivex/internal/util/AtomicThrowable;
      //   213: aload 6
      //   215: invokevirtual 142	io/reactivex/internal/util/AtomicThrowable:addThrowable	(Ljava/lang/Throwable;)Z
      //   218: pop
      //   219: aload_0
      //   220: invokevirtual 93	io/reactivex/internal/operators/observable/c$b:a	()V
      //   223: aload_0
      //   224: aload_1
      //   225: invokevirtual 86	io/reactivex/internal/operators/observable/c$b:b	(Lio/reactivex/internal/queue/b;)V
      //   228: aload_2
      //   229: aload_0
      //   230: getfield 43	io/reactivex/internal/operators/observable/c$b:p1	Lio/reactivex/internal/util/AtomicThrowable;
      //   233: invokevirtual 97	io/reactivex/internal/util/AtomicThrowable:terminate	()Ljava/lang/Throwable;
      //   236: invokeinterface 103 2 0
      //   241: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	242	0	this	b
      //   12	213	1	localObject1	Object
      //   17	212	2	localv	v
      //   22	18	3	bool1	boolean
      //   24	142	4	i	int
      //   80	26	5	bool2	boolean
      //   89	104	6	localObject2	Object
      //   202	12	6	localThrowable	Throwable
      //   97	71	7	j	int
      // Exception table:
      //   from	to	target	type
      //   173	191	202	finally
    }
    
    public void dispose()
    {
      if (!this.z)
      {
        this.z = true;
        a();
        if (getAndIncrement() == 0) {
          b(this.x);
        }
      }
    }
    
    void f(int paramInt)
    {
      try
      {
        Object[] arrayOfObject = this.q;
        if (arrayOfObject == null) {
          return;
        }
        if (arrayOfObject[paramInt] == null) {
          paramInt = 1;
        } else {
          paramInt = 0;
        }
        if (paramInt == 0)
        {
          int i = this.p3 + 1;
          this.p3 = i;
          if (i != arrayOfObject.length) {}
        }
        else
        {
          this.p0 = true;
        }
        if (paramInt != 0) {
          a();
        }
        d();
        return;
      }
      finally {}
    }
    
    void g(int paramInt, Throwable paramThrowable)
    {
      if (this.p1.addThrowable(paramThrowable))
      {
        boolean bool = this.y;
        int i = 1;
        if (bool) {
          try
          {
            paramThrowable = this.q;
            if (paramThrowable == null) {
              return;
            }
            if (paramThrowable[paramInt] == null) {
              paramInt = 1;
            } else {
              paramInt = 0;
            }
            if (paramInt == 0)
            {
              i = this.p3 + 1;
              this.p3 = i;
              if (i != paramThrowable.length) {}
            }
            else
            {
              this.p0 = true;
            }
            i = paramInt;
          }
          finally {}
        }
        if (i != 0) {
          a();
        }
        d();
      }
      else
      {
        a.r(paramThrowable);
      }
    }
    
    void h(int paramInt, T paramT)
    {
      try
      {
        Object[] arrayOfObject = this.q;
        if (arrayOfObject == null) {
          return;
        }
        Object localObject = arrayOfObject[paramInt];
        int i = this.p2;
        int j = i;
        if (localObject == null)
        {
          j = i + 1;
          this.p2 = j;
        }
        arrayOfObject[paramInt] = paramT;
        if (j == arrayOfObject.length)
        {
          this.x.offer(arrayOfObject.clone());
          paramInt = 1;
        }
        else
        {
          paramInt = 0;
        }
        if (paramInt != 0) {
          d();
        }
        return;
      }
      finally {}
    }
    
    public void i(t<? extends T>[] paramArrayOft)
    {
      c.a[] arrayOfa = this.f;
      int i = arrayOfa.length;
      this.c.onSubscribe(this);
      for (int j = 0; (j < i) && (!this.p0) && (!this.z); j++) {
        paramArrayOft[j].a(arrayOfa[j]);
      }
    }
    
    public boolean isDisposed()
    {
      return this.z;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\observable\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */