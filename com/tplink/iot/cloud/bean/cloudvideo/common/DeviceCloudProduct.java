package com.tplink.iot.cloud.bean.cloudvideo.common;

import com.tplink.iot.cloud.bean.cloudvideo.result.TrialResult;
import java.util.List;

public class DeviceCloudProduct
{
  private boolean autoRenew;
  private String deviceId;
  private long endTime;
  private List<String> features;
  private long gracePeriod;
  private String orderId;
  private String productDescription;
  private String productId;
  private String productName;
  private String status;
  private long timestamp;
  private TrialResult trial;
  private boolean trialQualified;
  
  public String getDeviceId()
  {
    return this.deviceId;
  }
  
  public long getEndTime()
  {
    return this.endTime;
  }
  
  public List<String> getFeatures()
  {
    return this.features;
  }
  
  public long getGracePeriod()
  {
    return this.gracePeriod;
  }
  
  public String getOrderId()
  {
    return this.orderId;
  }
  
  public String getProductDescription()
  {
    return this.productDescription;
  }
  
  public String getProductId()
  {
    return this.productId;
  }
  
  public String getProductName()
  {
    return this.productName;
  }
  
  public String getStatus()
  {
    return this.status;
  }
  
  public long getTimestamp()
  {
    return this.timestamp;
  }
  
  public TrialResult getTrial()
  {
    return this.trial;
  }
  
  public boolean getTrialQualified()
  {
    return this.trialQualified;
  }
  
  public boolean isAutoRenew()
  {
    return this.autoRenew;
  }
  
  public void setAutoRenew(boolean paramBoolean)
  {
    this.autoRenew = paramBoolean;
  }
  
  public void setDeviceId(String paramString)
  {
    this.deviceId = paramString;
  }
  
  public void setEndTime(long paramLong)
  {
    this.endTime = paramLong;
  }
  
  public void setFeatures(List<String> paramList)
  {
    this.features = paramList;
  }
  
  public void setGracePeriod(long paramLong)
  {
    this.gracePeriod = paramLong;
  }
  
  public void setOrderId(String paramString)
  {
    this.orderId = paramString;
  }
  
  public void setProductDescription(String paramString)
  {
    this.productDescription = paramString;
  }
  
  public void setProductId(String paramString)
  {
    this.productId = paramString;
  }
  
  public void setProductName(String paramString)
  {
    this.productName = paramString;
  }
  
  public void setStatus(String paramString)
  {
    this.status = paramString;
  }
  
  public void setTimestamp(long paramLong)
  {
    this.timestamp = paramLong;
  }
  
  public void setTrial(TrialResult paramTrialResult)
  {
    this.trial = paramTrialResult;
  }
  
  public void setTrialQualified(boolean paramBoolean)
  {
    this.trialQualified = paramBoolean;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\cloudvideo\common\DeviceCloudProduct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */