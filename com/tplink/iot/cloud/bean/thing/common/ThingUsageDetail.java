package com.tplink.iot.cloud.bean.thing.common;

import com.google.gson.q.c;

public class ThingUsageDetail
{
  @c("past30")
  private int past30;
  @c("past7")
  private int past7;
  @c("today")
  private int today;
  
  public int getPast30()
  {
    return this.past30;
  }
  
  public int getPast7()
  {
    return this.past7;
  }
  
  public int getToday()
  {
    return this.today;
  }
  
  public void setPast30(int paramInt)
  {
    this.past30 = paramInt;
  }
  
  public void setPast7(int paramInt)
  {
    this.past7 = paramInt;
  }
  
  public void setToday(int paramInt)
  {
    this.today = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\thing\common\ThingUsageDetail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */