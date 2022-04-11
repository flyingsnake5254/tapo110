package com.tplink.libtpnetwork.libwss.bean.result;

public class GoogleAssistantLinkInfoResult
{
  private boolean isLinked;
  
  public Boolean getLinked()
  {
    return Boolean.valueOf(this.isLinked);
  }
  
  public void setLinked(Boolean paramBoolean)
  {
    this.isLinked = paramBoolean.booleanValue();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\libwss\bean\result\GoogleAssistantLinkInfoResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */