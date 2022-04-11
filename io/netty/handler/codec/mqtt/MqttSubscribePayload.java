package io.netty.handler.codec.mqtt;

import io.netty.util.internal.StringUtil;
import java.util.Collections;
import java.util.List;

public final class MqttSubscribePayload
{
  private final List<MqttTopicSubscription> topicSubscriptions;
  
  public MqttSubscribePayload(List<MqttTopicSubscription> paramList)
  {
    this.topicSubscriptions = Collections.unmodifiableList(paramList);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(StringUtil.simpleClassName(this));
    localStringBuilder.append('[');
    for (int i = 0; i < this.topicSubscriptions.size(); i++)
    {
      localStringBuilder.append(this.topicSubscriptions.get(i));
      localStringBuilder.append(", ");
    }
    if (!this.topicSubscriptions.isEmpty()) {
      localStringBuilder.setLength(localStringBuilder.length() - 2);
    }
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public List<MqttTopicSubscription> topicSubscriptions()
  {
    return this.topicSubscriptions;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\mqtt\MqttSubscribePayload.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */