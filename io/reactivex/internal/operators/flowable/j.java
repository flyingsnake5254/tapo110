package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.h0.b.f;
import io.reactivex.h0.b.i;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.k;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class j<T, U>
  extends a<T, U>
{
  final io.reactivex.g0.j<? super T, ? extends e.b.a<? extends U>> f;
  final boolean q;
  final int x;
  final int y;
  
  public j(io.reactivex.h<T> paramh, io.reactivex.g0.j<? super T, ? extends e.b.a<? extends U>> paramj, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    super(paramh);
    this.f = paramj;
    this.q = paramBoolean;
    this.x = paramInt1;
    this.y = paramInt2;
  }
  
  public static <T, U> k<T> M(e.b.b<? super U> paramb, io.reactivex.g0.j<? super T, ? extends e.b.a<? extends U>> paramj, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    return new b(paramb, paramj, paramBoolean, paramInt1, paramInt2);
  }
  
  protected void H(e.b.b<? super U> paramb)
  {
    if (a0.b(this.d, paramb, this.f)) {
      return;
    }
    this.d.G(M(paramb, this.f, this.q, this.x, this.y));
  }
  
  static final class a<T, U>
    extends AtomicReference<e.b.c>
    implements k<U>, io.reactivex.e0.c
  {
    final long c;
    final j.b<T, U> d;
    final int f;
    int p0;
    final int q;
    volatile boolean x;
    volatile i<U> y;
    long z;
    
    a(j.b<T, U> paramb, long paramLong)
    {
      this.c = paramLong;
      this.d = paramb;
      int i = paramb.z;
      this.q = i;
      this.f = (i >> 2);
    }
    
    void a(long paramLong)
    {
      if (this.p0 != 1)
      {
        paramLong = this.z + paramLong;
        if (paramLong >= this.f)
        {
          this.z = 0L;
          ((e.b.c)get()).request(paramLong);
        }
        else
        {
          this.z = paramLong;
        }
      }
    }
    
    public void dispose()
    {
      SubscriptionHelper.cancel(this);
    }
    
    public boolean isDisposed()
    {
      boolean bool;
      if (get() == SubscriptionHelper.CANCELLED) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public void onComplete()
    {
      this.x = true;
      this.d.h();
    }
    
    public void onError(Throwable paramThrowable)
    {
      lazySet(SubscriptionHelper.CANCELLED);
      this.d.l(this, paramThrowable);
    }
    
    public void onNext(U paramU)
    {
      if (this.p0 != 2) {
        this.d.n(paramU, this);
      } else {
        this.d.h();
      }
    }
    
    public void onSubscribe(e.b.c paramc)
    {
      if (SubscriptionHelper.setOnce(this, paramc))
      {
        if ((paramc instanceof f))
        {
          f localf = (f)paramc;
          int i = localf.requestFusion(7);
          if (i == 1)
          {
            this.p0 = i;
            this.y = localf;
            this.x = true;
            this.d.h();
            return;
          }
          if (i == 2)
          {
            this.p0 = i;
            this.y = localf;
          }
        }
        paramc.request(this.q);
      }
    }
  }
  
  static final class b<T, U>
    extends AtomicInteger
    implements k<T>, e.b.c
  {
    static final j.a<?, ?>[] c = new j.a[0];
    static final j.a<?, ?>[] d = new j.a[0];
    final AtomicReference<j.a<?, ?>[]> H3;
    final AtomicLong I3;
    e.b.c J3;
    long K3;
    long L3;
    int M3;
    int N3;
    final int O3;
    final e.b.b<? super U> f;
    volatile io.reactivex.h0.b.h<U> p0;
    volatile boolean p1;
    final AtomicThrowable p2 = new AtomicThrowable();
    volatile boolean p3;
    final io.reactivex.g0.j<? super T, ? extends e.b.a<? extends U>> q;
    final boolean x;
    final int y;
    final int z;
    
    b(e.b.b<? super U> paramb, io.reactivex.g0.j<? super T, ? extends e.b.a<? extends U>> paramj, boolean paramBoolean, int paramInt1, int paramInt2)
    {
      AtomicReference localAtomicReference = new AtomicReference();
      this.H3 = localAtomicReference;
      this.I3 = new AtomicLong();
      this.f = paramb;
      this.q = paramj;
      this.x = paramBoolean;
      this.y = paramInt1;
      this.z = paramInt2;
      this.O3 = Math.max(1, paramInt1 >> 1);
      localAtomicReference.lazySet(c);
    }
    
    boolean a(j.a<T, U> parama)
    {
      j.a[] arrayOfa1;
      j.a[] arrayOfa2;
      do
      {
        arrayOfa1 = (j.a[])this.H3.get();
        if (arrayOfa1 == d)
        {
          parama.dispose();
          return false;
        }
        int i = arrayOfa1.length;
        arrayOfa2 = new j.a[i + 1];
        System.arraycopy(arrayOfa1, 0, arrayOfa2, 0, i);
        arrayOfa2[i] = parama;
      } while (!this.H3.compareAndSet(arrayOfa1, arrayOfa2));
      return true;
    }
    
    public void cancel()
    {
      if (!this.p3)
      {
        this.p3 = true;
        this.J3.cancel();
        g();
        if (getAndIncrement() == 0)
        {
          io.reactivex.h0.b.h localh = this.p0;
          if (localh != null) {
            localh.clear();
          }
        }
      }
    }
    
    boolean d()
    {
      if (this.p3)
      {
        f();
        return true;
      }
      if ((!this.x) && (this.p2.get() != null))
      {
        f();
        Throwable localThrowable = this.p2.terminate();
        if (localThrowable != io.reactivex.internal.util.e.a) {
          this.f.onError(localThrowable);
        }
        return true;
      }
      return false;
    }
    
    void f()
    {
      io.reactivex.h0.b.h localh = this.p0;
      if (localh != null) {
        localh.clear();
      }
    }
    
    void g()
    {
      j.a[] arrayOfa = (j.a[])this.H3.get();
      Object localObject = d;
      if (arrayOfa != localObject)
      {
        arrayOfa = (j.a[])this.H3.getAndSet(localObject);
        if (arrayOfa != localObject)
        {
          int i = arrayOfa.length;
          for (int j = 0; j < i; j++) {
            arrayOfa[j].dispose();
          }
          localObject = this.p2.terminate();
          if ((localObject != null) && (localObject != io.reactivex.internal.util.e.a)) {
            io.reactivex.j0.a.r((Throwable)localObject);
          }
        }
      }
    }
    
    void h()
    {
      if (getAndIncrement() == 0) {
        i();
      }
    }
    
    /* Error */
    void i()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 77	io/reactivex/internal/operators/flowable/j$b:f	Le/b/b;
      //   4: astore_1
      //   5: iconst_1
      //   6: istore_2
      //   7: aload_0
      //   8: invokevirtual 174	io/reactivex/internal/operators/flowable/j$b:d	()Z
      //   11: ifeq +4 -> 15
      //   14: return
      //   15: aload_0
      //   16: getfield 136	io/reactivex/internal/operators/flowable/j$b:p0	Lio/reactivex/h0/b/h;
      //   19: astore_3
      //   20: aload_0
      //   21: getfield 75	io/reactivex/internal/operators/flowable/j$b:I3	Ljava/util/concurrent/atomic/AtomicLong;
      //   24: invokevirtual 177	java/util/concurrent/atomic/AtomicLong:get	()J
      //   27: lstore 4
      //   29: lload 4
      //   31: ldc2_w 178
      //   34: lcmp
      //   35: ifne +9 -> 44
      //   38: iconst_1
      //   39: istore 6
      //   41: goto +6 -> 47
      //   44: iconst_0
      //   45: istore 6
      //   47: lconst_0
      //   48: lstore 7
      //   50: lload 4
      //   52: lstore 9
      //   54: lload 7
      //   56: lstore 11
      //   58: aload_3
      //   59: ifnull +135 -> 194
      //   62: lconst_0
      //   63: lstore 11
      //   65: aconst_null
      //   66: astore 13
      //   68: lload 4
      //   70: lconst_0
      //   71: lcmp
      //   72: ifeq +56 -> 128
      //   75: aload_3
      //   76: invokeinterface 184 1 0
      //   81: astore 13
      //   83: aload_0
      //   84: invokevirtual 174	io/reactivex/internal/operators/flowable/j$b:d	()Z
      //   87: ifeq +4 -> 91
      //   90: return
      //   91: aload 13
      //   93: ifnonnull +6 -> 99
      //   96: goto +32 -> 128
      //   99: aload_1
      //   100: aload 13
      //   102: invokeinterface 187 2 0
      //   107: lload 7
      //   109: lconst_1
      //   110: ladd
      //   111: lstore 7
      //   113: lload 11
      //   115: lconst_1
      //   116: ladd
      //   117: lstore 11
      //   119: lload 4
      //   121: lconst_1
      //   122: lsub
      //   123: lstore 4
      //   125: goto -57 -> 68
      //   128: lload 11
      //   130: lconst_0
      //   131: lcmp
      //   132: ifeq +28 -> 160
      //   135: iload 6
      //   137: ifeq +11 -> 148
      //   140: ldc2_w 178
      //   143: lstore 4
      //   145: goto +15 -> 160
      //   148: aload_0
      //   149: getfield 75	io/reactivex/internal/operators/flowable/j$b:I3	Ljava/util/concurrent/atomic/AtomicLong;
      //   152: lload 11
      //   154: lneg
      //   155: invokevirtual 191	java/util/concurrent/atomic/AtomicLong:addAndGet	(J)J
      //   158: lstore 4
      //   160: lload 4
      //   162: lstore 9
      //   164: lload 7
      //   166: lstore 11
      //   168: lload 4
      //   170: lconst_0
      //   171: lcmp
      //   172: ifeq +22 -> 194
      //   175: aload 13
      //   177: ifnonnull +14 -> 191
      //   180: lload 4
      //   182: lstore 9
      //   184: lload 7
      //   186: lstore 11
      //   188: goto +6 -> 194
      //   191: goto -129 -> 62
      //   194: aload_0
      //   195: getfield 193	io/reactivex/internal/operators/flowable/j$b:p1	Z
      //   198: istore 14
      //   200: aload_0
      //   201: getfield 136	io/reactivex/internal/operators/flowable/j$b:p0	Lio/reactivex/h0/b/h;
      //   204: astore_3
      //   205: aload_0
      //   206: getfield 70	io/reactivex/internal/operators/flowable/j$b:H3	Ljava/util/concurrent/atomic/AtomicReference;
      //   209: invokevirtual 105	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
      //   212: checkcast 106	[Lio/reactivex/internal/operators/flowable/j$a;
      //   215: astore 13
      //   217: aload 13
      //   219: arraylength
      //   220: istore 15
      //   222: iload 14
      //   224: ifeq +61 -> 285
      //   227: aload_3
      //   228: ifnull +12 -> 240
      //   231: aload_3
      //   232: invokeinterface 196 1 0
      //   237: ifeq +48 -> 285
      //   240: iload 15
      //   242: ifne +43 -> 285
      //   245: aload_0
      //   246: getfield 65	io/reactivex/internal/operators/flowable/j$b:p2	Lio/reactivex/internal/util/AtomicThrowable;
      //   249: invokevirtual 148	io/reactivex/internal/util/AtomicThrowable:terminate	()Ljava/lang/Throwable;
      //   252: astore 13
      //   254: aload 13
      //   256: getstatic 153	io/reactivex/internal/util/e:a	Ljava/lang/Throwable;
      //   259: if_acmpeq +25 -> 284
      //   262: aload 13
      //   264: ifnonnull +12 -> 276
      //   267: aload_1
      //   268: invokeinterface 199 1 0
      //   273: goto +11 -> 284
      //   276: aload_1
      //   277: aload 13
      //   279: invokeinterface 159 2 0
      //   284: return
      //   285: iload 15
      //   287: ifeq +606 -> 893
      //   290: aload_0
      //   291: getfield 201	io/reactivex/internal/operators/flowable/j$b:L3	J
      //   294: lstore 4
      //   296: aload_0
      //   297: getfield 203	io/reactivex/internal/operators/flowable/j$b:M3	I
      //   300: istore 16
      //   302: iload 15
      //   304: iload 16
      //   306: if_icmple +21 -> 327
      //   309: iload 16
      //   311: istore 17
      //   313: aload 13
      //   315: iload 16
      //   317: aaload
      //   318: getfield 205	io/reactivex/internal/operators/flowable/j$a:c	J
      //   321: lload 4
      //   323: lcmp
      //   324: ifeq +88 -> 412
      //   327: iload 16
      //   329: istore 17
      //   331: iload 15
      //   333: iload 16
      //   335: if_icmpgt +6 -> 341
      //   338: iconst_0
      //   339: istore 17
      //   341: iconst_0
      //   342: istore 16
      //   344: iload 16
      //   346: iload 15
      //   348: if_icmpge +46 -> 394
      //   351: aload 13
      //   353: iload 17
      //   355: aaload
      //   356: getfield 205	io/reactivex/internal/operators/flowable/j$a:c	J
      //   359: lload 4
      //   361: lcmp
      //   362: ifne +6 -> 368
      //   365: goto +29 -> 394
      //   368: iload 17
      //   370: iconst_1
      //   371: iadd
      //   372: istore 18
      //   374: iload 18
      //   376: istore 17
      //   378: iload 18
      //   380: iload 15
      //   382: if_icmpne +6 -> 388
      //   385: iconst_0
      //   386: istore 17
      //   388: iinc 16 1
      //   391: goto -47 -> 344
      //   394: aload_0
      //   395: iload 17
      //   397: putfield 203	io/reactivex/internal/operators/flowable/j$b:M3	I
      //   400: aload_0
      //   401: aload 13
      //   403: iload 17
      //   405: aaload
      //   406: getfield 205	io/reactivex/internal/operators/flowable/j$a:c	J
      //   409: putfield 201	io/reactivex/internal/operators/flowable/j$b:L3	J
      //   412: iconst_0
      //   413: istore 18
      //   415: iconst_0
      //   416: istore 19
      //   418: lload 11
      //   420: lstore 4
      //   422: iload 15
      //   424: istore 16
      //   426: lload 9
      //   428: lstore 11
      //   430: iload 19
      //   432: istore 15
      //   434: iload 17
      //   436: istore 20
      //   438: iload 18
      //   440: istore 17
      //   442: iload 15
      //   444: iload 16
      //   446: if_icmpge +426 -> 872
      //   449: aload_0
      //   450: invokevirtual 174	io/reactivex/internal/operators/flowable/j$b:d	()Z
      //   453: ifeq +4 -> 457
      //   456: return
      //   457: aload 13
      //   459: iload 20
      //   461: aaload
      //   462: astore 21
      //   464: aconst_null
      //   465: astore_3
      //   466: aload_0
      //   467: invokevirtual 174	io/reactivex/internal/operators/flowable/j$b:d	()Z
      //   470: ifeq +4 -> 474
      //   473: return
      //   474: aload 21
      //   476: getfield 208	io/reactivex/internal/operators/flowable/j$a:y	Lio/reactivex/h0/b/i;
      //   479: astore 22
      //   481: aload 22
      //   483: ifnonnull +10 -> 493
      //   486: lload 11
      //   488: lstore 7
      //   490: goto +217 -> 707
      //   493: iload 16
      //   495: istore 18
      //   497: lconst_0
      //   498: lstore 7
      //   500: lload 11
      //   502: lconst_0
      //   503: lcmp
      //   504: ifeq +125 -> 629
      //   507: aload 22
      //   509: invokeinterface 209 1 0
      //   514: astore_3
      //   515: aload_3
      //   516: ifnonnull +6 -> 522
      //   519: goto +110 -> 629
      //   522: aload_1
      //   523: aload_3
      //   524: invokeinterface 187 2 0
      //   529: aload_0
      //   530: invokevirtual 174	io/reactivex/internal/operators/flowable/j$b:d	()Z
      //   533: ifeq +4 -> 537
      //   536: return
      //   537: lload 11
      //   539: lconst_1
      //   540: lsub
      //   541: lstore 11
      //   543: lload 7
      //   545: lconst_1
      //   546: ladd
      //   547: lstore 7
      //   549: goto -49 -> 500
      //   552: astore_3
      //   553: aload_3
      //   554: invokestatic 213	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
      //   557: aload 21
      //   559: invokevirtual 109	io/reactivex/internal/operators/flowable/j$a:dispose	()V
      //   562: aload_0
      //   563: getfield 65	io/reactivex/internal/operators/flowable/j$b:p2	Lio/reactivex/internal/util/AtomicThrowable;
      //   566: aload_3
      //   567: invokevirtual 217	io/reactivex/internal/util/AtomicThrowable:addThrowable	(Ljava/lang/Throwable;)Z
      //   570: pop
      //   571: aload_0
      //   572: getfield 81	io/reactivex/internal/operators/flowable/j$b:x	Z
      //   575: ifne +12 -> 587
      //   578: aload_0
      //   579: getfield 125	io/reactivex/internal/operators/flowable/j$b:J3	Le/b/c;
      //   582: invokeinterface 127 1 0
      //   587: aload_0
      //   588: invokevirtual 174	io/reactivex/internal/operators/flowable/j$b:d	()Z
      //   591: ifeq +4 -> 595
      //   594: return
      //   595: aload_0
      //   596: aload 21
      //   598: invokevirtual 221	io/reactivex/internal/operators/flowable/j$b:m	(Lio/reactivex/internal/operators/flowable/j$a;)V
      //   601: iload 15
      //   603: iconst_1
      //   604: iadd
      //   605: istore 17
      //   607: iload 18
      //   609: istore 19
      //   611: iconst_1
      //   612: istore 16
      //   614: iload 20
      //   616: istore 18
      //   618: iload 17
      //   620: istore 20
      //   622: lload 4
      //   624: lstore 9
      //   626: goto +221 -> 847
      //   629: lload 7
      //   631: lconst_0
      //   632: lcmp
      //   633: ifeq +41 -> 674
      //   636: iload 6
      //   638: ifne +18 -> 656
      //   641: aload_0
      //   642: getfield 75	io/reactivex/internal/operators/flowable/j$b:I3	Ljava/util/concurrent/atomic/AtomicLong;
      //   645: lload 7
      //   647: lneg
      //   648: invokevirtual 191	java/util/concurrent/atomic/AtomicLong:addAndGet	(J)J
      //   651: lstore 11
      //   653: goto +8 -> 661
      //   656: ldc2_w 178
      //   659: lstore 11
      //   661: aload 21
      //   663: lload 7
      //   665: invokevirtual 224	io/reactivex/internal/operators/flowable/j$a:a	(J)V
      //   668: lconst_0
      //   669: lstore 9
      //   671: goto +6 -> 677
      //   674: lconst_0
      //   675: lstore 9
      //   677: lload 11
      //   679: lstore 7
      //   681: lload 11
      //   683: lload 9
      //   685: lcmp
      //   686: ifeq +21 -> 707
      //   689: aload_3
      //   690: ifnonnull +10 -> 700
      //   693: lload 11
      //   695: lstore 7
      //   697: goto +10 -> 707
      //   700: iload 18
      //   702: istore 16
      //   704: goto -238 -> 466
      //   707: aload 13
      //   709: astore_3
      //   710: aload 21
      //   712: getfield 225	io/reactivex/internal/operators/flowable/j$a:x	Z
      //   715: istore 14
      //   717: aload 21
      //   719: getfield 208	io/reactivex/internal/operators/flowable/j$a:y	Lio/reactivex/h0/b/i;
      //   722: astore 22
      //   724: iload 14
      //   726: ifeq +44 -> 770
      //   729: aload 22
      //   731: ifnull +13 -> 744
      //   734: aload 22
      //   736: invokeinterface 196 1 0
      //   741: ifeq +29 -> 770
      //   744: aload_0
      //   745: aload 21
      //   747: invokevirtual 221	io/reactivex/internal/operators/flowable/j$b:m	(Lio/reactivex/internal/operators/flowable/j$a;)V
      //   750: aload_0
      //   751: invokevirtual 174	io/reactivex/internal/operators/flowable/j$b:d	()Z
      //   754: ifeq +4 -> 758
      //   757: return
      //   758: lload 4
      //   760: lconst_1
      //   761: ladd
      //   762: lstore 4
      //   764: iconst_1
      //   765: istore 17
      //   767: goto +3 -> 770
      //   770: lload 7
      //   772: lconst_0
      //   773: lcmp
      //   774: ifne +9 -> 783
      //   777: aload_3
      //   778: astore 13
      //   780: goto +92 -> 872
      //   783: iload 20
      //   785: iconst_1
      //   786: iadd
      //   787: istore 23
      //   789: iload 16
      //   791: istore 24
      //   793: iload 17
      //   795: istore 16
      //   797: iload 23
      //   799: istore 18
      //   801: iload 15
      //   803: istore 20
      //   805: lload 7
      //   807: lstore 11
      //   809: iload 24
      //   811: istore 19
      //   813: lload 4
      //   815: lstore 9
      //   817: iload 23
      //   819: iload 24
      //   821: if_icmpne +26 -> 847
      //   824: iconst_0
      //   825: istore 18
      //   827: lload 4
      //   829: lstore 9
      //   831: iload 24
      //   833: istore 19
      //   835: lload 7
      //   837: lstore 11
      //   839: iload 15
      //   841: istore 20
      //   843: iload 17
      //   845: istore 16
      //   847: iload 20
      //   849: iconst_1
      //   850: iadd
      //   851: istore 15
      //   853: iload 16
      //   855: istore 17
      //   857: iload 18
      //   859: istore 20
      //   861: iload 19
      //   863: istore 16
      //   865: lload 9
      //   867: lstore 4
      //   869: goto -427 -> 442
      //   872: aload_0
      //   873: iload 20
      //   875: putfield 203	io/reactivex/internal/operators/flowable/j$b:M3	I
      //   878: aload_0
      //   879: aload 13
      //   881: iload 20
      //   883: aaload
      //   884: getfield 205	io/reactivex/internal/operators/flowable/j$a:c	J
      //   887: putfield 201	io/reactivex/internal/operators/flowable/j$b:L3	J
      //   890: goto +10 -> 900
      //   893: iconst_0
      //   894: istore 17
      //   896: lload 11
      //   898: lstore 4
      //   900: lload 4
      //   902: lconst_0
      //   903: lcmp
      //   904: ifeq +21 -> 925
      //   907: aload_0
      //   908: getfield 123	io/reactivex/internal/operators/flowable/j$b:p3	Z
      //   911: ifne +14 -> 925
      //   914: aload_0
      //   915: getfield 125	io/reactivex/internal/operators/flowable/j$b:J3	Le/b/c;
      //   918: lload 4
      //   920: invokeinterface 228 3 0
      //   925: iload 17
      //   927: ifeq +6 -> 933
      //   930: goto -923 -> 7
      //   933: aload_0
      //   934: iload_2
      //   935: ineg
      //   936: invokevirtual 231	java/util/concurrent/atomic/AtomicInteger:addAndGet	(I)I
      //   939: istore 17
      //   941: iload 17
      //   943: istore_2
      //   944: iload 17
      //   946: ifne -939 -> 7
      //   949: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	950	0	this	b
      //   4	519	1	localb	e.b.b
      //   6	938	2	i	int
      //   19	505	3	localObject1	Object
      //   552	138	3	localThrowable	Throwable
      //   709	69	3	localObject2	Object
      //   27	892	4	l1	long
      //   39	598	6	j	int
      //   48	788	7	l2	long
      //   52	814	9	l3	long
      //   56	841	11	l4	long
      //   66	814	13	localObject3	Object
      //   198	527	14	bool	boolean
      //   220	632	15	k	int
      //   300	564	16	m	int
      //   311	634	17	n	int
      //   372	486	18	i1	int
      //   416	446	19	i2	int
      //   436	446	20	i3	int
      //   462	284	21	locala	j.a
      //   479	256	22	locali	i
      //   787	35	23	i4	int
      //   791	41	24	i5	int
      // Exception table:
      //   from	to	target	type
      //   507	515	552	finally
    }
    
    i<U> j(j.a<T, U> parama)
    {
      i locali = parama.y;
      Object localObject = locali;
      if (locali == null)
      {
        localObject = new SpscArrayQueue(this.z);
        parama.y = ((i)localObject);
      }
      return (i<U>)localObject;
    }
    
    i<U> k()
    {
      io.reactivex.h0.b.h localh = this.p0;
      Object localObject = localh;
      if (localh == null)
      {
        if (this.y == Integer.MAX_VALUE) {
          localObject = new io.reactivex.internal.queue.b(this.z);
        } else {
          localObject = new SpscArrayQueue(this.y);
        }
        this.p0 = ((io.reactivex.h0.b.h)localObject);
      }
      return (i<U>)localObject;
    }
    
    void l(j.a<T, U> parama, Throwable paramThrowable)
    {
      if (this.p2.addThrowable(paramThrowable))
      {
        parama.x = true;
        if (!this.x)
        {
          this.J3.cancel();
          parama = (j.a[])this.H3.getAndSet(d);
          int i = parama.length;
          for (int j = 0; j < i; j++) {
            parama[j].dispose();
          }
        }
        h();
      }
      else
      {
        io.reactivex.j0.a.r(paramThrowable);
      }
    }
    
    void m(j.a<T, U> parama)
    {
      j.a[] arrayOfa1;
      j.a[] arrayOfa2;
      do
      {
        arrayOfa1 = (j.a[])this.H3.get();
        int i = arrayOfa1.length;
        if (i == 0) {
          return;
        }
        int j = -1;
        int m;
        for (int k = 0;; k++)
        {
          m = j;
          if (k >= i) {
            break;
          }
          if (arrayOfa1[k] == parama)
          {
            m = k;
            break;
          }
        }
        if (m < 0) {
          return;
        }
        if (i == 1)
        {
          arrayOfa2 = c;
        }
        else
        {
          arrayOfa2 = new j.a[i - 1];
          System.arraycopy(arrayOfa1, 0, arrayOfa2, 0, m);
          System.arraycopy(arrayOfa1, m + 1, arrayOfa2, m, i - m - 1);
        }
      } while (!this.H3.compareAndSet(arrayOfa1, arrayOfa2));
    }
    
    void n(U paramU, j.a<T, U> parama)
    {
      i locali;
      Object localObject;
      if ((get() == 0) && (compareAndSet(0, 1)))
      {
        long l = this.I3.get();
        locali = parama.y;
        if ((l != 0L) && ((locali == null) || (locali.isEmpty())))
        {
          this.f.onNext(paramU);
          if (l != Long.MAX_VALUE) {
            this.I3.decrementAndGet();
          }
          parama.a(1L);
        }
        else
        {
          localObject = locali;
          if (locali == null) {
            localObject = j(parama);
          }
          if (!((i)localObject).offer(paramU))
          {
            onError(new MissingBackpressureException("Inner queue full?!"));
            return;
          }
        }
        if (decrementAndGet() != 0) {}
      }
      else
      {
        locali = parama.y;
        localObject = locali;
        if (locali == null)
        {
          localObject = new SpscArrayQueue(this.z);
          parama.y = ((i)localObject);
        }
        if (!((i)localObject).offer(paramU))
        {
          onError(new MissingBackpressureException("Inner queue full?!"));
          return;
        }
        if (getAndIncrement() != 0) {
          return;
        }
      }
      i();
    }
    
    void o(U paramU)
    {
      if ((get() == 0) && (compareAndSet(0, 1)))
      {
        long l = this.I3.get();
        io.reactivex.h0.b.h localh = this.p0;
        if ((l != 0L) && ((localh == null) || (localh.isEmpty())))
        {
          this.f.onNext(paramU);
          if (l != Long.MAX_VALUE) {
            this.I3.decrementAndGet();
          }
          if ((this.y != Integer.MAX_VALUE) && (!this.p3))
          {
            int i = this.N3 + 1;
            this.N3 = i;
            int j = this.O3;
            if (i == j)
            {
              this.N3 = 0;
              this.J3.request(j);
            }
          }
        }
        else
        {
          Object localObject = localh;
          if (localh == null) {
            localObject = k();
          }
          if (!((i)localObject).offer(paramU))
          {
            onError(new IllegalStateException("Scalar queue full?!"));
            return;
          }
        }
        if (decrementAndGet() != 0) {}
      }
      else
      {
        if (!k().offer(paramU))
        {
          onError(new IllegalStateException("Scalar queue full?!"));
          return;
        }
        if (getAndIncrement() != 0) {
          return;
        }
      }
      i();
    }
    
    public void onComplete()
    {
      if (this.p1) {
        return;
      }
      this.p1 = true;
      h();
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.p1)
      {
        io.reactivex.j0.a.r(paramThrowable);
        return;
      }
      if (this.p2.addThrowable(paramThrowable))
      {
        this.p1 = true;
        if (!this.x)
        {
          paramThrowable = (j.a[])this.H3.getAndSet(d);
          int i = paramThrowable.length;
          for (int j = 0; j < i; j++) {
            paramThrowable[j].dispose();
          }
        }
        h();
      }
      else
      {
        io.reactivex.j0.a.r(paramThrowable);
      }
    }
    
    /* Error */
    public void onNext(T paramT)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 193	io/reactivex/internal/operators/flowable/j$b:p1	Z
      //   4: ifeq +4 -> 8
      //   7: return
      //   8: aload_0
      //   9: getfield 79	io/reactivex/internal/operators/flowable/j$b:q	Lio/reactivex/g0/j;
      //   12: aload_1
      //   13: invokeinterface 295 2 0
      //   18: ldc_w 297
      //   21: invokestatic 303	io/reactivex/h0/a/b:e	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
      //   24: checkcast 305	e/b/a
      //   27: astore_2
      //   28: aload_2
      //   29: instanceof 307
      //   32: ifeq +104 -> 136
      //   35: aload_2
      //   36: checkcast 307	java/util/concurrent/Callable
      //   39: invokeinterface 310 1 0
      //   44: astore_1
      //   45: aload_1
      //   46: ifnull +11 -> 57
      //   49: aload_0
      //   50: aload_1
      //   51: invokevirtual 312	io/reactivex/internal/operators/flowable/j$b:o	(Ljava/lang/Object;)V
      //   54: goto +122 -> 176
      //   57: aload_0
      //   58: getfield 83	io/reactivex/internal/operators/flowable/j$b:y	I
      //   61: ldc -14
      //   63: if_icmpeq +113 -> 176
      //   66: aload_0
      //   67: getfield 123	io/reactivex/internal/operators/flowable/j$b:p3	Z
      //   70: ifne +106 -> 176
      //   73: aload_0
      //   74: getfield 282	io/reactivex/internal/operators/flowable/j$b:N3	I
      //   77: iconst_1
      //   78: iadd
      //   79: istore_3
      //   80: aload_0
      //   81: iload_3
      //   82: putfield 282	io/reactivex/internal/operators/flowable/j$b:N3	I
      //   85: aload_0
      //   86: getfield 93	io/reactivex/internal/operators/flowable/j$b:O3	I
      //   89: istore 4
      //   91: iload_3
      //   92: iload 4
      //   94: if_icmpne +82 -> 176
      //   97: aload_0
      //   98: iconst_0
      //   99: putfield 282	io/reactivex/internal/operators/flowable/j$b:N3	I
      //   102: aload_0
      //   103: getfield 125	io/reactivex/internal/operators/flowable/j$b:J3	Le/b/c;
      //   106: iload 4
      //   108: i2l
      //   109: invokeinterface 228 3 0
      //   114: goto +62 -> 176
      //   117: astore_1
      //   118: aload_1
      //   119: invokestatic 213	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
      //   122: aload_0
      //   123: getfield 65	io/reactivex/internal/operators/flowable/j$b:p2	Lio/reactivex/internal/util/AtomicThrowable;
      //   126: aload_1
      //   127: invokevirtual 217	io/reactivex/internal/util/AtomicThrowable:addThrowable	(Ljava/lang/Throwable;)Z
      //   130: pop
      //   131: aload_0
      //   132: invokevirtual 250	io/reactivex/internal/operators/flowable/j$b:h	()V
      //   135: return
      //   136: aload_0
      //   137: getfield 314	io/reactivex/internal/operators/flowable/j$b:K3	J
      //   140: lstore 5
      //   142: aload_0
      //   143: lconst_1
      //   144: lload 5
      //   146: ladd
      //   147: putfield 314	io/reactivex/internal/operators/flowable/j$b:K3	J
      //   150: new 51	io/reactivex/internal/operators/flowable/j$a
      //   153: dup
      //   154: aload_0
      //   155: lload 5
      //   157: invokespecial 317	io/reactivex/internal/operators/flowable/j$a:<init>	(Lio/reactivex/internal/operators/flowable/j$b;J)V
      //   160: astore_1
      //   161: aload_0
      //   162: aload_1
      //   163: invokevirtual 319	io/reactivex/internal/operators/flowable/j$b:a	(Lio/reactivex/internal/operators/flowable/j$a;)Z
      //   166: ifeq +10 -> 176
      //   169: aload_2
      //   170: aload_1
      //   171: invokeinterface 322 2 0
      //   176: return
      //   177: astore_1
      //   178: aload_1
      //   179: invokestatic 213	io/reactivex/exceptions/a:b	(Ljava/lang/Throwable;)V
      //   182: aload_0
      //   183: getfield 125	io/reactivex/internal/operators/flowable/j$b:J3	Le/b/c;
      //   186: invokeinterface 127 1 0
      //   191: aload_0
      //   192: aload_1
      //   193: invokevirtual 276	io/reactivex/internal/operators/flowable/j$b:onError	(Ljava/lang/Throwable;)V
      //   196: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	197	0	this	b
      //   0	197	1	paramT	T
      //   27	143	2	locala	e.b.a
      //   79	16	3	i	int
      //   89	18	4	j	int
      //   140	16	5	l	long
      // Exception table:
      //   from	to	target	type
      //   35	45	117	finally
      //   8	28	177	finally
    }
    
    public void onSubscribe(e.b.c paramc)
    {
      if (SubscriptionHelper.validate(this.J3, paramc))
      {
        this.J3 = paramc;
        this.f.onSubscribe(this);
        if (!this.p3)
        {
          int i = this.y;
          if (i == Integer.MAX_VALUE) {
            paramc.request(Long.MAX_VALUE);
          } else {
            paramc.request(i);
          }
        }
      }
    }
    
    public void request(long paramLong)
    {
      if (SubscriptionHelper.validate(paramLong))
      {
        io.reactivex.internal.util.b.a(this.I3, paramLong);
        h();
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\internal\operators\flowable\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */