package io.netty.handler.codec.socks;

import io.netty.buffer.ByteBuf;
import io.netty.util.internal.ObjectUtil;

public abstract class SocksMessage
{
  private final SocksProtocolVersion protocolVersion = SocksProtocolVersion.SOCKS5;
  private final SocksMessageType type;
  
  protected SocksMessage(SocksMessageType paramSocksMessageType)
  {
    this.type = ((SocksMessageType)ObjectUtil.checkNotNull(paramSocksMessageType, "type"));
  }
  
  @Deprecated
  public abstract void encodeAsByteBuf(ByteBuf paramByteBuf);
  
  public SocksProtocolVersion protocolVersion()
  {
    return this.protocolVersion;
  }
  
  public SocksMessageType type()
  {
    return this.type;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\socks\SocksMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */