package com.tplink.iot.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraManualInputPwdViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.widget.DrawableEditText;

public abstract class FragmentCameraV2ManualInputPwdBinding
  extends ViewDataBinding
{
  @Bindable
  protected g H3;
  @NonNull
  public final Button c;
  @NonNull
  public final DrawableEditText d;
  @NonNull
  public final DrawableEditText f;
  @NonNull
  public final TextView p0;
  @NonNull
  public final TextView p1;
  @Bindable
  protected CameraManualInputPwdViewModel p2;
  @Bindable
  protected CameraOnBoardingViewModel p3;
  @NonNull
  public final RelativeLayout q;
  @NonNull
  public final Toolbar x;
  @NonNull
  public final TextView y;
  @NonNull
  public final TextView z;
  
  protected FragmentCameraV2ManualInputPwdBinding(Object paramObject, View paramView, int paramInt, Button paramButton, DrawableEditText paramDrawableEditText1, DrawableEditText paramDrawableEditText2, RelativeLayout paramRelativeLayout, Toolbar paramToolbar, TextView paramTextView1, TextView paramTextView2, TextView paramTextView3, TextView paramTextView4)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramButton;
    this.d = paramDrawableEditText1;
    this.f = paramDrawableEditText2;
    this.q = paramRelativeLayout;
    this.x = paramToolbar;
    this.y = paramTextView1;
    this.z = paramTextView2;
    this.p0 = paramTextView3;
    this.p1 = paramTextView4;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentCameraV2ManualInputPwdBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */