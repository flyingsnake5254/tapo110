package io.netty.handler.codec.mqtt;

import io.netty.util.internal.StringUtil;

public final class MqttConnAckVariableHeader
{
  private final MqttConnectReturnCode connectReturnCode;
  private final boolean sessionPresent;
  
  public MqttConnAckVariableHeader(MqttConnectReturnCode paramMqttConnectReturnCode, boolean paramBoolean)
  {
    this.connectReturnCode = paramMqttConnectReturnCode;
    this.sessionPresent = paramBoolean;
  }
  
  public MqttConnectReturnCode connectReturnCode()
  {
    return this.connectReturnCode;
  }
  
  public boolean isSessionPresent()
  {
    return this.sessionPresent;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(StringUtil.simpleClassName(this));
    localStringBuilder.append('[');
    localStringBuilder.append("connectReturnCode=");
    localStringBuilder.append(this.connectReturnCode);
    localStringBuilder.append(", sessionPresent=");
    localStringBuilder.append(this.sessionPresent);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\mqtt\MqttConnAckVariableHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */