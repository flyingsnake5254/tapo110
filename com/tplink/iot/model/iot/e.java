package com.tplink.iot.model.iot;

import com.tplink.iot.cloud.bean.thing.common.ThingFirmware;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.LoadInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import kotlin.jvm.internal.j;

public final class e
{
  private BaseALIoTDevice<?> a;
  private LoadInfoBean b;
  private ThingFirmware c;
  
  public e(BaseALIoTDevice<?> paramBaseALIoTDevice)
  {
    this(paramBaseALIoTDevice, null, null, 6, null);
  }
  
  public e(BaseALIoTDevice<?> paramBaseALIoTDevice, LoadInfoBean paramLoadInfoBean, ThingFirmware paramThingFirmware)
  {
    this.a = paramBaseALIoTDevice;
    this.b = paramLoadInfoBean;
    this.c = paramThingFirmware;
  }
  
  public final ThingFirmware a()
  {
    return this.c;
  }
  
  public final BaseALIoTDevice<?> b()
  {
    return this.a;
  }
  
  public final String c()
  {
    Object localObject = this.b;
    if (localObject != null) {
      localObject = ((LoadInfoBean)localObject).getLoadLevel();
    } else {
      localObject = null;
    }
    return (String)localObject;
  }
  
  public final boolean d()
  {
    ThingFirmware localThingFirmware = this.c;
    boolean bool;
    if (localThingFirmware != null) {
      bool = localThingFirmware.isNeedToUpgrade();
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final void e(ThingFirmware paramThingFirmware)
  {
    this.c = paramThingFirmware;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof e))
      {
        paramObject = (e)paramObject;
        if ((j.a(this.a, ((e)paramObject).a)) && (j.a(this.b, ((e)paramObject).b)) && (j.a(this.c, ((e)paramObject).c))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final void f(BaseALIoTDevice<?> paramBaseALIoTDevice)
  {
    j.e(paramBaseALIoTDevice, "<set-?>");
    this.a = paramBaseALIoTDevice;
  }
  
  public final void g(LoadInfoBean paramLoadInfoBean)
  {
    this.b = paramLoadInfoBean;
  }
  
  public int hashCode()
  {
    Object localObject = this.a;
    int i = 0;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.b;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    localObject = this.c;
    if (localObject != null) {
      i = localObject.hashCode();
    }
    return (j * 31 + k) * 31 + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SubGSetupHubCandidateBean(hub=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", loadInfo=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", firmware=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\model\iot\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */