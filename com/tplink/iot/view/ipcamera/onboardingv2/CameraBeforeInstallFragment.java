package com.tplink.iot.view.ipcamera.onboardingv2;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.databinding.FragmentCameraV2BeforeInstallBinding;
import com.tplink.iot.view.ipcamera.base.c;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraBeforeInstallViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;

public class CameraBeforeInstallFragment
  extends OnBoardingFragment<FragmentCameraV2BeforeInstallBinding, CameraBeforeInstallViewModel>
{
  public int A0()
  {
    return 2131558866;
  }
  
  public CameraBeforeInstallViewModel G0()
  {
    return (CameraBeforeInstallViewModel)ViewModelProviders.of(this).get(CameraBeforeInstallViewModel.class);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131362083)
    {
      if (i == 2131363744) {
        this.f.e0("CameraCompleteFragment.TAG", null);
      }
    }
    else {
      this.f.e0("CameraInstallGuideFragment.TAG", null);
    }
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    ((FragmentCameraV2BeforeInstallBinding)this.c).x.setNavigationOnClickListener(new b(this));
    if (c.v(this.q.D())) {
      ((FragmentCameraV2BeforeInstallBinding)this.c).z.setVisibility(0);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\onboardingv2\CameraBeforeInstallFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */