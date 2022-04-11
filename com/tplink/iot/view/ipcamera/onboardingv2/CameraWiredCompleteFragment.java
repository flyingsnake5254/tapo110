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
import com.tplink.iot.Utils.x0.f;
import com.tplink.iot.databinding.FragmentCameraWiredCompleteBinding;
import com.tplink.iot.view.ipcamera.base.c;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraWiredCompleteViewModel;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;

public class CameraWiredCompleteFragment
  extends OnBoardingFragment<FragmentCameraWiredCompleteBinding, CameraWiredCompleteViewModel>
{
  private String x;
  
  private void J0()
  {
    f.a(this.q.B(), this.q.z());
  }
  
  private void K0()
  {
    f.n(this.q.B(), this.q.C(), (String)this.q.c.get(), this.q.j.get());
  }
  
  private void L0()
  {
    ((FragmentCameraWiredCompleteBinding)this.c).f.setImageResource(c.r(this.q.D()));
  }
  
  private void N0()
  {
    this.q.L().observe(this, new i1(this));
  }
  
  public int A0()
  {
    return 2131558903;
  }
  
  public CameraWiredCompleteViewModel G0()
  {
    return (CameraWiredCompleteViewModel)ViewModelProviders.of(this).get(CameraWiredCompleteViewModel.class);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131362067)
    {
      if (i == 2131362107) {
        this.f.e0("CameraCompleteFragment.TAG", null);
      }
    }
    else {
      this.q.U1();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if ("rescan".equals(this.x))
    {
      this.q.U1();
      ((FragmentCameraWiredCompleteBinding)this.c).c.g();
    }
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    L0();
    if (getArguments() != null) {
      this.x = getArguments().getString("rescan_op");
    } else {
      this.x = null;
    }
    this.f.q0();
    K0();
    J0();
    N0();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\onboardingv2\CameraWiredCompleteFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */