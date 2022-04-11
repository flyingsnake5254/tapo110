package com.tplink.libtpcommonstream.stream.control.common;

public class StreamControlResponse<T>
{
  private T result;
  private int seq;
  private String type;
  
  public T getResult()
  {
    return (T)this.result;
  }
  
  public int getSeq()
  {
    return this.seq;
  }
  
  public String getType()
  {
    return this.type;
  }
  
  public void setResult(T paramT)
  {
    this.result = paramT;
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcommonstream\stream\control\common\StreamControlResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */