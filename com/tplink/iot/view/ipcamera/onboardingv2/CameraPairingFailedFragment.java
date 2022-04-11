package com.tplink.iot.view.ipcamera.onboardingv2;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.databinding.FragmentCameraV2PairingFailedBinding;
import com.tplink.iot.view.ipcamera.base.c;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.PairingFailedViewModel;
import com.tplink.iot.widget.PointTextView;
import com.tplink.libtpnetwork.cameranetwork.bean.DeviceModel;

public class CameraPairingFailedFragment
  extends OnBoardingFragment<FragmentCameraV2PairingFailedBinding, PairingFailedViewModel>
{
  private void J0()
  {
    ((FragmentCameraV2PairingFailedBinding)this.c).q.setContent(getString(c.j(this.q.D(), this.q.F()), new Object[] { this.q.a.get() }));
    ((FragmentCameraV2PairingFailedBinding)this.c).x.setContent(getString(c.l(this.q.D(), this.q.F(), this.q.k.get())));
    ((FragmentCameraV2PairingFailedBinding)this.c).y.setContent(getString(c.k(this.q.D(), this.q.F())));
  }
  
  public int A0()
  {
    return 2131558891;
  }
  
  public PairingFailedViewModel G0()
  {
    return (PairingFailedViewModel)ViewModelProviders.of(this).get(PairingFailedViewModel.class);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131362037) {
      this.f.e0("CameraSearchAfterSetupFragment.TAG", null);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    DeviceModel localDeviceModel = this.q.D();
    d.a0(getActivity(), ((FragmentCameraV2PairingFailedBinding)this.c).p0, localDeviceModel, this.q.B());
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.f.q0();
    J0();
    ((FragmentCameraV2PairingFailedBinding)this.c).z.setNavigationOnClickListener(new q0(this));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\onboardingv2\CameraPairingFailedFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */