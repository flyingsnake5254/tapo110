package io.netty.handler.codec.mqtt;

public enum MqttMessageType
{
  private final int value;
  
  static
  {
    MqttMessageType localMqttMessageType1 = new MqttMessageType("CONNECT", 0, 1);
    CONNECT = localMqttMessageType1;
    MqttMessageType localMqttMessageType2 = new MqttMessageType("CONNACK", 1, 2);
    CONNACK = localMqttMessageType2;
    MqttMessageType localMqttMessageType3 = new MqttMessageType("PUBLISH", 2, 3);
    PUBLISH = localMqttMessageType3;
    MqttMessageType localMqttMessageType4 = new MqttMessageType("PUBACK", 3, 4);
    PUBACK = localMqttMessageType4;
    MqttMessageType localMqttMessageType5 = new MqttMessageType("PUBREC", 4, 5);
    PUBREC = localMqttMessageType5;
    MqttMessageType localMqttMessageType6 = new MqttMessageType("PUBREL", 5, 6);
    PUBREL = localMqttMessageType6;
    MqttMessageType localMqttMessageType7 = new MqttMessageType("PUBCOMP", 6, 7);
    PUBCOMP = localMqttMessageType7;
    MqttMessageType localMqttMessageType8 = new MqttMessageType("SUBSCRIBE", 7, 8);
    SUBSCRIBE = localMqttMessageType8;
    MqttMessageType localMqttMessageType9 = new MqttMessageType("SUBACK", 8, 9);
    SUBACK = localMqttMessageType9;
    MqttMessageType localMqttMessageType10 = new MqttMessageType("UNSUBSCRIBE", 9, 10);
    UNSUBSCRIBE = localMqttMessageType10;
    MqttMessageType localMqttMessageType11 = new MqttMessageType("UNSUBACK", 10, 11);
    UNSUBACK = localMqttMessageType11;
    MqttMessageType localMqttMessageType12 = new MqttMessageType("PINGREQ", 11, 12);
    PINGREQ = localMqttMessageType12;
    MqttMessageType localMqttMessageType13 = new MqttMessageType("PINGRESP", 12, 13);
    PINGRESP = localMqttMessageType13;
    MqttMessageType localMqttMessageType14 = new MqttMessageType("DISCONNECT", 13, 14);
    DISCONNECT = localMqttMessageType14;
    $VALUES = new MqttMessageType[] { localMqttMessageType1, localMqttMessageType2, localMqttMessageType3, localMqttMessageType4, localMqttMessageType5, localMqttMessageType6, localMqttMessageType7, localMqttMessageType8, localMqttMessageType9, localMqttMessageType10, localMqttMessageType11, localMqttMessageType12, localMqttMessageType13, localMqttMessageType14 };
  }
  
  private MqttMessageType(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static MqttMessageType valueOf(int paramInt)
  {
    for (localObject : ) {
      if (((MqttMessageType)localObject).value == paramInt) {
        return (MqttMessageType)localObject;
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("unknown message type: ");
    ((StringBuilder)localObject).append(paramInt);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public int value()
  {
    return this.value;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\mqtt\MqttMessageType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */