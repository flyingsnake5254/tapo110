package com.tplink.iot.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.widget.BrightnessSeekBar;
import com.tplink.iot.widget.colorbulb.ColorPlateWrapView;

public abstract class FragmentColorLightSettingBinding
  extends ViewDataBinding
{
  @NonNull
  public final BrightnessSeekBar c;
  @NonNull
  public final ColorPlateWrapView d;
  
  protected FragmentColorLightSettingBinding(Object paramObject, View paramView, int paramInt, BrightnessSeekBar paramBrightnessSeekBar, ColorPlateWrapView paramColorPlateWrapView)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramBrightnessSeekBar;
    this.d = paramColorPlateWrapView;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentColorLightSettingBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */