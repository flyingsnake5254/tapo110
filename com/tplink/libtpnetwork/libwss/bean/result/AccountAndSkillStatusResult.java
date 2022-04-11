package com.tplink.libtpnetwork.libwss.bean.result;

import com.tplink.libtpnetwork.libwss.enumerate.WssAccountLinkStatus;
import com.tplink.libtpnetwork.libwss.enumerate.WssFfsLinkStatus;
import com.tplink.libtpnetwork.libwss.enumerate.WssSkillEnableStatus;

public class AccountAndSkillStatusResult
{
  private WssAccountLinkStatus accountLinkStatus;
  private WssFfsLinkStatus ffsLinkStatus;
  private WssSkillEnableStatus skillEnableStatus;
  
  public WssAccountLinkStatus getAccountLinkStatus()
  {
    return this.accountLinkStatus;
  }
  
  public WssFfsLinkStatus getFfsLinkStatus()
  {
    return this.ffsLinkStatus;
  }
  
  public WssSkillEnableStatus getSkillEnableStatus()
  {
    return this.skillEnableStatus;
  }
  
  public boolean isStatusOk()
  {
    boolean bool;
    if ((this.accountLinkStatus == WssAccountLinkStatus.LINKED) && (this.skillEnableStatus == WssSkillEnableStatus.ENABLED)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void setAccountLinkStatus(WssAccountLinkStatus paramWssAccountLinkStatus)
  {
    this.accountLinkStatus = paramWssAccountLinkStatus;
  }
  
  public void setFfsLinkStatus(WssFfsLinkStatus paramWssFfsLinkStatus)
  {
    this.ffsLinkStatus = paramWssFfsLinkStatus;
  }
  
  public void setSkillEnableStatus(WssSkillEnableStatus paramWssSkillEnableStatus)
  {
    this.skillEnableStatus = paramWssSkillEnableStatus;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\libwss\bean\result\AccountAndSkillStatusResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */