package org.eclipse.paho.client.mqttv3.internal;

import org.eclipse.paho.client.mqttv3.MqttPersistable;

public class MqttPersistentData
  implements MqttPersistable
{
  private int hLength;
  private int hOffset;
  private byte[] header;
  private String key;
  private int pLength;
  private int pOffset;
  private byte[] payload;
  
  public MqttPersistentData(String paramString, byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3, int paramInt4)
  {
    Object localObject = null;
    this.key = null;
    this.header = null;
    this.hOffset = 0;
    this.hLength = 0;
    this.payload = null;
    this.pOffset = 0;
    this.pLength = 0;
    this.key = paramString;
    this.header = ((byte[])paramArrayOfByte1.clone());
    this.hOffset = paramInt1;
    this.hLength = paramInt2;
    paramString = (String)localObject;
    if (paramArrayOfByte2 != null) {
      paramString = (byte[])paramArrayOfByte2.clone();
    }
    this.payload = paramString;
    this.pOffset = paramInt3;
    this.pLength = paramInt4;
  }
  
  public byte[] getHeaderBytes()
  {
    return this.header;
  }
  
  public int getHeaderLength()
  {
    return this.hLength;
  }
  
  public int getHeaderOffset()
  {
    return this.hOffset;
  }
  
  public String getKey()
  {
    return this.key;
  }
  
  public byte[] getPayloadBytes()
  {
    return this.payload;
  }
  
  public int getPayloadLength()
  {
    if (this.payload == null) {
      return 0;
    }
    return this.pLength;
  }
  
  public int getPayloadOffset()
  {
    return this.pOffset;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\internal\MqttPersistentData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */