package com.tplink.libtpanalytics.bean;

public class AppUpdateParams
{
  private String lastVersion;
  
  public AppUpdateParams(String paramString)
  {
    this.lastVersion = paramString;
  }
  
  public String getLastVersion()
  {
    return this.lastVersion;
  }
  
  public void setLastVersion(String paramString)
  {
    this.lastVersion = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpanalytics\bean\AppUpdateParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */