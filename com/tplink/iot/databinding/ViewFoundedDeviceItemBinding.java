package com.tplink.iot.databinding;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;

public abstract class ViewFoundedDeviceItemBinding
  extends ViewDataBinding
{
  @NonNull
  public final CheckBox c;
  @NonNull
  public final ImageView d;
  @NonNull
  public final TextView f;
  @NonNull
  public final TextView q;
  @Bindable
  protected View.OnClickListener x;
  
  protected ViewFoundedDeviceItemBinding(Object paramObject, View paramView, int paramInt, CheckBox paramCheckBox, ImageView paramImageView, TextView paramTextView1, TextView paramTextView2)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramCheckBox;
    this.d = paramImageView;
    this.f = paramTextView1;
    this.q = paramTextView2;
  }
  
  public abstract void h(@Nullable View.OnClickListener paramOnClickListener);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ViewFoundedDeviceItemBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */