package com.tplink.libtpnetwork.IoTNetwork.bean.common.params;

import com.tplink.libtpnetwork.Utils.x;
import java.util.Locale;

public class SyncEnvParams
{
  private String lang;
  
  public SyncEnvParams() {}
  
  public SyncEnvParams(Locale paramLocale)
  {
    this.lang = x.d(paramLocale);
  }
  
  public String getLang()
  {
    return this.lang;
  }
  
  public void setLang(String paramString)
  {
    this.lang = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\common\params\SyncEnvParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */