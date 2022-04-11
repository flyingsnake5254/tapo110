package io.netty.handler.codec.socks;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler.a;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

@ChannelHandler.a
public class SocksMessageEncoder
  extends MessageToByteEncoder<SocksMessage>
{
  protected void encode(ChannelHandlerContext paramChannelHandlerContext, SocksMessage paramSocksMessage, ByteBuf paramByteBuf)
    throws Exception
  {
    paramSocksMessage.encodeAsByteBuf(paramByteBuf);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\socks\SocksMessageEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */