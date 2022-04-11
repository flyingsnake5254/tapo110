package org.eclipse.paho.client.mqttv3.spi;

import java.net.URI;
import java.util.Set;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.internal.NetworkModule;

public abstract interface NetworkModuleFactory
{
  public abstract NetworkModule createNetworkModule(URI paramURI, MqttConnectOptions paramMqttConnectOptions, String paramString)
    throws MqttException;
  
  public abstract Set<String> getSupportedUriSchemes();
  
  public abstract void validateURI(URI paramURI)
    throws IllegalArgumentException;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\spi\NetworkModuleFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */