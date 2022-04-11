package io.netty.handler.codec.socksx.v4;

import io.netty.handler.codec.socksx.SocksMessage;

public abstract interface Socks4CommandResponse
  extends SocksMessage
{
  public abstract String dstAddr();
  
  public abstract int dstPort();
  
  public abstract Socks4CommandStatus status();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\socksx\v4\Socks4CommandResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */