package io.netty.handler.codec.socksx.v4;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler.a;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.util.NetUtil;

@ChannelHandler.a
public final class Socks4ServerEncoder
  extends MessageToByteEncoder<Socks4CommandResponse>
{
  public static final Socks4ServerEncoder INSTANCE = new Socks4ServerEncoder();
  private static final byte[] IPv4_HOSTNAME_ZEROED = { 0, 0, 0, 0 };
  
  protected void encode(ChannelHandlerContext paramChannelHandlerContext, Socks4CommandResponse paramSocks4CommandResponse, ByteBuf paramByteBuf)
    throws Exception
  {
    paramByteBuf.writeByte(0);
    paramByteBuf.writeByte(paramSocks4CommandResponse.status().byteValue());
    paramByteBuf.writeShort(paramSocks4CommandResponse.dstPort());
    if (paramSocks4CommandResponse.dstAddr() == null) {
      paramChannelHandlerContext = IPv4_HOSTNAME_ZEROED;
    } else {
      paramChannelHandlerContext = NetUtil.createByteArrayFromIpAddressString(paramSocks4CommandResponse.dstAddr());
    }
    paramByteBuf.writeBytes(paramChannelHandlerContext);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\socksx\v4\Socks4ServerEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */