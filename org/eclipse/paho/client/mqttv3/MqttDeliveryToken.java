package org.eclipse.paho.client.mqttv3;

import org.eclipse.paho.client.mqttv3.internal.Token;

public class MqttDeliveryToken
  extends MqttToken
  implements IMqttDeliveryToken
{
  public MqttDeliveryToken() {}
  
  public MqttDeliveryToken(String paramString)
  {
    super(paramString);
  }
  
  public MqttMessage getMessage()
    throws MqttException
  {
    return this.internalTok.getMessage();
  }
  
  protected void setMessage(MqttMessage paramMqttMessage)
  {
    this.internalTok.setMessage(paramMqttMessage);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\MqttDeliveryToken.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */