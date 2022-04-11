package com.tplink.cloud.bean.share.params;

import java.util.List;

public class ShareBlacklistUpdateParams
{
  private List<String> blackList;
  
  public ShareBlacklistUpdateParams() {}
  
  public ShareBlacklistUpdateParams(List<String> paramList)
  {
    this.blackList = paramList;
  }
  
  public List<String> getBlackList()
  {
    return this.blackList;
  }
  
  public void setBlackList(List<String> paramList)
  {
    this.blackList = paramList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\share\params\ShareBlacklistUpdateParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */