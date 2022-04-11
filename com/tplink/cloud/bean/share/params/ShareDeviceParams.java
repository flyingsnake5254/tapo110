package com.tplink.cloud.bean.share.params;

import com.tplink.cloud.bean.share.EnumDeviceShareRole;
import com.tplink.cloud.bean.share.EnumDeviceShareStatus;
import java.util.List;

public class ShareDeviceParams
{
  private List<String> deviceTypeList;
  private int index;
  private int limit;
  private EnumDeviceShareRole shareRole;
  private EnumDeviceShareStatus shareStatus;
  
  public List<String> getDeviceTypeList()
  {
    return this.deviceTypeList;
  }
  
  public int getIndex()
  {
    return this.index;
  }
  
  public int getLimit()
  {
    return this.limit;
  }
  
  public EnumDeviceShareRole getShareRole()
  {
    return this.shareRole;
  }
  
  public EnumDeviceShareStatus getShareStatus()
  {
    return this.shareStatus;
  }
  
  public void setDeviceTypeList(List<String> paramList)
  {
    this.deviceTypeList = paramList;
  }
  
  public void setIndex(int paramInt)
  {
    this.index = paramInt;
  }
  
  public void setLimit(int paramInt)
  {
    this.limit = paramInt;
  }
  
  public void setShareRole(EnumDeviceShareRole paramEnumDeviceShareRole)
  {
    this.shareRole = paramEnumDeviceShareRole;
  }
  
  public void setShareStatus(EnumDeviceShareStatus paramEnumDeviceShareStatus)
  {
    this.shareStatus = paramEnumDeviceShareStatus;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\share\params\ShareDeviceParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */