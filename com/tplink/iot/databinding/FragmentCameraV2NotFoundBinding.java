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

public abstract class FragmentCameraV2NotFoundBinding
  extends ViewDataBinding
{
  @NonNull
  public final Button c;
  @NonNull
  public final View d;
  @NonNull
  public final View f;
  @Bindable
  protected CameraOnBoardingViewModel p0;
  @Bindable
  protected g p1;
  @Bindable
  protected View p2;
  @NonNull
  public final ImageView q;
  @NonNull
  public final LinearLayout x;
  @NonNull
  public final Toolbar y;
  @NonNull
  public final TextView z;
  
  protected FragmentCameraV2NotFoundBinding(Object paramObject, View paramView1, int paramInt, Button paramButton, View paramView2, View paramView3, ImageView paramImageView, LinearLayout paramLinearLayout, Toolbar paramToolbar, TextView paramTextView)
  {
    super(paramObject, paramView1, paramInt);
    this.c = paramButton;
    this.d = paramView2;
    this.f = paramView3;
    this.q = paramImageView;
    this.x = paramLinearLayout;
    this.y = paramToolbar;
    this.z = paramTextView;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentCameraV2NotFoundBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */