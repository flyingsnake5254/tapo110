package io.netty.handler.ssl;

import io.netty.util.internal.SuppressJava6Requirement;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.ExtendedSSLSession;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSessionContext;
import javax.security.cert.X509Certificate;

@SuppressJava6Requirement(reason="Usage guarded by java version check")
abstract class ExtendedOpenSslSession
  extends ExtendedSSLSession
  implements OpenSslSession
{
  private static final String[] LOCAL_SUPPORTED_SIGNATURE_ALGORITHMS = { "SHA512withRSA", "SHA512withECDSA", "SHA384withRSA", "SHA384withECDSA", "SHA256withRSA", "SHA256withECDSA", "SHA224withRSA", "SHA224withECDSA", "SHA1withRSA", "SHA1withECDSA" };
  private final OpenSslSession wrapped;
  
  ExtendedOpenSslSession(OpenSslSession paramOpenSslSession)
  {
    this.wrapped = paramOpenSslSession;
  }
  
  public final int getApplicationBufferSize()
  {
    return this.wrapped.getApplicationBufferSize();
  }
  
  public final String getCipherSuite()
  {
    return this.wrapped.getCipherSuite();
  }
  
  public final long getCreationTime()
  {
    return this.wrapped.getCreationTime();
  }
  
  public final byte[] getId()
  {
    return this.wrapped.getId();
  }
  
  public final long getLastAccessedTime()
  {
    return this.wrapped.getLastAccessedTime();
  }
  
  public final Certificate[] getLocalCertificates()
  {
    return this.wrapped.getLocalCertificates();
  }
  
  public final Principal getLocalPrincipal()
  {
    return this.wrapped.getLocalPrincipal();
  }
  
  public final String[] getLocalSupportedSignatureAlgorithms()
  {
    return (String[])LOCAL_SUPPORTED_SIGNATURE_ALGORITHMS.clone();
  }
  
  public final int getPacketBufferSize()
  {
    return this.wrapped.getPacketBufferSize();
  }
  
  public final X509Certificate[] getPeerCertificateChain()
    throws SSLPeerUnverifiedException
  {
    return this.wrapped.getPeerCertificateChain();
  }
  
  public final Certificate[] getPeerCertificates()
    throws SSLPeerUnverifiedException
  {
    return this.wrapped.getPeerCertificates();
  }
  
  public final String getPeerHost()
  {
    return this.wrapped.getPeerHost();
  }
  
  public final int getPeerPort()
  {
    return this.wrapped.getPeerPort();
  }
  
  public final Principal getPeerPrincipal()
    throws SSLPeerUnverifiedException
  {
    return this.wrapped.getPeerPrincipal();
  }
  
  public String getProtocol()
  {
    return this.wrapped.getProtocol();
  }
  
  public abstract List getRequestedServerNames();
  
  public final SSLSessionContext getSessionContext()
  {
    return this.wrapped.getSessionContext();
  }
  
  public List<byte[]> getStatusResponses()
  {
    return Collections.emptyList();
  }
  
  public final Object getValue(String paramString)
  {
    return this.wrapped.getValue(paramString);
  }
  
  public final String[] getValueNames()
  {
    return this.wrapped.getValueNames();
  }
  
  public final void handshakeFinished()
    throws SSLException
  {
    this.wrapped.handshakeFinished();
  }
  
  public final void invalidate()
  {
    this.wrapped.invalidate();
  }
  
  public final boolean isValid()
  {
    return this.wrapped.isValid();
  }
  
  public final void putValue(String paramString, Object paramObject)
  {
    this.wrapped.putValue(paramString, paramObject);
  }
  
  public final void removeValue(String paramString)
  {
    this.wrapped.removeValue(paramString);
  }
  
  public final void tryExpandApplicationBufferSize(int paramInt)
  {
    this.wrapped.tryExpandApplicationBufferSize(paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\ExtendedOpenSslSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */