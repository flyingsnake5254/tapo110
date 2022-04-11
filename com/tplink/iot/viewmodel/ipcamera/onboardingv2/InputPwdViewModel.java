package com.tplink.iot.viewmodel.ipcamera.onboardingv2;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.WirelessInfoParams;
import com.tplink.libtpnetwork.Utils.o;

public class InputPwdViewModel
  extends OnBoardingFragmentViewModel
{
  public final ObservableBoolean a = new ObservableBoolean(false);
  private CameraOnBoardingViewModel b;
  
  public InputPwdViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
  }
  
  public void f()
  {
    WirelessInfoParams localWirelessInfoParams;
    if (this.b.e.get())
    {
      localWirelessInfoParams = new WirelessInfoParams((String)this.b.a.get(), (String)this.b.b.get(), "wpa2_psk");
      o.h0().a1(localWirelessInfoParams);
    }
    else
    {
      localWirelessInfoParams = new WirelessInfoParams((String)this.b.a.get(), "", "");
      o.h0().r0(localWirelessInfoParams);
    }
  }
  
  public void g(CameraOnBoardingViewModel paramCameraOnBoardingViewModel)
  {
    this.b = paramCameraOnBoardingViewModel;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\onboardingv2\InputPwdViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */