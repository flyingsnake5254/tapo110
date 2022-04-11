package com.tplink.libtpnetwork.IoTNetwork.transport.http.bean.handshake;

import androidx.annotation.Keep;
import com.google.gson.q.c;

@Keep
public class HandShakeResponse
{
  private String errMsg;
  @c("error_code")
  private int errorCode;
  private ResultBean result;
  
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
    private String key;
    
    public String getKey()
    {
      return this.key;
    }
    
    public void setKey(String paramString)
    {
      this.key = paramString;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\transport\http\bean\handshake\HandShakeResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */