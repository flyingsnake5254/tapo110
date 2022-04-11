package io.reactivex.internal.operators.observable;

import io.reactivex.e0.c;
import io.reactivex.g0.j;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.queue.b;
import io.reactivex.q;
import io.reactivex.t;
import io.reactivex.v;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class h1<T, R>
  extends q<R>
{
  final t<? extends T>[] c;
  final Iterable<? extends t<? extends T>> d;
  final j<? super Object[], ? extends R> f;
  final int q;
  final boolean x;
  
  public h1(t<? extends T>[] paramArrayOft, Iterable<? extends t<? extends T>> paramIterable, j<? super Object[], ? extends R> paramj, int paramInt, boolean paramBoolean)
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
    new a(paramv, this.f, j, this.x).h((t[])localObject1, this.q);
  }
  
  static final class a<T, R>
    extends AtomicInteger
    implements c
  {
    final v<? super R> c;
    final j<? super Object[], ? extends R> d;
    final h1.b<T, R>[] f;
    final T[] q;
    final boolean x;
    volatile boolean y;
    
    a(v<? super R> paramv, j<? super Object[], ? extends R> paramj, int paramInt, boolean paramBoolean)
    {
      this.c = paramv;
      this.d = paramj;
      this.f = new h1.b[paramInt];
      this.q = new Object[paramInt];
      this.x = paramBoolean;
    }
    
    void a()
    {
      f();
      b();
    }
    
    void b()
    {
      h1.b[] arrayOfb = this.f;
      int i = arrayOfb.length;
      for (int j = 0; j < i; j++) {
        arrayOfb[j].a();
      }
    }
    
    boolean d(boolean paramBoolean1, boolean paramBoolean2, v<? super R> paramv, boolean paramBoolean3, h1.b<?, ?> paramb)
    {
      if (this.y)
      {
        a();
        return true;
      }
      if (paramBoolean1) {
        if (paramBoolean3)
        {
          if (paramBoolean2)
          {
            paramb = paramb.q;
            this.y = true;
            a();
            if (paramb != null) {
              paramv.onError(paramb);
            } else {
              paramv.onComplete();
            }
            return true;
          }
        }
        else
        {
          paramb = paramb.q;
          if (paramb != null)
          {
            this.y = true;
            a();
            paramv.onError(paramb);
            return true;
          }
          if (paramBoolean2)
          {
            this.y = true;
            a();
            paramv.onComplete();
            return true;
          }
        }
      }
      return false;
    }
    
    public void dispose()
    {
      if (!this.y)
      {
        this.y = true;
        b();
        if (getAndIncrement() == 0) {
          f();
        }
      }
    }
    
    void f()
    {
      h1.b[] arrayOfb = this.f;
      int i = arrayOfb.length;
      for (int j = 0; j < i; j++) {
        arrayOfb[j].d.clear();
      }
    }
    
    /* Error */
    public void g()
    {
      // Byte code:
      //   0: aload_0
      //   1: invokevirtual 76	java/util/concurrent/atomic/AtomicInteger:getAndIncrement	()I
      //   4: ifeq +4 -> 8
      //   7: return
      //   8: aload_0
      //   9: getfield 38	io/reactivex/internal/operators/observable/h1$a:f	[Lio/reactivex/internal/operators/observable/h1$b;
      //   12: astore_1
      //   13: aload_0
      //   14: getfield 32	io/reactivex/internal/operators/observable/h1$a:c	Lio/reactivex/v;
      //   17: astore_2
      //   18: aload_0
      //   19: getfield 42	io/reactivex/internal/operators/observable/h1$a:q	[Ljava/lang/Object;
      //   22: astore_3
      //   23: aload_0
      //   24: getfield 44	io/reactivex/internal/operators/observable/h1$a:x	Z
      //   27: istore 4
      //   29: iconst_1
      //   30: istore 5
      //   32: aload_1
      //   33: arraylength
      //   34: istore 6
      //   36: iconst_0
      //   37: istore 7
      //   39: iconst_0
      //   40: istore 8
      //   42: iconst_0
      //   43: istore 9
      //   45: iload 7
      //   47: iload 6
      //   49: if_icmpge +159 -> 208
      //   52: aload_1
      //   53: iload 7
      //   55: aaload
      //   56: astore 10
      //   58: aload_3
      //   59: iload 9
      //   61: aaload
      //   62: ifnonnull +78 -> 140
      //   65: aload 10
      //   67: getfield 87	io/reactivex/internal/operators/observable/h1$b:f	Z
      //   70: istore 11
      //   72: aload 10
      //   74: getfield 79	io/reactivex/internal/operators/observable/h1$b:d	Lio/reactivex/internal/queue/b;
      //   77: invokevirtual 91	io/reactivex/internal/queue/b:poll	()Ljava/lang/Object;
      //   80: astore 12
      //   82: aload 12
      //   84: ifnonnull +9 -> 93
      //   87: iconst_1
      //   88: istore 13
      //   90: goto +6 -> 96
      //   93: iconst_0
      //   94: istore 13
      //   96: aload_0
      //   97: iload 11
      //   99: iload 13
      //   101: aload_2
      //   102: iload 4
      //   104: aload 10
      //   106: invokevirtual 93	io/reactivex/internal/operators/observable/h1$a:d	(ZZLio/reactivex/v;ZLio/reactivex/internal/operators/observable/h1$b;)Z
      //   109: ifeq +4 -> 113
      //   112: return
      //   113: iload 13
      //   115: ifne +16 -> 131
      //   118: aload_3
      //   119: iload 9
      //   121: aload 12
      //   123: aastore
      //   124: iload 8
      //   126: istore 14
      //   128: goto +67 -> 195
      //   131: iload 8
      //   133: iconst_1
      //   134: iadd
      //   135: istore 14
      //   137: goto +58 -> 195
      //   140: iload 8
      //   142: istore 14
      //   144: aload 10
      //   146: getfield 87	io/reactivex/internal/operators/observable/h1$b:f	Z
      //   149: ifeq +46 -> 195
      //   152: iload 8
      //   154: istore 14
      //   156: iload 4
      //   158: ifne +37 -> 195
      //   161: aload 10
      //   163: getfield 61	io/reactivex/internal/operators/observable/h1$b:q	Ljava/lang/Throwable;
      //   166: astore 12
      //   168: iload 8
      //   170: istore 14
      //   172: aload 12
      //   174: ifnull +21 -> 195
      //   177: aload_0
      //   178: iconst_1
      //   179: putfield 57	io/reactivex/internal/operators/observable/h1$a:y	Z
      //   182: aload_0
      //   183: invokevirtual 58	io/reactivex/internal/operators/observable/h1$a:a	()V
      //   186: aload_2
      //   187: aload 12
      //   189: invokeinterface 67 2 0
      //   194: return
      //   195: iinc 9 1
      //   198: iinc 7 1
      //   201: iload 14
      //   203: istore 8
      //   205: goto -160 -> 45
      //   208: iload 8
      //   210: ifeq +22 -> 232
      //   213: aload_0
      //   214: iload 5
      //   216: ineg
      //   217: invokevirtual 97	java/util/concurrent/atomic/AtomicInteger:addAndGet	(I)I
      //   220: istore 9
      //   222: iload 9
      //   224: istore 5
      //   226: iload 9
      //   228: ifne -196 -> 32
      //   231: return
      //   232: aload_0
      //   233: getfield 34	io/reactivex/internal/operators/observable/h1$a:d	Lio/reactivex/g0/j;
      //   236: aload_3
      //   237: invokevirtual 101	[Ljava/lang/Object;:clone	()Ljava/lang/Object;
      //   240: invokeinterface 107 2 0
      //   245: ldc 109
      //   247: invokestatic 115	io/reactivex/h0/a/b:e	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
      //   250: astore 12
      //   252: aload_2
      //   253: aload 12
      //   255: invokeinterface 119 2 0
      //   260: aload_3
      //   261: aconst_null
      //   262: invokestatic 125	java/util/Arrays:fill	([Ljava/lang/Object;Ljava/lang/Object;)V
      //   265: goto -233 -> 32
      //   268: astore_3
      //   269: aload_3
      //   270: invokestatic 129	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
      //   273: aload_0
      //   274: invokevirtual 58	io/reactivex/internal/operators/observable/h1$a:a	()V
      //   277: aload_2
      //   278: aload_3
      //   279: invokeinterface 67 2 0
      //   284: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	285	0	this	a
      //   12	41	1	arrayOfb	h1.b[]
      //   17	261	2	localv	v
      //   22	239	3	arrayOfObject	Object[]
      //   268	11	3	localThrowable	Throwable
      //   27	130	4	bool1	boolean
      //   30	195	5	i	int
      //   34	16	6	j	int
      //   37	162	7	k	int
      //   40	169	8	m	int
      //   43	184	9	n	int
      //   56	106	10	localb	h1.b
      //   70	28	11	bool2	boolean
      //   80	174	12	localObject	Object
      //   88	26	13	bool3	boolean
      //   126	76	14	i1	int
      // Exception table:
      //   from	to	target	type
      //   232	252	268	finally
    }
    
    public void h(t<? extends T>[] paramArrayOft, int paramInt)
    {
      h1.b[] arrayOfb = this.f;
      int i = arrayOfb.length;
      int j = 0;
      for (int k = 0; k < i; k++) {
        arrayOfb[k] = new h1.b(this, paramInt);
      }
      lazySet(0);
      this.c.onSubscribe(this);
      for (paramInt = j; paramInt < i; paramInt++)
      {
        if (this.y) {
          return;
        }
        paramArrayOft[paramInt].a(arrayOfb[paramInt]);
      }
    }
    
    public boolean isDisposed()
    {
      return this.y;
    }
  }
  
  static final class b<T, R>
    implements v<T>
  {
    final h1.a<T, R> c;
    final b<T> d;
    volatile boolean f;
    Throwable q;
    final AtomicReference<c> x = new AtomicReference();
    
    b(h1.a<T, R> parama, int paramInt)
    {
      this.c = parama;
      this.d = new b(paramInt);
    }
    
    public void a()
    {
      DisposableHelper.dispose(this.x);
    }
    
    public void onComplete()
    {
      this.f = true;
      this.c.g();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.q = paramThrowable;
      this.f = true;
      this.c.g();
    }
    
    public void onNext(T paramT)
    {
      this.d.offer(paramT);
      this.c.g();
    }
    
    public void onSubscribe(c paramc)
    {
      DisposableHelper.setOnce(this.x, paramc);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\observable\h1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */