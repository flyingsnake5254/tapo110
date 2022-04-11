package org.eclipse.paho.client.mqttv3.internal.wire;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import org.eclipse.paho.client.mqttv3.MqttException;

public class MqttUnsubscribe
  extends MqttWireMessage
{
  private int count;
  private String[] names;
  
  public MqttUnsubscribe(byte paramByte, byte[] paramArrayOfByte)
    throws IOException
  {
    super((byte)10);
    paramArrayOfByte = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte));
    this.msgId = paramArrayOfByte.readUnsignedShort();
    paramByte = 0;
    this.count = 0;
    this.names = new String[10];
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
      }
      catch (Exception localException)
      {
        paramByte = 1;
      }
    }
  }
  
  public MqttUnsubscribe(String[] paramArrayOfString)
  {
    super((byte)10);
    if (paramArrayOfString != null) {
      this.names = ((String[])paramArrayOfString.clone());
    }
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
    //   0: new 68	java/io/ByteArrayOutputStream
    //   3: astore_1
    //   4: aload_1
    //   5: invokespecial 70	java/io/ByteArrayOutputStream:<init>	()V
    //   8: new 72	java/io/DataOutputStream
    //   11: astore_2
    //   12: aload_2
    //   13: aload_1
    //   14: invokespecial 75	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   17: aload_0
    //   18: getfield 40	org/eclipse/paho/client/mqttv3/internal/wire/MqttUnsubscribe:names	[Ljava/lang/String;
    //   21: astore_3
    //   22: aload_3
    //   23: arraylength
    //   24: istore 4
    //   26: iconst_0
    //   27: istore 5
    //   29: iload 5
    //   31: iload 4
    //   33: if_icmplt +12 -> 45
    //   36: aload_2
    //   37: invokevirtual 78	java/io/DataOutputStream:flush	()V
    //   40: aload_1
    //   41: invokevirtual 81	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   44: areturn
    //   45: aload_2
    //   46: aload_3
    //   47: iload 5
    //   49: aaload
    //   50: invokestatic 85	org/eclipse/paho/client/mqttv3/internal/wire/MqttWireMessage:encodeUTF8	(Ljava/io/DataOutputStream;Ljava/lang/String;)V
    //   53: iinc 5 1
    //   56: goto -27 -> 29
    //   59: astore_3
    //   60: new 66	org/eclipse/paho/client/mqttv3/MqttException
    //   63: dup
    //   64: aload_3
    //   65: invokespecial 88	org/eclipse/paho/client/mqttv3/MqttException:<init>	(Ljava/lang/Throwable;)V
    //   68: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	this	MqttUnsubscribe
    //   3	38	1	localByteArrayOutputStream	ByteArrayOutputStream
    //   11	35	2	localDataOutputStream	DataOutputStream
    //   21	26	3	arrayOfString	String[]
    //   59	6	3	localIOException	IOException
    //   24	10	4	i	int
    //   27	27	5	j	int
    // Exception table:
    //   from	to	target	type
    //   0	26	59	java/io/IOException
    //   36	45	59	java/io/IOException
    //   45	53	59	java/io/IOException
  }
  
  protected byte[] getVariableHeader()
    throws MqttException
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new java/io/ByteArrayOutputStream;
      localByteArrayOutputStream.<init>();
      Object localObject = new java/io/DataOutputStream;
      ((DataOutputStream)localObject).<init>(localByteArrayOutputStream);
      ((DataOutputStream)localObject).writeShort(this.msgId);
      ((DataOutputStream)localObject).flush();
      localObject = localByteArrayOutputStream.toByteArray();
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
    for (int i = 0;; i++)
    {
      if (i >= this.count)
      {
        localStringBuffer.append("]");
        return localStringBuffer.toString();
      }
      if (i > 0) {
        localStringBuffer.append(", ");
      }
      StringBuilder localStringBuilder = new StringBuilder("\"");
      localStringBuilder.append(this.names[i]);
      localStringBuilder.append("\"");
      localStringBuffer.append(localStringBuilder.toString());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\internal\wire\MqttUnsubscribe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */