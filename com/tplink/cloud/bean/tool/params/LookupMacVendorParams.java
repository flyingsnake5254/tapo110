package com.tplink.cloud.bean.tool.params;

import java.util.List;

public class LookupMacVendorParams
{
  private List<String> ouis;
  
  public LookupMacVendorParams() {}
  
  public LookupMacVendorParams(List<String> paramList)
  {
    this.ouis = paramList;
  }
  
  public List<String> getOuis()
  {
    return this.ouis;
  }
  
  public void setOuis(List<String> paramList)
  {
    this.ouis = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\tool\params\LookupMacVendorParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */