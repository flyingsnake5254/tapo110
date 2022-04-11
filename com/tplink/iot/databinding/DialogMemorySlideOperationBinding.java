package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.memories.MemoriesViewModel;

public abstract class DialogMemorySlideOperationBinding
  extends ViewDataBinding
{
  @NonNull
  public final ImageView c;
  @NonNull
  public final ImageView d;
  @NonNull
  public final ImageView f;
  @NonNull
  public final ImageView q;
  @Bindable
  protected g x;
  @Bindable
  protected MemoriesViewModel y;
  
  protected DialogMemorySlideOperationBinding(Object paramObject, View paramView, int paramInt, ImageView paramImageView1, ImageView paramImageView2, ImageView paramImageView3, ImageView paramImageView4)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramImageView1;
    this.d = paramImageView2;
    this.f = paramImageView3;
    this.q = paramImageView4;
  }
  
  public abstract void h(@Nullable MemoriesViewModel paramMemoriesViewModel);
  
  public abstract void i(@Nullable g paramg);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\DialogMemorySlideOperationBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */