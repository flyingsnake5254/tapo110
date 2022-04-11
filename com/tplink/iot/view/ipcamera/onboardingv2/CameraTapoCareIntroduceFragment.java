package com.tplink.iot.view.ipcamera.onboardingv2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.cloud.bean.cloudvideo.common.DeviceCloudProduct;
import com.tplink.iot.databinding.FragmentCameraV2IntroduceTapoCareBinding;
import com.tplink.iot.view.main.MainActivity;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraTapoCareIntroduceViewModel;
import com.tplink.libtpnetwork.TDPNetwork.bean.TDPCameraDevice;
import io.reactivex.g0.g;
import io.reactivex.q;

public class CameraTapoCareIntroduceFragment
  extends OnBoardingFragment<FragmentCameraV2IntroduceTapoCareBinding, CameraTapoCareIntroduceViewModel>
{
  private void G0()
  {
    if (getActivity() != null) {
      startActivity(new Intent(getActivity(), MainActivity.class));
    }
  }
  
  public int A0()
  {
    return 2131558882;
  }
  
  public CameraTapoCareIntroduceViewModel H0()
  {
    return (CameraTapoCareIntroduceViewModel)ViewModelProviders.of(this).get(CameraTapoCareIntroduceViewModel.class);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131362073: 
      ((CameraTapoCareIntroduceViewModel)this.d).g(getActivity(), this.q.B().getDeviceId());
      break;
    case 2131362072: 
      ((CameraTapoCareIntroduceViewModel)this.d).f(getActivity());
      break;
    case 2131362055: 
    case 2131362058: 
      G0();
    }
  }
  
  @SuppressLint({"CheckResult"})
  public void onResume()
  {
    super.onResume();
    this.q.r().G0(new a());
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.f.q0();
    ((FragmentCameraV2IntroduceTapoCareBinding)this.c).f.setOnClickListener(this);
    ((FragmentCameraV2IntroduceTapoCareBinding)this.c).f.getPaint().setFlags(8);
    ((FragmentCameraV2IntroduceTapoCareBinding)this.c).q.setOnClickListener(this);
    paramBundle = ((FragmentCameraV2IntroduceTapoCareBinding)this.c).q;
    paramView = getActivity().getString(2131954233);
    int i = 0;
    paramBundle.setText(String.format(paramView, new Object[] { "30" }));
    ((FragmentCameraV2IntroduceTapoCareBinding)this.c).q.getPaint().setFlags(8);
    ((FragmentCameraV2IntroduceTapoCareBinding)this.c).q.setVisibility(this.q.S());
    ((FragmentCameraV2IntroduceTapoCareBinding)this.c).d.setVisibility(this.q.S());
    paramView = ((FragmentCameraV2IntroduceTapoCareBinding)this.c).c;
    if (this.q.S() != 8) {
      i = 8;
    }
    paramView.setVisibility(i);
    ((FragmentCameraV2IntroduceTapoCareBinding)this.c).d.setOnClickListener(this);
    ((FragmentCameraV2IntroduceTapoCareBinding)this.c).d.getPaint().setFlags(8);
  }
  
  class a
    implements g<DeviceCloudProduct>
  {
    a() {}
    
    public void a(DeviceCloudProduct paramDeviceCloudProduct)
      throws Exception
    {
      paramDeviceCloudProduct = CameraTapoCareIntroduceFragment.this;
      ((FragmentCameraV2IntroduceTapoCareBinding)paramDeviceCloudProduct.c).q.setVisibility(paramDeviceCloudProduct.q.S());
      paramDeviceCloudProduct = CameraTapoCareIntroduceFragment.this;
      ((FragmentCameraV2IntroduceTapoCareBinding)paramDeviceCloudProduct.c).d.setVisibility(paramDeviceCloudProduct.q.S());
      paramDeviceCloudProduct = CameraTapoCareIntroduceFragment.this;
      Button localButton = ((FragmentCameraV2IntroduceTapoCareBinding)paramDeviceCloudProduct.c).c;
      int i = paramDeviceCloudProduct.q.S();
      int j = 8;
      if (i == 8) {
        j = 0;
      }
      localButton.setVisibility(j);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\onboardingv2\CameraTapoCareIntroduceFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */