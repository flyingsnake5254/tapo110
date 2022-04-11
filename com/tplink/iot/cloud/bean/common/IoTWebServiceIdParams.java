package com.tplink.iot.cloud.bean.common;

public class IoTWebServiceIdParams
{
  private String iotAppServerId;
  private String iotGatewayId;
  private String iotSecurityId;
  
  public IoTWebServiceIdParams() {}
  
  public IoTWebServiceIdParams(String paramString1, String paramString2, String paramString3)
  {
    this.iotAppServerId = paramString1;
    this.iotGatewayId = paramString2;
    this.iotSecurityId = paramString3;
  }
  
  public String getIotAppServerId()
  {
    return this.iotAppServerId;
  }
  
  public String getIotGatewayId()
  {
    return this.iotGatewayId;
  }
  
  public String getIotSecurityId()
  {
    return this.iotSecurityId;
  }
  
  public void setIotAppServerId(String paramString)
  {
    this.iotAppServerId = paramString;
  }
  
  public void setIotGatewayId(String paramString)
  {
    this.iotGatewayId = paramString;
  }
  
  public void setIotSecurityId(String paramString)
  {
    this.iotSecurityId = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\common\IoTWebServiceIdParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */