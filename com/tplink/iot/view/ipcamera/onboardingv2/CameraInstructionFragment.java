package com.tplink.iot.view.ipcamera.onboardingv2;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.d0;
import com.tplink.iot.Utils.d0.g;
import com.tplink.iot.databinding.FragmentCameraV2InstructionBinding;
import com.tplink.iot.view.ipcamera.base.AutoRefreshTimer;
import com.tplink.iot.view.ipcamera.base.AutoRefreshTimer.a;
import com.tplink.iot.view.ipcamera.base.e;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraInstructionViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.widget.UniversalDialog.a;
import com.tplink.libtpwifi.b;

public class CameraInstructionFragment
  extends OnBoardingFragment<FragmentCameraV2InstructionBinding, CameraInstructionViewModel>
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
    if (!this.q.V()) {
      this.f.e0("CameraConnectingFragment.TAG", null);
    }
    String str = b.k().l();
    if (TextUtils.isEmpty(((CameraInstructionViewModel)this.d).f())) {
      R0(str);
    }
  }
  
  private void R0(String paramString)
  {
    if (!isAdded()) {
      return;
    }
    paramString = new UniversalDialog.a().q(getString(2131951953)).u(getString(2131952397)).s(getString(2131951757)).t(new k0(this, paramString)).l();
    FragmentTransaction localFragmentTransaction = getChildFragmentManager().beginTransaction();
    localFragmentTransaction.add(paramString, "");
    localFragmentTransaction.commitAllowingStateLoss();
  }
  
  public int A0()
  {
    return 2131558881;
  }
  
  public CameraInstructionViewModel I0()
  {
    return (CameraInstructionViewModel)ViewModelProviders.of(this).get(CameraInstructionViewModel.class);
  }
  
  public void h()
  {
    if (!this.q.V()) {
      return;
    }
    Object localObject = ((CameraInstructionViewModel)this.d).f();
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (e.a(getActivity())))
    {
      this.q.m2((String)localObject);
      localObject = getActivity();
      if (localObject != null) {
        ((Activity)localObject).runOnUiThread(new i0(this));
      }
    }
  }
  
  public void onClick(View paramView) {}
  
  public void onDestroyView()
  {
    super.onDestroyView();
  }
  
  public void onResume()
  {
    super.onResume();
    H0();
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.f.y0("CameraCheckStatusFragment.TAG");
    ((FragmentCameraV2InstructionBinding)this.c).d.setNavigationOnClickListener(new j0(this));
    d0.h(((FragmentCameraV2InstructionBinding)this.c).f, getString(2131953492), ContextCompat.getColor(requireContext(), 2131099811), new a());
  }
  
  class a
    implements d0.g
  {
    a() {}
    
    public void a()
    {
      CameraInstructionFragment.G0(CameraInstructionFragment.this);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\onboardingv2\CameraInstructionFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */