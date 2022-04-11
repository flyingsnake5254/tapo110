package io.netty.handler.codec.mqtt;

import io.netty.util.internal.StringUtil;

public final class MqttTopicSubscription
{
  private final MqttQoS qualityOfService;
  private final String topicFilter;
  
  public MqttTopicSubscription(String paramString, MqttQoS paramMqttQoS)
  {
    this.topicFilter = paramString;
    this.qualityOfService = paramMqttQoS;
  }
  
  public MqttQoS qualityOfService()
  {
    return this.qualityOfService;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(StringUtil.simpleClassName(this));
    localStringBuilder.append('[');
    localStringBuilder.append("topicFilter=");
    localStringBuilder.append(this.topicFilter);
    localStringBuilder.append(", qualityOfService=");
    localStringBuilder.append(this.qualityOfService);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public String topicName()
  {
    return this.topicFilter;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\mqtt\MqttTopicSubscription.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */