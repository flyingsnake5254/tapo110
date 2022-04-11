package com.tplink.libtpnetwork.IoTNetwork.bean.common.result;

import com.google.gson.i;
import com.google.gson.q.c;
import java.util.List;

public class PresetRuleResult
{
  @c("start_index")
  private int startIndex;
  private List<i> states;
  private int sum;
  
  public int getStartIndex()
  {
    return this.startIndex;
  }
  
  public List<i> getStates()
  {
    return this.states;
  }
  
  public int getSum()
  {
    return this.sum;
  }
  
  public void setStartIndex(int paramInt)
  {
    this.startIndex = paramInt;
  }
  
  public void setStates(List<i> paramList)
  {
    this.states = paramList;
  }
  
  public void setSum(int paramInt)
  {
    this.sum = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\common\result\PresetRuleResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */