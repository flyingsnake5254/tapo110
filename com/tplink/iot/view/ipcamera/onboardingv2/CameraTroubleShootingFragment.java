package com.tplink.iot.view.ipcamera.onboardingv2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.x0.f;
import com.tplink.iot.databinding.FragmentCameraV2TroubleShootingBinding;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraTroubleShootingViewModel;

public class CameraTroubleShootingFragment
  extends OnBoardingFragment<FragmentCameraV2TroubleShootingBinding, CameraTroubleShootingViewModel>
{
  public int A0()
  {
    return 2131558901;
  }
  
  public CameraTroubleShootingViewModel G0()
  {
    return (CameraTroubleShootingViewModel)ViewModelProviders.of(this).get(CameraTroubleShootingViewModel.class);
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131362037) && (getActivity() != null))
    {
      f.m(this.q.B());
      getActivity().finish();
    }
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    ((CameraTroubleShootingViewModel)this.d).f(this.q.D());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\onboardingv2\CameraTroubleShootingFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */