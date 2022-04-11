package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.widget.NumberPickerView;

public abstract class DialogIntRangePickerBinding
  extends ViewDataBinding
{
  @NonNull
  public final ImageView c;
  @NonNull
  public final ImageView d;
  @NonNull
  public final NumberPickerView f;
  @NonNull
  public final NumberPickerView q;
  
  protected DialogIntRangePickerBinding(Object paramObject, View paramView, int paramInt, ImageView paramImageView1, ImageView paramImageView2, NumberPickerView paramNumberPickerView1, NumberPickerView paramNumberPickerView2)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramImageView1;
    this.d = paramImageView2;
    this.f = paramNumberPickerView1;
    this.q = paramNumberPickerView2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\DialogIntRangePickerBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */