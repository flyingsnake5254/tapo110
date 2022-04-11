package com.tplink.iot.adapter.quicksetup;

import com.tplink.iot.model.iot.EnumDeviceNicknameType;
import java.io.Serializable;

public class SelectLocationBean
  implements Serializable
{
  private boolean isSelect;
  private EnumDeviceNicknameType location;
  
  public SelectLocationBean(EnumDeviceNicknameType paramEnumDeviceNicknameType)
  {
    this.location = paramEnumDeviceNicknameType;
  }
  
  public EnumDeviceNicknameType getLocation()
  {
    return this.location;
  }
  
  public boolean isSelect()
  {
    return this.isSelect;
  }
  
  public void setLocation(EnumDeviceNicknameType paramEnumDeviceNicknameType)
  {
    this.location = paramEnumDeviceNicknameType;
  }
  
  public void setSelect(boolean paramBoolean)
  {
    this.isSelect = paramBoolean;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\quicksetup\SelectLocationBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */