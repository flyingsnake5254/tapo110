package com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result;

import com.google.gson.q.c;
import java.io.Serializable;

public class QuickSetupComponentBean
  implements Serializable
{
  private String id;
  @c("ver_code")
  private int verCode;
  
  public String getId()
  {
    return this.id;
  }
  
  public int getVerCode()
  {
    return this.verCode;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setVerCode(int paramInt)
  {
    this.verCode = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\quicksetup\result\QuickSetupComponentBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */