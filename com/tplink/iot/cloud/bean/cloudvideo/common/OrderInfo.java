package com.tplink.iot.cloud.bean.cloudvideo.common;

public class OrderInfo
{
  private String accountId;
  private boolean autoRenew;
  private long endTime;
  private long gracePeriod;
  private String id;
  private long orderCreatedTime;
  private ProductInfo product;
  private long startTime;
  private String status;
  private int trial;
  
  public String getAccountId()
  {
    return this.accountId;
  }
  
  public long getEndTime()
  {
    return this.endTime;
  }
  
  public long getGracePeriod()
  {
    return this.gracePeriod;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public long getOrderCreatedTime()
  {
    return this.orderCreatedTime;
  }
  
  public ProductInfo getProduct()
  {
    return this.product;
  }
  
  public long getStartTime()
  {
    return this.startTime;
  }
  
  public String getStatus()
  {
    return this.status;
  }
  
  public int getTrial()
  {
    return this.trial;
  }
  
  public boolean isAutoRenew()
  {
    return this.autoRenew;
  }
  
  public void setAccountId(String paramString)
  {
    this.accountId = paramString;
  }
  
  public void setAutoRenew(boolean paramBoolean)
  {
    this.autoRenew = paramBoolean;
  }
  
  public void setEndTime(long paramLong)
  {
    this.endTime = paramLong;
  }
  
  public void setGracePeriod(long paramLong)
  {
    this.gracePeriod = paramLong;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setOrderCreatedTime(long paramLong)
  {
    this.orderCreatedTime = paramLong;
  }
  
  public void setProduct(ProductInfo paramProductInfo)
  {
    this.product = paramProductInfo;
  }
  
  public void setStartTime(long paramLong)
  {
    this.startTime = paramLong;
  }
  
  public void setStatus(String paramString)
  {
    this.status = paramString;
  }
  
  public void setTrial(int paramInt)
  {
    this.trial = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\cloudvideo\common\OrderInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */