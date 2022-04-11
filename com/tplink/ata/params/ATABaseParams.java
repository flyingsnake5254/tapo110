package com.tplink.ata.params;

import com.tplink.ata.common.ATAMethodType;

public class ATABaseParams
{
  private ATAMethodType method;
  private String token;
  
  public ATABaseParams() {}
  
  public ATABaseParams(String paramString, ATAMethodType paramATAMethodType)
  {
    this.token = paramString;
    this.method = paramATAMethodType;
  }
  
  public ATAMethodType getMethod()
  {
    return this.method;
  }
  
  public String getToken()
  {
    return this.token;
  }
  
  public void setMethod(ATAMethodType paramATAMethodType)
  {
    this.method = paramATAMethodType;
  }
  
  public void setToken(String paramString)
  {
    this.token = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\ata\params\ATABaseParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */