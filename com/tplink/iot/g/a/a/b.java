package com.tplink.iot.g.a.a;

import com.tplink.iot.cloud.bean.thing.common.ThingFirmware;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import kotlin.jvm.internal.j;

public final class b
{
  private final BaseALIoTDevice<?> a;
  private boolean b;
  private ThingFirmware c;
  
  public b(BaseALIoTDevice<?> paramBaseALIoTDevice, boolean paramBoolean, ThingFirmware paramThingFirmware)
  {
    this.a = paramBaseALIoTDevice;
    this.b = paramBoolean;
    this.c = paramThingFirmware;
  }
  
  public final BaseALIoTDevice<?> a()
  {
    return this.a;
  }
  
  public final boolean b()
  {
    ThingFirmware localThingFirmware = this.c;
    boolean bool = true;
    if ((localThingFirmware == null) || (localThingFirmware.isNeedToUpgrade() != true)) {
      bool = false;
    }
    return bool;
  }
  
  public final boolean c()
  {
    return this.b;
  }
  
  public final void d(ThingFirmware paramThingFirmware)
  {
    this.c = paramThingFirmware;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((j.a(this.a, ((b)paramObject).a)) && (this.b == ((b)paramObject).b) && (j.a(this.c, ((b)paramObject).c))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
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
    int k = this.b;
    int m = k;
    if (k != 0) {
      m = 1;
    }
    localObject = this.c;
    if (localObject != null) {
      i = localObject.hashCode();
    }
    return (j * 31 + m) * 31 + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FeaturedActionDeviceInfo(device=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", isSupport=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", firmware=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\g\a\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */