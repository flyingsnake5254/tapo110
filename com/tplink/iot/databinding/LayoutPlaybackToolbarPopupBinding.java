package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.play.PlaybackMainViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.VodViewModel;

public abstract class LayoutPlaybackToolbarPopupBinding
  extends ViewDataBinding
{
  @NonNull
  public final ImageView c;
  @NonNull
  public final ImageView d;
  @Bindable
  protected g f;
  @Bindable
  protected VodViewModel q;
  @Bindable
  protected PlaybackMainViewModel x;
  
  protected LayoutPlaybackToolbarPopupBinding(Object paramObject, View paramView, int paramInt, ImageView paramImageView1, ImageView paramImageView2)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramImageView1;
    this.d = paramImageView2;
  }
  
  public abstract void h(@Nullable g paramg);
  
  public abstract void i(@Nullable PlaybackMainViewModel paramPlaybackMainViewModel);
  
  public abstract void l(@Nullable VodViewModel paramVodViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\LayoutPlaybackToolbarPopupBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */