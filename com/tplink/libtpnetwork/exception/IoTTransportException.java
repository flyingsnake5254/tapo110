package com.tplink.libtpnetwork.exception;

import androidx.annotation.NonNull;
import b.d.s.b.a;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Map;
import retrofit2.HttpException;

public class IoTTransportException
  extends Exception
{
  private int errCode;
  private String msg;
  
  public IoTTransportException(int paramInt)
  {
    this.errCode = paramInt;
    this.msg = ((String)a.a.get(Integer.valueOf(paramInt)));
  }
  
  public IoTTransportException(int paramInt, String paramString)
  {
    this.errCode = paramInt;
    this.msg = paramString;
  }
  
  public static boolean isCancelException(Throwable paramThrowable)
  {
    boolean bool;
    if (((paramThrowable instanceof IoTTransportException)) && (((IoTTransportException)paramThrowable).isCancelException())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static boolean isTransportNotAvailableException(Throwable paramThrowable)
  {
    boolean bool;
    if ((!(paramThrowable instanceof ProtocolException)) && (!(paramThrowable instanceof UnknownHostException)) && (!(paramThrowable instanceof ConnectException)) && (!(paramThrowable instanceof SocketException)) && (!(paramThrowable instanceof SocketTimeoutException)) && ((!(paramThrowable instanceof HttpException)) || (((HttpException)paramThrowable).code() < 300)) && ((!(paramThrowable instanceof IoTTransportException)) || (((IoTTransportException)paramThrowable).isCancelException()))) {
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
  
  public boolean isCancelException()
  {
    boolean bool;
    if (this.errCode == 1001) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void setErrCode(int paramInt)
  {
    this.errCode = paramInt;
  }
  
  public void setMsg(String paramString)
  {
    this.msg = paramString;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("IoTTransportException{errCode=");
    localStringBuilder.append(this.errCode);
    localStringBuilder.append(", msg='");
    localStringBuilder.append(this.msg);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\exception\IoTTransportException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */