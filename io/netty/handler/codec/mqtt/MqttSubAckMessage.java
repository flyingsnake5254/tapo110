package io.netty.handler.codec.mqtt;

public final class MqttSubAckMessage
  extends MqttMessage
{
  public MqttSubAckMessage(MqttFixedHeader paramMqttFixedHeader, MqttMessageIdVariableHeader paramMqttMessageIdVariableHeader, MqttSubAckPayload paramMqttSubAckPayload)
  {
    super(paramMqttFixedHeader, paramMqttMessageIdVariableHeader, paramMqttSubAckPayload);
  }
  
  public MqttSubAckPayload payload()
  {
    return (MqttSubAckPayload)super.payload();
  }
  
  public MqttMessageIdVariableHeader variableHeader()
  {
    return (MqttMessageIdVariableHeader)super.variableHeader();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\mqtt\MqttSubAckMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */