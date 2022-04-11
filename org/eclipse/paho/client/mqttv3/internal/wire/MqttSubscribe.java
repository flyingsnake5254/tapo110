package org.eclipse.paho.client.mqttv3.internal.wire;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MqttSubscribe
  extends MqttWireMessage
{
  private int count;
  private String[] names;
  private int[] qos;
  
  public MqttSubscribe(byte paramByte, byte[] paramArrayOfByte)
    throws IOException
  {
    super((byte)8);
    paramArrayOfByte = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte));
    this.msgId = paramArrayOfByte.readUnsignedShort();
    paramByte = 0;
    this.count = 0;
    this.names = new String[10];
    this.qos = new int[10];
    for (;;)
    {
      if (paramByte != 0)
      {
        paramArrayOfByte.close();
        return;
      }
      try
      {
        this.names[this.count] = MqttWireMessage.decodeUTF8(paramArrayOfByte);
        int[] arrayOfInt = this.qos;
        int i = this.count;
        this.count = (i + 1);
        arrayOfInt[i] = paramArrayOfByte.readByte();
      }
      catch (Exception localException)
      {
        paramByte = 1;
      }
    }
  }
  
  public MqttSubscribe(String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    super((byte)8);
    if ((paramArrayOfString != null) && (paramArrayOfInt != null))
    {
      this.names = ((String[])paramArrayOfString.clone());
      int[] arrayOfInt = (int[])paramArrayOfInt.clone();
      this.qos = arrayOfInt;
      if (this.names.length == arrayOfInt.length)
      {
        this.count = paramArrayOfString.length;
        int i = paramArrayOfInt.length;
        for (int j = 0;; j++)
        {
          if (j >= i) {
            return;
          }
          MqttMessage.validateQos(paramArrayOfInt[j]);
        }
      }
      throw new IllegalArgumentException();
    }
    throw new IllegalArgumentException();
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
  
  /* Error */
  public byte[] getPayload()
    throws MqttException
  {
    // Byte code:
    //   0: new 87	java/io/ByteArrayOutputStream
    //   3: astore_1
    //   4: aload_1
    //   5: invokespecial 88	java/io/ByteArrayOutputStream:<init>	()V
    //   8: new 90	java/io/DataOutputStream
    //   11: astore_2
    //   12: aload_2
    //   13: aload_1
    //   14: invokespecial 93	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   17: iconst_0
    //   18: istore_3
    //   19: aload_0
    //   20: getfield 42	org/eclipse/paho/client/mqttv3/internal/wire/MqttSubscribe:names	[Ljava/lang/String;
    //   23: astore 4
    //   25: iload_3
    //   26: aload 4
    //   28: arraylength
    //   29: if_icmplt +12 -> 41
    //   32: aload_2
    //   33: invokevirtual 96	java/io/DataOutputStream:flush	()V
    //   36: aload_1
    //   37: invokevirtual 99	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   40: areturn
    //   41: aload_2
    //   42: aload 4
    //   44: iload_3
    //   45: aaload
    //   46: invokestatic 103	org/eclipse/paho/client/mqttv3/internal/wire/MqttWireMessage:encodeUTF8	(Ljava/io/DataOutputStream;Ljava/lang/String;)V
    //   49: aload_2
    //   50: aload_0
    //   51: getfield 44	org/eclipse/paho/client/mqttv3/internal/wire/MqttSubscribe:qos	[I
    //   54: iload_3
    //   55: iaload
    //   56: invokevirtual 106	java/io/DataOutputStream:writeByte	(I)V
    //   59: iinc 3 1
    //   62: goto -43 -> 19
    //   65: astore 4
    //   67: new 85	org/eclipse/paho/client/mqttv3/MqttException
    //   70: dup
    //   71: aload 4
    //   73: invokespecial 109	org/eclipse/paho/client/mqttv3/MqttException:<init>	(Ljava/lang/Throwable;)V
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	MqttSubscribe
    //   3	34	1	localByteArrayOutputStream	ByteArrayOutputStream
    //   11	39	2	localDataOutputStream	DataOutputStream
    //   18	42	3	i	int
    //   23	20	4	arrayOfString	String[]
    //   65	7	4	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   0	17	65	java/io/IOException
    //   19	41	65	java/io/IOException
    //   41	59	65	java/io/IOException
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
      localDataOutputStream.writeShort(this.msgId);
      localDataOutputStream.flush();
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      return (byte[])localObject;
    }
    catch (IOException localIOException)
    {
      throw new MqttException(localIOException);
    }
  }
  
  public boolean isRetryable()
  {
    return true;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(super.toString());
    localStringBuffer.append(" names:[");
    int i = 0;
    for (int j = 0;; j++)
    {
      if (j >= this.count)
      {
        localStringBuffer.append("] qos:[");
        for (j = i;; j++)
        {
          if (j >= this.count)
          {
            localStringBuffer.append("]");
            return localStringBuffer.toString();
          }
          if (j > 0) {
            localStringBuffer.append(", ");
          }
          localStringBuffer.append(this.qos[j]);
        }
      }
      if (j > 0) {
        localStringBuffer.append(", ");
      }
      localStringBuffer.append("\"");
      localStringBuffer.append(this.names[j]);
      localStringBuffer.append("\"");
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\internal\wire\MqttSubscribe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */