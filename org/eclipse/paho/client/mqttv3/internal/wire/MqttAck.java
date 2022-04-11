package org.eclipse.paho.client.mqttv3.internal.wire;

public abstract class MqttAck
  extends MqttWireMessage
{
  public MqttAck(byte paramByte)
  {
    super(paramByte);
  }
  
  protected byte getMessageInfo()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(super.toString()));
    localStringBuilder.append(" msgId ");
    localStringBuilder.append(this.msgId);
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\internal\wire\MqttAck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */