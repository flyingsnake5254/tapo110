package io.netty.util.internal;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.security.AccessController;
import java.security.PrivilegedAction;
import sun.misc.Unsafe;

final class CleanerJava9
  implements Cleaner
{
  private static final Method INVOKE_CLEANER;
  private static final InternalLogger logger;
  
  static
  {
    InternalLogger localInternalLogger = InternalLoggerFactory.getInstance(CleanerJava9.class);
    logger = localInternalLogger;
    boolean bool = PlatformDependent0.hasUnsafe();
    Object localObject1 = null;
    if (bool)
    {
      localObject2 = AccessController.doPrivileged(new PrivilegedAction()
      {
        public Object run()
        {
          try
          {
            Unsafe localUnsafe = PlatformDependent0.UNSAFE;
            Method localMethod = localUnsafe.getClass().getDeclaredMethod("invokeCleaner", new Class[] { ByteBuffer.class });
            localMethod.invoke(localUnsafe, new Object[] { this.val$buffer });
            return localMethod;
          }
          catch (IllegalAccessException localIllegalAccessException)
          {
            return localIllegalAccessException;
          }
          catch (InvocationTargetException localInvocationTargetException)
          {
            return localInvocationTargetException;
          }
          catch (NoSuchMethodException localNoSuchMethodException)
          {
            return localNoSuchMethodException;
          }
        }
      });
      if ((localObject2 instanceof Throwable))
      {
        localObject2 = (Throwable)localObject2;
      }
      else
      {
        localObject2 = (Method)localObject2;
        break label76;
      }
    }
    else
    {
      localObject2 = new UnsupportedOperationException("sun.misc.Unsafe unavailable");
    }
    Object localObject3 = null;
    localObject1 = localObject2;
    Object localObject2 = localObject3;
    label76:
    if (localObject1 == null) {
      localInternalLogger.debug("java.nio.ByteBuffer.cleaner(): available");
    } else {
      localInternalLogger.debug("java.nio.ByteBuffer.cleaner(): unavailable", (Throwable)localObject1);
    }
    INVOKE_CLEANER = (Method)localObject2;
  }
  
  private static void freeDirectBufferPrivileged(ByteBuffer paramByteBuffer)
  {
    paramByteBuffer = (Exception)AccessController.doPrivileged(new PrivilegedAction()
    {
      public Exception run()
      {
        try
        {
          CleanerJava9.INVOKE_CLEANER.invoke(PlatformDependent0.UNSAFE, new Object[] { this.val$buffer });
          return null;
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          return localIllegalAccessException;
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          return localInvocationTargetException;
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
    if (INVOKE_CLEANER != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  /* Error */
  public void freeDirectBuffer(ByteBuffer paramByteBuffer)
  {
    // Byte code:
    //   0: invokestatic 92	java/lang/System:getSecurityManager	()Ljava/lang/SecurityManager;
    //   3: ifnonnull +32 -> 35
    //   6: getstatic 71	io/netty/util/internal/CleanerJava9:INVOKE_CLEANER	Ljava/lang/reflect/Method;
    //   9: getstatic 96	io/netty/util/internal/PlatformDependent0:UNSAFE	Lsun/misc/Unsafe;
    //   12: iconst_1
    //   13: anewarray 4	java/lang/Object
    //   16: dup
    //   17: iconst_0
    //   18: aload_1
    //   19: aastore
    //   20: invokevirtual 100	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   23: pop
    //   24: goto +15 -> 39
    //   27: astore_1
    //   28: aload_1
    //   29: invokestatic 84	io/netty/util/internal/PlatformDependent0:throwException	(Ljava/lang/Throwable;)V
    //   32: goto +7 -> 39
    //   35: aload_1
    //   36: invokestatic 102	io/netty/util/internal/CleanerJava9:freeDirectBufferPrivileged	(Ljava/nio/ByteBuffer;)V
    //   39: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	CleanerJava9
    //   0	40	1	paramByteBuffer	ByteBuffer
    // Exception table:
    //   from	to	target	type
    //   6	24	27	finally
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\CleanerJava9.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */