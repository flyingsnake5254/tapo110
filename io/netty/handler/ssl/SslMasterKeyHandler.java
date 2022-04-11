package io.netty.handler.ssl;

import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelPipeline;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.reflect.Field;
import javax.crypto.SecretKey;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLSession;

public abstract class SslMasterKeyHandler
  extends ChannelInboundHandlerAdapter
{
  private static final Class<?> SSL_SESSIONIMPL_CLASS;
  private static final Field SSL_SESSIONIMPL_MASTER_SECRET_FIELD;
  public static final String SYSTEM_PROP_KEY = "io.netty.ssl.masterKeyHandler";
  private static final Throwable UNAVAILABILITY_CAUSE;
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(SslMasterKeyHandler.class);
  
  /* Error */
  static
  {
    // Byte code:
    //   0: ldc 2
    //   2: invokestatic 30	io/netty/util/internal/logging/InternalLoggerFactory:getInstance	(Ljava/lang/Class;)Lio/netty/util/internal/logging/InternalLogger;
    //   5: putstatic 32	io/netty/handler/ssl/SslMasterKeyHandler:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   8: aconst_null
    //   9: astore_0
    //   10: aconst_null
    //   11: astore_1
    //   12: ldc 34
    //   14: invokestatic 40	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   17: astore_2
    //   18: aload_2
    //   19: ldc 42
    //   21: invokevirtual 46	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   24: astore_0
    //   25: aload_0
    //   26: astore_1
    //   27: aload_0
    //   28: iconst_1
    //   29: invokestatic 52	io/netty/util/internal/ReflectionUtil:trySetAccessible	(Ljava/lang/reflect/AccessibleObject;Z)Ljava/lang/Throwable;
    //   32: astore_3
    //   33: aload_0
    //   34: astore_1
    //   35: aload_2
    //   36: astore 4
    //   38: aload_3
    //   39: astore_0
    //   40: goto +36 -> 76
    //   43: astore 4
    //   45: aload_2
    //   46: astore_0
    //   47: aload_1
    //   48: astore_2
    //   49: aload 4
    //   51: astore_1
    //   52: goto +6 -> 58
    //   55: astore_1
    //   56: aconst_null
    //   57: astore_2
    //   58: getstatic 32	io/netty/handler/ssl/SslMasterKeyHandler:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   61: ldc 54
    //   63: aload_1
    //   64: invokeinterface 60 3 0
    //   69: aload_0
    //   70: astore 4
    //   72: aload_1
    //   73: astore_0
    //   74: aload_2
    //   75: astore_1
    //   76: aload_0
    //   77: putstatic 62	io/netty/handler/ssl/SslMasterKeyHandler:UNAVAILABILITY_CAUSE	Ljava/lang/Throwable;
    //   80: aload 4
    //   82: putstatic 64	io/netty/handler/ssl/SslMasterKeyHandler:SSL_SESSIONIMPL_CLASS	Ljava/lang/Class;
    //   85: aload_1
    //   86: putstatic 66	io/netty/handler/ssl/SslMasterKeyHandler:SSL_SESSIONIMPL_MASTER_SECRET_FIELD	Ljava/lang/reflect/Field;
    //   89: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   9	68	0	localObject1	Object
    //   11	41	1	localObject2	Object
    //   55	18	1	localThrowable1	Throwable
    //   75	11	1	localObject3	Object
    //   17	58	2	localObject4	Object
    //   32	7	3	localThrowable2	Throwable
    //   36	1	4	localObject5	Object
    //   43	7	4	localObject6	Object
    //   70	11	4	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   18	25	43	finally
    //   27	33	43	finally
    //   12	18	55	finally
  }
  
  public static void ensureSunSslEngineAvailability()
  {
    Throwable localThrowable = UNAVAILABILITY_CAUSE;
    if (localThrowable == null) {
      return;
    }
    throw new IllegalStateException("Failed to find SSLSessionImpl on classpath", localThrowable);
  }
  
  public static boolean isSunSslEngineAvailable()
  {
    boolean bool;
    if (UNAVAILABILITY_CAUSE == null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static SslMasterKeyHandler newWireSharkSslMasterKeyHandler()
  {
    return new WiresharkSslMasterKeyHandler(null);
  }
  
  public static Throwable sunSslEngineUnavailabilityCause()
  {
    return UNAVAILABILITY_CAUSE;
  }
  
  protected abstract void accept(SecretKey paramSecretKey, SSLSession paramSSLSession);
  
  public final void userEventTriggered(ChannelHandlerContext paramChannelHandlerContext, Object paramObject)
  {
    if ((paramObject == SslHandshakeCompletionEvent.SUCCESS) && (SystemPropertyUtil.getBoolean("io.netty.ssl.masterKeyHandler", false)))
    {
      Object localObject = ((SslHandler)paramChannelHandlerContext.pipeline().get(SslHandler.class)).engine();
      SSLSession localSSLSession = ((SSLEngine)localObject).getSession();
      if ((isSunSslEngineAvailable()) && (localSSLSession.getClass().equals(SSL_SESSIONIMPL_CLASS))) {
        try
        {
          localObject = (SecretKey)SSL_SESSIONIMPL_MASTER_SECRET_FIELD.get(localSSLSession);
          accept((SecretKey)localObject, localSSLSession);
        }
        catch (IllegalAccessException paramChannelHandlerContext)
        {
          throw new IllegalArgumentException("Failed to access the field 'masterSecret' via reflection.", paramChannelHandlerContext);
        }
      } else if ((OpenSsl.isAvailable()) && ((localObject instanceof ReferenceCountedOpenSslEngine))) {
        accept(((ReferenceCountedOpenSslEngine)localObject).masterKey(), localSSLSession);
      }
    }
    paramChannelHandlerContext.fireUserEventTriggered(paramObject);
  }
  
  private static final class WiresharkSslMasterKeyHandler
    extends SslMasterKeyHandler
  {
    private static final char[] hexCode = "0123456789ABCDEF".toCharArray();
    private static final InternalLogger wireshark_logger = InternalLoggerFactory.getInstance("io.netty.wireshark");
    
    protected void accept(SecretKey paramSecretKey, SSLSession paramSSLSession)
    {
      if (paramSecretKey.getEncoded().length == 48)
      {
        paramSSLSession = paramSSLSession.getId();
        wireshark_logger.warn("RSA Session-ID:{} Master-Key:{}", ByteBufUtil.hexDump(paramSSLSession).toLowerCase(), ByteBufUtil.hexDump(paramSecretKey.getEncoded()).toLowerCase());
        return;
      }
      throw new IllegalArgumentException("An invalid length master key was provided.");
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\SslMasterKeyHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */