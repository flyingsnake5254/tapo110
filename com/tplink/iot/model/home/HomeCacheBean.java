package com.tplink.iot.model.home;

public class HomeCacheBean
{
  private String deviceIdMD5;
  private long firstDiscoverTime;
  private boolean isDrag;
  private boolean isFavorite = true;
  private boolean isNewDevice;
  private int sortValue;
  
  public void cloneHomeCacheBean(HomeCacheBean paramHomeCacheBean)
  {
    setFavorite(paramHomeCacheBean.isFavorite);
    setDeviceIdMD5(paramHomeCacheBean.getDeviceIdMD5());
    setSortValue(paramHomeCacheBean.getSortValue());
    setFirstDiscoverTime(paramHomeCacheBean.getFirstDiscoverTime());
    setNewDevice(paramHomeCacheBean.isNewDevice);
  }
  
  public String getDeviceIdMD5()
  {
    return this.deviceIdMD5;
  }
  
  public long getFirstDiscoverTime()
  {
    return this.firstDiscoverTime;
  }
  
  public int getSortValue()
  {
    return this.sortValue;
  }
  
  public boolean isDrag()
  {
    return this.isDrag;
  }
  
  public boolean isFavorite()
  {
    return this.isFavorite;
  }
  
  public boolean isNewDevice()
  {
    return this.isNewDevice;
  }
  
  public void setDeviceIdMD5(String paramString)
  {
    this.deviceIdMD5 = paramString;
  }
  
  public void setDragFlag(boolean paramBoolean)
  {
    this.isDrag = paramBoolean;
  }
  
  public void setFavorite(boolean paramBoolean)
  {
    this.isFavorite = paramBoolean;
  }
  
  public void setFirstDiscoverTime(long paramLong)
  {
    this.firstDiscoverTime = paramLong;
  }
  
  public void setNewDevice(boolean paramBoolean)
  {
    this.isNewDevice = paramBoolean;
  }
  
  public void setSortValue(int paramInt)
  {
    this.sortValue = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("HomeCacheBean{isFavorite=");
    localStringBuilder.append(this.isFavorite);
    localStringBuilder.append(", isNewDevice=");
    localStringBuilder.append(this.isNewDevice);
    localStringBuilder.append(", firstDiscoverTime=");
    localStringBuilder.append(this.firstDiscoverTime);
    localStringBuilder.append(", sortValue=");
    localStringBuilder.append(this.sortValue);
    localStringBuilder.append(", deviceIdMD5='");
    localStringBuilder.append(this.deviceIdMD5);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\model\home\HomeCacheBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */