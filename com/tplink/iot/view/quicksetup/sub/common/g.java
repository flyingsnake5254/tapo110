package com.tplink.iot.view.quicksetup.sub.common;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.j;

public final class g
{
  public static final g a = new g();
  
  public static final e a(SubDeviceModel paramSubDeviceModel)
  {
    j.e(paramSubDeviceModel, "model");
    switch (f.a[paramSubDeviceModel.ordinal()])
    {
    default: 
      throw new NoWhenBranchMatchedException();
    case 7: 
      paramSubDeviceModel = e.b.b;
      break;
    case 6: 
      paramSubDeviceModel = new i();
      break;
    case 5: 
      paramSubDeviceModel = h.b.b;
      break;
    case 4: 
      paramSubDeviceModel = h.a.b;
      break;
    case 3: 
      paramSubDeviceModel = new a();
      break;
    case 2: 
      paramSubDeviceModel = new b();
      break;
    case 1: 
      paramSubDeviceModel = new c();
    }
    return paramSubDeviceModel;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\sub\common\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */