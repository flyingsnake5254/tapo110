package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;

public abstract class LayoutCameraMenuSettingsBinding
  extends ViewDataBinding
{
  @NonNull
  public final ImageView c;
  @NonNull
  public final View d;
  @Bindable
  protected ObservableBoolean f;
  
  protected LayoutCameraMenuSettingsBinding(Object paramObject, View paramView1, int paramInt, ImageView paramImageView, View paramView2)
  {
    super(paramObject, paramView1, paramInt);
    this.c = paramImageView;
    this.d = paramView2;
  }
  
  public abstract void h(@Nullable ObservableBoolean paramObservableBoolean);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\LayoutCameraMenuSettingsBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */