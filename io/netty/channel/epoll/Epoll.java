package io.netty.channel.epoll;

public final class Epoll
{
  private static final Throwable UNAVAILABILITY_CAUSE;
  
  /* Error */
  static
  {
    // Byte code:
    //   0: ldc 12
    //   2: iconst_0
    //   3: invokestatic 18	io/netty/util/internal/SystemPropertyUtil:getBoolean	(Ljava/lang/String;Z)Z
    //   6: istore_0
    //   7: aconst_null
    //   8: astore_1
    //   9: aconst_null
    //   10: astore_2
    //   11: iload_0
    //   12: ifeq +16 -> 28
    //   15: new 20	java/lang/UnsupportedOperationException
    //   18: dup
    //   19: ldc 22
    //   21: invokespecial 26	java/lang/UnsupportedOperationException:<init>	(Ljava/lang/String;)V
    //   24: astore_3
    //   25: goto +70 -> 95
    //   28: invokestatic 32	io/netty/channel/epoll/Native:newEpollCreate	()Lio/netty/channel/unix/FileDescriptor;
    //   31: astore 4
    //   33: invokestatic 35	io/netty/channel/epoll/Native:newEventFd	()Lio/netty/channel/unix/FileDescriptor;
    //   36: astore 5
    //   38: aload 4
    //   40: ifnull +12 -> 52
    //   43: aload 4
    //   45: invokevirtual 40	io/netty/channel/unix/FileDescriptor:close	()V
    //   48: goto +4 -> 52
    //   51: astore_3
    //   52: aload_2
    //   53: astore_3
    //   54: aload 5
    //   56: ifnull +39 -> 95
    //   59: aload_1
    //   60: astore_3
    //   61: aload 5
    //   63: invokevirtual 40	io/netty/channel/unix/FileDescriptor:close	()V
    //   66: aload_2
    //   67: astore_3
    //   68: goto +27 -> 95
    //   71: astore_2
    //   72: goto +7 -> 79
    //   75: astore_2
    //   76: aconst_null
    //   77: astore 4
    //   79: aload_2
    //   80: astore_3
    //   81: aload 4
    //   83: ifnull +12 -> 95
    //   86: aload_2
    //   87: astore_3
    //   88: aload 4
    //   90: invokevirtual 40	io/netty/channel/unix/FileDescriptor:close	()V
    //   93: aload_2
    //   94: astore_3
    //   95: aload_3
    //   96: putstatic 42	io/netty/channel/epoll/Epoll:UNAVAILABILITY_CAUSE	Ljava/lang/Throwable;
    //   99: return
    //   100: astore_2
    //   101: goto -6 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	6	0	bool	boolean
    //   8	52	1	localObject1	Object
    //   10	57	2	localObject2	Object
    //   71	1	2	localObject3	Object
    //   75	19	2	localObject4	Object
    //   100	1	2	localException1	Exception
    //   24	1	3	localUnsupportedOperationException	UnsupportedOperationException
    //   51	1	3	localException2	Exception
    //   53	43	3	localObject5	Object
    //   31	58	4	localFileDescriptor1	io.netty.channel.unix.FileDescriptor
    //   36	26	5	localFileDescriptor2	io.netty.channel.unix.FileDescriptor
    // Exception table:
    //   from	to	target	type
    //   43	48	51	java/lang/Exception
    //   33	38	71	finally
    //   28	33	75	finally
    //   61	66	100	java/lang/Exception
    //   88	93	100	java/lang/Exception
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\epoll\Epoll.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */