package io.netty.handler.ssl;

import io.netty.buffer.ByteBufAllocator;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLEngine;

@Deprecated
public abstract interface JdkApplicationProtocolNegotiator
  extends ApplicationProtocolNegotiator
{
  public abstract ProtocolSelectionListenerFactory protocolListenerFactory();
  
  public abstract ProtocolSelectorFactory protocolSelectorFactory();
  
  public abstract SslEngineWrapperFactory wrapperFactory();
  
  public static abstract class AllocatorAwareSslEngineWrapperFactory
    implements JdkApplicationProtocolNegotiator.SslEngineWrapperFactory
  {
    abstract SSLEngine wrapSslEngine(SSLEngine paramSSLEngine, ByteBufAllocator paramByteBufAllocator, JdkApplicationProtocolNegotiator paramJdkApplicationProtocolNegotiator, boolean paramBoolean);
    
    public final SSLEngine wrapSslEngine(SSLEngine paramSSLEngine, JdkApplicationProtocolNegotiator paramJdkApplicationProtocolNegotiator, boolean paramBoolean)
    {
      return wrapSslEngine(paramSSLEngine, ByteBufAllocator.DEFAULT, paramJdkApplicationProtocolNegotiator, paramBoolean);
    }
  }
  
  public static abstract interface ProtocolSelectionListener
  {
    public abstract void selected(String paramString)
      throws Exception;
    
    public abstract void unsupported();
  }
  
  public static abstract interface ProtocolSelectionListenerFactory
  {
    public abstract JdkApplicationProtocolNegotiator.ProtocolSelectionListener newListener(SSLEngine paramSSLEngine, List<String> paramList);
  }
  
  public static abstract interface ProtocolSelector
  {
    public abstract String select(List<String> paramList)
      throws Exception;
    
    public abstract void unsupported();
  }
  
  public static abstract interface ProtocolSelectorFactory
  {
    public abstract JdkApplicationProtocolNegotiator.ProtocolSelector newSelector(SSLEngine paramSSLEngine, Set<String> paramSet);
  }
  
  public static abstract interface SslEngineWrapperFactory
  {
    public abstract SSLEngine wrapSslEngine(SSLEngine paramSSLEngine, JdkApplicationProtocolNegotiator paramJdkApplicationProtocolNegotiator, boolean paramBoolean);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\JdkApplicationProtocolNegotiator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */