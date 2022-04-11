package com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params;

import com.google.gson.q.c;

public class InheritInfoParams
{
  @c("is_inherit")
  private boolean isInherit;
  
  public InheritInfoParams(boolean paramBoolean)
  {
    this.isInherit = paramBoolean;
  }
  
  public boolean isInherit()
  {
    return this.isInherit;
  }
  
  public void setInherit(boolean paramBoolean)
  {
    this.isInherit = paramBoolean;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\quicksetup\params\InheritInfoParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */