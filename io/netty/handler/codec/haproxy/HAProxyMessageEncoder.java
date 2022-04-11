package io.netty.handler.codec.haproxy;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.DefaultByteBufHolder;
import io.netty.channel.ChannelHandler.a;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.util.CharsetUtil;
import io.netty.util.NetUtil;
import java.nio.charset.Charset;
import java.util.List;

@ChannelHandler.a
public final class HAProxyMessageEncoder
  extends MessageToByteEncoder<HAProxyMessage>
{
  public static final HAProxyMessageEncoder INSTANCE = new HAProxyMessageEncoder();
  static final int TOTAL_UNIX_ADDRESS_BYTES_LENGTH = 216;
  static final int UNIX_ADDRESS_BYTES_LENGTH = 108;
  private static final int V2_VERSION_BITMASK = 32;
  
  private static void encodeTlv(HAProxyTLV paramHAProxyTLV, ByteBuf paramByteBuf)
  {
    if ((paramHAProxyTLV instanceof HAProxySSLTLV))
    {
      HAProxySSLTLV localHAProxySSLTLV = (HAProxySSLTLV)paramHAProxyTLV;
      paramByteBuf.writeByte(paramHAProxyTLV.typeByteValue());
      paramByteBuf.writeShort(localHAProxySSLTLV.contentNumBytes());
      paramByteBuf.writeByte(localHAProxySSLTLV.client());
      paramByteBuf.writeInt(localHAProxySSLTLV.verify());
      encodeTlvs(localHAProxySSLTLV.encapsulatedTLVs(), paramByteBuf);
    }
    else
    {
      paramByteBuf.writeByte(paramHAProxyTLV.typeByteValue());
      paramHAProxyTLV = paramHAProxyTLV.content();
      int i = paramHAProxyTLV.readableBytes();
      paramByteBuf.writeShort(i);
      paramByteBuf.writeBytes(paramHAProxyTLV.readSlice(i));
    }
  }
  
  private static void encodeTlvs(List<HAProxyTLV> paramList, ByteBuf paramByteBuf)
  {
    for (int i = 0; i < paramList.size(); i++) {
      encodeTlv((HAProxyTLV)paramList.get(i), paramByteBuf);
    }
  }
  
  private static void encodeV1(HAProxyMessage paramHAProxyMessage, ByteBuf paramByteBuf)
  {
    paramByteBuf.writeBytes(HAProxyConstants.TEXT_PREFIX);
    paramByteBuf.writeByte(32);
    String str = paramHAProxyMessage.proxiedProtocol().name();
    Charset localCharset = CharsetUtil.US_ASCII;
    paramByteBuf.writeCharSequence(str, localCharset);
    paramByteBuf.writeByte(32);
    paramByteBuf.writeCharSequence(paramHAProxyMessage.sourceAddress(), localCharset);
    paramByteBuf.writeByte(32);
    paramByteBuf.writeCharSequence(paramHAProxyMessage.destinationAddress(), localCharset);
    paramByteBuf.writeByte(32);
    paramByteBuf.writeCharSequence(String.valueOf(paramHAProxyMessage.sourcePort()), localCharset);
    paramByteBuf.writeByte(32);
    paramByteBuf.writeCharSequence(String.valueOf(paramHAProxyMessage.destinationPort()), localCharset);
    paramByteBuf.writeByte(13);
    paramByteBuf.writeByte(10);
  }
  
  private static void encodeV2(HAProxyMessage paramHAProxyMessage, ByteBuf paramByteBuf)
  {
    paramByteBuf.writeBytes(HAProxyConstants.BINARY_PREFIX);
    paramByteBuf.writeByte(paramHAProxyMessage.command().byteValue() | 0x20);
    paramByteBuf.writeByte(paramHAProxyMessage.proxiedProtocol().byteValue());
    int i = 1.$SwitchMap$io$netty$handler$codec$haproxy$HAProxyProxiedProtocol$AddressFamily[paramHAProxyMessage.proxiedProtocol().addressFamily().ordinal()];
    Object localObject1;
    Object localObject2;
    if ((i != 1) && (i != 2))
    {
      if (i != 3)
      {
        if (i == 4) {
          paramByteBuf.writeShort(0);
        } else {
          throw new HAProxyProtocolException("unexpected addrFamily");
        }
      }
      else
      {
        paramByteBuf.writeShort(paramHAProxyMessage.tlvNumBytes() + 216);
        localObject1 = paramHAProxyMessage.sourceAddress();
        localObject2 = CharsetUtil.US_ASCII;
        paramByteBuf.writeZero(108 - paramByteBuf.writeCharSequence((CharSequence)localObject1, (Charset)localObject2));
        paramByteBuf.writeZero(108 - paramByteBuf.writeCharSequence(paramHAProxyMessage.destinationAddress(), (Charset)localObject2));
        encodeTlvs(paramHAProxyMessage.tlvs(), paramByteBuf);
      }
    }
    else
    {
      localObject2 = NetUtil.createByteArrayFromIpAddressString(paramHAProxyMessage.sourceAddress());
      localObject1 = NetUtil.createByteArrayFromIpAddressString(paramHAProxyMessage.destinationAddress());
      paramByteBuf.writeShort(localObject2.length + localObject1.length + 4 + paramHAProxyMessage.tlvNumBytes());
      paramByteBuf.writeBytes((byte[])localObject2);
      paramByteBuf.writeBytes((byte[])localObject1);
      paramByteBuf.writeShort(paramHAProxyMessage.sourcePort());
      paramByteBuf.writeShort(paramHAProxyMessage.destinationPort());
      encodeTlvs(paramHAProxyMessage.tlvs(), paramByteBuf);
    }
  }
  
  protected void encode(ChannelHandlerContext paramChannelHandlerContext, HAProxyMessage paramHAProxyMessage, ByteBuf paramByteBuf)
    throws Exception
  {
    int i = 1.$SwitchMap$io$netty$handler$codec$haproxy$HAProxyProtocolVersion[paramHAProxyMessage.protocolVersion().ordinal()];
    if (i != 1)
    {
      if (i == 2)
      {
        encodeV2(paramHAProxyMessage, paramByteBuf);
      }
      else
      {
        paramChannelHandlerContext = new StringBuilder();
        paramChannelHandlerContext.append("Unsupported version: ");
        paramChannelHandlerContext.append(paramHAProxyMessage.protocolVersion());
        throw new HAProxyProtocolException(paramChannelHandlerContext.toString());
      }
    }
    else {
      encodeV1(paramHAProxyMessage, paramByteBuf);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\haproxy\HAProxyMessageEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */