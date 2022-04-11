package com.tplink.cloud.bean.share.result;

import java.util.List;

public class ShareDeviceListResult
{
  private int currentIndex;
  private List<ShareDeviceResult> shareList;
  private int total;
  
  public int getCurrentIndex()
  {
    return this.currentIndex;
  }
  
  public List<ShareDeviceResult> getShareList()
  {
    return this.shareList;
  }
  
  public int getTotal()
  {
    return this.total;
  }
  
  public void setCurrentIndex(int paramInt)
  {
    this.currentIndex = paramInt;
  }
  
  public void setShareList(List<ShareDeviceResult> paramList)
  {
    this.shareList = paramList;
  }
  
  public void setTotal(int paramInt)
  {
    this.total = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\share\result\ShareDeviceListResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */