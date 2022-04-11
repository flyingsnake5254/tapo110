package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.play.MultiLiveVideoViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.TalkViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.VideoPlayViewModel;

public abstract class LayoutFullScreenControlBinding
  extends ViewDataBinding
{
  @NonNull
  public final ImageView c;
  @NonNull
  public final ImageView d;
  @NonNull
  public final ImageView f;
  @Bindable
  protected VideoPlayViewModel p0;
  @Bindable
  protected TalkViewModel p1;
  @NonNull
  public final ImageView q;
  @NonNull
  public final ImageView x;
  @Bindable
  protected g y;
  @Bindable
  protected MultiLiveVideoViewModel z;
  
  protected LayoutFullScreenControlBinding(Object paramObject, View paramView, int paramInt, ImageView paramImageView1, ImageView paramImageView2, ImageView paramImageView3, ImageView paramImageView4, ImageView paramImageView5)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramImageView1;
    this.d = paramImageView2;
    this.f = paramImageView3;
    this.q = paramImageView4;
    this.x = paramImageView5;
  }
  
  public abstract void h(@Nullable MultiLiveVideoViewModel paramMultiLiveVideoViewModel);
  
  public abstract void i(@Nullable VideoPlayViewModel paramVideoPlayViewModel);
  
  public abstract void l(@Nullable g paramg);
  
  public abstract void m(@Nullable TalkViewModel paramTalkViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\LayoutFullScreenControlBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */