package io.netty.handler.codec.socksx.v5;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandler.a;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.EncoderException;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.handler.codec.socksx.SocksMessage;
import io.netty.handler.codec.socksx.SocksVersion;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

@ChannelHandler.a
public class Socks5ClientEncoder
  extends MessageToByteEncoder<a>
{
  public static final Socks5ClientEncoder DEFAULT = new Socks5ClientEncoder();
  private final Socks5AddressEncoder addressEncoder;
  
  protected Socks5ClientEncoder()
  {
    this(Socks5AddressEncoder.DEFAULT);
  }
  
  public Socks5ClientEncoder(Socks5AddressEncoder paramSocks5AddressEncoder)
  {
    this.addressEncoder = ((Socks5AddressEncoder)ObjectUtil.checkNotNull(paramSocks5AddressEncoder, "addressEncoder"));
  }
  
  private static void encodeAuthMethodRequest(Socks5InitialRequest paramSocks5InitialRequest, ByteBuf paramByteBuf)
  {
    paramByteBuf.writeByte(paramSocks5InitialRequest.version().byteValue());
    paramSocks5InitialRequest = paramSocks5InitialRequest.authMethods();
    int i = paramSocks5InitialRequest.size();
    paramByteBuf.writeByte(i);
    if ((paramSocks5InitialRequest instanceof RandomAccess)) {
      for (int j = 0; j < i; j++) {
        paramByteBuf.writeByte(((Socks5AuthMethod)paramSocks5InitialRequest.get(j)).byteValue());
      }
    }
    paramSocks5InitialRequest = paramSocks5InitialRequest.iterator();
    while (paramSocks5InitialRequest.hasNext()) {
      paramByteBuf.writeByte(((Socks5AuthMethod)paramSocks5InitialRequest.next()).byteValue());
    }
  }
  
  private void encodeCommandRequest(Socks5CommandRequest paramSocks5CommandRequest, ByteBuf paramByteBuf)
    throws Exception
  {
    paramByteBuf.writeByte(paramSocks5CommandRequest.version().byteValue());
    paramByteBuf.writeByte(paramSocks5CommandRequest.type().byteValue());
    paramByteBuf.writeByte(0);
    Socks5AddressType localSocks5AddressType = paramSocks5CommandRequest.dstAddrType();
    paramByteBuf.writeByte(localSocks5AddressType.byteValue());
    this.addressEncoder.encodeAddress(localSocks5AddressType, paramSocks5CommandRequest.dstAddr(), paramByteBuf);
    paramByteBuf.writeShort(paramSocks5CommandRequest.dstPort());
  }
  
  private static void encodePasswordAuthRequest(Socks5PasswordAuthRequest paramSocks5PasswordAuthRequest, ByteBuf paramByteBuf)
  {
    paramByteBuf.writeByte(1);
    String str = paramSocks5PasswordAuthRequest.username();
    paramByteBuf.writeByte(str.length());
    ByteBufUtil.writeAscii(paramByteBuf, str);
    paramSocks5PasswordAuthRequest = paramSocks5PasswordAuthRequest.password();
    paramByteBuf.writeByte(paramSocks5PasswordAuthRequest.length());
    ByteBufUtil.writeAscii(paramByteBuf, paramSocks5PasswordAuthRequest);
  }
  
  protected final Socks5AddressEncoder addressEncoder()
  {
    return this.addressEncoder;
  }
  
  protected void encode(ChannelHandlerContext paramChannelHandlerContext, a parama, ByteBuf paramByteBuf)
    throws Exception
  {
    if ((parama instanceof Socks5InitialRequest))
    {
      encodeAuthMethodRequest((Socks5InitialRequest)parama, paramByteBuf);
    }
    else if ((parama instanceof Socks5PasswordAuthRequest))
    {
      encodePasswordAuthRequest((Socks5PasswordAuthRequest)parama, paramByteBuf);
    }
    else
    {
      if (!(parama instanceof Socks5CommandRequest)) {
        break label53;
      }
      encodeCommandRequest((Socks5CommandRequest)parama, paramByteBuf);
    }
    return;
    label53:
    paramChannelHandlerContext = new StringBuilder();
    paramChannelHandlerContext.append("unsupported message type: ");
    paramChannelHandlerContext.append(StringUtil.simpleClassName(parama));
    throw new EncoderException(paramChannelHandlerContext.toString());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\socksx\v5\Socks5ClientEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */