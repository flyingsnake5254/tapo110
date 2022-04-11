package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;

public abstract class ItemHomeAwayModeFailBinding
  extends ViewDataBinding
{
  @NonNull
  public final ImageView c;
  @NonNull
  public final ImageView d;
  @NonNull
  public final ImageView f;
  @Bindable
  protected com.tplink.iot.view.ipcamera.preview.d p0;
  @Bindable
  protected com.tplink.iot.adapter.databinding.d p1;
  @Bindable
  protected Integer p2;
  @NonNull
  public final ImageView q;
  @NonNull
  public final ImageView x;
  @NonNull
  public final TextView y;
  @NonNull
  public final TextView z;
  
  protected ItemHomeAwayModeFailBinding(Object paramObject, View paramView, int paramInt, ImageView paramImageView1, ImageView paramImageView2, ImageView paramImageView3, ImageView paramImageView4, ImageView paramImageView5, TextView paramTextView1, TextView paramTextView2)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramImageView1;
    this.d = paramImageView2;
    this.f = paramImageView3;
    this.q = paramImageView4;
    this.x = paramImageView5;
    this.y = paramTextView1;
    this.z = paramTextView2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ItemHomeAwayModeFailBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */