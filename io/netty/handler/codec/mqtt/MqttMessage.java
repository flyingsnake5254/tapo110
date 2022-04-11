package io.netty.handler.codec.mqtt;

import io.netty.handler.codec.DecoderResult;
import io.netty.util.internal.StringUtil;

public class MqttMessage
{
  public static final MqttMessage DISCONNECT;
  public static final MqttMessage PINGREQ;
  public static final MqttMessage PINGRESP;
  private final DecoderResult decoderResult;
  private final MqttFixedHeader mqttFixedHeader;
  private final Object payload;
  private final Object variableHeader;
  
  static
  {
    MqttMessageType localMqttMessageType = MqttMessageType.PINGREQ;
    MqttQoS localMqttQoS = MqttQoS.AT_MOST_ONCE;
    PINGREQ = new MqttMessage(new MqttFixedHeader(localMqttMessageType, false, localMqttQoS, false, 0));
    PINGRESP = new MqttMessage(new MqttFixedHeader(MqttMessageType.PINGRESP, false, localMqttQoS, false, 0));
    DISCONNECT = new MqttMessage(new MqttFixedHeader(MqttMessageType.DISCONNECT, false, localMqttQoS, false, 0));
  }
  
  public MqttMessage(MqttFixedHeader paramMqttFixedHeader)
  {
    this(paramMqttFixedHeader, null, null);
  }
  
  public MqttMessage(MqttFixedHeader paramMqttFixedHeader, Object paramObject)
  {
    this(paramMqttFixedHeader, paramObject, null);
  }
  
  public MqttMessage(MqttFixedHeader paramMqttFixedHeader, Object paramObject1, Object paramObject2)
  {
    this(paramMqttFixedHeader, paramObject1, paramObject2, DecoderResult.SUCCESS);
  }
  
  public MqttMessage(MqttFixedHeader paramMqttFixedHeader, Object paramObject1, Object paramObject2, DecoderResult paramDecoderResult)
  {
    this.mqttFixedHeader = paramMqttFixedHeader;
    this.variableHeader = paramObject1;
    this.payload = paramObject2;
    this.decoderResult = paramDecoderResult;
  }
  
  public DecoderResult decoderResult()
  {
    return this.decoderResult;
  }
  
  public MqttFixedHeader fixedHeader()
  {
    return this.mqttFixedHeader;
  }
  
  public Object payload()
  {
    return this.payload;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(StringUtil.simpleClassName(this));
    localStringBuilder.append('[');
    localStringBuilder.append("fixedHeader=");
    Object localObject = fixedHeader();
    String str = "";
    if (localObject != null) {
      localObject = fixedHeader().toString();
    } else {
      localObject = "";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(", variableHeader=");
    if (variableHeader() != null) {
      localObject = this.variableHeader.toString();
    } else {
      localObject = "";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(", payload=");
    localObject = str;
    if (payload() != null) {
      localObject = this.payload.toString();
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public Object variableHeader()
  {
    return this.variableHeader;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\mqtt\MqttMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */