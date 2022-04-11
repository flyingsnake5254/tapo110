package com.tplink.iot.databinding;

import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.setting.AutoRebootSettingViewModel;
import com.tplink.iot.widget.NumberPickerView;

public abstract class ActivityAutoRebootBinding
  extends ViewDataBinding
{
  @NonNull
  public final CheckBox c;
  @NonNull
  public final RelativeLayout d;
  @NonNull
  public final LinearLayout f;
  @NonNull
  public final CameraLoadingView q;
  @NonNull
  public final TextView x;
  @NonNull
  public final NumberPickerView y;
  @Bindable
  protected AutoRebootSettingViewModel z;
  
  protected ActivityAutoRebootBinding(Object paramObject, View paramView, int paramInt, CheckBox paramCheckBox, RelativeLayout paramRelativeLayout, LinearLayout paramLinearLayout, CameraLoadingView paramCameraLoadingView, TextView paramTextView, NumberPickerView paramNumberPickerView)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramCheckBox;
    this.d = paramRelativeLayout;
    this.f = paramLinearLayout;
    this.q = paramCameraLoadingView;
    this.x = paramTextView;
    this.y = paramNumberPickerView;
  }
  
  public abstract void h(@Nullable AutoRebootSettingViewModel paramAutoRebootSettingViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityAutoRebootBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */