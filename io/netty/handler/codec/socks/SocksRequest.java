package io.netty.handler.codec.socks;

import io.netty.util.internal.ObjectUtil;

public abstract class SocksRequest
  extends SocksMessage
{
  private final SocksRequestType requestType;
  
  protected SocksRequest(SocksRequestType paramSocksRequestType)
  {
    super(SocksMessageType.REQUEST);
    this.requestType = ((SocksRequestType)ObjectUtil.checkNotNull(paramSocksRequestType, "requestType"));
  }
  
  public SocksRequestType requestType()
  {
    return this.requestType;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\socks\SocksRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */