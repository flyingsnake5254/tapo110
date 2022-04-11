package kotlinx.coroutines.d2;

import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.a;
import kotlin.jvm.b.l;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.q;
import kotlin.k;
import kotlinx.coroutines.internal.x;

public final class b
{
  public static final <T> void a(l<? super c<? super T>, ? extends Object> paraml, c<? super T> paramc)
  {
    j.f(paraml, "$this$startCoroutineUndispatched");
    j.f(paramc, "completion");
    c localc = kotlin.coroutines.jvm.internal.f.a(paramc);
    try
    {
      kotlin.coroutines.f localf = paramc.getContext();
      paramc = x.c(localf, null);
      return;
    }
    finally
    {
      try
      {
        paraml = ((l)q.b(paraml, 1)).invoke(localc);
        x.a(localf, paramc);
        if (paraml == a.d()) {
          return;
        }
        paramc = Result.Companion;
        localc.resumeWith(Result.constructor-impl(paraml));
      }
      finally
      {
        x.a(localf, paramc);
      }
      paramc = Result.Companion;
      localc.resumeWith(Result.constructor-impl(k.a(paraml)));
    }
  }
  
  public static final <R, T> void b(p<? super R, ? super c<? super T>, ? extends Object> paramp, R paramR, c<? super T> paramc)
  {
    j.f(paramp, "$this$startCoroutineUndispatched");
    j.f(paramc, "completion");
    c localc = kotlin.coroutines.jvm.internal.f.a(paramc);
    try
    {
      kotlin.coroutines.f localf = paramc.getContext();
      paramc = x.c(localf, null);
      return;
    }
    finally
    {
      try
      {
        paramp = ((p)q.b(paramp, 2)).invoke(paramR, localc);
        x.a(localf, paramc);
        if (paramp == a.d()) {
          return;
        }
        paramR = Result.Companion;
        localc.resumeWith(Result.constructor-impl(paramp));
      }
      finally
      {
        x.a(localf, paramc);
      }
      paramR = Result.Companion;
      localc.resumeWith(Result.constructor-impl(k.a(paramp)));
    }
  }
  
  /* Error */
  public static final <R, T> void c(p<? super R, ? super c<? super T>, ? extends Object> paramp, R paramR, c<? super T> paramc)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 84
    //   3: invokestatic 14	kotlin/jvm/internal/j:f	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_2
    //   7: ldc 16
    //   9: invokestatic 14	kotlin/jvm/internal/j:f	(Ljava/lang/Object;Ljava/lang/String;)V
    //   12: aload_2
    //   13: invokestatic 21	kotlin/coroutines/jvm/internal/f:a	(Lkotlin/coroutines/c;)Lkotlin/coroutines/c;
    //   16: astore_2
    //   17: aload_0
    //   18: iconst_2
    //   19: invokestatic 39	kotlin/jvm/internal/q:b	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   22: checkcast 78	kotlin/jvm/b/p
    //   25: aload_1
    //   26: aload_2
    //   27: invokeinterface 81 3 0
    //   32: astore_1
    //   33: aload_1
    //   34: invokestatic 54	kotlin/coroutines/intrinsics/a:d	()Ljava/lang/Object;
    //   37: if_acmpeq +38 -> 75
    //   40: getstatic 60	kotlin/Result:Companion	Lkotlin/Result$a;
    //   43: astore_0
    //   44: aload_2
    //   45: aload_1
    //   46: invokestatic 63	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   49: invokeinterface 67 2 0
    //   54: goto +21 -> 75
    //   57: astore_1
    //   58: getstatic 60	kotlin/Result:Companion	Lkotlin/Result$a;
    //   61: astore_0
    //   62: aload_2
    //   63: aload_1
    //   64: invokestatic 72	kotlin/k:a	(Ljava/lang/Throwable;)Ljava/lang/Object;
    //   67: invokestatic 63	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   70: invokeinterface 67 2 0
    //   75: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	paramp	p<? super R, ? super c<? super T>, ? extends Object>
    //   0	76	1	paramR	R
    //   0	76	2	paramc	c<? super T>
    // Exception table:
    //   from	to	target	type
    //   17	33	57	finally
  }
  
  /* Error */
  public static final <T, R> Object d(kotlinx.coroutines.a<? super T> parama, R paramR, p<? super R, ? super c<? super T>, ? extends Object> paramp)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 87
    //   3: invokestatic 14	kotlin/jvm/internal/j:f	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_2
    //   7: ldc 89
    //   9: invokestatic 14	kotlin/jvm/internal/j:f	(Ljava/lang/Object;Ljava/lang/String;)V
    //   12: aload_0
    //   13: invokevirtual 95	kotlinx/coroutines/a:q0	()V
    //   16: aload_2
    //   17: iconst_2
    //   18: invokestatic 39	kotlin/jvm/internal/q:b	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   21: checkcast 78	kotlin/jvm/b/p
    //   24: aload_1
    //   25: aload_0
    //   26: invokeinterface 81 3 0
    //   31: astore_1
    //   32: goto +16 -> 48
    //   35: astore_1
    //   36: new 97	kotlinx/coroutines/r
    //   39: dup
    //   40: aload_1
    //   41: iconst_0
    //   42: iconst_2
    //   43: aconst_null
    //   44: invokespecial 101	kotlinx/coroutines/r:<init>	(Ljava/lang/Throwable;ZILkotlin/jvm/internal/f;)V
    //   47: astore_1
    //   48: aload_1
    //   49: invokestatic 54	kotlin/coroutines/intrinsics/a:d	()Ljava/lang/Object;
    //   52: if_acmpne +10 -> 62
    //   55: invokestatic 54	kotlin/coroutines/intrinsics/a:d	()Ljava/lang/Object;
    //   58: astore_0
    //   59: goto +48 -> 107
    //   62: aload_0
    //   63: aload_1
    //   64: iconst_4
    //   65: invokevirtual 107	kotlinx/coroutines/j1:S	(Ljava/lang/Object;I)Z
    //   68: ifeq +35 -> 103
    //   71: aload_0
    //   72: invokevirtual 110	kotlinx/coroutines/j1:L	()Ljava/lang/Object;
    //   75: astore_1
    //   76: aload_1
    //   77: instanceof 97
    //   80: ifeq +15 -> 95
    //   83: aload_0
    //   84: aload_1
    //   85: checkcast 97	kotlinx/coroutines/r
    //   88: getfield 113	kotlinx/coroutines/r:b	Ljava/lang/Throwable;
    //   91: invokestatic 118	kotlinx/coroutines/internal/r:a	(Lkotlinx/coroutines/a;Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   94: athrow
    //   95: aload_1
    //   96: invokestatic 123	kotlinx/coroutines/k1:e	(Ljava/lang/Object;)Ljava/lang/Object;
    //   99: astore_0
    //   100: goto +7 -> 107
    //   103: invokestatic 54	kotlin/coroutines/intrinsics/a:d	()Ljava/lang/Object;
    //   106: astore_0
    //   107: aload_0
    //   108: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	parama	kotlinx.coroutines.a<? super T>
    //   0	109	1	paramR	R
    //   0	109	2	paramp	p<? super R, ? super c<? super T>, ? extends Object>
    // Exception table:
    //   from	to	target	type
    //   16	32	35	finally
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\d2\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */