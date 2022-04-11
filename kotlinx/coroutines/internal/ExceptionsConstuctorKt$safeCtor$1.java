package kotlinx.coroutines.internal;

import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;

public final class ExceptionsConstuctorKt$safeCtor$1
  extends Lambda
  implements l<Throwable, Throwable>
{
  public ExceptionsConstuctorKt$safeCtor$1(l paraml)
  {
    super(1);
  }
  
  /* Error */
  public final Throwable invoke(Throwable paramThrowable)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 26
    //   3: invokestatic 32	kotlin/jvm/internal/j:f	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: getstatic 38	kotlin/Result:Companion	Lkotlin/Result$a;
    //   9: astore_2
    //   10: aload_0
    //   11: getfield 13	kotlinx/coroutines/internal/ExceptionsConstuctorKt$safeCtor$1:$block	Lkotlin/jvm/b/l;
    //   14: aload_1
    //   15: invokeinterface 40 2 0
    //   20: checkcast 21	java/lang/Throwable
    //   23: invokestatic 43	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   26: astore_1
    //   27: goto +16 -> 43
    //   30: astore_2
    //   31: getstatic 38	kotlin/Result:Companion	Lkotlin/Result$a;
    //   34: astore_1
    //   35: aload_2
    //   36: invokestatic 49	kotlin/k:a	(Ljava/lang/Throwable;)Ljava/lang/Object;
    //   39: invokestatic 43	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   42: astore_1
    //   43: aload_1
    //   44: astore_2
    //   45: aload_1
    //   46: invokestatic 53	kotlin/Result:isFailure-impl	(Ljava/lang/Object;)Z
    //   49: ifeq +5 -> 54
    //   52: aconst_null
    //   53: astore_2
    //   54: aload_2
    //   55: checkcast 21	java/lang/Throwable
    //   58: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	1
    //   0	59	1	paramThrowable	Throwable
    //   9	1	2	locala	kotlin.Result.a
    //   30	6	2	localThrowable1	Throwable
    //   44	11	2	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   6	27	30	finally
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\internal\ExceptionsConstuctorKt$safeCtor$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */