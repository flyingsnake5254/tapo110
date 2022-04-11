package com.tplink.iot.view.quicksetup.common;

import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result.QuickSetupComponentResult;
import java.io.Serializable;

public class CommonQuickSetupBean
  implements Serializable
{
  private QuickSetupComponentResult componentResult;
  private String deviceIdMD5;
  private boolean isFromQuickDiscovery;
  private boolean isKeepInherit;
  
  public CommonQuickSetupBean() {}
  
  public CommonQuickSetupBean(String paramString, QuickSetupComponentResult paramQuickSetupComponentResult)
  {
    this.deviceIdMD5 = paramString;
    this.componentResult = paramQuickSetupComponentResult;
  }
  
  public CommonQuickSetupBean(String paramString, QuickSetupComponentResult paramQuickSetupComponentResult, boolean paramBoolean)
  {
    this.deviceIdMD5 = paramString;
    this.componentResult = paramQuickSetupComponentResult;
    this.isKeepInherit = paramBoolean;
  }
  
  public QuickSetupComponentResult getComponentResult()
  {
    return this.componentResult;
  }
  
  public String getDeviceIdMD5()
  {
    return this.deviceIdMD5;
  }
  
  public boolean isFromQuickDiscovery()
  {
    return this.isFromQuickDiscovery;
  }
  
  public boolean isKeepInherit()
  {
    return this.isKeepInherit;
  }
  
  public void setComponentResult(QuickSetupComponentResult paramQuickSetupComponentResult)
  {
    this.componentResult = paramQuickSetupComponentResult;
  }
  
  public void setDeviceIdMD5(String paramString)
  {
    this.deviceIdMD5 = paramString;
  }
  
  public void setFromQuickDiscovery(boolean paramBoolean)
  {
    this.isFromQuickDiscovery = paramBoolean;
  }
  
  public void setKeepInherit(boolean paramBoolean)
  {
    this.isKeepInherit = paramBoolean;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\common\CommonQuickSetupBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */