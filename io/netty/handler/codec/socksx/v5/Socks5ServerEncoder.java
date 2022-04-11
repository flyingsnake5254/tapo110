package io.netty.handler.codec.socksx.v5;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler.a;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.EncoderException;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.handler.codec.socksx.SocksMessage;
import io.netty.handler.codec.socksx.SocksVersion;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

@ChannelHandler.a
public class Socks5ServerEncoder
  extends MessageToByteEncoder<a>
{
  public static final Socks5ServerEncoder DEFAULT = new Socks5ServerEncoder(Socks5AddressEncoder.DEFAULT);
  private final Socks5AddressEncoder addressEncoder;
  
  protected Socks5ServerEncoder()
  {
    this(Socks5AddressEncoder.DEFAULT);
  }
  
  public Socks5ServerEncoder(Socks5AddressEncoder paramSocks5AddressEncoder)
  {
    this.addressEncoder = ((Socks5AddressEncoder)ObjectUtil.checkNotNull(paramSocks5AddressEncoder, "addressEncoder"));
  }
  
  private static void encodeAuthMethodResponse(Socks5InitialResponse paramSocks5InitialResponse, ByteBuf paramByteBuf)
  {
    paramByteBuf.writeByte(paramSocks5InitialResponse.version().byteValue());
    paramByteBuf.writeByte(paramSocks5InitialResponse.authMethod().byteValue());
  }
  
  private void encodeCommandResponse(Socks5CommandResponse paramSocks5CommandResponse, ByteBuf paramByteBuf)
    throws Exception
  {
    paramByteBuf.writeByte(paramSocks5CommandResponse.version().byteValue());
    paramByteBuf.writeByte(paramSocks5CommandResponse.status().byteValue());
    paramByteBuf.writeByte(0);
    Socks5AddressType localSocks5AddressType = paramSocks5CommandResponse.bndAddrType();
    paramByteBuf.writeByte(localSocks5AddressType.byteValue());
    this.addressEncoder.encodeAddress(localSocks5AddressType, paramSocks5CommandResponse.bndAddr(), paramByteBuf);
    paramByteBuf.writeShort(paramSocks5CommandResponse.bndPort());
  }
  
  private static void encodePasswordAuthResponse(Socks5PasswordAuthResponse paramSocks5PasswordAuthResponse, ByteBuf paramByteBuf)
  {
    paramByteBuf.writeByte(1);
    paramByteBuf.writeByte(paramSocks5PasswordAuthResponse.status().byteValue());
  }
  
  protected final Socks5AddressEncoder addressEncoder()
  {
    return this.addressEncoder;
  }
  
  protected void encode(ChannelHandlerContext paramChannelHandlerContext, a parama, ByteBuf paramByteBuf)
    throws Exception
  {
    if ((parama instanceof Socks5InitialResponse))
    {
      encodeAuthMethodResponse((Socks5InitialResponse)parama, paramByteBuf);
    }
    else if ((parama instanceof Socks5PasswordAuthResponse))
    {
      encodePasswordAuthResponse((Socks5PasswordAuthResponse)parama, paramByteBuf);
    }
    else
    {
      if (!(parama instanceof Socks5CommandResponse)) {
        break label53;
      }
      encodeCommandResponse((Socks5CommandResponse)parama, paramByteBuf);
    }
    return;
    label53:
    paramChannelHandlerContext = new StringBuilder();
    paramChannelHandlerContext.append("unsupported message type: ");
    paramChannelHandlerContext.append(StringUtil.simpleClassName(parama));
    throw new EncoderException(paramChannelHandlerContext.toString());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\socksx\v5\Socks5ServerEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */