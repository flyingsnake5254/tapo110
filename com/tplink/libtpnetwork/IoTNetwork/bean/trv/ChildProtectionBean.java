package com.tplink.libtpnetwork.IoTNetwork.bean.trv;

public final class ChildProtectionBean
{
  private boolean enable;
  
  public ChildProtectionBean(boolean paramBoolean)
  {
    this.enable = paramBoolean;
  }
  
  public final boolean component1()
  {
    return this.enable;
  }
  
  public final ChildProtectionBean copy(boolean paramBoolean)
  {
    return new ChildProtectionBean(paramBoolean);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof ChildProtectionBean))
      {
        paramObject = (ChildProtectionBean)paramObject;
        if (this.enable == ((ChildProtectionBean)paramObject).enable) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final boolean getEnable()
  {
    return this.enable;
  }
  
  public int hashCode()
  {
    int i = this.enable;
    int j = i;
    if (i != 0) {
      j = 1;
    }
    return j;
  }
  
  public final void setEnable(boolean paramBoolean)
  {
    this.enable = paramBoolean;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ChildProtectionBean(enable=");
    localStringBuilder.append(this.enable);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\trv\ChildProtectionBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */