package com.tplink.iot.view.ipcamera.onboardingv2;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.databinding.FragmentCameraV2SaveSettingBinding;
import com.tplink.iot.view.ipcamera.base.c;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraSaveSettingViewModel;
import com.tplink.libtpcontrols.TPRippleBackground;
import com.tplink.libtpnetwork.TDPNetwork.bean.TDPCameraDevice;

public class CameraSaveSettingFragment
  extends OnBoardingFragment<FragmentCameraV2SaveSettingBinding, CameraSaveSettingViewModel>
{
  private void G0()
  {
    ((FragmentCameraV2SaveSettingBinding)this.c).q.f();
  }
  
  private void I0()
  {
    if (isAdded()) {
      ((CameraSaveSettingViewModel)this.d).a.set(getString(2131953236));
    }
    ((FragmentCameraV2SaveSettingBinding)this.c).q.e();
  }
  
  private void L0(String paramString1, String paramString2)
  {
    ((CameraSaveSettingViewModel)this.d).h(paramString1, paramString2);
  }
  
  private void N0()
  {
    ((FragmentCameraV2SaveSettingBinding)this.c).f.setImageResource(c.e(this.q.D()));
  }
  
  public int A0()
  {
    return 2131558897;
  }
  
  public CameraSaveSettingViewModel H0()
  {
    return (CameraSaveSettingViewModel)ViewModelProviders.of(this).get(CameraSaveSettingViewModel.class);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131362831)
    {
      if (!isAdded()) {
        return;
      }
      this.q.o2(20001);
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    G0();
  }
  
  public void onResume()
  {
    super.onResume();
    this.q.g2();
    this.q.G().observe(this, new y0(this));
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    I0();
    N0();
    this.f.q0();
    if (!this.q.l.get())
    {
      paramView = this.q;
      paramBundle = paramView.X;
      if (paramView.B() != null) {
        paramView = this.q.B().getDeviceId();
      } else {
        paramView = null;
      }
      L0(paramBundle, paramView);
      this.q.l.set(true);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\onboardingv2\CameraSaveSettingFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */