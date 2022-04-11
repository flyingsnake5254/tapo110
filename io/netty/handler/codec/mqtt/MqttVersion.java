package io.netty.handler.codec.mqtt;

import io.netty.util.CharsetUtil;
import io.netty.util.internal.ObjectUtil;

public enum MqttVersion
{
  private final byte level;
  private final String name;
  
  static
  {
    MqttVersion localMqttVersion1 = new MqttVersion("MQTT_3_1", 0, "MQIsdp", (byte)3);
    MQTT_3_1 = localMqttVersion1;
    MqttVersion localMqttVersion2 = new MqttVersion("MQTT_3_1_1", 1, "MQTT", (byte)4);
    MQTT_3_1_1 = localMqttVersion2;
    $VALUES = new MqttVersion[] { localMqttVersion1, localMqttVersion2 };
  }
  
  private MqttVersion(String paramString, byte paramByte)
  {
    this.name = ((String)ObjectUtil.checkNotNull(paramString, "protocolName"));
    this.level = ((byte)paramByte);
  }
  
  public static MqttVersion fromProtocolNameAndLevel(String paramString, byte paramByte)
  {
    for (localObject : ) {
      if (((MqttVersion)localObject).name.equals(paramString))
      {
        if (((MqttVersion)localObject).level == paramByte) {
          return (MqttVersion)localObject;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(" and ");
        ((StringBuilder)localObject).append(paramByte);
        ((StringBuilder)localObject).append(" are not match");
        throw new MqttUnacceptableProtocolVersionException(((StringBuilder)localObject).toString());
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("is unknown protocol name");
    throw new MqttUnacceptableProtocolVersionException(((StringBuilder)localObject).toString());
  }
  
  public byte protocolLevel()
  {
    return this.level;
  }
  
  public String protocolName()
  {
    return this.name;
  }
  
  public byte[] protocolNameBytes()
  {
    return this.name.getBytes(CharsetUtil.UTF_8);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\mqtt\MqttVersion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */