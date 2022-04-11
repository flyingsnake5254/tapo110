package io.netty.handler.codec.mqtt;

import io.netty.handler.codec.DecoderException;

final class MqttCodecUtil
{
  private static final int MAX_CLIENT_ID_LENGTH = 23;
  private static final int MIN_CLIENT_ID_LENGTH = 1;
  private static final char[] TOPIC_WILDCARDS = { 35, 43 };
  
  static boolean isValidClientId(MqttVersion paramMqttVersion, String paramString)
  {
    MqttVersion localMqttVersion = MqttVersion.MQTT_3_1;
    boolean bool1 = false;
    boolean bool2 = false;
    if (paramMqttVersion == localMqttVersion)
    {
      bool1 = bool2;
      if (paramString != null)
      {
        bool1 = bool2;
        if (paramString.length() >= 1)
        {
          bool1 = bool2;
          if (paramString.length() <= 23) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    if (paramMqttVersion == MqttVersion.MQTT_3_1_1)
    {
      if (paramString != null) {
        bool1 = true;
      }
      return bool1;
    }
    paramString = new StringBuilder();
    paramString.append(paramMqttVersion);
    paramString.append(" is unknown mqtt version");
    throw new IllegalArgumentException(paramString.toString());
  }
  
  static boolean isValidMessageId(int paramInt)
  {
    boolean bool;
    if (paramInt != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  static boolean isValidPublishTopicName(String paramString)
  {
    char[] arrayOfChar = TOPIC_WILDCARDS;
    int i = arrayOfChar.length;
    for (int j = 0; j < i; j++) {
      if (paramString.indexOf(arrayOfChar[j]) >= 0) {
        return false;
      }
    }
    return true;
  }
  
  static MqttFixedHeader resetUnusedFields(MqttFixedHeader paramMqttFixedHeader)
  {
    switch (1.$SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[paramMqttFixedHeader.messageType().ordinal()])
    {
    default: 
      return paramMqttFixedHeader;
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
      if ((!paramMqttFixedHeader.isDup()) && (paramMqttFixedHeader.qosLevel() == MqttQoS.AT_MOST_ONCE) && (!paramMqttFixedHeader.isRetain())) {
        return paramMqttFixedHeader;
      }
      return new MqttFixedHeader(paramMqttFixedHeader.messageType(), false, MqttQoS.AT_MOST_ONCE, false, paramMqttFixedHeader.remainingLength());
    }
    if (paramMqttFixedHeader.isRetain()) {
      return new MqttFixedHeader(paramMqttFixedHeader.messageType(), paramMqttFixedHeader.isDup(), paramMqttFixedHeader.qosLevel(), false, paramMqttFixedHeader.remainingLength());
    }
    return paramMqttFixedHeader;
  }
  
  static MqttFixedHeader validateFixedHeader(MqttFixedHeader paramMqttFixedHeader)
  {
    int i = 1.$SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[paramMqttFixedHeader.messageType().ordinal()];
    if (((i != 1) && (i != 2) && (i != 3)) || (paramMqttFixedHeader.qosLevel() == MqttQoS.AT_LEAST_ONCE)) {
      return paramMqttFixedHeader;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramMqttFixedHeader.messageType().name());
    localStringBuilder.append(" message must have QoS 1");
    throw new DecoderException(localStringBuilder.toString());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\mqtt\MqttCodecUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */