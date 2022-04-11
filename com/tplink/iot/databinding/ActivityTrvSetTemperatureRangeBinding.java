package com.tplink.iot.databinding;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.widget.viewgroup.ToastTipBarView;

public abstract class ActivityTrvSetTemperatureRangeBinding
  extends ViewDataBinding
{
  @NonNull
  public final ImageView c;
  @NonNull
  public final LinearLayout d;
  @NonNull
  public final ToastTipBarView f;
  @Bindable
  protected View.OnClickListener p0;
  @NonNull
  public final TextView q;
  @NonNull
  public final TextView x;
  @NonNull
  public final TextView y;
  @NonNull
  public final TextView z;
  
  protected ActivityTrvSetTemperatureRangeBinding(Object paramObject, View paramView, int paramInt, ImageView paramImageView, LinearLayout paramLinearLayout, ToastTipBarView paramToastTipBarView, TextView paramTextView1, TextView paramTextView2, TextView paramTextView3, TextView paramTextView4)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramImageView;
    this.d = paramLinearLayout;
    this.f = paramToastTipBarView;
    this.q = paramTextView1;
    this.x = paramTextView2;
    this.y = paramTextView3;
    this.z = paramTextView4;
  }
  
  public abstract void h(@Nullable View.OnClickListener paramOnClickListener);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityTrvSetTemperatureRangeBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */