package com.tplink.iot.databinding;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.devices.lightstrip.viewmodel.effects.ColorPaintingMakeViewModel;
import com.tplink.iot.devices.lightstrip.widget.ColorPaintingSegmentView;
import com.tplink.iot.widget.BrightnessSeekBar;
import com.tplink.iot.widget.ItemSettingLayout;

public abstract class ActivityColorPaintingMakeBinding
  extends ViewDataBinding
{
  @NonNull
  public final BrightnessSeekBar c;
  @NonNull
  public final Button d;
  @NonNull
  public final Button f;
  @NonNull
  public final TextView p0;
  @Bindable
  protected View.OnClickListener p1;
  @Bindable
  protected ColorPaintingMakeViewModel p2;
  @NonNull
  public final ColorPaintingSegmentView q;
  @NonNull
  public final CardView x;
  @NonNull
  public final ItemSettingLayout y;
  @NonNull
  public final ImageView z;
  
  protected ActivityColorPaintingMakeBinding(Object paramObject, View paramView, int paramInt, BrightnessSeekBar paramBrightnessSeekBar, Button paramButton1, Button paramButton2, ColorPaintingSegmentView paramColorPaintingSegmentView, CardView paramCardView, ItemSettingLayout paramItemSettingLayout, ImageView paramImageView, TextView paramTextView)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramBrightnessSeekBar;
    this.d = paramButton1;
    this.f = paramButton2;
    this.q = paramColorPaintingSegmentView;
    this.x = paramCardView;
    this.y = paramItemSettingLayout;
    this.z = paramImageView;
    this.p0 = paramTextView;
  }
  
  public abstract void h(@Nullable View.OnClickListener paramOnClickListener);
  
  public abstract void i(@Nullable ColorPaintingMakeViewModel paramColorPaintingMakeViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityColorPaintingMakeBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */