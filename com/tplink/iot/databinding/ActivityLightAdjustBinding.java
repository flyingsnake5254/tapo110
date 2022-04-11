package com.tplink.iot.databinding;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.setting.LightFrequencyViewModel;

public abstract class ActivityLightAdjustBinding
  extends ViewDataBinding
{
  @NonNull
  public final RadioButton c;
  @NonNull
  public final RadioButton d;
  @NonNull
  public final RadioButton f;
  @Bindable
  protected View.OnClickListener p0;
  @NonNull
  public final CameraLoadingView q;
  @NonNull
  public final RadioGroup x;
  @NonNull
  public final Toolbar y;
  @Bindable
  protected LightFrequencyViewModel z;
  
  protected ActivityLightAdjustBinding(Object paramObject, View paramView, int paramInt, RadioButton paramRadioButton1, RadioButton paramRadioButton2, RadioButton paramRadioButton3, CameraLoadingView paramCameraLoadingView, RadioGroup paramRadioGroup, Toolbar paramToolbar)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramRadioButton1;
    this.d = paramRadioButton2;
    this.f = paramRadioButton3;
    this.q = paramCameraLoadingView;
    this.x = paramRadioGroup;
    this.y = paramToolbar;
  }
  
  public abstract void h(@Nullable LightFrequencyViewModel paramLightFrequencyViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityLightAdjustBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */