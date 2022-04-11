package com.tplink.tdp.common;

import com.google.gson.q.c;

public class TDPResult<T>
{
  @c("error_code")
  private int errorCode;
  private T result;
  
  public TDPResult() {}
  
  public TDPResult(T paramT)
  {
    this.result = paramT;
  }
  
  public int getErrorCode()
  {
    return this.errorCode;
  }
  
  public T getResult()
  {
    return (T)this.result;
  }
  
  public void setErrorCode(int paramInt)
  {
    this.errorCode = paramInt;
  }
  
  public void setResult(T paramT)
  {
    this.result = paramT;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\tdp\common\TDPResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */