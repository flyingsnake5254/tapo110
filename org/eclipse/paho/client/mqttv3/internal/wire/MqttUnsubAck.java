package org.eclipse.paho.client.mqttv3.internal.wire;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import org.eclipse.paho.client.mqttv3.MqttException;

public class MqttUnsubAck
  extends MqttAck
{
  public MqttUnsubAck(byte paramByte, byte[] paramArrayOfByte)
    throws IOException
  {
    super((byte)11);
    paramArrayOfByte = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte));
    this.msgId = paramArrayOfByte.readUnsignedShort();
    paramArrayOfByte.close();
  }
  
  protected byte[] getVariableHeader()
    throws MqttException
  {
    return new byte[0];
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\internal\wire\MqttUnsubAck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */