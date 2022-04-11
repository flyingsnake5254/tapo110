package io.netty.handler.codec.mqtt;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.ReplayingDecoder;
import io.netty.util.CharsetUtil;
import java.util.ArrayList;
import java.util.List;

public final class MqttDecoder
  extends ReplayingDecoder<DecoderState>
{
  private static final int DEFAULT_MAX_BYTES_IN_MESSAGE = 8092;
  private int bytesRemainingInVariablePart;
  private final int maxBytesInMessage;
  private MqttFixedHeader mqttFixedHeader;
  private Object variableHeader;
  
  public MqttDecoder()
  {
    this(8092);
  }
  
  public MqttDecoder(int paramInt)
  {
    super(DecoderState.READ_FIXED_HEADER);
    this.maxBytesInMessage = paramInt;
  }
  
  private static Result<byte[]> decodeByteArray(ByteBuf paramByteBuf)
  {
    Result localResult = decodeMsbLsb(paramByteBuf);
    int i = ((Integer)localResult.value).intValue();
    byte[] arrayOfByte = new byte[i];
    paramByteBuf.readBytes(arrayOfByte);
    return new Result(arrayOfByte, localResult.numberOfBytesConsumed + i);
  }
  
  private static Result<MqttConnAckVariableHeader> decodeConnAckVariableHeader(ByteBuf paramByteBuf)
  {
    int i = paramByteBuf.readUnsignedByte();
    boolean bool = true;
    if ((i & 0x1) != 1) {
      bool = false;
    }
    return new Result(new MqttConnAckVariableHeader(MqttConnectReturnCode.valueOf(paramByteBuf.readByte()), bool), 2);
  }
  
  private static Result<MqttConnectPayload> decodeConnectionPayload(ByteBuf paramByteBuf, MqttConnectVariableHeader paramMqttConnectVariableHeader)
  {
    Object localObject1 = decodeString(paramByteBuf);
    Object localObject2 = (String)((Result)localObject1).value;
    if (MqttCodecUtil.isValidClientId(MqttVersion.fromProtocolNameAndLevel(paramMqttConnectVariableHeader.name(), (byte)paramMqttConnectVariableHeader.version()), (String)localObject2))
    {
      int i = ((Result)localObject1).numberOfBytesConsumed;
      boolean bool = paramMqttConnectVariableHeader.isWillFlag();
      Object localObject3 = null;
      if (bool)
      {
        localObject4 = decodeString(paramByteBuf, 0, 32767);
        int j = ((Result)localObject4).numberOfBytesConsumed;
        localObject2 = decodeByteArray(paramByteBuf);
        i = i + j + ((Result)localObject2).numberOfBytesConsumed;
      }
      else
      {
        localObject4 = null;
        localObject2 = localObject4;
      }
      Object localObject5;
      if (paramMqttConnectVariableHeader.hasUserName())
      {
        localObject5 = decodeString(paramByteBuf);
        i += ((Result)localObject5).numberOfBytesConsumed;
      }
      else
      {
        localObject5 = null;
      }
      if (paramMqttConnectVariableHeader.hasPassword())
      {
        paramByteBuf = decodeByteArray(paramByteBuf);
        i += paramByteBuf.numberOfBytesConsumed;
      }
      else
      {
        paramByteBuf = null;
      }
      localObject1 = (String)((Result)localObject1).value;
      if (localObject4 != null) {
        paramMqttConnectVariableHeader = (String)((Result)localObject4).value;
      } else {
        paramMqttConnectVariableHeader = null;
      }
      if (localObject2 != null) {
        localObject2 = (byte[])((Result)localObject2).value;
      } else {
        localObject2 = null;
      }
      if (localObject5 != null) {
        localObject5 = (String)((Result)localObject5).value;
      } else {
        localObject5 = null;
      }
      Object localObject4 = localObject3;
      if (paramByteBuf != null) {
        localObject4 = (byte[])paramByteBuf.value;
      }
      return new Result(new MqttConnectPayload((String)localObject1, paramMqttConnectVariableHeader, (byte[])localObject2, (String)localObject5, (byte[])localObject4), i);
    }
    paramByteBuf = new StringBuilder();
    paramByteBuf.append("invalid clientIdentifier: ");
    paramByteBuf.append((String)localObject2);
    throw new MqttIdentifierRejectedException(paramByteBuf.toString());
  }
  
  private static Result<MqttConnectVariableHeader> decodeConnectionVariableHeader(ByteBuf paramByteBuf)
  {
    Object localObject = decodeString(paramByteBuf);
    int i = ((Result)localObject).numberOfBytesConsumed;
    byte b = paramByteBuf.readByte();
    int j = 1;
    localObject = MqttVersion.fromProtocolNameAndLevel((String)((Result)localObject).value, b);
    int k = paramByteBuf.readUnsignedByte();
    paramByteBuf = decodeMsbLsb(paramByteBuf);
    int m = paramByteBuf.numberOfBytesConsumed;
    boolean bool1;
    if ((k & 0x80) == 128) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if ((k & 0x40) == 64) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    boolean bool3;
    if ((k & 0x20) == 32) {
      bool3 = true;
    } else {
      bool3 = false;
    }
    boolean bool4;
    if ((k & 0x4) == 4) {
      bool4 = true;
    } else {
      bool4 = false;
    }
    boolean bool5;
    if ((k & 0x2) == 2) {
      bool5 = true;
    } else {
      bool5 = false;
    }
    if (localObject == MqttVersion.MQTT_3_1_1)
    {
      if ((k & 0x1) != 0) {
        j = 0;
      }
      if (j == 0) {
        throw new DecoderException("non-zero reserved flag");
      }
    }
    return new Result(new MqttConnectVariableHeader(((MqttVersion)localObject).protocolName(), ((MqttVersion)localObject).protocolLevel(), bool1, bool2, bool3, (k & 0x18) >> 3, bool4, bool5, ((Integer)paramByteBuf.value).intValue()), i + 1 + 1 + m);
  }
  
  private static MqttFixedHeader decodeFixedHeader(ByteBuf paramByteBuf)
  {
    int i = paramByteBuf.readUnsignedByte();
    MqttMessageType localMqttMessageType = MqttMessageType.valueOf(i >> 4);
    int j = 0;
    boolean bool1;
    if ((i & 0x8) == 8) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if ((i & 0x1) != 0) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    int k = 0;
    int m = 1;
    int n;
    for (;;)
    {
      n = paramByteBuf.readUnsignedByte();
      j = (n & 0x7F) * m + j;
      m *= 128;
      k++;
      n &= 0x80;
      if ((n == 0) || (k >= 4)) {
        break;
      }
    }
    if ((k == 4) && (n != 0))
    {
      paramByteBuf = new StringBuilder();
      paramByteBuf.append("remaining length exceeds 4 digits (");
      paramByteBuf.append(localMqttMessageType);
      paramByteBuf.append(')');
      throw new DecoderException(paramByteBuf.toString());
    }
    return MqttCodecUtil.validateFixedHeader(MqttCodecUtil.resetUnusedFields(new MqttFixedHeader(localMqttMessageType, bool1, MqttQoS.valueOf((i & 0x6) >> 1), bool2, j)));
  }
  
  private static Result<Integer> decodeMessageId(ByteBuf paramByteBuf)
  {
    paramByteBuf = decodeMsbLsb(paramByteBuf);
    if (MqttCodecUtil.isValidMessageId(((Integer)paramByteBuf.value).intValue())) {
      return paramByteBuf;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("invalid messageId: ");
    localStringBuilder.append(paramByteBuf.value);
    throw new DecoderException(localStringBuilder.toString());
  }
  
  private static Result<MqttMessageIdVariableHeader> decodeMessageIdVariableHeader(ByteBuf paramByteBuf)
  {
    paramByteBuf = decodeMessageId(paramByteBuf);
    return new Result(MqttMessageIdVariableHeader.from(((Integer)paramByteBuf.value).intValue()), paramByteBuf.numberOfBytesConsumed);
  }
  
  private static Result<Integer> decodeMsbLsb(ByteBuf paramByteBuf)
  {
    return decodeMsbLsb(paramByteBuf, 0, 65535);
  }
  
  private static Result<Integer> decodeMsbLsb(ByteBuf paramByteBuf, int paramInt1, int paramInt2)
  {
    int i = paramByteBuf.readUnsignedByte();
    i = paramByteBuf.readUnsignedByte() | i << 8;
    if (i >= paramInt1)
    {
      paramInt1 = i;
      if (i <= paramInt2) {}
    }
    else
    {
      paramInt1 = -1;
    }
    return new Result(Integer.valueOf(paramInt1), 2);
  }
  
  private static Result<?> decodePayload(ByteBuf paramByteBuf, MqttMessageType paramMqttMessageType, int paramInt, Object paramObject)
  {
    int i = 1.$SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[paramMqttMessageType.ordinal()];
    if (i != 1)
    {
      if (i != 11)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5) {
              return new Result(null, 0);
            }
            return decodeSubackPayload(paramByteBuf, paramInt);
          }
          return decodeUnsubscribePayload(paramByteBuf, paramInt);
        }
        return decodeSubscribePayload(paramByteBuf, paramInt);
      }
      return decodePublishPayload(paramByteBuf, paramInt);
    }
    return decodeConnectionPayload(paramByteBuf, (MqttConnectVariableHeader)paramObject);
  }
  
  private static Result<ByteBuf> decodePublishPayload(ByteBuf paramByteBuf, int paramInt)
  {
    return new Result(paramByteBuf.readRetainedSlice(paramInt), paramInt);
  }
  
  private static Result<MqttPublishVariableHeader> decodePublishVariableHeader(ByteBuf paramByteBuf, MqttFixedHeader paramMqttFixedHeader)
  {
    Result localResult = decodeString(paramByteBuf);
    if (MqttCodecUtil.isValidPublishTopicName((String)localResult.value))
    {
      int i = localResult.numberOfBytesConsumed;
      int j = -1;
      int k = i;
      if (paramMqttFixedHeader.qosLevel().value() > 0)
      {
        paramByteBuf = decodeMessageId(paramByteBuf);
        j = ((Integer)paramByteBuf.value).intValue();
        k = i + paramByteBuf.numberOfBytesConsumed;
      }
      return new Result(new MqttPublishVariableHeader((String)localResult.value, j), k);
    }
    paramByteBuf = new StringBuilder();
    paramByteBuf.append("invalid publish topic name: ");
    paramByteBuf.append((String)localResult.value);
    paramByteBuf.append(" (contains wildcards)");
    throw new DecoderException(paramByteBuf.toString());
  }
  
  private static Result<String> decodeString(ByteBuf paramByteBuf)
  {
    return decodeString(paramByteBuf, 0, Integer.MAX_VALUE);
  }
  
  private static Result<String> decodeString(ByteBuf paramByteBuf, int paramInt1, int paramInt2)
  {
    Object localObject = decodeMsbLsb(paramByteBuf);
    int i = ((Integer)((Result)localObject).value).intValue();
    int j = ((Result)localObject).numberOfBytesConsumed;
    if ((i >= paramInt1) && (i <= paramInt2))
    {
      localObject = paramByteBuf.toString(paramByteBuf.readerIndex(), i, CharsetUtil.UTF_8);
      paramByteBuf.skipBytes(i);
      return new Result(localObject, j + i);
    }
    paramByteBuf.skipBytes(i);
    return new Result(null, j + i);
  }
  
  private static Result<MqttSubAckPayload> decodeSubackPayload(ByteBuf paramByteBuf, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramInt)
    {
      int j = paramByteBuf.readUnsignedByte();
      int k = j;
      if (j != MqttQoS.FAILURE.value()) {
        k = j & 0x3;
      }
      i++;
      localArrayList.add(Integer.valueOf(k));
    }
    return new Result(new MqttSubAckPayload(localArrayList), i);
  }
  
  private static Result<MqttSubscribePayload> decodeSubscribePayload(ByteBuf paramByteBuf, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramInt)
    {
      Result localResult = decodeString(paramByteBuf);
      int j = localResult.numberOfBytesConsumed;
      int k = paramByteBuf.readUnsignedByte();
      i = i + j + 1;
      localArrayList.add(new MqttTopicSubscription((String)localResult.value, MqttQoS.valueOf(k & 0x3)));
    }
    return new Result(new MqttSubscribePayload(localArrayList), i);
  }
  
  private static Result<MqttUnsubscribePayload> decodeUnsubscribePayload(ByteBuf paramByteBuf, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramInt)
    {
      Result localResult = decodeString(paramByteBuf);
      i += localResult.numberOfBytesConsumed;
      localArrayList.add(localResult.value);
    }
    return new Result(new MqttUnsubscribePayload(localArrayList), i);
  }
  
  private static Result<?> decodeVariableHeader(ByteBuf paramByteBuf, MqttFixedHeader paramMqttFixedHeader)
  {
    switch (1.$SwitchMap$io$netty$handler$codec$mqtt$MqttMessageType[paramMqttFixedHeader.messageType().ordinal()])
    {
    default: 
      return new Result(null, 0);
    case 12: 
    case 13: 
    case 14: 
      return new Result(null, 0);
    case 11: 
      return decodePublishVariableHeader(paramByteBuf, paramMqttFixedHeader);
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
      return decodeMessageIdVariableHeader(paramByteBuf);
    case 2: 
      return decodeConnAckVariableHeader(paramByteBuf);
    }
    return decodeConnectionVariableHeader(paramByteBuf);
  }
  
  private MqttMessage invalidMessage(Throwable paramThrowable)
  {
    checkpoint(DecoderState.BAD_MESSAGE);
    return MqttMessageFactory.newInvalidMessage(this.mqttFixedHeader, this.variableHeader, paramThrowable);
  }
  
  protected void decode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, List<Object> paramList)
    throws Exception
  {
    int i = 1.$SwitchMap$io$netty$handler$codec$mqtt$MqttDecoder$DecoderState[((DecoderState)state()).ordinal()];
    if (i != 1)
    {
      if (i == 2) {
        break label85;
      }
      if (i == 3) {
        break label135;
      }
      if (i == 4)
      {
        paramByteBuf.skipBytes(actualReadableBytes());
        break label218;
      }
      throw new Error();
    }
    try
    {
      paramChannelHandlerContext = decodeFixedHeader(paramByteBuf);
      this.mqttFixedHeader = paramChannelHandlerContext;
      this.bytesRemainingInVariablePart = paramChannelHandlerContext.remainingLength();
      checkpoint(DecoderState.READ_VARIABLE_HEADER);
      try
      {
        label85:
        paramChannelHandlerContext = decodeVariableHeader(paramByteBuf, this.mqttFixedHeader);
        this.variableHeader = paramChannelHandlerContext.value;
        i = this.bytesRemainingInVariablePart;
        if (i <= this.maxBytesInMessage)
        {
          this.bytesRemainingInVariablePart = (i - paramChannelHandlerContext.numberOfBytesConsumed);
          checkpoint(DecoderState.READ_PAYLOAD);
          try
          {
            label135:
            paramChannelHandlerContext = decodePayload(paramByteBuf, this.mqttFixedHeader.messageType(), this.bytesRemainingInVariablePart, this.variableHeader);
            i = this.bytesRemainingInVariablePart - paramChannelHandlerContext.numberOfBytesConsumed;
            this.bytesRemainingInVariablePart = i;
            if (i == 0)
            {
              checkpoint(DecoderState.READ_FIXED_HEADER);
              paramChannelHandlerContext = MqttMessageFactory.newMessage(this.mqttFixedHeader, this.variableHeader, paramChannelHandlerContext.value);
              this.mqttFixedHeader = null;
              this.variableHeader = null;
              paramList.add(paramChannelHandlerContext);
              label218:
              return;
            }
            paramChannelHandlerContext = new io/netty/handler/codec/DecoderException;
            paramByteBuf = new java/lang/StringBuilder;
            paramByteBuf.<init>();
            paramByteBuf.append("non-zero remaining payload bytes: ");
            paramByteBuf.append(this.bytesRemainingInVariablePart);
            paramByteBuf.append(" (");
            paramByteBuf.append(this.mqttFixedHeader.messageType());
            paramByteBuf.append(')');
            paramChannelHandlerContext.<init>(paramByteBuf.toString());
            throw paramChannelHandlerContext;
          }
          catch (Exception paramChannelHandlerContext)
          {
            paramList.add(invalidMessage(paramChannelHandlerContext));
            return;
          }
        }
        paramByteBuf = new io/netty/handler/codec/DecoderException;
        paramChannelHandlerContext = new java/lang/StringBuilder;
        paramChannelHandlerContext.<init>();
        paramChannelHandlerContext.append("too large message: ");
        paramChannelHandlerContext.append(this.bytesRemainingInVariablePart);
        paramChannelHandlerContext.append(" bytes");
        paramByteBuf.<init>(paramChannelHandlerContext.toString());
        throw paramByteBuf;
      }
      catch (Exception paramChannelHandlerContext)
      {
        paramList.add(invalidMessage(paramChannelHandlerContext));
        return;
      }
      return;
    }
    catch (Exception paramChannelHandlerContext)
    {
      paramList.add(invalidMessage(paramChannelHandlerContext));
    }
  }
  
  static enum DecoderState
  {
    static
    {
      DecoderState localDecoderState1 = new DecoderState("READ_FIXED_HEADER", 0);
      READ_FIXED_HEADER = localDecoderState1;
      DecoderState localDecoderState2 = new DecoderState("READ_VARIABLE_HEADER", 1);
      READ_VARIABLE_HEADER = localDecoderState2;
      DecoderState localDecoderState3 = new DecoderState("READ_PAYLOAD", 2);
      READ_PAYLOAD = localDecoderState3;
      DecoderState localDecoderState4 = new DecoderState("BAD_MESSAGE", 3);
      BAD_MESSAGE = localDecoderState4;
      $VALUES = new DecoderState[] { localDecoderState1, localDecoderState2, localDecoderState3, localDecoderState4 };
    }
  }
  
  private static final class Result<T>
  {
    private final int numberOfBytesConsumed;
    private final T value;
    
    Result(T paramT, int paramInt)
    {
      this.value = paramT;
      this.numberOfBytesConsumed = paramInt;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\mqtt\MqttDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */