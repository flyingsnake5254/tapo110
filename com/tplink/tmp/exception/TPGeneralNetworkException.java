package com.tplink.tmp.exception;

import b.d.d0.f2.c;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class TPGeneralNetworkException
  extends Exception
{
  private int errCode;
  private String errMsg;
  
  public TPGeneralNetworkException(int paramInt)
  {
    this.errCode = paramInt;
    this.errMsg = ((String)c.g.get(Integer.valueOf(paramInt)));
  }
  
  public TPGeneralNetworkException(int paramInt, String paramString)
  {
    this.errCode = paramInt;
    this.errMsg = paramString;
  }
  
  public static boolean isCancelException(Throwable paramThrowable)
  {
    boolean bool;
    if (((paramThrowable instanceof TPGeneralNetworkException)) && (64526 == ((TPGeneralNetworkException)paramThrowable).getErrCode())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static boolean isClientException(Throwable paramThrowable)
  {
    boolean bool;
    if (((paramThrowable instanceof TPGeneralNetworkException)) && (64528 == ((TPGeneralNetworkException)paramThrowable).getErrCode())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public int getErrCode()
  {
    return this.errCode;
  }
  
  public String getErrMsg()
  {
    return this.errMsg;
  }
  
  public void setErrCode(int paramInt)
  {
    this.errCode = paramInt;
  }
  
  public void setErrMsg(String paramString)
  {
    this.errMsg = paramString;
  }
  
  public String toString()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("errCode", this.errCode);
      localJSONObject.put("errMsg", this.errMsg);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\tmp\exception\TPGeneralNetworkException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */