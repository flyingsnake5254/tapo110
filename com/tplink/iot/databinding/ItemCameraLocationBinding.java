package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;

public abstract class ItemCameraLocationBinding
  extends ViewDataBinding
{
  @NonNull
  public final ImageView c;
  @NonNull
  public final TextView d;
  
  protected ItemCameraLocationBinding(Object paramObject, View paramView, int paramInt, ImageView paramImageView, TextView paramTextView)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramImageView;
    this.d = paramTextView;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ItemCameraLocationBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */