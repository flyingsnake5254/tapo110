package org.eclipse.paho.client.mqttv3.internal;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SNIHostName;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.logging.Logger;
import org.eclipse.paho.client.mqttv3.logging.LoggerFactory;

public class SSLNetworkModule
  extends TCPNetworkModule
{
  private static final String CLASS_NAME = "org.eclipse.paho.client.mqttv3.internal.SSLNetworkModule";
  private String[] enabledCiphers;
  private int handshakeTimeoutSecs;
  private String host;
  private HostnameVerifier hostnameVerifier;
  private boolean httpsHostnameVerificationEnabled;
  private Logger log;
  private int port;
  
  public SSLNetworkModule(SSLSocketFactory paramSSLSocketFactory, String paramString1, int paramInt, String paramString2)
  {
    super(paramSSLSocketFactory, paramString1, paramInt, paramString2);
    paramSSLSocketFactory = LoggerFactory.getLogger("org.eclipse.paho.client.mqttv3.internal.nls.logcat", CLASS_NAME);
    this.log = paramSSLSocketFactory;
    this.httpsHostnameVerificationEnabled = false;
    this.host = paramString1;
    this.port = paramInt;
    paramSSLSocketFactory.setResourceName(paramString2);
  }
  
  public String[] getEnabledCiphers()
  {
    return this.enabledCiphers;
  }
  
  public HostnameVerifier getSSLHostnameVerifier()
  {
    return this.hostnameVerifier;
  }
  
  public String getServerURI()
  {
    StringBuilder localStringBuilder = new StringBuilder("ssl://");
    localStringBuilder.append(this.host);
    localStringBuilder.append(":");
    localStringBuilder.append(this.port);
    return localStringBuilder.toString();
  }
  
  public boolean isHttpsHostnameVerificationEnabled()
  {
    return this.httpsHostnameVerificationEnabled;
  }
  
  public void setEnabledCiphers(String[] paramArrayOfString)
  {
    if (paramArrayOfString != null) {
      this.enabledCiphers = ((String[])paramArrayOfString.clone());
    }
    if ((this.socket != null) && (this.enabledCiphers != null))
    {
      if (this.log.isLoggable(5))
      {
        paramArrayOfString = "";
        for (int i = 0;; i++)
        {
          if (i >= this.enabledCiphers.length)
          {
            this.log.fine(CLASS_NAME, "setEnabledCiphers", "260", new Object[] { paramArrayOfString });
            break;
          }
          Object localObject = paramArrayOfString;
          if (i > 0)
          {
            paramArrayOfString = new StringBuilder(String.valueOf(paramArrayOfString));
            paramArrayOfString.append(",");
            localObject = paramArrayOfString.toString();
          }
          paramArrayOfString = new StringBuilder(String.valueOf(localObject));
          paramArrayOfString.append(this.enabledCiphers[i]);
          paramArrayOfString = paramArrayOfString.toString();
        }
      }
      ((SSLSocket)this.socket).setEnabledCipherSuites(this.enabledCiphers);
    }
  }
  
  public void setHttpsHostnameVerificationEnabled(boolean paramBoolean)
  {
    this.httpsHostnameVerificationEnabled = paramBoolean;
  }
  
  public void setSSLHostnameVerifier(HostnameVerifier paramHostnameVerifier)
  {
    this.hostnameVerifier = paramHostnameVerifier;
  }
  
  public void setSSLhandshakeTimeout(int paramInt)
  {
    super.setConnectTimeout(paramInt);
    this.handshakeTimeoutSecs = paramInt;
  }
  
  public void start()
    throws IOException, MqttException
  {
    super.start();
    setEnabledCiphers(this.enabledCiphers);
    int i = this.socket.getSoTimeout();
    this.socket.setSoTimeout(this.handshakeTimeoutSecs * 1000);
    Object localObject;
    try
    {
      SSLParameters localSSLParameters1 = new javax/net/ssl/SSLParameters;
      localSSLParameters1.<init>();
      ArrayList localArrayList = new java/util/ArrayList;
      localArrayList.<init>(1);
      localObject = new javax/net/ssl/SNIHostName;
      ((SNIHostName)localObject).<init>(this.host);
      localArrayList.add(localObject);
      localSSLParameters1.setServerNames(localArrayList);
      ((SSLSocket)this.socket).setSSLParameters(localSSLParameters1);
    }
    catch (NoClassDefFoundError localNoClassDefFoundError) {}
    if (this.httpsHostnameVerificationEnabled) {
      try
      {
        SSLParameters localSSLParameters2 = new javax/net/ssl/SSLParameters;
        localSSLParameters2.<init>();
        localSSLParameters2.setEndpointIdentificationAlgorithm("HTTPS");
        ((SSLSocket)this.socket).setSSLParameters(localSSLParameters2);
      }
      catch (NoSuchMethodError localNoSuchMethodError) {}
    }
    ((SSLSocket)this.socket).startHandshake();
    if ((this.hostnameVerifier != null) && (!this.httpsHostnameVerificationEnabled))
    {
      localObject = ((SSLSocket)this.socket).getSession();
      if (!this.hostnameVerifier.verify(this.host, (SSLSession)localObject))
      {
        ((SSLSession)localObject).invalidate();
        this.socket.close();
        StringBuilder localStringBuilder = new StringBuilder("Host: ");
        localStringBuilder.append(this.host);
        localStringBuilder.append(", Peer Host: ");
        localStringBuilder.append(((SSLSession)localObject).getPeerHost());
        throw new SSLPeerUnverifiedException(localStringBuilder.toString());
      }
    }
    this.socket.setSoTimeout(i);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\internal\SSLNetworkModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */