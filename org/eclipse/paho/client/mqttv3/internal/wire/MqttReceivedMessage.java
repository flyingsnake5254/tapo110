package org.eclipse.paho.client.mqttv3.internal.wire;

import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MqttReceivedMessage
  extends MqttMessage
{
  public int getMessageId()
  {
    return super.getId();
  }
  
  public void setDuplicate(boolean paramBoolean)
  {
    super.setDuplicate(paramBoolean);
  }
  
  public void setMessageId(int paramInt)
  {
    super.setId(paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\internal\wire\MqttReceivedMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */