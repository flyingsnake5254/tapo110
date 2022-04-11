package com.tplink.cloud.bean.webservice.params;

import java.util.List;

public class WebServiceInfoParams
{
  private List<String> serviceIds;
  
  public WebServiceInfoParams() {}
  
  public WebServiceInfoParams(List<String> paramList)
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\webservice\params\WebServiceInfoParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */