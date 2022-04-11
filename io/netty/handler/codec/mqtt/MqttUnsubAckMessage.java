package io.netty.handler.codec.mqtt;

public final class MqttUnsubAckMessage
  extends MqttMessage
{
  public MqttUnsubAckMessage(MqttFixedHeader paramMqttFixedHeader, MqttMessageIdVariableHeader paramMqttMessageIdVariableHeader)
  {
    super(paramMqttFixedHeader, paramMqttMessageIdVariableHeader, null);
  }
  
  public MqttMessageIdVariableHeader variableHeader()
  {
    return (MqttMessageIdVariableHeader)super.variableHeader();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\mqtt\MqttUnsubAckMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */