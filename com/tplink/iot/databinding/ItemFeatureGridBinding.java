package com.tplink.iot.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemFeatureGridBinding
  extends ViewDataBinding
{
  @NonNull
  public final ImageView c;
  @NonNull
  public final LinearLayout d;
  @NonNull
  public final TextView f;
  
  protected ItemFeatureGridBinding(Object paramObject, View paramView, int paramInt, ImageView paramImageView, LinearLayout paramLinearLayout, TextView paramTextView)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramImageView;
    this.d = paramLinearLayout;
    this.f = paramTextView;
  }
  
  @NonNull
  public static ItemFeatureGridBinding h(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, boolean paramBoolean)
  {
    return i(paramLayoutInflater, paramViewGroup, paramBoolean, DataBindingUtil.getDefaultComponent());
  }
  
  @Deprecated
  @NonNull
  public static ItemFeatureGridBinding i(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, boolean paramBoolean, @Nullable Object paramObject)
  {
    return (ItemFeatureGridBinding)ViewDataBinding.inflateInternal(paramLayoutInflater, 2131559030, paramViewGroup, paramBoolean, paramObject);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ItemFeatureGridBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */