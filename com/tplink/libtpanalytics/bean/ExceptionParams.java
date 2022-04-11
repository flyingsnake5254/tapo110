package com.tplink.libtpanalytics.bean;

public class ExceptionParams
{
  private String content;
  private String exceptionTime;
  
  public ExceptionParams(String paramString1, String paramString2)
  {
    this.content = paramString1;
    this.exceptionTime = paramString2;
  }
  
  public String getContent()
  {
    return this.content;
  }
  
  public String getExceptionTime()
  {
    return this.exceptionTime;
  }
  
  public void setContent(String paramString)
  {
    this.content = paramString;
  }
  
  public void setExceptionTime(String paramString)
  {
    this.exceptionTime = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpanalytics\bean\ExceptionParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */