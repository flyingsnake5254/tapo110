package com.tplink.libtpnetwork.IoTNetwork.bean.common;

import com.google.gson.q.c;

public class IoTResult<T>
{
  @c("error_code")
  private int errCode;
  private String msg;
  private T result;
  
  public IoTResult() {}
  
  public IoTResult(int paramInt)
  {
    this.errCode = paramInt;
  }
  
  public IoTResult(int paramInt, T paramT)
  {
    this.errCode = paramInt;
    this.result = paramT;
  }
  
  public int getErrCode()
  {
    return this.errCode;
  }
  
  public String getMsg()
  {
    return this.msg;
  }
  
  public T getResult()
  {
    return (T)this.result;
  }
  
  public void setErrCode(int paramInt)
  {
    this.errCode = paramInt;
  }
  
  public void setMsg(String paramString)
  {
    this.msg = paramString;
  }
  
  public void setResult(T paramT)
  {
    this.result = paramT;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\common\IoTResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */