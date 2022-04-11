package org.eclipse.paho.client.mqttv3.internal;

import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.spi.NetworkModuleFactory;

public class TCPNetworkModuleFactory
  implements NetworkModuleFactory
{
  public NetworkModule createNetworkModule(URI paramURI, MqttConnectOptions paramMqttConnectOptions, String paramString)
    throws MqttException
  {
    String str1 = paramURI.getHost();
    int i = paramURI.getPort();
    int j = i;
    if (i == -1) {
      j = 1883;
    }
    String str2 = paramURI.getPath();
    if ((str2 != null) && (!str2.isEmpty())) {
      throw new IllegalArgumentException(paramURI.toString());
    }
    paramURI = paramMqttConnectOptions.getSocketFactory();
    if (paramURI == null) {
      paramURI = SocketFactory.getDefault();
    } else {
      if ((paramURI instanceof SSLSocketFactory)) {
        break label108;
      }
    }
    paramURI = new TCPNetworkModule(paramURI, str1, j, paramString);
    paramURI.setConnectTimeout(paramMqttConnectOptions.getConnectionTimeout());
    return paramURI;
    label108:
    throw ExceptionHelper.createMqttException(32105);
  }
  
  public Set<String> getSupportedUriSchemes()
  {
    return Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[] { "tcp" })));
  }
  
  public void validateURI(URI paramURI)
    throws IllegalArgumentException
  {
    Object localObject = paramURI.getPath();
    if ((localObject != null) && (!((String)localObject).isEmpty()))
    {
      localObject = new StringBuilder("URI path must be empty \"");
      ((StringBuilder)localObject).append(paramURI.toString());
      ((StringBuilder)localObject).append("\"");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\internal\TCPNetworkModuleFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */