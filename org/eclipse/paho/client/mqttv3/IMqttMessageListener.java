package org.eclipse.paho.client.mqttv3;

public abstract interface IMqttMessageListener
{
  public abstract void messageArrived(String paramString, MqttMessage paramMqttMessage)
    throws Exception;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\IMqttMessageListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */