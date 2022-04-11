package org.eclipse.paho.client.mqttv3.internal.wire;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import org.eclipse.paho.client.mqttv3.MqttException;

public class MqttPubAck
  extends MqttAck
{
  public MqttPubAck(byte paramByte, byte[] paramArrayOfByte)
    throws IOException
  {
    super((byte)4);
    paramArrayOfByte = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte));
    this.msgId = paramArrayOfByte.readUnsignedShort();
    paramArrayOfByte.close();
  }
  
  public MqttPubAck(int paramInt)
  {
    super((byte)4);
    this.msgId = paramInt;
  }
  
  public MqttPubAck(MqttPublish paramMqttPublish)
  {
    super((byte)4);
    this.msgId = paramMqttPublish.getMessageId();
  }
  
  protected byte[] getVariableHeader()
    throws MqttException
  {
    return encodeMessageId();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\internal\wire\MqttPubAck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */