package io.netty.handler.ssl;

import io.netty.util.internal.SuppressJava6Requirement;
import java.nio.ByteBuffer;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.function.BiFunction;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLEngineResult.HandshakeStatus;
import javax.net.ssl.SSLException;

@SuppressJava6Requirement(reason="Usage guarded by java version check")
final class JdkAlpnSslEngine
  extends JdkSslEngine
{
  private final AlpnSelector alpnSelector;
  private final JdkApplicationProtocolNegotiator.ProtocolSelectionListener selectionListener;
  
  JdkAlpnSslEngine(SSLEngine paramSSLEngine, JdkApplicationProtocolNegotiator paramJdkApplicationProtocolNegotiator, boolean paramBoolean)
  {
    super(paramSSLEngine);
    if (paramBoolean)
    {
      this.selectionListener = null;
      paramJdkApplicationProtocolNegotiator = new AlpnSelector(paramJdkApplicationProtocolNegotiator.protocolSelectorFactory().newSelector(this, new LinkedHashSet(paramJdkApplicationProtocolNegotiator.protocols())));
      this.alpnSelector = paramJdkApplicationProtocolNegotiator;
      JdkAlpnSslUtils.setHandshakeApplicationProtocolSelector(paramSSLEngine, paramJdkApplicationProtocolNegotiator);
    }
    else
    {
      this.selectionListener = paramJdkApplicationProtocolNegotiator.protocolListenerFactory().newListener(this, paramJdkApplicationProtocolNegotiator.protocols());
      this.alpnSelector = null;
      JdkAlpnSslUtils.setApplicationProtocols(paramSSLEngine, paramJdkApplicationProtocolNegotiator.protocols());
    }
  }
  
  private SSLEngineResult verifyProtocolSelection(SSLEngineResult paramSSLEngineResult)
    throws SSLException
  {
    if (paramSSLEngineResult.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.FINISHED)
    {
      Object localObject = this.alpnSelector;
      if (localObject == null) {
        try
        {
          localObject = getApplicationProtocol();
          if (((String)localObject).isEmpty())
          {
            this.selectionListener.unsupported();
            return paramSSLEngineResult;
          }
          this.selectionListener.selected((String)localObject);
          return paramSSLEngineResult;
        }
        finally {}
      }
      ((AlpnSelector)localObject).checkUnsupported();
    }
    return paramSSLEngineResult;
  }
  
  public String getApplicationProtocol()
  {
    return JdkAlpnSslUtils.getApplicationProtocol(getWrappedEngine());
  }
  
  public String getHandshakeApplicationProtocol()
  {
    return JdkAlpnSslUtils.getHandshakeApplicationProtocol(getWrappedEngine());
  }
  
  public BiFunction<SSLEngine, List<String>, String> getHandshakeApplicationProtocolSelector()
  {
    return JdkAlpnSslUtils.getHandshakeApplicationProtocolSelector(getWrappedEngine());
  }
  
  public String getNegotiatedApplicationProtocol()
  {
    String str1 = getApplicationProtocol();
    if (str1 != null)
    {
      String str2 = str1;
      if (str1.isEmpty()) {
        str2 = null;
      }
      return str2;
    }
    return null;
  }
  
  public void setHandshakeApplicationProtocolSelector(BiFunction<SSLEngine, List<String>, String> paramBiFunction)
  {
    JdkAlpnSslUtils.setHandshakeApplicationProtocolSelector(getWrappedEngine(), paramBiFunction);
  }
  
  void setNegotiatedApplicationProtocol(String paramString) {}
  
  public SSLEngineResult unwrap(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2)
    throws SSLException
  {
    return verifyProtocolSelection(super.unwrap(paramByteBuffer1, paramByteBuffer2));
  }
  
  public SSLEngineResult unwrap(ByteBuffer paramByteBuffer, ByteBuffer[] paramArrayOfByteBuffer)
    throws SSLException
  {
    return verifyProtocolSelection(super.unwrap(paramByteBuffer, paramArrayOfByteBuffer));
  }
  
  public SSLEngineResult unwrap(ByteBuffer paramByteBuffer, ByteBuffer[] paramArrayOfByteBuffer, int paramInt1, int paramInt2)
    throws SSLException
  {
    return verifyProtocolSelection(super.unwrap(paramByteBuffer, paramArrayOfByteBuffer, paramInt1, paramInt2));
  }
  
  public SSLEngineResult wrap(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2)
    throws SSLException
  {
    return verifyProtocolSelection(super.wrap(paramByteBuffer1, paramByteBuffer2));
  }
  
  public SSLEngineResult wrap(ByteBuffer[] paramArrayOfByteBuffer, int paramInt1, int paramInt2, ByteBuffer paramByteBuffer)
    throws SSLException
  {
    return verifyProtocolSelection(super.wrap(paramArrayOfByteBuffer, paramInt1, paramInt2, paramByteBuffer));
  }
  
  public SSLEngineResult wrap(ByteBuffer[] paramArrayOfByteBuffer, ByteBuffer paramByteBuffer)
    throws SSLException
  {
    return verifyProtocolSelection(super.wrap(paramArrayOfByteBuffer, paramByteBuffer));
  }
  
  private final class AlpnSelector
    implements BiFunction<SSLEngine, List<String>, String>
  {
    private boolean called;
    private final JdkApplicationProtocolNegotiator.ProtocolSelector selector;
    
    AlpnSelector(JdkApplicationProtocolNegotiator.ProtocolSelector paramProtocolSelector)
    {
      this.selector = paramProtocolSelector;
    }
    
    public String apply(SSLEngine paramSSLEngine, List<String> paramList)
    {
      this.called = true;
      try
      {
        paramList = this.selector.select(paramList);
        paramSSLEngine = paramList;
        if (paramList == null) {
          paramSSLEngine = "";
        }
        return paramSSLEngine;
      }
      catch (Exception paramSSLEngine) {}
      return null;
    }
    
    void checkUnsupported()
    {
      if (this.called) {
        return;
      }
      if (JdkAlpnSslEngine.this.getApplicationProtocol().isEmpty()) {
        this.selector.unsupported();
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\JdkAlpnSslEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */