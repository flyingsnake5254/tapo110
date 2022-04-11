package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.h;
import io.reactivex.h0.b.e;
import io.reactivex.h0.b.f;
import io.reactivex.h0.b.i;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.k;
import io.reactivex.w;
import io.reactivex.w.c;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class q<T>
  extends a<T, T>
{
  final w f;
  final boolean q;
  final int x;
  
  public q(h<T> paramh, w paramw, boolean paramBoolean, int paramInt)
  {
    super(paramh);
    this.f = paramw;
    this.q = paramBoolean;
    this.x = paramInt;
  }
  
  public void H(e.b.b<? super T> paramb)
  {
    w.c localc = this.f.b();
    if ((paramb instanceof io.reactivex.h0.b.a)) {
      this.d.G(new b((io.reactivex.h0.b.a)paramb, localc, this.q, this.x));
    } else {
      this.d.G(new c(paramb, localc, this.q, this.x));
    }
  }
  
  static abstract class a<T>
    extends BasicIntQueueSubscription<T>
    implements k<T>, Runnable
  {
    long H3;
    boolean I3;
    final w.c c;
    final boolean d;
    final int f;
    volatile boolean p0;
    volatile boolean p1;
    Throwable p2;
    int p3;
    final int q;
    final AtomicLong x;
    e.b.c y;
    i<T> z;
    
    a(w.c paramc, boolean paramBoolean, int paramInt)
    {
      this.c = paramc;
      this.d = paramBoolean;
      this.f = paramInt;
      this.x = new AtomicLong();
      this.q = (paramInt - (paramInt >> 2));
    }
    
    public final void cancel()
    {
      if (this.p0) {
        return;
      }
      this.p0 = true;
      this.y.cancel();
      this.c.dispose();
      if ((!this.I3) && (getAndIncrement() == 0)) {
        this.z.clear();
      }
    }
    
    public final void clear()
    {
      this.z.clear();
    }
    
    final boolean d(boolean paramBoolean1, boolean paramBoolean2, e.b.b<?> paramb)
    {
      if (this.p0)
      {
        clear();
        return true;
      }
      if (paramBoolean1)
      {
        Throwable localThrowable;
        if (this.d)
        {
          if (paramBoolean2)
          {
            this.p0 = true;
            localThrowable = this.p2;
            if (localThrowable != null) {
              paramb.onError(localThrowable);
            } else {
              paramb.onComplete();
            }
            this.c.dispose();
            return true;
          }
        }
        else
        {
          localThrowable = this.p2;
          if (localThrowable != null)
          {
            this.p0 = true;
            clear();
            paramb.onError(localThrowable);
            this.c.dispose();
            return true;
          }
          if (paramBoolean2)
          {
            this.p0 = true;
            paramb.onComplete();
            this.c.dispose();
            return true;
          }
        }
      }
      return false;
    }
    
    abstract void f();
    
    abstract void g();
    
    abstract void h();
    
    final void i()
    {
      if (getAndIncrement() != 0) {
        return;
      }
      this.c.b(this);
    }
    
    public final boolean isEmpty()
    {
      return this.z.isEmpty();
    }
    
    public final void onComplete()
    {
      if (!this.p1)
      {
        this.p1 = true;
        i();
      }
    }
    
    public final void onError(Throwable paramThrowable)
    {
      if (this.p1)
      {
        io.reactivex.j0.a.r(paramThrowable);
        return;
      }
      this.p2 = paramThrowable;
      this.p1 = true;
      i();
    }
    
    public final void onNext(T paramT)
    {
      if (this.p1) {
        return;
      }
      if (this.p3 == 2)
      {
        i();
        return;
      }
      if (!this.z.offer(paramT))
      {
        this.y.cancel();
        this.p2 = new MissingBackpressureException("Queue is full?!");
        this.p1 = true;
      }
      i();
    }
    
    public final void request(long paramLong)
    {
      if (SubscriptionHelper.validate(paramLong))
      {
        io.reactivex.internal.util.b.a(this.x, paramLong);
        i();
      }
    }
    
    public final int requestFusion(int paramInt)
    {
      if ((paramInt & 0x2) != 0)
      {
        this.I3 = true;
        return 2;
      }
      return 0;
    }
    
    public final void run()
    {
      if (this.I3) {
        g();
      } else if (this.p3 == 1) {
        h();
      } else {
        f();
      }
    }
  }
  
  static final class b<T>
    extends q.a<T>
  {
    final io.reactivex.h0.b.a<? super T> J3;
    long K3;
    
    b(io.reactivex.h0.b.a<? super T> parama, w.c paramc, boolean paramBoolean, int paramInt)
    {
      super(paramBoolean, paramInt);
      this.J3 = parama;
    }
    
    /* Error */
    void f()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 20	io/reactivex/internal/operators/flowable/q$b:J3	Lio/reactivex/h0/b/a;
      //   4: astore_1
      //   5: aload_0
      //   6: getfield 29	io/reactivex/internal/operators/flowable/q$a:z	Lio/reactivex/h0/b/i;
      //   9: astore_2
      //   10: aload_0
      //   11: getfield 32	io/reactivex/internal/operators/flowable/q$a:H3	J
      //   14: lstore_3
      //   15: aload_0
      //   16: getfield 34	io/reactivex/internal/operators/flowable/q$b:K3	J
      //   19: lstore 5
      //   21: iconst_1
      //   22: istore 7
      //   24: aload_0
      //   25: getfield 38	io/reactivex/internal/operators/flowable/q$a:x	Ljava/util/concurrent/atomic/AtomicLong;
      //   28: invokevirtual 44	java/util/concurrent/atomic/AtomicLong:get	()J
      //   31: lstore 8
      //   33: lload_3
      //   34: lload 8
      //   36: lcmp
      //   37: istore 10
      //   39: iload 10
      //   41: ifeq +160 -> 201
      //   44: aload_0
      //   45: getfield 48	io/reactivex/internal/operators/flowable/q$a:p1	Z
      //   48: istore 11
      //   50: aload_2
      //   51: invokeinterface 54 1 0
      //   56: astore 12
      //   58: aload 12
      //   60: ifnonnull +9 -> 69
      //   63: iconst_1
      //   64: istore 13
      //   66: goto +6 -> 72
      //   69: iconst_0
      //   70: istore 13
      //   72: aload_0
      //   73: iload 11
      //   75: iload 13
      //   77: aload_1
      //   78: invokevirtual 58	io/reactivex/internal/operators/flowable/q$a:d	(ZZLe/b/b;)Z
      //   81: ifeq +4 -> 85
      //   84: return
      //   85: iload 13
      //   87: ifeq +6 -> 93
      //   90: goto +111 -> 201
      //   93: lload_3
      //   94: lstore 14
      //   96: aload_1
      //   97: aload 12
      //   99: invokeinterface 63 2 0
      //   104: ifeq +8 -> 112
      //   107: lload_3
      //   108: lconst_1
      //   109: ladd
      //   110: lstore 14
      //   112: lload 5
      //   114: lconst_1
      //   115: ladd
      //   116: lstore 16
      //   118: lload 14
      //   120: lstore_3
      //   121: lload 16
      //   123: lstore 5
      //   125: lload 16
      //   127: aload_0
      //   128: getfield 67	io/reactivex/internal/operators/flowable/q$a:q	I
      //   131: i2l
      //   132: lcmp
      //   133: ifne -100 -> 33
      //   136: aload_0
      //   137: getfield 71	io/reactivex/internal/operators/flowable/q$a:y	Le/b/c;
      //   140: lload 16
      //   142: invokeinterface 77 3 0
      //   147: lconst_0
      //   148: lstore 5
      //   150: lload 14
      //   152: lstore_3
      //   153: goto -120 -> 33
      //   156: astore 12
      //   158: aload 12
      //   160: invokestatic 82	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
      //   163: aload_0
      //   164: iconst_1
      //   165: putfield 85	io/reactivex/internal/operators/flowable/q$a:p0	Z
      //   168: aload_0
      //   169: getfield 71	io/reactivex/internal/operators/flowable/q$a:y	Le/b/c;
      //   172: invokeinterface 88 1 0
      //   177: aload_2
      //   178: invokeinterface 91 1 0
      //   183: aload_1
      //   184: aload 12
      //   186: invokeinterface 96 2 0
      //   191: aload_0
      //   192: getfield 100	io/reactivex/internal/operators/flowable/q$a:c	Lio/reactivex/w$c;
      //   195: invokeinterface 105 1 0
      //   200: return
      //   201: iload 10
      //   203: ifne +22 -> 225
      //   206: aload_0
      //   207: aload_0
      //   208: getfield 48	io/reactivex/internal/operators/flowable/q$a:p1	Z
      //   211: aload_2
      //   212: invokeinterface 109 1 0
      //   217: aload_1
      //   218: invokevirtual 58	io/reactivex/internal/operators/flowable/q$a:d	(ZZLe/b/b;)Z
      //   221: ifeq +4 -> 225
      //   224: return
      //   225: aload_0
      //   226: invokevirtual 114	java/util/concurrent/atomic/AtomicInteger:get	()I
      //   229: istore 10
      //   231: iload 7
      //   233: iload 10
      //   235: if_icmpne +33 -> 268
      //   238: aload_0
      //   239: lload_3
      //   240: putfield 32	io/reactivex/internal/operators/flowable/q$a:H3	J
      //   243: aload_0
      //   244: lload 5
      //   246: putfield 34	io/reactivex/internal/operators/flowable/q$b:K3	J
      //   249: aload_0
      //   250: iload 7
      //   252: ineg
      //   253: invokevirtual 118	java/util/concurrent/atomic/AtomicInteger:addAndGet	(I)I
      //   256: istore 10
      //   258: iload 10
      //   260: istore 7
      //   262: iload 10
      //   264: ifne -240 -> 24
      //   267: return
      //   268: iload 10
      //   270: istore 7
      //   272: goto -248 -> 24
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	275	0	this	b
      //   4	214	1	locala	io.reactivex.h0.b.a
      //   9	203	2	locali	i
      //   14	226	3	l1	long
      //   19	226	5	l2	long
      //   22	249	7	i	int
      //   31	4	8	l3	long
      //   37	165	10	bool1	boolean
      //   229	40	10	j	int
      //   48	26	11	bool2	boolean
      //   56	42	12	localObject	Object
      //   156	29	12	localThrowable	Throwable
      //   64	22	13	bool3	boolean
      //   94	57	14	l4	long
      //   116	25	16	l5	long
      // Exception table:
      //   from	to	target	type
      //   50	58	156	finally
    }
    
    void g()
    {
      int i = 1;
      int j;
      do
      {
        if (this.p0) {
          return;
        }
        boolean bool = this.p1;
        this.J3.onNext(null);
        if (bool)
        {
          this.p0 = true;
          Throwable localThrowable = this.p2;
          if (localThrowable != null) {
            this.J3.onError(localThrowable);
          } else {
            this.J3.onComplete();
          }
          this.c.dispose();
          return;
        }
        j = addAndGet(-i);
        i = j;
      } while (j != 0);
    }
    
    /* Error */
    void h()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 20	io/reactivex/internal/operators/flowable/q$b:J3	Lio/reactivex/h0/b/a;
      //   4: astore_1
      //   5: aload_0
      //   6: getfield 29	io/reactivex/internal/operators/flowable/q$a:z	Lio/reactivex/h0/b/i;
      //   9: astore_2
      //   10: aload_0
      //   11: getfield 32	io/reactivex/internal/operators/flowable/q$a:H3	J
      //   14: lstore_3
      //   15: iconst_1
      //   16: istore 5
      //   18: aload_0
      //   19: getfield 38	io/reactivex/internal/operators/flowable/q$a:x	Ljava/util/concurrent/atomic/AtomicLong;
      //   22: invokevirtual 44	java/util/concurrent/atomic/AtomicLong:get	()J
      //   25: lstore 6
      //   27: lload_3
      //   28: lload 6
      //   30: lcmp
      //   31: ifeq +102 -> 133
      //   34: aload_2
      //   35: invokeinterface 54 1 0
      //   40: astore 8
      //   42: aload_0
      //   43: getfield 85	io/reactivex/internal/operators/flowable/q$a:p0	Z
      //   46: ifeq +4 -> 50
      //   49: return
      //   50: aload 8
      //   52: ifnonnull +24 -> 76
      //   55: aload_0
      //   56: iconst_1
      //   57: putfield 85	io/reactivex/internal/operators/flowable/q$a:p0	Z
      //   60: aload_1
      //   61: invokeinterface 130 1 0
      //   66: aload_0
      //   67: getfield 100	io/reactivex/internal/operators/flowable/q$a:c	Lio/reactivex/w$c;
      //   70: invokeinterface 105 1 0
      //   75: return
      //   76: aload_1
      //   77: aload 8
      //   79: invokeinterface 63 2 0
      //   84: ifeq -57 -> 27
      //   87: lload_3
      //   88: lconst_1
      //   89: ladd
      //   90: lstore_3
      //   91: goto -64 -> 27
      //   94: astore 8
      //   96: aload 8
      //   98: invokestatic 82	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
      //   101: aload_0
      //   102: iconst_1
      //   103: putfield 85	io/reactivex/internal/operators/flowable/q$a:p0	Z
      //   106: aload_0
      //   107: getfield 71	io/reactivex/internal/operators/flowable/q$a:y	Le/b/c;
      //   110: invokeinterface 88 1 0
      //   115: aload_1
      //   116: aload 8
      //   118: invokeinterface 96 2 0
      //   123: aload_0
      //   124: getfield 100	io/reactivex/internal/operators/flowable/q$a:c	Lio/reactivex/w$c;
      //   127: invokeinterface 105 1 0
      //   132: return
      //   133: aload_0
      //   134: getfield 85	io/reactivex/internal/operators/flowable/q$a:p0	Z
      //   137: ifeq +4 -> 141
      //   140: return
      //   141: aload_2
      //   142: invokeinterface 109 1 0
      //   147: ifeq +24 -> 171
      //   150: aload_0
      //   151: iconst_1
      //   152: putfield 85	io/reactivex/internal/operators/flowable/q$a:p0	Z
      //   155: aload_1
      //   156: invokeinterface 130 1 0
      //   161: aload_0
      //   162: getfield 100	io/reactivex/internal/operators/flowable/q$a:c	Lio/reactivex/w$c;
      //   165: invokeinterface 105 1 0
      //   170: return
      //   171: aload_0
      //   172: invokevirtual 114	java/util/concurrent/atomic/AtomicInteger:get	()I
      //   175: istore 9
      //   177: iload 5
      //   179: iload 9
      //   181: if_icmpne +27 -> 208
      //   184: aload_0
      //   185: lload_3
      //   186: putfield 32	io/reactivex/internal/operators/flowable/q$a:H3	J
      //   189: aload_0
      //   190: iload 5
      //   192: ineg
      //   193: invokevirtual 118	java/util/concurrent/atomic/AtomicInteger:addAndGet	(I)I
      //   196: istore 9
      //   198: iload 9
      //   200: istore 5
      //   202: iload 9
      //   204: ifne -186 -> 18
      //   207: return
      //   208: iload 9
      //   210: istore 5
      //   212: goto -194 -> 18
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	215	0	this	b
      //   4	152	1	locala	io.reactivex.h0.b.a
      //   9	133	2	locali	i
      //   14	172	3	l1	long
      //   16	195	5	i	int
      //   25	4	6	l2	long
      //   40	38	8	localObject	Object
      //   94	23	8	localThrowable	Throwable
      //   175	34	9	j	int
      // Exception table:
      //   from	to	target	type
      //   34	42	94	finally
    }
    
    public void onSubscribe(e.b.c paramc)
    {
      if (SubscriptionHelper.validate(this.y, paramc))
      {
        this.y = paramc;
        if ((paramc instanceof f))
        {
          f localf = (f)paramc;
          int i = localf.requestFusion(7);
          if (i == 1)
          {
            this.p3 = 1;
            this.z = localf;
            this.p1 = true;
            this.J3.onSubscribe(this);
            return;
          }
          if (i == 2)
          {
            this.p3 = 2;
            this.z = localf;
            this.J3.onSubscribe(this);
            paramc.request(this.f);
            return;
          }
        }
        this.z = new SpscArrayQueue(this.f);
        this.J3.onSubscribe(this);
        paramc.request(this.f);
      }
    }
    
    public T poll()
      throws Exception
    {
      Object localObject = this.z.poll();
      if ((localObject != null) && (this.p3 != 1))
      {
        long l = this.K3 + 1L;
        if (l == this.q)
        {
          this.K3 = 0L;
          this.y.request(l);
        }
        else
        {
          this.K3 = l;
        }
      }
      return (T)localObject;
    }
  }
  
  static final class c<T>
    extends q.a<T>
    implements k<T>
  {
    final e.b.b<? super T> J3;
    
    c(e.b.b<? super T> paramb, w.c paramc, boolean paramBoolean, int paramInt)
    {
      super(paramBoolean, paramInt);
      this.J3 = paramb;
    }
    
    /* Error */
    void f()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 20	io/reactivex/internal/operators/flowable/q$c:J3	Le/b/b;
      //   4: astore_1
      //   5: aload_0
      //   6: getfield 29	io/reactivex/internal/operators/flowable/q$a:z	Lio/reactivex/h0/b/i;
      //   9: astore_2
      //   10: aload_0
      //   11: getfield 33	io/reactivex/internal/operators/flowable/q$a:H3	J
      //   14: lstore_3
      //   15: iconst_1
      //   16: istore 5
      //   18: aload_0
      //   19: getfield 37	io/reactivex/internal/operators/flowable/q$a:x	Ljava/util/concurrent/atomic/AtomicLong;
      //   22: invokevirtual 43	java/util/concurrent/atomic/AtomicLong:get	()J
      //   25: lstore 6
      //   27: lload_3
      //   28: lload 6
      //   30: lcmp
      //   31: istore 8
      //   33: iload 8
      //   35: ifeq +169 -> 204
      //   38: aload_0
      //   39: getfield 47	io/reactivex/internal/operators/flowable/q$a:p1	Z
      //   42: istore 9
      //   44: aload_2
      //   45: invokeinterface 53 1 0
      //   50: astore 10
      //   52: aload 10
      //   54: ifnonnull +9 -> 63
      //   57: iconst_1
      //   58: istore 11
      //   60: goto +6 -> 66
      //   63: iconst_0
      //   64: istore 11
      //   66: aload_0
      //   67: iload 9
      //   69: iload 11
      //   71: aload_1
      //   72: invokevirtual 57	io/reactivex/internal/operators/flowable/q$a:d	(ZZLe/b/b;)Z
      //   75: ifeq +4 -> 79
      //   78: return
      //   79: iload 11
      //   81: ifeq +6 -> 87
      //   84: goto +120 -> 204
      //   87: aload_1
      //   88: aload 10
      //   90: invokeinterface 63 2 0
      //   95: lload_3
      //   96: lconst_1
      //   97: ladd
      //   98: lstore 12
      //   100: lload 12
      //   102: lstore_3
      //   103: lload 12
      //   105: aload_0
      //   106: getfield 67	io/reactivex/internal/operators/flowable/q$a:q	I
      //   109: i2l
      //   110: lcmp
      //   111: ifne -84 -> 27
      //   114: lload 6
      //   116: lstore 14
      //   118: lload 6
      //   120: ldc2_w 68
      //   123: lcmp
      //   124: ifeq +15 -> 139
      //   127: aload_0
      //   128: getfield 37	io/reactivex/internal/operators/flowable/q$a:x	Ljava/util/concurrent/atomic/AtomicLong;
      //   131: lload 12
      //   133: lneg
      //   134: invokevirtual 73	java/util/concurrent/atomic/AtomicLong:addAndGet	(J)J
      //   137: lstore 14
      //   139: aload_0
      //   140: getfield 77	io/reactivex/internal/operators/flowable/q$a:y	Le/b/c;
      //   143: lload 12
      //   145: invokeinterface 83 3 0
      //   150: lconst_0
      //   151: lstore_3
      //   152: lload 14
      //   154: lstore 6
      //   156: goto -129 -> 27
      //   159: astore 10
      //   161: aload 10
      //   163: invokestatic 89	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
      //   166: aload_0
      //   167: iconst_1
      //   168: putfield 92	io/reactivex/internal/operators/flowable/q$a:p0	Z
      //   171: aload_0
      //   172: getfield 77	io/reactivex/internal/operators/flowable/q$a:y	Le/b/c;
      //   175: invokeinterface 95 1 0
      //   180: aload_2
      //   181: invokeinterface 98 1 0
      //   186: aload_1
      //   187: aload 10
      //   189: invokeinterface 101 2 0
      //   194: aload_0
      //   195: getfield 104	io/reactivex/internal/operators/flowable/q$a:c	Lio/reactivex/w$c;
      //   198: invokeinterface 109 1 0
      //   203: return
      //   204: iload 8
      //   206: ifne +22 -> 228
      //   209: aload_0
      //   210: aload_0
      //   211: getfield 47	io/reactivex/internal/operators/flowable/q$a:p1	Z
      //   214: aload_2
      //   215: invokeinterface 113 1 0
      //   220: aload_1
      //   221: invokevirtual 57	io/reactivex/internal/operators/flowable/q$a:d	(ZZLe/b/b;)Z
      //   224: ifeq +4 -> 228
      //   227: return
      //   228: aload_0
      //   229: invokevirtual 118	java/util/concurrent/atomic/AtomicInteger:get	()I
      //   232: istore 8
      //   234: iload 5
      //   236: iload 8
      //   238: if_icmpne +27 -> 265
      //   241: aload_0
      //   242: lload_3
      //   243: putfield 33	io/reactivex/internal/operators/flowable/q$a:H3	J
      //   246: aload_0
      //   247: iload 5
      //   249: ineg
      //   250: invokevirtual 121	java/util/concurrent/atomic/AtomicInteger:addAndGet	(I)I
      //   253: istore 8
      //   255: iload 8
      //   257: istore 5
      //   259: iload 8
      //   261: ifne -243 -> 18
      //   264: return
      //   265: iload 8
      //   267: istore 5
      //   269: goto -251 -> 18
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	272	0	this	c
      //   4	217	1	localb	e.b.b
      //   9	206	2	locali	i
      //   14	229	3	l1	long
      //   16	252	5	i	int
      //   25	130	6	l2	long
      //   31	174	8	bool1	boolean
      //   232	34	8	j	int
      //   42	26	9	bool2	boolean
      //   50	39	10	localObject	Object
      //   159	29	10	localThrowable	Throwable
      //   58	22	11	bool3	boolean
      //   98	46	12	l3	long
      //   116	37	14	l4	long
      // Exception table:
      //   from	to	target	type
      //   44	52	159	finally
    }
    
    void g()
    {
      int i = 1;
      int j;
      do
      {
        if (this.p0) {
          return;
        }
        boolean bool = this.p1;
        this.J3.onNext(null);
        if (bool)
        {
          this.p0 = true;
          Throwable localThrowable = this.p2;
          if (localThrowable != null) {
            this.J3.onError(localThrowable);
          } else {
            this.J3.onComplete();
          }
          this.c.dispose();
          return;
        }
        j = addAndGet(-i);
        i = j;
      } while (j != 0);
    }
    
    /* Error */
    void h()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 20	io/reactivex/internal/operators/flowable/q$c:J3	Le/b/b;
      //   4: astore_1
      //   5: aload_0
      //   6: getfield 29	io/reactivex/internal/operators/flowable/q$a:z	Lio/reactivex/h0/b/i;
      //   9: astore_2
      //   10: aload_0
      //   11: getfield 33	io/reactivex/internal/operators/flowable/q$a:H3	J
      //   14: lstore_3
      //   15: iconst_1
      //   16: istore 5
      //   18: aload_0
      //   19: getfield 37	io/reactivex/internal/operators/flowable/q$a:x	Ljava/util/concurrent/atomic/AtomicLong;
      //   22: invokevirtual 43	java/util/concurrent/atomic/AtomicLong:get	()J
      //   25: lstore 6
      //   27: lload_3
      //   28: lload 6
      //   30: lcmp
      //   31: ifeq +99 -> 130
      //   34: aload_2
      //   35: invokeinterface 53 1 0
      //   40: astore 8
      //   42: aload_0
      //   43: getfield 92	io/reactivex/internal/operators/flowable/q$a:p0	Z
      //   46: ifeq +4 -> 50
      //   49: return
      //   50: aload 8
      //   52: ifnonnull +24 -> 76
      //   55: aload_0
      //   56: iconst_1
      //   57: putfield 92	io/reactivex/internal/operators/flowable/q$a:p0	Z
      //   60: aload_1
      //   61: invokeinterface 129 1 0
      //   66: aload_0
      //   67: getfield 104	io/reactivex/internal/operators/flowable/q$a:c	Lio/reactivex/w$c;
      //   70: invokeinterface 109 1 0
      //   75: return
      //   76: aload_1
      //   77: aload 8
      //   79: invokeinterface 63 2 0
      //   84: lload_3
      //   85: lconst_1
      //   86: ladd
      //   87: lstore_3
      //   88: goto -61 -> 27
      //   91: astore 8
      //   93: aload 8
      //   95: invokestatic 89	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
      //   98: aload_0
      //   99: iconst_1
      //   100: putfield 92	io/reactivex/internal/operators/flowable/q$a:p0	Z
      //   103: aload_0
      //   104: getfield 77	io/reactivex/internal/operators/flowable/q$a:y	Le/b/c;
      //   107: invokeinterface 95 1 0
      //   112: aload_1
      //   113: aload 8
      //   115: invokeinterface 101 2 0
      //   120: aload_0
      //   121: getfield 104	io/reactivex/internal/operators/flowable/q$a:c	Lio/reactivex/w$c;
      //   124: invokeinterface 109 1 0
      //   129: return
      //   130: aload_0
      //   131: getfield 92	io/reactivex/internal/operators/flowable/q$a:p0	Z
      //   134: ifeq +4 -> 138
      //   137: return
      //   138: aload_2
      //   139: invokeinterface 113 1 0
      //   144: ifeq +24 -> 168
      //   147: aload_0
      //   148: iconst_1
      //   149: putfield 92	io/reactivex/internal/operators/flowable/q$a:p0	Z
      //   152: aload_1
      //   153: invokeinterface 129 1 0
      //   158: aload_0
      //   159: getfield 104	io/reactivex/internal/operators/flowable/q$a:c	Lio/reactivex/w$c;
      //   162: invokeinterface 109 1 0
      //   167: return
      //   168: aload_0
      //   169: invokevirtual 118	java/util/concurrent/atomic/AtomicInteger:get	()I
      //   172: istore 9
      //   174: iload 5
      //   176: iload 9
      //   178: if_icmpne +27 -> 205
      //   181: aload_0
      //   182: lload_3
      //   183: putfield 33	io/reactivex/internal/operators/flowable/q$a:H3	J
      //   186: aload_0
      //   187: iload 5
      //   189: ineg
      //   190: invokevirtual 121	java/util/concurrent/atomic/AtomicInteger:addAndGet	(I)I
      //   193: istore 9
      //   195: iload 9
      //   197: istore 5
      //   199: iload 9
      //   201: ifne -183 -> 18
      //   204: return
      //   205: iload 9
      //   207: istore 5
      //   209: goto -191 -> 18
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	212	0	this	c
      //   4	149	1	localb	e.b.b
      //   9	130	2	locali	i
      //   14	169	3	l1	long
      //   16	192	5	i	int
      //   25	4	6	l2	long
      //   40	38	8	localObject	Object
      //   91	23	8	localThrowable	Throwable
      //   172	34	9	j	int
      // Exception table:
      //   from	to	target	type
      //   34	42	91	finally
    }
    
    public void onSubscribe(e.b.c paramc)
    {
      if (SubscriptionHelper.validate(this.y, paramc))
      {
        this.y = paramc;
        if ((paramc instanceof f))
        {
          f localf = (f)paramc;
          int i = localf.requestFusion(7);
          if (i == 1)
          {
            this.p3 = 1;
            this.z = localf;
            this.p1 = true;
            this.J3.onSubscribe(this);
            return;
          }
          if (i == 2)
          {
            this.p3 = 2;
            this.z = localf;
            this.J3.onSubscribe(this);
            paramc.request(this.f);
            return;
          }
        }
        this.z = new SpscArrayQueue(this.f);
        this.J3.onSubscribe(this);
        paramc.request(this.f);
      }
    }
    
    public T poll()
      throws Exception
    {
      Object localObject = this.z.poll();
      if ((localObject != null) && (this.p3 != 1))
      {
        long l = this.H3 + 1L;
        if (l == this.q)
        {
          this.H3 = 0L;
          this.y.request(l);
        }
        else
        {
          this.H3 = l;
        }
      }
      return (T)localObject;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\flowable\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */