package com.tplink.cloud.bean.share.params;

import java.util.List;

public class DeviceShareActionListParams
{
  private List<DeviceShareActionParams> shareList;
  
  public DeviceShareActionListParams() {}
  
  public DeviceShareActionListParams(List<DeviceShareActionParams> paramList)
  {
    this.shareList = paramList;
  }
  
  public List<DeviceShareActionParams> getShareList()
  {
    return this.shareList;
  }
  
  public void setShareList(List<DeviceShareActionParams> paramList)
  {
    this.shareList = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\share\params\DeviceShareActionListParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */