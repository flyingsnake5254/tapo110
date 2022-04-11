package com.tplink.iot.view.ipcamera.onboardingv2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.databinding.FragmentCameraV2SdHintBinding;
import com.tplink.iot.view.ipcamera.base.c;
import com.tplink.iot.view.main.MainActivity;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraSdHintViewModel;
import com.tplink.iot.widget.PointTextView;

public class CameraSdHintFragment
  extends OnBoardingFragment<FragmentCameraV2SdHintBinding, CameraSdHintViewModel>
{
  private void G0()
  {
    if (this.q.X()) {
      this.f.e0("CameraTapoCareIntroduceFragment.TAG", null);
    } else {
      H0();
    }
  }
  
  private void H0()
  {
    if (getActivity() != null) {
      startActivity(new Intent(getActivity(), MainActivity.class));
    }
  }
  
  public int A0()
  {
    return 2131558898;
  }
  
  public CameraSdHintViewModel I0()
  {
    return (CameraSdHintViewModel)ViewModelProviders.of(this).get(CameraSdHintViewModel.class);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131362037) {
      G0();
    }
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.f.q0();
    ((FragmentCameraV2SdHintBinding)this.c).d.setImageResource(c.o(this.q.D()));
    ((FragmentCameraV2SdHintBinding)this.c).q.setContent(String.format(getString(2131951998), new Object[] { Integer.valueOf(c.n(this.q.D())) }));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\onboardingv2\CameraSdHintFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */