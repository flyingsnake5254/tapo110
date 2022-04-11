package com.tplink.libtpnetwork.IoTNetwork.transport.http.bean.secure;

import com.google.gson.q.c;

public class SecurePassThroughResponse
{
  private String errMsg;
  @c("error_code")
  private int errorCode;
  private ResultBean result;
  
  public SecurePassThroughResponse() {}
  
  public SecurePassThroughResponse(int paramInt)
  {
    this.errorCode = paramInt;
  }
  
  public String getErrMsg()
  {
    return this.errMsg;
  }
  
  public int getErrorCode()
  {
    return this.errorCode;
  }
  
  public ResultBean getResult()
  {
    return this.result;
  }
  
  public void setErrMsg(String paramString)
  {
    this.errMsg = paramString;
  }
  
  public void setErrorCode(int paramInt)
  {
    this.errorCode = paramInt;
  }
  
  public void setResult(ResultBean paramResultBean)
  {
    this.result = paramResultBean;
  }
  
  public static class ResultBean
  {
    private String response;
    
    public String getResponse()
    {
      return this.response;
    }
    
    public void setResponse(String paramString)
    {
      this.response = paramString;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\transport\http\bean\secure\SecurePassThroughResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */