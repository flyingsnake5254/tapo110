package kotlinx.coroutines.internal;

public final class m
{
  /* Error */
  public static final kotlinx.coroutines.m1 a(MainDispatcherFactory paramMainDispatcherFactory, java.util.List<? extends MainDispatcherFactory> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 8
    //   3: invokestatic 14	kotlin/jvm/internal/j:f	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_1
    //   7: ldc 16
    //   9: invokestatic 14	kotlin/jvm/internal/j:f	(Ljava/lang/Object;Ljava/lang/String;)V
    //   12: aload_0
    //   13: aload_1
    //   14: invokeinterface 22 2 0
    //   19: astore_1
    //   20: aload_1
    //   21: astore_0
    //   22: goto +19 -> 41
    //   25: astore_1
    //   26: new 24	kotlinx/coroutines/internal/n
    //   29: dup
    //   30: aload_1
    //   31: aload_0
    //   32: invokeinterface 27 1 0
    //   37: invokespecial 31	kotlinx/coroutines/internal/n:<init>	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   40: astore_0
    //   41: aload_0
    //   42: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	paramMainDispatcherFactory	MainDispatcherFactory
    //   0	43	1	paramList	java.util.List<? extends MainDispatcherFactory>
    // Exception table:
    //   from	to	target	type
    //   12	20	25	finally
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\internal\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */