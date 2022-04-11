package com.tplink.libtpnetwork.libwss.bean.result;

import com.tplink.libtpnetwork.libwss.enumerate.WssProvisionStatus;

public class ProvisionableStatusResult
{
  private WssProvisionStatus status;
  
  public WssProvisionStatus getStatus()
  {
    return this.status;
  }
  
  public void setStatus(WssProvisionStatus paramWssProvisionStatus)
  {
    this.status = paramWssProvisionStatus;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\libwss\bean\result\ProvisionableStatusResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */