package com.tplink.nbu.exception;

import com.google.gson.q.c;

public class NbuCloudException
  extends Exception
{
  @c(alternate={"code"}, value="errorCode")
  private int errorCode;
  @c(alternate={"message"}, value="msg")
  private String msg;
  private int status;
  private long timestamp;
  
  public NbuCloudException(int paramInt, String paramString)
  {
    this.errorCode = paramInt;
    this.msg = paramString;
  }
  
  public NbuCloudException(String paramString)
  {
    this.msg = paramString;
  }
  
  public int getErrorCode()
  {
    return this.errorCode;
  }
  
  public String getMsg()
  {
    return this.msg;
  }
  
  public int getStatus()
  {
    return this.status;
  }
  
  public long getTimestamp()
  {
    return this.timestamp;
  }
  
  public void setErrorCode(int paramInt)
  {
    this.errorCode = paramInt;
  }
  
  public void setMsg(String paramString)
  {
    this.msg = paramString;
  }
  
  public void setStatus(int paramInt)
  {
    this.status = paramInt;
  }
  
  public void setTimestamp(long paramLong)
  {
    this.timestamp = paramLong;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\nbu\exception\NbuCloudException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */