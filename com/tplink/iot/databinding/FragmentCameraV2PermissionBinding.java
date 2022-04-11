package com.tplink.iot.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraPermissionViewModel;
import com.tplink.libtpcontrols.tppulltorefresh.TPCircleProgressBar;

public abstract class FragmentCameraV2PermissionBinding
  extends ViewDataBinding
{
  @Bindable
  protected g H3;
  @NonNull
  public final FrameLayout c;
  @NonNull
  public final ImageView d;
  @NonNull
  public final ImageView f;
  @NonNull
  public final TextView p0;
  @NonNull
  public final TextView p1;
  @Bindable
  protected CameraPermissionViewModel p2;
  @Bindable
  protected CameraOnBoardingViewModel p3;
  @NonNull
  public final ImageView q;
  @NonNull
  public final LinearLayout x;
  @NonNull
  public final RelativeLayout y;
  @NonNull
  public final TPCircleProgressBar z;
  
  protected FragmentCameraV2PermissionBinding(Object paramObject, View paramView, int paramInt, FrameLayout paramFrameLayout, ImageView paramImageView1, ImageView paramImageView2, ImageView paramImageView3, LinearLayout paramLinearLayout, RelativeLayout paramRelativeLayout, TPCircleProgressBar paramTPCircleProgressBar, TextView paramTextView1, TextView paramTextView2)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramFrameLayout;
    this.d = paramImageView1;
    this.f = paramImageView2;
    this.q = paramImageView3;
    this.x = paramLinearLayout;
    this.y = paramRelativeLayout;
    this.z = paramTPCircleProgressBar;
    this.p0 = paramTextView1;
    this.p1 = paramTextView2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentCameraV2PermissionBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */