package io.netty.handler.codec.mqtt;

public final class MqttConnAckMessage
  extends MqttMessage
{
  public MqttConnAckMessage(MqttFixedHeader paramMqttFixedHeader, MqttConnAckVariableHeader paramMqttConnAckVariableHeader)
  {
    super(paramMqttFixedHeader, paramMqttConnAckVariableHeader);
  }
  
  public MqttConnAckVariableHeader variableHeader()
  {
    return (MqttConnAckVariableHeader)super.variableHeader();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\mqtt\MqttConnAckMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */