package com.tplink.iot.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.preview.CameraPreviewInfo;
import com.tplink.iot.widget.RoundImageView;

public abstract class ItemCameraPreviewBinding
  extends ViewDataBinding
{
  @NonNull
  public final RoundImageView c;
  @Bindable
  protected String d;
  @Bindable
  protected CameraPreviewInfo f;
  
  protected ItemCameraPreviewBinding(Object paramObject, View paramView, int paramInt, RoundImageView paramRoundImageView)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramRoundImageView;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ItemCameraPreviewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */