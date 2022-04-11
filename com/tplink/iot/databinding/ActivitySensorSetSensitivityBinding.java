package com.tplink.iot.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.viewmodel.iotsensor.SensorSetSensitivityViewModel;

public abstract class ActivitySensorSetSensitivityBinding
  extends ViewDataBinding
{
  @NonNull
  public final FrameLayout c;
  @NonNull
  public final SeekBar d;
  @Bindable
  protected SensorSetSensitivityViewModel f;
  
  protected ActivitySensorSetSensitivityBinding(Object paramObject, View paramView, int paramInt, FrameLayout paramFrameLayout, SeekBar paramSeekBar)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramFrameLayout;
    this.d = paramSeekBar;
  }
  
  public abstract void h(@Nullable SensorSetSensitivityViewModel paramSensorSetSensitivityViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivitySensorSetSensitivityBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */