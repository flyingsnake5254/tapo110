package org.eclipse.paho.client.mqttv3.internal;

import org.eclipse.paho.client.mqttv3.MqttTopic;

public abstract interface DestinationProvider
{
  public abstract MqttTopic getTopic(String paramString);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\internal\DestinationProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */