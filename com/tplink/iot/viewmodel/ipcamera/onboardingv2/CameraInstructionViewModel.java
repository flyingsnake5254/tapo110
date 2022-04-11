package com.tplink.iot.viewmodel.ipcamera.onboardingv2;

import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tplink.libtpwifi.b;

public class CameraInstructionViewModel
  extends OnBoardingFragmentViewModel
{
  public CameraInstructionViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
  }
  
  private boolean g(String paramString)
  {
    boolean bool;
    if ((!TextUtils.isEmpty(paramString)) && (paramString.matches("Tapo_Cam_[A-Fa-f0-9]{4}"))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public String f()
  {
    String str = b.k().l();
    if (!TextUtils.isEmpty(str))
    {
      str = str.substring(1, str.length() - 1);
      if (g(str)) {
        return str;
      }
    }
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\onboardingv2\CameraInstructionViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */