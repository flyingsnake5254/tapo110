package com.tplink.iot.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.InputPwdViewModel;
import com.tplink.iot.widget.DrawableEditText;

public abstract class FragmentCameraV2InputPwdBinding
  extends ViewDataBinding
{
  @Bindable
  protected CameraOnBoardingViewModel H3;
  @Bindable
  protected g I3;
  @NonNull
  public final Button c;
  @NonNull
  public final CheckBox d;
  @NonNull
  public final DrawableEditText f;
  @NonNull
  public final TextView p0;
  @NonNull
  public final TextView p1;
  @NonNull
  public final TextView p2;
  @Bindable
  protected InputPwdViewModel p3;
  @NonNull
  public final LinearLayout q;
  @NonNull
  public final Toolbar x;
  @NonNull
  public final TextView y;
  @NonNull
  public final TextView z;
  
  protected FragmentCameraV2InputPwdBinding(Object paramObject, View paramView, int paramInt, Button paramButton, CheckBox paramCheckBox, DrawableEditText paramDrawableEditText, LinearLayout paramLinearLayout, Toolbar paramToolbar, TextView paramTextView1, TextView paramTextView2, TextView paramTextView3, TextView paramTextView4, TextView paramTextView5)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramButton;
    this.d = paramCheckBox;
    this.f = paramDrawableEditText;
    this.q = paramLinearLayout;
    this.x = paramToolbar;
    this.y = paramTextView1;
    this.z = paramTextView2;
    this.p0 = paramTextView3;
    this.p1 = paramTextView4;
    this.p2 = paramTextView5;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentCameraV2InputPwdBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */