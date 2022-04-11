package com.tplink.cloud.bean.common;

import com.google.gson.q.c;

public class CloudResult<T>
{
  @c("error_code")
  private int errorCode;
  private String msg;
  private T result;
  
  public int getErrorCode()
  {
    return this.errorCode;
  }
  
  public String getMsg()
  {
    return this.msg;
  }
  
  public T getResult()
  {
    return (T)this.result;
  }
  
  public void setErrorCode(int paramInt)
  {
    this.errorCode = paramInt;
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\common\CloudResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */