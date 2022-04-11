package com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result;

import com.google.gson.q.c;
import java.io.Serializable;

public class QuickSetupInfoResult
  implements Serializable
{
  @c("device_id")
  private String deviceId;
  @c("inherit_status")
  private boolean inheritStatus;
  
  public QuickSetupInfoResult() {}
  
  public QuickSetupInfoResult(String paramString)
  {
    this.deviceId = paramString;
  }
  
  public String getDeviceId()
  {
    return this.deviceId;
  }
  
  public boolean isInheritStatus()
  {
    return this.inheritStatus;
  }
  
  public void setDeviceId(String paramString)
  {
    this.deviceId = paramString;
  }
  
  public void setInheritStatus(boolean paramBoolean)
  {
    this.inheritStatus = paramBoolean;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\quicksetup\result\QuickSetupInfoResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */