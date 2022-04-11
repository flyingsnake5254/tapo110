package com.tplink.libtpnetwork.IoTNetwork;

public class TPIoTRequest<T>
{
  private String method;
  private T params;
  private transient long requestID;
  private long requestTimeMils;
  private String terminalUUID;
  
  public String getMethod()
  {
    return this.method;
  }
  
  public T getParams()
  {
    return (T)this.params;
  }
  
  public long getRequestID()
  {
    return this.requestID;
  }
  
  public long getRequestTimeMils()
  {
    return this.requestTimeMils;
  }
  
  public String getTerminalUUID()
  {
    return this.terminalUUID;
  }
  
  public void setMethod(String paramString)
  {
    this.method = paramString;
  }
  
  public void setParams(T paramT)
  {
    this.params = paramT;
  }
  
  public void setRequestID(long paramLong)
  {
    this.requestID = paramLong;
  }
  
  public void setRequestTimeMils(long paramLong)
  {
    this.requestTimeMils = paramLong;
  }
  
  public void setTerminalUUID(String paramString)
  {
    this.terminalUUID = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\TPIoTRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */