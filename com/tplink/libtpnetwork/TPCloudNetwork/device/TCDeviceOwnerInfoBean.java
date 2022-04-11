package com.tplink.libtpnetwork.TPCloudNetwork.device;

import com.tplink.iot.cloud.bean.share.device.DeviceOwnerInfoResult;
import java.io.Serializable;

public class TCDeviceOwnerInfoBean
  implements Serializable
{
  private String avatarUrl;
  private long bindingTime;
  private String cloudUserName;
  private String nickname;
  
  public TCDeviceOwnerInfoBean() {}
  
  public TCDeviceOwnerInfoBean(DeviceOwnerInfoResult paramDeviceOwnerInfoResult)
  {
    this.cloudUserName = paramDeviceOwnerInfoResult.getCloudUsername();
    this.nickname = paramDeviceOwnerInfoResult.getNickname();
    this.bindingTime = paramDeviceOwnerInfoResult.getBindingTime();
    this.avatarUrl = paramDeviceOwnerInfoResult.getAvatarUrl();
  }
  
  public TCDeviceOwnerInfoBean(String paramString1, String paramString2, long paramLong, String paramString3)
  {
    this.cloudUserName = paramString1;
    this.nickname = paramString2;
    this.bindingTime = paramLong;
    this.avatarUrl = paramString3;
  }
  
  public String getAvatarUrl()
  {
    return this.avatarUrl;
  }
  
  public long getBindingTime()
  {
    return this.bindingTime;
  }
  
  public String getCloudUserName()
  {
    return this.cloudUserName;
  }
  
  public String getNickname()
  {
    return this.nickname;
  }
  
  public void setAvatarUrl(String paramString)
  {
    this.avatarUrl = paramString;
  }
  
  public void setBindingTime(long paramLong)
  {
    this.bindingTime = paramLong;
  }
  
  public void setCloudUserName(String paramString)
  {
    this.cloudUserName = paramString;
  }
  
  public void setNickname(String paramString)
  {
    this.nickname = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\TPCloudNetwork\device\TCDeviceOwnerInfoBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */