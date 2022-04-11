package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraInstallHelpfulItemsViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;

public abstract class FragmentCameraV2InstallHelpfulItemsBinding
  extends ViewDataBinding
{
  @NonNull
  public final LinearLayout c;
  @NonNull
  public final ImageView d;
  @NonNull
  public final Toolbar f;
  @Bindable
  protected g p0;
  @NonNull
  public final TextView q;
  @NonNull
  public final TextView x;
  @Bindable
  protected CameraInstallHelpfulItemsViewModel y;
  @Bindable
  protected CameraOnBoardingViewModel z;
  
  protected FragmentCameraV2InstallHelpfulItemsBinding(Object paramObject, View paramView, int paramInt, LinearLayout paramLinearLayout, ImageView paramImageView, Toolbar paramToolbar, TextView paramTextView1, TextView paramTextView2)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramLinearLayout;
    this.d = paramImageView;
    this.f = paramToolbar;
    this.q = paramTextView1;
    this.x = paramTextView2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentCameraV2InstallHelpfulItemsBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */