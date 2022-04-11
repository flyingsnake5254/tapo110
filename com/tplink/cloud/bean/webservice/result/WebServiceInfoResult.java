package com.tplink.cloud.bean.webservice.result;

import java.util.HashMap;
import java.util.Map;

public class WebServiceInfoResult
{
  private Map<String, String> serviceUrls = new HashMap();
  
  public Map<String, String> getServiceUrls()
  {
    return this.serviceUrls;
  }
  
  public void setServiceUrls(Map<String, String> paramMap)
  {
    this.serviceUrls = paramMap;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\webservice\result\WebServiceInfoResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */