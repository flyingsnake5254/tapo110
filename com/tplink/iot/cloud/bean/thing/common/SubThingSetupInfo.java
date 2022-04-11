package com.tplink.iot.cloud.bean.thing.common;

import com.google.gson.q.b;
import com.google.gson.q.c;
import com.tplink.iot.cloud.bean.common.Base64TypeAdapter;

public class SubThingSetupInfo
{
  private String avatar;
  private String category;
  @c("device_id")
  private String deviceId;
  @c("device_model")
  private String deviceModel;
  @b(Base64TypeAdapter.class)
  private String name;
  
  public String getAvatar()
  {
    return this.avatar;
  }
  
  public String getCategory()
  {
    return this.category;
  }
  
  public String getDeviceId()
  {
    return this.deviceId;
  }
  
  public String getDeviceModel()
  {
    return this.deviceModel;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public void setAvatar(String paramString)
  {
    this.avatar = paramString;
  }
  
  public void setCategory(String paramString)
  {
    this.category = paramString;
  }
  
  public void setDeviceId(String paramString)
  {
    this.deviceId = paramString;
  }
  
  public void setDeviceModel(String paramString)
  {
    this.deviceModel = paramString;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\thing\common\SubThingSetupInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */