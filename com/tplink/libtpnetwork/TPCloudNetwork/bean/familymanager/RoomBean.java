package com.tplink.libtpnetwork.TPCloudNetwork.bean.familymanager;

import java.util.ArrayList;
import java.util.List;

public class RoomBean
{
  private String mAvatarUrl;
  private int mDeviceCount;
  private List<DeviceBean> mDeviceList = new ArrayList();
  private String mRoomId;
  private String mRoomName;
  
  public String getAvatarUrl()
  {
    return this.mAvatarUrl;
  }
  
  public int getDeviceCount()
  {
    List localList = this.mDeviceList;
    if (localList != null) {
      this.mDeviceCount = localList.size();
    }
    return this.mDeviceCount;
  }
  
  public List<DeviceBean> getDeviceList()
  {
    return this.mDeviceList;
  }
  
  public String getRoomId()
  {
    return this.mRoomId;
  }
  
  public String getRoomName()
  {
    return this.mRoomName;
  }
  
  public void setAvatarUrl(String paramString)
  {
    this.mAvatarUrl = paramString;
  }
  
  public void setDeviceList(List<DeviceBean> paramList)
  {
    this.mDeviceList = paramList;
  }
  
  public void setRoomId(String paramString)
  {
    this.mRoomId = paramString;
  }
  
  public void setRoomName(String paramString)
  {
    this.mRoomName = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\TPCloudNetwork\bean\familymanager\RoomBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */