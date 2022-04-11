package com.tplink.libtpnetwork.IoTNetwork.bean.trv;

public final class RemoveScaleInfoBean
{
  private boolean auto;
  
  public RemoveScaleInfoBean(boolean paramBoolean)
  {
    this.auto = paramBoolean;
  }
  
  public final boolean component1()
  {
    return this.auto;
  }
  
  public final RemoveScaleInfoBean copy(boolean paramBoolean)
  {
    return new RemoveScaleInfoBean(paramBoolean);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof RemoveScaleInfoBean))
      {
        paramObject = (RemoveScaleInfoBean)paramObject;
        if (this.auto == ((RemoveScaleInfoBean)paramObject).auto) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final boolean getAuto()
  {
    return this.auto;
  }
  
  public int hashCode()
  {
    int i = this.auto;
    int j = i;
    if (i != 0) {
      j = 1;
    }
    return j;
  }
  
  public final void setAuto(boolean paramBoolean)
  {
    this.auto = paramBoolean;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RemoveScaleInfoBean(auto=");
    localStringBuilder.append(this.auto);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\trv\RemoveScaleInfoBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */