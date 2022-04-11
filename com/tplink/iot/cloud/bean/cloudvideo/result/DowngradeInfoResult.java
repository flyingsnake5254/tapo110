package com.tplink.iot.cloud.bean.cloudvideo.result;

import com.tplink.iot.cloud.bean.cloudvideo.common.DowngradeHandled;
import com.tplink.iot.cloud.bean.cloudvideo.common.DowngradeToHandle;

public class DowngradeInfoResult
{
  private DowngradeHandled downgradeHandled;
  private DowngradeToHandle downgradeToHandle;
  
  public DowngradeHandled getDowngradeHandled()
  {
    return this.downgradeHandled;
  }
  
  public DowngradeToHandle getDowngradeToHandle()
  {
    return this.downgradeToHandle;
  }
  
  public void setDowngradeHandled(DowngradeHandled paramDowngradeHandled)
  {
    this.downgradeHandled = paramDowngradeHandled;
  }
  
  public void setDowngradeToHandle(DowngradeToHandle paramDowngradeToHandle)
  {
    this.downgradeToHandle = paramDowngradeToHandle;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\cloudvideo\result\DowngradeInfoResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */