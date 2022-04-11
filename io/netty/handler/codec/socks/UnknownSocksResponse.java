package io.netty.handler.codec.socks;

import io.netty.buffer.ByteBuf;

public final class UnknownSocksResponse
  extends SocksResponse
{
  public UnknownSocksResponse()
  {
    super(SocksResponseType.UNKNOWN);
  }
  
  public void encodeAsByteBuf(ByteBuf paramByteBuf) {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\socks\UnknownSocksResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */