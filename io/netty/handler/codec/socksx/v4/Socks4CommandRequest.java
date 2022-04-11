package io.netty.handler.codec.socksx.v4;

import io.netty.handler.codec.socksx.SocksMessage;

public abstract interface Socks4CommandRequest
  extends SocksMessage
{
  public abstract String dstAddr();
  
  public abstract int dstPort();
  
  public abstract Socks4CommandType type();
  
  public abstract String userId();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\socksx\v4\Socks4CommandRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */