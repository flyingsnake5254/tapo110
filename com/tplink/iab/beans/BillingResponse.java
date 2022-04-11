package com.tplink.iab.beans;

public class BillingResponse
{
  private int responseCode;
  private Object result;
  private int sn;
  
  public BillingResponse(int paramInt)
  {
    this.sn = paramInt;
  }
  
  public BillingResponse(int paramInt1, int paramInt2)
  {
    this.sn = paramInt1;
    this.responseCode = paramInt2;
  }
  
  public BillingResponse(int paramInt1, int paramInt2, Object paramObject)
  {
    this.sn = paramInt1;
    this.responseCode = paramInt2;
    this.result = paramObject;
  }
  
  public BillingResponse(int paramInt, Object paramObject)
  {
    this.responseCode = 0;
    this.sn = paramInt;
    this.result = paramObject;
  }
  
  public int getResponseCode()
  {
    return this.responseCode;
  }
  
  public Object getResult()
  {
    return this.result;
  }
  
  public int getSn()
  {
    return this.sn;
  }
  
  public void setResponseCode(int paramInt)
  {
    this.responseCode = paramInt;
  }
  
  public void setResult(Object paramObject)
  {
    this.result = paramObject;
  }
  
  public void setSn(int paramInt)
  {
    this.sn = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iab\beans\BillingResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */