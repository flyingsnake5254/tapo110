package com.tplink.libtpnetwork.IoTNetwork.bean.sub.params;

public final class DoubleClickInfoBean
{
  private boolean enable;
  private int interval;
  
  public DoubleClickInfoBean(boolean paramBoolean, int paramInt)
  {
    this.enable = paramBoolean;
    this.interval = paramInt;
  }
  
  public final boolean component1()
  {
    return this.enable;
  }
  
  public final int component2()
  {
    return this.interval;
  }
  
  public final DoubleClickInfoBean copy(boolean paramBoolean, int paramInt)
  {
    return new DoubleClickInfoBean(paramBoolean, paramInt);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof DoubleClickInfoBean;
    boolean bool2 = false;
    boolean bool3 = bool2;
    if (bool1)
    {
      bool1 = this.enable;
      if ((bool1) || (((DoubleClickInfoBean)paramObject).enable))
      {
        paramObject = (DoubleClickInfoBean)paramObject;
        bool3 = bool2;
        if (bool1 == ((DoubleClickInfoBean)paramObject).enable)
        {
          bool3 = bool2;
          if (this.interval != ((DoubleClickInfoBean)paramObject).interval) {}
        }
      }
      else
      {
        bool3 = true;
      }
    }
    return bool3;
  }
  
  public final boolean getEnable()
  {
    return this.enable;
  }
  
  public final int getInterval()
  {
    return this.interval;
  }
  
  public int hashCode()
  {
    boolean bool1 = this.enable;
    boolean bool2 = bool1;
    if (bool1) {
      bool2 = true;
    }
    return bool2 * true + this.interval;
  }
  
  public final void setEnable(boolean paramBoolean)
  {
    this.enable = paramBoolean;
  }
  
  public final void setInterval(int paramInt)
  {
    this.interval = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DoubleClickInfoBean(enable=");
    localStringBuilder.append(this.enable);
    localStringBuilder.append(", interval=");
    localStringBuilder.append(this.interval);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\sub\params\DoubleClickInfoBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */