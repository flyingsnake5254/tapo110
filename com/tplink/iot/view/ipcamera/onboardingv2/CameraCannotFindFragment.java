package com.tplink.iot.view.ipcamera.onboardingv2;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.d0;
import com.tplink.iot.Utils.d0.g;
import com.tplink.iot.databinding.FragmentCameraV2CannotFindWifiBinding;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraCannotWifiViewModel;

public class CameraCannotFindFragment
  extends OnBoardingFragment<FragmentCameraV2CannotFindWifiBinding, CameraCannotWifiViewModel>
{
  public int A0()
  {
    return 2131558867;
  }
  
  public CameraCannotWifiViewModel G0()
  {
    return (CameraCannotWifiViewModel)ViewModelProviders.of(this).get(CameraCannotWifiViewModel.class);
  }
  
  public void onClick(View paramView) {}
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    ((FragmentCameraV2CannotFindWifiBinding)this.c).f.setNavigationOnClickListener(new c(this));
    d0.d(getActivity(), ((FragmentCameraV2CannotFindWifiBinding)this.c).q, 2131953495, getString(2131953496), new a());
  }
  
  class a
    implements d0.g
  {
    a() {}
    
    public void a()
    {
      CameraCannotFindFragment.this.f.e0("CameraManualInputPwdFragment.TAG", null);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\onboardingv2\CameraCannotFindFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */