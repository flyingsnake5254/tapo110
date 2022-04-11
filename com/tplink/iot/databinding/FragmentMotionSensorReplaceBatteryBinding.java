package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;

public abstract class FragmentMotionSensorReplaceBatteryBinding
  extends ViewDataBinding
{
  @NonNull
  public final ImageView c;
  
  protected FragmentMotionSensorReplaceBatteryBinding(Object paramObject, View paramView, int paramInt, ImageView paramImageView)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramImageView;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentMotionSensorReplaceBatteryBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */