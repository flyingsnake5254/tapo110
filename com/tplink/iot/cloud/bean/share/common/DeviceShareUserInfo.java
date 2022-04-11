package com.tplink.iot.cloud.bean.share.common;

public class DeviceShareUserInfo
{
  private long bindingTime;
  private String cloudUsername;
  private String nickname;
  private int role;
  
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
  
  public int getRole()
  {
    return this.role;
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
  
  public void setRole(int paramInt)
  {
    this.role = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\share\common\DeviceShareUserInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */