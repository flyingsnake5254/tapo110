package com.tplink.iot.view.ipcamera.onboardingv2;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ObservableBoolean;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.databinding.FragmentCameraV2ConfiguredBeforeBinding;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraCannotWifiViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;

public class CameraConfiguredBeforeFragment
  extends OnBoardingFragment<FragmentCameraV2ConfiguredBeforeBinding, CameraCannotWifiViewModel>
{
  private boolean x = false;
  
  public int A0()
  {
    return 2131558870;
  }
  
  public CameraCannotWifiViewModel G0()
  {
    return (CameraCannotWifiViewModel)ViewModelProviders.of(this).get(CameraCannotWifiViewModel.class);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131364354)
    {
      if (i == 2131364382) {
        if (this.x)
        {
          this.q.j2(true);
          z1 localz1 = this.f;
          if (this.q.j.get()) {
            paramView = "CameraWiredCompleteFragment.TAG";
          } else {
            paramView = "CameraRescanWifiFragment.TAG";
          }
          localz1.e0(paramView, null);
        }
        else
        {
          s0.l(getActivity());
          this.q.Q1(false);
        }
      }
    }
    else if (this.x)
    {
      s0.l(getActivity());
      this.q.Q1(true);
    }
    else
    {
      this.q.o2(20001);
    }
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    ((FragmentCameraV2ConfiguredBeforeBinding)this.c).d.setNavigationOnClickListener(new f(this));
    if (getArguments() != null) {
      this.x = getArguments().getBoolean("is_same_account", false);
    }
    paramView = ((FragmentCameraV2ConfiguredBeforeBinding)this.c).x;
    int i;
    if (this.x) {
      i = 2131951992;
    } else {
      i = 2131951994;
    }
    paramView.setText(getString(i));
    if (!this.x)
    {
      ((FragmentCameraV2ConfiguredBeforeBinding)this.c).y.setText(getString(2131951995));
      ((FragmentCameraV2ConfiguredBeforeBinding)this.c).z.setText(getString(2131951996));
    }
    paramView = ((FragmentCameraV2ConfiguredBeforeBinding)this.c).q;
    boolean bool = this.x;
    int j = 2131951993;
    if (bool) {
      i = 2131951991;
    } else {
      i = 2131951993;
    }
    paramView.setText(getString(i));
    paramView = ((FragmentCameraV2ConfiguredBeforeBinding)this.c).f;
    if (this.x) {
      i = j;
    } else {
      i = 2131951990;
    }
    paramView.setText(getString(i));
    ((FragmentCameraV2ConfiguredBeforeBinding)this.c).q.setOnClickListener(this);
    ((FragmentCameraV2ConfiguredBeforeBinding)this.c).f.setOnClickListener(this);
    this.q.J().observe(getViewLifecycleOwner(), new g(this));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\onboardingv2\CameraConfiguredBeforeFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */