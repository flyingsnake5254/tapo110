package io.netty.handler.ssl;

import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SuppressJava6Requirement;
import java.net.Socket;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.List;
import javax.net.ssl.ExtendedSSLSession;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSessionContext;
import javax.net.ssl.X509ExtendedTrustManager;

@SuppressJava6Requirement(reason="Usage guarded by java version check")
final class OpenSslTlsv13X509ExtendedTrustManager
  extends X509ExtendedTrustManager
{
  private final X509ExtendedTrustManager tm;
  
  private OpenSslTlsv13X509ExtendedTrustManager(X509ExtendedTrustManager paramX509ExtendedTrustManager)
  {
    this.tm = paramX509ExtendedTrustManager;
  }
  
  static X509ExtendedTrustManager wrap(X509ExtendedTrustManager paramX509ExtendedTrustManager)
  {
    if ((PlatformDependent.javaVersion() < 11) && (OpenSsl.isTlsv13Supported())) {
      return new OpenSslTlsv13X509ExtendedTrustManager(paramX509ExtendedTrustManager);
    }
    return paramX509ExtendedTrustManager;
  }
  
  private static SSLEngine wrapEngine(final SSLEngine paramSSLEngine)
  {
    final SSLSession localSSLSession = paramSSLEngine.getHandshakeSession();
    if ((localSSLSession != null) && ("TLSv1.3".equals(localSSLSession.getProtocol()))) {
      new JdkSslEngine(paramSSLEngine)
      {
        public SSLSession getHandshakeSession()
        {
          if (PlatformDependent.javaVersion() >= 7)
          {
            final Object localObject = localSSLSession;
            if ((localObject instanceof ExtendedOpenSslSession))
            {
              localObject = (ExtendedOpenSslSession)localObject;
              new ExtendedOpenSslSession((OpenSslSession)localObject)
              {
                public String[] getPeerSupportedSignatureAlgorithms()
                {
                  return localObject.getPeerSupportedSignatureAlgorithms();
                }
                
                public String getProtocol()
                {
                  return "TLSv1.2";
                }
                
                public List getRequestedServerNames()
                {
                  return localObject.getRequestedServerNames();
                }
              };
            }
          }
          new SSLSession()
          {
            public int getApplicationBufferSize()
            {
              return OpenSslTlsv13X509ExtendedTrustManager.1.this.val$session.getApplicationBufferSize();
            }
            
            public String getCipherSuite()
            {
              return OpenSslTlsv13X509ExtendedTrustManager.1.this.val$session.getCipherSuite();
            }
            
            public long getCreationTime()
            {
              return OpenSslTlsv13X509ExtendedTrustManager.1.this.val$session.getCreationTime();
            }
            
            public byte[] getId()
            {
              return OpenSslTlsv13X509ExtendedTrustManager.1.this.val$session.getId();
            }
            
            public long getLastAccessedTime()
            {
              return OpenSslTlsv13X509ExtendedTrustManager.1.this.val$session.getLastAccessedTime();
            }
            
            public Certificate[] getLocalCertificates()
            {
              return OpenSslTlsv13X509ExtendedTrustManager.1.this.val$session.getLocalCertificates();
            }
            
            public Principal getLocalPrincipal()
            {
              return OpenSslTlsv13X509ExtendedTrustManager.1.this.val$session.getLocalPrincipal();
            }
            
            public int getPacketBufferSize()
            {
              return OpenSslTlsv13X509ExtendedTrustManager.1.this.val$session.getPacketBufferSize();
            }
            
            public javax.security.cert.X509Certificate[] getPeerCertificateChain()
              throws SSLPeerUnverifiedException
            {
              return OpenSslTlsv13X509ExtendedTrustManager.1.this.val$session.getPeerCertificateChain();
            }
            
            public Certificate[] getPeerCertificates()
              throws SSLPeerUnverifiedException
            {
              return OpenSslTlsv13X509ExtendedTrustManager.1.this.val$session.getPeerCertificates();
            }
            
            public String getPeerHost()
            {
              return OpenSslTlsv13X509ExtendedTrustManager.1.this.val$session.getPeerHost();
            }
            
            public int getPeerPort()
            {
              return OpenSslTlsv13X509ExtendedTrustManager.1.this.val$session.getPeerPort();
            }
            
            public Principal getPeerPrincipal()
              throws SSLPeerUnverifiedException
            {
              return OpenSslTlsv13X509ExtendedTrustManager.1.this.val$session.getPeerPrincipal();
            }
            
            public String getProtocol()
            {
              return "TLSv1.2";
            }
            
            public SSLSessionContext getSessionContext()
            {
              return OpenSslTlsv13X509ExtendedTrustManager.1.this.val$session.getSessionContext();
            }
            
            public Object getValue(String paramAnonymous2String)
            {
              return OpenSslTlsv13X509ExtendedTrustManager.1.this.val$session.getValue(paramAnonymous2String);
            }
            
            public String[] getValueNames()
            {
              return OpenSslTlsv13X509ExtendedTrustManager.1.this.val$session.getValueNames();
            }
            
            public void invalidate()
            {
              OpenSslTlsv13X509ExtendedTrustManager.1.this.val$session.invalidate();
            }
            
            public boolean isValid()
            {
              return OpenSslTlsv13X509ExtendedTrustManager.1.this.val$session.isValid();
            }
            
            public void putValue(String paramAnonymous2String, Object paramAnonymous2Object)
            {
              OpenSslTlsv13X509ExtendedTrustManager.1.this.val$session.putValue(paramAnonymous2String, paramAnonymous2Object);
            }
            
            public void removeValue(String paramAnonymous2String)
            {
              OpenSslTlsv13X509ExtendedTrustManager.1.this.val$session.removeValue(paramAnonymous2String);
            }
          };
        }
        
        public String getNegotiatedApplicationProtocol()
        {
          SSLEngine localSSLEngine = paramSSLEngine;
          if ((localSSLEngine instanceof ApplicationProtocolAccessor)) {
            return ((ApplicationProtocolAccessor)localSSLEngine).getNegotiatedApplicationProtocol();
          }
          return super.getNegotiatedApplicationProtocol();
        }
      };
    }
    return paramSSLEngine;
  }
  
  public void checkClientTrusted(java.security.cert.X509Certificate[] paramArrayOfX509Certificate, String paramString)
    throws CertificateException
  {
    this.tm.checkClientTrusted(paramArrayOfX509Certificate, paramString);
  }
  
  public void checkClientTrusted(java.security.cert.X509Certificate[] paramArrayOfX509Certificate, String paramString, Socket paramSocket)
    throws CertificateException
  {
    this.tm.checkClientTrusted(paramArrayOfX509Certificate, paramString, paramSocket);
  }
  
  public void checkClientTrusted(java.security.cert.X509Certificate[] paramArrayOfX509Certificate, String paramString, SSLEngine paramSSLEngine)
    throws CertificateException
  {
    this.tm.checkClientTrusted(paramArrayOfX509Certificate, paramString, wrapEngine(paramSSLEngine));
  }
  
  public void checkServerTrusted(java.security.cert.X509Certificate[] paramArrayOfX509Certificate, String paramString)
    throws CertificateException
  {
    this.tm.checkServerTrusted(paramArrayOfX509Certificate, paramString);
  }
  
  public void checkServerTrusted(java.security.cert.X509Certificate[] paramArrayOfX509Certificate, String paramString, Socket paramSocket)
    throws CertificateException
  {
    this.tm.checkServerTrusted(paramArrayOfX509Certificate, paramString, paramSocket);
  }
  
  public void checkServerTrusted(java.security.cert.X509Certificate[] paramArrayOfX509Certificate, String paramString, SSLEngine paramSSLEngine)
    throws CertificateException
  {
    this.tm.checkServerTrusted(paramArrayOfX509Certificate, paramString, wrapEngine(paramSSLEngine));
  }
  
  public java.security.cert.X509Certificate[] getAcceptedIssuers()
  {
    return this.tm.getAcceptedIssuers();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\OpenSslTlsv13X509ExtendedTrustManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */