package com.tplink.libtpnetwork.IoTNetwork.transport.http.bean.login;

import com.google.gson.q.c;

public class LoginDeviceResponse
{
  @c("error_code")
  private int errorCode;
  private ResultBean result;
  
  public int getErrorCode()
  {
    return this.errorCode;
  }
  
  public ResultBean getResult()
  {
    return this.result;
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
    private String token;
    
    public String getToken()
    {
      return this.token;
    }
    
    public void setToken(String paramString)
    {
      this.token = paramString;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\transport\http\bean\login\LoginDeviceResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */