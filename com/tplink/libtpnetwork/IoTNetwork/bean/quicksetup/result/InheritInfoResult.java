package com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result;

import com.google.gson.q.c;

public class InheritInfoResult
{
  @c("inherit_status")
  private boolean inheritStatus;
  
  public boolean isInheritStatus()
  {
    return this.inheritStatus;
  }
  
  public void setInheritStatus(boolean paramBoolean)
  {
    this.inheritStatus = paramBoolean;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\quicksetup\result\InheritInfoResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */