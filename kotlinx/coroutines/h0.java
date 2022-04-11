package kotlinx.coroutines;

import kotlin.jvm.internal.j;

public final class h0
{
  public static final String a(Object paramObject)
  {
    j.f(paramObject, "$this$classSimpleName");
    paramObject = paramObject.getClass().getSimpleName();
    j.b(paramObject, "this::class.java.simpleName");
    return (String)paramObject;
  }
  
  public static final String b(Object paramObject)
  {
    j.f(paramObject, "$this$hexAddress");
    paramObject = Integer.toHexString(System.identityHashCode(paramObject));
    j.b(paramObject, "Integer.toHexString(System.identityHashCode(this))");
    return (String)paramObject;
  }
  
  /* Error */
  public static final String c(kotlin.coroutines.c<?> paramc)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 50
    //   3: invokestatic 14	kotlin/jvm/internal/j:f	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_0
    //   7: instanceof 52
    //   10: ifeq +11 -> 21
    //   13: aload_0
    //   14: invokevirtual 55	java/lang/Object:toString	()Ljava/lang/String;
    //   17: astore_0
    //   18: goto +117 -> 135
    //   21: getstatic 61	kotlin/Result:Companion	Lkotlin/Result$a;
    //   24: astore_1
    //   25: new 63	java/lang/StringBuilder
    //   28: astore_1
    //   29: aload_1
    //   30: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   33: aload_1
    //   34: aload_0
    //   35: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload_1
    //   40: bipush 64
    //   42: invokevirtual 74	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload_1
    //   47: aload_0
    //   48: invokestatic 76	kotlinx/coroutines/h0:b	(Ljava/lang/Object;)Ljava/lang/String;
    //   51: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload_1
    //   56: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokestatic 84	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   62: astore_1
    //   63: goto +16 -> 79
    //   66: astore_2
    //   67: getstatic 61	kotlin/Result:Companion	Lkotlin/Result$a;
    //   70: astore_1
    //   71: aload_2
    //   72: invokestatic 89	kotlin/k:a	(Ljava/lang/Throwable;)Ljava/lang/Object;
    //   75: invokestatic 84	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   78: astore_1
    //   79: aload_1
    //   80: invokestatic 93	kotlin/Result:exceptionOrNull-impl	(Ljava/lang/Object;)Ljava/lang/Throwable;
    //   83: ifnonnull +6 -> 89
    //   86: goto +44 -> 130
    //   89: new 63	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   96: astore_1
    //   97: aload_1
    //   98: aload_0
    //   99: invokevirtual 18	java/lang/Object:getClass	()Ljava/lang/Class;
    //   102: invokevirtual 96	java/lang/Class:getName	()Ljava/lang/String;
    //   105: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: aload_1
    //   110: bipush 64
    //   112: invokevirtual 74	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload_1
    //   117: aload_0
    //   118: invokestatic 76	kotlinx/coroutines/h0:b	(Ljava/lang/Object;)Ljava/lang/String;
    //   121: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: aload_1
    //   126: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: astore_1
    //   130: aload_1
    //   131: checkcast 98	java/lang/String
    //   134: astore_0
    //   135: aload_0
    //   136: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	paramc	kotlin.coroutines.c<?>
    //   24	107	1	localObject	Object
    //   66	6	2	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   21	63	66	finally
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\h0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */