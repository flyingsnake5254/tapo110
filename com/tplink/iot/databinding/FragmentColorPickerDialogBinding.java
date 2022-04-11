package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.widget.BrightnessSeekBar;
import com.tplink.iot.widget.colorbulb.ColorPlateWrapView;

public abstract class FragmentColorPickerDialogBinding
  extends ViewDataBinding
{
  @NonNull
  public final BrightnessSeekBar c;
  @NonNull
  public final ColorPlateWrapView d;
  @NonNull
  public final ImageView f;
  @NonNull
  public final ImageView q;
  @NonNull
  public final LinearLayout x;
  
  protected FragmentColorPickerDialogBinding(Object paramObject, View paramView, int paramInt, BrightnessSeekBar paramBrightnessSeekBar, ColorPlateWrapView paramColorPlateWrapView, ImageView paramImageView1, ImageView paramImageView2, LinearLayout paramLinearLayout)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramBrightnessSeekBar;
    this.d = paramColorPlateWrapView;
    this.f = paramImageView1;
    this.q = paramImageView2;
    this.x = paramLinearLayout;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentColorPickerDialogBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */