package io.netty.handler.ssl;

import io.netty.util.internal.ObjectUtil;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLHandshakeException;

class JdkBaseApplicationProtocolNegotiator
  implements JdkApplicationProtocolNegotiator
{
  static final JdkApplicationProtocolNegotiator.ProtocolSelectionListenerFactory FAIL_SELECTION_LISTENER_FACTORY = new JdkApplicationProtocolNegotiator.ProtocolSelectionListenerFactory()
  {
    public JdkApplicationProtocolNegotiator.ProtocolSelectionListener newListener(SSLEngine paramAnonymousSSLEngine, List<String> paramAnonymousList)
    {
      return new JdkBaseApplicationProtocolNegotiator.FailProtocolSelectionListener((JdkSslEngine)paramAnonymousSSLEngine, paramAnonymousList);
    }
  };
  static final JdkApplicationProtocolNegotiator.ProtocolSelectorFactory FAIL_SELECTOR_FACTORY = new JdkApplicationProtocolNegotiator.ProtocolSelectorFactory()
  {
    public JdkApplicationProtocolNegotiator.ProtocolSelector newSelector(SSLEngine paramAnonymousSSLEngine, Set<String> paramAnonymousSet)
    {
      return new JdkBaseApplicationProtocolNegotiator.FailProtocolSelector((JdkSslEngine)paramAnonymousSSLEngine, paramAnonymousSet);
    }
  };
  static final JdkApplicationProtocolNegotiator.ProtocolSelectionListenerFactory NO_FAIL_SELECTION_LISTENER_FACTORY = new JdkApplicationProtocolNegotiator.ProtocolSelectionListenerFactory()
  {
    public JdkApplicationProtocolNegotiator.ProtocolSelectionListener newListener(SSLEngine paramAnonymousSSLEngine, List<String> paramAnonymousList)
    {
      return new JdkBaseApplicationProtocolNegotiator.NoFailProtocolSelectionListener((JdkSslEngine)paramAnonymousSSLEngine, paramAnonymousList);
    }
  };
  static final JdkApplicationProtocolNegotiator.ProtocolSelectorFactory NO_FAIL_SELECTOR_FACTORY = new JdkApplicationProtocolNegotiator.ProtocolSelectorFactory()
  {
    public JdkApplicationProtocolNegotiator.ProtocolSelector newSelector(SSLEngine paramAnonymousSSLEngine, Set<String> paramAnonymousSet)
    {
      return new JdkBaseApplicationProtocolNegotiator.NoFailProtocolSelector((JdkSslEngine)paramAnonymousSSLEngine, paramAnonymousSet);
    }
  };
  private final JdkApplicationProtocolNegotiator.ProtocolSelectionListenerFactory listenerFactory;
  private final List<String> protocols;
  private final JdkApplicationProtocolNegotiator.ProtocolSelectorFactory selectorFactory;
  private final JdkApplicationProtocolNegotiator.SslEngineWrapperFactory wrapperFactory;
  
  JdkBaseApplicationProtocolNegotiator(JdkApplicationProtocolNegotiator.SslEngineWrapperFactory paramSslEngineWrapperFactory, JdkApplicationProtocolNegotiator.ProtocolSelectorFactory paramProtocolSelectorFactory, JdkApplicationProtocolNegotiator.ProtocolSelectionListenerFactory paramProtocolSelectionListenerFactory, Iterable<String> paramIterable)
  {
    this(paramSslEngineWrapperFactory, paramProtocolSelectorFactory, paramProtocolSelectionListenerFactory, ApplicationProtocolUtil.toList(paramIterable));
  }
  
  private JdkBaseApplicationProtocolNegotiator(JdkApplicationProtocolNegotiator.SslEngineWrapperFactory paramSslEngineWrapperFactory, JdkApplicationProtocolNegotiator.ProtocolSelectorFactory paramProtocolSelectorFactory, JdkApplicationProtocolNegotiator.ProtocolSelectionListenerFactory paramProtocolSelectionListenerFactory, List<String> paramList)
  {
    this.wrapperFactory = ((JdkApplicationProtocolNegotiator.SslEngineWrapperFactory)ObjectUtil.checkNotNull(paramSslEngineWrapperFactory, "wrapperFactory"));
    this.selectorFactory = ((JdkApplicationProtocolNegotiator.ProtocolSelectorFactory)ObjectUtil.checkNotNull(paramProtocolSelectorFactory, "selectorFactory"));
    this.listenerFactory = ((JdkApplicationProtocolNegotiator.ProtocolSelectionListenerFactory)ObjectUtil.checkNotNull(paramProtocolSelectionListenerFactory, "listenerFactory"));
    this.protocols = Collections.unmodifiableList((List)ObjectUtil.checkNotNull(paramList, "protocols"));
  }
  
  JdkBaseApplicationProtocolNegotiator(JdkApplicationProtocolNegotiator.SslEngineWrapperFactory paramSslEngineWrapperFactory, JdkApplicationProtocolNegotiator.ProtocolSelectorFactory paramProtocolSelectorFactory, JdkApplicationProtocolNegotiator.ProtocolSelectionListenerFactory paramProtocolSelectionListenerFactory, String... paramVarArgs)
  {
    this(paramSslEngineWrapperFactory, paramProtocolSelectorFactory, paramProtocolSelectionListenerFactory, ApplicationProtocolUtil.toList(paramVarArgs));
  }
  
  public JdkApplicationProtocolNegotiator.ProtocolSelectionListenerFactory protocolListenerFactory()
  {
    return this.listenerFactory;
  }
  
  public JdkApplicationProtocolNegotiator.ProtocolSelectorFactory protocolSelectorFactory()
  {
    return this.selectorFactory;
  }
  
  public List<String> protocols()
  {
    return this.protocols;
  }
  
  public JdkApplicationProtocolNegotiator.SslEngineWrapperFactory wrapperFactory()
  {
    return this.wrapperFactory;
  }
  
  private static final class FailProtocolSelectionListener
    extends JdkBaseApplicationProtocolNegotiator.NoFailProtocolSelectionListener
  {
    FailProtocolSelectionListener(JdkSslEngine paramJdkSslEngine, List<String> paramList)
    {
      super(paramList);
    }
    
    protected void noSelectedMatchFound(String paramString)
      throws Exception
    {
      throw new SSLHandshakeException("No compatible protocols found");
    }
  }
  
  private static final class FailProtocolSelector
    extends JdkBaseApplicationProtocolNegotiator.NoFailProtocolSelector
  {
    FailProtocolSelector(JdkSslEngine paramJdkSslEngine, Set<String> paramSet)
    {
      super(paramSet);
    }
    
    public String noSelectMatchFound()
      throws Exception
    {
      throw new SSLHandshakeException("Selected protocol is not supported");
    }
  }
  
  private static class NoFailProtocolSelectionListener
    implements JdkApplicationProtocolNegotiator.ProtocolSelectionListener
  {
    private final JdkSslEngine engineWrapper;
    private final List<String> supportedProtocols;
    
    NoFailProtocolSelectionListener(JdkSslEngine paramJdkSslEngine, List<String> paramList)
    {
      this.engineWrapper = paramJdkSslEngine;
      this.supportedProtocols = paramList;
    }
    
    protected void noSelectedMatchFound(String paramString)
      throws Exception
    {}
    
    public void selected(String paramString)
      throws Exception
    {
      if (this.supportedProtocols.contains(paramString)) {
        this.engineWrapper.setNegotiatedApplicationProtocol(paramString);
      } else {
        noSelectedMatchFound(paramString);
      }
    }
    
    public void unsupported()
    {
      this.engineWrapper.setNegotiatedApplicationProtocol(null);
    }
  }
  
  static class NoFailProtocolSelector
    implements JdkApplicationProtocolNegotiator.ProtocolSelector
  {
    private final JdkSslEngine engineWrapper;
    private final Set<String> supportedProtocols;
    
    NoFailProtocolSelector(JdkSslEngine paramJdkSslEngine, Set<String> paramSet)
    {
      this.engineWrapper = paramJdkSslEngine;
      this.supportedProtocols = paramSet;
    }
    
    public String noSelectMatchFound()
      throws Exception
    {
      this.engineWrapper.setNegotiatedApplicationProtocol(null);
      return null;
    }
    
    public String select(List<String> paramList)
      throws Exception
    {
      Iterator localIterator = this.supportedProtocols.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (paramList.contains(str))
        {
          this.engineWrapper.setNegotiatedApplicationProtocol(str);
          return str;
        }
      }
      return noSelectMatchFound();
    }
    
    public void unsupported()
    {
      this.engineWrapper.setNegotiatedApplicationProtocol(null);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\JdkBaseApplicationProtocolNegotiator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */