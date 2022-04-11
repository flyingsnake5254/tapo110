package io.netty.handler.codec.socks;

import io.netty.buffer.ByteBuf;
import io.netty.util.internal.ObjectUtil;

public final class SocksAuthResponse
  extends SocksResponse
{
  private static final SocksSubnegotiationVersion SUBNEGOTIATION_VERSION = SocksSubnegotiationVersion.AUTH_PASSWORD;
  private final SocksAuthStatus authStatus;
  
  public SocksAuthResponse(SocksAuthStatus paramSocksAuthStatus)
  {
    super(SocksResponseType.AUTH);
    this.authStatus = ((SocksAuthStatus)ObjectUtil.checkNotNull(paramSocksAuthStatus, "authStatus"));
  }
  
  public SocksAuthStatus authStatus()
  {
    return this.authStatus;
  }
  
  public void encodeAsByteBuf(ByteBuf paramByteBuf)
  {
    paramByteBuf.writeByte(SUBNEGOTIATION_VERSION.byteValue());
    paramByteBuf.writeByte(this.authStatus.byteValue());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\socks\SocksAuthResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */