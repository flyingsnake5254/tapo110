package com.tplink.iot.view.ipcamera.onboardingv2;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.OnBoardingFragmentViewModel;
import java.util.Objects;

public abstract class OnBoardingFragment<VDB extends ViewDataBinding, V extends OnBoardingFragmentViewModel>
  extends Fragment
  implements g
{
  protected VDB c;
  protected V d;
  protected z1 f;
  protected CameraOnBoardingViewModel q;
  
  @LayoutRes
  public abstract int A0();
  
  public abstract V B0();
  
  protected void C0()
  {
    Object localObject = getActivity();
    if (localObject == null) {
      return;
    }
    View localView = ((Activity)localObject).getWindow().peekDecorView();
    if (localView != null)
    {
      localObject = (InputMethodManager)((Activity)localObject).getSystemService("input_method");
      if (localObject == null) {
        return;
      }
      ((InputMethodManager)localObject).hideSoftInputFromWindow(localView.getWindowToken(), 0);
    }
  }
  
  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    if ((getActivity() instanceof z1)) {
      this.f = ((z1)getActivity());
    }
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    this.c = DataBindingUtil.inflate(paramLayoutInflater, A0(), paramViewGroup, false);
    paramLayoutInflater = getActivity();
    Objects.requireNonNull(paramLayoutInflater);
    this.q = ((CameraOnBoardingViewModel)ViewModelProviders.of((FragmentActivity)paramLayoutInflater).get(CameraOnBoardingViewModel.class));
    paramViewGroup = this.d;
    paramLayoutInflater = paramViewGroup;
    if (paramViewGroup == null) {
      paramLayoutInflater = B0();
    }
    this.d = paramLayoutInflater;
    this.c.setVariable(103, paramLayoutInflater);
    this.c.setVariable(68, this.q);
    this.c.setVariable(79, this);
    return this.c.getRoot();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    C0();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\onboardingv2\OnBoardingFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */