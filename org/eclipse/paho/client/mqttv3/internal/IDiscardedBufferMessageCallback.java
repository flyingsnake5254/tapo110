package org.eclipse.paho.client.mqttv3.internal;

import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

public abstract interface IDiscardedBufferMessageCallback
{
  public abstract void messageDiscarded(MqttWireMessage paramMqttWireMessage);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\internal\IDiscardedBufferMessageCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */