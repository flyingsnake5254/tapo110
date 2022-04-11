package org.eclipse.paho.client.mqttv3.internal;

import org.eclipse.paho.client.mqttv3.BufferedMessage;
import org.eclipse.paho.client.mqttv3.MqttException;

public abstract interface IDisconnectedBufferCallback
{
  public abstract void publishBufferedMessage(BufferedMessage paramBufferedMessage)
    throws MqttException;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\internal\IDisconnectedBufferCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */