package kotlinx.coroutines;

import a;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.j;
import kotlin.sequences.g;

public final class z
{
  private static final List<CoroutineExceptionHandler> a;
  
  static
  {
    Iterator localIterator = a.a();
    j.b(localIterator, "ServiceLoader.load(\n    ….classLoader\n).iterator()");
    a = g.i(g.a(localIterator));
  }
  
  /* Error */
  public static final void a(kotlin.coroutines.f paramf, Throwable paramThrowable)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 36
    //   3: invokestatic 39	kotlin/jvm/internal/j:f	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_1
    //   7: ldc 41
    //   9: invokestatic 39	kotlin/jvm/internal/j:f	(Ljava/lang/Object;Ljava/lang/String;)V
    //   12: getstatic 32	kotlinx/coroutines/z:a	Ljava/util/List;
    //   15: invokeinterface 46 1 0
    //   20: astore_2
    //   21: aload_2
    //   22: invokeinterface 52 1 0
    //   27: ifeq +57 -> 84
    //   30: aload_2
    //   31: invokeinterface 56 1 0
    //   36: checkcast 58	kotlinx/coroutines/CoroutineExceptionHandler
    //   39: astore_3
    //   40: aload_3
    //   41: aload_0
    //   42: aload_1
    //   43: invokeinterface 61 3 0
    //   48: goto -27 -> 21
    //   51: astore_3
    //   52: invokestatic 67	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   55: astore 4
    //   57: aload 4
    //   59: ldc 68
    //   61: invokestatic 21	kotlin/jvm/internal/j:b	(Ljava/lang/Object;Ljava/lang/String;)V
    //   64: aload 4
    //   66: invokevirtual 72	java/lang/Thread:getUncaughtExceptionHandler	()Ljava/lang/Thread$UncaughtExceptionHandler;
    //   69: aload 4
    //   71: aload_1
    //   72: aload_3
    //   73: invokestatic 77	kotlinx/coroutines/a0:b	(Ljava/lang/Throwable;Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   76: invokeinterface 83 3 0
    //   81: goto -60 -> 21
    //   84: invokestatic 67	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   87: astore_0
    //   88: aload_0
    //   89: ldc 68
    //   91: invokestatic 21	kotlin/jvm/internal/j:b	(Ljava/lang/Object;Ljava/lang/String;)V
    //   94: aload_0
    //   95: invokevirtual 72	java/lang/Thread:getUncaughtExceptionHandler	()Ljava/lang/Thread$UncaughtExceptionHandler;
    //   98: aload_0
    //   99: aload_1
    //   100: invokeinterface 83 3 0
    //   105: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	paramf	kotlin.coroutines.f
    //   0	106	1	paramThrowable	Throwable
    //   20	11	2	localIterator	Iterator
    //   39	2	3	localCoroutineExceptionHandler	CoroutineExceptionHandler
    //   51	22	3	localThrowable	Throwable
    //   55	15	4	localThread	Thread
    // Exception table:
    //   from	to	target	type
    //   40	48	51	finally
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */