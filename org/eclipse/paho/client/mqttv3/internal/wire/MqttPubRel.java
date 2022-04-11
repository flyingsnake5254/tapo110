package org.eclipse.paho.client.mqttv3.internal.wire;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import org.eclipse.paho.client.mqttv3.MqttException;

public class MqttPubRel
  extends MqttPersistableWireMessage
{
  public MqttPubRel(byte paramByte, byte[] paramArrayOfByte)
    throws IOException
  {
    super((byte)6);
    paramArrayOfByte = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte));
    this.msgId = paramArrayOfByte.readUnsignedShort();
    paramArrayOfByte.close();
  }
  
  public MqttPubRel(MqttPubRec paramMqttPubRec)
  {
    super((byte)6);
    setMessageId(paramMqttPubRec.getMessageId());
  }
  
  protected byte getMessageInfo()
  {
    int i;
    if (this.duplicate) {
      i = 8;
    } else {
      i = 0;
    }
    return (byte)(i | 0x2);
  }
  
  protected byte[] getVariableHeader()
    throws MqttException
  {
    return encodeMessageId();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(super.toString()));
    localStringBuilder.append(" msgId ");
    localStringBuilder.append(this.msgId);
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\internal\wire\MqttPubRel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */