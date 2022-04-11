package com.tplink.iot.view.ipcamera.onboardingv2;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.databinding.FragmentCameraWiredConnectApBinding;
import com.tplink.iot.view.ipcamera.base.c;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraWiredConnectApViewModel;
import com.tplink.libtpcontrols.TPRippleBackground;
import com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a;
import java.util.List;

public class CameraWiredConnectApFragment
  extends OnBoardingFragment<FragmentCameraWiredConnectApBinding, CameraWiredConnectApViewModel>
{
  private CountDownTimer x;
  
  private void H0()
  {
    this.x = new a(60000L, 10000L);
  }
  
  private void P0()
  {
    CountDownTimer localCountDownTimer = this.x;
    if (localCountDownTimer != null) {
      localCountDownTimer.cancel();
    }
    this.q.d0.clear();
    this.f.e0("CameraCompleteFragment.TAG", null);
  }
  
  private void Q0()
  {
    LiveData localLiveData = this.q.H();
    if ((localLiveData != null) && (localLiveData.getValue() != null) && (((a)localLiveData.getValue()).c() != null) && (((Boolean)((a)localLiveData.getValue()).c()).booleanValue())) {
      ((CameraWiredConnectApViewModel)this.d).g();
    } else {
      this.q.l();
    }
  }
  
  private void R0()
  {
    ((FragmentCameraWiredConnectApBinding)this.c).f.setImageResource(c.e(this.q.D()));
  }
  
  private void S0()
  {
    this.q.H().observe(this, new k1(this));
    ((CameraWiredConnectApViewModel)this.d).i().observe(this, new l1(this));
    ((CameraWiredConnectApViewModel)this.d).h().observe(this, new j1(this));
  }
  
  public int A0()
  {
    return 2131558904;
  }
  
  public CameraWiredConnectApViewModel G0()
  {
    return (CameraWiredConnectApViewModel)ViewModelProviders.of(this).get(CameraWiredConnectApViewModel.class);
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
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    R0();
    this.f.q0();
    ((CameraWiredConnectApViewModel)this.d).s(this.q);
    ((FragmentCameraWiredConnectApBinding)this.c).q.e();
    H0();
    S0();
    Q0();
  }
  
  class a
    extends CountDownTimer
  {
    a(long paramLong1, long paramLong2)
    {
      super(paramLong2);
    }
    
    public void onFinish()
    {
      CameraWiredConnectApFragment.this.f.e0("CameraWiredSetWirelessFailedFragment.TAG", null);
    }
    
    public void onTick(long paramLong) {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\onboardingv2\CameraWiredConnectApFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */