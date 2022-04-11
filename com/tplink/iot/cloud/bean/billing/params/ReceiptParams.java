package com.tplink.iot.cloud.bean.billing.params;

public class ReceiptParams
{
  private String accountId;
  private String platform;
  private PurchaseData purchaseData;
  
  public String getAccountId()
  {
    return this.accountId;
  }
  
  public String getPlatform()
  {
    return this.platform;
  }
  
  public PurchaseData getPurchaseData()
  {
    return this.purchaseData;
  }
  
  public void setAccountId(String paramString)
  {
    this.accountId = paramString;
  }
  
  public void setPlatform(String paramString)
  {
    this.platform = paramString;
  }
  
  public void setPurchaseData(PurchaseData paramPurchaseData)
  {
    this.purchaseData = paramPurchaseData;
  }
  
  public static class PurchaseData
  {
    private String packageName;
    private String productId;
    private String purchaseToken;
    
    public String getPackageName()
    {
      return this.packageName;
    }
    
    public String getProductId()
    {
      return this.productId;
    }
    
    public String getPurchaseToken()
    {
      return this.purchaseToken;
    }
    
    public void setPackageName(String paramString)
    {
      this.packageName = paramString;
    }
    
    public void setProductId(String paramString)
    {
      this.productId = paramString;
    }
    
    public void setPurchaseToken(String paramString)
    {
      this.purchaseToken = paramString;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\billing\params\ReceiptParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */