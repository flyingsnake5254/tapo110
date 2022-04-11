package com.tplink.iot.viewmodel.ipcamera.onboardingv2;

import android.app.Application;
import androidx.annotation.NonNull;

public class CameraLocationPermissionViewModel
  extends OnBoardingFragmentViewModel
{
  private boolean a = false;
  
  public CameraLocationPermissionViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
  }
  
  public boolean f()
  {
    return this.a;
  }
  
  public void g(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\onboardingv2\CameraLocationPermissionViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */