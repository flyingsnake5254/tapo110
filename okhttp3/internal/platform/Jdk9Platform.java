package okhttp3.internal.platform;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Protocol;
import okhttp3.internal.Util;

final class Jdk9Platform
  extends Platform
{
  final Method getProtocolMethod;
  final Method setProtocolMethod;
  
  Jdk9Platform(Method paramMethod1, Method paramMethod2)
  {
    this.setProtocolMethod = paramMethod1;
    this.getProtocolMethod = paramMethod2;
  }
  
  public static Jdk9Platform buildIfSupported()
  {
    try
    {
      Jdk9Platform localJdk9Platform = new Jdk9Platform(SSLParameters.class.getMethod("setApplicationProtocols", new Class[] { String[].class }), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
      return localJdk9Platform;
    }
    catch (NoSuchMethodException localNoSuchMethodException) {}
    return null;
  }
  
  public void configureTlsExtensions(SSLSocket paramSSLSocket, String paramString, List<Protocol> paramList)
  {
    try
    {
      paramString = paramSSLSocket.getSSLParameters();
      paramList = Platform.alpnProtocolNames(paramList);
      this.setProtocolMethod.invoke(paramString, new Object[] { paramList.toArray(new String[paramList.size()]) });
      paramSSLSocket.setSSLParameters(paramString);
      return;
    }
    catch (InvocationTargetException paramSSLSocket) {}catch (IllegalAccessException paramSSLSocket) {}
    throw Util.assertionError("unable to set ssl parameters", paramSSLSocket);
  }
  
  @Nullable
  public String getSelectedProtocol(SSLSocket paramSSLSocket)
  {
    try
    {
      paramSSLSocket = (String)this.getProtocolMethod.invoke(paramSSLSocket, new Object[0]);
      if (paramSSLSocket != null)
      {
        boolean bool = paramSSLSocket.equals("");
        if (!bool) {
          return paramSSLSocket;
        }
      }
      return null;
    }
    catch (IllegalAccessException paramSSLSocket)
    {
      throw Util.assertionError("failed to get ALPN selected protocol", paramSSLSocket);
    }
    catch (InvocationTargetException paramSSLSocket)
    {
      if ((paramSSLSocket.getCause() instanceof UnsupportedOperationException)) {
        return null;
      }
      throw Util.assertionError("failed to get ALPN selected protocol", paramSSLSocket);
    }
  }
  
  public X509TrustManager trustManager(SSLSocketFactory paramSSLSocketFactory)
  {
    throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on JDK 9+");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okhttp3\internal\platform\Jdk9Platform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */