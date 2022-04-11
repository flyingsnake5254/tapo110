package com.tplink.iot.cloud.bean.share.device;

public class DeviceOwnerInfoResult
{
  private String avatarUrl;
  private long bindingTime;
  private String cloudUsername;
  private String nickname;
  
  public String getAvatarUrl()
  {
    return this.avatarUrl;
  }
  
  public long getBindingTime()
  {
    return this.bindingTime;
  }
  
  public String getCloudUsername()
  {
    return this.cloudUsername;
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
  
  public void setCloudUsername(String paramString)
  {
    this.cloudUsername = paramString;
  }
  
  public void setNickname(String paramString)
  {
    this.nickname = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\share\device\DeviceOwnerInfoResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */