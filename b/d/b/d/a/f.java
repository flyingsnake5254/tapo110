package b.d.b.d.a;

import android.os.Build.VERSION;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class f
  extends SSLSocketFactory
{
  private static String[] a;
  private static String[] b;
  private final SSLSocketFactory c;
  
  static
  {
    try
    {
      SSLSocket localSSLSocket = (SSLSocket)SSLSocketFactory.getDefault().createSocket();
      if (localSSLSocket != null)
      {
        Object localObject1 = new java/util/LinkedList;
        ((LinkedList)localObject1).<init>();
        Object localObject3;
        for (localObject3 : localSSLSocket.getSupportedProtocols()) {
          if (!((String)localObject3).toUpperCase().contains("SSL")) {
            ((List)localObject1).add(localObject3);
          }
        }
        a = (String[])((List)localObject1).toArray(new String[((List)localObject1).size()]);
        if (Build.VERSION.SDK_INT < 22)
        {
          ??? = Arrays.asList(new String[] { "TLS_RSA_WITH_AES_256_GCM_SHA384", "TLS_RSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", "TLS_ECHDE_RSA_WITH_AES_128_GCM_SHA256", "TLS_RSA_WITH_3DES_EDE_CBC_SHA", "TLS_RSA_WITH_AES_128_CBC_SHA", "TLS_RSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA" });
          localObject1 = Arrays.asList(localSSLSocket.getSupportedCipherSuites());
          localObject3 = new java/util/HashSet;
          ((HashSet)localObject3).<init>((Collection)???);
          ((HashSet)localObject3).retainAll((Collection)localObject1);
          localObject1 = new java/util/HashSet;
          ((HashSet)localObject1).<init>(Arrays.asList(localSSLSocket.getEnabledCipherSuites()));
          ((HashSet)localObject3).addAll((Collection)localObject1);
          b = (String[])((HashSet)localObject3).toArray(new String[((HashSet)localObject3).size()]);
        }
      }
      return;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException(localIOException);
    }
  }
  
  public f(SSLSocketFactory paramSSLSocketFactory)
  {
    this.c = paramSSLSocketFactory;
  }
  
  private Socket a(Socket paramSocket)
  {
    if ((paramSocket instanceof SSLSocket))
    {
      String[] arrayOfString = a;
      if (arrayOfString != null) {
        ((SSLSocket)paramSocket).setEnabledProtocols(arrayOfString);
      }
      if (Build.VERSION.SDK_INT < 22)
      {
        arrayOfString = b;
        if (arrayOfString != null) {
          ((SSLSocket)paramSocket).setEnabledCipherSuites(arrayOfString);
        }
      }
    }
    return paramSocket;
  }
  
  public Socket createSocket()
    throws IOException
  {
    return this.c.createSocket();
  }
  
  public Socket createSocket(String paramString, int paramInt)
    throws IOException
  {
    return a(this.c.createSocket(paramString, paramInt));
  }
  
  public Socket createSocket(String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2)
    throws IOException
  {
    return a(this.c.createSocket(paramString, paramInt1, paramInetAddress, paramInt2));
  }
  
  public Socket createSocket(InetAddress paramInetAddress, int paramInt)
    throws IOException
  {
    return a(this.c.createSocket(paramInetAddress, paramInt));
  }
  
  public Socket createSocket(InetAddress paramInetAddress1, int paramInt1, InetAddress paramInetAddress2, int paramInt2)
    throws IOException
  {
    return a(this.c.createSocket(paramInetAddress1, paramInt1, paramInetAddress2, paramInt2));
  }
  
  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
    throws IOException
  {
    return a(this.c.createSocket(paramSocket, paramString, paramInt, paramBoolean));
  }
  
  public String[] getDefaultCipherSuites()
  {
    return b;
  }
  
  public String[] getSupportedCipherSuites()
  {
    return b;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\b\d\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */