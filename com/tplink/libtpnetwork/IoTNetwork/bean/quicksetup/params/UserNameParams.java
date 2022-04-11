package com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params;

import com.google.gson.q.b;
import com.tplink.libtpnetwork.IoTNetwork.util.Base64TypeAdapter;

public class UserNameParams
{
  @b(Base64TypeAdapter.class)
  private String username;
  
  public UserNameParams(String paramString)
  {
    this.username = paramString;
  }
  
  public String getUsername()
  {
    return this.username;
  }
  
  public void setUsername(String paramString)
  {
    this.username = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\quicksetup\params\UserNameParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */