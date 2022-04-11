package org.eclipse.paho.client.mqttv3.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.net.SocketFactory;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.logging.Logger;
import org.eclipse.paho.client.mqttv3.logging.LoggerFactory;

public class TCPNetworkModule
  implements NetworkModule
{
  private static final String CLASS_NAME = "org.eclipse.paho.client.mqttv3.internal.TCPNetworkModule";
  private int conTimeout;
  private SocketFactory factory;
  private String host;
  private Logger log;
  private int port;
  protected Socket socket;
  
  public TCPNetworkModule(SocketFactory paramSocketFactory, String paramString1, int paramInt, String paramString2)
  {
    Logger localLogger = LoggerFactory.getLogger("org.eclipse.paho.client.mqttv3.internal.nls.logcat", CLASS_NAME);
    this.log = localLogger;
    localLogger.setResourceName(paramString2);
    this.factory = paramSocketFactory;
    this.host = paramString1;
    this.port = paramInt;
  }
  
  public InputStream getInputStream()
    throws IOException
  {
    return this.socket.getInputStream();
  }
  
  public OutputStream getOutputStream()
    throws IOException
  {
    return this.socket.getOutputStream();
  }
  
  public String getServerURI()
  {
    StringBuilder localStringBuilder = new StringBuilder("tcp://");
    localStringBuilder.append(this.host);
    localStringBuilder.append(":");
    localStringBuilder.append(this.port);
    return localStringBuilder.toString();
  }
  
  public void setConnectTimeout(int paramInt)
  {
    this.conTimeout = paramInt;
  }
  
  public void start()
    throws IOException, MqttException
  {
    try
    {
      this.log.fine(CLASS_NAME, "start", "252", new Object[] { this.host, Integer.valueOf(this.port), Long.valueOf(this.conTimeout * 1000) });
      InetSocketAddress localInetSocketAddress = new java/net/InetSocketAddress;
      localInetSocketAddress.<init>(this.host, this.port);
      Socket localSocket = this.factory.createSocket();
      this.socket = localSocket;
      localSocket.connect(localInetSocketAddress, this.conTimeout * 1000);
      this.socket.setSoTimeout(1000);
      return;
    }
    catch (ConnectException localConnectException)
    {
      this.log.fine(CLASS_NAME, "start", "250", null, localConnectException);
      throw new MqttException(32103, localConnectException);
    }
  }
  
  public void stop()
    throws IOException
  {
    Socket localSocket = this.socket;
    if (localSocket != null) {
      localSocket.close();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\internal\TCPNetworkModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */