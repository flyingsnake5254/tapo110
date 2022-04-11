package com.tplink.iot.viewmodel.ipcamera.onboardingv2;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;

public class CameraSetNameViewModel
  extends OnBoardingFragmentViewModel
{
  public final ObservableBoolean a = new ObservableBoolean(true);
  
  public CameraSetNameViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
  }
  
  public boolean f(String paramString)
  {
    boolean bool1 = false;
    int i;
    try
    {
      i = paramString.getBytes("UTF-8").length;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      i = 0;
    }
    boolean bool2 = bool1;
    if (i > 0)
    {
      bool2 = bool1;
      if (i <= 32) {
        bool2 = true;
      }
    }
    return bool2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\onboardingv2\CameraSetNameViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */