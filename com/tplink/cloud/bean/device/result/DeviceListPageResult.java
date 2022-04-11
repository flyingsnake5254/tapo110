package com.tplink.cloud.bean.device.result;

public class DeviceListPageResult
  extends DeviceListResult
{
  private int currentIndex;
  private int totalNum;
  
  public int getCurrentIndex()
  {
    return this.currentIndex;
  }
  
  public int getTotalNum()
  {
    return this.totalNum;
  }
  
  public void setCurrentIndex(int paramInt)
  {
    this.currentIndex = paramInt;
  }
  
  public void setTotalNum(int paramInt)
  {
    this.totalNum = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\device\result\DeviceListPageResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */