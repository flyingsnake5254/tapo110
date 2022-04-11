package com.tplink.iot.view.ipcamera.onboardingv2;

import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.x0.f;
import com.tplink.iot.databinding.FragmentCameraV2CompleteBinding;
import com.tplink.iot.view.ipcamera.base.c;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraCompleteViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import io.reactivex.q;

public class CameraCompleteFragment
  extends OnBoardingFragment<FragmentCameraV2CompleteBinding, CameraCompleteViewModel>
{
  private void G0()
  {
    if ((this.q.f0()) && (!this.q.a0())) {
      this.f.e0("CameraAutoUpdateHintFragment.TAG", null);
    } else {
      this.f.e0("CameraSdHintFragment.TAG", null);
    }
  }
  
  private void I0()
  {
    f.a(this.q.B(), this.q.z());
  }
  
  private void J0()
  {
    f.n(this.q.B(), this.q.C(), (String)this.q.c.get(), this.q.j.get());
  }
  
  public int A0()
  {
    return 2131558869;
  }
  
  public CameraCompleteViewModel H0()
  {
    return (CameraCompleteViewModel)ViewModelProviders.of(this).get(CameraCompleteViewModel.class);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131362055)
    {
      if (i == 2131362071) {
        this.f.e0("CameraBeforeInstallFragment.TAG", null);
      }
    }
    else {
      G0();
    }
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.f.q0();
    ((FragmentCameraV2CompleteBinding)this.c).f.setImageResource(c.a(this.q.D()));
    if (!this.q.j.get())
    {
      J0();
      I0();
    }
    ((FragmentCameraV2CompleteBinding)this.c).d.setVisibility(H0().f(this.q.D()));
    ((FragmentCameraV2CompleteBinding)this.c).d.getPaint().setFlags(8);
    this.q.p();
    this.q.r().F0();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\onboardingv2\CameraCompleteFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */