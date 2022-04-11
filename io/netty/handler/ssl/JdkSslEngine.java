package io.netty.handler.ssl;

import io.netty.util.internal.SuppressJava6Requirement;
import java.nio.ByteBuffer;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLEngineResult.HandshakeStatus;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSession;

class JdkSslEngine
  extends SSLEngine
  implements ApplicationProtocolAccessor
{
  private volatile String applicationProtocol;
  private final SSLEngine engine;
  
  JdkSslEngine(SSLEngine paramSSLEngine)
  {
    this.engine = paramSSLEngine;
  }
  
  public void beginHandshake()
    throws SSLException
  {
    this.engine.beginHandshake();
  }
  
  public void closeInbound()
    throws SSLException
  {
    this.engine.closeInbound();
  }
  
  public void closeOutbound()
  {
    this.engine.closeOutbound();
  }
  
  public Runnable getDelegatedTask()
  {
    return this.engine.getDelegatedTask();
  }
  
  public boolean getEnableSessionCreation()
  {
    return this.engine.getEnableSessionCreation();
  }
  
  public String[] getEnabledCipherSuites()
  {
    return this.engine.getEnabledCipherSuites();
  }
  
  public String[] getEnabledProtocols()
  {
    return this.engine.getEnabledProtocols();
  }
  
  @SuppressJava6Requirement(reason="Can only be called when running on JDK7+")
  public SSLSession getHandshakeSession()
  {
    return this.engine.getHandshakeSession();
  }
  
  public SSLEngineResult.HandshakeStatus getHandshakeStatus()
  {
    return this.engine.getHandshakeStatus();
  }
  
  public boolean getNeedClientAuth()
  {
    return this.engine.getNeedClientAuth();
  }
  
  public String getNegotiatedApplicationProtocol()
  {
    return this.applicationProtocol;
  }
  
  public String getPeerHost()
  {
    return this.engine.getPeerHost();
  }
  
  public int getPeerPort()
  {
    return this.engine.getPeerPort();
  }
  
  public SSLParameters getSSLParameters()
  {
    return this.engine.getSSLParameters();
  }
  
  public SSLSession getSession()
  {
    return this.engine.getSession();
  }
  
  public String[] getSupportedCipherSuites()
  {
    return this.engine.getSupportedCipherSuites();
  }
  
  public String[] getSupportedProtocols()
  {
    return this.engine.getSupportedProtocols();
  }
  
  public boolean getUseClientMode()
  {
    return this.engine.getUseClientMode();
  }
  
  public boolean getWantClientAuth()
  {
    return this.engine.getWantClientAuth();
  }
  
  public SSLEngine getWrappedEngine()
  {
    return this.engine;
  }
  
  public boolean isInboundDone()
  {
    return this.engine.isInboundDone();
  }
  
  public boolean isOutboundDone()
  {
    return this.engine.isOutboundDone();
  }
  
  public void setEnableSessionCreation(boolean paramBoolean)
  {
    this.engine.setEnableSessionCreation(paramBoolean);
  }
  
  public void setEnabledCipherSuites(String[] paramArrayOfString)
  {
    this.engine.setEnabledCipherSuites(paramArrayOfString);
  }
  
  public void setEnabledProtocols(String[] paramArrayOfString)
  {
    this.engine.setEnabledProtocols(paramArrayOfString);
  }
  
  public void setNeedClientAuth(boolean paramBoolean)
  {
    this.engine.setNeedClientAuth(paramBoolean);
  }
  
  void setNegotiatedApplicationProtocol(String paramString)
  {
    this.applicationProtocol = paramString;
  }
  
  public void setSSLParameters(SSLParameters paramSSLParameters)
  {
    this.engine.setSSLParameters(paramSSLParameters);
  }
  
  public void setUseClientMode(boolean paramBoolean)
  {
    this.engine.setUseClientMode(paramBoolean);
  }
  
  public void setWantClientAuth(boolean paramBoolean)
  {
    this.engine.setWantClientAuth(paramBoolean);
  }
  
  public SSLEngineResult unwrap(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2)
    throws SSLException
  {
    return this.engine.unwrap(paramByteBuffer1, paramByteBuffer2);
  }
  
  public SSLEngineResult unwrap(ByteBuffer paramByteBuffer, ByteBuffer[] paramArrayOfByteBuffer)
    throws SSLException
  {
    return this.engine.unwrap(paramByteBuffer, paramArrayOfByteBuffer);
  }
  
  public SSLEngineResult unwrap(ByteBuffer paramByteBuffer, ByteBuffer[] paramArrayOfByteBuffer, int paramInt1, int paramInt2)
    throws SSLException
  {
    return this.engine.unwrap(paramByteBuffer, paramArrayOfByteBuffer, paramInt1, paramInt2);
  }
  
  public SSLEngineResult wrap(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2)
    throws SSLException
  {
    return this.engine.wrap(paramByteBuffer1, paramByteBuffer2);
  }
  
  public SSLEngineResult wrap(ByteBuffer[] paramArrayOfByteBuffer, int paramInt1, int paramInt2, ByteBuffer paramByteBuffer)
    throws SSLException
  {
    return this.engine.wrap(paramArrayOfByteBuffer, paramInt1, paramInt2, paramByteBuffer);
  }
  
  public SSLEngineResult wrap(ByteBuffer[] paramArrayOfByteBuffer, ByteBuffer paramByteBuffer)
    throws SSLException
  {
    return this.engine.wrap(paramArrayOfByteBuffer, paramByteBuffer);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\JdkSslEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */