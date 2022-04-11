package com.tplink.libtpcommonstream.stream.control.common;

import com.google.gson.i;
import com.google.gson.q.c;

public class CommonPayload
{
  @c("params")
  private i params;
  @c("seq")
  private int seq;
  @c("type")
  private String type;
  
  public i getParams()
  {
    return this.params;
  }
  
  public int getSeq()
  {
    return this.seq;
  }
  
  public String getType()
  {
    return this.type;
  }
  
  public void setParams(i parami)
  {
    this.params = parami;
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcommonstream\stream\control\common\CommonPayload.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */