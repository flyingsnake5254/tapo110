package com.tplink.cloud.define;

import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import retrofit2.HttpException;

public class CloudException
  extends Exception
{
  private int errCode;
  private String msg;
  
  public CloudException() {}
  
  public CloudException(int paramInt, String paramString)
  {
    super(paramString);
    this.errCode = paramInt;
    this.msg = paramString;
  }
  
  public static boolean isCloudStatusException(Throwable paramThrowable)
  {
    boolean bool;
    if ((!(paramThrowable instanceof ProtocolException)) && (!(paramThrowable instanceof UnknownHostException)) && (!(paramThrowable instanceof SocketException)) && (!(paramThrowable instanceof SocketTimeoutException)) && (!(paramThrowable instanceof HttpException))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public int getErrCode()
  {
    return this.errCode;
  }
  
  public String getMsg()
  {
    return this.msg;
  }
  
  public void setErrCode(int paramInt)
  {
    this.errCode = paramInt;
  }
  
  public void setMsg(String paramString)
  {
    this.msg = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\define\CloudException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */