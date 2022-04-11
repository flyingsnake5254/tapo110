package com.tplink.iot.viewmodel.ipcamera.onboardingv2;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import com.tplink.iot.view.ipcamera.base.c;
import com.tplink.libtpnetwork.cameranetwork.bean.DeviceModel;

public class CameraCompleteViewModel
  extends OnBoardingFragmentViewModel
{
  public final ObservableBoolean a = new ObservableBoolean(false);
  
  public CameraCompleteViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
  }
  
  public int f(DeviceModel paramDeviceModel)
  {
    int i;
    if ((c.t(paramDeviceModel)) || (c.u(paramDeviceModel)) || (c.v(paramDeviceModel))) {
      i = 0;
    } else {
      i = 4;
    }
    return i;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\onboardingv2\CameraCompleteViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */