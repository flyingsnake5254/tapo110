package okhttp3.internal.platform;

import android.annotation.SuppressLint;
import android.net.ssl.SSLSockets;
import java.io.IOException;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import okhttp3.Protocol;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

@SuppressLint({"NewApi"})
class Android10Platform
  extends AndroidPlatform
{
  Android10Platform(Class<?> paramClass)
  {
    super(paramClass, null, null, null, null);
  }
  
  @Nullable
  public static Platform buildIfSupported()
  {
    if (!Platform.isAndroid()) {
      return null;
    }
    try
    {
      if (AndroidPlatform.getSdkInt() >= 29)
      {
        Android10Platform localAndroid10Platform = new Android10Platform(Class.forName("com.android.org.conscrypt.SSLParametersImpl"));
        return localAndroid10Platform;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;) {}
    }
    return null;
  }
  
  private void enableSessionTickets(SSLSocket paramSSLSocket)
  {
    if (SSLSockets.isSupportedSocket(paramSSLSocket)) {
      SSLSockets.setUseSessionTickets(paramSSLSocket, true);
    }
  }
  
  @SuppressLint({"NewApi"})
  @IgnoreJRERequirement
  public void configureTlsExtensions(SSLSocket paramSSLSocket, String paramString, List<Protocol> paramList)
    throws IOException
  {
    try
    {
      enableSessionTickets(paramSSLSocket);
      paramString = paramSSLSocket.getSSLParameters();
      paramString.setApplicationProtocols((String[])Platform.alpnProtocolNames(paramList).toArray(new String[0]));
      paramSSLSocket.setSSLParameters(paramString);
      return;
    }
    catch (IllegalArgumentException paramSSLSocket)
    {
      throw new IOException("Android internal error", paramSSLSocket);
    }
  }
  
  @Nullable
  @IgnoreJRERequirement
  public String getSelectedProtocol(SSLSocket paramSSLSocket)
  {
    paramSSLSocket = paramSSLSocket.getApplicationProtocol();
    if ((paramSSLSocket != null) && (!paramSSLSocket.isEmpty())) {
      return paramSSLSocket;
    }
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okhttp3\internal\platform\Android10Platform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */