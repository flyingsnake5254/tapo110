package com.tplink.iot.databinding;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
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
import com.tplink.iot.viewmodel.ipcamera.setting.DeviceSettingNewViewModel;

public abstract class ActivityDeviceSettingNewIpcBinding
  extends ViewDataBinding
{
  @NonNull
  public final TextView H3;
  @NonNull
  public final ImageView I3;
  @NonNull
  public final ImageView J3;
  @NonNull
  public final CheckBox K3;
  @NonNull
  public final CameraLoadingView L3;
  @NonNull
  public final RelativeLayout M3;
  @NonNull
  public final RelativeLayout N3;
  @NonNull
  public final RelativeLayout O3;
  @NonNull
  public final RelativeLayout P3;
  @NonNull
  public final TextView Q3;
  @NonNull
  public final TextView R3;
  @NonNull
  public final RelativeLayout S3;
  @NonNull
  public final TextView T3;
  @NonNull
  public final TextView U3;
  @NonNull
  public final TextView V3;
  @NonNull
  public final TextView W3;
  @NonNull
  public final TextView X3;
  @NonNull
  public final TextView Y3;
  @NonNull
  public final ImageView Z3;
  @NonNull
  public final FrameLayout a4;
  @NonNull
  public final FrameLayout b4;
  @NonNull
  public final FrameLayout c;
  @NonNull
  public final CheckBox c4;
  @NonNull
  public final ImageView d;
  @NonNull
  public final FrameLayout d4;
  @NonNull
  public final TextView e4;
  @NonNull
  public final RelativeLayout f;
  @NonNull
  public final CheckBox f4;
  @NonNull
  public final RelativeLayout g4;
  @NonNull
  public final TextView h4;
  @NonNull
  public final TextView i4;
  @NonNull
  public final FrameLayout j4;
  @NonNull
  public final RelativeLayout k4;
  @NonNull
  public final TextView l4;
  @NonNull
  public final TextView m4;
  @NonNull
  public final TextView n4;
  @NonNull
  public final Toolbar o4;
  @NonNull
  public final TextView p0;
  @NonNull
  public final TextView p1;
  @NonNull
  public final RelativeLayout p2;
  @NonNull
  public final TextView p3;
  @NonNull
  public final RelativeLayout p4;
  @NonNull
  public final TextView q;
  @NonNull
  public final TextView q4;
  @NonNull
  public final CheckBox r4;
  @NonNull
  public final TextView s4;
  @NonNull
  public final TextView t4;
  @NonNull
  public final TextView u4;
  @NonNull
  public final RelativeLayout v4;
  @NonNull
  public final TextView w4;
  @NonNull
  public final TextView x;
  @NonNull
  public final TextView x4;
  @NonNull
  public final FrameLayout y;
  @Bindable
  protected DeviceSettingNewViewModel y4;
  @NonNull
  public final ImageView z;
  @Bindable
  protected View.OnClickListener z4;
  
  protected ActivityDeviceSettingNewIpcBinding(Object paramObject, View paramView, int paramInt, FrameLayout paramFrameLayout1, ImageView paramImageView1, RelativeLayout paramRelativeLayout1, TextView paramTextView1, TextView paramTextView2, FrameLayout paramFrameLayout2, ImageView paramImageView2, TextView paramTextView3, TextView paramTextView4, RelativeLayout paramRelativeLayout2, TextView paramTextView5, TextView paramTextView6, ImageView paramImageView3, ImageView paramImageView4, CheckBox paramCheckBox1, CameraLoadingView paramCameraLoadingView, RelativeLayout paramRelativeLayout3, RelativeLayout paramRelativeLayout4, RelativeLayout paramRelativeLayout5, RelativeLayout paramRelativeLayout6, TextView paramTextView7, TextView paramTextView8, RelativeLayout paramRelativeLayout7, TextView paramTextView9, TextView paramTextView10, TextView paramTextView11, TextView paramTextView12, TextView paramTextView13, TextView paramTextView14, ImageView paramImageView5, FrameLayout paramFrameLayout3, FrameLayout paramFrameLayout4, CheckBox paramCheckBox2, FrameLayout paramFrameLayout5, TextView paramTextView15, CheckBox paramCheckBox3, RelativeLayout paramRelativeLayout8, TextView paramTextView16, TextView paramTextView17, FrameLayout paramFrameLayout6, RelativeLayout paramRelativeLayout9, TextView paramTextView18, TextView paramTextView19, TextView paramTextView20, Toolbar paramToolbar, RelativeLayout paramRelativeLayout10, TextView paramTextView21, CheckBox paramCheckBox4, TextView paramTextView22, TextView paramTextView23, TextView paramTextView24, RelativeLayout paramRelativeLayout11, TextView paramTextView25, TextView paramTextView26)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramFrameLayout1;
    this.d = paramImageView1;
    this.f = paramRelativeLayout1;
    this.q = paramTextView1;
    this.x = paramTextView2;
    this.y = paramFrameLayout2;
    this.z = paramImageView2;
    this.p0 = paramTextView3;
    this.p1 = paramTextView4;
    this.p2 = paramRelativeLayout2;
    this.p3 = paramTextView5;
    this.H3 = paramTextView6;
    this.I3 = paramImageView3;
    this.J3 = paramImageView4;
    this.K3 = paramCheckBox1;
    this.L3 = paramCameraLoadingView;
    this.M3 = paramRelativeLayout3;
    this.N3 = paramRelativeLayout4;
    this.O3 = paramRelativeLayout5;
    this.P3 = paramRelativeLayout6;
    this.Q3 = paramTextView7;
    this.R3 = paramTextView8;
    this.S3 = paramRelativeLayout7;
    this.T3 = paramTextView9;
    this.U3 = paramTextView10;
    this.V3 = paramTextView11;
    this.W3 = paramTextView12;
    this.X3 = paramTextView13;
    this.Y3 = paramTextView14;
    this.Z3 = paramImageView5;
    this.a4 = paramFrameLayout3;
    this.b4 = paramFrameLayout4;
    this.c4 = paramCheckBox2;
    this.d4 = paramFrameLayout5;
    this.e4 = paramTextView15;
    this.f4 = paramCheckBox3;
    this.g4 = paramRelativeLayout8;
    this.h4 = paramTextView16;
    this.i4 = paramTextView17;
    this.j4 = paramFrameLayout6;
    this.k4 = paramRelativeLayout9;
    this.l4 = paramTextView18;
    this.m4 = paramTextView19;
    this.n4 = paramTextView20;
    this.o4 = paramToolbar;
    this.p4 = paramRelativeLayout10;
    this.q4 = paramTextView21;
    this.r4 = paramCheckBox4;
    this.s4 = paramTextView22;
    this.t4 = paramTextView23;
    this.u4 = paramTextView24;
    this.v4 = paramRelativeLayout11;
    this.w4 = paramTextView25;
    this.x4 = paramTextView26;
  }
  
  public abstract void h(@Nullable View.OnClickListener paramOnClickListener);
  
  public abstract void i(@Nullable DeviceSettingNewViewModel paramDeviceSettingNewViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityDeviceSettingNewIpcBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */