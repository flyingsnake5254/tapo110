package com.tplink.libtpnetwork.IoTNetwork.bean.sub.params;

import kotlin.jvm.internal.j;

public final class DelayActionInfoBean
{
  private boolean enabled;
  private DelayActionStateBean state;
  private int time;
  
  public DelayActionInfoBean(DelayActionStateBean paramDelayActionStateBean, boolean paramBoolean, int paramInt)
  {
    this.state = paramDelayActionStateBean;
    this.enabled = paramBoolean;
    this.time = paramInt;
  }
  
  public final DelayActionStateBean component1()
  {
    return this.state;
  }
  
  public final boolean component2()
  {
    return this.enabled;
  }
  
  public final int component3()
  {
    return this.time;
  }
  
  public final DelayActionInfoBean copy(DelayActionStateBean paramDelayActionStateBean, boolean paramBoolean, int paramInt)
  {
    return new DelayActionInfoBean(paramDelayActionStateBean, paramBoolean, paramInt);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof DelayActionInfoBean))
      {
        paramObject = (DelayActionInfoBean)paramObject;
        if ((j.a(this.state, ((DelayActionInfoBean)paramObject).state)) && (this.enabled == ((DelayActionInfoBean)paramObject).enabled) && (this.time == ((DelayActionInfoBean)paramObject).time)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final boolean getEnabled()
  {
    return this.enabled;
  }
  
  public final DelayActionStateBean getState()
  {
    return this.state;
  }
  
  public final int getTime()
  {
    return this.time;
  }
  
  public int hashCode()
  {
    DelayActionStateBean localDelayActionStateBean = this.state;
    int i;
    if (localDelayActionStateBean != null) {
      i = localDelayActionStateBean.hashCode();
    } else {
      i = 0;
    }
    int j = this.enabled;
    int k = j;
    if (j != 0) {
      k = 1;
    }
    return (i * 31 + k) * 31 + this.time;
  }
  
  public final void setEnabled(boolean paramBoolean)
  {
    this.enabled = paramBoolean;
  }
  
  public final void setState(DelayActionStateBean paramDelayActionStateBean)
  {
    this.state = paramDelayActionStateBean;
  }
  
  public final void setTime(int paramInt)
  {
    this.time = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DelayActionInfoBean(state=");
    localStringBuilder.append(this.state);
    localStringBuilder.append(", enabled=");
    localStringBuilder.append(this.enabled);
    localStringBuilder.append(", time=");
    localStringBuilder.append(this.time);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\sub\params\DelayActionInfoBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */