package com.tplink.libtpnetwork.IoTNetwork.bean.common.result;

public class AutoUpdateBean
{
  private boolean enable;
  private int random_range;
  private int time;
  
  public AutoUpdateBean(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.enable = paramBoolean;
    this.time = paramInt1;
    this.random_range = paramInt2;
  }
  
  public int getRandom_range()
  {
    return this.random_range;
  }
  
  public int getTime()
  {
    return this.time;
  }
  
  public boolean isEnable()
  {
    return this.enable;
  }
  
  public void setEnable(boolean paramBoolean)
  {
    this.enable = paramBoolean;
  }
  
  public void setRandom_range(int paramInt)
  {
    this.random_range = paramInt;
  }
  
  public void setTime(int paramInt)
  {
    this.time = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\common\result\AutoUpdateBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */