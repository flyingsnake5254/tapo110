package com.tplink.libtpnetwork.Utils;

import android.text.TextUtils;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.ThingDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.device.TCDeviceBean;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.model.P2PSharePwd;
import com.tplink.libtpnetwork.enumerate.EnumDeviceStatus;
import com.tplink.tdp.bean.BaseTDPDevice;

public class f
{
  public static String a(BaseALIoTDevice paramBaseALIoTDevice)
  {
    if (paramBaseALIoTDevice != null) {
      paramBaseALIoTDevice = paramBaseALIoTDevice.getTDPIoTDevice();
    } else {
      paramBaseALIoTDevice = null;
    }
    if (paramBaseALIoTDevice == null) {
      paramBaseALIoTDevice = "";
    } else {
      paramBaseALIoTDevice = paramBaseALIoTDevice.getIp();
    }
    return paramBaseALIoTDevice;
  }
  
  public static String b(BaseALIoTDevice paramBaseALIoTDevice)
  {
    boolean bool = paramBaseALIoTDevice instanceof ALCameraDevice;
    String str1 = "";
    String str2 = str1;
    if (bool)
    {
      paramBaseALIoTDevice = (ALCameraDevice)paramBaseALIoTDevice;
      str2 = str1;
      if (paramBaseALIoTDevice.getP2PSharePwd() != null) {
        str2 = paramBaseALIoTDevice.getP2PSharePwd().getSharepwd();
      }
    }
    return str2;
  }
  
  public static String c(BaseALIoTDevice paramBaseALIoTDevice)
  {
    boolean bool = paramBaseALIoTDevice instanceof ALCameraDevice;
    String str1 = "";
    String str2 = str1;
    if (bool)
    {
      paramBaseALIoTDevice = (ALCameraDevice)paramBaseALIoTDevice;
      str2 = str1;
      if (paramBaseALIoTDevice.getP2PSharePwd() != null) {
        str2 = paramBaseALIoTDevice.getP2PSharePwd().getUsername();
      }
    }
    return str2;
  }
  
  public static boolean d(BaseALIoTDevice paramBaseALIoTDevice)
  {
    boolean bool;
    if ((paramBaseALIoTDevice != null) && (paramBaseALIoTDevice.getTDPIoTDevice() != null)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static boolean e(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return d(TPIoTClientManager.I1(paramString));
  }
  
  public static boolean f(String paramString)
  {
    boolean bool = false;
    if (paramString == null) {
      return false;
    }
    if ((e(paramString)) || (j(paramString))) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean g(BaseALIoTDevice paramBaseALIoTDevice)
  {
    if (paramBaseALIoTDevice != null) {
      paramBaseALIoTDevice = paramBaseALIoTDevice.getCloudIoTDevice();
    } else {
      paramBaseALIoTDevice = null;
    }
    boolean bool;
    if (paramBaseALIoTDevice != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static boolean h(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return g(TPIoTClientManager.I1(paramString));
  }
  
  public static boolean i(BaseALIoTDevice paramBaseALIoTDevice)
  {
    TCDeviceBean localTCDeviceBean = null;
    if (paramBaseALIoTDevice != null)
    {
      localTCDeviceBean = paramBaseALIoTDevice.getCloudIoTDevice();
      paramBaseALIoTDevice = paramBaseALIoTDevice.getThingDevice();
    }
    else
    {
      paramBaseALIoTDevice = null;
    }
    boolean bool;
    if (((localTCDeviceBean != null) && (EnumDeviceStatus.STATUS_ONLINE == localTCDeviceBean.getStatus())) || ((paramBaseALIoTDevice != null) && (paramBaseALIoTDevice.isThingOnline()))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static boolean j(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return i(TPIoTClientManager.I1(paramString));
  }
  
  public static boolean k(BaseALIoTDevice paramBaseALIoTDevice)
  {
    boolean bool1 = paramBaseALIoTDevice instanceof ALCameraDevice;
    boolean bool2 = false;
    boolean bool3 = bool2;
    if (bool1)
    {
      paramBaseALIoTDevice = (ALCameraDevice)paramBaseALIoTDevice;
      if (paramBaseALIoTDevice.isUserRoleTypeDevice())
      {
        bool3 = bool2;
        if (paramBaseALIoTDevice.getP2PSharePwd() != null)
        {
          bool3 = bool2;
          if (TextUtils.isEmpty(paramBaseALIoTDevice.getP2PSharePwd().getSharepwd())) {}
        }
      }
      else
      {
        bool3 = true;
      }
    }
    return bool3;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\Utils\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */