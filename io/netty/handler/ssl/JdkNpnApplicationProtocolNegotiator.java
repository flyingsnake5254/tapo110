package io.netty.handler.ssl;

import javax.net.ssl.SSLEngine;

@Deprecated
public final class JdkNpnApplicationProtocolNegotiator
  extends JdkBaseApplicationProtocolNegotiator
{
  private static final JdkApplicationProtocolNegotiator.SslEngineWrapperFactory NPN_WRAPPER = new JdkApplicationProtocolNegotiator.SslEngineWrapperFactory()
  {
    public SSLEngine wrapSslEngine(SSLEngine paramAnonymousSSLEngine, JdkApplicationProtocolNegotiator paramAnonymousJdkApplicationProtocolNegotiator, boolean paramAnonymousBoolean)
    {
      return new JettyNpnSslEngine(paramAnonymousSSLEngine, paramAnonymousJdkApplicationProtocolNegotiator, paramAnonymousBoolean);
    }
  };
  
  public JdkNpnApplicationProtocolNegotiator(JdkApplicationProtocolNegotiator.ProtocolSelectorFactory paramProtocolSelectorFactory, JdkApplicationProtocolNegotiator.ProtocolSelectionListenerFactory paramProtocolSelectionListenerFactory, Iterable<String> paramIterable)
  {
    super(NPN_WRAPPER, paramProtocolSelectorFactory, paramProtocolSelectionListenerFactory, paramIterable);
  }
  
  public JdkNpnApplicationProtocolNegotiator(JdkApplicationProtocolNegotiator.ProtocolSelectorFactory paramProtocolSelectorFactory, JdkApplicationProtocolNegotiator.ProtocolSelectionListenerFactory paramProtocolSelectionListenerFactory, String... paramVarArgs)
  {
    super(NPN_WRAPPER, paramProtocolSelectorFactory, paramProtocolSelectionListenerFactory, paramVarArgs);
  }
  
  public JdkNpnApplicationProtocolNegotiator(Iterable<String> paramIterable)
  {
    this(false, paramIterable);
  }
  
  public JdkNpnApplicationProtocolNegotiator(boolean paramBoolean, Iterable<String> paramIterable)
  {
    this(paramBoolean, paramBoolean, paramIterable);
  }
  
  public JdkNpnApplicationProtocolNegotiator(boolean paramBoolean1, boolean paramBoolean2, Iterable<String> paramIterable)
  {
    this(localProtocolSelectorFactory, localProtocolSelectionListenerFactory, paramIterable);
  }
  
  public JdkNpnApplicationProtocolNegotiator(boolean paramBoolean1, boolean paramBoolean2, String... paramVarArgs)
  {
    this(localProtocolSelectorFactory, localProtocolSelectionListenerFactory, paramVarArgs);
  }
  
  public JdkNpnApplicationProtocolNegotiator(boolean paramBoolean, String... paramVarArgs)
  {
    this(paramBoolean, paramBoolean, paramVarArgs);
  }
  
  public JdkNpnApplicationProtocolNegotiator(String... paramVarArgs)
  {
    this(false, paramVarArgs);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\JdkNpnApplicationProtocolNegotiator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */