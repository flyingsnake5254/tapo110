package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.adapter.databinding.d;
import com.tplink.iot.viewmodel.ipcamera.play.SelectDeviceViewModel.a;

public abstract class ItemCameraSelectDeviceBinding
  extends ViewDataBinding
{
  @NonNull
  public final ImageView c;
  @NonNull
  public final TextView d;
  @NonNull
  public final ImageView f;
  @NonNull
  public final TextView q;
  @Bindable
  protected SelectDeviceViewModel.a x;
  @Bindable
  protected d y;
  @Bindable
  protected Integer z;
  
  protected ItemCameraSelectDeviceBinding(Object paramObject, View paramView, int paramInt, ImageView paramImageView1, TextView paramTextView1, ImageView paramImageView2, TextView paramTextView2)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramImageView1;
    this.d = paramTextView1;
    this.f = paramImageView2;
    this.q = paramTextView2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ItemCameraSelectDeviceBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */