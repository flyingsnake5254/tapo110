package com.tplink.iot.databinding;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;

public abstract class ItemCameraSsidLayoutBinding
  extends ViewDataBinding
{
  @NonNull
  public final ImageView c;
  @NonNull
  public final ImageView d;
  @NonNull
  public final TextView f;
  @NonNull
  public final RelativeLayout q;
  @Bindable
  protected String x;
  @Bindable
  protected View.OnClickListener y;
  
  protected ItemCameraSsidLayoutBinding(Object paramObject, View paramView, int paramInt, ImageView paramImageView1, ImageView paramImageView2, TextView paramTextView, RelativeLayout paramRelativeLayout)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramImageView1;
    this.d = paramImageView2;
    this.f = paramTextView;
    this.q = paramRelativeLayout;
  }
  
  public abstract void h(@Nullable View.OnClickListener paramOnClickListener);
  
  public abstract void i(@Nullable String paramString);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ItemCameraSsidLayoutBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */