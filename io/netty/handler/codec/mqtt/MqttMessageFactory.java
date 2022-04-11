package io.netty.handler.codec.mqtt;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.DecoderResult;

public final class MqttMessageFactory
{
  public static MqttMessage newInvalidMessage(MqttFixedHeader paramMqttFixedHeader, Object paramObject, Throwable paramThrowable)
  {
    return new MqttMessage(paramMqttFixedHeader, paramObject, null, DecoderResult.failure(paramThrowable));
  }
  
  public static MqttMessage newInvalidMessage(Throwable paramThrowable)
  {
    return new MqttMessage(null, null, null, DecoderResult.failure(paramThrowable));
  }
  
  public static MqttMessage newMessage(MqttFixedHeader paramMqttFixedHeader, Object paramObject1, Object paramObject2)
  {
    switch (1.$SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[paramMqttFixedHeader.messageType().ordinal()])
    {
    default: 
      paramObject1 = new StringBuilder();
      ((StringBuilder)paramObject1).append("unknown message type: ");
      ((StringBuilder)paramObject1).append(paramMqttFixedHeader.messageType());
      throw new IllegalArgumentException(((StringBuilder)paramObject1).toString());
    case 12: 
    case 13: 
    case 14: 
      return new MqttMessage(paramMqttFixedHeader);
    case 9: 
    case 10: 
    case 11: 
      return new MqttMessage(paramMqttFixedHeader, paramObject1);
    case 8: 
      return new MqttPubAckMessage(paramMqttFixedHeader, (MqttMessageIdVariableHeader)paramObject1);
    case 7: 
      return new MqttPublishMessage(paramMqttFixedHeader, (MqttPublishVariableHeader)paramObject1, (ByteBuf)paramObject2);
    case 6: 
      return new MqttUnsubscribeMessage(paramMqttFixedHeader, (MqttMessageIdVariableHeader)paramObject1, (MqttUnsubscribePayload)paramObject2);
    case 5: 
      return new MqttUnsubAckMessage(paramMqttFixedHeader, (MqttMessageIdVariableHeader)paramObject1);
    case 4: 
      return new MqttSubAckMessage(paramMqttFixedHeader, (MqttMessageIdVariableHeader)paramObject1, (MqttSubAckPayload)paramObject2);
    case 3: 
      return new MqttSubscribeMessage(paramMqttFixedHeader, (MqttMessageIdVariableHeader)paramObject1, (MqttSubscribePayload)paramObject2);
    case 2: 
      return new MqttConnAckMessage(paramMqttFixedHeader, (MqttConnAckVariableHeader)paramObject1);
    }
    return new MqttConnectMessage(paramMqttFixedHeader, (MqttConnectVariableHeader)paramObject1, (MqttConnectPayload)paramObject2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\mqtt\MqttMessageFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */