package com.tplink.libtpnetwork.IoTNetwork.bean.sub.result;

import com.google.gson.q.c;

public final class BatteryDetectInfoResult
{
  @c("is_low")
  private boolean isLow;
  
  public BatteryDetectInfoResult(boolean paramBoolean)
  {
    this.isLow = paramBoolean;
  }
  
  public final boolean component1()
  {
    return this.isLow;
  }
  
  public final BatteryDetectInfoResult copy(boolean paramBoolean)
  {
    return new BatteryDetectInfoResult(paramBoolean);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof BatteryDetectInfoResult))
      {
        paramObject = (BatteryDetectInfoResult)paramObject;
        if (this.isLow == ((BatteryDetectInfoResult)paramObject).isLow) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int i = this.isLow;
    int j = i;
    if (i != 0) {
      j = 1;
    }
    return j;
  }
  
  public final boolean isLow()
  {
    return this.isLow;
  }
  
  public final void setLow(boolean paramBoolean)
  {
    this.isLow = paramBoolean;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BatteryDetectInfoResult(isLow=");
    localStringBuilder.append(this.isLow);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\sub\result\BatteryDetectInfoResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */