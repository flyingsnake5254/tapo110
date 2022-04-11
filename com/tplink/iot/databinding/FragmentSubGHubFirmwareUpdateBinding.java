package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGViewModel;

public abstract class FragmentSubGHubFirmwareUpdateBinding
  extends ViewDataBinding
{
  @NonNull
  public final ImageView c;
  @Bindable
  protected SubGViewModel d;
  @Bindable
  protected g f;
  
  protected FragmentSubGHubFirmwareUpdateBinding(Object paramObject, View paramView, int paramInt, ImageView paramImageView)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramImageView;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentSubGHubFirmwareUpdateBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */