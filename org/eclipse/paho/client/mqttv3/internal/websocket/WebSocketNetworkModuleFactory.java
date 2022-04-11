package org.eclipse.paho.client.mqttv3.internal.websocket;

import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.internal.ExceptionHelper;
import org.eclipse.paho.client.mqttv3.internal.NetworkModule;
import org.eclipse.paho.client.mqttv3.internal.TCPNetworkModule;
import org.eclipse.paho.client.mqttv3.spi.NetworkModuleFactory;

public class WebSocketNetworkModuleFactory
  implements NetworkModuleFactory
{
  public NetworkModule createNetworkModule(URI paramURI, MqttConnectOptions paramMqttConnectOptions, String paramString)
    throws MqttException
  {
    String str = paramURI.getHost();
    int i = paramURI.getPort();
    if (i == -1) {
      i = 80;
    }
    SocketFactory localSocketFactory = paramMqttConnectOptions.getSocketFactory();
    if (localSocketFactory == null) {
      localSocketFactory = SocketFactory.getDefault();
    } else {
      if ((localSocketFactory instanceof SSLSocketFactory)) {
        break label85;
      }
    }
    paramURI = new WebSocketNetworkModule(localSocketFactory, paramURI.toString(), str, i, paramString, paramMqttConnectOptions.getCustomWebSocketHeaders());
    paramURI.setConnectTimeout(paramMqttConnectOptions.getConnectionTimeout());
    return paramURI;
    label85:
    throw ExceptionHelper.createMqttException(32105);
  }
  
  public Set<String> getSupportedUriSchemes()
  {
    return Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[] { "ws" })));
  }
  
  public void validateURI(URI paramURI)
    throws IllegalArgumentException
  {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\internal\websocket\WebSocketNetworkModuleFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */