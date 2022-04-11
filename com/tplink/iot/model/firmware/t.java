package com.tplink.iot.model.firmware;

import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import com.tplink.libtpnetwork.enumerate.EnumIoTComponent;

public class t
{
  public static int a = 100;
  private String b;
  private BaseALIoTDevice c;
  private int d = 0;
  private EnumIoTSeriesState e = EnumIoTSeriesState.IDLE;
  private int f = 0;
  
  public t(BaseALIoTDevice paramBaseALIoTDevice)
  {
    this.c = paramBaseALIoTDevice;
  }
  
  public String a()
  {
    return this.c.getDeviceIdMD5();
  }
  
  public int b()
  {
    return this.d;
  }
  
  public EnumIoTSeriesState c()
  {
    return this.e;
  }
  
  public BaseALIoTDevice d()
  {
    return this.c;
  }
  
  public String e()
  {
    return this.c.getDeviceName();
  }
  
  public int f()
  {
    return this.f;
  }
  
  public String g()
  {
    return this.b;
  }
  
  public boolean h()
  {
    boolean bool;
    if (this.d == a) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean i()
  {
    boolean bool;
    if (EnumDeviceType.BULB == EnumDeviceType.fromType(this.c.getDeviceType())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean j()
  {
    boolean bool;
    if (EnumDeviceType.CAMERA == EnumDeviceType.fromType(this.c.getDeviceType())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean k()
  {
    int i = this.d;
    boolean bool;
    if ((i != 3) && (i != 4) && (i != a) && (i != 64533)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean l()
  {
    int i = this.d;
    boolean bool;
    if ((i != 3) && (i != 4)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean m()
  {
    boolean bool;
    if (this.d == 4) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean n()
  {
    return this.c.isSubDevice();
  }
  
  public boolean o()
  {
    return this.c.isSupportIoTComponent(EnumIoTComponent.BATTERY_DETECT);
  }
  
  public boolean p()
  {
    boolean bool;
    if (this.d == 64533) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void q(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void r(EnumIoTSeriesState paramEnumIoTSeriesState)
  {
    this.e = paramEnumIoTSeriesState;
  }
  
  public void s(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void t(String paramString)
  {
    this.b = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\model\firmware\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */