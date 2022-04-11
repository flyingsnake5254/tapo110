package com.tplink.iot.databinding;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.setting.DeviceDetailInfoViewModel;

public abstract class ActivityDeviceDetailInfoNewIpcBinding
  extends ViewDataBinding
{
  @NonNull
  public final RelativeLayout H3;
  @NonNull
  public final TextView I3;
  @NonNull
  public final ImageView J3;
  @NonNull
  public final RelativeLayout K3;
  @NonNull
  public final TextView L3;
  @NonNull
  public final TextView M3;
  @NonNull
  public final CameraLoadingView N3;
  @NonNull
  public final RelativeLayout O3;
  @NonNull
  public final TextView P3;
  @NonNull
  public final TextView Q3;
  @NonNull
  public final LinearLayout R3;
  @NonNull
  public final TextView S3;
  @NonNull
  public final TextView T3;
  @NonNull
  public final FrameLayout U3;
  @NonNull
  public final Toolbar V3;
  @NonNull
  public final TextView W3;
  @NonNull
  public final RelativeLayout X3;
  @NonNull
  public final TextView Y3;
  @Bindable
  protected DeviceDetailInfoViewModel Z3;
  @Bindable
  protected View.OnClickListener a4;
  @NonNull
  public final RelativeLayout c;
  @NonNull
  public final RelativeLayout d;
  @NonNull
  public final LinearLayout f;
  @NonNull
  public final TextView p0;
  @NonNull
  public final RelativeLayout p1;
  @NonNull
  public final TextView p2;
  @NonNull
  public final TextView p3;
  @NonNull
  public final ImageView q;
  @NonNull
  public final TextView x;
  @NonNull
  public final TextView y;
  @NonNull
  public final ImageView z;
  
  protected ActivityDeviceDetailInfoNewIpcBinding(Object paramObject, View paramView, int paramInt, RelativeLayout paramRelativeLayout1, RelativeLayout paramRelativeLayout2, LinearLayout paramLinearLayout1, ImageView paramImageView1, TextView paramTextView1, TextView paramTextView2, ImageView paramImageView2, TextView paramTextView3, RelativeLayout paramRelativeLayout3, TextView paramTextView4, TextView paramTextView5, RelativeLayout paramRelativeLayout4, TextView paramTextView6, ImageView paramImageView3, RelativeLayout paramRelativeLayout5, TextView paramTextView7, TextView paramTextView8, CameraLoadingView paramCameraLoadingView, RelativeLayout paramRelativeLayout6, TextView paramTextView9, TextView paramTextView10, LinearLayout paramLinearLayout2, TextView paramTextView11, TextView paramTextView12, FrameLayout paramFrameLayout, Toolbar paramToolbar, TextView paramTextView13, RelativeLayout paramRelativeLayout7, TextView paramTextView14)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramRelativeLayout1;
    this.d = paramRelativeLayout2;
    this.f = paramLinearLayout1;
    this.q = paramImageView1;
    this.x = paramTextView1;
    this.y = paramTextView2;
    this.z = paramImageView2;
    this.p0 = paramTextView3;
    this.p1 = paramRelativeLayout3;
    this.p2 = paramTextView4;
    this.p3 = paramTextView5;
    this.H3 = paramRelativeLayout4;
    this.I3 = paramTextView6;
    this.J3 = paramImageView3;
    this.K3 = paramRelativeLayout5;
    this.L3 = paramTextView7;
    this.M3 = paramTextView8;
    this.N3 = paramCameraLoadingView;
    this.O3 = paramRelativeLayout6;
    this.P3 = paramTextView9;
    this.Q3 = paramTextView10;
    this.R3 = paramLinearLayout2;
    this.S3 = paramTextView11;
    this.T3 = paramTextView12;
    this.U3 = paramFrameLayout;
    this.V3 = paramToolbar;
    this.W3 = paramTextView13;
    this.X3 = paramRelativeLayout7;
    this.Y3 = paramTextView14;
  }
  
  public abstract void h(@Nullable View.OnClickListener paramOnClickListener);
  
  public abstract void i(@Nullable DeviceDetailInfoViewModel paramDeviceDetailInfoViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityDeviceDetailInfoNewIpcBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */