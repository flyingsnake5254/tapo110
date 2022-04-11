package io.netty.handler.codec.socks;

import io.netty.buffer.ByteBuf;
import io.netty.util.internal.ObjectUtil;

public final class SocksInitResponse
  extends SocksResponse
{
  private final SocksAuthScheme authScheme;
  
  public SocksInitResponse(SocksAuthScheme paramSocksAuthScheme)
  {
    super(SocksResponseType.INIT);
    this.authScheme = ((SocksAuthScheme)ObjectUtil.checkNotNull(paramSocksAuthScheme, "authScheme"));
  }
  
  public SocksAuthScheme authScheme()
  {
    return this.authScheme;
  }
  
  public void encodeAsByteBuf(ByteBuf paramByteBuf)
  {
    paramByteBuf.writeByte(protocolVersion().byteValue());
    paramByteBuf.writeByte(this.authScheme.byteValue());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\socks\SocksInitResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */