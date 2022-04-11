package org.eclipse.paho.client.mqttv3.internal.websocket;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.nio.ByteBuffer;
import java.util.Properties;
import javax.net.ssl.SSLSocketFactory;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.internal.SSLNetworkModule;
import org.eclipse.paho.client.mqttv3.internal.TCPNetworkModule;
import org.eclipse.paho.client.mqttv3.logging.Logger;
import org.eclipse.paho.client.mqttv3.logging.LoggerFactory;

public class WebSocketSecureNetworkModule
  extends SSLNetworkModule
{
  private static final String CLASS_NAME = "org.eclipse.paho.client.mqttv3.internal.websocket.WebSocketSecureNetworkModule";
  private Properties customWebSocketHeaders;
  private String host;
  private Logger log = LoggerFactory.getLogger("org.eclipse.paho.client.mqttv3.internal.nls.logcat", CLASS_NAME);
  private ByteArrayOutputStream outputStream = new ExtendedByteArrayOutputStream(this);
  private PipedInputStream pipedInputStream;
  private int port;
  ByteBuffer recievedPayload;
  private String uri;
  private WebSocketReceiver webSocketReceiver;
  
  public WebSocketSecureNetworkModule(SSLSocketFactory paramSSLSocketFactory, String paramString1, String paramString2, int paramInt, String paramString3, Properties paramProperties)
  {
    super(paramSSLSocketFactory, paramString2, paramInt, paramString3);
    this.uri = paramString1;
    this.host = paramString2;
    this.port = paramInt;
    this.customWebSocketHeaders = paramProperties;
    this.pipedInputStream = new PipedInputStream();
    this.log.setResourceName(paramString3);
  }
  
  public InputStream getInputStream()
    throws IOException
  {
    return this.pipedInputStream;
  }
  
  public OutputStream getOutputStream()
    throws IOException
  {
    return this.outputStream;
  }
  
  public String getServerURI()
  {
    StringBuilder localStringBuilder = new StringBuilder("wss://");
    localStringBuilder.append(this.host);
    localStringBuilder.append(":");
    localStringBuilder.append(this.port);
    return localStringBuilder.toString();
  }
  
  InputStream getSocketInputStream()
    throws IOException
  {
    return super.getInputStream();
  }
  
  OutputStream getSocketOutputStream()
    throws IOException
  {
    return super.getOutputStream();
  }
  
  public void start()
    throws IOException, MqttException
  {
    super.start();
    new WebSocketHandshake(super.getInputStream(), super.getOutputStream(), this.uri, this.host, this.port, this.customWebSocketHeaders).execute();
    WebSocketReceiver localWebSocketReceiver = new WebSocketReceiver(getSocketInputStream(), this.pipedInputStream);
    this.webSocketReceiver = localWebSocketReceiver;
    localWebSocketReceiver.start("WssSocketReceiver");
  }
  
  public void stop()
    throws IOException
  {
    Object localObject = new WebSocketFrame((byte)8, true, "1000".getBytes()).encodeFrame();
    getSocketOutputStream().write((byte[])localObject);
    getSocketOutputStream().flush();
    localObject = this.webSocketReceiver;
    if (localObject != null) {
      ((WebSocketReceiver)localObject).stop();
    }
    super.stop();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\internal\websocket\WebSocketSecureNetworkModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */