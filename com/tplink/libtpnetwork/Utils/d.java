package com.tplink.libtpnetwork.Utils;

import android.text.TextUtils;
import b.d.b.f.b;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.CloudVideoRepository;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CameraSettingRepository;
import com.tplink.libtpnetwork.cameranetwork.model.CameraComponent;
import com.tplink.libtpnetwork.cameranetwork.model.ComponentType;
import com.tplink.libtpnetwork.cameranetwork.model.ServiceList;
import com.tplink.libtpnetwork.cameranetwork.model.SettingsData;
import io.reactivex.q;

public class d
{
  public static boolean a(ComponentType paramComponentType, String paramString)
  {
    ALCameraDevice localALCameraDevice = (ALCameraDevice)TPIoTClientManager.I1(paramString);
    if ((localALCameraDevice != null) && (localALCameraDevice.getCameraComponent() != null) && (localALCameraDevice.getCameraComponent().isSupportSubscriptionService()))
    {
      paramString = c(paramString);
      if (paramString == null) {
        return false;
      }
      if (paramComponentType == null) {
        return false;
      }
      return paramString.isComponentNeedSubscription(paramComponentType) ^ true;
    }
    return false;
  }
  
  public static q<ServiceList> b(String paramString)
  {
    ALCameraDevice localALCameraDevice = (ALCameraDevice)TPIoTClientManager.I1(paramString);
    if ((localALCameraDevice != null) && (localALCameraDevice.getCameraComponent() != null) && (localALCameraDevice.getCameraComponent().isSupportSubscriptionService())) {
      return ((CameraSettingRepository)e.c(paramString, CameraSettingRepository.class)).J();
    }
    return q.I();
  }
  
  public static ServiceList c(String paramString)
  {
    CameraSettingRepository localCameraSettingRepository = (CameraSettingRepository)e.c(paramString, CameraSettingRepository.class);
    if (localCameraSettingRepository.x() != null) {
      return localCameraSettingRepository.x().getTapoCareNeedPayFunctionList();
    }
    return (ServiceList)i.b(o.h0().A(paramString), ServiceList.class);
  }
  
  public static boolean d(String paramString)
  {
    boolean bool1 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    paramString = TPIoTClientManager.K1(paramString);
    if (paramString == null) {
      return false;
    }
    paramString = (ALCameraDevice)paramString.getCameraDevice();
    if (paramString == null) {
      return false;
    }
    String str = paramString.getDeviceId();
    paramString = (CloudVideoRepository)b.a(b.d.s.a.a.f(), CloudVideoRepository.class);
    bool1 = bool2;
    if (paramString.h0())
    {
      bool1 = bool2;
      if (paramString.i0(str)) {
        bool1 = true;
      }
    }
    paramString = new StringBuilder();
    paramString.append("当前设备支持TapoCare：");
    paramString.append(bool1);
    b.d.w.c.a.d(paramString.toString());
    return bool1;
  }
  
  public static boolean e(String paramString)
  {
    return ((CloudVideoRepository)b.a(b.d.s.a.a.f(), CloudVideoRepository.class)).l0(paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\Utils\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */