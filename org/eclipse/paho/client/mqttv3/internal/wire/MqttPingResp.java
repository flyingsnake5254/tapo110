package org.eclipse.paho.client.mqttv3.internal.wire;

import org.eclipse.paho.client.mqttv3.MqttException;

public class MqttPingResp
  extends MqttAck
{
  public static final String KEY = "Ping";
  
  public MqttPingResp(byte paramByte, byte[] paramArrayOfByte)
  {
    super((byte)13);
  }
  
  public String getKey()
  {
    return "Ping";
  }
  
  protected byte[] getVariableHeader()
    throws MqttException
  {
    return new byte[0];
  }
  
  public boolean isMessageIdRequired()
  {
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\internal\wire\MqttPingResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */