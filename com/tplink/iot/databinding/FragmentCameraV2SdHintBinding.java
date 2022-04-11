package com.tplink.iot.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraSdHintViewModel;
import com.tplink.iot.widget.PointTextView;

public abstract class FragmentCameraV2SdHintBinding
  extends ViewDataBinding
{
  @NonNull
  public final Button c;
  @NonNull
  public final ImageView d;
  @NonNull
  public final LinearLayout f;
  @Bindable
  protected CameraSdHintViewModel p0;
  @Bindable
  protected CameraOnBoardingViewModel p1;
  @Bindable
  protected g p2;
  @NonNull
  public final PointTextView q;
  @NonNull
  public final PointTextView x;
  @NonNull
  public final PointTextView y;
  @NonNull
  public final Toolbar z;
  
  protected FragmentCameraV2SdHintBinding(Object paramObject, View paramView, int paramInt, Button paramButton, ImageView paramImageView, LinearLayout paramLinearLayout, PointTextView paramPointTextView1, PointTextView paramPointTextView2, PointTextView paramPointTextView3, Toolbar paramToolbar)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramButton;
    this.d = paramImageView;
    this.f = paramLinearLayout;
    this.q = paramPointTextView1;
    this.x = paramPointTextView2;
    this.y = paramPointTextView3;
    this.z = paramToolbar;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentCameraV2SdHintBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */