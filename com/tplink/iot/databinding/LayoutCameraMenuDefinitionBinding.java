package com.tplink.iot.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;

public abstract class LayoutCameraMenuDefinitionBinding
  extends ViewDataBinding
{
  @NonNull
  public final TextView c;
  @NonNull
  public final TextView d;
  @Bindable
  protected ObservableBoolean f;
  
  protected LayoutCameraMenuDefinitionBinding(Object paramObject, View paramView, int paramInt, TextView paramTextView1, TextView paramTextView2)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramTextView1;
    this.d = paramTextView2;
  }
  
  public abstract void h(@Nullable ObservableBoolean paramObservableBoolean);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\LayoutCameraMenuDefinitionBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */