package io.netty.handler.codec.mqtt;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandler.a;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.EmptyArrays;
import java.util.Iterator;
import java.util.List;

@ChannelHandler.a
public final class MqttEncoder
  extends MessageToMessageEncoder<MqttMessage>
{
  public static final MqttEncoder INSTANCE = new MqttEncoder();
  
  static ByteBuf doEncode(ByteBufAllocator paramByteBufAllocator, MqttMessage paramMqttMessage)
  {
    switch (1.$SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[paramMqttMessage.fixedHeader().messageType().ordinal()])
    {
    default: 
      paramByteBufAllocator = new StringBuilder();
      paramByteBufAllocator.append("Unknown message type: ");
      paramByteBufAllocator.append(paramMqttMessage.fixedHeader().messageType().value());
      throw new IllegalArgumentException(paramByteBufAllocator.toString());
    case 12: 
    case 13: 
    case 14: 
      return encodeMessageWithOnlySingleByteFixedHeader(paramByteBufAllocator, paramMqttMessage);
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
      return encodeMessageWithOnlySingleByteFixedHeaderAndMessageId(paramByteBufAllocator, paramMqttMessage);
    case 6: 
      return encodeSubAckMessage(paramByteBufAllocator, (MqttSubAckMessage)paramMqttMessage);
    case 5: 
      return encodeUnsubscribeMessage(paramByteBufAllocator, (MqttUnsubscribeMessage)paramMqttMessage);
    case 4: 
      return encodeSubscribeMessage(paramByteBufAllocator, (MqttSubscribeMessage)paramMqttMessage);
    case 3: 
      return encodePublishMessage(paramByteBufAllocator, (MqttPublishMessage)paramMqttMessage);
    case 2: 
      return encodeConnAckMessage(paramByteBufAllocator, (MqttConnAckMessage)paramMqttMessage);
    }
    return encodeConnectMessage(paramByteBufAllocator, (MqttConnectMessage)paramMqttMessage);
  }
  
  private static ByteBuf encodeConnAckMessage(ByteBufAllocator paramByteBufAllocator, MqttConnAckMessage paramMqttConnAckMessage)
  {
    paramByteBufAllocator = paramByteBufAllocator.buffer(4);
    paramByteBufAllocator.writeByte(getFixedHeaderByte1(paramMqttConnAckMessage.fixedHeader()));
    paramByteBufAllocator.writeByte(2);
    paramByteBufAllocator.writeByte(paramMqttConnAckMessage.variableHeader().isSessionPresent());
    paramByteBufAllocator.writeByte(paramMqttConnAckMessage.variableHeader().connectReturnCode().byteValue());
    return paramByteBufAllocator;
  }
  
  private static ByteBuf encodeConnectMessage(ByteBufAllocator paramByteBufAllocator, MqttConnectMessage paramMqttConnectMessage)
  {
    MqttFixedHeader localMqttFixedHeader = paramMqttConnectMessage.fixedHeader();
    MqttConnectVariableHeader localMqttConnectVariableHeader = paramMqttConnectMessage.variableHeader();
    Object localObject1 = paramMqttConnectMessage.payload();
    Object localObject2 = MqttVersion.fromProtocolNameAndLevel(localMqttConnectVariableHeader.name(), (byte)localMqttConnectVariableHeader.version());
    if ((!localMqttConnectVariableHeader.hasUserName()) && (localMqttConnectVariableHeader.hasPassword())) {
      throw new DecoderException("Without a username, the password MUST be not set");
    }
    paramMqttConnectMessage = ((MqttConnectPayload)localObject1).clientIdentifier();
    if (MqttCodecUtil.isValidClientId((MqttVersion)localObject2, paramMqttConnectMessage))
    {
      byte[] arrayOfByte1 = encodeStringUtf8(paramMqttConnectMessage);
      int i = arrayOfByte1.length + 2 + 0;
      paramMqttConnectMessage = ((MqttConnectPayload)localObject1).willTopic();
      if (paramMqttConnectMessage != null) {
        paramMqttConnectMessage = encodeStringUtf8(paramMqttConnectMessage);
      } else {
        paramMqttConnectMessage = EmptyArrays.EMPTY_BYTES;
      }
      byte[] arrayOfByte2 = ((MqttConnectPayload)localObject1).willMessageInBytes();
      if (arrayOfByte2 == null) {
        arrayOfByte2 = EmptyArrays.EMPTY_BYTES;
      }
      int j = i;
      if (localMqttConnectVariableHeader.isWillFlag()) {
        j = i + (paramMqttConnectMessage.length + 2) + (arrayOfByte2.length + 2);
      }
      Object localObject3 = ((MqttConnectPayload)localObject1).userName();
      if (localObject3 != null) {
        localObject3 = encodeStringUtf8((String)localObject3);
      } else {
        localObject3 = EmptyArrays.EMPTY_BYTES;
      }
      i = j;
      if (localMqttConnectVariableHeader.hasUserName()) {
        i = j + (localObject3.length + 2);
      }
      localObject1 = ((MqttConnectPayload)localObject1).passwordInBytes();
      if (localObject1 == null) {
        localObject1 = EmptyArrays.EMPTY_BYTES;
      }
      j = i;
      if (localMqttConnectVariableHeader.hasPassword()) {
        j = i + (localObject1.length + 2);
      }
      localObject2 = ((MqttVersion)localObject2).protocolNameBytes();
      i = localObject2.length + 2 + 4 + j;
      paramByteBufAllocator = paramByteBufAllocator.buffer(getVariableLengthInt(i) + 1 + i);
      paramByteBufAllocator.writeByte(getFixedHeaderByte1(localMqttFixedHeader));
      writeVariableLengthInt(paramByteBufAllocator, i);
      paramByteBufAllocator.writeShort(localObject2.length);
      paramByteBufAllocator.writeBytes((byte[])localObject2);
      paramByteBufAllocator.writeByte(localMqttConnectVariableHeader.version());
      paramByteBufAllocator.writeByte(getConnVariableHeaderFlag(localMqttConnectVariableHeader));
      paramByteBufAllocator.writeShort(localMqttConnectVariableHeader.keepAliveTimeSeconds());
      paramByteBufAllocator.writeShort(arrayOfByte1.length);
      paramByteBufAllocator.writeBytes(arrayOfByte1, 0, arrayOfByte1.length);
      if (localMqttConnectVariableHeader.isWillFlag())
      {
        paramByteBufAllocator.writeShort(paramMqttConnectMessage.length);
        paramByteBufAllocator.writeBytes(paramMqttConnectMessage, 0, paramMqttConnectMessage.length);
        paramByteBufAllocator.writeShort(arrayOfByte2.length);
        paramByteBufAllocator.writeBytes(arrayOfByte2, 0, arrayOfByte2.length);
      }
      if (localMqttConnectVariableHeader.hasUserName())
      {
        paramByteBufAllocator.writeShort(localObject3.length);
        paramByteBufAllocator.writeBytes((byte[])localObject3, 0, localObject3.length);
      }
      if (localMqttConnectVariableHeader.hasPassword())
      {
        paramByteBufAllocator.writeShort(localObject1.length);
        paramByteBufAllocator.writeBytes((byte[])localObject1, 0, localObject1.length);
      }
      return paramByteBufAllocator;
    }
    paramByteBufAllocator = new StringBuilder();
    paramByteBufAllocator.append("invalid clientIdentifier: ");
    paramByteBufAllocator.append(paramMqttConnectMessage);
    throw new MqttIdentifierRejectedException(paramByteBufAllocator.toString());
  }
  
  private static ByteBuf encodeMessageWithOnlySingleByteFixedHeader(ByteBufAllocator paramByteBufAllocator, MqttMessage paramMqttMessage)
  {
    paramMqttMessage = paramMqttMessage.fixedHeader();
    paramByteBufAllocator = paramByteBufAllocator.buffer(2);
    paramByteBufAllocator.writeByte(getFixedHeaderByte1(paramMqttMessage));
    paramByteBufAllocator.writeByte(0);
    return paramByteBufAllocator;
  }
  
  private static ByteBuf encodeMessageWithOnlySingleByteFixedHeaderAndMessageId(ByteBufAllocator paramByteBufAllocator, MqttMessage paramMqttMessage)
  {
    MqttFixedHeader localMqttFixedHeader = paramMqttMessage.fixedHeader();
    int i = ((MqttMessageIdVariableHeader)paramMqttMessage.variableHeader()).messageId();
    paramByteBufAllocator = paramByteBufAllocator.buffer(getVariableLengthInt(2) + 1 + 2);
    paramByteBufAllocator.writeByte(getFixedHeaderByte1(localMqttFixedHeader));
    writeVariableLengthInt(paramByteBufAllocator, 2);
    paramByteBufAllocator.writeShort(i);
    return paramByteBufAllocator;
  }
  
  private static ByteBuf encodePublishMessage(ByteBufAllocator paramByteBufAllocator, MqttPublishMessage paramMqttPublishMessage)
  {
    MqttFixedHeader localMqttFixedHeader = paramMqttPublishMessage.fixedHeader();
    MqttPublishVariableHeader localMqttPublishVariableHeader = paramMqttPublishMessage.variableHeader();
    paramMqttPublishMessage = paramMqttPublishMessage.payload().duplicate();
    byte[] arrayOfByte = encodeStringUtf8(localMqttPublishVariableHeader.topicName());
    int i = arrayOfByte.length;
    int j = 2;
    if (localMqttFixedHeader.qosLevel().value() <= 0) {
      j = 0;
    }
    j = i + 2 + j + paramMqttPublishMessage.readableBytes();
    paramByteBufAllocator = paramByteBufAllocator.buffer(getVariableLengthInt(j) + 1 + j);
    paramByteBufAllocator.writeByte(getFixedHeaderByte1(localMqttFixedHeader));
    writeVariableLengthInt(paramByteBufAllocator, j);
    paramByteBufAllocator.writeShort(arrayOfByte.length);
    paramByteBufAllocator.writeBytes(arrayOfByte);
    if (localMqttFixedHeader.qosLevel().value() > 0) {
      paramByteBufAllocator.writeShort(localMqttPublishVariableHeader.packetId());
    }
    paramByteBufAllocator.writeBytes(paramMqttPublishMessage);
    return paramByteBufAllocator;
  }
  
  private static byte[] encodeStringUtf8(String paramString)
  {
    return paramString.getBytes(CharsetUtil.UTF_8);
  }
  
  private static ByteBuf encodeSubAckMessage(ByteBufAllocator paramByteBufAllocator, MqttSubAckMessage paramMqttSubAckMessage)
  {
    int i = paramMqttSubAckMessage.payload().grantedQoSLevels().size() + 2;
    paramByteBufAllocator = paramByteBufAllocator.buffer(getVariableLengthInt(i) + 1 + i);
    paramByteBufAllocator.writeByte(getFixedHeaderByte1(paramMqttSubAckMessage.fixedHeader()));
    writeVariableLengthInt(paramByteBufAllocator, i);
    paramByteBufAllocator.writeShort(paramMqttSubAckMessage.variableHeader().messageId());
    paramMqttSubAckMessage = paramMqttSubAckMessage.payload().grantedQoSLevels().iterator();
    while (paramMqttSubAckMessage.hasNext()) {
      paramByteBufAllocator.writeByte(((Integer)paramMqttSubAckMessage.next()).intValue());
    }
    return paramByteBufAllocator;
  }
  
  private static ByteBuf encodeSubscribeMessage(ByteBufAllocator paramByteBufAllocator, MqttSubscribeMessage paramMqttSubscribeMessage)
  {
    Object localObject1 = paramMqttSubscribeMessage.fixedHeader();
    Object localObject2 = paramMqttSubscribeMessage.variableHeader();
    paramMqttSubscribeMessage = paramMqttSubscribeMessage.payload();
    Iterator localIterator = paramMqttSubscribeMessage.topicSubscriptions().iterator();
    for (int i = 0; localIterator.hasNext(); i = i + (encodeStringUtf8(((MqttTopicSubscription)localIterator.next()).topicName()).length + 2) + 1) {}
    i += 2;
    paramByteBufAllocator = paramByteBufAllocator.buffer(getVariableLengthInt(i) + 1 + i);
    paramByteBufAllocator.writeByte(getFixedHeaderByte1((MqttFixedHeader)localObject1));
    writeVariableLengthInt(paramByteBufAllocator, i);
    paramByteBufAllocator.writeShort(((MqttMessageIdVariableHeader)localObject2).messageId());
    localObject2 = paramMqttSubscribeMessage.topicSubscriptions().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      paramMqttSubscribeMessage = (MqttTopicSubscription)((Iterator)localObject2).next();
      localObject1 = encodeStringUtf8(paramMqttSubscribeMessage.topicName());
      paramByteBufAllocator.writeShort(localObject1.length);
      paramByteBufAllocator.writeBytes((byte[])localObject1, 0, localObject1.length);
      paramByteBufAllocator.writeByte(paramMqttSubscribeMessage.qualityOfService().value());
    }
    return paramByteBufAllocator;
  }
  
  private static ByteBuf encodeUnsubscribeMessage(ByteBufAllocator paramByteBufAllocator, MqttUnsubscribeMessage paramMqttUnsubscribeMessage)
  {
    MqttFixedHeader localMqttFixedHeader = paramMqttUnsubscribeMessage.fixedHeader();
    Object localObject = paramMqttUnsubscribeMessage.variableHeader();
    paramMqttUnsubscribeMessage = paramMqttUnsubscribeMessage.payload();
    Iterator localIterator = paramMqttUnsubscribeMessage.topics().iterator();
    int i = 0;
    while (localIterator.hasNext()) {
      i += encodeStringUtf8((String)localIterator.next()).length + 2;
    }
    i += 2;
    paramByteBufAllocator = paramByteBufAllocator.buffer(getVariableLengthInt(i) + 1 + i);
    paramByteBufAllocator.writeByte(getFixedHeaderByte1(localMqttFixedHeader));
    writeVariableLengthInt(paramByteBufAllocator, i);
    paramByteBufAllocator.writeShort(((MqttMessageIdVariableHeader)localObject).messageId());
    paramMqttUnsubscribeMessage = paramMqttUnsubscribeMessage.topics().iterator();
    while (paramMqttUnsubscribeMessage.hasNext())
    {
      localObject = encodeStringUtf8((String)paramMqttUnsubscribeMessage.next());
      paramByteBufAllocator.writeShort(localObject.length);
      paramByteBufAllocator.writeBytes((byte[])localObject, 0, localObject.length);
    }
    return paramByteBufAllocator;
  }
  
  private static int getConnVariableHeaderFlag(MqttConnectVariableHeader paramMqttConnectVariableHeader)
  {
    if (paramMqttConnectVariableHeader.hasUserName()) {
      i = 128;
    } else {
      i = 0;
    }
    int j = i;
    if (paramMqttConnectVariableHeader.hasPassword()) {
      j = i | 0x40;
    }
    int i = j;
    if (paramMqttConnectVariableHeader.isWillRetain()) {
      i = j | 0x20;
    }
    i |= (paramMqttConnectVariableHeader.willQos() & 0x3) << 3;
    j = i;
    if (paramMqttConnectVariableHeader.isWillFlag()) {
      j = i | 0x4;
    }
    i = j;
    if (paramMqttConnectVariableHeader.isCleanSession()) {
      i = j | 0x2;
    }
    return i;
  }
  
  private static int getFixedHeaderByte1(MqttFixedHeader paramMqttFixedHeader)
  {
    int i = paramMqttFixedHeader.messageType().value() << 4 | 0x0;
    int j = i;
    if (paramMqttFixedHeader.isDup()) {
      j = i | 0x8;
    }
    i = j | paramMqttFixedHeader.qosLevel().value() << 1;
    j = i;
    if (paramMqttFixedHeader.isRetain()) {
      j = i | 0x1;
    }
    return j;
  }
  
  private static int getVariableLengthInt(int paramInt)
  {
    int i = 0;
    int j;
    int k;
    do
    {
      j = paramInt / 128;
      k = i + 1;
      i = k;
      paramInt = j;
    } while (j > 0);
    return k;
  }
  
  private static void writeVariableLengthInt(ByteBuf paramByteBuf, int paramInt)
  {
    int j;
    do
    {
      int i = paramInt % 128;
      j = paramInt / 128;
      paramInt = i;
      if (j > 0) {
        paramInt = i | 0x80;
      }
      paramByteBuf.writeByte(paramInt);
      paramInt = j;
    } while (j > 0);
  }
  
  protected void encode(ChannelHandlerContext paramChannelHandlerContext, MqttMessage paramMqttMessage, List<Object> paramList)
    throws Exception
  {
    paramList.add(doEncode(paramChannelHandlerContext.alloc(), paramMqttMessage));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\mqtt\MqttEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */