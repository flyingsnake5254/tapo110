package com.tplink.iot.databinding;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.SeekBarBindingAdapter.OnStopTrackingTouch;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.play.ModeDetectionSettingsViewModel;

public abstract class ActivityModeDetectSettingBinding
  extends ViewDataBinding
{
  @NonNull
  public final CheckBox H3;
  @NonNull
  public final RelativeLayout I3;
  @NonNull
  public final TextView J3;
  @NonNull
  public final TextView K3;
  @NonNull
  public final TextView L3;
  @Bindable
  protected ModeDetectionSettingsViewModel M3;
  @Bindable
  protected View.OnClickListener N3;
  @Bindable
  protected SeekBarBindingAdapter.OnStopTrackingTouch O3;
  @NonNull
  public final LinearLayout c;
  @NonNull
  public final RelativeLayout d;
  @NonNull
  public final TextView f;
  @NonNull
  public final LinearLayout p0;
  @NonNull
  public final LinearLayout p1;
  @NonNull
  public final Toolbar p2;
  @NonNull
  public final LinearLayout p3;
  @NonNull
  public final TextView q;
  @NonNull
  public final CameraLoadingView x;
  @NonNull
  public final LinearLayout y;
  @NonNull
  public final LinearLayout z;
  
  protected ActivityModeDetectSettingBinding(Object paramObject, View paramView, int paramInt, LinearLayout paramLinearLayout1, RelativeLayout paramRelativeLayout1, TextView paramTextView1, TextView paramTextView2, CameraLoadingView paramCameraLoadingView, LinearLayout paramLinearLayout2, LinearLayout paramLinearLayout3, LinearLayout paramLinearLayout4, LinearLayout paramLinearLayout5, Toolbar paramToolbar, LinearLayout paramLinearLayout6, CheckBox paramCheckBox, RelativeLayout paramRelativeLayout2, TextView paramTextView3, TextView paramTextView4, TextView paramTextView5)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramLinearLayout1;
    this.d = paramRelativeLayout1;
    this.f = paramTextView1;
    this.q = paramTextView2;
    this.x = paramCameraLoadingView;
    this.y = paramLinearLayout2;
    this.z = paramLinearLayout3;
    this.p0 = paramLinearLayout4;
    this.p1 = paramLinearLayout5;
    this.p2 = paramToolbar;
    this.p3 = paramLinearLayout6;
    this.H3 = paramCheckBox;
    this.I3 = paramRelativeLayout2;
    this.J3 = paramTextView3;
    this.K3 = paramTextView4;
    this.L3 = paramTextView5;
  }
  
  public abstract void h(@Nullable View.OnClickListener paramOnClickListener);
  
  public abstract void i(@Nullable ModeDetectionSettingsViewModel paramModeDetectionSettingsViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityModeDetectSettingBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */