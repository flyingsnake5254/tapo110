package com.tplink.iot.view.ipcamera.onboardingv2;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ObservableBoolean;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.databinding.FragmentCameraV2ResetBinding;
import com.tplink.iot.view.ipcamera.base.c;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.ResetCameraViewModel;

public class CameraResetFragment
  extends OnBoardingFragment<FragmentCameraV2ResetBinding, ResetCameraViewModel>
{
  public int A0()
  {
    return 2131558894;
  }
  
  public ResetCameraViewModel G0()
  {
    return (ResetCameraViewModel)ViewModelProviders.of(this).get(ResetCameraViewModel.class);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131362037) {
      if (this.q.j.get()) {
        this.f.e0("CameraConnectRouterFragment.TAG", null);
      } else {
        this.f.e0("CameraCheckStatusFragment.TAG", null);
      }
    }
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    ((FragmentCameraV2ResetBinding)this.c).x.setNavigationOnClickListener(new r0(this));
    ((FragmentCameraV2ResetBinding)this.c).d.setImageResource(c.m(this.q.D()));
    ((FragmentCameraV2ResetBinding)this.c).q.setText(c.p(this.q.D()));
    if (this.q.j.get()) {
      this.f.y0("CameraConnectRouterFragment.TAG");
    } else {
      this.f.y0("CameraCheckStatusFragment.TAG");
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\onboardingv2\CameraResetFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */