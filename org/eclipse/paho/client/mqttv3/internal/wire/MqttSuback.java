package org.eclipse.paho.client.mqttv3.internal.wire;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import org.eclipse.paho.client.mqttv3.MqttException;

public class MqttSuback
  extends MqttAck
{
  private int[] grantedQos;
  
  public MqttSuback(byte paramByte, byte[] paramArrayOfByte)
    throws IOException
  {
    super((byte)9);
    DataInputStream localDataInputStream = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte));
    this.msgId = localDataInputStream.readUnsignedShort();
    this.grantedQos = new int[paramArrayOfByte.length - 2];
    paramByte = localDataInputStream.read();
    int i = 0;
    for (;;)
    {
      if (paramByte == -1)
      {
        localDataInputStream.close();
        return;
      }
      this.grantedQos[i] = paramByte;
      i++;
      paramByte = localDataInputStream.read();
    }
  }
  
  public int[] getGrantedQos()
  {
    return this.grantedQos;
  }
  
  protected byte[] getVariableHeader()
    throws MqttException
  {
    return new byte[0];
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(super.toString());
    localStringBuffer.append(" granted Qos");
    int[] arrayOfInt = this.grantedQos;
    int i = arrayOfInt.length;
    for (int j = 0;; j++)
    {
      if (j >= i) {
        return localStringBuffer.toString();
      }
      int k = arrayOfInt[j];
      localStringBuffer.append(" ");
      localStringBuffer.append(k);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\internal\wire\MqttSuback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */