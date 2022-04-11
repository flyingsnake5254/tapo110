package com.tplink.libtpnetwork.IoTNetwork.bean.sub.result;

import com.google.gson.q.c;

public final class RealTimeBatteryInfoResult
{
  @c("allow_upgrade")
  private boolean allowUpgrade;
  
  public RealTimeBatteryInfoResult()
  {
    this(false);
  }
  
  public RealTimeBatteryInfoResult(boolean paramBoolean)
  {
    this.allowUpgrade = paramBoolean;
  }
  
  public final boolean component1()
  {
    return this.allowUpgrade;
  }
  
  public final RealTimeBatteryInfoResult copy(boolean paramBoolean)
  {
    return new RealTimeBatteryInfoResult(paramBoolean);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof RealTimeBatteryInfoResult))
      {
        paramObject = (RealTimeBatteryInfoResult)paramObject;
        if (this.allowUpgrade == ((RealTimeBatteryInfoResult)paramObject).allowUpgrade) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final boolean getAllowUpgrade()
  {
    return this.allowUpgrade;
  }
  
  public int hashCode()
  {
    int i = this.allowUpgrade;
    int j = i;
    if (i != 0) {
      j = 1;
    }
    return j;
  }
  
  public final void setAllowUpgrade(boolean paramBoolean)
  {
    this.allowUpgrade = paramBoolean;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RealTimeBatteryInfoResult(allowUpgrade=");
    localStringBuilder.append(this.allowUpgrade);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\sub\result\RealTimeBatteryInfoResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */