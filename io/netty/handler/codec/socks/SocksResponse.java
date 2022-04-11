package io.netty.handler.codec.socks;

import io.netty.util.internal.ObjectUtil;

public abstract class SocksResponse
  extends SocksMessage
{
  private final SocksResponseType responseType;
  
  protected SocksResponse(SocksResponseType paramSocksResponseType)
  {
    super(SocksMessageType.RESPONSE);
    this.responseType = ((SocksResponseType)ObjectUtil.checkNotNull(paramSocksResponseType, "responseType"));
  }
  
  public SocksResponseType responseType()
  {
    return this.responseType;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\socks\SocksResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */