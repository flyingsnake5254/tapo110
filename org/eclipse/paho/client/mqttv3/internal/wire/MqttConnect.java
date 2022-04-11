package org.eclipse.paho.client.mqttv3.internal.wire;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MqttConnect
  extends MqttWireMessage
{
  public static final String KEY = "Con";
  private boolean cleanSession;
  private String clientId;
  private int keepAliveInterval;
  private int mqttVersion;
  private char[] password;
  private String userName;
  private String willDestination;
  private MqttMessage willMessage;
  
  public MqttConnect(byte paramByte, byte[] paramArrayOfByte)
    throws IOException, MqttException
  {
    super((byte)1);
    paramArrayOfByte = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte));
    MqttWireMessage.decodeUTF8(paramArrayOfByte);
    paramArrayOfByte.readByte();
    paramArrayOfByte.readByte();
    this.keepAliveInterval = paramArrayOfByte.readUnsignedShort();
    this.clientId = MqttWireMessage.decodeUTF8(paramArrayOfByte);
    paramArrayOfByte.close();
  }
  
  public MqttConnect(String paramString1, int paramInt1, boolean paramBoolean, int paramInt2, String paramString2, char[] paramArrayOfChar, MqttMessage paramMqttMessage, String paramString3)
  {
    super((byte)1);
    this.clientId = paramString1;
    this.cleanSession = paramBoolean;
    this.keepAliveInterval = paramInt2;
    this.userName = paramString2;
    if (paramArrayOfChar != null) {
      this.password = ((char[])paramArrayOfChar.clone());
    }
    this.willMessage = paramMqttMessage;
    this.willDestination = paramString3;
    this.mqttVersion = paramInt1;
  }
  
  public String getKey()
  {
    return "Con";
  }
  
  protected byte getMessageInfo()
  {
    return 0;
  }
  
  public byte[] getPayload()
    throws MqttException
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new java/io/ByteArrayOutputStream;
      localByteArrayOutputStream.<init>();
      Object localObject = new java/io/DataOutputStream;
      ((DataOutputStream)localObject).<init>(localByteArrayOutputStream);
      MqttWireMessage.encodeUTF8((DataOutputStream)localObject, this.clientId);
      if (this.willMessage != null)
      {
        MqttWireMessage.encodeUTF8((DataOutputStream)localObject, this.willDestination);
        ((DataOutputStream)localObject).writeShort(this.willMessage.getPayload().length);
        ((DataOutputStream)localObject).write(this.willMessage.getPayload());
      }
      String str = this.userName;
      if (str != null)
      {
        MqttWireMessage.encodeUTF8((DataOutputStream)localObject, str);
        if (this.password != null)
        {
          str = new java/lang/String;
          str.<init>(this.password);
          MqttWireMessage.encodeUTF8((DataOutputStream)localObject, str);
        }
      }
      ((DataOutputStream)localObject).flush();
      localObject = localByteArrayOutputStream.toByteArray();
      return (byte[])localObject;
    }
    catch (IOException localIOException)
    {
      throw new MqttException(localIOException);
    }
  }
  
  protected byte[] getVariableHeader()
    throws MqttException
  {
    try
    {
      Object localObject = new java/io/ByteArrayOutputStream;
      ((ByteArrayOutputStream)localObject).<init>();
      DataOutputStream localDataOutputStream = new java/io/DataOutputStream;
      localDataOutputStream.<init>((OutputStream)localObject);
      int i = this.mqttVersion;
      if (i == 3) {
        MqttWireMessage.encodeUTF8(localDataOutputStream, "MQIsdp");
      } else if (i == 4) {
        MqttWireMessage.encodeUTF8(localDataOutputStream, "MQTT");
      }
      localDataOutputStream.write(this.mqttVersion);
      int j = 0;
      if (this.cleanSession) {
        j = (byte)2;
      }
      MqttMessage localMqttMessage = this.willMessage;
      i = j;
      if (localMqttMessage != null)
      {
        j = (byte)((byte)(j | 0x4) | localMqttMessage.getQos() << 3);
        i = j;
        if (this.willMessage.isRetained()) {
          i = (byte)(j | 0x20);
        }
      }
      j = i;
      if (this.userName != null)
      {
        i = (byte)(i | 0x80);
        j = i;
        if (this.password != null) {
          j = (byte)(i | 0x40);
        }
      }
      localDataOutputStream.write(j);
      localDataOutputStream.writeShort(this.keepAliveInterval);
      localDataOutputStream.flush();
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      return (byte[])localObject;
    }
    catch (IOException localIOException)
    {
      throw new MqttException(localIOException);
    }
  }
  
  public boolean isCleanSession()
  {
    return this.cleanSession;
  }
  
  public boolean isMessageIdRequired()
  {
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(super.toString()));
    localStringBuilder.append(" clientId ");
    localStringBuilder.append(this.clientId);
    localStringBuilder.append(" keepAliveInterval ");
    localStringBuilder.append(this.keepAliveInterval);
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\internal\wire\MqttConnect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */