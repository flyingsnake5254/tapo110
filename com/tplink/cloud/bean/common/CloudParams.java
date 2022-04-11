package com.tplink.cloud.bean.common;

public class CloudParams<T>
{
  private String method;
  private T params;
  
  public CloudParams() {}
  
  public CloudParams(String paramString, T paramT)
  {
    this.method = paramString;
    this.params = paramT;
  }
  
  public String getMethod()
  {
    return this.method;
  }
  
  public T getParams()
  {
    return (T)this.params;
  }
  
  public void setMethod(String paramString)
  {
    this.method = paramString;
  }
  
  public void setParams(T paramT)
  {
    this.params = paramT;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\common\CloudParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */