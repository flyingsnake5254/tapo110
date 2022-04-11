package b.d.d.k;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import org.bouncycastle.crypto.tls.g1;
import org.bouncycastle.crypto.tls.n0;

public class c
  extends SSLSocket
{
  private n0 c;
  private String[] d;
  private String[] f;
  private b.d.d.k.f.b q;
  
  c(n0 paramn0, String[] paramArrayOfString1, String[] paramArrayOfString2, b.d.d.k.f.b paramb)
  {
    this.c = paramn0;
    this.d = paramArrayOfString1;
    this.f = paramArrayOfString2;
    this.q = paramb;
  }
  
  public void addHandshakeCompletedListener(HandshakeCompletedListener paramHandshakeCompletedListener) {}
  
  public void close()
    throws IOException
  {
    try
    {
      n0 localn0 = this.c;
      if (localn0 != null) {
        localn0.g();
      }
      super.close();
      return;
    }
    finally {}
  }
  
  public void connect()
    throws IOException
  {
    n0 localn0 = this.c;
    if (localn0 != null) {
      localn0.a0(new a(this.q));
    }
  }
  
  public boolean getEnableSessionCreation()
  {
    return true;
  }
  
  public String[] getEnabledCipherSuites()
  {
    String[] arrayOfString1 = this.f;
    String[] arrayOfString2 = arrayOfString1;
    if (arrayOfString1 == null) {
      arrayOfString2 = new String[0];
    }
    return arrayOfString2;
  }
  
  public String[] getEnabledProtocols()
  {
    String[] arrayOfString1 = this.d;
    String[] arrayOfString2 = arrayOfString1;
    if (arrayOfString1 == null) {
      arrayOfString2 = new String[0];
    }
    return arrayOfString2;
  }
  
  public InputStream getInputStream()
    throws IOException
  {
    n0 localn0 = this.c;
    if (localn0 != null) {
      return localn0.q();
    }
    return null;
  }
  
  public boolean getNeedClientAuth()
  {
    return false;
  }
  
  public OutputStream getOutputStream()
    throws IOException
  {
    n0 localn0 = this.c;
    if (localn0 != null) {
      return localn0.r();
    }
    return null;
  }
  
  public SSLSession getSession()
  {
    return new b();
  }
  
  public String[] getSupportedCipherSuites()
  {
    String[] arrayOfString1 = this.f;
    String[] arrayOfString2 = arrayOfString1;
    if (arrayOfString1 == null) {
      arrayOfString2 = new String[0];
    }
    return arrayOfString2;
  }
  
  public String[] getSupportedProtocols()
  {
    String[] arrayOfString1 = this.d;
    String[] arrayOfString2 = arrayOfString1;
    if (arrayOfString1 == null) {
      arrayOfString2 = new String[0];
    }
    return arrayOfString2;
  }
  
  public boolean getUseClientMode()
  {
    return true;
  }
  
  public boolean getWantClientAuth()
  {
    return false;
  }
  
  public void removeHandshakeCompletedListener(HandshakeCompletedListener paramHandshakeCompletedListener) {}
  
  public void setEnableSessionCreation(boolean paramBoolean) {}
  
  public void setEnabledCipherSuites(String[] paramArrayOfString) {}
  
  public void setEnabledProtocols(String[] paramArrayOfString) {}
  
  public void setNeedClientAuth(boolean paramBoolean) {}
  
  public void setUseClientMode(boolean paramBoolean) {}
  
  public void setWantClientAuth(boolean paramBoolean) {}
  
  public void startHandshake()
    throws IOException
  {
    n0 localn0 = this.c;
    if (localn0 != null) {
      localn0.a0(new a(this.q));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\d\k\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */