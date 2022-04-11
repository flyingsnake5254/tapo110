package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;

public abstract class WidgetTipsBarBinding
  extends ViewDataBinding
{
  @NonNull
  public final ImageView c;
  @NonNull
  public final TextView d;
  @NonNull
  public final ConstraintLayout f;
  @Bindable
  protected ObservableBoolean q;
  
  protected WidgetTipsBarBinding(Object paramObject, View paramView, int paramInt, ImageView paramImageView, TextView paramTextView, ConstraintLayout paramConstraintLayout)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramImageView;
    this.d = paramTextView;
    this.f = paramConstraintLayout;
  }
  
  public abstract void h(@Nullable ObservableBoolean paramObservableBoolean);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\WidgetTipsBarBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */