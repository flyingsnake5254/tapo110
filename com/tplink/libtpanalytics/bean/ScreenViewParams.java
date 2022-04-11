package com.tplink.libtpanalytics.bean;

public class ScreenViewParams
{
  private String lastScreenClass;
  private String lastScreenName;
  private String screenClass;
  private String screenName;
  
  public ScreenViewParams() {}
  
  public ScreenViewParams(String paramString)
  {
    this.lastScreenClass = paramString;
  }
  
  public String getLastScreenClass()
  {
    return this.lastScreenClass;
  }
  
  public String getLastScreenName()
  {
    return this.lastScreenName;
  }
  
  public String getScreenClass()
  {
    return this.screenClass;
  }
  
  public String getScreenName()
  {
    return this.screenName;
  }
  
  public void setLastScreenClass(String paramString)
  {
    this.lastScreenClass = paramString;
  }
  
  public void setLastScreenName(String paramString)
  {
    this.lastScreenName = paramString;
  }
  
  public void setScreenClass(String paramString)
  {
    this.screenClass = paramString;
  }
  
  public void setScreenName(String paramString)
  {
    this.screenName = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpanalytics\bean\ScreenViewParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */