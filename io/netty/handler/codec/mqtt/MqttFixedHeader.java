package io.netty.handler.codec.mqtt;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

public final class MqttFixedHeader
{
  private final boolean isDup;
  private final boolean isRetain;
  private final MqttMessageType messageType;
  private final MqttQoS qosLevel;
  private final int remainingLength;
  
  public MqttFixedHeader(MqttMessageType paramMqttMessageType, boolean paramBoolean1, MqttQoS paramMqttQoS, boolean paramBoolean2, int paramInt)
  {
    this.messageType = ((MqttMessageType)ObjectUtil.checkNotNull(paramMqttMessageType, "messageType"));
    this.isDup = paramBoolean1;
    this.qosLevel = ((MqttQoS)ObjectUtil.checkNotNull(paramMqttQoS, "qosLevel"));
    this.isRetain = paramBoolean2;
    this.remainingLength = paramInt;
  }
  
  public boolean isDup()
  {
    return this.isDup;
  }
  
  public boolean isRetain()
  {
    return this.isRetain;
  }
  
  public MqttMessageType messageType()
  {
    return this.messageType;
  }
  
  public MqttQoS qosLevel()
  {
    return this.qosLevel;
  }
  
  public int remainingLength()
  {
    return this.remainingLength;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(StringUtil.simpleClassName(this));
    localStringBuilder.append('[');
    localStringBuilder.append("messageType=");
    localStringBuilder.append(this.messageType);
    localStringBuilder.append(", isDup=");
    localStringBuilder.append(this.isDup);
    localStringBuilder.append(", qosLevel=");
    localStringBuilder.append(this.qosLevel);
    localStringBuilder.append(", isRetain=");
    localStringBuilder.append(this.isRetain);
    localStringBuilder.append(", remainingLength=");
    localStringBuilder.append(this.remainingLength);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\mqtt\MqttFixedHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */