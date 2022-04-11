package com.tplink.iot.databinding;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.appbar.AppBarLayout;
import com.tplink.iot.view.ipcamera.setting.RecordCustomSettingView;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.setting.RecordPlanViewModel;

public abstract class ActivityScheduleSettingBinding
  extends ViewDataBinding
{
  @NonNull
  public final LinearLayout H3;
  @NonNull
  public final LinearLayout I3;
  @NonNull
  public final AppCompatImageView J3;
  @NonNull
  public final Toolbar K3;
  @NonNull
  public final AppBarLayout L3;
  @Bindable
  protected RecordPlanViewModel M3;
  @Bindable
  protected View.OnClickListener N3;
  @Bindable
  protected RadioGroup.OnCheckedChangeListener O3;
  @NonNull
  public final TextView c;
  @NonNull
  public final AppCompatRadioButton d;
  @NonNull
  public final AppCompatRadioButton f;
  @NonNull
  public final TextView p0;
  @NonNull
  public final TextView p1;
  @NonNull
  public final RecordCustomSettingView p2;
  @NonNull
  public final LinearLayout p3;
  @NonNull
  public final CameraLoadingView q;
  @NonNull
  public final TextView x;
  @NonNull
  public final TextView y;
  @NonNull
  public final TextView z;
  
  protected ActivityScheduleSettingBinding(Object paramObject, View paramView, int paramInt, TextView paramTextView1, AppCompatRadioButton paramAppCompatRadioButton1, AppCompatRadioButton paramAppCompatRadioButton2, CameraLoadingView paramCameraLoadingView, TextView paramTextView2, TextView paramTextView3, TextView paramTextView4, TextView paramTextView5, TextView paramTextView6, RecordCustomSettingView paramRecordCustomSettingView, LinearLayout paramLinearLayout1, LinearLayout paramLinearLayout2, LinearLayout paramLinearLayout3, AppCompatImageView paramAppCompatImageView, Toolbar paramToolbar, AppBarLayout paramAppBarLayout)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramTextView1;
    this.d = paramAppCompatRadioButton1;
    this.f = paramAppCompatRadioButton2;
    this.q = paramCameraLoadingView;
    this.x = paramTextView2;
    this.y = paramTextView3;
    this.z = paramTextView4;
    this.p0 = paramTextView5;
    this.p1 = paramTextView6;
    this.p2 = paramRecordCustomSettingView;
    this.p3 = paramLinearLayout1;
    this.H3 = paramLinearLayout2;
    this.I3 = paramLinearLayout3;
    this.J3 = paramAppCompatImageView;
    this.K3 = paramToolbar;
    this.L3 = paramAppBarLayout;
  }
  
  public abstract void h(@Nullable RadioGroup.OnCheckedChangeListener paramOnCheckedChangeListener);
  
  public abstract void i(@Nullable View.OnClickListener paramOnClickListener);
  
  public abstract void l(@Nullable RecordPlanViewModel paramRecordPlanViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityScheduleSettingBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */