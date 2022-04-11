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
import com.tplink.iot.viewmodel.ipcamera.setting.DiagnoseSettingViewModel;

public abstract class ActivityDiagnoseStatusBinding
  extends ViewDataBinding
{
  @NonNull
  public final View c;
  @NonNull
  public final CheckBox d;
  @NonNull
  public final CameraLoadingView f;
  @Bindable
  protected LiveData<Boolean> p0;
  @NonNull
  public final TextView q;
  @NonNull
  public final TextView x;
  @NonNull
  public final TextView y;
  @Bindable
  protected DiagnoseSettingViewModel z;
  
  protected ActivityDiagnoseStatusBinding(Object paramObject, View paramView1, int paramInt, View paramView2, CheckBox paramCheckBox, CameraLoadingView paramCameraLoadingView, TextView paramTextView1, TextView paramTextView2, TextView paramTextView3)
  {
    super(paramObject, paramView1, paramInt);
    this.c = paramView2;
    this.d = paramCheckBox;
    this.f = paramCameraLoadingView;
    this.q = paramTextView1;
    this.x = paramTextView2;
    this.y = paramTextView3;
  }
  
  public abstract void h(@Nullable DiagnoseSettingViewModel paramDiagnoseSettingViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityDiagnoseStatusBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */