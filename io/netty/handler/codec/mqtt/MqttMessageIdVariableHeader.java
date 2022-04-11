package io.netty.handler.codec.mqtt;

import io.netty.util.internal.StringUtil;

public final class MqttMessageIdVariableHeader
{
  private final int messageId;
  
  private MqttMessageIdVariableHeader(int paramInt)
  {
    this.messageId = paramInt;
  }
  
  public static MqttMessageIdVariableHeader from(int paramInt)
  {
    if ((paramInt >= 1) && (paramInt <= 65535)) {
      return new MqttMessageIdVariableHeader(paramInt);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("messageId: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" (expected: 1 ~ 65535)");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public int messageId()
  {
    return this.messageId;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(StringUtil.simpleClassName(this));
    localStringBuilder.append('[');
    localStringBuilder.append("messageId=");
    localStringBuilder.append(this.messageId);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\mqtt\MqttMessageIdVariableHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */