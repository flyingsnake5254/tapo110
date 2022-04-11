package com.tplink.iot.databinding;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.basic.RegionEditViewModel;

public abstract class ActivityPrivacyMaskZonesBinding
  extends ViewDataBinding
{
  @Nullable
  public final ImageView H3;
  @Nullable
  public final RelativeLayout I3;
  @Nullable
  public final ImageView J3;
  @NonNull
  public final CameraLoadingView K3;
  @Nullable
  public final ImageView L3;
  @NonNull
  public final View M3;
  @NonNull
  public final FrameLayout N3;
  @Nullable
  public final TextView O3;
  @NonNull
  public final ImageView P3;
  @Nullable
  public final TextView Q3;
  @Nullable
  public final TextView R3;
  @Nullable
  public final Toolbar S3;
  @Bindable
  protected RegionEditViewModel T3;
  @Bindable
  protected View.OnClickListener U3;
  @NonNull
  public final View c;
  @Nullable
  public final View d;
  @Nullable
  public final View f;
  @Nullable
  public final View p0;
  @Nullable
  public final View p1;
  @Nullable
  public final ImageView p2;
  @Nullable
  public final FrameLayout p3;
  @Nullable
  public final FrameLayout q;
  @Nullable
  public final ImageView x;
  @Nullable
  public final FrameLayout y;
  @Nullable
  public final ImageView z;
  
  protected ActivityPrivacyMaskZonesBinding(Object paramObject, View paramView1, int paramInt, View paramView2, View paramView3, View paramView4, FrameLayout paramFrameLayout1, ImageView paramImageView1, FrameLayout paramFrameLayout2, ImageView paramImageView2, View paramView5, View paramView6, ImageView paramImageView3, FrameLayout paramFrameLayout3, ImageView paramImageView4, RelativeLayout paramRelativeLayout, ImageView paramImageView5, CameraLoadingView paramCameraLoadingView, ImageView paramImageView6, View paramView7, FrameLayout paramFrameLayout4, TextView paramTextView1, ImageView paramImageView7, TextView paramTextView2, TextView paramTextView3, Toolbar paramToolbar)
  {
    super(paramObject, paramView1, paramInt);
    this.c = paramView2;
    this.d = paramView3;
    this.f = paramView4;
    this.q = paramFrameLayout1;
    this.x = paramImageView1;
    this.y = paramFrameLayout2;
    this.z = paramImageView2;
    this.p0 = paramView5;
    this.p1 = paramView6;
    this.p2 = paramImageView3;
    this.p3 = paramFrameLayout3;
    this.H3 = paramImageView4;
    this.I3 = paramRelativeLayout;
    this.J3 = paramImageView5;
    this.K3 = paramCameraLoadingView;
    this.L3 = paramImageView6;
    this.M3 = paramView7;
    this.N3 = paramFrameLayout4;
    this.O3 = paramTextView1;
    this.P3 = paramImageView7;
    this.Q3 = paramTextView2;
    this.R3 = paramTextView3;
    this.S3 = paramToolbar;
  }
  
  public abstract void h(@Nullable View.OnClickListener paramOnClickListener);
  
  public abstract void i(@Nullable RegionEditViewModel paramRegionEditViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityPrivacyMaskZonesBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */