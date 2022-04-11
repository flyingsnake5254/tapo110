package b.d.d.k;

import b.d.d.k.f.b;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.SecureRandom;
import javax.net.ssl.SSLSocketFactory;
import org.bouncycastle.crypto.tls.n0;

public class d
  extends SSLSocketFactory
{
  private String[] a;
  private String[] b;
  private b c;
  private int d = 30000;
  private int e = 15000;
  
  public d(String[] paramArrayOfString1, String[] paramArrayOfString2, b paramb)
  {
    this.a = paramArrayOfString1;
    this.b = paramArrayOfString2;
    this.c = paramb;
  }
  
  private Socket a(Socket paramSocket, String paramString, int paramInt)
    throws IOException
  {
    Socket localSocket = paramSocket;
    if (paramSocket == null) {
      localSocket = new Socket();
    }
    if (!localSocket.isConnected())
    {
      localSocket.connect(new InetSocketAddress(paramString, paramInt), this.d);
      localSocket.setSoTimeout(this.e);
    }
    return new c(new n0(localSocket.getInputStream(), localSocket.getOutputStream(), new SecureRandom()), this.a, this.b, this.c);
  }
  
  public void b(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void c(int paramInt)
  {
    this.e = paramInt;
  }
  
  public Socket createSocket(String paramString, int paramInt)
    throws IOException, UnknownHostException
  {
    return a(null, paramString, paramInt);
  }
  
  public Socket createSocket(String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2)
    throws IOException, UnknownHostException
  {
    return a(null, paramString, paramInt1);
  }
  
  public Socket createSocket(InetAddress paramInetAddress, int paramInt)
    throws IOException
  {
    return a(null, paramInetAddress.getHostName(), paramInt);
  }
  
  public Socket createSocket(InetAddress paramInetAddress1, int paramInt1, InetAddress paramInetAddress2, int paramInt2)
    throws IOException
  {
    return a(null, paramInetAddress1.getHostName(), paramInt1);
  }
  
  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
    throws IOException
  {
    return a(paramSocket, paramString, paramInt);
  }
  
  public String[] getDefaultCipherSuites()
  {
    String[] arrayOfString1 = this.b;
    String[] arrayOfString2 = arrayOfString1;
    if (arrayOfString1 == null) {
      arrayOfString2 = new String[0];
    }
    return arrayOfString2;
  }
  
  public String[] getSupportedCipherSuites()
  {
    String[] arrayOfString1 = this.b;
    String[] arrayOfString2 = arrayOfString1;
    if (arrayOfString1 == null) {
      arrayOfString2 = new String[0];
    }
    return arrayOfString2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\d\k\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */