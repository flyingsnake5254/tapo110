package com.tplink.cloud.bean.update.result;

import java.util.ArrayList;
import java.util.List;

public class AppVersionsResult
{
  private List<AppVersionResult> appVersions = new ArrayList();
  
  public List<AppVersionResult> getAppVersions()
  {
    return this.appVersions;
  }
  
  public void setAppVersions(List<AppVersionResult> paramList)
  {
    this.appVersions = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\update\result\AppVersionsResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */