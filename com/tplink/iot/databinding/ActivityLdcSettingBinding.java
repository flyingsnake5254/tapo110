package com.tplink.iot.databinding;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LiveData;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.setting.LdcSettingViewModel;

public abstract class ActivityLdcSettingBinding
  extends ViewDataBinding
{
  @NonNull
  public final View c;
  @NonNull
  public final CheckBox d;
  @NonNull
  public final CameraLoadingView f;
  @NonNull
  public final TextView q;
  @NonNull
  public final TextView x;
  @Bindable
  protected LdcSettingViewModel y;
  @Bindable
  protected LiveData<Boolean> z;
  
  protected ActivityLdcSettingBinding(Object paramObject, View paramView1, int paramInt, View paramView2, CheckBox paramCheckBox, CameraLoadingView paramCameraLoadingView, TextView paramTextView1, TextView paramTextView2)
  {
    super(paramObject, paramView1, paramInt);
    this.c = paramView2;
    this.d = paramCheckBox;
    this.f = paramCameraLoadingView;
    this.q = paramTextView1;
    this.x = paramTextView2;
  }
  
  public abstract void h(@Nullable LdcSettingViewModel paramLdcSettingViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityLdcSettingBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */