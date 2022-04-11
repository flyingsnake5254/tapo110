package com.tplink.iot.view.ipcamera.base;

import androidx.annotation.ColorRes;
import b.d.w.h.b;
import com.tplink.libtpnetwork.cameranetwork.bean.DeviceModel;

public class c
{
  public static int a(DeviceModel paramDeviceModel)
  {
    int i;
    if (t(paramDeviceModel)) {
      i = 2131230920;
    } else if (u(paramDeviceModel)) {
      i = 2131230925;
    } else {
      i = 2131230928;
    }
    return i;
  }
  
  public static int b(DeviceModel paramDeviceModel)
  {
    int i;
    if (t(paramDeviceModel)) {
      i = 2131231127;
    } else if (u(paramDeviceModel)) {
      i = 2131231128;
    } else {
      i = 2131231129;
    }
    return i;
  }
  
  public static int c(DeviceModel paramDeviceModel)
  {
    int i;
    if (t(paramDeviceModel)) {
      i = 2131230967;
    } else if (u(paramDeviceModel)) {
      i = 2131230966;
    } else {
      i = 2131230968;
    }
    return i;
  }
  
  public static int d(DeviceModel paramDeviceModel)
  {
    return 2131230929;
  }
  
  public static int e(DeviceModel paramDeviceModel)
  {
    int i;
    if (t(paramDeviceModel)) {
      i = 2131230917;
    } else if (u(paramDeviceModel)) {
      i = 2131230935;
    } else {
      i = 2131230936;
    }
    return i;
  }
  
  public static int f(DeviceModel paramDeviceModel)
  {
    int i;
    if (t(paramDeviceModel)) {
      i = 2131230921;
    } else if (u(paramDeviceModel)) {
      i = 2131230926;
    } else {
      i = 2131230930;
    }
    return i;
  }
  
  public static int g(DeviceModel paramDeviceModel, String paramString)
  {
    if (s(paramDeviceModel, paramString)) {
      return 2131953246;
    }
    return 2131953247;
  }
  
  @ColorRes
  public static int h(DeviceModel paramDeviceModel, String paramString)
  {
    if (s(paramDeviceModel, paramString)) {
      return 2131099958;
    }
    return 2131099960;
  }
  
  public static int i(DeviceModel paramDeviceModel, String paramString)
  {
    if (s(paramDeviceModel, paramString)) {
      return 2131953248;
    }
    return 2131953249;
  }
  
  public static int j(DeviceModel paramDeviceModel, String paramString)
  {
    if (s(paramDeviceModel, paramString)) {
      return 2131951975;
    }
    return 2131951976;
  }
  
  public static int k(DeviceModel paramDeviceModel, String paramString)
  {
    if (s(paramDeviceModel, paramString)) {
      return 2131951982;
    }
    return 2131951981;
  }
  
  public static int l(DeviceModel paramDeviceModel, String paramString, boolean paramBoolean)
  {
    if (s(paramDeviceModel, paramString))
    {
      if (paramBoolean) {
        return 2131951978;
      }
      return 2131951984;
    }
    if (paramBoolean) {
      return 2131951979;
    }
    return 2131951985;
  }
  
  public static int m(DeviceModel paramDeviceModel)
  {
    int i;
    if (t(paramDeviceModel)) {
      i = 2131231451;
    } else if (u(paramDeviceModel)) {
      i = 2131231450;
    } else {
      i = 2131231452;
    }
    return i;
  }
  
  public static int n(DeviceModel paramDeviceModel)
  {
    if ((DeviceModel.CAMERA_C110 != paramDeviceModel) && (DeviceModel.CAMERA_C210 != paramDeviceModel) && (DeviceModel.CAMERA_C320WS != paramDeviceModel)) {
      return 128;
    }
    return 256;
  }
  
  public static int o(DeviceModel paramDeviceModel)
  {
    int i;
    if (t(paramDeviceModel)) {
      i = 2131689539;
    } else if (u(paramDeviceModel)) {
      i = 2131689541;
    } else {
      i = 2131689543;
    }
    return i;
  }
  
  public static int p(DeviceModel paramDeviceModel)
  {
    int i;
    if (t(paramDeviceModel)) {
      i = 2131953315;
    } else if (u(paramDeviceModel)) {
      i = 2131951947;
    } else {
      i = 2131952374;
    }
    return i;
  }
  
  public static int q(DeviceModel paramDeviceModel)
  {
    int i;
    if (t(paramDeviceModel)) {
      i = 2131230922;
    } else if (u(paramDeviceModel)) {
      i = 2131230927;
    } else {
      i = 2131230931;
    }
    return i;
  }
  
  public static int r(DeviceModel paramDeviceModel)
  {
    return 2131230928;
  }
  
  private static boolean s(DeviceModel paramDeviceModel, String paramString)
  {
    if (b.d(paramString)) {
      return false;
    }
    return (paramString.startsWith("1.0")) && ((paramDeviceModel == DeviceModel.CAMERA_C100) || (paramDeviceModel == DeviceModel.CAMERA_C200) || (paramDeviceModel == DeviceModel.CAMERA_TC60) || (paramDeviceModel == DeviceModel.CAMERA_TC70));
  }
  
  public static boolean t(DeviceModel paramDeviceModel)
  {
    boolean bool;
    if ((paramDeviceModel != DeviceModel.CAMERA_C100) && (paramDeviceModel != DeviceModel.CAMERA_TC60) && (paramDeviceModel != DeviceModel.CAMERA_C110)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static boolean u(DeviceModel paramDeviceModel)
  {
    boolean bool;
    if ((paramDeviceModel != DeviceModel.CAMERA_C200) && (paramDeviceModel != DeviceModel.CAMERA_TC70) && (paramDeviceModel != DeviceModel.CAMERA_C210)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static boolean v(DeviceModel paramDeviceModel)
  {
    boolean bool;
    if ((paramDeviceModel != DeviceModel.CAMERA_C310) && (paramDeviceModel != DeviceModel.CAMERA_TC65) && (paramDeviceModel != DeviceModel.CAMERA_C320WS)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static boolean w(DeviceModel paramDeviceModel)
  {
    return (DeviceModel.CAMERA_C310 == paramDeviceModel) || (DeviceModel.CAMERA_C320WS == paramDeviceModel) || (DeviceModel.CAMERA_TC65 == paramDeviceModel);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\base\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */