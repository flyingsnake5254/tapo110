package com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result;

import com.google.gson.q.c;
import java.util.List;

public class WirelessScanInfoResult
{
  @c("ap_list")
  private List<WirelessScanInfoBean> apList;
  @c("start_index")
  private int startIndex;
  private int sum;
  @c("wep_supported")
  private boolean wepSupported;
  
  public List<WirelessScanInfoBean> getApList()
  {
    return this.apList;
  }
  
  public int getStartIndex()
  {
    return this.startIndex;
  }
  
  public int getSum()
  {
    return this.sum;
  }
  
  public boolean isWepSupported()
  {
    return this.wepSupported;
  }
  
  public void setApList(List<WirelessScanInfoBean> paramList)
  {
    this.apList = paramList;
  }
  
  public void setStartIndex(int paramInt)
  {
    this.startIndex = paramInt;
  }
  
  public void setSum(int paramInt)
  {
    this.sum = paramInt;
  }
  
  public void setWepSupported(boolean paramBoolean)
  {
    this.wepSupported = paramBoolean;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\quicksetup\result\WirelessScanInfoResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */