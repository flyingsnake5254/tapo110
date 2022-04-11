package io.netty.channel.kqueue;

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

final class Native
{
  static final short EVFILT_READ;
  static final short EVFILT_SOCK = KQueueStaticallyReferencedJniMethods.evfiltSock();
  static final short EVFILT_USER;
  static final short EVFILT_WRITE;
  static final short EV_ADD;
  static final short EV_ADD_CLEAR_ENABLE;
  static final short EV_CLEAR;
  static final short EV_DELETE;
  static final short EV_DELETE_DISABLE;
  static final short EV_DISABLE;
  static final short EV_ENABLE;
  static final short EV_EOF;
  static final short EV_ERROR;
  static final int NOTE_CONNRESET;
  static final int NOTE_DISCONNECTED;
  static final int NOTE_RDHUP;
  static final int NOTE_READCLOSED;
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(Native.class);
  
  static
  {
    try
    {
      sizeofKEvent();
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      loadNativeLibrary();
    }
    Socket.initialize();
    int i = KQueueStaticallyReferencedJniMethods.evAdd();
    EV_ADD = (short)i;
    int j = KQueueStaticallyReferencedJniMethods.evEnable();
    EV_ENABLE = (short)j;
    int k = KQueueStaticallyReferencedJniMethods.evDisable();
    EV_DISABLE = (short)k;
    int m = KQueueStaticallyReferencedJniMethods.evDelete();
    EV_DELETE = (short)m;
    int n = KQueueStaticallyReferencedJniMethods.evClear();
    EV_CLEAR = (short)n;
    EV_ERROR = KQueueStaticallyReferencedJniMethods.evError();
    EV_EOF = KQueueStaticallyReferencedJniMethods.evEOF();
    int i1 = KQueueStaticallyReferencedJniMethods.noteReadClosed();
    NOTE_READCLOSED = i1;
    int i2 = KQueueStaticallyReferencedJniMethods.noteConnReset();
    NOTE_CONNRESET = i2;
    int i3 = KQueueStaticallyReferencedJniMethods.noteDisconnected();
    NOTE_DISCONNECTED = i3;
    NOTE_RDHUP = i1 | i2 | i3;
    EV_ADD_CLEAR_ENABLE = (short)(short)(i | n | j);
    EV_DELETE_DISABLE = (short)(short)(m | k);
    EVFILT_READ = KQueueStaticallyReferencedJniMethods.evfiltRead();
    EVFILT_WRITE = KQueueStaticallyReferencedJniMethods.evfiltWrite();
    EVFILT_USER = KQueueStaticallyReferencedJniMethods.evfiltUser();
  }
  
  static native int keventAddUserEvent(int paramInt1, int paramInt2);
  
  static native int keventTriggerUserEvent(int paramInt1, int paramInt2);
  
  private static native int keventWait(int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3, int paramInt4, int paramInt5);
  
  static int keventWait(int paramInt1, KQueueEventArray paramKQueueEventArray1, KQueueEventArray paramKQueueEventArray2, int paramInt2, int paramInt3)
    throws IOException
  {
    paramInt1 = keventWait(paramInt1, paramKQueueEventArray1.memoryAddress(), paramKQueueEventArray1.size(), paramKQueueEventArray2.memoryAddress(), paramKQueueEventArray2.capacity(), paramInt2, paramInt3);
    if (paramInt1 >= 0) {
      return paramInt1;
    }
    throw Errors.newIOException("kevent", paramInt1);
  }
  
  private static native int kqueueCreate();
  
  private static void loadNativeLibrary()
  {
    Object localObject = SystemPropertyUtil.get("os.name").toLowerCase(Locale.UK).trim();
    if ((!((String)localObject).startsWith("mac")) && (!((String)localObject).contains("bsd")) && (!((String)localObject).startsWith("darwin"))) {
      throw new IllegalStateException("Only supported on BSD");
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("netty_transport_native_kqueue");
    ((StringBuilder)localObject).append('_');
    ((StringBuilder)localObject).append(PlatformDependent.normalizedArch());
    String str = ((StringBuilder)localObject).toString();
    ClassLoader localClassLoader = PlatformDependent.getClassLoader(Native.class);
    try
    {
      NativeLibraryLoader.load(str, localClassLoader);
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError1) {}
    try
    {
      NativeLibraryLoader.load("netty_transport_native_kqueue", localClassLoader);
      logger.debug("Failed to load {}", str, localUnsatisfiedLinkError1);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
    {
      ThrowableUtil.addSuppressed(localUnsatisfiedLinkError1, localUnsatisfiedLinkError2);
      throw localUnsatisfiedLinkError1;
    }
  }
  
  static FileDescriptor newKQueue()
  {
    return new FileDescriptor(kqueueCreate());
  }
  
  static native int offsetofKEventFFlags();
  
  static native int offsetofKEventFilter();
  
  static native int offsetofKEventFlags();
  
  static native int offsetofKEventIdent();
  
  static native int offsetofKeventData();
  
  static native int sizeofKEvent();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\kqueue\Native.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */