package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.google.android.exoplayer2.ui.DefaultTimeBar;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.memories.MemoriesViewModel;

public abstract class ExoPlaybackControlViewBinding
  extends ViewDataBinding
{
  @Bindable
  protected g H3;
  @Bindable
  protected MemoriesViewModel I3;
  @NonNull
  public final ImageView c;
  @NonNull
  public final RelativeLayout d;
  @NonNull
  public final LinearLayout f;
  @NonNull
  public final DefaultTimeBar p0;
  @NonNull
  public final RelativeLayout p1;
  @NonNull
  public final RelativeLayout p2;
  @NonNull
  public final RelativeLayout p3;
  @NonNull
  public final TextView q;
  @NonNull
  public final ImageView x;
  @NonNull
  public final ImageView y;
  @NonNull
  public final TextView z;
  
  protected ExoPlaybackControlViewBinding(Object paramObject, View paramView, int paramInt, ImageView paramImageView1, RelativeLayout paramRelativeLayout1, LinearLayout paramLinearLayout, TextView paramTextView1, ImageView paramImageView2, ImageView paramImageView3, TextView paramTextView2, DefaultTimeBar paramDefaultTimeBar, RelativeLayout paramRelativeLayout2, RelativeLayout paramRelativeLayout3, RelativeLayout paramRelativeLayout4)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramImageView1;
    this.d = paramRelativeLayout1;
    this.f = paramLinearLayout;
    this.q = paramTextView1;
    this.x = paramImageView2;
    this.y = paramImageView3;
    this.z = paramTextView2;
    this.p0 = paramDefaultTimeBar;
    this.p1 = paramRelativeLayout2;
    this.p2 = paramRelativeLayout3;
    this.p3 = paramRelativeLayout4;
  }
  
  public abstract void h(@Nullable MemoriesViewModel paramMemoriesViewModel);
  
  public abstract void i(@Nullable g paramg);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ExoPlaybackControlViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */