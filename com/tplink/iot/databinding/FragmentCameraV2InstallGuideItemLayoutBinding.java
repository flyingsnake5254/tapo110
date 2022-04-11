package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraInstallGuideViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;

public abstract class FragmentCameraV2InstallGuideItemLayoutBinding
  extends ViewDataBinding
{
  @NonNull
  public final TextView c;
  @NonNull
  public final TextView d;
  @NonNull
  public final ImageView f;
  @Bindable
  protected g p0;
  @NonNull
  public final LinearLayout q;
  @NonNull
  public final TextView x;
  @Bindable
  protected CameraInstallGuideViewModel y;
  @Bindable
  protected CameraOnBoardingViewModel z;
  
  protected FragmentCameraV2InstallGuideItemLayoutBinding(Object paramObject, View paramView, int paramInt, TextView paramTextView1, TextView paramTextView2, ImageView paramImageView, LinearLayout paramLinearLayout, TextView paramTextView3)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramTextView1;
    this.d = paramTextView2;
    this.f = paramImageView;
    this.q = paramLinearLayout;
    this.x = paramTextView3;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentCameraV2InstallGuideItemLayoutBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */