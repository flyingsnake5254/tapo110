package io.netty.channel.epoll;

import io.netty.channel.unix.Errors;
import io.netty.channel.unix.FileDescriptor;
import io.netty.channel.unix.Socket;
import io.netty.util.internal.NativeLibraryLoader;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.ThrowableUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.util.Locale;

public final class Native
{
  public static final int EPOLLERR;
  public static final int EPOLLET;
  public static final int EPOLLIN;
  public static final int EPOLLOUT;
  public static final int EPOLLRDHUP;
  static final boolean IS_SUPPORTING_RECVMMSG;
  public static final boolean IS_SUPPORTING_SENDMMSG;
  public static final boolean IS_SUPPORTING_TCP_FASTOPEN;
  public static final String KERNEL_VERSION;
  public static final int TCP_MD5SIG_MAXKEYLEN;
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(Native.class);
  
  /* Error */
  static
  {
    // Byte code:
    //   0: ldc 2
    //   2: invokestatic 31	io/netty/util/internal/logging/InternalLoggerFactory:getInstance	(Ljava/lang/Class;)Lio/netty/util/internal/logging/InternalLogger;
    //   5: putstatic 33	io/netty/channel/epoll/Native:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   8: invokestatic 39	java/nio/channels/Selector:open	()Ljava/nio/channels/Selector;
    //   11: astore_0
    //   12: goto +6 -> 18
    //   15: astore_0
    //   16: aconst_null
    //   17: astore_0
    //   18: invokestatic 43	io/netty/channel/epoll/Native:offsetofEpollData	()I
    //   21: pop
    //   22: aload_0
    //   23: ifnull +25 -> 48
    //   26: aload_0
    //   27: invokevirtual 46	java/nio/channels/Selector:close	()V
    //   30: goto +18 -> 48
    //   33: astore_1
    //   34: goto +78 -> 112
    //   37: astore_1
    //   38: invokestatic 49	io/netty/channel/epoll/Native:loadNativeLibrary	()V
    //   41: aload_0
    //   42: ifnull +6 -> 48
    //   45: goto -19 -> 26
    //   48: invokestatic 54	io/netty/channel/unix/Socket:initialize	()V
    //   51: invokestatic 59	io/netty/channel/epoll/NativeStaticallyReferencedJniMethods:epollin	()I
    //   54: putstatic 61	io/netty/channel/epoll/Native:EPOLLIN	I
    //   57: invokestatic 64	io/netty/channel/epoll/NativeStaticallyReferencedJniMethods:epollout	()I
    //   60: putstatic 66	io/netty/channel/epoll/Native:EPOLLOUT	I
    //   63: invokestatic 69	io/netty/channel/epoll/NativeStaticallyReferencedJniMethods:epollrdhup	()I
    //   66: putstatic 71	io/netty/channel/epoll/Native:EPOLLRDHUP	I
    //   69: invokestatic 74	io/netty/channel/epoll/NativeStaticallyReferencedJniMethods:epollet	()I
    //   72: putstatic 76	io/netty/channel/epoll/Native:EPOLLET	I
    //   75: invokestatic 79	io/netty/channel/epoll/NativeStaticallyReferencedJniMethods:epollerr	()I
    //   78: putstatic 81	io/netty/channel/epoll/Native:EPOLLERR	I
    //   81: invokestatic 85	io/netty/channel/epoll/NativeStaticallyReferencedJniMethods:isSupportingSendmmsg	()Z
    //   84: putstatic 87	io/netty/channel/epoll/Native:IS_SUPPORTING_SENDMMSG	Z
    //   87: invokestatic 90	io/netty/channel/epoll/NativeStaticallyReferencedJniMethods:isSupportingRecvmmsg	()Z
    //   90: putstatic 92	io/netty/channel/epoll/Native:IS_SUPPORTING_RECVMMSG	Z
    //   93: invokestatic 95	io/netty/channel/epoll/NativeStaticallyReferencedJniMethods:isSupportingTcpFastopen	()Z
    //   96: putstatic 97	io/netty/channel/epoll/Native:IS_SUPPORTING_TCP_FASTOPEN	Z
    //   99: invokestatic 100	io/netty/channel/epoll/NativeStaticallyReferencedJniMethods:tcpMd5SigMaxKeyLen	()I
    //   102: putstatic 102	io/netty/channel/epoll/Native:TCP_MD5SIG_MAXKEYLEN	I
    //   105: invokestatic 106	io/netty/channel/epoll/NativeStaticallyReferencedJniMethods:kernelVersion	()Ljava/lang/String;
    //   108: putstatic 108	io/netty/channel/epoll/Native:KERNEL_VERSION	Ljava/lang/String;
    //   111: return
    //   112: aload_0
    //   113: ifnull +7 -> 120
    //   116: aload_0
    //   117: invokevirtual 46	java/nio/channels/Selector:close	()V
    //   120: aload_1
    //   121: athrow
    //   122: astore_0
    //   123: goto -75 -> 48
    //   126: astore_0
    //   127: goto -7 -> 120
    // Local variable table:
    //   start	length	slot	name	signature
    //   11	1	0	localSelector	java.nio.channels.Selector
    //   15	1	0	localIOException1	IOException
    //   17	100	0	localObject1	Object
    //   122	1	0	localIOException2	IOException
    //   126	1	0	localIOException3	IOException
    //   33	1	1	localObject2	Object
    //   37	84	1	localUnsatisfiedLinkError	UnsatisfiedLinkError
    // Exception table:
    //   from	to	target	type
    //   8	12	15	java/io/IOException
    //   18	22	33	finally
    //   38	41	33	finally
    //   18	22	37	java/lang/UnsatisfiedLinkError
    //   26	30	122	java/io/IOException
    //   116	120	126	java/io/IOException
  }
  
  public static int epollBusyWait(FileDescriptor paramFileDescriptor, EpollEventArray paramEpollEventArray)
    throws IOException
  {
    int i = epollBusyWait0(paramFileDescriptor.intValue(), paramEpollEventArray.memoryAddress(), paramEpollEventArray.length());
    if (i >= 0) {
      return i;
    }
    throw Errors.newIOException("epoll_wait", i);
  }
  
  private static native int epollBusyWait0(int paramInt1, long paramLong, int paramInt2);
  
  private static native int epollCreate();
  
  public static void epollCtlAdd(int paramInt1, int paramInt2, int paramInt3)
    throws IOException
  {
    paramInt1 = epollCtlAdd0(paramInt1, paramInt2, paramInt3);
    if (paramInt1 >= 0) {
      return;
    }
    throw Errors.newIOException("epoll_ctl", paramInt1);
  }
  
  private static native int epollCtlAdd0(int paramInt1, int paramInt2, int paramInt3);
  
  public static void epollCtlDel(int paramInt1, int paramInt2)
    throws IOException
  {
    paramInt1 = epollCtlDel0(paramInt1, paramInt2);
    if (paramInt1 >= 0) {
      return;
    }
    throw Errors.newIOException("epoll_ctl", paramInt1);
  }
  
  private static native int epollCtlDel0(int paramInt1, int paramInt2);
  
  public static void epollCtlMod(int paramInt1, int paramInt2, int paramInt3)
    throws IOException
  {
    paramInt1 = epollCtlMod0(paramInt1, paramInt2, paramInt3);
    if (paramInt1 >= 0) {
      return;
    }
    throw Errors.newIOException("epoll_ctl", paramInt1);
  }
  
  private static native int epollCtlMod0(int paramInt1, int paramInt2, int paramInt3);
  
  private static native int epollWait(int paramInt1, long paramLong, int paramInt2, int paramInt3);
  
  static int epollWait(FileDescriptor paramFileDescriptor, EpollEventArray paramEpollEventArray, int paramInt)
    throws IOException
  {
    paramInt = epollWait(paramFileDescriptor.intValue(), paramEpollEventArray.memoryAddress(), paramEpollEventArray.length(), paramInt);
    if (paramInt >= 0) {
      return paramInt;
    }
    throw Errors.newIOException("epoll_wait", paramInt);
  }
  
  @Deprecated
  public static int epollWait(FileDescriptor paramFileDescriptor1, EpollEventArray paramEpollEventArray, FileDescriptor paramFileDescriptor2, int paramInt1, int paramInt2)
    throws IOException
  {
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      return epollWait(paramFileDescriptor1, paramEpollEventArray, 0);
    }
    if (paramInt1 == Integer.MAX_VALUE)
    {
      paramInt1 = 0;
      paramInt2 = 0;
    }
    paramInt1 = epollWait0(paramFileDescriptor1.intValue(), paramEpollEventArray.memoryAddress(), paramEpollEventArray.length(), paramFileDescriptor2.intValue(), paramInt1, paramInt2);
    if (paramInt1 >= 0) {
      return paramInt1;
    }
    throw Errors.newIOException("epoll_wait", paramInt1);
  }
  
  static int epollWait(FileDescriptor paramFileDescriptor, EpollEventArray paramEpollEventArray, boolean paramBoolean)
    throws IOException
  {
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = -1;
    }
    return epollWait(paramFileDescriptor, paramEpollEventArray, i);
  }
  
  private static native int epollWait0(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  private static native int eventFd();
  
  public static native void eventFdRead(int paramInt);
  
  public static native void eventFdWrite(int paramInt, long paramLong);
  
  private static void loadNativeLibrary()
  {
    if (SystemPropertyUtil.get("os.name").toLowerCase(Locale.UK).trim().startsWith("linux"))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("netty_transport_native_epoll");
      localStringBuilder.append('_');
      localStringBuilder.append(PlatformDependent.normalizedArch());
      String str = localStringBuilder.toString();
      ClassLoader localClassLoader = PlatformDependent.getClassLoader(Native.class);
      try
      {
        NativeLibraryLoader.load(str, localClassLoader);
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError1) {}
      try
      {
        NativeLibraryLoader.load("netty_transport_native_epoll", localClassLoader);
        logger.debug("Failed to load {}", str, localUnsatisfiedLinkError1);
        return;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
      {
        ThrowableUtil.addSuppressed(localUnsatisfiedLinkError1, localUnsatisfiedLinkError2);
        throw localUnsatisfiedLinkError1;
      }
    }
    throw new IllegalStateException("Only supported on Linux");
  }
  
  public static FileDescriptor newEpollCreate()
  {
    return new FileDescriptor(epollCreate());
  }
  
  public static FileDescriptor newEventFd()
  {
    return new FileDescriptor(eventFd());
  }
  
  public static FileDescriptor newTimerFd()
  {
    return new FileDescriptor(timerFd());
  }
  
  public static native int offsetofEpollData();
  
  static int recvmmsg(int paramInt1, boolean paramBoolean, NativeDatagramPacketArray.NativeDatagramPacket[] paramArrayOfNativeDatagramPacket, int paramInt2, int paramInt3)
    throws IOException
  {
    paramInt1 = recvmmsg0(paramInt1, paramBoolean, paramArrayOfNativeDatagramPacket, paramInt2, paramInt3);
    if (paramInt1 >= 0) {
      return paramInt1;
    }
    return Errors.ioResult("recvmmsg", paramInt1);
  }
  
  private static native int recvmmsg0(int paramInt1, boolean paramBoolean, NativeDatagramPacketArray.NativeDatagramPacket[] paramArrayOfNativeDatagramPacket, int paramInt2, int paramInt3);
  
  static int sendmmsg(int paramInt1, boolean paramBoolean, NativeDatagramPacketArray.NativeDatagramPacket[] paramArrayOfNativeDatagramPacket, int paramInt2, int paramInt3)
    throws IOException
  {
    paramInt1 = sendmmsg0(paramInt1, paramBoolean, paramArrayOfNativeDatagramPacket, paramInt2, paramInt3);
    if (paramInt1 >= 0) {
      return paramInt1;
    }
    return Errors.ioResult("sendmmsg", paramInt1);
  }
  
  @Deprecated
  public static int sendmmsg(int paramInt1, NativeDatagramPacketArray.NativeDatagramPacket[] paramArrayOfNativeDatagramPacket, int paramInt2, int paramInt3)
    throws IOException
  {
    return sendmmsg(paramInt1, Socket.isIPv6Preferred(), paramArrayOfNativeDatagramPacket, paramInt2, paramInt3);
  }
  
  private static native int sendmmsg0(int paramInt1, boolean paramBoolean, NativeDatagramPacketArray.NativeDatagramPacket[] paramArrayOfNativeDatagramPacket, int paramInt2, int paramInt3);
  
  public static native int sizeofEpollEvent();
  
  public static int splice(int paramInt1, long paramLong1, int paramInt2, long paramLong2, long paramLong3)
    throws IOException
  {
    paramInt1 = splice0(paramInt1, paramLong1, paramInt2, paramLong2, paramLong3);
    if (paramInt1 >= 0) {
      return paramInt1;
    }
    return Errors.ioResult("splice", paramInt1);
  }
  
  private static native int splice0(int paramInt1, long paramLong1, int paramInt2, long paramLong2, long paramLong3);
  
  private static native int timerFd();
  
  static native void timerFdRead(int paramInt);
  
  static native void timerFdSetTime(int paramInt1, int paramInt2, int paramInt3)
    throws IOException;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\epoll\Native.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */