package com.tplink.iot.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;

public abstract class ActivityCameraV2OnboardingBinding
  extends ViewDataBinding
{
  @NonNull
  public final FrameLayout c;
  @Bindable
  protected CameraOnBoardingViewModel d;
  
  protected ActivityCameraV2OnboardingBinding(Object paramObject, View paramView, int paramInt, FrameLayout paramFrameLayout)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramFrameLayout;
  }
  
  public abstract void h(@Nullable CameraOnBoardingViewModel paramCameraOnBoardingViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityCameraV2OnboardingBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */