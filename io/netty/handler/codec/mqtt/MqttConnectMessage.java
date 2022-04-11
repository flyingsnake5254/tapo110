package io.netty.handler.codec.mqtt;

public final class MqttConnectMessage
  extends MqttMessage
{
  public MqttConnectMessage(MqttFixedHeader paramMqttFixedHeader, MqttConnectVariableHeader paramMqttConnectVariableHeader, MqttConnectPayload paramMqttConnectPayload)
  {
    super(paramMqttFixedHeader, paramMqttConnectVariableHeader, paramMqttConnectPayload);
  }
  
  public MqttConnectPayload payload()
  {
    return (MqttConnectPayload)super.payload();
  }
  
  public MqttConnectVariableHeader variableHeader()
  {
    return (MqttConnectVariableHeader)super.variableHeader();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\mqtt\MqttConnectMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */