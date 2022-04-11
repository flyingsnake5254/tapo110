package com.tplink.iot.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.widget.BrightnessSeekBar;
import com.tplink.iot.widget.colorbulb.ColorTempWrapView;

public abstract class FragmentColorTemperatureSettingBinding
  extends ViewDataBinding
{
  @NonNull
  public final BrightnessSeekBar c;
  @NonNull
  public final ColorTempWrapView d;
  
  protected FragmentColorTemperatureSettingBinding(Object paramObject, View paramView, int paramInt, BrightnessSeekBar paramBrightnessSeekBar, ColorTempWrapView paramColorTempWrapView)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramBrightnessSeekBar;
    this.d = paramColorTempWrapView;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentColorTemperatureSettingBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */