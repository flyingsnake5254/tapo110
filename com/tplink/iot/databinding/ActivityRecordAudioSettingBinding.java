package com.tplink.iot.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LiveData;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.setting.RecordAudioSettingViewModel;
import com.tplink.iot.widget.NoninteractiveCheckBox;

public abstract class ActivityRecordAudioSettingBinding
  extends ViewDataBinding
{
  @NonNull
  public final NoninteractiveCheckBox c;
  @NonNull
  public final CameraLoadingView d;
  @NonNull
  public final View f;
  @NonNull
  public final TextView q;
  @NonNull
  public final TextView x;
  @Bindable
  protected RecordAudioSettingViewModel y;
  @Bindable
  protected LiveData<Boolean> z;
  
  protected ActivityRecordAudioSettingBinding(Object paramObject, View paramView1, int paramInt, NoninteractiveCheckBox paramNoninteractiveCheckBox, CameraLoadingView paramCameraLoadingView, View paramView2, TextView paramTextView1, TextView paramTextView2)
  {
    super(paramObject, paramView1, paramInt);
    this.c = paramNoninteractiveCheckBox;
    this.d = paramCameraLoadingView;
    this.f = paramView2;
    this.q = paramTextView1;
    this.x = paramTextView2;
  }
  
  public abstract void h(@Nullable RecordAudioSettingViewModel paramRecordAudioSettingViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityRecordAudioSettingBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */