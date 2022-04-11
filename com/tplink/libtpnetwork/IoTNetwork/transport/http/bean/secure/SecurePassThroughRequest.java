package com.tplink.libtpnetwork.IoTNetwork.transport.http.bean.secure;

public class SecurePassThroughRequest
{
  private String method = "securePassthrough";
  private ParamsBean params;
  
  public SecurePassThroughRequest(ParamsBean paramParamsBean)
  {
    this.params = paramParamsBean;
  }
  
  public String getMethod()
  {
    return this.method;
  }
  
  public ParamsBean getParams()
  {
    return this.params;
  }
  
  public void setMethod(String paramString)
  {
    this.method = paramString;
  }
  
  public void setParams(ParamsBean paramParamsBean)
  {
    this.params = paramParamsBean;
  }
  
  public static class ParamsBean
  {
    private String request;
    
    public ParamsBean(String paramString)
    {
      this.request = paramString;
    }
    
    public String getRequest()
    {
      return this.request;
    }
    
    public void setRequest(String paramString)
    {
      this.request = paramString;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\transport\http\bean\secure\SecurePassThroughRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */