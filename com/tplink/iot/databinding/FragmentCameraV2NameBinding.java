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
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraSetNameViewModel;
import com.tplink.iot.widget.DrawableEditText;

public abstract class FragmentCameraV2NameBinding
  extends ViewDataBinding
{
  @NonNull
  public final Button c;
  @NonNull
  public final DrawableEditText d;
  @NonNull
  public final RelativeLayout f;
  @Bindable
  protected CameraOnBoardingViewModel p0;
  @Bindable
  protected g p1;
  @NonNull
  public final Toolbar q;
  @NonNull
  public final TextView x;
  @NonNull
  public final TextView y;
  @Bindable
  protected CameraSetNameViewModel z;
  
  protected FragmentCameraV2NameBinding(Object paramObject, View paramView, int paramInt, Button paramButton, DrawableEditText paramDrawableEditText, RelativeLayout paramRelativeLayout, Toolbar paramToolbar, TextView paramTextView1, TextView paramTextView2)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramButton;
    this.d = paramDrawableEditText;
    this.f = paramRelativeLayout;
    this.q = paramToolbar;
    this.x = paramTextView1;
    this.y = paramTextView2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentCameraV2NameBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */