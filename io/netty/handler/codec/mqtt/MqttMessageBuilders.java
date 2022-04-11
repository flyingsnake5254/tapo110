package io.netty.handler.codec.mqtt;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;
import java.util.ArrayList;
import java.util.List;

public final class MqttMessageBuilders
{
  public static ConnAckBuilder connAck()
  {
    return new ConnAckBuilder();
  }
  
  public static ConnectBuilder connect()
  {
    return new ConnectBuilder();
  }
  
  public static PublishBuilder publish()
  {
    return new PublishBuilder();
  }
  
  public static SubscribeBuilder subscribe()
  {
    return new SubscribeBuilder();
  }
  
  public static UnsubscribeBuilder unsubscribe()
  {
    return new UnsubscribeBuilder();
  }
  
  public static final class ConnAckBuilder
  {
    private MqttConnectReturnCode returnCode;
    private boolean sessionPresent;
    
    public MqttConnAckMessage build()
    {
      return new MqttConnAckMessage(new MqttFixedHeader(MqttMessageType.CONNACK, false, MqttQoS.AT_MOST_ONCE, false, 0), new MqttConnAckVariableHeader(this.returnCode, this.sessionPresent));
    }
    
    public ConnAckBuilder returnCode(MqttConnectReturnCode paramMqttConnectReturnCode)
    {
      this.returnCode = paramMqttConnectReturnCode;
      return this;
    }
    
    public ConnAckBuilder sessionPresent(boolean paramBoolean)
    {
      this.sessionPresent = paramBoolean;
      return this;
    }
  }
  
  public static final class ConnectBuilder
  {
    private boolean cleanSession;
    private String clientId;
    private boolean hasPassword;
    private boolean hasUser;
    private int keepAliveSecs;
    private byte[] password;
    private String username;
    private MqttVersion version = MqttVersion.MQTT_3_1_1;
    private boolean willFlag;
    private byte[] willMessage;
    private MqttQoS willQos = MqttQoS.AT_MOST_ONCE;
    private boolean willRetain;
    private String willTopic;
    
    public MqttConnectMessage build()
    {
      return new MqttConnectMessage(new MqttFixedHeader(MqttMessageType.CONNECT, false, MqttQoS.AT_MOST_ONCE, false, 0), new MqttConnectVariableHeader(this.version.protocolName(), this.version.protocolLevel(), this.hasUser, this.hasPassword, this.willRetain, this.willQos.value(), this.willFlag, this.cleanSession, this.keepAliveSecs), new MqttConnectPayload(this.clientId, this.willTopic, this.willMessage, this.username, this.password));
    }
    
    public ConnectBuilder cleanSession(boolean paramBoolean)
    {
      this.cleanSession = paramBoolean;
      return this;
    }
    
    public ConnectBuilder clientId(String paramString)
    {
      this.clientId = paramString;
      return this;
    }
    
    public ConnectBuilder hasPassword(boolean paramBoolean)
    {
      this.hasPassword = paramBoolean;
      return this;
    }
    
    public ConnectBuilder hasUser(boolean paramBoolean)
    {
      this.hasUser = paramBoolean;
      return this;
    }
    
    public ConnectBuilder keepAlive(int paramInt)
    {
      this.keepAliveSecs = paramInt;
      return this;
    }
    
    @Deprecated
    public ConnectBuilder password(String paramString)
    {
      if (paramString == null) {
        paramString = null;
      } else {
        paramString = paramString.getBytes(CharsetUtil.UTF_8);
      }
      password(paramString);
      return this;
    }
    
    public ConnectBuilder password(byte[] paramArrayOfByte)
    {
      boolean bool;
      if (paramArrayOfByte != null) {
        bool = true;
      } else {
        bool = false;
      }
      this.hasPassword = bool;
      this.password = paramArrayOfByte;
      return this;
    }
    
    public ConnectBuilder protocolVersion(MqttVersion paramMqttVersion)
    {
      this.version = paramMqttVersion;
      return this;
    }
    
    public ConnectBuilder username(String paramString)
    {
      boolean bool;
      if (paramString != null) {
        bool = true;
      } else {
        bool = false;
      }
      this.hasUser = bool;
      this.username = paramString;
      return this;
    }
    
    public ConnectBuilder willFlag(boolean paramBoolean)
    {
      this.willFlag = paramBoolean;
      return this;
    }
    
    @Deprecated
    public ConnectBuilder willMessage(String paramString)
    {
      if (paramString == null) {
        paramString = null;
      } else {
        paramString = paramString.getBytes(CharsetUtil.UTF_8);
      }
      willMessage(paramString);
      return this;
    }
    
    public ConnectBuilder willMessage(byte[] paramArrayOfByte)
    {
      this.willMessage = paramArrayOfByte;
      return this;
    }
    
    public ConnectBuilder willQoS(MqttQoS paramMqttQoS)
    {
      this.willQos = paramMqttQoS;
      return this;
    }
    
    public ConnectBuilder willRetain(boolean paramBoolean)
    {
      this.willRetain = paramBoolean;
      return this;
    }
    
    public ConnectBuilder willTopic(String paramString)
    {
      this.willTopic = paramString;
      return this;
    }
  }
  
  public static final class PublishBuilder
  {
    private int messageId;
    private ByteBuf payload;
    private MqttQoS qos;
    private boolean retained;
    private String topic;
    
    public MqttPublishMessage build()
    {
      return new MqttPublishMessage(new MqttFixedHeader(MqttMessageType.PUBLISH, false, this.qos, this.retained, 0), new MqttPublishVariableHeader(this.topic, this.messageId), Unpooled.buffer().writeBytes(this.payload));
    }
    
    public PublishBuilder messageId(int paramInt)
    {
      this.messageId = paramInt;
      return this;
    }
    
    public PublishBuilder payload(ByteBuf paramByteBuf)
    {
      this.payload = paramByteBuf;
      return this;
    }
    
    public PublishBuilder qos(MqttQoS paramMqttQoS)
    {
      this.qos = paramMqttQoS;
      return this;
    }
    
    public PublishBuilder retained(boolean paramBoolean)
    {
      this.retained = paramBoolean;
      return this;
    }
    
    public PublishBuilder topicName(String paramString)
    {
      this.topic = paramString;
      return this;
    }
  }
  
  public static final class SubscribeBuilder
  {
    private int messageId;
    private List<MqttTopicSubscription> subscriptions;
    
    public SubscribeBuilder addSubscription(MqttQoS paramMqttQoS, String paramString)
    {
      if (this.subscriptions == null) {
        this.subscriptions = new ArrayList(5);
      }
      this.subscriptions.add(new MqttTopicSubscription(paramString, paramMqttQoS));
      return this;
    }
    
    public MqttSubscribeMessage build()
    {
      return new MqttSubscribeMessage(new MqttFixedHeader(MqttMessageType.SUBSCRIBE, false, MqttQoS.AT_LEAST_ONCE, false, 0), MqttMessageIdVariableHeader.from(this.messageId), new MqttSubscribePayload(this.subscriptions));
    }
    
    public SubscribeBuilder messageId(int paramInt)
    {
      this.messageId = paramInt;
      return this;
    }
  }
  
  public static final class UnsubscribeBuilder
  {
    private int messageId;
    private List<String> topicFilters;
    
    public UnsubscribeBuilder addTopicFilter(String paramString)
    {
      if (this.topicFilters == null) {
        this.topicFilters = new ArrayList(5);
      }
      this.topicFilters.add(paramString);
      return this;
    }
    
    public MqttUnsubscribeMessage build()
    {
      return new MqttUnsubscribeMessage(new MqttFixedHeader(MqttMessageType.UNSUBSCRIBE, false, MqttQoS.AT_LEAST_ONCE, false, 0), MqttMessageIdVariableHeader.from(this.messageId), new MqttUnsubscribePayload(this.topicFilters));
    }
    
    public UnsubscribeBuilder messageId(int paramInt)
    {
      this.messageId = paramInt;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\mqtt\MqttMessageBuilders.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */