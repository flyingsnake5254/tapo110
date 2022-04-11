package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip;

public final class DeviceSegmentBean
{
  private int segment;
  
  public DeviceSegmentBean(int paramInt)
  {
    this.segment = paramInt;
  }
  
  public final int component1()
  {
    return this.segment;
  }
  
  public final DeviceSegmentBean copy(int paramInt)
  {
    return new DeviceSegmentBean(paramInt);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof DeviceSegmentBean))
      {
        paramObject = (DeviceSegmentBean)paramObject;
        if (this.segment == ((DeviceSegmentBean)paramObject).segment) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final int getSegment()
  {
    return this.segment;
  }
  
  public int hashCode()
  {
    return this.segment;
  }
  
  public final void setSegment(int paramInt)
  {
    this.segment = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceSegmentBean(segment=");
    localStringBuilder.append(this.segment);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\lightstrip\DeviceSegmentBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */