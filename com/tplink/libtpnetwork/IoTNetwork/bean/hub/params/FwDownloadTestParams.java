package com.tplink.libtpnetwork.IoTNetwork.bean.hub.params;

public class FwDownloadTestParams
{
  private String url;
  
  public FwDownloadTestParams() {}
  
  public FwDownloadTestParams(String paramString)
  {
    this.url = paramString;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\hub\params\FwDownloadTestParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */