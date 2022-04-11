package org.eclipse.paho.client.mqttv3.internal.websocket;

import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import javax.net.ssl.SSLSocketFactory;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.internal.ExceptionHelper;
import org.eclipse.paho.client.mqttv3.internal.NetworkModule;
import org.eclipse.paho.client.mqttv3.internal.SSLNetworkModule;
import org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory;
import org.eclipse.paho.client.mqttv3.spi.NetworkModuleFactory;

public class WebSocketSecureNetworkModuleFactory
  implements NetworkModuleFactory
{
  public NetworkModule createNetworkModule(URI paramURI, MqttConnectOptions paramMqttConnectOptions, String paramString)
    throws MqttException
  {
    String str = paramURI.getHost();
    int i = paramURI.getPort();
    if (i == -1) {
      i = 443;
    }
    Object localObject = paramMqttConnectOptions.getSocketFactory();
    SSLSocketFactoryFactory localSSLSocketFactoryFactory;
    if (localObject == null)
    {
      localSSLSocketFactoryFactory = new SSLSocketFactoryFactory();
      localObject = paramMqttConnectOptions.getSSLProperties();
      if (localObject != null) {
        localSSLSocketFactoryFactory.initialize((Properties)localObject, null);
      }
      localObject = localSSLSocketFactoryFactory.createSocketFactory(null);
    }
    else
    {
      if (!(localObject instanceof SSLSocketFactory)) {
        break label160;
      }
      localSSLSocketFactoryFactory = null;
    }
    paramURI = new WebSocketSecureNetworkModule((SSLSocketFactory)localObject, paramURI.toString(), str, i, paramString, paramMqttConnectOptions.getCustomWebSocketHeaders());
    paramURI.setSSLhandshakeTimeout(paramMqttConnectOptions.getConnectionTimeout());
    paramURI.setSSLHostnameVerifier(paramMqttConnectOptions.getSSLHostnameVerifier());
    paramURI.setHttpsHostnameVerificationEnabled(paramMqttConnectOptions.isHttpsHostnameVerificationEnabled());
    if (localSSLSocketFactoryFactory != null)
    {
      paramMqttConnectOptions = localSSLSocketFactoryFactory.getEnabledCipherSuites(null);
      if (paramMqttConnectOptions != null) {
        paramURI.setEnabledCiphers(paramMqttConnectOptions);
      }
    }
    return paramURI;
    label160:
    throw ExceptionHelper.createMqttException(32105);
  }
  
  public Set<String> getSupportedUriSchemes()
  {
    return Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[] { "wss" })));
  }
  
  public void validateURI(URI paramURI)
    throws IllegalArgumentException
  {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\internal\websocket\WebSocketSecureNetworkModuleFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */