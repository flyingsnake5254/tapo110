package com.tplink.iot.viewmodel.ipcamera.onboardingv2;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;

public class CameraSearchAfterSetupViewModel
  extends OnBoardingFragmentViewModel
{
  public final ObservableBoolean a = new ObservableBoolean(true);
  
  public CameraSearchAfterSetupViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\onboardingv2\CameraSearchAfterSetupViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */