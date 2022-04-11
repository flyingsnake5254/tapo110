package org.eclipse.paho.client.mqttv3.internal;

import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import javax.net.ssl.SSLSocketFactory;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory;
import org.eclipse.paho.client.mqttv3.spi.NetworkModuleFactory;

public class SSLNetworkModuleFactory
  implements NetworkModuleFactory
{
  public NetworkModule createNetworkModule(URI paramURI, MqttConnectOptions paramMqttConnectOptions, String paramString)
    throws MqttException
  {
    String str = paramURI.getHost();
    int i = paramURI.getPort();
    int j = i;
    if (i == -1) {
      j = 8883;
    }
    Object localObject = paramURI.getPath();
    if ((localObject != null) && (!((String)localObject).isEmpty())) {
      throw new IllegalArgumentException(paramURI.toString());
    }
    localObject = paramMqttConnectOptions.getSocketFactory();
    if (localObject == null)
    {
      paramURI = new SSLSocketFactoryFactory();
      localObject = paramMqttConnectOptions.getSSLProperties();
      if (localObject != null) {
        paramURI.initialize((Properties)localObject, null);
      }
      localObject = paramURI.createSocketFactory(null);
    }
    else
    {
      if (!(localObject instanceof SSLSocketFactory)) {
        break label181;
      }
      paramURI = null;
    }
    paramString = new SSLNetworkModule((SSLSocketFactory)localObject, str, j, paramString);
    paramString.setSSLhandshakeTimeout(paramMqttConnectOptions.getConnectionTimeout());
    paramString.setSSLHostnameVerifier(paramMqttConnectOptions.getSSLHostnameVerifier());
    paramString.setHttpsHostnameVerificationEnabled(paramMqttConnectOptions.isHttpsHostnameVerificationEnabled());
    if (paramURI != null)
    {
      paramURI = paramURI.getEnabledCipherSuites(null);
      if (paramURI != null) {
        paramString.setEnabledCiphers(paramURI);
      }
    }
    return paramString;
    label181:
    throw ExceptionHelper.createMqttException(32105);
  }
  
  public Set<String> getSupportedUriSchemes()
  {
    return Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[] { "ssl" })));
  }
  
  public void validateURI(URI paramURI)
    throws IllegalArgumentException
  {
    String str = paramURI.getPath();
    if ((str != null) && (!str.isEmpty())) {
      throw new IllegalArgumentException(paramURI.toString());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\internal\SSLNetworkModuleFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */