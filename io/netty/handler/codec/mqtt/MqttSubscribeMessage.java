package io.netty.handler.codec.mqtt;

public final class MqttSubscribeMessage
  extends MqttMessage
{
  public MqttSubscribeMessage(MqttFixedHeader paramMqttFixedHeader, MqttMessageIdVariableHeader paramMqttMessageIdVariableHeader, MqttSubscribePayload paramMqttSubscribePayload)
  {
    super(paramMqttFixedHeader, paramMqttMessageIdVariableHeader, paramMqttSubscribePayload);
  }
  
  public MqttSubscribePayload payload()
  {
    return (MqttSubscribePayload)super.payload();
  }
  
  public MqttMessageIdVariableHeader variableHeader()
  {
    return (MqttMessageIdVariableHeader)super.variableHeader();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\mqtt\MqttSubscribeMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */