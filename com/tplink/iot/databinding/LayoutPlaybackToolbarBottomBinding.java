package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.play.PlaybackMainViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.VodViewModel;

public abstract class LayoutPlaybackToolbarBottomBinding
  extends ViewDataBinding
{
  @Bindable
  protected g H3;
  @Bindable
  protected VodViewModel I3;
  @Bindable
  protected PlaybackMainViewModel J3;
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
  public final ImageView z;
  
  protected LayoutPlaybackToolbarBottomBinding(Object paramObject, View paramView, int paramInt, Guideline paramGuideline1, Guideline paramGuideline2, Guideline paramGuideline3, Guideline paramGuideline4, Guideline paramGuideline5, Guideline paramGuideline6, ImageView paramImageView1, ImageView paramImageView2, ImageView paramImageView3, ImageView paramImageView4, ImageView paramImageView5)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramGuideline1;
    this.d = paramGuideline2;
    this.f = paramGuideline3;
    this.q = paramGuideline4;
    this.x = paramGuideline5;
    this.y = paramGuideline6;
    this.z = paramImageView1;
    this.p0 = paramImageView2;
    this.p1 = paramImageView3;
    this.p2 = paramImageView4;
    this.p3 = paramImageView5;
  }
  
  public abstract void h(@Nullable g paramg);
  
  public abstract void i(@Nullable PlaybackMainViewModel paramPlaybackMainViewModel);
  
  public abstract void l(@Nullable VodViewModel paramVodViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\LayoutPlaybackToolbarBottomBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */