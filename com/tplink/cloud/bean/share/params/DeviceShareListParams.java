package com.tplink.cloud.bean.share.params;

import java.util.List;

public class DeviceShareListParams
{
  private List<DeviceShareParams> shareList;
  
  public DeviceShareListParams() {}
  
  public DeviceShareListParams(List<DeviceShareParams> paramList)
  {
    this.shareList = paramList;
  }
  
  public List<DeviceShareParams> getShareList()
  {
    return this.shareList;
  }
  
  public void setShareList(List<DeviceShareParams> paramList)
  {
    this.shareList = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\share\params\DeviceShareListParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */