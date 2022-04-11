package com.tplink.iot.viewmodel.ipcamera.onboardingv2;

import android.app.Activity;
import android.app.Application;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import com.tplink.iot.Utils.v0.e;
import com.tplink.iot.view.tapocare.BillingActivity;
import com.tplink.iot.view.tapocare.TrialDialogActivity;

public class CameraTapoCareIntroduceViewModel
  extends OnBoardingFragmentViewModel
{
  public final ObservableBoolean a = new ObservableBoolean(false);
  
  public CameraTapoCareIntroduceViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
  }
  
  public void f(Activity paramActivity)
  {
    BillingActivity.f1(paramActivity, e.x());
  }
  
  public void g(Activity paramActivity, String paramString)
  {
    TrialDialogActivity.f1(paramActivity, e.k(paramString));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\onboardingv2\CameraTapoCareIntroduceViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */