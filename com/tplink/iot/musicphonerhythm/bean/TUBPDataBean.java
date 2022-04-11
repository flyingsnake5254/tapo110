package com.tplink.iot.musicphonerhythm.bean;

import com.google.gson.q.c;

public class TUBPDataBean
{
  @c("method")
  private String method;
  @c("params")
  private TUBPColorDbBean params;
  
  public TUBPDataBean(String paramString, TUBPColorDbBean paramTUBPColorDbBean)
  {
    this.method = paramString;
    this.params = paramTUBPColorDbBean;
  }
  
  public void setMethod(String paramString)
  {
    this.method = paramString;
  }
  
  public void setParams(TUBPColorDbBean paramTUBPColorDbBean)
  {
    this.params = paramTUBPColorDbBean;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\musicphonerhythm\bean\TUBPDataBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */