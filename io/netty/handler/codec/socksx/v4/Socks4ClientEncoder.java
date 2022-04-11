package io.netty.handler.codec.socksx.v4;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandler.a;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.handler.codec.socksx.SocksMessage;
import io.netty.handler.codec.socksx.SocksVersion;
import io.netty.util.NetUtil;

@ChannelHandler.a
public final class Socks4ClientEncoder
  extends MessageToByteEncoder<Socks4CommandRequest>
{
  public static final Socks4ClientEncoder INSTANCE = new Socks4ClientEncoder();
  private static final byte[] IPv4_DOMAIN_MARKER = { 0, 0, 0, 1 };
  
  protected void encode(ChannelHandlerContext paramChannelHandlerContext, Socks4CommandRequest paramSocks4CommandRequest, ByteBuf paramByteBuf)
    throws Exception
  {
    paramByteBuf.writeByte(paramSocks4CommandRequest.version().byteValue());
    paramByteBuf.writeByte(paramSocks4CommandRequest.type().byteValue());
    paramByteBuf.writeShort(paramSocks4CommandRequest.dstPort());
    if (NetUtil.isValidIpV4Address(paramSocks4CommandRequest.dstAddr()))
    {
      paramByteBuf.writeBytes(NetUtil.createByteArrayFromIpAddressString(paramSocks4CommandRequest.dstAddr()));
      ByteBufUtil.writeAscii(paramByteBuf, paramSocks4CommandRequest.userId());
      paramByteBuf.writeByte(0);
    }
    else
    {
      paramByteBuf.writeBytes(IPv4_DOMAIN_MARKER);
      ByteBufUtil.writeAscii(paramByteBuf, paramSocks4CommandRequest.userId());
      paramByteBuf.writeByte(0);
      ByteBufUtil.writeAscii(paramByteBuf, paramSocks4CommandRequest.dstAddr());
      paramByteBuf.writeByte(0);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\socksx\v4\Socks4ClientEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */