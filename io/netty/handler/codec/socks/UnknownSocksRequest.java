package io.netty.handler.codec.socks;

import io.netty.buffer.ByteBuf;

public final class UnknownSocksRequest
  extends SocksRequest
{
  public UnknownSocksRequest()
  {
    super(SocksRequestType.UNKNOWN);
  }
  
  public void encodeAsByteBuf(ByteBuf paramByteBuf) {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\socks\UnknownSocksRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */