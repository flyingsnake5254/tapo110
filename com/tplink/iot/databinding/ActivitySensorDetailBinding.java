package com.tplink.iot.databinding;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.viewmodel.iotsensor.SensorDetailViewModel;
import com.yinglan.scrolllayout.ScrollLayout;

public abstract class ActivitySensorDetailBinding
  extends ViewDataBinding
{
  @NonNull
  public final ImageView c;
  @NonNull
  public final ScrollLayout d;
  @NonNull
  public final ActivitySensorDetailBottomBinding f;
  @NonNull
  public final ActivitySensorDetailContentBinding q;
  @Bindable
  protected View.OnClickListener x;
  @Bindable
  protected SensorDetailViewModel y;
  
  protected ActivitySensorDetailBinding(Object paramObject, View paramView, int paramInt, ImageView paramImageView, ScrollLayout paramScrollLayout, ActivitySensorDetailBottomBinding paramActivitySensorDetailBottomBinding, ActivitySensorDetailContentBinding paramActivitySensorDetailContentBinding)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramImageView;
    this.d = paramScrollLayout;
    this.f = paramActivitySensorDetailBottomBinding;
    this.q = paramActivitySensorDetailContentBinding;
  }
  
  public abstract void h(@Nullable SensorDetailViewModel paramSensorDetailViewModel);
  
  public abstract void i(@Nullable View.OnClickListener paramOnClickListener);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivitySensorDetailBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */