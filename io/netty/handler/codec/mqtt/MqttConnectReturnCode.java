package io.netty.handler.codec.mqtt;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum MqttConnectReturnCode
{
  private static final Map<Byte, MqttConnectReturnCode> VALUE_TO_CODE_MAP;
  private final byte byteValue;
  
  static
  {
    int i = 0;
    MqttConnectReturnCode localMqttConnectReturnCode1 = new MqttConnectReturnCode("CONNECTION_ACCEPTED", 0, (byte)0);
    CONNECTION_ACCEPTED = localMqttConnectReturnCode1;
    MqttConnectReturnCode localMqttConnectReturnCode2 = new MqttConnectReturnCode("CONNECTION_REFUSED_UNACCEPTABLE_PROTOCOL_VERSION", 1, (byte)1);
    CONNECTION_REFUSED_UNACCEPTABLE_PROTOCOL_VERSION = localMqttConnectReturnCode2;
    Object localObject1 = new MqttConnectReturnCode("CONNECTION_REFUSED_IDENTIFIER_REJECTED", 2, (byte)2);
    CONNECTION_REFUSED_IDENTIFIER_REJECTED = (MqttConnectReturnCode)localObject1;
    Object localObject2 = new MqttConnectReturnCode("CONNECTION_REFUSED_SERVER_UNAVAILABLE", 3, (byte)3);
    CONNECTION_REFUSED_SERVER_UNAVAILABLE = (MqttConnectReturnCode)localObject2;
    MqttConnectReturnCode localMqttConnectReturnCode3 = new MqttConnectReturnCode("CONNECTION_REFUSED_BAD_USER_NAME_OR_PASSWORD", 4, (byte)4);
    CONNECTION_REFUSED_BAD_USER_NAME_OR_PASSWORD = localMqttConnectReturnCode3;
    MqttConnectReturnCode localMqttConnectReturnCode4 = new MqttConnectReturnCode("CONNECTION_REFUSED_NOT_AUTHORIZED", 5, (byte)5);
    CONNECTION_REFUSED_NOT_AUTHORIZED = localMqttConnectReturnCode4;
    $VALUES = new MqttConnectReturnCode[] { localMqttConnectReturnCode1, localMqttConnectReturnCode2, localObject1, localObject2, localMqttConnectReturnCode3, localMqttConnectReturnCode4 };
    localObject2 = new HashMap();
    localObject1 = values();
    int j = localObject1.length;
    while (i < j)
    {
      localMqttConnectReturnCode2 = localObject1[i];
      ((Map)localObject2).put(Byte.valueOf(localMqttConnectReturnCode2.byteValue), localMqttConnectReturnCode2);
      i++;
    }
    VALUE_TO_CODE_MAP = Collections.unmodifiableMap((Map)localObject2);
  }
  
  private MqttConnectReturnCode(byte paramByte)
  {
    this.byteValue = ((byte)paramByte);
  }
  
  public static MqttConnectReturnCode valueOf(byte paramByte)
  {
    Object localObject = VALUE_TO_CODE_MAP;
    if (((Map)localObject).containsKey(Byte.valueOf(paramByte))) {
      return (MqttConnectReturnCode)((Map)localObject).get(Byte.valueOf(paramByte));
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("unknown connect return code: ");
    ((StringBuilder)localObject).append(paramByte & 0xFF);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public byte byteValue()
  {
    return this.byteValue;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\mqtt\MqttConnectReturnCode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */