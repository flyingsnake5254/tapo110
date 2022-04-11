package com.tplink.libtpnetwork.IoTNetwork.bean.common.result;

import com.google.gson.q.c;
import com.tplink.iot.cloud.bean.thing.common.ThingComponent;
import com.tplink.libtpnetwork.enumerate.EnumIoTComponent;
import java.io.Serializable;

public class ComponentBean
  implements Serializable
{
  private EnumIoTComponent id;
  @c("ver_code")
  private int version;
  
  public ComponentBean() {}
  
  public ComponentBean(ThingComponent paramThingComponent)
  {
    this.id = EnumIoTComponent.fromComponentName(paramThingComponent.getId());
    this.version = paramThingComponent.getVerCode();
  }
  
  public EnumIoTComponent getId()
  {
    return this.id;
  }
  
  public int getVersion()
  {
    return this.version;
  }
  
  public void setId(EnumIoTComponent paramEnumIoTComponent)
  {
    this.id = paramEnumIoTComponent;
  }
  
  public void setVersion(int paramInt)
  {
    this.version = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\common\result\ComponentBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */