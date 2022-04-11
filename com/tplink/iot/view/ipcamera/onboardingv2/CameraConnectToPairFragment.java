package com.tplink.iot.view.ipcamera.onboardingv2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.databinding.ObservableField;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.d0;
import com.tplink.iot.Utils.d0.g;
import com.tplink.iot.Utils.x0.f;
import com.tplink.iot.databinding.FragmentCameraV2ConnectToPairBinding;
import com.tplink.iot.view.ipcamera.base.AutoRefreshTimer;
import com.tplink.iot.view.ipcamera.base.AutoRefreshTimer.a;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraConnectToPairViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.widget.UniversalDialog.a;

public class CameraConnectToPairFragment
  extends OnBoardingFragment<FragmentCameraV2ConnectToPairBinding, CameraConnectToPairViewModel>
  implements AutoRefreshTimer.a
{
  private AutoRefreshTimer x;
  
  private void H0()
  {
    if (this.q.V())
    {
      AutoRefreshTimer localAutoRefreshTimer = new AutoRefreshTimer(0L, 2000L, this);
      this.x = localAutoRefreshTimer;
      localAutoRefreshTimer.a(this);
    }
  }
  
  private void Q0()
  {
    if (!this.q.V())
    {
      f.t(this.q.B());
      this.f.e0("CameraSearchAfterSetupFragment.TAG", null);
    }
    CameraOnBoardingViewModel localCameraOnBoardingViewModel = this.q;
    if (!localCameraOnBoardingViewModel.Y((String)localCameraOnBoardingViewModel.a.get())) {
      R0((String)this.q.a.get());
    }
  }
  
  private void R0(String paramString)
  {
    if (!isAdded()) {
      return;
    }
    paramString = new UniversalDialog.a().q(getString(2131951954, new Object[] { paramString })).u(getString(2131952397)).s(getString(2131951757)).t(new o(this)).l();
    FragmentTransaction localFragmentTransaction = getChildFragmentManager().beginTransaction();
    localFragmentTransaction.add(paramString, "");
    localFragmentTransaction.commitAllowingStateLoss();
  }
  
  public int A0()
  {
    return 2131558872;
  }
  
  public CameraConnectToPairViewModel I0()
  {
    return (CameraConnectToPairViewModel)ViewModelProviders.of(this).get(CameraConnectToPairViewModel.class);
  }
  
  public void h()
  {
    if (!this.q.V()) {
      return;
    }
    CameraOnBoardingViewModel localCameraOnBoardingViewModel = this.q;
    if (localCameraOnBoardingViewModel.Y((String)localCameraOnBoardingViewModel.a.get())) {
      requireActivity().runOnUiThread(new n(this));
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131362826)
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
    paramBundle = (String)this.q.a.get();
    TextView localTextView = ((FragmentCameraV2ConnectToPairBinding)this.c).x;
    paramView = paramBundle;
    if (paramBundle == null) {
      paramView = "";
    }
    localTextView.setText(getString(2131953618, new Object[] { paramView }));
    d0.h(((FragmentCameraV2ConnectToPairBinding)this.c).q, getString(2131953492), ContextCompat.getColor(requireContext(), 2131099811), new a());
  }
  
  class a
    implements d0.g
  {
    a() {}
    
    public void a()
    {
      CameraConnectToPairFragment.G0(CameraConnectToPairFragment.this);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\onboardingv2\CameraConnectToPairFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */