package com.tplink.iot.databinding;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.devices.trv.viewmodel.TRVDetailViewModel;
import com.tplink.iot.widget.trv.TemperatureSlider;
import com.tplink.iot.widget.viewgroup.ToastTipBarView;

public abstract class LayoutTrvDetailContentExtBinding
  extends ViewDataBinding
{
  @NonNull
  public final ImageView c;
  @NonNull
  public final ImageView d;
  @NonNull
  public final TemperatureSlider f;
  @Bindable
  protected View.OnClickListener p0;
  @Bindable
  protected TRVDetailViewModel p1;
  @NonNull
  public final ToastTipBarView q;
  @NonNull
  public final TextView x;
  @NonNull
  public final TextView y;
  @NonNull
  public final TextView z;
  
  protected LayoutTrvDetailContentExtBinding(Object paramObject, View paramView, int paramInt, ImageView paramImageView1, ImageView paramImageView2, TemperatureSlider paramTemperatureSlider, ToastTipBarView paramToastTipBarView, TextView paramTextView1, TextView paramTextView2, TextView paramTextView3)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramImageView1;
    this.d = paramImageView2;
    this.f = paramTemperatureSlider;
    this.q = paramToastTipBarView;
    this.x = paramTextView1;
    this.y = paramTextView2;
    this.z = paramTextView3;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\LayoutTrvDetailContentExtBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */