package com.tplink.libtpnetwork.IoTNetwork.transport.http.bean.handshake;

import androidx.annotation.Keep;

@Keep
public class HandShakeRequest
{
  private String key;
  
  public String getKey()
  {
    return this.key;
  }
  
  public void setKey(String paramString)
  {
    this.key = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\transport\http\bean\handshake\HandShakeRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */