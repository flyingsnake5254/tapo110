package com.tplink.libtpnetwork.TPCloudNetwork.device;

import com.tplink.iot.cloud.bean.share.device.DeviceOwnerInfoResult;
import com.tplink.iot.cloud.bean.share.device.DeviceUserInfoResult;
import com.tplink.libtpnetwork.enumerate.EnumUserRole;
import java.io.Serializable;

public class TCDeviceUserInfoBean
  implements Serializable
{
  private String avatarUrl;
  private long bindingTime;
  private String cloudUserName;
  private String nickname;
  private EnumUserRole role;
  
  public TCDeviceUserInfoBean() {}
  
  public TCDeviceUserInfoBean(DeviceUserInfoResult paramDeviceUserInfoResult)
  {
    this.cloudUserName = paramDeviceUserInfoResult.getCloudUsername();
    this.nickname = paramDeviceUserInfoResult.getNickname();
    this.bindingTime = paramDeviceUserInfoResult.getBindingTime();
    EnumUserRole localEnumUserRole;
    if (paramDeviceUserInfoResult.getRole() == 0) {
      localEnumUserRole = EnumUserRole.ROLE_OWNER;
    } else {
      localEnumUserRole = EnumUserRole.ROLE_USER;
    }
    this.role = localEnumUserRole;
    this.avatarUrl = paramDeviceUserInfoResult.getAvatarUrl();
  }
  
  public TCDeviceUserInfoBean(TCDeviceUserInfoBean paramTCDeviceUserInfoBean)
  {
    this.cloudUserName = paramTCDeviceUserInfoBean.getCloudUserName();
    this.nickname = paramTCDeviceUserInfoBean.getNickname();
    this.bindingTime = paramTCDeviceUserInfoBean.getBindingTime();
    this.role = paramTCDeviceUserInfoBean.getRole();
    this.avatarUrl = paramTCDeviceUserInfoBean.getAvatarUrl();
  }
  
  public TCDeviceUserInfoBean(String paramString1, String paramString2, long paramLong, EnumUserRole paramEnumUserRole, String paramString3)
  {
    this.cloudUserName = paramString1;
    this.nickname = paramString2;
    this.bindingTime = paramLong;
    this.role = paramEnumUserRole;
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
  
  public EnumUserRole getRole()
  {
    return this.role;
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
  
  public void setRole(EnumUserRole paramEnumUserRole)
  {
    this.role = paramEnumUserRole;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\TPCloudNetwork\device\TCDeviceUserInfoBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */