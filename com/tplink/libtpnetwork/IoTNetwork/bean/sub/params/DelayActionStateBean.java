package com.tplink.libtpnetwork.IoTNetwork.bean.sub.params;

public final class DelayActionStateBean
{
  private boolean on;
  
  public DelayActionStateBean(boolean paramBoolean)
  {
    this.on = paramBoolean;
  }
  
  public final boolean component1()
  {
    return this.on;
  }
  
  public final DelayActionStateBean copy(boolean paramBoolean)
  {
    return new DelayActionStateBean(paramBoolean);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof DelayActionStateBean))
      {
        paramObject = (DelayActionStateBean)paramObject;
        if (this.on == ((DelayActionStateBean)paramObject).on) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final boolean getOn()
  {
    return this.on;
  }
  
  public int hashCode()
  {
    int i = this.on;
    int j = i;
    if (i != 0) {
      j = 1;
    }
    return j;
  }
  
  public final void setOn(boolean paramBoolean)
  {
    this.on = paramBoolean;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DelayActionStateBean(on=");
    localStringBuilder.append(this.on);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\sub\params\DelayActionStateBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */