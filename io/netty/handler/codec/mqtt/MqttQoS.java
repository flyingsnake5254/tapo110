package io.netty.handler.codec.mqtt;

public enum MqttQoS
{
  private final int value;
  
  static
  {
    MqttQoS localMqttQoS1 = new MqttQoS("AT_MOST_ONCE", 0, 0);
    AT_MOST_ONCE = localMqttQoS1;
    MqttQoS localMqttQoS2 = new MqttQoS("AT_LEAST_ONCE", 1, 1);
    AT_LEAST_ONCE = localMqttQoS2;
    MqttQoS localMqttQoS3 = new MqttQoS("EXACTLY_ONCE", 2, 2);
    EXACTLY_ONCE = localMqttQoS3;
    MqttQoS localMqttQoS4 = new MqttQoS("FAILURE", 3, 128);
    FAILURE = localMqttQoS4;
    $VALUES = new MqttQoS[] { localMqttQoS1, localMqttQoS2, localMqttQoS3, localMqttQoS4 };
  }
  
  private MqttQoS(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static MqttQoS valueOf(int paramInt)
  {
    for (localObject : ) {
      if (((MqttQoS)localObject).value == paramInt) {
        return (MqttQoS)localObject;
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("invalid QoS: ");
    ((StringBuilder)localObject).append(paramInt);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public int value()
  {
    return this.value;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\mqtt\MqttQoS.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */