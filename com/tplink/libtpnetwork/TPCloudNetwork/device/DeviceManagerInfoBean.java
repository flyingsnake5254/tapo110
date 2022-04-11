package com.tplink.libtpnetwork.TPCloudNetwork.device;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DeviceManagerInfoBean
  implements Serializable
{
  private int margin;
  private TCDeviceOwnerInfoBean ownerInfo;
  private List<TCDeviceUserInfoBean> userInfo;
  
  public DeviceManagerInfoBean()
  {
    this.userInfo = new ArrayList();
  }
  
  public DeviceManagerInfoBean(TCDeviceOwnerInfoBean paramTCDeviceOwnerInfoBean)
  {
    this.ownerInfo = paramTCDeviceOwnerInfoBean;
    this.userInfo = new ArrayList();
  }
  
  public DeviceManagerInfoBean(List<TCDeviceUserInfoBean> paramList, int paramInt)
  {
    this.userInfo = paramList;
    this.margin = paramInt;
  }
  
  public int getMargin()
  {
    return this.margin;
  }
  
  public TCDeviceOwnerInfoBean getOwnerInfo()
  {
    return this.ownerInfo;
  }
  
  public List<TCDeviceUserInfoBean> getUserInfo()
  {
    return this.userInfo;
  }
  
  public void setMargin(int paramInt)
  {
    this.margin = paramInt;
  }
  
  public void setOwnerInfo(TCDeviceOwnerInfoBean paramTCDeviceOwnerInfoBean)
  {
    this.ownerInfo = paramTCDeviceOwnerInfoBean;
  }
  
  public void setUserInfo(List<TCDeviceUserInfoBean> paramList)
  {
    this.userInfo = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\TPCloudNetwork\device\DeviceManagerInfoBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */