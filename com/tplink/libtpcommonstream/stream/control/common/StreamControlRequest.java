package com.tplink.libtpcommonstream.stream.control.common;

import com.google.gson.q.c;

public class StreamControlRequest<T>
{
  @c("params")
  private T params;
  @c("seq")
  private int seq;
  @c("type")
  private String type = "request";
  
  public StreamControlRequest() {}
  
  public StreamControlRequest(T paramT)
  {
    this.params = paramT;
  }
  
  public T getParams()
  {
    return (T)this.params;
  }
  
  public int getSeq()
  {
    return this.seq;
  }
  
  public String getType()
  {
    return this.type;
  }
  
  public void setParams(T paramT)
  {
    this.params = paramT;
  }
  
  public void setSeq(int paramInt)
  {
    this.seq = paramInt;
  }
  
  public void setType(String paramString)
  {
    this.type = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcommonstream\stream\control\common\StreamControlRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */