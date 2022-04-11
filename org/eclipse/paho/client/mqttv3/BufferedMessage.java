package org.eclipse.paho.client.mqttv3;

import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

public class BufferedMessage
{
  private MqttWireMessage message;
  private MqttToken token;
  
  public BufferedMessage(MqttWireMessage paramMqttWireMessage, MqttToken paramMqttToken)
  {
    this.message = paramMqttWireMessage;
    this.token = paramMqttToken;
  }
  
  public MqttWireMessage getMessage()
  {
    return this.message;
  }
  
  public MqttToken getToken()
  {
    return this.token;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\BufferedMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */