package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraInstallPreviewViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.widget.cameralive.VideoSurfaceViewLayout;
import io.reactivex.m0.d;

public abstract class FragmentCameraV2InstallPreviewBinding
  extends ViewDataBinding
{
  @Bindable
  protected d<Integer> H3;
  @Bindable
  protected String I3;
  @NonNull
  public final TextView c;
  @NonNull
  public final TextView d;
  @NonNull
  public final LinearLayout f;
  @NonNull
  public final VideoSurfaceViewLayout p0;
  @Bindable
  protected CameraInstallPreviewViewModel p1;
  @Bindable
  protected CameraOnBoardingViewModel p2;
  @Bindable
  protected g p3;
  @NonNull
  public final ImageView q;
  @NonNull
  public final Toolbar x;
  @NonNull
  public final TextView y;
  @NonNull
  public final TextView z;
  
  protected FragmentCameraV2InstallPreviewBinding(Object paramObject, View paramView, int paramInt, TextView paramTextView1, TextView paramTextView2, LinearLayout paramLinearLayout, ImageView paramImageView, Toolbar paramToolbar, TextView paramTextView3, TextView paramTextView4, VideoSurfaceViewLayout paramVideoSurfaceViewLayout)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramTextView1;
    this.d = paramTextView2;
    this.f = paramLinearLayout;
    this.q = paramImageView;
    this.x = paramToolbar;
    this.y = paramTextView3;
    this.z = paramTextView4;
    this.p0 = paramVideoSurfaceViewLayout;
  }
  
  public abstract void h(@Nullable d<Integer> paramd);
  
  public abstract void i(@Nullable String paramString);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentCameraV2InstallPreviewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */