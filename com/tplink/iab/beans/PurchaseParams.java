package com.tplink.iab.beans;

import java.util.List;

public class PurchaseParams
{
  private String currency;
  private List<String> deviceIdList;
  private String productGroup;
  private String productId;
  private int productType;
  
  public String getCurrency()
  {
    return this.currency;
  }
  
  public List<String> getDeviceIdList()
  {
    return this.deviceIdList;
  }
  
  public String getProductGroup()
  {
    return this.productGroup;
  }
  
  public String getProductId()
  {
    return this.productId;
  }
  
  public int getProductType()
  {
    return this.productType;
  }
  
  public void setCurrency(String paramString)
  {
    this.currency = paramString;
  }
  
  public void setDeviceIdList(List<String> paramList)
  {
    this.deviceIdList = paramList;
  }
  
  public void setProductGroup(String paramString)
  {
    this.productGroup = paramString;
  }
  
  public void setProductId(String paramString)
  {
    this.productId = paramString;
  }
  
  public void setProductType(int paramInt)
  {
    this.productType = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iab\beans\PurchaseParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */