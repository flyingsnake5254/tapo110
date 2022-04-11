package io.netty.handler.codec.mqtt;

import io.netty.util.internal.StringUtil;

public final class MqttPublishVariableHeader
{
  private final int packetId;
  private final String topicName;
  
  public MqttPublishVariableHeader(String paramString, int paramInt)
  {
    this.topicName = paramString;
    this.packetId = paramInt;
  }
  
  @Deprecated
  public int messageId()
  {
    return this.packetId;
  }
  
  public int packetId()
  {
    return this.packetId;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(StringUtil.simpleClassName(this));
    localStringBuilder.append('[');
    localStringBuilder.append("topicName=");
    localStringBuilder.append(this.topicName);
    localStringBuilder.append(", packetId=");
    localStringBuilder.append(this.packetId);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public String topicName()
  {
    return this.topicName;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\mqtt\MqttPublishVariableHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */