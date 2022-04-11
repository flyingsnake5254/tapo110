package com.tplink.cloud.bean.share.params;

import com.tplink.cloud.bean.share.EnumDeviceShareAction;

public class DeviceShareActionParams
{
  private EnumDeviceShareAction action;
  private String shareId;
  
  public DeviceShareActionParams() {}
  
  public DeviceShareActionParams(String paramString, EnumDeviceShareAction paramEnumDeviceShareAction)
  {
    this.shareId = paramString;
    this.action = paramEnumDeviceShareAction;
  }
  
  public EnumDeviceShareAction getAction()
  {
    return this.action;
  }
  
  public String getShareId()
  {
    return this.shareId;
  }
  
  public void setAction(EnumDeviceShareAction paramEnumDeviceShareAction)
  {
    this.action = paramEnumDeviceShareAction;
  }
  
  public void setShareId(String paramString)
  {
    this.shareId = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\share\params\DeviceShareActionParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */