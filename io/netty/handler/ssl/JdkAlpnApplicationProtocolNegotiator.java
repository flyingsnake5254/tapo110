package io.netty.handler.ssl;

import io.netty.buffer.ByteBufAllocator;
import javax.net.ssl.SSLEngine;

@Deprecated
public final class JdkAlpnApplicationProtocolNegotiator
  extends JdkBaseApplicationProtocolNegotiator
{
  private static final JdkApplicationProtocolNegotiator.SslEngineWrapperFactory ALPN_WRAPPER;
  private static final boolean AVAILABLE;
  
  static
  {
    boolean bool;
    if ((!Conscrypt.isAvailable()) && (!JdkAlpnSslUtils.supportsAlpn()) && (!JettyAlpnSslEngine.isAvailable())) {
      bool = false;
    } else {
      bool = true;
    }
    AVAILABLE = bool;
    Object localObject;
    if (bool) {
      localObject = new AlpnWrapper(null);
    } else {
      localObject = new FailureWrapper(null);
    }
    ALPN_WRAPPER = (JdkApplicationProtocolNegotiator.SslEngineWrapperFactory)localObject;
  }
  
  public JdkAlpnApplicationProtocolNegotiator(JdkApplicationProtocolNegotiator.ProtocolSelectorFactory paramProtocolSelectorFactory, JdkApplicationProtocolNegotiator.ProtocolSelectionListenerFactory paramProtocolSelectionListenerFactory, Iterable<String> paramIterable)
  {
    super(ALPN_WRAPPER, paramProtocolSelectorFactory, paramProtocolSelectionListenerFactory, paramIterable);
  }
  
  public JdkAlpnApplicationProtocolNegotiator(JdkApplicationProtocolNegotiator.ProtocolSelectorFactory paramProtocolSelectorFactory, JdkApplicationProtocolNegotiator.ProtocolSelectionListenerFactory paramProtocolSelectionListenerFactory, String... paramVarArgs)
  {
    super(ALPN_WRAPPER, paramProtocolSelectorFactory, paramProtocolSelectionListenerFactory, paramVarArgs);
  }
  
  public JdkAlpnApplicationProtocolNegotiator(Iterable<String> paramIterable)
  {
    this(false, paramIterable);
  }
  
  public JdkAlpnApplicationProtocolNegotiator(boolean paramBoolean, Iterable<String> paramIterable)
  {
    this(paramBoolean, paramBoolean, paramIterable);
  }
  
  public JdkAlpnApplicationProtocolNegotiator(boolean paramBoolean1, boolean paramBoolean2, Iterable<String> paramIterable)
  {
    this(localProtocolSelectorFactory, localProtocolSelectionListenerFactory, paramIterable);
  }
  
  public JdkAlpnApplicationProtocolNegotiator(boolean paramBoolean1, boolean paramBoolean2, String... paramVarArgs)
  {
    this(localProtocolSelectorFactory, localProtocolSelectionListenerFactory, paramVarArgs);
  }
  
  public JdkAlpnApplicationProtocolNegotiator(boolean paramBoolean, String... paramVarArgs)
  {
    this(paramBoolean, paramBoolean, paramVarArgs);
  }
  
  public JdkAlpnApplicationProtocolNegotiator(String... paramVarArgs)
  {
    this(false, paramVarArgs);
  }
  
  static boolean isAlpnSupported()
  {
    return AVAILABLE;
  }
  
  private static final class AlpnWrapper
    extends JdkApplicationProtocolNegotiator.AllocatorAwareSslEngineWrapperFactory
  {
    public SSLEngine wrapSslEngine(SSLEngine paramSSLEngine, ByteBufAllocator paramByteBufAllocator, JdkApplicationProtocolNegotiator paramJdkApplicationProtocolNegotiator, boolean paramBoolean)
    {
      if (Conscrypt.isEngineSupported(paramSSLEngine))
      {
        if (paramBoolean) {
          paramSSLEngine = ConscryptAlpnSslEngine.newServerEngine(paramSSLEngine, paramByteBufAllocator, paramJdkApplicationProtocolNegotiator);
        } else {
          paramSSLEngine = ConscryptAlpnSslEngine.newClientEngine(paramSSLEngine, paramByteBufAllocator, paramJdkApplicationProtocolNegotiator);
        }
        return paramSSLEngine;
      }
      if (JdkAlpnSslUtils.supportsAlpn()) {
        return new JdkAlpnSslEngine(paramSSLEngine, paramJdkApplicationProtocolNegotiator, paramBoolean);
      }
      if (JettyAlpnSslEngine.isAvailable())
      {
        if (paramBoolean) {
          paramSSLEngine = JettyAlpnSslEngine.newServerEngine(paramSSLEngine, paramJdkApplicationProtocolNegotiator);
        } else {
          paramSSLEngine = JettyAlpnSslEngine.newClientEngine(paramSSLEngine, paramJdkApplicationProtocolNegotiator);
        }
        return paramSSLEngine;
      }
      paramByteBufAllocator = new StringBuilder();
      paramByteBufAllocator.append("ALPN not supported. Unable to wrap SSLEngine of type '");
      paramByteBufAllocator.append(paramSSLEngine.getClass().getName());
      paramByteBufAllocator.append("')");
      throw new UnsupportedOperationException(paramByteBufAllocator.toString());
    }
  }
  
  private static final class FailureWrapper
    extends JdkApplicationProtocolNegotiator.AllocatorAwareSslEngineWrapperFactory
  {
    public SSLEngine wrapSslEngine(SSLEngine paramSSLEngine, ByteBufAllocator paramByteBufAllocator, JdkApplicationProtocolNegotiator paramJdkApplicationProtocolNegotiator, boolean paramBoolean)
    {
      throw new RuntimeException("ALPN unsupported. Is your classpath configured correctly? For Conscrypt, add the appropriate Conscrypt JAR to classpath and set the security provider. For Jetty-ALPN, see http://www.eclipse.org/jetty/documentation/current/alpn-chapter.html#alpn-starting");
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\JdkAlpnApplicationProtocolNegotiator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */