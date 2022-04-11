package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.MutableLiveData;

public abstract class LayoutCameraMenuButtonDayNightModeBinding
  extends ViewDataBinding
{
  @NonNull
  public final ImageView c;
  @NonNull
  public final TextView d;
  @Bindable
  protected MutableLiveData<Boolean> f;
  @Bindable
  protected ObservableBoolean q;
  @Bindable
  protected ObservableBoolean x;
  @Bindable
  protected ObservableBoolean y;
  @Bindable
  protected ObservableBoolean z;
  
  protected LayoutCameraMenuButtonDayNightModeBinding(Object paramObject, View paramView, int paramInt, ImageView paramImageView, TextView paramTextView)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramImageView;
    this.d = paramTextView;
  }
  
  public abstract void h(@Nullable MutableLiveData<Boolean> paramMutableLiveData);
  
  public abstract void i(@Nullable ObservableBoolean paramObservableBoolean);
  
  public abstract void l(@Nullable ObservableBoolean paramObservableBoolean);
  
  public abstract void m(@Nullable ObservableBoolean paramObservableBoolean);
  
  public abstract void n(@Nullable ObservableBoolean paramObservableBoolean);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\LayoutCameraMenuButtonDayNightModeBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */