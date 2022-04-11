package com.tplink.iot.databinding;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.appbar.AppBarLayout;
import com.tplink.iot.view.ipcamera.setting.RecordCustomSettingView;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.setting.AreaIntrusionScheduleViewModel;

public abstract class ActivityIntrusionScheduleSettingBinding
  extends ViewDataBinding
{
  @NonNull
  public final Toolbar H3;
  @NonNull
  public final AppBarLayout I3;
  @Bindable
  protected AreaIntrusionScheduleViewModel J3;
  @Bindable
  protected View.OnClickListener K3;
  @Bindable
  protected RadioGroup.OnCheckedChangeListener L3;
  @NonNull
  public final TextView c;
  @NonNull
  public final CameraLoadingView d;
  @NonNull
  public final TextView f;
  @NonNull
  public final LinearLayout p0;
  @NonNull
  public final LinearLayout p1;
  @NonNull
  public final LinearLayout p2;
  @NonNull
  public final AppCompatImageView p3;
  @NonNull
  public final TextView q;
  @NonNull
  public final TextView x;
  @NonNull
  public final TextView y;
  @NonNull
  public final RecordCustomSettingView z;
  
  protected ActivityIntrusionScheduleSettingBinding(Object paramObject, View paramView, int paramInt, TextView paramTextView1, CameraLoadingView paramCameraLoadingView, TextView paramTextView2, TextView paramTextView3, TextView paramTextView4, TextView paramTextView5, RecordCustomSettingView paramRecordCustomSettingView, LinearLayout paramLinearLayout1, LinearLayout paramLinearLayout2, LinearLayout paramLinearLayout3, AppCompatImageView paramAppCompatImageView, Toolbar paramToolbar, AppBarLayout paramAppBarLayout)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramTextView1;
    this.d = paramCameraLoadingView;
    this.f = paramTextView2;
    this.q = paramTextView3;
    this.x = paramTextView4;
    this.y = paramTextView5;
    this.z = paramRecordCustomSettingView;
    this.p0 = paramLinearLayout1;
    this.p1 = paramLinearLayout2;
    this.p2 = paramLinearLayout3;
    this.p3 = paramAppCompatImageView;
    this.H3 = paramToolbar;
    this.I3 = paramAppBarLayout;
  }
  
  public abstract void h(@Nullable View.OnClickListener paramOnClickListener);
  
  public abstract void i(@Nullable AreaIntrusionScheduleViewModel paramAreaIntrusionScheduleViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityIntrusionScheduleSettingBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */