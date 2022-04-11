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
import com.tplink.iot.Utils.x0.f;
import com.tplink.iot.Utils.y;
import com.tplink.iot.databinding.FragmentCameraV2ConnectApBinding;
import com.tplink.iot.view.ipcamera.base.AutoRefreshTimer;
import com.tplink.iot.view.ipcamera.base.AutoRefreshTimer.a;
import com.tplink.iot.view.ipcamera.base.c;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraConnectApViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.libtpcontrols.TPRippleBackground;
import com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a;
import java.util.List;

public class CameraConnectApFragment
  extends OnBoardingFragment<FragmentCameraV2ConnectApBinding, CameraConnectApViewModel>
  implements AutoRefreshTimer.a
{
  private CountDownTimer x;
  private AutoRefreshTimer y;
  
  private void H0()
  {
    if (this.q.V())
    {
      AutoRefreshTimer localAutoRefreshTimer = new AutoRefreshTimer(0L, 3000L, this);
      this.y = localAutoRefreshTimer;
      localAutoRefreshTimer.a(this);
    }
  }
  
  private void J0()
  {
    this.x = new a(60000L, 10000L);
  }
  
  private void R0()
  {
    Object localObject = this.y;
    if (localObject != null) {
      ((AutoRefreshTimer)localObject).cancel();
    }
    localObject = this.x;
    if (localObject != null) {
      ((CountDownTimer)localObject).cancel();
    }
    this.q.d0.clear();
    this.f.e0("CameraConnectToPairFragment.TAG", null);
  }
  
  private void S0()
  {
    LiveData localLiveData = this.q.H();
    if ((localLiveData != null) && (localLiveData.getValue() != null) && (((a)localLiveData.getValue()).c() != null) && (((Boolean)((a)localLiveData.getValue()).c()).booleanValue())) {
      ((CameraConnectApViewModel)this.d).g();
    } else {
      this.q.l();
    }
  }
  
  private void T0()
  {
    ((FragmentCameraV2ConnectApBinding)this.c).f.setImageResource(c.e(this.q.D()));
  }
  
  private void U0()
  {
    this.q.H().observe(this, new i(this));
    ((CameraConnectApViewModel)this.d).i().observe(this, new j(this));
    ((CameraConnectApViewModel)this.d).h().observe(this, new h(this));
  }
  
  public int A0()
  {
    return 2131558871;
  }
  
  public CameraConnectApViewModel I0()
  {
    return (CameraConnectApViewModel)ViewModelProviders.of(this).get(CameraConnectApViewModel.class);
  }
  
  public void h()
  {
    if (!this.q.V()) {
      return;
    }
    CameraOnBoardingViewModel localCameraOnBoardingViewModel = this.q;
    if (!localCameraOnBoardingViewModel.Y(localCameraOnBoardingViewModel.Q())) {
      y.b(this.q.Q(), null, null);
    }
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
    H0();
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    T0();
    this.f.q0();
    ((CameraConnectApViewModel)this.d).s(this.q);
    ((FragmentCameraV2ConnectApBinding)this.c).q.e();
    J0();
    U0();
    S0();
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
      f.u(CameraConnectApFragment.this.q.B(), CameraConnectApFragment.this.q.z());
      CameraConnectApFragment.G0(CameraConnectApFragment.this);
    }
    
    public void onTick(long paramLong) {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\onboardingv2\CameraConnectApFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */