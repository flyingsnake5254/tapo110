package org.eclipse.paho.client.mqttv3.internal.wire;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import org.eclipse.paho.client.mqttv3.MqttException;

public class MqttPubComp
  extends MqttAck
{
  public MqttPubComp(byte paramByte, byte[] paramArrayOfByte)
    throws IOException
  {
    super((byte)7);
    paramArrayOfByte = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte));
    this.msgId = paramArrayOfByte.readUnsignedShort();
    paramArrayOfByte.close();
  }
  
  public MqttPubComp(int paramInt)
  {
    super((byte)7);
    this.msgId = paramInt;
  }
  
  public MqttPubComp(MqttPublish paramMqttPublish)
  {
    super((byte)7);
    this.msgId = paramMqttPublish.getMessageId();
  }
  
  protected byte[] getVariableHeader()
    throws MqttException
  {
    return encodeMessageId();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\internal\wire\MqttPubComp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */