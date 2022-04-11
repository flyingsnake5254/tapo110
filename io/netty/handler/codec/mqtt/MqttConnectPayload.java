package io.netty.handler.codec.mqtt;

import io.netty.util.CharsetUtil;
import io.netty.util.internal.StringUtil;
import java.nio.charset.Charset;
import java.util.Arrays;

public final class MqttConnectPayload
{
  private final String clientIdentifier;
  private final byte[] password;
  private final String userName;
  private final byte[] willMessage;
  private final String willTopic;
  
  @Deprecated
  public MqttConnectPayload(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this(paramString1, paramString2, paramString3.getBytes(localCharset), paramString4, paramString5.getBytes(localCharset));
  }
  
  public MqttConnectPayload(String paramString1, String paramString2, byte[] paramArrayOfByte1, String paramString3, byte[] paramArrayOfByte2)
  {
    this.clientIdentifier = paramString1;
    this.willTopic = paramString2;
    this.willMessage = paramArrayOfByte1;
    this.userName = paramString3;
    this.password = paramArrayOfByte2;
  }
  
  public String clientIdentifier()
  {
    return this.clientIdentifier;
  }
  
  @Deprecated
  public String password()
  {
    String str;
    if (this.password == null) {
      str = null;
    } else {
      str = new String(this.password, CharsetUtil.UTF_8);
    }
    return str;
  }
  
  public byte[] passwordInBytes()
  {
    return this.password;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(StringUtil.simpleClassName(this));
    localStringBuilder.append('[');
    localStringBuilder.append("clientIdentifier=");
    localStringBuilder.append(this.clientIdentifier);
    localStringBuilder.append(", willTopic=");
    localStringBuilder.append(this.willTopic);
    localStringBuilder.append(", willMessage=");
    localStringBuilder.append(Arrays.toString(this.willMessage));
    localStringBuilder.append(", userName=");
    localStringBuilder.append(this.userName);
    localStringBuilder.append(", password=");
    localStringBuilder.append(Arrays.toString(this.password));
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public String userName()
  {
    return this.userName;
  }
  
  @Deprecated
  public String willMessage()
  {
    String str;
    if (this.willMessage == null) {
      str = null;
    } else {
      str = new String(this.willMessage, CharsetUtil.UTF_8);
    }
    return str;
  }
  
  public byte[] willMessageInBytes()
  {
    return this.willMessage;
  }
  
  public String willTopic()
  {
    return this.willTopic;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\mqtt\MqttConnectPayload.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */