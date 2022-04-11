package io.netty.handler.codec.socksx.v5;

public abstract interface Socks5CommandRequest
  extends a
{
  public abstract String dstAddr();
  
  public abstract Socks5AddressType dstAddrType();
  
  public abstract int dstPort();
  
  public abstract Socks5CommandType type();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\socksx\v5\Socks5CommandRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */