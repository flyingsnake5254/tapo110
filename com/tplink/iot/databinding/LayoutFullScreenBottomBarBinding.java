package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.play.MultiLiveVideoViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.TalkViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.VideoPlayViewModel;

public abstract class LayoutFullScreenBottomBarBinding
  extends ViewDataBinding
{
  @NonNull
  public final TextView c;
  @NonNull
  public final TextView d;
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
  
  protected LayoutFullScreenBottomBarBinding(Object paramObject, View paramView, int paramInt, TextView paramTextView1, TextView paramTextView2, ImageView paramImageView1, ImageView paramImageView2, ImageView paramImageView3)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramTextView1;
    this.d = paramTextView2;
    this.f = paramImageView1;
    this.q = paramImageView2;
    this.x = paramImageView3;
  }
  
  public abstract void h(@Nullable MultiLiveVideoViewModel paramMultiLiveVideoViewModel);
  
  public abstract void i(@Nullable VideoPlayViewModel paramVideoPlayViewModel);
  
  public abstract void l(@Nullable g paramg);
  
  public abstract void m(@Nullable TalkViewModel paramTalkViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\LayoutFullScreenBottomBarBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */