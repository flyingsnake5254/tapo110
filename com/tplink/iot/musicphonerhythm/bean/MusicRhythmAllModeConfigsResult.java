package com.tplink.iot.musicphonerhythm.bean;

import com.google.gson.q.c;
import java.util.ArrayList;

public class MusicRhythmAllModeConfigsResult
{
  @c("enable")
  private boolean enable;
  @c("rule_list")
  private ArrayList<MusicRhythmModeConfigParams> ruleList;
  @c("rule_max_count")
  private int ruleMaxCount;
  @c("start_index")
  private int startIndex;
  @c("sum")
  private int sum;
  
  public ArrayList<MusicRhythmModeConfigParams> getRuleList()
  {
    return this.ruleList;
  }
  
  public int getRuleMaxCount()
  {
    return this.ruleMaxCount;
  }
  
  public int getStartIndex()
  {
    return this.startIndex;
  }
  
  public int getSum()
  {
    return this.sum;
  }
  
  public boolean isEnable()
  {
    return this.enable;
  }
  
  public void setEnable(boolean paramBoolean)
  {
    this.enable = paramBoolean;
  }
  
  public void setRuleList(ArrayList<MusicRhythmModeConfigParams> paramArrayList)
  {
    this.ruleList = paramArrayList;
  }
  
  public void setRuleMaxCount(int paramInt)
  {
    this.ruleMaxCount = paramInt;
  }
  
  public void setStartIndex(int paramInt)
  {
    this.startIndex = paramInt;
  }
  
  public void setSum(int paramInt)
  {
    this.sum = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\musicphonerhythm\bean\MusicRhythmAllModeConfigsResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */