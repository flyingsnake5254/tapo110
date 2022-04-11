package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.adapter.databinding.d;
import com.tplink.iot.viewmodel.ipcamera.play.SelectDeviceViewModel.a;

public abstract class ItemCameraSelectDeviceFullScreenBinding
  extends ViewDataBinding
{
  @NonNull
  public final View c;
  @NonNull
  public final ImageView d;
  @NonNull
  public final TextView f;
  @Bindable
  protected Integer p0;
  @NonNull
  public final ImageView q;
  @NonNull
  public final TextView x;
  @Bindable
  protected SelectDeviceViewModel.a y;
  @Bindable
  protected d z;
  
  protected ItemCameraSelectDeviceFullScreenBinding(Object paramObject, View paramView1, int paramInt, View paramView2, ImageView paramImageView1, TextView paramTextView1, ImageView paramImageView2, TextView paramTextView2)
  {
    super(paramObject, paramView1, paramInt);
    this.c = paramView2;
    this.d = paramImageView1;
    this.f = paramTextView1;
    this.q = paramImageView2;
    this.x = paramTextView2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ItemCameraSelectDeviceFullScreenBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */