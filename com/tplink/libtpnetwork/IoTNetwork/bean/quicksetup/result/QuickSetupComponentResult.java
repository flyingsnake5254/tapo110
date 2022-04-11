package com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result;

import com.google.gson.q.c;
import java.io.Serializable;
import java.util.List;

public class QuickSetupComponentResult
  implements Serializable
{
  @c("component_list")
  private List<QuickSetupComponentBean> componentList;
  @c("extra_info")
  private QuickSetupComponentExtraInfoBean extraInfo;
  
  public List<QuickSetupComponentBean> getComponentList()
  {
    return this.componentList;
  }
  
  public QuickSetupComponentExtraInfoBean getExtraInfo()
  {
    return this.extraInfo;
  }
  
  public void setComponentList(List<QuickSetupComponentBean> paramList)
  {
    this.componentList = paramList;
  }
  
  public void setExtraInfo(QuickSetupComponentExtraInfoBean paramQuickSetupComponentExtraInfoBean)
  {
    this.extraInfo = paramQuickSetupComponentExtraInfoBean;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\quicksetup\result\QuickSetupComponentResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */