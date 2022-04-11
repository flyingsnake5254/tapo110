package io.netty.handler.codec.mqtt;

public final class MqttUnsubscribeMessage
  extends MqttMessage
{
  public MqttUnsubscribeMessage(MqttFixedHeader paramMqttFixedHeader, MqttMessageIdVariableHeader paramMqttMessageIdVariableHeader, MqttUnsubscribePayload paramMqttUnsubscribePayload)
  {
    super(paramMqttFixedHeader, paramMqttMessageIdVariableHeader, paramMqttUnsubscribePayload);
  }
  
  public MqttUnsubscribePayload payload()
  {
    return (MqttUnsubscribePayload)super.payload();
  }
  
  public MqttMessageIdVariableHeader variableHeader()
  {
    return (MqttMessageIdVariableHeader)super.variableHeader();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\mqtt\MqttUnsubscribeMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */