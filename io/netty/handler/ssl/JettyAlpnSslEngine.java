package io.netty.handler.ssl;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.util.LinkedHashSet;
import java.util.List;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLException;
import org.eclipse.jetty.alpn.ALPN;
import org.eclipse.jetty.alpn.ALPN.ClientProvider;
import org.eclipse.jetty.alpn.ALPN.ServerProvider;

abstract class JettyAlpnSslEngine
  extends JdkSslEngine
{
  private static final boolean available = ;
  
  private JettyAlpnSslEngine(SSLEngine paramSSLEngine)
  {
    super(paramSSLEngine);
  }
  
  private static boolean initAvailable()
  {
    if (PlatformDependent.javaVersion() <= 8) {}
    try
    {
      Class.forName("sun.security.ssl.ALPNExtension", true, null);
      return true;
    }
    finally
    {
      for (;;) {}
    }
    return false;
  }
  
  static boolean isAvailable()
  {
    return available;
  }
  
  static JettyAlpnSslEngine newClientEngine(SSLEngine paramSSLEngine, JdkApplicationProtocolNegotiator paramJdkApplicationProtocolNegotiator)
  {
    return new ClientEngine(paramSSLEngine, paramJdkApplicationProtocolNegotiator);
  }
  
  static JettyAlpnSslEngine newServerEngine(SSLEngine paramSSLEngine, JdkApplicationProtocolNegotiator paramJdkApplicationProtocolNegotiator)
  {
    return new ServerEngine(paramSSLEngine, paramJdkApplicationProtocolNegotiator);
  }
  
  private static final class ClientEngine
    extends JettyAlpnSslEngine
  {
    ClientEngine(SSLEngine paramSSLEngine, final JdkApplicationProtocolNegotiator paramJdkApplicationProtocolNegotiator)
    {
      super(null);
      ObjectUtil.checkNotNull(paramJdkApplicationProtocolNegotiator, "applicationNegotiator");
      ALPN.put(paramSSLEngine, new ALPN.ClientProvider()
      {
        public List<String> protocols()
        {
          return paramJdkApplicationProtocolNegotiator.protocols();
        }
        
        public void selected(String paramAnonymousString)
          throws SSLException
        {
          try
          {
            this.val$protocolListener.selected(paramAnonymousString);
            return;
          }
          finally {}
        }
        
        public void unsupported()
        {
          this.val$protocolListener.unsupported();
        }
      });
    }
    
    public void closeInbound()
      throws SSLException
    {
      try
      {
        ALPN.remove(getWrappedEngine());
        return;
      }
      finally
      {
        super.closeInbound();
      }
    }
    
    public void closeOutbound()
    {
      try
      {
        ALPN.remove(getWrappedEngine());
        return;
      }
      finally
      {
        super.closeOutbound();
      }
    }
  }
  
  private static final class ServerEngine
    extends JettyAlpnSslEngine
  {
    ServerEngine(SSLEngine paramSSLEngine, JdkApplicationProtocolNegotiator paramJdkApplicationProtocolNegotiator)
    {
      super(null);
      ObjectUtil.checkNotNull(paramJdkApplicationProtocolNegotiator, "applicationNegotiator");
      ALPN.put(paramSSLEngine, new ALPN.ServerProvider()
      {
        public String select(List<String> paramAnonymousList)
          throws SSLException
        {
          try
          {
            paramAnonymousList = this.val$protocolSelector.select(paramAnonymousList);
            return paramAnonymousList;
          }
          finally {}
        }
        
        public void unsupported()
        {
          this.val$protocolSelector.unsupported();
        }
      });
    }
    
    public void closeInbound()
      throws SSLException
    {
      try
      {
        ALPN.remove(getWrappedEngine());
        return;
      }
      finally
      {
        super.closeInbound();
      }
    }
    
    public void closeOutbound()
    {
      try
      {
        ALPN.remove(getWrappedEngine());
        return;
      }
      finally
      {
        super.closeOutbound();
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\JettyAlpnSslEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */