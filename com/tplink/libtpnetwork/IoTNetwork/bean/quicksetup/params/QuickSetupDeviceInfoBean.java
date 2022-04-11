package com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params;

import com.google.gson.q.b;
import com.tplink.libtpnetwork.IoTNetwork.util.Base64TypeAdapter;
import java.io.Serializable;

public class QuickSetupDeviceInfoBean
  implements Serializable
{
  private String avatar;
  private String location;
  @b(Base64TypeAdapter.class)
  private String nickname;
  
  public QuickSetupDeviceInfoBean() {}
  
  public QuickSetupDeviceInfoBean(String paramString1, String paramString2)
  {
    this.nickname = paramString1;
    this.avatar = paramString2;
  }
  
  public String getAvatar()
  {
    return this.avatar;
  }
  
  public String getLocation()
  {
    return this.location;
  }
  
  public String getNickname()
  {
    return this.nickname;
  }
  
  public void setAvatar(String paramString)
  {
    this.avatar = paramString;
  }
  
  public void setLocation(String paramString)
  {
    this.location = paramString;
  }
  
  public void setNickname(String paramString)
  {
    this.nickname = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\quicksetup\params\QuickSetupDeviceInfoBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */