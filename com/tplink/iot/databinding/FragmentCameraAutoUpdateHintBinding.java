package com.tplink.iot.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraAutoUpdateHintViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;

public abstract class FragmentCameraAutoUpdateHintBinding
  extends ViewDataBinding
{
  @NonNull
  public final TextView c;
  @NonNull
  public final Button d;
  @NonNull
  public final RelativeLayout f;
  @NonNull
  public final LinearLayout q;
  @Bindable
  protected CameraAutoUpdateHintViewModel x;
  @Bindable
  protected CameraOnBoardingViewModel y;
  @Bindable
  protected g z;
  
  protected FragmentCameraAutoUpdateHintBinding(Object paramObject, View paramView, int paramInt, TextView paramTextView, Button paramButton, RelativeLayout paramRelativeLayout, LinearLayout paramLinearLayout)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramTextView;
    this.d = paramButton;
    this.f = paramRelativeLayout;
    this.q = paramLinearLayout;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentCameraAutoUpdateHintBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */