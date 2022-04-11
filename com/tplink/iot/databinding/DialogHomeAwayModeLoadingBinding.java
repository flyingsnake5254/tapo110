package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;

public abstract class DialogHomeAwayModeLoadingBinding
  extends ViewDataBinding
{
  @NonNull
  public final ImageView c;
  @NonNull
  public final TextView d;
  @NonNull
  public final LinearLayout f;
  @Bindable
  protected ObservableField<String> q;
  
  protected DialogHomeAwayModeLoadingBinding(Object paramObject, View paramView, int paramInt, ImageView paramImageView, TextView paramTextView, LinearLayout paramLinearLayout)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramImageView;
    this.d = paramTextView;
    this.f = paramLinearLayout;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\DialogHomeAwayModeLoadingBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */