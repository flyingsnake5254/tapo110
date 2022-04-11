package com.tplink.iot.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.widget.trv.TemperaturePresetsView;
import com.tplink.iot.widget.trv.TemperatureSeekBar;

public abstract class LayoutTemperatureSeekbarBinding
  extends ViewDataBinding
{
  @NonNull
  public final TemperaturePresetsView c;
  @NonNull
  public final TemperatureSeekBar d;
  @NonNull
  public final TextView f;
  
  protected LayoutTemperatureSeekbarBinding(Object paramObject, View paramView, int paramInt, TemperaturePresetsView paramTemperaturePresetsView, TemperatureSeekBar paramTemperatureSeekBar, TextView paramTextView)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramTemperaturePresetsView;
    this.d = paramTemperatureSeekBar;
    this.f = paramTextView;
  }
  
  @NonNull
  public static LayoutTemperatureSeekbarBinding h(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, boolean paramBoolean)
  {
    return i(paramLayoutInflater, paramViewGroup, paramBoolean, DataBindingUtil.getDefaultComponent());
  }
  
  @Deprecated
  @NonNull
  public static LayoutTemperatureSeekbarBinding i(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, boolean paramBoolean, @Nullable Object paramObject)
  {
    return (LayoutTemperatureSeekbarBinding)ViewDataBinding.inflateInternal(paramLayoutInflater, 2131559238, paramViewGroup, paramBoolean, paramObject);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\LayoutTemperatureSeekbarBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */