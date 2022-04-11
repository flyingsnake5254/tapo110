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
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraInstallGuideViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;

public abstract class FragmentCameraV2InstallGuideBinding
  extends ViewDataBinding
{
  @NonNull
  public final TextView c;
  @NonNull
  public final LinearLayout d;
  @NonNull
  public final ImageView f;
  @Bindable
  protected g p0;
  @NonNull
  public final Toolbar q;
  @NonNull
  public final Button x;
  @Bindable
  protected CameraInstallGuideViewModel y;
  @Bindable
  protected CameraOnBoardingViewModel z;
  
  protected FragmentCameraV2InstallGuideBinding(Object paramObject, View paramView, int paramInt, TextView paramTextView, LinearLayout paramLinearLayout, ImageView paramImageView, Toolbar paramToolbar, Button paramButton)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramTextView;
    this.d = paramLinearLayout;
    this.f = paramImageView;
    this.q = paramToolbar;
    this.x = paramButton;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentCameraV2InstallGuideBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */