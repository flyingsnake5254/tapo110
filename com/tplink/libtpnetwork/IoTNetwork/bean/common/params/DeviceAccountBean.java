package com.tplink.libtpnetwork.IoTNetwork.bean.common.params;

import com.google.gson.q.b;
import com.tplink.libtpnetwork.IoTNetwork.util.Base64TypeAdapter;

public class DeviceAccountBean
{
  @b(Base64TypeAdapter.class)
  private String password;
  @b(Base64TypeAdapter.class)
  private String username;
  
  public DeviceAccountBean() {}
  
  public DeviceAccountBean(String paramString1, String paramString2)
  {
    this.username = paramString1;
    this.password = paramString2;
  }
  
  public String getPassword()
  {
    return this.password;
  }
  
  public String getUsername()
  {
    return this.username;
  }
  
  public void setPassword(String paramString)
  {
    this.password = paramString;
  }
  
  public void setUsername(String paramString)
  {
    this.username = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\common\params\DeviceAccountBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */