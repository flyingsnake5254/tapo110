package io.netty.handler.codec.socksx.v5;

public abstract interface Socks5CommandResponse
  extends a
{
  public abstract String bndAddr();
  
  public abstract Socks5AddressType bndAddrType();
  
  public abstract int bndPort();
  
  public abstract Socks5CommandStatus status();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\socksx\v5\Socks5CommandResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */