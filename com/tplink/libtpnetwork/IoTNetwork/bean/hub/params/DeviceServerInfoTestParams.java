package com.tplink.libtpnetwork.IoTNetwork.bean.hub.params;

import com.google.gson.q.c;

public class DeviceServerInfoTestParams
{
  @c("server_type")
  private String serverType;
  
  public DeviceServerInfoTestParams() {}
  
  public DeviceServerInfoTestParams(String paramString)
  {
    this.serverType = paramString;
  }
  
  public String getServerType()
  {
    return this.serverType;
  }
  
  public void setServerType(String paramString)
  {
    this.serverType = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\hub\params\DeviceServerInfoTestParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */