package com.tplink.iot.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.MutableLiveData;

public abstract class LayoutCameraMenuButtonBinding
  extends ViewDataBinding
{
  @NonNull
  public final TextView c;
  @Bindable
  protected MutableLiveData<Boolean> d;
  @Bindable
  protected ObservableBoolean f;
  @Bindable
  protected ObservableBoolean q;
  @Bindable
  protected ObservableBoolean x;
  @Bindable
  protected ObservableBoolean y;
  
  protected LayoutCameraMenuButtonBinding(Object paramObject, View paramView, int paramInt, TextView paramTextView)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramTextView;
  }
  
  public abstract void h(@Nullable ObservableBoolean paramObservableBoolean);
  
  public abstract void i(@Nullable ObservableBoolean paramObservableBoolean);
  
  public abstract void l(@Nullable ObservableBoolean paramObservableBoolean);
  
  public abstract void m(@Nullable ObservableBoolean paramObservableBoolean);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\LayoutCameraMenuButtonBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */