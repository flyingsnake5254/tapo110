package org.eclipse.paho.client.mqttv3.internal.wire;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import org.eclipse.paho.client.mqttv3.MqttException;

public class MqttConnack
  extends MqttAck
{
  public static final String KEY = "Con";
  private int returnCode;
  private boolean sessionPresent;
  
  public MqttConnack(byte paramByte, byte[] paramArrayOfByte)
    throws IOException
  {
    super((byte)2);
    paramArrayOfByte = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte));
    paramByte = paramArrayOfByte.readUnsignedByte();
    boolean bool = true;
    if ((paramByte & 0x1) != 1) {
      bool = false;
    }
    this.sessionPresent = bool;
    this.returnCode = paramArrayOfByte.readUnsignedByte();
    paramArrayOfByte.close();
  }
  
  public String getKey()
  {
    return "Con";
  }
  
  public int getReturnCode()
  {
    return this.returnCode;
  }
  
  public boolean getSessionPresent()
  {
    return this.sessionPresent;
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
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(super.toString()));
    localStringBuilder.append(" session present:");
    localStringBuilder.append(this.sessionPresent);
    localStringBuilder.append(" return code: ");
    localStringBuilder.append(this.returnCode);
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\internal\wire\MqttConnack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */