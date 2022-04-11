package io.netty.channel.kqueue;

public final class KQueue
{
  private static final Throwable UNAVAILABILITY_CAUSE;
  
  /* Error */
  static
  {
    // Byte code:
    //   0: ldc 12
    //   2: iconst_0
    //   3: invokestatic 18	io/netty/util/internal/SystemPropertyUtil:getBoolean	(Ljava/lang/String;Z)Z
    //   6: ifeq +16 -> 22
    //   9: new 20	java/lang/UnsupportedOperationException
    //   12: dup
    //   13: ldc 22
    //   15: invokespecial 26	java/lang/UnsupportedOperationException:<init>	(Ljava/lang/String;)V
    //   18: astore_0
    //   19: goto +21 -> 40
    //   22: invokestatic 32	io/netty/channel/kqueue/Native:newKQueue	()Lio/netty/channel/unix/FileDescriptor;
    //   25: astore_0
    //   26: aload_0
    //   27: ifnull +7 -> 34
    //   30: aload_0
    //   31: invokevirtual 37	io/netty/channel/unix/FileDescriptor:close	()V
    //   34: aconst_null
    //   35: astore_0
    //   36: goto +4 -> 40
    //   39: astore_0
    //   40: aload_0
    //   41: putstatic 39	io/netty/channel/kqueue/KQueue:UNAVAILABILITY_CAUSE	Ljava/lang/Throwable;
    //   44: return
    //   45: astore_0
    //   46: goto -12 -> 34
    // Local variable table:
    //   start	length	slot	name	signature
    //   18	18	0	localObject	Object
    //   39	2	0	localThrowable	Throwable
    //   45	1	0	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   22	26	39	finally
    //   30	34	45	java/lang/Exception
  }
  
  public static void ensureAvailability()
  {
    Throwable localThrowable = UNAVAILABILITY_CAUSE;
    if (localThrowable == null) {
      return;
    }
    throw ((Error)new UnsatisfiedLinkError("failed to load the required native library").initCause(localThrowable));
  }
  
  public static boolean isAvailable()
  {
    boolean bool;
    if (UNAVAILABILITY_CAUSE == null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static Throwable unavailabilityCause()
  {
    return UNAVAILABILITY_CAUSE;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\kqueue\KQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */