package io.netty.handler.ssl;

import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.SuppressJava6Requirement;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.reflect.Method;
import java.security.PrivilegedExceptionAction;
import java.util.List;
import java.util.function.BiFunction;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLParameters;

@SuppressJava6Requirement(reason="Usage guarded by java version check")
final class JdkAlpnSslUtils
{
  private static final Method GET_APPLICATION_PROTOCOL;
  private static final Method GET_HANDSHAKE_APPLICATION_PROTOCOL;
  private static final Method GET_HANDSHAKE_APPLICATION_PROTOCOL_SELECTOR;
  private static final Method SET_APPLICATION_PROTOCOLS;
  private static final Method SET_HANDSHAKE_APPLICATION_PROTOCOL_SELECTOR;
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(JdkAlpnSslUtils.class);
  
  /* Error */
  static
  {
    // Byte code:
    //   0: ldc 2
    //   2: invokestatic 35	io/netty/util/internal/logging/InternalLoggerFactory:getInstance	(Ljava/lang/Class;)Lio/netty/util/internal/logging/InternalLogger;
    //   5: putstatic 37	io/netty/handler/ssl/JdkAlpnSslUtils:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   8: aconst_null
    //   9: astore_0
    //   10: ldc 39
    //   12: invokestatic 44	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   15: astore_1
    //   16: aload_1
    //   17: aconst_null
    //   18: aconst_null
    //   19: aconst_null
    //   20: invokevirtual 48	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   23: aload_1
    //   24: invokevirtual 52	javax/net/ssl/SSLContext:createSSLEngine	()Ljavax/net/ssl/SSLEngine;
    //   27: astore_2
    //   28: new 6	io/netty/handler/ssl/JdkAlpnSslUtils$1
    //   31: astore_1
    //   32: aload_1
    //   33: invokespecial 55	io/netty/handler/ssl/JdkAlpnSslUtils$1:<init>	()V
    //   36: aload_1
    //   37: invokestatic 61	java/security/AccessController:doPrivileged	(Ljava/security/PrivilegedExceptionAction;)Ljava/lang/Object;
    //   40: checkcast 63	java/lang/reflect/Method
    //   43: astore_3
    //   44: aload_3
    //   45: aload_2
    //   46: iconst_0
    //   47: anewarray 4	java/lang/Object
    //   50: invokevirtual 67	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   53: pop
    //   54: new 8	io/netty/handler/ssl/JdkAlpnSslUtils$2
    //   57: astore_1
    //   58: aload_1
    //   59: invokespecial 68	io/netty/handler/ssl/JdkAlpnSslUtils$2:<init>	()V
    //   62: aload_1
    //   63: invokestatic 61	java/security/AccessController:doPrivileged	(Ljava/security/PrivilegedExceptionAction;)Ljava/lang/Object;
    //   66: checkcast 63	java/lang/reflect/Method
    //   69: astore 4
    //   71: aload 4
    //   73: aload_2
    //   74: iconst_0
    //   75: anewarray 4	java/lang/Object
    //   78: invokevirtual 67	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   81: pop
    //   82: new 10	io/netty/handler/ssl/JdkAlpnSslUtils$3
    //   85: astore_1
    //   86: aload_1
    //   87: invokespecial 69	io/netty/handler/ssl/JdkAlpnSslUtils$3:<init>	()V
    //   90: aload_1
    //   91: invokestatic 61	java/security/AccessController:doPrivileged	(Ljava/security/PrivilegedExceptionAction;)Ljava/lang/Object;
    //   94: checkcast 63	java/lang/reflect/Method
    //   97: astore_1
    //   98: aload_1
    //   99: aload_2
    //   100: invokevirtual 75	javax/net/ssl/SSLEngine:getSSLParameters	()Ljavax/net/ssl/SSLParameters;
    //   103: iconst_1
    //   104: anewarray 4	java/lang/Object
    //   107: dup
    //   108: iconst_0
    //   109: getstatic 81	io/netty/util/internal/EmptyArrays:EMPTY_STRINGS	[Ljava/lang/String;
    //   112: aastore
    //   113: invokevirtual 67	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   116: pop
    //   117: new 12	io/netty/handler/ssl/JdkAlpnSslUtils$4
    //   120: astore 5
    //   122: aload 5
    //   124: invokespecial 82	io/netty/handler/ssl/JdkAlpnSslUtils$4:<init>	()V
    //   127: aload 5
    //   129: invokestatic 61	java/security/AccessController:doPrivileged	(Ljava/security/PrivilegedExceptionAction;)Ljava/lang/Object;
    //   132: checkcast 63	java/lang/reflect/Method
    //   135: astore 5
    //   137: new 14	io/netty/handler/ssl/JdkAlpnSslUtils$5
    //   140: astore 6
    //   142: aload 6
    //   144: invokespecial 83	io/netty/handler/ssl/JdkAlpnSslUtils$5:<init>	()V
    //   147: aload 5
    //   149: aload_2
    //   150: iconst_1
    //   151: anewarray 4	java/lang/Object
    //   154: dup
    //   155: iconst_0
    //   156: aload 6
    //   158: aastore
    //   159: invokevirtual 67	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   162: pop
    //   163: new 16	io/netty/handler/ssl/JdkAlpnSslUtils$6
    //   166: astore 6
    //   168: aload 6
    //   170: invokespecial 84	io/netty/handler/ssl/JdkAlpnSslUtils$6:<init>	()V
    //   173: aload 6
    //   175: invokestatic 61	java/security/AccessController:doPrivileged	(Ljava/security/PrivilegedExceptionAction;)Ljava/lang/Object;
    //   178: checkcast 63	java/lang/reflect/Method
    //   181: astore 6
    //   183: aload 6
    //   185: aload_2
    //   186: iconst_0
    //   187: anewarray 4	java/lang/Object
    //   190: invokevirtual 67	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   193: pop
    //   194: aload_3
    //   195: astore_0
    //   196: aload 6
    //   198: astore_3
    //   199: goto +44 -> 243
    //   202: astore_1
    //   203: invokestatic 90	io/netty/util/internal/PlatformDependent:javaVersion	()I
    //   206: istore 7
    //   208: iload 7
    //   210: bipush 9
    //   212: if_icmplt +19 -> 231
    //   215: getstatic 37	io/netty/handler/ssl/JdkAlpnSslUtils:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   218: ldc 92
    //   220: iload 7
    //   222: invokestatic 98	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   225: aload_1
    //   226: invokeinterface 104 4 0
    //   231: aconst_null
    //   232: astore 4
    //   234: aload 4
    //   236: astore_1
    //   237: aload_1
    //   238: astore 5
    //   240: aload 5
    //   242: astore_3
    //   243: aload_0
    //   244: putstatic 106	io/netty/handler/ssl/JdkAlpnSslUtils:GET_HANDSHAKE_APPLICATION_PROTOCOL	Ljava/lang/reflect/Method;
    //   247: aload 4
    //   249: putstatic 108	io/netty/handler/ssl/JdkAlpnSslUtils:GET_APPLICATION_PROTOCOL	Ljava/lang/reflect/Method;
    //   252: aload_1
    //   253: putstatic 110	io/netty/handler/ssl/JdkAlpnSslUtils:SET_APPLICATION_PROTOCOLS	Ljava/lang/reflect/Method;
    //   256: aload 5
    //   258: putstatic 112	io/netty/handler/ssl/JdkAlpnSslUtils:SET_HANDSHAKE_APPLICATION_PROTOCOL_SELECTOR	Ljava/lang/reflect/Method;
    //   261: aload_3
    //   262: putstatic 114	io/netty/handler/ssl/JdkAlpnSslUtils:GET_HANDSHAKE_APPLICATION_PROTOCOL_SELECTOR	Ljava/lang/reflect/Method;
    //   265: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   9	235	0	localObject1	Object
    //   15	84	1	localObject2	Object
    //   202	24	1	localObject3	Object
    //   236	17	1	localObject4	Object
    //   27	159	2	localSSLEngine	SSLEngine
    //   43	219	3	localObject5	Object
    //   69	179	4	localMethod	Method
    //   120	137	5	localObject6	Object
    //   140	57	6	localObject7	Object
    //   206	15	7	i	int
    // Exception table:
    //   from	to	target	type
    //   10	194	202	finally
  }
  
  static String getApplicationProtocol(SSLEngine paramSSLEngine)
  {
    try
    {
      paramSSLEngine = (String)GET_APPLICATION_PROTOCOL.invoke(paramSSLEngine, new Object[0]);
      return paramSSLEngine;
    }
    catch (Exception paramSSLEngine)
    {
      throw new IllegalStateException(paramSSLEngine);
    }
    catch (UnsupportedOperationException paramSSLEngine)
    {
      throw paramSSLEngine;
    }
  }
  
  static String getHandshakeApplicationProtocol(SSLEngine paramSSLEngine)
  {
    try
    {
      paramSSLEngine = (String)GET_HANDSHAKE_APPLICATION_PROTOCOL.invoke(paramSSLEngine, new Object[0]);
      return paramSSLEngine;
    }
    catch (Exception paramSSLEngine)
    {
      throw new IllegalStateException(paramSSLEngine);
    }
    catch (UnsupportedOperationException paramSSLEngine)
    {
      throw paramSSLEngine;
    }
  }
  
  static BiFunction<SSLEngine, List<String>, String> getHandshakeApplicationProtocolSelector(SSLEngine paramSSLEngine)
  {
    try
    {
      paramSSLEngine = (BiFunction)GET_HANDSHAKE_APPLICATION_PROTOCOL_SELECTOR.invoke(paramSSLEngine, new Object[0]);
      return paramSSLEngine;
    }
    catch (Exception paramSSLEngine)
    {
      throw new IllegalStateException(paramSSLEngine);
    }
    catch (UnsupportedOperationException paramSSLEngine)
    {
      throw paramSSLEngine;
    }
  }
  
  static void setApplicationProtocols(SSLEngine paramSSLEngine, List<String> paramList)
  {
    SSLParameters localSSLParameters = paramSSLEngine.getSSLParameters();
    paramList = (String[])paramList.toArray(EmptyArrays.EMPTY_STRINGS);
    try
    {
      SET_APPLICATION_PROTOCOLS.invoke(localSSLParameters, new Object[] { paramList });
      paramSSLEngine.setSSLParameters(localSSLParameters);
      return;
    }
    catch (Exception paramSSLEngine)
    {
      throw new IllegalStateException(paramSSLEngine);
    }
    catch (UnsupportedOperationException paramSSLEngine)
    {
      throw paramSSLEngine;
    }
  }
  
  static void setHandshakeApplicationProtocolSelector(SSLEngine paramSSLEngine, BiFunction<SSLEngine, List<String>, String> paramBiFunction)
  {
    try
    {
      SET_HANDSHAKE_APPLICATION_PROTOCOL_SELECTOR.invoke(paramSSLEngine, new Object[] { paramBiFunction });
      return;
    }
    catch (Exception paramSSLEngine)
    {
      throw new IllegalStateException(paramSSLEngine);
    }
    catch (UnsupportedOperationException paramSSLEngine)
    {
      throw paramSSLEngine;
    }
  }
  
  static boolean supportsAlpn()
  {
    boolean bool;
    if (GET_APPLICATION_PROTOCOL != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\JdkAlpnSslUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */