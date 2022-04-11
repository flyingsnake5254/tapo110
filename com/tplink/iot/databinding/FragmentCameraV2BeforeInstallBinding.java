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
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraBeforeInstallViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;

public abstract class FragmentCameraV2BeforeInstallBinding
  extends ViewDataBinding
{
  @NonNull
  public final Button c;
  @NonNull
  public final ImageView d;
  @NonNull
  public final LinearLayout f;
  @Bindable
  protected CameraBeforeInstallViewModel p0;
  @Bindable
  protected CameraOnBoardingViewModel p1;
  @Bindable
  protected g p2;
  @NonNull
  public final ImageView q;
  @NonNull
  public final Toolbar x;
  @NonNull
  public final TextView y;
  @NonNull
  public final TextView z;
  
  protected FragmentCameraV2BeforeInstallBinding(Object paramObject, View paramView, int paramInt, Button paramButton, ImageView paramImageView1, LinearLayout paramLinearLayout, ImageView paramImageView2, Toolbar paramToolbar, TextView paramTextView1, TextView paramTextView2)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramButton;
    this.d = paramImageView1;
    this.f = paramLinearLayout;
    this.q = paramImageView2;
    this.x = paramToolbar;
    this.y = paramTextView1;
    this.z = paramTextView2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentCameraV2BeforeInstallBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */