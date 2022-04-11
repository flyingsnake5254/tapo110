package org.eclipse.paho.client.mqttv3.internal.wire;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MqttPublish
  extends MqttPersistableWireMessage
{
  private byte[] encodedPayload = null;
  private MqttMessage message;
  private String topicName;
  
  public MqttPublish(byte paramByte, byte[] paramArrayOfByte)
    throws MqttException, IOException
  {
    super((byte)3);
    Object localObject = new MqttReceivedMessage();
    this.message = ((MqttMessage)localObject);
    ((MqttMessage)localObject).setQos(0x3 & paramByte >> 1);
    if ((paramByte & 0x1) == 1) {
      this.message.setRetained(true);
    }
    if ((paramByte & 0x8) == 8) {
      ((MqttReceivedMessage)this.message).setDuplicate(true);
    }
    CountingInputStream localCountingInputStream = new CountingInputStream(new ByteArrayInputStream(paramArrayOfByte));
    localObject = new DataInputStream(localCountingInputStream);
    this.topicName = MqttWireMessage.decodeUTF8((DataInputStream)localObject);
    if (this.message.getQos() > 0) {
      this.msgId = ((DataInputStream)localObject).readUnsignedShort();
    }
    paramArrayOfByte = new byte[paramArrayOfByte.length - localCountingInputStream.getCounter()];
    ((DataInputStream)localObject).readFully(paramArrayOfByte);
    ((DataInputStream)localObject).close();
    this.message.setPayload(paramArrayOfByte);
  }
  
  public MqttPublish(String paramString, MqttMessage paramMqttMessage)
  {
    super((byte)3);
    this.topicName = paramString;
    this.message = paramMqttMessage;
  }
  
  protected static byte[] encodePayload(MqttMessage paramMqttMessage)
  {
    return paramMqttMessage.getPayload();
  }
  
  public MqttMessage getMessage()
  {
    return this.message;
  }
  
  protected byte getMessageInfo()
  {
    byte b1 = (byte)(this.message.getQos() << 1);
    byte b2 = b1;
    if (this.message.isRetained()) {
      b2 = (byte)(b1 | 0x1);
    }
    byte b3;
    if (!this.message.isDuplicate())
    {
      b3 = b2;
      if (!this.duplicate) {}
    }
    else
    {
      b2 = (byte)(b2 | 0x8);
      b3 = b2;
    }
    return b3;
  }
  
  public byte[] getPayload()
    throws MqttException
  {
    if (this.encodedPayload == null) {
      this.encodedPayload = encodePayload(this.message);
    }
    return this.encodedPayload;
  }
  
  public int getPayloadLength()
  {
    int i;
    try
    {
      i = getPayload().length;
    }
    catch (MqttException localMqttException)
    {
      i = 0;
    }
    return i;
  }
  
  public String getTopicName()
  {
    return this.topicName;
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
      MqttWireMessage.encodeUTF8(localDataOutputStream, this.topicName);
      if (this.message.getQos() > 0) {
        localDataOutputStream.writeShort(this.msgId);
      }
      localDataOutputStream.flush();
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      return (byte[])localObject;
    }
    catch (IOException localIOException)
    {
      throw new MqttException(localIOException);
    }
  }
  
  public boolean isMessageIdRequired()
  {
    return true;
  }
  
  public void setMessageId(int paramInt)
  {
    super.setMessageId(paramInt);
    MqttMessage localMqttMessage = this.message;
    if ((localMqttMessage instanceof MqttReceivedMessage)) {
      ((MqttReceivedMessage)localMqttMessage).setMessageId(paramInt);
    }
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    byte[] arrayOfByte = this.message.getPayload();
    int i = Math.min(arrayOfByte.length, 20);
    for (int j = 0;; j++)
    {
      if (j >= i)
      {
        try
        {
          String str = new java/lang/String;
          str.<init>(arrayOfByte, 0, i, "UTF-8");
        }
        catch (Exception localException)
        {
          localObject1 = "?";
        }
        localObject2 = new StringBuffer();
        ((StringBuffer)localObject2).append(super.toString());
        ((StringBuffer)localObject2).append(" qos:");
        ((StringBuffer)localObject2).append(this.message.getQos());
        if (this.message.getQos() > 0)
        {
          ((StringBuffer)localObject2).append(" msgId:");
          ((StringBuffer)localObject2).append(this.msgId);
        }
        ((StringBuffer)localObject2).append(" retained:");
        ((StringBuffer)localObject2).append(this.message.isRetained());
        ((StringBuffer)localObject2).append(" dup:");
        ((StringBuffer)localObject2).append(this.duplicate);
        ((StringBuffer)localObject2).append(" topic:\"");
        ((StringBuffer)localObject2).append(this.topicName);
        ((StringBuffer)localObject2).append("\"");
        ((StringBuffer)localObject2).append(" payload:[hex:");
        ((StringBuffer)localObject2).append(localStringBuffer);
        ((StringBuffer)localObject2).append(" utf8:\"");
        ((StringBuffer)localObject2).append((String)localObject1);
        ((StringBuffer)localObject2).append("\"");
        ((StringBuffer)localObject2).append(" length:");
        ((StringBuffer)localObject2).append(arrayOfByte.length);
        ((StringBuffer)localObject2).append("]");
        return ((StringBuffer)localObject2).toString();
      }
      Object localObject2 = Integer.toHexString(arrayOfByte[j]);
      Object localObject1 = localObject2;
      if (((String)localObject2).length() == 1)
      {
        localObject1 = new StringBuilder("0");
        ((StringBuilder)localObject1).append((String)localObject2);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localStringBuffer.append((String)localObject1);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\internal\wire\MqttPublish.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */