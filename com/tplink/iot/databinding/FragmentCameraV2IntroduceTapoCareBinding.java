package com.tplink.iot.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraTapoCareIntroduceViewModel;

public abstract class FragmentCameraV2IntroduceTapoCareBinding
  extends ViewDataBinding
{
  @Bindable
  protected g H3;
  @NonNull
  public final Button c;
  @NonNull
  public final TextView d;
  @NonNull
  public final TextView f;
  @NonNull
  public final TextView p0;
  @NonNull
  public final TextView p1;
  @Bindable
  protected CameraTapoCareIntroduceViewModel p2;
  @Bindable
  protected CameraOnBoardingViewModel p3;
  @NonNull
  public final TextView q;
  @NonNull
  public final ImageView x;
  @NonNull
  public final LinearLayout y;
  @NonNull
  public final Toolbar z;
  
  protected FragmentCameraV2IntroduceTapoCareBinding(Object paramObject, View paramView, int paramInt, Button paramButton, TextView paramTextView1, TextView paramTextView2, TextView paramTextView3, ImageView paramImageView, LinearLayout paramLinearLayout, Toolbar paramToolbar, TextView paramTextView4, TextView paramTextView5)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramButton;
    this.d = paramTextView1;
    this.f = paramTextView2;
    this.q = paramTextView3;
    this.x = paramImageView;
    this.y = paramLinearLayout;
    this.z = paramToolbar;
    this.p0 = paramTextView4;
    this.p1 = paramTextView5;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentCameraV2IntroduceTapoCareBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */