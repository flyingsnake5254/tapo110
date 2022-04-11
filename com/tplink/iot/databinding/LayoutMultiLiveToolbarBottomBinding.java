package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.play.MultiLiveVideoViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.TalkViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.VideoPlayViewModel;

public abstract class LayoutMultiLiveToolbarBottomBinding
  extends ViewDataBinding
{
  @NonNull
  public final ImageView H3;
  @NonNull
  public final ImageView I3;
  @Bindable
  protected g J3;
  @Bindable
  protected VideoPlayViewModel K3;
  @Bindable
  protected MultiLiveVideoViewModel L3;
  @Bindable
  protected TalkViewModel M3;
  @NonNull
  public final Guideline c;
  @NonNull
  public final Guideline d;
  @NonNull
  public final Guideline f;
  @NonNull
  public final ImageView p0;
  @NonNull
  public final ImageView p1;
  @NonNull
  public final ImageView p2;
  @NonNull
  public final ImageView p3;
  @NonNull
  public final Guideline q;
  @NonNull
  public final Guideline x;
  @NonNull
  public final Guideline y;
  @NonNull
  public final TextView z;
  
  protected LayoutMultiLiveToolbarBottomBinding(Object paramObject, View paramView, int paramInt, Guideline paramGuideline1, Guideline paramGuideline2, Guideline paramGuideline3, Guideline paramGuideline4, Guideline paramGuideline5, Guideline paramGuideline6, TextView paramTextView, ImageView paramImageView1, ImageView paramImageView2, ImageView paramImageView3, ImageView paramImageView4, ImageView paramImageView5, ImageView paramImageView6)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramGuideline1;
    this.d = paramGuideline2;
    this.f = paramGuideline3;
    this.q = paramGuideline4;
    this.x = paramGuideline5;
    this.y = paramGuideline6;
    this.z = paramTextView;
    this.p0 = paramImageView1;
    this.p1 = paramImageView2;
    this.p2 = paramImageView3;
    this.p3 = paramImageView4;
    this.H3 = paramImageView5;
    this.I3 = paramImageView6;
  }
  
  public abstract void h(@Nullable MultiLiveVideoViewModel paramMultiLiveVideoViewModel);
  
  public abstract void i(@Nullable VideoPlayViewModel paramVideoPlayViewModel);
  
  public abstract void l(@Nullable g paramg);
  
  public abstract void m(@Nullable TalkViewModel paramTalkViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\LayoutMultiLiveToolbarBottomBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */