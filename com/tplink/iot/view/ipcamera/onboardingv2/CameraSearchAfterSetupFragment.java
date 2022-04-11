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
import com.tplink.iot.databinding.FragmentCameraV2SearchAfterSetupBinding;
import com.tplink.iot.view.ipcamera.base.c;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraSearchAfterSetupViewModel;
import com.tplink.libtpcontrols.TPRippleBackground;
import io.reactivex.q;
import java.util.List;

public class CameraSearchAfterSetupFragment
  extends OnBoardingFragment<FragmentCameraV2SearchAfterSetupBinding, CameraSearchAfterSetupViewModel>
{
  private CountDownTimer x;
  private boolean y = false;
  private boolean z = false;
  
  private void H0()
  {
    this.x = new a(60000L, 5000L);
  }
  
  private void O0()
  {
    if (!this.z)
    {
      this.z = true;
      this.q.W1();
    }
  }
  
  private void P0()
  {
    ((FragmentCameraV2SearchAfterSetupBinding)this.c).f.setImageResource(c.e(this.q.D()));
  }
  
  private void Q0()
  {
    this.q.n2(10003);
    this.q.d0.clear();
    this.q.z.observe(this, new a1(this));
  }
  
  public int A0()
  {
    return 2131558899;
  }
  
  public CameraSearchAfterSetupViewModel G0()
  {
    return (CameraSearchAfterSetupViewModel)ViewModelProviders.of(this).get(CameraSearchAfterSetupViewModel.class);
  }
  
  public void N0()
  {
    this.q.j();
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
    ((FragmentCameraV2SearchAfterSetupBinding)this.c).q.f();
    this.q.q2();
  }
  
  public void onStart()
  {
    super.onStart();
    this.q.O1().E(new z0(this)).F0();
  }
  
  public void onStop()
  {
    super.onStop();
    CountDownTimer localCountDownTimer = this.x;
    if (localCountDownTimer != null) {
      localCountDownTimer.cancel();
    }
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    P0();
    this.f.q0();
    ((FragmentCameraV2SearchAfterSetupBinding)this.c).q.e();
    H0();
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
      CameraSearchAfterSetupFragment.this.q.q2();
      CameraSearchAfterSetupFragment.this.f.e0("CameraPairingFailedFragment.TAG", null);
    }
    
    public void onTick(long paramLong)
    {
      CameraSearchAfterSetupFragment.this.q.v();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\onboardingv2\CameraSearchAfterSetupFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */