package io.netty.handler.codec.mqtt;

import io.netty.util.internal.StringUtil;
import java.util.Collections;
import java.util.List;

public final class MqttUnsubscribePayload
{
  private final List<String> topics;
  
  public MqttUnsubscribePayload(List<String> paramList)
  {
    this.topics = Collections.unmodifiableList(paramList);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(StringUtil.simpleClassName(this));
    localStringBuilder.append('[');
    for (int i = 0; i < this.topics.size(); i++)
    {
      localStringBuilder.append("topicName = ");
      localStringBuilder.append((String)this.topics.get(i));
      localStringBuilder.append(", ");
    }
    if (!this.topics.isEmpty()) {
      localStringBuilder.setLength(localStringBuilder.length() - 2);
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public List<String> topics()
  {
    return this.topics;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\mqtt\MqttUnsubscribePayload.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */