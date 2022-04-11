package com.tplink.iot.view.ipcamera.onboardingv2;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.databinding.FragmentCameraV2IdentifyBinding;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraIdentifyViewModel;

public class CameraIdentifyFragment
  extends OnBoardingFragment<FragmentCameraV2IdentifyBinding, CameraIdentifyViewModel>
{
  public int A0()
  {
    return 2131558874;
  }
  
  public CameraIdentifyViewModel G0()
  {
    return (CameraIdentifyViewModel)ViewModelProviders.of(this).get(CameraIdentifyViewModel.class);
  }
  
  public void onClick(View paramView) {}
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    ((FragmentCameraV2IdentifyBinding)this.c).c.setNavigationOnClickListener(new z(this));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\onboardingv2\CameraIdentifyFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */