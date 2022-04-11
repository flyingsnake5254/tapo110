package com.tplink.iot.Utils.w0;

import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.enumerate.EnumIoTComponent;

public class a
{
  public static int a(String paramString, EnumIoTComponent paramEnumIoTComponent)
  {
    paramString = b(paramString);
    if ((paramString != null) && (paramString.getLocalIoTDevice() != null)) {
      return paramString.getLocalIoTDevice().getComponentVersion(paramEnumIoTComponent);
    }
    return 0;
  }
  
  public static ALIoTDevice b(String paramString)
  {
    return (ALIoTDevice)TPIoTClientManager.k2(paramString).getIoTDevice();
  }
  
  public static boolean c(String paramString)
  {
    paramString = b(paramString);
    boolean bool;
    if ((paramString != null) && (paramString.isPlugP105OfJP())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static boolean d(String paramString)
  {
    paramString = b(paramString);
    boolean bool;
    if ((paramString != null) && (paramString.isSupportCloudConnect())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static boolean e(String paramString)
  {
    paramString = b(paramString);
    boolean bool;
    if ((paramString != null) && (paramString.isSupportColorAndColorTemp())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static boolean f(ThingContext paramThingContext, EnumIoTComponent paramEnumIoTComponent)
  {
    paramThingContext = (ALIoTDevice)paramThingContext.getIoTDevice();
    boolean bool;
    if ((paramThingContext != null) && (paramThingContext.getLocalIoTDevice() != null) && (paramThingContext.getLocalIoTDevice().isSupportComponent(paramEnumIoTComponent))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static boolean g(String paramString, EnumIoTComponent paramEnumIoTComponent)
  {
    paramString = b(paramString);
    boolean bool;
    if ((paramString != null) && (paramString.getLocalIoTDevice() != null) && (paramString.getLocalIoTDevice().isSupportComponent(paramEnumIoTComponent))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static boolean h(String paramString)
  {
    paramString = b(paramString);
    boolean bool;
    if ((paramString != null) && (paramString.isSupportDefaultStates())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static boolean i(String paramString)
  {
    paramString = b(paramString);
    boolean bool;
    if ((paramString != null) && (paramString.isSupportIoTCloudComponent())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static boolean j(String paramString)
  {
    paramString = b(paramString);
    boolean bool;
    if ((paramString != null) && (paramString.isSupportLightEffect())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static boolean k(String paramString)
  {
    paramString = b(paramString);
    boolean bool;
    if ((paramString != null) && (paramString.isSupportSunriseSunset())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static boolean l(String paramString)
  {
    paramString = b(paramString);
    boolean bool;
    if ((paramString != null) && (paramString.isSupportLED())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\w0\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */