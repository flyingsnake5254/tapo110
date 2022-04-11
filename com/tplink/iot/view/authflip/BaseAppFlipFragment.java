package com.tplink.iot.view.authflip;

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
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.view.ipcamera.onboardingv2.z1;
import com.tplink.iot.viewmodel.authflip.AppFlipAuthViewModel;
import java.util.Objects;

public abstract class BaseAppFlipFragment
  extends Fragment
{
  protected View c;
  protected z1 d;
  protected AppFlipAuthViewModel f;
  
  @LayoutRes
  public abstract int A0();
  
  protected void B0()
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
  
  public void onAttach(@NonNull Context paramContext)
  {
    super.onAttach(paramContext);
    if ((getActivity() instanceof z1)) {
      this.d = ((z1)getActivity());
    }
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    this.c = paramLayoutInflater.inflate(A0(), paramViewGroup, false);
    paramLayoutInflater = getActivity();
    Objects.requireNonNull(paramLayoutInflater);
    this.f = ((AppFlipAuthViewModel)ViewModelProviders.of((FragmentActivity)paramLayoutInflater).get(AppFlipAuthViewModel.class));
    return this.c;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    B0();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\authflip\BaseAppFlipFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */