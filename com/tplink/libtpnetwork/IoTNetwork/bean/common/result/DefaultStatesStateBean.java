package com.tplink.libtpnetwork.IoTNetwork.bean.common.result;

import androidx.annotation.Nullable;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;

public class DefaultStatesStateBean
  extends LightStateBean
{
  public DefaultStatesStateBean() {}
  
  public DefaultStatesStateBean(@Nullable LightStateBean paramLightStateBean)
  {
    super(paramLightStateBean);
  }
  
  public com.google.gson.i toJsonTree()
  {
    return com.tplink.libtpnetwork.Utils.i.i(this);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\common\result\DefaultStatesStateBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */