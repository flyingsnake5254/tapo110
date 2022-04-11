package io.netty.handler.ssl;

import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLEngine;

final class JdkDefaultApplicationProtocolNegotiator
  implements JdkApplicationProtocolNegotiator
{
  private static final JdkApplicationProtocolNegotiator.SslEngineWrapperFactory DEFAULT_SSL_ENGINE_WRAPPER_FACTORY = new JdkApplicationProtocolNegotiator.SslEngineWrapperFactory()
  {
    public SSLEngine wrapSslEngine(SSLEngine paramAnonymousSSLEngine, JdkApplicationProtocolNegotiator paramAnonymousJdkApplicationProtocolNegotiator, boolean paramAnonymousBoolean)
    {
      return paramAnonymousSSLEngine;
    }
  };
  public static final JdkDefaultApplicationProtocolNegotiator INSTANCE = new JdkDefaultApplicationProtocolNegotiator();
  
  public JdkApplicationProtocolNegotiator.ProtocolSelectionListenerFactory protocolListenerFactory()
  {
    throw new UnsupportedOperationException("Application protocol negotiation unsupported");
  }
  
  public JdkApplicationProtocolNegotiator.ProtocolSelectorFactory protocolSelectorFactory()
  {
    throw new UnsupportedOperationException("Application protocol negotiation unsupported");
  }
  
  public List<String> protocols()
  {
    return Collections.emptyList();
  }
  
  public JdkApplicationProtocolNegotiator.SslEngineWrapperFactory wrapperFactory()
  {
    return DEFAULT_SSL_ENGINE_WRAPPER_FACTORY;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\JdkDefaultApplicationProtocolNegotiator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */