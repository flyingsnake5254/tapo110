package com.tplink.libtpnetwork.IoTNetwork.bean.common.params;

import com.google.gson.q.b;
import com.google.gson.q.c;
import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.iot.cloud.bean.thing.common.ThingSetting;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DefaultStatesBean;
import com.tplink.libtpnetwork.IoTNetwork.util.Base64TypeAdapter;
import java.util.HashMap;
import java.util.Map;

public class DeviceInfoParams
{
  private String avatar;
  @c("default_states")
  private DefaultStatesBean defaultStates;
  @c("device_on")
  private Boolean deviceOn;
  private Integer latitude;
  @Deprecated
  private String location;
  private Integer longitude;
  @b(Base64TypeAdapter.class)
  private String nickname;
  
  public DeviceInfoParams() {}
  
  public DeviceInfoParams(Integer paramInteger1, Integer paramInteger2)
  {
    this.longitude = paramInteger1;
    this.latitude = paramInteger2;
  }
  
  public DeviceInfoParams(String paramString1, String paramString2)
  {
    this.nickname = paramString1;
    this.avatar = paramString2;
  }
  
  public String getAvatar()
  {
    return this.avatar;
  }
  
  public DefaultStatesBean getDefaultStates()
  {
    return this.defaultStates;
  }
  
  public Boolean getDeviceOn()
  {
    return this.deviceOn;
  }
  
  public Integer getLatitude()
  {
    return this.latitude;
  }
  
  public String getLocation()
  {
    return this.location;
  }
  
  public Integer getLongitude()
  {
    return this.longitude;
  }
  
  public String getNickname()
  {
    return this.nickname;
  }
  
  public boolean isMatchThingModel(ThingModel paramThingModel)
  {
    boolean bool = false;
    if (paramThingModel == null) {
      return false;
    }
    if (paramThingModel.getThingProperty("on") != null) {
      bool = true;
    }
    return bool;
  }
  
  public void setAvatar(String paramString)
  {
    this.avatar = paramString;
  }
  
  public void setDefaultStates(DefaultStatesBean paramDefaultStatesBean)
  {
    this.defaultStates = paramDefaultStatesBean;
  }
  
  public void setDeviceOn(Boolean paramBoolean)
  {
    this.deviceOn = paramBoolean;
  }
  
  public void setLatitude(Integer paramInteger)
  {
    this.latitude = paramInteger;
  }
  
  public void setLocation(String paramString)
  {
    this.location = paramString;
  }
  
  public void setLongitude(Integer paramInteger)
  {
    this.longitude = paramInteger;
  }
  
  public void setNickname(String paramString)
  {
    this.nickname = paramString;
  }
  
  public Map<String, Object> toMap()
  {
    return toMap(null);
  }
  
  public Map<String, Object> toMap(Map<String, Object> paramMap)
  {
    if (paramMap == null) {
      paramMap = new HashMap();
    } else {
      paramMap = new HashMap(paramMap);
    }
    Boolean localBoolean = this.deviceOn;
    if (localBoolean != null) {
      paramMap.put("on", localBoolean);
    }
    return paramMap;
  }
  
  public ThingSetting toThingSetting()
  {
    ThingSetting localThingSetting = new ThingSetting();
    localThingSetting.setNickname(this.nickname);
    localThingSetting.setAvatarUrl(this.avatar);
    localThingSetting.setLongitude(this.longitude);
    localThingSetting.setLatitude(this.latitude);
    return localThingSetting;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\common\params\DeviceInfoParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */