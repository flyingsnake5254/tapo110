package org.eclipse.paho.client.mqttv3.internal.wire;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttPersistable;
import org.eclipse.paho.client.mqttv3.MqttToken;
import org.eclipse.paho.client.mqttv3.internal.ExceptionHelper;

public abstract class MqttWireMessage
{
  private static final long FOUR_BYTE_INT_MAX = 4294967295L;
  public static final byte MESSAGE_TYPE_CONNACK = 2;
  public static final byte MESSAGE_TYPE_CONNECT = 1;
  public static final byte MESSAGE_TYPE_DISCONNECT = 14;
  public static final byte MESSAGE_TYPE_PINGREQ = 12;
  public static final byte MESSAGE_TYPE_PINGRESP = 13;
  public static final byte MESSAGE_TYPE_PUBACK = 4;
  public static final byte MESSAGE_TYPE_PUBCOMP = 7;
  public static final byte MESSAGE_TYPE_PUBLISH = 3;
  public static final byte MESSAGE_TYPE_PUBREC = 5;
  public static final byte MESSAGE_TYPE_PUBREL = 6;
  public static final byte MESSAGE_TYPE_SUBACK = 9;
  public static final byte MESSAGE_TYPE_SUBSCRIBE = 8;
  public static final byte MESSAGE_TYPE_UNSUBACK = 11;
  public static final byte MESSAGE_TYPE_UNSUBSCRIBE = 10;
  private static final String[] PACKET_NAMES = { "reserved", "CONNECT", "CONNACK", "PUBLISH", "PUBACK", "PUBREC", "PUBREL", "PUBCOMP", "SUBSCRIBE", "SUBACK", "UNSUBSCRIBE", "UNSUBACK", "PINGREQ", "PINGRESP", "DISCONNECT" };
  protected static final Charset STRING_ENCODING = StandardCharsets.UTF_8;
  private static final int VARIABLE_BYTE_INT_MAX = 268435455;
  protected boolean duplicate = false;
  protected int msgId;
  private MqttToken token;
  private byte type;
  
  public MqttWireMessage(byte paramByte)
  {
    this.type = ((byte)paramByte);
    this.msgId = 0;
  }
  
  private static MqttWireMessage createWireMessage(InputStream paramInputStream)
    throws MqttException
  {
    try
    {
      CountingInputStream localCountingInputStream = new org/eclipse/paho/client/mqttv3/internal/wire/CountingInputStream;
      localCountingInputStream.<init>(paramInputStream);
      DataInputStream localDataInputStream = new java/io/DataInputStream;
      localDataInputStream.<init>(localCountingInputStream);
      int i = localDataInputStream.readUnsignedByte();
      int j = (byte)(i >> 4);
      byte b = (byte)(i & 0xF);
      long l = readMBI(localDataInputStream).getValue();
      l = localCountingInputStream.getCounter() + l - localCountingInputStream.getCounter();
      paramInputStream = new byte[0];
      if (l > 0L)
      {
        i = (int)l;
        paramInputStream = new byte[i];
        localDataInputStream.readFully(paramInputStream, 0, i);
      }
      if (j == 1)
      {
        paramInputStream = new MqttConnect(b, paramInputStream);
      }
      else if (j == 3)
      {
        paramInputStream = new MqttPublish(b, paramInputStream);
      }
      else if (j == 4)
      {
        paramInputStream = new MqttPubAck(b, paramInputStream);
      }
      else if (j == 7)
      {
        paramInputStream = new MqttPubComp(b, paramInputStream);
      }
      else if (j == 2)
      {
        paramInputStream = new MqttConnack(b, paramInputStream);
      }
      else if (j == 12)
      {
        paramInputStream = new MqttPingReq(b, paramInputStream);
      }
      else if (j == 13)
      {
        paramInputStream = new MqttPingResp(b, paramInputStream);
      }
      else if (j == 8)
      {
        paramInputStream = new MqttSubscribe(b, paramInputStream);
      }
      else if (j == 9)
      {
        paramInputStream = new MqttSuback(b, paramInputStream);
      }
      else if (j == 10)
      {
        paramInputStream = new MqttUnsubscribe(b, paramInputStream);
      }
      else if (j == 11)
      {
        paramInputStream = new MqttUnsubAck(b, paramInputStream);
      }
      else if (j == 6)
      {
        paramInputStream = new MqttPubRel(b, paramInputStream);
      }
      else if (j == 5)
      {
        paramInputStream = new MqttPubRec(b, paramInputStream);
      }
      else
      {
        if (j != 14) {
          break label376;
        }
        paramInputStream = new MqttDisconnect(b, paramInputStream);
      }
      return paramInputStream;
      label376:
      throw ExceptionHelper.createMqttException(6);
    }
    catch (IOException paramInputStream)
    {
      throw new MqttException(paramInputStream);
    }
  }
  
  public static MqttWireMessage createWireMessage(MqttPersistable paramMqttPersistable)
    throws MqttException
  {
    byte[] arrayOfByte1 = paramMqttPersistable.getPayloadBytes();
    byte[] arrayOfByte2 = arrayOfByte1;
    if (arrayOfByte1 == null) {
      arrayOfByte2 = new byte[0];
    }
    return createWireMessage(new MultiByteArrayInputStream(paramMqttPersistable.getHeaderBytes(), paramMqttPersistable.getHeaderOffset(), paramMqttPersistable.getHeaderLength(), arrayOfByte2, paramMqttPersistable.getPayloadOffset(), paramMqttPersistable.getPayloadLength()));
  }
  
  public static MqttWireMessage createWireMessage(byte[] paramArrayOfByte)
    throws MqttException
  {
    return createWireMessage(new ByteArrayInputStream(paramArrayOfByte));
  }
  
  public static String decodeUTF8(DataInputStream paramDataInputStream)
    throws MqttException
  {
    try
    {
      byte[] arrayOfByte = new byte[paramDataInputStream.readUnsignedShort()];
      paramDataInputStream.readFully(arrayOfByte);
      paramDataInputStream = new java/lang/String;
      paramDataInputStream.<init>(arrayOfByte, STRING_ENCODING);
      validateUTF8String(paramDataInputStream);
      return paramDataInputStream;
    }
    catch (IOException paramDataInputStream)
    {
      throw new MqttException(paramDataInputStream);
    }
  }
  
  public static byte[] encodeMBI(long paramLong)
  {
    validateVariableByteInt((int)paramLong);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    int i = 0;
    int k;
    do
    {
      int j = (byte)(int)(paramLong % 128L);
      paramLong /= 128L;
      boolean bool = paramLong < 0L;
      k = j;
      if (bool) {
        k = (byte)(j | 0x80);
      }
      localByteArrayOutputStream.write(k);
      k = i + 1;
      if (!bool) {
        break;
      }
      i = k;
    } while (k < 4);
    return localByteArrayOutputStream.toByteArray();
  }
  
  public static void encodeUTF8(DataOutputStream paramDataOutputStream, String paramString)
    throws MqttException
  {
    validateUTF8String(paramString);
    try
    {
      paramString = paramString.getBytes(STRING_ENCODING);
      int i = (byte)(paramString.length >>> 8 & 0xFF);
      int j = (byte)(paramString.length >>> 0 & 0xFF);
      paramDataOutputStream.write(i);
      paramDataOutputStream.write(j);
      paramDataOutputStream.write(paramString);
      return;
    }
    catch (IOException paramDataOutputStream)
    {
      throw new MqttException(paramDataOutputStream);
    }
    catch (UnsupportedEncodingException paramDataOutputStream)
    {
      throw new MqttException(paramDataOutputStream);
    }
  }
  
  public static MultiByteInteger readMBI(DataInputStream paramDataInputStream)
    throws IOException
  {
    int i = 0;
    int j = 0;
    int k = 1;
    int m;
    int n;
    int i1;
    do
    {
      m = paramDataInputStream.readByte();
      n = i + 1;
      i1 = j + (m & 0x7F) * k;
      k *= 128;
      i = n;
      j = i1;
    } while ((m & 0x80) != 0);
    if ((i1 >= 0) && (i1 <= 268435455)) {
      return new MultiByteInteger(i1, n);
    }
    paramDataInputStream = new StringBuilder("This property must be a number between 0 and 268435455. Read value was: ");
    paramDataInputStream.append(i1);
    throw new IOException(paramDataInputStream.toString());
  }
  
  private static void validateUTF8String(String paramString)
    throws IllegalArgumentException
  {
    int j;
    int k;
    for (int i = 0;; i = k + 1)
    {
      if (i >= paramString.length()) {
        return;
      }
      j = paramString.charAt(i);
      if (Character.isHighSurrogate(j))
      {
        i++;
        if (i == paramString.length())
        {
          k = i;
          break label173;
        }
        char c = paramString.charAt(i);
        if (Character.isLowSurrogate(c))
        {
          k = i;
          break label173;
        }
        int m = (c & 0x3FF | (j & 0x3FF) << 10) & 0xFFFF;
        k = i;
        if (m == 65535) {
          break label173;
        }
        k = i;
        if (m == 65534)
        {
          k = i;
          break label173;
        }
      }
      else
      {
        k = i;
        if (Character.isISOControl(j)) {
          break label173;
        }
        if (Character.isLowSurrogate(j))
        {
          k = i;
          break label173;
        }
        k = i;
        if (j >= 64976)
        {
          k = i;
          if (j == 65534) {
            break label173;
          }
          k = i;
          if (j >= 64976) {
            break label173;
          }
          k = i;
          if (j <= 64991)
          {
            k = i;
            break label173;
          }
        }
      }
      i = 0;
      break label175;
      label173:
      i = 1;
      label175:
      if (i != 0) {
        break;
      }
    }
    throw new IllegalArgumentException(String.format("Invalid UTF-8 char: [%x]", new Object[] { Integer.valueOf(j) }));
  }
  
  public static void validateVariableByteInt(int paramInt)
    throws IllegalArgumentException
  {
    if ((paramInt >= 0) && (paramInt <= 268435455)) {
      return;
    }
    throw new IllegalArgumentException("This property must be a number between 0 and 268435455");
  }
  
  protected byte[] encodeMessageId()
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
  
  public byte[] getHeader()
    throws MqttException
  {
    try
    {
      int i = getType();
      int j = getMessageInfo();
      byte[] arrayOfByte = getVariableHeader();
      int k = arrayOfByte.length;
      int m = getPayload().length;
      ByteArrayOutputStream localByteArrayOutputStream = new java/io/ByteArrayOutputStream;
      localByteArrayOutputStream.<init>();
      DataOutputStream localDataOutputStream = new java/io/DataOutputStream;
      localDataOutputStream.<init>(localByteArrayOutputStream);
      localDataOutputStream.writeByte((i & 0xF) << 4 ^ j & 0xF);
      localDataOutputStream.write(encodeMBI(k + m));
      localDataOutputStream.write(arrayOfByte);
      localDataOutputStream.flush();
      arrayOfByte = localByteArrayOutputStream.toByteArray();
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      throw new MqttException(localIOException);
    }
  }
  
  public String getKey()
  {
    return Integer.toString(getMessageId());
  }
  
  public int getMessageId()
  {
    return this.msgId;
  }
  
  protected abstract byte getMessageInfo();
  
  public byte[] getPayload()
    throws MqttException
  {
    return new byte[0];
  }
  
  public MqttToken getToken()
  {
    return this.token;
  }
  
  public byte getType()
  {
    return this.type;
  }
  
  protected abstract byte[] getVariableHeader()
    throws MqttException;
  
  public boolean isMessageIdRequired()
  {
    return true;
  }
  
  public boolean isRetryable()
  {
    return false;
  }
  
  public void setDuplicate(boolean paramBoolean)
  {
    this.duplicate = paramBoolean;
  }
  
  public void setMessageId(int paramInt)
  {
    this.msgId = paramInt;
  }
  
  public void setToken(MqttToken paramMqttToken)
  {
    this.token = paramMqttToken;
  }
  
  public String toString()
  {
    return PACKET_NAMES[this.type];
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\internal\wire\MqttWireMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */