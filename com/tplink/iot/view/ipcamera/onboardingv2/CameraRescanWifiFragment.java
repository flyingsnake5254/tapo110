package com.tplink.iot.view.ipcamera.onboardingv2;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.x0.f;
import com.tplink.iot.Utils.y;
import com.tplink.iot.databinding.FragmentCameraV2RescanWifiBinding;
import com.tplink.iot.view.ipcamera.base.AutoRefreshTimer;
import com.tplink.iot.view.ipcamera.base.AutoRefreshTimer.a;
import com.tplink.iot.view.ipcamera.base.c;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraRescanWifiViewModel;
import com.tplink.libtpcontrols.TPRippleBackground;
import com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a;

public class CameraRescanWifiFragment
  extends OnBoardingFragment<FragmentCameraV2RescanWifiBinding, CameraRescanWifiViewModel>
  implements AutoRefreshTimer.a
{
  private AutoRefreshTimer x;
  
  private void G0()
  {
    if (this.q.V())
    {
      AutoRefreshTimer localAutoRefreshTimer = new AutoRefreshTimer(0L, 3000L, this);
      this.x = localAutoRefreshTimer;
      localAutoRefreshTimer.a(this);
    }
  }
  
  private void I0()
  {
    ((FragmentCameraV2RescanWifiBinding)this.c).f.setImageResource(c.e(this.q.D()));
  }
  
  private void J0()
  {
    y.b(this.q.Q(), null, null);
  }
  
  public int A0()
  {
    return 2131558893;
  }
  
  public CameraRescanWifiViewModel H0()
  {
    return (CameraRescanWifiViewModel)ViewModelProviders.of(this).get(CameraRescanWifiViewModel.class);
  }
  
  public void h()
  {
    if (!this.q.V()) {
      return;
    }
    CameraOnBoardingViewModel localCameraOnBoardingViewModel = this.q;
    if (!localCameraOnBoardingViewModel.Y(localCameraOnBoardingViewModel.Q())) {
      J0();
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
    G0();
    this.q.U1();
    if (!this.q.Z()) {
      this.q.y();
    }
    ((FragmentCameraV2RescanWifiBinding)this.c).q.e();
  }
  
  public void onStop()
  {
    super.onStop();
    ((FragmentCameraV2RescanWifiBinding)this.c).q.f();
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    I0();
    this.f.q0();
    this.q.L().observe(this, new a());
  }
  
  class a
    implements Observer<a<Boolean>>
  {
    a() {}
    
    public void a(@Nullable a<Boolean> parama)
    {
      parama = (Boolean)parama.a();
      if (parama == null) {
        return;
      }
      if (parama.booleanValue()) {
        f.M(CameraRescanWifiFragment.this.q.B());
      } else {
        f.L(CameraRescanWifiFragment.this.q.B());
      }
      CameraRescanWifiFragment.this.f.e0("CameraWifiListFragment.TAG", null);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\onboardingv2\CameraRescanWifiFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */