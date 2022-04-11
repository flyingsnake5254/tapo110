package com.tplink.libtpnetwork.IoTNetwork.bean.common.params;

import com.google.gson.q.c;

public class RulePageParams
{
  @c("start_index")
  private int startIndex;
  
  public RulePageParams() {}
  
  public RulePageParams(int paramInt)
  {
    this.startIndex = paramInt;
  }
  
  public int getStartIndex()
  {
    return this.startIndex;
  }
  
  public void setStartIndex(int paramInt)
  {
    this.startIndex = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\common\params\RulePageParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */