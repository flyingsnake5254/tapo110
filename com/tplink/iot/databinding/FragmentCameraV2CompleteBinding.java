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
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraCompleteViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;

public abstract class FragmentCameraV2CompleteBinding
  extends ViewDataBinding
{
  @NonNull
  public final Button c;
  @NonNull
  public final TextView d;
  @NonNull
  public final ImageView f;
  @Bindable
  protected CameraCompleteViewModel p0;
  @Bindable
  protected CameraOnBoardingViewModel p1;
  @Bindable
  protected g p2;
  @NonNull
  public final LinearLayout q;
  @NonNull
  public final Toolbar x;
  @NonNull
  public final TextView y;
  @NonNull
  public final TextView z;
  
  protected FragmentCameraV2CompleteBinding(Object paramObject, View paramView, int paramInt, Button paramButton, TextView paramTextView1, ImageView paramImageView, LinearLayout paramLinearLayout, Toolbar paramToolbar, TextView paramTextView2, TextView paramTextView3)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramButton;
    this.d = paramTextView1;
    this.f = paramImageView;
    this.q = paramLinearLayout;
    this.x = paramToolbar;
    this.y = paramTextView2;
    this.z = paramTextView3;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentCameraV2CompleteBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */