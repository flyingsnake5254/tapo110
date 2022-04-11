package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraSaveSettingViewModel;
import com.tplink.libtpcontrols.TPRippleBackground;

public abstract class FragmentCameraV2SaveSettingBinding
  extends ViewDataBinding
{
  @NonNull
  public final ImageView c;
  @NonNull
  public final ImageView d;
  @NonNull
  public final ImageView f;
  @Bindable
  protected g p0;
  @NonNull
  public final TPRippleBackground q;
  @NonNull
  public final TextView x;
  @Bindable
  protected CameraSaveSettingViewModel y;
  @Bindable
  protected CameraOnBoardingViewModel z;
  
  protected FragmentCameraV2SaveSettingBinding(Object paramObject, View paramView, int paramInt, ImageView paramImageView1, ImageView paramImageView2, ImageView paramImageView3, TPRippleBackground paramTPRippleBackground, TextView paramTextView)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramImageView1;
    this.d = paramImageView2;
    this.f = paramImageView3;
    this.q = paramTPRippleBackground;
    this.x = paramTextView;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentCameraV2SaveSettingBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */