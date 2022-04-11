package com.tplink.iot.databinding;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.devices.lightstrip.viewmodel.effects.CustomizedEffectsMakeViewModel;
import com.tplink.iot.devices.lightstrip.widget.DiscreteSeekBarTextView;
import com.tplink.iot.devices.lightstrip.widget.multicolorpalette.MultiColorPaletteView;
import com.tplink.iot.widget.BrightnessSeekBar;
import com.tplink.iot.widget.ItemSettingLayout;

public abstract class ActivityCustomizedEffectsMakeBinding
  extends ViewDataBinding
{
  @Bindable
  protected CustomizedEffectsMakeViewModel H3;
  @NonNull
  public final BrightnessSeekBar c;
  @NonNull
  public final Button d;
  @NonNull
  public final Button f;
  @NonNull
  public final SeekBar p0;
  @NonNull
  public final SeekBar p1;
  @NonNull
  public final TextView p2;
  @Bindable
  protected View.OnClickListener p3;
  @NonNull
  public final DiscreteSeekBarTextView q;
  @NonNull
  public final ItemSettingLayout x;
  @NonNull
  public final MultiColorPaletteView y;
  @NonNull
  public final RecyclerView z;
  
  protected ActivityCustomizedEffectsMakeBinding(Object paramObject, View paramView, int paramInt, BrightnessSeekBar paramBrightnessSeekBar, Button paramButton1, Button paramButton2, DiscreteSeekBarTextView paramDiscreteSeekBarTextView, ItemSettingLayout paramItemSettingLayout, MultiColorPaletteView paramMultiColorPaletteView, RecyclerView paramRecyclerView, SeekBar paramSeekBar1, SeekBar paramSeekBar2, TextView paramTextView)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramBrightnessSeekBar;
    this.d = paramButton1;
    this.f = paramButton2;
    this.q = paramDiscreteSeekBarTextView;
    this.x = paramItemSettingLayout;
    this.y = paramMultiColorPaletteView;
    this.z = paramRecyclerView;
    this.p0 = paramSeekBar1;
    this.p1 = paramSeekBar2;
    this.p2 = paramTextView;
  }
  
  public abstract void h(@Nullable View.OnClickListener paramOnClickListener);
  
  public abstract void i(@Nullable CustomizedEffectsMakeViewModel paramCustomizedEffectsMakeViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityCustomizedEffectsMakeBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */