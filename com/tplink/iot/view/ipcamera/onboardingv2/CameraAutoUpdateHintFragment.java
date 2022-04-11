package com.tplink.iot.view.ipcamera.onboardingv2;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.databinding.FragmentCameraAutoUpdateHintBinding;
import com.tplink.iot.view.ipcamera.setting.firmware.AutoUpdateTimePickerDialog;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraAutoUpdateHintViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.widget.h;

public class CameraAutoUpdateHintFragment
  extends OnBoardingFragment<FragmentCameraAutoUpdateHintBinding, CameraAutoUpdateHintViewModel>
{
  private AutoUpdateTimePickerDialog x;
  private int y = 180;
  private String[] z = h.d();
  
  private void J0()
  {
    AutoUpdateTimePickerDialog localAutoUpdateTimePickerDialog = this.x;
    if ((localAutoUpdateTimePickerDialog != null) && (localAutoUpdateTimePickerDialog.isVisible())) {
      return;
    }
    localAutoUpdateTimePickerDialog = AutoUpdateTimePickerDialog.A0(this.y);
    this.x = localAutoUpdateTimePickerDialog;
    localAutoUpdateTimePickerDialog.B0(new a(this));
    this.x.show(getParentFragmentManager(), null);
  }
  
  public int A0()
  {
    return 2131558861;
  }
  
  public CameraAutoUpdateHintViewModel G0()
  {
    return (CameraAutoUpdateHintViewModel)ViewModelProviders.of(this).get(CameraAutoUpdateHintViewModel.class);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131361994)
    {
      if (i == 2131362068)
      {
        this.q.a2(this.y);
        this.f.e0("CameraSdHintFragment.TAG", null);
      }
    }
    else {
      J0();
    }
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.f.q0();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\onboardingv2\CameraAutoUpdateHintFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */