package org.eclipse.paho.client.mqttv3;

public abstract interface IMqttDeliveryToken
  extends IMqttToken
{
  public abstract MqttMessage getMessage()
    throws MqttException;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\IMqttDeliveryToken.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */