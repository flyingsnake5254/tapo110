package io.netty.handler.ssl;

import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SuppressJava6Requirement;
import io.netty.util.internal.logging.InternalLogger;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivilegedAction;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509ExtendedTrustManager;
import javax.net.ssl.X509TrustManager;

@SuppressJava6Requirement(reason="Usage guarded by java version check")
final class OpenSslX509TrustManagerWrapper
{
  private static final InternalLogger LOGGER;
  private static final TrustManagerWrapper WRAPPER;
  
  /* Error */
  static
  {
    // Byte code:
    //   0: ldc 2
    //   2: invokestatic 31	io/netty/util/internal/logging/InternalLoggerFactory:getInstance	(Ljava/lang/Class;)Lio/netty/util/internal/logging/InternalLogger;
    //   5: astore_0
    //   6: aload_0
    //   7: putstatic 33	io/netty/handler/ssl/OpenSslX509TrustManagerWrapper:LOGGER	Lio/netty/util/internal/logging/InternalLogger;
    //   10: new 6	io/netty/handler/ssl/OpenSslX509TrustManagerWrapper$1
    //   13: dup
    //   14: invokespecial 36	io/netty/handler/ssl/OpenSslX509TrustManagerWrapper$1:<init>	()V
    //   17: astore_1
    //   18: invokestatic 42	io/netty/util/internal/PlatformDependent:getUnsafeUnavailabilityCause	()Ljava/lang/Throwable;
    //   21: astore_2
    //   22: aconst_null
    //   23: astore_3
    //   24: aload_2
    //   25: ifnonnull +101 -> 126
    //   28: invokestatic 46	io/netty/handler/ssl/OpenSslX509TrustManagerWrapper:newSSLContext	()Ljavax/net/ssl/SSLContext;
    //   31: astore_2
    //   32: new 8	io/netty/handler/ssl/OpenSslX509TrustManagerWrapper$2
    //   35: astore_0
    //   36: aload_0
    //   37: invokespecial 47	io/netty/handler/ssl/OpenSslX509TrustManagerWrapper$2:<init>	()V
    //   40: aload_2
    //   41: aconst_null
    //   42: iconst_1
    //   43: anewarray 49	javax/net/ssl/TrustManager
    //   46: dup
    //   47: iconst_0
    //   48: aload_0
    //   49: aastore
    //   50: aconst_null
    //   51: invokevirtual 55	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   54: goto +6 -> 60
    //   57: astore_3
    //   58: aconst_null
    //   59: astore_2
    //   60: aload_3
    //   61: ifnull +19 -> 80
    //   64: getstatic 33	io/netty/handler/ssl/OpenSslX509TrustManagerWrapper:LOGGER	Lio/netty/util/internal/logging/InternalLogger;
    //   67: ldc 57
    //   69: aload_3
    //   70: invokeinterface 63 3 0
    //   75: aload_1
    //   76: astore_2
    //   77: goto +60 -> 137
    //   80: new 10	io/netty/handler/ssl/OpenSslX509TrustManagerWrapper$3
    //   83: dup
    //   84: aload_2
    //   85: invokespecial 66	io/netty/handler/ssl/OpenSslX509TrustManagerWrapper$3:<init>	(Ljavax/net/ssl/SSLContext;)V
    //   88: invokestatic 72	java/security/AccessController:doPrivileged	(Ljava/security/PrivilegedAction;)Ljava/lang/Object;
    //   91: astore_2
    //   92: aload_2
    //   93: instanceof 74
    //   96: ifeq +22 -> 118
    //   99: getstatic 33	io/netty/handler/ssl/OpenSslX509TrustManagerWrapper:LOGGER	Lio/netty/util/internal/logging/InternalLogger;
    //   102: ldc 57
    //   104: aload_2
    //   105: checkcast 74	java/lang/Throwable
    //   108: invokeinterface 63 3 0
    //   113: aload_1
    //   114: astore_2
    //   115: goto +22 -> 137
    //   118: aload_2
    //   119: checkcast 12	io/netty/handler/ssl/OpenSslX509TrustManagerWrapper$TrustManagerWrapper
    //   122: astore_2
    //   123: goto +14 -> 137
    //   126: aload_0
    //   127: ldc 57
    //   129: aconst_null
    //   130: invokeinterface 63 3 0
    //   135: aload_1
    //   136: astore_2
    //   137: aload_2
    //   138: putstatic 76	io/netty/handler/ssl/OpenSslX509TrustManagerWrapper:WRAPPER	Lio/netty/handler/ssl/OpenSslX509TrustManagerWrapper$TrustManagerWrapper;
    //   141: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   5	122	0	localObject1	Object
    //   17	119	1	local1	1
    //   21	117	2	localObject2	Object
    //   23	1	3	localObject3	Object
    //   57	13	3	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   28	54	57	finally
  }
  
  private static SSLContext newSSLContext()
    throws NoSuchAlgorithmException, NoSuchProviderException
  {
    return SSLContext.getInstance("TLS", "SunJSSE");
  }
  
  static X509TrustManager wrapIfNeeded(X509TrustManager paramX509TrustManager)
  {
    return WRAPPER.wrapIfNeeded(paramX509TrustManager);
  }
  
  private static abstract interface TrustManagerWrapper
  {
    public abstract X509TrustManager wrapIfNeeded(X509TrustManager paramX509TrustManager);
  }
  
  private static final class UnsafeTrustManagerWrapper
    implements OpenSslX509TrustManagerWrapper.TrustManagerWrapper
  {
    private final long spiOffset;
    private final long tmOffset;
    
    UnsafeTrustManagerWrapper(long paramLong1, long paramLong2)
    {
      this.spiOffset = paramLong1;
      this.tmOffset = paramLong2;
    }
    
    @SuppressJava6Requirement(reason="Usage guarded by java version check")
    public X509TrustManager wrapIfNeeded(X509TrustManager paramX509TrustManager)
    {
      if (!(paramX509TrustManager instanceof X509ExtendedTrustManager)) {
        try
        {
          Object localObject = OpenSslX509TrustManagerWrapper.access$000();
          ((SSLContext)localObject).init(null, new TrustManager[] { paramX509TrustManager }, null);
          localObject = PlatformDependent.getObject(localObject, this.spiOffset);
          if (localObject != null)
          {
            localObject = PlatformDependent.getObject(localObject, this.tmOffset);
            if ((localObject instanceof X509ExtendedTrustManager))
            {
              localObject = (X509TrustManager)localObject;
              return (X509TrustManager)localObject;
            }
          }
        }
        catch (NoSuchProviderException localNoSuchProviderException)
        {
          PlatformDependent.throwException(localNoSuchProviderException);
        }
        catch (KeyManagementException localKeyManagementException)
        {
          PlatformDependent.throwException(localKeyManagementException);
        }
        catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
        {
          PlatformDependent.throwException(localNoSuchAlgorithmException);
        }
      }
      return paramX509TrustManager;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\OpenSslX509TrustManagerWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */