package com.tplink.iot.view.ipcamera.onboardingv2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ObservableBoolean;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.databinding.FragmentCameraConnectTypeBinding;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraConnectTypeViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;

public class CameraConnectTypeFragment
  extends OnBoardingFragment<FragmentCameraConnectTypeBinding, CameraConnectTypeViewModel>
{
  private void J0(boolean paramBoolean)
  {
    this.q.j.set(paramBoolean);
    this.q.Y = paramBoolean;
    ((CameraConnectTypeViewModel)this.d).a.set(paramBoolean);
  }
  
  public int A0()
  {
    return 2131558863;
  }
  
  public CameraConnectTypeViewModel G0()
  {
    return (CameraConnectTypeViewModel)ViewModelProviders.of(this).get(CameraConnectTypeViewModel.class);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131364734: 
      J0(false);
      break;
    case 2131364733: 
      J0(true);
      break;
    case 2131363742: 
      if (((CameraConnectTypeViewModel)this.d).a.get())
      {
        ((FragmentCameraConnectTypeBinding)this.c).q.h();
        this.f.e0("CameraConnectRouterFragment.TAG", null);
      }
      else
      {
        ((FragmentCameraConnectTypeBinding)this.c).q.h();
        this.f.e0("CameraCheckStatusFragment.TAG", null);
      }
      break;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    ((FragmentCameraConnectTypeBinding)this.c).y.setNavigationOnClickListener(new p(this));
    J0(this.q.Y);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\onboardingv2\CameraConnectTypeFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */