package com.tplink.iot.viewmodel.ipcamera.onboardingv2;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.AndroidViewModel;
import com.tplink.iot.view.ipcamera.base.c;
import com.tplink.libtpnetwork.cameranetwork.bean.DeviceModel;

public class CameraInstallGuideViewModel
  extends OnBoardingFragmentViewModel
{
  public final ObservableBoolean a = new ObservableBoolean(false);
  
  public CameraInstallGuideViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
  }
  
  private int f(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            return 0;
          }
          return 2131689554;
        }
        return 2131689546;
      }
      return 2131689551;
    }
    return 2131689555;
  }
  
  private String g(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            return "";
          }
          return getApplication().getString(2131951897);
        }
        return getApplication().getString(2131951895);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(getApplication().getString(2131951898));
      localStringBuilder.append("\n\n");
      localStringBuilder.append(getApplication().getString(2131951896));
      return localStringBuilder.toString();
    }
    return getApplication().getString(2131951899);
  }
  
  private int h(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            return 0;
          }
          return 2131689549;
        }
        return 2131689547;
      }
      return 2131689552;
    }
    return 2131689555;
  }
  
  private String i(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            return "";
          }
          return getApplication().getString(2131951900);
        }
        return getApplication().getString(2131951895);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(getApplication().getString(2131951898));
      localStringBuilder.append("\n\n");
      localStringBuilder.append(getApplication().getString(2131951896));
      return localStringBuilder.toString();
    }
    return getApplication().getString(2131951899);
  }
  
  private int j(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return 0;
        }
        return 2131689548;
      }
      return 2131689553;
    }
    return 2131689555;
  }
  
  private String k(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return "";
        }
        return getApplication().getString(2131951895);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(getApplication().getString(2131951901));
      localStringBuilder.append("\n\n");
      localStringBuilder.append(getApplication().getString(2131951896));
      return localStringBuilder.toString();
    }
    return getApplication().getString(2131951899);
  }
  
  public int l(int paramInt, DeviceModel paramDeviceModel)
  {
    if (c.t(paramDeviceModel)) {
      return f(paramInt);
    }
    if (c.u(paramDeviceModel)) {
      return h(paramInt);
    }
    if (c.v(paramDeviceModel)) {
      return j(paramInt);
    }
    return h(paramInt);
  }
  
  public String m(int paramInt, DeviceModel paramDeviceModel)
  {
    if (c.t(paramDeviceModel)) {
      return g(paramInt);
    }
    if (c.u(paramDeviceModel)) {
      return i(paramInt);
    }
    if (c.v(paramDeviceModel)) {
      return k(paramInt);
    }
    return "";
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\onboardingv2\CameraInstallGuideViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */