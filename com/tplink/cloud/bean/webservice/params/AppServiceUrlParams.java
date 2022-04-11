package com.tplink.cloud.bean.webservice.params;

import java.util.List;

public class AppServiceUrlParams
{
  private List<String> serviceIds;
  
  public AppServiceUrlParams() {}
  
  public AppServiceUrlParams(List<String> paramList)
  {
    this.serviceIds = paramList;
  }
  
  public List<String> getServiceIds()
  {
    return this.serviceIds;
  }
  
  public void setServiceIds(List<String> paramList)
  {
    this.serviceIds = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\webservice\params\AppServiceUrlParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */