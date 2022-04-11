package com.tplink.libtpnetwork.TDPNetwork.bean.camera;

import com.google.gson.q.c;

public class TDPCameraDiscoverRequest
{
  @c("params")
  private Param param;
  
  public TDPCameraDiscoverRequest(String paramString)
  {
    this.param = new Param(paramString);
  }
  
  public static class Param
  {
    @c("rsa_key")
    private String rsaKey;
    
    Param(String paramString)
    {
      this.rsaKey = paramString;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\TDPNetwork\bean\camera\TDPCameraDiscoverRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */