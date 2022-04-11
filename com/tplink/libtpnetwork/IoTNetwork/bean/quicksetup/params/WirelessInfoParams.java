package com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params;

import com.google.gson.q.b;
import com.google.gson.q.c;
import com.tplink.libtpnetwork.IoTNetwork.util.Base64TypeAdapter;
import java.io.Serializable;

public class WirelessInfoParams
  implements Serializable
{
  @c("key_type")
  private String keyType;
  @b(Base64TypeAdapter.class)
  private String password;
  @b(Base64TypeAdapter.class)
  private String ssid;
  
  public WirelessInfoParams() {}
  
  public WirelessInfoParams(String paramString1, String paramString2)
  {
    this.ssid = paramString1;
    this.keyType = paramString2;
  }
  
  public WirelessInfoParams(String paramString1, String paramString2, String paramString3)
  {
    this.ssid = paramString1;
    this.password = paramString2;
    this.keyType = paramString3;
  }
  
  public String getKeyType()
  {
    return this.keyType;
  }
  
  public String getPassword()
  {
    return this.password;
  }
  
  public String getSsid()
  {
    return this.ssid;
  }
  
  public void setKeyType(String paramString)
  {
    this.keyType = paramString;
  }
  
  public void setPassword(String paramString)
  {
    this.password = paramString;
  }
  
  public void setSsid(String paramString)
  {
    this.ssid = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\quicksetup\params\WirelessInfoParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */