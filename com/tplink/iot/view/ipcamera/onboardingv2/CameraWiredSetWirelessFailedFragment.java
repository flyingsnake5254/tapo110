package com.tplink.iot.view.ipcamera.onboardingv2;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.d0;
import com.tplink.iot.databinding.FragmentCameraWiredSetWirelessFailedBinding;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraWiredSetWirelessFailedViewModel;

public class CameraWiredSetWirelessFailedFragment
  extends OnBoardingFragment<FragmentCameraWiredSetWirelessFailedBinding, CameraWiredSetWirelessFailedViewModel>
{
  public int A0()
  {
    return 2131558906;
  }
  
  public CameraWiredSetWirelessFailedViewModel G0()
  {
    return (CameraWiredSetWirelessFailedViewModel)ViewModelProviders.of(this).get(CameraWiredSetWirelessFailedViewModel.class);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131362037) {
      this.f.e0("CameraWiredConnectApFragment.TAG", null);
    }
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.f.q0();
    ((FragmentCameraWiredSetWirelessFailedBinding)this.c).y.setNavigationOnClickListener(new w1(this));
    d0.h(((FragmentCameraWiredSetWirelessFailedBinding)this.c).z, getString(2131952027), ContextCompat.getColor(requireContext(), 2131099811), new v1(this));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\onboardingv2\CameraWiredSetWirelessFailedFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */