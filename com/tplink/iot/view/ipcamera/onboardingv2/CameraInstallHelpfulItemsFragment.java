package com.tplink.iot.view.ipcamera.onboardingv2;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.databinding.FragmentCameraV2InstallHelpfulItemsBinding;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraInstallHelpfulItemsViewModel;

public class CameraInstallHelpfulItemsFragment
  extends OnBoardingFragment<FragmentCameraV2InstallHelpfulItemsBinding, CameraInstallHelpfulItemsViewModel>
{
  public int A0()
  {
    return 2131558879;
  }
  
  public CameraInstallHelpfulItemsViewModel G0()
  {
    return (CameraInstallHelpfulItemsViewModel)ViewModelProviders.of(this).get(CameraInstallHelpfulItemsViewModel.class);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131363744) {
      this.f.e0("CameraCompleteFragment.TAG", null);
    }
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    ((FragmentCameraV2InstallHelpfulItemsBinding)this.c).f.setNavigationOnClickListener(new e0(this));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\onboardingv2\CameraInstallHelpfulItemsFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */