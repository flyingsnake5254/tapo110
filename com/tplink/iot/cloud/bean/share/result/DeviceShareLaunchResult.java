package com.tplink.iot.cloud.bean.share.result;

import com.tplink.iot.cloud.bean.share.common.LaunchFailBean;
import com.tplink.iot.cloud.bean.share.common.LaunchSuccessBean;
import java.util.List;

public class DeviceShareLaunchResult
{
  private List<LaunchFailBean> failList;
  private List<LaunchSuccessBean> launchList;
  
  public List<LaunchFailBean> getFailList()
  {
    return this.failList;
  }
  
  public List<LaunchSuccessBean> getLaunchList()
  {
    return this.launchList;
  }
  
  public void setFailList(List<LaunchFailBean> paramList)
  {
    this.failList = paramList;
  }
  
  public void setLaunchList(List<LaunchSuccessBean> paramList)
  {
    this.launchList = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\share\result\DeviceShareLaunchResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */