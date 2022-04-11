package b.d.d.k;

import java.security.Principal;
import java.security.cert.Certificate;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSessionContext;
import javax.security.cert.X509Certificate;

public class b
  implements SSLSession
{
  private long a;
  private long b;
  
  b()
  {
    long l = System.currentTimeMillis();
    this.a = l;
    this.b = l;
  }
  
  public int getApplicationBufferSize()
  {
    return 16384;
  }
  
  public String getCipherSuite()
  {
    return "TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA";
  }
  
  public long getCreationTime()
  {
    return this.a;
  }
  
  public byte[] getId()
  {
    return new byte[0];
  }
  
  public long getLastAccessedTime()
  {
    return this.b;
  }
  
  public Certificate[] getLocalCertificates()
  {
    return new Certificate[0];
  }
  
  public Principal getLocalPrincipal()
  {
    return null;
  }
  
  public int getPacketBufferSize()
  {
    return 16709;
  }
  
  public X509Certificate[] getPeerCertificateChain()
    throws SSLPeerUnverifiedException
  {
    return new X509Certificate[0];
  }
  
  public Certificate[] getPeerCertificates()
    throws SSLPeerUnverifiedException
  {
    return new Certificate[0];
  }
  
  public String getPeerHost()
  {
    return null;
  }
  
  public int getPeerPort()
  {
    return 0;
  }
  
  public Principal getPeerPrincipal()
    throws SSLPeerUnverifiedException
  {
    return null;
  }
  
  public String getProtocol()
  {
    return "TLSv1.2";
  }
  
  public SSLSessionContext getSessionContext()
  {
    return null;
  }
  
  public Object getValue(String paramString)
  {
    return null;
  }
  
  public String[] getValueNames()
  {
    return new String[0];
  }
  
  public void invalidate() {}
  
  public boolean isValid()
  {
    return false;
  }
  
  public void putValue(String paramString, Object paramObject) {}
  
  public void removeValue(String paramString) {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\d\k\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */