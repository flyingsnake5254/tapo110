package com.tplink.iot.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.devices.lightstrip.widget.LightingEffectPresetStatusView;

public abstract class FragmentLightStripScheduleBinding
  extends ViewDataBinding
{
  @NonNull
  public final LightingEffectPresetStatusView c;
  @NonNull
  public final FrameLayout d;
  @NonNull
  public final RadioGroup f;
  @NonNull
  public final RadioButton q;
  @NonNull
  public final RadioButton x;
  
  protected FragmentLightStripScheduleBinding(Object paramObject, View paramView, int paramInt, LightingEffectPresetStatusView paramLightingEffectPresetStatusView, FrameLayout paramFrameLayout, RadioGroup paramRadioGroup, RadioButton paramRadioButton1, RadioButton paramRadioButton2)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramLightingEffectPresetStatusView;
    this.d = paramFrameLayout;
    this.f = paramRadioGroup;
    this.q = paramRadioButton1;
    this.x = paramRadioButton2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentLightStripScheduleBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */