package com.tplink.cloud.bean.share.result;

import java.util.List;

public class ShareBlacklistResult
{
  private List<ShareBlacklistItemResult> blackList;
  private int currentIndex;
  private int total;
  
  public List<ShareBlacklistItemResult> getBlackList()
  {
    return this.blackList;
  }
  
  public int getCurrentIndex()
  {
    return this.currentIndex;
  }
  
  public int getTotal()
  {
    return this.total;
  }
  
  public void setBlackList(List<ShareBlacklistItemResult> paramList)
  {
    this.blackList = paramList;
  }
  
  public void setCurrentIndex(int paramInt)
  {
    this.currentIndex = paramInt;
  }
  
  public void setTotal(int paramInt)
  {
    this.total = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\share\result\ShareBlacklistResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */