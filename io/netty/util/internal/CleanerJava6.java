package io.netty.util.internal;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.security.AccessController;
import java.security.PrivilegedAction;

final class CleanerJava6
  implements Cleaner
{
  private static final Field CLEANER_FIELD;
  private static final long CLEANER_FIELD_OFFSET;
  private static final Method CLEAN_METHOD;
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(CleanerJava6.class);
  
  static
  {
    Object localObject1 = ByteBuffer.allocateDirect(1);
    long l1 = -1L;
    Object localObject2 = null;
    try
    {
      localObject3 = new io/netty/util/internal/CleanerJava6$1;
      ((1)localObject3).<init>((ByteBuffer)localObject1);
      localObject3 = AccessController.doPrivileged((PrivilegedAction)localObject3);
      if (!(localObject3 instanceof Throwable))
      {
        localObject3 = (Field)localObject3;
        if (PlatformDependent.hasUnsafe())
        {
          l2 = PlatformDependent0.objectFieldOffset((Field)localObject3);
          localObject1 = PlatformDependent0.getObject(localObject1, l2);
        }
        else
        {
          localObject1 = ((Field)localObject3).get(localObject1);
          l2 = -1L;
        }
        Method localMethod = localObject1.getClass().getDeclaredMethod("clean", new Class[0]);
        localMethod.invoke(localObject1, new Object[0]);
        localObject1 = localObject3;
        localObject3 = localMethod;
      }
      else
      {
        throw ((Throwable)localObject3);
      }
    }
    finally
    {
      localObject1 = null;
      Object localObject3 = localObject1;
      long l2 = l1;
      if (localThrowable == null) {
        logger.debug("java.nio.ByteBuffer.cleaner(): available");
      } else {
        logger.debug("java.nio.ByteBuffer.cleaner(): unavailable", localThrowable);
      }
      CLEANER_FIELD = (Field)localObject1;
      CLEANER_FIELD_OFFSET = l2;
      CLEAN_METHOD = (Method)localObject3;
    }
  }
  
  private static void freeDirectBuffer0(ByteBuffer paramByteBuffer)
    throws Exception
  {
    long l = CLEANER_FIELD_OFFSET;
    if (l == -1L) {
      paramByteBuffer = CLEANER_FIELD.get(paramByteBuffer);
    } else {
      paramByteBuffer = PlatformDependent0.getObject(paramByteBuffer, l);
    }
    if (paramByteBuffer != null) {
      CLEAN_METHOD.invoke(paramByteBuffer, new Object[0]);
    }
  }
  
  private static void freeDirectBufferPrivileged(ByteBuffer paramByteBuffer)
  {
    paramByteBuffer = (Throwable)AccessController.doPrivileged(new PrivilegedAction()
    {
      public Throwable run()
      {
        try
        {
          CleanerJava6.freeDirectBuffer0(this.val$buffer);
        }
        finally
        {
          return localThrowable;
        }
      }
    });
    if (paramByteBuffer != null) {
      PlatformDependent0.throwException(paramByteBuffer);
    }
  }
  
  static boolean isSupported()
  {
    boolean bool;
    if ((CLEANER_FIELD_OFFSET == -1L) && (CLEANER_FIELD == null)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  /* Error */
  public void freeDirectBuffer(ByteBuffer paramByteBuffer)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 128	java/nio/ByteBuffer:isDirect	()Z
    //   4: ifne +4 -> 8
    //   7: return
    //   8: invokestatic 134	java/lang/System:getSecurityManager	()Ljava/lang/SecurityManager;
    //   11: ifnonnull +18 -> 29
    //   14: aload_1
    //   15: invokestatic 116	io/netty/util/internal/CleanerJava6:freeDirectBuffer0	(Ljava/nio/ByteBuffer;)V
    //   18: goto +15 -> 33
    //   21: astore_1
    //   22: aload_1
    //   23: invokestatic 123	io/netty/util/internal/PlatformDependent0:throwException	(Ljava/lang/Throwable;)V
    //   26: goto +7 -> 33
    //   29: aload_1
    //   30: invokestatic 136	io/netty/util/internal/CleanerJava6:freeDirectBufferPrivileged	(Ljava/nio/ByteBuffer;)V
    //   33: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	this	CleanerJava6
    //   0	34	1	paramByteBuffer	ByteBuffer
    // Exception table:
    //   from	to	target	type
    //   14	18	21	finally
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\CleanerJava6.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */