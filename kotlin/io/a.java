package kotlin.io;

public final class a
{
  /* Error */
  public static final void a(java.io.Closeable paramCloseable, Throwable paramThrowable)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +6 -> 7
    //   4: goto +31 -> 35
    //   7: aload_1
    //   8: ifnonnull +12 -> 20
    //   11: aload_0
    //   12: invokeinterface 12 1 0
    //   17: goto +18 -> 35
    //   20: aload_0
    //   21: invokeinterface 12 1 0
    //   26: goto +9 -> 35
    //   29: astore_0
    //   30: aload_1
    //   31: aload_0
    //   32: invokestatic 17	kotlin/a:a	(Ljava/lang/Throwable;Ljava/lang/Throwable;)V
    //   35: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	paramCloseable	java.io.Closeable
    //   0	36	1	paramThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   20	26	29	finally
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\io\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */