package kotlinx.coroutines.flow.internal;

import kotlin.TypeCastException;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.q;
import kotlin.jvm.internal.j;
import kotlin.k;
import kotlinx.coroutines.channels.g;
import kotlinx.coroutines.channels.n;
import kotlinx.coroutines.channels.r;
import kotlinx.coroutines.d0;
import kotlinx.coroutines.e0;
import kotlinx.coroutines.flow.b;
import kotlinx.coroutines.internal.t;

public final class CombineKt
{
  private static final r<Object> b(d0 paramd0, kotlinx.coroutines.flow.a<?> parama)
  {
    return n.b(paramd0, null, 0, new a(parama, null), 3, null);
  }
  
  public static final <R, T> Object c(b<? super R> paramb, final kotlinx.coroutines.flow.a<? extends T>[] paramArrayOfa, final kotlin.jvm.b.a<T[]> parama, final q<? super b<? super R>, ? super T[], ? super c<? super kotlin.p>, ? extends Object> paramq, c<? super kotlin.p> paramc)
  {
    e0.a(new SuspendLambda(paramb, paramArrayOfa)
    {
      private d0 c;
      Object d;
      Object f;
      int p0;
      Object q;
      Object x;
      Object y;
      int z;
      
      public final c<kotlin.p> create(Object paramAnonymousObject, c<?> paramAnonymousc)
      {
        j.f(paramAnonymousc, "completion");
        paramAnonymousc = new 2(this.p1, paramArrayOfa, parama, paramq, paramAnonymousc);
        paramAnonymousc.c = ((d0)paramAnonymousObject);
        return paramAnonymousc;
      }
      
      public final Object invoke(Object paramAnonymousObject1, Object paramAnonymousObject2)
      {
        return ((2)create(paramAnonymousObject1, (c)paramAnonymousObject2)).invokeSuspend(kotlin.p.a);
      }
      
      /* Error */
      public final Object invokeSuspend(Object paramAnonymousObject)
      {
        // Byte code:
        //   0: invokestatic 92	kotlin/coroutines/intrinsics/a:d	()Ljava/lang/Object;
        //   3: astore_2
        //   4: aload_0
        //   5: getfield 94	kotlinx/coroutines/flow/internal/CombineKt$combineInternal$2:p0	I
        //   8: istore_3
        //   9: iload_3
        //   10: ifeq +83 -> 93
        //   13: iload_3
        //   14: iconst_1
        //   15: if_icmpne +68 -> 83
        //   18: aload_0
        //   19: getfield 96	kotlinx/coroutines/flow/internal/CombineKt$combineInternal$2:y	Ljava/lang/Object;
        //   22: checkcast 2	kotlinx/coroutines/flow/internal/CombineKt$combineInternal$2
        //   25: astore 4
        //   27: aload_0
        //   28: getfield 98	kotlinx/coroutines/flow/internal/CombineKt$combineInternal$2:x	Ljava/lang/Object;
        //   31: checkcast 100	[Ljava/lang/Boolean;
        //   34: astore 5
        //   36: aload_0
        //   37: getfield 102	kotlinx/coroutines/flow/internal/CombineKt$combineInternal$2:q	Ljava/lang/Object;
        //   40: checkcast 104	[Ljava/lang/Object;
        //   43: astore 6
        //   45: aload_0
        //   46: getfield 106	kotlinx/coroutines/flow/internal/CombineKt$combineInternal$2:f	Ljava/lang/Object;
        //   49: checkcast 108	[Lkotlinx/coroutines/channels/r;
        //   52: astore 4
        //   54: aload_0
        //   55: getfield 110	kotlinx/coroutines/flow/internal/CombineKt$combineInternal$2:z	I
        //   58: istore_3
        //   59: aload_0
        //   60: getfield 112	kotlinx/coroutines/flow/internal/CombineKt$combineInternal$2:d	Ljava/lang/Object;
        //   63: checkcast 68	kotlinx/coroutines/d0
        //   66: astore 7
        //   68: aload_1
        //   69: invokestatic 118	kotlin/k:b	(Ljava/lang/Object;)V
        //   72: aload_0
        //   73: astore_1
        //   74: aload_2
        //   75: astore 8
        //   77: aload 7
        //   79: astore_2
        //   80: goto +412 -> 492
        //   83: new 120	java/lang/IllegalStateException
        //   86: dup
        //   87: ldc 122
        //   89: invokespecial 125	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
        //   92: athrow
        //   93: aload_1
        //   94: invokestatic 118	kotlin/k:b	(Ljava/lang/Object;)V
        //   97: aload_0
        //   98: getfield 70	kotlinx/coroutines/flow/internal/CombineKt$combineInternal$2:c	Lkotlinx/coroutines/d0;
        //   101: astore 6
        //   103: aload_0
        //   104: getfield 47	kotlinx/coroutines/flow/internal/CombineKt$combineInternal$2:p2	[Lkotlinx/coroutines/flow/a;
        //   107: arraylength
        //   108: istore 9
        //   110: iload 9
        //   112: anewarray 127	kotlinx/coroutines/channels/r
        //   115: astore 4
        //   117: iconst_0
        //   118: istore_3
        //   119: iload_3
        //   120: iload 9
        //   122: if_icmpge +34 -> 156
        //   125: iload_3
        //   126: invokestatic 132	kotlin/coroutines/jvm/internal/a:c	(I)Ljava/lang/Integer;
        //   129: invokevirtual 138	java/lang/Number:intValue	()I
        //   132: istore 10
        //   134: aload 4
        //   136: iload_3
        //   137: aload 6
        //   139: aload_0
        //   140: getfield 47	kotlinx/coroutines/flow/internal/CombineKt$combineInternal$2:p2	[Lkotlinx/coroutines/flow/a;
        //   143: iload 10
        //   145: aaload
        //   146: invokestatic 141	kotlinx/coroutines/flow/internal/CombineKt:a	(Lkotlinx/coroutines/d0;Lkotlinx/coroutines/flow/a;)Lkotlinx/coroutines/channels/r;
        //   149: aastore
        //   150: iinc 3 1
        //   153: goto -34 -> 119
        //   156: iload 9
        //   158: anewarray 143	java/lang/Object
        //   161: astore 11
        //   163: iload 9
        //   165: anewarray 145	java/lang/Boolean
        //   168: astore 5
        //   170: iconst_0
        //   171: istore_3
        //   172: iload_3
        //   173: iload 9
        //   175: if_icmpge +25 -> 200
        //   178: iload_3
        //   179: invokestatic 132	kotlin/coroutines/jvm/internal/a:c	(I)Ljava/lang/Integer;
        //   182: invokevirtual 138	java/lang/Number:intValue	()I
        //   185: pop
        //   186: aload 5
        //   188: iload_3
        //   189: iconst_0
        //   190: invokestatic 148	kotlin/coroutines/jvm/internal/a:a	(Z)Ljava/lang/Boolean;
        //   193: aastore
        //   194: iinc 3 1
        //   197: goto -25 -> 172
        //   200: aload_0
        //   201: astore_1
        //   202: iload 9
        //   204: istore_3
        //   205: aload_2
        //   206: astore 8
        //   208: aload 6
        //   210: astore_2
        //   211: aload 5
        //   213: arraylength
        //   214: istore 10
        //   216: iconst_0
        //   217: istore 9
        //   219: iload 9
        //   221: iload 10
        //   223: if_icmpge +32 -> 255
        //   226: aload 5
        //   228: iload 9
        //   230: aaload
        //   231: invokevirtual 152	java/lang/Boolean:booleanValue	()Z
        //   234: invokestatic 148	kotlin/coroutines/jvm/internal/a:a	(Z)Ljava/lang/Boolean;
        //   237: invokevirtual 152	java/lang/Boolean:booleanValue	()Z
        //   240: ifne +9 -> 249
        //   243: iconst_0
        //   244: istore 9
        //   246: goto +12 -> 258
        //   249: iinc 9 1
        //   252: goto -33 -> 219
        //   255: iconst_1
        //   256: istore 9
        //   258: iload 9
        //   260: ifne +239 -> 499
        //   263: aload_1
        //   264: aload_2
        //   265: putfield 112	kotlinx/coroutines/flow/internal/CombineKt$combineInternal$2:d	Ljava/lang/Object;
        //   268: aload_1
        //   269: iload_3
        //   270: putfield 110	kotlinx/coroutines/flow/internal/CombineKt$combineInternal$2:z	I
        //   273: aload_1
        //   274: aload 4
        //   276: putfield 106	kotlinx/coroutines/flow/internal/CombineKt$combineInternal$2:f	Ljava/lang/Object;
        //   279: aload_1
        //   280: aload 11
        //   282: putfield 102	kotlinx/coroutines/flow/internal/CombineKt$combineInternal$2:q	Ljava/lang/Object;
        //   285: aload_1
        //   286: aload 5
        //   288: putfield 98	kotlinx/coroutines/flow/internal/CombineKt$combineInternal$2:x	Ljava/lang/Object;
        //   291: aload_1
        //   292: aload_1
        //   293: putfield 96	kotlinx/coroutines/flow/internal/CombineKt$combineInternal$2:y	Ljava/lang/Object;
        //   296: aload_1
        //   297: iconst_1
        //   298: putfield 94	kotlinx/coroutines/flow/internal/CombineKt$combineInternal$2:p0	I
        //   301: new 154	kotlinx/coroutines/selects/b
        //   304: dup
        //   305: aload_1
        //   306: invokespecial 157	kotlinx/coroutines/selects/b:<init>	(Lkotlin/coroutines/c;)V
        //   309: astore 6
        //   311: iconst_0
        //   312: istore 9
        //   314: iload 9
        //   316: iload_3
        //   317: if_icmpge +142 -> 459
        //   320: aload 5
        //   322: iload 9
        //   324: aaload
        //   325: invokevirtual 152	java/lang/Boolean:booleanValue	()Z
        //   328: istore 12
        //   330: aload 4
        //   332: iload 9
        //   334: aaload
        //   335: astore 13
        //   337: new 14	kotlinx/coroutines/flow/internal/CombineKt$combineInternal$2$a
        //   340: astore 14
        //   342: aload 6
        //   344: astore 15
        //   346: aload_1
        //   347: astore 7
        //   349: iload_3
        //   350: istore 10
        //   352: aload 14
        //   354: iload 9
        //   356: aconst_null
        //   357: aload_1
        //   358: iload_3
        //   359: aload 5
        //   361: aload 4
        //   363: aload 11
        //   365: invokespecial 160	kotlinx/coroutines/flow/internal/CombineKt$combineInternal$2$a:<init>	(ILkotlin/coroutines/c;Lkotlinx/coroutines/flow/internal/CombineKt$combineInternal$2;I[Ljava/lang/Boolean;[Lkotlinx/coroutines/channels/r;[Ljava/lang/Object;)V
        //   368: iload 12
        //   370: ifeq +6 -> 376
        //   373: goto +48 -> 421
        //   376: aload 13
        //   378: invokeinterface 164 1 0
        //   383: astore 16
        //   385: new 16	kotlinx/coroutines/flow/internal/CombineKt$combineInternal$2$invokeSuspend$$inlined$select$lambda$2
        //   388: astore 13
        //   390: aload 13
        //   392: aload 14
        //   394: aconst_null
        //   395: iload 9
        //   397: aload 7
        //   399: iload 10
        //   401: aload 5
        //   403: aload 4
        //   405: aload 11
        //   407: invokespecial 167	kotlinx/coroutines/flow/internal/CombineKt$combineInternal$2$invokeSuspend$$inlined$select$lambda$2:<init>	(Lkotlin/jvm/b/p;Lkotlin/coroutines/c;ILkotlinx/coroutines/flow/internal/CombineKt$combineInternal$2;I[Ljava/lang/Boolean;[Lkotlinx/coroutines/channels/r;[Ljava/lang/Object;)V
        //   410: aload 15
        //   412: aload 16
        //   414: aload 13
        //   416: invokeinterface 173 3 0
        //   421: iinc 9 1
        //   424: aload 15
        //   426: astore 6
        //   428: aload 7
        //   430: astore_1
        //   431: iload 10
        //   433: istore_3
        //   434: goto -120 -> 314
        //   437: astore 7
        //   439: goto +10 -> 449
        //   442: astore 7
        //   444: goto +5 -> 449
        //   447: astore 7
        //   449: aload 6
        //   451: aload 7
        //   453: invokevirtual 177	kotlinx/coroutines/selects/b:P	(Ljava/lang/Throwable;)V
        //   456: goto +3 -> 459
        //   459: aload 6
        //   461: invokevirtual 180	kotlinx/coroutines/selects/b:N	()Ljava/lang/Object;
        //   464: astore 6
        //   466: aload 6
        //   468: invokestatic 92	kotlin/coroutines/intrinsics/a:d	()Ljava/lang/Object;
        //   471: if_acmpne +7 -> 478
        //   474: aload_1
        //   475: invokestatic 184	kotlin/coroutines/jvm/internal/f:c	(Lkotlin/coroutines/c;)V
        //   478: aload 6
        //   480: aload 8
        //   482: if_acmpne +6 -> 488
        //   485: aload 8
        //   487: areturn
        //   488: aload 11
        //   490: astore 6
        //   492: aload 6
        //   494: astore 11
        //   496: goto -285 -> 211
        //   499: getstatic 84	kotlin/p:a	Lkotlin/p;
        //   502: areturn
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	503	0	this	2
        //   0	503	1	paramAnonymousObject	Object
        //   3	262	2	localObject1	Object
        //   8	426	3	i	int
        //   25	379	4	localObject2	Object
        //   34	368	5	arrayOfBoolean	Boolean[]
        //   43	450	6	localObject3	Object
        //   66	363	7	localObject4	Object
        //   437	1	7	localObject5	Object
        //   442	1	7	localObject6	Object
        //   447	5	7	localThrowable	Throwable
        //   75	411	8	localObject7	Object
        //   108	314	9	j	int
        //   132	300	10	k	int
        //   161	334	11	localObject8	Object
        //   328	41	12	bool	boolean
        //   335	80	13	local2	invokeSuspend..inlined.select.lambda.2
        //   340	53	14	locala	a
        //   344	81	15	localObject9	Object
        //   383	30	16	localc	kotlinx.coroutines.selects.c
        // Exception table:
        //   from	to	target	type
        //   390	421	437	finally
        //   352	368	442	finally
        //   376	390	442	finally
        //   320	330	447	finally
        //   337	342	447	finally
      }
      
      static final class a
        extends SuspendLambda
        implements kotlin.jvm.b.p<Object, c<? super kotlin.p>, Object>
      {
        private Object c;
        Object d;
        Object f;
        int q;
        
        a(int paramInt1, c paramc, CombineKt.combineInternal.2 param2, int paramInt2, Boolean[] paramArrayOfBoolean, r[] paramArrayOfr, Object[] paramArrayOfObject)
        {
          super(paramc);
        }
        
        public final c<kotlin.p> create(Object paramObject, c<?> paramc)
        {
          j.f(paramc, "completion");
          paramc = new a(this.x, paramc, this.y, this.z, this.p0, this.p1, this.p2);
          paramc.c = paramObject;
          return paramc;
        }
        
        public final Object invoke(Object paramObject1, Object paramObject2)
        {
          return ((a)create(paramObject1, (c)paramObject2)).invokeSuspend(kotlin.p.a);
        }
        
        public final Object invokeSuspend(Object paramObject)
        {
          Object localObject1 = kotlin.coroutines.intrinsics.a.d();
          int i = this.q;
          Object localObject2;
          if (i != 0)
          {
            if (i == 1)
            {
              localObject2 = (Object[])this.f;
              k.b(paramObject);
            }
            else
            {
              throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
          }
          else
          {
            k.b(paramObject);
            Object localObject3 = this.c;
            paramObject = this.p2;
            paramObject[this.x] = localObject3;
            int j = paramObject.length;
            int k = 0;
            for (i = 0; i < j; i++)
            {
              boolean bool;
              if (paramObject[i] != null) {
                bool = true;
              } else {
                bool = false;
              }
              if (!kotlin.coroutines.jvm.internal.a.a(bool).booleanValue())
              {
                i = 0;
                break label121;
              }
            }
            i = 1;
            label121:
            if (i != 0)
            {
              Object[] arrayOfObject = (Object[])this.y.p3.invoke();
              j = this.z;
              for (i = k; i < j; i++)
              {
                t localt = d.a;
                localObject2 = this.p2[i];
                paramObject = localObject2;
                if (localObject2 == localt) {
                  paramObject = null;
                }
                arrayOfObject[i] = paramObject;
              }
              localObject2 = this.y;
              paramObject = ((CombineKt.combineInternal.2)localObject2).H3;
              localObject2 = ((CombineKt.combineInternal.2)localObject2).p1;
              if (arrayOfObject != null)
              {
                this.d = localObject3;
                this.f = arrayOfObject;
                this.q = 1;
                if (((q)paramObject).invoke(localObject2, arrayOfObject, this) == localObject1) {
                  return localObject1;
                }
              }
              else
              {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
              }
            }
          }
          return kotlin.p.a;
        }
      }
    }, paramc);
  }
  
  @kotlin.coroutines.jvm.internal.d(c="kotlinx.coroutines.flow.internal.CombineKt$asFairChannel$1", f="Combine.kt", l={144}, m="invokeSuspend")
  static final class a
    extends SuspendLambda
    implements kotlin.jvm.b.p<kotlinx.coroutines.channels.p<? super Object>, c<? super kotlin.p>, Object>
  {
    private kotlinx.coroutines.channels.p c;
    Object d;
    Object f;
    Object q;
    int x;
    
    a(kotlinx.coroutines.flow.a parama, c paramc)
    {
      super(paramc);
    }
    
    public final c<kotlin.p> create(Object paramObject, c<?> paramc)
    {
      j.f(paramc, "completion");
      paramc = new a(this.y, paramc);
      paramc.c = ((kotlinx.coroutines.channels.p)paramObject);
      return paramc;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      return ((a)create(paramObject1, (c)paramObject2)).invokeSuspend(kotlin.p.a);
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      Object localObject1 = kotlin.coroutines.intrinsics.a.d();
      int i = this.x;
      if (i != 0)
      {
        if (i == 1)
        {
          localObject1 = (kotlinx.coroutines.flow.a)this.q;
          localObject1 = (g)this.f;
          localObject1 = (kotlinx.coroutines.channels.p)this.d;
          k.b(paramObject);
        }
        else
        {
          throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
      }
      else
      {
        k.b(paramObject);
        paramObject = this.c;
        Object localObject2 = ((kotlinx.coroutines.channels.p)paramObject).c();
        if (localObject2 == null) {
          break label147;
        }
        localObject2 = (g)localObject2;
        kotlinx.coroutines.flow.a locala = this.y;
        a locala1 = new a((g)localObject2);
        this.d = paramObject;
        this.f = localObject2;
        this.q = locala;
        this.x = 1;
        if (locala.a(locala1, this) == localObject1) {
          return localObject1;
        }
      }
      return kotlin.p.a;
      label147:
      throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelCoroutine<kotlin.Any>");
    }
    
    public static final class a
      implements b<Object>
    {
      public a(g paramg) {}
      
      public Object a(Object paramObject, c paramc)
      {
        g localg = this.a;
        if (paramObject == null) {
          paramObject = d.a;
        }
        return localg.y0(paramObject, paramc);
      }
    }
  }
  
  static final class combineInternal$2$a
    extends SuspendLambda
    implements kotlin.jvm.b.p<Object, c<? super kotlin.p>, Object>
  {
    private Object c;
    Object d;
    Object f;
    int q;
    
    combineInternal$2$a(int paramInt1, c paramc, CombineKt.combineInternal.2 param2, int paramInt2, Boolean[] paramArrayOfBoolean, r[] paramArrayOfr, Object[] paramArrayOfObject)
    {
      super(paramc);
    }
    
    public final c<kotlin.p> create(Object paramObject, c<?> paramc)
    {
      j.f(paramc, "completion");
      paramc = new a(this.x, paramc, this.y, this.z, this.p0, this.p1, this.p2);
      paramc.c = paramObject;
      return paramc;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      return ((a)create(paramObject1, (c)paramObject2)).invokeSuspend(kotlin.p.a);
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      Object localObject1 = kotlin.coroutines.intrinsics.a.d();
      int i = this.q;
      Object localObject2;
      if (i != 0)
      {
        if (i == 1)
        {
          localObject2 = (Object[])this.f;
          k.b(paramObject);
        }
        else
        {
          throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
      }
      else
      {
        k.b(paramObject);
        Object localObject3 = this.c;
        paramObject = this.p2;
        paramObject[this.x] = localObject3;
        int j = paramObject.length;
        int k = 0;
        for (i = 0; i < j; i++)
        {
          boolean bool;
          if (paramObject[i] != null) {
            bool = true;
          } else {
            bool = false;
          }
          if (!kotlin.coroutines.jvm.internal.a.a(bool).booleanValue())
          {
            i = 0;
            break label121;
          }
        }
        i = 1;
        label121:
        if (i != 0)
        {
          Object[] arrayOfObject = (Object[])this.y.p3.invoke();
          j = this.z;
          for (i = k; i < j; i++)
          {
            t localt = d.a;
            localObject2 = this.p2[i];
            paramObject = localObject2;
            if (localObject2 == localt) {
              paramObject = null;
            }
            arrayOfObject[i] = paramObject;
          }
          localObject2 = this.y;
          paramObject = ((CombineKt.combineInternal.2)localObject2).H3;
          localObject2 = ((CombineKt.combineInternal.2)localObject2).p1;
          if (arrayOfObject != null)
          {
            this.d = localObject3;
            this.f = arrayOfObject;
            this.q = 1;
            if (((q)paramObject).invoke(localObject2, arrayOfObject, this) == localObject1) {
              return localObject1;
            }
          }
          else
          {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
          }
        }
      }
      return kotlin.p.a;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\flow\internal\CombineKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */